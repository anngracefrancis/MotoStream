package androidx.datastore.core;

/* JADX INFO: compiled from: SingleProcessDataStore.kt */
/* JADX INFO: loaded from: classes.dex */
final class b<T> extends m<T> {
    private final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f1128b;

    public b(T t, int i2) {
        super(null);
        this.a = t;
        this.f1128b = i2;
    }

    public final void a() {
        T t = this.a;
        if (!((t != null ? t.hashCode() : 0) == this.f1128b)) {
            throw new IllegalStateException("Data in DataStore was mutated but DataStore is only compatible with Immutable types.".toString());
        }
    }

    public final T b() {
        return this.a;
    }
}
