package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzabe {
    private static zzabe a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f13772b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzaab f13773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RewardedVideoAd f13774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zztw f13775e;

    private zzabe() {
    }

    public static zzabe j() {
        zzabe zzabeVar;
        synchronized (f13772b) {
            if (a == null) {
                a = new zzabe();
            }
            zzabeVar = a;
        }
        return zzabeVar;
    }

    public final RewardedVideoAd a(Context context) {
        synchronized (f13772b) {
            RewardedVideoAd rewardedVideoAd = this.f13774d;
            if (rewardedVideoAd != null) {
                return rewardedVideoAd;
            }
            zzatj zzatjVar = new zzatj(context, new f60(zzyt.b(), context, new zzamo()).b(context, false));
            this.f13774d = zzatjVar;
            return zzatjVar;
        }
    }

    public final String b() {
        Preconditions.o(this.f13773c != null, "MobileAds.initialize() must be called prior to getting version string.");
        try {
            return this.f13773c.H3();
        } catch (RemoteException e2) {
            zzbad.c("Unable to get version string.", e2);
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    public final void c(Context context, String str) {
        Preconditions.o(this.f13773c != null, "MobileAds.initialize() must be called prior to opening debug menu.");
        try {
            this.f13773c.t6(ObjectWrapper.E0(context), str);
        } catch (RemoteException e2) {
            zzbad.c("Unable to open debug menu.", e2);
        }
    }

    public final void d(Class<? extends RtbAdapter> cls) {
        try {
            this.f13773c.N2(cls.getCanonicalName());
        } catch (RemoteException e2) {
            zzbad.c("Unable to register RtbAdapter", e2);
        }
    }

    public final void e(boolean z) {
        Preconditions.o(this.f13773c != null, "MobileAds.initialize() must be called prior to setting app muted state.");
        try {
            this.f13773c.c2(z);
        } catch (RemoteException e2) {
            zzbad.c("Unable to set app mute state.", e2);
        }
    }

    public final void f(float f2) {
        Preconditions.b(0.0f <= f2 && f2 <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        Preconditions.o(this.f13773c != null, "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.f13773c.v5(f2);
        } catch (RemoteException e2) {
            zzbad.c("Unable to set app volume.", e2);
        }
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [com.google.android.gms.internal.ads.c, com.google.android.gms.internal.ads.zztw] */
    public final void g(final Context context, String str, zzabi zzabiVar, zztx zztxVar) {
        synchronized (f13772b) {
            if (this.f13773c != null) {
                return;
            }
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null.");
            }
            try {
                zzami.h7(context, str);
                boolean z = false;
                zzaab zzaabVarB = new c60(zzyt.b(), context).b(context, false);
                this.f13773c = zzaabVarB;
                zzaabVarB.O0(new zzamo());
                this.f13773c.a();
                this.f13773c.B2(str, ObjectWrapper.E0(new Runnable(this, context) { // from class: com.google.android.gms.internal.ads.b

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    private final zzabe f12280f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    private final Context f12281g;

                    {
                        this.f12280f = this;
                        this.f12281g = context;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f12280f.a(this.f12281g);
                    }
                }));
                zzacu.a(context);
                if (!((Boolean) zzyt.e().c(zzacu.d4)).booleanValue()) {
                    if (((Boolean) zzyt.e().c(zzacu.j4)).booleanValue()) {
                        z = true;
                    }
                }
                if (!z) {
                    zzbad.g("Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.");
                    this.f13775e = new Object(this) { // from class: com.google.android.gms.internal.ads.c
                        private final zzabe a;

                        {
                            this.a = this;
                        }
                    };
                }
            } catch (RemoteException e2) {
                zzbad.d("MobileAdsSettingManager initialization failed", e2);
            }
        }
    }

    public final float h() {
        zzaab zzaabVar = this.f13773c;
        if (zzaabVar == null) {
            return 1.0f;
        }
        try {
            return zzaabVar.C4();
        } catch (RemoteException e2) {
            zzbad.c("Unable to get app volume.", e2);
            return 1.0f;
        }
    }

    public final boolean i() {
        zzaab zzaabVar = this.f13773c;
        if (zzaabVar == null) {
            return false;
        }
        try {
            return zzaabVar.J3();
        } catch (RemoteException e2) {
            zzbad.c("Unable to get app mute state.", e2);
            return false;
        }
    }
}
