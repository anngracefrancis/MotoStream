package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdbu {
    private zzdha a;

    private zzdbu(zzdha zzdhaVar) {
        this.a = zzdhaVar;
    }

    static final zzdbu a(zzdha zzdhaVar) throws GeneralSecurityException {
        if (zzdhaVar == null || zzdhaVar.z() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        return new zzdbu(zzdhaVar);
    }

    final zzdha b() {
        return this.a;
    }

    public final String toString() {
        return cr.a(this.a).toString();
    }
}
