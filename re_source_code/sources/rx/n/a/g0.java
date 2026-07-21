package rx.n.a;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: OnSubscribeTimerPeriodically.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g0 implements rx.e.a<Long> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final long f26220f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final long f26221g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final TimeUnit f26222h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final rx.h f26223i;

    /* JADX INFO: compiled from: OnSubscribeTimerPeriodically.java */
    class a implements rx.m.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f26224f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ rx.j f26225g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ rx.h.a f26226h;

        a(rx.j jVar, rx.h.a aVar) {
            this.f26225g = jVar;
            this.f26226h = aVar;
        }

        @Override // rx.m.a
        public void call() {
            try {
                rx.j jVar = this.f26225g;
                long j2 = this.f26224f;
                this.f26224f = 1 + j2;
                jVar.onNext(Long.valueOf(j2));
            } catch (Throwable th) {
                try {
                    this.f26226h.unsubscribe();
                } finally {
                    rx.exceptions.a.f(th, this.f26225g);
                }
            }
        }
    }

    public g0(long j2, long j3, TimeUnit timeUnit, rx.h hVar) {
        this.f26220f = j2;
        this.f26221g = j3;
        this.f26222h = timeUnit;
        this.f26223i = hVar;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super Long> jVar) {
        rx.h.a aVarCreateWorker = this.f26223i.createWorker();
        jVar.add(aVarCreateWorker);
        aVarCreateWorker.e(new a(jVar, aVarCreateWorker), this.f26220f, this.f26221g, this.f26222h);
    }
}
