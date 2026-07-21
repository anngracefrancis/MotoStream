package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcmo extends zzcmn<zzbnf> {
    private final zzbjm a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbqy.zza f15392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzcow f15393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbtv f15394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzbxk f15395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbtb f15396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ViewGroup f15397g;

    public zzcmo(zzbjm zzbjmVar, zzbqy.zza zzaVar, zzcow zzcowVar, zzbtv zzbtvVar, zzbxk zzbxkVar, zzbtb zzbtbVar, ViewGroup viewGroup) {
        this.a = zzbjmVar;
        this.f15392b = zzaVar;
        this.f15393c = zzcowVar;
        this.f15394d = zzbtvVar;
        this.f15395e = zzbxkVar;
        this.f15396f = zzbtbVar;
        this.f15397g = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzcmn
    protected final zzbbh<zzbnf> c(zzcxv zzcxvVar, Bundle bundle) {
        return this.a.j().f(this.f15392b.b(zzcxvVar).h(bundle).c()).a(this.f15394d).e(this.f15393c).g(this.f15395e).c(new zzbox(this.f15396f)).d(new zzbnc(this.f15397g)).b().d();
    }
}
