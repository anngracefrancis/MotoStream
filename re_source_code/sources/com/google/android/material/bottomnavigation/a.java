package com.google.android.material.bottomnavigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.s0;
import androidx.core.view.s;
import androidx.core.view.u;
import androidx.core.widget.k;
import com.google.android.material.badge.BadgeDrawable;
import e.e.b.c.d;
import e.e.b.c.e;
import e.e.b.c.f;
import e.e.b.c.h;
import e.e.b.c.j;

/* JADX INFO: compiled from: BottomNavigationItemView.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends FrameLayout implements n.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f18466f = {R.attr.state_checked};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f18467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f18468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f18469i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f18470j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f18471k;
    private boolean l;
    private ImageView m;
    private final TextView n;
    private final TextView o;
    private int p;
    private i q;
    private ColorStateList r;
    private Drawable s;
    private Drawable t;
    private BadgeDrawable u;

    /* JADX INFO: renamed from: com.google.android.material.bottomnavigation.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BottomNavigationItemView.java */
    class ViewOnLayoutChangeListenerC0193a implements View.OnLayoutChangeListener {
        ViewOnLayoutChangeListenerC0193a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (a.this.m.getVisibility() == 0) {
                a aVar = a.this;
                aVar.m(aVar.m);
            }
        }
    }

    public a(Context context) {
        this(context, null);
    }

    private void c(float f2, float f3) {
        this.f18468h = f2 - f3;
        this.f18469i = (f3 * 1.0f) / f2;
        this.f18470j = (f2 * 1.0f) / f3;
    }

    private FrameLayout f(View view) {
        ImageView imageView = this.m;
        if (view == imageView && com.google.android.material.badge.a.a) {
            return (FrameLayout) imageView.getParent();
        }
        return null;
    }

    private boolean g() {
        return this.u != null;
    }

    private void i(View view, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i2;
        layoutParams.gravity = i3;
        view.setLayoutParams(layoutParams);
    }

    private void j(View view, float f2, float f3, int i2) {
        view.setScaleX(f2);
        view.setScaleY(f3);
        view.setVisibility(i2);
    }

    private void k(View view) {
        if (g() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            com.google.android.material.badge.a.a(this.u, view, f(view));
        }
    }

    private void l(View view) {
        if (g()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                com.google.android.material.badge.a.d(this.u, view, f(view));
            }
            this.u = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(View view) {
        if (g()) {
            com.google.android.material.badge.a.e(this.u, view, f(view));
        }
    }

    @Override // androidx.appcompat.view.menu.n.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void e(i iVar, int i2) {
        this.q = iVar;
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setIcon(iVar.getIcon());
        setTitle(iVar.getTitle());
        setId(iVar.getItemId());
        if (!TextUtils.isEmpty(iVar.getContentDescription())) {
            setContentDescription(iVar.getContentDescription());
        }
        s0.a(this, !TextUtils.isEmpty(iVar.getTooltipText()) ? iVar.getTooltipText() : iVar.getTitle());
        setVisibility(iVar.isVisible() ? 0 : 8);
    }

    BadgeDrawable getBadge() {
        return this.u;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public i getItemData() {
        return this.q;
    }

    public int getItemPosition() {
        return this.p;
    }

    void h() {
        l(this.m);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        i iVar = this.q;
        if (iVar != null && iVar.isCheckable() && this.q.isChecked()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, f18466f);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.u;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            CharSequence title = this.q.getTitle();
            if (!TextUtils.isEmpty(this.q.getContentDescription())) {
                title = this.q.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.u.f()));
        }
        androidx.core.view.d0.c cVarY0 = androidx.core.view.d0.c.y0(accessibilityNodeInfo);
        cVarY0.b0(androidx.core.view.d0.c.C0025c.f(0, 1, getItemPosition(), 1, false, isSelected()));
        if (isSelected()) {
            cVarY0.Z(false);
            cVarY0.Q(androidx.core.view.d0.c.a.f1038e);
        }
        cVarY0.p0(getResources().getString(j.f21025g));
    }

    void setBadge(BadgeDrawable badgeDrawable) {
        this.u = badgeDrawable;
        ImageView imageView = this.m;
        if (imageView != null) {
            k(imageView);
        }
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        TextView textView = this.o;
        textView.setPivotX(textView.getWidth() / 2);
        TextView textView2 = this.o;
        textView2.setPivotY(textView2.getBaseline());
        TextView textView3 = this.n;
        textView3.setPivotX(textView3.getWidth() / 2);
        TextView textView4 = this.n;
        textView4.setPivotY(textView4.getBaseline());
        int i2 = this.f18471k;
        if (i2 != -1) {
            if (i2 == 0) {
                if (z) {
                    i(this.m, this.f18467g, 49);
                    j(this.o, 1.0f, 1.0f, 0);
                } else {
                    i(this.m, this.f18467g, 17);
                    j(this.o, 0.5f, 0.5f, 4);
                }
                this.n.setVisibility(4);
            } else if (i2 != 1) {
                if (i2 == 2) {
                    i(this.m, this.f18467g, 17);
                    this.o.setVisibility(8);
                    this.n.setVisibility(8);
                }
            } else if (z) {
                i(this.m, (int) (this.f18467g + this.f18468h), 49);
                j(this.o, 1.0f, 1.0f, 0);
                TextView textView5 = this.n;
                float f2 = this.f18469i;
                j(textView5, f2, f2, 4);
            } else {
                i(this.m, this.f18467g, 49);
                TextView textView6 = this.o;
                float f3 = this.f18470j;
                j(textView6, f3, f3, 4);
                j(this.n, 1.0f, 1.0f, 0);
            }
        } else if (this.l) {
            if (z) {
                i(this.m, this.f18467g, 49);
                j(this.o, 1.0f, 1.0f, 0);
            } else {
                i(this.m, this.f18467g, 17);
                j(this.o, 0.5f, 0.5f, 4);
            }
            this.n.setVisibility(4);
        } else if (z) {
            i(this.m, (int) (this.f18467g + this.f18468h), 49);
            j(this.o, 1.0f, 1.0f, 0);
            TextView textView7 = this.n;
            float f4 = this.f18469i;
            j(textView7, f4, f4, 4);
        } else {
            i(this.m, this.f18467g, 49);
            TextView textView8 = this.o;
            float f5 = this.f18470j;
            j(textView8, f5, f5, 4);
            j(this.n, 1.0f, 1.0f, 0);
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.n.setEnabled(z);
        this.o.setEnabled(z);
        this.m.setEnabled(z);
        if (z) {
            u.x0(this, s.b(getContext(), 1002));
        } else {
            u.x0(this, null);
        }
    }

    public void setIcon(Drawable drawable) {
        if (drawable == this.s) {
            return;
        }
        this.s = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            this.t = drawable;
            ColorStateList colorStateList = this.r;
            if (colorStateList != null) {
                androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            }
        }
        this.m.setImageDrawable(drawable);
    }

    public void setIconSize(int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i2;
        this.m.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.r = colorStateList;
        if (this.q == null || (drawable = this.t) == null) {
            return;
        }
        androidx.core.graphics.drawable.a.o(drawable, colorStateList);
        this.t.invalidateSelf();
    }

    public void setItemBackground(int i2) {
        setItemBackground(i2 == 0 ? null : androidx.core.content.a.f(getContext(), i2));
    }

    public void setItemPosition(int i2) {
        this.p = i2;
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f18471k != i2) {
            this.f18471k = i2;
            i iVar = this.q;
            if (iVar != null) {
                setChecked(iVar.isChecked());
            }
        }
    }

    public void setShifting(boolean z) {
        if (this.l != z) {
            this.l = z;
            i iVar = this.q;
            if (iVar != null) {
                setChecked(iVar.isChecked());
            }
        }
    }

    public void setTextAppearanceActive(int i2) {
        k.n(this.o, i2);
        c(this.n.getTextSize(), this.o.getTextSize());
    }

    public void setTextAppearanceInactive(int i2) {
        k.n(this.n, i2);
        c(this.n.getTextSize(), this.o.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.n.setTextColor(colorStateList);
            this.o.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.n.setText(charSequence);
        this.o.setText(charSequence);
        i iVar = this.q;
        if (iVar == null || TextUtils.isEmpty(iVar.getContentDescription())) {
            setContentDescription(charSequence);
        }
        i iVar2 = this.q;
        if (iVar2 != null && !TextUtils.isEmpty(iVar2.getTooltipText())) {
            charSequence = this.q.getTooltipText();
        }
        s0.a(this, charSequence);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.p = -1;
        Resources resources = getResources();
        LayoutInflater.from(context).inflate(h.a, (ViewGroup) this, true);
        setBackgroundResource(e.a);
        this.f18467g = resources.getDimensionPixelSize(d.f20988h);
        this.m = (ImageView) findViewById(f.f21004g);
        TextView textView = (TextView) findViewById(f.A);
        this.n = textView;
        TextView textView2 = (TextView) findViewById(f.f21005h);
        this.o = textView2;
        u.t0(textView, 2);
        u.t0(textView2, 2);
        setFocusable(true);
        c(textView.getTextSize(), textView2.getTextSize());
        ImageView imageView = this.m;
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0193a());
        }
    }

    public void setItemBackground(Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        u.m0(this, drawable);
    }
}
