package io.sentry.android.core.internal.gestures;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.e2;
import io.sentry.j5;
import io.sentry.n1;
import io.sentry.protocol.z;
import io.sentry.r5;
import io.sentry.s3;
import io.sentry.s4;
import io.sentry.t3;
import io.sentry.t5;
import io.sentry.util.v;
import io.sentry.v0;
import io.sentry.v1;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.VisibleForTesting;

/* JADX INFO: compiled from: SentryGestureListener.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class g implements GestureDetector.OnGestureListener {
    private final WeakReference<Activity> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v1 f22147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SentryAndroidOptions f22148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private io.sentry.internal.gestures.b f22149d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private e2 f22150e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f22151f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final b f22152g = new b();

    /* JADX INFO: compiled from: SentryGestureListener.java */
    private static final class b {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private io.sentry.internal.gestures.b f22153b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f22154c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f22155d;

        private b() {
            this.a = null;
            this.f22154c = 0.0f;
            this.f22155d = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String i(MotionEvent motionEvent) {
            float x = motionEvent.getX() - this.f22154c;
            float y = motionEvent.getY() - this.f22155d;
            if (Math.abs(x) > Math.abs(y)) {
                return x > 0.0f ? "right" : "left";
            }
            return y > 0.0f ? "down" : "up";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j() {
            this.f22153b = null;
            this.a = null;
            this.f22154c = 0.0f;
            this.f22155d = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(io.sentry.internal.gestures.b bVar) {
            this.f22153b = bVar;
        }
    }

    public g(Activity activity, v1 v1Var, SentryAndroidOptions sentryAndroidOptions) {
        this.a = new WeakReference<>(activity);
        this.f22147b = v1Var;
        this.f22148c = sentryAndroidOptions;
    }

    private void a(io.sentry.internal.gestures.b bVar, String str, Map<String, Object> map, MotionEvent motionEvent) {
        if (this.f22148c.isEnableUserInteractionBreadcrumbs()) {
            n1 n1Var = new n1();
            n1Var.j("android:motionEvent", motionEvent);
            n1Var.j("android:view", bVar.f());
            this.f22147b.n(v0.r(str, bVar.d(), bVar.a(), bVar.e(), map), n1Var);
        }
    }

    private View d(String str) {
        Activity activity = this.a.get();
        if (activity == null) {
            this.f22148c.getLogger().c(s4.DEBUG, "Activity is null in " + str + ". No breadcrumb captured.", new Object[0]);
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            this.f22148c.getLogger().c(s4.DEBUG, "Window is null in " + str + ". No breadcrumb captured.", new Object[0]);
            return null;
        }
        View decorView = window.getDecorView();
        if (decorView != null) {
            return decorView;
        }
        this.f22148c.getLogger().c(s4.DEBUG, "DecorView is null in " + str + ". No breadcrumb captured.", new Object[0]);
        return null;
    }

    private String e(Activity activity) {
        return activity.getClass().getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(s3 s3Var, e2 e2Var, e2 e2Var2) {
        if (e2Var2 == null) {
            s3Var.z(e2Var);
        } else {
            this.f22148c.getLogger().c(s4.DEBUG, "Transaction '%s' won't be bound to the Scope since there's one already in there.", e2Var.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(s3 s3Var, e2 e2Var) {
        if (e2Var == this.f22150e) {
            s3Var.e();
        }
    }

    private void o(io.sentry.internal.gestures.b bVar, String str) {
        io.sentry.internal.gestures.b bVar2 = this.f22149d;
        if (!this.f22148c.isTracingEnabled() || !this.f22148c.isEnableUserInteractionTracing()) {
            if (bVar.equals(bVar2) && str.equals(this.f22151f)) {
                return;
            }
            v.e(this.f22147b);
            this.f22149d = bVar;
            this.f22151f = str;
            return;
        }
        Activity activity = this.a.get();
        if (activity == null) {
            this.f22148c.getLogger().c(s4.DEBUG, "Activity is null, no transaction captured.", new Object[0]);
            return;
        }
        String strB = bVar.b();
        if (this.f22150e != null) {
            if (bVar.equals(bVar2) && str.equals(this.f22151f) && !this.f22150e.b()) {
                this.f22148c.getLogger().c(s4.DEBUG, "The view with id: " + strB + " already has an ongoing transaction assigned. Rescheduling finish", new Object[0]);
                if (this.f22148c.getIdleTimeout() != null) {
                    this.f22150e.l();
                    return;
                }
                return;
            }
            p(j5.OK);
        }
        t5 t5Var = new t5();
        t5Var.n(true);
        t5Var.k(this.f22148c.getIdleTimeout());
        t5Var.d(true);
        final e2 e2VarL = this.f22147b.l(new r5(e(activity) + "." + strB, z.COMPONENT, "ui.action." + str), t5Var);
        e2VarL.m().m("auto.ui.gesture_listener." + bVar.c());
        this.f22147b.o(new t3() { // from class: io.sentry.android.core.internal.gestures.c
            @Override // io.sentry.t3
            public final void a(s3 s3Var) {
                this.a.k(e2VarL, s3Var);
            }
        });
        this.f22150e = e2VarL;
        this.f22149d = bVar;
        this.f22151f = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void k(final s3 s3Var, final e2 e2Var) {
        s3Var.D(new s3.c() { // from class: io.sentry.android.core.internal.gestures.a
            @Override // io.sentry.s3.c
            public final void a(e2 e2Var2) {
                this.a.g(s3Var, e2Var, e2Var2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void m(final s3 s3Var) {
        s3Var.D(new s3.c() { // from class: io.sentry.android.core.internal.gestures.b
            @Override // io.sentry.s3.c
            public final void a(e2 e2Var) {
                this.a.i(s3Var, e2Var);
            }
        });
    }

    public void n(MotionEvent motionEvent) {
        View viewD = d("onUp");
        io.sentry.internal.gestures.b bVar = this.f22152g.f22153b;
        if (viewD == null || bVar == null) {
            return;
        }
        if (this.f22152g.a == null) {
            this.f22148c.getLogger().c(s4.DEBUG, "Unable to define scroll type. No breadcrumb captured.", new Object[0]);
            return;
        }
        a(bVar, this.f22152g.a, Collections.singletonMap("direction", this.f22152g.i(motionEvent)), motionEvent);
        o(bVar, this.f22152g.a);
        this.f22152g.j();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        this.f22152g.j();
        this.f22152g.f22154c = motionEvent.getX();
        this.f22152g.f22155d = motionEvent.getY();
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.f22152g.a = "swipe";
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        View viewD = d("onScroll");
        if (viewD != null && motionEvent != null && this.f22152g.a == null) {
            io.sentry.internal.gestures.b bVarA = j.a(this.f22148c, viewD, motionEvent.getX(), motionEvent.getY(), io.sentry.internal.gestures.b.a.SCROLLABLE);
            if (bVarA == null) {
                this.f22148c.getLogger().c(s4.DEBUG, "Unable to find scroll target. No breadcrumb captured.", new Object[0]);
                return false;
            }
            this.f22148c.getLogger().c(s4.DEBUG, "Scroll target found: " + bVarA.b(), new Object[0]);
            this.f22152g.k(bVarA);
            this.f22152g.a = "scroll";
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        View viewD = d("onSingleTapUp");
        if (viewD != null && motionEvent != null) {
            io.sentry.internal.gestures.b bVarA = j.a(this.f22148c, viewD, motionEvent.getX(), motionEvent.getY(), io.sentry.internal.gestures.b.a.CLICKABLE);
            if (bVarA == null) {
                this.f22148c.getLogger().c(s4.DEBUG, "Unable to find click target. No breadcrumb captured.", new Object[0]);
                return false;
            }
            a(bVarA, "click", Collections.emptyMap(), motionEvent);
            o(bVarA, "click");
        }
        return false;
    }

    void p(j5 j5Var) {
        e2 e2Var = this.f22150e;
        if (e2Var != null) {
            e2Var.d(j5Var);
        }
        this.f22147b.o(new t3() { // from class: io.sentry.android.core.internal.gestures.d
            @Override // io.sentry.t3
            public final void a(s3 s3Var) {
                this.a.m(s3Var);
            }
        });
        this.f22150e = null;
        if (this.f22149d != null) {
            this.f22149d = null;
        }
        this.f22151f = null;
    }
}
