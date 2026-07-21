package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.p003y.CoroutineContext;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: OnUndeliveredElement.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aI\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0004*\u0018\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\u0010\t\u001a=\u0010\n\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\u0018\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\u0010\u000b\u001aC\u0010\f\u001a\u0004\u0018\u00010\r\"\u0004\b\u0000\u0010\u0004*\u0018\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0002\u0010\u000f**\b\u0000\u0010\u0010\u001a\u0004\b\u0000\u0010\u0004\"\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u00012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0011"}, d2 = {"bindCancellationFun", "Lkotlin/Function1;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "E", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "element", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)Lkotlin/jvm/functions/Function1;", "callUndeliveredElement", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", "callUndeliveredElementCatchingException", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "undeliveredElementException", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlinx/coroutines/internal/UndeliveredElementException;)Lkotlinx/coroutines/internal/UndeliveredElementException;", "OnUndeliveredElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class y {

    /* JADX INFO: compiled from: OnUndeliveredElement.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "E", "<anonymous parameter 0>", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends Lambda implements Function1<Throwable, kotlin.u> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1<E, kotlin.u> f25839f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ E f25840g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ CoroutineContext f25841h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super E, kotlin.u> function1, E e2, CoroutineContext coroutineContext) {
            super(1);
            this.f25839f = function1;
            this.f25840g = e2;
            this.f25841h = coroutineContext;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
            invoke2(th);
            return kotlin.u.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            y.b(this.f25839f, this.f25840g, this.f25841h);
        }
    }

    public static final <E> Function1<Throwable, kotlin.u> a(Function1<? super E, kotlin.u> function1, E e2, CoroutineContext coroutineContext) {
        return new a(function1, e2, coroutineContext);
    }

    public static final <E> void b(Function1<? super E, kotlin.u> function1, E e2, CoroutineContext coroutineContext) {
        UndeliveredElementException undeliveredElementExceptionC = c(function1, e2, null);
        if (undeliveredElementExceptionC != null) {
            kotlinx.coroutines.l0.a(coroutineContext, undeliveredElementExceptionC);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> UndeliveredElementException c(Function1<? super E, kotlin.u> function1, E e2, UndeliveredElementException undeliveredElementException) {
        try {
            function1.invoke(e2);
        } catch (Throwable th) {
            if (undeliveredElementException == null || undeliveredElementException.getCause() == th) {
                return new UndeliveredElementException("Exception in undelivered element handler for " + e2, th);
            }
            kotlin.b.a(undeliveredElementException, th);
        }
        return undeliveredElementException;
    }

    public static /* synthetic */ UndeliveredElementException d(Function1 function1, Object obj, UndeliveredElementException undeliveredElementException, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            undeliveredElementException = null;
        }
        return c(function1, obj, undeliveredElementException);
    }
}
