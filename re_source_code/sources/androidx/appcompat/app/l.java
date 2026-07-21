package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.r0;
import androidx.appcompat.widget.x;
import androidx.core.view.u;
import java.util.ArrayList;

/* JADX INFO: compiled from: ToolbarActionBar.java */
/* JADX INFO: loaded from: classes.dex */
class l extends androidx.appcompat.app.a {
    x a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Window.Callback f210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<androidx.appcompat.app.a.b> f213f = new ArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Runnable f214g = new a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Toolbar.f f215h;

    /* JADX INFO: compiled from: ToolbarActionBar.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.A();
        }
    }

    /* JADX INFO: compiled from: ToolbarActionBar.java */
    class b implements Toolbar.f {
        b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.f
        public boolean onMenuItemClick(MenuItem menuItem) {
            return l.this.f210c.onMenuItemSelected(0, menuItem);
        }
    }

    /* JADX INFO: compiled from: ToolbarActionBar.java */
    private final class c implements androidx.appcompat.view.menu.m.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f217f;

        c() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
            if (this.f217f) {
                return;
            }
            this.f217f = true;
            l.this.a.h();
            Window.Callback callback = l.this.f210c;
            if (callback != null) {
                callback.onPanelClosed(108, gVar);
            }
            this.f217f = false;
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            Window.Callback callback = l.this.f210c;
            if (callback == null) {
                return false;
            }
            callback.onMenuOpened(108, gVar);
            return true;
        }
    }

    /* JADX INFO: compiled from: ToolbarActionBar.java */
    private final class d implements androidx.appcompat.view.menu.g.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
            l lVar = l.this;
            if (lVar.f210c != null) {
                if (lVar.a.b()) {
                    l.this.f210c.onPanelClosed(108, gVar);
                } else if (l.this.f210c.onPreparePanel(0, null, gVar)) {
                    l.this.f210c.onMenuOpened(108, gVar);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ToolbarActionBar.java */
    private class e extends c.a.o.i {
        public e(Window.Callback callback) {
            super(callback);
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public View onCreatePanelView(int i2) {
            return i2 == 0 ? new View(l.this.a.getContext()) : super.onCreatePanelView(i2);
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public boolean onPreparePanel(int i2, View view, Menu menu) {
            boolean zOnPreparePanel = super.onPreparePanel(i2, view, menu);
            if (zOnPreparePanel) {
                l lVar = l.this;
                if (!lVar.f209b) {
                    lVar.a.c();
                    l.this.f209b = true;
                }
            }
            return zOnPreparePanel;
        }
    }

    l(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.f215h = bVar;
        this.a = new r0(toolbar, false);
        e eVar = new e(callback);
        this.f210c = eVar;
        this.a.setWindowCallback(eVar);
        toolbar.setOnMenuItemClickListener(bVar);
        this.a.setWindowTitle(charSequence);
    }

    private Menu y() {
        if (!this.f211d) {
            this.a.p(new c(), new d());
            this.f211d = true;
        }
        return this.a.l();
    }

    void A() {
        Menu menuY = y();
        androidx.appcompat.view.menu.g gVar = menuY instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) menuY : null;
        if (gVar != null) {
            gVar.h0();
        }
        try {
            menuY.clear();
            if (!this.f210c.onCreatePanelMenu(0, menuY) || !this.f210c.onPreparePanel(0, null, menuY)) {
                menuY.clear();
            }
        } finally {
            if (gVar != null) {
                gVar.g0();
            }
        }
    }

    public void B(int i2, int i3) {
        this.a.k((i2 & i3) | ((i3 ^ (-1)) & this.a.t()));
    }

    @Override // androidx.appcompat.app.a
    public boolean f() {
        return this.a.f();
    }

    @Override // androidx.appcompat.app.a
    public boolean g() {
        if (!this.a.j()) {
            return false;
        }
        this.a.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void h(boolean z) {
        if (z == this.f212e) {
            return;
        }
        this.f212e = z;
        int size = this.f213f.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f213f.get(i2).a(z);
        }
    }

    @Override // androidx.appcompat.app.a
    public int i() {
        return this.a.t();
    }

    @Override // androidx.appcompat.app.a
    public Context j() {
        return this.a.getContext();
    }

    @Override // androidx.appcompat.app.a
    public boolean k() {
        this.a.r().removeCallbacks(this.f214g);
        u.a0(this.a.r(), this.f214g);
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void l(Configuration configuration) {
        super.l(configuration);
    }

    @Override // androidx.appcompat.app.a
    void m() {
        this.a.r().removeCallbacks(this.f214g);
    }

    @Override // androidx.appcompat.app.a
    public boolean n(int i2, KeyEvent keyEvent) {
        Menu menuY = y();
        if (menuY == null) {
            return false;
        }
        menuY.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuY.performShortcut(i2, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public boolean o(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            p();
        }
        return true;
    }

    @Override // androidx.appcompat.app.a
    public boolean p() {
        return this.a.g();
    }

    @Override // androidx.appcompat.app.a
    public void q(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z) {
        B(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z) {
        B(z ? 2 : 0, 2);
    }

    @Override // androidx.appcompat.app.a
    public void t(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void u(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void v(CharSequence charSequence) {
        this.a.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public void w(CharSequence charSequence) {
        this.a.setWindowTitle(charSequence);
    }

    public Window.Callback z() {
        return this.f210c;
    }
}
