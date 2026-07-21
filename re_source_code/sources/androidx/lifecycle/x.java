package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: ViewModel.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class x {
    private final Map<String, Object> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f1783b = false;

    private static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    final void a() {
        this.f1783b = true;
        Map<String, Object> map = this.a;
        if (map != null) {
            synchronized (map) {
                Iterator<Object> it = this.a.values().iterator();
                while (it.hasNext()) {
                    b(it.next());
                }
            }
        }
        d();
    }

    <T> T c(String str) {
        T t;
        Map<String, Object> map = this.a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t = (T) this.a.get(str);
        }
        return t;
    }

    protected void d() {
    }

    <T> T e(String str, T t) {
        Object obj;
        synchronized (this.a) {
            obj = this.a.get(str);
            if (obj == null) {
                this.a.put(str, t);
            }
        }
        if (obj != null) {
            t = (T) obj;
        }
        if (this.f1783b) {
            b(t);
        }
        return t;
    }
}
