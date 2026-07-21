package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbmt implements zzdti<zzty> {
    private final zzdtu<zzcxm> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbai> f14564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<JSONObject> f14565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<String> f14566d;

    private zzbmt(zzdtu<zzcxm> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<JSONObject> zzdtuVar3, zzdtu<String> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f14564b = zzdtuVar2;
        this.f14565c = zzdtuVar3;
        this.f14566d = zzdtuVar4;
    }

    public static zzbmt a(zzdtu<zzcxm> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<JSONObject> zzdtuVar3, zzdtu<String> zzdtuVar4) {
        return new zzbmt(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        this.a.get();
        zzbai zzbaiVar = this.f14564b.get();
        JSONObject jSONObject = this.f14565c.get();
        String str = this.f14566d.get();
        boolean zEquals = "native".equals(str);
        zzk.zzlg();
        return (zzty) zzdto.b(new zzty(zzaxi.j0(), zzbaiVar, str, jSONObject, false, zEquals), "Cannot return null from a non-@Nullable @Provides method");
    }
}
