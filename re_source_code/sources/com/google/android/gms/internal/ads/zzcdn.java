package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcdn {
    private final zzbhf a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f15101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzcxv f15102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdh f15103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzbai f15104e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.android.gms.ads.internal.zza f15105f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzwj f15106g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzbtb f15107h;

    public zzcdn(zzbhf zzbhfVar, Context context, zzcxv zzcxvVar, zzdh zzdhVar, zzbai zzbaiVar, com.google.android.gms.ads.internal.zza zzaVar, zzwj zzwjVar, zzbtb zzbtbVar) {
        this.a = zzbhfVar;
        this.f15101b = context;
        this.f15102c = zzcxvVar;
        this.f15103d = zzdhVar;
        this.f15104e = zzbaiVar;
        this.f15105f = zzaVar;
        this.f15106g = zzwjVar;
        this.f15107h = zzbtbVar;
    }

    public final zzbgz b(zzyd zzydVar) throws zzbhj {
        return zzbhf.b(this.f15101b, zzbin.i(zzydVar), zzydVar.f16987f, false, false, this.f15103d, this.f15104e, null, new th(this), this.f15105f, this.f15106g);
    }
}
