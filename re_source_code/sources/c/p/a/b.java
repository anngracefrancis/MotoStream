package c.p.a;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.k;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import c.e.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* JADX INFO: compiled from: LoaderManagerImpl.java */
/* JADX INFO: loaded from: classes.dex */
class b extends c.p.a.a {
    static boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f3359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f3360c;

    /* JADX INFO: compiled from: LoaderManagerImpl.java */
    public static class a<D> extends q<D> implements c.p.b.b.InterfaceC0086b<D> {
        private final int l;
        private final Bundle m;
        private final c.p.b.b<D> n;
        private k o;
        private C0084b<D> p;
        private c.p.b.b<D> q;

        a(int i2, Bundle bundle, c.p.b.b<D> bVar, c.p.b.b<D> bVar2) {
            this.l = i2;
            this.m = bundle;
            this.n = bVar;
            this.q = bVar2;
            bVar.r(i2, this);
        }

        @Override // c.p.b.b.InterfaceC0086b
        public void a(c.p.b.b<D> bVar, D d2) {
            if (b.a) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                n(d2);
                return;
            }
            if (b.a) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            l(d2);
        }

        @Override // androidx.lifecycle.LiveData
        protected void j() {
            if (b.a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.n.u();
        }

        @Override // androidx.lifecycle.LiveData
        protected void k() {
            if (b.a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.n.v();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void m(r<? super D> rVar) {
            super.m(rVar);
            this.o = null;
            this.p = null;
        }

        @Override // androidx.lifecycle.q, androidx.lifecycle.LiveData
        public void n(D d2) {
            super.n(d2);
            c.p.b.b<D> bVar = this.q;
            if (bVar != null) {
                bVar.s();
                this.q = null;
            }
        }

        c.p.b.b<D> o(boolean z) {
            if (b.a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.n.c();
            this.n.b();
            C0084b<D> c0084b = this.p;
            if (c0084b != null) {
                m(c0084b);
                if (z) {
                    c0084b.d();
                }
            }
            this.n.w(this);
            if ((c0084b == null || c0084b.c()) && !z) {
                return this.n;
            }
            this.n.s();
            return this.q;
        }

        public void p(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.l);
            printWriter.print(" mArgs=");
            printWriter.println(this.m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.n);
            this.n.h(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.p != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.p);
                this.p.b(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(q().e(f()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(g());
        }

        c.p.b.b<D> q() {
            return this.n;
        }

        void r() {
            k kVar = this.o;
            C0084b<D> c0084b = this.p;
            if (kVar == null || c0084b == null) {
                return;
            }
            super.m(c0084b);
            h(kVar, c0084b);
        }

        c.p.b.b<D> s(k kVar, c.p.a.a.InterfaceC0083a<D> interfaceC0083a) {
            C0084b<D> c0084b = new C0084b<>(this.n, interfaceC0083a);
            h(kVar, c0084b);
            C0084b<D> c0084b2 = this.p;
            if (c0084b2 != null) {
                m(c0084b2);
            }
            this.o = kVar;
            this.p = c0084b;
            return this.n;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.l);
            sb.append(" : ");
            c.i.j.b.a(this.n, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: c.p.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LoaderManagerImpl.java */
    static class C0084b<D> implements r<D> {
        private final c.p.b.b<D> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c.p.a.a.InterfaceC0083a<D> f3361b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f3362c = false;

        C0084b(c.p.b.b<D> bVar, c.p.a.a.InterfaceC0083a<D> interfaceC0083a) {
            this.a = bVar;
            this.f3361b = interfaceC0083a;
        }

        @Override // androidx.lifecycle.r
        public void a(D d2) {
            if (b.a) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.a + ": " + this.a.e(d2));
            }
            this.f3361b.a(this.a, d2);
            this.f3362c = true;
        }

        public void b(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f3362c);
        }

        boolean c() {
            return this.f3362c;
        }

        void d() {
            if (this.f3362c) {
                if (b.a) {
                    Log.v("LoaderManager", "  Resetting: " + this.a);
                }
                this.f3361b.c(this.a);
            }
        }

        public String toString() {
            return this.f3361b.toString();
        }
    }

    /* JADX INFO: compiled from: LoaderManagerImpl.java */
    static class c extends x {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final y.b f3363c = new a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private h<a> f3364d = new h<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f3365e = false;

        /* JADX INFO: compiled from: LoaderManagerImpl.java */
        static class a implements y.b {
            a() {
            }

            @Override // androidx.lifecycle.y.b
            public <T extends x> T a(Class<T> cls) {
                return new c();
            }
        }

        c() {
        }

        static c h(z zVar) {
            return (c) new y(zVar, f3363c).a(c.class);
        }

        @Override // androidx.lifecycle.x
        protected void d() {
            super.d();
            int iL = this.f3364d.l();
            for (int i2 = 0; i2 < iL; i2++) {
                this.f3364d.m(i2).o(true);
            }
            this.f3364d.d();
        }

        public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f3364d.l() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i2 = 0; i2 < this.f3364d.l(); i2++) {
                    a aVarM = this.f3364d.m(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f3364d.j(i2));
                    printWriter.print(": ");
                    printWriter.println(aVarM.toString());
                    aVarM.p(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void g() {
            this.f3365e = false;
        }

        <D> a<D> i(int i2) {
            return this.f3364d.g(i2);
        }

        boolean j() {
            return this.f3365e;
        }

        void k() {
            int iL = this.f3364d.l();
            for (int i2 = 0; i2 < iL; i2++) {
                this.f3364d.m(i2).r();
            }
        }

        void l(int i2, a aVar) {
            this.f3364d.k(i2, aVar);
        }

        void m() {
            this.f3365e = true;
        }
    }

    b(k kVar, z zVar) {
        this.f3359b = kVar;
        this.f3360c = c.h(zVar);
    }

    private <D> c.p.b.b<D> e(int i2, Bundle bundle, c.p.a.a.InterfaceC0083a<D> interfaceC0083a, c.p.b.b<D> bVar) {
        try {
            this.f3360c.m();
            c.p.b.b<D> bVarB = interfaceC0083a.b(i2, bundle);
            if (bVarB == null) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            }
            if (bVarB.getClass().isMemberClass() && !Modifier.isStatic(bVarB.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + bVarB);
            }
            a aVar = new a(i2, bundle, bVarB, bVar);
            if (a) {
                Log.v("LoaderManager", "  Created new loader " + aVar);
            }
            this.f3360c.l(i2, aVar);
            this.f3360c.g();
            return aVar.s(this.f3359b, interfaceC0083a);
        } catch (Throwable th) {
            this.f3360c.g();
            throw th;
        }
    }

    @Override // c.p.a.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f3360c.f(str, fileDescriptor, printWriter, strArr);
    }

    @Override // c.p.a.a
    public <D> c.p.b.b<D> c(int i2, Bundle bundle, c.p.a.a.InterfaceC0083a<D> interfaceC0083a) {
        if (this.f3360c.j()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        a<D> aVarI = this.f3360c.i(i2);
        if (a) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (aVarI == null) {
            return e(i2, bundle, interfaceC0083a, null);
        }
        if (a) {
            Log.v("LoaderManager", "  Re-using existing loader " + aVarI);
        }
        return aVarI.s(this.f3359b, interfaceC0083a);
    }

    @Override // c.p.a.a
    public void d() {
        this.f3360c.k();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        c.i.j.b.a(this.f3359b, sb);
        sb.append("}}");
        return sb.toString();
    }
}
