package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcyf implements zzdti<Clock> {
    private final zzcye a;

    public zzcyf(zzcye zzcyeVar) {
        this.a = zzcyeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Clock) zzdto.b(DefaultClock.c(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
