package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcmq extends zzcmn<zzbvx> {
    private final zzbjm a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbqy.zza f15404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzcow f15405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbtv f15406d;

    public zzcmq(zzbjm zzbjmVar, zzbqy.zza zzaVar, zzcow zzcowVar, zzbtv zzbtvVar) {
        this.a = zzbjmVar;
        this.f15404b = zzaVar;
        this.f15405c = zzcowVar;
        this.f15406d = zzbtvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcmn
    protected final zzbbh<zzbvx> c(zzcxv zzcxvVar, Bundle bundle) {
        return this.a.k().c(this.f15404b.b(zzcxvVar).h(bundle).c()).d(this.f15406d).b(this.f15405c).a().c();
    }
}
