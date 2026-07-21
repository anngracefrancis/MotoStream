package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public class zzde extends zzdf {
    private AdvertisingIdClient.Info I;

    @Override // com.google.android.gms.internal.ads.zzdf, com.google.android.gms.internal.ads.zzdd
    protected final zzbp.zza.C0176zza b(Context context, View view, Activity activity) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdf
    protected final void h(zzdy zzdyVar, Context context, zzbp.zza.C0176zza c0176zza, zzbk.zza zzaVar) {
        if (!zzdyVar.n) {
            zzdf.i(k(zzdyVar, context, c0176zza, zzaVar));
            return;
        }
        AdvertisingIdClient.Info info = this.I;
        if (info != null) {
            String id = info.getId();
            if (!TextUtils.isEmpty(id)) {
                c0176zza.C(zzef.e(id));
                c0176zza.T(zzbp.zza.zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
                c0176zza.X(this.I.isLimitAdTrackingEnabled());
            }
            this.I = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdf
    protected final List<Callable<Void>> k(zzdy zzdyVar, Context context, zzbp.zza.C0176zza c0176zza, zzbk.zza zzaVar) {
        ArrayList arrayList = new ArrayList();
        if (zzdyVar.r() == null) {
            return arrayList;
        }
        arrayList.add(new zzes(zzdyVar, "3pegtvj7nkb7e3rwh5b+3dnQATJj6aqtaosJ3DkOYPzNGN2w+CoarbJEsY1UQgeA", "/kRTFQbKQx44ublaFMNQ8yNL6QxOrgEofiWDpZSH6zA=", c0176zza, zzdyVar.q(), 24));
        return arrayList;
    }
}
