package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class t4 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Context f13343f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzbbr f13344g;

    t4(zzawg zzawgVar, Context context, zzbbr zzbbrVar) {
        this.f13343f = context;
        this.f13344g = zzbbrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f13344g.a(AdvertisingIdClient.getAdvertisingIdInfo(this.f13343f));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e2) {
            this.f13344g.c(e2);
            zzbad.c("Exception while getting advertising Id info", e2);
        }
    }
}
