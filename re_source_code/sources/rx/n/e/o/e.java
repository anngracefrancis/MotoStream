package rx.n.e.o;

/* JADX INFO: compiled from: BaseLinkedQueue.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class e<E> extends c<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final long f26814f = z.a(e.class, "producerNode");
    protected rx.n.e.n.c<E> producerNode;

    e() {
    }

    protected final rx.n.e.n.c<E> c() {
        return (rx.n.e.n.c) z.a.getObjectVolatile(this, f26814f);
    }
}
