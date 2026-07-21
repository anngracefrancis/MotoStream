package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcza implements zzdti<ScheduledExecutorService> {
    private final zzdtu<ThreadFactory> a;

    public zzcza(zzdtu<ThreadFactory> zzdtuVar) {
        this.a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (ScheduledExecutorService) zzdto.b(new ScheduledThreadPoolExecutor(1, this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
