package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.PublisherAdView;

/* JADX INFO: loaded from: classes2.dex */
final class x implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ PublisherAdView f13534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzzk f13535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzagq f13536h;

    x(zzagq zzagqVar, PublisherAdView publisherAdView, zzzk zzzkVar) {
        this.f13536h = zzagqVar;
        this.f13534f = publisherAdView;
        this.f13535g = zzzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f13534f.zza(this.f13535g)) {
            this.f13536h.f13885f.onPublisherAdViewLoaded(this.f13534f);
        } else {
            zzbad.i("Could not bind.");
        }
    }
}
