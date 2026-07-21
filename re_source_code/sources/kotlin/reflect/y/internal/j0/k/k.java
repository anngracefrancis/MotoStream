package kotlin.reflect.y.internal.j0.k;

import kotlin.jvm.functions.Function1;
import kotlin.u;

/* JADX INFO: compiled from: locks.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface k {
    public static final a a = a.a;

    /* JADX INFO: compiled from: locks.kt */
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }

        public final d a(Runnable runnable, Function1<? super InterruptedException, u> function1) {
            return (runnable == null || function1 == null) ? new d(null, 1, null) : new c(runnable, function1);
        }
    }

    void lock();

    void unlock();
}
