package com.airbnb.lottie.v;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: BaseLottieAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends ValueAnimator {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set<ValueAnimator.AnimatorUpdateListener> f8850f = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set<Animator.AnimatorListener> f8851g = new CopyOnWriteArraySet();

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.f8851g.add(animatorListener);
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f8850f.add(animatorUpdateListener);
    }

    void b() {
        Iterator<Animator.AnimatorListener> it = this.f8851g.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
    }

    void d(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.f8851g) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    void e() {
        Iterator<Animator.AnimatorListener> it = this.f8851g.iterator();
        while (it.hasNext()) {
            it.next().onAnimationRepeat(this);
        }
    }

    void f(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.f8851g) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    void g() {
        Iterator<ValueAnimator.AnimatorUpdateListener> it = this.f8850f.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.f8851g.clear();
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.f8850f.clear();
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.f8851g.remove(animatorListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f8850f.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j2) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j2) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }
}
