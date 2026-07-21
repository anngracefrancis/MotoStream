package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
final class d40 extends BroadcastReceiver {
    private final /* synthetic */ zzua a;

    d40(zzua zzuaVar) {
        this.a = zzuaVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.a.f(3);
    }
}
