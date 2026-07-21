package c.x;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: TransitionManager.java */
/* JADX INFO: loaded from: classes.dex */
public class o {
    private static m a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ThreadLocal<WeakReference<c.e.a<ViewGroup, ArrayList<m>>>> f3600b = new ThreadLocal<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static ArrayList<ViewGroup> f3601c = new ArrayList<>();

    /* JADX INFO: compiled from: TransitionManager.java */
    private static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        m f3602f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ViewGroup f3603g;

        /* JADX INFO: renamed from: c.x.o$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: TransitionManager.java */
        class C0102a extends n {
            final /* synthetic */ c.e.a a;

            C0102a(c.e.a aVar) {
                this.a = aVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.x.m.f
            public void c(m mVar) {
                ((ArrayList) this.a.get(a.this.f3603g)).remove(mVar);
                mVar.T(this);
            }
        }

        a(m mVar, ViewGroup viewGroup) {
            this.f3602f = mVar;
            this.f3603g = viewGroup;
        }

        private void a() {
            this.f3603g.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f3603g.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!o.f3601c.remove(this.f3603g)) {
                return true;
            }
            c.e.a<ViewGroup, ArrayList<m>> aVarB = o.b();
            ArrayList<m> arrayList = aVarB.get(this.f3603g);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                aVarB.put(this.f3603g, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f3602f);
            this.f3602f.b(new C0102a(aVarB));
            this.f3602f.l(this.f3603g, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((m) it.next()).V(this.f3603g);
                }
            }
            this.f3602f.S(this.f3603g);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            o.f3601c.remove(this.f3603g);
            ArrayList<m> arrayList = o.b().get(this.f3603g);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<m> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().V(this.f3603g);
                }
            }
            this.f3602f.m(true);
        }
    }

    public static void a(ViewGroup viewGroup, m mVar) {
        if (f3601c.contains(viewGroup) || !androidx.core.view.u.O(viewGroup)) {
            return;
        }
        f3601c.add(viewGroup);
        if (mVar == null) {
            mVar = a;
        }
        m mVarClone = mVar.clone();
        d(viewGroup, mVarClone);
        l.c(viewGroup, null);
        c(viewGroup, mVarClone);
    }

    static c.e.a<ViewGroup, ArrayList<m>> b() {
        c.e.a<ViewGroup, ArrayList<m>> aVar;
        WeakReference<c.e.a<ViewGroup, ArrayList<m>>> weakReference = f3600b.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        c.e.a<ViewGroup, ArrayList<m>> aVar2 = new c.e.a<>();
        f3600b.set(new WeakReference<>(aVar2));
        return aVar2;
    }

    private static void c(ViewGroup viewGroup, m mVar) {
        if (mVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(mVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    private static void d(ViewGroup viewGroup, m mVar) {
        ArrayList<m> arrayList = b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<m> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().R(viewGroup);
            }
        }
        if (mVar != null) {
            mVar.l(viewGroup, true);
        }
        l lVarB = l.b(viewGroup);
        if (lVarB != null) {
            lVarB.a();
        }
    }
}
