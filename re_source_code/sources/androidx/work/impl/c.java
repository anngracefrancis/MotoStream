package androidx.work.impl;

import androidx.work.q;

/* JADX INFO: compiled from: OperationImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final androidx.lifecycle.q<q.b> f2389c = new androidx.lifecycle.q<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final androidx.work.impl.utils.o.c<q.b.c> f2390d = androidx.work.impl.utils.o.c.u();

    public c() {
        a(q.f2663b);
    }

    public void a(q.b bVar) {
        this.f2389c.l(bVar);
        if (bVar instanceof q.b.c) {
            this.f2390d.q((q.b.c) bVar);
        } else if (bVar instanceof q.b.a) {
            this.f2390d.r(((q.b.a) bVar).a());
        }
    }
}
