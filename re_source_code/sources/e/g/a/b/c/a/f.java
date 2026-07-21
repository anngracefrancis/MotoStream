package e.g.a.b.c.a;

import androidx.appcompat.widget.SearchView;
import rx.j;

/* JADX INFO: compiled from: SearchViewQueryTextChangeEventsOnSubscribe.java */
/* JADX INFO: loaded from: classes2.dex */
final class f implements rx.e.a<g> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final SearchView f21153f;

    /* JADX INFO: compiled from: SearchViewQueryTextChangeEventsOnSubscribe.java */
    class a implements SearchView.l {
        final /* synthetic */ j a;

        a(j jVar) {
            this.a = jVar;
        }

        @Override // androidx.appcompat.widget.SearchView.l
        public boolean a(String str) {
            if (this.a.isUnsubscribed()) {
                return false;
            }
            this.a.onNext(g.b(f.this.f21153f, str, false));
            return true;
        }

        @Override // androidx.appcompat.widget.SearchView.l
        public boolean b(String str) {
            if (this.a.isUnsubscribed()) {
                return false;
            }
            j jVar = this.a;
            SearchView searchView = f.this.f21153f;
            jVar.onNext(g.b(searchView, searchView.getQuery(), true));
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchViewQueryTextChangeEventsOnSubscribe.java */
    class b extends rx.l.a {
        b() {
        }

        @Override // rx.l.a
        protected void onUnsubscribe() {
            f.this.f21153f.setOnQueryTextListener(null);
        }
    }

    f(SearchView searchView) {
        this.f21153f = searchView;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(j<? super g> jVar) {
        rx.l.a.verifyMainThread();
        a aVar = new a(jVar);
        jVar.add(new b());
        this.f21153f.setOnQueryTextListener(aVar);
        SearchView searchView = this.f21153f;
        jVar.onNext(g.b(searchView, searchView.getQuery(), false));
    }
}
