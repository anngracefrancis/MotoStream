package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcms extends zzcmn<zzcdb> {
    private final zzbjm a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbqy.zza f15410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbtv f15411c;

    public zzcms(zzbjm zzbjmVar, zzbqy.zza zzaVar, zzbtv zzbtvVar) {
        this.a = zzbjmVar;
        this.f15410b = zzaVar;
        this.f15411c = zzbtvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcmn
    protected final zzbbh<zzcdb> c(zzcxv zzcxvVar, Bundle bundle) {
        return this.a.m().a(this.f15410b.b(zzcxvVar).h(bundle).c()).c(this.f15411c).b().c();
    }
}
