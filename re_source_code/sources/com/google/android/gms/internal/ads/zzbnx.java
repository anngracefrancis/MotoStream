package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbnx implements zzdti<zzavf> {
    private final zzbnk a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Context> f14603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcxv> f14604c;

    public zzbnx(zzbnk zzbnkVar, zzdtu<Context> zzdtuVar, zzdtu<zzcxv> zzdtuVar2) {
        this.a = zzbnkVar;
        this.f14603b = zzdtuVar;
        this.f14604c = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzavf) zzdto.b(new zzavf(this.f14603b.get(), this.f14604c.get().f15752f), "Cannot return null from a non-@Nullable @Provides method");
    }
}
