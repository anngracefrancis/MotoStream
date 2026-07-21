package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbvx extends zzbpc {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f14754f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbup f14755g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzbwz f14756h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzbpv f14757i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzdan f14758j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f14759k = false;

    zzbvx(Context context, zzbry zzbryVar, zzbup zzbupVar, zzbwz zzbwzVar, zzbpv zzbpvVar, zzdan zzdanVar) {
        this.f14754f = context;
        this.f14663c = zzbryVar;
        this.f14755g = zzbupVar;
        this.f14756h = zzbwzVar;
        this.f14757i = zzbpvVar;
        this.f14758j = zzdanVar;
    }

    public final boolean g() {
        return this.f14757i.a();
    }

    public final void h(boolean z) {
        this.f14755g.y();
        this.f14756h.a(z, this.f14754f);
        this.f14759k = true;
    }

    public final zzbry i() {
        return this.f14663c;
    }

    public final boolean j() {
        if (((Boolean) zzyt.e().c(zzacu.L0)).booleanValue()) {
            zzk.zzlg();
            if (zzaxi.A(this.f14754f)) {
                zzbad.i("It is not recommended to show an interstitial when app is not in foreground.");
                if (((Boolean) zzyt.e().c(zzacu.M0)).booleanValue()) {
                    this.f14758j.a(this.a.f15747b.f15744b.f15736b);
                }
                return false;
            }
        }
        return !this.f14759k;
    }
}
