package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class zzjx extends IOException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzjq f16384f;

    public zzjx(String str, zzjq zzjqVar) {
        super(str);
        this.f16384f = zzjqVar;
    }

    public zzjx(IOException iOException, zzjq zzjqVar) {
        super(iOException);
        this.f16384f = zzjqVar;
    }

    public zzjx(String str, IOException iOException, zzjq zzjqVar) {
        super(str, iOException);
        this.f16384f = zzjqVar;
    }
}
