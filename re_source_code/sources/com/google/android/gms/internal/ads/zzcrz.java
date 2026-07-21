package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcrz implements zzcva<Object> {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbqe f15585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzcyi f15586d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzcxv f15587e;

    public zzcrz(String str, String str2, zzbqe zzbqeVar, zzcyi zzcyiVar, zzcxv zzcxvVar) {
        this.a = str;
        this.f15584b = str2;
        this.f15585c = zzbqeVar;
        this.f15586d = zzcyiVar;
        this.f15587e = zzcxvVar;
    }

    final /* synthetic */ void a(Bundle bundle) {
        this.f15585c.b(this.f15587e.f15750d);
        bundle.putBundle("quality_signals", this.f15586d.b());
        bundle.putString("seq_num", this.a);
        bundle.putString("session_id", this.f15584b);
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<Object> b() {
        return zzbar.o(new zzcuz(this) { // from class: com.google.android.gms.internal.ads.xn
            private final zzcrz a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzcuz
            public final void a(Object obj) {
                this.a.a((Bundle) obj);
            }
        });
    }
}
