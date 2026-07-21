package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcob implements zzdti<zzcnw> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Executor> f15454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcdf> f15455c;

    public zzcob(zzdtu<Context> zzdtuVar, zzdtu<Executor> zzdtuVar2, zzdtu<zzcdf> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f15454b = zzdtuVar2;
        this.f15455c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcnw(this.a.get(), this.f15454b.get(), this.f15455c.get());
    }
}
