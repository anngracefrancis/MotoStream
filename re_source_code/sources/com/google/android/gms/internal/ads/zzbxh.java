package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbxh implements zzdti<zzbxg> {
    private final zzdtu<zzavf> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Context> f14808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzavg> f14809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<View> f14810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<Integer> f14811e;

    private zzbxh(zzdtu<zzavf> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<zzavg> zzdtuVar3, zzdtu<View> zzdtuVar4, zzdtu<Integer> zzdtuVar5) {
        this.a = zzdtuVar;
        this.f14808b = zzdtuVar2;
        this.f14809c = zzdtuVar3;
        this.f14810d = zzdtuVar4;
        this.f14811e = zzdtuVar5;
    }

    public static zzbxh a(zzdtu<zzavf> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<zzavg> zzdtuVar3, zzdtu<View> zzdtuVar4, zzdtu<Integer> zzdtuVar5) {
        return new zzbxh(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbxg(this.a.get(), this.f14808b.get(), this.f14809c.get(), this.f14810d.get(), this.f14811e.get().intValue());
    }
}
