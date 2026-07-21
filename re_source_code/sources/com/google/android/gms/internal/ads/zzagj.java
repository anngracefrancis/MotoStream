package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzagj extends UnifiedNativeAd {
    private final zzagg a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzael f13876c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final NativeAd.AdChoicesInfo f13878e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final UnifiedNativeAd.zza f13880g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<NativeAd.Image> f13875b = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final VideoController f13877d = new VideoController();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<MuteThisAdReason> f13879f = new ArrayList();

    public zzagj(zzagg zzaggVar) {
        zzael zzaelVar;
        zzaed zzaedVar;
        zzaei zzaekVar;
        IBinder iBinder;
        this.a = zzaggVar;
        zzaeh zzaehVar = null;
        try {
            List listK = zzaggVar.k();
            if (listK != null) {
                for (Object obj : listK) {
                    if (!(obj instanceof IBinder) || (iBinder = (IBinder) obj) == null) {
                        zzaekVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                        zzaekVar = iInterfaceQueryLocalInterface instanceof zzaei ? (zzaei) iInterfaceQueryLocalInterface : new zzaek(iBinder);
                    }
                    if (zzaekVar != null) {
                        this.f13875b.add(new zzael(zzaekVar));
                    }
                }
            }
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
        try {
            List listU4 = this.a.u4();
            if (listU4 != null) {
                for (Object obj2 : listU4) {
                    zzaak zzaakVarH7 = obj2 instanceof IBinder ? zzaal.h7((IBinder) obj2) : null;
                    if (zzaakVarH7 != null) {
                        this.f13879f.add(new zzaan(zzaakVarH7));
                    }
                }
            }
        } catch (RemoteException e3) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e3);
        }
        try {
            zzaei zzaeiVarN = this.a.n();
            zzaelVar = zzaeiVarN != null ? new zzael(zzaeiVarN) : null;
        } catch (RemoteException e4) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e4);
        }
        this.f13876c = zzaelVar;
        try {
            zzaedVar = this.a.f() != null ? new zzaed(this.a.f()) : null;
        } catch (RemoteException e5) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e5);
        }
        this.f13878e = zzaedVar;
        try {
            if (this.a.n2() != null) {
                zzaehVar = new zzaeh(this.a.n2());
            }
        } catch (RemoteException e6) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e6);
        }
        this.f13880g = zzaehVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final IObjectWrapper zzkq() {
        try {
            return this.a.r();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void cancelUnconfirmedClick() {
        try {
            this.a.W();
        } catch (RemoteException e2) {
            zzbad.c("Failed to cancelUnconfirmedClick", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void destroy() {
        try {
            this.a.destroy();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void enableCustomClickGesture() {
        try {
            this.a.j0();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.f13878e;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getAdvertiser() {
        try {
            return this.a.w();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getBody() {
        try {
            return this.a.i();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getCallToAction() {
        try {
            return this.a.h();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Bundle getExtras() {
        try {
            Bundle extras = this.a.getExtras();
            if (extras != null) {
                return extras;
            }
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getHeadline() {
        try {
            return this.a.g();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.Image getIcon() {
        return this.f13876c;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List<NativeAd.Image> getImages() {
        return this.f13875b;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getMediationAdapterClassName() {
        try {
            return this.a.getMediationAdapterClassName();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.f13879f;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getPrice() {
        try {
            return this.a.o();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Double getStarRating() {
        try {
            double dT = this.a.t();
            if (dT == -1.0d) {
                return null;
            }
            return Double.valueOf(dT);
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getStore() {
        try {
            return this.a.getStore();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final VideoController getVideoController() {
        try {
            if (this.a.getVideoController() != null) {
                this.f13877d.zza(this.a.getVideoController());
            }
        } catch (RemoteException e2) {
            zzbad.c("Exception occurred while getting video controller", e2);
        }
        return this.f13877d;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.a.u2();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            if (!isCustomMuteThisAdEnabled()) {
                zzbad.g("Ad is not custom mute enabled");
                return;
            }
            if (muteThisAdReason == null) {
                this.a.e0(null);
            } else if (muteThisAdReason instanceof zzaan) {
                this.a.e0(((zzaan) muteThisAdReason).a());
            } else {
                zzbad.g("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
            }
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.a.z(bundle);
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void recordCustomClickGesture() {
        try {
            this.a.D6();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.a.E(bundle);
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.a.L(bundle);
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.a.G0(new zzaaj(muteThisAdListener));
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setUnconfirmedClickListener(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.a.d0(new zzagt(unconfirmedClickListener));
        } catch (RemoteException e2) {
            zzbad.c("Failed to setUnconfirmedClickListener", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Object zzkv() {
        try {
            IObjectWrapper iObjectWrapperJ = this.a.j();
            if (iObjectWrapperJ != null) {
                return ObjectWrapper.k0(iObjectWrapperJ);
            }
            return null;
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }
}
