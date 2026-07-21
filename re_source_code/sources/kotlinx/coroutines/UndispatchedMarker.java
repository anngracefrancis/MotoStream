package kotlinx.coroutines;

import cm.aptoide.pt.database.room.RoomNotification;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.p003y.CoroutineContext;

/* JADX INFO: renamed from: kotlinx.coroutines.x2, reason: from Kotlin metadata */
/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/UndispatchedMarker;", "Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext$Key;", "()V", RoomNotification.KEY, "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class UndispatchedMarker implements CoroutineContext.b, CoroutineContext.c<UndispatchedMarker> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final UndispatchedMarker f25889f = new UndispatchedMarker();

    private UndispatchedMarker() {
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
        return this;
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
