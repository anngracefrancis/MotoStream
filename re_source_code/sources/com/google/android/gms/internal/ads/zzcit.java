package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcit implements zzdti<zzcig> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Executor> f15272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzasm> f15273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzblp> f15274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<zzasl> f15275e;

    private zzcit(zzdtu<Context> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<zzasm> zzdtuVar3, zzdtu<zzblp> zzdtuVar4, zzdtu<zzasl> zzdtuVar5) {
        this.a = zzdtuVar;
        this.f15272b = zzdtuVar2;
        this.f15273c = zzdtuVar3;
        this.f15274d = zzdtuVar4;
        this.f15275e = zzdtuVar5;
    }

    public static zzcit a(zzdtu<Context> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<zzasm> zzdtuVar3, zzdtu<zzblp> zzdtuVar4, zzdtu<zzasl> zzdtuVar5) {
        return new zzcit(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcig(this.a.get(), this.f15272b.get(), this.f15273c.get(), this.f15274d.get(), this.f15275e.get());
    }
}
