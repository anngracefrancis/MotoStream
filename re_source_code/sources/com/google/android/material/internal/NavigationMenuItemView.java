package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.c0;
import androidx.appcompat.widget.s0;
import androidx.core.view.u;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class NavigationMenuItemView extends d implements n.a {
    private static final int[] A = {R.attr.state_checked};
    private int B;
    private boolean C;
    boolean D;
    private final CheckedTextView E;
    private FrameLayout F;
    private androidx.appcompat.view.menu.i G;
    private ColorStateList H;
    private boolean I;
    private Drawable J;
    private final androidx.core.view.a K;

    class a extends androidx.core.view.a {
        a() {
        }

        @Override // androidx.core.view.a
        public void g(View view, androidx.core.view.d0.c cVar) {
            super.g(view, cVar);
            cVar.W(NavigationMenuItemView.this.D);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void B() {
        if (D()) {
            this.E.setVisibility(8);
            FrameLayout frameLayout = this.F;
            if (frameLayout != null) {
                c0.a aVar = (c0.a) frameLayout.getLayoutParams();
                ((ViewGroup.MarginLayoutParams) aVar).width = -1;
                this.F.setLayoutParams(aVar);
                return;
            }
            return;
        }
        this.E.setVisibility(0);
        FrameLayout frameLayout2 = this.F;
        if (frameLayout2 != null) {
            c0.a aVar2 = (c0.a) frameLayout2.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) aVar2).width = -2;
            this.F.setLayoutParams(aVar2);
        }
    }

    private StateListDrawable C() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(c.a.a.v, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(A, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private boolean D() {
        return this.G.getTitle() == null && this.G.getIcon() == null && this.G.getActionView() != null;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.F == null) {
                this.F = (FrameLayout) ((ViewStub) findViewById(e.e.b.c.f.f21002e)).inflate();
            }
            this.F.removeAllViews();
            this.F.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.n.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void e(androidx.appcompat.view.menu.i iVar, int i2) {
        this.G = iVar;
        if (iVar.getItemId() > 0) {
            setId(iVar.getItemId());
        }
        setVisibility(iVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            u.m0(this, C());
        }
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setTitle(iVar.getTitle());
        setIcon(iVar.getIcon());
        setActionView(iVar.getActionView());
        setContentDescription(iVar.getContentDescription());
        s0.a(this, iVar.getTooltipText());
        B();
    }

    @Override // androidx.appcompat.view.menu.n.a
    public androidx.appcompat.view.menu.i getItemData() {
        return this.G;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        androidx.appcompat.view.menu.i iVar = this.G;
        if (iVar != null && iVar.isCheckable() && this.G.isChecked()) {
            ViewGroup.mergeDrawableStates(iArrOnCreateDrawableState, A);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.D != z) {
            this.D = z;
            this.K.l(this.E, RecyclerView.l.FLAG_MOVED);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.E.setChecked(z);
    }

    public void setHorizontalPadding(int i2) {
        setPadding(i2, 0, i2, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.I) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
                androidx.core.graphics.drawable.a.o(drawable, this.H);
            }
            int i2 = this.B;
            drawable.setBounds(0, 0, i2, i2);
        } else if (this.C) {
            if (this.J == null) {
                Drawable drawableD = androidx.core.content.d.f.d(getResources(), e.e.b.c.e.f20998h, getContext().getTheme());
                this.J = drawableD;
                if (drawableD != null) {
                    int i3 = this.B;
                    drawableD.setBounds(0, 0, i3, i3);
                }
            }
            drawable = this.J;
        }
        androidx.core.widget.k.i(this.E, drawable, null, null, null);
    }

    public void setIconPadding(int i2) {
        this.E.setCompoundDrawablePadding(i2);
    }

    public void setIconSize(int i2) {
        this.B = i2;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.H = colorStateList;
        this.I = colorStateList != null;
        androidx.appcompat.view.menu.i iVar = this.G;
        if (iVar != null) {
            setIcon(iVar.getIcon());
        }
    }

    public void setMaxLines(int i2) {
        this.E.setMaxLines(i2);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.C = z;
    }

    public void setTextAppearance(int i2) {
        androidx.core.widget.k.n(this.E, i2);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.E.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.E.setText(charSequence);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a aVar = new a();
        this.K = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(e.e.b.c.h.f21013e, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(e.e.b.c.d.m));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(e.e.b.c.f.f21003f);
        this.E = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        u.i0(checkedTextView, aVar);
    }
}
