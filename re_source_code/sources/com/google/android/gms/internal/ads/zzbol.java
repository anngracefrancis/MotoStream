package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbol extends zzbnf {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzaga f14619f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Runnable f14620g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Executor f14621h;

    public zzbol(zzaga zzagaVar, Runnable runnable, Executor executor) {
        this.f14619f = zzagaVar;
        this.f14620g = runnable;
        this.f14621h = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzbpc
    public final void c() {
        final AtomicReference atomicReference = new AtomicReference(this.f14620g);
        final Runnable runnable = new Runnable(atomicReference) { // from class: com.google.android.gms.internal.ads.dd

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final AtomicReference f12477f;

            {
                this.f12477f = atomicReference;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Runnable runnable2 = (Runnable) this.f12477f.getAndSet(null);
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        };
        this.f14621h.execute(new Runnable(this, runnable) { // from class: com.google.android.gms.internal.ads.ed

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbol f12530f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final Runnable f12531g;

            {
                this.f12530f = this;
                this.f12531g = runnable;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12530f.m(this.f12531g);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final zzaar g() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final void h(ViewGroup viewGroup, zzyd zzydVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final View i() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final zzcxn j() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final int k() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final void l() {
    }

    final /* synthetic */ void m(Runnable runnable) {
        try {
            if (this.f14619f.W2(ObjectWrapper.E0(runnable))) {
                return;
            }
            runnable.run();
        } catch (RemoteException unused) {
            runnable.run();
        }
    }
}
