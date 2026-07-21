package kotlin.p003y;

import cm.aptoide.pt.database.room.RoomNotification;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.y.e, reason: from Kotlin metadata */
/* JADX INFO: compiled from: ContinuationInterceptor.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ(\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0096\u0002¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\bH&J\u0014\u0010\u000b\u001a\u00020\f2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\u0014\u0010\r\u001a\u00020\u000e2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¨\u0006\u0010"}, d2 = {"Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/CoroutineContext$Element;", "get", "E", RoomNotification.KEY, "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "minusKey", "Lkotlin/coroutines/CoroutineContext;", "releaseInterceptedContinuation", HttpUrl.FRAGMENT_ENCODE_SET, "Key", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ContinuationInterceptor extends CoroutineContext.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f25606b = b.f25607f;

    /* JADX INFO: renamed from: kotlin.y.e$a */
    /* JADX INFO: compiled from: ContinuationInterceptor.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public static <E extends CoroutineContext.b> E a(ContinuationInterceptor continuationInterceptor, CoroutineContext.c<E> cVar) {
            m.f(cVar, RoomNotification.KEY);
            if (!(cVar instanceof AbstractCoroutineContextKey)) {
                if (ContinuationInterceptor.f25606b != cVar) {
                    return null;
                }
                m.d(continuationInterceptor, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return continuationInterceptor;
            }
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) cVar;
            if (!abstractCoroutineContextKey.a(continuationInterceptor.getKey())) {
                return null;
            }
            E e2 = (E) abstractCoroutineContextKey.b(continuationInterceptor);
            if (e2 instanceof CoroutineContext.b) {
                return e2;
            }
            return null;
        }

        public static CoroutineContext b(ContinuationInterceptor continuationInterceptor, CoroutineContext.c<?> cVar) {
            m.f(cVar, RoomNotification.KEY);
            if (!(cVar instanceof AbstractCoroutineContextKey)) {
                return ContinuationInterceptor.f25606b == cVar ? EmptyCoroutineContext.f25609f : continuationInterceptor;
            }
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) cVar;
            return (!abstractCoroutineContextKey.a(continuationInterceptor.getKey()) || abstractCoroutineContextKey.b(continuationInterceptor) == null) ? continuationInterceptor : EmptyCoroutineContext.f25609f;
        }
    }

    /* JADX INFO: renamed from: kotlin.y.e$b */
    /* JADX INFO: compiled from: ContinuationInterceptor.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/coroutines/ContinuationInterceptor$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements CoroutineContext.c<ContinuationInterceptor> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final /* synthetic */ b f25607f = new b();

        private b() {
        }
    }

    void a(Continuation<?> continuation);

    <T> Continuation<T> c(Continuation<? super T> continuation);
}
