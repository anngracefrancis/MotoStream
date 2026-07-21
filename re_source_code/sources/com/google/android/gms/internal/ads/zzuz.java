package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzuz {
    private final float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f16827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f16828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f16829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f16830e;

    @VisibleForTesting
    public zzuz(float f2, float f3, float f4, float f5, int i2) {
        this.a = f2;
        this.f16827b = f3;
        this.f16828c = f2 + f4;
        this.f16829d = f3 + f5;
        this.f16830e = i2;
    }

    final float a() {
        return this.a;
    }

    final float b() {
        return this.f16827b;
    }

    final float c() {
        return this.f16828c;
    }

    final float d() {
        return this.f16829d;
    }

    final int e() {
        return this.f16830e;
    }
}
