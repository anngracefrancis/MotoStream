package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbxg implements zzbrl, zzbur {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzavf f14802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f14803g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzavg f14804h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final View f14805i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f14806j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f14807k;

    public zzbxg(zzavf zzavfVar, Context context, zzavg zzavgVar, View view, int i2) {
        this.f14802f = zzavfVar;
        this.f14803g = context;
        this.f14804h = zzavgVar;
        this.f14805i = view;
        this.f14807k = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void a(zzasr zzasrVar, String str, String str2) {
        if (this.f14804h.D(this.f14803g)) {
            try {
                zzavg zzavgVar = this.f14804h;
                Context context = this.f14803g;
                zzavgVar.g(context, zzavgVar.n(context), this.f14802f.j(), zzasrVar.getType(), zzasrVar.getAmount());
            } catch (RemoteException e2) {
                zzbad.d("Remote Exception to get reward item.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdClosed() {
        this.f14802f.k(false);
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdOpened() {
        View view = this.f14805i;
        if (view != null && this.f14806j != null) {
            this.f14804h.t(view.getContext(), this.f14806j);
        }
        this.f14802f.k(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbur
    public final void y() {
        String strF = this.f14804h.F(this.f14803g);
        this.f14806j = strF;
        String strValueOf = String.valueOf(strF);
        String str = this.f14807k == 7 ? "/Rewarded" : "/Interstitial";
        this.f14806j = str.length() != 0 ? strValueOf.concat(str) : new String(strValueOf);
    }
}
