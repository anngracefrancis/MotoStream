package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: FragmentTransitionImpl.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
public abstract class x {

    /* JADX INFO: compiled from: FragmentTransitionImpl.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f1700f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ArrayList f1701g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ ArrayList f1702h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ ArrayList f1703i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ ArrayList f1704j;

        a(int i2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f1700f = i2;
            this.f1701g = arrayList;
            this.f1702h = arrayList2;
            this.f1703i = arrayList3;
            this.f1704j = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i2 = 0; i2 < this.f1700f; i2++) {
                androidx.core.view.u.z0((View) this.f1701g.get(i2), (String) this.f1702h.get(i2));
                androidx.core.view.u.z0((View) this.f1703i.get(i2), (String) this.f1704j.get(i2));
            }
        }
    }

    /* JADX INFO: compiled from: FragmentTransitionImpl.java */
    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f1706f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Map f1707g;

        b(ArrayList arrayList, Map map) {
            this.f1706f = arrayList;
            this.f1707g = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f1706f.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) this.f1706f.get(i2);
                String strG = androidx.core.view.u.G(view);
                if (strG != null) {
                    androidx.core.view.u.z0(view, x.i(this.f1707g, strG));
                }
            }
        }
    }

    /* JADX INFO: compiled from: FragmentTransitionImpl.java */
    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f1709f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Map f1710g;

        c(ArrayList arrayList, Map map) {
            this.f1709f = arrayList;
            this.f1710g = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f1709f.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) this.f1709f.get(i2);
                androidx.core.view.u.z0(view, (String) this.f1710g.get(androidx.core.view.u.G(view)));
            }
        }
    }

    protected static void d(List<View> list, View view) {
        int size = list.size();
        if (h(list, view, size)) {
            return;
        }
        list.add(view);
        for (int i2 = size; i2 < list.size(); i2++) {
            View view2 = list.get(i2);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = viewGroup.getChildAt(i3);
                    if (!h(list, childAt, size)) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    private static boolean h(List<View> list, View view, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (list.get(i3) == view) {
                return true;
            }
        }
        return false;
    }

    static String i(Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    protected static boolean l(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object B(Object obj);

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    void f(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
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
                f(arrayList, viewGroup.getChildAt(i2));
            }
        }
    }

    public abstract Object g(Object obj);

    void j(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String strG = androidx.core.view.u.G(view);
            if (strG != null) {
                map.put(strG, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    j(map, viewGroup.getChildAt(i2));
                }
            }
        }
    }

    protected void k(View view, Rect rect) {
        if (androidx.core.view.u.N(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            Object parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            int[] iArr = new int[2];
            view.getRootView().getLocationOnScreen(iArr);
            rectF.offset(iArr[0], iArr[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public abstract Object m(Object obj, Object obj2, Object obj3);

    public abstract Object n(Object obj, Object obj2, Object obj3);

    ArrayList<String> o(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = arrayList.get(i2);
            arrayList2.add(androidx.core.view.u.G(view));
            androidx.core.view.u.z0(view, null);
        }
        return arrayList2;
    }

    public abstract void p(Object obj, View view);

    public abstract void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void r(Object obj, View view, ArrayList<View> arrayList);

    void s(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        androidx.core.view.r.a(viewGroup, new c(arrayList, map));
    }

    public abstract void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void u(Object obj, Rect rect);

    public abstract void v(Object obj, View view);

    public void w(Fragment fragment, Object obj, androidx.core.os.b bVar, Runnable runnable) {
        runnable.run();
    }

    void x(View view, ArrayList<View> arrayList, Map<String, String> map) {
        androidx.core.view.r.a(view, new b(arrayList, map));
    }

    void y(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = arrayList.get(i2);
            String strG = androidx.core.view.u.G(view2);
            arrayList4.add(strG);
            if (strG != null) {
                androidx.core.view.u.z0(view2, null);
                String str = map.get(strG);
                for (int i3 = 0; i3 < size; i3++) {
                    if (str.equals(arrayList3.get(i3))) {
                        androidx.core.view.u.z0(arrayList2.get(i3), strG);
                        break;
                    }
                }
            }
        }
        androidx.core.view.r.a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void z(Object obj, View view, ArrayList<View> arrayList);
}
