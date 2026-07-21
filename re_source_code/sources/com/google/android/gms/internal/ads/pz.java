package com.google.android.gms.internal.ads;

import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
final class pz implements zzkc {
    private final Uri a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzjp f13191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzid f13192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzjr f13193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f13194e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzij f13195f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f13196g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f13197h;

    public pz(Uri uri, zzjp zzjpVar, zzid zzidVar, zzjr zzjrVar, int i2, long j2) {
        this.a = (Uri) zzkh.c(uri);
        this.f13191b = (zzjp) zzkh.c(zzjpVar);
        this.f13192c = (zzid) zzkh.c(zzidVar);
        this.f13193d = (zzjr) zzkh.c(zzjrVar);
        this.f13194e = i2;
        zzij zzijVar = new zzij();
        this.f13195f = zzijVar;
        zzijVar.a = j2;
        this.f13197h = true;
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final boolean a() {
        return this.f13196g;
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final void b() {
        this.f13196g = true;
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final void c() throws Throwable {
        if (this.f13197h) {
            this.f13192c.e();
            this.f13197h = false;
        }
        int iC = 0;
        while (iC == 0 && !this.f13196g) {
            zzib zzibVar = null;
            try {
                long j2 = this.f13195f.a;
                long jA = this.f13191b.a(new zzjq(this.a, j2, -1L, null));
                if (jA != -1) {
                    jA += j2;
                }
                zzib zzibVar2 = new zzib(this.f13191b, j2, jA);
                while (iC == 0) {
                    try {
                        if (this.f13196g) {
                            break;
                        }
                        this.f13193d.d(this.f13194e);
                        iC = this.f13192c.c(zzibVar2, this.f13195f);
                    } catch (Throwable th) {
                        th = th;
                        zzibVar = zzibVar2;
                        if (iC != 1 && zzibVar != null) {
                            this.f13195f.a = zzibVar.getPosition();
                        }
                        this.f13191b.close();
                        throw th;
                    }
                }
                if (iC == 1) {
                    iC = 0;
                } else {
                    this.f13195f.a = zzibVar2.getPosition();
                }
                this.f13191b.close();
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }
}
