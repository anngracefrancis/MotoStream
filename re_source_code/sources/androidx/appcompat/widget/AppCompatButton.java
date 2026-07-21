package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatButton extends Button implements androidx.core.view.t, androidx.core.widget.d, androidx.core.widget.m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d f387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final s f388g;

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.q);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f387f;
        if (dVar != null) {
            dVar.b();
        }
        s sVar = this.f388g;
        if (sVar != null) {
            sVar.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (androidx.core.widget.d.a) {
            return super.getAutoSizeMaxTextSize();
        }
        s sVar = this.f388g;
        if (sVar != null) {
            return sVar.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (androidx.core.widget.d.a) {
            return super.getAutoSizeMinTextSize();
        }
        s sVar = this.f388g;
        if (sVar != null) {
            return sVar.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (androidx.core.widget.d.a) {
            return super.getAutoSizeStepGranularity();
        }
        s sVar = this.f388g;
        if (sVar != null) {
            return sVar.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (androidx.core.widget.d.a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        s sVar = this.f388g;
        return sVar != null ? sVar.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (androidx.core.widget.d.a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        s sVar = this.f388g;
        if (sVar != null) {
            return sVar.i();
        }
        return 0;
    }

    @Override // androidx.core.view.t
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f387f;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f387f;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f388g.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f388g.k();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        s sVar = this.f388g;
        if (sVar != null) {
            sVar.o(z, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        s sVar = this.f388g;
        if (sVar == null || androidx.core.widget.d.a || !sVar.l()) {
            return;
        }
        this.f388g.c();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (androidx.core.widget.d.a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        s sVar = this.f388g;
        if (sVar != null) {
            sVar.s(i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) throws IllegalArgumentException {
        if (androidx.core.widget.d.a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        s sVar = this.f388g;
        if (sVar != null) {
            sVar.t(iArr, i2);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (androidx.core.widget.d.a) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        s sVar = this.f388g;
        if (sVar != null) {
            sVar.u(i2);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f387f;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f387f;
        if (dVar != null) {
            dVar.g(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.k.p(this, callback));
    }

    public void setSupportAllCaps(boolean z) {
        s sVar = this.f388g;
        if (sVar != null) {
            sVar.r(z);
        }
    }

    @Override // androidx.core.view.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f387f;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f387f;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    @Override // androidx.core.widget.m
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f388g.v(colorStateList);
        this.f388g.b();
    }

    @Override // androidx.core.widget.m
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f388g.w(mode);
        this.f388g.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        s sVar = this.f388g;
        if (sVar != null) {
            sVar.q(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i2, float f2) {
        if (androidx.core.widget.d.a) {
            super.setTextSize(i2, f2);
            return;
        }
        s sVar = this.f388g;
        if (sVar != null) {
            sVar.z(i2, f2);
        }
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i2) {
        super(n0.b(context), attributeSet, i2);
        l0.a(this, getContext());
        d dVar = new d(this);
        this.f387f = dVar;
        dVar.e(attributeSet, i2);
        s sVar = new s(this);
        this.f388g = sVar;
        sVar.m(attributeSet, i2);
        sVar.b();
    }
}
