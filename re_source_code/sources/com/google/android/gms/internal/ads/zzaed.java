package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzaed extends NativeAd.AdChoicesInfo {
    private final zzaea a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<NativeAd.Image> f13851b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f13852c;

    public zzaed(zzaea zzaeaVar) {
        zzaei zzaekVar;
        IBinder iBinder;
        this.a = zzaeaVar;
        try {
            this.f13852c = zzaeaVar.m1();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            this.f13852c = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        try {
            for (zzaei zzaeiVar : zzaeaVar.M0()) {
                if (!(zzaeiVar instanceof IBinder) || (iBinder = (IBinder) zzaeiVar) == null) {
                    zzaekVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    zzaekVar = iInterfaceQueryLocalInterface instanceof zzaei ? (zzaei) iInterfaceQueryLocalInterface : new zzaek(iBinder);
                }
                if (zzaekVar != null) {
                    this.f13851b.add(new zzael(zzaekVar));
                }
            }
        } catch (RemoteException e3) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e3);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final List<NativeAd.Image> getImages() {
        return this.f13851b;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final CharSequence getText() {
        return this.f13852c;
    }
}
