package kotlinx.coroutines.rx2;

import h.a.c;
import kotlin.Metadata;
import kotlin.b;
import kotlin.p003y.CoroutineContext;
import kotlin.u;
import kotlinx.coroutines.AbstractCoroutine;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.b3.e, reason: from Kotlin metadata */
/* JADX INFO: compiled from: RxCompletable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0014¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/rx2/RxCompletableCoroutine;", "Lkotlinx/coroutines/AbstractCoroutine;", HttpUrl.FRAGMENT_ENCODE_SET, "parentContext", "Lkotlin/coroutines/CoroutineContext;", "subscriber", "Lio/reactivex/CompletableEmitter;", "(Lkotlin/coroutines/CoroutineContext;Lio/reactivex/CompletableEmitter;)V", "onCancelled", "cause", HttpUrl.FRAGMENT_ENCODE_SET, "handled", HttpUrl.FRAGMENT_ENCODE_SET, "onCompleted", "value", "(Lkotlin/Unit;)V", "kotlinx-coroutines-rx2"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class RxCompletableCoroutine extends AbstractCoroutine<u> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final c f25652h;

    public RxCompletableCoroutine(CoroutineContext coroutineContext, c cVar) {
        super(coroutineContext, false, true);
        this.f25652h = cVar;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void D0(Throwable th, boolean z) {
        try {
            if (this.f25652h.c(th)) {
                return;
            }
        } catch (Throwable th2) {
            b.a(th, th2);
        }
        d.a(th, getL());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.AbstractCoroutine
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void E0(u uVar) {
        try {
            this.f25652h.a();
        } catch (Throwable th) {
            d.a(th, getL());
        }
    }
}
