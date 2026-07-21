package kotlinx.coroutines;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DefaultExecutor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\b\u0010\u0006\u001a\u00020\u0001H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"DefaultDelay", "Lkotlinx/coroutines/Delay;", "getDefaultDelay", "()Lkotlinx/coroutines/Delay;", "defaultMainDelayOptIn", HttpUrl.FRAGMENT_ENCODE_SET, "initializeDefaultDelay", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class v0 {
    private static final boolean a = kotlinx.coroutines.internal.f0.e("kotlinx.coroutines.main.delay", false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Delay f25882b = b();

    public static final Delay a() {
        return f25882b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Delay b() {
        if (!a) {
            return DefaultExecutor.l;
        }
        MainCoroutineDispatcher mainCoroutineDispatcherC = Dispatchers.c();
        return (kotlinx.coroutines.internal.w.c(mainCoroutineDispatcherC) || !(mainCoroutineDispatcherC instanceof Delay)) ? DefaultExecutor.l : (Delay) mainCoroutineDispatcherC;
    }
}
