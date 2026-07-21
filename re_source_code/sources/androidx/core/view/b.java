package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: compiled from: ActionProvider.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f1005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterfaceC0024b f1006c;

    /* JADX INFO: compiled from: ActionProvider.java */
    public interface a {
    }

    /* JADX INFO: renamed from: androidx.core.view.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionProvider.java */
    public interface InterfaceC0024b {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public b(Context context) {
        this.a = context;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public void f(SubMenu subMenu) {
    }

    public boolean g() {
        return false;
    }

    public void h() {
        this.f1006c = null;
        this.f1005b = null;
    }

    public void i(a aVar) {
        this.f1005b = aVar;
    }

    public void j(InterfaceC0024b interfaceC0024b) {
        if (this.f1006c != null && interfaceC0024b != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f1006c = interfaceC0024b;
    }
}
