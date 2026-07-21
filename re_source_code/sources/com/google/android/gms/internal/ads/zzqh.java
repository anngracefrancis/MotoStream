package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzqh implements zzql, zzqm {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Uri f16600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzrw f16601g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zznq f16602h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Handler f16604j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzqi f16605k;
    private final int n;
    private zzqm o;
    private zzlr p;
    private boolean q;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f16603i = -1;
    private final String m = null;
    private final zzlt l = new zzlt();

    public zzqh(Uri uri, zzrw zzrwVar, zznq zznqVar, int i2, Handler handler, zzqi zzqiVar, String str, int i3) {
        this.f16600f = uri;
        this.f16601g = zzrwVar;
        this.f16602h = zznqVar;
        this.f16604j = handler;
        this.f16605k = zzqiVar;
        this.n = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final void a(zzkv zzkvVar, boolean z, zzqm zzqmVar) {
        this.o = zzqmVar;
        zzqz zzqzVar = new zzqz(-9223372036854775807L, false);
        this.p = zzqzVar;
        zzqmVar.e(zzqzVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final zzqj b(int i2, zzrt zzrtVar) {
        zzsk.a(i2 == 0);
        return new x20(this.f16600f, this.f16601g.a(), this.f16602h.a(), this.f16603i, this.f16604j, this.f16605k, this, zzrtVar, null, this.n);
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final void c(zzqj zzqjVar) {
        ((x20) zzqjVar).o();
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final void d() {
        this.o = null;
    }

    @Override // com.google.android.gms.internal.ads.zzqm
    public final void e(zzlr zzlrVar, Object obj) {
        boolean z = zzlrVar.c(0, this.l, false).f16437d != -9223372036854775807L;
        if (!this.q || z) {
            this.p = zzlrVar;
            this.q = z;
            this.o.e(zzlrVar, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final void f() throws IOException {
    }
}
