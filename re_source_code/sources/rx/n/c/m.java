package rx.n.c;

/* JADX INFO: compiled from: SleepingAction.java */
/* JADX INFO: loaded from: classes3.dex */
class m implements rx.m.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final rx.m.a f26710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final rx.h.a f26711g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f26712h;

    public m(rx.m.a aVar, rx.h.a aVar2, long j2) {
        this.f26710f = aVar;
        this.f26711g = aVar2;
        this.f26712h = j2;
    }

    @Override // rx.m.a
    public void call() {
        if (this.f26711g.isUnsubscribed()) {
            return;
        }
        long jB = this.f26712h - this.f26711g.b();
        if (jB > 0) {
            try {
                Thread.sleep(jB);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                rx.exceptions.a.c(e2);
            }
        }
        if (this.f26711g.isUnsubscribed()) {
            return;
        }
        this.f26710f.call();
    }
}
