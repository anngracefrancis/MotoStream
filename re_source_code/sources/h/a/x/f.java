package h.a.x;

/* JADX INFO: compiled from: RunnableDisposable.java */
/* JADX INFO: loaded from: classes2.dex */
final class f extends e<Runnable> {
    f(Runnable runnable) {
        super(runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h.a.x.e
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(Runnable runnable) {
        runnable.run();
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "RunnableDisposable(disposed=" + q() + ", " + get() + ")";
    }
}
