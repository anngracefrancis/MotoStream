package kotlinx.coroutines;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: EventLoop.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\u0019\u0010\u0002\u001a\u00020\u00032\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0080\b\u001a\b\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"createEventLoop", "Lkotlinx/coroutines/EventLoop;", "platformAutoreleasePool", HttpUrl.FRAGMENT_ENCODE_SET, "block", "Lkotlin/Function0;", "processNextEventInCurrentThread", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class l1 {
    public static final EventLoop a() {
        return new BlockingEventLoop(Thread.currentThread());
    }
}
