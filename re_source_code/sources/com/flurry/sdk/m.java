package com.flurry.sdk;

import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes2.dex */
public enum m {
    DeviceId(0, true),
    AndroidAdvertisingId(13, true),
    AndroidInstallationId(14, false),
    a1Cookie(WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY, true),
    a3Cookie(1002, true),
    bCookie(1003, true);

    public final int m;
    public final boolean n;

    m(int i2, boolean z) {
        this.m = i2;
        this.n = z;
    }
}
