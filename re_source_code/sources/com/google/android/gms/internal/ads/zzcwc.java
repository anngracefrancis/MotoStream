package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcwc implements zzcva<zzcwb> {
    zzvx a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzbbl f15700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Context f15701c;

    public zzcwc(zzvx zzvxVar, zzbbl zzbblVar, Context context) {
        this.a = zzvxVar;
        this.f15700b = zzbblVar;
        this.f15701c = context;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcwb> b() {
        return this.f15700b.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.lp

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzcwc f12940f;

            {
                this.f12940f = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzcwc zzcwcVar = this.f12940f;
                return new zzcwb(zzcwcVar.a.a(zzcwcVar.f15701c));
            }
        });
    }
}
