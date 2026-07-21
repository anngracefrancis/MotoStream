package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
final class ga implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12635f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f12636g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f12637h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ String f12638i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzbft f12639j;

    ga(zzbft zzbftVar, String str, String str2, String str3, String str4) {
        this.f12639j = zzbftVar;
        this.f12635f = str;
        this.f12636g = str2;
        this.f12637h = str3;
        this.f12638i = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheCanceled");
        map.put("src", this.f12635f);
        if (!TextUtils.isEmpty(this.f12636g)) {
            map.put("cachedSrc", this.f12636g);
        }
        zzbft zzbftVar = this.f12639j;
        map.put("type", zzbft.A(this.f12637h));
        map.put("reason", this.f12637h);
        if (!TextUtils.isEmpty(this.f12638i)) {
            map.put("message", this.f12638i);
        }
        this.f12639j.r("onPrecacheEvent", map);
    }
}
