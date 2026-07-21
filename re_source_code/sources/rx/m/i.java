package rx.m;

/* JADX INFO: compiled from: Functions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: compiled from: Functions.java */
    static class a<R> implements h<R> {
        final /* synthetic */ f a;

        a(f fVar) {
            this.a = fVar;
        }

        @Override // rx.m.h
        public R call(Object... objArr) {
            if (objArr.length == 2) {
                return (R) this.a.a(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Func2 expecting 2 arguments.");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: compiled from: Functions.java */
    static class b<R> implements h<R> {
        final /* synthetic */ g a;

        b(g gVar) {
            this.a = gVar;
        }

        @Override // rx.m.h
        public R call(Object... objArr) {
            if (objArr.length == 3) {
                return (R) this.a.a(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Func3 expecting 3 arguments.");
        }
    }

    public static <T0, T1, R> h<R> a(f<? super T0, ? super T1, ? extends R> fVar) {
        return new a(fVar);
    }

    public static <T0, T1, T2, R> h<R> b(g<? super T0, ? super T1, ? super T2, ? extends R> gVar) {
        return new b(gVar);
    }
}
