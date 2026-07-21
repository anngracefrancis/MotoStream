package kotlinx.coroutines.rx2;

import h.a.a0.a;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.b;
import kotlin.p003y.CoroutineContext;
import kotlinx.coroutines.l0;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: RxCancellable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"handleUndeliverableException", HttpUrl.FRAGMENT_ENCODE_SET, "cause", HttpUrl.FRAGMENT_ENCODE_SET, "context", "Lkotlin/coroutines/CoroutineContext;", "kotlinx-coroutines-rx2"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class d {
    public static final void a(Throwable th, CoroutineContext coroutineContext) {
        if (th instanceof CancellationException) {
            return;
        }
        try {
            a.o(th);
        } catch (Throwable th2) {
            b.a(th, th2);
            l0.a(coroutineContext, th);
        }
    }
}
