package c.b.a.a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: DefaultTaskExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends c {
    private final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExecutorService f2846b = Executors.newFixedThreadPool(4, new a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Handler f2847c;

    /* JADX INFO: compiled from: DefaultTaskExecutor.java */
    class a implements ThreadFactory {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final AtomicInteger f2848f = new AtomicInteger(0);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.f2848f.getAndIncrement())));
            return thread;
        }
    }

    private static Handler d(Looper looper) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return Handler.createAsync(looper);
        }
        if (i2 >= 16) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            } catch (InvocationTargetException unused2) {
                return new Handler(looper);
            }
        }
        return new Handler(looper);
    }

    @Override // c.b.a.a.c
    public void a(Runnable runnable) {
        this.f2846b.execute(runnable);
    }

    @Override // c.b.a.a.c
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // c.b.a.a.c
    public void c(Runnable runnable) {
        if (this.f2847c == null) {
            synchronized (this.a) {
                if (this.f2847c == null) {
                    this.f2847c = d(Looper.getMainLooper());
                }
            }
        }
        this.f2847c.post(runnable);
    }
}
