package rx.schedulers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import rx.h;
import rx.k;
import rx.n.c.i;
import rx.t.e;

/* JADX INFO: loaded from: classes3.dex */
public class TestScheduler extends h {
    static long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Queue<c> f26895b = new PriorityQueue(11, new a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f26896c;

    static final class a implements Comparator<c> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            long j2 = cVar.a;
            long j3 = cVar2.a;
            if (j2 == j3) {
                if (cVar.f26905d < cVar2.f26905d) {
                    return -1;
                }
                return cVar.f26905d > cVar2.f26905d ? 1 : 0;
            }
            if (j2 < j3) {
                return -1;
            }
            return j2 > j3 ? 1 : 0;
        }
    }

    final class b extends h.a implements i.b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final rx.t.a f26897f = new rx.t.a();

        class a implements rx.m.a {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ c f26899f;

            a(c cVar) {
                this.f26899f = cVar;
            }

            @Override // rx.m.a
            public void call() {
                TestScheduler.this.f26895b.remove(this.f26899f);
            }
        }

        /* JADX INFO: renamed from: rx.schedulers.TestScheduler$b$b, reason: collision with other inner class name */
        class C0470b implements rx.m.a {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ c f26901f;

            C0470b(c cVar) {
                this.f26901f = cVar;
            }

            @Override // rx.m.a
            public void call() {
                TestScheduler.this.f26895b.remove(this.f26901f);
            }
        }

        b() {
        }

        @Override // rx.n.c.i.b
        public long a() {
            return TestScheduler.this.f26896c;
        }

        @Override // rx.h.a
        public long b() {
            return TestScheduler.this.now();
        }

        @Override // rx.h.a
        public k c(rx.m.a aVar) {
            c cVar = new c(this, 0L, aVar);
            TestScheduler.this.f26895b.add(cVar);
            return e.a(new C0470b(cVar));
        }

        @Override // rx.h.a
        public k d(rx.m.a aVar, long j2, TimeUnit timeUnit) {
            c cVar = new c(this, TestScheduler.this.f26896c + timeUnit.toNanos(j2), aVar);
            TestScheduler.this.f26895b.add(cVar);
            return e.a(new a(cVar));
        }

        @Override // rx.h.a
        public k e(rx.m.a aVar, long j2, long j3, TimeUnit timeUnit) {
            return i.a(this, aVar, j2, j3, timeUnit, this);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.f26897f.isUnsubscribed();
        }

        @Override // rx.k
        public void unsubscribe() {
            this.f26897f.unsubscribe();
        }
    }

    static final class c {
        final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final rx.m.a f26903b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final h.a f26904c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f26905d;

        c(h.a aVar, long j2, rx.m.a aVar2) {
            long j3 = TestScheduler.a;
            TestScheduler.a = 1 + j3;
            this.f26905d = j3;
            this.a = j2;
            this.f26903b = aVar2;
            this.f26904c = aVar;
        }

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.a), this.f26903b.toString());
        }
    }

    private void a(long j2) {
        while (!this.f26895b.isEmpty()) {
            c cVarPeek = this.f26895b.peek();
            long j3 = cVarPeek.a;
            if (j3 > j2) {
                break;
            }
            if (j3 == 0) {
                j3 = this.f26896c;
            }
            this.f26896c = j3;
            this.f26895b.remove();
            if (!cVarPeek.f26904c.isUnsubscribed()) {
                cVarPeek.f26903b.call();
            }
        }
        this.f26896c = j2;
    }

    public void advanceTimeBy(long j2, TimeUnit timeUnit) {
        advanceTimeTo(this.f26896c + timeUnit.toNanos(j2), TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long j2, TimeUnit timeUnit) {
        a(timeUnit.toNanos(j2));
    }

    @Override // rx.h
    public h.a createWorker() {
        return new b();
    }

    @Override // rx.h
    public long now() {
        return TimeUnit.NANOSECONDS.toMillis(this.f26896c);
    }

    public void triggerActions() {
        a(this.f26896c);
    }
}
