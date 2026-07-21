package rx.n.c;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SchedulerWhen.java */
/* JADX INFO: loaded from: classes3.dex */
public class l extends rx.h implements rx.k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final rx.k f26691f = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final rx.k f26692g = rx.t.e.c();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final rx.h f26693h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final rx.f<rx.e<rx.b>> f26694i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final rx.k f26695j;

    /* JADX INFO: compiled from: SchedulerWhen.java */
    class a implements rx.m.e<g, rx.b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.h.a f26696f;

        /* JADX INFO: renamed from: rx.n.c.l$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SchedulerWhen.java */
        class C0461a implements rx.b.w {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f26698f;

            C0461a(g gVar) {
                this.f26698f = gVar;
            }

            @Override // rx.m.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void call(rx.c cVar) {
                cVar.a(this.f26698f);
                this.f26698f.b(a.this.f26696f, cVar);
            }
        }

        a(rx.h.a aVar) {
            this.f26696f = aVar;
        }

        @Override // rx.m.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public rx.b call(g gVar) {
            return rx.b.h(new C0461a(gVar));
        }
    }

    /* JADX INFO: compiled from: SchedulerWhen.java */
    class b extends rx.h.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final AtomicBoolean f26700f = new AtomicBoolean();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ rx.h.a f26701g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ rx.f f26702h;

        b(rx.h.a aVar, rx.f fVar) {
            this.f26701g = aVar;
            this.f26702h = fVar;
        }

        @Override // rx.h.a
        public rx.k c(rx.m.a aVar) {
            e eVar = new e(aVar);
            this.f26702h.onNext(eVar);
            return eVar;
        }

        @Override // rx.h.a
        public rx.k d(rx.m.a aVar, long j2, TimeUnit timeUnit) {
            d dVar = new d(aVar, j2, timeUnit);
            this.f26702h.onNext(dVar);
            return dVar;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.f26700f.get();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.f26700f.compareAndSet(false, true)) {
                this.f26701g.unsubscribe();
                this.f26702h.onCompleted();
            }
        }
    }

    /* JADX INFO: compiled from: SchedulerWhen.java */
    static class c implements rx.k {
        c() {
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // rx.k
        public void unsubscribe() {
        }
    }

    /* JADX INFO: compiled from: SchedulerWhen.java */
    static class d extends g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final rx.m.a f26704f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long f26705g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final TimeUnit f26706h;

        public d(rx.m.a aVar, long j2, TimeUnit timeUnit) {
            this.f26704f = aVar;
            this.f26705g = j2;
            this.f26706h = timeUnit;
        }

        @Override // rx.n.c.l.g
        protected rx.k c(rx.h.a aVar, rx.c cVar) {
            return aVar.d(new f(this.f26704f, cVar), this.f26705g, this.f26706h);
        }
    }

    /* JADX INFO: compiled from: SchedulerWhen.java */
    static class e extends g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final rx.m.a f26707f;

        public e(rx.m.a aVar) {
            this.f26707f = aVar;
        }

        @Override // rx.n.c.l.g
        protected rx.k c(rx.h.a aVar, rx.c cVar) {
            return aVar.c(new f(this.f26707f, cVar));
        }
    }

    /* JADX INFO: compiled from: SchedulerWhen.java */
    static class f implements rx.m.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private rx.c f26708f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private rx.m.a f26709g;

        public f(rx.m.a aVar, rx.c cVar) {
            this.f26709g = aVar;
            this.f26708f = cVar;
        }

        @Override // rx.m.a
        public void call() {
            try {
                this.f26709g.call();
            } finally {
                this.f26708f.onCompleted();
            }
        }
    }

    /* JADX INFO: compiled from: SchedulerWhen.java */
    static abstract class g extends AtomicReference<rx.k> implements rx.k {
        public g() {
            super(l.f26691f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(rx.h.a aVar, rx.c cVar) {
            rx.k kVar;
            rx.k kVar2 = get();
            if (kVar2 != l.f26692g && kVar2 == (kVar = l.f26691f)) {
                rx.k kVarC = c(aVar, cVar);
                if (compareAndSet(kVar, kVarC)) {
                    return;
                }
                kVarC.unsubscribe();
            }
        }

        protected abstract rx.k c(rx.h.a aVar, rx.c cVar);

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // rx.k
        public void unsubscribe() {
            rx.k kVar;
            rx.k kVar2 = l.f26692g;
            do {
                kVar = get();
                if (kVar == l.f26692g) {
                    return;
                }
            } while (!compareAndSet(kVar, kVar2));
            if (kVar != l.f26691f) {
                kVar.unsubscribe();
            }
        }
    }

    public l(rx.m.e<rx.e<rx.e<rx.b>>, rx.b> eVar, rx.h hVar) {
        this.f26693h = hVar;
        rx.s.b bVarG1 = rx.s.b.g1();
        this.f26694i = new rx.p.d(bVarG1);
        this.f26695j = eVar.call(bVarG1.m0()).H();
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    @Override // rx.h
    public rx.h.a createWorker() {
        rx.h.a aVarCreateWorker = this.f26693h.createWorker();
        rx.n.a.b bVarG1 = rx.n.a.b.g1();
        rx.p.d dVar = new rx.p.d(bVarG1);
        Object objX = bVarG1.X(new a(aVarCreateWorker));
        b bVar = new b(aVarCreateWorker, dVar);
        this.f26694i.onNext(objX);
        return bVar;
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.f26695j.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.f26695j.unsubscribe();
    }
}
