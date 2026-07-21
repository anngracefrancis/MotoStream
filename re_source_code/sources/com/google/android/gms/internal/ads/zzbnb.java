package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbnb implements zzdti<JSONObject> {
    private final zzdtu<zzcxm> a;

    private zzbnb(zzdtu<zzcxm> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzbnb a(zzdtu<zzcxm> zzdtuVar) {
        return new zzbnb(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zzbna.a(this.a.get());
    }
}
