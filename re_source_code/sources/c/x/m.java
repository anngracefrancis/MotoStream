package c.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Transition.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class m implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f3589f = {2, 1, 3, 4};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final g f3590g = new a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static ThreadLocal<c.e.a<Animator, d>> f3591h = new ThreadLocal<>();
    private ArrayList<s> B;
    private ArrayList<s> C;
    p L;
    private e M;
    private c.e.a<String, String> N;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f3592i = getClass().getName();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f3593j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    long f3594k = -1;
    private TimeInterpolator l = null;
    ArrayList<Integer> m = new ArrayList<>();
    ArrayList<View> n = new ArrayList<>();
    private ArrayList<String> o = null;
    private ArrayList<Class<?>> p = null;
    private ArrayList<Integer> q = null;
    private ArrayList<View> r = null;
    private ArrayList<Class<?>> s = null;
    private ArrayList<String> t = null;
    private ArrayList<Integer> u = null;
    private ArrayList<View> v = null;
    private ArrayList<Class<?>> w = null;
    private t x = new t();
    private t y = new t();
    q z = null;
    private int[] A = f3589f;
    private ViewGroup D = null;
    boolean E = false;
    ArrayList<Animator> F = new ArrayList<>();
    private int G = 0;
    private boolean H = false;
    private boolean I = false;
    private ArrayList<f> J = null;
    private ArrayList<Animator> K = new ArrayList<>();
    private g O = f3590g;

    /* JADX INFO: compiled from: Transition.java */
    static class a extends g {
        a() {
        }

        @Override // c.x.g
        public Path a(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    }

    /* JADX INFO: compiled from: Transition.java */
    class b extends AnimatorListenerAdapter {
        final /* synthetic */ c.e.a a;

        b(c.e.a aVar) {
            this.a = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.remove(animator);
            m.this.F.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            m.this.F.add(animator);
        }
    }

    /* JADX INFO: compiled from: Transition.java */
    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            m.this.q();
            animator.removeListener(this);
        }
    }

    /* JADX INFO: compiled from: Transition.java */
    private static class d {
        View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f3596b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        s f3597c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        m0 f3598d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        m f3599e;

        d(View view, String str, m mVar, m0 m0Var, s sVar) {
            this.a = view;
            this.f3596b = str;
            this.f3597c = sVar;
            this.f3598d = m0Var;
            this.f3599e = mVar;
        }
    }

    /* JADX INFO: compiled from: Transition.java */
    public static abstract class e {
    }

    /* JADX INFO: compiled from: Transition.java */
    public interface f {
        void a(m mVar);

        void b(m mVar);

        void c(m mVar);

        void d(m mVar);

        void e(m mVar);
    }

    private static c.e.a<Animator, d> B() {
        c.e.a<Animator, d> aVar = f3591h.get();
        if (aVar != null) {
            return aVar;
        }
        c.e.a<Animator, d> aVar2 = new c.e.a<>();
        f3591h.set(aVar2);
        return aVar2;
    }

    private static boolean L(s sVar, s sVar2, String str) {
        Object obj = sVar.a.get(str);
        Object obj2 = sVar2.a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    private void M(c.e.a<View, s> aVar, c.e.a<View, s> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            View viewValueAt = sparseArray.valueAt(i2);
            if (viewValueAt != null && K(viewValueAt) && (view = sparseArray2.get(sparseArray.keyAt(i2))) != null && K(view)) {
                s sVar = aVar.get(viewValueAt);
                s sVar2 = aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.B.add(sVar);
                    this.C.add(sVar2);
                    aVar.remove(viewValueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void N(c.e.a<View, s> aVar, c.e.a<View, s> aVar2) {
        s sVarRemove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View viewJ = aVar.j(size);
            if (viewJ != null && K(viewJ) && (sVarRemove = aVar2.remove(viewJ)) != null && K(sVarRemove.f3608b)) {
                this.B.add(aVar.l(size));
                this.C.add(sVarRemove);
            }
        }
    }

    private void O(c.e.a<View, s> aVar, c.e.a<View, s> aVar2, c.e.d<View> dVar, c.e.d<View> dVar2) {
        View viewG;
        int iN = dVar.n();
        for (int i2 = 0; i2 < iN; i2++) {
            View viewO = dVar.o(i2);
            if (viewO != null && K(viewO) && (viewG = dVar2.g(dVar.j(i2))) != null && K(viewG)) {
                s sVar = aVar.get(viewO);
                s sVar2 = aVar2.get(viewG);
                if (sVar != null && sVar2 != null) {
                    this.B.add(sVar);
                    this.C.add(sVar2);
                    aVar.remove(viewO);
                    aVar2.remove(viewG);
                }
            }
        }
    }

    private void P(c.e.a<View, s> aVar, c.e.a<View, s> aVar2, c.e.a<String, View> aVar3, c.e.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i2 = 0; i2 < size; i2++) {
            View viewN = aVar3.n(i2);
            if (viewN != null && K(viewN) && (view = aVar4.get(aVar3.j(i2))) != null && K(view)) {
                s sVar = aVar.get(viewN);
                s sVar2 = aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.B.add(sVar);
                    this.C.add(sVar2);
                    aVar.remove(viewN);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void Q(t tVar, t tVar2) {
        c.e.a<View, s> aVar = new c.e.a<>(tVar.a);
        c.e.a<View, s> aVar2 = new c.e.a<>(tVar2.a);
        int i2 = 0;
        while (true) {
            int[] iArr = this.A;
            if (i2 >= iArr.length) {
                e(aVar, aVar2);
                return;
            }
            int i3 = iArr[i2];
            if (i3 == 1) {
                N(aVar, aVar2);
            } else if (i3 == 2) {
                P(aVar, aVar2, tVar.f3612d, tVar2.f3612d);
            } else if (i3 == 3) {
                M(aVar, aVar2, tVar.f3610b, tVar2.f3610b);
            } else if (i3 == 4) {
                O(aVar, aVar2, tVar.f3611c, tVar2.f3611c);
            }
            i2++;
        }
    }

    private void X(Animator animator, c.e.a<Animator, d> aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            g(animator);
        }
    }

    private void e(c.e.a<View, s> aVar, c.e.a<View, s> aVar2) {
        for (int i2 = 0; i2 < aVar.size(); i2++) {
            s sVarN = aVar.n(i2);
            if (K(sVarN.f3608b)) {
                this.B.add(sVarN);
                this.C.add(null);
            }
        }
        for (int i3 = 0; i3 < aVar2.size(); i3++) {
            s sVarN2 = aVar2.n(i3);
            if (K(sVarN2.f3608b)) {
                this.C.add(sVarN2);
                this.B.add(null);
            }
        }
    }

    private static void f(t tVar, View view, s sVar) {
        tVar.a.put(view, sVar);
        int id = view.getId();
        if (id >= 0) {
            if (tVar.f3610b.indexOfKey(id) >= 0) {
                tVar.f3610b.put(id, null);
            } else {
                tVar.f3610b.put(id, view);
            }
        }
        String strG = androidx.core.view.u.G(view);
        if (strG != null) {
            if (tVar.f3612d.containsKey(strG)) {
                tVar.f3612d.put(strG, null);
            } else {
                tVar.f3612d.put(strG, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (tVar.f3611c.i(itemIdAtPosition) < 0) {
                    androidx.core.view.u.s0(view, true);
                    tVar.f3611c.k(itemIdAtPosition, view);
                    return;
                }
                View viewG = tVar.f3611c.g(itemIdAtPosition);
                if (viewG != null) {
                    androidx.core.view.u.s0(viewG, false);
                    tVar.f3611c.k(itemIdAtPosition, null);
                }
            }
        }
    }

    private void i(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.q;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.r;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.s;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.s.get(i2).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    s sVar = new s(view);
                    if (z) {
                        k(sVar);
                    } else {
                        h(sVar);
                    }
                    sVar.f3609c.add(this);
                    j(sVar);
                    if (z) {
                        f(this.x, view, sVar);
                    } else {
                        f(this.y, view, sVar);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.u;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.v;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.w;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i3 = 0; i3 < size2; i3++) {
                                    if (this.w.get(i3).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                i(viewGroup.getChildAt(i4), z);
                            }
                        }
                    }
                }
            }
        }
    }

    public p A() {
        return this.L;
    }

    public long C() {
        return this.f3593j;
    }

    public List<Integer> D() {
        return this.m;
    }

    public List<String> E() {
        return this.o;
    }

    public List<Class<?>> F() {
        return this.p;
    }

    public List<View> G() {
        return this.n;
    }

    public String[] H() {
        return null;
    }

    public s I(View view, boolean z) {
        q qVar = this.z;
        if (qVar != null) {
            return qVar.I(view, z);
        }
        return (z ? this.x : this.y).a.get(view);
    }

    public boolean J(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return false;
        }
        String[] strArrH = H();
        if (strArrH == null) {
            Iterator<String> it = sVar.a.keySet().iterator();
            while (it.hasNext()) {
                if (L(sVar, sVar2, it.next())) {
                }
            }
            return false;
        }
        for (String str : strArrH) {
            if (!L(sVar, sVar2, str)) {
            }
        }
        return false;
        return true;
    }

    boolean K(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.q;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.r;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.s;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.s.get(i2).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.t != null && androidx.core.view.u.G(view) != null && this.t.contains(androidx.core.view.u.G(view))) {
            return false;
        }
        if ((this.m.size() == 0 && this.n.size() == 0 && (((arrayList = this.p) == null || arrayList.isEmpty()) && ((arrayList2 = this.o) == null || arrayList2.isEmpty()))) || this.m.contains(Integer.valueOf(id)) || this.n.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.o;
        if (arrayList6 != null && arrayList6.contains(androidx.core.view.u.G(view))) {
            return true;
        }
        if (this.p != null) {
            for (int i3 = 0; i3 < this.p.size(); i3++) {
                if (this.p.get(i3).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void R(View view) {
        if (this.I) {
            return;
        }
        c.e.a<Animator, d> aVarB = B();
        int size = aVarB.size();
        m0 m0VarD = c0.d(view);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            d dVarN = aVarB.n(i2);
            if (dVarN.a != null && m0VarD.equals(dVarN.f3598d)) {
                c.x.a.b(aVarB.j(i2));
            }
        }
        ArrayList<f> arrayList = this.J;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.J.clone();
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ((f) arrayList2.get(i3)).b(this);
            }
        }
        this.H = true;
    }

    void S(ViewGroup viewGroup) {
        d dVar;
        this.B = new ArrayList<>();
        this.C = new ArrayList<>();
        Q(this.x, this.y);
        c.e.a<Animator, d> aVarB = B();
        int size = aVarB.size();
        m0 m0VarD = c0.d(viewGroup);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Animator animatorJ = aVarB.j(i2);
            if (animatorJ != null && (dVar = aVarB.get(animatorJ)) != null && dVar.a != null && m0VarD.equals(dVar.f3598d)) {
                s sVar = dVar.f3597c;
                View view = dVar.a;
                s sVarI = I(view, true);
                s sVarU = u(view, true);
                if (sVarI == null && sVarU == null) {
                    sVarU = this.y.a.get(view);
                }
                if (!(sVarI == null && sVarU == null) && dVar.f3599e.J(sVar, sVarU)) {
                    if (animatorJ.isRunning() || animatorJ.isStarted()) {
                        animatorJ.cancel();
                    } else {
                        aVarB.remove(animatorJ);
                    }
                }
            }
        }
        p(viewGroup, this.x, this.y, this.B, this.C);
        Z();
    }

    public m T(f fVar) {
        ArrayList<f> arrayList = this.J;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.J.size() == 0) {
            this.J = null;
        }
        return this;
    }

    public m U(View view) {
        this.n.remove(view);
        return this;
    }

    public void V(View view) {
        if (this.H) {
            if (!this.I) {
                c.e.a<Animator, d> aVarB = B();
                int size = aVarB.size();
                m0 m0VarD = c0.d(view);
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    d dVarN = aVarB.n(i2);
                    if (dVarN.a != null && m0VarD.equals(dVarN.f3598d)) {
                        c.x.a.c(aVarB.j(i2));
                    }
                }
                ArrayList<f> arrayList = this.J;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.J.clone();
                    int size2 = arrayList2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        ((f) arrayList2.get(i3)).e(this);
                    }
                }
            }
            this.H = false;
        }
    }

    protected void Z() {
        h0();
        c.e.a<Animator, d> aVarB = B();
        for (Animator animator : this.K) {
            if (aVarB.containsKey(animator)) {
                h0();
                X(animator, aVarB);
            }
        }
        this.K.clear();
        q();
    }

    public m a0(long j2) {
        this.f3594k = j2;
        return this;
    }

    public m b(f fVar) {
        if (this.J == null) {
            this.J = new ArrayList<>();
        }
        this.J.add(fVar);
        return this;
    }

    public void b0(e eVar) {
        this.M = eVar;
    }

    public m c0(TimeInterpolator timeInterpolator) {
        this.l = timeInterpolator;
        return this;
    }

    protected void cancel() {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.F.get(size).cancel();
        }
        ArrayList<f> arrayList = this.J;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.J.clone();
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((f) arrayList2.get(i2)).d(this);
        }
    }

    public m d(View view) {
        this.n.add(view);
        return this;
    }

    public void d0(g gVar) {
        if (gVar == null) {
            this.O = f3590g;
        } else {
            this.O = gVar;
        }
    }

    public void f0(p pVar) {
    }

    protected void g(Animator animator) {
        if (animator == null) {
            q();
            return;
        }
        if (r() >= 0) {
            animator.setDuration(r());
        }
        if (C() >= 0) {
            animator.setStartDelay(C() + animator.getStartDelay());
        }
        if (t() != null) {
            animator.setInterpolator(t());
        }
        animator.addListener(new c());
        animator.start();
    }

    public m g0(long j2) {
        this.f3593j = j2;
        return this;
    }

    public abstract void h(s sVar);

    protected void h0() {
        if (this.G == 0) {
            ArrayList<f> arrayList = this.J;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.J.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((f) arrayList2.get(i2)).a(this);
                }
            }
            this.I = false;
        }
        this.G++;
    }

    void j(s sVar) {
        if (this.L != null && !sVar.a.isEmpty()) {
            throw null;
        }
    }

    String j0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f3594k != -1) {
            str2 = str2 + "dur(" + this.f3594k + ") ";
        }
        if (this.f3593j != -1) {
            str2 = str2 + "dly(" + this.f3593j + ") ";
        }
        if (this.l != null) {
            str2 = str2 + "interp(" + this.l + ") ";
        }
        if (this.m.size() <= 0 && this.n.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.m.size() > 0) {
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.m.get(i2);
            }
        }
        if (this.n.size() > 0) {
            for (int i3 = 0; i3 < this.n.size(); i3++) {
                if (i3 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.n.get(i3);
            }
        }
        return str3 + ")";
    }

    public abstract void k(s sVar);

    void l(ViewGroup viewGroup, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        c.e.a<String, String> aVar;
        m(z);
        if ((this.m.size() > 0 || this.n.size() > 0) && (((arrayList = this.o) == null || arrayList.isEmpty()) && ((arrayList2 = this.p) == null || arrayList2.isEmpty()))) {
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                View viewFindViewById = viewGroup.findViewById(this.m.get(i2).intValue());
                if (viewFindViewById != null) {
                    s sVar = new s(viewFindViewById);
                    if (z) {
                        k(sVar);
                    } else {
                        h(sVar);
                    }
                    sVar.f3609c.add(this);
                    j(sVar);
                    if (z) {
                        f(this.x, viewFindViewById, sVar);
                    } else {
                        f(this.y, viewFindViewById, sVar);
                    }
                }
            }
            for (int i3 = 0; i3 < this.n.size(); i3++) {
                View view = this.n.get(i3);
                s sVar2 = new s(view);
                if (z) {
                    k(sVar2);
                } else {
                    h(sVar2);
                }
                sVar2.f3609c.add(this);
                j(sVar2);
                if (z) {
                    f(this.x, view, sVar2);
                } else {
                    f(this.y, view, sVar2);
                }
            }
        } else {
            i(viewGroup, z);
        }
        if (z || (aVar = this.N) == null) {
            return;
        }
        int size = aVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            arrayList3.add(this.x.f3612d.remove(this.N.j(i4)));
        }
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = (View) arrayList3.get(i5);
            if (view2 != null) {
                this.x.f3612d.put(this.N.n(i5), view2);
            }
        }
    }

    void m(boolean z) {
        if (z) {
            this.x.a.clear();
            this.x.f3610b.clear();
            this.x.f3611c.d();
        } else {
            this.y.a.clear();
            this.y.f3610b.clear();
            this.y.f3611c.d();
        }
    }

    @Override // 
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public m clone() {
        try {
            m mVar = (m) super.clone();
            mVar.K = new ArrayList<>();
            mVar.x = new t();
            mVar.y = new t();
            mVar.B = null;
            mVar.C = null;
            return mVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator o(ViewGroup viewGroup, s sVar, s sVar2) {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003c  */
    protected void p(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        int i2;
        View view;
        Animator animator;
        s sVar;
        Animator animator2;
        s sVar2;
        c.e.a<Animator, d> aVarB = B();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            s sVar3 = arrayList.get(i3);
            s sVar4 = arrayList2.get(i3);
            if (sVar3 != null && !sVar3.f3609c.contains(this)) {
                sVar3 = null;
            }
            if (sVar4 != null && !sVar4.f3609c.contains(this)) {
                sVar4 = null;
            }
            if (sVar3 == null && sVar4 == null) {
                i2 = size;
            } else {
                if (sVar3 == null || sVar4 == null || J(sVar3, sVar4)) {
                    Animator animatorO = o(viewGroup, sVar3, sVar4);
                    if (animatorO != null) {
                        if (sVar4 != null) {
                            View view2 = sVar4.f3608b;
                            String[] strArrH = H();
                            if (strArrH != null && strArrH.length > 0) {
                                sVar2 = new s(view2);
                                s sVar5 = tVar2.a.get(view2);
                                if (sVar5 != null) {
                                    int i4 = 0;
                                    while (i4 < strArrH.length) {
                                        sVar2.a.put(strArrH[i4], sVar5.a.get(strArrH[i4]));
                                        i4++;
                                        animatorO = animatorO;
                                        size = size;
                                        sVar5 = sVar5;
                                    }
                                }
                                Animator animator3 = animatorO;
                                i2 = size;
                                int size2 = aVarB.size();
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= size2) {
                                        animator2 = animator3;
                                        break;
                                    }
                                    d dVar = aVarB.get(aVarB.j(i5));
                                    if (dVar.f3597c != null && dVar.a == view2 && dVar.f3596b.equals(v()) && dVar.f3597c.equals(sVar2)) {
                                        animator2 = null;
                                        break;
                                    }
                                    i5++;
                                }
                            } else {
                                i2 = size;
                                animator2 = animatorO;
                                sVar2 = null;
                            }
                            view = view2;
                            animator = animator2;
                            sVar = sVar2;
                        } else {
                            i2 = size;
                            view = sVar3.f3608b;
                            animator = animatorO;
                            sVar = null;
                        }
                        if (animator == null) {
                            continue;
                        } else {
                            if (this.L != null) {
                                throw null;
                            }
                            aVarB.put(animator, new d(view, v(), this, c0.d(viewGroup), sVar));
                            this.K.add(animator);
                        }
                    }
                }
                i2 = size;
            }
            i3++;
            size = i2;
        }
        if (sparseIntArray.size() != 0) {
            for (int i6 = 0; i6 < sparseIntArray.size(); i6++) {
                Animator animator4 = this.K.get(sparseIntArray.keyAt(i6));
                animator4.setStartDelay((((long) sparseIntArray.valueAt(i6)) - Long.MAX_VALUE) + animator4.getStartDelay());
            }
        }
    }

    protected void q() {
        int i2 = this.G - 1;
        this.G = i2;
        if (i2 == 0) {
            ArrayList<f> arrayList = this.J;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.J.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((f) arrayList2.get(i3)).c(this);
                }
            }
            for (int i4 = 0; i4 < this.x.f3611c.n(); i4++) {
                View viewO = this.x.f3611c.o(i4);
                if (viewO != null) {
                    androidx.core.view.u.s0(viewO, false);
                }
            }
            for (int i5 = 0; i5 < this.y.f3611c.n(); i5++) {
                View viewO2 = this.y.f3611c.o(i5);
                if (viewO2 != null) {
                    androidx.core.view.u.s0(viewO2, false);
                }
            }
            this.I = true;
        }
    }

    public long r() {
        return this.f3594k;
    }

    public e s() {
        return this.M;
    }

    public TimeInterpolator t() {
        return this.l;
    }

    public String toString() {
        return j0(HttpUrl.FRAGMENT_ENCODE_SET);
    }

    s u(View view, boolean z) {
        q qVar = this.z;
        if (qVar != null) {
            return qVar.u(view, z);
        }
        ArrayList<s> arrayList = z ? this.B : this.C;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = -1;
        for (int i3 = 0; i3 < size; i3++) {
            s sVar = arrayList.get(i3);
            if (sVar == null) {
                return null;
            }
            if (sVar.f3608b == view) {
                i2 = i3;
                break;
            }
        }
        if (i2 >= 0) {
            return (z ? this.C : this.B).get(i2);
        }
        return null;
    }

    public String v() {
        return this.f3592i;
    }

    public g w() {
        return this.O;
    }
}
