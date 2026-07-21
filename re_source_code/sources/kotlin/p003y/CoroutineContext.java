package kotlin.p003y;

import cm.aptoide.pt.database.room.RoomNotification;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.y.g, reason: from Kotlin metadata */
/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH¦\u0002¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u00002\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH&J\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002¨\u0006\u0013"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", HttpUrl.FRAGMENT_ENCODE_SET, "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", RoomNotification.KEY, "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "plus", "context", "Element", "Key", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface CoroutineContext {

    /* JADX INFO: renamed from: kotlin.y.g$a */
    /* JADX INFO: compiled from: CoroutineContext.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: kotlin.y.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CoroutineContext.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class C0420a extends Lambda implements Function2<CoroutineContext, b, CoroutineContext> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final C0420a f25608f = new C0420a();

            C0420a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CoroutineContext invoke(CoroutineContext coroutineContext, b bVar) {
                CombinedContext combinedContext;
                m.f(coroutineContext, "acc");
                m.f(bVar, "element");
                CoroutineContext coroutineContextMinusKey = coroutineContext.minusKey(bVar.getKey());
                EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f25609f;
                if (coroutineContextMinusKey == emptyCoroutineContext) {
                    return bVar;
                }
                ContinuationInterceptor.b bVar2 = ContinuationInterceptor.f25606b;
                ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContextMinusKey.get(bVar2);
                if (continuationInterceptor == null) {
                    combinedContext = new CombinedContext(coroutineContextMinusKey, bVar);
                } else {
                    CoroutineContext coroutineContextMinusKey2 = coroutineContextMinusKey.minusKey(bVar2);
                    if (coroutineContextMinusKey2 == emptyCoroutineContext) {
                        return new CombinedContext(bVar, continuationInterceptor);
                    }
                    combinedContext = new CombinedContext(new CombinedContext(coroutineContextMinusKey2, bVar), continuationInterceptor);
                }
                return combinedContext;
            }
        }

        public static CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
            m.f(coroutineContext2, "context");
            return coroutineContext2 == EmptyCoroutineContext.f25609f ? coroutineContext : (CoroutineContext) coroutineContext2.fold(coroutineContext, C0420a.f25608f);
        }
    }

    /* JADX INFO: renamed from: kotlin.y.g$b */
    /* JADX INFO: compiled from: CoroutineContext.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J5\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u0002H\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\r0\u0003H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016R\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2 = {"Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", RoomNotification.KEY, "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface b extends CoroutineContext {

        /* JADX INFO: renamed from: kotlin.y.g$b$a */
        /* JADX INFO: compiled from: CoroutineContext.kt */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a {
            public static <R> R a(b bVar, R r, Function2<? super R, ? super b, ? extends R> function2) {
                m.f(function2, "operation");
                return function2.invoke(r, bVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends b> E b(b bVar, c<E> cVar) {
                m.f(cVar, RoomNotification.KEY);
                if (!m.a(bVar.getKey(), cVar)) {
                    return null;
                }
                m.d(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            public static CoroutineContext c(b bVar, c<?> cVar) {
                m.f(cVar, RoomNotification.KEY);
                return m.a(bVar.getKey(), cVar) ? EmptyCoroutineContext.f25609f : bVar;
            }

            public static CoroutineContext d(b bVar, CoroutineContext coroutineContext) {
                m.f(coroutineContext, "context");
                return a.a(bVar, coroutineContext);
            }
        }

        @Override // kotlin.p003y.CoroutineContext
        <E extends b> E get(c<E> cVar);

        c<?> getKey();
    }

    /* JADX INFO: renamed from: kotlin.y.g$c */
    /* JADX INFO: compiled from: CoroutineContext.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/coroutines/CoroutineContext$Key;", "E", "Lkotlin/coroutines/CoroutineContext$Element;", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface c<E extends b> {
    }

    <R> R fold(R r, Function2<? super R, ? super b, ? extends R> function2);

    <E extends b> E get(c<E> cVar);

    CoroutineContext minusKey(c<?> cVar);

    CoroutineContext plus(CoroutineContext coroutineContext);
}
