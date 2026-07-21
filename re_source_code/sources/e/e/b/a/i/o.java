package e.e.b.a.i;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SafeLoggingExecutor.java */
/* JADX INFO: loaded from: classes2.dex */
class o implements Executor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Executor f20839f;

    /* JADX INFO: compiled from: SafeLoggingExecutor.java */
    static class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Runnable f20840f;

        a(Runnable runnable) {
            this.f20840f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f20840f.run();
            } catch (Exception e2) {
                e.e.b.a.i.z.a.d("Executor", "Background execution failure.", e2);
            }
        }
    }

    o(Executor executor) {
        this.f20839f = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f20839f.execute(new a(runnable));
    }
}
