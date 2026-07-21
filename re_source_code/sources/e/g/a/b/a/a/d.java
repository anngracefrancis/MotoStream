package e.g.a.b.a.a;

import com.google.android.material.snackbar.Snackbar;
import rx.e;
import rx.j;

/* JADX INFO: compiled from: SnackbarDismissesOnSubscribe.java */
/* JADX INFO: loaded from: classes2.dex */
final class d implements e.a<Integer> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Snackbar f21138f;

    /* JADX INFO: compiled from: SnackbarDismissesOnSubscribe.java */
    class a extends Snackbar.b {
        final /* synthetic */ j a;

        a(j jVar) {
            this.a = jVar;
        }

        @Override // com.google.android.material.snackbar.Snackbar.b
        public void onDismissed(Snackbar snackbar, int i2) {
            if (this.a.isUnsubscribed()) {
                return;
            }
            this.a.onNext(Integer.valueOf(i2));
        }
    }

    /* JADX INFO: compiled from: SnackbarDismissesOnSubscribe.java */
    class b extends rx.l.a {
        b() {
        }

        @Override // rx.l.a
        protected void onUnsubscribe() {
            d.this.f21138f.d0(null);
        }
    }

    d(Snackbar snackbar) {
        this.f21138f = snackbar;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(j<? super Integer> jVar) {
        rx.l.a.verifyMainThread();
        a aVar = new a(jVar);
        jVar.add(new b());
        this.f21138f.d0(aVar);
    }
}
