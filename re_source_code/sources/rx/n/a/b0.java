package rx.n.a;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: OnSubscribeSkipTimed.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b0<T> implements rx.e.a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final long f26131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final TimeUnit f26132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final rx.h f26133h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final rx.e<T> f26134i;

    /* JADX INFO: compiled from: OnSubscribeSkipTimed.java */
    static final class a<T> extends rx.j<T> implements rx.m.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final rx.j<? super T> f26135f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile boolean f26136g;

        a(rx.j<? super T> jVar) {
            this.f26135f = jVar;
        }

        @Override // rx.m.a
        public void call() {
            this.f26136g = true;
        }

        @Override // rx.f
        public void onCompleted() {
            try {
                this.f26135f.onCompleted();
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            try {
                this.f26135f.onError(th);
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onNext(T t) {
            if (this.f26136g) {
                this.f26135f.onNext(t);
            }
        }
    }

    public b0(rx.e<T> eVar, long j2, TimeUnit timeUnit, rx.h hVar) {
        this.f26134i = eVar;
        this.f26131f = j2;
        this.f26132g = timeUnit;
        this.f26133h = hVar;
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
    public void call(rx.j<? super T> jVar) {
        rx.h.a aVarCreateWorker = this.f26133h.createWorker();
        a aVar = new a(jVar);
        aVar.add(aVarCreateWorker);
        jVar.add(aVar);
        aVarCreateWorker.d(aVar, this.f26131f, this.f26132g);
        this.f26134i.c1(aVar);
    }
}
