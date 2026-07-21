package com.facebook.o0.m0;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListView;
import com.facebook.FacebookException;
import com.facebook.a0;
import com.facebook.internal.c0;
import com.facebook.internal.d0;
import com.facebook.internal.h0;
import com.facebook.internal.p0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.text.u;

/* JADX INFO: compiled from: CodelessMatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10273b = j.class.getCanonicalName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static j f10274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f10275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<Activity> f10276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set<c> f10277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private HashSet<String> f10278g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final HashMap<Integer, HashSet<String>> f10279h;

    /* JADX INFO: compiled from: CodelessMatcher.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final synchronized j a() {
            j jVar;
            if (j.f10274c == null) {
                j.f10274c = new j(null);
            }
            jVar = j.f10274c;
            if (jVar == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessMatcher");
            }
            return jVar;
        }

        public final Bundle b(com.facebook.o0.m0.n.a aVar, View view, View view2) {
            List<com.facebook.o0.m0.n.b> listC;
            List<b> listA;
            kotlin.jvm.internal.m.f(view, "rootView");
            kotlin.jvm.internal.m.f(view2, "hostView");
            Bundle bundle = new Bundle();
            if (aVar != null && (listC = aVar.c()) != null) {
                for (com.facebook.o0.m0.n.b bVar : listC) {
                    if (bVar.d() != null) {
                        if (bVar.d().length() > 0) {
                            bundle.putString(bVar.a(), bVar.d());
                        }
                    }
                    if (bVar.b().size() > 0) {
                        if (kotlin.jvm.internal.m.a(bVar.c(), "relative")) {
                            c.a aVar2 = c.f10281f;
                            List<com.facebook.o0.m0.n.c> listB = bVar.b();
                            String simpleName = view2.getClass().getSimpleName();
                            kotlin.jvm.internal.m.e(simpleName, "hostView.javaClass.simpleName");
                            listA = aVar2.a(aVar, view2, listB, 0, -1, simpleName);
                        } else {
                            c.a aVar3 = c.f10281f;
                            List<com.facebook.o0.m0.n.c> listB2 = bVar.b();
                            String simpleName2 = view.getClass().getSimpleName();
                            kotlin.jvm.internal.m.e(simpleName2, "rootView.javaClass.simpleName");
                            listA = aVar3.a(aVar, view, listB2, 0, -1, simpleName2);
                        }
                        for (b bVar2 : listA) {
                            if (bVar2.a() != null) {
                                com.facebook.o0.m0.n.f fVar = com.facebook.o0.m0.n.f.a;
                                String strK = com.facebook.o0.m0.n.f.k(bVar2.a());
                                if (strK.length() > 0) {
                                    bundle.putString(bVar.a(), strK);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            return bundle;
        }
    }

    /* JADX INFO: compiled from: CodelessMatcher.kt */
    public static final class b {
        private final WeakReference<View> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10280b;

        public b(View view, String str) {
            kotlin.jvm.internal.m.f(view, "view");
            kotlin.jvm.internal.m.f(str, "viewMapKey");
            this.a = new WeakReference<>(view);
            this.f10280b = str;
        }

        public final View a() {
            WeakReference<View> weakReference = this.a;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }

        public final String b() {
            return this.f10280b;
        }
    }

    /* JADX INFO: compiled from: CodelessMatcher.kt */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f10281f = new a(null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final WeakReference<View> f10282g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private List<com.facebook.o0.m0.n.a> f10283h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Handler f10284i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final HashSet<String> f10285j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final String f10286k;

        /* JADX INFO: compiled from: CodelessMatcher.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
                this();
            }

            private final List<View> b(ViewGroup viewGroup) {
                ArrayList arrayList = new ArrayList();
                int childCount = viewGroup.getChildCount();
                if (childCount > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2 + 1;
                        View childAt = viewGroup.getChildAt(i2);
                        if (childAt.getVisibility() == 0) {
                            kotlin.jvm.internal.m.e(childAt, "child");
                            arrayList.add(childAt);
                        }
                        if (i3 >= childCount) {
                            break;
                        }
                        i2 = i3;
                    }
                }
                return arrayList;
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0063, code lost:
            
                if (kotlin.jvm.internal.m.a(r9.getClass().getSimpleName(), (java.lang.String) r11.get(r11.size() - 1)) != false) goto L16;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            private final boolean c(android.view.View r9, com.facebook.o0.m0.n.c r10, int r11) {
                /*
                    Method dump skipped, instruction units count: 333
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.o0.m0.j.c.a.c(android.view.View, com.facebook.o0.m0.n.c, int):boolean");
            }

            public final List<b> a(com.facebook.o0.m0.n.a aVar, View view, List<com.facebook.o0.m0.n.c> list, int i2, int i3, String str) {
                List<View> listB;
                int size;
                List<View> listB2;
                int size2;
                kotlin.jvm.internal.m.f(list, "path");
                kotlin.jvm.internal.m.f(str, "mapKey");
                String str2 = str + '.' + i3;
                ArrayList arrayList = new ArrayList();
                if (view == null) {
                    return arrayList;
                }
                if (i2 >= list.size()) {
                    arrayList.add(new b(view, str2));
                } else {
                    com.facebook.o0.m0.n.c cVar = list.get(i2);
                    if (kotlin.jvm.internal.m.a(cVar.a(), "..")) {
                        ViewParent parent = view.getParent();
                        if ((parent instanceof ViewGroup) && (size = (listB = b((ViewGroup) parent)).size()) > 0) {
                            int i4 = 0;
                            while (true) {
                                int i5 = i4 + 1;
                                arrayList.addAll(a(aVar, listB.get(i4), list, i2 + 1, i4, str2));
                                if (i5 >= size) {
                                    break;
                                }
                                i4 = i5;
                            }
                        }
                        return arrayList;
                    }
                    if (kotlin.jvm.internal.m.a(cVar.a(), ".")) {
                        arrayList.add(new b(view, str2));
                        return arrayList;
                    }
                    if (!c(view, cVar, i3)) {
                        return arrayList;
                    }
                    if (i2 == list.size() - 1) {
                        arrayList.add(new b(view, str2));
                    }
                }
                if ((view instanceof ViewGroup) && (size2 = (listB2 = b((ViewGroup) view)).size()) > 0) {
                    int i6 = 0;
                    while (true) {
                        int i7 = i6 + 1;
                        arrayList.addAll(a(aVar, listB2.get(i6), list, i2 + 1, i6, str2));
                        if (i7 >= size2) {
                            break;
                        }
                        i6 = i7;
                    }
                }
                return arrayList;
            }
        }

        public c(View view, Handler handler, HashSet<String> hashSet, String str) {
            kotlin.jvm.internal.m.f(handler, "handler");
            kotlin.jvm.internal.m.f(hashSet, "listenerSet");
            kotlin.jvm.internal.m.f(str, "activityName");
            this.f10282g = new WeakReference<>(view);
            this.f10284i = handler;
            this.f10285j = hashSet;
            this.f10286k = str;
            handler.postDelayed(this, 200L);
        }

        private final void a(b bVar, View view, com.facebook.o0.m0.n.a aVar) {
            if (aVar == null) {
                return;
            }
            try {
                View viewA = bVar.a();
                if (viewA == null) {
                    return;
                }
                com.facebook.o0.m0.n.f fVar = com.facebook.o0.m0.n.f.a;
                View viewA2 = com.facebook.o0.m0.n.f.a(viewA);
                if (viewA2 != null && fVar.p(viewA, viewA2)) {
                    d(bVar, view, aVar);
                    return;
                }
                String name = viewA.getClass().getName();
                kotlin.jvm.internal.m.e(name, "view.javaClass.name");
                if (u.E(name, "com.facebook.react", false, 2, null)) {
                    return;
                }
                if (!(viewA instanceof AdapterView)) {
                    b(bVar, view, aVar);
                } else if (viewA instanceof ListView) {
                    c(bVar, view, aVar);
                }
            } catch (Exception e2) {
                p0 p0Var = p0.a;
                p0.i0(j.f10273b, e2);
            }
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0029  */
        private final void b(b bVar, View view, com.facebook.o0.m0.n.a aVar) {
            boolean z;
            View viewA = bVar.a();
            if (viewA == null) {
                return;
            }
            String strB = bVar.b();
            com.facebook.o0.m0.n.f fVar = com.facebook.o0.m0.n.f.a;
            View.OnClickListener onClickListenerG = com.facebook.o0.m0.n.f.g(viewA);
            if (!(onClickListenerG instanceof h.a)) {
                z = false;
            } else {
                if (onClickListenerG == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnClickListener");
                }
                if (((h.a) onClickListenerG).a()) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (this.f10285j.contains(strB) || z) {
                return;
            }
            h hVar = h.a;
            viewA.setOnClickListener(h.a(aVar, view, viewA));
            this.f10285j.add(strB);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0029  */
        private final void c(b bVar, View view, com.facebook.o0.m0.n.a aVar) {
            boolean z;
            AdapterView adapterView = (AdapterView) bVar.a();
            if (adapterView == null) {
                return;
            }
            String strB = bVar.b();
            AdapterView.OnItemClickListener onItemClickListener = adapterView.getOnItemClickListener();
            if (!(onItemClickListener instanceof h.b)) {
                z = false;
            } else {
                if (onItemClickListener == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnItemClickListener");
                }
                if (((h.b) onItemClickListener).a()) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (this.f10285j.contains(strB) || z) {
                return;
            }
            h hVar = h.a;
            adapterView.setOnItemClickListener(h.b(aVar, view, adapterView));
            this.f10285j.add(strB);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0029  */
        private final void d(b bVar, View view, com.facebook.o0.m0.n.a aVar) {
            boolean z;
            View viewA = bVar.a();
            if (viewA == null) {
                return;
            }
            String strB = bVar.b();
            com.facebook.o0.m0.n.f fVar = com.facebook.o0.m0.n.f.a;
            View.OnTouchListener onTouchListenerH = com.facebook.o0.m0.n.f.h(viewA);
            if (!(onTouchListenerH instanceof k.a)) {
                z = false;
            } else {
                if (onTouchListenerH == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener");
                }
                if (((k.a) onTouchListenerH).a()) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (this.f10285j.contains(strB) || z) {
                return;
            }
            k kVar = k.a;
            viewA.setOnTouchListener(k.a(aVar, view, viewA));
            this.f10285j.add(strB);
        }

        private final void e(com.facebook.o0.m0.n.a aVar, View view) {
            if (aVar == null || view == null) {
                return;
            }
            String strA = aVar.a();
            if ((strA == null || strA.length() == 0) || kotlin.jvm.internal.m.a(aVar.a(), this.f10286k)) {
                List<com.facebook.o0.m0.n.c> listD = aVar.d();
                if (listD.size() > 25) {
                    return;
                }
                Iterator<b> it = f10281f.a(aVar, view, listD, 0, -1, this.f10286k).iterator();
                while (it.hasNext()) {
                    a(it.next(), view, aVar);
                }
            }
        }

        private final void f() {
            List<com.facebook.o0.m0.n.a> list = this.f10283h;
            if (list == null || this.f10282g.get() == null) {
                return;
            }
            int i2 = 0;
            int size = list.size() - 1;
            if (size < 0) {
                return;
            }
            while (true) {
                int i3 = i2 + 1;
                e(list.get(i2), this.f10282g.get());
                if (i3 > size) {
                    return;
                } else {
                    i2 = i3;
                }
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            f();
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            f();
        }

        @Override // java.lang.Runnable
        public void run() {
            View view;
            a0 a0Var = a0.a;
            String strD = a0.d();
            d0 d0Var = d0.a;
            c0 c0VarC = d0.c(strD);
            if (c0VarC == null || !c0VarC.b()) {
                return;
            }
            List<com.facebook.o0.m0.n.a> listB = com.facebook.o0.m0.n.a.a.b(c0VarC.d());
            this.f10283h = listB;
            if (listB == null || (view = this.f10282g.get()) == null) {
                return;
            }
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
                viewTreeObserver.addOnScrollChangedListener(this);
            }
            f();
        }
    }

    private j() {
        this.f10275d = new Handler(Looper.getMainLooper());
        Set<Activity> setNewSetFromMap = Collections.newSetFromMap(new WeakHashMap());
        kotlin.jvm.internal.m.e(setNewSetFromMap, "newSetFromMap(WeakHashMap())");
        this.f10276e = setNewSetFromMap;
        this.f10277f = new LinkedHashSet();
        this.f10278g = new HashSet<>();
        this.f10279h = new HashMap<>();
    }

    public /* synthetic */ j(kotlin.jvm.internal.g gVar) {
        this();
    }

    private final void g() {
        for (Activity activity : this.f10276e) {
            if (activity != null) {
                com.facebook.o0.q0.g gVar = com.facebook.o0.q0.g.a;
                View viewE = com.facebook.o0.q0.g.e(activity);
                String simpleName = activity.getClass().getSimpleName();
                Handler handler = this.f10275d;
                HashSet<String> hashSet = this.f10278g;
                kotlin.jvm.internal.m.e(simpleName, "activityName");
                this.f10277f.add(new c(viewE, handler, hashSet, simpleName));
            }
        }
    }

    private final void i() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            g();
        } else {
            this.f10275d.post(new Runnable() { // from class: com.facebook.o0.m0.d
                @Override // java.lang.Runnable
                public final void run() {
                    j.j(this.f10251f);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(j jVar) {
        kotlin.jvm.internal.m.f(jVar, "this$0");
        jVar.g();
    }

    public final void d(Activity activity) {
        kotlin.jvm.internal.m.f(activity, "activity");
        h0 h0Var = h0.a;
        if (h0.b()) {
            return;
        }
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new FacebookException("Can't add activity to CodelessMatcher on non-UI thread");
        }
        this.f10276e.add(activity);
        this.f10278g.clear();
        HashSet<String> hashSet = this.f10279h.get(Integer.valueOf(activity.hashCode()));
        if (hashSet != null) {
            this.f10278g = hashSet;
        }
        i();
    }

    public final void e(Activity activity) {
        kotlin.jvm.internal.m.f(activity, "activity");
        this.f10279h.remove(Integer.valueOf(activity.hashCode()));
    }

    public final void h(Activity activity) {
        kotlin.jvm.internal.m.f(activity, "activity");
        h0 h0Var = h0.a;
        if (h0.b()) {
            return;
        }
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new FacebookException("Can't remove activity from CodelessMatcher on non-UI thread");
        }
        this.f10276e.remove(activity);
        this.f10277f.clear();
        this.f10279h.put(Integer.valueOf(activity.hashCode()), (HashSet) this.f10278g.clone());
        this.f10278g.clear();
    }
}
