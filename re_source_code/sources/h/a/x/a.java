package h.a.x;

/* JADX INFO: compiled from: ActionDisposable.java */
/* JADX INFO: loaded from: classes2.dex */
final class a extends e<h.a.y.a> {
    a(h.a.y.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h.a.x.e
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(h.a.y.a aVar) {
        try {
            aVar.run();
        } catch (Throwable th) {
            throw h.a.z.j.c.c(th);
        }
    }
}
