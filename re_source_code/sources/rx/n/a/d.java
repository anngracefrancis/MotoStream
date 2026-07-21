package rx.n.a;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: CompletableOnSubscribeConcatArray.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements rx.b.w {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.b[] f26164f;

    /* JADX INFO: compiled from: CompletableOnSubscribeConcatArray.java */
    static final class a extends AtomicInteger implements rx.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final rx.c f26165f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final rx.b[] f26166g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f26167h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final rx.n.d.a f26168i = new rx.n.d.a();

        public a(rx.c cVar, rx.b[] bVarArr) {
            this.f26165f = cVar;
            this.f26166g = bVarArr;
        }

        @Override // rx.c
        public void a(rx.k kVar) {
            this.f26168i.b(kVar);
        }

        void b() {
            if (!this.f26168i.isUnsubscribed() && getAndIncrement() == 0) {
                rx.b[] bVarArr = this.f26166g;
                while (!this.f26168i.isUnsubscribed()) {
                    int i2 = this.f26167h;
                    this.f26167h = i2 + 1;
                    if (i2 == bVarArr.length) {
                        this.f26165f.onCompleted();
                        return;
                    } else {
                        bVarArr[i2].P(this);
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
            }
        }

        @Override // rx.c
        public void onCompleted() {
            b();
        }

        @Override // rx.c
        public void onError(Throwable th) {
            this.f26165f.onError(th);
        }
    }

    public d(rx.b[] bVarArr) {
        this.f26164f = bVarArr;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.c cVar) {
        a aVar = new a(cVar, this.f26164f);
        cVar.a(aVar.f26168i);
        aVar.b();
    }
}
