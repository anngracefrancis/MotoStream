package cm.aptoide.pt.search;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cm.aptoide.pt.R;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SuggestionCursorAdapter extends c.j.a.a {
    private static final String[] COLUMN_NAMES = {"_id", "suggest_text_1"};
    private static final int ITEM_LAYOUT = 2131493179;
    private final List<String> suggestions;

    public SuggestionCursorAdapter(Context context, List<String> list) {
        super(context, (Cursor) null, false);
        this.suggestions = new LinkedList();
        if (list == null || list.isEmpty()) {
            return;
        }
        setData(list);
    }

    private MatrixCursor getCursorFor(List<String> list) {
        MatrixCursor matrixCursor = new MatrixCursor(COLUMN_NAMES, list.size());
        Iterator<String> it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            matrixCursor.newRow().add(Integer.toString(i2)).add(it.next());
            i2++;
        }
        return matrixCursor;
    }

    private String getSuggestionAtCurrentPosition(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex("suggest_text_1"));
    }

    @Override // c.j.a.a
    public void bindView(View view, Context context, Cursor cursor) {
        ((TextView) view.findViewById(R.id.dropdown_text)).setText(getSuggestionAtCurrentPosition(cursor));
    }

    public CharSequence getSuggestionAt(int i2) {
        Cursor cursor = getCursor();
        if (cursor.moveToPosition(i2)) {
            return getSuggestionAtCurrentPosition(cursor);
        }
        throw new UnsupportedOperationException("Unable to find query at position " + i2);
    }

    public List<String> getSuggestions() {
        return this.suggestions;
    }

    @Override // c.j.a.a
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.simple_dropdown_item, viewGroup, false);
    }

    public void setData(List<String> list) {
        this.suggestions.clear();
        this.suggestions.addAll(list);
        changeCursor(getCursorFor(this.suggestions));
    }

    public SuggestionCursorAdapter(Context context) {
        this(context, Collections.emptyList());
    }
}
