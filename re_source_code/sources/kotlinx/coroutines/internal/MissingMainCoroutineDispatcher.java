package kotlinx.coroutines.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.p003y.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.MainCoroutineDispatcher;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.internal.x, reason: from Kotlin metadata */
/* JADX INFO: compiled from: MainDispatchers.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000e2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\fH\u0002J\u001e\u0010 \u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "cause", HttpUrl.FRAGMENT_ENCODE_SET, "errorHint", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/Throwable;Ljava/lang/String;)V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "delay", HttpUrl.FRAGMENT_ENCODE_SET, "time", HttpUrl.FRAGMENT_ENCODE_SET, "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "isDispatchNeeded", HttpUrl.FRAGMENT_ENCODE_SET, "limitedParallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "parallelism", HttpUrl.FRAGMENT_ENCODE_SET, "missing", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class MissingMainCoroutineDispatcher extends MainCoroutineDispatcher implements Delay {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Throwable f25837g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f25838h;

    public MissingMainCoroutineDispatcher(Throwable th, String str) {
        this.f25837g = th;
        this.f25838h = str;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0025  */
    private final Void Z() {
        String str;
        if (this.f25837g == null) {
            w.d();
            throw new KotlinNothingValueException();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Module with the Main dispatcher had failed to initialize");
        String str2 = this.f25838h;
        if (str2 != null) {
            str = ". " + str2;
            if (str == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET;
            }
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(str);
        throw new IllegalStateException(sb.toString(), this.f25837g);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean N(CoroutineContext coroutineContext) {
        Z();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public MainCoroutineDispatcher T() {
        return this;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public Void K(CoroutineContext coroutineContext, Runnable runnable) {
        Z();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.Delay
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public Void e(long j2, CancellableContinuation<? super kotlin.u> cancellableContinuation) {
        Z();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.f25837g != null) {
            str = ", cause=" + this.f25837g;
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }
}
