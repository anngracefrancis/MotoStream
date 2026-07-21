package c.p.b;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ModernAsyncTask.java */
/* JADX INFO: loaded from: classes.dex */
abstract class c<Params, Progress, Result> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ThreadFactory f3376f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f3377g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Executor f3378h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static f f3379i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile Executor f3380j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final h<Params, Result> f3381k;
    private final FutureTask<Result> l;
    private volatile g m = g.PENDING;
    final AtomicBoolean n = new AtomicBoolean();
    final AtomicBoolean o = new AtomicBoolean();

    /* JADX INFO: compiled from: ModernAsyncTask.java */
    static class a implements ThreadFactory {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final AtomicInteger f3382f = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f3382f.getAndIncrement());
        }
    }

    /* JADX INFO: compiled from: ModernAsyncTask.java */
    class b extends h<Params, Result> {
        b() {
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            c.this.o.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = (Result) c.this.b(this.f3390f);
                Binder.flushPendingCommands();
                c.this.l(result);
                return result;
            } catch (Throwable th) {
                try {
                    c.this.n.set(true);
                    throw th;
                } catch (Throwable th2) {
                    c.this.l(result);
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: renamed from: c.p.b.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ModernAsyncTask.java */
    class C0087c extends FutureTask<Result> {
        C0087c(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                c.this.m(get());
            } catch (InterruptedException e2) {
                Log.w("AsyncTask", e2);
            } catch (CancellationException unused) {
                c.this.m(null);
            } catch (ExecutionException e3) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e3.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    }

    /* JADX INFO: compiled from: ModernAsyncTask.java */
    static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[g.values().length];
            a = iArr;
            try {
                iArr[g.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[g.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: ModernAsyncTask.java */
    private static class e<Data> {
        final c a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Data[] f3385b;

        e(c cVar, Data... dataArr) {
            this.a = cVar;
            this.f3385b = dataArr;
        }
    }

    /* JADX INFO: compiled from: ModernAsyncTask.java */
    private static class f extends Handler {
        f() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar = (e) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                eVar.a.d(eVar.f3385b[0]);
            } else {
                if (i2 != 2) {
                    return;
                }
                eVar.a.k(eVar.f3385b);
            }
        }
    }

    /* JADX INFO: compiled from: ModernAsyncTask.java */
    public enum g {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* JADX INFO: compiled from: ModernAsyncTask.java */
    private static abstract class h<Params, Result> implements Callable<Result> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Params[] f3390f;

        h() {
        }
    }

    static {
        a aVar = new a();
        f3376f = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        f3377g = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        f3378h = threadPoolExecutor;
        f3380j = threadPoolExecutor;
    }

    c() {
        b bVar = new b();
        this.f3381k = bVar;
        this.l = new C0087c(bVar);
    }

    private static Handler e() {
        f fVar;
        synchronized (c.class) {
            if (f3379i == null) {
                f3379i = new f();
            }
            fVar = f3379i;
        }
        return fVar;
    }

    public final boolean a(boolean z) {
        this.n.set(true);
        return this.l.cancel(z);
    }

    protected abstract Result b(Params... paramsArr);

    public final c<Params, Progress, Result> c(Executor executor, Params... paramsArr) {
        if (this.m == g.PENDING) {
            this.m = g.RUNNING;
            j();
            this.f3381k.f3390f = paramsArr;
            executor.execute(this.l);
            return this;
        }
        int i2 = d.a[this.m.ordinal()];
        if (i2 == 1) {
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        if (i2 != 2) {
            throw new IllegalStateException("We should never reach this state");
        }
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }

    void d(Result result) {
        if (f()) {
            h(result);
        } else {
            i(result);
        }
        this.m = g.FINISHED;
    }

    public final boolean f() {
        return this.n.get();
    }

    protected void g() {
    }

    protected void h(Result result) {
        g();
    }

    protected void i(Result result) {
    }

    protected void j() {
    }

    protected void k(Progress... progressArr) {
    }

    Result l(Result result) {
        e().obtainMessage(1, new e(this, result)).sendToTarget();
        return result;
    }

    void m(Result result) {
        if (this.o.get()) {
            return;
        }
        l(result);
    }
}
