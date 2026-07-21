package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class lq extends zzbts<zzczz> implements zzczr<zzczs> {
    lq(Set<zzbuz<zzczz>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzczr
    public final void B(final zzcze<zzczs, ?> zzczeVar) {
        T(new zzbtu(zzczeVar) { // from class: com.google.android.gms.internal.ads.pq
            private final zzcze a;

            {
                this.a = zzczeVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void a(Object obj) {
                zzcze zzczeVar2 = this.a;
                ((zzczz) obj).c((zzczs) zzczeVar2.a(), zzczeVar2.b());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzczr
    public final void F(final zzcze<zzczs, ?> zzczeVar, final Throwable th) {
        T(new zzbtu(zzczeVar, th) { // from class: com.google.android.gms.internal.ads.oq
            private final zzcze a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Throwable f13115b;

            {
                this.a = zzczeVar;
                this.f13115b = th;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void a(Object obj) {
                zzcze zzczeVar2 = this.a;
                ((zzczz) obj).b((zzczs) zzczeVar2.a(), zzczeVar2.b(), this.f13115b);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzczr
    public final void L(final zzcze<zzczs, ?> zzczeVar) {
        T(new zzbtu(zzczeVar) { // from class: com.google.android.gms.internal.ads.nq
            private final zzcze a;

            {
                this.a = zzczeVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void a(Object obj) {
                zzcze zzczeVar2 = this.a;
                ((zzczz) obj).d((zzczs) zzczeVar2.a(), zzczeVar2.b());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzczr
    public final void M(final zzcze<zzczs, ?> zzczeVar) {
        T(new zzbtu(zzczeVar) { // from class: com.google.android.gms.internal.ads.mq
            private final zzcze a;

            {
                this.a = zzczeVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void a(Object obj) {
                zzcze zzczeVar2 = this.a;
                ((zzczz) obj).e((zzczs) zzczeVar2.a(), zzczeVar2.b());
            }
        });
    }
}
