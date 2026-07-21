package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: loaded from: classes2.dex */
final class w40 implements BaseGmsClient.BaseConnectionCallbacks {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzvn f13495f;

    w40(zzvn zzvnVar) {
        this.f13495f = zzvnVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void H(int i2) {
        synchronized (this.f13495f.f16858b) {
            this.f13495f.f16861e = null;
            this.f13495f.f16858b.notifyAll();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void P(Bundle bundle) {
        synchronized (this.f13495f.f16858b) {
            try {
                if (this.f13495f.f16859c != null) {
                    zzvn zzvnVar = this.f13495f;
                    zzvnVar.f16861e = zzvnVar.f16859c.e();
                }
            } catch (DeadObjectException e2) {
                zzbad.c("Unable to obtain a cache service instance.", e2);
                this.f13495f.b();
            }
            this.f13495f.f16858b.notifyAll();
        }
    }
}
