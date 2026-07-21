package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Property<SwitchCompat, Float> f445f = new a(Float.class, "thumbPos");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f446g = {R.attr.state_checked};
    private float A;
    private float B;
    private VelocityTracker C;
    private int D;
    float E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private final TextPaint M;
    private ColorStateList N;
    private Layout O;
    private Layout P;
    private TransformationMethod Q;
    ObjectAnimator R;
    private final s S;
    private final Rect T;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Drawable f447h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ColorStateList f448i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private PorterDuff.Mode f449j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f450k;
    private boolean l;
    private Drawable m;
    private ColorStateList n;
    private PorterDuff.Mode o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private boolean u;
    private CharSequence v;
    private CharSequence w;
    private boolean x;
    private int y;
    private int z;

    class a extends Property<SwitchCompat, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.E);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f2) {
            switchCompat.setThumbPosition(f2.floatValue());
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.L);
    }

    private void a(boolean z) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f445f, z ? 1.0f : 0.0f);
        this.R = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
            this.R.setAutoCancel(true);
        }
        this.R.start();
    }

    private void b() {
        Drawable drawable = this.f447h;
        if (drawable != null) {
            if (this.f450k || this.l) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
                this.f447h = drawableMutate;
                if (this.f450k) {
                    androidx.core.graphics.drawable.a.o(drawableMutate, this.f448i);
                }
                if (this.l) {
                    androidx.core.graphics.drawable.a.p(this.f447h, this.f449j);
                }
                if (this.f447h.isStateful()) {
                    this.f447h.setState(getDrawableState());
                }
            }
        }
    }

    private void c() {
        Drawable drawable = this.m;
        if (drawable != null) {
            if (this.p || this.q) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
                this.m = drawableMutate;
                if (this.p) {
                    androidx.core.graphics.drawable.a.o(drawableMutate, this.n);
                }
                if (this.q) {
                    androidx.core.graphics.drawable.a.p(this.m, this.o);
                }
                if (this.m.isStateful()) {
                    this.m.setState(getDrawableState());
                }
            }
        }
    }

    private void d() {
        ObjectAnimator objectAnimator = this.R;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void e(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    private static float f(float f2, float f3, float f4) {
        if (f2 < f3) {
            return f3;
        }
        return f2 > f4 ? f4 : f2;
    }

    private boolean g(float f2, float f3) {
        if (this.f447h == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f447h.getPadding(this.T);
        int i2 = this.J;
        int i3 = this.z;
        int i4 = i2 - i3;
        int i5 = (this.I + thumbOffset) - i3;
        int i6 = this.H + i5;
        Rect rect = this.T;
        return f2 > ((float) i5) && f2 < ((float) (((i6 + rect.left) + rect.right) + i3)) && f3 > ((float) i4) && f3 < ((float) (this.L + i3));
    }

    private boolean getTargetCheckedState() {
        return this.E > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((w0.b(this) ? 1.0f - this.E : this.E) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.m;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.T;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f447h;
        Rect rectD = drawable2 != null ? y.d(drawable2) : y.f666c;
        return ((((this.F - this.H) - rect.left) - rect.right) - rectD.left) - rectD.right;
    }

    private Layout h(CharSequence charSequence) {
        TransformationMethod transformationMethod = this.Q;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        TextPaint textPaint = this.M;
        return new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void k(int i2, int i3) {
        Typeface typeface;
        if (i2 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i2 != 2) {
            typeface = i2 != 3 ? null : Typeface.MONOSPACE;
        } else {
            typeface = Typeface.SERIF;
        }
        j(typeface, i3);
    }

    private void l(MotionEvent motionEvent) {
        this.y = 0;
        boolean targetCheckedState = true;
        boolean z = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z) {
            this.C.computeCurrentVelocity(1000);
            float xVelocity = this.C.getXVelocity();
            if (Math.abs(xVelocity) <= this.D) {
                targetCheckedState = getTargetCheckedState();
            } else if (!w0.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                targetCheckedState = false;
            }
        } else {
            targetCheckedState = zIsChecked;
        }
        if (targetCheckedState != zIsChecked) {
            playSoundEffect(0);
        }
        setChecked(targetCheckedState);
        e(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i2;
        int i3;
        Rect rect = this.T;
        int i4 = this.I;
        int i5 = this.J;
        int i6 = this.K;
        int i7 = this.L;
        int thumbOffset = getThumbOffset() + i4;
        Drawable drawable = this.f447h;
        Rect rectD = drawable != null ? y.d(drawable) : y.f666c;
        Drawable drawable2 = this.m;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i8 = rect.left;
            thumbOffset += i8;
            if (rectD != null) {
                int i9 = rectD.left;
                if (i9 > i8) {
                    i4 += i9 - i8;
                }
                int i10 = rectD.top;
                int i11 = rect.top;
                i2 = i10 > i11 ? (i10 - i11) + i5 : i5;
                int i12 = rectD.right;
                int i13 = rect.right;
                if (i12 > i13) {
                    i6 -= i12 - i13;
                }
                int i14 = rectD.bottom;
                int i15 = rect.bottom;
                if (i14 > i15) {
                    i3 = i7 - (i14 - i15);
                }
                this.m.setBounds(i4, i2, i6, i3);
            } else {
                i2 = i5;
            }
            i3 = i7;
            this.m.setBounds(i4, i2, i6, i3);
        }
        Drawable drawable3 = this.f447h;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i16 = thumbOffset - rect.left;
            int i17 = thumbOffset + this.H + rect.right;
            this.f447h.setBounds(i16, i5, i17, i7);
            Drawable background = getBackground();
            if (background != null) {
                androidx.core.graphics.drawable.a.l(background, i16, i5, i17, i7);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f2, f3);
        }
        Drawable drawable = this.f447h;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.k(drawable, f2, f3);
        }
        Drawable drawable2 = this.m;
        if (drawable2 != null) {
            androidx.core.graphics.drawable.a.k(drawable2, f2, f3);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f447h;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.m;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!w0.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.F;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.t : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (w0.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.F;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.t : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.x;
    }

    public boolean getSplitTrack() {
        return this.u;
    }

    public int getSwitchMinWidth() {
        return this.s;
    }

    public int getSwitchPadding() {
        return this.t;
    }

    public CharSequence getTextOff() {
        return this.w;
    }

    public CharSequence getTextOn() {
        return this.v;
    }

    public Drawable getThumbDrawable() {
        return this.f447h;
    }

    public int getThumbTextPadding() {
        return this.r;
    }

    public ColorStateList getThumbTintList() {
        return this.f448i;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f449j;
    }

    public Drawable getTrackDrawable() {
        return this.m;
    }

    public ColorStateList getTrackTintList() {
        return this.n;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.o;
    }

    public void i(Context context, int i2) {
        q0 q0VarT = q0.t(context, i2, c.a.j.X2);
        ColorStateList colorStateListC = q0VarT.c(c.a.j.b3);
        if (colorStateListC != null) {
            this.N = colorStateListC;
        } else {
            this.N = getTextColors();
        }
        int iF = q0VarT.f(c.a.j.Y2, 0);
        if (iF != 0) {
            float f2 = iF;
            if (f2 != this.M.getTextSize()) {
                this.M.setTextSize(f2);
                requestLayout();
            }
        }
        k(q0VarT.k(c.a.j.Z2, -1), q0VarT.k(c.a.j.a3, -1));
        if (q0VarT.a(c.a.j.i3, false)) {
            this.Q = new c.a.n.a(getContext());
        } else {
            this.Q = null;
        }
        q0VarT.w();
    }

    public void j(Typeface typeface, int i2) {
        if (i2 <= 0) {
            this.M.setFakeBoldText(false);
            this.M.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        } else {
            Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i2) : Typeface.create(typeface, i2);
            setSwitchTypeface(typefaceDefaultFromStyle);
            int style = ((typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0) ^ (-1)) & i2;
            this.M.setFakeBoldText((style & 1) != 0);
            this.M.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f447h;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.m;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.R;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.R.end();
        this.R = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(iArrOnCreateDrawableState, f446g);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.T;
        Drawable drawable = this.m;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i2 = this.J;
        int i3 = this.L;
        int i4 = i2 + rect.top;
        int i5 = i3 - rect.bottom;
        Drawable drawable2 = this.f447h;
        if (drawable != null) {
            if (!this.u || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectD = y.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectD.left;
                rect.right -= rectD.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.O : this.P;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.N;
            if (colorStateList != null) {
                this.M.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.M.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i4 + i5) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        CharSequence charSequence = isChecked() ? this.v : this.w;
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        CharSequence text = accessibilityNodeInfo.getText();
        if (TextUtils.isEmpty(text)) {
            accessibilityNodeInfo.setText(charSequence);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        sb.append(' ');
        sb.append(charSequence);
        accessibilityNodeInfo.setText(sb);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int iMax;
        int width;
        int paddingLeft;
        int i6;
        int paddingTop;
        int height;
        super.onLayout(z, i2, i3, i4, i5);
        int iMax2 = 0;
        if (this.f447h != null) {
            Rect rect = this.T;
            Drawable drawable = this.m;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectD = y.d(this.f447h);
            iMax = Math.max(0, rectD.left - rect.left);
            iMax2 = Math.max(0, rectD.right - rect.right);
        } else {
            iMax = 0;
        }
        if (w0.b(this)) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.F + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.F) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity != 16) {
            if (gravity != 80) {
                paddingTop = getPaddingTop();
                i6 = this.G;
            } else {
                height = getHeight() - getPaddingBottom();
                paddingTop = height - this.G;
            }
            this.I = paddingLeft;
            this.J = paddingTop;
            this.L = height;
            this.K = width;
        }
        int paddingTop2 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
        i6 = this.G;
        paddingTop = paddingTop2 - (i6 / 2);
        height = i6 + paddingTop;
        this.I = paddingLeft;
        this.J = paddingTop;
        this.L = height;
        this.K = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.x) {
            if (this.O == null) {
                this.O = h(this.v);
            }
            if (this.P == null) {
                this.P = h(this.w);
            }
        }
        Rect rect = this.T;
        Drawable drawable = this.f447h;
        int intrinsicHeight2 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f447h.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f447h.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.H = Math.max(this.x ? Math.max(this.O.getWidth(), this.P.getWidth()) + (this.r * 2) : 0, intrinsicWidth);
        Drawable drawable2 = this.m;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.m.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.f447h;
        if (drawable3 != null) {
            Rect rectD = y.d(drawable3);
            iMax = Math.max(iMax, rectD.left);
            iMax2 = Math.max(iMax2, rectD.right);
        }
        int iMax3 = Math.max(this.s, (this.H * 2) + iMax + iMax2);
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.F = iMax3;
        this.G = iMax4;
        super.onMeasure(i2, i3);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.v : this.w;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008b  */
    /* JADX WARN: Code duplicated, block: B:36:0x008f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0096  */
    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f2;
        this.C.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (isEnabled() && g(x, y)) {
                this.y = 1;
                this.A = x;
                this.B = y;
            }
        } else if (actionMasked == 1) {
            if (this.y == 2) {
                l(motionEvent);
                super.onTouchEvent(motionEvent);
                return true;
            }
            this.y = 0;
            this.C.clear();
        } else if (actionMasked == 2) {
            int i2 = this.y;
            if (i2 == 1) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                if (Math.abs(x2 - this.A) > this.z || Math.abs(y2 - this.B) > this.z) {
                    this.y = 2;
                    getParent().requestDisallowInterceptTouchEvent(true);
                    this.A = x2;
                    this.B = y2;
                    return true;
                }
            } else if (i2 == 2) {
                float x3 = motionEvent.getX();
                int thumbScrollRange = getThumbScrollRange();
                float f3 = x3 - this.A;
                if (thumbScrollRange != 0) {
                    f2 = f3 / thumbScrollRange;
                } else {
                    f2 = f3 > 0.0f ? 1.0f : -1.0f;
                }
                if (w0.b(this)) {
                    f2 = -f2;
                }
                float f4 = f(this.E + f2, 0.0f, 1.0f);
                if (f4 != this.E) {
                    this.A = x3;
                    setThumbPosition(f4);
                }
                return true;
            }
        } else if (actionMasked == 3) {
            if (this.y == 2) {
                l(motionEvent);
                super.onTouchEvent(motionEvent);
                return true;
            }
            this.y = 0;
            this.C.clear();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean zIsChecked = isChecked();
        if (getWindowToken() != null && androidx.core.view.u.O(this)) {
            a(zIsChecked);
        } else {
            d();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.k.p(this, callback));
    }

    public void setShowText(boolean z) {
        if (this.x != z) {
            this.x = z;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z) {
        this.u = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i2) {
        this.s = i2;
        requestLayout();
    }

    public void setSwitchPadding(int i2) {
        this.t = i2;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.M.getTypeface() == null || this.M.getTypeface().equals(typeface)) && (this.M.getTypeface() != null || typeface == null)) {
            return;
        }
        this.M.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        this.w = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.v = charSequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f447h;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f447h = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    void setThumbPosition(float f2) {
        this.E = f2;
        invalidate();
    }

    public void setThumbResource(int i2) {
        setThumbDrawable(c.a.k.a.a.d(getContext(), i2));
    }

    public void setThumbTextPadding(int i2) {
        this.r = i2;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f448i = colorStateList;
        this.f450k = true;
        b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f449j = mode;
        this.l = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.m;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.m = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i2) {
        setTrackDrawable(c.a.k.a.a.d(getContext(), i2));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.n = colorStateList;
        this.p = true;
        c();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.o = mode;
        this.q = true;
        c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f447h || drawable == this.m;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f448i = null;
        this.f449j = null;
        this.f450k = false;
        this.l = false;
        this.n = null;
        this.o = null;
        this.p = false;
        this.q = false;
        this.C = VelocityTracker.obtain();
        this.T = new Rect();
        l0.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.M = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = c.a.j.I2;
        q0 q0VarV = q0.v(context, attributeSet, iArr, i2, 0);
        androidx.core.view.u.g0(this, context, iArr, attributeSet, q0VarV.r(), i2, 0);
        Drawable drawableG = q0VarV.g(c.a.j.L2);
        this.f447h = drawableG;
        if (drawableG != null) {
            drawableG.setCallback(this);
        }
        Drawable drawableG2 = q0VarV.g(c.a.j.U2);
        this.m = drawableG2;
        if (drawableG2 != null) {
            drawableG2.setCallback(this);
        }
        this.v = q0VarV.p(c.a.j.J2);
        this.w = q0VarV.p(c.a.j.K2);
        this.x = q0VarV.a(c.a.j.M2, true);
        this.r = q0VarV.f(c.a.j.R2, 0);
        this.s = q0VarV.f(c.a.j.O2, 0);
        this.t = q0VarV.f(c.a.j.P2, 0);
        this.u = q0VarV.a(c.a.j.N2, false);
        ColorStateList colorStateListC = q0VarV.c(c.a.j.S2);
        if (colorStateListC != null) {
            this.f448i = colorStateListC;
            this.f450k = true;
        }
        PorterDuff.Mode modeE = y.e(q0VarV.k(c.a.j.T2, -1), null);
        if (this.f449j != modeE) {
            this.f449j = modeE;
            this.l = true;
        }
        if (this.f450k || this.l) {
            b();
        }
        ColorStateList colorStateListC2 = q0VarV.c(c.a.j.V2);
        if (colorStateListC2 != null) {
            this.n = colorStateListC2;
            this.p = true;
        }
        PorterDuff.Mode modeE2 = y.e(q0VarV.k(c.a.j.W2, -1), null);
        if (this.o != modeE2) {
            this.o = modeE2;
            this.q = true;
        }
        if (this.p || this.q) {
            c();
        }
        int iN = q0VarV.n(c.a.j.Q2, 0);
        if (iN != 0) {
            i(context, iN);
        }
        s sVar = new s(this);
        this.S = sVar;
        sVar.m(attributeSet, i2);
        q0VarV.w();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.z = viewConfiguration.getScaledTouchSlop();
        this.D = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }
}
