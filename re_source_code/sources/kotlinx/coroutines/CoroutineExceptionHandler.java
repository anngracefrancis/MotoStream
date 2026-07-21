package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.p003y.CoroutineContext;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.j0, reason: from Kotlin metadata */
/* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext$Element;", "handleException", HttpUrl.FRAGMENT_ENCODE_SET, "context", "Lkotlin/coroutines/CoroutineContext;", "exception", HttpUrl.FRAGMENT_ENCODE_SET, "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CoroutineExceptionHandler extends CoroutineContext.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f25842d = a.f25843f;

    /* JADX INFO: renamed from: kotlinx.coroutines.j0$a */
    /* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements CoroutineContext.c<CoroutineExceptionHandler> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final /* synthetic */ a f25843f = new a();

        private a() {
        }
    }

    void handleException(CoroutineContext coroutineContext, Throwable th);
}
