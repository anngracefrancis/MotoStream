package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdtj<T> implements zzdte<T>, zzdti<T> {
    private static final zzdtj<Object> a = new zzdtj<>(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f16170b;

    private zzdtj(T t) {
        this.f16170b = t;
    }

    public static <T> zzdti<T> a(T t) {
        return new zzdtj(zzdto.b(t, "instance cannot be null"));
    }

    @Override // com.google.android.gms.internal.ads.zzdte, com.google.android.gms.internal.ads.zzdtu
    public final T get() {
        return this.f16170b;
    }
}
