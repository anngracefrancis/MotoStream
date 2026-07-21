package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzabb {
    private final zzamo a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzyc f13752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f13753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final VideoController f13754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    private final zzyv f13755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzxr f13756f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AdListener f13757g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AdSize[] f13758h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AppEventListener f13759i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Correlator f13760j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private zzzk f13761k;
    private OnCustomRenderedAdLoadedListener l;
    private VideoOptions m;
    private String n;
    private ViewGroup o;
    private int p;
    private boolean q;

    public zzabb(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzyc.a, 0);
    }

    private static boolean C(int i2) {
        return i2 == 1;
    }

    private static zzyd x(Context context, AdSize[] adSizeArr, int i2) {
        zzyd zzydVar = new zzyd(context, adSizeArr);
        zzydVar.o = C(i2);
        return zzydVar;
    }

    public final void A(AdSize... adSizeArr) {
        this.f13758h = adSizeArr;
        try {
            zzzk zzzkVar = this.f13761k;
            if (zzzkVar != null) {
                zzzkVar.C2(x(this.o.getContext(), this.f13758h, this.p));
            }
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
        this.o.requestLayout();
    }

    public final boolean B(zzzk zzzkVar) {
        if (zzzkVar == null) {
            return false;
        }
        try {
            IObjectWrapper iObjectWrapperS0 = zzzkVar.S0();
            if (iObjectWrapperS0 == null || ((View) ObjectWrapper.k0(iObjectWrapperS0)).getParent() != null) {
                return false;
            }
            this.o.addView((View) ObjectWrapper.k0(iObjectWrapperS0));
            this.f13761k = zzzkVar;
            return true;
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
            return false;
        }
    }

    public final zzaar D() {
        zzzk zzzkVar = this.f13761k;
        if (zzzkVar == null) {
            return null;
        }
        try {
            return zzzkVar.getVideoController();
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
            return null;
        }
    }

    public final void a() {
        try {
            zzzk zzzkVar = this.f13761k;
            if (zzzkVar != null) {
                zzzkVar.destroy();
            }
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    public final AdListener b() {
        return this.f13757g;
    }

    public final AdSize c() {
        zzyd zzydVarC5;
        try {
            zzzk zzzkVar = this.f13761k;
            if (zzzkVar != null && (zzydVarC5 = zzzkVar.C5()) != null) {
                return com.google.android.gms.ads.zzb.zza(zzydVarC5.f16991j, zzydVarC5.f16988g, zzydVarC5.f16987f);
            }
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
        AdSize[] adSizeArr = this.f13758h;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public final AdSize[] d() {
        return this.f13758h;
    }

    public final String e() {
        zzzk zzzkVar;
        if (this.n == null && (zzzkVar = this.f13761k) != null) {
            try {
                this.n = zzzkVar.f6();
            } catch (RemoteException e2) {
                zzbad.f("#007 Could not call remote method.", e2);
            }
        }
        return this.n;
    }

    public final AppEventListener f() {
        return this.f13759i;
    }

    public final String g() {
        try {
            zzzk zzzkVar = this.f13761k;
            if (zzzkVar != null) {
                return zzzkVar.c0();
            }
            return null;
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
            return null;
        }
    }

    public final OnCustomRenderedAdLoadedListener h() {
        return this.l;
    }

    public final VideoController i() {
        return this.f13754d;
    }

    public final VideoOptions j() {
        return this.m;
    }

    public final boolean k() {
        try {
            zzzk zzzkVar = this.f13761k;
            if (zzzkVar != null) {
                return zzzkVar.p0();
            }
            return false;
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
            return false;
        }
    }

    public final void l() {
        try {
            zzzk zzzkVar = this.f13761k;
            if (zzzkVar != null) {
                zzzkVar.pause();
            }
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    public final void m() {
        if (this.f13753c.getAndSet(true)) {
            return;
        }
        try {
            zzzk zzzkVar = this.f13761k;
            if (zzzkVar != null) {
                zzzkVar.x6();
            }
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    public final void n() {
        try {
            zzzk zzzkVar = this.f13761k;
            if (zzzkVar != null) {
                zzzkVar.resume();
            }
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    public final void o(AdListener adListener) {
        this.f13757g = adListener;
        this.f13755e.a(adListener);
    }

    public final void p(AdSize... adSizeArr) {
        if (this.f13758h != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        A(adSizeArr);
    }

    public final void q(String str) {
        if (this.n != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.n = str;
    }

    public final void r(AppEventListener appEventListener) {
        try {
            this.f13759i = appEventListener;
            zzzk zzzkVar = this.f13761k;
            if (zzzkVar != null) {
                zzzkVar.P5(appEventListener != null ? new zzyf(appEventListener) : null);
            }
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    public final void s(Correlator correlator) {
        this.f13760j = correlator;
        try {
            zzzk zzzkVar = this.f13761k;
            if (zzzkVar != null) {
                zzzkVar.v4(correlator == null ? null : correlator.zzdf());
            }
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    public final void t(boolean z) {
        this.q = z;
        try {
            zzzk zzzkVar = this.f13761k;
            if (zzzkVar != null) {
                zzzkVar.t1(z);
            }
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    public final void u(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.l = onCustomRenderedAdLoadedListener;
        try {
            zzzk zzzkVar = this.f13761k;
            if (zzzkVar != null) {
                zzzkVar.H6(onCustomRenderedAdLoadedListener != null ? new zzadr(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    public final void v(VideoOptions videoOptions) {
        this.m = videoOptions;
        try {
            zzzk zzzkVar = this.f13761k;
            if (zzzkVar != null) {
                zzzkVar.W6(videoOptions == null ? null : new zzacd(videoOptions));
            }
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    public final void y(zzaaz zzaazVar) {
        try {
            zzzk zzzkVar = this.f13761k;
            if (zzzkVar == null) {
                if ((this.f13758h == null || this.n == null) && zzzkVar == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.o.getContext();
                zzyd zzydVarX = x(context, this.f13758h, this.p);
                zzzk zzzkVarB = "search_v2".equals(zzydVarX.f16987f) ? new z50(zzyt.b(), context, zzydVarX, this.n).b(context, false) : new x50(zzyt.b(), context, zzydVarX, this.n, this.a).b(context, false);
                this.f13761k = zzzkVarB;
                zzzkVarB.L0(new zzxv(this.f13755e));
                if (this.f13756f != null) {
                    this.f13761k.w4(new zzxs(this.f13756f));
                }
                if (this.f13759i != null) {
                    this.f13761k.P5(new zzyf(this.f13759i));
                }
                if (this.l != null) {
                    this.f13761k.H6(new zzadr(this.l));
                }
                Correlator correlator = this.f13760j;
                if (correlator != null) {
                    this.f13761k.v4(correlator.zzdf());
                }
                if (this.m != null) {
                    this.f13761k.W6(new zzacd(this.m));
                }
                this.f13761k.t1(this.q);
                try {
                    IObjectWrapper iObjectWrapperS0 = this.f13761k.S0();
                    if (iObjectWrapperS0 != null) {
                        this.o.addView((View) ObjectWrapper.k0(iObjectWrapperS0));
                    }
                } catch (RemoteException e2) {
                    zzbad.f("#007 Could not call remote method.", e2);
                }
            }
            if (this.f13761k.J4(zzyc.a(this.o.getContext(), zzaazVar))) {
                this.a.k7(zzaazVar.q());
            }
        } catch (RemoteException e3) {
            zzbad.f("#007 Could not call remote method.", e3);
        }
    }

    public final void z(zzxr zzxrVar) {
        try {
            this.f13756f = zzxrVar;
            zzzk zzzkVar = this.f13761k;
            if (zzzkVar != null) {
                zzzkVar.w4(zzxrVar != null ? new zzxs(zzxrVar) : null);
            }
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    public zzabb(ViewGroup viewGroup, int i2) {
        this(viewGroup, null, false, zzyc.a, i2);
    }

    public zzabb(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzyc.a, 0);
    }

    public zzabb(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i2) {
        this(viewGroup, attributeSet, false, zzyc.a, i2);
    }

    @VisibleForTesting
    private zzabb(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzyc zzycVar, zzzk zzzkVar, int i2) {
        this.a = new zzamo();
        this.f13754d = new VideoController();
        this.f13755e = new a(this);
        this.o = viewGroup;
        this.f13752b = zzycVar;
        this.f13761k = null;
        this.f13753c = new AtomicBoolean(false);
        this.p = i2;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzyg zzygVar = new zzyg(context, attributeSet);
                this.f13758h = zzygVar.c(z);
                this.n = zzygVar.a();
                if (viewGroup.isInEditMode()) {
                    zzazt zzaztVarA = zzyt.a();
                    AdSize adSize = this.f13758h[0];
                    int i3 = this.p;
                    zzyd zzydVar = new zzyd(context, adSize);
                    zzydVar.o = C(i3);
                    zzaztVarA.f(viewGroup, zzydVar, "Ads by Google");
                }
            } catch (IllegalArgumentException e2) {
                zzyt.a().h(viewGroup, new zzyd(context, AdSize.BANNER), e2.getMessage(), e2.getMessage());
            }
        }
    }

    @VisibleForTesting
    private zzabb(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzyc zzycVar, int i2) {
        this(viewGroup, attributeSet, z, zzycVar, null, i2);
    }
}
