package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
final class ba implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f12329g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ long f12330h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ long f12331i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ boolean f12332j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzbft f12333k;

    ba(zzbft zzbftVar, String str, String str2, long j2, long j3, boolean z) {
        this.f12333k = zzbftVar;
        this.f12328f = str;
        this.f12329g = str2;
        this.f12330h = j2;
        this.f12331i = j3;
        this.f12332j = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheProgress");
        map.put("src", this.f12328f);
        map.put("cachedSrc", this.f12329g);
        map.put("bufferedDuration", Long.toString(this.f12330h));
        map.put("totalDuration", Long.toString(this.f12331i));
        map.put("cacheReady", this.f12332j ? "1" : "0");
        this.f12333k.r("onPrecacheEvent", map);
    }
}
