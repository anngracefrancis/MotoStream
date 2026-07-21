package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbmv implements zzdti<Set<zzbuz<zzbrx>>> {
    private final zzdtu<zzbmn> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Executor> f14567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<JSONObject> f14568c;

    private zzbmv(zzdtu<zzbmn> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<JSONObject> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f14567b = zzdtuVar2;
        this.f14568c = zzdtuVar3;
    }

    public static zzbmv a(zzdtu<zzbmn> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<JSONObject> zzdtuVar3) {
        return new zzbmv(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.b(this.f14568c.get() == null ? Collections.emptySet() : Collections.singleton(new zzbuz(this.a.get(), this.f14567b.get())), "Cannot return null from a non-@Nullable @Provides method");
    }
}
