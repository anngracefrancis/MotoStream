package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbyl implements zzdti<zzbmy> {
    private final zzdtu<zzty> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Executor> f14852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<Context> f14853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<Clock> f14854d;

    public zzbyl(zzdtu<zzty> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<Context> zzdtuVar3, zzdtu<Clock> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f14852b = zzdtuVar2;
        this.f14853c = zzdtuVar3;
        this.f14854d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzty zztyVar = this.a.get();
        Executor executor = this.f14852b.get();
        Context context = this.f14853c.get();
        return (zzbmy) zzdto.b(new zzbmy(executor, new zzbml(context, zztyVar), this.f14854d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
