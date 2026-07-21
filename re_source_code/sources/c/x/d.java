package c.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: Fade.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends j0 {

    /* JADX INFO: compiled from: Fade.java */
    class a extends n {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // c.x.m.f
        public void c(m mVar) {
            c0.g(this.a, 1.0f);
            c0.a(this.a);
            mVar.T(this);
        }
    }

    /* JADX INFO: compiled from: Fade.java */
    private static class b extends AnimatorListenerAdapter {
        private final View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f3548b = false;

        b(View view) {
            this.a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c0.g(this.a, 1.0f);
            if (this.f3548b) {
                this.a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (androidx.core.view.u.K(this.a) && this.a.getLayerType() == 0) {
                this.f3548b = true;
                this.a.setLayerType(2, null);
            }
        }
    }

    public d(int i2) {
        r0(i2);
    }

    private Animator s0(View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        c0.g(view, f2);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, c0.f3545b, f3);
        objectAnimatorOfFloat.addListener(new b(view));
        b(new a(view));
        return objectAnimatorOfFloat;
    }

    private static float t0(s sVar, float f2) {
        Float f3;
        return (sVar == null || (f3 = (Float) sVar.a.get("android:fade:transitionAlpha")) == null) ? f2 : f3.floatValue();
    }

    @Override // c.x.j0, c.x.m
    public void k(s sVar) {
        super.k(sVar);
        sVar.a.put("android:fade:transitionAlpha", Float.valueOf(c0.c(sVar.f3608b)));
    }

    @Override // c.x.j0
    public Animator m0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        float fT0 = t0(sVar, 0.0f);
        return s0(view, fT0 != 1.0f ? fT0 : 0.0f, 1.0f);
    }

    @Override // c.x.j0
    public Animator o0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        c0.e(view);
        return s0(view, t0(sVar, 1.0f), 0.0f);
    }
}
