package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.p003y.CoroutineContext;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.ScopeCoroutine;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SafeCollector.common.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022/\b\u0005\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\tH\u0081\bø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0018\u0010\u000b\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00020\u000eH\u0001\u001a\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0080\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"unsafeFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "checkContext", "Lkotlinx/coroutines/flow/internal/SafeCollector;", "currentContext", "Lkotlin/coroutines/CoroutineContext;", "transitiveCoroutineParent", "Lkotlinx/coroutines/Job;", "collectJob", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class j {

    /* JADX INFO: compiled from: SafeCollector.common.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "count", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(ILkotlin/coroutines/CoroutineContext$Element;)Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends Lambda implements Function2<Integer, CoroutineContext.b, Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ SafeCollector<?> f25770f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(SafeCollector<?> safeCollector) {
            super(2);
            this.f25770f = safeCollector;
        }

        public final Integer b(int i2, CoroutineContext.b bVar) {
            CoroutineContext.c<?> key = bVar.getKey();
            CoroutineContext.b bVar2 = this.f25770f.f25764g.get(key);
            if (key != Job.f25890e) {
                return Integer.valueOf(bVar != bVar2 ? Integer.MIN_VALUE : i2 + 1);
            }
            Job job = (Job) bVar2;
            Job jobB = j.b((Job) bVar, job);
            if (jobB == job) {
                if (job != null) {
                    i2++;
                }
                return Integer.valueOf(i2);
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + jobB + ", expected child of " + job + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, CoroutineContext.b bVar) {
            return b(num.intValue(), bVar);
        }
    }

    public static final void a(SafeCollector<?> safeCollector, CoroutineContext coroutineContext) {
        if (((Number) coroutineContext.fold(0, new a(safeCollector))).intValue() == safeCollector.f25765h) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.f25764g + ",\n\t\tbut emission happened in " + coroutineContext + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final Job b(Job job, Job job2) {
        while (job != null) {
            if (job == job2 || !(job instanceof ScopeCoroutine)) {
                return job;
            }
            job = ((ScopeCoroutine) job).G0();
        }
        return null;
    }
}
