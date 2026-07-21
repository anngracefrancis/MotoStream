package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcfj implements zzdti<zzcfi> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<String> f15166b;

    private zzcfj(zzdtu<Context> zzdtuVar, zzdtu<String> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15166b = zzdtuVar2;
    }

    public static zzcfj a(zzdtu<Context> zzdtuVar, zzdtu<String> zzdtuVar2) {
        return new zzcfj(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcfi(this.a.get(), this.f15166b.get());
    }
}
