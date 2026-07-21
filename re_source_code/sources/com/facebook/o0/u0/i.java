package com.facebook.o0.u0;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: ViewObserver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f10527f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Map<Integer, i> f10528g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final WeakReference<Activity> f10529h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Handler f10530i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AtomicBoolean f10531j;

    /* JADX INFO: compiled from: ViewObserver.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final void a(Activity activity) {
            m.f(activity, "activity");
            int iHashCode = activity.hashCode();
            Map map = i.f10528g;
            Integer numValueOf = Integer.valueOf(iHashCode);
            Object iVar = map.get(numValueOf);
            if (iVar == null) {
                iVar = new i(activity, null);
                map.put(numValueOf, iVar);
            }
            ((i) iVar).g();
        }

        public final void b(Activity activity) {
            m.f(activity, "activity");
            i iVar = (i) i.f10528g.remove(Integer.valueOf(activity.hashCode()));
            if (iVar == null) {
                return;
            }
            iVar.h();
        }
    }

    private i(Activity activity) {
        this.f10529h = new WeakReference<>(activity);
        this.f10530i = new Handler(Looper.getMainLooper());
        this.f10531j = new AtomicBoolean(false);
    }

    public /* synthetic */ i(Activity activity, kotlin.jvm.internal.g gVar) {
        this(activity);
    }

    private final void e() {
        Runnable runnable = new Runnable() { // from class: com.facebook.o0.u0.b
            @Override // java.lang.Runnable
            public final void run() {
                i.f(this.f10508f);
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            this.f10530i.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(i iVar) {
        m.f(iVar, "this$0");
        try {
            com.facebook.o0.q0.g gVar = com.facebook.o0.q0.g.a;
            View viewE = com.facebook.o0.q0.g.e(iVar.f10529h.get());
            Activity activity = iVar.f10529h.get();
            if (viewE != null && activity != null) {
                g gVar2 = g.a;
                for (View view : g.a(viewE)) {
                    com.facebook.o0.m0.n.d dVar = com.facebook.o0.m0.n.d.a;
                    if (!com.facebook.o0.m0.n.d.g(view)) {
                        g gVar3 = g.a;
                        String strD = g.d(view);
                        if ((strD.length() > 0) && strD.length() <= 300) {
                            j.a aVar = j.f10532f;
                            String localClassName = activity.getLocalClassName();
                            m.e(localClassName, "activity.localClassName");
                            aVar.c(view, viewE, localClassName);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        if (this.f10531j.getAndSet(true)) {
            return;
        }
        com.facebook.o0.q0.g gVar = com.facebook.o0.q0.g.a;
        View viewE = com.facebook.o0.q0.g.e(this.f10529h.get());
        if (viewE == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = viewE.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        if (this.f10531j.getAndSet(false)) {
            com.facebook.o0.q0.g gVar = com.facebook.o0.q0.g.a;
            View viewE = com.facebook.o0.q0.g.e(this.f10529h.get());
            if (viewE == null) {
                return;
            }
            ViewTreeObserver viewTreeObserver = viewE.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        e();
    }
}
