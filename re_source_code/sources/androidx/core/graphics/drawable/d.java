package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: WrappedDrawableApi14.java */
/* JADX INFO: loaded from: classes.dex */
class d extends Drawable implements Drawable.Callback, c, b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final PorterDuff.Mode f977f = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f978g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private PorterDuff.Mode f979h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f980i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    f f981j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f982k;
    Drawable l;

    d(f fVar, Resources resources) {
        this.f981j = fVar;
        e(resources);
    }

    private f d() {
        return new f(this.f981j);
    }

    private void e(Resources resources) {
        Drawable.ConstantState constantState;
        f fVar = this.f981j;
        if (fVar == null || (constantState = fVar.f983b) == null) {
            return;
        }
        a(constantState.newDrawable(resources));
    }

    private boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        f fVar = this.f981j;
        ColorStateList colorStateList = fVar.f984c;
        PorterDuff.Mode mode = fVar.f985d;
        if (colorStateList == null || mode == null) {
            this.f980i = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f980i || colorForState != this.f978g || mode != this.f979h) {
                setColorFilter(colorForState, mode);
                this.f978g = colorForState;
                this.f979h = mode;
                this.f980i = true;
                return true;
            }
        }
        return false;
    }

    @Override // androidx.core.graphics.drawable.c
    public final void a(Drawable drawable) {
        Drawable drawable2 = this.l;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.l = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            f fVar = this.f981j;
            if (fVar != null) {
                fVar.f983b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    @Override // androidx.core.graphics.drawable.c
    public final Drawable b() {
        return this.l;
    }

    protected boolean c() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.l.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        f fVar = this.f981j;
        return changingConfigurations | (fVar != null ? fVar.getChangingConfigurations() : 0) | this.l.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        f fVar = this.f981j;
        if (fVar == null || !fVar.a()) {
            return null;
        }
        this.f981j.a = getChangingConfigurations();
        return this.f981j;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.l.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.l.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.l.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return a.f(this.l);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.l.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.l.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.l.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.l.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.l.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.l.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return a.h(this.l);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        f fVar;
        ColorStateList colorStateList = (!c() || (fVar = this.f981j) == null) ? null : fVar.f984c;
        return (colorStateList != null && colorStateList.isStateful()) || this.l.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.l.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f982k && super.mutate() == this) {
            this.f981j = d();
            Drawable drawable = this.l;
            if (drawable != null) {
                drawable.mutate();
            }
            f fVar = this.f981j;
            if (fVar != null) {
                Drawable drawable2 = this.l;
                fVar.f983b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f982k = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.l;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        return a.m(this.l, i2);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        return this.l.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.l.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        a.j(this.l, z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i2) {
        this.l.setChangingConfigurations(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.l.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.l.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.l.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return f(iArr) || this.l.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.f981j.f984c = colorStateList;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        this.f981j.f985d = mode;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.l.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    d(Drawable drawable) {
        this.f981j = d();
        a(drawable);
    }
}
