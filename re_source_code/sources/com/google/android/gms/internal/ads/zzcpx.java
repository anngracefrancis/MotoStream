package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcpx extends AdMetadataListener {
    private zzzp a;

    public final synchronized void a(zzzp zzzpVar) {
        this.a = zzzpVar;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final synchronized void onAdMetadataChanged() {
        zzzp zzzpVar = this.a;
        if (zzzpVar != null) {
            try {
                zzzpVar.onAdMetadataChanged();
            } catch (RemoteException e2) {
                zzbad.d("Remote Exception at onAdMetadataChanged.", e2);
            }
        }
    }
}
