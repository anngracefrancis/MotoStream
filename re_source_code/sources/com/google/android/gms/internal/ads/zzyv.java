package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public class zzyv extends AdListener {
    private final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AdListener f17014b;

    public final void a(AdListener adListener) {
        synchronized (this.a) {
            this.f17014b = adListener;
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdClosed() {
        synchronized (this.a) {
            AdListener adListener = this.f17014b;
            if (adListener != null) {
                adListener.onAdClosed();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdFailedToLoad(int i2) {
        synchronized (this.a) {
            AdListener adListener = this.f17014b;
            if (adListener != null) {
                adListener.onAdFailedToLoad(i2);
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdLeftApplication() {
        synchronized (this.a) {
            AdListener adListener = this.f17014b;
            if (adListener != null) {
                adListener.onAdLeftApplication();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdLoaded() {
        synchronized (this.a) {
            AdListener adListener = this.f17014b;
            if (adListener != null) {
                adListener.onAdLoaded();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdOpened() {
        synchronized (this.a) {
            AdListener adListener = this.f17014b;
            if (adListener != null) {
                adListener.onAdOpened();
            }
        }
    }
}
