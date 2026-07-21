package com.google.android.gms.internal.ads;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzawt {
    private BigInteger a = BigInteger.ONE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14236b = "0";

    public final synchronized String a() {
        String string;
        string = this.a.toString();
        this.a = this.a.add(BigInteger.ONE);
        this.f14236b = string;
        return string;
    }

    public final synchronized String b() {
        return this.f14236b;
    }
}
