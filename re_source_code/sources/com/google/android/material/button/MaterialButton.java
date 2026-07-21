package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.u;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.j;
import e.e.b.c.a0.h;
import e.e.b.c.a0.n;
import e.e.b.c.k;
import e.e.b.c.l;
import e.e.b.c.x.c;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialButton extends AppCompatButton implements Checkable, n {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[] f18508h = {R.attr.state_checkable};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f18509i = {R.attr.state_checked};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f18510j = k.p;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.google.android.material.button.a f18511k;
    private final LinkedHashSet<a> l;
    private b m;
    private PorterDuff.Mode n;
    private ColorStateList o;
    private Drawable p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private int v;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f18512h;

        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void b(Parcel parcel) {
            this.f18512h = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f18512h ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            b(parcel);
        }
    }

    public interface a {
        void a(MaterialButton materialButton, boolean z);
    }

    interface b {
        void a(MaterialButton materialButton, boolean z);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.e.b.c.b.u);
    }

    private boolean b() {
        return u.y(this) == 1;
    }

    private boolean c() {
        com.google.android.material.button.a aVar = this.f18511k;
        return (aVar == null || aVar.m()) ? false : true;
    }

    private void d(boolean z) {
        if (z) {
            androidx.core.widget.k.i(this, this.p, null, null, null);
        } else {
            androidx.core.widget.k.i(this, null, null, this.p, null);
        }
    }

    private void e(boolean z) {
        Drawable drawable = this.p;
        boolean z2 = false;
        if (drawable != null) {
            Drawable drawableMutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
            this.p = drawableMutate;
            androidx.core.graphics.drawable.a.o(drawableMutate, this.o);
            PorterDuff.Mode mode = this.n;
            if (mode != null) {
                androidx.core.graphics.drawable.a.p(this.p, mode);
            }
            int intrinsicWidth = this.q;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.p.getIntrinsicWidth();
            }
            int intrinsicHeight = this.q;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.p.getIntrinsicHeight();
            }
            Drawable drawable2 = this.p;
            int i2 = this.r;
            drawable2.setBounds(i2, 0, intrinsicWidth + i2, intrinsicHeight);
        }
        int i3 = this.v;
        boolean z3 = i3 == 1 || i3 == 2;
        if (z) {
            d(z3);
            return;
        }
        Drawable[] drawableArrA = androidx.core.widget.k.a(this);
        Drawable drawable3 = drawableArrA[0];
        Drawable drawable4 = drawableArrA[2];
        if ((z3 && drawable3 != this.p) || (!z3 && drawable4 != this.p)) {
            z2 = true;
        }
        if (z2) {
            d(z3);
        }
    }

    private void f() {
        if (this.p == null || getLayout() == null) {
            return;
        }
        int i2 = this.v;
        if (i2 == 1 || i2 == 3) {
            this.r = 0;
            e(false);
            return;
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        int iMin = Math.min((int) paint.measureText(string), getLayout().getEllipsizedWidth());
        int intrinsicWidth = this.q;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.p.getIntrinsicWidth();
        }
        int measuredWidth = (((((getMeasuredWidth() - iMin) - u.C(this)) - intrinsicWidth) - this.s) - u.D(this)) / 2;
        if (b() != (this.v == 4)) {
            measuredWidth = -measuredWidth;
        }
        if (this.r != measuredWidth) {
            this.r = measuredWidth;
            e(false);
        }
    }

    private String getA11yClassName() {
        return (a() ? CompoundButton.class : Button.class).getName();
    }

    public boolean a() {
        com.google.android.material.button.a aVar = this.f18511k;
        return aVar != null && aVar.n();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (c()) {
            return this.f18511k.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.p;
    }

    public int getIconGravity() {
        return this.v;
    }

    public int getIconPadding() {
        return this.s;
    }

    public int getIconSize() {
        return this.q;
    }

    public ColorStateList getIconTint() {
        return this.o;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.n;
    }

    public ColorStateList getRippleColor() {
        if (c()) {
            return this.f18511k.f();
        }
        return null;
    }

    public e.e.b.c.a0.k getShapeAppearanceModel() {
        if (c()) {
            return this.f18511k.g();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (c()) {
            return this.f18511k.h();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (c()) {
            return this.f18511k.i();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.t
    public ColorStateList getSupportBackgroundTintList() {
        return c() ? this.f18511k.j() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return c() ? this.f18511k.k() : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.t;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (c()) {
            h.f(this, this.f18511k.d());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (a()) {
            Button.mergeDrawableStates(iArrOnCreateDrawableState, f18508h);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(iArrOnCreateDrawableState, f18509i);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        com.google.android.material.button.a aVar;
        super.onLayout(z, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT != 21 || (aVar = this.f18511k) == null) {
            return;
        }
        aVar.B(i5 - i3, i4 - i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        f();
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setChecked(savedState.f18512h);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f18512h = this.t;
        return savedState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        f();
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        if (c()) {
            this.f18511k.p(i2);
        } else {
            super.setBackgroundColor(i2);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!c()) {
            super.setBackgroundDrawable(drawable);
        } else {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            Log.w("MaterialButton", "Do not set the background; MaterialButton manages its own background drawable.");
            this.f18511k.q();
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i2) {
        setBackgroundDrawable(i2 != 0 ? c.a.k.a.a.d(getContext(), i2) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (c()) {
            this.f18511k.r(z);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (a() && isEnabled() && this.t != z) {
            this.t = z;
            refreshDrawableState();
            if (this.u) {
                return;
            }
            this.u = true;
            Iterator<a> it = this.l.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.t);
            }
            this.u = false;
        }
    }

    public void setCornerRadius(int i2) {
        if (c()) {
            this.f18511k.s(i2);
        }
    }

    public void setCornerRadiusResource(int i2) {
        if (c()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        if (c()) {
            this.f18511k.d().W(f2);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.p != drawable) {
            this.p = drawable;
            e(true);
        }
    }

    public void setIconGravity(int i2) {
        if (this.v != i2) {
            this.v = i2;
            f();
        }
    }

    public void setIconPadding(int i2) {
        if (this.s != i2) {
            this.s = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(int i2) {
        setIcon(i2 != 0 ? c.a.k.a.a.d(getContext(), i2) : null);
    }

    public void setIconSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.q != i2) {
            this.q = i2;
            e(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.o != colorStateList) {
            this.o = colorStateList;
            e(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.n != mode) {
            this.n = mode;
            e(false);
        }
    }

    public void setIconTintResource(int i2) {
        setIconTint(c.a.k.a.a.c(getContext(), i2));
    }

    void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    void setOnPressedChangeListenerInternal(b bVar) {
        this.m = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        b bVar = this.m;
        if (bVar != null) {
            bVar.a(this, z);
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (c()) {
            this.f18511k.t(colorStateList);
        }
    }

    public void setRippleColorResource(int i2) {
        if (c()) {
            setRippleColor(c.a.k.a.a.c(getContext(), i2));
        }
    }

    @Override // e.e.b.c.a0.n
    public void setShapeAppearanceModel(e.e.b.c.a0.k kVar) {
        if (!c()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f18511k.u(kVar);
    }

    void setShouldDrawSurfaceColorStroke(boolean z) {
        if (c()) {
            this.f18511k.v(z);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (c()) {
            this.f18511k.w(colorStateList);
        }
    }

    public void setStrokeColorResource(int i2) {
        if (c()) {
            setStrokeColor(c.a.k.a.a.c(getContext(), i2));
        }
    }

    public void setStrokeWidth(int i2) {
        if (c()) {
            this.f18511k.x(i2);
        }
    }

    public void setStrokeWidthResource(int i2) {
        if (c()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (c()) {
            this.f18511k.y(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (c()) {
            this.f18511k.z(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.t);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButton(Context context, AttributeSet attributeSet, int i2) {
        int i3 = f18510j;
        super(com.google.android.material.theme.a.a.c(context, attributeSet, i2, i3), attributeSet, i2);
        this.l = new LinkedHashSet<>();
        this.t = false;
        this.u = false;
        Context context2 = getContext();
        TypedArray typedArrayH = j.h(context2, attributeSet, l.t2, i2, i3, new int[0]);
        this.s = typedArrayH.getDimensionPixelSize(l.G2, 0);
        this.n = com.google.android.material.internal.k.e(typedArrayH.getInt(l.J2, -1), PorterDuff.Mode.SRC_IN);
        this.o = c.a(getContext(), typedArrayH, l.I2);
        this.p = c.d(getContext(), typedArrayH, l.E2);
        this.v = typedArrayH.getInteger(l.F2, 1);
        this.q = typedArrayH.getDimensionPixelSize(l.H2, 0);
        com.google.android.material.button.a aVar = new com.google.android.material.button.a(this, e.e.b.c.a0.k.e(context2, attributeSet, i2, i3).m());
        this.f18511k = aVar;
        aVar.o(typedArrayH);
        typedArrayH.recycle();
        setCompoundDrawablePadding(this.s);
        e(this.p != null);
    }
}
