package com.google.android.gms.common.api;

/* JADX INFO: loaded from: classes2.dex */
public final class BatchResult implements Result {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Status f11657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final PendingResult<?>[] f11658g;

    BatchResult(Status status, PendingResult<?>[] pendingResultArr) {
        this.f11657f = status;
        this.f11658g = pendingResultArr;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f11657f;
    }
}
