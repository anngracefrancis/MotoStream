package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
final class aa implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12232f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f12233g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ int f12234h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ int f12235i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ boolean f12236j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ int f12237k;
    private final /* synthetic */ int l;
    private final /* synthetic */ zzbft m;

    aa(zzbft zzbftVar, String str, String str2, int i2, int i3, boolean z, int i4, int i5) {
        this.m = zzbftVar;
        this.f12232f = str;
        this.f12233g = str2;
        this.f12234h = i2;
        this.f12236j = z;
        this.f12237k = i4;
        this.l = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheProgress");
        map.put("src", this.f12232f);
        map.put("cachedSrc", this.f12233g);
        map.put("bytesLoaded", Integer.toString(this.f12234h));
        map.put("totalBytes", Integer.toString(this.f12235i));
        map.put("cacheReady", this.f12236j ? "1" : "0");
        map.put("playerCount", Integer.toString(this.f12237k));
        map.put("playerPreparedCount", Integer.toString(this.l));
        this.m.r("onPrecacheEvent", map);
    }
}
