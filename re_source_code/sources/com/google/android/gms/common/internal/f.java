package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
final class f implements PendingResultUtil.zaa {
    f() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.zaa
    public final ApiException a(Status status) {
        return ApiExceptionUtil.a(status);
    }
}
