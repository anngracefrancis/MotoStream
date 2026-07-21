package kotlinx.coroutines.rx2;

import h.a.t;
import kotlin.Metadata;
import kotlin.b;
import kotlin.p003y.CoroutineContext;
import kotlinx.coroutines.AbstractCoroutine;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.b3.g, reason: from Kotlin metadata */
/* JADX INFO: compiled from: RxSingle.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/rx2/RxSingleCoroutine;", "T", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/AbstractCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "subscriber", "Lio/reactivex/SingleEmitter;", "(Lkotlin/coroutines/CoroutineContext;Lio/reactivex/SingleEmitter;)V", "onCancelled", HttpUrl.FRAGMENT_ENCODE_SET, "cause", HttpUrl.FRAGMENT_ENCODE_SET, "handled", HttpUrl.FRAGMENT_ENCODE_SET, "onCompleted", "value", "(Ljava/lang/Object;)V", "kotlinx-coroutines-rx2"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class RxSingleCoroutine<T> extends AbstractCoroutine<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final t<T> f25653h;

    public RxSingleCoroutine(CoroutineContext coroutineContext, t<T> tVar) {
        super(coroutineContext, false, true);
        this.f25653h = tVar;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void D0(Throwable th, boolean z) {
        try {
            if (this.f25653h.c(th)) {
                return;
            }
        } catch (Throwable th2) {
            b.a(th, th2);
        }
        d.a(th, getL());
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void E0(T t) {
        try {
            this.f25653h.onSuccess(t);
        } catch (Throwable th) {
            d.a(th, getL());
        }
    }
}
