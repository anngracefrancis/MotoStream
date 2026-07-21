package e.g.a.b.b.a;

import androidx.core.widget.NestedScrollView;
import e.g.a.c.f;
import rx.e;
import rx.j;

/* JADX INFO: compiled from: NestedScrollViewScrollChangeEventOnSubscribe.java */
/* JADX INFO: loaded from: classes2.dex */
final class a implements e.a<f> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final NestedScrollView f21141f;

    /* JADX INFO: renamed from: e.g.a.b.b.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NestedScrollViewScrollChangeEventOnSubscribe.java */
    class C0267a implements NestedScrollView.b {
        final /* synthetic */ j a;

        C0267a(j jVar) {
            this.a = jVar;
        }

        @Override // androidx.core.widget.NestedScrollView.b
        public void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
            if (this.a.isUnsubscribed()) {
                return;
            }
            this.a.onNext(f.b(a.this.f21141f, i2, i3, i4, i5));
        }
    }

    /* JADX INFO: compiled from: NestedScrollViewScrollChangeEventOnSubscribe.java */
    class b extends rx.l.a {
        b() {
        }

        @Override // rx.l.a
        protected void onUnsubscribe() {
            a.this.f21141f.setOnScrollChangeListener((NestedScrollView.b) null);
        }
    }

    a(NestedScrollView nestedScrollView) {
        this.f21141f = nestedScrollView;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(j<? super f> jVar) {
        rx.l.a.verifyMainThread();
        C0267a c0267a = new C0267a(jVar);
        jVar.add(new b());
        this.f21141f.setOnScrollChangeListener(c0267a);
    }
}
