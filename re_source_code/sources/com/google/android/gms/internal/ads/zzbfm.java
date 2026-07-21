package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbfm implements zzbgd {
    @Override // com.google.android.gms.internal.ads.zzbgd
    public final zzbft a(zzbdf zzbdfVar, int i2, String str, zzbde zzbdeVar) {
        if (Build.VERSION.SDK_INT >= 16 && i2 > 0) {
            List listAsList = Arrays.asList(zzbdeVar.f14367e.split(","));
            if (listAsList.contains("3")) {
                int iH = zzbfa.H();
                if (iH < zzbdeVar.f14370h) {
                    return new zzbgp(zzbdfVar, zzbdeVar);
                }
                return iH < zzbdeVar.f14364b ? new zzbgo(zzbdfVar, zzbdeVar) : new zzbgf(zzbdfVar);
            }
            if (listAsList.contains("1")) {
                int iH2 = zzbdk.h();
                if (iH2 < zzbdeVar.f14370h) {
                    if (i2 == 1) {
                        return new zzbgk(zzbdfVar);
                    }
                    if (i2 == 2) {
                        return new zzbgh(zzbdfVar, null);
                    }
                }
                return iH2 < zzbdeVar.f14364b ? new zzbgg(zzbdfVar, zzbdeVar) : new zzbgf(zzbdfVar);
            }
        }
        return new zzbge(zzbdfVar);
    }
}
