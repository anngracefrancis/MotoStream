package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.u;

/* JADX INFO: compiled from: FastScroller.java */
/* JADX INFO: loaded from: classes.dex */
class g extends RecyclerView.n implements RecyclerView.s {
    private static final int[] a = {R.attr.state_pressed};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f2063b = new int[0];
    final ValueAnimator B;
    int C;
    private final Runnable D;
    private final RecyclerView.t E;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final StateListDrawable f2066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Drawable f2067f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f2068g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f2069h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final StateListDrawable f2070i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Drawable f2071j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f2072k;
    private final int l;
    int m;
    int n;
    float o;
    int p;
    int q;
    float r;
    private RecyclerView u;
    private int s = 0;
    private int t = 0;
    private boolean v = false;
    private boolean w = false;
    private int x = 0;
    private int y = 0;
    private final int[] z = new int[2];
    private final int[] A = new int[2];

    /* JADX INFO: compiled from: FastScroller.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.k(500);
        }
    }

    /* JADX INFO: compiled from: FastScroller.java */
    class b extends RecyclerView.t {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            g.this.v(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    /* JADX INFO: compiled from: FastScroller.java */
    private class c extends AnimatorListenerAdapter {
        private boolean a = false;

        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                this.a = false;
                return;
            }
            if (((Float) g.this.B.getAnimatedValue()).floatValue() == 0.0f) {
                g gVar = g.this;
                gVar.C = 0;
                gVar.s(0);
            } else {
                g gVar2 = g.this;
                gVar2.C = 2;
                gVar2.p();
            }
        }
    }

