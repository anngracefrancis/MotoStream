package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;

/* JADX INFO: loaded from: classes2.dex */
final class pm implements zzf {
    private final /* synthetic */ zzbbr a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzcxu f13178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzcxm f13179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzcoz f13180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzcor f13181e;

    pm(zzcor zzcorVar, zzbbr zzbbrVar, zzcxu zzcxuVar, zzcxm zzcxmVar, zzcoz zzcozVar) {
        this.f13181e = zzcorVar;
        this.a = zzbbrVar;
        this.f13178b = zzcxuVar;
        this.f13179c = zzcxmVar;
        this.f13180d = zzcozVar;
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzg(View view) {
        this.a.a(this.f13181e.f15483d.a(this.f13178b, this.f13179c, view, this.f13180d));
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzky() {
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzkz() {
    }
}
