package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import java.util.ArrayList;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: FragmentContainerView.java */
/* JADX INFO: loaded from: classes.dex */
public final class g extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<View> f1613f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList<View> f1614g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1615h;

    g(Context context, AttributeSet attributeSet, FragmentManager fragmentManager) {
        String str;
        super(context, attributeSet);
        this.f1615h = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.m.c.f3350h);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(c.m.c.f3351i) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(c.m.c.f3352j);
        typedArrayObtainStyledAttributes.recycle();
        int id = getId();
        Fragment fragmentI0 = fragmentManager.i0(id);
        if (classAttribute == null || fragmentI0 != null) {
            return;
        }
        if (id > 0) {
            Fragment fragmentA = fragmentManager.t0().a(context.getClassLoader(), classAttribute);
            fragmentA.onInflate(context, attributeSet, (Bundle) null);
            fragmentManager.m().u(true).d(this, fragmentA, string).l();
            return;
        }
        if (string != null) {
            str = " with tag " + string;
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
    }

    private void a(View view) {
        ArrayList<View> arrayList = this.f1614g;
        if (arrayList == null || !arrayList.contains(view)) {
            return;
        }
        if (this.f1613f == null) {
            this.f1613f = new ArrayList<>();
        }
        this.f1613f.add(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (FragmentManager.C0(view) != null) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (FragmentManager.C0(view) != null) {
            return super.addViewInLayout(view, i2, layoutParams, z);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f1615h && this.f1613f != null) {
            for (int i2 = 0; i2 < this.f1613f.size(); i2++) {
                super.drawChild(canvas, this.f1613f.get(i2), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        ArrayList<View> arrayList;
        if (!this.f1615h || (arrayList = this.f1613f) == null || arrayList.size() <= 0 || !this.f1613f.contains(view)) {
            return super.drawChild(canvas, view, j2);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        ArrayList<View> arrayList = this.f1614g;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList<View> arrayList2 = this.f1613f;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f1615h = true;
            }
        }
        super.endViewTransition(view);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            getChildAt(i2).dispatchApplyWindowInsets(new WindowInsets(windowInsets));
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z) {
        if (z) {
            a(view);
        }
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i2) {
        a(getChildAt(i2));
        super.removeViewAt(i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            a(getChildAt(i4));
        }
        super.removeViews(i2, i3);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            a(getChildAt(i4));
        }
        super.removeViewsInLayout(i2, i3);
    }

    void setDrawDisappearingViewsLast(boolean z) {
        this.f1615h = z;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT >= 18) {
            throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
        }
        super.setLayoutTransition(layoutTransition);
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.f1614g == null) {
                this.f1614g = new ArrayList<>();
            }
            this.f1614g.add(view);
        }
        super.startViewTransition(view);
    }
}
