package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzku extends Exception {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f16411f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f16412g;

    private zzku(int i2, String str, Throwable th, int i3) {
        super(null, th);
        this.f16411f = i2;
        this.f16412g = i3;
    }

    public static zzku a(IOException iOException) {
        return new zzku(0, null, iOException, -1);
    }

    public static zzku b(Exception exc, int i2) {
        return new zzku(1, null, exc, i2);
    }

    static zzku c(RuntimeException runtimeException) {
        return new zzku(2, null, runtimeException, -1);
    }
}
