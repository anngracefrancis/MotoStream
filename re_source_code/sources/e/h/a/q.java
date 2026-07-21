package e.h.a;

import android.content.Context;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: FileDownloader.java */
/* JADX INFO: loaded from: classes2.dex */
public class q {
    private static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f21384b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private w f21385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private v f21386d;

    /* JADX INFO: compiled from: FileDownloader.java */
    private static final class a {
        private static final q a = new q();
    }

    public static q e() {
        return a.a;
    }

    public static void h(Context context, com.liulishuo.filedownloader.services.c.a aVar) {
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(q.class, "init Downloader with params: %s %s", context, aVar);
        }
        if (context == null) {
            throw new IllegalArgumentException("the provided context must not be null!");
        }
        e.h.a.k0.c.b(context.getApplicationContext());
        e.h.a.g0.c.j().o(aVar);
    }

    public void a(e eVar) {
        f.e().a("event.service.connect.changed", eVar);
    }

    public void b() {
        if (i()) {
            return;
        }
        m.b().u0(e.h.a.k0.c.a());
    }

    public boolean c(int i2, String str) {
        j(i2);
        if (!m.b().o0(i2)) {
            return false;
        }
        File file = new File(e.h.a.k0.f.C(str));
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            return true;
        }
        file2.delete();
        return true;
    }

    public e.h.a.a d(String str) {
        return new c(str);
    }

    v f() {
        if (this.f21386d == null) {
            synchronized (f21384b) {
                if (this.f21386d == null) {
                    z zVar = new z();
                    this.f21386d = zVar;
                    a(zVar);
                }
            }
        }
        return this.f21386d;
    }

    w g() {
        if (this.f21385c == null) {
            synchronized (a) {
                if (this.f21385c == null) {
                    this.f21385c = new c0();
                }
            }
        }
        return this.f21385c;
    }

    public boolean i() {
        return m.b().isConnected();
    }

    public int j(int i2) {
        List<e.h.a.a.b> listH = h.i().h(i2);
        if (listH == null || listH.isEmpty()) {
            e.h.a.k0.d.i(this, "request pause but not exist %d", Integer.valueOf(i2));
            return 0;
        }
        Iterator<e.h.a.a.b> it = listH.iterator();
        while (it.hasNext()) {
            it.next().v().pause();
        }
        return listH.size();
    }

    public void k(i iVar) {
        p.c().a(iVar);
        Iterator<e.h.a.a.b> it = h.i().d(iVar).iterator();
        while (it.hasNext()) {
            it.next().v().pause();
        }
    }

    public int l(int i2, i iVar) {
        e.h.a.a.b bVarG = h.i().g(i2);
        if (bVarG == null) {
            return 0;
        }
        bVarG.v().W(iVar);
        return bVarG.v().getId();
    }

    public boolean m(i iVar, boolean z) {
        if (iVar != null) {
            return z ? g().e(iVar) : g().c(iVar);
        }
        e.h.a.k0.d.i(this, "Tasks with the listener can't start, because the listener provided is null: [null, %B]", Boolean.valueOf(z));
        return false;
    }

    public void n(boolean z) {
        m.b().t0(z);
    }
}
