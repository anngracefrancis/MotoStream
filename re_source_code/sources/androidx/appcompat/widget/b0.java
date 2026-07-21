package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* JADX INFO: compiled from: ForwardingListener.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f478f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f479g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f480h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final View f481i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Runnable f482j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Runnable f483k;
    private boolean l;
    private int m;
    private final int[] n = new int[2];

    /* JADX INFO: compiled from: ForwardingListener.java */
    private class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = b0.this.f481i.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: compiled from: ForwardingListener.java */
    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.e();
        }
    }

    public b0(View view) {
        this.f481i = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f478f = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f479g = tapTimeout;
        this.f480h = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void a() {
        Runnable runnable = this.f483k;
        if (runnable != null) {
            this.f481i.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f482j;
        if (runnable2 != null) {
            this.f481i.removeCallbacks(runnable2);
        }
    }

    private boolean f(MotionEvent motionEvent) {
        z zVar;
        View view = this.f481i;
        androidx.appcompat.view.menu.p pVarB = b();
        if (pVarB == null || !pVarB.a() || (zVar = (z) pVarB.j()) == null || !zVar.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, motionEventObtainNoHistory);
        j(zVar, motionEventObtainNoHistory);
        boolean zE = zVar.e(motionEventObtainNoHistory, this.m);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zE && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    private boolean g(MotionEvent motionEvent) {
        View view = this.f481i;
        if (!view.isEnabled()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.m = motionEvent.getPointerId(0);
            if (this.f482j == null) {
                this.f482j = new a();
            }
            view.postDelayed(this.f482j, this.f479g);
            if (this.f483k == null) {
                this.f483k = new b();
            }
            view.postDelayed(this.f483k, this.f480h);
        } else if (actionMasked == 1) {
            a();
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.m);
            if (iFindPointerIndex >= 0 && !h(view, motionEvent.getX(iFindPointerIndex), motionEvent.getY(iFindPointerIndex), this.f478f)) {
                a();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
        } else if (actionMasked == 3) {
            a();
        }
        return false;
    }

    private static boolean h(View view, float f2, float f3, float f4) {
        float f5 = -f4;
        return f2 >= f5 && f3 >= f5 && f2 < ((float) (view.getRight() - view.getLeft())) + f4 && f3 < ((float) (view.getBottom() - view.getTop())) + f4;
    }

    private boolean i(View view, MotionEvent motionEvent) {
        int[] iArr = this.n;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(iArr[0], iArr[1]);
        return true;
    }

    private boolean j(View view, MotionEvent motionEvent) {
        int[] iArr = this.n;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(-iArr[0], -iArr[1]);
        return true;
    }

    public abstract androidx.appcompat.view.menu.p b();

    protected abstract boolean c();

    protected boolean d() {
        androidx.appcompat.view.menu.p pVarB = b();
        if (pVarB == null || !pVarB.a()) {
            return true;
        }
        pVarB.dismiss();
        return true;
    }

    void e() {
        a();
        View view = this.f481i;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.l = true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.l;
        if (z2) {
            z = f(motionEvent) || !d();
        } else {
            z = g(motionEvent) && c();
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f481i.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.l = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.l = false;
        this.m = -1;
        Runnable runnable = this.f482j;
        if (runnable != null) {
            this.f481i.removeCallbacks(runnable);
        }
    }
}
