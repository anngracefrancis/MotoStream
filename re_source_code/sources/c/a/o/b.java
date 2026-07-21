package c.a.o;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: compiled from: ActionMode.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f2802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2803g;

    /* JADX INFO: compiled from: ActionMode.java */
    public interface a {
        void a(b bVar);

        boolean b(b bVar, Menu menu);

        boolean c(b bVar, Menu menu);

        boolean d(b bVar, MenuItem menuItem);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f2802f;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.f2803g;
    }

    public abstract void k();

    public abstract boolean l();

    public abstract void m(View view);

    public abstract void n(int i2);

    public abstract void o(CharSequence charSequence);

    public void p(Object obj) {
        this.f2802f = obj;
    }

    public abstract void q(int i2);

    public abstract void r(CharSequence charSequence);

    public void s(boolean z) {
        this.f2803g = z;
    }
}
