package c.i.h;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: RequestExecutor.java */
/* JADX INFO: loaded from: classes.dex */
class g {

    /* JADX INFO: compiled from: RequestExecutor.java */
    private static class a implements ThreadFactory {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f3238f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f3239g;

        /* JADX INFO: renamed from: c.i.h.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: RequestExecutor.java */
        private static class C0073a extends Thread {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final int f3240f;

            C0073a(Runnable runnable, String str, int i2) {
                super(runnable, str);
                this.f3240f = i2;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f3240f);
                super.run();
            }
        }

        a(String str, int i2) {
            this.f3238f = str;
            this.f3239g = i2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0073a(runnable, this.f3238f, this.f3239g);
        }
    }

    /* JADX INFO: compiled from: RequestExecutor.java */
    private static class b<T> implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Callable<T> f3241f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private c.i.j.a<T> f3242g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Handler f3243h;

        /* JADX INFO: compiled from: RequestExecutor.java */
        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ c.i.j.a f3244f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ Object f3245g;

            a(c.i.j.a aVar, Object obj) {
                this.f3244f = aVar;
                this.f3245g = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                this.f3244f.a(this.f3245g);
            }
        }

        b(Handler handler, Callable<T> callable, c.i.j.a<T> aVar) {
            this.f3241f = callable;
            this.f3242g = aVar;
            this.f3243h = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            T tCall;
            try {
                tCall = this.f3241f.call();
            } catch (Exception unused) {
                tCall = null;
            }
            this.f3243h.post(new a(this.f3242g, tCall));
        }
    }

    static ThreadPoolExecutor a(String str, int i2, int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i3, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i2));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static <T> void b(Executor executor, Callable<T> callable, c.i.j.a<T> aVar) {
        executor.execute(new b(c.i.h.b.a(), callable, aVar));
    }

    static <T> T c(ExecutorService executorService, Callable<T> callable, int i2) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i2, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            throw e2;
        } catch (ExecutionException e3) {
            throw new RuntimeException(e3);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
