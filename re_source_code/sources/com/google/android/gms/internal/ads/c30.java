package com.google.android.gms.internal.ads;

import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
final class c30 implements zzsh {
    private final Uri a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzrv f12385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d30 f12386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzsm f12387d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f12389f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f12391h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ x20 f12393j;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zznt f12388e = new zznt();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f12390g = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f12392i = -1;

    public c30(x20 x20Var, Uri uri, zzrv zzrvVar, d30 d30Var, zzsm zzsmVar) {
        this.f12393j = x20Var;
        this.a = (Uri) zzsk.d(uri);
        this.f12385b = (zzrv) zzsk.d(zzrvVar);
        this.f12386c = (d30) zzsk.d(d30Var);
        this.f12387d = zzsmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzsh
    public final boolean a() {
        return this.f12389f;
    }

    @Override // com.google.android.gms.internal.ads.zzsh
    public final void b() {
        this.f12389f = true;
    }

    @Override // com.google.android.gms.internal.ads.zzsh
    public final void c() throws Throwable {
        int iD = 0;
        while (iD == 0 && !this.f12389f) {
            zznm zznmVar = null;
            try {
                long position = this.f12388e.a;
                long jA = this.f12385b.a(new zzry(this.a, position, -1L, this.f12393j.m));
                this.f12392i = jA;
                if (jA != -1) {
                    this.f12392i = jA + position;
                }
                zznm zznmVar2 = new zznm(this.f12385b, position, this.f12392i);
                try {
                    zznn zznnVarB = this.f12386c.b(zznmVar2, this.f12385b.I0());
                    if (this.f12390g) {
                        zznnVarB.h(position, this.f12391h);
                        this.f12390g = false;
                    }
                    while (iD == 0 && !this.f12389f) {
                        this.f12387d.a();
                        iD = zznnVarB.d(zznmVar2, this.f12388e);
                        if (zznmVar2.getPosition() > this.f12393j.n + position) {
                            position = zznmVar2.getPosition();
                            this.f12387d.c();
                            this.f12393j.t.post(this.f12393j.s);
                        }
                    }
                    if (iD == 1) {
                        iD = 0;
                    } else {
                        this.f12388e.a = zznmVar2.getPosition();
                    }
                    zzsy.e(this.f12385b);
                } catch (Throwable th) {
                    th = th;
                    zznmVar = zznmVar2;
                    if (iD != 1 && zznmVar != null) {
                        this.f12388e.a = zznmVar.getPosition();
                    }
                    zzsy.e(this.f12385b);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void e(long j2, long j3) {
        this.f12388e.a = j2;
        this.f12391h = j3;
        this.f12390g = true;
    }
}
