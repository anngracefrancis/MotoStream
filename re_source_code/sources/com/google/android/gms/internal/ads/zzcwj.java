package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcwj implements zzcva<zzcwi> {
    private zzawe a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzbbl f15705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15706c;

    public zzcwj(zzawe zzaweVar, zzbbl zzbblVar, String str) {
        this.a = zzaweVar;
        this.f15705b = zzbblVar;
        this.f15706c = str;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcwi> b() {
        new zzbbr();
        final zzbbh<String> zzbbhVarO = zzbar.o(null);
        if (((Boolean) zzyt.e().c(zzacu.E4)).booleanValue()) {
            zzbbhVarO = this.a.a(this.f15706c);
        }
        final zzbbh<String> zzbbhVarB = this.a.b(this.f15706c);
        return zzbar.a(zzbbhVarO, zzbbhVarB).a(new Callable(zzbbhVarO, zzbbhVarB) { // from class: com.google.android.gms.internal.ads.op

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbbh f13113f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzbbh f13114g;

            {
                this.f13113f = zzbbhVarO;
                this.f13114g = zzbbhVarB;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzcwi((String) this.f13113f.get(), (String) this.f13114g.get());
            }
        }, zzaxg.a);
    }
}
