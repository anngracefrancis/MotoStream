package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: compiled from: TooltipCompatHandler.java */
/* JADX INFO: loaded from: classes.dex */
class t0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static t0 f639f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static t0 f640g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final View f641h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final CharSequence f642i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f643j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Runnable f644k = new a();
    private final Runnable l = new b();
    private int m;
    private int n;
    private u0 o;
    private boolean p;

    /* JADX INFO: compiled from: TooltipCompatHandler.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t0.this.g(false);
        }
    }

    /* JADX INFO: compiled from: TooltipCompatHandler.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t0.this.c();
        }
    }

    private t0(View view, CharSequence charSequence) {
        this.f641h = view;
        this.f642i = charSequence;
        this.f643j = androidx.core.view.v.c(ViewConfiguration.get(view.getContext()));
        b();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void a() {
        this.f641h.removeCallbacks(this.f644k);
    }

    private void b() {
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
    }

    private void d() {
        this.f641h.postDelayed(this.f644k, ViewConfiguration.getLongPressTimeout());
    }

    private static void e(t0 t0Var) {
        t0 t0Var2 = f639f;
        if (t0Var2 != null) {
            t0Var2.a();
        }
        f639f = t0Var;
        if (t0Var != null) {
            t0Var.d();
        }
    }

    public static void f(View view, CharSequence charSequence) {
        t0 t0Var = f639f;
        if (t0Var != null && t0Var.f641h == view) {
            e(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new t0(view, charSequence);
            return;
        }
        t0 t0Var2 = f640g;
        if (t0Var2 != null && t0Var2.f641h == view) {
            t0Var2.c();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    private boolean h(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.m) <= this.f643j && Math.abs(y - this.n) <= this.f643j) {
            return false;
        }
        this.m = x;
        this.n = y;
        return true;
    }

    void c() {
        if (f640g == this) {
            f640g = null;
            u0 u0Var = this.o;
            if (u0Var != null) {
                u0Var.c();
                this.o = null;
                b();
                this.f641h.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f639f == this) {
            e(null);
        }
        this.f641h.removeCallbacks(this.l);
    }

    void g(boolean z) {
        long j2;
        int longPressTimeout;
        long j3;
        if (androidx.core.view.u.N(this.f641h)) {
            e(null);
            t0 t0Var = f640g;
            if (t0Var != null) {
                t0Var.c();
            }
            f640g = this;
            this.p = z;
            u0 u0Var = new u0(this.f641h.getContext());
            this.o = u0Var;
            u0Var.e(this.f641h, this.m, this.n, this.p, this.f642i);
            this.f641h.addOnAttachStateChangeListener(this);
            if (this.p) {
                j3 = 2500;
            } else {
                if ((androidx.core.view.u.H(this.f641h) & 1) == 1) {
                    j2 = 3000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                } else {
                    j2 = 15000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                }
                j3 = j2 - ((long) longPressTimeout);
            }
            this.f641h.removeCallbacks(this.l);
            this.f641h.postDelayed(this.l, j3);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.o != null && this.p) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f641h.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                b();
                c();
            }
        } else if (this.f641h.isEnabled() && this.o == null && h(motionEvent)) {
            e(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.m = view.getWidth() / 2;
        this.n = view.getHeight() / 2;
        g(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        c();
    }
}
