package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.p003y.AbstractCoroutineContextElement;
import kotlin.p003y.AbstractCoroutineContextKey;
import kotlin.p003y.Continuation;
import kotlin.p003y.ContinuationInterceptor;
import kotlin.p003y.CoroutineContext;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.LimitedDispatcher;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.i0, reason: from Kotlin metadata */
/* JADX INFO: compiled from: CoroutineDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH&J\u001c\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0017J \u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\rJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0011\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0000H\u0087\u0002J\u0012\u0010\u0017\u001a\u00020\u00052\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\rJ\b\u0010\u0018\u001a\u00020\u0019H\u0016¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "dispatch", HttpUrl.FRAGMENT_ENCODE_SET, "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchYield", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "isDispatchNeeded", HttpUrl.FRAGMENT_ENCODE_SET, "limitedParallelism", "parallelism", HttpUrl.FRAGMENT_ENCODE_SET, "plus", "other", "releaseInterceptedContinuation", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CoroutineDispatcher extends AbstractCoroutineContextElement implements ContinuationInterceptor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f25784f = new a(null);

    /* JADX INFO: renamed from: kotlinx.coroutines.i0$a */
    /* JADX INFO: compiled from: CoroutineDispatcher.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends AbstractCoroutineContextKey<ContinuationInterceptor, CoroutineDispatcher> {

        /* JADX INFO: renamed from: kotlinx.coroutines.i0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CoroutineDispatcher.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/CoroutineDispatcher;", "it", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class C0423a extends Lambda implements Function1<CoroutineContext.b, CoroutineDispatcher> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final C0423a f25785f = new C0423a();

            C0423a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CoroutineDispatcher invoke(CoroutineContext.b bVar) {
                if (bVar instanceof CoroutineDispatcher) {
                    return (CoroutineDispatcher) bVar;
                }
                return null;
            }
        }

        private a() {
            super(ContinuationInterceptor.f25606b, C0423a.f25785f);
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public CoroutineDispatcher() {
        super(ContinuationInterceptor.f25606b);
    }

    public abstract void K(CoroutineContext coroutineContext, Runnable runnable);

    public boolean N(CoroutineContext coroutineContext) {
        return true;
    }

    public CoroutineDispatcher Q(int i2) {
        kotlinx.coroutines.internal.o.a(i2);
        return new LimitedDispatcher(this, i2);
    }

    @Override // kotlin.p003y.ContinuationInterceptor
    public final void a(Continuation<?> continuation) {
        ((DispatchedContinuation) continuation).s();
    }

    @Override // kotlin.p003y.ContinuationInterceptor
    public final <T> Continuation<T> c(Continuation<? super T> continuation) {
        return new DispatchedContinuation(this, continuation);
    }

    @Override // kotlin.p003y.AbstractCoroutineContextElement, kotlin.p003y.CoroutineContext.b, kotlin.p003y.CoroutineContext
    public <E extends CoroutineContext.b> E get(CoroutineContext.c<E> cVar) {
        return (E) ContinuationInterceptor.a.a(this, cVar);
    }

    @Override // kotlin.p003y.AbstractCoroutineContextElement, kotlin.p003y.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.c<?> cVar) {
        return ContinuationInterceptor.a.b(this, cVar);
    }

    public String toString() {
        return t0.a(this) + '@' + t0.b(this);
    }
}
