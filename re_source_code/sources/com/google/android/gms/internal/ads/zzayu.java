package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzayu {
    private static zzv a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f14292b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    private static final zzayy<Void> f14293c = new v5();

    public zzayu(Context context) {
        b(context.getApplicationContext() != null ? context.getApplicationContext() : context);
    }

    @VisibleForTesting
    private static zzv b(Context context) {
        zzv zzvVar;
        zzv zzvVar2;
        synchronized (f14292b) {
            if (a == null) {
                zzacu.a(context);
                if (((Boolean) zzyt.e().c(zzacu.C3)).booleanValue()) {
                    zzvVar2 = zzayl.d(context);
                } else {
                    zzvVar2 = new zzv(new zzan(new File(context.getCacheDir(), "volley")), new zzak((zzaj) new zzat()));
                    zzvVar2.a();
                }
                a = zzvVar2;
            }
            zzvVar = a;
        }
        return zzvVar;
    }

    public static zzbbh<zzp> d(String str) {
        zzbbr zzbbrVar = new zzbbr();
        a.c(new zzaza(str, zzbbrVar));
        return zzbbrVar;
    }

    public final zzbbh<String> a(int i2, String str, Map<String, String> map, byte[] bArr) {
        y5 y5Var = new y5(null);
        w5 w5Var = new w5(this, str, y5Var);
        zzazx zzazxVar = new zzazx(null);
        x5 x5Var = new x5(this, i2, str, y5Var, w5Var, bArr, map, zzazxVar);
        if (zzazx.a()) {
            try {
                zzazxVar.f(str, "GET", x5Var.g(), x5Var.O());
            } catch (zza e2) {
                zzbad.i(e2.getMessage());
            }
        }
        a.c(x5Var);
        return y5Var;
    }

    public final zzbbh<String> c(String str, Map<String, String> map) {
        return a(0, str, map, null);
    }
}
