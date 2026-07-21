package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class i extends zzc {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f12032e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ BaseGmsClient f12033f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected i(BaseGmsClient baseGmsClient, int i2, Bundle bundle) {
        super(baseGmsClient, Boolean.TRUE);
        this.f12033f = baseGmsClient;
        this.f12031d = i2;
        this.f12032e = bundle;
    }

    @Override // com.google.android.gms.common.internal.zzc
    protected final /* bridge */ /* synthetic */ void a(Object obj) {
        if (this.f12031d != 0) {
            this.f12033f.zzp(1, null);
            Bundle bundle = this.f12032e;
            f(new ConnectionResult(this.f12031d, bundle != null ? (PendingIntent) bundle.getParcelable(BaseGmsClient.KEY_PENDING_INTENT) : null));
        } else {
            if (g()) {
                return;
            }
            this.f12033f.zzp(1, null);
            f(new ConnectionResult(8, null));
        }
    }

    @Override // com.google.android.gms.common.internal.zzc
    protected final void b() {
    }

    protected abstract void f(ConnectionResult connectionResult);

    protected abstract boolean g();
}
