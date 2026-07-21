package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
final class fa implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12574f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f12575g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ long f12576h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzbft f12577i;

    fa(zzbft zzbftVar, String str, String str2, long j2) {
        this.f12577i = zzbftVar;
        this.f12574f = str;
        this.f12575g = str2;
        this.f12576h = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheComplete");
        map.put("src", this.f12574f);
        map.put("cachedSrc", this.f12575g);
        map.put("totalDuration", Long.toString(this.f12576h));
        this.f12577i.r("onPrecacheEvent", map);
    }
}
