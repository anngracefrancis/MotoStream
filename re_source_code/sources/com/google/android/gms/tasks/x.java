package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class x<TResult> extends Task<TResult> {
    private final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u f18348b = new u();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f18349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f18350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f18351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Exception f18352f;

    x() {
    }

    private final void v() {
        Preconditions.o(this.f18349c, "Task is not yet complete");
    }

    private final void w() {
        if (this.f18350d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void x() {
        if (this.f18349c) {
            throw DuplicateTaskCompletionException.a(this);
        }
    }

    private final void y() {
        synchronized (this.a) {
            if (this.f18349c) {
                this.f18348b.b(this);
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> a(Executor executor, OnCanceledListener onCanceledListener) {
        this.f18348b.a(new j(executor, onCanceledListener));
        y();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> b(OnCompleteListener<TResult> onCompleteListener) {
        this.f18348b.a(new l(TaskExecutors.a, onCompleteListener));
        y();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> c(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f18348b.a(new l(executor, onCompleteListener));
        y();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> d(Executor executor, OnFailureListener onFailureListener) {
        this.f18348b.a(new n(executor, onFailureListener));
        y();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> e(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.f18348b.a(new p(executor, onSuccessListener));
        y();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> f(Continuation<TResult, TContinuationResult> continuation) {
        return g(TaskExecutors.a, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> g(Executor executor, Continuation<TResult, TContinuationResult> continuation) {
        x xVar = new x();
        this.f18348b.a(new f(executor, continuation, xVar));
        y();
        return xVar;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> h(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation) {
        x xVar = new x();
        this.f18348b.a(new h(executor, continuation, xVar));
        y();
        return xVar;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Exception i() {
        Exception exc;
        synchronized (this.a) {
            exc = this.f18352f;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.Task
    public final TResult j() {
        TResult tresult;
        synchronized (this.a) {
            v();
            w();
            Exception exc = this.f18352f;
            if (exc != null) {
                throw new RuntimeExecutionException(exc);
            }
            tresult = (TResult) this.f18351e;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <X extends Throwable> TResult k(Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.a) {
            v();
            w();
            if (cls.isInstance(this.f18352f)) {
                throw cls.cast(this.f18352f);
            }
            Exception exc = this.f18352f;
            if (exc != null) {
                throw new RuntimeExecutionException(exc);
            }
            tresult = (TResult) this.f18351e;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean l() {
        return this.f18350d;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean m() {
        boolean z;
        synchronized (this.a) {
            z = this.f18349c;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean n() {
        boolean z;
        synchronized (this.a) {
            z = false;
            if (this.f18349c && !this.f18350d && this.f18352f == null) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> o(SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        Executor executor = TaskExecutors.a;
        x xVar = new x();
        this.f18348b.a(new s(executor, successContinuation, xVar));
        y();
        return xVar;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> p(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        x xVar = new x();
        this.f18348b.a(new s(executor, successContinuation, xVar));
        y();
        return xVar;
    }

    public final void q(Exception exc) {
        Preconditions.l(exc, "Exception must not be null");
        synchronized (this.a) {
            x();
            this.f18349c = true;
            this.f18352f = exc;
        }
        this.f18348b.b(this);
    }

    public final void r(Object obj) {
        synchronized (this.a) {
            x();
            this.f18349c = true;
            this.f18351e = obj;
        }
        this.f18348b.b(this);
    }

    public final boolean s() {
        synchronized (this.a) {
            if (this.f18349c) {
                return false;
            }
            this.f18349c = true;
            this.f18350d = true;
            this.f18348b.b(this);
            return true;
        }
    }

    public final boolean t(Exception exc) {
        Preconditions.l(exc, "Exception must not be null");
        synchronized (this.a) {
            if (this.f18349c) {
                return false;
            }
            this.f18349c = true;
            this.f18352f = exc;
            this.f18348b.b(this);
            return true;
        }
    }

    public final boolean u(Object obj) {
        synchronized (this.a) {
            if (this.f18349c) {
                return false;
            }
            this.f18349c = true;
            this.f18351e = obj;
            this.f18348b.b(this);
            return true;
        }
    }
}
