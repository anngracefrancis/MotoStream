package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcbi {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzcxv f15014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f15015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzcdn f15016d;

    public zzcbi(Context context, zzcxv zzcxvVar, Executor executor, zzcdn zzcdnVar) {
        this.a = context;
        this.f15014b = zzcxvVar;
        this.f15015c = executor;
        this.f15016d = zzcdnVar;
    }

    private final void e(zzbgz zzbgzVar) {
        zzbgzVar.f("/video", zzagz.l);
        zzbgzVar.f("/videoMeta", zzagz.m);
        zzbgzVar.f("/precache", new zzbgc());
        zzbgzVar.f("/delayPageLoaded", zzagz.p);
        zzbgzVar.f("/instrument", zzagz.n);
        zzbgzVar.f("/log", zzagz.f13893g);
        zzbgzVar.f("/videoClicked", zzagz.f13894h);
        zzbgzVar.p().b(true);
        if (this.f15014b.f15749c != null) {
            zzbgzVar.f("/open", new zzahs(null, null));
        }
    }

    final /* synthetic */ zzbbh a(String str, String str2, Object obj) throws Exception {
        final zzbgz zzbgzVarB = this.f15016d.b(zzyd.Y(this.a));
        final zzbbq zzbbqVarE = zzbbq.e(zzbgzVarB);
        e(zzbgzVarB);
        if (this.f15014b.f15749c != null) {
            zzbgzVarB.A(zzbin.d());
        } else {
            zzbgzVarB.A(zzbin.c());
        }
        zzbgzVarB.p().i(new zzbij(this, zzbgzVarB, zzbbqVarE) { // from class: com.google.android.gms.internal.ads.bh
            private final zzcbi a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final zzbgz f12353b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final zzbbq f12354c;

            {
                this.a = this;
                this.f12353b = zzbgzVarB;
                this.f12354c = zzbbqVarE;
            }

            @Override // com.google.android.gms.internal.ads.zzbij
            public final void zzae(boolean z) {
                this.a.c(this.f12353b, this.f12354c, z);
            }
        });
        zzbgzVarB.G(str, str2, null);
        return zzbbqVarE;
    }

    final /* synthetic */ zzbbh b(JSONObject jSONObject, final zzbgz zzbgzVar) throws Exception {
        final zzbbq zzbbqVarE = zzbbq.e(zzbgzVar);
        if (this.f15014b.f15749c != null) {
            zzbgzVar.A(zzbin.d());
        } else {
            zzbgzVar.A(zzbin.c());
        }
        zzbgzVar.p().i(new zzbij(this, zzbgzVar, zzbbqVarE) { // from class: com.google.android.gms.internal.ads.ch
            private final zzcbi a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final zzbgz f12430b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final zzbbq f12431c;

            {
                this.a = this;
                this.f12430b = zzbgzVar;
                this.f12431c = zzbbqVarE;
            }

            @Override // com.google.android.gms.internal.ads.zzbij
            public final void zzae(boolean z) {
                this.a.d(this.f12430b, this.f12431c, z);
            }
        });
        zzbgzVar.Y("google.afma.nativeAds.renderVideo", jSONObject);
        return zzbbqVarE;
    }

    final /* synthetic */ void c(zzbgz zzbgzVar, zzbbq zzbbqVar, boolean z) {
        if (this.f15014b.f15748b != null && zzbgzVar.h() != null) {
            zzbgzVar.h().m7(this.f15014b.f15748b);
        }
        zzbbqVar.f();
    }

    final /* synthetic */ void d(zzbgz zzbgzVar, zzbbq zzbbqVar, boolean z) {
        if (this.f15014b.f15748b != null && zzbgzVar.h() != null) {
            zzbgzVar.h().m7(this.f15014b.f15748b);
        }
        zzbbqVar.f();
    }

    public final zzbbh<zzbgz> f(final JSONObject jSONObject) {
        return zzbar.c(zzbar.c(zzbar.o(null), new zzbal(this) { // from class: com.google.android.gms.internal.ads.zg
            private final zzcbi a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.a.h(obj);
            }
        }, this.f15015c), new zzbal(this, jSONObject) { // from class: com.google.android.gms.internal.ads.xg
            private final zzcbi a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final JSONObject f13579b;

            {
                this.a = this;
                this.f13579b = jSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.a.b(this.f13579b, (zzbgz) obj);
            }
        }, this.f15015c);
    }

    public final zzbbh<zzbgz> g(final String str, final String str2) {
        return zzbar.c(zzbar.o(null), new zzbal(this, str, str2) { // from class: com.google.android.gms.internal.ads.yg
            private final zzcbi a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f13641b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final String f13642c;

            {
                this.a = this;
                this.f13641b = str;
                this.f13642c = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.a.a(this.f13641b, this.f13642c, obj);
            }
        }, this.f15015c);
    }

    final /* synthetic */ zzbbh h(Object obj) throws Exception {
        zzbgz zzbgzVarB = this.f15016d.b(zzyd.Y(this.a));
        final zzbbq zzbbqVarE = zzbbq.e(zzbgzVarB);
        e(zzbgzVarB);
        zzbgzVarB.p().j(new zzbik(zzbbqVarE) { // from class: com.google.android.gms.internal.ads.ah
            private final zzbbq a;

            {
                this.a = zzbbqVarE;
            }

            @Override // com.google.android.gms.internal.ads.zzbik
            public final void a() {
                this.a.f();
            }
        });
        zzbgzVarB.loadUrl((String) zzyt.e().c(zzacu.K2));
        return zzbbqVarE;
    }
}
