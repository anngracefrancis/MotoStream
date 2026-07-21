package androidx.work.impl.utils.o;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: DirectExecutor.java */
/* JADX INFO: loaded from: classes.dex */
enum b implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "DirectExecutor";
    }
}
