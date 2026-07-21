package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class e0 implements zzaho<zzbgz> {
    e0() {
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void a(zzbgz zzbgzVar, Map map) {
        zzbgz zzbgzVar2 = zzbgzVar;
        com.google.android.gms.ads.internal.overlay.zzd zzdVarK0 = zzbgzVar2.k0();
        if (zzdVarK0 != null) {
            zzdVarK0.close();
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzd zzdVarS0 = zzbgzVar2.s0();
        if (zzdVarS0 != null) {
            zzdVarS0.close();
        } else {
            zzbad.i("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
