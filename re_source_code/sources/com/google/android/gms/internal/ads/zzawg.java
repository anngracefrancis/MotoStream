package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzawg implements zzawi {
    @Override // com.google.android.gms.internal.ads.zzawi
    public final zzbbh<AdvertisingIdClient.Info> a(Context context) {
        zzbbr zzbbrVar = new zzbbr();
        zzyt.a();
        if (zzazt.n(context)) {
            zzaxg.b(new t4(this, context, zzbbrVar));
        }
        return zzbbrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzawi
    public final zzbbh<String> b(String str, PackageInfo packageInfo) {
        return zzbar.o(str);
    }
}
