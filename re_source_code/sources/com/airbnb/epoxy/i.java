package com.airbnb.epoxy;

import android.util.Log;

/* JADX INFO: compiled from: DebugTimer.java */
/* JADX INFO: loaded from: classes.dex */
class i implements k0 {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f8434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8435c;

    i(String str) {
        this.a = str;
        b();
    }

    private void b() {
        this.f8434b = -1L;
        this.f8435c = null;
    }

    @Override // com.airbnb.epoxy.k0
    public void a(String str) {
        if (this.f8434b != -1) {
            throw new IllegalStateException("Timer was already started");
        }
        this.f8434b = System.nanoTime();
        this.f8435c = str;
    }

    @Override // com.airbnb.epoxy.k0
    public void stop() {
        if (this.f8434b == -1) {
            throw new IllegalStateException("Timer was not started");
        }
        float fNanoTime = (System.nanoTime() - this.f8434b) / 1000000.0f;
        Log.d(this.a, String.format(this.f8435c + ": %.3fms", Float.valueOf(fNanoTime)));
        b();
    }
}
