package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcrg implements zzdti<zzcre> {
    private final zzdtu<zzbbl> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Context> f15564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcxv> f15565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<ViewGroup> f15566d;

    public zzcrg(zzdtu<zzbbl> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3, zzdtu<ViewGroup> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f15564b = zzdtuVar2;
        this.f15565c = zzdtuVar3;
        this.f15566d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcre(this.a.get(), this.f15564b.get(), this.f15565c.get(), this.f15566d.get());
    }
}
