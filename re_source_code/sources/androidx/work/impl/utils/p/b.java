package androidx.work.impl.utils.p;

import android.os.Handler;
import android.os.Looper;
import androidx.work.impl.utils.g;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: WorkManagerTaskExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements androidx.work.impl.utils.p.a {
    private final g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f2640b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f2641c = new a();

    /* JADX INFO: compiled from: WorkManagerTaskExecutor.java */
    class a implements Executor {
        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            b.this.d(runnable);
        }
    }

    public b(Executor executor) {
        this.a = new g(executor);
    }

    @Override // androidx.work.impl.utils.p.a
    public Executor a() {
        return this.f2641c;
    }

    @Override // androidx.work.impl.utils.p.a
    public void b(Runnable runnable) {
        this.a.execute(runnable);
    }

    @Override // androidx.work.impl.utils.p.a
    public g c() {
        return this.a;
    }

    public void d(Runnable runnable) {
        this.f2640b.post(runnable);
    }
}
