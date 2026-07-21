package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;

/* JADX INFO: loaded from: classes2.dex */
public final class zzccw extends VideoController.VideoLifecycleCallbacks {
    private final zzbyt a;

    public zzccw(zzbyt zzbytVar) {
        this.a = zzbytVar;
    }

    private static zzaau a(zzbyt zzbytVar) {
        zzaar zzaarVarM = zzbytVar.m();
        if (zzaarVarM == null) {
            return null;
        }
        try {
            return zzaarVarM.a5();
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoEnd() {
        zzaau zzaauVarA = a(this.a);
        if (zzaauVarA == null) {
            return;
        }
        try {
            zzaauVarA.n0();
        } catch (RemoteException e2) {
            zzbad.d("Unable to call onVideoEnd()", e2);
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoPause() {
        zzaau zzaauVarA = a(this.a);
        if (zzaauVarA == null) {
            return;
        }
        try {
            zzaauVarA.onVideoPause();
        } catch (RemoteException e2) {
            zzbad.d("Unable to call onVideoEnd()", e2);
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoStart() {
        zzaau zzaauVarA = a(this.a);
        if (zzaauVarA == null) {
            return;
        }
        try {
            zzaauVarA.onVideoStart();
        } catch (RemoteException e2) {
            zzbad.d("Unable to call onVideoEnd()", e2);
        }
    }
}
