package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcoo implements zzf {
    private final zzbri a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbrt f15472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbvd f15473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbva f15474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzbmn f15475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicBoolean f15476f = new AtomicBoolean(false);

    zzcoo(zzbri zzbriVar, zzbrt zzbrtVar, zzbvd zzbvdVar, zzbva zzbvaVar, zzbmn zzbmnVar) {
        this.a = zzbriVar;
        this.f15472b = zzbrtVar;
        this.f15473c = zzbvdVar;
        this.f15474d = zzbvaVar;
        this.f15475e = zzbmnVar;
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final synchronized void zzg(View view) {
        if (this.f15476f.compareAndSet(false, true)) {
            this.f15475e.onAdImpression();
            this.f15474d.Y(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzky() {
        if (this.f15476f.get()) {
            this.a.onAdClicked();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzkz() {
        if (this.f15476f.get()) {
            this.f15472b.Y();
            this.f15473c.Y();
        }
    }
}
