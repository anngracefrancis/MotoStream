package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class cg implements zzaho<Object> {
    private final /* synthetic */ zzagd a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzbzq f12429b;

    cg(zzbzq zzbzqVar, zzagd zzagdVar) {
        this.f12429b = zzbzqVar;
        this.a = zzagdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final void a(Object obj, Map<String, String> map) {
        try {
            this.f12429b.f14940k = Long.valueOf(Long.parseLong(map.get("timestamp")));
        } catch (NumberFormatException unused) {
            zzbad.g("Failed to call parse unconfirmedClickTimestamp.");
        }
        this.f12429b.f14939j = map.get(DeepLinkIntentReceiver.DeepLinksKeys.ID);
        String str = map.get("asset_id");
        zzagd zzagdVar = this.a;
        if (zzagdVar == null) {
            zzbad.e("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            zzagdVar.onUnconfirmedClickReceived(str);
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }
}
