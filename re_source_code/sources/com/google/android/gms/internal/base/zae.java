package com.google.android.gms.internal.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
public final class zae extends Drawable implements Drawable.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f17051f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f17052g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f17053h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f17054i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f17055j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f17056k;
    private boolean l;
    private boolean m;
    private Drawable n;
    private Drawable o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;

    private final boolean a() {
        if (!this.p) {
            this.q = (this.n.getConstantState() == null || this.o.getConstantState() == null) ? false : true;
            this.p = true;
        }
        return this.q;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i2 = this.f17051f;
        boolean z = false;
        if (i2 == 1) {
            this.f17052g = SystemClock.uptimeMillis();
            this.f17051f = 2;
        } else if (i2 == 2 && this.f17052g >= 0) {
            float fUptimeMillis = (SystemClock.uptimeMillis() - this.f17052g) / this.f17055j;
            boolean z2 = fUptimeMillis >= 1.0f;
            if (z2) {
                this.f17051f = 0;
            }
            this.f17056k = (int) ((this.f17053h * Math.min(fUptimeMillis, 1.0f)) + 0.0f);
            z = z2;
        } else {
            z = true;
        }
        int i3 = this.f17056k;
        boolean z3 = this.l;
        Drawable drawable = this.n;
        Drawable drawable2 = this.o;
        if (z) {
            if (!z3 || i3 == 0) {
                drawable.draw(canvas);
            }
            int i4 = this.f17054i;
            if (i3 == i4) {
                drawable2.setAlpha(i4);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z3) {
            drawable.setAlpha(this.f17054i - i3);
        }
        drawable.draw(canvas);
        if (z3) {
            drawable.setAlpha(this.f17054i);
        }
        if (i3 > 0) {
            drawable2.setAlpha(i3);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.f17054i);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        super.getChangingConfigurations();
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!a()) {
            return null;
        }
        getChangingConfigurations();
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return Math.max(this.n.getIntrinsicHeight(), this.o.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.max(this.n.getIntrinsicWidth(), this.o.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (!this.r) {
            this.s = Drawable.resolveOpacity(this.n.getOpacity(), this.o.getOpacity());
            this.r = true;
        }
        return this.s;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.m && super.mutate() == this) {
            if (!a()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.n.mutate();
            this.o.mutate();
            this.m = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected final void onBoundsChange(Rect rect) {
        this.n.setBounds(rect);
        this.o.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        if (this.f17056k == this.f17054i) {
            this.f17056k = i2;
        }
        this.f17054i = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.n.setColorFilter(colorFilter);
        this.o.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
