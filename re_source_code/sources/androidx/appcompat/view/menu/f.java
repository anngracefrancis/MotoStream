package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* JADX INFO: compiled from: MenuAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends BaseAdapter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    g f297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f298g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f299h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f300i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LayoutInflater f301j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f302k;

    public f(g gVar, LayoutInflater layoutInflater, boolean z, int i2) {
        this.f300i = z;
        this.f301j = layoutInflater;
        this.f297f = gVar;
        this.f302k = i2;
        a();
    }

    void a() {
        i iVarX = this.f297f.x();
        if (iVarX != null) {
            ArrayList<i> arrayListB = this.f297f.B();
            int size = arrayListB.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (arrayListB.get(i2) == iVarX) {
                    this.f298g = i2;
                    return;
                }
            }
        }
        this.f298g = -1;
    }

    public g b() {
        return this.f297f;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public i getItem(int i2) {
        ArrayList<i> arrayListB = this.f300i ? this.f297f.B() : this.f297f.G();
        int i3 = this.f298g;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return arrayListB.get(i2);
    }

    public void d(boolean z) {
        this.f299h = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<i> arrayListB = this.f300i ? this.f297f.B() : this.f297f.G();
        return this.f298g < 0 ? arrayListB.size() : arrayListB.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f301j.inflate(this.f302k, viewGroup, false);
        }
        int groupId = getItem(i2).getGroupId();
        int i3 = i2 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f297f.H() && groupId != (i3 >= 0 ? getItem(i3).getGroupId() : groupId));
        n.a aVar = (n.a) view;
        if (this.f299h) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.e(getItem(i2), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
