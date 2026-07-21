package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzagq extends zzafv {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final OnPublisherAdViewLoadedListener f13885f;

    public zzagq(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener) {
        this.f13885f = onPublisherAdViewLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafu
    public final void h1(zzzk zzzkVar, IObjectWrapper iObjectWrapper) {
        if (zzzkVar == null || iObjectWrapper == null) {
            return;
        }
        PublisherAdView publisherAdView = new PublisherAdView((Context) ObjectWrapper.k0(iObjectWrapper));
        try {
            if (zzzkVar.x5() instanceof zzxv) {
                zzxv zzxvVar = (zzxv) zzzkVar.x5();
                publisherAdView.setAdListener(zzxvVar != null ? zzxvVar.h7() : null);
            }
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
        try {
            if (zzzkVar.I4() instanceof zzyf) {
                zzyf zzyfVar = (zzyf) zzzkVar.I4();
                publisherAdView.setAppEventListener(zzyfVar != null ? zzyfVar.i7() : null);
            }
        } catch (RemoteException e3) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e3);
        }
        zzazt.a.post(new x(this, publisherAdView, zzzkVar));
    }
}
