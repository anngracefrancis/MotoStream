package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends androidx.appcompat.widget.a {
    private CharSequence n;
    private CharSequence o;
    private View p;
    private View q;
    private LinearLayout r;
    private TextView s;
    private TextView t;
    private int u;
    private int v;
    private boolean w;
    private int x;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c.a.o.b f364f;

        a(c.a.o.b bVar) {
            this.f364f = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f364f.c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    private void i() {
        if (this.r == null) {
            LayoutInflater.from(getContext()).inflate(c.a.g.a, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.r = linearLayout;
            this.s = (TextView) linearLayout.findViewById(c.a.f.f2725e);
            this.t = (TextView) this.r.findViewById(c.a.f.f2724d);
            if (this.u != 0) {
                this.s.setTextAppearance(getContext(), this.u);
            }
            if (this.v != 0) {
                this.t.setTextAppearance(getContext(), this.v);
            }
        }
        this.s.setText(this.n);
        this.t.setText(this.o);
        boolean z = !TextUtils.isEmpty(this.n);
        boolean z2 = !TextUtils.isEmpty(this.o);
        int i2 = 0;
        this.t.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout2 = this.r;
        if (!z && !z2) {
            i2 = 8;
        }
        linearLayout2.setVisibility(i2);
        if (this.r.getParent() == null) {
            addView(this.r);
        }
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ androidx.core.view.y f(int i2, long j2) {
        return super.f(i2, j2);
    }

    public void g() {
        if (this.p == null) {
            k();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.o;
    }

    public CharSequence getTitle() {
        return this.n;
    }

    public void h(c.a.o.b bVar) {
        View view = this.p;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.x, (ViewGroup) this, false);
            this.p = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.p);
        }
        this.p.findViewById(c.a.f.f2729i).setOnClickListener(new a(bVar));
        androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) bVar.e();
        ActionMenuPresenter actionMenuPresenter = this.f473i;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.A();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f473i = actionMenuPresenter2;
        actionMenuPresenter2.L(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        gVar.c(this.f473i, this.f471g);
        ActionMenuView actionMenuView = (ActionMenuView) this.f473i.q(this);
        this.f472h = actionMenuView;
        androidx.core.view.u.m0(actionMenuView, null);
        addView(this.f472h, layoutParams);
    }

    public boolean j() {
        return this.w;
    }

    public void k() {
        removeAllViews();
        this.q = null;
        this.f472h = null;
    }

    public boolean l() {
        ActionMenuPresenter actionMenuPresenter = this.f473i;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.M();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f473i;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.D();
            this.f473i.E();
        }
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            return;
        }
        accessibilityEvent.setSource(this);
        accessibilityEvent.setClassName(getClass().getName());
        accessibilityEvent.setPackageName(getContext().getPackageName());
        accessibilityEvent.setContentDescription(this.n);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean zB = w0.b(this);
        int paddingRight = zB ? (i4 - i2) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
        View view = this.p;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.p.getLayoutParams();
            int i6 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iD = androidx.appcompat.widget.a.d(paddingRight, i6, zB);
            paddingRight = androidx.appcompat.widget.a.d(iD + e(this.p, iD, paddingTop, paddingTop2, zB), i7, zB);
        }
        int iE = paddingRight;
        LinearLayout linearLayout = this.r;
        if (linearLayout != null && this.q == null && linearLayout.getVisibility() != 8) {
            iE += e(this.r, iE, paddingTop, paddingTop2, zB);
        }
        int i8 = iE;
        View view2 = this.q;
        if (view2 != null) {
            e(view2, i8, paddingTop, paddingTop2, zB);
        }
        int paddingLeft = zB ? getPaddingLeft() : (i4 - i2) - getPaddingRight();
        ActionMenuView actionMenuView = this.f472h;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zB);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i3) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i2);
        int size2 = this.f474j;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i3);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.p;
        if (view != null) {
            int iC = c(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.p.getLayoutParams();
            paddingLeft = iC - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f472h;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = c(this.f472h, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.r;
        if (linearLayout != null && this.q == null) {
            if (this.w) {
                this.r.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.r.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.r.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = c(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.q;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i4 = layoutParams.width;
            int i5 = i4 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i4 >= 0) {
                paddingLeft = Math.min(i4, paddingLeft);
            }
            int i6 = layoutParams.height;
            int i7 = i6 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i6 >= 0) {
                iMin = Math.min(i6, iMin);
            }
            this.q.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i5), View.MeasureSpec.makeMeasureSpec(iMin, i7));
        }
        if (this.f474j > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            int measuredHeight = getChildAt(i9).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i8) {
                i8 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i8);
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.a
    public void setContentHeight(int i2) {
        this.f474j = i2;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.q;
        if (view2 != null) {
            removeView(view2);
        }
        this.q = view;
        if (view != null && (linearLayout = this.r) != null) {
            removeView(linearLayout);
            this.r = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.o = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.n = charSequence;
        i();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.w) {
            requestLayout();
        }
        this.w = z;
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.f2693j);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        q0 q0VarV = q0.v(context, attributeSet, c.a.j.y, i2, 0);
        androidx.core.view.u.m0(this, q0VarV.g(c.a.j.z));
        this.u = q0VarV.n(c.a.j.D, 0);
        this.v = q0VarV.n(c.a.j.C, 0);
        this.f474j = q0VarV.m(c.a.j.B, 0);
        this.x = q0VarV.n(c.a.j.A, c.a.g.f2734d);
        q0VarV.w();
    }
}
