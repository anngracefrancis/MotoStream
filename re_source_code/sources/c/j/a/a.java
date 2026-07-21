package c.j.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: CursorAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, c.j.a.b.a {

    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
    protected boolean mAutoRequery;
    protected C0077a mChangeObserver;
    protected Context mContext;
    protected Cursor mCursor;
    protected c.j.a.b mCursorFilter;
    protected DataSetObserver mDataSetObserver;
    protected boolean mDataValid;
    protected FilterQueryProvider mFilterQueryProvider;
    protected int mRowIDColumn;

    /* JADX INFO: renamed from: c.j.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CursorAdapter.java */
    private class C0077a extends ContentObserver {
        C0077a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            a.this.onContentChanged();
        }
    }

    /* JADX INFO: compiled from: CursorAdapter.java */
    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.mDataValid = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.mDataValid = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    @Deprecated
    public a(Context context, Cursor cursor) {
        init(context, cursor, 1);
    }

    public abstract void bindView(View view, Context context, Cursor cursor);

    public void changeCursor(Cursor cursor) {
        Cursor cursorSwapCursor = swapCursor(cursor);
        if (cursorSwapCursor != null) {
            cursorSwapCursor.close();
        }
    }

    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? HttpUrl.FRAGMENT_ENCODE_SET : cursor.toString();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.mDataValid || (cursor = this.mCursor) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // c.j.a.b.a
    public Cursor getCursor() {
        return this.mCursor;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.mDataValid) {
            return null;
        }
        this.mCursor.moveToPosition(i2);
        if (view == null) {
            view = newDropDownView(this.mContext, this.mCursor, viewGroup);
        }
        bindView(view, this.mContext, this.mCursor);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.mCursorFilter == null) {
            this.mCursorFilter = new c.j.a.b(this);
        }
        return this.mCursorFilter;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        return this.mFilterQueryProvider;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        Cursor cursor;
        if (!this.mDataValid || (cursor = this.mCursor) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.mCursor;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        Cursor cursor;
        if (this.mDataValid && (cursor = this.mCursor) != null && cursor.moveToPosition(i2)) {
            return this.mCursor.getLong(this.mRowIDColumn);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.mDataValid) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.mCursor.moveToPosition(i2)) {
            if (view == null) {
                view = newView(this.mContext, this.mCursor, viewGroup);
            }
            bindView(view, this.mContext, this.mCursor);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Deprecated
    protected void init(Context context, Cursor cursor, boolean z) {
        init(context, cursor, z ? 1 : 2);
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return newView(context, cursor, viewGroup);
    }

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    protected void onContentChanged() {
        Cursor cursor;
        if (!this.mAutoRequery || (cursor = this.mCursor) == null || cursor.isClosed()) {
            return;
        }
        this.mDataValid = this.mCursor.requery();
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.mFilterQueryProvider;
        return filterQueryProvider != null ? filterQueryProvider.runQuery(charSequence) : this.mCursor;
    }

    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        this.mFilterQueryProvider = filterQueryProvider;
    }

    public Cursor swapCursor(Cursor cursor) {
        Cursor cursor2 = this.mCursor;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0077a c0077a = this.mChangeObserver;
            if (c0077a != null) {
                cursor2.unregisterContentObserver(c0077a);
            }
            DataSetObserver dataSetObserver = this.mDataSetObserver;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.mCursor = cursor;
        if (cursor != null) {
            C0077a c0077a2 = this.mChangeObserver;
            if (c0077a2 != null) {
                cursor.registerContentObserver(c0077a2);
            }
            DataSetObserver dataSetObserver2 = this.mDataSetObserver;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.mRowIDColumn = cursor.getColumnIndexOrThrow("_id");
            this.mDataValid = true;
            notifyDataSetChanged();
        } else {
            this.mRowIDColumn = -1;
            this.mDataValid = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    void init(Context context, Cursor cursor, int i2) {
        if ((i2 & 1) == 1) {
            i2 |= 2;
            this.mAutoRequery = true;
        } else {
            this.mAutoRequery = false;
        }
        boolean z = cursor != null;
        this.mCursor = cursor;
        this.mDataValid = z;
        this.mContext = context;
        this.mRowIDColumn = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i2 & 2) == 2) {
            this.mChangeObserver = new C0077a();
            this.mDataSetObserver = new b();
        } else {
            this.mChangeObserver = null;
            this.mDataSetObserver = null;
        }
        if (z) {
            C0077a c0077a = this.mChangeObserver;
            if (c0077a != null) {
                cursor.registerContentObserver(c0077a);
            }
            DataSetObserver dataSetObserver = this.mDataSetObserver;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public a(Context context, Cursor cursor, boolean z) {
        init(context, cursor, z ? 1 : 2);
    }

    public a(Context context, Cursor cursor, int i2) {
        init(context, cursor, i2);
    }
}
