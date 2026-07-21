package e.g.a.b.a.a;

import com.google.android.material.appbar.AppBarLayout;
import rx.e;
import rx.j;

/* JADX INFO: compiled from: AppBarLayoutOffsetChangeOnSubscribe.java */
/* JADX INFO: loaded from: classes2.dex */
final class a implements e.a<Integer> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final AppBarLayout f21134f;

    /* JADX INFO: renamed from: e.g.a.b.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppBarLayoutOffsetChangeOnSubscribe.java */
    class C0266a implements AppBarLayout.e {
        final /* synthetic */ j a;

        C0266a(j jVar) {
            this.a = jVar;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            if (this.a.isUnsubscribed()) {
                return;
            }
            this.a.onNext(Integer.valueOf(i2));
        }
    }

    /* JADX INFO: compiled from: AppBarLayoutOffsetChangeOnSubscribe.java */
    class b extends rx.l.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ AppBarLayout.e f21136f;

        b(AppBarLayout.e eVar) {
            this.f21136f = eVar;
        }

        @Override // rx.l.a
        protected void onUnsubscribe() {
            a.this.f21134f.p(this.f21136f);
        }
    }

    a(AppBarLayout appBarLayout) {
        this.f21134f = appBarLayout;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(j<? super Integer> jVar) {
        rx.l.a.verifyMainThread();
        C0266a c0266a = new C0266a(jVar);
        jVar.add(new b(c0266a));
        this.f21134f.b(c0266a);
    }
}
