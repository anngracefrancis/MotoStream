package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: RoundRectDrawableWithShadow.java */
/* JADX INFO: loaded from: classes.dex */
class g extends Drawable {
    private static final double a = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static a f695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f696c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Paint f698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Paint f699f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final RectF f700g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f701h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Path f702i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f703j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f704k;
    private float l;
    private ColorStateList m;
    private final int o;
    private final int p;
    private boolean n = true;
    private boolean q = true;
    private boolean r = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Paint f697d = new Paint(5);

    /* JADX INFO: compiled from: RoundRectDrawableWithShadow.java */
    interface a {
        void a(Canvas canvas, RectF rectF, float f2, Paint paint);
    }

    g(Resources resources, ColorStateList colorStateList, float f2, float f3, float f4) {
        this.o = resources.getColor(c.d.b.f2897d);
        this.p = resources.getColor(c.d.b.f2896c);
        this.f696c = resources.getDimensionPixelSize(c.d.c.a);
        n(colorStateList);
        Paint paint = new Paint(5);
        this.f698e = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f701h = (int) (f2 + 0.5f);
        this.f700g = new RectF();
        Paint paint2 = new Paint(this.f698e);
        this.f699f = paint2;
        paint2.setAntiAlias(false);
        s(f3, f4);
    }

    private void a(Rect rect) {
        float f2 = this.f703j;
        float f3 = 1.5f * f2;
        this.f700g.set(rect.left + f2, rect.top + f3, rect.right - f2, rect.bottom - f3);
        b();
    }

    private void b() {
        float f2 = this.f701h;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        RectF rectF2 = new RectF(rectF);
        float f3 = this.f704k;
        rectF2.inset(-f3, -f3);
        Path path = this.f702i;
        if (path == null) {
            this.f702i = new Path();
        } else {
            path.reset();
        }
        this.f702i.setFillType(Path.FillType.EVEN_ODD);
        this.f702i.moveTo(-this.f701h, 0.0f);
        this.f702i.rLineTo(-this.f704k, 0.0f);
        this.f702i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f702i.arcTo(rectF, 270.0f, -90.0f, false);
        this.f702i.close();
        float f4 = this.f701h;
        float f5 = f4 / (this.f704k + f4);
        Paint paint = this.f698e;
        float f6 = this.f701h + this.f704k;
        int i2 = this.o;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f6, new int[]{i2, i2, this.p}, new float[]{0.0f, f5, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f699f;
        float f7 = this.f701h;
        float f8 = this.f704k;
        int i3 = this.o;
        paint2.setShader(new LinearGradient(0.0f, (-f7) + f8, 0.0f, (-f7) - f8, new int[]{i3, i3, this.p}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f699f.setAntiAlias(false);
    }

    static float c(float f2, float f3, boolean z) {
        if (!z) {
            return f2;
        }
        double d2 = f2;
        double d3 = 1.0d - a;
        double d4 = f3;
        Double.isNaN(d4);
        Double.isNaN(d2);
        return (float) (d2 + (d3 * d4));
    }

    static float d(float f2, float f3, boolean z) {
        if (!z) {
            return f2 * 1.5f;
        }
        double d2 = f2 * 1.5f;
        double d3 = 1.0d - a;
        double d4 = f3;
        Double.isNaN(d4);
        Double.isNaN(d2);
        return (float) (d2 + (d3 * d4));
    }

    private void e(Canvas canvas) {
        float f2 = this.f701h;
        float f3 = (-f2) - this.f704k;
        float f4 = f2 + this.f696c + (this.l / 2.0f);
        float f5 = f4 * 2.0f;
        boolean z = this.f700g.width() - f5 > 0.0f;
        boolean z2 = this.f700g.height() - f5 > 0.0f;
        int iSave = canvas.save();
        RectF rectF = this.f700g;
        canvas.translate(rectF.left + f4, rectF.top + f4);
        canvas.drawPath(this.f702i, this.f698e);
        if (z) {
            canvas.drawRect(0.0f, f3, this.f700g.width() - f5, -this.f701h, this.f699f);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        RectF rectF2 = this.f700g;
        canvas.translate(rectF2.right - f4, rectF2.bottom - f4);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f702i, this.f698e);
        if (z) {
            canvas.drawRect(0.0f, f3, this.f700g.width() - f5, (-this.f701h) + this.f704k, this.f699f);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        RectF rectF3 = this.f700g;
        canvas.translate(rectF3.left + f4, rectF3.bottom - f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f702i, this.f698e);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.f700g.height() - f5, -this.f701h, this.f699f);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        RectF rectF4 = this.f700g;
        canvas.translate(rectF4.right - f4, rectF4.top + f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f702i, this.f698e);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.f700g.height() - f5, -this.f701h, this.f699f);
        }
        canvas.restoreToCount(iSave4);
    }

    private void n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.m = colorStateList;
        this.f697d.setColor(colorStateList.getColorForState(getState(), this.m.getDefaultColor()));
    }

    private void s(float f2, float f3) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f2 + ". Must be >= 0");
        }
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f3 + ". Must be >= 0");
        }
        float fT = t(f2);
        float fT2 = t(f3);
        if (fT > fT2) {
            if (!this.r) {
                this.r = true;
            }
            fT = fT2;
        }
        if (this.l == fT && this.f703j == fT2) {
            return;
        }
        this.l = fT;
        this.f703j = fT2;
        this.f704k = (int) ((fT * 1.5f) + this.f696c + 0.5f);
        this.n = true;
        invalidateSelf();
    }

    private int t(float f2) {
        int i2 = (int) (f2 + 0.5f);
        return i2 % 2 == 1 ? i2 - 1 : i2;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.n) {
            a(getBounds());
            this.n = false;
        }
        canvas.translate(0.0f, this.l / 2.0f);
        e(canvas);
        canvas.translate(0.0f, (-this.l) / 2.0f);
        f695b.a(canvas, this.f700g, this.f701h, this.f697d);
    }

    ColorStateList f() {
        return this.m;
    }

    float g() {
        return this.f701h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(d(this.f703j, this.f701h, this.q));
        int iCeil2 = (int) Math.ceil(c(this.f703j, this.f701h, this.q));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    void h(Rect rect) {
        getPadding(rect);
    }

    float i() {
        return this.f703j;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.m;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    float j() {
        float f2 = this.f703j;
        return (Math.max(f2, this.f701h + this.f696c + ((f2 * 1.5f) / 2.0f)) * 2.0f) + (((this.f703j * 1.5f) + this.f696c) * 2.0f);
    }

    float k() {
        float f2 = this.f703j;
        return (Math.max(f2, this.f701h + this.f696c + (f2 / 2.0f)) * 2.0f) + ((this.f703j + this.f696c) * 2.0f);
    }

    float l() {
        return this.l;
    }

    void m(boolean z) {
        this.q = z;
        invalidateSelf();
    }

    void o(ColorStateList colorStateList) {
        n(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.n = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.m;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f697d.getColor() == colorForState) {
            return false;
        }
        this.f697d.setColor(colorForState);
        this.n = true;
        invalidateSelf();
        return true;
    }

    void p(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f2 + ". Must be >= 0");
        }
        float f3 = (int) (f2 + 0.5f);
        if (this.f701h == f3) {
            return;
        }
        this.f701h = f3;
        this.n = true;
        invalidateSelf();
    }

    void q(float f2) {
        s(this.l, f2);
    }

    void r(float f2) {
        s(f2, this.f703j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f697d.setAlpha(i2);
        this.f698e.setAlpha(i2);
        this.f699f.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f697d.setColorFilter(colorFilter);
    }
}
