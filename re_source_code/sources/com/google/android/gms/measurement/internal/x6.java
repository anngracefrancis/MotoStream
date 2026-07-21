package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class x6 {
    private final Runnable a = new Runnable(this) { // from class: com.google.android.gms.measurement.internal.w6

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final x6 f18008f;

        {
            this.f18008f = this;
        }

        @Override // java.lang.Runnable
        public final void run() {
            final x6 x6Var = this.f18008f;
            x6Var.f18025b.g().z(new Runnable(x6Var) { // from class: com.google.android.gms.measurement.internal.z6

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final x6 f18050f;

                {
                    this.f18050f = x6Var;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    x6 x6Var2 = this.f18050f;
                    x6Var2.f18025b.d();
                    x6Var2.f18025b.h().O().a("Application backgrounded");
                    x6Var2.f18025b.p().u0("auto", "_ab", new Bundle());
                }
            });
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzjl f18025b;

    x6(zzjl zzjlVar) {
        this.f18025b = zzjlVar;
    }

    final void a(long j2) {
        this.f18025b.d();
        if (this.f18025b.n().r(zzap.O0)) {
            this.f18025b.f18202c.removeCallbacks(this.a);
        }
    }

    final void b(long j2) {
        if (this.f18025b.n().r(zzap.O0)) {
            this.f18025b.f18202c.postDelayed(this.a, 2000L);
        }
    }
}
