package e.h.a.g0;

import android.os.Process;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.liulishuo.filedownloader.exception.FileDownloadHttpException;
import com.liulishuo.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.liulishuo.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.liulishuo.filedownloader.exception.FileDownloadSecurityException;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import e.h.a.y;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: DownloadLaunchRunnable.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements Runnable, h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ThreadPoolExecutor f21286f = e.h.a.k0.b.c("ConnectionBlock");
    private volatile boolean A;
    private volatile Exception B;
    private String C;
    private long D;
    private long E;
    private long F;
    private long G;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final f f21287g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f21288h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final FileDownloadModel f21289i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final FileDownloadHeader f21290j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f21291k;
    private final boolean l;
    private final e.h.a.f0.a m;
    private final y n;
    private boolean o;
    int p;
    private boolean q;
    private final boolean r;
    private final ArrayList<e> s;
    private e t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private final AtomicBoolean y;
    private volatile boolean z;

    /* JADX INFO: compiled from: DownloadLaunchRunnable.java */
    public static class b {
        private FileDownloadModel a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private FileDownloadHeader f21292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private y f21293c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Integer f21294d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Integer f21295e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Boolean f21296f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Boolean f21297g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Integer f21298h;

        public d a() {
            if (this.a == null || this.f21293c == null || this.f21294d == null || this.f21295e == null || this.f21296f == null || this.f21297g == null || this.f21298h == null) {
                throw new IllegalArgumentException();
            }
            return new d(this.a, this.f21292b, this.f21293c, this.f21294d.intValue(), this.f21295e.intValue(), this.f21296f.booleanValue(), this.f21297g.booleanValue(), this.f21298h.intValue());
        }

        public b b(Integer num) {
            this.f21295e = num;
            return this;
        }

        public b c(Boolean bool) {
            this.f21296f = bool;
            return this;
        }

        public b d(FileDownloadHeader fileDownloadHeader) {
            this.f21292b = fileDownloadHeader;
            return this;
        }

        public b e(Integer num) {
            this.f21298h = num;
            return this;
        }

        public b f(Integer num) {
            this.f21294d = num;
            return this;
        }

        public b g(FileDownloadModel fileDownloadModel) {
            this.a = fileDownloadModel;
            return this;
        }

        public b h(y yVar) {
            this.f21293c = yVar;
            return this;
        }

        public b i(Boolean bool) {
            this.f21297g = bool;
            return this;
        }
    }

    /* JADX INFO: compiled from: DownloadLaunchRunnable.java */
    class c extends Throwable {
        c() {
        }
    }

    /* JADX INFO: renamed from: e.h.a.g0.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DownloadLaunchRunnable.java */
    class C0276d extends Throwable {
        C0276d() {
        }
    }

    private int g(long j2) {
        if (q()) {
            return this.v ? this.f21289i.a() : e.h.a.g0.c.j().c(this.f21289i.e(), this.f21289i.l(), this.f21289i.f(), j2);
        }
        return 1;
    }

    private void h() throws c, C0276d {
        int iE = this.f21289i.e();
        if (this.f21289i.p()) {
            String strI = this.f21289i.i();
            int iR = e.h.a.k0.f.r(this.f21289i.l(), strI);
            if (e.h.a.k0.c.d(iE, strI, this.f21291k, false)) {
                this.m.remove(iE);
                this.m.h(iE);
                throw new c();
            }
            FileDownloadModel fileDownloadModelO = this.m.o(iR);
            if (fileDownloadModelO != null) {
                if (e.h.a.k0.c.e(iE, fileDownloadModelO, this.n, false)) {
                    this.m.remove(iE);
                    this.m.h(iE);
                    throw new c();
                }
                List<com.liulishuo.filedownloader.model.a> listN = this.m.n(iR);
                this.m.remove(iR);
                this.m.h(iR);
                e.h.a.k0.f.e(this.f21289i.i());
                if (e.h.a.k0.f.G(iR, fileDownloadModelO)) {
                    this.f21289i.x(fileDownloadModelO.g());
                    this.f21289i.z(fileDownloadModelO.k());
                    this.f21289i.s(fileDownloadModelO.b());
                    this.f21289i.r(fileDownloadModelO.a());
                    this.m.j(this.f21289i);
                    if (listN != null) {
                        for (com.liulishuo.filedownloader.model.a aVar : listN) {
                            aVar.i(iE);
                            this.m.g(aVar);
                        }
                    }
                    throw new C0276d();
                }
            }
            if (e.h.a.k0.c.c(iE, this.f21289i.g(), this.f21289i.j(), strI, this.n)) {
                this.m.remove(iE);
                this.m.h(iE);
                throw new c();
            }
        }
    }

    private void i() throws FileDownloadGiveUpRetryException {
        if (this.l && !e.h.a.k0.f.a("android.permission.ACCESS_NETWORK_STATE")) {
            throw new FileDownloadGiveUpRetryException(e.h.a.k0.f.o("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.f21289i.e()), "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (this.l && e.h.a.k0.f.M()) {
            throw new FileDownloadNetworkPolicyException();
        }
    }

    private void j(List<com.liulishuo.filedownloader.model.a> list, long j2) throws InterruptedException {
        int iE = this.f21289i.e();
        String strB = this.f21289i.b();
        String strL = this.C;
        if (strL == null) {
            strL = this.f21289i.l();
        }
        String strJ = this.f21289i.j();
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(iE), Long.valueOf(j2));
        }
        boolean z = this.v;
        long j3 = 0;
        long jA = 0;
        for (com.liulishuo.filedownloader.model.a aVar : list) {
            long jA2 = aVar.b() == -1 ? j2 - aVar.a() : (aVar.b() - aVar.a()) + 1;
            jA += aVar.a() - aVar.e();
            if (jA2 != j3) {
                e eVarA = new e.b().g(iE).c(Integer.valueOf(aVar.d())).b(this).i(strL).e(z ? strB : null).f(this.f21290j).j(this.l).d(e.h.a.g0.b.C0275b.b(aVar.e(), aVar.a(), aVar.b(), jA2)).h(strJ).a();
                if (e.h.a.k0.d.a) {
                    e.h.a.k0.d.a(this, "enable multiple connection: %s", aVar);
                }
                if (eVarA == null) {
                    throw new IllegalArgumentException("the download runnable must not be null!");
                }
                this.s.add(eVarA);
            } else if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(aVar.c()), Integer.valueOf(aVar.d()));
            }
            j3 = 0;
        }
        if (jA != this.f21289i.g()) {
            e.h.a.k0.d.i(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.f21289i.g()), Long.valueOf(jA));
            this.f21289i.x(jA);
        }
        ArrayList arrayList = new ArrayList(this.s.size());
        for (e eVar : this.s) {
            if (this.z) {
                eVar.c();
            } else {
                arrayList.add(Executors.callable(eVar));
            }
        }
        if (this.z) {
            this.f21289i.y((byte) -2);
            return;
        }
        List<Future> listInvokeAll = f21286f.invokeAll(arrayList);
        if (e.h.a.k0.d.a) {
            for (Future future : listInvokeAll) {
                e.h.a.k0.d.a(this, "finish sub-task for [%d] %B %B", Integer.valueOf(iE), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
            }
        }
    }

    private void m(long j2, String str) throws IllegalAccessException, IOException {
        e.h.a.j0.a aVarC = null;
        if (j2 != -1) {
            try {
                aVarC = e.h.a.k0.f.c(this.f21289i.j());
                long length = new File(str).length();
                long j3 = j2 - length;
                long jX = e.h.a.k0.f.x(str);
                if (jX < j3) {
                    throw new FileDownloadOutOfSpaceException(jX, j3, length);
                }
                if (!e.h.a.k0.e.a().f21368f) {
                    aVarC.a(j2);
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    aVarC.close();
                }
                throw th;
            }
        }
        if (aVarC != null) {
            aVarC.close();
        }
    }

    private void n(Map<String, List<String>> map, e.h.a.g0.a aVar, e.h.a.e0.b bVar) throws C0276d, FileDownloadSecurityException, IOException, IllegalArgumentException {
        boolean z;
        int iE = this.f21289i.e();
        int iD = bVar.d();
        this.w = e.h.a.k0.f.E(iD, bVar);
        boolean z2 = iD == 200 || iD == 201 || iD == 0;
        long jM = e.h.a.k0.f.m(bVar);
        String strB = this.f21289i.b();
        String strJ = e.h.a.k0.f.j(iE, bVar);
        if (iD != 412 && ((strB == null || strB.equals(strJ) || !(z2 || this.w)) && !(iD == 201 && aVar.h()))) {
            if (iD == 416) {
                if (!this.w || jM < 0) {
                    if (this.f21289i.g() > 0) {
                        e.h.a.k0.d.i(this, "get 416, precondition failed and just retry", new Object[0]);
                    } else if (!this.q) {
                        this.q = true;
                        e.h.a.k0.d.i(this, "get 416, precondition failed and need to retry with discarding range", new Object[0]);
                    }
                    z = true;
                } else {
                    e.h.a.k0.d.i(this, "get 416 but the Content-Range is returned, no need to retry", new Object[0]);
                }
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            this.C = aVar.e();
            if (!this.w && !z2) {
                throw new FileDownloadHttpException(iD, map, bVar.b());
            }
            String strL = this.f21289i.p() ? e.h.a.k0.f.l(bVar, this.f21289i.l()) : null;
            this.x = jM == -1;
            this.f21287g.n(this.v && this.w, jM, strJ, strL);
            return;
        }
        if (this.v) {
            e.h.a.k0.d.i(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response code is %d", Integer.valueOf(iE), strB, strJ, Integer.valueOf(iD));
        }
        this.m.h(this.f21289i.e());
        e.h.a.k0.f.f(this.f21289i.i(), this.f21289i.j());
        this.v = false;
        if (strB != null && strB.equals(strJ)) {
            e.h.a.k0.d.i(this, "the old etag[%s] is the same to the new etag[%s], but the response status code is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", strB, strJ, Integer.valueOf(iD), Integer.valueOf(iE));
            strJ = null;
        }
        this.f21289i.x(0L);
        this.f21289i.z(0L);
        this.f21289i.s(strJ);
        this.f21289i.q();
        this.m.e(iE, this.f21289i.b(), this.f21289i.g(), this.f21289i.k(), this.f21289i.a());
        throw new C0276d();
    }

    private boolean q() {
        return (!this.v || this.f21289i.a() > 1) && this.w && this.r && !this.x;
    }

    private void t(long j2, int i2) throws InterruptedException {
        long j3 = j2 / ((long) i2);
        int iE = this.f21289i.e();
        ArrayList arrayList = new ArrayList();
        long j4 = 0;
        int i3 = 0;
        while (i3 < i2) {
            long j5 = i3 == i2 + (-1) ? -1L : (j4 + j3) - 1;
            com.liulishuo.filedownloader.model.a aVar = new com.liulishuo.filedownloader.model.a();
            aVar.i(iE);
            aVar.j(i3);
            aVar.k(j4);
            aVar.g(j4);
            aVar.h(j5);
            arrayList.add(aVar);
            this.m.g(aVar);
            j4 += j3;
            i3++;
        }
        this.f21289i.r(i2);
        this.m.p(iE, i2);
        j(arrayList, j2);
    }

    private void u(int i2, List<com.liulishuo.filedownloader.model.a> list) throws InterruptedException {
        if (i2 <= 1 || list.size() != i2) {
            throw new IllegalArgumentException();
        }
        j(list, this.f21289i.k());
    }

    private void v(long j2) throws IllegalAccessException, IOException {
        e.h.a.g0.b bVarC;
        if (this.w) {
            bVarC = e.h.a.g0.b.C0275b.c(this.f21289i.g(), this.f21289i.g(), j2 - this.f21289i.g());
        } else {
            this.f21289i.x(0L);
            bVarC = e.h.a.g0.b.C0275b.a(j2);
        }
        this.t = new e.b().g(this.f21289i.e()).c(-1).b(this).i(this.f21289i.l()).e(this.f21289i.b()).f(this.f21290j).j(this.l).d(bVarC).h(this.f21289i.j()).a();
        this.f21289i.r(1);
        this.m.p(this.f21289i.e(), 1);
        if (!this.z) {
            this.t.run();
        } else {
            this.f21289i.y((byte) -2);
            this.t.c();
        }
    }

    private void w() throws IllegalAccessException, C0276d, FileDownloadSecurityException, IOException {
        e.h.a.e0.b bVarC = null;
        try {
            e.h.a.g0.a aVarA = new e.h.a.g0.a.b().c(this.f21289i.e()).f(this.f21289i.l()).d(this.f21289i.b()).e(this.f21290j).b(this.q ? e.h.a.g0.b.C0275b.e() : e.h.a.g0.b.C0275b.d()).a();
            bVarC = aVarA.c();
            n(aVarA.g(), aVarA, bVarC);
        } finally {
            if (bVarC != null) {
                bVarC.g();
            }
        }
    }

    @Override // e.h.a.g0.h
    public void a(e eVar, long j2, long j3) {
        if (this.z) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.f21289i.e()));
                return;
            }
            return;
        }
        int i2 = eVar.m;
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(this.f21289i.k()));
        }
        if (!this.u) {
            synchronized (this.s) {
                this.s.remove(eVar);
            }
        } else {
            if (j2 == 0 || j3 == this.f21289i.k()) {
                return;
            }
            e.h.a.k0.d.b(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(this.f21289i.k()), Integer.valueOf(this.f21289i.e()));
        }
    }

    @Override // e.h.a.g0.h
    public void b(Exception exc) {
        this.A = true;
        this.B = exc;
        if (this.z) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.f21289i.e()));
            }
        } else {
            for (e eVar : (ArrayList) this.s.clone()) {
                if (eVar != null) {
                    eVar.a();
                }
            }
        }
    }

    @Override // e.h.a.g0.h
    public void c(Exception exc) {
        if (this.z) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.f21289i.e()));
            }
        } else {
            int i2 = this.p;
            int i3 = i2 - 1;
            this.p = i3;
            if (i2 < 0) {
                e.h.a.k0.d.b(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(i3), Integer.valueOf(this.f21289i.e()));
            }
            this.f21287g.t(exc, this.p);
        }
    }

    @Override // e.h.a.g0.h
    public void d(long j2) {
        if (this.z) {
            return;
        }
        this.f21287g.s(j2);
    }

    @Override // e.h.a.g0.h
    public boolean e(Exception exc) {
        if (exc instanceof FileDownloadHttpException) {
            int iB = ((FileDownloadHttpException) exc).b();
            if (this.u && iB == 416 && !this.o) {
                e.h.a.k0.f.f(this.f21289i.i(), this.f21289i.j());
                this.o = true;
                return true;
            }
        }
        return this.p > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
    }

    @Override // e.h.a.g0.h
    public void f() {
        this.m.l(this.f21289i.e(), this.f21289i.g());
    }

    public int k() {
        return this.f21289i.e();
    }

    public String l() {
        return this.f21289i.j();
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    void o(List<com.liulishuo.filedownloader.model.a> list) {
        long jG;
        int iA = this.f21289i.a();
        String strJ = this.f21289i.j();
        String strI = this.f21289i.i();
        boolean z = iA > 1;
        if (this.q || ((z && !this.r) || !e.h.a.k0.f.G(this.f21289i.e(), this.f21289i))) {
            jG = 0;
        } else if (!this.r) {
            jG = new File(strJ).length();
        } else if (!z) {
            jG = this.f21289i.g();
        } else if (iA != list.size()) {
            jG = 0;
        } else {
            jG = com.liulishuo.filedownloader.model.a.f(list);
        }
        this.f21289i.x(jG);
        boolean z2 = jG > 0;
        this.v = z2;
        if (z2) {
            return;
        }
        this.m.h(this.f21289i.e());
        e.h.a.k0.f.f(strI, strJ);
    }

    public boolean p() {
        return this.y.get() || this.f21287g.l();
    }

    public void r() {
        this.z = true;
        e eVar = this.t;
        if (eVar != null) {
            eVar.c();
        }
        for (e eVar2 : (ArrayList) this.s.clone()) {
            if (eVar2 != null) {
                eVar2.c();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:119:0x01c1 A[Catch: all -> 0x01f6, TryCatch #12 {all -> 0x01f6, blocks: (B:3:0x0003, B:6:0x0012, B:8:0x001a, B:10:0x001e, B:11:0x0030, B:24:0x008d, B:26:0x0091, B:27:0x0096, B:29:0x009a, B:31:0x009e, B:42:0x00c6, B:44:0x00e2, B:55:0x0100, B:69:0x0136, B:71:0x013a, B:85:0x015f, B:87:0x0163, B:88:0x0167, B:90:0x0170, B:91:0x0174, B:92:0x0178, B:93:0x018b, B:94:0x018c, B:117:0x01bb, B:119:0x01c1, B:120:0x01c6), top: B:157:0x0003, inners: #15, #12, #11 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x0069  */
    /* JADX WARN: Code duplicated, block: B:165:0x01c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:17:0x0073  */
    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            Process.setThreadPriority(10);
            if (this.f21289i.h() != 1) {
                if (this.f21289i.h() != -2) {
                    b(new RuntimeException(e.h.a.k0.f.o("Task[%d] can't start the download runnable, because its status is %d not %d", Integer.valueOf(this.f21289i.e()), Byte.valueOf(this.f21289i.h()), (byte) 1)));
                } else if (e.h.a.k0.d.a) {
                    e.h.a.k0.d.a(this, "High concurrent cause, start runnable but already paused %d", Integer.valueOf(this.f21289i.e()));
                }
                this.f21287g.b();
                if (this.z) {
                    this.f21287g.q();
                } else if (this.A) {
                    this.f21287g.o(this.B);
                } else {
                    try {
                        this.f21287g.m();
                    } catch (IOException e2) {
                        e = e2;
                        this.f21287g.o(e);
                    }
                }
            } else {
                if (!this.z) {
                    this.f21287g.u();
                }
                while (true) {
                    if (this.z) {
                        if (e.h.a.k0.d.a) {
                            e.h.a.k0.d.a(this, "High concurrent cause, start runnable but already paused %d", Integer.valueOf(this.f21289i.e()));
                        }
                        this.f21287g.b();
                        if (this.z) {
                            this.f21287g.q();
                        } else if (this.A) {
                            this.f21287g.o(this.B);
                        } else {
                            try {
                                this.f21287g.m();
                            } catch (IOException e3) {
                                e = e3;
                                this.f21287g.o(e);
                            }
                        }
                    } else {
                        try {
                            i();
                            w();
                            h();
                            List<com.liulishuo.filedownloader.model.a> listN = this.m.n(this.f21289i.e());
                            o(listN);
                            if (this.z) {
                                this.f21289i.y((byte) -2);
                                this.f21287g.b();
                                if (this.z) {
                                    this.f21287g.q();
                                } else if (this.A) {
                                    this.f21287g.o(this.B);
                                } else {
                                    try {
                                        this.f21287g.m();
                                    } catch (IOException e4) {
                                        e = e4;
                                        this.f21287g.o(e);
                                    }
                                }
                            } else {
                                long jK = this.f21289i.k();
                                m(jK, this.f21289i.j());
                                int iG = g(jK);
                                if (iG <= 0) {
                                    throw new IllegalAccessException(e.h.a.k0.f.o("invalid connection count %d, the connection count must be larger than 0", Integer.valueOf(iG)));
                                }
                                if (jK == 0) {
                                    this.f21287g.b();
                                    if (this.z) {
                                        this.f21287g.q();
                                    } else if (this.A) {
                                        this.f21287g.o(this.B);
                                    } else {
                                        try {
                                            this.f21287g.m();
                                        } catch (IOException e5) {
                                            e = e5;
                                            this.f21287g.o(e);
                                        }
                                    }
                                } else {
                                    if (!this.z) {
                                        boolean z = iG == 1;
                                        this.u = z;
                                        if (z) {
                                            v(jK);
                                        } else {
                                            this.f21287g.p();
                                            if (this.v) {
                                                u(iG, listN);
                                            } else {
                                                t(jK, iG);
                                            }
                                        }
                                        this.f21287g.b();
                                        if (this.z) {
                                            this.f21287g.q();
                                        } else if (this.A) {
                                            this.f21287g.o(this.B);
                                        } else {
                                            try {
                                                this.f21287g.m();
                                            } catch (IOException e6) {
                                                this.f21287g.o(e6);
                                            }
                                        }
                                        this.y.set(false);
                                        return;
                                    }
                                    this.f21289i.y((byte) -2);
                                    this.f21287g.b();
                                    if (this.z) {
                                        this.f21287g.q();
                                    } else if (this.A) {
                                        this.f21287g.o(this.B);
                                    } else {
                                        try {
                                            this.f21287g.m();
                                        } catch (IOException e7) {
                                            e = e7;
                                            this.f21287g.o(e);
                                        }
                                    }
                                }
                            }
                        } catch (FileDownloadGiveUpRetryException e8) {
                            e = e8;
                            if (e(e)) {
                                c(e);
                            } else {
                                b(e);
                            }
                        } catch (FileDownloadSecurityException e9) {
                            e = e9;
                            if (e(e)) {
                                c(e);
                            } else {
                                b(e);
                            }
                        } catch (c unused) {
                            this.f21287g.b();
                            if (!this.z) {
                                if (this.A) {
                                    this.f21287g.o(this.B);
                                } else {
                                    try {
                                        this.f21287g.m();
                                    } catch (IOException e10) {
                                        e = e10;
                                        this.f21287g.o(e);
                                    }
                                }
                            }
                        } catch (C0276d unused2) {
                            this.f21289i.y((byte) 5);
                        } catch (IOException e11) {
                            e = e11;
                            if (e(e)) {
                                c(e);
                            } else {
                                b(e);
                            }
                        } catch (IllegalAccessException e12) {
                            e = e12;
                            if (e(e)) {
                                c(e);
                            } else {
                                b(e);
                            }
                        } catch (IllegalArgumentException e13) {
                            e = e13;
                            if (e(e)) {
                                c(e);
                            } else {
                                b(e);
                            }
                        } catch (InterruptedException e14) {
                            e = e14;
                            if (e(e)) {
                                c(e);
                            } else {
                                b(e);
                            }
                        }
                    }
                }
            }
            this.y.set(false);
        } catch (Throwable th) {
            this.f21287g.b();
            if (this.z) {
                this.f21287g.q();
            } else if (this.A) {
                this.f21287g.o(this.B);
            } else {
                try {
                    this.f21287g.m();
                } catch (IOException e15) {
                    this.f21287g.o(e15);
                }
            }
            this.y.set(false);
            throw th;
        }
    }

    public void s() {
        o(this.m.n(this.f21289i.e()));
        this.f21287g.r();
    }

    private d(FileDownloadModel fileDownloadModel, FileDownloadHeader fileDownloadHeader, y yVar, int i2, int i3, boolean z, boolean z2, int i4) {
        this.f21288h = 5;
        this.q = false;
        this.s = new ArrayList<>(5);
        this.D = 0L;
        this.E = 0L;
        this.F = 0L;
        this.G = 0L;
        this.y = new AtomicBoolean(true);
        this.z = false;
        this.o = false;
        this.f21289i = fileDownloadModel;
        this.f21290j = fileDownloadHeader;
        this.f21291k = z;
        this.l = z2;
        this.m = e.h.a.g0.c.j().f();
        this.r = e.h.a.g0.c.j().m();
        this.n = yVar;
        this.p = i4;
        this.f21287g = new f(fileDownloadModel, i4, i2, i3);
    }
}
