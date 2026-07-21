package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.u;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import e.e.b.c.k;
import e.e.b.c.l;
import e.e.b.c.m.h;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {
    private static final int w = k.v;
    static final Property<View, Float> x = new b(Float.class, "width");
    static final Property<View, Float> y = new c(Float.class, "height");
    private final com.google.android.material.floatingactionbutton.d A;
    private final com.google.android.material.floatingactionbutton.d B;
    private final com.google.android.material.floatingactionbutton.d C;
    private final CoordinatorLayout.c<ExtendedFloatingActionButton> D;
    private boolean E;
    private final com.google.android.material.floatingactionbutton.d z;

    class a extends AnimatorListenerAdapter {
        private boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.floatingactionbutton.d f18630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f18631c;

        a(com.google.android.material.floatingactionbutton.d dVar, d dVar2) {
            this.f18630b = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
            this.f18630b.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f18630b.e();
            if (this.a) {
                return;
            }
            this.f18630b.i(this.f18631c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f18630b.onAnimationStart(animator);
            this.a = false;
        }
    }

    static class b extends Property<View, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f2) {
            view.getLayoutParams().width = f2.intValue();
            view.requestLayout();
        }
    }

    static class c extends Property<View, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f2) {
            view.getLayoutParams().height = f2.intValue();
            view.requestLayout();
        }
    }

    public static abstract class d {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(com.google.android.material.floatingactionbutton.d dVar, d dVar2) {
        if (dVar.d()) {
            return;
        }
        if (!m()) {
            dVar.b();
            dVar.i(dVar2);
            return;
        }
        measure(0, 0);
        AnimatorSet animatorSetG = dVar.g();
        animatorSetG.addListener(new a(dVar, dVar2));
        Iterator<Animator.AnimatorListener> it = dVar.h().iterator();
        while (it.hasNext()) {
            animatorSetG.addListener(it.next());
        }
        animatorSetG.start();
    }

    private boolean m() {
        return u.O(this) && !isInEditMode();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<ExtendedFloatingActionButton> getBehavior() {
        return this.D;
    }

    int getCollapsedSize() {
        return (Math.min(u.D(this), u.C(this)) * 2) + getIconSize();
    }

    public h getExtendMotionSpec() {
        return this.A.c();
    }

    public h getHideMotionSpec() {
        return this.C.c();
    }

    public h getShowMotionSpec() {
        return this.B.c();
    }

    public h getShrinkMotionSpec() {
        return this.z.c();
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.E && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.E = false;
            this.z.b();
        }
    }

    public void setExtendMotionSpec(h hVar) {
        this.A.f(hVar);
    }

    public void setExtendMotionSpecResource(int i2) {
        setExtendMotionSpec(h.c(getContext(), i2));
    }

    public void setExtended(boolean z) {
        if (this.E == z) {
            return;
        }
        com.google.android.material.floatingactionbutton.d dVar = z ? this.A : this.z;
        if (dVar.d()) {
            return;
        }
        dVar.b();
    }

    public void setHideMotionSpec(h hVar) {
        this.C.f(hVar);
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(h.c(getContext(), i2));
    }

    public void setShowMotionSpec(h hVar) {
        this.B.f(hVar);
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(h.c(getContext(), i2));
    }

    public void setShrinkMotionSpec(h hVar) {
        this.z.f(hVar);
    }

    public void setShrinkMotionSpecResource(int i2) {
        setShrinkMotionSpec(h.c(getContext(), i2));
    }

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c<T> {
        private Rect a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d f18626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private d f18627c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f18628d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f18629e;

        public ExtendedFloatingActionButtonBehavior() {
            this.f18628d = false;
            this.f18629e = true;
        }

        private static boolean G(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean J(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f18628d || this.f18629e) && ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams()).e() == view.getId();
        }

        private boolean L(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            com.google.android.material.internal.b.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        private boolean M(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        protected void E(ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z = this.f18629e;
            extendedFloatingActionButton.l(z ? extendedFloatingActionButton.A : extendedFloatingActionButton.B, z ? this.f18627c : this.f18626b);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.b(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public boolean h(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!G(view)) {
                return false;
            }
            M(view, extendedFloatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i2) {
            List<View> listR = coordinatorLayout.r(extendedFloatingActionButton);
            int size = listR.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = listR.get(i3);
                if (!(view instanceof AppBarLayout)) {
                    if (G(view) && M(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.I(extendedFloatingActionButton, i2);
            return true;
        }

        protected void K(ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z = this.f18629e;
            extendedFloatingActionButton.l(z ? extendedFloatingActionButton.z : extendedFloatingActionButton.C, z ? this.f18627c : this.f18626b);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void g(CoordinatorLayout.f fVar) {
            if (fVar.f826h == 0) {
                fVar.f826h = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.F1);
            this.f18628d = typedArrayObtainStyledAttributes.getBoolean(l.G1, false);
            this.f18629e = typedArrayObtainStyledAttributes.getBoolean(l.H1, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
