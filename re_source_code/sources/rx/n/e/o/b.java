package rx.n.e.o;

/* JADX INFO: compiled from: BaseLinkedQueue.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class b<E> extends d<E> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected static final long f26813g = z.a(b.class, "consumerNode");
    protected rx.n.e.n.c<E> consumerNode;

    b() {
    }

    protected final rx.n.e.n.c<E> f() {
        return this.consumerNode;
    }

    protected final rx.n.e.n.c<E> g() {
        return (rx.n.e.n.c) z.a.getObjectVolatile(this, f26813g);
    }

    protected final void h(rx.n.e.n.c<E> cVar) {
        this.consumerNode = cVar;
    }
}
