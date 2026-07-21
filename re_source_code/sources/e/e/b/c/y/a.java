package e.e.b.c.y;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import e.e.b.c.a0.g;
import e.e.b.c.a0.k;
import e.e.b.c.a0.n;

/* JADX INFO: compiled from: RippleDrawableCompat.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends Drawable implements n, androidx.core.graphics.drawable.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f21098f;

    @Override // android.graphics.drawable.Drawable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a mutate() {
        this.f21098f = new b(this.f21098f);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f21098f;
        if (bVar.f21099b) {
            bVar.a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f21098f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f21098f.a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f21098f.a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.f21098f.a.setState(iArr)) {
            zOnStateChange = true;
        }
        boolean zE = e.e.b.c.y.b.e(iArr);
        b bVar = this.f21098f;
        if (bVar.f21099b == zE) {
            return zOnStateChange;
        }
        bVar.f21099b = zE;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f21098f.a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f21098f.a.setColorFilter(colorFilter);
    }

    @Override // e.e.b.c.a0.n
    public void setShapeAppearanceModel(k kVar) {
        this.f21098f.a.setShapeAppearanceModel(kVar);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i2) {
        this.f21098f.a.setTint(i2);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.f21098f.a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        this.f21098f.a.setTintMode(mode);
    }

    public a(k kVar) {
        this(new b(new g(kVar)));
    }

    /* JADX INFO: compiled from: RippleDrawableCompat.java */
    static final class b extends Drawable.ConstantState {
        g a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f21099b;

        public b(g gVar) {
            this.a = gVar;
            this.f21099b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a newDrawable() {
            return new a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public b(b bVar) {
            this.a = (g) bVar.a.getConstantState().newDrawable();
            this.f21099b = bVar.f21099b;
        }
    }

    private a(b bVar) {
        this.f21098f = bVar;
    }
}
