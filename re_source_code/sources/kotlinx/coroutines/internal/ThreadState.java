package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.p003y.CoroutineContext;
import kotlinx.coroutines.ThreadContextElement;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.internal.l0, reason: from Kotlin metadata */
/* JADX INFO: compiled from: ThreadContext.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t0\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/internal/ThreadState;", HttpUrl.FRAGMENT_ENCODE_SET, "context", "Lkotlin/coroutines/CoroutineContext;", "n", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlin/coroutines/CoroutineContext;I)V", "elements", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/ThreadContextElement;", "[Lkotlinx/coroutines/ThreadContextElement;", "i", "values", "[Ljava/lang/Object;", "append", HttpUrl.FRAGMENT_ENCODE_SET, "element", "value", "restore", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class ThreadState {
    public final CoroutineContext a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f25812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ThreadContextElement<Object>[] f25813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f25814d;

    public ThreadState(CoroutineContext coroutineContext, int i2) {
        this.a = coroutineContext;
        this.f25812b = new Object[i2];
        this.f25813c = new ThreadContextElement[i2];
    }

    public final void a(ThreadContextElement<?> threadContextElement, Object obj) {
        Object[] objArr = this.f25812b;
        int i2 = this.f25814d;
        objArr[i2] = obj;
        ThreadContextElement<Object>[] threadContextElementArr = this.f25813c;
        this.f25814d = i2 + 1;
        threadContextElementArr[i2] = threadContextElement;
    }

    public final void b(CoroutineContext coroutineContext) {
        int length = this.f25813c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i2 = length - 1;
            ThreadContextElement<Object> threadContextElement = this.f25813c[length];
            kotlin.jvm.internal.m.c(threadContextElement);
            threadContextElement.z(coroutineContext, this.f25812b[length]);
            if (i2 < 0) {
                return;
            } else {
                length = i2;
            }
        }
    }
}
