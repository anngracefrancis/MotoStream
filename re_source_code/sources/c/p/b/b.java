package c.p.b;

import android.content.Context;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: Loader.java */
/* JADX INFO: loaded from: classes.dex */
public class b<D> {
    int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    InterfaceC0086b<D> f3368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    a<D> f3369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Context f3370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f3371e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f3372f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f3373g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f3374h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f3375i = false;

    /* JADX INFO: compiled from: Loader.java */
    public interface a<D> {
        void a(b<D> bVar);
    }

    /* JADX INFO: renamed from: c.p.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Loader.java */
    public interface InterfaceC0086b<D> {
        void a(b<D> bVar, D d2);
    }

    public b(Context context) {
        this.f3370d = context.getApplicationContext();
    }

    public void b() {
        this.f3372f = true;
        k();
    }

    public boolean c() {
        return l();
    }

    public void d() {
        this.f3375i = false;
    }

    public String e(D d2) {
        StringBuilder sb = new StringBuilder(64);
        c.i.j.b.a(d2, sb);
        sb.append("}");
        return sb.toString();
    }

    public void f() {
        a<D> aVar = this.f3369c;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void g(D d2) {
        InterfaceC0086b<D> interfaceC0086b = this.f3368b;
        if (interfaceC0086b != null) {
            interfaceC0086b.a(this, d2);
        }
    }

    @Deprecated
    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.a);
        printWriter.print(" mListener=");
        printWriter.println(this.f3368b);
        if (this.f3371e || this.f3374h || this.f3375i) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f3371e);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f3374h);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f3375i);
        }
        if (this.f3372f || this.f3373g) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f3372f);
            printWriter.print(" mReset=");
            printWriter.println(this.f3373g);
        }
    }

    public void i() {
        n();
    }

    public boolean j() {
        return this.f3372f;
    }

    protected void k() {
    }

    protected boolean l() {
        throw null;
    }

    public void m() {
        if (this.f3371e) {
            i();
        } else {
            this.f3374h = true;
        }
    }

    protected void n() {
    }

    protected void o() {
    }

    protected void p() {
        throw null;
    }

    protected void q() {
    }

    public void r(int i2, InterfaceC0086b<D> interfaceC0086b) {
        if (this.f3368b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f3368b = interfaceC0086b;
        this.a = i2;
    }

    public void s() {
        o();
        this.f3373g = true;
        this.f3371e = false;
        this.f3372f = false;
        this.f3374h = false;
        this.f3375i = false;
    }

    public void t() {
        if (this.f3375i) {
            m();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        c.i.j.b.a(this, sb);
        sb.append(" id=");
        sb.append(this.a);
        sb.append("}");
        return sb.toString();
    }

    public final void u() {
        this.f3371e = true;
        this.f3373g = false;
        this.f3372f = false;
        p();
    }

    public void v() {
        this.f3371e = false;
        q();
    }

    public void w(InterfaceC0086b<D> interfaceC0086b) {
        InterfaceC0086b<D> interfaceC0086b2 = this.f3368b;
        if (interfaceC0086b2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (interfaceC0086b2 != interfaceC0086b) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f3368b = null;
    }
}
