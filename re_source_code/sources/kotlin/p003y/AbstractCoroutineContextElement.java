package kotlin.p003y;

import cm.aptoide.pt.database.room.RoomNotification;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;

/* JADX INFO: renamed from: kotlin.y.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", RoomNotification.KEY, "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)V", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AbstractCoroutineContextElement implements CoroutineContext.b {
    private final CoroutineContext.c<?> key;

    public AbstractCoroutineContextElement(CoroutineContext.c<?> cVar) {
        m.f(cVar, RoomNotification.KEY);
        this.key = cVar;
    }

    @Override // kotlin.p003y.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.b, ? extends R> function2) {
        return (R) CoroutineContext.b.a.a(this, r, function2);
    }

    @Override // kotlin.p003y.CoroutineContext.b, kotlin.p003y.CoroutineContext
    public <E extends CoroutineContext.b> E get(CoroutineContext.c<E> cVar) {
        return (E) CoroutineContext.b.a.b(this, cVar);
    }

    @Override // kotlin.p003y.CoroutineContext.b
    public CoroutineContext.c<?> getKey() {
        return this.key;
    }

    @Override // kotlin.p003y.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.c<?> cVar) {
        return CoroutineContext.b.a.c(this, cVar);
    }

    @Override // kotlin.p003y.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.b.a.d(this, coroutineContext);
    }
}
