package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcpz extends AdMetadataListener {
    private zzaao a;

    public final synchronized void a(zzaao zzaaoVar) {
        this.a = zzaaoVar;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final synchronized void onAdMetadataChanged() {
        zzaao zzaaoVar = this.a;
        if (zzaaoVar != null) {
            try {
                zzaaoVar.onAdMetadataChanged();
            } catch (RemoteException e2) {
                zzbad.f("#007 Could not call remote method.", e2);
            }
        }
    }
}
