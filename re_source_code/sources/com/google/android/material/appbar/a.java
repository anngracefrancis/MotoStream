package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.u;

/* JADX INFO: compiled from: HeaderBehavior.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class a<V extends View> extends c<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Runnable f18385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    OverScroller f18386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f18387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f18388g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f18389h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f18390i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private VelocityTracker f18391j;

    /* JADX INFO: renamed from: com.google.android.material.appbar.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HeaderBehavior.java */
    private class RunnableC0192a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final CoordinatorLayout f18392f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final V f18393g;

        RunnableC0192a(CoordinatorLayout coordinatorLayout, V v) {
            this.f18392f = coordinatorLayout;
            this.f18393g = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f18393g == null || (overScroller = a.this.f18386e) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                a.this.N(this.f18392f, this.f18393g);
                return;
            }
            a aVar = a.this;
            aVar.P(this.f18392f, this.f18393g, aVar.f18386e.getCurrY());
            u.a0(this.f18393g, this);
        }
    }

    public a() {
        this.f18388g = -1;
        this.f18390i = -1;
    }

    private void I() {
        if (this.f18391j == null) {
            this.f18391j = VelocityTracker.obtain();
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007b  */
    /* JADX WARN: Code duplicated, block: B:30:0x0085  */
    /* JADX WARN: Code duplicated, block: B:33:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:37:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            VelocityTracker velocityTracker3 = this.f18391j;
            if (velocityTracker3 != null) {
                velocityTracker3.addMovement(motionEvent);
                this.f18391j.computeCurrentVelocity(1000);
                J(coordinatorLayout, v, -L(v), 0, this.f18391j.getYVelocity(this.f18388g));
                z = true;
            }
            this.f18387f = false;
            this.f18388g = -1;
            velocityTracker = this.f18391j;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f18391j = null;
            }
            velocityTracker2 = this.f18391j;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            if (this.f18387f) {
                return true;
            }
        }
        if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f18388g);
            if (iFindPointerIndex == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(iFindPointerIndex);
            int i2 = this.f18389h - y;
            this.f18389h = y;
            O(coordinatorLayout, v, i2, K(v), 0);
        } else if (actionMasked != 3) {
            if (actionMasked == 6) {
                int i3 = motionEvent.getActionIndex() == 0 ? 1 : 0;
                this.f18388g = motionEvent.getPointerId(i3);
                this.f18389h = (int) (motionEvent.getY(i3) + 0.5f);
            }
        }
        z = false;
        velocityTracker2 = this.f18391j;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return !this.f18387f || z;
        z = false;
        this.f18387f = false;
        this.f18388g = -1;
        velocityTracker = this.f18391j;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f18391j = null;
        }
        velocityTracker2 = this.f18391j;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        if (this.f18387f) {
            return true;
        }
    }

    abstract boolean H(V v);

    final boolean J(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, float f2) {
        Runnable runnable = this.f18385d;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.f18385d = null;
        }
        if (this.f18386e == null) {
            this.f18386e = new OverScroller(v.getContext());
        }
        this.f18386e.fling(0, E(), 0, Math.round(f2), 0, 0, i2, i3);
        if (!this.f18386e.computeScrollOffset()) {
            N(coordinatorLayout, v);
            return false;
        }
        RunnableC0192a runnableC0192a = new RunnableC0192a(coordinatorLayout, v);
        this.f18385d = runnableC0192a;
        u.a0(v, runnableC0192a);
        return true;
    }

    abstract int K(V v);

    abstract int L(V v);

    abstract int M();

    abstract void N(CoordinatorLayout coordinatorLayout, V v);

    final int O(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        return Q(coordinatorLayout, v, M() - i2, i3, i4);
    }

    int P(CoordinatorLayout coordinatorLayout, V v, int i2) {
        return Q(coordinatorLayout, v, i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    abstract int Q(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.f18390i < 0) {
            this.f18390i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f18387f) {
            int i2 = this.f18388g;
            if (i2 == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i2)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y - this.f18389h) > this.f18390i) {
                this.f18389h = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f18388g = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            boolean z = H(v) && coordinatorLayout.B(v, x, y2);
            this.f18387f = z;
            if (z) {
                this.f18389h = y2;
                this.f18388g = motionEvent.getPointerId(0);
                I();
                OverScroller overScroller = this.f18386e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f18386e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f18391j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18388g = -1;
        this.f18390i = -1;
    }
}
