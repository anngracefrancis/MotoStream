package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class PendingResultUtil {
    private static final zaa a = new f();

    @KeepForSdk
    public interface ResultConverter<R extends Result, T> {
        @KeepForSdk
        T a(R r);
    }

    public interface zaa {
        ApiException a(Status status);
    }

    @KeepForSdk
    public static <R extends Result, T extends Response<R>> Task<T> a(PendingResult<R> pendingResult, T t) {
        return b(pendingResult, new h(t));
    }

    @KeepForSdk
    public static <R extends Result, T> Task<T> b(PendingResult<R> pendingResult, ResultConverter<R, T> resultConverter) {
        zaa zaaVar = a;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.b(new g(pendingResult, taskCompletionSource, resultConverter, zaaVar));
        return taskCompletionSource.a();
    }
}
