package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class zzeh implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Handler f16206f = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f16207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Application f16208h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final PowerManager f16209i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final KeyguardManager f16210j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzdy f16211k;
    private BroadcastReceiver l;
    private WeakReference<ViewTreeObserver> m;
    private WeakReference<View> n;
    private st o;
    private byte p = -1;
    private int q = -1;
    private long r = -3;

    public zzeh(zzdy zzdyVar, View view) {
        this.f16211k = zzdyVar;
        Context context = zzdyVar.f16182b;
        this.f16207g = context;
        this.f16209i = (PowerManager) context.getSystemService("power");
        this.f16210j = (KeyguardManager) context.getSystemService("keyguard");
        if (context instanceof Application) {
            this.f16208h = (Application) context;
            this.o = new st((Application) context, this);
        }
        f(view);
    }

    private final void a(Activity activity, int i2) {
        Window window;
        if (this.n == null || (window = activity.getWindow()) == null) {
            return;
        }
        View viewPeekDecorView = window.peekDecorView();
        View view = this.n.get();
        if (view == null || viewPeekDecorView == null || view.getRootView() != viewPeekDecorView.getRootView()) {
            return;
        }
        this.q = i2;
    }

    private final void c() {
        f16206f.post(new ry(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:37:0x0065  */
    /* JADX WARN: Code duplicated, block: B:40:0x0069  */
    public final void e() {
        boolean z;
        WeakReference<View> weakReference = this.n;
        if (weakReference == null) {
            return;
        }
        View view = weakReference.get();
        if (view == null) {
            this.r = -3L;
            this.p = (byte) -1;
            return;
        }
        boolean z2 = true;
        byte b2 = view.getVisibility() != 0 ? (byte) 1 : (byte) 0;
        if (!view.isShown()) {
            b2 = (byte) (b2 | 2);
        }
        PowerManager powerManager = this.f16209i;
        if (powerManager != null && !powerManager.isScreenOn()) {
            b2 = (byte) (b2 | 4);
        }
        if (!this.f16211k.y()) {
            KeyguardManager keyguardManager = this.f16210j;
            if (keyguardManager == null || !keyguardManager.inKeyguardRestrictedInputMode()) {
                z2 = false;
            } else {
                Activity activityG = zzef.g(view);
                if (activityG == null) {
                    z = false;
                } else {
                    Window window = activityG.getWindow();
                    WindowManager.LayoutParams attributes = window == null ? null : window.getAttributes();
                    if (attributes == null || (attributes.flags & 524288) == 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                }
                if (!z) {
                    z2 = false;
                }
            }
        }
        if (!z2) {
            b2 = (byte) (b2 | 8);
        }
        if (!view.getGlobalVisibleRect(new Rect())) {
            b2 = (byte) (b2 | 16);
        }
        if (!view.getLocalVisibleRect(new Rect())) {
            b2 = (byte) (b2 | 32);
        }
        int windowVisibility = view.getWindowVisibility();
        int i2 = this.q;
        if (i2 != -1) {
            windowVisibility = i2;
        }
        if (windowVisibility != 0) {
            b2 = (byte) (b2 | 64);
        }
        if (this.p != b2) {
            this.p = b2;
            this.r = b2 == 0 ? SystemClock.elapsedRealtime() : (-3) - ((long) b2);
        }
    }

    private final void g(View view) {
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
            sy syVar = new sy(this);
            this.l = syVar;
            this.f16207g.registerReceiver(syVar, intentFilter);
        }
        Application application = this.f16208h;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.o);
            } catch (Exception unused) {
            }
        }
    }

    private final void h(View view) {
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
        } catch (Exception unused) {
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception unused2) {
        }
        BroadcastReceiver broadcastReceiver = this.l;
        if (broadcastReceiver != null) {
            try {
                this.f16207g.unregisterReceiver(broadcastReceiver);
            } catch (Exception unused3) {
            }
            this.l = null;
        }
        Application application = this.f16208h;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.o);
            } catch (Exception unused4) {
            }
        }
    }

    public final long d() {
        if (this.r <= -2 && this.n.get() == null) {
            this.r = -3L;
        }
        return this.r;
    }

    final void f(View view) {
        WeakReference<View> weakReference = this.n;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            h(view2);
        }
        this.n = new WeakReference<>(view);
        if (view == null) {
            this.r = -3L;
            return;
        }
        if ((view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true) {
            g(view);
        }
        view.addOnAttachStateChangeListener(this);
        this.r = -2L;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, 0);
        e();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        e();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity, 4);
        e();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity, 0);
        e();
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        e();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity, 0);
        e();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        e();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        e();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        e();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.q = -1;
        g(view);
        e();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.q = -1;
        e();
        c();
        h(view);
    }
}
