package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.p003y.Continuation;
import kotlin.p003y.CoroutineContext;
import kotlin.p003y.j.p004a.CoroutineStackFrame;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.b1, reason: from Kotlin metadata */
/* JADX INFO: compiled from: DispatchedTask.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000e\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0002\b\u0014J\u001f\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u001b\u001a\u00020\fJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u000eH ¢\u0006\u0002\b\u001dR\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX \u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", HttpUrl.FRAGMENT_ENCODE_SET, "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "cancelCompletedResult", HttpUrl.FRAGMENT_ENCODE_SET, "takenState", HttpUrl.FRAGMENT_ENCODE_SET, "cause", HttpUrl.FRAGMENT_ENCODE_SET, "cancelCompletedResult$kotlinx_coroutines_core", "getExceptionalResult", "state", "getExceptionalResult$kotlinx_coroutines_core", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "handleFatalException", "exception", "finallyException", "run", "takeState", "takeState$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class DispatchedTask<T> extends Task {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f25647h;

    public DispatchedTask(int i2) {
        this.f25647h = i2;
    }

    public void a(Object obj, Throwable th) {
    }

    public abstract Continuation<T> c();

    public Throwable d(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.f25646b;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T f(Object obj) {
        return obj;
    }

    public final void i(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            kotlin.b.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        kotlin.jvm.internal.m.c(th);
        l0.a(c().getL(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object j();

    @Override // java.lang.Runnable
    public final void run() {
        Object objA;
        Object objA2;
        if (s0.a()) {
            if (!(this.f25647h != -1)) {
                throw new AssertionError();
            }
        }
        TaskContext taskContext = this.f25680g;
        try {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) c();
            Continuation<T> continuation = dispatchedContinuation.f25798k;
            Object obj = dispatchedContinuation.m;
            CoroutineContext context = continuation.getL();
            Object objC = kotlinx.coroutines.internal.i0.c(context, obj);
            UndispatchedCoroutine<?> undispatchedCoroutineG = objC != kotlinx.coroutines.internal.i0.a ? h0.g(continuation, context, objC) : null;
            try {
                CoroutineContext context2 = continuation.getL();
                Object objJ = j();
                Throwable thD = d(objJ);
                Job job = (thD == null && c1.b(this.f25647h)) ? (Job) context2.get(Job.f25890e) : null;
                if (job != null && !job.b()) {
                    Throwable thJ = job.j();
                    a(objJ, thJ);
                    Result.a aVar = Result.f25108f;
                    if (s0.d() && (continuation instanceof CoroutineStackFrame)) {
                        thJ = kotlinx.coroutines.internal.d0.j(thJ, (CoroutineStackFrame) continuation);
                    }
                    continuation.resumeWith(Result.a(kotlin.o.a(thJ)));
                } else if (thD != null) {
                    Result.a aVar2 = Result.f25108f;
                    continuation.resumeWith(Result.a(kotlin.o.a(thD)));
                } else {
                    Result.a aVar3 = Result.f25108f;
                    continuation.resumeWith(Result.a(f(objJ)));
                }
                kotlin.u uVar = kotlin.u.a;
                if (undispatchedCoroutineG == null || undispatchedCoroutineG.H0()) {
                    kotlinx.coroutines.internal.i0.a(context, objC);
                }
                try {
                    Result.a aVar4 = Result.f25108f;
                    taskContext.a();
                    objA2 = Result.a(uVar);
                } catch (Throwable th) {
                    Result.a aVar5 = Result.f25108f;
                    objA2 = Result.a(kotlin.o.a(th));
                }
                i(null, Result.b(objA2));
            } catch (Throwable th2) {
                if (undispatchedCoroutineG == null || undispatchedCoroutineG.H0()) {
                    kotlinx.coroutines.internal.i0.a(context, objC);
                }
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                Result.a aVar6 = Result.f25108f;
                taskContext.a();
                objA = Result.a(kotlin.u.a);
            } catch (Throwable th4) {
                Result.a aVar7 = Result.f25108f;
                objA = Result.a(kotlin.o.a(th4));
            }
            i(th3, Result.b(objA));
        }
    }
}
