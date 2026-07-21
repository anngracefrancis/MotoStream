package androidx.fragment.app;

import android.util.Log;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: compiled from: BackStackRecord.java */
/* JADX INFO: loaded from: classes.dex */
final class a extends u implements FragmentManager.k, FragmentManager.o {
    final FragmentManager t;
    boolean u;
    int v;

    a(FragmentManager fragmentManager) {
        super(fragmentManager.t0(), fragmentManager.w0() != null ? fragmentManager.w0().f().getClassLoader() : null);
        this.v = -1;
        this.t = fragmentManager;
    }

    private static boolean E(u.a aVar) {
        Fragment fragment = aVar.f1650b;
        return (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
    }

    void A(boolean z) {
        for (int size = this.f1641c.size() - 1; size >= 0; size--) {
            u.a aVar = this.f1641c.get(size);
            Fragment fragment = aVar.f1650b;
            if (fragment != null) {
                fragment.setNextTransition(FragmentManager.l1(this.f1646h));
                fragment.setSharedElementNames(this.q, this.p);
            }
            switch (aVar.a) {
                case 1:
                    fragment.setNextAnim(aVar.f1654f);
                    this.t.p1(fragment, true);
                    this.t.g1(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                case 3:
                    fragment.setNextAnim(aVar.f1653e);
                    this.t.g(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.f1653e);
                    this.t.t1(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.f1654f);
                    this.t.p1(fragment, true);
                    this.t.F0(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.f1653e);
                    this.t.l(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.f1654f);
                    this.t.p1(fragment, true);
                    this.t.y(fragment);
                    break;
                case 8:
                    this.t.r1(null);
                    break;
                case 9:
                    this.t.r1(fragment);
                    break;
                case 10:
                    this.t.q1(fragment, aVar.f1655g);
                    break;
            }
            if (!this.r && aVar.a != 3 && fragment != null && !FragmentManager.f1494b) {
                this.t.R0(fragment);
            }
        }
        if (this.r || !z || FragmentManager.f1494b) {
            return;
        }
        FragmentManager fragmentManager = this.t;
        fragmentManager.S0(fragmentManager.s, true);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b2  */
    Fragment B(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i2 = 0;
        while (i2 < this.f1641c.size()) {
            u.a aVar = this.f1641c.get(i2);
            int i3 = aVar.a;
            if (i3 == 1) {
                arrayList.add(aVar.f1650b);
            } else if (i3 == 2) {
                Fragment fragment3 = aVar.f1650b;
                int i4 = fragment3.mContainerId;
                boolean z = false;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Fragment fragment4 = arrayList.get(size);
                    if (fragment4.mContainerId == i4) {
                        if (fragment4 == fragment3) {
                            z = true;
                        } else {
                            if (fragment4 == fragment2) {
                                this.f1641c.add(i2, new u.a(9, fragment4));
                                i2++;
                                fragment2 = null;
                            }
                            u.a aVar2 = new u.a(3, fragment4);
                            aVar2.f1651c = aVar.f1651c;
                            aVar2.f1653e = aVar.f1653e;
                            aVar2.f1652d = aVar.f1652d;
                            aVar2.f1654f = aVar.f1654f;
                            this.f1641c.add(i2, aVar2);
                            arrayList.remove(fragment4);
                            i2++;
                        }
                    }
                }
                if (z) {
                    this.f1641c.remove(i2);
                    i2--;
                } else {
                    aVar.a = 1;
                    arrayList.add(fragment3);
                }
            } else if (i3 == 3 || i3 == 6) {
                arrayList.remove(aVar.f1650b);
                Fragment fragment5 = aVar.f1650b;
                if (fragment5 == fragment2) {
                    this.f1641c.add(i2, new u.a(9, fragment5));
                    i2++;
                    fragment2 = null;
                }
            } else if (i3 == 7) {
                arrayList.add(aVar.f1650b);
            } else if (i3 == 8) {
                this.f1641c.add(i2, new u.a(9, fragment2));
                i2++;
                fragment2 = aVar.f1650b;
            }
            i2++;
        }
        return fragment2;
    }

    boolean C(int i2) {
        int size = this.f1641c.size();
        for (int i3 = 0; i3 < size; i3++) {
            Fragment fragment = this.f1641c.get(i3).f1650b;
            int i4 = fragment != null ? fragment.mContainerId : 0;
            if (i4 != 0 && i4 == i2) {
                return true;
            }
        }
        return false;
    }

    boolean D(ArrayList<a> arrayList, int i2, int i3) {
        if (i3 == i2) {
            return false;
        }
        int size = this.f1641c.size();
        int i4 = -1;
        for (int i5 = 0; i5 < size; i5++) {
            Fragment fragment = this.f1641c.get(i5).f1650b;
            int i6 = fragment != null ? fragment.mContainerId : 0;
            if (i6 != 0 && i6 != i4) {
                for (int i7 = i2; i7 < i3; i7++) {
                    a aVar = arrayList.get(i7);
                    int size2 = aVar.f1641c.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        Fragment fragment2 = aVar.f1641c.get(i8).f1650b;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i6) {
                            return true;
                        }
                    }
                }
                i4 = i6;
            }
        }
        return false;
    }

