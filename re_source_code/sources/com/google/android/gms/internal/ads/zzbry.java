package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbry extends zzbts<zzbrx> {
    public zzbry(Set<zzbuz<zzbrx>> set) {
        super(set);
    }

    public final void Y(zzbvp zzbvpVar, Executor executor) {
        U(zzbuz.a(new yd(this, zzbvpVar), executor));
    }

    public final void f0(final Context context) {
        T(new zzbtu(context) { // from class: com.google.android.gms.internal.ads.ud
            private final Context a;

            {
                this.a = context;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void a(Object obj) {
                ((zzbrx) obj).r(this.a);
            }
        });
    }

    public final void g0(final Context context) {
        T(new zzbtu(context) { // from class: com.google.android.gms.internal.ads.wd
            private final Context a;

            {
                this.a = context;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void a(Object obj) {
                ((zzbrx) obj).k(this.a);
            }
        });
    }

    public final void i0(final Context context) {
        T(new zzbtu(context) { // from class: com.google.android.gms.internal.ads.xd
            private final Context a;

            {
                this.a = context;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void a(Object obj) {
                ((zzbrx) obj).j(this.a);
            }
        });
    }
}
