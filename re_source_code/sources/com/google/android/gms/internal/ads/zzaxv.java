package com.google.android.gms.internal.ads;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public class zzaxv extends zzaxu {
    @Override // com.google.android.gms.internal.ads.zzaxo
    public final WebResourceResponse f(String str, String str2, int i2, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i2, str3, map, inputStream);
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final zzbha g(zzbgz zzbgzVar, zzwj zzwjVar, boolean z) {
        return new zzbib(zzbgzVar, zzwjVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final CookieManager n(Context context) {
        if (zzaxo.u()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzbad.c("Failed to obtain CookieManager.", th);
            zzk.zzlk().e(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final int v() {
        return R.style.Theme.Material.Dialog.Alert;
    }
}
