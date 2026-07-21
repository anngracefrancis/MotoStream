package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.MainCoroutineDispatcher;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.internal.v, reason: from Kotlin metadata */
/* JADX INFO: compiled from: MainDispatchers.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/internal/MainDispatcherLoader;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "FAST_SERVICE_LOADER_ENABLED", HttpUrl.FRAGMENT_ENCODE_SET, "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "loadMainDispatcher", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MainDispatcherLoader {
    public static final MainDispatcherLoader a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f25835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MainCoroutineDispatcher f25836c;

    static {
        MainDispatcherLoader mainDispatcherLoader = new MainDispatcherLoader();
        a = mainDispatcherLoader;
        f25835b = f0.e("kotlinx.coroutines.fast.service.loader", true);
        f25836c = mainDispatcherLoader.a();
    }

    private MainDispatcherLoader() {
    }

    private final MainCoroutineDispatcher a() {
        Object next;
        MainCoroutineDispatcher mainCoroutineDispatcherE;
        try {
            List<MainDispatcherFactory> listC = f25835b ? FastServiceLoader.a.c() : kotlin.sequences.n.A(kotlin.sequences.l.a(defpackage.a.b()));
            Iterator<T> it = listC.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) next;
            return (mainDispatcherFactory == null || (mainCoroutineDispatcherE = w.e(mainDispatcherFactory, listC)) == null) ? w.b(null, null, 3, null) : mainCoroutineDispatcherE;
        } catch (Throwable th) {
            return w.b(th, null, 2, null);
        }
    }
}
