package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* JADX INFO: compiled from: AppCompatSeekBarHelper.java */
/* JADX INFO: loaded from: classes.dex */
class q extends o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SeekBar f599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f600e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ColorStateList f601f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f602g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f603h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f604i;

    q(SeekBar seekBar) {
        super(seekBar);
        this.f601f = null;
        this.f602g = null;
        this.f603h = false;
        this.f604i = false;
        this.f599d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f600e;
        if (drawable != null) {
            if (this.f603h || this.f604i) {
                Drawable drawableR = androidx.core.graphics.drawable.a.r(drawable.mutate());
                this.f600e = drawableR;
                if (this.f603h) {
                    androidx.core.graphics.drawable.a.o(drawableR, this.f601f);
                }
                if (this.f604i) {
                    androidx.core.graphics.drawable.a.p(this.f600e, this.f602g);
                }
                if (this.f600e.isStateful()) {
                    this.f600e.setState(this.f599d.getDrawableState());
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.o
    void c(AttributeSet attributeSet, int i2) {
        super.c(attributeSet, i2);
        Context context = this.f599d.getContext();
        int[] iArr = c.a.j.V;
        q0 q0VarV = q0.v(context, attributeSet, iArr, i2, 0);
        SeekBar seekBar = this.f599d;
        androidx.core.view.u.g0(seekBar, seekBar.getContext(), iArr, attributeSet, q0VarV.r(), i2, 0);
        Drawable drawableH = q0VarV.h(c.a.j.W);
        if (drawableH != null) {
            this.f599d.setThumb(drawableH);
        }
        j(q0VarV.g(c.a.j.X));
        int i3 = c.a.j.Z;
        if (q0VarV.s(i3)) {
            this.f602g = y.e(q0VarV.k(i3, -1), this.f602g);
            this.f604i = true;
        }
        int i4 = c.a.j.Y;
        if (q0VarV.s(i4)) {
            this.f601f = q0VarV.c(i4);
            this.f603h = true;
        }
        q0VarV.w();
        f();
    }

    void g(Canvas canvas) {
        if (this.f600e != null) {
            int max = this.f599d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f600e.getIntrinsicWidth();
                int intrinsicHeight = this.f600e.getIntrinsicHeight();
                int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i3 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f600e.setBounds(-i2, -i3, i2, i3);
                float width = ((this.f599d.getWidth() - this.f599d.getPaddingLeft()) - this.f599d.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f599d.getPaddingLeft(), this.f599d.getHeight() / 2);
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f600e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    void h() {
        Drawable drawable = this.f600e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f599d.getDrawableState())) {
            this.f599d.invalidateDrawable(drawable);
        }
    }

    void i() {
        Drawable drawable = this.f600e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void j(Drawable drawable) {
        Drawable drawable2 = this.f600e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f600e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f599d);
            androidx.core.graphics.drawable.a.m(drawable, androidx.core.view.u.y(this.f599d));
            if (drawable.isStateful()) {
                drawable.setState(this.f599d.getDrawableState());
            }
            f();
        }
        this.f599d.invalidate();
    }
}
