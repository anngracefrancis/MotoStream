package androidx.room;

import java.io.File;

/* JADX INFO: compiled from: SQLiteCopyOpenHelperFactory.java */
/* JADX INFO: loaded from: classes.dex */
class p implements c.u.a.c.InterfaceC0094c {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f2202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c.u.a.c.InterfaceC0094c f2203c;

    p(String str, File file, c.u.a.c.InterfaceC0094c interfaceC0094c) {
        this.a = str;
        this.f2202b = file;
        this.f2203c = interfaceC0094c;
    }

    @Override // c.u.a.c.InterfaceC0094c
    public c.u.a.c a(c.u.a.c.b bVar) {
        return new o(bVar.a, this.a, this.f2202b, bVar.f3471c.a, this.f2203c.a(bVar));
    }
}
