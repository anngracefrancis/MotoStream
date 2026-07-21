package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: AppCompatTextView.java */
/* JADX INFO: loaded from: classes.dex */
public class t extends TextView implements androidx.core.view.t, androidx.core.widget.m, androidx.core.widget.d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d f635f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final s f636g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final r f637h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Future<c.i.i.c> f638i;

    public t(Context context) {
        this(context, null);
    }

    private void c() {
        Future<c.i.i.c> future = this.f638i;
        if (future != null) {
            try {
                this.f638i = null;
                androidx.core.widget.k.m(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f635f;
        if (dVar != null) {
            dVar.b();
        }
        s sVar = this.f636g;
        if (sVar != null) {
            sVar.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (androidx.core.widget.d.a) {
            return super.getAutoSizeMaxTextSize();
        }
        s sVar = this.f636g;
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
        s sVar = this.f636g;
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
        s sVar = this.f636g;
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
        s sVar = this.f636g;
        return sVar != null ? sVar.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (androidx.core.widget.d.a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        s sVar = this.f636g;
        if (sVar != null) {
            return sVar.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return androidx.core.widget.k.b(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return androidx.core.widget.k.c(this);
    }

    @Override // androidx.core.view.t
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f635f;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f635f;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f636g.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f636g.k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        c();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        r rVar;
        return (Build.VERSION.SDK_INT >= 28 || (rVar = this.f637h) == null) ? super.getTextClassifier() : rVar.a();
    }

    public c.i.i.c.a getTextMetricsParamsCompat() {
        return androidx.core.widget.k.f(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return j.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        s sVar = this.f636g;
        if (sVar != null) {
            sVar.o(z, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        c();
        super.onMeasure(i2, i3);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        s sVar = this.f636g;
        if (sVar == null || androidx.core.widget.d.a || !sVar.l()) {
            return;
        }
        this.f636g.c();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (androidx.core.widget.d.a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        s sVar = this.f636g;
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
        s sVar = this.f636g;
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
        s sVar = this.f636g;
        if (sVar != null) {
            sVar.u(i2);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f635f;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f635f;
        if (dVar != null) {
            dVar.g(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        s sVar = this.f636g;
        if (sVar != null) {
            sVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        s sVar = this.f636g;
        if (sVar != null) {
            sVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        s sVar = this.f636g;
        if (sVar != null) {
            sVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        s sVar = this.f636g;
        if (sVar != null) {
            sVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.k.p(this, callback));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i2);
        } else {
            androidx.core.widget.k.j(this, i2);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i2);
        } else {
            androidx.core.widget.k.k(this, i2);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i2) {
        androidx.core.widget.k.l(this, i2);
    }

    public void setPrecomputedText(c.i.i.c cVar) {
        androidx.core.widget.k.m(this, cVar);
    }

    @Override // androidx.core.view.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f635f;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f635f;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    @Override // androidx.core.widget.m
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f636g.v(colorStateList);
        this.f636g.b();
    }

    @Override // androidx.core.widget.m
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f636g.w(mode);
        this.f636g.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        s sVar = this.f636g;
        if (sVar != null) {
            sVar.q(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        r rVar;
        if (Build.VERSION.SDK_INT >= 28 || (rVar = this.f637h) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            rVar.b(textClassifier);
        }
    }

    public void setTextFuture(Future<c.i.i.c> future) {
        this.f638i = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(c.i.i.c.a aVar) {
        androidx.core.widget.k.o(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i2, float f2) {
        if (androidx.core.widget.d.a) {
            super.setTextSize(i2, f2);
            return;
        }
        s sVar = this.f636g;
        if (sVar != null) {
            sVar.z(i2, f2);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i2) {
        Typeface typefaceA = (typeface == null || i2 <= 0) ? null : c.i.e.d.a(getContext(), typeface, i2);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        super.setTypeface(typeface, i2);
    }

    public t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public t(Context context, AttributeSet attributeSet, int i2) {
        super(n0.b(context), attributeSet, i2);
        l0.a(this, getContext());
        d dVar = new d(this);
        this.f635f = dVar;
        dVar.e(attributeSet, i2);
        s sVar = new s(this);
        this.f636g = sVar;
        sVar.m(attributeSet, i2);
        sVar.b();
        this.f637h = new r(this);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i2 != 0 ? c.a.k.a.a.d(context, i2) : null, i3 != 0 ? c.a.k.a.a.d(context, i3) : null, i4 != 0 ? c.a.k.a.a.d(context, i4) : null, i5 != 0 ? c.a.k.a.a.d(context, i5) : null);
        s sVar = this.f636g;
        if (sVar != null) {
            sVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i2 != 0 ? c.a.k.a.a.d(context, i2) : null, i3 != 0 ? c.a.k.a.a.d(context, i3) : null, i4 != 0 ? c.a.k.a.a.d(context, i4) : null, i5 != 0 ? c.a.k.a.a.d(context, i5) : null);
        s sVar = this.f636g;
        if (sVar != null) {
            sVar.p();
        }
    }
}
