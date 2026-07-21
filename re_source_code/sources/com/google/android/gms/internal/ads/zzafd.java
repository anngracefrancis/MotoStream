package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzafd extends NativeContentAd {
    private final zzafa a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzael f13865c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final NativeAd.AdChoicesInfo f13867e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<NativeAd.Image> f13864b = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final VideoController f13866d = new VideoController();

    public zzafd(zzafa zzafaVar) {
        zzael zzaelVar;
        zzaei zzaekVar;
        IBinder iBinder;
        this.a = zzafaVar;
        zzaed zzaedVar = null;
        try {
            List listK = zzafaVar.k();
            if (listK != null) {
                for (Object obj : listK) {
                    if (!(obj instanceof IBinder) || (iBinder = (IBinder) obj) == null) {
                        zzaekVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                        zzaekVar = iInterfaceQueryLocalInterface instanceof zzaei ? (zzaei) iInterfaceQueryLocalInterface : new zzaek(iBinder);
                    }
                    if (zzaekVar != null) {
                        this.f13864b.add(new zzael(zzaekVar));
                    }
                }
            }
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
        try {
            zzaei zzaeiVarD0 = this.a.D0();
            zzaelVar = zzaeiVarD0 != null ? new zzael(zzaeiVarD0) : null;
        } catch (RemoteException e3) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e3);
        }
        this.f13865c = zzaelVar;
        try {
            if (this.a.f() != null) {
                zzaedVar = new zzaed(this.a.f());
            }
        } catch (RemoteException e4) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e4);
        }
        this.f13867e = zzaedVar;
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

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final void destroy() {
        try {
            this.a.destroy();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.f13867e;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getAdvertiser() {
        try {
            return this.a.w();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getBody() {
        try {
            return this.a.i();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getCallToAction() {
        try {
            return this.a.h();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final Bundle getExtras() {
        try {
            return this.a.getExtras();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getHeadline() {
        try {
            return this.a.g();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final List<NativeAd.Image> getImages() {
        return this.f13864b;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final NativeAd.Image getLogo() {
        return this.f13865c;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getMediationAdapterClassName() {
        try {
            return this.a.getMediationAdapterClassName();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final VideoController getVideoController() {
        try {
            if (this.a.getVideoController() != null) {
                this.f13866d.zza(this.a.getVideoController());
            }
        } catch (RemoteException e2) {
            zzbad.c("Exception occurred while getting video controller", e2);
        }
        return this.f13866d;
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
