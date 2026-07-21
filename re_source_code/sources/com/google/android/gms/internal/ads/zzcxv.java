package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcxv {
    public final zzzy a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzacd f15748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zzaiy f15749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zzxz f15750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final zzyd f15751e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f15752f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<String> f15753g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<String> f15754h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final zzady f15755i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f15756j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f15757k;
    public final int l;
    public final PublisherAdViewOptions m;
    public final zzzs n;
    public final Set<String> o;

    private zzcxv(zzcxx zzcxxVar) {
        this.f15751e = zzcxxVar.f15758b;
        this.f15752f = zzcxxVar.f15760d;
        this.a = zzcxxVar.f15759c;
        this.f15750d = new zzxz(zzcxxVar.a.f16968f, zzcxxVar.a.f16969g, zzcxxVar.a.f16970h, zzcxxVar.a.f16971i, zzcxxVar.a.f16972j, zzcxxVar.a.f16973k, zzcxxVar.a.l, zzcxxVar.a.m || zzcxxVar.f15762f, zzcxxVar.a.n, zzcxxVar.a.o, zzcxxVar.a.p, zzcxxVar.a.q, zzcxxVar.a.r, zzcxxVar.a.s, zzcxxVar.a.t, zzcxxVar.a.u, zzcxxVar.a.v, zzcxxVar.a.w, zzcxxVar.a.x, zzcxxVar.a.y, zzcxxVar.a.z);
        this.f15748b = zzcxxVar.f15761e != null ? zzcxxVar.f15761e : zzcxxVar.f15765i != null ? zzcxxVar.f15765i.f13850k : null;
        this.f15753g = zzcxxVar.f15763g;
        this.f15754h = zzcxxVar.f15764h;
        this.f15755i = zzcxxVar.f15763g != null ? zzcxxVar.f15765i == null ? new zzady(new NativeAdOptions.Builder().build()) : zzcxxVar.f15765i : null;
        this.f15756j = zzcxxVar.l;
        this.f15757k = zzcxxVar.m;
        this.l = zzcxxVar.n;
        this.m = zzcxxVar.f15766j;
        this.n = zzcxxVar.f15767k;
        this.f15749c = zzcxxVar.o;
        this.o = zzcxxVar.p;
    }

    public final zzaga a() {
        PublisherAdViewOptions publisherAdViewOptions = this.m;
        if (publisherAdViewOptions == null) {
            return null;
        }
        return publisherAdViewOptions.zzku();
    }
}
