package e.h.a.g0;

import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.liulishuo.filedownloader.services.i;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: compiled from: CustomComponentHolder.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private com.liulishuo.filedownloader.services.c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e.h.a.k0.c.a f21280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private e.h.a.k0.c.b f21281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e.h.a.k0.c.e f21282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private e.h.a.f0.a f21283e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e.h.a.k0.c.d f21284f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private i f21285g;

    /* JADX INFO: compiled from: CustomComponentHolder.java */
    private static final class a {
        private static final c a = new c();
    }

    private e.h.a.k0.c.a d() {
        e.h.a.k0.c.a aVar = this.f21280b;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.f21280b == null) {
                this.f21280b = g().a();
            }
        }
        return this.f21280b;
    }

    private e.h.a.k0.c.b e() {
        e.h.a.k0.c.b bVar = this.f21281c;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            if (this.f21281c == null) {
                this.f21281c = g().b();
            }
        }
        return this.f21281c;
    }

    private com.liulishuo.filedownloader.services.c g() {
        com.liulishuo.filedownloader.services.c cVar = this.a;
        if (cVar != null) {
            return cVar;
        }
        synchronized (this) {
            if (this.a == null) {
                this.a = new com.liulishuo.filedownloader.services.c();
            }
        }
        return this.a;
    }

    public static c j() {
        return a.a;
    }

    private e.h.a.k0.c.e l() {
        e.h.a.k0.c.e eVar = this.f21282d;
        if (eVar != null) {
            return eVar;
        }
        synchronized (this) {
            if (this.f21282d == null) {
                this.f21282d = g().l();
            }
        }
        return this.f21282d;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0053 A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:9:0x0034, B:11:0x003b, B:13:0x0042, B:15:0x0049, B:18:0x0056, B:21:0x0065, B:23:0x0070, B:17:0x0053), top: B:83:0x0034 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x019b  */
    private static void n(e.h.a.f0.a.InterfaceC0272a interfaceC0272a) throws Throwable {
        long j2;
        boolean z;
        String str = "refreshed data count: %d , delete data count: %d, reset id count: %d. consume %d";
        Iterator<FileDownloadModel> it = interfaceC0272a.iterator();
        e.h.a.k0.c.d dVarI = j().i();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        while (it.hasNext()) {
            try {
                FileDownloadModel next = it.next();
                String str2 = str;
                if (next.h() != 3) {
                    try {
                        if (next.h() == 2 || next.h() == -1 || (next.h() == 1 && next.g() > 0)) {
                            next.y((byte) -2);
                        }
                    } catch (Throwable th) {
                        th = th;
                        j2 = jCurrentTimeMillis;
                        j3 = j3;
                        str = str2;
                        e.h.a.k0.f.N(e.h.a.k0.c.a());
                        interfaceC0272a.T0();
                        if (e.h.a.k0.d.a) {
                            e.h.a.k0.d.a(e.h.a.f0.a.class, str, Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(System.currentTimeMillis() - j2));
                        }
                        throw th;
                    }
                } else {
                    next.y((byte) -2);
                }
                String strI = next.i();
                if (strI == null) {
                    j2 = jCurrentTimeMillis;
                    j3 = j3;
                    z = true;
                } else {
                    File file = new File(strI);
                    if (next.h() == -2) {
                        j2 = jCurrentTimeMillis;
                        try {
                            if (e.h.a.k0.f.I(next.e(), next, next.f(), null)) {
                                File file2 = new File(next.j());
                                if (!file2.exists() && file.exists()) {
                                    boolean zRenameTo = file.renameTo(file2);
                                    if (e.h.a.k0.d.a) {
                                        e.h.a.k0.d.a(e.h.a.f0.a.class, "resume from the old no-temp-file architecture [%B], [%s]->[%s]", Boolean.valueOf(zRenameTo), file.getPath(), file2.getPath());
                                    }
                                }
                            }
                            if (next.h() == 1 || next.g() > 0) {
                                z = e.h.a.k0.f.G(next.e(), next) || file.exists();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            j3 = j3;
                            str = str2;
                            e.h.a.k0.f.N(e.h.a.k0.c.a());
                            interfaceC0272a.T0();
                            if (e.h.a.k0.d.a) {
                                e.h.a.k0.d.a(e.h.a.f0.a.class, str, Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(System.currentTimeMillis() - j2));
                            }
                            throw th;
                        }
                    } else {
                        j2 = jCurrentTimeMillis;
                    }
                    if (next.h() == 1) {
                    }
                    if (e.h.a.k0.f.G(next.e(), next)) {
                    }
                }
                if (z) {
                    try {
                        it.remove();
                        interfaceC0272a.K(next);
                        j4++;
                        j3 = j3;
                    } catch (Throwable th3) {
                        th = th3;
                        str = str2;
                        e.h.a.k0.f.N(e.h.a.k0.c.a());
                        interfaceC0272a.T0();
                        if (e.h.a.k0.d.a) {
                            e.h.a.k0.d.a(e.h.a.f0.a.class, str, Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(System.currentTimeMillis() - j2));
                        }
                        throw th;
                    }
                } else {
                    int iE = next.e();
                    int iB = dVarI.b(iE, next.l(), next.f(), next.p());
                    if (iB != iE) {
                        if (e.h.a.k0.d.a) {
                            e.h.a.k0.d.a(e.h.a.f0.a.class, "the id is changed on restoring from db: old[%d] -> new[%d]", Integer.valueOf(iE), Integer.valueOf(iB));
                        }
                        next.v(iB);
                        interfaceC0272a.f0(iE, next);
                        j5++;
                    }
                    interfaceC0272a.T(next);
                    j3++;
                }
                str = str2;
                jCurrentTimeMillis = j2;
            } catch (Throwable th4) {
                th = th4;
                j2 = jCurrentTimeMillis;
                j3 = j3;
            }
        }
        String str3 = str;
        long j6 = jCurrentTimeMillis;
        long j7 = j3;
        e.h.a.k0.f.N(e.h.a.k0.c.a());
        interfaceC0272a.T0();
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(e.h.a.f0.a.class, str3, Long.valueOf(j7), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(System.currentTimeMillis() - j6));
        }
    }

    public e.h.a.e0.b a(String str) throws IOException {
        return e().a(str);
    }

    public e.h.a.j0.a b(File file) throws IOException {
        return l().a(file);
    }

    public int c(int i2, String str, String str2, long j2) {
        return d().a(i2, str, str2, j2);
    }

    public e.h.a.f0.a f() {
        e.h.a.f0.a aVar = this.f21283e;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.f21283e == null) {
                e.h.a.f0.a aVarC = g().c();
                this.f21283e = aVarC;
                n(aVarC.b());
            }
        }
        return this.f21283e;
    }

    public i h() {
        i iVar = this.f21285g;
        if (iVar != null) {
            return iVar;
        }
        synchronized (this) {
            if (this.f21285g == null) {
                this.f21285g = g().j();
            }
        }
        return this.f21285g;
    }

    public e.h.a.k0.c.d i() {
        e.h.a.k0.c.d dVar = this.f21284f;
        if (dVar != null) {
            return dVar;
        }
        synchronized (this) {
            if (this.f21284f == null) {
                this.f21284f = g().k();
            }
        }
        return this.f21284f;
    }

    public int k() {
        return g().n();
    }

    public boolean m() {
        return l().b();
    }

    public void o(com.liulishuo.filedownloader.services.c.a aVar) {
        synchronized (this) {
            this.a = new com.liulishuo.filedownloader.services.c(aVar);
            this.f21281c = null;
            this.f21282d = null;
            this.f21283e = null;
            this.f21284f = null;
        }
    }
}
