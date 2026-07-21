package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbot implements zzbrw, zzbsr {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f14630f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbgz f14631g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzcxm f14632h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzbai f14633i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private IObjectWrapper f14634j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f14635k;

    public zzbot(Context context, zzbgz zzbgzVar, zzcxm zzcxmVar, zzbai zzbaiVar) {
        this.f14630f = context;
        this.f14631g = zzbgzVar;
        this.f14632h = zzcxmVar;
        this.f14633i = zzbaiVar;
    }

    private final synchronized void a() {
        if (this.f14632h.J) {
            if (this.f14631g == null) {
                return;
            }
            if (zzk.zzlv().g(this.f14630f)) {
                zzbai zzbaiVar = this.f14633i;
                int i2 = zzbaiVar.f14327g;
                int i3 = zzbaiVar.f14328h;
                StringBuilder sb = new StringBuilder(23);
                sb.append(i2);
                sb.append(".");
                sb.append(i3);
                this.f14634j = zzk.zzlv().b(sb.toString(), this.f14631g.getWebView(), HttpUrl.FRAGMENT_ENCODE_SET, "javascript", this.f14632h.L.optInt("media_type", -1) == 0 ? null : "javascript");
                View view = this.f14631g.getView();
                if (this.f14634j != null && view != null) {
                    zzk.zzlv().d(this.f14634j, view);
                    this.f14631g.H(this.f14634j);
                    zzk.zzlv().e(this.f14634j);
                    this.f14635k = true;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrw
    public final synchronized void onAdImpression() {
        zzbgz zzbgzVar;
        if (!this.f14635k) {
            a();
        }
        if (this.f14632h.J && this.f14634j != null && (zzbgzVar = this.f14631g) != null) {
            zzbgzVar.y("onSdkImpression", new c.e.a());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final synchronized void onAdLoaded() {
        if (this.f14635k) {
            return;
        }
        a();
    }
}
