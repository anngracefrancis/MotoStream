package kotlin.reflect.y.internal.j0.k;

/* JADX INFO: compiled from: SingleThreadValue.java */
/* JADX INFO: loaded from: classes3.dex */
class l<T> {
    private final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Thread f24671b = Thread.currentThread();

    l(T t) {
        this.a = t;
    }

    public T a() {
        if (b()) {
            return this.a;
        }
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }

    public boolean b() {
        return this.f24671b == Thread.currentThread();
    }
}
