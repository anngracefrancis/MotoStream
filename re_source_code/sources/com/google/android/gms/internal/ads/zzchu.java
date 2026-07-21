package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzchu implements zzdti<zzchq> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbai> f15253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcxv> f15254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<Executor> f15255d;

    private zzchu(zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3, zzdtu<Executor> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f15253b = zzdtuVar2;
        this.f15254c = zzdtuVar3;
        this.f15255d = zzdtuVar4;
    }

    public static zzchu a(zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3, zzdtu<Executor> zzdtuVar4) {
        return new zzchu(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzchq(this.a.get(), this.f15253b.get(), this.f15254c.get(), this.f15255d.get());
    }
}