    /* JADX INFO: compiled from: FastScroller.java */
    private class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            g.this.f2066e.setAlpha(iFloatValue);
            g.this.f2067f.setAlpha(iFloatValue);
            g.this.p();
        }
    }

    g(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.B = valueAnimatorOfFloat;
        this.C = 0;
        this.D = new a();
        this.E = new b();
        this.f2066e = stateListDrawable;
        this.f2067f = drawable;
        this.f2070i = stateListDrawable2;
        this.f2071j = drawable2;
        this.f2068g = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.f2069h = Math.max(i2, drawable.getIntrinsicWidth());
        this.f2072k = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.l = Math.max(i2, drawable2.getIntrinsicWidth());
        this.f2064c = i3;
        this.f2065d = i4;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new c());
        valueAnimatorOfFloat.addUpdateListener(new d());
        d(recyclerView);
    }

    private void e() {
        this.u.removeCallbacks(this.D);
    }

    private void f() {
        this.u.removeItemDecoration(this);
        this.u.removeOnItemTouchListener(this);
        this.u.removeOnScrollListener(this.E);
        e();
    }

    private void g(Canvas canvas) {
        int i2 = this.t;
        int i3 = this.f2072k;
        int i4 = i2 - i3;
        int i5 = this.q;
        int i6 = this.p;
        int i7 = i5 - (i6 / 2);
        this.f2070i.setBounds(0, 0, i6, i3);
        this.f2071j.setBounds(0, 0, this.s, this.l);
        canvas.translate(0.0f, i4);
        this.f2071j.draw(canvas);
        canvas.translate(i7, 0.0f);
        this.f2070i.draw(canvas);
        canvas.translate(-i7, -i4);
    }

    private void h(Canvas canvas) {
        int i2 = this.s;
        int i3 = this.f2068g;
        int i4 = i2 - i3;
        int i5 = this.n;
        int i6 = this.m;
        int i7 = i5 - (i6 / 2);
        this.f2066e.setBounds(0, 0, i3, i6);
        this.f2067f.setBounds(0, 0, this.f2069h, this.t);
        if (!m()) {
            canvas.translate(i4, 0.0f);
            this.f2067f.draw(canvas);
            canvas.translate(0.0f, i7);
            this.f2066e.draw(canvas);
            canvas.translate(-i4, -i7);
            return;
        }
        this.f2067f.draw(canvas);
        canvas.translate(this.f2068g, i7);
        canvas.scale(-1.0f, 1.0f);
        this.f2066e.draw(canvas);
        canvas.scale(1.0f, 1.0f);
        canvas.translate(-this.f2068g, -i7);
    }

    private int[] i() {
        int[] iArr = this.A;
        int i2 = this.f2065d;
        iArr[0] = i2;
        iArr[1] = this.s - i2;
        return iArr;
    }

    private int[] j() {
        int[] iArr = this.z;
        int i2 = this.f2065d;
        iArr[0] = i2;
        iArr[1] = this.t - i2;
        return iArr;
    }

    private void l(float f2) {
        int[] iArrI = i();
        float fMax = Math.max(iArrI[0], Math.min(iArrI[1], f2));
        if (Math.abs(this.q - fMax) < 2.0f) {
            return;
        }
        int iR = r(this.r, fMax, iArrI, this.u.computeHorizontalScrollRange(), this.u.computeHorizontalScrollOffset(), this.s);
        if (iR != 0) {
            this.u.scrollBy(iR, 0);
        }
        this.r = fMax;
    }

    private boolean m() {
        return u.y(this.u) == 1;
    }

    private void q(int i2) {
        e();
        this.u.postDelayed(this.D, i2);
    }

    private int r(float f2, float f3, int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 == 0) {
            return 0;
        }
        int i6 = i2 - i4;
        int i7 = (int) (((f3 - f2) / i5) * i6);
        int i8 = i3 + i7;
        if (i8 >= i6 || i8 < 0) {
            return 0;
        }
        return i7;
    }

    private void t() {
        this.u.addItemDecoration(this);
        this.u.addOnItemTouchListener(this);
        this.u.addOnScrollListener(this.E);
    }

    private void w(float f2) {
        int[] iArrJ = j();
        float fMax = Math.max(iArrJ[0], Math.min(iArrJ[1], f2));
        if (Math.abs(this.n - fMax) < 2.0f) {
            return;
        }
        int iR = r(this.o, fMax, iArrJ, this.u.computeVerticalScrollRange(), this.u.computeVerticalScrollOffset(), this.t);
        if (iR != 0) {
            this.u.scrollBy(0, iR);
        }
        this.o = fMax;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.x == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zO = o(motionEvent.getX(), motionEvent.getY());
            boolean zN = n(motionEvent.getX(), motionEvent.getY());
            if (zO || zN) {
                if (zN) {
                    this.y = 1;
                    this.r = (int) motionEvent.getX();
                } else if (zO) {
                    this.y = 2;
                    this.o = (int) motionEvent.getY();
                }
                s(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.x == 2) {
            this.o = 0.0f;
            this.r = 0.0f;
            s(1);
            this.y = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.x == 2) {
            u();
            if (this.y == 1) {
                l(motionEvent.getX());
            }
            if (this.y == 2) {
                w(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public boolean b(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i2 = this.x;
        if (i2 == 1) {
            boolean zO = o(motionEvent.getX(), motionEvent.getY());
            boolean zN = n(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!zO && !zN) {
                return false;
            }
            if (zN) {
                this.y = 1;
                this.r = (int) motionEvent.getX();
            } else if (zO) {
                this.y = 2;
                this.o = (int) motionEvent.getY();
            }
            s(2);
        } else if (i2 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void c(boolean z) {
    }

    public void d(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.u;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            f();
        }
        this.u = recyclerView;
        if (recyclerView != null) {
            t();
        }
    }

    void k(int i2) {
        int i3 = this.C;
        if (i3 == 1) {
            this.B.cancel();
        } else if (i3 != 2) {
            return;
        }
        this.C = 3;
        ValueAnimator valueAnimator = this.B;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.B.setDuration(i2);
        this.B.start();
    }

    boolean n(float f2, float f3) {
        if (f3 >= this.t - this.f2072k) {
            int i2 = this.q;
            int i3 = this.p;
            if (f2 >= i2 - (i3 / 2) && f2 <= i2 + (i3 / 2)) {
                return true;
            }
        }
        return false;
    }

    boolean o(float f2, float f3) {
        if (!m() ? f2 >= this.s - this.f2068g : f2 <= this.f2068g / 2) {
            int i2 = this.n;
            int i3 = this.m;
            if (f3 >= i2 - (i3 / 2) && f3 <= i2 + (i3 / 2)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        if (this.s != this.u.getWidth() || this.t != this.u.getHeight()) {
            this.s = this.u.getWidth();
            this.t = this.u.getHeight();
            s(0);
        } else if (this.C != 0) {
            if (this.v) {
                h(canvas);
            }
            if (this.w) {
                g(canvas);
            }
        }
    }

    void p() {
        this.u.invalidate();
    }

    void s(int i2) {
        if (i2 == 2 && this.x != 2) {
            this.f2066e.setState(a);
            e();
        }
        if (i2 == 0) {
            p();
        } else {
            u();
        }
        if (this.x == 2 && i2 != 2) {
            this.f2066e.setState(f2063b);
            q(1200);
        } else if (i2 == 1) {
            q(1500);
        }
        this.x = i2;
    }

    public void u() {
        int i2 = this.C;
        if (i2 != 0) {
            if (i2 != 3) {
                return;
            } else {
                this.B.cancel();
            }
        }
        this.C = 1;
        ValueAnimator valueAnimator = this.B;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.B.setDuration(500L);
        this.B.setStartDelay(0L);
        this.B.start();
    }

    void v(int i2, int i3) {
        int iComputeVerticalScrollRange = this.u.computeVerticalScrollRange();
        int i4 = this.t;
        this.v = iComputeVerticalScrollRange - i4 > 0 && i4 >= this.f2064c;
        int iComputeHorizontalScrollRange = this.u.computeHorizontalScrollRange();
        int i5 = this.s;
        boolean z = iComputeHorizontalScrollRange - i5 > 0 && i5 >= this.f2064c;
        this.w = z;
        boolean z2 = this.v;
        if (!z2 && !z) {
            if (this.x != 0) {
                s(0);
                return;
            }
            return;
        }
        if (z2) {
            float f2 = i4;
            this.n = (int) ((f2 * (i3 + (f2 / 2.0f))) / iComputeVerticalScrollRange);
            this.m = Math.min(i4, (i4 * i4) / iComputeVerticalScrollRange);
        }
        if (this.w) {
            float f3 = i5;
            this.q = (int) ((f3 * (i2 + (f3 / 2.0f))) / iComputeHorizontalScrollRange);
            this.p = Math.min(i5, (i5 * i5) / iComputeHorizontalScrollRange);
        }
        int i6 = this.x;
        if (i6 == 0 || i6 == 1) {
            s(1);
        }
    }
}
