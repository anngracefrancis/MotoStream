package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: FragmentTransitionCompat21.java */
/* JADX INFO: loaded from: classes.dex */
class w extends x {

    /* JADX INFO: compiled from: FragmentTransitionCompat21.java */
    class a extends Transition.EpicenterCallback {
        final /* synthetic */ Rect a;

        a(Rect rect) {
            this.a = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: FragmentTransitionCompat21.java */
    class b implements Transition.TransitionListener {
        final /* synthetic */ View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f1690b;

        b(View view, ArrayList arrayList) {
            this.a = view;
            this.f1690b = arrayList;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            this.a.setVisibility(8);
            int size = this.f1690b.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((View) this.f1690b.get(i2)).setVisibility(0);
            }
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            transition.removeListener(this);
            transition.addListener(this);
        }
    }

    /* JADX INFO: compiled from: FragmentTransitionCompat21.java */
    class c implements Transition.TransitionListener {
        final /* synthetic */ Object a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f1692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f1693c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f1694d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f1695e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f1696f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.a = obj;
            this.f1692b = arrayList;
            this.f1693c = obj2;
            this.f1694d = arrayList2;
            this.f1695e = obj3;
            this.f1696f = arrayList3;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            Object obj = this.a;
            if (obj != null) {
                w.this.q(obj, this.f1692b, null);
            }
            Object obj2 = this.f1693c;
            if (obj2 != null) {
                w.this.q(obj2, this.f1694d, null);
            }
            Object obj3 = this.f1695e;
            if (obj3 != null) {
                w.this.q(obj3, this.f1696f, null);
            }
        }
    }

    /* JADX INFO: compiled from: FragmentTransitionCompat21.java */
    class d implements Transition.TransitionListener {
        final /* synthetic */ Runnable a;

        d(Runnable runnable) {
            this.a = runnable;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            this.a.run();
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }
    }

    /* JADX INFO: compiled from: FragmentTransitionCompat21.java */
    class e extends Transition.EpicenterCallback {
        final /* synthetic */ Rect a;

        e(Rect rect) {
            this.a = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            Rect rect = this.a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.a;
        }
    }

    w() {
    }

    private static boolean C(Transition transition) {
        return (x.l(transition.getTargetIds()) && x.l(transition.getTargetNames()) && x.l(transition.getTargetTypes())) ? false : true;
    }

    @Override // androidx.fragment.app.x
    public void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            q(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.x
    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    @Override // androidx.fragment.app.x
    public void a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.x
    public void b(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i2 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i2 < transitionCount) {
                b(transitionSet.getTransitionAt(i2), arrayList);
                i2++;
            }
            return;
        }
        if (C(transition) || !x.l(transition.getTargets())) {
            return;
        }
        int size = arrayList.size();
        while (i2 < size) {
            transition.addTarget(arrayList.get(i2));
            i2++;
        }
    }

    @Override // androidx.fragment.app.x
    public void c(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    @Override // androidx.fragment.app.x
    public boolean e(Object obj) {
        return obj instanceof Transition;
    }

    @Override // androidx.fragment.app.x
    public Object g(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.x
    public Object m(Object obj, Object obj2, Object obj3) {
        Transition ordering = (Transition) obj;
        Transition transition = (Transition) obj2;
        Transition transition2 = (Transition) obj3;
        if (ordering != null && transition != null) {
            ordering = new TransitionSet().addTransition(ordering).addTransition(transition).setOrdering(1);
        } else if (ordering == null) {
            ordering = transition != null ? transition : null;
        }
        if (transition2 == null) {
            return ordering;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (ordering != null) {
            transitionSet.addTransition(ordering);
        }
        transitionSet.addTransition(transition2);
        return transitionSet;
    }

    @Override // androidx.fragment.app.x
    public Object n(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    @Override // androidx.fragment.app.x
    public void p(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    @Override // androidx.fragment.app.x
    public void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        List<View> targets;
        Transition transition = (Transition) obj;
        int i2 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i2 < transitionCount) {
                q(transitionSet.getTransitionAt(i2), arrayList, arrayList2);
                i2++;
            }
            return;
        }
        if (C(transition) || (targets = transition.getTargets()) == null || targets.size() != arrayList.size() || !targets.containsAll(arrayList)) {
            return;
        }
        int size = arrayList2 == null ? 0 : arrayList2.size();
        while (i2 < size) {
            transition.addTarget(arrayList2.get(i2));
            i2++;
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            transition.removeTarget(arrayList.get(size2));
        }
    }

    @Override // androidx.fragment.app.x
    public void r(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.x
    public void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.x
    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new e(rect));
        }
    }

    @Override // androidx.fragment.app.x
    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((Transition) obj).setEpicenterCallback(new a(rect));
        }
    }

    @Override // androidx.fragment.app.x
    public void w(Fragment fragment, Object obj, androidx.core.os.b bVar, Runnable runnable) {
        ((Transition) obj).addListener(new d(runnable));
    }

    @Override // androidx.fragment.app.x
    public void z(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            x.d(targets, arrayList.get(i2));
        }
        targets.add(view);
        arrayList.add(view);
        b(transitionSet, arrayList);
    }
}
