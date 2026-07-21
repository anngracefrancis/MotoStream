package kotlinx.coroutines.p005z2;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.p003y.Continuation;
import kotlin.u;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt", "kotlinx/coroutines/flow/FlowKt__ChannelsKt", "kotlinx/coroutines/flow/FlowKt__CollectKt", "kotlinx/coroutines/flow/FlowKt__CollectionKt", "kotlinx/coroutines/flow/FlowKt__ContextKt", "kotlinx/coroutines/flow/FlowKt__CountKt", "kotlinx/coroutines/flow/FlowKt__DelayKt", "kotlinx/coroutines/flow/FlowKt__DistinctKt", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__MigrationKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/FlowKt__ShareKt", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, k = 4, mv = {1, 6, 0}, xi = 48)
public final class d {
    public static final <T> Flow<T> a(Flow<? extends T> flow, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super u>, ? extends Object> function3) {
        return h.a(flow, function3);
    }

    public static final <T> Object b(Flow<? extends T> flow, FlowCollector<? super T> flowCollector, Continuation<? super Throwable> continuation) {
        return h.b(flow, flowCollector, continuation);
    }

    public static final <T> Flow<T> c(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return i.a(flow, function2);
    }

    public static final <T> Object d(FlowCollector<? super T> flowCollector, Flow<? extends T> flow, Continuation<? super u> continuation) {
        return f.a(flowCollector, flow, continuation);
    }

    public static final void e(FlowCollector<?> flowCollector) {
        g.a(flowCollector);
    }

    public static final <T> Object f(Flow<? extends T> flow, Continuation<? super T> continuation) {
        return j.a(flow, continuation);
    }

    public static final <T> Flow<T> g(Function2<? super FlowCollector<? super T>, ? super Continuation<? super u>, ? extends Object> function2) {
        return e.a(function2);
    }
}
