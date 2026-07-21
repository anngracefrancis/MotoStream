package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbxa implements com.google.android.gms.ads.internal.overlay.zzo, zzbsr {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f14789f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbgz f14790g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzcxm f14791h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzbai f14792i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f14793j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @VisibleForTesting
    private IObjectWrapper f14794k;

    public zzbxa(Context context, zzbgz zzbgzVar, zzcxm zzcxmVar, zzbai zzbaiVar, int i2) {
        this.f14789f = context;
        this.f14790g = zzbgzVar;
        this.f14791h = zzcxmVar;
        this.f14792i = zzbaiVar;
        this.f14793j = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final void onAdLoaded() {
        int i2 = this.f14793j;
        if ((i2 == 7 || i2 == 3) && this.f14791h.J && this.f14790g != null && zzk.zzlv().g(this.f14789f)) {
            zzbai zzbaiVar = this.f14792i;
            int i3 = zzbaiVar.f14327g;
            int i4 = zzbaiVar.f14328h;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i3);
            sb.append(".");
            sb.append(i4);
            IObjectWrapper iObjectWrapperB = zzk.zzlv().b(sb.toString(), this.f14790g.getWebView(), HttpUrl.FRAGMENT_ENCODE_SET, "javascript", this.f14791h.L.optInt("media_type", -1) == 0 ? null : "javascript");
            this.f14794k = iObjectWrapperB;
            if (iObjectWrapperB == null || this.f14790g.getView() == null) {
                return;
            }
            zzk.zzlv().d(this.f14794k, this.f14790g.getView());
            this.f14790g.H(this.f14794k);
            zzk.zzlv().e(this.f14794k);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzsz() {
        this.f14794k = null;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzta() {
        zzbgz zzbgzVar;
        if (this.f14794k == null || (zzbgzVar = this.f14790g) == null) {
            return;
        }
        zzbgzVar.y("onSdkImpression", new HashMap());
    }
}
