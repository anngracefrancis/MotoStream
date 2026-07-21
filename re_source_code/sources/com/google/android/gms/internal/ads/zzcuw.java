package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcuw implements zzcva<zzcuv> {
    private final zzbbl a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f15659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbai f15660c;

    public zzcuw(zzbbl zzbblVar, Context context, zzbai zzbaiVar) {
        this.a = zzbblVar;
        this.f15659b = context;
        this.f15660c = zzbaiVar;
    }

    final /* synthetic */ zzcuv a() throws Exception {
        boolean zF = Wrappers.a(this.f15659b).f();
        zzk.zzlg();
        boolean zE = zzaxi.E(this.f15659b);
        String str = this.f15660c.f14326f;
        zzk.zzli();
        boolean zU = zzaxo.u();
        zzk.zzlg();
        return new zzcuv(zF, zE, str, zU, zzaxi.B(this.f15659b), DynamiteModule.c(this.f15659b, ModuleDescriptor.MODULE_ID));
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcuv> b() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.yo

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzcuw f13653f;

            {
                this.f13653f = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f13653f.a();
            }
        });
    }
}
