package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes2.dex */
final class xy extends Handler {
    private final /* synthetic */ wy a;

    xy(wy wyVar) {
        this.a = wyVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.a.m(message);
    }
}
