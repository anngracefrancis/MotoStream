package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzaly {
    private zzakh a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzbbr<zzalf> f13962b;

    zzaly(zzakh zzakhVar) {
        this.a = zzakhVar;
    }

    private final void d() {
        if (this.f13962b == null) {
            final zzbbr<zzalf> zzbbrVar = new zzbbr<>();
            this.f13962b = zzbbrVar;
            this.a.h(null).d(new zzbbv(zzbbrVar) { // from class: com.google.android.gms.internal.ads.j2
                private final zzbbr a;

                {
                    this.a = zzbbrVar;
                }

                @Override // com.google.android.gms.internal.ads.zzbbv
                public final void a(Object obj) {
                    this.a.a((zzalf) obj);
                }
            }, new zzbbt(zzbbrVar) { // from class: com.google.android.gms.internal.ads.l2
                private final zzbbr a;

                {
                    this.a = zzbbrVar;
                }

                @Override // com.google.android.gms.internal.ads.zzbbt
                public final void run() {
                    this.a.c(new zzali("Cannot get Javascript Engine"));
                }
            });
        }
    }

    public final zzamd a(String str, zzalm zzalmVar, zzall zzallVar) {
        d();
        return new zzamd(this.f13962b, str, zzalmVar, zzallVar);
    }

    public final void b(final String str, final zzaho<? super zzalf> zzahoVar) {
        d();
        this.f13962b = (zzbbr) zzbar.c(this.f13962b, new zzbal(str, zzahoVar) { // from class: com.google.android.gms.internal.ads.m2
            private final String a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final zzaho f12950b;

            {
                this.a = str;
                this.f12950b = zzahoVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                zzalf zzalfVar = (zzalf) obj;
                zzalfVar.f(this.a, this.f12950b);
                return zzbar.o(zzalfVar);
            }
        }, zzbbm.f14331b);
    }

    public final void c(final String str, final zzaho<? super zzalf> zzahoVar) {
        this.f13962b = (zzbbr) zzbar.d(this.f13962b, new zzbam(str, zzahoVar) { // from class: com.google.android.gms.internal.ads.n2
            private final String a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final zzaho f13012b;

            {
                this.a = str;
                this.f13012b = zzahoVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbam
            public final Object a(Object obj) {
                zzalf zzalfVar = (zzalf) obj;
                zzalfVar.i(this.a, this.f13012b);
                return zzalfVar;
            }
        }, zzbbm.f14331b);
    }
}
