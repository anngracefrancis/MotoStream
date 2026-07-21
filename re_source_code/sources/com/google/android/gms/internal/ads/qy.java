package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
final class qy {
    static zzdbq a;

    static boolean a(zzdy zzdyVar) throws IllegalAccessException, GeneralSecurityException, InvocationTargetException {
        Method methodP;
        if (a != null) {
            return true;
        }
        String str = (String) zzyt.e().c(zzacu.s2);
        if (str == null || str.length() == 0) {
            str = (zzdyVar == null || (methodP = zzdyVar.p("zu6uZ8u7nNJHsIXbotuBCEBd9hieUh9UBKC94dMPsF422AtJb3FisPSqZI3W+06A", "tm6XtP5M5qvCs+TffoCZhF/AF3Fx7Ow8iqgApPbgXSw=")) == null) ? null : (String) methodP.invoke(null, new Object[0]);
            if (str == null) {
                return false;
            }
        }
        try {
            zzdbu zzdbuVarB = zzdbz.b(zzcg.b(str, true));
            zzdbl.b(zzddc.a);
            zzdcf.l(new zzddg());
            zzdbq zzdbqVar = (zzdbq) zzdcf.f(zzdcf.c(zzdbuVarB, null, zzdbq.class));
            a = zzdbqVar;
            return zzdbqVar != null;
        } catch (IllegalArgumentException | GeneralSecurityException unused) {
        }
    }
}
