package e.g.a.c;

import android.view.View;
import rx.j;

/* JADX INFO: compiled from: ViewLongClickOnSubscribe.java */
/* JADX INFO: loaded from: classes2.dex */
final class e implements rx.e.a<Void> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final View f21169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final rx.m.d<Boolean> f21170g;

    /* JADX INFO: compiled from: ViewLongClickOnSubscribe.java */
    class a implements View.OnLongClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f21171f;

        a(j jVar) {
            this.f21171f = jVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (!e.this.f21170g.call().booleanValue()) {
                return false;
            }
            if (this.f21171f.isUnsubscribed()) {
                return true;
            }
            this.f21171f.onNext(null);
            return true;
        }
    }

    /* JADX INFO: compiled from: ViewLongClickOnSubscribe.java */
    class b extends rx.l.a {
        b() {
        }

        @Override // rx.l.a
        protected void onUnsubscribe() {
            e.this.f21169f.setOnLongClickListener(null);
        }
    }

    e(View view, rx.m.d<Boolean> dVar) {
        this.f21169f = view;
        this.f21170g = dVar;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(j<? super Void> jVar) {
        rx.l.a.verifyMainThread();
        a aVar = new a(jVar);
        jVar.add(new b());
        this.f21169f.setOnLongClickListener(aVar);
    }
}
