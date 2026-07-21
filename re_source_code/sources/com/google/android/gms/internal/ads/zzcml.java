package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcml extends zzcmn<zzbph> {
    private final zzbjm a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbxk f15386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbqy.zza f15387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbtv f15388d;

    public zzcml(zzbjm zzbjmVar, zzbxk zzbxkVar, zzbqy.zza zzaVar, zzbtv zzbtvVar) {
        this.a = zzbjmVar;
        this.f15386b = zzbxkVar;
        this.f15387c = zzaVar;
        this.f15388d = zzbtvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcmn
    protected final zzbbh<zzbph> c(zzcxv zzcxvVar, Bundle bundle) {
        return this.a.l().c(this.f15387c.b(zzcxvVar).h(bundle).c()).a(this.f15388d).d(this.f15386b).b().d();
    }
}
