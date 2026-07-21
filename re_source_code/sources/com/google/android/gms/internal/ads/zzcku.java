package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcku implements zzdti<zzckr> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Executor> f15335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbws> f15336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzcxk> f15337d;

    public zzcku(zzdtu<Context> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<zzbws> zzdtuVar3, zzdtu<zzcxk> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f15335b = zzdtuVar2;
        this.f15336c = zzdtuVar3;
        this.f15337d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzckr(this.a.get(), this.f15335b.get(), this.f15336c.get(), this.f15337d.get());
    }
}
