package e.g.a.b.b.a;

import rx.e;
import rx.j;

/* JADX INFO: compiled from: SwipeRefreshLayoutRefreshOnSubscribe.java */
/* JADX INFO: loaded from: classes2.dex */
final class d implements e.a<Void> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final c.v.a.c f21144f;

    /* JADX INFO: compiled from: SwipeRefreshLayoutRefreshOnSubscribe.java */
    class a implements c.v.a.c.j {
        final /* synthetic */ j a;

        a(j jVar) {
            this.a = jVar;
        }

        @Override // c.v.a.c.j
        public void a() {
            if (this.a.isUnsubscribed()) {
                return;
            }
            this.a.onNext(null);
        }
    }

    /* JADX INFO: compiled from: SwipeRefreshLayoutRefreshOnSubscribe.java */
    class b extends rx.l.a {
        b() {
        }

        @Override // rx.l.a
        protected void onUnsubscribe() {
            d.this.f21144f.setOnRefreshListener(null);
        }
    }

    d(c.v.a.c cVar) {
        this.f21144f = cVar;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(j<? super Void> jVar) {
        rx.l.a.verifyMainThread();
        a aVar = new a(jVar);
        jVar.add(new b());
        this.f21144f.setOnRefreshListener(aVar);
    }
}
