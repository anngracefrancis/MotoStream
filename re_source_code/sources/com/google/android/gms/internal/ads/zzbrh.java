package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbrh implements zzdti<zzavb> {
    private final zzbrg a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Context> f14713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbai> f14714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzcxm> f14715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<zzavd> f14716e;

    private zzbrh(zzbrg zzbrgVar, zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzcxm> zzdtuVar3, zzdtu<zzavd> zzdtuVar4) {
        this.a = zzbrgVar;
        this.f14713b = zzdtuVar;
        this.f14714c = zzdtuVar2;
        this.f14715d = zzdtuVar3;
        this.f14716e = zzdtuVar4;
    }

    public static zzbrh a(zzbrg zzbrgVar, zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzcxm> zzdtuVar3, zzdtu<zzavd> zzdtuVar4) {
        return new zzbrh(zzbrgVar, zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        Context context = this.f14713b.get();
        zzbai zzbaiVar = this.f14714c.get();
        zzcxm zzcxmVar = this.f14715d.get();
        zzavd zzavdVar = this.f14716e.get();
        if (zzcxmVar.x != null) {
            return new zzauq(context, zzbaiVar, zzcxmVar.x, zzcxmVar.p.f15741b, zzavdVar);
        }
        return null;
    }
}
