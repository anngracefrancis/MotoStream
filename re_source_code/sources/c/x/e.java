package c.x;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: FragmentTransitionSupport.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public class e extends androidx.fragment.app.x {

    /* JADX INFO: compiled from: FragmentTransitionSupport.java */
    class a extends m.e {
        final /* synthetic */ Rect a;

        a(Rect rect) {
            this.a = rect;
        }
    }

    /* JADX INFO: compiled from: FragmentTransitionSupport.java */
    class b implements m.f {
        final /* synthetic */ View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f3551b;

        b(View view, ArrayList arrayList) {
            this.a = view;
            this.f3551b = arrayList;
        }

        @Override // c.x.m.f
        public void a(m mVar) {
        }

        @Override // c.x.m.f
        public void b(m mVar) {
        }

        @Override // c.x.m.f
        public void c(m mVar) {
            mVar.T(this);
            this.a.setVisibility(8);
            int size = this.f3551b.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((View) this.f3551b.get(i2)).setVisibility(0);
            }
        }

        @Override // c.x.m.f
        public void d(m mVar) {
        }

        @Override // c.x.m.f
        public void e(m mVar) {
        }
    }

    /* JADX INFO: compiled from: FragmentTransitionSupport.java */
    class c extends n {
        final /* synthetic */ Object a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f3553b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f3554c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f3555d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f3556e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f3557f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.a = obj;
            this.f3553b = arrayList;
            this.f3554c = obj2;
            this.f3555d = arrayList2;
            this.f3556e = obj3;
            this.f3557f = arrayList3;
        }

        @Override // c.x.n, c.x.m.f
        public void a(m mVar) {
            Object obj = this.a;
            if (obj != null) {
                e.this.q(obj, this.f3553b, null);
            }
            Object obj2 = this.f3554c;
            if (obj2 != null) {
                e.this.q(obj2, this.f3555d, null);
            }
            Object obj3 = this.f3556e;
            if (obj3 != null) {
                e.this.q(obj3, this.f3557f, null);
            }
        }

        @Override // c.x.m.f
        public void c(m mVar) {
            mVar.T(this);
        }
    }

    /* JADX INFO: compiled from: FragmentTransitionSupport.java */
    class d extends m.e {
        final /* synthetic */ Rect a;

        d(Rect rect) {
            this.a = rect;
        }
    }

    private static boolean C(m mVar) {
        return (androidx.fragment.app.x.l(mVar.D()) && androidx.fragment.app.x.l(mVar.E()) && androidx.fragment.app.x.l(mVar.F())) ? false : true;
    }

    @Override // androidx.fragment.app.x
    public void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        q qVar = (q) obj;
        if (qVar != null) {
            qVar.G().clear();
            qVar.G().addAll(arrayList2);
            q(qVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.x
    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        q qVar = new q();
        qVar.m0((m) obj);
        return qVar;
    }

    @Override // androidx.fragment.app.x
    public void a(Object obj, View view) {
        if (obj != null) {
            ((m) obj).d(view);
        }
    }

    @Override // androidx.fragment.app.x
    public void b(Object obj, ArrayList<View> arrayList) {
        m mVar = (m) obj;
        if (mVar == null) {
            return;
        }
        int i2 = 0;
        if (mVar instanceof q) {
            q qVar = (q) mVar;
            int iQ0 = qVar.q0();
            while (i2 < iQ0) {
                b(qVar.o0(i2), arrayList);
                i2++;
            }
            return;
        }
        if (C(mVar) || !androidx.fragment.app.x.l(mVar.G())) {
            return;
        }
        int size = arrayList.size();
        while (i2 < size) {
            mVar.d(arrayList.get(i2));
            i2++;
        }
    }

    @Override // androidx.fragment.app.x
    public void c(ViewGroup viewGroup, Object obj) {
        o.a(viewGroup, (m) obj);
    }

    @Override // androidx.fragment.app.x
    public boolean e(Object obj) {
        return obj instanceof m;
    }

    @Override // androidx.fragment.app.x
    public Object g(Object obj) {
        if (obj != null) {
            return ((m) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.x
    public Object m(Object obj, Object obj2, Object obj3) {
        m mVarV0 = (m) obj;
        m mVar = (m) obj2;
        m mVar2 = (m) obj3;
        if (mVarV0 != null && mVar != null) {
            mVarV0 = new q().m0(mVarV0).m0(mVar).v0(1);
        } else if (mVarV0 == null) {
            mVarV0 = mVar != null ? mVar : null;
        }
        if (mVar2 == null) {
            return mVarV0;
        }
        q qVar = new q();
        if (mVarV0 != null) {
            qVar.m0(mVarV0);
        }
        qVar.m0(mVar2);
        return qVar;
    }

    @Override // androidx.fragment.app.x
    public Object n(Object obj, Object obj2, Object obj3) {
        q qVar = new q();
        if (obj != null) {
            qVar.m0((m) obj);
        }
        if (obj2 != null) {
            qVar.m0((m) obj2);
        }
        if (obj3 != null) {
            qVar.m0((m) obj3);
        }
        return qVar;
    }

    @Override // androidx.fragment.app.x
    public void p(Object obj, View view) {
        if (obj != null) {
            ((m) obj).U(view);
        }
    }

    @Override // androidx.fragment.app.x
    public void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        m mVar = (m) obj;
        int i2 = 0;
        if (mVar instanceof q) {
            q qVar = (q) mVar;
            int iQ0 = qVar.q0();
            while (i2 < iQ0) {
                q(qVar.o0(i2), arrayList, arrayList2);
                i2++;
            }
            return;
        }
        if (C(mVar)) {
            return;
        }
        List<View> listG = mVar.G();
        if (listG.size() == arrayList.size() && listG.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i2 < size) {
                mVar.d(arrayList2.get(i2));
                i2++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                mVar.U(arrayList.get(size2));
            }
        }
    }

    @Override // androidx.fragment.app.x
    public void r(Object obj, View view, ArrayList<View> arrayList) {
        ((m) obj).b(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.x
    public void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((m) obj).b(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.x
    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((m) obj).b0(new d(rect));
        }
    }

    @Override // androidx.fragment.app.x
    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((m) obj).b0(new a(rect));
        }
    }

    @Override // androidx.fragment.app.x
    public void z(Object obj, View view, ArrayList<View> arrayList) {
        q qVar = (q) obj;
        List<View> listG = qVar.G();
        listG.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            androidx.fragment.app.x.d(listG, arrayList.get(i2));
        }
        listG.add(view);
        arrayList.add(view);
        b(qVar, arrayList);
    }
}
