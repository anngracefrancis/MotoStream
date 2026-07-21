package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.zzk;
import java.io.File;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@TargetApi(11)
public class zzbia extends zzbha {
    public zzbia(zzbgz zzbgzVar, zzwj zzwjVar, boolean z) {
        super(zzbgzVar, zzwjVar, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final WebResourceResponse L(WebView webView, String str, Map<String, String> map) {
        String str2;
        if (!(webView instanceof zzbgz)) {
            zzbad.i("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzbgz zzbgzVar = (zzbgz) webView;
        zzavb zzavbVar = this.v;
        if (zzavbVar != null) {
            zzavbVar.a(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.I(str, map);
        }
        if (zzbgzVar.p() != null) {
            zzbgzVar.p().d();
        }
        if (zzbgzVar.o().e()) {
            str2 = (String) zzyt.e().c(zzacu.b0);
        } else if (zzbgzVar.m()) {
            str2 = (String) zzyt.e().c(zzacu.a0);
        } else {
            str2 = (String) zzyt.e().c(zzacu.Z);
        }
        zzk.zzlg();
        return zzaxi.L(zzbgzVar.getContext(), zzbgzVar.b().f14326f, str2);
    }
}
