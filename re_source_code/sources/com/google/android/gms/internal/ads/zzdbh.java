package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes2.dex */
public class zzdbh extends Handler {
    public zzdbh() {
    }

    protected void a(Message message) {
        super.dispatchMessage(message);
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        a(message);
    }

    public zzdbh(Looper looper) {
        super(looper);
    }
}
