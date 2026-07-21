package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzg extends i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ BaseGmsClient f12064g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzg(BaseGmsClient baseGmsClient, int i2, Bundle bundle) {
        super(baseGmsClient, i2, null);
        this.f12064g = baseGmsClient;
    }

    @Override // com.google.android.gms.common.internal.i
    protected final void f(ConnectionResult connectionResult) {
        if (this.f12064g.enableLocalFallback() && BaseGmsClient.zzo(this.f12064g)) {
            BaseGmsClient.zzk(this.f12064g, 16);
        } else {
            this.f12064g.zzc.a(connectionResult);
            this.f12064g.onConnectionFailed(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.internal.i
    protected final boolean g() {
        this.f12064g.zzc.a(ConnectionResult.f11619f);
        return true;
    }
}
