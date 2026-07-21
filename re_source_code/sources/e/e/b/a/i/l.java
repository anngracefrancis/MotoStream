package e.e.b.a.i;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ExecutionModule_ExecutorFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements e.e.b.a.i.x.a.b<Executor> {

    /* JADX INFO: compiled from: ExecutionModule_ExecutorFactory.java */
    private static final class a {
        private static final l a = new l();
    }

    public static l a() {
        return a.a;
    }

    public static Executor b() {
        return (Executor) e.e.b.a.i.x.a.d.c(k.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Executor get() {
        return b();
    }
}
