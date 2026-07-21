package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbja {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f14483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f14485d;

    @TargetApi(21)
    public zzbja(WebResourceRequest webResourceRequest) {
        this(webResourceRequest.getUrl().toString(), webResourceRequest.getUrl(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders());
    }

    public zzbja(String str) {
        this(str, Uri.parse(str), null, null);
    }

    private zzbja(String str, Uri uri, String str2, Map<String, String> map) {
        this.a = str;
        this.f14483b = uri;
        this.f14484c = str2 == null ? "GET" : str2;
        this.f14485d = map == null ? Collections.emptyMap() : map;
    }
}
