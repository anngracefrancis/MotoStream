package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class zzczb implements zzdti<ThreadFactory> {
    private static final zzczb a = new zzczb();

    public static zzczb a() {
        return a;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (ThreadFactory) zzdto.b(new bq(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
