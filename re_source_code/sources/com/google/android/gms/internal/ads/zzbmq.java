package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbmq implements zzdti<zzbmn> {
    private final zzdtu<zzaly> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbml> f14556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<Executor> f14557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzbmg> f14558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<Clock> f14559e;

    private zzbmq(zzdtu<zzaly> zzdtuVar, zzdtu<zzbml> zzdtuVar2, zzdtu<Executor> zzdtuVar3, zzdtu<zzbmg> zzdtuVar4, zzdtu<Clock> zzdtuVar5) {
        this.a = zzdtuVar;
        this.f14556b = zzdtuVar2;
        this.f14557c = zzdtuVar3;
        this.f14558d = zzdtuVar4;
        this.f14559e = zzdtuVar5;
    }

    public static zzbmq a(zzdtu<zzaly> zzdtuVar, zzdtu<zzbml> zzdtuVar2, zzdtu<Executor> zzdtuVar3, zzdtu<zzbmg> zzdtuVar4, zzdtu<Clock> zzdtuVar5) {
        return new zzbmq(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbmn(this.a.get(), this.f14556b.get(), this.f14557c.get(), this.f14558d.get(), this.f14559e.get());
    }
}
