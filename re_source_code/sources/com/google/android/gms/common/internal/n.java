package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class n implements Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ o f12041f;

    /* synthetic */ n(o oVar, zzp zzpVar) {
        this.f12041f = oVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            synchronized (this.f12041f.f12042f) {
                zzn zznVar = (zzn) message.obj;
                m mVar = (m) this.f12041f.f12042f.get(zznVar);
                if (mVar != null && mVar.i()) {
                    if (mVar.j()) {
                        mVar.g("GmsClientSupervisor");
                    }
                    this.f12041f.f12042f.remove(zznVar);
                }
            }
            return true;
        }
        if (i2 != 1) {
            return false;
        }
        synchronized (this.f12041f.f12042f) {
            zzn zznVar2 = (zzn) message.obj;
            m mVar2 = (m) this.f12041f.f12042f.get(zznVar2);
            if (mVar2 != null && mVar2.a() == 3) {
                Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + String.valueOf(zznVar2), new Exception());
                ComponentName componentNameB = mVar2.b();
                if (componentNameB == null) {
                    componentNameB = zznVar2.b();
                }
                if (componentNameB == null) {
                    String strD = zznVar2.d();
                    Preconditions.k(strD);
                    componentNameB = new ComponentName(strD, "unknown");
                }
                mVar2.onServiceDisconnected(componentNameB);
            }
        }
        return true;
    }
}
