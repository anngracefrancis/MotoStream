package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.ScrollView;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@TargetApi(14)
public final class zzua implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f16791f = ((Long) zzyt.e().c(zzacu.P1)).longValue();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f16792g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Application f16793h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final WindowManager f16794i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final PowerManager f16795j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final KeyguardManager f16796k;

    @VisibleForTesting
    private BroadcastReceiver l;
    private WeakReference<ViewTreeObserver> m;
    private WeakReference<View> n;
    private e40 o;
    private zzazj p = new zzazj(f16791f);
    private boolean q = false;
    private int r = -1;
    private final HashSet<zzue> s = new HashSet<>();
    private final DisplayMetrics t;
    private final Rect u;

    public zzua(Context context, View view) {
        Context applicationContext = context.getApplicationContext();
        this.f16792g = applicationContext;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.f16794i = windowManager;
        this.f16795j = (PowerManager) applicationContext.getSystemService("power");
        this.f16796k = (KeyguardManager) context.getSystemService("keyguard");
        if (applicationContext instanceof Application) {
            this.f16793h = (Application) applicationContext;
            this.o = new e40((Application) applicationContext, this);
        }
        this.t = context.getResources().getDisplayMetrics();
        Rect rect = new Rect();
        this.u = rect;
        rect.right = windowManager.getDefaultDisplay().getWidth();
        rect.bottom = windowManager.getDefaultDisplay().getHeight();
        WeakReference<View> weakReference = this.n;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            k(view2);
        }
        this.n = new WeakReference<>(view);
        if (view != null) {
            if (zzk.zzli().b(view)) {
                i(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    private final Rect a(Rect rect) {
        return new Rect(g(rect.left), g(rect.top), g(rect.right), g(rect.bottom));
    }

    private final void b(Activity activity, int i2) {
        Window window;
        if (this.n == null || (window = activity.getWindow()) == null) {
            return;
        }
        View viewPeekDecorView = window.peekDecorView();
        View view = this.n.get();
        if (view == null || viewPeekDecorView == null || view.getRootView() != viewPeekDecorView.getRootView()) {
            return;
        }
        this.r = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(int i2) {
        WeakReference<View> weakReference;
        boolean z;
        boolean z2;
        if (this.s.size() == 0 || (weakReference = this.n) == null) {
            return;
        }
        View view = weakReference.get();
        boolean z3 = i2 == 1;
        boolean z4 = view == null;
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        Rect rect3 = new Rect();
        Rect rect4 = new Rect();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        if (view != null) {
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect2);
            boolean localVisibleRect = view.getLocalVisibleRect(rect3);
            view.getHitRect(rect4);
            try {
                view.getLocationOnScreen(iArr);
                view.getLocationInWindow(iArr2);
            } catch (Exception e2) {
                zzbad.c("Failure getting view location.", e2);
            }
            int i3 = iArr[0];
            rect.left = i3;
            rect.top = iArr[1];
            rect.right = i3 + view.getWidth();
            rect.bottom = rect.top + view.getHeight();
            z = globalVisibleRect;
            z2 = localVisibleRect;
        } else {
            z = false;
            z2 = false;
        }
        List<Rect> listEmptyList = (!((Boolean) zzyt.e().c(zzacu.S1)).booleanValue() || view == null) ? Collections.emptyList() : l(view);
        int windowVisibility = view != null ? view.getWindowVisibility() : 8;
        int i4 = this.r;
        if (i4 != -1) {
            windowVisibility = i4;
        }
        boolean z5 = !z4 && zzk.zzlg().r(view, this.f16795j, this.f16796k) && z && z2 && windowVisibility == 0;
        if (z3 && !this.p.a() && z5 == this.q) {
            return;
        }
        if (z5 || this.q || i2 != 1) {
            zzud zzudVar = new zzud(zzk.zzln().b(), this.f16795j.isScreenOn(), view != null && zzk.zzli().b(view), view != null ? view.getWindowVisibility() : 8, a(this.u), a(rect), a(rect2), z, a(rect3), z2, a(rect4), this.t.density, z5, listEmptyList);
            Iterator<zzue> it = this.s.iterator();
            while (it.hasNext()) {
                it.next().r0(zzudVar);
            }
            this.q = z5;
        }
    }

    private final int g(int i2) {
        return (int) (i2 / this.t.density);
    }

    private final void h() {
        zzk.zzlg();
        zzaxi.a.post(new c40(this));
    }

    private final void i(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.m = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.l == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.l = new d40(this);
            zzk.zzmb().c(this.f16792g, this.l, intentFilter);
        }
        Application application = this.f16793h;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.o);
            } catch (Exception e2) {
                zzbad.c("Error registering activity lifecycle callbacks.", e2);
            }
        }
    }

    private final void k(View view) {
        try {
            WeakReference<ViewTreeObserver> weakReference = this.m;
            if (weakReference != null) {
                ViewTreeObserver viewTreeObserver = weakReference.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.m = null;
            }
        } catch (Exception e2) {
            zzbad.c("Error while unregistering listeners from the last ViewTreeObserver.", e2);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e3) {
            zzbad.c("Error while unregistering listeners from the ViewTreeObserver.", e3);
        }
        if (this.l != null) {
            try {
                zzk.zzmb().b(this.f16792g, this.l);
            } catch (IllegalStateException e4) {
                zzbad.c("Failed trying to unregister the receiver", e4);
            } catch (Exception e5) {
                zzk.zzlk().e(e5, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.l = null;
        }
        Application application = this.f16793h;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.o);
            } catch (Exception e6) {
                zzbad.c("Error registering activity lifecycle callbacks.", e6);
            }
        }
    }

    private final List<Rect> l(View view) {
        try {
            ArrayList arrayList = new ArrayList();
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                View view2 = (View) parent;
                Rect rect = new Rect();
                if ((Build.VERSION.SDK_INT >= 16 ? view2.isScrollContainer() : (view2 instanceof ScrollView) || (view2 instanceof ListView)) && view2.getGlobalVisibleRect(rect)) {
                    arrayList.add(a(rect));
                }
            }
            return arrayList;
        } catch (Exception e2) {
            zzk.zzlk().e(e2, "PositionWatcher.getParentScrollViewRects");
            return Collections.emptyList();
        }
    }

    public final void d(zzue zzueVar) {
        this.s.add(zzueVar);
        f(3);
    }

    public final void e(zzue zzueVar) {
        this.s.remove(zzueVar);
    }

    public final void j(long j2) {
        this.p.b(j2);
    }

    public final void m() {
        this.p.b(f16791f);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        b(activity, 0);
        f(3);
        h();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        f(3);
        h();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        b(activity, 4);
        f(3);
        h();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        b(activity, 0);
        f(3);
        h();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        f(3);
        h();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        b(activity, 0);
        f(3);
        h();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        f(3);
        h();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        f(2);
        h();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        f(1);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.r = -1;
        i(view);
        f(3);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.r = -1;
        f(3);
        h();
        k(view);
    }
}
