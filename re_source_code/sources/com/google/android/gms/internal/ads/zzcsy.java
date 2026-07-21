package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcsy implements zzcuz<Bundle> {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzxz f15613b;

    public zzcsy(int i2, zzxz zzxzVar) {
        this.a = i2;
        this.f15613b = zzxzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(Bundle bundle) {
        zzcxz.d(bundle, "correlation_id", Integer.valueOf(this.a), this.f15613b.f16968f >= 6);
    }
}
