package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: RoundRectDrawable.java */
/* JADX INFO: loaded from: classes.dex */
class f extends Drawable {
    private float a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RectF f686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f688e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ColorStateList f691h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private PorterDuffColorFilter f692i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ColorStateList f693j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f689f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f690g = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PorterDuff.Mode f694k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f685b = new Paint(5);

    f(ColorStateList colorStateList, float f2) {
        this.a = f2;
        e(colorStateList);
        this.f686c = new RectF();
        this.f687d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f691h = colorStateList;
        this.f685b.setColor(colorStateList.getColorForState(getState(), this.f691h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f686c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f687d.set(rect);
        if (this.f689f) {
            this.f687d.inset((int) Math.ceil(g.c(this.f688e, this.a, this.f690g)), (int) Math.ceil(g.d(this.f688e, this.a, this.f690g)));
            this.f686c.set(this.f687d);
        }
    }

    public ColorStateList b() {
        return this.f691h;
    }

    float c() {
        return this.f688e;
    }

    public float d() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f685b;
        if (this.f692i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f692i);
            z = true;
        }
        RectF rectF = this.f686c;
        float f2 = this.a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    void g(float f2, boolean z, boolean z2) {
        if (f2 == this.f688e && this.f689f == z && this.f690g == z2) {
            return;
        }
        this.f688e = f2;
        this.f689f = z;
        this.f690g = z2;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f687d, this.a);
    }

    void h(float f2) {
        if (f2 == this.a) {
            return;
        }
        this.a = f2;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f693j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f691h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f691h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.f685b.getColor();
        if (z) {
            this.f685b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f693j;
        if (colorStateList2 == null || (mode = this.f694k) == null) {
            return z;
        }
        this.f692i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f685b.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f685b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f693j = colorStateList;
        this.f692i = a(colorStateList, this.f694k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f694k = mode;
        this.f692i = a(this.f693j, mode);
        invalidateSelf();
    }
}
