package h.a.z.e.a;

import h.a.u;
import h.a.w;

/* JADX INFO: compiled from: CompletableFromSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c<T> extends h.a.b {
    final w<T> a;

    /* JADX INFO: compiled from: CompletableFromSingle.java */
    static final class a<T> implements u<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.d f21467f;

        a(h.a.d dVar) {
            this.f21467f = dVar;
        }

        @Override // h.a.u
        public void b(h.a.x.c cVar) {
            this.f21467f.b(cVar);
        }

        @Override // h.a.u
        public void onError(Throwable th) {
            this.f21467f.onError(th);
        }

        @Override // h.a.u
        public void onSuccess(T t) {
            this.f21467f.a();
        }
    }

    public c(w<T> wVar) {
        this.a = wVar;
    }

    @Override // h.a.b
    protected void e(h.a.d dVar) {
        this.a.b(new a(dVar));
    }
}
