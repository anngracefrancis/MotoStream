package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import e.e.b.c.a0.k;

/* JADX INFO: compiled from: CutoutDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
class c extends e.e.b.c.a0.g {
    private final Paint D;
    private final RectF E;
    private int F;

    c() {
        this(null);
    }

    private void m0(Canvas canvas) {
        if (t0(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.F);
    }

    private void n0(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (!t0(callback)) {
            p0(canvas);
            return;
        }
        View view = (View) callback;
        if (view.getLayerType() != 2) {
            view.setLayerType(2, null);
        }
    }

    private void p0(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.F = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        } else {
            this.F = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
        }
    }

    private void s0() {
        this.D.setStyle(Paint.Style.FILL_AND_STROKE);
        this.D.setColor(-1);
        this.D.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private boolean t0(Drawable.Callback callback) {
        return callback instanceof View;
    }

    @Override // e.e.b.c.a0.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        n0(canvas);
        super.draw(canvas);
        canvas.drawRect(this.E, this.D);
        m0(canvas);
    }

    boolean l0() {
        return !this.E.isEmpty();
    }

    void o0() {
        q0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    void q0(float f2, float f3, float f4, float f5) {
        RectF rectF = this.E;
        if (f2 == rectF.left && f3 == rectF.top && f4 == rectF.right && f5 == rectF.bottom) {
            return;
        }
        rectF.set(f2, f3, f4, f5);
        invalidateSelf();
    }

    void r0(RectF rectF) {
        q0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    c(k kVar) {
        super(kVar == null ? new k() : kVar);
        this.D = new Paint(1);
        s0();
        this.E = new RectF();
    }
}
