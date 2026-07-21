package com.liulishuo.filedownloader.services;

/* JADX INFO: compiled from: DownloadMgrInitialParams.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private final a a;

    /* JADX INFO: compiled from: DownloadMgrInitialParams.java */
    public static class a {
        e.h.a.k0.c.InterfaceC0281c a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Integer f20513b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        e.h.a.k0.c.e f20514c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        e.h.a.k0.c.b f20515d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        e.h.a.k0.c.a f20516e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        e.h.a.k0.c.d f20517f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        i f20518g;

        public a a(e.h.a.k0.c.b bVar) {
            this.f20515d = bVar;
            return this;
        }

        public String toString() {
            return e.h.a.k0.f.o("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.a, this.f20513b, this.f20514c, this.f20515d, this.f20516e);
        }
    }

    public c() {
        this.a = null;
    }

    private e.h.a.k0.c.a d() {
        return new e.h.a.e0.a();
    }

    private e.h.a.k0.c.b e() {
        return new e.h.a.e0.c.b();
    }

    private e.h.a.f0.a f() {
        return new e.h.a.f0.c();
    }

    private i g() {
        return new i.b().b(true).a();
    }

    private e.h.a.k0.c.d h() {
        return new b();
    }

    private e.h.a.k0.c.e i() {
        return new e.h.a.j0.b.a();
    }

    private int m() {
        return e.h.a.k0.e.a().f21367e;
    }

    public e.h.a.k0.c.a a() {
        a aVar = this.a;
        if (aVar == null) {
            return d();
        }
        e.h.a.k0.c.a aVar2 = aVar.f20516e;
        if (aVar2 == null) {
            return d();
        }
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar2);
        }
        return aVar2;
    }

    public e.h.a.k0.c.b b() {
        a aVar = this.a;
        if (aVar == null) {
            return e();
        }
        e.h.a.k0.c.b bVar = aVar.f20515d;
        if (bVar == null) {
            return e();
        }
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "initial FileDownloader manager with the customize connection creator: %s", bVar);
        }
        return bVar;
    }

    public e.h.a.f0.a c() {
        e.h.a.k0.c.InterfaceC0281c interfaceC0281c;
        a aVar = this.a;
        if (aVar == null || (interfaceC0281c = aVar.a) == null) {
            return f();
        }
        e.h.a.f0.a aVarA = interfaceC0281c.a();
        if (aVarA == null) {
            return f();
        }
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "initial FileDownloader manager with the customize database: %s", aVarA);
        }
        return aVarA;
    }

    public i j() {
        a aVar = this.a;
        if (aVar == null) {
            return g();
        }
        i iVar = aVar.f20518g;
        if (iVar == null) {
            return g();
        }
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "initial FileDownloader manager with the customize foreground service config: %s", iVar);
        }
        return iVar;
    }

    public e.h.a.k0.c.d k() {
        a aVar = this.a;
        if (aVar == null) {
            return h();
        }
        e.h.a.k0.c.d dVar = aVar.f20517f;
        if (dVar == null) {
            return h();
        }
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
        }
        return dVar;
    }

    public e.h.a.k0.c.e l() {
        a aVar = this.a;
        if (aVar == null) {
            return i();
        }
        e.h.a.k0.c.e eVar = aVar.f20514c;
        if (eVar == null) {
            return i();
        }
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
        }
        return eVar;
    }

    public int n() {
        a aVar = this.a;
        if (aVar == null) {
            return m();
        }
        Integer num = aVar.f20513b;
        if (num == null) {
            return m();
        }
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
        }
        return e.h.a.k0.e.b(num.intValue());
    }

    public c(a aVar) {
        this.a = aVar;
    }
}
