package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
final class ca implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12412f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f12413g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ long f12414h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ long f12415i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ boolean f12416j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ int f12417k;
    private final /* synthetic */ int l;
    private final /* synthetic */ zzbft m;

    ca(zzbft zzbftVar, String str, String str2, long j2, long j3, boolean z, int i2, int i3) {
        this.m = zzbftVar;
        this.f12412f = str;
        this.f12413g = str2;
        this.f12414h = j2;
        this.f12415i = j3;
        this.f12416j = z;
        this.f12417k = i2;
        this.l = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheProgress");
        map.put("src", this.f12412f);
        map.put("cachedSrc", this.f12413g);
        map.put("bufferedDuration", Long.toString(this.f12414h));
        map.put("totalDuration", Long.toString(this.f12415i));
        map.put("cacheReady", this.f12416j ? "1" : "0");
        map.put("playerCount", Integer.toString(this.f12417k));
        map.put("playerPreparedCount", Integer.toString(this.l));
        this.m.r("onPrecacheEvent", map);
    }
}
