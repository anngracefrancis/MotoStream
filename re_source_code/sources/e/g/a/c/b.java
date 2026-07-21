package e.g.a.c;

import android.view.View;
import rx.j;

/* JADX INFO: compiled from: ViewClickOnSubscribe.java */
/* JADX INFO: loaded from: classes2.dex */
final class b implements rx.e.a<Void> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final View f21161f;

    /* JADX INFO: compiled from: ViewClickOnSubscribe.java */
    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f21162f;

        a(j jVar) {
            this.f21162f = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f21162f.isUnsubscribed()) {
                return;
            }
            this.f21162f.onNext(null);
        }
    }

    /* JADX INFO: renamed from: e.g.a.c.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ViewClickOnSubscribe.java */
    class C0269b extends rx.l.a {
        C0269b() {
        }

        @Override // rx.l.a
        protected void onUnsubscribe() {
            b.this.f21161f.setOnClickListener(null);
        }
    }

    b(View view) {
        this.f21161f = view;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(j<? super Void> jVar) {
        rx.l.a.verifyMainThread();
        a aVar = new a(jVar);
        jVar.add(new C0269b());
        this.f21161f.setOnClickListener(aVar);
    }
}
