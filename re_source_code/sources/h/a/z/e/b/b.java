package h.a.z.e.b;

import h.a.h;
import h.a.m;
import h.a.q;

/* JADX INFO: compiled from: FlowableFromObservable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b<T> extends h<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m<T> f21473b;

    /* JADX INFO: compiled from: FlowableFromObservable.java */
    static final class a<T> implements q<T>, k.a.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final k.a.b<? super T> f21474f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        h.a.x.c f21475g;

        a(k.a.b<? super T> bVar) {
            this.f21474f = bVar;
        }

        @Override // h.a.q
        public void a() {
            this.f21474f.a();
        }

        @Override // h.a.q
        public void b(h.a.x.c cVar) {
            this.f21475g = cVar;
            this.f21474f.b(this);
        }

        @Override // k.a.c
        public void cancel() {
            this.f21475g.k();
        }

        @Override // h.a.q
        public void onError(Throwable th) {
            this.f21474f.onError(th);
        }

        @Override // h.a.q
        public void onNext(T t) {
            this.f21474f.onNext(t);
        }

        @Override // k.a.c
        public void request(long j2) {
        }
    }

    public b(m<T> mVar) {
        this.f21473b = mVar;
    }

    @Override // h.a.h
    protected void i(k.a.b<? super T> bVar) {
        this.f21473b.a(new a(bVar));
    }
}
