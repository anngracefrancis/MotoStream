package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcyj implements zzdti<zzcyi> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzawu> f15774b;

    private zzcyj(zzdtu<Context> zzdtuVar, zzdtu<zzawu> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15774b = zzdtuVar2;
    }

    public static zzcyj a(zzdtu<Context> zzdtuVar, zzdtu<zzawu> zzdtuVar2) {
        return new zzcyj(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcyi(this.a.get(), this.f15774b.get());
    }
}
