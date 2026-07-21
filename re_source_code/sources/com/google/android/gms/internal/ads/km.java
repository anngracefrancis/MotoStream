package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class km implements zzbsn {
    private final /* synthetic */ zzbbr a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzcjy f12892b;

    km(zzcoe zzcoeVar, zzbbr zzbbrVar, zzcjy zzcjyVar) {
        this.a = zzbbrVar;
        this.f12892b = zzcjyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final synchronized void onAdFailedToLoad(int i2) {
        if (((Boolean) zzyt.e().c(zzacu.q4)).booleanValue()) {
            i2 = 3;
        }
        zzbbr zzbbrVar = this.a;
        String str = this.f12892b.a;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
        sb.append("adapter ");
        sb.append(str);
        sb.append(" failed to load");
        zzbbrVar.c(new zzcmw(sb.toString(), i2));
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final synchronized void onAdLoaded() {
        this.a.a(null);
    }
}
