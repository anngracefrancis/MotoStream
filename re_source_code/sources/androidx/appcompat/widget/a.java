package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: AbsActionBarView.java */
/* JADX INFO: loaded from: classes.dex */
abstract class a extends ViewGroup {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final C0012a f470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final Context f471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected ActionMenuView f472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected ActionMenuPresenter f473i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f474j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected androidx.core.view.y f475k;
    private boolean l;
    private boolean m;

    /* JADX INFO: renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbsActionBarView.java */
    protected class C0012a implements androidx.core.view.z {
        private boolean a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f476b;

        protected C0012a() {
        }

        public C0012a a(androidx.core.view.y yVar, int i2) {
            a.this.f475k = yVar;
            this.f476b = i2;
            return this;
        }

        @Override // androidx.core.view.z
        public void onAnimationCancel(View view) {
            this.a = true;
        }

        @Override // androidx.core.view.z
        public void onAnimationEnd(View view) {
            if (this.a) {
                return;
            }
            a aVar = a.this;
            aVar.f475k = null;
            a.super.setVisibility(this.f476b);
        }

        @Override // androidx.core.view.z
        public void onAnimationStart(View view) {
            a.super.setVisibility(0);
            this.a = false;
        }
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected static int d(int i2, int i3, boolean z) {
        return z ? i2 - i3 : i2 + i3;
    }

    protected int c(View view, int i2, int i3, int i4) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), i3);
        return Math.max(0, (i2 - view.getMeasuredWidth()) - i4);
    }

    protected int e(View view, int i2, int i3, int i4, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = i3 + ((i4 - measuredHeight) / 2);
        if (z) {
            view.layout(i2 - measuredWidth, i5, i2, measuredHeight + i5);
        } else {
            view.layout(i2, i5, i2 + measuredWidth, measuredHeight + i5);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public androidx.core.view.y f(int i2, long j2) {
        androidx.core.view.y yVar = this.f475k;
        if (yVar != null) {
            yVar.b();
        }
        if (i2 != 0) {
            androidx.core.view.y yVarA = androidx.core.view.u.c(this).a(0.0f);
            yVarA.d(j2);
            yVarA.f(this.f470f.a(yVarA, i2));
            return yVarA;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        androidx.core.view.y yVarA2 = androidx.core.view.u.c(this).a(1.0f);
        yVarA2.d(j2);
        yVarA2.f(this.f470f.a(yVarA2, i2));
        return yVarA2;
    }

    public int getAnimatedVisibility() {
        return this.f475k != null ? this.f470f.f476b : getVisibility();
    }

    public int getContentHeight() {
        return this.f474j;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, c.a.j.a, c.a.a.f2686c, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(c.a.j.f2764j, 0));
        typedArrayObtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f473i;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.H(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.m = false;
        }
        if (!this.m) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.m = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.m = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.l = false;
        }
        if (!this.l) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.l = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.l = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i2);

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            androidx.core.view.y yVar = this.f475k;
            if (yVar != null) {
                yVar.b();
            }
            super.setVisibility(i2);
        }
    }

    a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f470f = new C0012a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(c.a.a.a, typedValue, true) || typedValue.resourceId == 0) {
            this.f471g = context;
        } else {
            this.f471g = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }
}
