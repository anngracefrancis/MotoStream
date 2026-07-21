package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcvu implements zzcva<zzcvt> {
    private final zzawi a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f15691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f15692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PackageInfo f15693d;

    public zzcvu(zzawi zzawiVar, Executor executor, String str, PackageInfo packageInfo) {
        this.a = zzawiVar;
        this.f15691b = executor;
        this.f15692c = str;
        this.f15693d = packageInfo;
    }

    final /* synthetic */ zzbbh a(Throwable th) throws Exception {
        return zzbar.o(new zzcvt(this.f15692c));
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcvt> b() {
        return zzbar.e(zzbar.d(this.a.b(this.f15692c, this.f15693d), hp.a, this.f15691b), Throwable.class, new zzbal(this) { // from class: com.google.android.gms.internal.ads.ip
            private final zzcvu a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.a.a((Throwable) obj);
            }
        }, this.f15691b);
    }
}
