package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
final class da implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12461f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f12462g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ int f12463h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ int f12464i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ long f12465j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ long f12466k;
    private final /* synthetic */ boolean l;
    private final /* synthetic */ int m;
    private final /* synthetic */ int n;
    private final /* synthetic */ zzbft o;

    da(zzbft zzbftVar, String str, String str2, int i2, int i3, long j2, long j3, boolean z, int i4, int i5) {
        this.o = zzbftVar;
        this.f12461f = str;
        this.f12462g = str2;
        this.f12463h = i2;
        this.f12464i = i3;
        this.f12465j = j2;
        this.f12466k = j3;
        this.l = z;
        this.m = i4;
        this.n = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheProgress");
        map.put("src", this.f12461f);
        map.put("cachedSrc", this.f12462g);
        map.put("bytesLoaded", Integer.toString(this.f12463h));
        map.put("totalBytes", Integer.toString(this.f12464i));
        map.put("bufferedDuration", Long.toString(this.f12465j));
        map.put("totalDuration", Long.toString(this.f12466k));
        map.put("cacheReady", this.l ? "1" : "0");
        map.put("playerCount", Integer.toString(this.m));
        map.put("playerPreparedCount", Integer.toString(this.n));
        this.o.r("onPrecacheEvent", map);
    }
}
