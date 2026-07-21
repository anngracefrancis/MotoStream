package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcap implements zzdti<zzcan> {
    private final zzdtu<zzayu> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Clock> f14985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<Executor> f14986c;

    public zzcap(zzdtu<zzayu> zzdtuVar, zzdtu<Clock> zzdtuVar2, zzdtu<Executor> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f14985b = zzdtuVar2;
        this.f14986c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcan(this.a.get(), this.f14985b.get(), this.f14986c.get());
    }
}
