package rx.m;

/* JADX INFO: compiled from: Actions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final b a = new b();

    /* JADX INFO: compiled from: Actions.java */
    static final class a<T> implements rx.m.b<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final rx.m.a f26105f;

        public a(rx.m.a aVar) {
            this.f26105f = aVar;
        }

        @Override // rx.m.b
        public void call(T t) {
            this.f26105f.call();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: compiled from: Actions.java */
    public static final class b<T0, T1, T2, T3, T4, T5, T6, T7, T8> implements rx.m.a, rx.m.b<T0> {
        b() {
        }

        @Override // rx.m.a
        public void call() {
        }

        @Override // rx.m.b
        public void call(T0 t0) {
        }
    }

    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8> b<T0, T1, T2, T3, T4, T5, T6, T7, T8> a() {
        return a;
    }

    public static <T> rx.m.b<T> b(rx.m.a aVar) {
        return new a(aVar);
    }
}
