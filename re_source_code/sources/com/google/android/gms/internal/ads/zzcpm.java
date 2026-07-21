package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcpm extends zzzl {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f15502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzyz f15503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzcxv f15504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzbnf f15505i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ViewGroup f15506j;

    public zzcpm(Context context, zzyz zzyzVar, zzcxv zzcxvVar, zzbnf zzbnfVar) {
        this.f15502f = context;
        this.f15503g = zzyzVar;
        this.f15504h = zzcxvVar;
        this.f15505i = zzbnfVar;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.removeAllViews();
        frameLayout.addView(zzbnfVar.i(), zzk.zzli().t());
        frameLayout.setMinimumHeight(C5().f16989h);
        frameLayout.setMinimumWidth(C5().f16992k);
        this.f15506j = frameLayout;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final boolean B() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void C2(zzyd zzydVar) throws RemoteException {
        zzbnf zzbnfVar = this.f15505i;
        if (zzbnfVar != null) {
            zzbnfVar.h(this.f15506j, zzydVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void C3(zzaqt zzaqtVar, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzyd C5() {
        return zzcxy.a(this.f15502f, Collections.singletonList(this.f15505i.j()));
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void H6(zzado zzadoVar) throws RemoteException {
        zzbad.h("setOnCustomRenderedAdLoadedListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzzs I4() throws RemoteException {
        return this.f15504h.n;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final boolean J4(zzxz zzxzVar) throws RemoteException {
        zzbad.h("loadAd is not supported for a Publisher AdView returned from AdLoader.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void L0(zzyz zzyzVar) throws RemoteException {
        zzbad.h("setAdListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void P5(zzzs zzzsVar) throws RemoteException {
        zzbad.h("setAppEventListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final IObjectWrapper S0() throws RemoteException {
        return ObjectWrapper.E0(this.f15506j);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void U5(zzaqn zzaqnVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void W6(zzacd zzacdVar) throws RemoteException {
        zzbad.h("setVideoOptions is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void X5(zzaax zzaaxVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final String c0() throws RemoteException {
        return this.f15505i.f();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void destroy() throws RemoteException {
        Preconditions.f("destroy must be called on the main UI thread.");
        this.f15505i.a();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final String f6() throws RemoteException {
        return this.f15504h.f15752f;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final Bundle getAdMetadata() throws RemoteException {
        zzbad.h("getAdMetadata is not supported in Publisher AdView returned by AdLoader.");
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final String getMediationAdapterClassName() throws RemoteException {
        return this.f15505i.b();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzaar getVideoController() throws RemoteException {
        return this.f15505i.g();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void h0(zzatb zzatbVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void k4() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void m4(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final boolean p0() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void pause() throws RemoteException {
        Preconditions.f("destroy must be called on the main UI thread.");
        this.f15505i.d().f0(null);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void resume() throws RemoteException {
        Preconditions.f("destroy must be called on the main UI thread.");
        this.f15505i.d().g0(null);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void setImmersiveMode(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void setUserId(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void showInterstitial() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void t1(boolean z) throws RemoteException {
        zzbad.h("setManualImpressionsEnabled is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void v4(zzzy zzzyVar) throws RemoteException {
        zzbad.h("setCorrelationIdProvider is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void w4(zzyw zzywVar) throws RemoteException {
        zzbad.h("setAdClickListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzyz x5() throws RemoteException {
        return this.f15503g;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void x6() throws RemoteException {
        this.f15505i.l();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void z0(zzzp zzzpVar) throws RemoteException {
        zzbad.h("setAdMetadataListener is not supported in Publisher AdView returned by AdLoader.");
    }
}
