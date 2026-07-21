package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import e.e.b.c.m.i;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i f18844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final i f18845d;

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f18846b;

        a(boolean z, View view) {
            this.a = z;
            this.f18846b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            this.f18846b.setVisibility(4);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.a) {
                this.f18846b.setVisibility(0);
            }
        }
    }

    public FabTransformationScrimBehavior() {
        this.f18844c = new i(75L, 150L);
        this.f18845d = new i(0L, 150L);
    }

    private void K(View view, boolean z, boolean z2, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfFloat;
        i iVar = z ? this.f18844c : this.f18845d;
        if (z) {
            if (!z2) {
                view.setAlpha(0.0f);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f);
        }
        iVar.a(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return super.D(coordinatorLayout, view, motionEvent);
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected AnimatorSet J(View view, View view2, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        K(view2, z, z2, arrayList, new ArrayList());
        AnimatorSet animatorSet = new AnimatorSet();
        e.e.b.c.m.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z, view2));
        return animatorSet;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18844c = new i(75L, 150L);
        this.f18845d = new i(0L, 150L);
    }
}
