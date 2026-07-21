package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
public final class zzsw implements zzso {
    private boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f16737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f16738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzln f16739d = zzln.a;

    public final void a() {
        if (this.a) {
            return;
        }
        this.f16738c = SystemClock.elapsedRealtime();
        this.a = true;
    }

    public final void b() {
        if (this.a) {
            g(d());
            this.a = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final zzln c(zzln zzlnVar) {
        if (this.a) {
            g(d());
        }
        this.f16739d = zzlnVar;
        return zzlnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final long d() {
        long j2 = this.f16737b;
        if (!this.a) {
            return j2;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f16738c;
        zzln zzlnVar = this.f16739d;
        return j2 + (zzlnVar.f16431b == 1.0f ? zzkt.b(jElapsedRealtime) : zzlnVar.a(jElapsedRealtime));
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final zzln e() {
        return this.f16739d;
    }

    public final void f(zzso zzsoVar) {
        g(zzsoVar.d());
        this.f16739d = zzsoVar.e();
    }

    public final void g(long j2) {
        this.f16737b = j2;
        if (this.a) {
            this.f16738c = SystemClock.elapsedRealtime();
        }
    }
}
