package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;

/* JADX INFO: loaded from: classes2.dex */
public final class Batch extends BasePendingResult<BatchResult> {
    private final PendingResult<?>[] q;

    public static final class Builder {
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult, com.google.android.gms.common.api.PendingResult
    public final void d() {
        super.d();
        for (PendingResult<?> pendingResult : this.q) {
            pendingResult.d();
        }
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final BatchResult h(Status status) {
        return new BatchResult(status, this.q);
    }
}
