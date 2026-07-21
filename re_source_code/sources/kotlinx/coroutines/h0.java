package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.p003y.Continuation;
import kotlin.p003y.ContinuationInterceptor;
import kotlin.p003y.CoroutineContext;
import kotlin.p003y.EmptyCoroutineContext;
import kotlin.p003y.j.p004a.CoroutineStackFrame;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002\u001a8\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\f0\u0012H\u0080\b¢\u0006\u0002\u0010\u0013\u001a4\u0010\u0014\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\f0\u0012H\u0080\b¢\u0006\u0002\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\n*\u00020\u0003H\u0002\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0003H\u0007\u001a\u0013\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c*\u00020\u001dH\u0080\u0010\u001a(\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006 "}, d2 = {"DEBUG_THREAD_NAME_SEPARATOR", HttpUrl.FRAGMENT_ENCODE_SET, "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "foldCopies", "originalContext", "appendContext", "isNewCoroutine", HttpUrl.FRAGMENT_ENCODE_SET, "withContinuationContext", "T", "continuation", "Lkotlin/coroutines/Continuation;", "countOrElement", HttpUrl.FRAGMENT_ENCODE_SET, "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withCoroutineContext", "context", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hasCopyableElements", "newCoroutineContext", "addedContext", "Lkotlinx/coroutines/CoroutineScope;", "undispatchedCompletion", "Lkotlinx/coroutines/UndispatchedCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "updateUndispatchedCompletion", "oldValue", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class h0 {

    /* JADX INFO: compiled from: CoroutineContext.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "result", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends Lambda implements Function2<CoroutineContext, CoroutineContext.b, CoroutineContext> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f25778f = new a();

        a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CoroutineContext invoke(CoroutineContext coroutineContext, CoroutineContext.b bVar) {
            return bVar instanceof CopyableThreadContextElement ? coroutineContext.plus(((CopyableThreadContextElement) bVar).p()) : coroutineContext.plus(bVar);
        }
    }

    /* JADX INFO: compiled from: CoroutineContext.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "result", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends Lambda implements Function2<CoroutineContext, CoroutineContext.b, CoroutineContext> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.f0<CoroutineContext> f25779f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f25780g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlin.jvm.internal.f0<CoroutineContext> f0Var, boolean z) {
            super(2);
            this.f25779f = f0Var;
            this.f25780g = z;
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [T, kotlin.y.g] */
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CoroutineContext invoke(CoroutineContext coroutineContext, CoroutineContext.b bVar) {
            if (!(bVar instanceof CopyableThreadContextElement)) {
                return coroutineContext.plus(bVar);
            }
            CoroutineContext.b bVar2 = this.f25779f.f22943f.get(bVar.getKey());
            if (bVar2 != null) {
                kotlin.jvm.internal.f0<CoroutineContext> f0Var = this.f25779f;
                f0Var.f22943f = f0Var.f22943f.minusKey(bVar.getKey());
                return coroutineContext.plus(((CopyableThreadContextElement) bVar).d(bVar2));
            }
            CopyableThreadContextElement copyableThreadContextElementP = (CopyableThreadContextElement) bVar;
            if (this.f25780g) {
                copyableThreadContextElementP = copyableThreadContextElementP.p();
            }
            return coroutineContext.plus(copyableThreadContextElementP);
        }
    }

    /* JADX INFO: compiled from: CoroutineContext.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "result", "it", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(ZLkotlin/coroutines/CoroutineContext$Element;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c extends Lambda implements Function2<Boolean, CoroutineContext.b, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f25781f = new c();

        c() {
            super(2);
        }

        public final Boolean b(boolean z, CoroutineContext.b bVar) {
            return Boolean.valueOf(z || (bVar instanceof CopyableThreadContextElement));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool, CoroutineContext.b bVar) {
            return b(bool.booleanValue(), bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    private static final CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, boolean z) {
        boolean zC = c(coroutineContext);
        boolean zC2 = c(coroutineContext2);
        if (!zC && !zC2) {
            return coroutineContext.plus(coroutineContext2);
        }
        kotlin.jvm.internal.f0 f0Var = new kotlin.jvm.internal.f0();
        f0Var.f22943f = coroutineContext2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f25609f;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.fold(emptyCoroutineContext, new b(f0Var, z));
        if (zC2) {
            f0Var.f22943f = ((CoroutineContext) f0Var.f22943f).fold(emptyCoroutineContext, a.f25778f);
        }
        return coroutineContext3.plus((CoroutineContext) f0Var.f22943f);
    }

    public static final String b(CoroutineContext coroutineContext) {
        CoroutineId coroutineId;
        String f25857g;
        if (!s0.c() || (coroutineId = (CoroutineId) coroutineContext.get(CoroutineId.f25853f)) == null) {
            return null;
        }
        CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.f25856f);
        if (coroutineName == null || (f25857g = coroutineName.getF25857g()) == null) {
            f25857g = "coroutine";
        }
        return f25857g + '#' + coroutineId.getF25854g();
    }

    private static final boolean c(CoroutineContext coroutineContext) {
        return ((Boolean) coroutineContext.fold(Boolean.FALSE, c.f25781f)).booleanValue();
    }

    public static final CoroutineContext d(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
        return !c(coroutineContext2) ? coroutineContext.plus(coroutineContext2) : a(coroutineContext, coroutineContext2, false);
    }

    public static final CoroutineContext e(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        CoroutineContext coroutineContextA = a(coroutineScope.getF25795f(), coroutineContext, true);
        CoroutineContext coroutineContextPlus = s0.c() ? coroutineContextA.plus(new CoroutineId(s0.b().incrementAndGet())) : coroutineContextA;
        return (coroutineContextA == Dispatchers.a() || coroutineContextA.get(ContinuationInterceptor.f25606b) != null) ? coroutineContextPlus : coroutineContextPlus.plus(Dispatchers.a());
    }

    public static final UndispatchedCoroutine<?> f(CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof DispatchedCoroutine) && (coroutineStackFrame = coroutineStackFrame.getCallerFrame()) != null) {
            if (coroutineStackFrame instanceof UndispatchedCoroutine) {
                return (UndispatchedCoroutine) coroutineStackFrame;
            }
        }
        return null;
    }

    public static final UndispatchedCoroutine<?> g(Continuation<?> continuation, CoroutineContext coroutineContext, Object obj) {
        if (!(continuation instanceof CoroutineStackFrame)) {
            return null;
        }
        if (!(coroutineContext.get(UndispatchedMarker.f25889f) != null)) {
            return null;
        }
        UndispatchedCoroutine<?> undispatchedCoroutineF = f((CoroutineStackFrame) continuation);
        if (undispatchedCoroutineF != null) {
            undispatchedCoroutineF.I0(coroutineContext, obj);
        }
        return undispatchedCoroutineF;
    }
}
