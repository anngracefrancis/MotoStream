package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: FragmentTransition.java */
/* JADX INFO: loaded from: classes.dex */
class v {
    private static final int[] a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final x f1657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final x f1658c;

    /* JADX INFO: compiled from: FragmentTransition.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f1659f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Fragment f1660g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ androidx.core.os.b f1661h;

        a(g gVar, Fragment fragment, androidx.core.os.b bVar) {
            this.f1659f = gVar;
            this.f1660g = fragment;
            this.f1661h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1659f.a(this.f1660g, this.f1661h);
        }
    }

    /* JADX INFO: compiled from: FragmentTransition.java */
    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f1662f;

        b(ArrayList arrayList) {
            this.f1662f = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.A(this.f1662f, 4);
        }
    }

    /* JADX INFO: compiled from: FragmentTransition.java */
    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f1663f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Fragment f1664g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ androidx.core.os.b f1665h;

        c(g gVar, Fragment fragment, androidx.core.os.b bVar) {
            this.f1663f = gVar;
            this.f1664g = fragment;
            this.f1665h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1663f.a(this.f1664g, this.f1665h);
        }
    }

    /* JADX INFO: compiled from: FragmentTransition.java */
    class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f1666f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ x f1667g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f1668h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Fragment f1669i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ ArrayList f1670j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ ArrayList f1671k;
        final /* synthetic */ ArrayList l;
        final /* synthetic */ Object m;

        d(Object obj, x xVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f1666f = obj;
            this.f1667g = xVar;
            this.f1668h = view;
            this.f1669i = fragment;
            this.f1670j = arrayList;
            this.f1671k = arrayList2;
            this.l = arrayList3;
            this.m = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f1666f;
            if (obj != null) {
                this.f1667g.p(obj, this.f1668h);
                this.f1671k.addAll(v.k(this.f1667g, this.f1666f, this.f1669i, this.f1670j, this.f1668h));
            }
            if (this.l != null) {
                if (this.m != null) {
                    ArrayList<View> arrayList = new ArrayList<>();
                    arrayList.add(this.f1668h);
                    this.f1667g.q(this.m, this.l, arrayList);
                }
                this.l.clear();
                this.l.add(this.f1668h);
            }
        }
    }

    /* JADX INFO: compiled from: FragmentTransition.java */
    class e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Fragment f1672f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Fragment f1673g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f1674h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ c.e.a f1675i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ View f1676j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ x f1677k;
        final /* synthetic */ Rect l;

        e(Fragment fragment, Fragment fragment2, boolean z, c.e.a aVar, View view, x xVar, Rect rect) {
            this.f1672f = fragment;
            this.f1673g = fragment2;
            this.f1674h = z;
            this.f1675i = aVar;
            this.f1676j = view;
            this.f1677k = xVar;
            this.l = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.f(this.f1672f, this.f1673g, this.f1674h, this.f1675i, false);
            View view = this.f1676j;
            if (view != null) {
                this.f1677k.k(view, this.l);
            }
        }
    }

    /* JADX INFO: compiled from: FragmentTransition.java */
    class f implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ x f1678f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c.e.a f1679g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Object f1680h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ h f1681i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ ArrayList f1682j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ View f1683k;
        final /* synthetic */ Fragment l;
        final /* synthetic */ Fragment m;
        final /* synthetic */ boolean n;
        final /* synthetic */ ArrayList o;
        final /* synthetic */ Object p;
        final /* synthetic */ Rect q;

        f(x xVar, c.e.a aVar, Object obj, h hVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f1678f = xVar;
            this.f1679g = aVar;
            this.f1680h = obj;
            this.f1681i = hVar;
            this.f1682j = arrayList;
            this.f1683k = view;
            this.l = fragment;
            this.m = fragment2;
            this.n = z;
            this.o = arrayList2;
            this.p = obj2;
            this.q = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.e.a<String, View> aVarH = v.h(this.f1678f, this.f1679g, this.f1680h, this.f1681i);
            if (aVarH != null) {
                this.f1682j.addAll(aVarH.values());
                this.f1682j.add(this.f1683k);
            }
            v.f(this.l, this.m, this.n, aVarH, false);
            Object obj = this.f1680h;
            if (obj != null) {
                this.f1678f.A(obj, this.o, this.f1682j);
                View viewS = v.s(aVarH, this.f1681i, this.p, this.n);
                if (viewS != null) {
                    this.f1678f.k(viewS, this.q);
                }
            }
        }
    }

    /* JADX INFO: compiled from: FragmentTransition.java */
    interface g {
        void a(Fragment fragment, androidx.core.os.b bVar);

        void b(Fragment fragment, androidx.core.os.b bVar);
    }

    /* JADX INFO: compiled from: FragmentTransition.java */
    static class h {
        public Fragment a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public androidx.fragment.app.a f1685c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Fragment f1686d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f1687e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public androidx.fragment.app.a f1688f;

        h() {
        }
    }

    static {
        f1657b = Build.VERSION.SDK_INT >= 21 ? new w() : null;
        f1658c = w();
    }

    static void A(ArrayList<View> arrayList, int i2) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i2);
        }
    }

    static void B(Context context, androidx.fragment.app.f fVar, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, boolean z, g gVar) {
        ViewGroup viewGroup;
        SparseArray sparseArray = new SparseArray();
        for (int i4 = i2; i4 < i3; i4++) {
            androidx.fragment.app.a aVar = arrayList.get(i4);
            if (arrayList2.get(i4).booleanValue()) {
                e(aVar, sparseArray, z);
            } else {
                c(aVar, sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(context);
            int size = sparseArray.size();
            for (int i5 = 0; i5 < size; i5++) {
                int iKeyAt = sparseArray.keyAt(i5);
                c.e.a<String, String> aVarD = d(iKeyAt, arrayList, arrayList2, i2, i3);
                h hVar = (h) sparseArray.valueAt(i5);
                if (fVar.d() && (viewGroup = (ViewGroup) fVar.c(iKeyAt)) != null) {
                    if (z) {
                        o(viewGroup, hVar, view, aVarD, gVar);
                    } else {
                        n(viewGroup, hVar, view, aVarD, gVar);
                    }
                }
            }
        }
    }

    private static void a(ArrayList<View> arrayList, c.e.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View viewN = aVar.n(size);
            if (collection.contains(androidx.core.view.u.G(viewN))) {
                arrayList.add(viewN);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x006e  */
    /* JADX WARN: Code duplicated, block: B:57:0x0070  */
    /* JADX WARN: Code duplicated, block: B:64:0x007f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x0081  */
    /* JADX WARN: Code duplicated, block: B:66:0x0084  */
    /* JADX WARN: Code duplicated, block: B:70:0x008c  */
    /* JADX WARN: Code duplicated, block: B:71:0x008e  */
    private static void b(androidx.fragment.app.a aVar, u.a aVar2, SparseArray<h> sparseArray, boolean z, boolean z2) {
        int i2;
        boolean z3;
        boolean z4;
        boolean z5;
        View view;
        boolean z6;
        Fragment fragment = aVar2.f1650b;
        if (fragment == null || (i2 = fragment.mContainerId) == 0) {
            return;
        }
        int i3 = z ? a[aVar2.a] : aVar2.a;
        boolean z7 = false;
        boolean z8 = true;
        if (i3 == 1) {
            if (z2) {
                z3 = fragment.mIsNewlyAdded;
            } else if (!fragment.mAdded || fragment.mHidden) {
                z3 = false;
            } else {
                z3 = true;
            }
            z7 = z3;
            z4 = false;
            z5 = false;
        } else if (i3 == 3) {
            if (z2 ? !fragment.mAdded || fragment.mHidden : fragment.mAdded || (view = fragment.mView) == null || view.getVisibility() != 0 || fragment.mPostponedAlpha < 0.0f) {
                z6 = false;
            } else {
                z6 = true;
            }
            z5 = z6;
            z4 = true;
            z8 = false;
        } else if (i3 != 4) {
            if (i3 != 5) {
                if (i3 != 6) {
                    if (i3 != 7) {
                        z4 = false;
                        z8 = false;
                    } else {
                        if (z2) {
                            z3 = fragment.mIsNewlyAdded;
                        } else {
                            if (fragment.mAdded) {
                            }
                            z3 = false;
                        }
                        z7 = z3;
                        z4 = false;
                    }
                }
                if (z2) {
                    z6 = false;
                } else {
                    z6 = false;
                }
                z5 = z6;
                z4 = true;
                z8 = false;
            } else {
                if (!z2) {
                    z3 = fragment.mHidden;
                } else if (fragment.mHiddenChanged && !fragment.mHidden && fragment.mAdded) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z7 = z3;
                z4 = false;
            }
            z5 = false;
        } else {
            if (!z2 ? !(!fragment.mAdded || fragment.mHidden) : fragment.mHiddenChanged && fragment.mAdded && fragment.mHidden) {
                z6 = false;
            } else {
                z6 = true;
            }
            z5 = z6;
            z4 = true;
            z8 = false;
        }
        h hVarP = sparseArray.get(i2);
        if (z7) {
            hVarP = p(hVarP, sparseArray, i2);
            hVarP.a = fragment;
            hVarP.f1684b = z;
            hVarP.f1685c = aVar;
        }
        if (!z2 && z8) {
            if (hVarP != null && hVarP.f1686d == fragment) {
                hVarP.f1686d = null;
            }
            if (!aVar.r) {
                FragmentManager fragmentManager = aVar.t;
                fragmentManager.u0().p(fragmentManager.w(fragment));
                fragmentManager.T0(fragment);
            }
        }
        if (z5 && (hVarP == null || hVarP.f1686d == null)) {
            hVarP = p(hVarP, sparseArray, i2);
            hVarP.f1686d = fragment;
            hVarP.f1687e = z;
            hVarP.f1688f = aVar;
        }
        if (z2 || !z4 || hVarP == null || hVarP.a != fragment) {
            return;
        }
        hVarP.a = null;
    }

    public static void c(androidx.fragment.app.a aVar, SparseArray<h> sparseArray, boolean z) {
        int size = aVar.f1641c.size();
        for (int i2 = 0; i2 < size; i2++) {
            b(aVar, aVar.f1641c.get(i2), sparseArray, false, z);
        }
    }

    private static c.e.a<String, String> d(int i2, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        c.e.a<String, String> aVar = new c.e.a<>();
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            androidx.fragment.app.a aVar2 = arrayList.get(i5);
            if (aVar2.C(i2)) {
                boolean zBooleanValue = arrayList2.get(i5).booleanValue();
                ArrayList<String> arrayList5 = aVar2.p;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (zBooleanValue) {
                        arrayList3 = aVar2.p;
                        arrayList4 = aVar2.q;
                    } else {
                        ArrayList<String> arrayList6 = aVar2.p;
                        arrayList3 = aVar2.q;
                        arrayList4 = arrayList6;
                    }
                    for (int i6 = 0; i6 < size; i6++) {
                        String str = arrayList4.get(i6);
                        String str2 = arrayList3.get(i6);
                        String strRemove = aVar.remove(str2);
                        if (strRemove != null) {
                            aVar.put(str, strRemove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static void e(androidx.fragment.app.a aVar, SparseArray<h> sparseArray, boolean z) {
        if (aVar.t.q0().d()) {
            for (int size = aVar.f1641c.size() - 1; size >= 0; size--) {
                b(aVar, aVar.f1641c.get(size), sparseArray, true, z);
            }
        }
    }

    static void f(Fragment fragment, Fragment fragment2, boolean z, c.e.a<String, View> aVar, boolean z2) {
        if ((z ? fragment2.getEnterTransitionCallback() : fragment.getEnterTransitionCallback()) != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList2.add(aVar.j(i2));
                arrayList.add(aVar.n(i2));
            }
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    private static boolean g(x xVar, List<Object> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!xVar.e(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    static c.e.a<String, View> h(x xVar, c.e.a<String, String> aVar, Object obj, h hVar) {
        androidx.core.app.o enterTransitionCallback;
        ArrayList<String> arrayList;
        Fragment fragment = hVar.a;
        View view = fragment.getView();
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        c.e.a<String, View> aVar2 = new c.e.a<>();
        xVar.j(aVar2, view);
        androidx.fragment.app.a aVar3 = hVar.f1685c;
        if (hVar.f1684b) {
            enterTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = aVar3.p;
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = aVar3.q;
        }
        if (arrayList != null) {
            aVar2.p(arrayList);
            aVar2.p(aVar.values());
        }
        if (enterTransitionCallback != null) {
            throw null;
        }
        x(aVar, aVar2);
        return aVar2;
    }

    private static c.e.a<String, View> i(x xVar, c.e.a<String, String> aVar, Object obj, h hVar) {
        androidx.core.app.o exitTransitionCallback;
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = hVar.f1686d;
        c.e.a<String, View> aVar2 = new c.e.a<>();
        xVar.j(aVar2, fragment.requireView());
        androidx.fragment.app.a aVar3 = hVar.f1688f;
        if (hVar.f1687e) {
            exitTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = aVar3.q;
        } else {
            exitTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = aVar3.p;
        }
        if (arrayList != null) {
            aVar2.p(arrayList);
        }
        if (exitTransitionCallback != null) {
            throw null;
        }
        aVar.p(aVar2.keySet());
        return aVar2;
    }

    private static x j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        x xVar = f1657b;
        if (xVar != null && g(xVar, arrayList)) {
            return xVar;
        }
        x xVar2 = f1658c;
        if (xVar2 != null && g(xVar2, arrayList)) {
            return xVar2;
        }
        if (xVar == null && xVar2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    static ArrayList<View> k(x xVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            xVar.f(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        xVar.b(obj, arrayList2);
        return arrayList2;
    }

    private static Object l(x xVar, ViewGroup viewGroup, View view, c.e.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Rect rect;
        Fragment fragment = hVar.a;
        Fragment fragment2 = hVar.f1686d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = hVar.f1684b;
        Object objT = aVar.isEmpty() ? null : t(xVar, fragment, fragment2, z);
        c.e.a<String, View> aVarI = i(xVar, aVar, objT, hVar);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(aVarI.values());
            obj3 = objT;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z, aVarI, true);
        if (obj3 != null) {
            rect = new Rect();
            xVar.z(obj3, view, arrayList);
            z(xVar, obj3, obj2, aVarI, hVar.f1687e, hVar.f1688f);
            if (obj != null) {
                xVar.u(obj, rect);
            }
        } else {
            rect = null;
        }
        androidx.core.view.r.a(viewGroup, new f(xVar, aVar, obj3, hVar, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect));
        return obj3;
    }

    private static Object m(x xVar, ViewGroup viewGroup, View view, c.e.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = hVar.a;
        Fragment fragment2 = hVar.f1686d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = hVar.f1684b;
        Object objT = aVar.isEmpty() ? null : t(xVar, fragment, fragment2, z);
        c.e.a<String, View> aVarI = i(xVar, aVar, objT, hVar);
        c.e.a<String, View> aVarH = h(xVar, aVar, objT, hVar);
        if (aVar.isEmpty()) {
            if (aVarI != null) {
                aVarI.clear();
            }
            if (aVarH != null) {
                aVarH.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, aVarI, aVar.keySet());
            a(arrayList2, aVarH, aVar.values());
            obj3 = objT;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z, aVarI, true);
        if (obj3 != null) {
            arrayList2.add(view);
            xVar.z(obj3, view, arrayList);
            z(xVar, obj3, obj2, aVarI, hVar.f1687e, hVar.f1688f);
            Rect rect2 = new Rect();
            View viewS = s(aVarH, hVar, obj, z);
            if (viewS != null) {
                xVar.u(obj, rect2);
            }
            rect = rect2;
            view2 = viewS;
        } else {
            view2 = null;
            rect = null;
        }
        androidx.core.view.r.a(viewGroup, new e(fragment, fragment2, z, aVarH, view2, xVar, rect));
        return obj3;
    }

    private static void n(ViewGroup viewGroup, h hVar, View view, c.e.a<String, String> aVar, g gVar) {
        Object obj;
        Fragment fragment = hVar.a;
        Fragment fragment2 = hVar.f1686d;
        x xVarJ = j(fragment2, fragment);
        if (xVarJ == null) {
            return;
        }
        boolean z = hVar.f1684b;
        boolean z2 = hVar.f1687e;
        Object objQ = q(xVarJ, fragment, z);
        Object objR = r(xVarJ, fragment2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objL = l(xVarJ, viewGroup, view, aVar, hVar, arrayList, arrayList2, objQ, objR);
        if (objQ == null && objL == null) {
            obj = objR;
            if (obj == null) {
                return;
            }
        } else {
            obj = objR;
        }
        ArrayList<View> arrayListK = k(xVarJ, obj, fragment2, arrayList, view);
        if (arrayListK == null || arrayListK.isEmpty()) {
            obj = null;
        }
        Object obj2 = obj;
        xVarJ.a(objQ, view);
        Object objU = u(xVarJ, objQ, obj2, objL, fragment, hVar.f1684b);
        if (fragment2 != null && arrayListK != null && (arrayListK.size() > 0 || arrayList.size() > 0)) {
            androidx.core.os.b bVar = new androidx.core.os.b();
            gVar.b(fragment2, bVar);
            xVarJ.w(fragment2, objU, bVar, new c(gVar, fragment2, bVar));
        }
        if (objU != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            xVarJ.t(objU, objQ, arrayList3, obj2, arrayListK, objL, arrayList2);
            y(xVarJ, viewGroup, fragment, view, arrayList2, objQ, arrayList3, obj2, arrayListK);
            xVarJ.x(viewGroup, arrayList2, aVar);
            xVarJ.c(viewGroup, objU);
            xVarJ.s(viewGroup, arrayList2, aVar);
        }
    }

    private static void o(ViewGroup viewGroup, h hVar, View view, c.e.a<String, String> aVar, g gVar) {
        Object obj;
        Fragment fragment = hVar.a;
        Fragment fragment2 = hVar.f1686d;
        x xVarJ = j(fragment2, fragment);
        if (xVarJ == null) {
            return;
        }
        boolean z = hVar.f1684b;
        boolean z2 = hVar.f1687e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objQ = q(xVarJ, fragment, z);
        Object objR = r(xVarJ, fragment2, z2);
        Object objM = m(xVarJ, viewGroup, view, aVar, hVar, arrayList2, arrayList, objQ, objR);
        if (objQ == null && objM == null) {
            obj = objR;
            if (obj == null) {
                return;
            }
        } else {
            obj = objR;
        }
        ArrayList<View> arrayListK = k(xVarJ, obj, fragment2, arrayList2, view);
        ArrayList<View> arrayListK2 = k(xVarJ, objQ, fragment, arrayList, view);
        A(arrayListK2, 4);
        Object objU = u(xVarJ, objQ, obj, objM, fragment, z);
        if (fragment2 != null && arrayListK != null && (arrayListK.size() > 0 || arrayList2.size() > 0)) {
            androidx.core.os.b bVar = new androidx.core.os.b();
            gVar.b(fragment2, bVar);
            xVarJ.w(fragment2, objU, bVar, new a(gVar, fragment2, bVar));
        }
        if (objU != null) {
            v(xVarJ, obj, fragment2, arrayListK);
            ArrayList<String> arrayListO = xVarJ.o(arrayList);
            xVarJ.t(objU, objQ, arrayListK2, obj, arrayListK, objM, arrayList);
            xVarJ.c(viewGroup, objU);
            xVarJ.y(viewGroup, arrayList2, arrayList, arrayListO, aVar);
            A(arrayListK2, 0);
            xVarJ.A(objM, arrayList2, arrayList);
        }
    }

    private static h p(h hVar, SparseArray<h> sparseArray, int i2) {
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h();
        sparseArray.put(i2, hVar2);
        return hVar2;
    }

    private static Object q(x xVar, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return xVar.g(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static Object r(x xVar, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return xVar.g(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    static View s(c.e.a<String, View> aVar, h hVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        androidx.fragment.app.a aVar2 = hVar.f1685c;
        if (obj == null || aVar == null || (arrayList = aVar2.p) == null || arrayList.isEmpty()) {
            return null;
        }
        return aVar.get(z ? aVar2.p.get(0) : aVar2.q.get(0));
    }

    private static Object t(x xVar, Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return xVar.B(xVar.g(z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition()));
    }

    private static Object u(x xVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean allowReturnTransitionOverlap;
        if (obj == null || obj2 == null || fragment == null) {
            allowReturnTransitionOverlap = true;
        } else {
            allowReturnTransitionOverlap = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        return allowReturnTransitionOverlap ? xVar.n(obj2, obj, obj3) : xVar.m(obj2, obj, obj3);
    }

    private static void v(x xVar, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            xVar.r(obj, fragment.getView(), arrayList);
            androidx.core.view.r.a(fragment.mContainer, new b(arrayList));
        }
    }

    private static x w() {
        try {
            return (x) Class.forName("c.x.e").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static void x(c.e.a<String, String> aVar, c.e.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.n(size))) {
                aVar.l(size);
            }
        }
    }

    private static void y(x xVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        androidx.core.view.r.a(viewGroup, new d(obj, xVar, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    private static void z(x xVar, Object obj, Object obj2, c.e.a<String, View> aVar, boolean z, androidx.fragment.app.a aVar2) {
        ArrayList<String> arrayList = aVar2.p;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        View view = aVar.get(z ? aVar2.q.get(0) : aVar2.p.get(0));
        xVar.v(obj, view);
        if (obj2 != null) {
            xVar.v(obj2, view);
        }
    }
}
