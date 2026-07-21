package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcoc implements zzcjz<zzaov, zzcla> {
    private final zzclc a;

    public zzcoc(zzclc zzclcVar) {
        this.a = zzclcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjz
    public final zzcjy<zzaov, zzcla> a(String str, JSONObject jSONObject) throws RemoteException {
        zzaov zzaovVarD = this.a.d(str);
        if (zzaovVarD == null) {
            return null;
        }
        return new zzcjy<>(zzaovVarD, new zzcla(), str);
    }
}
