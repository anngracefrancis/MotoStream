package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(26)
public class zzaxx extends zzaxw {
    @Override // com.google.android.gms.internal.ads.zzaxo
    public final zzwx h(Context context, TelephonyManager telephonyManager) {
        zzk.zzlg();
        if (zzaxi.f0(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return telephonyManager.isDataEnabled() ? zzwx.ENUM_TRUE : zzwx.ENUM_FALSE;
        }
        return zzwx.ENUM_FALSE;
    }
}
