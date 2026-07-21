package androidx.work;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: ListenableFuture.kt */
/* JADX INFO: loaded from: classes.dex */
public final class m<R> implements e.e.c.a.a.a<R> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Job f2652f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final androidx.work.impl.utils.o.c<R> f2653g;

    /* JADX INFO: compiled from: ListenableFuture.kt */
    static final class a extends Lambda implements Function1<Throwable, kotlin.u> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ m<R> f2654f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(m<R> mVar) {
            super(1);
            this.f2654f = mVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
            invoke2(th);
            return kotlin.u.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            if (th == null) {
                if (!((m) this.f2654f).f2653g.isDone()) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            } else {
                if (th instanceof CancellationException) {
                    ((m) this.f2654f).f2653g.cancel(true);
                    return;
                }
                androidx.work.impl.utils.o.c cVar = ((m) this.f2654f).f2653g;
                Throwable cause = th.getCause();
                if (cause != null) {
                    th = cause;
                }
                cVar.r(th);
            }
        }
    }

    public m(Job job, androidx.work.impl.utils.o.c<R> cVar) {
        kotlin.jvm.internal.m.f(job, "job");
        kotlin.jvm.internal.m.f(cVar, "underlying");
        this.f2652f = job;
        this.f2653g = cVar;
        job.m(new a(this));
    }

    public final void b(R r) {
        this.f2653g.q(r);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.f2653g.cancel(z);
    }

    @Override // e.e.c.a.a.a
    public void g(Runnable runnable, Executor executor) {
        this.f2653g.g(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public R get() {
        return this.f2653g.get();
    }

    @Override // java.util.concurrent.Future
    public R get(long j2, TimeUnit timeUnit) {
        return this.f2653g.get(j2, timeUnit);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f2653g.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f2653g.isDone();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ m(Job job, androidx.work.impl.utils.o.c cVar, int i2, kotlin.jvm.internal.g gVar) {
        if ((i2 & 2) != 0) {
            cVar = androidx.work.impl.utils.o.c.u();
            kotlin.jvm.internal.m.e(cVar, "create()");
        }
        this(job, cVar);
    }
}
