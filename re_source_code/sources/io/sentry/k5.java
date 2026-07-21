package io.sentry;

import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: compiled from: Stack.java */
/* JADX INFO: loaded from: classes2.dex */
final class k5 {
    private final Deque<a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w1 f22470b;

    public k5(w1 w1Var, a aVar) {
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        this.a = linkedBlockingDeque;
        this.f22470b = (w1) io.sentry.util.q.c(w1Var, "logger is required");
        linkedBlockingDeque.push((a) io.sentry.util.q.c(aVar, "rootStackItem is required"));
    }

    a a() {
        return this.a.peek();
    }

    void b(a aVar) {
        this.a.push(aVar);
    }

    /* JADX INFO: compiled from: Stack.java */
    static final class a {
        private final x4 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile a2 f22471b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile s3 f22472c;

        a(x4 x4Var, a2 a2Var, s3 s3Var) {
            this.f22471b = (a2) io.sentry.util.q.c(a2Var, "ISentryClient is required.");
            this.f22472c = (s3) io.sentry.util.q.c(s3Var, "Scope is required.");
            this.a = (x4) io.sentry.util.q.c(x4Var, "Options is required");
        }

        public a2 a() {
            return this.f22471b;
        }

        public x4 b() {
            return this.a;
        }

        public s3 c() {
            return this.f22472c;
        }

        a(a aVar) {
            this.a = aVar.a;
            this.f22471b = aVar.f22471b;
            this.f22472c = new s3(aVar.f22472c);
        }
    }

    public k5(k5 k5Var) {
        this(k5Var.f22470b, new a(k5Var.a.getLast()));
        Iterator<a> itDescendingIterator = k5Var.a.descendingIterator();
        if (itDescendingIterator.hasNext()) {
            itDescendingIterator.next();
        }
        while (itDescendingIterator.hasNext()) {
            b(new a(itDescendingIterator.next()));
        }
    }
}
