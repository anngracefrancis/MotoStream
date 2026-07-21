package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzabz extends zzaap {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final OnAdMetadataChangedListener f13782f;

    public zzabz(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.f13782f = onAdMetadataChangedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaao
    public final void onAdMetadataChanged() throws RemoteException {
        OnAdMetadataChangedListener onAdMetadataChangedListener = this.f13782f;
        if (onAdMetadataChangedListener != null) {
            onAdMetadataChangedListener.onAdMetadataChanged();
        }
    }
}
