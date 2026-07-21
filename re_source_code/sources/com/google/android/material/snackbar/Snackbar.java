package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import e.e.b.c.h;

/* JADX INFO: loaded from: classes2.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] w;
    private static final int[] x;
    private BaseTransientBottomBar.r<Snackbar> A;
    private final AccessibilityManager y;
    private boolean z;

    public static final class SnackbarLayout extends BaseTransientBottomBar.v {
        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.v, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.v, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.v, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.v, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.v, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }
    }

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f18752f;

        a(View.OnClickListener onClickListener) {
            this.f18752f = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f18752f.onClick(view);
            Snackbar.this.u(1);
        }
    }

    public static class b extends BaseTransientBottomBar.r<Snackbar> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.r
        public void onDismissed(Snackbar snackbar, int i2) {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.r
        public void onShown(Snackbar snackbar) {
        }
    }

    static {
        int i2 = e.e.b.c.b.z;
        w = new int[]{i2};
        x = new int[]{i2, e.e.b.c.b.B};
    }

    private Snackbar(ViewGroup viewGroup, View view, com.google.android.material.snackbar.a aVar) {
        super(viewGroup, view, aVar);
        this.y = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    private static ViewGroup X(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    private static boolean Y(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(x);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        typedArrayObtainStyledAttributes.recycle();
        return (resourceId == -1 || resourceId2 == -1) ? false : true;
    }

    public static Snackbar Z(View view, int i2, int i3) {
        return a0(view, view.getResources().getText(i2), i3);
    }

    public static Snackbar a0(View view, CharSequence charSequence, int i2) {
        ViewGroup viewGroupX = X(view);
        if (viewGroupX == null) {
            throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        }
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(viewGroupX.getContext()).inflate(Y(viewGroupX.getContext()) ? h.o : h.f21012d, viewGroupX, false);
        Snackbar snackbar = new Snackbar(viewGroupX, snackbarContentLayout, snackbarContentLayout);
        snackbar.e0(charSequence);
        snackbar.L(i2);
        return snackbar;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void P() {
        super.P();
    }

    public Snackbar b0(int i2, View.OnClickListener onClickListener) {
        return c0(w().getText(i2), onClickListener);
    }

    public Snackbar c0(CharSequence charSequence, View.OnClickListener onClickListener) {
        Button actionView = ((SnackbarContentLayout) this.f18731g.getChildAt(0)).getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
            this.z = false;
        } else {
            this.z = true;
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new a(onClickListener));
        }
        return this;
    }

    @Deprecated
    public Snackbar d0(b bVar) {
        BaseTransientBottomBar.r<Snackbar> rVar = this.A;
        if (rVar != null) {
            K(rVar);
        }
        if (bVar != null) {
            p(bVar);
        }
        this.A = bVar;
        return this;
    }

    public Snackbar e0(CharSequence charSequence) {
        ((SnackbarContentLayout) this.f18731g.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void t() {
        super.t();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int x() {
        int iX = super.x();
        if (iX == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.y.getRecommendedTimeoutMillis(iX, (this.z ? 4 : 0) | 1 | 2);
        }
        if (this.z && this.y.isTouchExplorationEnabled()) {
            return -2;
        }
        return iX;
    }
}
