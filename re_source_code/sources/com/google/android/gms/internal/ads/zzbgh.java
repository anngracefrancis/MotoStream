package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@TargetApi(16)
public final class zzbgh extends zzbgl {
    private final String m;

    public zzbgh(zzbdf zzbdfVar, String str) {
        super(zzbdfVar);
        this.m = null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgl
    protected final zzhn C(String str) {
        zzjt zzjtVar = new zzjt(this.f14430f, this.f14431g);
        return new zzig(Uri.parse(str), ((Boolean) zzyt.e().c(zzacu.y3)).booleanValue() ? new zzbeh(this.f14430f, zzjtVar, new zzbei(this) { // from class: com.google.android.gms.internal.ads.ha
            private final zzbgh a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbei
            public final void a(boolean z, long j2) {
                this.a.G(z, j2);
            }
        }) : zzjtVar, "video/webm".equals(this.m) ? new zzjg() : new zziv(), 2, ((Integer) zzyt.e().c(zzacu.D)).intValue());
    }

    @Override // com.google.android.gms.internal.ads.zzbgl
    protected final int D() {
        return 0;
    }

    final /* synthetic */ void G(final boolean z, final long j2) {
        final zzbdf zzbdfVar = this.f14432h.get();
        if (zzbdfVar != null) {
            zzbbm.a.execute(new Runnable(zzbdfVar, z, j2) { // from class: com.google.android.gms.internal.ads.ia

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final zzbdf f12752f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                private final boolean f12753g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                private final long f12754h;

                {
                    this.f12752f = zzbdfVar;
                    this.f12753g = z;
                    this.f12754h = j2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f12752f.R(this.f12753g, this.f12754h);
                }
            });
        }
    }
}
