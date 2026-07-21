package com.google.android.material.chip;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.e;
import androidx.core.view.u;
import e.e.b.c.a0.n;
import e.e.b.c.j;
import e.e.b.c.k;
import e.e.b.c.l;
import e.e.b.c.m.h;
import e.e.b.c.x.d;
import e.e.b.c.x.f;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public class Chip extends e implements com.google.android.material.chip.a.InterfaceC0196a, n {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f18534i = k.s;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Rect f18535j = new Rect();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f18536k = {R.attr.state_selected};
    private static final int[] l = {R.attr.state_checkable};
    private final RectF A;
    private final f B;
    private com.google.android.material.chip.a m;
    private InsetDrawable n;
    private RippleDrawable o;
    private View.OnClickListener p;
    private CompoundButton.OnCheckedChangeListener q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private final c y;
    private final Rect z;

    class a extends f {
        a() {
        }

        @Override // e.e.b.c.x.f
        public void a(int i2) {
        }

        @Override // e.e.b.c.x.f
        public void b(Typeface typeface, boolean z) {
            Chip chip = Chip.this;
            chip.setText(chip.m.K2() ? Chip.this.m.g1() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        @TargetApi(21)
        public void getOutline(View view, Outline outline) {
            if (Chip.this.m != null) {
                Chip.this.m.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    private class c extends c.k.a.a {
        c(Chip chip) {
            super(chip);
        }

        @Override // c.k.a.a
        protected int B(float f2, float f3) {
            return (Chip.this.n() && Chip.this.getCloseIconTouchBounds().contains(f2, f3)) ? 1 : 0;
        }

        @Override // c.k.a.a
        protected void C(List<Integer> list) {
            list.add(0);
            if (Chip.this.n() && Chip.this.s() && Chip.this.p != null) {
                list.add(1);
            }
        }

        @Override // c.k.a.a
        protected boolean J(int i2, int i3, Bundle bundle) {
            if (i3 != 16) {
                return false;
            }
            if (i2 == 0) {
                return Chip.this.performClick();
            }
            if (i2 == 1) {
                return Chip.this.t();
            }
            return false;
        }

        @Override // c.k.a.a
        protected void M(androidx.core.view.d0.c cVar) {
            cVar.W(Chip.this.r());
            cVar.Z(Chip.this.isClickable());
            if (Chip.this.r() || Chip.this.isClickable()) {
                cVar.Y(Chip.this.r() ? "android.widget.CompoundButton" : "android.widget.Button");
            } else {
                cVar.Y("android.view.View");
            }
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                cVar.v0(text);
            } else {
                cVar.c0(text);
            }
        }

        @Override // c.k.a.a
        protected void N(int i2, androidx.core.view.d0.c cVar) {
            CharSequence charSequence = HttpUrl.FRAGMENT_ENCODE_SET;
            if (i2 != 1) {
                cVar.c0(HttpUrl.FRAGMENT_ENCODE_SET);
                cVar.U(Chip.f18535j);
                return;
            }
            CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                cVar.c0(closeIconContentDescription);
            } else {
                CharSequence text = Chip.this.getText();
                Context context = Chip.this.getContext();
                int i3 = j.f21027i;
                Object[] objArr = new Object[1];
                if (!TextUtils.isEmpty(text)) {
                    charSequence = text;
                }
                objArr[0] = charSequence;
                cVar.c0(context.getString(i3, objArr).trim());
            }
            cVar.U(Chip.this.getCloseIconTouchBoundsInt());
            cVar.b(androidx.core.view.d0.c.a.f1038e);
            cVar.e0(Chip.this.isEnabled());
        }

        @Override // c.k.a.a
        protected void O(int i2, boolean z) {
            if (i2 == 1) {
                Chip.this.u = z;
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.e.b.c.b.f20970i);
    }

    private void A() {
        com.google.android.material.chip.a aVar;
        if (TextUtils.isEmpty(getText()) || (aVar = this.m) == null) {
            return;
        }
        int iK0 = (int) (aVar.K0() + this.m.i1() + this.m.r0());
        int iP0 = (int) (this.m.P0() + this.m.j1() + this.m.n0());
        if (this.n != null) {
            Rect rect = new Rect();
            this.n.getPadding(rect);
            iP0 += rect.left;
            iK0 += rect.right;
        }
        u.w0(this, iP0, getPaddingTop(), iK0, getPaddingBottom());
    }

    private void B() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.i(getContext(), paint, this.B);
        }
    }

    private void C(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.A.setEmpty();
        if (n()) {
            this.m.Z0(this.A);
        }
        return this.A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.z.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.z;
    }

    private d getTextAppearance() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.h1();
        }
        return null;
    }

    private void i(com.google.android.material.chip.a aVar) {
        aVar.o2(this);
    }

    private int[] j() {
        int i2 = 0;
        int i3 = isEnabled() ? 1 : 0;
        if (this.u) {
            i3++;
        }
        if (this.t) {
            i3++;
        }
        if (this.s) {
            i3++;
        }
        if (isChecked()) {
            i3++;
        }
        int[] iArr = new int[i3];
        if (isEnabled()) {
            iArr[0] = 16842910;
            i2 = 1;
        }
        if (this.u) {
            iArr[i2] = 16842908;
            i2++;
        }
        if (this.t) {
            iArr[i2] = 16843623;
            i2++;
        }
        if (this.s) {
            iArr[i2] = 16842919;
            i2++;
        }
        if (isChecked()) {
            iArr[i2] = 16842913;
        }
        return iArr;
    }

    private void l() {
        if (getBackgroundDrawable() == this.n && this.m.getCallback() == null) {
            this.m.setCallback(this.n);
        }
    }

    @SuppressLint({"PrivateApi"})
    private boolean m(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = c.k.a.a.class.getDeclaredField("p");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.y)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = c.k.a.a.class.getDeclaredMethod("V", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.y, Integer.MIN_VALUE);
                    return true;
                }
            } catch (IllegalAccessException e2) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e2);
            } catch (NoSuchFieldException e3) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e3);
            } catch (NoSuchMethodException e4) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e4);
            } catch (InvocationTargetException e5) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e5);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        com.google.android.material.chip.a aVar = this.m;
        return (aVar == null || aVar.S0() == null) ? false : true;
    }

    private void o(Context context, AttributeSet attributeSet, int i2) {
        TypedArray typedArrayH = com.google.android.material.internal.j.h(context, attributeSet, l.h0, i2, f18534i, new int[0]);
        this.v = typedArrayH.getBoolean(l.N0, false);
        this.x = (int) Math.ceil(typedArrayH.getDimension(l.B0, (float) Math.ceil(com.google.android.material.internal.k.b(getContext(), 48))));
        typedArrayH.recycle();
    }

    private void p() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new b());
        }
    }

    private void q(int i2, int i3, int i4, int i5) {
        this.n = new InsetDrawable((Drawable) this.m, i2, i3, i4, i5);
    }

    private void setCloseIconHovered(boolean z) {
        if (this.t != z) {
            this.t = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.s != z) {
            this.s = z;
            refreshDrawableState();
        }
    }

    private void u() {
        if (this.n != null) {
            this.n = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            y();
        }
    }

    private void w(com.google.android.material.chip.a aVar) {
        if (aVar != null) {
            aVar.o2(null);
        }
    }

    private void x() {
        if (n() && s() && this.p != null) {
            u.i0(this, this.y);
        } else {
            u.i0(this, null);
        }
    }

    private void y() {
        if (e.e.b.c.y.b.a) {
            z();
            return;
        }
        this.m.J2(true);
        u.m0(this, getBackgroundDrawable());
        A();
        l();
    }

    private void z() {
        this.o = new RippleDrawable(e.e.b.c.y.b.d(this.m.e1()), getBackgroundDrawable(), null);
        this.m.J2(false);
        u.m0(this, this.o);
        A();
    }

    @Override // com.google.android.material.chip.a.InterfaceC0196a
    public void a() {
        k(this.x);
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return m(motionEvent) || this.y.v(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.y.w(keyEvent) || this.y.A() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // androidx.appcompat.widget.e, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        com.google.android.material.chip.a aVar = this.m;
        if ((aVar == null || !aVar.o1()) ? false : this.m.k2(j())) {
            invalidate();
        }
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.n;
        return insetDrawable == null ? this.m : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.G0();
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.H0();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.I0();
        }
        return null;
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return Math.max(0.0f, aVar.J0());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.m;
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.K0();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.L0();
        }
        return null;
    }

    public float getChipIconSize() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.M0();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.N0();
        }
        return null;
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.O0();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.P0();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.Q0();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.R0();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.S0();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.T0();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.U0();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.V0();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.W0();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.Y0();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.a1();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.y.A() == 1 || this.y.x() == 1) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public h getHideMotionSpec() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.b1();
        }
        return null;
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.c1();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.d1();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.e1();
        }
        return null;
    }

    public e.e.b.c.a0.k getShapeAppearanceModel() {
        return this.m.D();
    }

    public h getShowMotionSpec() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.f1();
        }
        return null;
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.i1();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            return aVar.j1();
        }
        return 0.0f;
    }

    public boolean k(int i2) {
        this.x = i2;
        if (!v()) {
            if (this.n != null) {
                u();
            } else {
                y();
            }
            return false;
        }
        int iMax = Math.max(0, i2 - this.m.getIntrinsicHeight());
        int iMax2 = Math.max(0, i2 - this.m.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            if (this.n != null) {
                u();
            } else {
                y();
            }
            return false;
        }
        int i3 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i4 = iMax > 0 ? iMax / 2 : 0;
        if (this.n != null) {
            Rect rect = new Rect();
            this.n.getPadding(rect);
            if (rect.top == i4 && rect.bottom == i4 && rect.left == i3 && rect.right == i3) {
                y();
                return true;
            }
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (getMinHeight() != i2) {
                setMinHeight(i2);
            }
            if (getMinWidth() != i2) {
                setMinWidth(i2);
            }
        } else {
            setMinHeight(i2);
            setMinWidth(i2);
        }
        q(i3, i4, i3, i4);
        y();
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e.e.b.c.a0.h.f(this, this.m);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(iArrOnCreateDrawableState, f18536k);
        }
        if (r()) {
            CheckBox.mergeDrawableStates(iArrOnCreateDrawableState, l);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        this.y.I(z, i2, rect);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (r() || isClickable()) {
            accessibilityNodeInfo.setClassName(r() ? "android.widget.CompoundButton" : "android.widget.Button");
        } else {
            accessibilityNodeInfo.setClassName("android.view.View");
        }
        accessibilityNodeInfo.setCheckable(r());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            androidx.core.view.d0.c.y0(accessibilityNodeInfo).b0(androidx.core.view.d0.c.C0025c.f(chipGroup.b(this), 1, chipGroup.c() ? chipGroup.n(this) : -1, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i2) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        if (this.w != i2) {
            this.w = i2;
            A();
        }
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        boolean zContains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                    }
                } else if (this.s) {
                    if (!zContains) {
                        setCloseIconPressed(false);
                    }
                    z = true;
                }
                z = false;
            } else {
                if (this.s) {
                    t();
                    z = true;
                }
                setCloseIconPressed(false);
            }
            z = false;
            setCloseIconPressed(false);
        } else if (zContains) {
            setCloseIconPressed(true);
            z = true;
        } else {
            z = false;
        }
        return z || super.onTouchEvent(motionEvent);
    }

    public boolean r() {
        com.google.android.material.chip.a aVar = this.m;
        return aVar != null && aVar.n1();
    }

    public boolean s() {
        com.google.android.material.chip.a aVar = this.m;
        return aVar != null && aVar.p1();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.o) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.e, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.o) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.e, android.view.View
    public void setBackgroundResource(int i2) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.w1(z);
        }
    }

    public void setCheckableResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.x1(i2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        com.google.android.material.chip.a aVar = this.m;
        if (aVar == null) {
            this.r = z;
            return;
        }
        if (aVar.n1()) {
            boolean zIsChecked = isChecked();
            super.setChecked(z);
            if (zIsChecked == z || (onCheckedChangeListener = this.q) == null) {
                return;
            }
            onCheckedChangeListener.onCheckedChanged(this, z);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.y1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i2) {
        setCheckedIconVisible(i2);
    }

    public void setCheckedIconResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.z1(i2);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.A1(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.B1(i2);
        }
    }

    public void setCheckedIconVisible(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.C1(i2);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.E1(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.F1(i2);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.G1(f2);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.H1(i2);
        }
    }

    public void setChipDrawable(com.google.android.material.chip.a aVar) {
        com.google.android.material.chip.a aVar2 = this.m;
        if (aVar2 != aVar) {
            w(aVar2);
            this.m = aVar;
            aVar.z2(false);
            i(this.m);
            k(this.x);
        }
    }

    public void setChipEndPadding(float f2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.I1(f2);
        }
    }

    public void setChipEndPaddingResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.J1(i2);
        }
    }

    public void setChipIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.K1(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i2) {
        setChipIconVisible(i2);
    }

    public void setChipIconResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.L1(i2);
        }
    }

    public void setChipIconSize(float f2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.M1(f2);
        }
    }

    public void setChipIconSizeResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.N1(i2);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.O1(colorStateList);
        }
    }

    public void setChipIconTintResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.P1(i2);
        }
    }

    public void setChipIconVisible(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.Q1(i2);
        }
    }

    public void setChipMinHeight(float f2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.S1(f2);
        }
    }

    public void setChipMinHeightResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.T1(i2);
        }
    }

    public void setChipStartPadding(float f2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.U1(f2);
        }
    }

    public void setChipStartPaddingResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.V1(i2);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.W1(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.X1(i2);
        }
    }

    public void setChipStrokeWidth(float f2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.Y1(f2);
        }
    }

    public void setChipStrokeWidthResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.Z1(i2);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i2) {
        setText(getResources().getString(i2));
    }

    public void setCloseIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.b2(drawable);
        }
        x();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.c2(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i2) {
        setCloseIconVisible(i2);
    }

    public void setCloseIconEndPadding(float f2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.d2(f2);
        }
    }

    public void setCloseIconEndPaddingResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.e2(i2);
        }
    }

    public void setCloseIconResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.f2(i2);
        }
        x();
    }

    public void setCloseIconSize(float f2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.g2(f2);
        }
    }

    public void setCloseIconSizeResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.h2(i2);
        }
    }

    public void setCloseIconStartPadding(float f2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.i2(f2);
        }
    }

    public void setCloseIconStartPaddingResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.j2(i2);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.l2(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.m2(i2);
        }
    }

    public void setCloseIconVisible(int i2) {
        setCloseIconVisible(getResources().getBoolean(i2));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i4 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i3, i4, i5);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i4 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i2, i3, i4, i5);
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.W(f2);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.m == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.p2(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.v = z;
        k(this.x);
    }

    @Override // android.widget.TextView
    public void setGravity(int i2) {
        if (i2 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i2);
        }
    }

    public void setHideMotionSpec(h hVar) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.q2(hVar);
        }
    }

    public void setHideMotionSpecResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.r2(i2);
        }
    }

    public void setIconEndPadding(float f2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.s2(f2);
        }
    }

    public void setIconEndPaddingResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.t2(i2);
        }
    }

    public void setIconStartPadding(float f2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.u2(f2);
        }
    }

    public void setIconStartPaddingResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.v2(i2);
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i2) {
        if (this.m != null && Build.VERSION.SDK_INT >= 17) {
            super.setLayoutDirection(i2);
        }
    }

    @Override // android.widget.TextView
    public void setLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i2);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i2);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i2) {
        super.setMaxWidth(i2);
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.w2(i2);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i2);
    }

    void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.q = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.p = onClickListener;
        x();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.x2(colorStateList);
        }
        if (this.m.l1()) {
            return;
        }
        z();
    }

    public void setRippleColorResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.y2(i2);
            if (this.m.l1()) {
                return;
            }
            z();
        }
    }

    @Override // e.e.b.c.a0.n
    public void setShapeAppearanceModel(e.e.b.c.a0.k kVar) {
        this.m.setShapeAppearanceModel(kVar);
    }

    public void setShowMotionSpec(h hVar) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.A2(hVar);
        }
    }

    public void setShowMotionSpecResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.B2(i2);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        if (!z) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        super.setText(aVar.K2() ? null : charSequence, bufferType);
        com.google.android.material.chip.a aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.C2(charSequence);
        }
    }

    public void setTextAppearance(d dVar) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.D2(dVar);
        }
        B();
    }

    public void setTextAppearanceResource(int i2) {
        setTextAppearance(getContext(), i2);
    }

    public void setTextEndPadding(float f2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.F2(f2);
        }
    }

    public void setTextEndPaddingResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.G2(i2);
        }
    }

    public void setTextStartPadding(float f2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.H2(f2);
        }
    }

    public void setTextStartPaddingResource(int i2) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.I2(i2);
        }
    }

    public boolean t() {
        boolean z = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.p;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z = true;
        }
        this.y.U(1, 1);
        return z;
    }

    public boolean v() {
        return this.v;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Chip(Context context, AttributeSet attributeSet, int i2) {
        int i3 = f18534i;
        super(com.google.android.material.theme.a.a.c(context, attributeSet, i2, i3), attributeSet, i2);
        this.z = new Rect();
        this.A = new RectF();
        this.B = new a();
        Context context2 = getContext();
        C(attributeSet);
        com.google.android.material.chip.a aVarW0 = com.google.android.material.chip.a.w0(context2, attributeSet, i2, i3);
        o(context2, attributeSet, i2);
        setChipDrawable(aVarW0);
        aVarW0.W(u.t(this));
        TypedArray typedArrayH = com.google.android.material.internal.j.h(context2, attributeSet, l.h0, i2, i3, new int[0]);
        if (Build.VERSION.SDK_INT < 23) {
            setTextColor(e.e.b.c.x.c.a(context2, typedArrayH, l.j0));
        }
        boolean zHasValue = typedArrayH.hasValue(l.S0);
        typedArrayH.recycle();
        this.y = new c(this);
        x();
        if (!zHasValue) {
            p();
        }
        setChecked(this.r);
        setText(aVarW0.g1());
        setEllipsize(aVarW0.a1());
        setIncludeFontPadding(false);
        B();
        if (!this.m.K2()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        A();
        if (v()) {
            setMinHeight(this.x);
        }
        this.w = u.y(this);
    }

    public void setCloseIconVisible(boolean z) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.n2(z);
        }
        x();
    }

    public void setCheckedIconVisible(boolean z) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.D1(z);
        }
    }

    public void setChipIconVisible(boolean z) {
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.R1(z);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.E2(i2);
        }
        B();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
        com.google.android.material.chip.a aVar = this.m;
        if (aVar != null) {
            aVar.E2(i2);
        }
        B();
    }
}
