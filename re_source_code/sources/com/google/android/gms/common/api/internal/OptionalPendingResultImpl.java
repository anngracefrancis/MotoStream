package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public final class OptionalPendingResultImpl<R extends Result> extends OptionalPendingResult<R> {
    private final BasePendingResult<R> a;

    @Override // com.google.android.gms.common.api.PendingResult
    public final void b(PendingResult.StatusListener statusListener) {
        this.a.b(statusListener);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R c(long j2, TimeUnit timeUnit) {
        return this.a.c(j2, timeUnit);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void d() {
        this.a.d();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final boolean e() {
        return this.a.e();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void f(ResultCallback<? super R> resultCallback) {
        this.a.f(resultCallback);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final Integer g() {
        return this.a.g();
    }
}
