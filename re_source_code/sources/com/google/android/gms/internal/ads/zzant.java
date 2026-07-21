package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.e;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzant<NETWORK_EXTRAS extends com.google.ads.mediation.e, SERVER_PARAMETERS extends MediationServerParameters> extends zzamt {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.ads.mediation.b<NETWORK_EXTRAS, SERVER_PARAMETERS> f14025f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final NETWORK_EXTRAS f14026g;

    public zzant(com.google.ads.mediation.b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar, NETWORK_EXTRAS network_extras) {
        this.f14025f = bVar;
        this.f14026g = network_extras;
    }

    private static boolean h7(zzxz zzxzVar) {
        if (zzxzVar.f16973k) {
            return true;
        }
        zzyt.a();
        return zzazt.v();
    }

    private final SERVER_PARAMETERS i7(String str) throws RemoteException {
        HashMap map;
        try {
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                map = new HashMap(jSONObject.length());
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.getString(next));
                }
            } else {
                map = new HashMap(0);
            }
            Class<SERVER_PARAMETERS> serverParametersType = this.f14025f.getServerParametersType();
            if (serverParametersType == null) {
                return null;
            }
            SERVER_PARAMETERS server_parametersNewInstance = serverParametersType.newInstance();
            server_parametersNewInstance.a(map);
            return server_parametersNewInstance;
        } catch (Throwable th) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzafe F2() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void G4(IObjectWrapper iObjectWrapper, zzaiq zzaiqVar, List<zzaiw> list) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void H4(IObjectWrapper iObjectWrapper, zzatk zzatkVar, List<String> list) {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void M3(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, String str2, zzamv zzamvVar, zzady zzadyVar, List<String> list) {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzang P1() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void Q2(zzxz zzxzVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void Y2(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException {
        c6(iObjectWrapper, zzxzVar, str, null, zzamvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void a4(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzana b7() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzams
    public final void c6(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, String str2, zzamv zzamvVar) throws RemoteException {
        com.google.ads.mediation.b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar = this.f14025f;
        if (!(bVar instanceof MediationInterstitialAdapter)) {
            String strValueOf = String.valueOf(bVar.getClass().getCanonicalName());
            zzbad.i(strValueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(strValueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzbad.e("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.f14025f).requestInterstitialAd(new zzanu(zzamvVar), (Activity) ObjectWrapper.k0(iObjectWrapper), i7(str), zzaog.b(zzxzVar, h7(zzxzVar)), this.f14026g);
        } catch (Throwable th) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void destroy() throws RemoteException {
        try {
            this.f14025f.destroy();
        } catch (Throwable th) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzand e6() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void f2(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzaar getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void h4(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzatk zzatkVar, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void o6(zzxz zzxzVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final Bundle r4() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void resume() throws RemoteException {
        throw new RemoteException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzams
    public final void s4(IObjectWrapper iObjectWrapper, zzyd zzydVar, zzxz zzxzVar, String str, String str2, zzamv zzamvVar) throws RemoteException {
        e.e.a.c cVar;
        com.google.ads.mediation.b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar = this.f14025f;
        if (!(bVar instanceof MediationBannerAdapter)) {
            String strValueOf = String.valueOf(bVar.getClass().getCanonicalName());
            zzbad.i(strValueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(strValueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzbad.e("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.f14025f;
            zzanu zzanuVar = new zzanu(zzamvVar);
            Activity activity = (Activity) ObjectWrapper.k0(iObjectWrapper);
            MediationServerParameters mediationServerParametersI7 = i7(str);
            e.e.a.c[] cVarArr = {e.e.a.c.a, e.e.a.c.f20718b, e.e.a.c.f20719c, e.e.a.c.f20720d, e.e.a.c.f20721e, e.e.a.c.f20722f};
            for (int i2 = 0; i2 < 6; i2++) {
                if (cVarArr[i2].b() == zzydVar.f16991j && cVarArr[i2].a() == zzydVar.f16988g) {
                    cVar = cVarArr[i2];
                    mediationBannerAdapter.requestBannerAd(zzanuVar, activity, mediationServerParametersI7, cVar, zzaog.b(zzxzVar, h7(zzxzVar)), this.f14026g);
                }
            }
            cVar = new e.e.a.c(com.google.android.gms.ads.zzb.zza(zzydVar.f16991j, zzydVar.f16988g, zzydVar.f16987f));
            mediationBannerAdapter.requestBannerAd(zzanuVar, activity, mediationServerParametersI7, cVar, zzaog.b(zzxzVar, h7(zzxzVar)), this.f14026g);
        } catch (Throwable th) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void showInterstitial() throws RemoteException {
        com.google.ads.mediation.b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar = this.f14025f;
        if (!(bVar instanceof MediationInterstitialAdapter)) {
            String strValueOf = String.valueOf(bVar.getClass().getCanonicalName());
            zzbad.i(strValueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(strValueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzbad.e("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.f14025f).showInterstitial();
        } catch (Throwable th) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void showVideo() {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void w0(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final IObjectWrapper x1() throws RemoteException {
        com.google.ads.mediation.b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar = this.f14025f;
        if (!(bVar instanceof MediationBannerAdapter)) {
            String strValueOf = String.valueOf(bVar.getClass().getCanonicalName());
            zzbad.i(strValueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(strValueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return ObjectWrapper.E0(((MediationBannerAdapter) bVar).getBannerView());
        } catch (Throwable th) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final boolean x3() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void y2(IObjectWrapper iObjectWrapper, zzyd zzydVar, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException {
        s4(iObjectWrapper, zzydVar, zzxzVar, str, null, zzamvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final Bundle zzsh() {
        return new Bundle();
    }
}
