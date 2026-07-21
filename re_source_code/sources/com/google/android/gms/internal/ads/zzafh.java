package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;
import java.util.WeakHashMap;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzafh implements NativeCustomTemplateAd {
    private static WeakHashMap<IBinder, zzafh> a = new WeakHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzafe f13868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MediaView f13869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final VideoController f13870d = new VideoController();

    @VisibleForTesting
    private zzafh(zzafe zzafeVar) {
        Context context;
        this.f13868b = zzafeVar;
        MediaView mediaView = null;
        try {
            context = (Context) ObjectWrapper.k0(zzafeVar.U4());
        } catch (RemoteException | NullPointerException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (this.f13868b.F3(ObjectWrapper.E0(mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (RemoteException e3) {
                zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e3);
            }
        }
        this.f13869c = mediaView;
    }

    public static zzafh a(zzafe zzafeVar) {
        synchronized (a) {
            zzafh zzafhVar = a.get(zzafeVar.asBinder());
            if (zzafhVar != null) {
                return zzafhVar;
            }
            zzafh zzafhVar2 = new zzafh(zzafeVar);
            a.put(zzafeVar.asBinder(), zzafhVar2);
            return zzafhVar2;
        }
    }

    public final zzafe b() {
        return this.f13868b;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final void destroy() {
        try {
            this.f13868b.destroy();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final List<String> getAvailableAssetNames() {
        try {
            return this.f13868b.getAvailableAssetNames();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final String getCustomTemplateId() {
        try {
            return this.f13868b.getCustomTemplateId();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final NativeAd.Image getImage(String str) {
        try {
            zzaei zzaeiVarN1 = this.f13868b.N1(str);
            if (zzaeiVarN1 != null) {
                return new zzael(zzaeiVarN1);
            }
            return null;
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final CharSequence getText(String str) {
        try {
            return this.f13868b.Y0(str);
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final VideoController getVideoController() {
        try {
            zzaar videoController = this.f13868b.getVideoController();
            if (videoController != null) {
                this.f13870d.zza(videoController);
            }
        } catch (RemoteException e2) {
            zzbad.c("Exception occurred while getting video controller", e2);
        }
        return this.f13870d;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final MediaView getVideoMediaView() {
        return this.f13869c;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final void performClick(String str) {
        try {
            this.f13868b.performClick(str);
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final void recordImpression() {
        try {
            this.f13868b.recordImpression();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }
}
