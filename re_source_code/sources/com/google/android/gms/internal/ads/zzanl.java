package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzanl extends zzamt {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f14003f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzano f14004g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzatk f14005h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private IObjectWrapper f14006i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MediationRewardedAd f14007j;

    public zzanl(MediationAdapter mediationAdapter) {
        this.f14003f = mediationAdapter;
    }

    private final Bundle h7(String str, zzxz zzxzVar, String str2) throws RemoteException {
        String strValueOf = String.valueOf(str);
        zzbad.e(strValueOf.length() != 0 ? "Server parameters: ".concat(strValueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                bundle = bundle2;
            }
            if (this.f14003f instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzxzVar != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzxzVar.l);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
        } catch (Throwable th) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
            throw new RemoteException();
        }
    }

    private static String j7(String str, zzxz zzxzVar) {
        String str2 = zzxzVar.z;
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return str2;
        }
    }

    private static boolean k7(zzxz zzxzVar) {
        if (zzxzVar.f16973k) {
            return true;
        }
        zzyt.a();
        return zzazt.v();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzafe F2() {
        NativeCustomTemplateAd nativeCustomTemplateAdD = this.f14004g.d();
        if (nativeCustomTemplateAdD instanceof zzafh) {
            return ((zzafh) nativeCustomTemplateAdD).b();
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x0064  */
    /* JADX WARN: Code duplicated, block: B:30:0x0067  */
    /* JADX WARN: Code duplicated, block: B:31:0x006a  */
    /* JADX WARN: Code duplicated, block: B:32:0x006d  */
    /* JADX WARN: Code duplicated, block: B:40:0x005e A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzams
    public final void G4(IObjectWrapper iObjectWrapper, zzaiq zzaiqVar, List<zzaiw> list) throws RemoteException {
        AdFormat adFormat;
        if (!(this.f14003f instanceof Adapter)) {
            throw new RemoteException();
        }
        t2 t2Var = new t2(this, zzaiqVar);
        ArrayList arrayList = new ArrayList();
        Iterator<zzaiw> it = list.iterator();
        while (it.hasNext()) {
            String str = it.next().f13919f;
            str.hashCode();
            byte b2 = -1;
            switch (str) {
                case "banner":
                    b2 = 0;
                case "native":
                    b2 = 1;
                case "rewarded":
                    b2 = 2;
                case "interstitial":
                    b2 = 3;
                default:
                    switch (b2) {
                        case 0:
                            adFormat = AdFormat.BANNER;
                            break;
                        case 1:
                            adFormat = AdFormat.NATIVE;
                            break;
                        case 2:
                            adFormat = AdFormat.REWARDED;
                            break;
                        case 3:
                            adFormat = AdFormat.INTERSTITIAL;
                            break;
                        default:
                            throw new RemoteException();
                    }
            }
        }
        ((Adapter) this.f14003f).initialize((Context) ObjectWrapper.k0(iObjectWrapper), t2Var, arrayList);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void H4(IObjectWrapper iObjectWrapper, zzatk zzatkVar, List<String> list) throws RemoteException {
        if (!(this.f14003f instanceof InitializableMediationRewardedVideoAdAdapter)) {
            String canonicalName = InitializableMediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = this.f14003f.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.i(sb.toString());
            throw new RemoteException();
        }
        zzbad.e("Initialize rewarded video adapter.");
        try {
            InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.f14003f;
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(h7(it.next(), null, null));
            }
            initializableMediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.k0(iObjectWrapper), new zzatn(zzatkVar), arrayList);
        } catch (Throwable th) {
            zzbad.d("Could not initialize rewarded video adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void M3(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, String str2, zzamv zzamvVar, zzady zzadyVar, List<String> list) throws RemoteException {
        Object obj = this.f14003f;
        if (!(obj instanceof MediationNativeAdapter)) {
            String canonicalName = MediationNativeAdapter.class.getCanonicalName();
            String canonicalName2 = this.f14003f.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.i(sb.toString());
            throw new RemoteException();
        }
        try {
            MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) obj;
            zzans zzansVar = new zzans(zzxzVar.f16969g == -1 ? null : new Date(zzxzVar.f16969g), zzxzVar.f16971i, zzxzVar.f16972j != null ? new HashSet(zzxzVar.f16972j) : null, zzxzVar.p, k7(zzxzVar), zzxzVar.l, zzadyVar, list, zzxzVar.w, zzxzVar.y, j7(str, zzxzVar));
            Bundle bundle = zzxzVar.r;
            Bundle bundle2 = bundle != null ? bundle.getBundle(mediationNativeAdapter.getClass().getName()) : null;
            this.f14004g = new zzano(zzamvVar);
            mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.k0(iObjectWrapper), this.f14004g, h7(str, zzxzVar, str2), zzansVar, bundle2);
        } catch (Throwable th) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzang P1() {
        UnifiedNativeAdMapper unifiedNativeAdMapperC = this.f14004g.c();
        if (unifiedNativeAdMapperC != null) {
            return new zzaoi(unifiedNativeAdMapperC);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void Q2(zzxz zzxzVar, String str, String str2) throws RemoteException {
        Object obj = this.f14003f;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbad.e("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.f14003f;
                zzank zzankVar = new zzank(zzxzVar.f16969g == -1 ? null : new Date(zzxzVar.f16969g), zzxzVar.f16971i, zzxzVar.f16972j != null ? new HashSet(zzxzVar.f16972j) : null, zzxzVar.p, k7(zzxzVar), zzxzVar.l, zzxzVar.w, zzxzVar.y, j7(str, zzxzVar));
                Bundle bundle = zzxzVar.r;
                mediationRewardedVideoAdAdapter.loadAd(zzankVar, h7(str, zzxzVar, str2), bundle != null ? bundle.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
                return;
            } catch (Throwable th) {
                zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
                throw new RemoteException();
            }
        }
        if (obj instanceof Adapter) {
            f2(this.f14006i, zzxzVar, str, new zzanp((Adapter) obj, this.f14005h));
            return;
        }
        String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
        String canonicalName2 = Adapter.class.getCanonicalName();
        String canonicalName3 = this.f14003f.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
        sb.append(canonicalName);
        sb.append(" or ");
        sb.append(canonicalName2);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName3);
        zzbad.i(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void Y2(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException {
        c6(iObjectWrapper, zzxzVar, str, null, zzamvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void a4(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.f14003f instanceof Adapter) {
            zzbad.e("Show rewarded ad from adapter.");
            MediationRewardedAd mediationRewardedAd = this.f14007j;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.k0(iObjectWrapper));
                return;
            } else {
                zzbad.g("Can not show null mediation rewarded ad.");
                throw new RemoteException();
            }
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = this.f14003f.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbad.i(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzana b7() {
        NativeAdMapper nativeAdMapperB = this.f14004g.b();
        if (nativeAdMapperB instanceof NativeAppInstallAdMapper) {
            return new zzanq((NativeAppInstallAdMapper) nativeAdMapperB);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void c6(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, String str2, zzamv zzamvVar) throws RemoteException {
        if (!(this.f14003f instanceof MediationInterstitialAdapter)) {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.f14003f.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.i(sb.toString());
            throw new RemoteException();
        }
        zzbad.e("Requesting interstitial ad from adapter.");
        try {
            MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.f14003f;
            zzank zzankVar = new zzank(zzxzVar.f16969g == -1 ? null : new Date(zzxzVar.f16969g), zzxzVar.f16971i, zzxzVar.f16972j != null ? new HashSet(zzxzVar.f16972j) : null, zzxzVar.p, k7(zzxzVar), zzxzVar.l, zzxzVar.w, zzxzVar.y, j7(str, zzxzVar));
            Bundle bundle = zzxzVar.r;
            mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.k0(iObjectWrapper), new zzano(zzamvVar), h7(str, zzxzVar, str2), zzankVar, bundle != null ? bundle.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void destroy() throws RemoteException {
        Object obj = this.f14003f;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onDestroy();
            } catch (Throwable th) {
                zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzand e6() {
        NativeAdMapper nativeAdMapperB = this.f14004g.b();
        if (nativeAdMapperB instanceof NativeContentAdMapper) {
            return new zzanr((NativeContentAdMapper) nativeAdMapperB);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void f2(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException {
        Bundle bundle;
        if (!(this.f14003f instanceof Adapter)) {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.f14003f.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.i(sb.toString());
            throw new RemoteException();
        }
        zzbad.e("Requesting rewarded ad from adapter.");
        try {
            Adapter adapter = (Adapter) this.f14003f;
            s2 s2Var = new s2(this, zzamvVar, adapter);
            Context context = (Context) ObjectWrapper.k0(iObjectWrapper);
            Bundle bundleH7 = h7(str, zzxzVar, null);
            Bundle bundle2 = zzxzVar.r;
            if (bundle2 == null || (bundle = bundle2.getBundle(this.f14003f.getClass().getName())) == null) {
                bundle = new Bundle();
            }
            adapter.loadRewardedAd(new MediationRewardedAdConfiguration(context, HttpUrl.FRAGMENT_ENCODE_SET, bundleH7, bundle, k7(zzxzVar), zzxzVar.p, zzxzVar.l, zzxzVar.y, j7(str, zzxzVar)), s2Var);
        } catch (Exception e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final Bundle getInterstitialAdapterInfo() {
        Object obj = this.f14003f;
        if (obj instanceof zzbjl) {
            return ((zzbjl) obj).getInterstitialAdapterInfo();
        }
        String canonicalName = zzbjl.class.getCanonicalName();
        String canonicalName2 = this.f14003f.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbad.i(sb.toString());
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzaar getVideoController() {
        Object obj = this.f14003f;
        if (!(obj instanceof com.google.android.gms.ads.mediation.zza)) {
            return null;
        }
        try {
            return ((com.google.android.gms.ads.mediation.zza) obj).getVideoController();
        } catch (Throwable th) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void h4(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzatk zzatkVar, String str2) throws RemoteException {
        zzank zzankVar;
        Bundle bundle;
        Object obj = this.f14003f;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbad.e("Initialize rewarded video adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.f14003f;
                Bundle bundleH7 = h7(str2, zzxzVar, null);
                if (zzxzVar != null) {
                    zzank zzankVar2 = new zzank(zzxzVar.f16969g == -1 ? null : new Date(zzxzVar.f16969g), zzxzVar.f16971i, zzxzVar.f16972j != null ? new HashSet(zzxzVar.f16972j) : null, zzxzVar.p, k7(zzxzVar), zzxzVar.l, zzxzVar.w, zzxzVar.y, j7(str2, zzxzVar));
                    Bundle bundle2 = zzxzVar.r;
                    bundle = bundle2 != null ? bundle2.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null;
                    zzankVar = zzankVar2;
                } else {
                    zzankVar = null;
                    bundle = null;
                }
                mediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.k0(iObjectWrapper), zzankVar, str, new zzatn(zzatkVar), bundleH7, bundle);
                return;
            } catch (Throwable th) {
                zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
                throw new RemoteException();
            }
        }
        if (obj instanceof Adapter) {
            this.f14006i = iObjectWrapper;
            this.f14005h = zzatkVar;
            zzatkVar.c3(ObjectWrapper.E0(obj));
            return;
        }
        String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
        String canonicalName2 = Adapter.class.getCanonicalName();
        String canonicalName3 = this.f14003f.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
        sb.append(canonicalName);
        sb.append(" or ");
        sb.append(canonicalName2);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName3);
        zzbad.i(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final boolean isInitialized() throws RemoteException {
        Object obj = this.f14003f;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbad.e("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.f14003f).isInitialized();
            } catch (Throwable th) {
                zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
                throw new RemoteException();
            }
        }
        if (obj instanceof Adapter) {
            return this.f14005h != null;
        }
        String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
        String canonicalName2 = Adapter.class.getCanonicalName();
        String canonicalName3 = this.f14003f.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
        sb.append(canonicalName);
        sb.append(" or ");
        sb.append(canonicalName2);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName3);
        zzbad.i(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void o6(zzxz zzxzVar, String str) throws RemoteException {
        Q2(zzxzVar, str, null);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void pause() throws RemoteException {
        Object obj = this.f14003f;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onPause();
            } catch (Throwable th) {
                zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final Bundle r4() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void resume() throws RemoteException {
        Object obj = this.f14003f;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onResume();
            } catch (Throwable th) {
                zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void s4(IObjectWrapper iObjectWrapper, zzyd zzydVar, zzxz zzxzVar, String str, String str2, zzamv zzamvVar) throws RemoteException {
        if (!(this.f14003f instanceof MediationBannerAdapter)) {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = this.f14003f.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbad.i(sb.toString());
            throw new RemoteException();
        }
        zzbad.e("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.f14003f;
            zzank zzankVar = new zzank(zzxzVar.f16969g == -1 ? null : new Date(zzxzVar.f16969g), zzxzVar.f16971i, zzxzVar.f16972j != null ? new HashSet(zzxzVar.f16972j) : null, zzxzVar.p, k7(zzxzVar), zzxzVar.l, zzxzVar.w, zzxzVar.y, j7(str, zzxzVar));
            Bundle bundle = zzxzVar.r;
            mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.k0(iObjectWrapper), new zzano(zzamvVar), h7(str, zzxzVar, str2), com.google.android.gms.ads.zzb.zza(zzydVar.f16991j, zzydVar.f16988g, zzydVar.f16987f), zzankVar, bundle != null ? bundle.getBundle(mediationBannerAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Object obj = this.f14003f;
        if (obj instanceof OnImmersiveModeUpdatedListener) {
            try {
                ((OnImmersiveModeUpdatedListener) obj).onImmersiveModeUpdated(z);
                return;
            } catch (Throwable th) {
                zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
                return;
            }
        }
        String canonicalName = OnImmersiveModeUpdatedListener.class.getCanonicalName();
        String canonicalName2 = this.f14003f.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbad.i(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void showInterstitial() throws RemoteException {
        if (this.f14003f instanceof MediationInterstitialAdapter) {
            zzbad.e("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.f14003f).showInterstitial();
                return;
            } catch (Throwable th) {
                zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
                throw new RemoteException();
            }
        }
        String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
        String canonicalName2 = this.f14003f.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbad.i(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void showVideo() throws RemoteException {
        Object obj = this.f14003f;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbad.e("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.f14003f).showVideo();
                return;
            } catch (Throwable th) {
                zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
                throw new RemoteException();
            }
        }
        if (obj instanceof Adapter) {
            MediationRewardedAd mediationRewardedAd = this.f14007j;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.k0(this.f14006i));
                return;
            } else {
                zzbad.g("Can not show null mediated rewarded ad.");
                throw new RemoteException();
            }
        }
        String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
        String canonicalName2 = Adapter.class.getCanonicalName();
        String canonicalName3 = this.f14003f.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
        sb.append(canonicalName);
        sb.append(" or ");
        sb.append(canonicalName2);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName3);
        zzbad.i(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void w0(IObjectWrapper iObjectWrapper) throws RemoteException {
        Context context = (Context) ObjectWrapper.k0(iObjectWrapper);
        Object obj = this.f14003f;
        if (obj instanceof OnContextChangedListener) {
            ((OnContextChangedListener) obj).onContextChanged(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final IObjectWrapper x1() throws RemoteException {
        Object obj = this.f14003f;
        if (obj instanceof MediationBannerAdapter) {
            try {
                return ObjectWrapper.E0(((MediationBannerAdapter) obj).getBannerView());
            } catch (Throwable th) {
                zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
                throw new RemoteException();
            }
        }
        String canonicalName = MediationBannerAdapter.class.getCanonicalName();
        String canonicalName2 = this.f14003f.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbad.i(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final boolean x3() {
        return this.f14003f instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void y2(IObjectWrapper iObjectWrapper, zzyd zzydVar, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException {
        s4(iObjectWrapper, zzydVar, zzxzVar, str, null, zzamvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final Bundle zzsh() {
        Object obj = this.f14003f;
        if (obj instanceof zzbjk) {
            return ((zzbjk) obj).zzsh();
        }
        String canonicalName = zzbjk.class.getCanonicalName();
        String canonicalName2 = this.f14003f.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbad.i(sb.toString());
        return new Bundle();
    }

    public zzanl(Adapter adapter) {
        this.f14003f = adapter;
    }
}
