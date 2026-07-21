package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzabd {
    private final zzamo a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f13762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzyc f13763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AdListener f13764d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzxr f13765e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzzk f13766f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f13767g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AdMetadataListener f13768h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AppEventListener f13769i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private OnCustomRenderedAdLoadedListener f13770j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Correlator f13771k;
    private RewardedVideoAdListener l;
    private boolean m;
    private boolean n;

    public zzabd(Context context) {
        this(context, zzyc.a, null);
    }

    private final void u(String str) {
        if (this.f13766f != null) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63);
        sb.append("The ad unit ID must be set on InterstitialAd before ");
        sb.append(str);
        sb.append(" is called.");
        throw new IllegalStateException(sb.toString());
    }

    public final AdListener a() {
        return this.f13764d;
    }

    public final Bundle b() {
        try {
            zzzk zzzkVar = this.f13766f;
            if (zzzkVar != null) {
                return zzzkVar.getAdMetadata();
            }
        } catch (RemoteException e2) {
            zzbad.f("#008 Must be called on the main UI thread.", e2);
        }
        return new Bundle();
    }

    public final String c() {
        return this.f13767g;
    }

    public final AppEventListener d() {
        return this.f13769i;
    }

    public final String e() {
        try {
            zzzk zzzkVar = this.f13766f;
            if (zzzkVar != null) {
                return zzzkVar.c0();
            }
            return null;
        } catch (RemoteException e2) {
            zzbad.f("#008 Must be called on the main UI thread.", e2);
            return null;
        }
    }

    public final OnCustomRenderedAdLoadedListener f() {
        return this.f13770j;
    }

    public final boolean g() {
        try {
            zzzk zzzkVar = this.f13766f;
            if (zzzkVar == null) {
                return false;
            }
            return zzzkVar.B();
        } catch (RemoteException e2) {
            zzbad.f("#008 Must be called on the main UI thread.", e2);
            return false;
        }
    }

    public final boolean h() {
        try {
            zzzk zzzkVar = this.f13766f;
            if (zzzkVar == null) {
                return false;
            }
            return zzzkVar.p0();
        } catch (RemoteException e2) {
            zzbad.f("#008 Must be called on the main UI thread.", e2);
            return false;
        }
    }

    public final void i(AdListener adListener) {
        try {
            this.f13764d = adListener;
            zzzk zzzkVar = this.f13766f;
            if (zzzkVar != null) {
                zzzkVar.L0(adListener != null ? new zzxv(adListener) : null);
            }
        } catch (RemoteException e2) {
            zzbad.f("#008 Must be called on the main UI thread.", e2);
        }
    }

    public final void j(AdMetadataListener adMetadataListener) {
        try {
            this.f13768h = adMetadataListener;
            zzzk zzzkVar = this.f13766f;
            if (zzzkVar != null) {
                zzzkVar.z0(adMetadataListener != null ? new zzxy(adMetadataListener) : null);
            }
        } catch (RemoteException e2) {
            zzbad.f("#008 Must be called on the main UI thread.", e2);
        }
    }

    public final void k(String str) {
        if (this.f13767g != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.f13767g = str;
    }

    public final void l(AppEventListener appEventListener) {
        try {
            this.f13769i = appEventListener;
            zzzk zzzkVar = this.f13766f;
            if (zzzkVar != null) {
                zzzkVar.P5(appEventListener != null ? new zzyf(appEventListener) : null);
            }
        } catch (RemoteException e2) {
            zzbad.f("#008 Must be called on the main UI thread.", e2);
        }
    }

    public final void m(Correlator correlator) {
        this.f13771k = correlator;
        try {
            zzzk zzzkVar = this.f13766f;
            if (zzzkVar != null) {
                zzzkVar.v4(correlator == null ? null : correlator.zzdf());
            }
        } catch (RemoteException e2) {
            zzbad.f("#008 Must be called on the main UI thread.", e2);
        }
    }

    public final void n(boolean z) {
        try {
            this.n = z;
            zzzk zzzkVar = this.f13766f;
            if (zzzkVar != null) {
                zzzkVar.setImmersiveMode(z);
            }
        } catch (RemoteException e2) {
            zzbad.f("#008 Must be called on the main UI thread.", e2);
        }
    }

    public final void o(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.f13770j = onCustomRenderedAdLoadedListener;
            zzzk zzzkVar = this.f13766f;
            if (zzzkVar != null) {
                zzzkVar.H6(onCustomRenderedAdLoadedListener != null ? new zzadr(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e2) {
            zzbad.f("#008 Must be called on the main UI thread.", e2);
        }
    }

    public final void p(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.l = rewardedVideoAdListener;
            zzzk zzzkVar = this.f13766f;
            if (zzzkVar != null) {
                zzzkVar.h0(rewardedVideoAdListener != null ? new zzatg(rewardedVideoAdListener) : null);
            }
        } catch (RemoteException e2) {
            zzbad.f("#008 Must be called on the main UI thread.", e2);
        }
    }

    public final void q() {
        try {
            u("show");
            this.f13766f.showInterstitial();
        } catch (RemoteException e2) {
            zzbad.f("#008 Must be called on the main UI thread.", e2);
        }
    }

    public final void r(zzaaz zzaazVar) {
        try {
            if (this.f13766f == null) {
                if (this.f13767g == null) {
                    u("loadAd");
                }
                zzyd zzydVarE0 = this.m ? zzyd.e0() : new zzyd();
                zzyh zzyhVarB = zzyt.b();
                Context context = this.f13762b;
                zzzk zzzkVarB = new a60(zzyhVarB, context, zzydVarE0, this.f13767g, this.a).b(context, false);
                this.f13766f = zzzkVarB;
                if (this.f13764d != null) {
                    zzzkVarB.L0(new zzxv(this.f13764d));
                }
                if (this.f13765e != null) {
                    this.f13766f.w4(new zzxs(this.f13765e));
                }
                if (this.f13768h != null) {
                    this.f13766f.z0(new zzxy(this.f13768h));
                }
                if (this.f13769i != null) {
                    this.f13766f.P5(new zzyf(this.f13769i));
                }
                if (this.f13770j != null) {
                    this.f13766f.H6(new zzadr(this.f13770j));
                }
                Correlator correlator = this.f13771k;
                if (correlator != null) {
                    this.f13766f.v4(correlator.zzdf());
                }
                if (this.l != null) {
                    this.f13766f.h0(new zzatg(this.l));
                }
                this.f13766f.setImmersiveMode(this.n);
            }
            if (this.f13766f.J4(zzyc.a(this.f13762b, zzaazVar))) {
                this.a.k7(zzaazVar.q());
            }
        } catch (RemoteException e2) {
            zzbad.f("#008 Must be called on the main UI thread.", e2);
        }
    }

    public final void s(zzxr zzxrVar) {
        try {
            this.f13765e = zzxrVar;
            zzzk zzzkVar = this.f13766f;
            if (zzzkVar != null) {
                zzzkVar.w4(zzxrVar != null ? new zzxs(zzxrVar) : null);
            }
        } catch (RemoteException e2) {
            zzbad.f("#008 Must be called on the main UI thread.", e2);
        }
    }

    public final void t(boolean z) {
        this.m = true;
    }

    public zzabd(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzyc.a, publisherInterstitialAd);
    }

    @VisibleForTesting
    private zzabd(Context context, zzyc zzycVar, PublisherInterstitialAd publisherInterstitialAd) {
        this.a = new zzamo();
        this.f13762b = context;
        this.f13763c = zzycVar;
    }
}
