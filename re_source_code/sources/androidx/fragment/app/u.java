package androidx.fragment.app;

import android.view.ViewGroup;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: compiled from: FragmentTransaction.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class u {
    private final i a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ClassLoader f1640b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f1642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f1643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f1644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f1645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f1646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f1647i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    String f1649k;
    int l;
    CharSequence m;
    int n;
    CharSequence o;
    ArrayList<String> p;
    ArrayList<String> q;
    ArrayList<Runnable> s;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ArrayList<a> f1641c = new ArrayList<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f1648j = true;
    boolean r = false;

    /* JADX INFO: compiled from: FragmentTransaction.java */
    static final class a {
        int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Fragment f1650b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1651c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1652d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1653e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1654f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        androidx.lifecycle.g.c f1655g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        androidx.lifecycle.g.c f1656h;

        a() {
        }

        a(int i2, Fragment fragment) {
            this.a = i2;
            this.f1650b = fragment;
            androidx.lifecycle.g.c cVar = androidx.lifecycle.g.c.RESUMED;
            this.f1655g = cVar;
            this.f1656h = cVar;
        }

        a(int i2, Fragment fragment, androidx.lifecycle.g.c cVar) {
            this.a = i2;
            this.f1650b = fragment;
            this.f1655g = fragment.mMaxState;
            this.f1656h = cVar;
        }
    }

    u(i iVar, ClassLoader classLoader) {
        this.a = iVar;
        this.f1640b = classLoader;
    }

    public u b(int i2, Fragment fragment) {
        o(i2, fragment, null, 1);
        return this;
    }

    public u c(int i2, Fragment fragment, String str) {
        o(i2, fragment, str, 1);
        return this;
    }

    u d(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        return c(viewGroup.getId(), fragment, str);
    }

    public u e(Fragment fragment, String str) {
        o(0, fragment, str, 1);
        return this;
    }

    void f(a aVar) {
        this.f1641c.add(aVar);
        aVar.f1651c = this.f1642d;
        aVar.f1652d = this.f1643e;
        aVar.f1653e = this.f1644f;
        aVar.f1654f = this.f1645g;
    }

    public u g(String str) {
        if (!this.f1648j) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.f1647i = true;
        this.f1649k = str;
        return this;
    }

    public u h(Fragment fragment) {
        f(new a(7, fragment));
        return this;
    }

    public abstract int i();

    public abstract int j();

    public abstract void k();

    public abstract void l();

    public u m(Fragment fragment) {
        f(new a(6, fragment));
        return this;
    }

    public u n() {
        if (this.f1647i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f1648j = false;
        return this;
    }

    void o(int i2, Fragment fragment, String str, int i3) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.mTag;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i2 != 0) {
            if (i2 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i4 = fragment.mFragmentId;
            if (i4 != 0 && i4 != i2) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i2);
            }
            fragment.mFragmentId = i2;
            fragment.mContainerId = i2;
        }
        f(new a(i3, fragment));
    }

    public u p(Fragment fragment) {
        f(new a(3, fragment));
        return this;
    }

    public u q(int i2, Fragment fragment) {
        return r(i2, fragment, null);
    }

    public u r(int i2, Fragment fragment, String str) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        o(i2, fragment, str, 2);
        return this;
    }

    public u s(int i2, int i3, int i4, int i5) {
        this.f1642d = i2;
        this.f1643e = i3;
        this.f1644f = i4;
        this.f1645g = i5;
        return this;
    }

    public u t(Fragment fragment, androidx.lifecycle.g.c cVar) {
        f(new a(10, fragment, cVar));
        return this;
    }

    public u u(boolean z) {
        this.r = z;
        return this;
    }
}
