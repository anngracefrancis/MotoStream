package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbrb implements zzdti<Context> {
    private final zzbqy a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Context> f14711b;

    private zzbrb(zzbqy zzbqyVar, zzdtu<Context> zzdtuVar) {
        this.a = zzbqyVar;
        this.f14711b = zzdtuVar;
    }

    public static zzbrb a(zzbqy zzbqyVar, zzdtu<Context> zzdtuVar) {
        return new zzbrb(zzbqyVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Context) zzdto.b(this.a.e(this.f14711b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
