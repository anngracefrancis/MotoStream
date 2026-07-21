package rx.n.e;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: BackpressureDrainManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends AtomicLong implements rx.g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f26730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile boolean f26731g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Throwable f26732h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final a f26733i;

    /* JADX INFO: compiled from: BackpressureDrainManager.java */
    public interface a {
        boolean a(Object obj);

        void b(Throwable th);

        Object peek();

        Object poll();
    }

    public c(a aVar) {
        this.f26733i = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0032 A[Catch: all -> 0x0086, TRY_ENTER, TryCatch #2 {all -> 0x0086, blocks: (B:10:0x0012, B:27:0x0038, B:16:0x001f, B:25:0x0032, B:60:0x0079), top: B:83:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0079 A[Catch: all -> 0x0086, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0086, blocks: (B:10:0x0012, B:27:0x0038, B:16:0x001f, B:25:0x0032, B:60:0x0079), top: B:83:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0080 A[LOOP:1: B:12:0x0015->B:63:0x0080, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:93:0x007f A[SYNTHETIC] */
    public void a() throws Throwable {
        Object objPoll;
        synchronized (this) {
            if (this.f26730f) {
                return;
            }
            boolean z = true;
            this.f26730f = true;
            boolean z2 = this.f26731g;
            long j2 = get();
            try {
                a aVar = this.f26733i;
                while (true) {
                    int i2 = 0;
                    while (true) {
                        try {
                            if (j2 <= 0 && !z2) {
                                break;
                            }
                            if (!z2) {
                                objPoll = aVar.poll();
                                if (objPoll != null) {
                                    break;
                                }
                                if (aVar.a(objPoll)) {
                                    return;
                                }
                                j2--;
                                i2++;
                            } else if (aVar.peek() != null) {
                                if (j2 == 0) {
                                    break;
                                }
                                objPoll = aVar.poll();
                                if (objPoll != null) {
                                    break;
                                }
                                if (aVar.a(objPoll)) {
                                    return;
                                }
                                j2--;
                                i2++;
                            } else {
                                aVar.b(this.f26732h);
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (!z) {
                                synchronized (this) {
                                    this.f26730f = false;
                                }
                            }
                            throw th;
                        }
                    }
                    try {
                        synchronized (this) {
                            try {
                                z2 = this.f26731g;
                                boolean z3 = aVar.peek() != null;
                                if (get() != Long.MAX_VALUE) {
                                    long jAddAndGet = addAndGet(-i2);
                                    if ((jAddAndGet != 0 && z3) || (z2 && !z3)) {
                                        j2 = jAddAndGet;
                                    }
                                    this.f26730f = false;
                                    return;
                                }
                                if (!z3 && !z2) {
                                    this.f26730f = false;
                                    return;
                                }
                                j2 = Long.MAX_VALUE;
                            } catch (Throwable th2) {
                                th = th2;
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                z = false;
            }
        }
    }

    public void b() throws Throwable {
        this.f26731g = true;
        a();
    }

    public void c(Throwable th) throws Throwable {
        if (this.f26731g) {
            return;
        }
        this.f26732h = th;
        this.f26731g = true;
        a();
    }

    @Override // rx.g
    public void request(long j2) throws Throwable {
        boolean z;
        long j3;
        if (j2 == 0) {
            return;
        }
        while (true) {
            long j4 = get();
            boolean z2 = true;
            z = j4 == 0;
            if (j4 == Long.MAX_VALUE) {
                break;
            }
            if (j2 == Long.MAX_VALUE) {
                j3 = j2;
            } else {
                j3 = j4 <= Long.MAX_VALUE - j2 ? j4 + j2 : Long.MAX_VALUE;
                z2 = z;
            }
            if (compareAndSet(j4, j3)) {
                z = z2;
                break;
            }
        }
        if (z) {
            a();
        }
    }
}
