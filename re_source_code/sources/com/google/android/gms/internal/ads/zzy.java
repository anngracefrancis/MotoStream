package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzy<T> {
    public final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzc f16974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zzaf f16975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f16976d;

    private zzy(T t, zzc zzcVar) {
        this.f16976d = false;
        this.a = t;
        this.f16974b = zzcVar;
        this.f16975c = null;
    }

    public static <T> zzy<T> a(T t, zzc zzcVar) {
        return new zzy<>(t, zzcVar);
    }

    public static <T> zzy<T> b(zzaf zzafVar) {
        return new zzy<>(zzafVar);
    }

    private zzy(zzaf zzafVar) {
        this.f16976d = false;
        this.a = null;
        this.f16974b = null;
        this.f16975c = zzafVar;
    }
}
