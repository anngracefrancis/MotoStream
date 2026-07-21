package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzi implements zzab {
    private final Executor a;

    public zzi(Handler handler) {
        this.a = new a00(this, handler);
    }

    @Override // com.google.android.gms.internal.ads.zzab
    public final void a(zzr<?> zzrVar, zzaf zzafVar) {
        zzrVar.I("post-error");
        this.a.execute(new k00(zzrVar, zzy.b(zzafVar), null));
    }

    @Override // com.google.android.gms.internal.ads.zzab
    public final void b(zzr<?> zzrVar, zzy<?> zzyVar, Runnable runnable) {
        zzrVar.S();
        zzrVar.I("post-response");
        this.a.execute(new k00(zzrVar, zzyVar, runnable));
    }

    @Override // com.google.android.gms.internal.ads.zzab
    public final void c(zzr<?> zzrVar, zzy<?> zzyVar) {
        b(zzrVar, zzyVar, null);
    }
}
