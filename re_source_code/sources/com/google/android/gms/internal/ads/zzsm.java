package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzsm {
    private boolean a;

    public final synchronized void a() throws InterruptedException {
        while (!this.a) {
            wait();
        }
    }

    public final synchronized boolean b() {
        if (this.a) {
            return false;
        }
        this.a = true;
        notifyAll();
        return true;
    }

    public final synchronized boolean c() {
        boolean z;
        z = this.a;
        this.a = false;
        return z;
    }
}
