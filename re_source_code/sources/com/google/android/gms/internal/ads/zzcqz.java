package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcqz implements zzbal<zzarx, zzcrc> {
    private Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzchz f15556b;

    public zzcqz(Executor executor, zzchz zzchzVar) {
        this.a = executor;
        this.f15556b = zzchzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbal
    public final /* synthetic */ zzbbh<zzcrc> zzf(zzarx zzarxVar) throws Exception {
        final zzarx zzarxVar2 = zzarxVar;
        return zzbar.c(this.f15556b.b(zzarxVar2), new zzbal(zzarxVar2) { // from class: com.google.android.gms.internal.ads.nn
            private final zzarx a;

            {
                this.a = zzarxVar2;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return zzbar.o(new zzcrc(new JsonReader(new InputStreamReader((InputStream) obj))).a(this.a.f14104f));
            }
        }, this.a);
    }
}
