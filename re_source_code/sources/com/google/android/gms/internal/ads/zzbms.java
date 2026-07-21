package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbms implements zzdti<Set<zzbuz<zzbrw>>> {
    private final zzdtu<zzbmn> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Executor> f14562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<JSONObject> f14563c;

    private zzbms(zzdtu<zzbmn> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<JSONObject> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f14562b = zzdtuVar2;
        this.f14563c = zzdtuVar3;
    }

    public static zzbms a(zzdtu<zzbmn> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<JSONObject> zzdtuVar3) {
        return new zzbms(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.b(this.f14563c.get() == null ? Collections.emptySet() : Collections.singleton(new zzbuz(this.a.get(), this.f14562b.get())), "Cannot return null from a non-@Nullable @Provides method");
    }
}
