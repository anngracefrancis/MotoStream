package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcwn implements zzcva<zzcwm> {
    zzaci a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzbbl f15709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    List<String> f15710c;

    public zzcwn(zzaci zzaciVar, zzbbl zzbblVar, List<String> list) {
        this.a = zzaciVar;
        this.f15709b = zzbblVar;
        this.f15710c = list;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcwm> b() {
        return this.f15709b.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.pp

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzcwn f13182f;

            {
                this.f13182f = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzcwn zzcwnVar = this.f13182f;
                return new zzcwm(zzcwnVar.a.A(zzcwnVar.f15710c));
            }
        });
    }
}
