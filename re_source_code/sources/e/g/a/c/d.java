package e.g.a.c;

import android.view.View;
import rx.j;

/* JADX INFO: compiled from: ViewFocusChangeOnSubscribe.java */
/* JADX INFO: loaded from: classes2.dex */
final class d implements rx.e.a<Boolean> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final View f21165f;

    /* JADX INFO: compiled from: ViewFocusChangeOnSubscribe.java */
    class a implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f21166f;

        a(j jVar) {
            this.f21166f = jVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (this.f21166f.isUnsubscribed()) {
                return;
            }
            this.f21166f.onNext(Boolean.valueOf(z));
        }
    }

    /* JADX INFO: compiled from: ViewFocusChangeOnSubscribe.java */
    class b extends rx.l.a {
        b() {
        }

        @Override // rx.l.a
        protected void onUnsubscribe() {
            d.this.f21165f.setOnFocusChangeListener(null);
        }
    }

    d(View view) {
        this.f21165f = view;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(j<? super Boolean> jVar) {
        rx.l.a.verifyMainThread();
        a aVar = new a(jVar);
        jVar.add(new b());
        this.f21165f.setOnFocusChangeListener(aVar);
        jVar.onNext(Boolean.valueOf(this.f21165f.hasFocus()));
    }
}
