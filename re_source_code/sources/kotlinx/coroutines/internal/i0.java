package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.p003y.CoroutineContext;
import kotlinx.coroutines.ThreadContextElement;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ThreadContext.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0002\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\",\u0010\u0006\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"NO_THREAD_ELEMENTS", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "updateState", "Lkotlinx/coroutines/internal/ThreadState;", "restoreThreadContext", HttpUrl.FRAGMENT_ENCODE_SET, "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "threadContextElements", "updateThreadContext", "countOrElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class i0 {
    public static final Symbol a = new Symbol("NO_THREAD_ELEMENTS");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Function2<Object, CoroutineContext.b, Object> f25800b = a.f25803f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Function2<ThreadContextElement<?>, CoroutineContext.b, ThreadContextElement<?>> f25801c = b.f25804f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Function2<ThreadState, CoroutineContext.b, ThreadState> f25802d = c.f25805f;

    /* JADX INFO: compiled from: ThreadContext.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<no name provided>", HttpUrl.FRAGMENT_ENCODE_SET, "countOrElement", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends Lambda implements Function2<Object, CoroutineContext.b, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f25803f = new a();

        a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, CoroutineContext.b bVar) {
            if (!(bVar instanceof ThreadContextElement)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? bVar : Integer.valueOf(iIntValue + 1);
        }
    }

    /* JADX INFO: compiled from: ThreadContext.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<no name provided>", "Lkotlinx/coroutines/ThreadContextElement;", "found", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends Lambda implements Function2<ThreadContextElement<?>, CoroutineContext.b, ThreadContextElement<?>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f25804f = new b();

        b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ThreadContextElement<?> invoke(ThreadContextElement<?> threadContextElement, CoroutineContext.b bVar) {
            if (threadContextElement != null) {
                return threadContextElement;
            }
            if (bVar instanceof ThreadContextElement) {
                return (ThreadContextElement) bVar;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ThreadContext.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c extends Lambda implements Function2<ThreadState, CoroutineContext.b, ThreadState> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f25805f = new c();

        c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ThreadState invoke(ThreadState threadState, CoroutineContext.b bVar) {
            if (bVar instanceof ThreadContextElement) {
                ThreadContextElement<?> threadContextElement = (ThreadContextElement) bVar;
                threadState.a(threadContextElement, threadContextElement.I(threadState.a));
            }
            return threadState;
        }
    }

    public static final void a(CoroutineContext coroutineContext, Object obj) {
        if (obj == a) {
            return;
        }
        if (obj instanceof ThreadState) {
            ((ThreadState) obj).b(coroutineContext);
            return;
        }
        Object objFold = coroutineContext.fold(null, f25801c);
        if (objFold == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
        ((ThreadContextElement) objFold).z(coroutineContext, obj);
    }

    public static final Object b(CoroutineContext coroutineContext) {
        Object objFold = coroutineContext.fold(0, f25800b);
        kotlin.jvm.internal.m.c(objFold);
        return objFold;
    }

    public static final Object c(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = b(coroutineContext);
        }
        if (obj == 0) {
            return a;
        }
        return obj instanceof Integer ? coroutineContext.fold(new ThreadState(coroutineContext, ((Number) obj).intValue()), f25802d) : ((ThreadContextElement) obj).I(coroutineContext);
    }
}
