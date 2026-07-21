package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class zaab {
    private final Map<BasePendingResult<?>, Boolean> a = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<TaskCompletionSource<?>, Boolean> f11801b = Collections.synchronizedMap(new WeakHashMap());

    private final void d(boolean z, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (this.a) {
            map = new HashMap(this.a);
        }
        synchronized (this.f11801b) {
            map2 = new HashMap(this.f11801b);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).p(status);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).d(new ApiException(status));
            }
        }
    }

    final void b(BasePendingResult<? extends Result> basePendingResult, boolean z) {
        this.a.put(basePendingResult, Boolean.valueOf(z));
        basePendingResult.b(new b(this, basePendingResult));
    }

    final <TResult> void c(TaskCompletionSource<TResult> taskCompletionSource, boolean z) {
        this.f11801b.put(taskCompletionSource, Boolean.valueOf(z));
        taskCompletionSource.a().b(new c(this, taskCompletionSource));
    }

    final boolean e() {
        return (this.a.isEmpty() && this.f11801b.isEmpty()) ? false : true;
    }

    public final void f() {
        d(false, GoogleApiManager.f11711f);
    }

    public final void g() {
        d(true, zacp.a);
    }
}
