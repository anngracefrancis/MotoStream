package h.a.z.g;

import h.a.r;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: NewThreadScheduler.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h f21695b = new h("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ThreadFactory f21696c;

    public f() {
        this(f21695b);
    }

    @Override // h.a.r
    public r.b a() {
        return new g(this.f21696c);
    }

    public f(ThreadFactory threadFactory) {
        this.f21696c = threadFactory;
    }
}
