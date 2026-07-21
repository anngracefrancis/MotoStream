package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbyd implements zzdti<JSONObject> {
    private final zzbyc a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbyx> f14846b;

    public zzbyd(zzbyc zzbycVar, zzdtu<zzbyx> zzdtuVar) {
        this.a = zzbycVar;
        this.f14846b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return this.f14846b.get().a();
    }
}
