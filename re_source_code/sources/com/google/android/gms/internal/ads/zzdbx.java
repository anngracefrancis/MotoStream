package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdbx {
    private static final CopyOnWriteArrayList<zzdbw> a = new CopyOnWriteArrayList<>();

    public static zzdbw a(String str) throws GeneralSecurityException {
        for (zzdbw zzdbwVar : a) {
            if (zzdbwVar.a(str)) {
                return zzdbwVar;
            }
        }
        String strValueOf = String.valueOf(str);
        throw new GeneralSecurityException(strValueOf.length() != 0 ? "No KMS client does support: ".concat(strValueOf) : new String("No KMS client does support: "));
    }
}
