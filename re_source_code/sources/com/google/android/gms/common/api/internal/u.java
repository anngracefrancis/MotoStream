package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zap;

/* JADX INFO: loaded from: classes2.dex */
final class u extends zap {
    private final /* synthetic */ zaaw a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    u(zaaw zaawVar, Looper looper) {
        super(looper);
        this.a = zaawVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            this.a.D();
            return;
        }
        if (i2 == 2) {
            this.a.x();
            return;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("Unknown message id: ");
        sb.append(i2);
        Log.w("GoogleApiClientImpl", sb.toString());
    }
}
