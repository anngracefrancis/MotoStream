package rx.n.a;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Single;

/* JADX INFO: compiled from: SingleTimeout.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s1<T> implements Single.j<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Single.j<T> f26479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final long f26480g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final TimeUnit f26481h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final rx.h f26482i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final Single.j<? extends T> f26483j;

    /* JADX INFO: compiled from: SingleTimeout.java */
    static final class a<T> extends rx.i<T> implements rx.m.a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final rx.i<? super T> f26484g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicBoolean f26485h = new AtomicBoolean();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Single.j<? extends T> f26486i;

        /* JADX INFO: renamed from: rx.n.a.s1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SingleTimeout.java */
        static final class C0449a<T> extends rx.i<T> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final rx.i<? super T> f26487g;

            C0449a(rx.i<? super T> iVar) {
                this.f26487g = iVar;
            }

            @Override // rx.i
            public void c(T t) {
                this.f26487g.c(t);
            }

            @Override // rx.i
            public void onError(Throwable th) {
                this.f26487g.onError(th);
            }
        }

        a(rx.i<? super T> iVar, Single.j<? extends T> jVar) {
            this.f26484g = iVar;
            this.f26486i = jVar;
        }

        @Override // rx.i
        public void c(T t) {
            if (this.f26485h.compareAndSet(false, true)) {
                try {
                    this.f26484g.c(t);
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // rx.m.a
        public void call() {
            if (this.f26485h.compareAndSet(false, true)) {
                try {
                    Single.j<? extends T> jVar = this.f26486i;
                    if (jVar == null) {
                        this.f26484g.onError(new TimeoutException());
                    } else {
                        C0449a c0449a = new C0449a(this.f26484g);
                        this.f26484g.b(c0449a);
                        jVar.call(c0449a);
                    }
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // rx.i
        public void onError(Throwable th) {
            if (!this.f26485h.compareAndSet(false, true)) {
                rx.q.c.j(th);
                return;
            }
            try {
                this.f26484g.onError(th);
            } finally {
                unsubscribe();
            }
        }
    }

    public s1(Single.j<T> jVar, long j2, TimeUnit timeUnit, rx.h hVar, Single.j<? extends T> jVar2) {
        this.f26479f = jVar;
        this.f26480g = j2;
        this.f26481h = timeUnit;
        this.f26482i = hVar;
        this.f26483j = jVar2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.i<? super T> iVar) {
        a aVar = new a(iVar, this.f26483j);
        rx.h.a aVarCreateWorker = this.f26482i.createWorker();
        aVar.b(aVarCreateWorker);
        iVar.b(aVar);
        aVarCreateWorker.d(aVar, this.f26480g, this.f26481h);
        this.f26479f.call(aVar);
    }
}
