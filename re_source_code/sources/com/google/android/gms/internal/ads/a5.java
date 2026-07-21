package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class a5 extends zzawv {
    private Context a;

    a5(Context context) {
        this.a = context;
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final void zzto() {
        boolean isAdIdFakeForDebugLogging;
        try {
            isAdIdFakeForDebugLogging = AdvertisingIdClient.getIsAdIdFakeForDebugLogging(this.a);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e2) {
            zzbad.c("Fail to get isAdIdFakeForDebugLogging", e2);
            isAdIdFakeForDebugLogging = false;
        }
        zzazx.l(isAdIdFakeForDebugLogging);
        StringBuilder sb = new StringBuilder(43);
        sb.append("Update ad debug logging enablement as ");
        sb.append(isAdIdFakeForDebugLogging);
        zzbad.i(sb.toString());
    }
}
