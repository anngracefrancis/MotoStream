package e.e.b.a.i;

/* JADX INFO: compiled from: TransportImpl.java */
/* JADX INFO: loaded from: classes2.dex */
final class s<T> implements e.e.b.a.f<T> {
    private final q a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f20843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e.e.b.a.b f20844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e.e.b.a.e<T, byte[]> f20845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final t f20846e;

    s(q qVar, String str, e.e.b.a.b bVar, e.e.b.a.e<T, byte[]> eVar, t tVar) {
        this.a = qVar;
        this.f20843b = str;
        this.f20844c = bVar;
        this.f20845d = eVar;
        this.f20846e = tVar;
    }

    static /* synthetic */ void d(Exception exc) {
    }

    @Override // e.e.b.a.f
    public void a(e.e.b.a.c<T> cVar) {
        b(cVar, new e.e.b.a.h() { // from class: e.e.b.a.i.a
            @Override // e.e.b.a.h
            public final void a(Exception exc) {
                s.d(exc);
            }
        });
    }

    @Override // e.e.b.a.f
    public void b(e.e.b.a.c<T> cVar, e.e.b.a.h hVar) {
        this.f20846e.a(p.a().e(this.a).c(cVar).f(this.f20843b).d(this.f20845d).b(this.f20844c).a(), hVar);
    }

    q c() {
        return this.a;
    }
}
