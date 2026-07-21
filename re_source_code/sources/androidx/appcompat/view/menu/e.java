package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

/* JADX INFO: compiled from: ListMenuPresenter.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements m, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Context f289f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    LayoutInflater f290g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    g f291h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ExpandedMenuView f292i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f293j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f294k;
    int l;
    private m.a m;
    a n;
    private int o;

    /* JADX INFO: compiled from: ListMenuPresenter.java */
    private class a extends BaseAdapter {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f295f = -1;

        public a() {
            a();
        }

        void a() {
            i iVarX = e.this.f291h.x();
            if (iVarX != null) {
                ArrayList<i> arrayListB = e.this.f291h.B();
                int size = arrayListB.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (arrayListB.get(i2) == iVarX) {
                        this.f295f = i2;
                        return;
                    }
                }
            }
            this.f295f = -1;
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public i getItem(int i2) {
            ArrayList<i> arrayListB = e.this.f291h.B();
            int i3 = i2 + e.this.f293j;
            int i4 = this.f295f;
            if (i4 >= 0 && i3 >= i4) {
                i3++;
            }
            return arrayListB.get(i3);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = e.this.f291h.B().size() - e.this.f293j;
            return this.f295f < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                e eVar = e.this;
                view = eVar.f290g.inflate(eVar.l, viewGroup, false);
            }
            ((n.a) view).e(getItem(i2), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public e(Context context, int i2) {
        this(i2, 0);
        this.f289f = context;
        this.f290g = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.n == null) {
            this.n = new a();
        }
        return this.n;
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z) {
        m.a aVar = this.m;
        if (aVar != null) {
            aVar.b(gVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void c(boolean z) {
        a aVar = this.n;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean e(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean f(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void g(m.a aVar) {
        this.m = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public int getId() {
        return this.o;
    }

    @Override // androidx.appcompat.view.menu.m
    public void h(Context context, g gVar) {
        if (this.f294k != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f294k);
            this.f289f = contextThemeWrapper;
            this.f290g = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f289f != null) {
            this.f289f = context;
            if (this.f290g == null) {
                this.f290g = LayoutInflater.from(context);
            }
        }
        this.f291h = gVar;
        a aVar = this.n;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void i(Parcelable parcelable) {
        m((Bundle) parcelable);
    }

    public n j(ViewGroup viewGroup) {
        if (this.f292i == null) {
            this.f292i = (ExpandedMenuView) this.f290g.inflate(c.a.g.f2737g, viewGroup, false);
            if (this.n == null) {
                this.n = new a();
            }
            this.f292i.setAdapter((ListAdapter) this.n);
            this.f292i.setOnItemClickListener(this);
        }
        return this.f292i;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean k(r rVar) {
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        new h(rVar).d(null);
        m.a aVar = this.m;
        if (aVar == null) {
            return true;
        }
        aVar.c(rVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable l() {
        if (this.f292i == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        n(bundle);
        return bundle;
    }

    public void m(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f292i.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public void n(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f292i;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f291h.O(this.n.getItem(i2), this, 0);
    }

    public e(int i2, int i3) {
        this.l = i2;
        this.f294k = i3;
    }
}
