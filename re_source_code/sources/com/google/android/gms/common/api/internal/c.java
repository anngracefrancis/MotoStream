package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Add missing generic type declarations: [TResult] */
/* JADX INFO: loaded from: classes2.dex */
final class c<TResult> implements OnCompleteListener<TResult> {
    private final /* synthetic */ TaskCompletionSource a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zaab f11746b;

    c(zaab zaabVar, TaskCompletionSource taskCompletionSource) {
        this.f11746b = zaabVar;
        this.a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void a(Task<TResult> task) {
        this.f11746b.f11801b.remove(this.a);
    }
}
