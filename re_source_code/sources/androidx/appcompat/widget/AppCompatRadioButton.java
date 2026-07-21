package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatRadioButton extends RadioButton implements androidx.core.widget.l, androidx.core.view.t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final g f391f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d f392g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final s f393h;

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.G);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f392g;
        if (dVar != null) {
            dVar.b();
        }
        s sVar = this.f393h;
        if (sVar != null) {
            sVar.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        g gVar = this.f391f;
        return gVar != null ? gVar.b(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // androidx.core.view.t
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f392g;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f392g;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.l
    public ColorStateList getSupportButtonTintList() {
        g gVar = this.f391f;
        if (gVar != null) {
            return gVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        g gVar = this.f391f;
        if (gVar != null) {
            return gVar.d();
        }
        return null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f392g;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f392g;
        if (dVar != null) {
            dVar.g(i2);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        g gVar = this.f391f;
        if (gVar != null) {
            gVar.f();
        }
    }

    @Override // androidx.core.view.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f392g;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f392g;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    @Override // androidx.core.widget.l
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        g gVar = this.f391f;
        if (gVar != null) {
            gVar.g(colorStateList);
        }
    }

    @Override // androidx.core.widget.l
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        g gVar = this.f391f;
        if (gVar != null) {
            gVar.h(mode);
        }
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i2) {
        super(n0.b(context), attributeSet, i2);
        l0.a(this, getContext());
        g gVar = new g(this);
        this.f391f = gVar;
        gVar.e(attributeSet, i2);
        d dVar = new d(this);
        this.f392g = dVar;
        dVar.e(attributeSet, i2);
        s sVar = new s(this);
        this.f393h = sVar;
        sVar.m(attributeSet, i2);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i2) {
        setButtonDrawable(c.a.k.a.a.d(getContext(), i2));
    }
}
