package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
final class z9 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f13688f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f13689g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ int f13690h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ int f13691i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ boolean f13692j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzbft f13693k;

    z9(zzbft zzbftVar, String str, String str2, int i2, int i3, boolean z) {
        this.f13693k = zzbftVar;
        this.f13688f = str;
        this.f13689g = str2;
        this.f13690h = i2;
        this.f13691i = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheProgress");
        map.put("src", this.f13688f);
        map.put("cachedSrc", this.f13689g);
        map.put("bytesLoaded", Integer.toString(this.f13690h));
        map.put("totalBytes", Integer.toString(this.f13691i));
        map.put("cacheReady", this.f13692j ? "1" : "0");
        this.f13693k.r("onPrecacheEvent", map);
    }
}
