package h.a.z.a;

import h.a.k;
import h.a.q;
import h.a.u;

/* JADX INFO: compiled from: EmptyDisposable.java */
/* JADX INFO: loaded from: classes2.dex */
public enum d implements h.a.z.c.b<Object> {
    INSTANCE,
    NEVER;

    public static void u(k<?> kVar) {
        kVar.b(INSTANCE);
        kVar.a();
    }

    public static void v(q<?> qVar) {
        qVar.b(INSTANCE);
        qVar.a();
    }

    public static void x(Throwable th, q<?> qVar) {
        qVar.b(INSTANCE);
        qVar.onError(th);
    }

    public static void y(Throwable th, u<?> uVar) {
        uVar.b(INSTANCE);
        uVar.onError(th);
    }

    @Override // h.a.z.c.f
    public void clear() {
    }

    @Override // h.a.z.c.c
    public int g(int i2) {
        return i2 & 2;
    }

    @Override // h.a.z.c.f
    public boolean isEmpty() {
        return true;
    }

    @Override // h.a.x.c
    public void k() {
    }

    @Override // h.a.z.c.f
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // h.a.z.c.f
    public Object poll() throws Exception {
        return null;
    }

    @Override // h.a.x.c
    public boolean q() {
        return this == INSTANCE;
    }
}
