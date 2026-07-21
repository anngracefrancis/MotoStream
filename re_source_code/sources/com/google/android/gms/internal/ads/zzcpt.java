package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzcpt extends zzzl implements zzbtf {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbjm f15521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f15522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ViewGroup f15523h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzcpw f15524i = new zzcpw();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzcpv f15525j = new zzcpv();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzcpy f15526k = new zzcpy();
    private final zzbtb l;
    private final zzcxx m;
    private zzado n;
    private zzbnf o;
    private zzbbh<zzbnf> p;

    public zzcpt(zzbjm zzbjmVar, Context context, zzyd zzydVar, String str) {
        zzcxx zzcxxVar = new zzcxx();
        this.m = zzcxxVar;
        this.f15523h = new FrameLayout(context);
        this.f15521f = zzbjmVar;
        this.f15522g = context;
        zzcxxVar.n(zzydVar).t(str);
        zzbtb zzbtbVarG = zzbjmVar.g();
        this.l = zzbtbVarG;
        zzbtbVarG.V(this, zzbjmVar.e());
    }

    static /* synthetic */ zzbbh i7(zzcpt zzcptVar, zzbbh zzbbhVar) {
        zzcptVar.p = null;
        return null;
    }

    private final synchronized zzboc m7(zzcxv zzcxvVar) {
        return this.f15521f.j().f(new zzbqy.zza().e(this.f15522g).b(zzcxvVar).c()).a(new zzbtv.zza().h(this.f15524i, this.f15521f.e()).h(this.f15525j, this.f15521f.e()).c(this.f15524i, this.f15521f.e()).g(this.f15524i, this.f15521f.e()).d(this.f15524i, this.f15521f.e()).a(this.f15526k, this.f15521f.e()).k()).e(new zzcow(this.n)).g(new zzbxk(zzbzc.a, null)).c(new zzbox(this.l)).d(new zzbnc(this.f15523h)).b();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final boolean B() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void C2(zzyd zzydVar) {
        Preconditions.f("setAdSize must be called on the main UI thread.");
        this.m.n(zzydVar);
        zzbnf zzbnfVar = this.o;
        if (zzbnfVar != null) {
            zzbnfVar.h(this.f15523h, zzydVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void C3(zzaqt zzaqtVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized zzyd C5() {
        Preconditions.f("getAdSize must be called on the main UI thread.");
        zzbnf zzbnfVar = this.o;
        if (zzbnfVar != null) {
            return zzcxy.a(this.f15522g, Collections.singletonList(zzbnfVar.j()));
        }
        return this.m.G();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void H6(zzado zzadoVar) {
        Preconditions.f("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.n = zzadoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzzs I4() {
        return this.f15526k.a();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized boolean J4(zzxz zzxzVar) {
        Preconditions.f("loadAd must be called on the main UI thread.");
        if (this.p != null) {
            return false;
        }
        zzcya.b(this.f15522g, zzxzVar.f16973k);
        zzboc zzbocVarM7 = m7(this.m.w(zzxzVar).d());
        zzbbh<zzbnf> zzbbhVarD = zzbocVarM7.d();
        this.p = zzbbhVarD;
        zzbar.f(zzbbhVarD, new an(this, zzbocVarM7), this.f15521f.e());
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void L0(zzyz zzyzVar) {
        Preconditions.f("setAdListener must be called on the main UI thread.");
        this.f15524i.c(zzyzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void P() {
        boolean zQ;
        Object parent = this.f15523h.getParent();
        if (parent instanceof View) {
            View view = (View) parent;
            zQ = zzk.zzlg().q(view, view.getContext());
        } else {
            zQ = false;
        }
        if (zQ) {
            J4(this.m.b());
        } else {
            this.l.i0(60);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void P5(zzzs zzzsVar) {
        Preconditions.f("setAppEventListener must be called on the main UI thread.");
        this.f15526k.b(zzzsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final IObjectWrapper S0() {
        Preconditions.f("destroy must be called on the main UI thread.");
        return ObjectWrapper.E0(this.f15523h);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void U5(zzaqn zzaqnVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void W6(zzacd zzacdVar) {
        Preconditions.f("setVideoOptions must be called on the main UI thread.");
        this.m.k(zzacdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void X5(zzaax zzaaxVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized String c0() {
        zzbnf zzbnfVar = this.o;
        if (zzbnfVar == null) {
            return null;
        }
        return zzbnfVar.f();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void destroy() {
        Preconditions.f("destroy must be called on the main UI thread.");
        zzbnf zzbnfVar = this.o;
        if (zzbnfVar != null) {
            zzbnfVar.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized String f6() {
        return this.m.c();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final Bundle getAdMetadata() {
        Preconditions.f("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized String getMediationAdapterClassName() {
        zzbnf zzbnfVar = this.o;
        if (zzbnfVar == null) {
            return null;
        }
        return zzbnfVar.b();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized zzaar getVideoController() {
        Preconditions.f("getVideoController must be called from the main thread.");
        zzbnf zzbnfVar = this.o;
        if (zzbnfVar == null) {
            return null;
        }
        return zzbnfVar.g();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void h0(zzatb zzatbVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void k4() {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void m4(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized boolean p0() {
        zzbbh<zzbnf> zzbbhVar;
        zzbbhVar = this.p;
        return (zzbbhVar == null || zzbbhVar.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void pause() {
        Preconditions.f("pause must be called on the main UI thread.");
        zzbnf zzbnfVar = this.o;
        if (zzbnfVar != null) {
            zzbnfVar.d().f0(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void resume() {
        Preconditions.f("resume must be called on the main UI thread.");
        zzbnf zzbnfVar = this.o;
        if (zzbnfVar != null) {
            zzbnfVar.d().g0(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void setUserId(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void showInterstitial() {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void t1(boolean z) {
        Preconditions.f("setManualImpressionsEnabled must be called from the main thread.");
        this.m.j(z);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void v4(zzzy zzzyVar) {
        Preconditions.f("setCorrelationIdProvider must be called on the main UI thread");
        this.m.o(zzzyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void w4(zzyw zzywVar) {
        Preconditions.f("setAdListener must be called on the main UI thread.");
        this.f15525j.a(zzywVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzyz x5() {
        return this.f15524i.b();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void x6() {
        Preconditions.f("recordManualImpression must be called on the main UI thread.");
        zzbnf zzbnfVar = this.o;
        if (zzbnfVar != null) {
            zzbnfVar.l();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void z0(zzzp zzzpVar) {
        Preconditions.f("setAdMetadataListener must be called on the main UI thread.");
    }
}
