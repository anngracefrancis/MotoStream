package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SuggestionsAdapter.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
class k0 extends c.j.a.c implements View.OnClickListener {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final SearchView f566i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final SearchableInfo f567j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Context f568k;
    private final WeakHashMap<String, Drawable.ConstantState> l;
    private final int m;
    private boolean n;
    private int o;
    private ColorStateList p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;

    /* JADX INFO: compiled from: SuggestionsAdapter.java */
    private static final class a {
        public final TextView a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f569b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f570c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f571d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImageView f572e;

        public a(View view) {
            this.a = (TextView) view.findViewById(R.id.text1);
            this.f569b = (TextView) view.findViewById(R.id.text2);
            this.f570c = (ImageView) view.findViewById(R.id.icon1);
            this.f571d = (ImageView) view.findViewById(R.id.icon2);
            this.f572e = (ImageView) view.findViewById(c.a.f.q);
        }
    }

    public k0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.n = false;
        this.o = 1;
        this.q = -1;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.f566i = searchView;
        this.f567j = searchableInfo;
        this.m = searchView.getSuggestionCommitIconResId();
        this.f568k = context;
        this.l = weakHashMap;
    }

    private Drawable a(String str) {
        Drawable.ConstantState constantState = this.l.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence b(CharSequence charSequence) {
        if (this.p == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(c.a.a.M, typedValue, true);
            this.p = this.mContext.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.p, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable c(ComponentName componentName) {
        PackageManager packageManager = this.mContext.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.w("SuggestionsAdapter", e2.toString());
            return null;
        }
    }

    private Drawable d(ComponentName componentName) {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (!this.l.containsKey(strFlattenToShortString)) {
            Drawable drawableC = c(componentName);
            this.l.put(strFlattenToShortString, drawableC != null ? drawableC.getConstantState() : null);
            return drawableC;
        }
        Drawable.ConstantState constantState = this.l.get(strFlattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.f568k.getResources());
    }

    public static String e(Cursor cursor, String str) {
        return m(cursor, cursor.getColumnIndex(str));
    }

    private Drawable f() {
        Drawable drawableD = d(this.f567j.getSearchActivity());
        return drawableD != null ? drawableD : this.mContext.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable g(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return h(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.f568k.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                Drawable drawableCreateFromStream = Drawable.createFromStream(inputStreamOpenInputStream, null);
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e2) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e2);
                }
                return drawableCreateFromStream;
            } catch (Throwable th) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e3) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e3);
                }
                throw th;
            }
        } catch (FileNotFoundException e4) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e4.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e4.getMessage());
        return null;
    }

    private Drawable i(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int i2 = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f568k.getPackageName() + "/" + i2;
            Drawable drawableA = a(str2);
            if (drawableA != null) {
                return drawableA;
            }
            Drawable drawableF = androidx.core.content.a.f(this.f568k, i2);
            q(str2, drawableF);
            return drawableF;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable drawableA2 = a(str);
            if (drawableA2 != null) {
                return drawableA2;
            }
            Drawable drawableG = g(Uri.parse(str));
            q(str, drawableG);
            return drawableG;
        }
    }

    private Drawable j(Cursor cursor) {
        int i2 = this.t;
        if (i2 == -1) {
            return null;
        }
        Drawable drawableI = i(cursor.getString(i2));
        return drawableI != null ? drawableI : f();
    }

    private Drawable k(Cursor cursor) {
        int i2 = this.u;
        if (i2 == -1) {
            return null;
        }
        return i(cursor.getString(i2));
    }

    private static String m(Cursor cursor, int i2) {
        if (i2 == -1) {
            return null;
        }
        try {
            return cursor.getString(i2);
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e2);
            return null;
        }
    }

    private void o(ImageView imageView, Drawable drawable, int i2) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i2);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void p(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void q(String str, Drawable drawable) {
        if (drawable != null) {
            this.l.put(str, drawable.getConstantState());
        }
    }

    private void r(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    @Override // c.j.a.a
    public void bindView(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i2 = this.v;
        int i3 = i2 != -1 ? cursor.getInt(i2) : 0;
        if (aVar.a != null) {
            p(aVar.a, m(cursor, this.q));
        }
        if (aVar.f569b != null) {
            String strM = m(cursor, this.s);
            CharSequence charSequenceB = strM != null ? b(strM) : m(cursor, this.r);
            if (TextUtils.isEmpty(charSequenceB)) {
                TextView textView = aVar.a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.a.setMaxLines(1);
                }
            }
            p(aVar.f569b, charSequenceB);
        }
        ImageView imageView = aVar.f570c;
        if (imageView != null) {
            o(imageView, j(cursor), 4);
        }
        ImageView imageView2 = aVar.f571d;
        if (imageView2 != null) {
            o(imageView2, k(cursor), 8);
        }
        int i4 = this.o;
        if (i4 != 2 && (i4 != 1 || (i3 & 1) == 0)) {
            aVar.f572e.setVisibility(8);
            return;
        }
        aVar.f572e.setVisibility(0);
        aVar.f572e.setTag(aVar.a.getText());
        aVar.f572e.setOnClickListener(this);
    }

    @Override // c.j.a.a, c.j.a.b.a
    public void changeCursor(Cursor cursor) {
        if (this.n) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.q = cursor.getColumnIndex("suggest_text_1");
                this.r = cursor.getColumnIndex("suggest_text_2");
                this.s = cursor.getColumnIndex("suggest_text_2_url");
                this.t = cursor.getColumnIndex("suggest_icon_1");
                this.u = cursor.getColumnIndex("suggest_icon_2");
                this.v = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e2);
        }
    }

    @Override // c.j.a.a, c.j.a.b.a
    public CharSequence convertToString(Cursor cursor) {
        String strE;
        String strE2;
        if (cursor == null) {
            return null;
        }
        String strE3 = e(cursor, "suggest_intent_query");
        if (strE3 != null) {
            return strE3;
        }
        if (this.f567j.shouldRewriteQueryFromData() && (strE2 = e(cursor, "suggest_intent_data")) != null) {
            return strE2;
        }
        if (!this.f567j.shouldRewriteQueryFromText() || (strE = e(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strE;
    }

    @Override // c.j.a.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View viewNewDropDownView = newDropDownView(this.mContext, this.mCursor, viewGroup);
            if (viewNewDropDownView != null) {
                ((a) viewNewDropDownView.getTag()).a.setText(e2.toString());
            }
            return viewNewDropDownView;
        }
    }

    @Override // c.j.a.a, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View viewNewView = newView(this.mContext, this.mCursor, viewGroup);
            if (viewNewView != null) {
                ((a) viewNewView.getTag()).a.setText(e2.toString());
            }
            return viewNewView;
        }
    }

    Drawable h(Uri uri) throws FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.mContext.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    @Override // c.j.a.a, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    Cursor l(SearchableInfo searchableInfo, String str, int i2) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query(HttpUrl.FRAGMENT_ENCODE_SET).fragment(HttpUrl.FRAGMENT_ENCODE_SET);
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i2 > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i2));
        }
        return this.mContext.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    public void n(int i2) {
        this.o = i2;
    }

    @Override // c.j.a.c, c.j.a.a
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewNewView = super.newView(context, cursor, viewGroup);
        viewNewView.setTag(new a(viewNewView));
        ((ImageView) viewNewView.findViewById(c.a.f.q)).setImageResource(this.m);
        return viewNewView;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        r(getCursor());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        r(getCursor());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f566i.U((CharSequence) tag);
        }
    }

    @Override // c.j.a.a, c.j.a.b.a
    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String string = charSequence == null ? HttpUrl.FRAGMENT_ENCODE_SET : charSequence.toString();
        if (this.f566i.getVisibility() == 0 && this.f566i.getWindowVisibility() == 0) {
            try {
                Cursor cursorL = l(this.f567j, string, 50);
                if (cursorL != null) {
                    cursorL.getCount();
                    return cursorL;
                }
            } catch (RuntimeException e2) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e2);
            }
        }
        return null;
    }
}
