package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcyk {
    private final Map<String, zzcym> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f15775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzawm f15776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbai f15777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdh f15778e;

    public zzcyk(Context context, zzbai zzbaiVar, zzawm zzawmVar) {
        this.f15775b = context;
        this.f15777d = zzbaiVar;
        this.f15776c = zzawmVar;
        this.f15778e = new zzdh(new com.google.android.gms.ads.internal.zzg(context, zzbaiVar));
    }

    private final zzcym a() {
        return new zzcym(this.f15775b, this.f15776c.r(), this.f15776c.t(), this.f15778e);
    }

    private final zzcym c(String str) {
        zzasq zzasqVarE = zzasq.e(this.f15775b);
        try {
            zzasqVarE.a(str);
            zzaxc zzaxcVar = new zzaxc();
            zzaxcVar.B(this.f15775b, str, false);
            zzaxf zzaxfVar = new zzaxf(this.f15776c.r(), zzaxcVar);
            return new zzcym(zzasqVarE, zzaxfVar, new zzawu(zzazt.x(), zzaxfVar), new zzdh(new com.google.android.gms.ads.internal.zzg(this.f15775b, this.f15777d)));
        } catch (PackageManager.NameNotFoundException unused) {
            return a();
        }
    }

    public final zzcym b(String str) {
        if (str == null) {
            return a();
        }
        if (this.a.containsKey(str)) {
            return this.a.get(str);
        }
        zzcym zzcymVarC = c(str);
        this.a.put(str, zzcymVarC);
        return zzcymVarC;
    }
}
