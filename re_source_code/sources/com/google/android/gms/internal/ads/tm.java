package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;

/* JADX INFO: loaded from: classes2.dex */
final class tm implements zzf {
    private final /* synthetic */ zzbvy a;

    tm(zzcpa zzcpaVar, zzbvy zzbvyVar) {
        this.a = zzbvyVar;
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzg(View view) {
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzky() {
        this.a.c().onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzkz() {
        this.a.d().Y();
        this.a.e().Y();
    }
}
