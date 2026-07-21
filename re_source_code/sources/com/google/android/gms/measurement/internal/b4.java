package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class b4 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzm f17700f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzgc f17701g;

    b4(zzgc zzgcVar, zzm zzmVar) {
        this.f17701g = zzgcVar;
        this.f17700f = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17701g.f18163f.e0();
        zzkc zzkcVar = this.f17701g.f18163f;
        zzm zzmVar = this.f17700f;
        zzkcVar.g().d();
        zzkcVar.c0();
        Preconditions.g(zzmVar.f18234f);
        zzkcVar.T(zzmVar);
    }
}
