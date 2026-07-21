package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: ViewPropertyAnimatorCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class y {
    private WeakReference<View> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Runnable f1077b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Runnable f1078c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f1079d = -1;

    /* JADX INFO: compiled from: ViewPropertyAnimatorCompat.java */
    class a extends AnimatorListenerAdapter {
        final /* synthetic */ z a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f1080b;

        a(z zVar, View view) {
            this.a = zVar;
            this.f1080b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a.onAnimationCancel(this.f1080b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.onAnimationEnd(this.f1080b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.onAnimationStart(this.f1080b);
        }
    }

    /* JADX INFO: compiled from: ViewPropertyAnimatorCompat.java */
    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ b0 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f1082b;

        b(b0 b0Var, View view) {
            this.a = b0Var;
            this.f1082b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.a(this.f1082b);
        }
    }

    /* JADX INFO: compiled from: ViewPropertyAnimatorCompat.java */
    static class c implements z {
        y a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f1084b;

        c(y yVar) {
            this.a = yVar;
        }

        @Override // androidx.core.view.z
        public void onAnimationCancel(View view) {
            Object tag = view.getTag(2113929216);
            z zVar = tag instanceof z ? (z) tag : null;
            if (zVar != null) {
                zVar.onAnimationCancel(view);
            }
        }

        @Override // androidx.core.view.z
        @SuppressLint({"WrongConstant"})
        public void onAnimationEnd(View view) {
            int i2 = this.a.f1079d;
            if (i2 > -1) {
                view.setLayerType(i2, null);
                this.a.f1079d = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f1084b) {
                y yVar = this.a;
                Runnable runnable = yVar.f1078c;
                if (runnable != null) {
                    yVar.f1078c = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                z zVar = tag instanceof z ? (z) tag : null;
                if (zVar != null) {
                    zVar.onAnimationEnd(view);
                }
                this.f1084b = true;
            }
        }

        @Override // androidx.core.view.z
        public void onAnimationStart(View view) {
            this.f1084b = false;
            if (this.a.f1079d > -1) {
                view.setLayerType(2, null);
            }
            y yVar = this.a;
            Runnable runnable = yVar.f1077b;
            if (runnable != null) {
                yVar.f1077b = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            z zVar = tag instanceof z ? (z) tag : null;
            if (zVar != null) {
                zVar.onAnimationStart(view);
            }
        }
    }

    y(View view) {
        this.a = new WeakReference<>(view);
    }

    private void g(View view, z zVar) {
        if (zVar != null) {
            view.animate().setListener(new a(zVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public y a(float f2) {
        View view = this.a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    public void b() {
        View view = this.a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long c() {
        View view = this.a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public y d(long j2) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
        return this;
    }

    public y e(Interpolator interpolator) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public y f(z zVar) {
        View view = this.a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                g(view, zVar);
            } else {
                view.setTag(2113929216, zVar);
                g(view, new c(this));
            }
        }
        return this;
    }

    public y h(long j2) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setStartDelay(j2);
        }
        return this;
    }

    public y i(b0 b0Var) {
        View view = this.a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(b0Var != null ? new b(b0Var, view) : null);
        }
        return this;
    }

    public void j() {
        View view = this.a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public y k(float f2) {
        View view = this.a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }
}
