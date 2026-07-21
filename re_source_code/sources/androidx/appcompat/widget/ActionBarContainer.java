package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f358f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f359g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f360h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View f361i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Drawable f362j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Drawable f363k;
    Drawable l;
    boolean m;
    boolean n;
    private int o;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        androidx.core.view.u.m0(this, new b(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.j.a);
        this.f362j = typedArrayObtainStyledAttributes.getDrawable(c.a.j.f2756b);
        this.f363k = typedArrayObtainStyledAttributes.getDrawable(c.a.j.f2758d);
        this.o = typedArrayObtainStyledAttributes.getDimensionPixelSize(c.a.j.f2764j, -1);
        boolean z = true;
        if (getId() == c.a.f.H) {
            this.m = true;
            this.l = typedArrayObtainStyledAttributes.getDrawable(c.a.j.f2757c);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.m ? this.f362j != null || this.f363k != null : this.l != null) {
            z = false;
        }
        setWillNotDraw(z);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f362j;
        if (drawable != null && drawable.isStateful()) {
            this.f362j.setState(getDrawableState());
        }
        Drawable drawable2 = this.f363k;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f363k.setState(getDrawableState());
        }
        Drawable drawable3 = this.l;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.l.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f359g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f362j;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f363k;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.l;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f360h = findViewById(c.a.f.a);
        this.f361i = findViewById(c.a.f.f2726f);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f358f || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Drawable drawable;
        super.onLayout(z, i2, i3, i4, i5);
        View view = this.f359g;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int measuredHeight2 = measuredHeight - view.getMeasuredHeight();
            int i6 = layoutParams.bottomMargin;
            view.layout(i2, measuredHeight2 - i6, i4, measuredHeight - i6);
        }
        if (this.m) {
            Drawable drawable2 = this.l;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f362j != null) {
                if (this.f360h.getVisibility() == 0) {
                    this.f362j.setBounds(this.f360h.getLeft(), this.f360h.getTop(), this.f360h.getRight(), this.f360h.getBottom());
                } else {
                    View view2 = this.f361i;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f362j.setBounds(0, 0, 0, 0);
                    } else {
                        this.f362j.setBounds(this.f361i.getLeft(), this.f361i.getTop(), this.f361i.getRight(), this.f361i.getBottom());
                    }
                }
                z3 = true;
            }
            this.n = z4;
            if (!z4 || (drawable = this.f363k) == null) {
                z2 = z3;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int iA;
        int i4;
        if (this.f360h == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i4 = this.o) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i4, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        if (this.f360h == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        View view = this.f359g;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (b(this.f360h)) {
            iA = !b(this.f361i) ? a(this.f361i) : 0;
        } else {
            iA = a(this.f360h);
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(iA + a(this.f359g), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f362j;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f362j);
        }
        this.f362j = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f360h;
            if (view != null) {
                this.f362j.setBounds(view.getLeft(), this.f360h.getTop(), this.f360h.getRight(), this.f360h.getBottom());
            }
        }
        boolean z = true;
        if (!this.m ? this.f362j != null || this.f363k != null : this.l != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.l;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.l);
        }
        this.l = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.m && (drawable2 = this.l) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.m ? !(this.f362j != null || this.f363k != null) : this.l == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f363k;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f363k);
        }
        this.f363k = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.n && (drawable2 = this.f363k) != null) {
                drawable2.setBounds(this.f359g.getLeft(), this.f359g.getTop(), this.f359g.getRight(), this.f359g.getBottom());
            }
        }
        boolean z = true;
        if (!this.m ? this.f362j != null || this.f363k != null : this.l != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setTabContainer(j0 j0Var) {
        View view = this.f359g;
        if (view != null) {
            removeView(view);
        }
        this.f359g = j0Var;
        if (j0Var != null) {
            addView(j0Var);
            ViewGroup.LayoutParams layoutParams = j0Var.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            j0Var.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f358f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.f362j;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f363k;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.l;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f362j && !this.m) || (drawable == this.f363k && this.n) || ((drawable == this.l && this.m) || super.verifyDrawable(drawable));
    }
}
