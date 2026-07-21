package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdag implements zzdti<zzdae> {
    private final zzdtu<Executor> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbah> f15831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcmu> f15832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzbai> f15833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<String> f15834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzdtu<String> f15835f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzdtu<Context> f15836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzdtu<Clock> f15837h;

    private zzdag(zzdtu<Executor> zzdtuVar, zzdtu<zzbah> zzdtuVar2, zzdtu<zzcmu> zzdtuVar3, zzdtu<zzbai> zzdtuVar4, zzdtu<String> zzdtuVar5, zzdtu<String> zzdtuVar6, zzdtu<Context> zzdtuVar7, zzdtu<Clock> zzdtuVar8) {
        this.a = zzdtuVar;
        this.f15831b = zzdtuVar2;
        this.f15832c = zzdtuVar3;
        this.f15833d = zzdtuVar4;
        this.f15834e = zzdtuVar5;
        this.f15835f = zzdtuVar6;
        this.f15836g = zzdtuVar7;
        this.f15837h = zzdtuVar8;
    }

    public static zzdag a(zzdtu<Executor> zzdtuVar, zzdtu<zzbah> zzdtuVar2, zzdtu<zzcmu> zzdtuVar3, zzdtu<zzbai> zzdtuVar4, zzdtu<String> zzdtuVar5, zzdtu<String> zzdtuVar6, zzdtu<Context> zzdtuVar7, zzdtu<Clock> zzdtuVar8) {
        return new zzdag(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5, zzdtuVar6, zzdtuVar7, zzdtuVar8);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzdae(this.a.get(), this.f15831b.get(), this.f15832c.get(), this.f15833d.get(), this.f15834e.get(), this.f15835f.get(), this.f15836g.get(), this.f15837h.get());
    }
}
