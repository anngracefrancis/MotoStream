package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcve<T> implements zzdti<zzcvb<T>> {
    private final zzdtu<Executor> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Set<zzcva<? extends zzcuz<T>>>> f15664b;

    private zzcve(zzdtu<Executor> zzdtuVar, zzdtu<Set<zzcva<? extends zzcuz<T>>>> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15664b = zzdtuVar2;
    }

    public static <T> zzcve<T> a(zzdtu<Executor> zzdtuVar, zzdtu<Set<zzcva<? extends zzcuz<T>>>> zzdtuVar2) {
        return new zzcve<>(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcvb(this.a.get(), this.f15664b.get());
    }
}
