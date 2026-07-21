package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DefaultSpecialEffectsController.java */
/* JADX INFO: loaded from: classes.dex */
class b extends a0 {

    /* JADX INFO: compiled from: DefaultSpecialEffectsController.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a0.e.c.values().length];
            a = iArr;
            try {
                iArr[a0.e.c.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[a0.e.c.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[a0.e.c.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[a0.e.c.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DefaultSpecialEffectsController.java */
    class RunnableC0035b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f1559f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a0.e f1560g;

        RunnableC0035b(List list, a0.e eVar) {
            this.f1559f = list;
            this.f1560g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1559f.contains(this.f1560g)) {
                this.f1559f.remove(this.f1560g);
                b.this.s(this.f1560g);
            }
        }
    }

    /* JADX INFO: compiled from: DefaultSpecialEffectsController.java */
    class c extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f1562b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f1563c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a0.e f1564d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ k f1565e;

        c(ViewGroup viewGroup, View view, boolean z, a0.e eVar, k kVar) {
            this.a = viewGroup;
            this.f1562b = view;
            this.f1563c = z;
            this.f1564d = eVar;
            this.f1565e = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.endViewTransition(this.f1562b);
            if (this.f1563c) {
                this.f1564d.e().g(this.f1562b);
            }
            this.f1565e.a();
        }
    }

    /* JADX INFO: compiled from: DefaultSpecialEffectsController.java */
    class d implements androidx.core.os.b.a {
        final /* synthetic */ Animator a;

        d(Animator animator) {
            this.a = animator;
        }

        @Override // androidx.core.os.b.a
        public void onCancel() {
            this.a.end();
        }
    }

    /* JADX INFO: compiled from: DefaultSpecialEffectsController.java */
    class e implements Animation.AnimationListener {
        final /* synthetic */ ViewGroup a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f1568b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f1569c;

        /* JADX INFO: compiled from: DefaultSpecialEffectsController.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.a.endViewTransition(eVar.f1568b);
                e.this.f1569c.a();
            }
        }

        e(ViewGroup viewGroup, View view, k kVar) {
            this.a = viewGroup;
            this.f1568b = view;
            this.f1569c = kVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: compiled from: DefaultSpecialEffectsController.java */
    class f implements androidx.core.os.b.a {
        final /* synthetic */ View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f1572b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f1573c;

        f(View view, ViewGroup viewGroup, k kVar) {
            this.a = view;
            this.f1572b = viewGroup;
            this.f1573c = kVar;
        }

        @Override // androidx.core.os.b.a
        public void onCancel() {
            this.a.clearAnimation();
            this.f1572b.endViewTransition(this.a);
            this.f1573c.a();
        }
    }

    /* JADX INFO: compiled from: DefaultSpecialEffectsController.java */
    class g implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a0.e f1575f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a0.e f1576g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f1577h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ c.e.a f1578i;

        g(a0.e eVar, a0.e eVar2, boolean z, c.e.a aVar) {
            this.f1575f = eVar;
            this.f1576g = eVar2;
            this.f1577h = z;
            this.f1578i = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.f(this.f1575f.f(), this.f1576g.f(), this.f1577h, this.f1578i, false);
        }
    }

    /* JADX INFO: compiled from: DefaultSpecialEffectsController.java */
    class h implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ x f1580f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ View f1581g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Rect f1582h;

        h(x xVar, View view, Rect rect) {
            this.f1580f = xVar;
            this.f1581g = view;
            this.f1582h = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1580f.k(this.f1581g, this.f1582h);
        }
    }

    /* JADX INFO: compiled from: DefaultSpecialEffectsController.java */
    class i implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f1584f;

        i(ArrayList arrayList) {
            this.f1584f = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.A(this.f1584f, 4);
        }
    }

    /* JADX INFO: compiled from: DefaultSpecialEffectsController.java */
    class j implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ m f1586f;

        j(m mVar) {
            this.f1586f = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1586f.a();
        }
    }

    /* JADX INFO: compiled from: DefaultSpecialEffectsController.java */
    private static class k extends l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f1588c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private androidx.fragment.app.e.d f1589d;

        k(a0.e eVar, androidx.core.os.b bVar) {
            super(eVar, bVar);
            this.f1588c = false;
        }

        androidx.fragment.app.e.d e(Context context) {
            if (this.f1588c) {
                return this.f1589d;
            }
            androidx.fragment.app.e.d dVarB = androidx.fragment.app.e.b(context, b().f(), b().e() == a0.e.c.VISIBLE);
            this.f1589d = dVarB;
            this.f1588c = true;
            return dVarB;
        }
    }

    /* JADX INFO: compiled from: DefaultSpecialEffectsController.java */
    private static class l {
        private final a0.e a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final androidx.core.os.b f1590b;

        l(a0.e eVar, androidx.core.os.b bVar) {
            this.a = eVar;
            this.f1590b = bVar;
        }

        void a() {
            this.a.d(this.f1590b);
        }

        a0.e b() {
            return this.a;
        }

        androidx.core.os.b c() {
            return this.f1590b;
        }

        boolean d() {
            a0.e.c cVar;
            a0.e.c cVarQ = a0.e.c.q(this.a.f().mView);
            a0.e.c cVarE = this.a.e();
            return cVarQ == cVarE || !(cVarQ == (cVar = a0.e.c.VISIBLE) || cVarE == cVar);
        }
    }

    /* JADX INFO: compiled from: DefaultSpecialEffectsController.java */
    private static class m extends l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object f1591c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f1592d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Object f1593e;

        m(a0.e eVar, androidx.core.os.b bVar, boolean z, boolean z2) {
            super(eVar, bVar);
            if (eVar.e() == a0.e.c.VISIBLE) {
                this.f1591c = z ? eVar.f().getReenterTransition() : eVar.f().getEnterTransition();
                this.f1592d = z ? eVar.f().getAllowReturnTransitionOverlap() : eVar.f().getAllowEnterTransitionOverlap();
            } else {
                this.f1591c = z ? eVar.f().getReturnTransition() : eVar.f().getExitTransition();
                this.f1592d = true;
            }
            if (!z2) {
                this.f1593e = null;
            } else if (z) {
                this.f1593e = eVar.f().getSharedElementReturnTransition();
            } else {
                this.f1593e = eVar.f().getSharedElementEnterTransition();
            }
        }

        private x f(Object obj) {
            if (obj == null) {
                return null;
            }
            x xVar = v.f1657b;
            if (xVar != null && xVar.e(obj)) {
                return xVar;
            }
            x xVar2 = v.f1658c;
            if (xVar2 != null && xVar2.e(obj)) {
                return xVar2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        x e() {
            x xVarF = f(this.f1591c);
            x xVarF2 = f(this.f1593e);
            if (xVarF == null || xVarF2 == null || xVarF == xVarF2) {
                return xVarF != null ? xVarF : xVarF2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f1591c + " which uses a different Transition  type than its shared element transition " + this.f1593e);
        }

        public Object g() {
            return this.f1593e;
        }

        Object h() {
            return this.f1591c;
        }

        public boolean i() {
            return this.f1593e != null;
        }

        boolean j() {
            return this.f1592d;
        }
    }

    b(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(List<k> list, List<a0.e> list2, boolean z, Map<a0.e, Boolean> map) {
        ViewGroup viewGroupM = m();
        Context context = viewGroupM.getContext();
        ArrayList<k> arrayList = new ArrayList();
        boolean z2 = false;
        for (k kVar : list) {
            if (kVar.d()) {
                kVar.a();
            } else {
                androidx.fragment.app.e.d dVarE = kVar.e(context);
                if (dVarE == null) {
                    kVar.a();
                } else {
                    Animator animator = dVarE.f1607b;
                    if (animator == null) {
                        arrayList.add(kVar);
                    } else {
                        a0.e eVarB = kVar.b();
                        Fragment fragmentF = eVarB.f();
                        if (Boolean.TRUE.equals(map.get(eVarB))) {
                            if (FragmentManager.H0(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + fragmentF + " as this Fragment was involved in a Transition.");
                            }
                            kVar.a();
                        } else {
                            boolean z3 = eVarB.e() == a0.e.c.GONE;
                            if (z3) {
                                list2.remove(eVarB);
                            }
                            View view = fragmentF.mView;
                            viewGroupM.startViewTransition(view);
                            animator.addListener(new c(viewGroupM, view, z3, eVarB, kVar));
                            animator.setTarget(view);
                            animator.start();
                            kVar.c().c(new d(animator));
                            z2 = true;
                        }
                    }
                }
            }
        }
        for (k kVar2 : arrayList) {
            a0.e eVarB2 = kVar2.b();
            Fragment fragmentF2 = eVarB2.f();
            if (z) {
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragmentF2 + " as Animations cannot run alongside Transitions.");
                }
                kVar2.a();
            } else if (z2) {
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragmentF2 + " as Animations cannot run alongside Animators.");
                }
                kVar2.a();
            } else {
                View view2 = fragmentF2.mView;
                Animation animation = (Animation) c.i.j.i.c(((androidx.fragment.app.e.d) c.i.j.i.c(kVar2.e(context))).a);
                if (eVarB2.e() != a0.e.c.REMOVED) {
                    view2.startAnimation(animation);
                    kVar2.a();
                } else {
                    viewGroupM.startViewTransition(view2);
                    androidx.fragment.app.e.RunnableC0037e runnableC0037e = new androidx.fragment.app.e.RunnableC0037e(animation, viewGroupM, view2);
                    runnableC0037e.setAnimationListener(new e(viewGroupM, view2, kVar2));
                    view2.startAnimation(runnableC0037e);
                }
                kVar2.c().c(new f(view2, viewGroupM, kVar2));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Map<a0.e, Boolean> x(List<m> list, boolean z, a0.e eVar, a0.e eVar2) {
        Iterator<m> it;
        View view;
        a0.e eVar3;
        Object obj;
        ArrayList<View> arrayList;
        Object obj2;
        ArrayList<View> arrayList2;
        a0.e eVar4;
        View view2;
        ArrayList<View> arrayList3;
        a0.e eVar5;
        Rect rect;
        a0.e eVar6;
        View view3;
        androidx.core.app.o enterTransitionCallback;
        androidx.core.app.o exitTransitionCallback;
        View view4;
        a0.e eVar7 = eVar;
        a0.e eVar8 = eVar2;
        HashMap map = new HashMap();
        x xVar = null;
        for (m mVar : list) {
            if (!mVar.d()) {
                x xVarE = mVar.e();
                if (xVar == null) {
                    xVar = xVarE;
                } else if (xVarE != null && xVar != xVarE) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + mVar.b().f() + " returned Transition " + mVar.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (xVar == null) {
            for (m mVar2 : list) {
                map.put(mVar2.b(), Boolean.FALSE);
                mVar2.a();
            }
            return map;
        }
        View view5 = new View(m().getContext());
        Rect rect2 = new Rect();
        ArrayList<View> arrayList4 = new ArrayList<>();
        ArrayList<View> arrayList5 = new ArrayList<>();
        c.e.a aVar = new c.e.a();
        Object obj3 = null;
        View view6 = null;
        boolean z2 = false;
        for (m mVar3 : list) {
            if (!mVar3.i() || eVar7 == null || eVar8 == null) {
                arrayList3 = arrayList5;
                eVar5 = eVar7;
                rect = rect2;
                eVar6 = eVar8;
                view3 = view5;
                view6 = view6;
            } else {
                Object objB = xVar.B(xVar.g(mVar3.g()));
                ArrayList<String> sharedElementSourceNames = eVar2.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = eVar.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = eVar.f().getSharedElementTargetNames();
                View view7 = view6;
                int i2 = 0;
                while (i2 < sharedElementTargetNames.size()) {
                    int iIndexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i2));
                    ArrayList<String> arrayList6 = sharedElementTargetNames;
                    if (iIndexOf != -1) {
                        sharedElementSourceNames.set(iIndexOf, sharedElementSourceNames2.get(i2));
                    }
                    i2++;
                    sharedElementTargetNames = arrayList6;
                }
                ArrayList<String> sharedElementTargetNames2 = eVar2.f().getSharedElementTargetNames();
                if (z == 0) {
                    enterTransitionCallback = eVar.f().getExitTransitionCallback();
                    exitTransitionCallback = eVar2.f().getEnterTransitionCallback();
                } else {
                    enterTransitionCallback = eVar.f().getEnterTransitionCallback();
                    exitTransitionCallback = eVar2.f().getExitTransitionCallback();
                }
                int i3 = 0;
                for (int size = sharedElementSourceNames.size(); i3 < size; size = size) {
                    aVar.put(sharedElementSourceNames.get(i3), sharedElementTargetNames2.get(i3));
                    i3++;
                }
                c.e.a<String, View> aVar2 = new c.e.a<>();
                u(aVar2, eVar.f().mView);
                aVar2.p(sharedElementSourceNames);
                if (enterTransitionCallback != null) {
                    throw null;
                }
                aVar.p(aVar2.keySet());
                c.e.a<String, View> aVar3 = new c.e.a<>();
                u(aVar3, eVar2.f().mView);
                aVar3.p(sharedElementTargetNames2);
                aVar3.p(aVar.values());
                if (exitTransitionCallback != null) {
                    throw null;
                }
                v.x(aVar, aVar3);
                v(aVar2, aVar.keySet());
                v(aVar3, aVar.values());
                if (aVar.isEmpty()) {
                    arrayList4.clear();
                    arrayList5.clear();
                    eVar5 = eVar;
                    arrayList3 = arrayList5;
                    rect = rect2;
                    view3 = view5;
                    view6 = view7;
                    obj3 = null;
                    eVar6 = eVar2;
                } else {
                    v.f(eVar2.f(), eVar.f(), z, aVar2, true);
                    HashMap map2 = map;
                    View view8 = view5;
                    Rect rect3 = rect2;
                    ArrayList<View> arrayList7 = arrayList5;
                    androidx.core.view.r.a(m(), new g(eVar2, eVar, z, aVar3));
                    Iterator<View> it2 = aVar2.values().iterator();
                    while (it2.hasNext()) {
                        t(arrayList4, it2.next());
                    }
                    if (sharedElementSourceNames.isEmpty()) {
                        view6 = view7;
                    } else {
                        View view9 = (View) aVar2.get(sharedElementSourceNames.get(0));
                        xVar.v(objB, view9);
                        view6 = view9;
                    }
                    Iterator<View> it3 = aVar3.values().iterator();
                    while (it3.hasNext()) {
                        t(arrayList7, it3.next());
                    }
                    arrayList3 = arrayList7;
                    if (sharedElementTargetNames2.isEmpty() || (view4 = (View) aVar3.get(sharedElementTargetNames2.get(0))) == null) {
                        rect = rect3;
                    } else {
                        rect = rect3;
                        androidx.core.view.r.a(m(), new h(xVar, view4, rect));
                        z2 = true;
                    }
                    xVar.z(objB, view8, arrayList4);
                    view3 = view8;
                    xVar.t(objB, null, null, null, null, objB, arrayList3);
                    Boolean bool = Boolean.TRUE;
                    eVar5 = eVar;
                    map = map2;
                    map.put(eVar5, bool);
                    eVar6 = eVar2;
                    map.put(eVar6, bool);
                    obj3 = objB;
                }
            }
            eVar7 = eVar5;
            arrayList4 = arrayList4;
            rect2 = rect;
            view5 = view3;
            eVar8 = eVar6;
            aVar = aVar;
            arrayList5 = arrayList3;
            xVar = xVar;
        }
        View view10 = view6;
        c.e.a aVar4 = aVar;
        ArrayList<View> arrayList8 = arrayList5;
        a0.e eVar9 = eVar7;
        ArrayList<View> arrayList9 = arrayList4;
        Rect rect4 = rect2;
        x xVar2 = xVar;
        a0.e eVar10 = eVar8;
        View view11 = view5;
        ArrayList arrayList10 = new ArrayList();
        Iterator<m> it4 = list.iterator();
        Object objN = null;
        Object objN2 = null;
        while (it4.hasNext()) {
            m next = it4.next();
            if (next.d()) {
                map.put(next.b(), Boolean.FALSE);
                next.a();
            } else {
                Object objG = xVar2.g(next.h());
                a0.e eVarB = next.b();
                boolean z3 = obj3 != null && (eVarB == eVar9 || eVarB == eVar10);
                if (objG == null) {
                    if (!z3) {
                        map.put(eVarB, Boolean.FALSE);
                        next.a();
                    }
                    arrayList2 = arrayList8;
                    arrayList = arrayList9;
                    it = it4;
                    view = view11;
                    eVar4 = eVar10;
                    view2 = view10;
                } else {
                    it = it4;
                    ArrayList<View> arrayList11 = new ArrayList<>();
                    Object obj4 = objN;
                    t(arrayList11, eVarB.f().mView);
                    if (z3) {
                        if (eVarB == eVar9) {
                            arrayList11.removeAll(arrayList9);
                        } else {
                            arrayList11.removeAll(arrayList8);
                        }
                    }
                    if (arrayList11.isEmpty()) {
                        xVar2.a(objG, view11);
                        arrayList2 = arrayList8;
                        arrayList = arrayList9;
                        view = view11;
                        eVar3 = eVarB;
                        obj2 = objN2;
                        eVar4 = eVar10;
                        obj = obj4;
                    } else {
                        xVar2.b(objG, arrayList11);
                        view = view11;
                        eVar3 = eVarB;
                        obj = obj4;
                        arrayList = arrayList9;
                        obj2 = objN2;
                        arrayList2 = arrayList8;
                        eVar4 = eVar10;
                        xVar2.t(objG, objG, arrayList11, null, null, null, null);
                        if (eVar3.e() == a0.e.c.GONE) {
                            xVar2.r(objG, eVar3.f().mView, arrayList11);
                            androidx.core.view.r.a(m(), new i(arrayList11));
                        }
                    }
                    if (eVar3.e() == a0.e.c.VISIBLE) {
                        arrayList10.addAll(arrayList11);
                        if (z2) {
                            xVar2.u(objG, rect4);
                        }
                        view2 = view10;
                    } else {
                        view2 = view10;
                        xVar2.v(objG, view2);
                    }
                    map.put(eVar3, Boolean.TRUE);
                    if (next.j()) {
                        objN2 = xVar2.n(obj2, objG, null);
                        objN = obj;
                    } else {
                        objN2 = obj2;
                        objN = xVar2.n(obj, objG, null);
                    }
                }
                eVar10 = eVar4;
                view10 = view2;
                view11 = view;
                arrayList9 = arrayList;
                arrayList8 = arrayList2;
                it4 = it;
            }
        }
        ArrayList<View> arrayList12 = arrayList8;
        ArrayList<View> arrayList13 = arrayList9;
        a0.e eVar11 = eVar10;
        Object objM = xVar2.m(objN2, objN, obj3);
        for (m mVar4 : list) {
            if (!mVar4.d()) {
                Object objH = mVar4.h();
                a0.e eVarB2 = mVar4.b();
                boolean z4 = obj3 != null && (eVarB2 == eVar9 || eVarB2 == eVar11);
                if (objH != null || z4) {
                    xVar2.w(mVar4.b().f(), objM, mVar4.c(), new j(mVar4));
                }
            }
        }
        v.A(arrayList10, 4);
        ArrayList<String> arrayListO = xVar2.o(arrayList12);
        xVar2.c(m(), objM);
        xVar2.y(m(), arrayList13, arrayList12, arrayListO, aVar4);
        v.A(arrayList10, 0);
        xVar2.A(obj3, arrayList13, arrayList12);
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0084  */
    @Override // androidx.fragment.app.a0
    void f(List<a0.e> list, boolean z) {
        a0.e eVar = null;
        a0.e eVar2 = null;
        for (a0.e eVar3 : list) {
            a0.e.c cVarQ = a0.e.c.q(eVar3.f().mView);
            int i2 = a.a[eVar3.e().ordinal()];
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                if (cVarQ == a0.e.c.VISIBLE && eVar == null) {
                    eVar = eVar3;
                }
            } else if (i2 == 4 && cVarQ != a0.e.c.VISIBLE) {
                eVar2 = eVar3;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(list);
        for (a0.e eVar4 : list) {
            androidx.core.os.b bVar = new androidx.core.os.b();
            eVar4.j(bVar);
            arrayList.add(new k(eVar4, bVar));
            androidx.core.os.b bVar2 = new androidx.core.os.b();
            eVar4.j(bVar2);
            boolean z2 = false;
            if (z) {
                if (eVar4 == eVar) {
                    z2 = true;
                }
            } else if (eVar4 == eVar2) {
                z2 = true;
            }
            arrayList2.add(new m(eVar4, bVar2, z, z2));
            eVar4.a(new RunnableC0035b(arrayList3, eVar4));
        }
        Map<a0.e, Boolean> mapX = x(arrayList2, z, eVar, eVar2);
        w(arrayList, arrayList3, mapX.containsValue(Boolean.TRUE), mapX);
        Iterator<a0.e> it = arrayList3.iterator();
        while (it.hasNext()) {
            s(it.next());
        }
        arrayList3.clear();
    }

    void s(a0.e eVar) {
        eVar.e().g(eVar.f().mView);
    }

    void t(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (androidx.core.view.w.a(viewGroup)) {
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                t(arrayList, childAt);
            }
        }
    }

    void u(Map<String, View> map, View view) {
        String strG = androidx.core.view.u.G(view);
        if (strG != null) {
            map.put(strG, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    void v(c.e.a<String, View> aVar, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = aVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(androidx.core.view.u.G(it.next().getValue()))) {
                it.remove();
            }
        }
    }
}
