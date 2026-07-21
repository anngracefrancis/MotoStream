package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzawv;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zzaxo;

/* JADX INFO: loaded from: classes2.dex */
@zzard
final class zzk extends zzawv {
    final /* synthetic */ zzd zzdki;

    private zzk(zzd zzdVar) {
        this.zzdki = zzdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final void zzto() {
        Bitmap bitmapA = com.google.android.gms.ads.internal.zzk.zzlz().a(Integer.valueOf(this.zzdki.zzdjl.zzdkt.zzbrj));
        if (bitmapA != null) {
            zzaxo zzaxoVarZzli = com.google.android.gms.ads.internal.zzk.zzli();
            zzd zzdVar = this.zzdki;
            Activity activity = zzdVar.mActivity;
            com.google.android.gms.ads.internal.zzh zzhVar = zzdVar.zzdjl.zzdkt;
            final Drawable drawableE = zzaxoVarZzli.e(activity, bitmapA, zzhVar.zzbrh, zzhVar.zzbri);
            zzaxi.a.post(new Runnable(this, drawableE) { // from class: com.google.android.gms.ads.internal.overlay.zzl
                private final zzk zzdkj;
                private final Drawable zzdkk;

                {
                    this.zzdkj = this;
                    this.zzdkk = drawableE;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzk zzkVar = this.zzdkj;
                    zzkVar.zzdki.mActivity.getWindow().setBackgroundDrawable(this.zzdkk);
                }
            });
        }
    }
}
