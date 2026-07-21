package androidx.preference;

import android.R;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.u;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PreferenceGroupAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends RecyclerView.g<l> implements Preference.b, PreferenceGroup.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PreferenceGroup f1829f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<Preference> f1830g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<Preference> f1831h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<d> f1832i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Runnable f1834k = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Handler f1833j = new Handler();

    /* JADX INFO: compiled from: PreferenceGroupAdapter.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.n();
        }
    }

    /* JADX INFO: compiled from: PreferenceGroupAdapter.java */
    class b extends androidx.recyclerview.widget.f.b {
        final /* synthetic */ List a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f1836b;

        b(List list, List list2, j.d dVar) {
            this.a = list;
            this.f1836b = list2;
        }

        @Override // androidx.recyclerview.widget.f.b
        public boolean areContentsTheSame(int i2, int i3) {
            throw null;
        }

        @Override // androidx.recyclerview.widget.f.b
        public boolean areItemsTheSame(int i2, int i3) {
            throw null;
        }

        @Override // androidx.recyclerview.widget.f.b
        public int getNewListSize() {
            return this.f1836b.size();
        }

        @Override // androidx.recyclerview.widget.f.b
        public int getOldListSize() {
            return this.a.size();
        }
    }

    /* JADX INFO: compiled from: PreferenceGroupAdapter.java */
    class c implements Preference.d {
        final /* synthetic */ PreferenceGroup a;

        c(PreferenceGroup preferenceGroup) {
            this.a = preferenceGroup;
        }

        @Override // androidx.preference.Preference.d
        public boolean onPreferenceClick(Preference preference) {
            this.a.k1(Integer.MAX_VALUE);
            h.this.a(preference);
            PreferenceGroup.b bVarD1 = this.a.d1();
            if (bVarD1 == null) {
                return true;
            }
            bVarD1.a();
            return true;
        }
    }

    /* JADX INFO: compiled from: PreferenceGroupAdapter.java */
    private static class d {
        int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1839b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f1840c;

        d(Preference preference) {
            this.f1840c = preference.getClass().getName();
            this.a = preference.K();
            this.f1839b = preference.X();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.a == dVar.a && this.f1839b == dVar.f1839b && TextUtils.equals(this.f1840c, dVar.f1840c);
        }

        public int hashCode() {
            return ((((527 + this.a) * 31) + this.f1839b) * 31) + this.f1840c.hashCode();
        }
    }

    public h(PreferenceGroup preferenceGroup) {
        this.f1829f = preferenceGroup;
        this.f1829f.M0(this);
        this.f1830g = new ArrayList();
        this.f1831h = new ArrayList();
        this.f1832i = new ArrayList();
        PreferenceGroup preferenceGroup2 = this.f1829f;
        if (preferenceGroup2 instanceof PreferenceScreen) {
            setHasStableIds(((PreferenceScreen) preferenceGroup2).n1());
        } else {
            setHasStableIds(true);
        }
        n();
    }

    private androidx.preference.b g(PreferenceGroup preferenceGroup, List<Preference> list) {
        androidx.preference.b bVar = new androidx.preference.b(preferenceGroup.D(), list, preferenceGroup.H());
        bVar.N0(new c(preferenceGroup));
        return bVar;
    }

    private List<Preference> h(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int iF1 = preferenceGroup.f1();
        int i2 = 0;
        for (int i3 = 0; i3 < iF1; i3++) {
            Preference preferenceE1 = preferenceGroup.e1(i3);
            if (preferenceE1.d0()) {
                if (!k(preferenceGroup) || i2 < preferenceGroup.c1()) {
                    arrayList.add(preferenceE1);
                } else {
                    arrayList2.add(preferenceE1);
                }
                if (preferenceE1 instanceof PreferenceGroup) {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceE1;
                    if (!preferenceGroup2.g1()) {
                        continue;
                    } else {
                        if (k(preferenceGroup) && k(preferenceGroup2)) {
                            throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                        }
                        for (Preference preference : h(preferenceGroup2)) {
                            if (!k(preferenceGroup) || i2 < preferenceGroup.c1()) {
                                arrayList.add(preference);
                            } else {
                                arrayList2.add(preference);
                            }
                            i2++;
                        }
                    }
                } else {
                    i2++;
                }
            }
        }
        if (k(preferenceGroup) && i2 > preferenceGroup.c1()) {
            arrayList.add(g(preferenceGroup, arrayList2));
        }
        return arrayList;
    }

    private void i(List<Preference> list, PreferenceGroup preferenceGroup) {
        preferenceGroup.m1();
        int iF1 = preferenceGroup.f1();
        for (int i2 = 0; i2 < iF1; i2++) {
            Preference preferenceE1 = preferenceGroup.e1(i2);
            list.add(preferenceE1);
            d dVar = new d(preferenceE1);
            if (!this.f1832i.contains(dVar)) {
                this.f1832i.add(dVar);
            }
            if (preferenceE1 instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceE1;
                if (preferenceGroup2.g1()) {
                    i(list, preferenceGroup2);
                }
            }
            preferenceE1.M0(this);
        }
    }

    private boolean k(PreferenceGroup preferenceGroup) {
        return preferenceGroup.c1() != Integer.MAX_VALUE;
    }

    @Override // androidx.preference.Preference.b
    public void a(Preference preference) {
        this.f1833j.removeCallbacks(this.f1834k);
        this.f1833j.post(this.f1834k);
    }

    @Override // androidx.preference.Preference.b
    public void b(Preference preference) {
        a(preference);
    }

    @Override // androidx.preference.PreferenceGroup.c
    public int c(Preference preference) {
        int size = this.f1831h.size();
        for (int i2 = 0; i2 < size; i2++) {
            Preference preference2 = this.f1831h.get(i2);
            if (preference2 != null && preference2.equals(preference)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // androidx.preference.Preference.b
    public void e(Preference preference) {
        int iIndexOf = this.f1831h.indexOf(preference);
        if (iIndexOf != -1) {
            notifyItemChanged(iIndexOf, preference);
        }
    }

    @Override // androidx.preference.PreferenceGroup.c
    public int f(String str) {
        int size = this.f1831h.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (TextUtils.equals(str, this.f1831h.get(i2).J())) {
                return i2;
            }
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f1831h.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long getItemId(int i2) {
        if (hasStableIds()) {
            return j(i2).H();
        }
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        d dVar = new d(j(i2));
        int iIndexOf = this.f1832i.indexOf(dVar);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        int size = this.f1832i.size();
        this.f1832i.add(dVar);
        return size;
    }

    public Preference j(int i2) {
        if (i2 < 0 || i2 >= getItemCount()) {
            return null;
        }
        return this.f1831h.get(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(l lVar, int i2) {
        j(i2).k0(lVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public l onCreateViewHolder(ViewGroup viewGroup, int i2) {
        d dVar = this.f1832i.get(i2);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        TypedArray typedArrayObtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, t.p);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(t.q);
        if (drawable == null) {
            drawable = c.a.k.a.a.d(viewGroup.getContext(), R.drawable.list_selector_background);
        }
        typedArrayObtainStyledAttributes.recycle();
        View viewInflate = layoutInflaterFrom.inflate(dVar.a, viewGroup, false);
        if (viewInflate.getBackground() == null) {
            u.m0(viewInflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(R.id.widget_frame);
        if (viewGroup2 != null) {
            int i3 = dVar.f1839b;
            if (i3 != 0) {
                layoutInflaterFrom.inflate(i3, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new l(viewInflate);
    }

    void n() {
        Iterator<Preference> it = this.f1830g.iterator();
        while (it.hasNext()) {
            it.next().M0(null);
        }
        ArrayList arrayList = new ArrayList(this.f1830g.size());
        this.f1830g = arrayList;
        i(arrayList, this.f1829f);
        List<Preference> list = this.f1831h;
        List<Preference> listH = h(this.f1829f);
        this.f1831h = listH;
        j jVarS = this.f1829f.S();
        if (jVarS == null || jVarS.g() == null) {
            notifyDataSetChanged();
        } else {
            androidx.recyclerview.widget.f.a(new b(list, listH, jVarS.g())).e(this);
        }
        Iterator<Preference> it2 = this.f1830g.iterator();
        while (it2.hasNext()) {
            it2.next().q();
        }
    }
}
