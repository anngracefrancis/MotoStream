package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes.dex */
public abstract class Worker extends ListenableWorker {
    androidx.work.impl.utils.o.c<ListenableWorker.a> mFuture;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Worker.this.mFuture.q(Worker.this.doWork());
            } catch (Throwable th) {
                Worker.this.mFuture.r(th);
            }
        }
    }

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public abstract ListenableWorker.a doWork();

    @Override // androidx.work.ListenableWorker
    public final e.e.c.a.a.a<ListenableWorker.a> startWork() {
        this.mFuture = androidx.work.impl.utils.o.c.u();
        getBackgroundExecutor().execute(new a());
        return this.mFuture;
    }
}
