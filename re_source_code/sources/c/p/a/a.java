package c.p.a;

import android.os.Bundle;
import androidx.lifecycle.a0;
import androidx.lifecycle.k;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: LoaderManager.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: c.p.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LoaderManager.java */
    public interface InterfaceC0083a<D> {
        void a(c.p.b.b<D> bVar, D d2);

        c.p.b.b<D> b(int i2, Bundle bundle);

        void c(c.p.b.b<D> bVar);
    }

    public static <T extends k & a0> a b(T t) {
        return new b(t, t.getViewModelStore());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract <D> c.p.b.b<D> c(int i2, Bundle bundle, InterfaceC0083a<D> interfaceC0083a);

    public abstract void d();
}
