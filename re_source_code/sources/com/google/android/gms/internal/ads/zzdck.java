package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class zzdck implements zzdcc<zzdbj> {
    private static final Logger a = Logger.getLogger(zzdck.class.getName());

    static class a implements zzdbj {
        private final zzdca<zzdbj> a;

        private a(zzdca<zzdbj> zzdcaVar) {
            this.a = zzdcaVar;
        }

        @Override // com.google.android.gms.internal.ads.zzdbj
        public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            return zzdjs.c(this.a.e().c(), this.a.e().a().a(bArr, bArr2));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcc
    public final Class<zzdbj> a() {
        return zzdbj.class;
    }

    @Override // com.google.android.gms.internal.ads.zzdcc
    public final /* synthetic */ zzdbj b(zzdca<zzdbj> zzdcaVar) throws GeneralSecurityException {
        return new a(zzdcaVar);
    }
}
