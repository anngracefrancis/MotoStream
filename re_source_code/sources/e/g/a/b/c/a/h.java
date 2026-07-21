package e.g.a.b.c.a;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import rx.j;

/* JADX INFO: compiled from: ToolbarItemClickOnSubscribe.java */
/* JADX INFO: loaded from: classes2.dex */
final class h implements rx.e.a<MenuItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Toolbar f21158f;

    /* JADX INFO: compiled from: ToolbarItemClickOnSubscribe.java */
    class a implements Toolbar.f {
        final /* synthetic */ j a;

        a(j jVar) {
            this.a = jVar;
        }

        @Override // androidx.appcompat.widget.Toolbar.f
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (this.a.isUnsubscribed()) {
                return true;
            }
            this.a.onNext(menuItem);
            return true;
        }
    }

    /* JADX INFO: compiled from: ToolbarItemClickOnSubscribe.java */
    class b extends rx.l.a {
        b() {
        }

        @Override // rx.l.a
        protected void onUnsubscribe() {
            h.this.f21158f.setOnMenuItemClickListener(null);
        }
    }

    h(Toolbar toolbar) {
        this.f21158f = toolbar;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(j<? super MenuItem> jVar) {
        rx.l.a.verifyMainThread();
        a aVar = new a(jVar);
        jVar.add(new b());
        this.f21158f.setOnMenuItemClickListener(aVar);
    }
}
