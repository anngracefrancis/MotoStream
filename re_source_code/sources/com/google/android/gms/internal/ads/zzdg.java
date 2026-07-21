package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdg extends zzdf {
    private zzdg(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static zzdg l(String str, Context context, boolean z) {
        zzdf.g(context, z);
        return new zzdg(context, str, z);
    }

    @Override // com.google.android.gms.internal.ads.zzdf
    protected final List<Callable<Void>> k(zzdy zzdyVar, Context context, zzbp.zza.C0176zza c0176zza, zzbk.zza zzaVar) {
        if (zzdyVar.r() == null || !this.D) {
            return super.k(zzdyVar, context, c0176zza, zzaVar);
        }
        int iQ = zzdyVar.q();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.k(zzdyVar, context, c0176zza, zzaVar));
        arrayList.add(new zzes(zzdyVar, "3pegtvj7nkb7e3rwh5b+3dnQATJj6aqtaosJ3DkOYPzNGN2w+CoarbJEsY1UQgeA", "/kRTFQbKQx44ublaFMNQ8yNL6QxOrgEofiWDpZSH6zA=", c0176zza, iQ, 24));
        return arrayList;
    }
}
