package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzawx {
    public static void a(Context context) {
        if (zzazx.o(context) && !zzazx.u()) {
            zzbbh zzbbhVarZzvi = new a5(context).zzvi();
            zzbad.h("Updating ad debug logging enablement.");
            zzbao.a(zzbbhVarZzvi, "AdDebugLogUpdater.updateEnablement");
        }
    }
}
