package c.v.a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import c.i.j.i;

/* JADX INFO: compiled from: CircularProgressDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends Drawable implements Animatable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Interpolator f3498f = new LinearInterpolator();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Interpolator f3499g = new c.n.a.a.b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[] f3500h = {-16777216};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final c f3501i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f3502j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Resources f3503k;
    private Animator l;
    float m;
    boolean n;

    /* JADX INFO: compiled from: CircularProgressDrawable.java */
    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ c a;

        a(c cVar) {
            this.a = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b.this.n(fFloatValue, this.a);
            b.this.b(fFloatValue, this.a, false);
            b.this.invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: c.v.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CircularProgressDrawable.java */
    class C0098b implements Animator.AnimatorListener {
        final /* synthetic */ c a;

        C0098b(c cVar) {
            this.a = cVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.this.b(1.0f, this.a, true);
            this.a.A();
            this.a.l();
            b bVar = b.this;
            if (!bVar.n) {
                bVar.m += 1.0f;
                return;
            }
            bVar.n = false;
            animator.cancel();
            animator.setDuration(1332L);
            animator.start();
            this.a.x(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.m = 0.0f;
        }
    }

    /* JADX INFO: compiled from: CircularProgressDrawable.java */
    private static class c {
        final RectF a = new RectF();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Paint f3506b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Paint f3507c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Paint f3508d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f3509e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        float f3510f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        float f3511g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        float f3512h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int[] f3513i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f3514j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        float f3515k;
        float l;
        float m;
        boolean n;
        Path o;
        float p;
        float q;
        int r;
        int s;
        int t;
        int u;

        c() {
            Paint paint = new Paint();
            this.f3506b = paint;
            Paint paint2 = new Paint();
            this.f3507c = paint2;
            Paint paint3 = new Paint();
            this.f3508d = paint3;
            this.f3509e = 0.0f;
            this.f3510f = 0.0f;
            this.f3511g = 0.0f;
            this.f3512h = 5.0f;
            this.p = 1.0f;
            this.t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        void A() {
            this.f3515k = this.f3509e;
            this.l = this.f3510f;
            this.m = this.f3511g;
        }

        void a(Canvas canvas, Rect rect) {
            RectF rectF = this.a;
            float f2 = this.q;
            float fMin = (this.f3512h / 2.0f) + f2;
            if (f2 <= 0.0f) {
                fMin = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.r * this.p) / 2.0f, this.f3512h / 2.0f);
            }
            rectF.set(rect.centerX() - fMin, rect.centerY() - fMin, rect.centerX() + fMin, rect.centerY() + fMin);
            float f3 = this.f3509e;
            float f4 = this.f3511g;
            float f5 = (f3 + f4) * 360.0f;
            float f6 = ((this.f3510f + f4) * 360.0f) - f5;
            this.f3506b.setColor(this.u);
            this.f3506b.setAlpha(this.t);
            float f7 = this.f3512h / 2.0f;
            rectF.inset(f7, f7);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f3508d);
            float f8 = -f7;
            rectF.inset(f8, f8);
            canvas.drawArc(rectF, f5, f6, false, this.f3506b);
            b(canvas, f5, f6, rectF);
        }

        void b(Canvas canvas, float f2, float f3, RectF rectF) {
            if (this.n) {
                Path path = this.o;
                if (path == null) {
                    Path path2 = new Path();
                    this.o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float fMin = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f4 = (this.r * this.p) / 2.0f;
                this.o.moveTo(0.0f, 0.0f);
                this.o.lineTo(this.r * this.p, 0.0f);
                Path path3 = this.o;
                float f5 = this.r;
                float f6 = this.p;
                path3.lineTo((f5 * f6) / 2.0f, this.s * f6);
                this.o.offset((fMin + rectF.centerX()) - f4, rectF.centerY() + (this.f3512h / 2.0f));
                this.o.close();
                this.f3507c.setColor(this.u);
                this.f3507c.setAlpha(this.t);
                canvas.save();
                canvas.rotate(f2 + f3, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.o, this.f3507c);
                canvas.restore();
            }
        }

        int c() {
            return this.t;
        }

        float d() {
            return this.f3510f;
        }

        int e() {
            return this.f3513i[f()];
        }

        int f() {
            return (this.f3514j + 1) % this.f3513i.length;
        }

        float g() {
            return this.f3509e;
        }

        int h() {
            return this.f3513i[this.f3514j];
        }

        float i() {
            return this.l;
        }

        float j() {
            return this.m;
        }

        float k() {
            return this.f3515k;
        }

        void l() {
            t(f());
        }

        void m() {
            this.f3515k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            y(0.0f);
            v(0.0f);
            w(0.0f);
        }

        void n(int i2) {
            this.t = i2;
        }

        void o(float f2, float f3) {
            this.r = (int) f2;
            this.s = (int) f3;
        }

        void p(float f2) {
            if (f2 != this.p) {
                this.p = f2;
            }
        }

        void q(float f2) {
            this.q = f2;
        }

        void r(int i2) {
            this.u = i2;
        }

        void s(ColorFilter colorFilter) {
            this.f3506b.setColorFilter(colorFilter);
        }

        void t(int i2) {
            this.f3514j = i2;
            this.u = this.f3513i[i2];
        }

        void u(int[] iArr) {
            this.f3513i = iArr;
            t(0);
        }

        void v(float f2) {
            this.f3510f = f2;
        }

        void w(float f2) {
            this.f3511g = f2;
        }

        void x(boolean z) {
            if (this.n != z) {
                this.n = z;
            }
        }

        void y(float f2) {
            this.f3509e = f2;
        }

        void z(float f2) {
            this.f3512h = f2;
            this.f3506b.setStrokeWidth(f2);
        }
    }

    public b(Context context) {
        this.f3503k = ((Context) i.c(context)).getResources();
        c cVar = new c();
        this.f3501i = cVar;
        cVar.u(f3500h);
        k(2.5f);
        m();
    }

    private void a(float f2, c cVar) {
        n(f2, cVar);
        float fFloor = (float) (Math.floor(cVar.j() / 0.8f) + 1.0d);
        cVar.y(cVar.k() + (((cVar.i() - 0.01f) - cVar.k()) * f2));
        cVar.v(cVar.i());
        cVar.w(cVar.j() + ((fFloor - cVar.j()) * f2));
    }

    private int c(float f2, int i2, int i3) {
        int i4 = (i2 >> 24) & 255;
        int i5 = (i2 >> 16) & 255;
        int i6 = (i2 >> 8) & 255;
        int i7 = i2 & 255;
        return ((i4 + ((int) ((((i3 >> 24) & 255) - i4) * f2))) << 24) | ((i5 + ((int) ((((i3 >> 16) & 255) - i5) * f2))) << 16) | ((i6 + ((int) ((((i3 >> 8) & 255) - i6) * f2))) << 8) | (i7 + ((int) (f2 * ((i3 & 255) - i7))));
    }

    private void h(float f2) {
        this.f3502j = f2;
    }

    private void i(float f2, float f3, float f4, float f5) {
        c cVar = this.f3501i;
        float f6 = this.f3503k.getDisplayMetrics().density;
        cVar.z(f3 * f6);
        cVar.q(f2 * f6);
        cVar.t(0);
        cVar.o(f4 * f6, f5 * f6);
    }

    private void m() {
        c cVar = this.f3501i;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new a(cVar));
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setInterpolator(f3498f);
        valueAnimatorOfFloat.addListener(new C0098b(cVar));
        this.l = valueAnimatorOfFloat;
    }

    void b(float f2, c cVar, boolean z) {
        float interpolation;
        float interpolation2;
        if (this.n) {
            a(f2, cVar);
            return;
        }
        if (f2 != 1.0f || z) {
            float fJ = cVar.j();
            if (f2 < 0.5f) {
                interpolation = cVar.k();
                interpolation2 = (f3499g.getInterpolation(f2 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float fK = cVar.k() + 0.79f;
                interpolation = fK - (((1.0f - f3499g.getInterpolation((f2 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                interpolation2 = fK;
            }
            float f3 = fJ + (0.20999998f * f2);
            float f4 = (f2 + this.m) * 216.0f;
            cVar.y(interpolation);
            cVar.v(interpolation2);
            cVar.w(f3);
            h(f4);
        }
    }

    public void d(boolean z) {
        this.f3501i.x(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f3502j, bounds.exactCenterX(), bounds.exactCenterY());
        this.f3501i.a(canvas, bounds);
        canvas.restore();
    }

    public void e(float f2) {
        this.f3501i.p(f2);
        invalidateSelf();
    }

    public void f(int... iArr) {
        this.f3501i.u(iArr);
        this.f3501i.t(0);
        invalidateSelf();
    }

    public void g(float f2) {
        this.f3501i.w(f2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f3501i.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.l.isRunning();
    }

    public void j(float f2, float f3) {
        this.f3501i.y(f2);
        this.f3501i.v(f3);
        invalidateSelf();
    }

    public void k(float f2) {
        this.f3501i.z(f2);
        invalidateSelf();
    }

    public void l(int i2) {
        if (i2 == 0) {
            i(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            i(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    void n(float f2, c cVar) {
        if (f2 > 0.75f) {
            cVar.r(c((f2 - 0.75f) / 0.25f, cVar.h(), cVar.e()));
        } else {
            cVar.r(cVar.h());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f3501i.n(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3501i.s(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.l.cancel();
        this.f3501i.A();
        if (this.f3501i.d() != this.f3501i.g()) {
            this.n = true;
            this.l.setDuration(666L);
            this.l.start();
        } else {
            this.f3501i.t(0);
            this.f3501i.m();
            this.l.setDuration(1332L);
            this.l.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.l.cancel();
        h(0.0f);
        this.f3501i.x(false);
        this.f3501i.t(0);
        this.f3501i.m();
        invalidateSelf();
    }
}
