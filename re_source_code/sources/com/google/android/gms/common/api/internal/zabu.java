package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public class zabu extends zal {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TaskCompletionSource<Void> f11833k;

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void f() {
        super.f();
        this.f11833k.d(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    }

    @Override // com.google.android.gms.common.api.internal.zal
    protected final void l(ConnectionResult connectionResult, int i2) {
        this.f11833k.b(ApiExceptionUtil.a(new Status(connectionResult.y(), connectionResult.z(), connectionResult.W())));
    }

    @Override // com.google.android.gms.common.api.internal.zal
    protected final void n() {
        int i2 = this.f11875j.i(this.f11734f.c());
        if (i2 == 0) {
            this.f11833k.c(null);
        } else {
            if (this.f11833k.a().m()) {
                return;
            }
            m(new ConnectionResult(i2, null), 0);
        }
    }
}
