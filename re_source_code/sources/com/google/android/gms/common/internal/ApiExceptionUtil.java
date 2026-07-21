package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class ApiExceptionUtil {
    @KeepForSdk
    public static ApiException a(Status status) {
        return status.Y() ? new ResolvableApiException(status) : new ApiException(status);
    }
}