    boolean F() {
        for (int i2 = 0; i2 < this.f1641c.size(); i2++) {
            if (E(this.f1641c.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public void G() {
        if (this.s != null) {
            for (int i2 = 0; i2 < this.s.size(); i2++) {
                this.s.get(i2).run();
            }
            this.s = null;
        }
    }

    void H(Fragment.k kVar) {
        for (int i2 = 0; i2 < this.f1641c.size(); i2++) {
            u.a aVar = this.f1641c.get(i2);
            if (E(aVar)) {
                aVar.f1650b.setOnStartEnterTransitionListener(kVar);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    /* JADX WARN: Code duplicated, block: B:14:0x002d  */
    Fragment I(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f1641c.size() - 1; size >= 0; size--) {
            u.a aVar = this.f1641c.get(size);
            int i2 = aVar.a;
            if (i2 == 1) {
                arrayList.remove(aVar.f1650b);
            } else if (i2 != 3) {
                switch (i2) {
                    case 6:
                        arrayList.add(aVar.f1650b);
                        break;
                    case 7:
                        arrayList.remove(aVar.f1650b);
                        break;
                    case 8:
                        fragment = null;
                        break;
                    case 9:
                        fragment = aVar.f1650b;
                        break;
                    case 10:
                        aVar.f1656h = aVar.f1655g;
                        break;
                }
            } else {
                arrayList.add(aVar.f1650b);
            }
        }
        return fragment;
    }

    @Override // androidx.fragment.app.FragmentManager.o
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f1647i) {
            return true;
        }
        this.t.e(this);
        return true;
    }

    @Override // androidx.fragment.app.FragmentManager.k
    public String getName() {
        return this.f1649k;
    }

    @Override // androidx.fragment.app.u
    public int i() {
        return w(false);
    }

    @Override // androidx.fragment.app.u
    public int j() {
        return w(true);
    }

    @Override // androidx.fragment.app.u
    public void k() {
        n();
        this.t.c0(this, false);
    }

    @Override // androidx.fragment.app.u
    public void l() {
        n();
        this.t.c0(this, true);
    }

    @Override // androidx.fragment.app.u
    public u m(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.t) {
            return super.m(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.u
    void o(int i2, Fragment fragment, String str, int i3) {
        super.o(i2, fragment, str, i3);
        fragment.mFragmentManager = this.t;
    }

    @Override // androidx.fragment.app.u
    public u p(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.t) {
            return super.p(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.u
    public u t(Fragment fragment, androidx.lifecycle.g.c cVar) {
        if (fragment.mFragmentManager != this.t) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.t);
        }
        if (cVar == androidx.lifecycle.g.c.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + cVar + " after the Fragment has been created");
        }
        if (cVar != androidx.lifecycle.g.c.DESTROYED) {
            return super.t(fragment, cVar);
        }
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + cVar + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.v >= 0) {
            sb.append(" #");
            sb.append(this.v);
        }
        if (this.f1649k != null) {
            sb.append(" ");
            sb.append(this.f1649k);
        }
        sb.append("}");
        return sb.toString();
    }

    void v(int i2) {
        if (this.f1647i) {
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            int size = this.f1641c.size();
            for (int i3 = 0; i3 < size; i3++) {
                u.a aVar = this.f1641c.get(i3);
                Fragment fragment = aVar.f1650b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i2;
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f1650b + " to " + aVar.f1650b.mBackStackNesting);
                    }
                }
            }
        }
    }

    int w(boolean z) {
        if (this.u) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new z("FragmentManager"));
            x("  ", printWriter);
            printWriter.close();
        }
        this.u = true;
        if (this.f1647i) {
            this.v = this.t.j();
        } else {
            this.v = -1;
        }
        this.t.Z(this, z);
        return this.v;
    }

    public void x(String str, PrintWriter printWriter) {
        y(str, printWriter, true);
    }

    public void y(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1649k);
            printWriter.print(" mIndex=");
            printWriter.print(this.v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.u);
            if (this.f1646h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1646h));
            }
            if (this.f1642d != 0 || this.f1643e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1642d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1643e));
            }
            if (this.f1644f != 0 || this.f1645g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1644f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1645g));
            }
            if (this.l != 0 || this.m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.m);
            }
            if (this.n != 0 || this.o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.o);
            }
        }
        if (this.f1641c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f1641c.size();
        for (int i2 = 0; i2 < size; i2++) {
            u.a aVar = this.f1641c.get(i2);
            switch (aVar.a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i2);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f1650b);
            if (z) {
                if (aVar.f1651c != 0 || aVar.f1652d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f1651c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f1652d));
                }
                if (aVar.f1653e != 0 || aVar.f1654f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f1653e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f1654f));
                }
            }
        }
    }

    void z() {
        int size = this.f1641c.size();
        for (int i2 = 0; i2 < size; i2++) {
            u.a aVar = this.f1641c.get(i2);
            Fragment fragment = aVar.f1650b;
            if (fragment != null) {
                fragment.setNextTransition(this.f1646h);
                fragment.setSharedElementNames(this.p, this.q);
            }
            switch (aVar.a) {
                case 1:
                    fragment.setNextAnim(aVar.f1651c);
                    this.t.p1(fragment, false);
                    this.t.g(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                case 3:
                    fragment.setNextAnim(aVar.f1652d);
                    this.t.g1(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.f1652d);
                    this.t.F0(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.f1651c);
                    this.t.p1(fragment, false);
                    this.t.t1(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.f1652d);
                    this.t.y(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.f1651c);
                    this.t.p1(fragment, false);
                    this.t.l(fragment);
                    break;
                case 8:
                    this.t.r1(fragment);
                    break;
                case 9:
                    this.t.r1(null);
                    break;
                case 10:
                    this.t.q1(fragment, aVar.f1656h);
                    break;
            }
            if (!this.r && aVar.a != 1 && fragment != null && !FragmentManager.f1494b) {
                this.t.R0(fragment);
            }
        }
        if (this.r || FragmentManager.f1494b) {
            return;
        }
        FragmentManager fragmentManager = this.t;
        fragmentManager.S0(fragmentManager.s, true);
    }
}
