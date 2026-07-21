package kotlinx.coroutines;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.p003y.AbstractCoroutineContextKey;
import kotlin.p003y.CoroutineContext;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.o1, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000 \n2\u00020\u00012\u00020\u0002:\u0001\nB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/io/Closeable;", "()V", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "close", HttpUrl.FRAGMENT_ENCODE_SET, "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f25862g = new a(null);

    /* JADX INFO: renamed from: kotlinx.coroutines.o1$a */
    /* JADX INFO: compiled from: Executors.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends AbstractCoroutineContextKey<CoroutineDispatcher, ExecutorCoroutineDispatcher> {

        /* JADX INFO: renamed from: kotlinx.coroutines.o1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Executors.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "it", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class C0424a extends Lambda implements Function1<CoroutineContext.b, ExecutorCoroutineDispatcher> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final C0424a f25863f = new C0424a();

            C0424a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ExecutorCoroutineDispatcher invoke(CoroutineContext.b bVar) {
                if (bVar instanceof ExecutorCoroutineDispatcher) {
                    return (ExecutorCoroutineDispatcher) bVar;
                }
                return null;
            }
        }

        private a() {
            super(CoroutineDispatcher.f25784f, C0424a.f25863f);
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }
}
