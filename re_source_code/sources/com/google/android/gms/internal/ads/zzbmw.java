package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbmw implements zzdti<Set<zzbuz<zzue>>> {
    private final zzdtu<zzbmn> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Executor> f14569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<JSONObject> f14570c;

    private zzbmw(zzdtu<zzbmn> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<JSONObject> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f14569b = zzdtuVar2;
        this.f14570c = zzdtuVar3;
    }

    public static zzbmw a(zzdtu<zzbmn> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<JSONObject> zzdtuVar3) {
        return new zzbmw(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.b(this.f14570c.get() == null ? Collections.emptySet() : Collections.singleton(new zzbuz(this.a.get(), this.f14569b.get())), "Cannot return null from a non-@Nullable @Provides method");
    }
}
