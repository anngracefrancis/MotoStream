package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.l0;
import kotlin.p003y.Continuation;
import kotlin.u;
import kotlinx.coroutines.p005z2.FlowCollector;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SafeCollector.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\">\u0010\u0000\u001a,\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"emitFun", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/coroutines/Continuation;", HttpUrl.FRAGMENT_ENCODE_SET, "getEmitFun$annotations", "()V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class i {
    private static final Function3<FlowCollector<Object>, Object, Continuation<? super u>, Object> a = (Function3) l0.e(a.f25769h, 3);

    /* JADX INFO: compiled from: SafeCollector.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* synthetic */ class a extends kotlin.jvm.internal.j implements Function3<FlowCollector<? super Object>, Object, Continuation<? super u>, Object> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f25769h = new a();

        a() {
            super(3, FlowCollector.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public final Object d(FlowCollector<Object> flowCollector, Object obj, Continuation<? super u> continuation) {
            return flowCollector.c(obj, continuation);
        }
    }
}
