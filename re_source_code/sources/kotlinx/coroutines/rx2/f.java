package kotlinx.coroutines.rx2;

import h.a.b;
import h.a.c;
import h.a.e;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.p003y.Continuation;
import kotlin.p003y.CoroutineContext;
import kotlin.p003y.EmptyCoroutineContext;
import kotlin.u;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.h0;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: RxCompletable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aA\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\b\nø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001aI\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\b\nH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001aG\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u00032'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"rxCompletable", "Lio/reactivex/Completable;", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lio/reactivex/Completable;", "rxCompletableInternal", "scope", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lio/reactivex/Completable;", "kotlinx-coroutines-rx2"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class f {
    public static final b b(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super u>, ? extends Object> function2) {
        if (coroutineContext.get(Job.f25890e) == null) {
            return d(GlobalScope.f25874f, coroutineContext, function2);
        }
        throw new IllegalArgumentException(("Completable context cannot contain job in it. Its lifecycle should be managed via Disposable handle. Had " + coroutineContext).toString());
    }

    public static /* synthetic */ b c(CoroutineContext coroutineContext, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f25609f;
        }
        return b(coroutineContext, function2);
    }

    private static final b d(final CoroutineScope coroutineScope, final CoroutineContext coroutineContext, final Function2<? super CoroutineScope, ? super Continuation<? super u>, ? extends Object> function2) {
        return b.c(new e() { // from class: kotlinx.coroutines.b3.a
            @Override // h.a.e
            public final void a(c cVar) {
                f.e(coroutineScope, coroutineContext, function2, cVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2, c cVar) {
        RxCompletableCoroutine rxCompletableCoroutine = new RxCompletableCoroutine(h0.e(coroutineScope, coroutineContext), cVar);
        cVar.b(new RxCancellable(rxCompletableCoroutine));
        rxCompletableCoroutine.F0(CoroutineStart.DEFAULT, rxCompletableCoroutine, function2);
    }
}
