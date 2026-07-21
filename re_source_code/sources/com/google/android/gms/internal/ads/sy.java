package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
final class sy extends BroadcastReceiver {
    private final /* synthetic */ zzeh a;

    sy(zzeh zzehVar) {
        this.a = zzehVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.a.e();
    }
}
