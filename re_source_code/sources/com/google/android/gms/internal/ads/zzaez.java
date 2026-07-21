package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzaez extends NativeAppInstallAd {
    private final zzaew a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzael f13859c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final NativeAd.AdChoicesInfo f13861e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<NativeAd.Image> f13858b = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final VideoController f13860d = new VideoController();

    public zzaez(zzaew zzaewVar) {
        zzael zzaelVar;
        zzaei zzaekVar;
        IBinder iBinder;
        this.a = zzaewVar;
        zzaed zzaedVar = null;
        try {
            List listK = zzaewVar.k();
            if (listK != null) {
                for (Object obj : listK) {
                    if (!(obj instanceof IBinder) || (iBinder = (IBinder) obj) == null) {
                        zzaekVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                        zzaekVar = iInterfaceQueryLocalInterface instanceof zzaei ? (zzaei) iInterfaceQueryLocalInterface : new zzaek(iBinder);
                    }
                    if (zzaekVar != null) {
                        this.f13858b.add(new zzael(zzaekVar));
                    }
                }
            }
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
        try {
            zzaei zzaeiVarN = this.a.n();
            zzaelVar = zzaeiVarN != null ? new zzael(zzaeiVarN) : null;
        } catch (RemoteException e3) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e3);
        }
        this.f13859c = zzaelVar;
        try {
            if (this.a.f() != null) {
                zzaedVar = new zzaed(this.a.f());
            }
        } catch (RemoteException e4) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e4);
        }
        this.f13861e = zzaedVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.formats.NativeAd
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final IObjectWrapper zzkq() {
        try {
            return this.a.r();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final void destroy() {
        try {
            this.a.destroy();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.f13861e;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getBody() {
        try {
            return this.a.i();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getCallToAction() {
        try {
            return this.a.h();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final Bundle getExtras() {
        try {
            return this.a.getExtras();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getHeadline() {
        try {
            return this.a.g();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final NativeAd.Image getIcon() {
        return this.f13859c;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final List<NativeAd.Image> getImages() {
        return this.f13858b;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getMediationAdapterClassName() {
        try {
            return this.a.getMediationAdapterClassName();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getPrice() {
        try {
            return this.a.o();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
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

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getStore() {
        try {
            return this.a.getStore();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final VideoController getVideoController() {
        try {
            if (this.a.getVideoController() != null) {
                this.f13860d.zza(this.a.getVideoController());
            }
        } catch (RemoteException e2) {
            zzbad.c("Exception occurred while getting video controller", e2);
        }
        return this.f13860d;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.a.z(bundle);
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.a.E(bundle);
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.a.L(bundle);
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }
}
