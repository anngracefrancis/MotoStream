package com.google.android.gms.common.api;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    @Override // com.google.android.gms.common.api.ResultCallback
    @KeepForSdk
    public final void a(R r) {
        Status status = r.getStatus();
        if (status.e0()) {
            c(r);
            return;
        }
        b(status);
        if (r instanceof Releasable) {
            try {
                ((Releasable) r).c();
            } catch (RuntimeException e2) {
                Log.w("ResultCallbacks", "Unable to release ".concat(String.valueOf(r)), e2);
            }
        }
    }

    public abstract void b(Status status);

    public abstract void c(R r);
}
