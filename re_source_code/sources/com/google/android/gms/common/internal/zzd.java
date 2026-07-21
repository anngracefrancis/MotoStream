package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public final class zzd extends zzab {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BaseGmsClient f12058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f12059g;

    public zzd(BaseGmsClient baseGmsClient, int i2) {
        this.f12058f = baseGmsClient;
        this.f12059g = i2;
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void O3(int i2, IBinder iBinder, Bundle bundle) {
        Preconditions.l(this.f12058f, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f12058f.onPostInitHandler(i2, iBinder, bundle, this.f12059g);
        this.f12058f = null;
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void f4(int i2, IBinder iBinder, zzj zzjVar) {
        BaseGmsClient baseGmsClient = this.f12058f;
        Preconditions.l(baseGmsClient, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        Preconditions.k(zzjVar);
        BaseGmsClient.zzj(baseGmsClient, zzjVar);
        O3(i2, iBinder, zzjVar.f12065f);
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void v2(int i2, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
}
