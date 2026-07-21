package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class zzddp implements zzdcc<zzdby> {
    private static final Logger a = Logger.getLogger(zzddp.class.getName());

    static class a implements zzdby {
        private final zzdca<zzdby> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f15884b;

        private a(zzdca<zzdby> zzdcaVar) {
            this.f15884b = new byte[]{0};
            this.a = zzdcaVar;
        }

        @Override // com.google.android.gms.internal.ads.zzdby
        public final byte[] a(byte[] bArr) throws GeneralSecurityException {
            return this.a.e().b().equals(zzdhm.LEGACY) ? zzdjs.c(this.a.e().c(), this.a.e().a().a(zzdjs.c(bArr, this.f15884b))) : zzdjs.c(this.a.e().c(), this.a.e().a().a(bArr));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcc
    public final Class<zzdby> a() {
        return zzdby.class;
    }

    @Override // com.google.android.gms.internal.ads.zzdcc
    public final /* synthetic */ zzdby b(zzdca<zzdby> zzdcaVar) throws GeneralSecurityException {
        return new a(zzdcaVar);
    }
}
