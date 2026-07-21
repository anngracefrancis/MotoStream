package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: FragmentManagerViewModel.java */
/* JADX INFO: loaded from: classes.dex */
final class n extends androidx.lifecycle.x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final androidx.lifecycle.y.b f1624c = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f1628g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap<String, Fragment> f1625d = new HashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashMap<String, n> f1626e = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashMap<String, androidx.lifecycle.z> f1627f = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1629h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1630i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1631j = false;

    /* JADX INFO: compiled from: FragmentManagerViewModel.java */
    class a implements androidx.lifecycle.y.b {
        a() {
        }

        @Override // androidx.lifecycle.y.b
        public <T extends androidx.lifecycle.x> T a(Class<T> cls) {
            return new n(true);
        }
    }

    n(boolean z) {
        this.f1628g = z;
    }

    static n j(androidx.lifecycle.z zVar) {
        return (n) new androidx.lifecycle.y(zVar, f1624c).a(n.class);
    }

    @Override // androidx.lifecycle.x
    protected void d() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f1629h = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        return this.f1625d.equals(nVar.f1625d) && this.f1626e.equals(nVar.f1626e) && this.f1627f.equals(nVar.f1627f);
    }

    void f(Fragment fragment) {
        if (this.f1631j) {
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f1625d.containsKey(fragment.mWho)) {
                return;
            }
            this.f1625d.put(fragment.mWho, fragment);
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    void g(Fragment fragment) {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        n nVar = this.f1626e.get(fragment.mWho);
        if (nVar != null) {
            nVar.d();
            this.f1626e.remove(fragment.mWho);
        }
        androidx.lifecycle.z zVar = this.f1627f.get(fragment.mWho);
        if (zVar != null) {
            zVar.a();
            this.f1627f.remove(fragment.mWho);
        }
    }

    Fragment h(String str) {
        return this.f1625d.get(str);
    }

    public int hashCode() {
        return (((this.f1625d.hashCode() * 31) + this.f1626e.hashCode()) * 31) + this.f1627f.hashCode();
    }

    n i(Fragment fragment) {
        n nVar = this.f1626e.get(fragment.mWho);
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = new n(this.f1628g);
        this.f1626e.put(fragment.mWho, nVar2);
        return nVar2;
    }

    Collection<Fragment> k() {
        return new ArrayList(this.f1625d.values());
    }

    androidx.lifecycle.z l(Fragment fragment) {
        androidx.lifecycle.z zVar = this.f1627f.get(fragment.mWho);
        if (zVar != null) {
            return zVar;
        }
        androidx.lifecycle.z zVar2 = new androidx.lifecycle.z();
        this.f1627f.put(fragment.mWho, zVar2);
        return zVar2;
    }

    boolean m() {
        return this.f1629h;
    }

    void n(Fragment fragment) {
        if (this.f1631j) {
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        if ((this.f1625d.remove(fragment.mWho) != null) && FragmentManager.H0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    void o(boolean z) {
        this.f1631j = z;
    }

    boolean p(Fragment fragment) {
        if (this.f1625d.containsKey(fragment.mWho)) {
            return this.f1628g ? this.f1629h : !this.f1630i;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f1625d.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f1626e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f1627f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
