package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdts<T> {
    private final List<zzdtu<T>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<zzdtu<Collection<T>>> f16174b;

    private zzdts(int i2, int i3) {
        this.a = zzdtf.a(i2);
        this.f16174b = zzdtf.a(i3);
    }

    public final zzdts<T> a(zzdtu<? extends T> zzdtuVar) {
        this.a.add(zzdtuVar);
        return this;
    }

    public final zzdts<T> b(zzdtu<? extends Collection<? extends T>> zzdtuVar) {
        this.f16174b.add(zzdtuVar);
        return this;
    }

    public final zzdtq<T> c() {
        return new zzdtq<>(this.a, this.f16174b);
    }
}
