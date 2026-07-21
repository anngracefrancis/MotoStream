package c.k.a;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.u;
import java.util.Arrays;

/* JADX INFO: compiled from: ViewDragHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final Interpolator a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3302c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float[] f3304e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float[] f3305f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float[] f3306g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float[] f3307h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int[] f3308i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f3309j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int[] f3310k;
    private int l;
    private VelocityTracker m;
    private float n;
    private float o;
    private int p;
    private int q;
    private OverScroller r;
    private final AbstractC0080c s;
    private View t;
    private boolean u;
    private final ViewGroup v;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3303d = -1;
    private final Runnable w = new b();

    /* JADX INFO: compiled from: ViewDragHelper.java */
    static class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    /* JADX INFO: compiled from: ViewDragHelper.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.E(0);
        }
    }

    /* JADX INFO: renamed from: c.k.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ViewDragHelper.java */
    public static abstract class AbstractC0080c {
        public abstract int a(View view, int i2, int i3);

        public abstract int b(View view, int i2, int i3);

        public int c(int i2) {
            return i2;
        }

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public void f(int i2, int i3) {
        }

        public boolean g(int i2) {
            return false;
        }

        public void h(int i2, int i3) {
        }

        public void i(View view, int i2) {
        }

        public abstract void j(int i2);

        public abstract void k(View view, int i2, int i3, int i4, int i5);

        public abstract void l(View view, float f2, float f3);

        public abstract boolean m(View view, int i2);
    }

    private c(Context context, ViewGroup viewGroup, AbstractC0080c abstractC0080c) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC0080c == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.v = viewGroup;
        this.s = abstractC0080c;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.p = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f3302c = viewConfiguration.getScaledTouchSlop();
        this.n = viewConfiguration.getScaledMaximumFlingVelocity();
        this.o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.r = new OverScroller(context, a);
    }

    private void A() {
        this.m.computeCurrentVelocity(1000, this.n);
        n(e(this.m.getXVelocity(this.f3303d), this.o, this.n), e(this.m.getYVelocity(this.f3303d), this.o, this.n));
    }

    private void B(float f2, float f3, int i2) {
        int i3 = c(f2, f3, i2, 1) ? 1 : 0;
        if (c(f3, f2, i2, 4)) {
            i3 |= 4;
        }
        if (c(f2, f3, i2, 2)) {
            i3 |= 2;
        }
        if (c(f3, f2, i2, 8)) {
            i3 |= 8;
        }
        if (i3 != 0) {
            int[] iArr = this.f3309j;
            iArr[i2] = iArr[i2] | i3;
            this.s.f(i3, i2);
        }
    }

    private void C(float f2, float f3, int i2) {
        q(i2);
        float[] fArr = this.f3304e;
        this.f3306g[i2] = f2;
        fArr[i2] = f2;
        float[] fArr2 = this.f3305f;
        this.f3307h[i2] = f3;
        fArr2[i2] = f3;
        this.f3308i[i2] = t((int) f2, (int) f3);
        this.l |= 1 << i2;
    }

    private void D(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            if (x(pointerId)) {
                float x = motionEvent.getX(i2);
                float y = motionEvent.getY(i2);
                this.f3306g[pointerId] = x;
                this.f3307h[pointerId] = y;
            }
        }
    }

    private boolean c(float f2, float f3, int i2, int i3) {
        float fAbs = Math.abs(f2);
        float fAbs2 = Math.abs(f3);
        if ((this.f3308i[i2] & i3) != i3 || (this.q & i3) == 0 || (this.f3310k[i2] & i3) == i3 || (this.f3309j[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.f3302c;
        if (fAbs <= i4 && fAbs2 <= i4) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.s.g(i3)) {
            return (this.f3309j[i2] & i3) == 0 && fAbs > ((float) this.f3302c);
        }
        int[] iArr = this.f3310k;
        iArr[i2] = iArr[i2] | i3;
        return false;
    }

    private boolean d(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z = this.s.d(view) > 0;
        boolean z2 = this.s.e(view) > 0;
        if (z && z2) {
            float f4 = (f2 * f2) + (f3 * f3);
            int i2 = this.f3302c;
            return f4 > ((float) (i2 * i2));
        }
        if (z) {
            return Math.abs(f2) > ((float) this.f3302c);
        }
        return z2 && Math.abs(f3) > ((float) this.f3302c);
    }

    private float e(float f2, float f3, float f4) {
        float fAbs = Math.abs(f2);
        if (fAbs < f3) {
            return 0.0f;
        }
        if (fAbs > f4) {
            return f2 > 0.0f ? f4 : -f4;
        }
        return f2;
    }

    private int f(int i2, int i3, int i4) {
        int iAbs = Math.abs(i2);
        if (iAbs < i3) {
            return 0;
        }
        if (iAbs > i4) {
            return i2 > 0 ? i4 : -i4;
        }
        return i2;
    }

    private void g() {
        float[] fArr = this.f3304e;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f3305f, 0.0f);
        Arrays.fill(this.f3306g, 0.0f);
        Arrays.fill(this.f3307h, 0.0f);
        Arrays.fill(this.f3308i, 0);
        Arrays.fill(this.f3309j, 0);
        Arrays.fill(this.f3310k, 0);
        this.l = 0;
    }

    private void h(int i2) {
        if (this.f3304e == null || !w(i2)) {
            return;
        }
        this.f3304e[i2] = 0.0f;
        this.f3305f[i2] = 0.0f;
        this.f3306g[i2] = 0.0f;
        this.f3307h[i2] = 0.0f;
        this.f3308i[i2] = 0;
        this.f3309j[i2] = 0;
        this.f3310k[i2] = 0;
        this.l = ((1 << i2) ^ (-1)) & this.l;
    }

    private int i(int i2, int i3, int i4) {
        if (i2 == 0) {
            return 0;
        }
        int width = this.v.getWidth();
        float f2 = width / 2;
        float fO = f2 + (o(Math.min(1.0f, Math.abs(i2) / width)) * f2);
        int iAbs = Math.abs(i3);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fO / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i2) / i4) + 1.0f) * 256.0f), 600);
    }

    private int j(View view, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int iF = f(i4, (int) this.o, (int) this.n);
        int iF2 = f(i5, (int) this.o, (int) this.n);
        int iAbs = Math.abs(i2);
        int iAbs2 = Math.abs(i3);
        int iAbs3 = Math.abs(iF);
        int iAbs4 = Math.abs(iF2);
        int i6 = iAbs3 + iAbs4;
        int i7 = iAbs + iAbs2;
        if (iF != 0) {
            f2 = iAbs3;
            f3 = i6;
        } else {
            f2 = iAbs;
            f3 = i7;
        }
        float f6 = f2 / f3;
        if (iF2 != 0) {
            f4 = iAbs4;
            f5 = i6;
        } else {
            f4 = iAbs2;
            f5 = i7;
        }
        return (int) ((i(i2, iF, this.s.d(view)) * f6) + (i(i3, iF2, this.s.e(view)) * (f4 / f5)));
    }

    public static c l(ViewGroup viewGroup, float f2, AbstractC0080c abstractC0080c) {
        c cVarM = m(viewGroup, abstractC0080c);
        cVarM.f3302c = (int) (cVarM.f3302c * (1.0f / f2));
        return cVarM;
    }

    public static c m(ViewGroup viewGroup, AbstractC0080c abstractC0080c) {
        return new c(viewGroup.getContext(), viewGroup, abstractC0080c);
    }

    private void n(float f2, float f3) {
        this.u = true;
        this.s.l(this.t, f2, f3);
        this.u = false;
        if (this.f3301b == 1) {
            E(0);
        }
    }

    private float o(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    private void p(int i2, int i3, int i4, int i5) {
        int left = this.t.getLeft();
        int top = this.t.getTop();
        if (i4 != 0) {
            i2 = this.s.a(this.t, i2, i4);
            u.T(this.t, i2 - left);
        }
        int i6 = i2;
        if (i5 != 0) {
            i3 = this.s.b(this.t, i3, i5);
            u.U(this.t, i3 - top);
        }
        int i7 = i3;
        if (i4 == 0 && i5 == 0) {
            return;
        }
        this.s.k(this.t, i6, i7, i6 - left, i7 - top);
    }

    private void q(int i2) {
        float[] fArr = this.f3304e;
        if (fArr == null || fArr.length <= i2) {
            int i3 = i2 + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f3305f;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f3306g;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f3307h;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f3308i;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f3309j;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f3310k;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f3304e = fArr2;
            this.f3305f = fArr3;
            this.f3306g = fArr4;
            this.f3307h = fArr5;
            this.f3308i = iArr;
            this.f3309j = iArr2;
            this.f3310k = iArr3;
        }
    }

    private boolean s(int i2, int i3, int i4, int i5) {
        int left = this.t.getLeft();
        int top = this.t.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.r.abortAnimation();
            E(0);
            return false;
        }
        this.r.startScroll(left, top, i6, i7, j(this.t, i6, i7, i4, i5));
        E(2);
        return true;
    }

    private int t(int i2, int i3) {
        int i4 = i2 < this.v.getLeft() + this.p ? 1 : 0;
        if (i3 < this.v.getTop() + this.p) {
            i4 |= 4;
        }
        if (i2 > this.v.getRight() - this.p) {
            i4 |= 2;
        }
        return i3 > this.v.getBottom() - this.p ? i4 | 8 : i4;
    }

    private boolean x(int i2) {
        if (w(i2)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i2 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    void E(int i2) {
        this.v.removeCallbacks(this.w);
        if (this.f3301b != i2) {
            this.f3301b = i2;
            this.s.j(i2);
            if (this.f3301b == 0) {
                this.t = null;
            }
        }
    }

    public boolean F(int i2, int i3) {
        if (this.u) {
            return s(i2, i3, (int) this.m.getXVelocity(this.f3303d), (int) this.m.getYVelocity(this.f3303d));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ff  */
    public boolean G(MotionEvent motionEvent) {
        boolean z;
        View viewR;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.m == null) {
            this.m = VelocityTracker.obtain();
        }
        this.m.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                a();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    a();
                } else if (actionMasked == 5) {
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    float x = motionEvent.getX(actionIndex);
                    float y = motionEvent.getY(actionIndex);
                    C(x, y, pointerId);
                    int i2 = this.f3301b;
                    if (i2 == 0) {
                        int i3 = this.f3308i[pointerId];
                        int i4 = this.q;
                        if ((i3 & i4) != 0) {
                            this.s.h(i3 & i4, pointerId);
                        }
                    } else if (i2 == 2 && (viewR = r((int) x, (int) y)) == this.t) {
                        I(viewR, pointerId);
                    }
                } else if (actionMasked == 6) {
                    h(motionEvent.getPointerId(actionIndex));
                }
            } else if (this.f3304e != null && this.f3305f != null) {
                int pointerCount = motionEvent.getPointerCount();
                for (int i5 = 0; i5 < pointerCount; i5++) {
                    int pointerId2 = motionEvent.getPointerId(i5);
                    if (x(pointerId2)) {
                        float x2 = motionEvent.getX(i5);
                        float y2 = motionEvent.getY(i5);
                        float f2 = x2 - this.f3304e[pointerId2];
                        float f3 = y2 - this.f3305f[pointerId2];
                        View viewR2 = r((int) x2, (int) y2);
                        boolean z2 = viewR2 != null && d(viewR2, f2, f3);
                        if (!z2) {
                            B(f2, f3, pointerId2);
                            if (this.f3301b != 1) {
                                break;
                            }
                        } else {
                            int left = viewR2.getLeft();
                            int i6 = (int) f2;
                            int iA = this.s.a(viewR2, left + i6, i6);
                            int top = viewR2.getTop();
                            int i7 = (int) f3;
                            int iB = this.s.b(viewR2, top + i7, i7);
                            int iD = this.s.d(viewR2);
                            int iE = this.s.e(viewR2);
                            if ((iD == 0 || (iD > 0 && iA == left)) && (iE == 0 || (iE > 0 && iB == top))) {
                                break;
                            }
                            B(f2, f3, pointerId2);
                            if (this.f3301b != 1 || (z2 && I(viewR2, pointerId2))) {
                                break;
                            }
                        }
                    }
                }
                D(motionEvent);
            }
            z = false;
        } else {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            z = false;
            int pointerId3 = motionEvent.getPointerId(0);
            C(x3, y3, pointerId3);
            View viewR3 = r((int) x3, (int) y3);
            if (viewR3 == this.t && this.f3301b == 2) {
                I(viewR3, pointerId3);
            }
            int i8 = this.f3308i[pointerId3];
            int i9 = this.q;
            if ((i8 & i9) != 0) {
                this.s.h(i8 & i9, pointerId3);
            }
        }
        if (this.f3301b == 1) {
            return true;
        }
        return z;
    }

    public boolean H(View view, int i2, int i3) {
        this.t = view;
        this.f3303d = -1;
        boolean zS = s(i2, i3, 0, 0);
        if (!zS && this.f3301b == 0 && this.t != null) {
            this.t = null;
        }
        return zS;
    }

    boolean I(View view, int i2) {
        if (view == this.t && this.f3303d == i2) {
            return true;
        }
        if (view == null || !this.s.m(view, i2)) {
            return false;
        }
        this.f3303d = i2;
        b(view, i2);
        return true;
    }

    public void a() {
        this.f3303d = -1;
        g();
        VelocityTracker velocityTracker = this.m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.m = null;
        }
    }

    public void b(View view, int i2) {
        if (view.getParent() == this.v) {
            this.t = view;
            this.f3303d = i2;
            this.s.i(view, i2);
            E(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.v + ")");
    }

    public boolean k(boolean z) {
        if (this.f3301b == 2) {
            boolean zComputeScrollOffset = this.r.computeScrollOffset();
            int currX = this.r.getCurrX();
            int currY = this.r.getCurrY();
            int left = currX - this.t.getLeft();
            int top = currY - this.t.getTop();
            if (left != 0) {
                u.T(this.t, left);
            }
            if (top != 0) {
                u.U(this.t, top);
            }
            if (left != 0 || top != 0) {
                this.s.k(this.t, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.r.getFinalX() && currY == this.r.getFinalY()) {
                this.r.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z) {
                    this.v.post(this.w);
                } else {
                    E(0);
                }
            }
        }
        return this.f3301b == 2;
    }

    public View r(int i2, int i3) {
        for (int childCount = this.v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.v.getChildAt(this.s.c(childCount));
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public int u() {
        return this.f3302c;
    }

    public boolean v(int i2, int i3) {
        return y(this.t, i2, i3);
    }

    public boolean w(int i2) {
        return ((1 << i2) & this.l) != 0;
    }

    public boolean y(View view, int i2, int i3) {
        return view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom();
    }

    public void z(MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.m == null) {
            this.m = VelocityTracker.obtain();
        }
        this.m.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewR = r((int) x, (int) y);
            C(x, y, pointerId);
            I(viewR, pointerId);
            int i4 = this.f3308i[pointerId];
            int i5 = this.q;
            if ((i4 & i5) != 0) {
                this.s.h(i4 & i5, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f3301b == 1) {
                A();
            }
            a();
            return;
        }
        if (actionMasked == 2) {
            if (this.f3301b == 1) {
                if (x(this.f3303d)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f3303d);
                    float x2 = motionEvent.getX(iFindPointerIndex);
                    float y2 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f3306g;
                    int i6 = this.f3303d;
                    int i7 = (int) (x2 - fArr[i6]);
                    int i8 = (int) (y2 - this.f3307h[i6]);
                    p(this.t.getLeft() + i7, this.t.getTop() + i8, i7, i8);
                    D(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i3 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i3);
                if (x(pointerId2)) {
                    float x3 = motionEvent.getX(i3);
                    float y3 = motionEvent.getY(i3);
                    float f2 = x3 - this.f3304e[pointerId2];
                    float f3 = y3 - this.f3305f[pointerId2];
                    B(f2, f3, pointerId2);
                    if (this.f3301b != 1) {
                        View viewR2 = r((int) x3, (int) y3);
                        if (d(viewR2, f2, f3) && I(viewR2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i3++;
            }
            D(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f3301b == 1) {
                n(0.0f, 0.0f);
            }
            a();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x4 = motionEvent.getX(actionIndex);
            float y4 = motionEvent.getY(actionIndex);
            C(x4, y4, pointerId3);
            if (this.f3301b != 0) {
                if (v((int) x4, (int) y4)) {
                    I(this.t, pointerId3);
                    return;
                }
                return;
            } else {
                I(r((int) x4, (int) y4), pointerId3);
                int i9 = this.f3308i[pointerId3];
                int i10 = this.q;
                if ((i9 & i10) != 0) {
                    this.s.h(i9 & i10, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f3301b == 1 && pointerId4 == this.f3303d) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i3 >= pointerCount2) {
                    i2 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i3);
                if (pointerId5 != this.f3303d) {
                    View viewR3 = r((int) motionEvent.getX(i3), (int) motionEvent.getY(i3));
                    View view = this.t;
                    if (viewR3 == view && I(view, pointerId5)) {
                        i2 = this.f3303d;
                        break;
                    }
                }
                i3++;
            }
            if (i2 == -1) {
                A();
            }
        }
        h(pointerId4);
    }
}
