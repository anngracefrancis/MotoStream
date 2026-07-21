package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SpecialEffectsController.java */
/* JADX INFO: loaded from: classes.dex */
abstract class a0 {
    private final ViewGroup a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList<e> f1534b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ArrayList<e> f1535c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f1536d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f1537e = false;

    /* JADX INFO: compiled from: SpecialEffectsController.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f1538f;

        a(d dVar) {
            this.f1538f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a0.this.f1534b.contains(this.f1538f)) {
                this.f1538f.e().g(this.f1538f.f().mView);
            }
        }
    }

    /* JADX INFO: compiled from: SpecialEffectsController.java */
    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f1540f;

        b(d dVar) {
            this.f1540f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a0.this.f1534b.remove(this.f1540f);
            a0.this.f1535c.remove(this.f1540f);
        }
    }

    /* JADX INFO: compiled from: SpecialEffectsController.java */
    static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f1542b;

        static {
            int[] iArr = new int[e.b.values().length];
            f1542b = iArr;
            try {
                iArr[e.b.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1542b[e.b.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1542b[e.b.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[e.c.values().length];
            a = iArr2;
            try {
                iArr2[e.c.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[e.c.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[e.c.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[e.c.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: SpecialEffectsController.java */
    private static class d extends e {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final r f1543h;

        d(e.c cVar, e.b bVar, r rVar, androidx.core.os.b bVar2) {
            super(cVar, bVar, rVar.k(), bVar2);
            this.f1543h = rVar;
        }

        @Override // androidx.fragment.app.a0.e
        public void c() {
            super.c();
            this.f1543h.m();
        }

        @Override // androidx.fragment.app.a0.e
        void l() {
            Fragment fragmentK = this.f1543h.k();
            View viewFindFocus = fragmentK.mView.findFocus();
            if (viewFindFocus != null) {
                fragmentK.setFocusedView(viewFindFocus);
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragmentK);
                }
            }
            if (g() == e.b.ADDING) {
                View viewRequireView = f().requireView();
                if (viewRequireView.getParent() == null) {
                    this.f1543h.b();
                    viewRequireView.setAlpha(0.0f);
                }
                if (viewRequireView.getAlpha() == 0.0f && viewRequireView.getVisibility() == 0) {
                    viewRequireView.setVisibility(4);
                }
                viewRequireView.setAlpha(fragmentK.getPostOnViewCreatedAlpha());
            }
        }
    }

    /* JADX INFO: compiled from: SpecialEffectsController.java */
    static class e {
        private c a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b f1544b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Fragment f1545c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<Runnable> f1546d = new ArrayList();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final HashSet<androidx.core.os.b> f1547e = new HashSet<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f1548f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f1549g = false;

        /* JADX INFO: compiled from: SpecialEffectsController.java */
        class a implements androidx.core.os.b.a {
            a() {
            }

            @Override // androidx.core.os.b.a
            public void onCancel() {
                e.this.b();
            }
        }

        /* JADX INFO: compiled from: SpecialEffectsController.java */
        enum b {
            NONE,
            ADDING,
            REMOVING
        }

        /* JADX INFO: compiled from: SpecialEffectsController.java */
        enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            static c k(int i2) {
                if (i2 == 0) {
                    return VISIBLE;
                }
                if (i2 == 4) {
                    return INVISIBLE;
                }
                if (i2 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i2);
            }

            static c q(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : k(view.getVisibility());
            }

            void g(View view) {
                int i2 = c.a[ordinal()];
                if (i2 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.H0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i2 == 2) {
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i2 == 3) {
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i2 != 4) {
                    return;
                }
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        e(c cVar, b bVar, Fragment fragment, androidx.core.os.b bVar2) {
            this.a = cVar;
            this.f1544b = bVar;
            this.f1545c = fragment;
            bVar2.c(new a());
        }

        final void a(Runnable runnable) {
            this.f1546d.add(runnable);
        }

        final void b() {
            if (h()) {
                return;
            }
            this.f1548f = true;
            if (this.f1547e.isEmpty()) {
                c();
                return;
            }
            Iterator it = new ArrayList(this.f1547e).iterator();
            while (it.hasNext()) {
                ((androidx.core.os.b) it.next()).a();
            }
        }

        public void c() {
            if (this.f1549g) {
                return;
            }
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f1549g = true;
            Iterator<Runnable> it = this.f1546d.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }

        public final void d(androidx.core.os.b bVar) {
            if (this.f1547e.remove(bVar) && this.f1547e.isEmpty()) {
                c();
            }
        }

        public c e() {
            return this.a;
        }

        public final Fragment f() {
            return this.f1545c;
        }

        b g() {
            return this.f1544b;
        }

        final boolean h() {
            return this.f1548f;
        }

        final boolean i() {
            return this.f1549g;
        }

        public final void j(androidx.core.os.b bVar) {
            l();
            this.f1547e.add(bVar);
        }

        final void k(c cVar, b bVar) {
            int i2 = c.f1542b[bVar.ordinal()];
            if (i2 == 1) {
                if (this.a == c.REMOVED) {
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f1545c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f1544b + " to ADDING.");
                    }
                    this.a = c.VISIBLE;
                    this.f1544b = b.ADDING;
                    return;
                }
                return;
            }
            if (i2 == 2) {
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f1545c + " mFinalState = " + this.a + " -> REMOVED. mLifecycleImpact  = " + this.f1544b + " to REMOVING.");
                }
                this.a = c.REMOVED;
                this.f1544b = b.REMOVING;
                return;
            }
            if (i2 == 3 && this.a != c.REMOVED) {
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f1545c + " mFinalState = " + this.a + " -> " + cVar + ". ");
                }
                this.a = cVar;
            }
        }

        void l() {
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.a + "} {mLifecycleImpact = " + this.f1544b + "} {mFragment = " + this.f1545c + "}";
        }
    }

    a0(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    private void a(e.c cVar, e.b bVar, r rVar) {
        synchronized (this.f1534b) {
            androidx.core.os.b bVar2 = new androidx.core.os.b();
            e eVarH = h(rVar.k());
            if (eVarH != null) {
                eVarH.k(cVar, bVar);
                return;
            }
            d dVar = new d(cVar, bVar, rVar, bVar2);
            this.f1534b.add(dVar);
            dVar.a(new a(dVar));
            dVar.a(new b(dVar));
        }
    }

    private e h(Fragment fragment) {
        for (e eVar : this.f1534b) {
            if (eVar.f().equals(fragment) && !eVar.h()) {
                return eVar;
            }
        }
        return null;
    }

    private e i(Fragment fragment) {
        for (e eVar : this.f1535c) {
            if (eVar.f().equals(fragment) && !eVar.h()) {
                return eVar;
            }
        }
        return null;
    }

    static a0 n(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return o(viewGroup, fragmentManager.B0());
    }

    static a0 o(ViewGroup viewGroup, b0 b0Var) {
        int i2 = c.m.b.f3342b;
        Object tag = viewGroup.getTag(i2);
        if (tag instanceof a0) {
            return (a0) tag;
        }
        a0 a0VarA = b0Var.a(viewGroup);
        viewGroup.setTag(i2, a0VarA);
        return a0VarA;
    }

    private void q() {
        for (e eVar : this.f1534b) {
            if (eVar.g() == e.b.ADDING) {
                eVar.k(e.c.k(eVar.f().requireView().getVisibility()), e.b.NONE);
            }
        }
    }

    void b(e.c cVar, r rVar) {
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + rVar.k());
        }
        a(cVar, e.b.ADDING, rVar);
    }

    void c(r rVar) {
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + rVar.k());
        }
        a(e.c.GONE, e.b.NONE, rVar);
    }

    void d(r rVar) {
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + rVar.k());
        }
        a(e.c.REMOVED, e.b.REMOVING, rVar);
    }

    void e(r rVar) {
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + rVar.k());
        }
        a(e.c.VISIBLE, e.b.NONE, rVar);
    }

    abstract void f(List<e> list, boolean z);

    void g() {
        if (this.f1537e) {
            return;
        }
        if (!androidx.core.view.u.N(this.a)) {
            j();
            this.f1536d = false;
            return;
        }
        synchronized (this.f1534b) {
            if (!this.f1534b.isEmpty()) {
                ArrayList<e> arrayList = new ArrayList(this.f1535c);
                this.f1535c.clear();
                for (e eVar : arrayList) {
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + eVar);
                    }
                    eVar.b();
                    if (!eVar.i()) {
                        this.f1535c.add(eVar);
                    }
                }
                q();
                ArrayList arrayList2 = new ArrayList(this.f1534b);
                this.f1534b.clear();
                this.f1535c.addAll(arrayList2);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).l();
                }
                f(arrayList2, this.f1536d);
                this.f1536d = false;
            }
        }
    }

    void j() {
        boolean zN = androidx.core.view.u.N(this.a);
        synchronized (this.f1534b) {
            q();
            Iterator<e> it = this.f1534b.iterator();
            while (it.hasNext()) {
                it.next().l();
            }
            for (e eVar : new ArrayList(this.f1535c)) {
                if (FragmentManager.H0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    sb.append(zN ? HttpUrl.FRAGMENT_ENCODE_SET : "Container " + this.a + " is not attached to window. ");
                    sb.append("Cancelling running operation ");
                    sb.append(eVar);
                    Log.v("FragmentManager", sb.toString());
                }
                eVar.b();
            }
            for (e eVar2 : new ArrayList(this.f1534b)) {
                if (FragmentManager.H0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    sb2.append(zN ? HttpUrl.FRAGMENT_ENCODE_SET : "Container " + this.a + " is not attached to window. ");
                    sb2.append("Cancelling pending operation ");
                    sb2.append(eVar2);
                    Log.v("FragmentManager", sb2.toString());
                }
                eVar2.b();
            }
        }
    }

    void k() {
        if (this.f1537e) {
            this.f1537e = false;
            g();
        }
    }

    e.b l(r rVar) {
        e eVarH = h(rVar.k());
        if (eVarH != null) {
            return eVarH.g();
        }
        e eVarI = i(rVar.k());
        if (eVarI != null) {
            return eVarI.g();
        }
        return null;
    }

    public ViewGroup m() {
        return this.a;
    }

    void p() {
        synchronized (this.f1534b) {
            q();
            this.f1537e = false;
            for (int size = this.f1534b.size() - 1; size >= 0; size--) {
                e eVar = this.f1534b.get(size);
                e.c cVarQ = e.c.q(eVar.f().mView);
                e.c cVarE = eVar.e();
                e.c cVar = e.c.VISIBLE;
                if (cVarE == cVar && cVarQ != cVar) {
                    this.f1537e = eVar.f().isPostponed();
                    break;
                }
            }
        }
    }

    void r(boolean z) {
        this.f1536d = z;
    }
}
