package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzapc extends zzaow {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RtbAdapter f14028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MediationInterstitialAd f14029g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MediationRewardedAd f14030h;

    public zzapc(RtbAdapter rtbAdapter) {
        this.f14028f = rtbAdapter;
    }

    private static String k7(String str, zzxz zzxzVar) {
        String str2 = zzxzVar.z;
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return str2;
        }
    }

    private static boolean l7(zzxz zzxzVar) {
        if (zzxzVar.f16973k) {
            return true;
        }
        zzyt.a();
        return zzazt.v();
    }

    private final Bundle m7(zzxz zzxzVar) {
        Bundle bundle;
        Bundle bundle2 = zzxzVar.r;
        return (bundle2 == null || (bundle = bundle2.getBundle(this.f14028f.getClass().getName())) == null) ? new Bundle() : bundle;
    }

    private static Bundle n7(String str) throws RemoteException {
        String strValueOf = String.valueOf(str);
        zzbad.i(strValueOf.length() != 0 ? "Server parameters: ".concat(strValueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void K4(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaoj zzaojVar, zzamv zzamvVar, zzyd zzydVar) throws RemoteException {
        try {
            this.f14028f.loadBannerAd(new MediationBannerAdConfiguration((Context) ObjectWrapper.k0(iObjectWrapper), str, n7(str2), m7(zzxzVar), l7(zzxzVar), zzxzVar.p, zzxzVar.l, zzxzVar.y, k7(str2, zzxzVar), com.google.android.gms.ads.zzb.zza(zzydVar.f16991j, zzydVar.f16988g, zzydVar.f16987f)), new z2(this, zzaojVar, zzamvVar));
        } catch (Throwable th) {
            zzbad.c("Adapter failed to render banner ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final boolean L2(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationRewardedAd mediationRewardedAd = this.f14030h;
        if (mediationRewardedAd == null) {
            return false;
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.k0(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final zzapj a6() throws RemoteException {
        return zzapj.y(this.f14028f.getVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void g4(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaop zzaopVar, zzamv zzamvVar) throws RemoteException {
        try {
            this.f14028f.loadNativeAd(new MediationNativeAdConfiguration((Context) ObjectWrapper.k0(iObjectWrapper), str, n7(str2), m7(zzxzVar), l7(zzxzVar), zzxzVar.p, zzxzVar.l, zzxzVar.y, k7(str2, zzxzVar)), new c3(this, zzaopVar, zzamvVar));
        } catch (Throwable th) {
            zzbad.c("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final zzaar getVideoController() {
        MediationExtrasReceiver mediationExtrasReceiver = this.f14028f;
        if (!(mediationExtrasReceiver instanceof com.google.android.gms.ads.mediation.zza)) {
            return null;
        }
        try {
            return ((com.google.android.gms.ads.mediation.zza) mediationExtrasReceiver).getVideoController();
        } catch (Throwable th) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void h5(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaos zzaosVar, zzamv zzamvVar) throws RemoteException {
        try {
            this.f14028f.loadRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.k0(iObjectWrapper), str, n7(str2), m7(zzxzVar), l7(zzxzVar), zzxzVar.p, zzxzVar.l, zzxzVar.y, k7(str2, zzxzVar)), new b3(this, zzaosVar, zzamvVar));
        } catch (Throwable th) {
            zzbad.c("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final zzapj i5() throws RemoteException {
        return zzapj.y(this.f14028f.getSDKVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void j5(String[] strArr, Bundle[] bundleArr) {
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void o3(IObjectWrapper iObjectWrapper) {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.gms.internal.ads.zzaov
    public final void u3(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzyd zzydVar, zzaoy zzaoyVar) throws RemoteException {
        AdFormat adFormat;
        try {
            d3 d3Var = new d3(this, zzaoyVar);
            RtbAdapter rtbAdapter = this.f14028f;
            byte b2 = -1;
            switch (str.hashCode()) {
                case -1396342996:
                    if (str.equals("banner")) {
                        b2 = 0;
                    }
                    break;
                case -1052618729:
                    if (str.equals("native")) {
                        b2 = 3;
                    }
                    break;
                case -239580146:
                    if (str.equals("rewarded")) {
                        b2 = 2;
                    }
                    break;
                case 604727084:
                    if (str.equals("interstitial")) {
                        b2 = 1;
                    }
                    break;
            }
            if (b2 == 0) {
                adFormat = AdFormat.BANNER;
            } else if (b2 == 1) {
                adFormat = AdFormat.INTERSTITIAL;
            } else if (b2 == 2) {
                adFormat = AdFormat.REWARDED;
            } else {
                if (b2 != 3) {
                    throw new IllegalArgumentException("Internal Error");
                }
                adFormat = AdFormat.NATIVE;
            }
            rtbAdapter.collectSignals(new RtbSignalData((Context) ObjectWrapper.k0(iObjectWrapper), new MediationConfiguration(adFormat, bundle2), bundle, com.google.android.gms.ads.zzb.zza(zzydVar.f16991j, zzydVar.f16988g, zzydVar.f16987f)), d3Var);
        } catch (Throwable th) {
            zzbad.c("Error generating signals for RTB", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final boolean x2(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationInterstitialAd mediationInterstitialAd = this.f14029g;
        if (mediationInterstitialAd == null) {
            return false;
        }
        try {
            mediationInterstitialAd.showAd((Context) ObjectWrapper.k0(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void y6(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaom zzaomVar, zzamv zzamvVar) throws RemoteException {
        try {
            this.f14028f.loadInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.k0(iObjectWrapper), str, n7(str2), m7(zzxzVar), l7(zzxzVar), zzxzVar.p, zzxzVar.l, zzxzVar.y, k7(str2, zzxzVar)), new a3(this, zzaomVar, zzamvVar));
        } catch (Throwable th) {
            zzbad.c("Adapter failed to render interstitial ad.", th);
            throw new RemoteException();
        }
    }
}
