package kotlinx.coroutines.tasks;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.o;
import kotlin.p003y.Continuation;
import kotlin.p003y.intrinsics.c;
import kotlin.p003y.intrinsics.d;
import kotlin.p003y.j.p004a.h;
import kotlin.u;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Tasks.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a(\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002\u001a\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a!\u0010\b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a)\u0010\b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a+\u0010\u000b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"asDeferred", "Lkotlinx/coroutines/Deferred;", "T", "Lcom/google/android/gms/tasks/Task;", "cancellationTokenSource", "Lcom/google/android/gms/tasks/CancellationTokenSource;", "asDeferredImpl", "asTask", "await", "(Lcom/google/android/gms/tasks/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/google/android/gms/tasks/Task;Lcom/google/android/gms/tasks/CancellationTokenSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitImpl", "kotlinx-coroutines-play-services"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: compiled from: Tasks.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u0001H\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "T", "it", "Lcom/google/android/gms/tasks/Task;", "kotlin.jvm.PlatformType", "onComplete"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a<TResult> implements OnCompleteListener {
        final /* synthetic */ CancellableContinuation<T> a;

        /* JADX WARN: Multi-variable type inference failed */
        a(CancellableContinuation<? super T> cancellableContinuation) {
            this.a = cancellableContinuation;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public final void a(Task<T> task) {
            Exception excI = task.i();
            if (excI != null) {
                Continuation continuation = this.a;
                Result.a aVar = Result.f25108f;
                continuation.resumeWith(Result.a(o.a(excI)));
            } else {
                if (task.l()) {
                    CancellableContinuation.a.a(this.a, null, 1, null);
                    return;
                }
                Continuation continuation2 = this.a;
                Result.a aVar2 = Result.f25108f;
                continuation2.resumeWith(Result.a(task.j()));
            }
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.e3.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Tasks.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "T", "it", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C0422b extends Lambda implements Function1<Throwable, u> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ CancellationTokenSource f25743f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0422b(CancellationTokenSource cancellationTokenSource) {
            super(1);
            this.f25743f = cancellationTokenSource;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ u invoke(Throwable th) {
            invoke2(th);
            return u.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            this.f25743f.a();
        }
    }

    public static final <T> Object a(Task<T> task, Continuation<? super T> continuation) {
        return b(task, null, continuation);
    }

    private static final <T> Object b(Task<T> task, CancellationTokenSource cancellationTokenSource, Continuation<? super T> continuation) throws Exception {
        if (!task.m()) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(c.b(continuation), 1);
            cancellableContinuationImpl.z();
            task.c(DirectExecutor.f25742f, new a(cancellableContinuationImpl));
            if (cancellationTokenSource != null) {
                cancellableContinuationImpl.e(new C0422b(cancellationTokenSource));
            }
            Object objW = cancellableContinuationImpl.w();
            if (objW == d.c()) {
                h.c(continuation);
            }
            return objW;
        }
        Exception excI = task.i();
        if (excI != null) {
            throw excI;
        }
        if (!task.l()) {
            return task.j();
        }
        throw new CancellationException("Task " + task + " was cancelled normally.");
    }
}
