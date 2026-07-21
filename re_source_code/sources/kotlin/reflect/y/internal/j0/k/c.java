package kotlin.reflect.y.internal.j0.k;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.u;

/* JADX INFO: compiled from: locks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f24646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function1<InterruptedException, u> f24647d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(Lock lock, Runnable runnable, Function1<? super InterruptedException, u> function1) {
        super(lock);
        m.f(lock, "lock");
        m.f(runnable, "checkCancelled");
        m.f(function1, "interruptedExceptionHandler");
        this.f24646c = runnable;
        this.f24647d = function1;
    }

    @Override // kotlin.reflect.y.internal.j0.k.d, kotlin.reflect.y.internal.j0.k.k
    public void lock() {
        while (!a().tryLock(50L, TimeUnit.MILLISECONDS)) {
            try {
                this.f24646c.run();
            } catch (InterruptedException e2) {
                this.f24647d.invoke(e2);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Runnable runnable, Function1<? super InterruptedException, u> function1) {
        this(new ReentrantLock(), runnable, function1);
        m.f(runnable, "checkCancelled");
        m.f(function1, "interruptedExceptionHandler");
    }
}
