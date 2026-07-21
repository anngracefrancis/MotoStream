package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zap;

/* JADX INFO: loaded from: classes2.dex */
final class x extends zap {
    private final /* synthetic */ zabe a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    x(zabe zabeVar, Looper looper) {
        super(looper);
        this.a = zabeVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            ((w) message.obj).b(this.a);
        } else {
            if (i2 == 2) {
                throw ((RuntimeException) message.obj);
            }
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i2);
            Log.w("GACStateManager", sb.toString());
        }
    }
}
