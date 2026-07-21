package e.h.a;

import com.liulishuo.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: FileDownloadList.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {
    private final ArrayList<e.h.a.a.b> a;

    /* JADX INFO: compiled from: FileDownloadList.java */
    private static final class b {
        private static final h a = new h();
    }

    public static h i() {
        return b.a;
    }

    void a(e.h.a.a.b bVar) {
        if (!bVar.v().p()) {
            bVar.F();
        }
        if (bVar.y().f().i()) {
            b(bVar);
        }
    }

    void b(e.h.a.a.b bVar) {
        if (bVar.H()) {
            return;
        }
        synchronized (this.a) {
            if (this.a.contains(bVar)) {
                e.h.a.k0.d.i(this, "already has %s", bVar);
            } else {
                bVar.T();
                this.a.add(bVar);
                if (e.h.a.k0.d.a) {
                    e.h.a.k0.d.h(this, "add list in all %s %d %d", bVar, Byte.valueOf(bVar.v().getStatus()), Integer.valueOf(this.a.size()));
                }
            }
        }
    }

    List<e.h.a.a.b> c(int i2, i iVar) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.a) {
            for (e.h.a.a.b bVar : this.a) {
                if (bVar.v().G() == iVar && !bVar.v().p()) {
                    bVar.C(i2);
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    List<e.h.a.a.b> d(i iVar) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.a) {
            for (e.h.a.a.b bVar : this.a) {
                if (bVar.z(iVar)) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    int e(int i2) {
        int i3;
        synchronized (this.a) {
            Iterator<e.h.a.a.b> it = this.a.iterator();
            i3 = 0;
            while (it.hasNext()) {
                if (it.next().A(i2)) {
                    i3++;
                }
            }
        }
        return i3;
    }

    void f(List<e.h.a.a.b> list) {
        synchronized (this.a) {
            for (e.h.a.a.b bVar : this.a) {
                if (!list.contains(bVar)) {
                    list.add(bVar);
                }
            }
            this.a.clear();
        }
    }

    public e.h.a.a.b g(int i2) {
        synchronized (this.a) {
            for (e.h.a.a.b bVar : this.a) {
                if (bVar.A(i2)) {
                    return bVar;
                }
            }
            return null;
        }
    }

    List<e.h.a.a.b> h(int i2) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.a) {
            for (e.h.a.a.b bVar : this.a) {
                if (bVar.A(i2) && !bVar.P()) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    List<e.h.a.a.b> j(int i2) {
        byte status;
        ArrayList arrayList = new ArrayList();
        synchronized (this.a) {
            for (e.h.a.a.b bVar : this.a) {
                if (bVar.A(i2) && !bVar.P() && (status = bVar.v().getStatus()) != 0 && status != 10) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    boolean k(e.h.a.a.b bVar) {
        return this.a.isEmpty() || !this.a.contains(bVar);
    }

    public boolean l(e.h.a.a.b bVar, MessageSnapshot messageSnapshot) {
        boolean zRemove;
        byte bK = messageSnapshot.k();
        synchronized (this.a) {
            zRemove = this.a.remove(bVar);
            if (zRemove && this.a.size() == 0 && m.b().v0()) {
                q.e().n(true);
            }
        }
        if (e.h.a.k0.d.a && this.a.size() == 0) {
            e.h.a.k0.d.h(this, "remove %s left %d %d", bVar, Byte.valueOf(bK), Integer.valueOf(this.a.size()));
        }
        if (zRemove) {
            t tVarF = bVar.y().f();
            if (bK == -4) {
                tVarF.g(messageSnapshot);
            } else if (bK == -3) {
                tVarF.k(com.liulishuo.filedownloader.message.c.f(messageSnapshot));
            } else if (bK == -2) {
                tVarF.c(messageSnapshot);
            } else if (bK == -1) {
                tVarF.d(messageSnapshot);
            }
        } else {
            e.h.a.k0.d.b(this, "remove error, not exist: %s %d", bVar, Byte.valueOf(bK));
        }
        return zRemove;
    }

    int m() {
        return this.a.size();
    }

    private h() {
        this.a = new ArrayList<>();
    }
}
