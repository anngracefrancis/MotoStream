package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: FragmentStore.java */
/* JADX INFO: loaded from: classes.dex */
class t {
    private final ArrayList<Fragment> a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<String, r> f1638b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private n f1639c;

    t() {
    }

    void a(Fragment fragment) {
        if (this.a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.a) {
            this.a.add(fragment);
        }
        fragment.mAdded = true;
    }

    void b() {
        this.f1638b.values().removeAll(Collections.singleton(null));
    }

    boolean c(String str) {
        return this.f1638b.get(str) != null;
    }

    void d(int i2) {
        for (r rVar : this.f1638b.values()) {
            if (rVar != null) {
                rVar.u(i2);
            }
        }
    }

    void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f1638b.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments:");
            for (r rVar : this.f1638b.values()) {
                printWriter.print(str);
                if (rVar != null) {
                    Fragment fragmentK = rVar.k();
                    printWriter.println(fragmentK);
                    fragmentK.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = this.a.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    Fragment f(String str) {
        r rVar = this.f1638b.get(str);
        if (rVar != null) {
            return rVar.k();
        }
        return null;
    }

    Fragment g(int i2) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.a.get(size);
            if (fragment != null && fragment.mFragmentId == i2) {
                return fragment;
            }
        }
        for (r rVar : this.f1638b.values()) {
            if (rVar != null) {
                Fragment fragmentK = rVar.k();
                if (fragmentK.mFragmentId == i2) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    Fragment h(String str) {
        if (str != null) {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (r rVar : this.f1638b.values()) {
            if (rVar != null) {
                Fragment fragmentK = rVar.k();
                if (str.equals(fragmentK.mTag)) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    Fragment i(String str) {
        Fragment fragmentFindFragmentByWho;
        for (r rVar : this.f1638b.values()) {
            if (rVar != null && (fragmentFindFragmentByWho = rVar.k().findFragmentByWho(str)) != null) {
                return fragmentFindFragmentByWho;
            }
        }
        return null;
    }

    int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int iIndexOf = this.a.indexOf(fragment);
        for (int i2 = iIndexOf - 1; i2 >= 0; i2--) {
            Fragment fragment2 = this.a.get(i2);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.a.size()) {
                return -1;
            }
            Fragment fragment3 = this.a.get(iIndexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    List<r> k() {
        ArrayList arrayList = new ArrayList();
        for (r rVar : this.f1638b.values()) {
            if (rVar != null) {
                arrayList.add(rVar);
            }
        }
        return arrayList;
    }

    List<Fragment> l() {
        ArrayList arrayList = new ArrayList();
        for (r rVar : this.f1638b.values()) {
            if (rVar != null) {
                arrayList.add(rVar.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    r m(String str) {
        return this.f1638b.get(str);
    }

    List<Fragment> n() {
        ArrayList arrayList;
        if (this.a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.a) {
            arrayList = new ArrayList(this.a);
        }
        return arrayList;
    }

    n o() {
        return this.f1639c;
    }

    void p(r rVar) {
        Fragment fragmentK = rVar.k();
        if (c(fragmentK.mWho)) {
            return;
        }
        this.f1638b.put(fragmentK.mWho, rVar);
        if (fragmentK.mRetainInstanceChangedWhileDetached) {
            if (fragmentK.mRetainInstance) {
                this.f1639c.f(fragmentK);
            } else {
                this.f1639c.n(fragmentK);
            }
            fragmentK.mRetainInstanceChangedWhileDetached = false;
        }
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragmentK);
        }
    }

    void q(r rVar) {
        Fragment fragmentK = rVar.k();
        if (fragmentK.mRetainInstance) {
            this.f1639c.n(fragmentK);
        }
        if (this.f1638b.put(fragmentK.mWho, null) != null && FragmentManager.H0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragmentK);
        }
    }

    void r() {
        Iterator<Fragment> it = this.a.iterator();
        while (it.hasNext()) {
            r rVar = this.f1638b.get(it.next().mWho);
            if (rVar != null) {
                rVar.m();
            }
        }
        for (r rVar2 : this.f1638b.values()) {
            if (rVar2 != null) {
                rVar2.m();
                Fragment fragmentK = rVar2.k();
                if (fragmentK.mRemoving && !fragmentK.isInBackStack()) {
                    q(rVar2);
                }
            }
        }
    }

    void s(Fragment fragment) {
        synchronized (this.a) {
            this.a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    void t() {
        this.f1638b.clear();
    }

    void u(List<String> list) {
        this.a.clear();
        if (list != null) {
            for (String str : list) {
                Fragment fragmentF = f(str);
                if (fragmentF == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + fragmentF);
                }
                a(fragmentF);
            }
        }
    }

    ArrayList<FragmentState> v() {
        ArrayList<FragmentState> arrayList = new ArrayList<>(this.f1638b.size());
        for (r rVar : this.f1638b.values()) {
            if (rVar != null) {
                Fragment fragmentK = rVar.k();
                FragmentState fragmentStateS = rVar.s();
                arrayList.add(fragmentStateS);
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragmentK + ": " + fragmentStateS.r);
                }
            }
        }
        return arrayList;
    }

    ArrayList<String> w() {
        synchronized (this.a) {
            if (this.a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.a.size());
            for (Fragment fragment : this.a) {
                arrayList.add(fragment.mWho);
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment.mWho + "): " + fragment);
                }
            }
            return arrayList;
        }
    }

    void x(n nVar) {
        this.f1639c = nVar;
    }
}
