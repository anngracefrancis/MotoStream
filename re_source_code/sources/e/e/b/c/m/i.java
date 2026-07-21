package e.e.b.c.m;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: compiled from: MotionTiming.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {
    private long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f21058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TimeInterpolator f21059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f21060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f21061e;

    public i(long j2, long j3) {
        this.a = 0L;
        this.f21058b = 300L;
        this.f21059c = null;
        this.f21060d = 0;
        this.f21061e = 1;
        this.a = j2;
        this.f21058b = j3;
    }

    static i b(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        iVar.f21060d = valueAnimator.getRepeatCount();
        iVar.f21061e = valueAnimator.getRepeatMode();
        return iVar;
    }

    private static TimeInterpolator f(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
            return a.f21050b;
        }
        if (interpolator instanceof AccelerateInterpolator) {
            return a.f21051c;
        }
        return interpolator instanceof DecelerateInterpolator ? a.f21052d : interpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.a;
    }

    public long d() {
        return this.f21058b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f21059c;
        return timeInterpolator != null ? timeInterpolator : a.f21050b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (c() == iVar.c() && d() == iVar.d() && g() == iVar.g() && h() == iVar.h()) {
            return e().getClass().equals(iVar.e().getClass());
        }
        return false;
    }

    public int g() {
        return this.f21060d;
    }

    public int h() {
        return this.f21061e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    public String toString() {
        return '\n' + i.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }

    public i(long j2, long j3, TimeInterpolator timeInterpolator) {
        this.a = 0L;
        this.f21058b = 300L;
        this.f21059c = null;
        this.f21060d = 0;
        this.f21061e = 1;
        this.a = j2;
        this.f21058b = j3;
        this.f21059c = timeInterpolator;
    }
}
