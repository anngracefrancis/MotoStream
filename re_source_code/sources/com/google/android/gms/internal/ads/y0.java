package com.google.android.gms.internal.ads;

import android.webkit.JavascriptInterface;

/* JADX INFO: loaded from: classes2.dex */
final class y0 {
    private final zzajt a;

    private y0(zzajt zzajtVar) {
        this.a = zzajtVar;
    }

    @JavascriptInterface
    public final void notify(String str) {
        this.a.u(str);
    }
}
