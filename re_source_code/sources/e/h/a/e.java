package e.h.a;

/* JADX INFO: compiled from: FileDownloadConnectListener.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e extends e.h.a.h0.d {
    private e.h.a.h0.b.a a;

    @Override // e.h.a.h0.d
    public boolean d(e.h.a.h0.c cVar) {
        if (!(cVar instanceof e.h.a.h0.b)) {
            return false;
        }
        e.h.a.h0.b.a aVarB = ((e.h.a.h0.b) cVar).b();
        this.a = aVarB;
        if (aVarB == e.h.a.h0.b.a.connected) {
            e();
            return false;
        }
        f();
        return false;
    }

    public abstract void e();

    public abstract void f();

    public e.h.a.h0.b.a g() {
        return this.a;
    }
}
