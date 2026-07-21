package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
final class i5 extends BroadcastReceiver {
    private final /* synthetic */ zzaxi a;

    private i5(zzaxi zzaxiVar) {
        this.a = zzaxiVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            this.a.f14257d = true;
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.a.f14257d = false;
        }
    }

    /* synthetic */ i5(zzaxi zzaxiVar, e5 e5Var) {
        this(zzaxiVar);
    }
}
