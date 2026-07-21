package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.android.gms.internal.ads.zzbhx;
import com.google.android.gms.internal.ads.zzbif;
import com.google.android.gms.internal.ads.zzbih;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@TargetApi(17)
public final class zzbht<WebViewT extends zzbhx & zzbif & zzbih> {
    private final zzbhw a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WebViewT f14467b;

    private zzbht(WebViewT webviewt, zzbhw zzbhwVar) {
        this.a = zzbhwVar;
        this.f14467b = webviewt;
    }

    public static zzbht<zzbgz> a(final zzbgz zzbgzVar) {
        return new zzbht<>(zzbgzVar, new zzbhw(zzbgzVar) { // from class: com.google.android.gms.internal.ads.hb
            private final zzbgz a;

            {
                this.a = zzbgzVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbhw
            public final void a(Uri uri) {
                zzbii zzbiiVarP = this.a.p();
                if (zzbiiVarP == null) {
                    zzbad.g("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
                } else {
                    zzbiiVarP.a(uri);
                }
            }
        });
    }

    final /* synthetic */ void b(String str) {
        this.a.a(Uri.parse(str));
    }

    @JavascriptInterface
    public final String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            zzawz.m("Click string is empty, not proceeding.");
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        zzdh zzdhVarD = this.f14467b.d();
        if (zzdhVarD == null) {
            zzawz.m("Signal utils is empty, ignoring.");
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        zzdc zzdcVarF = zzdhVarD.f();
        if (zzdcVarF == null) {
            zzawz.m("Signals object is empty, ignoring.");
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (this.f14467b.getContext() != null) {
            return zzdcVarF.zza(this.f14467b.getContext(), str, this.f14467b.getView(), this.f14467b.a());
        }
        zzawz.m("Context is null, ignoring.");
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    @JavascriptInterface
    public final void notify(final String str) {
        if (TextUtils.isEmpty(str)) {
            zzbad.i("URL is empty, ignoring message");
        } else {
            zzaxi.a.post(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.ib

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final zzbht f12755f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                private final String f12756g;

                {
                    this.f12755f = this;
                    this.f12756g = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f12755f.b(this.f12756g);
                }
            });
        }
    }
}
