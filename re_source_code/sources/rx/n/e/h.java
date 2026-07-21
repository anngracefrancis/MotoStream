package rx.n.e;

import java.util.Queue;
import rx.exceptions.MissingBackpressureException;
import rx.n.e.o.s;
import rx.n.e.o.z;

/* JADX INFO: compiled from: RxRingBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public class h implements rx.k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f26744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Queue<Object> f26745g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f26746h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile Object f26747i;

    static {
        int i2 = g.b() ? 16 : 128;
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                i2 = Integer.parseInt(property);
            } catch (NumberFormatException e2) {
                System.err.println("Failed to set 'rx.buffer.size' with value " + property + " => " + e2.getMessage());
            }
        }
        f26744f = i2;
    }

    private h(Queue<Object> queue, int i2) {
        this.f26745g = queue;
        this.f26746h = i2;
    }

    public static h a() {
        return z.b() ? new h(true, f26744f) : new h();
    }

    public static h b() {
        return z.b() ? new h(false, f26744f) : new h();
    }

    public Object c(Object obj) {
        return rx.n.a.h.e(obj);
    }

    public boolean d(Object obj) {
        return rx.n.a.h.f(obj);
    }

    public boolean e() {
        Queue<Object> queue = this.f26745g;
        return queue == null || queue.isEmpty();
    }

    public void f() {
        if (this.f26747i == null) {
            this.f26747i = rx.n.a.h.b();
        }
    }

    public void g(Object obj) throws MissingBackpressureException {
        boolean z;
        boolean z2;
        synchronized (this) {
            Queue<Object> queue = this.f26745g;
            z = true;
            z2 = false;
            if (queue != null) {
                z2 = !queue.offer(rx.n.a.h.g(obj));
                z = false;
            }
        }
        if (z) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        }
        if (z2) {
            throw new MissingBackpressureException();
        }
    }

    public Object h() {
        synchronized (this) {
            Queue<Object> queue = this.f26745g;
            if (queue == null) {
                return null;
            }
            Object objPeek = queue.peek();
            Object obj = this.f26747i;
            if (objPeek == null && obj != null && queue.peek() == null) {
                objPeek = obj;
            }
            return objPeek;
        }
    }

    public Object i() {
        synchronized (this) {
            Queue<Object> queue = this.f26745g;
            if (queue == null) {
                return null;
            }
            Object objPoll = queue.poll();
            Object obj = this.f26747i;
            if (objPoll == null && obj != null && queue.peek() == null) {
                this.f26747i = null;
                objPoll = obj;
            }
            return objPoll;
        }
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.f26745g == null;
    }

    public synchronized void j() {
    }

    @Override // rx.k
    public void unsubscribe() {
        j();
    }

    private h(boolean z, int i2) {
        this.f26745g = z ? new rx.n.e.o.k<>(i2) : new s<>(i2);
        this.f26746h = i2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    h() {
        int i2 = f26744f;
        this(new rx.n.e.n.e(i2), i2);
    }
}
