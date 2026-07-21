package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: FragmentLifecycleCallbacksDispatcher.java */
/* JADX INFO: loaded from: classes.dex */
class l {
    private final CopyOnWriteArrayList<a> a = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FragmentManager f1622b;

    /* JADX INFO: compiled from: FragmentLifecycleCallbacksDispatcher.java */
    private static final class a {
        final FragmentManager.m a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f1623b;
    }

    l(FragmentManager fragmentManager) {
        this.f1622b = fragmentManager;
    }

    void a(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragmentZ0 = this.f1622b.z0();
        if (fragmentZ0 != null) {
            fragmentZ0.getParentFragmentManager().y0().a(fragment, bundle, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.f1623b) {
                FragmentManager.m mVar = aVar.a;
                throw null;
            }
        }
    }

    void b(Fragment fragment, boolean z) {
        this.f1622b.w0().f();
        Fragment fragmentZ0 = this.f1622b.z0();
        if (fragmentZ0 != null) {
            fragmentZ0.getParentFragmentManager().y0().b(fragment, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.f1623b) {
                FragmentManager.m mVar = aVar.a;
                throw null;
            }
        }
    }

    void c(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragmentZ0 = this.f1622b.z0();
        if (fragmentZ0 != null) {
            fragmentZ0.getParentFragmentManager().y0().c(fragment, bundle, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.f1623b) {
                FragmentManager.m mVar = aVar.a;
                throw null;
            }
        }
    }

    void d(Fragment fragment, boolean z) {
        Fragment fragmentZ0 = this.f1622b.z0();
        if (fragmentZ0 != null) {
            fragmentZ0.getParentFragmentManager().y0().d(fragment, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.f1623b) {
                FragmentManager.m mVar = aVar.a;
                throw null;
            }
        }
    }

    void e(Fragment fragment, boolean z) {
        Fragment fragmentZ0 = this.f1622b.z0();
        if (fragmentZ0 != null) {
            fragmentZ0.getParentFragmentManager().y0().e(fragment, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.f1623b) {
                FragmentManager.m mVar = aVar.a;
                throw null;
            }
        }
    }

    void f(Fragment fragment, boolean z) {
        Fragment fragmentZ0 = this.f1622b.z0();
        if (fragmentZ0 != null) {
            fragmentZ0.getParentFragmentManager().y0().f(fragment, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.f1623b) {
                FragmentManager.m mVar = aVar.a;
                throw null;
            }
        }
    }

    void g(Fragment fragment, boolean z) {
        this.f1622b.w0().f();
        Fragment fragmentZ0 = this.f1622b.z0();
        if (fragmentZ0 != null) {
            fragmentZ0.getParentFragmentManager().y0().g(fragment, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.f1623b) {
                FragmentManager.m mVar = aVar.a;
                throw null;
            }
        }
    }

    void h(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragmentZ0 = this.f1622b.z0();
        if (fragmentZ0 != null) {
            fragmentZ0.getParentFragmentManager().y0().h(fragment, bundle, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.f1623b) {
                FragmentManager.m mVar = aVar.a;
                throw null;
            }
        }
    }

    void i(Fragment fragment, boolean z) {
        Fragment fragmentZ0 = this.f1622b.z0();
        if (fragmentZ0 != null) {
            fragmentZ0.getParentFragmentManager().y0().i(fragment, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.f1623b) {
                FragmentManager.m mVar = aVar.a;
                throw null;
            }
        }
    }

    void j(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragmentZ0 = this.f1622b.z0();
        if (fragmentZ0 != null) {
            fragmentZ0.getParentFragmentManager().y0().j(fragment, bundle, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.f1623b) {
                FragmentManager.m mVar = aVar.a;
                throw null;
            }
        }
    }

    void k(Fragment fragment, boolean z) {
        Fragment fragmentZ0 = this.f1622b.z0();
        if (fragmentZ0 != null) {
            fragmentZ0.getParentFragmentManager().y0().k(fragment, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.f1623b) {
                FragmentManager.m mVar = aVar.a;
                throw null;
            }
        }
    }

    void l(Fragment fragment, boolean z) {
        Fragment fragmentZ0 = this.f1622b.z0();
        if (fragmentZ0 != null) {
            fragmentZ0.getParentFragmentManager().y0().l(fragment, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.f1623b) {
                FragmentManager.m mVar = aVar.a;
                throw null;
            }
        }
    }

    void m(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment fragmentZ0 = this.f1622b.z0();
        if (fragmentZ0 != null) {
            fragmentZ0.getParentFragmentManager().y0().m(fragment, view, bundle, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.f1623b) {
                FragmentManager.m mVar = aVar.a;
                throw null;
            }
        }
    }

    void n(Fragment fragment, boolean z) {
        Fragment fragmentZ0 = this.f1622b.z0();
        if (fragmentZ0 != null) {
            fragmentZ0.getParentFragmentManager().y0().n(fragment, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.f1623b) {
                FragmentManager.m mVar = aVar.a;
                throw null;
            }
        }
    }
}
