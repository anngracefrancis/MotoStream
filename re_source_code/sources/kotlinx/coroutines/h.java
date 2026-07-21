package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.p003y.Continuation;
import kotlin.p003y.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"kotlinx/coroutines/BuildersKt__BuildersKt", "kotlinx/coroutines/BuildersKt__Builders_commonKt"}, k = 4, mv = {1, 6, 0}, xi = 48)
public final class h {
    public static final Job a(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super kotlin.u>, ? extends Object> function2) {
        return j.a(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static final <T> T c(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        return (T) i.a(coroutineContext, function2);
    }

    public static final <T> Object e(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return j.c(coroutineContext, function2, continuation);
    }
}
