package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* JADX INFO: compiled from: StateListAnimator.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    private final ArrayList<b> a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f18700b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ValueAnimator f18701c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Animator.AnimatorListener f18702d = new a();

    /* JADX INFO: compiled from: StateListAnimator.java */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f fVar = f.this;
            if (fVar.f18701c == animator) {
                fVar.f18701c = null;
            }
        }
    }

    /* JADX INFO: compiled from: StateListAnimator.java */
    static class b {
        final int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ValueAnimator f18703b;

        b(int[] iArr, ValueAnimator valueAnimator) {
            this.a = iArr;
            this.f18703b = valueAnimator;
        }
    }

    private void b() {
        ValueAnimator valueAnimator = this.f18701c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f18701c = null;
        }
    }

    private void e(b bVar) {
        ValueAnimator valueAnimator = bVar.f18703b;
        this.f18701c = valueAnimator;
        valueAnimator.start();
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f18702d);
        this.a.add(bVar);
    }

    public void c() {
        ValueAnimator valueAnimator = this.f18701c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f18701c = null;
        }
    }

    public void d(int[] iArr) {
        b bVar;
        int size = this.a.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                bVar = null;
                break;
            }
            bVar = this.a.get(i2);
            if (StateSet.stateSetMatches(bVar.a, iArr)) {
                break;
            } else {
                i2++;
            }
        }
        b bVar2 = this.f18700b;
        if (bVar == bVar2) {
            return;
        }
        if (bVar2 != null) {
            b();
        }
        this.f18700b = bVar;
        if (bVar != null) {
            e(bVar);
        }
    }
}
