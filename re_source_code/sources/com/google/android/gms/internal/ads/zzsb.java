package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class zzsb extends IOException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f16707f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzry f16708g;

    public zzsb(String str, zzry zzryVar, int i2) {
        super(str);
        this.f16708g = zzryVar;
        this.f16707f = 1;
    }

    public zzsb(IOException iOException, zzry zzryVar, int i2) {
        super(iOException);
        this.f16708g = zzryVar;
        this.f16707f = i2;
    }

    public zzsb(String str, IOException iOException, zzry zzryVar, int i2) {
        super(str, iOException);
        this.f16708g = zzryVar;
        this.f16707f = 1;
    }
}
