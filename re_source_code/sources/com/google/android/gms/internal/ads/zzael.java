package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzael extends NativeAd.Image {
    private final zzaei a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Drawable f13853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Uri f13854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final double f13855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f13856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f13857f;

    public zzael(zzaei zzaeiVar) {
        Drawable drawable;
        int width;
        this.a = zzaeiVar;
        Uri uriI0 = null;
        try {
            IObjectWrapper iObjectWrapperT4 = zzaeiVar.t4();
            drawable = iObjectWrapperT4 != null ? (Drawable) ObjectWrapper.k0(iObjectWrapperT4) : null;
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
        this.f13853b = drawable;
        try {
            uriI0 = this.a.I0();
        } catch (RemoteException e3) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e3);
        }
        this.f13854c = uriI0;
        double dT3 = 1.0d;
        try {
            dT3 = this.a.T3();
        } catch (RemoteException e4) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e4);
        }
        this.f13855d = dT3;
        int height = -1;
        try {
            width = this.a.getWidth();
        } catch (RemoteException e5) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e5);
            width = -1;
        }
        this.f13856e = width;
        try {
            height = this.a.getHeight();
        } catch (RemoteException e6) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e6);
        }
        this.f13857f = height;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Drawable getDrawable() {
        return this.f13853b;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final int getHeight() {
        return this.f13857f;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final double getScale() {
        return this.f13855d;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Uri getUri() {
        return this.f13854c;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final int getWidth() {
        return this.f13856e;
    }
}
