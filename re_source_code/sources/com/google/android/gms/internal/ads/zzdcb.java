package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdcb<P> {
    private final P a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f15863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdgu f15864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdhm f15865d;

    public zzdcb(P p, byte[] bArr, zzdgu zzdguVar, zzdhm zzdhmVar) {
        this.a = p;
        this.f15863b = Arrays.copyOf(bArr, bArr.length);
        this.f15864c = zzdguVar;
        this.f15865d = zzdhmVar;
    }

    public final P a() {
        return this.a;
    }

    public final zzdhm b() {
        return this.f15865d;
    }

    public final byte[] c() {
        byte[] bArr = this.f15863b;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}
