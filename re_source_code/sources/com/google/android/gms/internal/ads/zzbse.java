package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbse extends zzbts<zzbrl> {
    public zzbse(Set<zzbuz<zzbrl>> set) {
        super(set);
    }

    public final void Y() {
        T(zd.a);
    }

    public final void f0() {
        T(ae.a);
    }

    public final void g0() {
        T(be.a);
    }

    public final void i0() {
        T(ee.a);
    }

    public final void o0() {
        T(ce.a);
    }

    public final void q0(final zzasr zzasrVar, final String str, final String str2) {
        T(new zzbtu(zzasrVar, str, str2) { // from class: com.google.android.gms.internal.ads.de
            private final zzasr a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f12478b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final String f12479c;

            {
                this.a = zzasrVar;
                this.f12478b = str;
                this.f12479c = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void a(Object obj) {
                ((zzbrl) obj).a(this.a, this.f12478b, this.f12479c);
            }
        });
    }
}
