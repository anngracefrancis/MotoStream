package androidx.room;

import h.a.s;
import h.a.t;
import h.a.v;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: RxRoom.java */
/* JADX INFO: loaded from: classes.dex */
public class n {
    public static final Object a = new Object();

    /* JADX INFO: compiled from: RxRoom.java */
    static class a implements h.a.o<Object> {
        final /* synthetic */ String[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f2191b;

        /* JADX INFO: renamed from: androidx.room.n$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: RxRoom.java */
        class C0046a extends g.c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ h.a.n f2192b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0046a(String[] strArr, h.a.n nVar) {
                super(strArr);
                this.f2192b = nVar;
            }

            @Override // androidx.room.g.c
            public void b(Set<String> set) {
                this.f2192b.onNext(n.a);
            }
        }

        /* JADX INFO: compiled from: RxRoom.java */
        class b implements h.a.y.a {
            final /* synthetic */ g.c a;

            b(g.c cVar) {
                this.a = cVar;
            }

            @Override // h.a.y.a
            public void run() throws Exception {
                a.this.f2191b.getInvalidationTracker().g(this.a);
            }
        }

        a(String[] strArr, j jVar) {
            this.a = strArr;
            this.f2191b = jVar;
        }

        @Override // h.a.o
        public void a(h.a.n<Object> nVar) throws Exception {
            C0046a c0046a = new C0046a(this.a, nVar);
            this.f2191b.getInvalidationTracker().a(c0046a);
            nVar.a(h.a.x.d.c(new b(c0046a)));
            nVar.onNext(n.a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: RxRoom.java */
    static class b<T> implements h.a.y.f<Object, h.a.l<T>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h.a.j f2195f;

        b(h.a.j jVar) {
            this.f2195f = jVar;
        }

        @Override // h.a.y.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public h.a.l<T> a(Object obj) throws Exception {
            return this.f2195f;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: RxRoom.java */
    static class c<T> implements v<T> {
        final /* synthetic */ Callable a;

        c(Callable callable) {
            this.a = callable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.a.v
        public void a(t<T> tVar) throws Exception {
            try {
                tVar.onSuccess(this.a.call());
            } catch (EmptyResultSetException e2) {
                tVar.c(e2);
            }
        }
    }

    public static <T> h.a.m<T> a(j jVar, boolean z, String[] strArr, Callable<T> callable) {
        h.a.r rVarA = h.a.b0.a.a(d(jVar, z));
        return (h.a.m<T>) b(jVar, strArr).y(rVarA).C(rVarA).u(rVarA).q(new b(h.a.j.c(callable)));
    }

    public static h.a.m<Object> b(j jVar, String... strArr) {
        return h.a.m.c(new a(strArr, jVar));
    }

    public static <T> s<T> c(Callable<T> callable) {
        return s.c(new c(callable));
    }

    private static Executor d(j jVar, boolean z) {
        return z ? jVar.getTransactionExecutor() : jVar.getQueryExecutor();
    }
}
