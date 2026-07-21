package com.google.android.gms.internal.ads;

import android.content.Context;
import cm.aptoide.pt.dataprovider.BuildConfig;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzjt implements zzkf {
    private final zzkf a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzkf f16376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzkf f16377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzkf f16378d;

    public zzjt(Context context, String str) {
        this(context, null, str, false);
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final long a(zzjq zzjqVar) throws IOException {
        zzkh.d(this.f16378d == null);
        String scheme = zzjqVar.a.getScheme();
        if ("http".equals(scheme) || BuildConfig.APTOIDE_WEB_SERVICES_SCHEME.equals(scheme)) {
            this.f16378d = this.a;
        } else if ("file".equals(scheme)) {
            if (zzjqVar.a.getPath().startsWith("/android_asset/")) {
                this.f16378d = this.f16377c;
            } else {
                this.f16378d = this.f16376b;
            }
        } else {
            if (!"asset".equals(scheme)) {
                throw new zzju(scheme);
            }
            this.f16378d = this.f16377c;
        }
        return this.f16378d.a(zzjqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final void close() throws IOException {
        zzkf zzkfVar = this.f16378d;
        if (zzkfVar != null) {
            try {
                zzkfVar.close();
            } finally {
                this.f16378d = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        return this.f16378d.read(bArr, i2, i3);
    }

    private zzjt(Context context, zzke zzkeVar, String str, boolean z) {
        this(context, null, new zzjs(str, null, null, 8000, 8000, false));
    }

    private zzjt(Context context, zzke zzkeVar, zzkf zzkfVar) {
        this.a = (zzkf) zzkh.c(zzkfVar);
        this.f16376b = new zzjv(null);
        this.f16377c = new zzjm(context, null);
    }
}
