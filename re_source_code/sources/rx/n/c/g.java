package rx.n.c;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: NewThreadScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends rx.h {
    private final ThreadFactory a;

    public g(ThreadFactory threadFactory) {
        this.a = threadFactory;
    }

    @Override // rx.h
    public rx.h.a createWorker() {
        return new h(this.a);
    }
}
