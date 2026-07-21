package com.google.android.gms.cloudmessaging;

import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class u extends com.google.android.gms.internal.cloudmessaging.zze {
    private final /* synthetic */ Rpc a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    u(Rpc rpc, Looper looper) {
        super(looper);
        this.a = rpc;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.a.g(message);
    }
}
