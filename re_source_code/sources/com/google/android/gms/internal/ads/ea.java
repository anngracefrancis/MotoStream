package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
final class ea implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f12516g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ int f12517h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzbft f12518i;

    ea(zzbft zzbftVar, String str, String str2, int i2) {
        this.f12518i = zzbftVar;
        this.f12515f = str;
        this.f12516g = str2;
        this.f12517h = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheComplete");
        map.put("src", this.f12515f);
        map.put("cachedSrc", this.f12516g);
        map.put("totalBytes", Integer.toString(this.f12517h));
        this.f12518i.r("onPrecacheEvent", map);
    }
}
