package c.j.a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: ResourceCursorAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3286g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private LayoutInflater f3287h;

    @Deprecated
    public c(Context context, int i2, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f3286g = i2;
        this.f3285f = i2;
        this.f3287h = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // c.j.a.a
    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f3287h.inflate(this.f3286g, viewGroup, false);
    }

    @Override // c.j.a.a
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f3287h.inflate(this.f3285f, viewGroup, false);
    }
}
