package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzatj implements RewardedVideoAd {
    private final zzasw a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f14152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f14153c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzatg f14154d = new zzatg(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f14155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14156f;

    public zzatj(Context context, zzasw zzaswVar) {
        this.a = zzaswVar == null ? new zzabx() : zzaswVar;
        this.f14152b = context.getApplicationContext();
    }

    private final void a(String str, zzaaz zzaazVar) {
        synchronized (this.f14153c) {
            zzasw zzaswVar = this.a;
            if (zzaswVar == null) {
                return;
            }
            try {
                zzaswVar.i4(new zzath(zzyc.a(this.f14152b, zzaazVar), str));
            } catch (RemoteException e2) {
                zzbad.f("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void destroy() {
        destroy(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final Bundle getAdMetadata() {
        synchronized (this.f14153c) {
            zzasw zzaswVar = this.a;
            if (zzaswVar != null) {
                try {
                    return zzaswVar.getAdMetadata();
                } catch (RemoteException e2) {
                    zzbad.f("#007 Could not call remote method.", e2);
                }
            }
            return new Bundle();
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getCustomData() {
        String str;
        synchronized (this.f14153c) {
            str = this.f14156f;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getMediationAdapterClassName() {
        try {
            zzasw zzaswVar = this.a;
            if (zzaswVar != null) {
                return zzaswVar.getMediationAdapterClassName();
            }
            return null;
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListenerI7;
        synchronized (this.f14153c) {
            rewardedVideoAdListenerI7 = this.f14154d.i7();
        }
        return rewardedVideoAdListenerI7;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getUserId() {
        String str;
        synchronized (this.f14153c) {
            str = this.f14155e;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final boolean isLoaded() {
        synchronized (this.f14153c) {
            zzasw zzaswVar = this.a;
            if (zzaswVar == null) {
                return false;
            }
            try {
                return zzaswVar.isLoaded();
            } catch (RemoteException e2) {
                zzbad.f("#007 Could not call remote method.", e2);
                return false;
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void loadAd(String str, AdRequest adRequest) {
        a(str, adRequest.zzde());
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void pause() {
        pause(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void resume() {
        resume(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        synchronized (this.f14153c) {
            zzasw zzaswVar = this.a;
            if (zzaswVar != null) {
                try {
                    zzaswVar.z0(new zzxy(adMetadataListener));
                } catch (RemoteException e2) {
                    zzbad.f("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setCustomData(String str) {
        synchronized (this.f14153c) {
            zzasw zzaswVar = this.a;
            if (zzaswVar != null) {
                try {
                    zzaswVar.setCustomData(str);
                    this.f14156f = str;
                } catch (RemoteException e2) {
                    zzbad.f("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setImmersiveMode(boolean z) {
        synchronized (this.f14153c) {
            zzasw zzaswVar = this.a;
            if (zzaswVar != null) {
                try {
                    zzaswVar.setImmersiveMode(z);
                } catch (RemoteException e2) {
                    zzbad.f("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.f14153c) {
            this.f14154d.j7(rewardedVideoAdListener);
            zzasw zzaswVar = this.a;
            if (zzaswVar != null) {
                try {
                    zzaswVar.h0(this.f14154d);
                } catch (RemoteException e2) {
                    zzbad.f("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setUserId(String str) {
        synchronized (this.f14153c) {
            this.f14155e = str;
            zzasw zzaswVar = this.a;
            if (zzaswVar != null) {
                try {
                    zzaswVar.setUserId(str);
                } catch (RemoteException e2) {
                    zzbad.f("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void show() {
        synchronized (this.f14153c) {
            zzasw zzaswVar = this.a;
            if (zzaswVar == null) {
                return;
            }
            try {
                zzaswVar.show();
            } catch (RemoteException e2) {
                zzbad.f("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void destroy(Context context) {
        synchronized (this.f14153c) {
            this.f14154d.j7(null);
            zzasw zzaswVar = this.a;
            if (zzaswVar == null) {
                return;
            }
            try {
                zzaswVar.d2(ObjectWrapper.E0(context));
            } catch (RemoteException e2) {
                zzbad.f("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void loadAd(String str, PublisherAdRequest publisherAdRequest) {
        a(str, publisherAdRequest.zzde());
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void pause(Context context) {
        synchronized (this.f14153c) {
            zzasw zzaswVar = this.a;
            if (zzaswVar == null) {
                return;
            }
            try {
                zzaswVar.M6(ObjectWrapper.E0(context));
            } catch (RemoteException e2) {
                zzbad.f("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void resume(Context context) {
        synchronized (this.f14153c) {
            zzasw zzaswVar = this.a;
            if (zzaswVar == null) {
                return;
            }
            try {
                zzaswVar.T5(ObjectWrapper.E0(context));
            } catch (RemoteException e2) {
                zzbad.f("#007 Could not call remote method.", e2);
            }
        }
    }
}
