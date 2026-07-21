package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ChildHelper.java */
/* JADX INFO: loaded from: classes.dex */
class d {
    final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final a f2013b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final List<View> f2014c = new ArrayList();

    /* JADX INFO: compiled from: ChildHelper.java */
    static class a {
        long a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a f2015b;

        a() {
        }

        private void c() {
            if (this.f2015b == null) {
                this.f2015b = new a();
            }
        }

        void a(int i2) {
            if (i2 < 64) {
                this.a &= (1 << i2) ^ (-1);
                return;
            }
            a aVar = this.f2015b;
            if (aVar != null) {
                aVar.a(i2 - 64);
            }
        }

        int b(int i2) {
            a aVar = this.f2015b;
            if (aVar == null) {
                return i2 >= 64 ? Long.bitCount(this.a) : Long.bitCount(this.a & ((1 << i2) - 1));
            }
            return i2 < 64 ? Long.bitCount(this.a & ((1 << i2) - 1)) : aVar.b(i2 - 64) + Long.bitCount(this.a);
        }

        boolean d(int i2) {
            if (i2 < 64) {
                return (this.a & (1 << i2)) != 0;
            }
            c();
            return this.f2015b.d(i2 - 64);
        }

        void e(int i2, boolean z) {
            if (i2 >= 64) {
                c();
                this.f2015b.e(i2 - 64, z);
                return;
            }
            long j2 = this.a;
            boolean z2 = (Long.MIN_VALUE & j2) != 0;
            long j3 = (1 << i2) - 1;
            this.a = ((j2 & (j3 ^ (-1))) << 1) | (j2 & j3);
            if (z) {
                h(i2);
            } else {
                a(i2);
            }
            if (z2 || this.f2015b != null) {
                c();
                this.f2015b.e(0, z2);
            }
        }

        boolean f(int i2) {
            if (i2 >= 64) {
                c();
                return this.f2015b.f(i2 - 64);
            }
            long j2 = 1 << i2;
            long j3 = this.a;
            boolean z = (j3 & j2) != 0;
            long j4 = j3 & (j2 ^ (-1));
            this.a = j4;
            long j5 = j2 - 1;
            this.a = (j4 & j5) | Long.rotateRight((j5 ^ (-1)) & j4, 1);
            a aVar = this.f2015b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f2015b.f(0);
            }
            return z;
        }

        void g() {
            this.a = 0L;
            a aVar = this.f2015b;
            if (aVar != null) {
                aVar.g();
            }
        }

        void h(int i2) {
            if (i2 < 64) {
                this.a |= 1 << i2;
            } else {
                c();
                this.f2015b.h(i2 - 64);
            }
        }

        public String toString() {
            if (this.f2015b == null) {
                return Long.toBinaryString(this.a);
            }
            return this.f2015b.toString() + "xx" + Long.toBinaryString(this.a);
        }
    }

    /* JADX INFO: compiled from: ChildHelper.java */
    interface b {
        View a(int i2);

        void b(View view);

        int c();

        void d();

        int e(View view);

        RecyclerView.c0 f(View view);

        void g(int i2);

        void h(View view);

        void i(View view, int i2);

        void j(int i2);

        void k(View view, int i2, ViewGroup.LayoutParams layoutParams);
    }

    d(b bVar) {
        this.a = bVar;
    }

    private int h(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int iC = this.a.c();
        int i3 = i2;
        while (i3 < iC) {
            int iB = i2 - (i3 - this.f2013b.b(i3));
            if (iB == 0) {
                while (this.f2013b.d(i3)) {
                    i3++;
                }
                return i3;
            }
            i3 += iB;
        }
        return -1;
    }

    private void l(View view) {
        this.f2014c.add(view);
        this.a.b(view);
    }

    private boolean t(View view) {
        if (!this.f2014c.remove(view)) {
            return false;
        }
        this.a.h(view);
        return true;
    }

    void a(View view, int i2, boolean z) {
        int iC = i2 < 0 ? this.a.c() : h(i2);
        this.f2013b.e(iC, z);
        if (z) {
            l(view);
        }
        this.a.i(view, iC);
    }

    void b(View view, boolean z) {
        a(view, -1, z);
    }

    void c(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iC = i2 < 0 ? this.a.c() : h(i2);
        this.f2013b.e(iC, z);
        if (z) {
            l(view);
        }
        this.a.k(view, iC, layoutParams);
    }

    void d(int i2) {
        int iH = h(i2);
        this.f2013b.f(iH);
        this.a.g(iH);
    }

    View e(int i2) {
        int size = this.f2014c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.f2014c.get(i3);
            RecyclerView.c0 c0VarF = this.a.f(view);
            if (c0VarF.getLayoutPosition() == i2 && !c0VarF.isInvalid() && !c0VarF.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    View f(int i2) {
        return this.a.a(h(i2));
    }

    int g() {
        return this.a.c() - this.f2014c.size();
    }

    View i(int i2) {
        return this.a.a(i2);
    }

    int j() {
        return this.a.c();
    }

    void k(View view) {
        int iE = this.a.e(view);
        if (iE >= 0) {
            this.f2013b.h(iE);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    int m(View view) {
        int iE = this.a.e(view);
        if (iE == -1 || this.f2013b.d(iE)) {
            return -1;
        }
        return iE - this.f2013b.b(iE);
    }

    boolean n(View view) {
        return this.f2014c.contains(view);
    }

    void o() {
        this.f2013b.g();
        for (int size = this.f2014c.size() - 1; size >= 0; size--) {
            this.a.h(this.f2014c.get(size));
            this.f2014c.remove(size);
        }
        this.a.d();
    }

    void p(View view) {
        int iE = this.a.e(view);
        if (iE < 0) {
            return;
        }
        if (this.f2013b.f(iE)) {
            t(view);
        }
        this.a.j(iE);
    }

    void q(int i2) {
        int iH = h(i2);
        View viewA = this.a.a(iH);
        if (viewA == null) {
            return;
        }
        if (this.f2013b.f(iH)) {
            t(viewA);
        }
        this.a.j(iH);
    }

    boolean r(View view) {
        int iE = this.a.e(view);
        if (iE == -1) {
            t(view);
            return true;
        }
        if (!this.f2013b.d(iE)) {
            return false;
        }
        this.f2013b.f(iE);
        t(view);
        this.a.j(iE);
        return true;
    }

    void s(View view) {
        int iE = this.a.e(view);
        if (iE < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f2013b.d(iE)) {
            this.f2013b.a(iE);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f2013b.toString() + ", hidden list:" + this.f2014c.size();
    }
}
