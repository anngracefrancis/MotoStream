package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class ProcessLifecycleOwner implements k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ProcessLifecycleOwner f1734f = new ProcessLifecycleOwner();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Handler f1739k;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1735g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1736h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1737i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1738j = true;
    private final l l = new l(this);
    private Runnable m = new a();
    t.a n = new b();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProcessLifecycleOwner.this.f();
            ProcessLifecycleOwner.this.g();
        }
    }

    class b implements t.a {
        b() {
        }

        @Override // androidx.lifecycle.t.a
        public void a() {
        }

        @Override // androidx.lifecycle.t.a
        public void onResume() {
            ProcessLifecycleOwner.this.b();
        }

        @Override // androidx.lifecycle.t.a
        public void onStart() {
            ProcessLifecycleOwner.this.c();
        }
    }

    class c extends d {

        class a extends d {
            a() {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                ProcessLifecycleOwner.this.b();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                ProcessLifecycleOwner.this.c();
            }
        }

        c() {
        }

        @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 29) {
                t.f(activity).h(ProcessLifecycleOwner.this.n);
            }
        }

        @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            ProcessLifecycleOwner.this.a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            activity.registerActivityLifecycleCallbacks(new a());
        }

        @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            ProcessLifecycleOwner.this.d();
        }
    }

    private ProcessLifecycleOwner() {
    }

    public static k h() {
        return f1734f;
    }

    static void i(Context context) {
        f1734f.e(context);
    }

    void a() {
        int i2 = this.f1736h - 1;
        this.f1736h = i2;
        if (i2 == 0) {
            this.f1739k.postDelayed(this.m, 700L);
        }
    }

    void b() {
        int i2 = this.f1736h + 1;
        this.f1736h = i2;
        if (i2 == 1) {
            if (!this.f1737i) {
                this.f1739k.removeCallbacks(this.m);
            } else {
                this.l.h(g.b.ON_RESUME);
                this.f1737i = false;
            }
        }
    }

    void c() {
        int i2 = this.f1735g + 1;
        this.f1735g = i2;
        if (i2 == 1 && this.f1738j) {
            this.l.h(g.b.ON_START);
            this.f1738j = false;
        }
    }

    void d() {
        this.f1735g--;
        g();
    }

    void e(Context context) {
        this.f1739k = new Handler();
        this.l.h(g.b.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new c());
    }

    void f() {
        if (this.f1736h == 0) {
            this.f1737i = true;
            this.l.h(g.b.ON_PAUSE);
        }
    }

    void g() {
        if (this.f1735g == 0 && this.f1737i) {
            this.l.h(g.b.ON_STOP);
            this.f1738j = true;
        }
    }

    @Override // androidx.lifecycle.k
    public g getLifecycle() {
        return this.l;
    }
}
