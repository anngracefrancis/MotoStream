package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcue implements zzcva<zzcud> {
    private final zzbbl a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bundle f15632b;

    public zzcue(zzbbl zzbblVar, Bundle bundle) {
        this.a = zzbblVar;
        this.f15632b = bundle;
    }

    final /* synthetic */ zzcud a() throws Exception {
        return new zzcud(this.f15632b);
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcud> b() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.ro

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzcue f13282f;

            {
                this.f13282f = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f13282f.a();
            }
        });
    }
}
