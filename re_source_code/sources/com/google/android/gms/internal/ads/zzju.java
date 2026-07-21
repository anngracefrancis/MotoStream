package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzju extends IOException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f16379f;

    /* JADX WARN: Illegal instructions before constructor call */
    public zzju(String str) {
        String strValueOf = String.valueOf(str);
        super(strValueOf.length() != 0 ? "Unsupported URI scheme: ".concat(strValueOf) : new String("Unsupported URI scheme: "));
        this.f16379f = str;
    }
}
