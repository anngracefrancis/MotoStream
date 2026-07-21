package com.google.android.gms.internal.ads;

import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
final class d8 implements Runnable {
    d8(c8 c8Var) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Looper.myLooper().quit();
    }
}
