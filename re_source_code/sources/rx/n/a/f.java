package rx.n.a;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: CompletableOnSubscribeMergeDelayErrorArray.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements rx.b.w {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.b[] f26196f;

    /* JADX INFO: compiled from: CompletableOnSubscribeMergeDelayErrorArray.java */
    class a implements rx.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.t.b f26197f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Queue f26198g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f26199h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ rx.c f26200i;

        a(rx.t.b bVar, Queue queue, AtomicInteger atomicInteger, rx.c cVar) {
            this.f26197f = bVar;
            this.f26198g = queue;
            this.f26199h = atomicInteger;
            this.f26200i = cVar;
        }

        @Override // rx.c
        public void a(rx.k kVar) {
            this.f26197f.a(kVar);
        }

        void b() {
            if (this.f26199h.decrementAndGet() == 0) {
                if (this.f26198g.isEmpty()) {
                    this.f26200i.onCompleted();
                } else {
                    this.f26200i.onError(e.a(this.f26198g));
                }
            }
        }

        @Override // rx.c
        public void onCompleted() {
            b();
        }

        @Override // rx.c
        public void onError(Throwable th) {
            this.f26198g.offer(th);
            b();
        }
    }

    public f(rx.b[] bVarArr) {
        this.f26196f = bVarArr;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.c cVar) {
        rx.t.b bVar = new rx.t.b();
        AtomicInteger atomicInteger = new AtomicInteger(this.f26196f.length + 1);
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        cVar.a(bVar);
        for (rx.b bVar2 : this.f26196f) {
            if (bVar.isUnsubscribed()) {
                return;
            }
            if (bVar2 == null) {
                concurrentLinkedQueue.offer(new NullPointerException("A completable source is null"));
                atomicInteger.decrementAndGet();
            } else {
                bVar2.P(new a(bVar, concurrentLinkedQueue, atomicInteger, cVar));
            }
        }
        if (atomicInteger.decrementAndGet() == 0) {
            if (concurrentLinkedQueue.isEmpty()) {
                cVar.onCompleted();
            } else {
                cVar.onError(e.a(concurrentLinkedQueue));
            }
        }
    }
}
