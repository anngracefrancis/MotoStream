package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ResultTransform<R extends Result, S extends Result> {
    public Status a(Status status) {
        return status;
    }

    public abstract PendingResult<S> b(R r);
}
