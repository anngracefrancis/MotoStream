package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaab;
import com.google.android.gms.internal.ads.zzabp;
import com.google.android.gms.internal.ads.zzaem;
import com.google.android.gms.internal.ads.zzaer;
import com.google.android.gms.internal.ads.zzamp;
import com.google.android.gms.internal.ads.zzaqg;
import com.google.android.gms.internal.ads.zzaqq;
import com.google.android.gms.internal.ads.zzasw;
import com.google.android.gms.internal.ads.zzatt;
import com.google.android.gms.internal.ads.zzbjm;
import com.google.android.gms.internal.ads.zzbzi;
import com.google.android.gms.internal.ads.zzbzj;
import com.google.android.gms.internal.ads.zzcpo;
import com.google.android.gms.internal.ads.zzcpt;
import com.google.android.gms.internal.ads.zzcqd;
import com.google.android.gms.internal.ads.zzcqf;
import com.google.android.gms.internal.ads.zzcqj;
import com.google.android.gms.internal.ads.zzyd;
import com.google.android.gms.internal.ads.zzzf;
import com.google.android.gms.internal.ads.zzzk;
import com.google.android.gms.internal.ads.zzzw;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ClientApi2 extends zzzw {
    @KeepForSdk
    public ClientApi2() {
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzzk zza(IObjectWrapper iObjectWrapper, zzyd zzydVar, String str, zzamp zzampVar, int i2) {
        Context context = (Context) ObjectWrapper.k0(iObjectWrapper);
        return new zzcpt(zzbjm.b(context, zzampVar, i2), context, zzydVar, str);
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzzk zzb(IObjectWrapper iObjectWrapper, zzyd zzydVar, String str, zzamp zzampVar, int i2) {
        Context context = (Context) ObjectWrapper.k0(iObjectWrapper);
        return new zzcqd(zzbjm.b(context, zzampVar, i2), context, zzydVar, str);
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaem zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzbzj((FrameLayout) ObjectWrapper.k0(iObjectWrapper), (FrameLayout) ObjectWrapper.k0(iObjectWrapper2));
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaqg zzf(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.k0(iObjectWrapper);
        AdOverlayInfoParcel adOverlayInfoParcelZzc = AdOverlayInfoParcel.zzc(activity.getIntent());
        if (adOverlayInfoParcelZzc == null) {
            return new zzs(activity);
        }
        int i2 = adOverlayInfoParcelZzc.zzdkr;
        if (i2 == 1) {
            return new zzr(activity);
        }
        if (i2 == 2) {
            return new zzy(activity);
        }
        if (i2 != 3) {
            return i2 != 4 ? new zzs(activity) : new zzt(activity, adOverlayInfoParcelZzc);
        }
        return new zzz(activity);
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaab zzg(IObjectWrapper iObjectWrapper) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaqq zzh(IObjectWrapper iObjectWrapper) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzzf zza(IObjectWrapper iObjectWrapper, String str, zzamp zzampVar, int i2) {
        Context context = (Context) ObjectWrapper.k0(iObjectWrapper);
        return new zzcpo(zzbjm.b(context, zzampVar, i2), context, str);
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzatt zzb(IObjectWrapper iObjectWrapper, String str, zzamp zzampVar, int i2) {
        Context context = (Context) ObjectWrapper.k0(iObjectWrapper);
        return new zzcqf(zzbjm.b(context, zzampVar, i2), context, str);
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzasw zza(IObjectWrapper iObjectWrapper, zzamp zzampVar, int i2) {
        Context context = (Context) ObjectWrapper.k0(iObjectWrapper);
        return new zzcqj(zzbjm.b(context, zzampVar, i2), context);
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaab zza(IObjectWrapper iObjectWrapper, int i2) {
        return zzbjm.o((Context) ObjectWrapper.k0(iObjectWrapper), i2).i();
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzzk zza(IObjectWrapper iObjectWrapper, zzyd zzydVar, String str, int i2) {
        return new zzabp();
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaer zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzbzi((View) ObjectWrapper.k0(iObjectWrapper), (HashMap) ObjectWrapper.k0(iObjectWrapper2), (HashMap) ObjectWrapper.k0(iObjectWrapper3));
    }
}
