package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Task<TResult> {
    public Task<TResult> a(Executor executor, OnCanceledListener onCanceledListener) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    public Task<TResult> b(OnCompleteListener<TResult> onCompleteListener) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public Task<TResult> c(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public abstract Task<TResult> d(Executor executor, OnFailureListener onFailureListener);

    public abstract Task<TResult> e(Executor executor, OnSuccessListener<? super TResult> onSuccessListener);

    public <TContinuationResult> Task<TContinuationResult> f(Continuation<TResult, TContinuationResult> continuation) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> g(Executor executor, Continuation<TResult, TContinuationResult> continuation) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> h(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public abstract Exception i();

    public abstract TResult j();

    public abstract <X extends Throwable> TResult k(Class<X> cls) throws Throwable;

    public abstract boolean l();

    public abstract boolean m();

    public abstract boolean n();

    public <TContinuationResult> Task<TContinuationResult> o(SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> p(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }
}
