package e.h.a;

import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/* JADX INFO: compiled from: DownloadTaskHunter.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements x, x.b, x.a, e.h.a.a.d {
    private t a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f21235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f21236c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final s f21239f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final r f21240g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f21241h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f21242i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f21243j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f21244k;
    private boolean l;
    private String m;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile byte f21237d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Throwable f21238e = null;
    private boolean n = false;

    /* JADX INFO: compiled from: DownloadTaskHunter.java */
    interface a {
        ArrayList<e.h.a.a.InterfaceC0271a> D();

        FileDownloadHeader N();

        void a(String str);

        e.h.a.a.b s();
    }

    d(a aVar, Object obj) {
        this.f21235b = obj;
        this.f21236c = aVar;
        b bVar = new b();
        this.f21239f = bVar;
        this.f21240g = bVar;
        this.a = new k(aVar.s(), this);
    }

    private int s() {
        return this.f21236c.s().v().getId();
    }

    private void t() throws IOException {
        File file;
        e.h.a.a aVarV = this.f21236c.s().v();
        if (aVarV.g() == null) {
            aVarV.k(e.h.a.k0.f.v(aVarV.n()));
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "save Path is null to %s", aVarV.g());
            }
        }
        if (aVarV.Q()) {
            file = new File(aVarV.g());
        } else {
            String strA = e.h.a.k0.f.A(aVarV.g());
            if (strA == null) {
                throw new InvalidParameterException(e.h.a.k0.f.o("the provided mPath[%s] is invalid, can't find its directory", aVarV.g()));
            }
            file = new File(strA);
        }
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            throw new IOException(e.h.a.k0.f.o("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void u(MessageSnapshot messageSnapshot) {
        e.h.a.a aVarV = this.f21236c.s().v();
        byte bK = messageSnapshot.k();
        this.f21237d = bK;
        this.f21244k = messageSnapshot.m();
        if (bK == -4) {
            this.f21239f.a();
            int iE = h.i().e(aVarV.getId());
            if (iE + ((iE > 1 || !aVarV.Q()) ? 0 : h.i().e(e.h.a.k0.f.r(aVarV.n(), aVarV.l()))) <= 1) {
                byte bQ = m.b().Q(aVarV.getId());
                e.h.a.k0.d.i(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(aVarV.getId()), Integer.valueOf(bQ));
                if (com.liulishuo.filedownloader.model.b.a(bQ)) {
                    this.f21237d = (byte) 1;
                    this.f21242i = messageSnapshot.g();
                    long jF = messageSnapshot.f();
                    this.f21241h = jF;
                    this.f21239f.g(jF);
                    this.a.b(((MessageSnapshot.b) messageSnapshot).a());
                    return;
                }
            }
            h.i().l(this.f21236c.s(), messageSnapshot);
            return;
        }
        if (bK == -3) {
            this.n = messageSnapshot.o();
            this.f21241h = messageSnapshot.g();
            this.f21242i = messageSnapshot.g();
            h.i().l(this.f21236c.s(), messageSnapshot);
            return;
        }
        if (bK == -1) {
            this.f21238e = messageSnapshot.l();
            this.f21241h = messageSnapshot.f();
            h.i().l(this.f21236c.s(), messageSnapshot);
            return;
        }
        if (bK == 1) {
            this.f21241h = messageSnapshot.f();
            this.f21242i = messageSnapshot.g();
            this.a.b(messageSnapshot);
            return;
        }
        if (bK == 2) {
            this.f21242i = messageSnapshot.g();
            this.l = messageSnapshot.n();
            this.m = messageSnapshot.c();
            String strD = messageSnapshot.d();
            if (strD != null) {
                if (aVarV.V() != null) {
                    e.h.a.k0.d.i(this, "already has mFilename[%s], but assign mFilename[%s] again", aVarV.V(), strD);
                }
                this.f21236c.a(strD);
            }
            this.f21239f.g(this.f21241h);
            this.a.h(messageSnapshot);
            return;
        }
        if (bK == 3) {
            this.f21241h = messageSnapshot.f();
            this.f21239f.i(messageSnapshot.f());
            this.a.f(messageSnapshot);
        } else if (bK != 5) {
            if (bK != 6) {
                return;
            }
            this.a.l(messageSnapshot);
        } else {
            this.f21241h = messageSnapshot.f();
            this.f21238e = messageSnapshot.l();
            this.f21243j = messageSnapshot.h();
            this.f21239f.a();
            this.a.e(messageSnapshot);
        }
    }

    @Override // e.h.a.x.a
    public boolean a(MessageSnapshot messageSnapshot) {
        if (!this.f21236c.s().v().Q() || messageSnapshot.k() != -4 || getStatus() != 2) {
            return false;
        }
        u(messageSnapshot);
        return true;
    }

    @Override // e.h.a.x
    public void b() {
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "free the task %d, when the status is %d", Integer.valueOf(s()), Byte.valueOf(this.f21237d));
        }
        this.f21237d = (byte) 0;
    }

    @Override // e.h.a.r
    public int c() {
        return this.f21240g.c();
    }

    @Override // e.h.a.x
    public int d() {
        return this.f21243j;
    }

    @Override // e.h.a.x
    public Throwable e() {
        return this.f21238e;
    }

    @Override // e.h.a.x.a
    public t f() {
        return this.a;
    }

    @Override // e.h.a.a.d
    public void g() {
        e.h.a.a aVarV = this.f21236c.s().v();
        if (l.b()) {
            l.a().c(aVarV);
        }
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.h(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(getStatus()));
        }
        this.f21239f.f(this.f21241h);
        if (this.f21236c.D() != null) {
            ArrayList arrayList = (ArrayList) this.f21236c.D().clone();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((e.h.a.a.InterfaceC0271a) arrayList.get(i2)).a(aVarV);
            }
        }
        q.e().f().c(this.f21236c.s());
    }

    @Override // e.h.a.x
    public byte getStatus() {
        return this.f21237d;
    }

    @Override // e.h.a.x
    public boolean h() {
        return this.f21244k;
    }

    @Override // e.h.a.x.a
    public boolean i(MessageSnapshot messageSnapshot) {
        if (com.liulishuo.filedownloader.model.b.b(getStatus(), messageSnapshot.k())) {
            u(messageSnapshot);
            return true;
        }
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.f21237d), Byte.valueOf(getStatus()), Integer.valueOf(s()));
        }
        return false;
    }

    @Override // e.h.a.x
    public void j() {
        boolean z;
        synchronized (this.f21235b) {
            if (this.f21237d != 0) {
                e.h.a.k0.d.i(this, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", Integer.valueOf(s()), Byte.valueOf(this.f21237d));
                return;
            }
            this.f21237d = (byte) 10;
            e.h.a.a.b bVarS = this.f21236c.s();
            e.h.a.a aVarV = bVarS.v();
            if (l.b()) {
                l.a().b(aVarV);
            }
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.h(this, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", aVarV.n(), aVarV.g(), aVarV.G(), aVarV.getTag());
            }
            try {
                t();
                z = true;
            } catch (Throwable th) {
                h.i().a(bVarS);
                h.i().l(bVarS, l(th));
                z = false;
            }
            if (z) {
                p.c().d(this);
            }
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.h(this, "the task[%d] has been into the launch pool.", Integer.valueOf(s()));
            }
        }
    }

    @Override // e.h.a.x
    public long k() {
        return this.f21241h;
    }

    @Override // e.h.a.x.a
    public MessageSnapshot l(Throwable th) {
        this.f21237d = (byte) -1;
        this.f21238e = th;
        return com.liulishuo.filedownloader.message.c.b(s(), k(), th);
    }

    @Override // e.h.a.x
    public long m() {
        return this.f21242i;
    }

    @Override // e.h.a.x.a
    public boolean n(MessageSnapshot messageSnapshot) {
        if (!com.liulishuo.filedownloader.model.b.d(this.f21236c.s().v())) {
            return false;
        }
        u(messageSnapshot);
        return true;
    }

    @Override // e.h.a.a.d
    public void o() {
        if (l.b() && getStatus() == 6) {
            l.a().e(this.f21236c.s().v());
        }
    }

    @Override // e.h.a.x.a
    public boolean p(MessageSnapshot messageSnapshot) {
        byte status = getStatus();
        byte bK = messageSnapshot.k();
        if (-2 == status && com.liulishuo.filedownloader.model.b.a(bK)) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(s()));
            }
            return true;
        }
        if (com.liulishuo.filedownloader.model.b.c(status, bK)) {
            u(messageSnapshot);
            return true;
        }
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.f21237d), Byte.valueOf(getStatus()), Integer.valueOf(s()));
        }
        return false;
    }

    @Override // e.h.a.x
    public boolean pause() {
        if (com.liulishuo.filedownloader.model.b.e(getStatus())) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(getStatus()), Integer.valueOf(this.f21236c.s().v().getId()));
            }
            return false;
        }
        this.f21237d = (byte) -2;
        e.h.a.a.b bVarS = this.f21236c.s();
        e.h.a.a aVarV = bVarS.v();
        p.c().b(this);
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.h(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(s()));
        }
        if (q.e().i()) {
            m.b().a0(aVarV.getId());
        } else if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(aVarV.getId()));
        }
        h.i().a(bVarS);
        h.i().l(bVarS, com.liulishuo.filedownloader.message.c.c(aVarV));
        q.e().f().c(bVarS);
        return true;
    }

    @Override // e.h.a.a.d
    public void q() {
        if (l.b()) {
            l.a().d(this.f21236c.s().v());
        }
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.h(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(getStatus()));
        }
    }

    @Override // e.h.a.x.b
    public boolean r(i iVar) {
        return this.f21236c.s().v().G() == iVar;
    }

    @Override // e.h.a.x.b
    public void start() {
        if (this.f21237d != 10) {
            e.h.a.k0.d.i(this, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", Integer.valueOf(s()), Byte.valueOf(this.f21237d));
            return;
        }
        e.h.a.a.b bVarS = this.f21236c.s();
        e.h.a.a aVarV = bVarS.v();
        v vVarF = q.e().f();
        try {
            if (vVarF.b(bVarS)) {
                return;
            }
            synchronized (this.f21235b) {
                if (this.f21237d != 10) {
                    e.h.a.k0.d.i(this, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", Integer.valueOf(s()), Byte.valueOf(this.f21237d));
                    return;
                }
                this.f21237d = (byte) 11;
                h.i().a(bVarS);
                if (e.h.a.k0.c.d(aVarV.getId(), aVarV.l(), aVarV.M(), true)) {
                    return;
                }
                boolean zS = m.b().S(aVarV.n(), aVarV.g(), aVarV.Q(), aVarV.K(), aVarV.q(), aVarV.t(), aVarV.M(), this.f21236c.N(), aVarV.r());
                if (this.f21237d == -2) {
                    e.h.a.k0.d.i(this, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", Integer.valueOf(s()));
                    if (zS) {
                        m.b().a0(s());
                        return;
                    }
                    return;
                }
                if (zS) {
                    vVarF.c(bVarS);
                    return;
                }
                if (vVarF.b(bVarS)) {
                    return;
                }
                MessageSnapshot messageSnapshotL = l(new RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
                if (h.i().k(bVarS)) {
                    vVarF.c(bVarS);
                    h.i().a(bVarS);
                }
                h.i().l(bVarS, messageSnapshotL);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            h.i().l(bVarS, l(th));
        }
    }
}
