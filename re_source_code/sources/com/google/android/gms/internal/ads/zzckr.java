package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzckr implements zzcjv<zzbvx> {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbws f15332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f15333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzcxk f15334d;

    public zzckr(Context context, Executor executor, zzbws zzbwsVar, zzcxk zzcxkVar) {
        this.a = context;
        this.f15332b = zzbwsVar;
        this.f15333c = executor;
        this.f15334d = zzcxkVar;
    }

    private static String d(zzcxm zzcxmVar) {
        try {
            return zzcxmVar.s.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<zzbvx> a(final zzcxu zzcxuVar, final zzcxm zzcxmVar) {
        String strD = d(zzcxmVar);
        final Uri uri = strD != null ? Uri.parse(strD) : null;
        return zzbar.c(zzbar.o(null), new zzbal(this, uri, zzcxuVar, zzcxmVar) { // from class: com.google.android.gms.internal.ads.pk
            private final zzckr a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Uri f13175b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final zzcxu f13176c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final zzcxm f13177d;

            {
                this.a = this;
                this.f13175b = uri;
                this.f13176c = zzcxuVar;
                this.f13177d = zzcxmVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.a.c(this.f13175b, this.f13176c, this.f13177d, obj);
            }
        }, this.f15333c);
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean b(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        return (this.a instanceof Activity) && PlatformVersion.b() && zzads.a(this.a) && !TextUtils.isEmpty(d(zzcxmVar));
    }

    final /* synthetic */ zzbbh c(Uri uri, zzcxu zzcxuVar, zzcxm zzcxmVar, Object obj) throws Exception {
        try {
            c.c.b.c cVarC = new c.c.b.c.a().c();
            cVarC.a.setData(uri);
            com.google.android.gms.ads.internal.overlay.zzc zzcVar = new com.google.android.gms.ads.internal.overlay.zzc(cVarC.a);
            final zzbbr zzbbrVar = new zzbbr();
            zzbvy zzbvyVarA = this.f15332b.a(new zzbpr(zzcxuVar, zzcxmVar, null), new zzbvz(new zzbwz(zzbbrVar) { // from class: com.google.android.gms.internal.ads.qk
                private final zzbbr a;

                {
                    this.a = zzbbrVar;
                }

                @Override // com.google.android.gms.internal.ads.zzbwz
                public final void a(boolean z, Context context) {
                    zzbbr zzbbrVar2 = this.a;
                    try {
                        zzk.zzlf();
                        com.google.android.gms.ads.internal.overlay.zzm.zza(context, (AdOverlayInfoParcel) zzbbrVar2.get(), true);
                    } catch (Exception unused) {
                    }
                }
            }));
            zzbbrVar.a(new AdOverlayInfoParcel(zzcVar, null, zzbvyVarA.i(), null, new zzbai(0, 0, false)));
            this.f15334d.f();
            return zzbar.o(zzbvyVarA.h());
        } catch (Throwable th) {
            zzbad.c("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }
}
