package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public abstract class PendingResult<R extends Result> {

    @KeepForSdk
    public interface StatusListener {
        @KeepForSdk
        void a(Status status);
    }

    @KeepForSdk
    public void b(StatusListener statusListener) {
        throw new UnsupportedOperationException();
    }

    public abstract R c(long j2, TimeUnit timeUnit);

    public abstract void d();

    public abstract boolean e();

    public abstract void f(ResultCallback<? super R> resultCallback);

    public Integer g() {
        throw new UnsupportedOperationException();
    }
}
