package e.h.a;

import com.liulishuo.filedownloader.message.BlockCompleteMessage;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: FileDownloadMessenger.java */
/* JADX INFO: loaded from: classes2.dex */
class k implements t {
    private a.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a.d f21357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Queue<MessageSnapshot> f21358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f21359d = false;

    k(a.b bVar, a.d dVar) {
        n(bVar, dVar);
    }

    private void n(a.b bVar, a.d dVar) {
        this.a = bVar;
        this.f21357b = dVar;
        this.f21358c = new LinkedBlockingQueue();
    }

    private void o(int i2) {
        if (com.liulishuo.filedownloader.model.b.e(i2)) {
            if (!this.f21358c.isEmpty()) {
                MessageSnapshot messageSnapshotPeek = this.f21358c.peek();
                e.h.a.k0.d.i(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(messageSnapshotPeek.e()), Integer.valueOf(this.f21358c.size()), Byte.valueOf(messageSnapshotPeek.k()));
            }
            this.a = null;
        }
    }

    private void q(MessageSnapshot messageSnapshot) {
        a.b bVar = this.a;
        if (bVar == null) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(messageSnapshot.e()), Byte.valueOf(messageSnapshot.k()));
            }
        } else {
            if (!this.f21359d && bVar.v().G() != null) {
                this.f21358c.offer(messageSnapshot);
                j.d().i(this);
                return;
            }
            if ((l.b() || this.a.S()) && messageSnapshot.k() == 4) {
                this.f21357b.g();
            }
            o(messageSnapshot.k());
        }
    }

    @Override // e.h.a.t
    public boolean a() {
        return this.a.v().U();
    }

    @Override // e.h.a.t
    public void b(MessageSnapshot messageSnapshot) {
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "notify pending %s", this.a);
        }
        this.f21357b.o();
        q(messageSnapshot);
    }

    @Override // e.h.a.t
    public void c(MessageSnapshot messageSnapshot) {
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "notify paused %s", this.a);
        }
        this.f21357b.g();
        q(messageSnapshot);
    }

    @Override // e.h.a.t
    public void d(MessageSnapshot messageSnapshot) {
        if (e.h.a.k0.d.a) {
            a.b bVar = this.a;
            e.h.a.k0.d.a(this, "notify error %s %s", bVar, bVar.v().e());
        }
        this.f21357b.g();
        q(messageSnapshot);
    }

    @Override // e.h.a.t
    public void e(MessageSnapshot messageSnapshot) {
        if (e.h.a.k0.d.a) {
            a aVarV = this.a.v();
            e.h.a.k0.d.a(this, "notify retry %s %d %d %s", this.a, Integer.valueOf(aVarV.t()), Integer.valueOf(aVarV.d()), aVarV.e());
        }
        this.f21357b.o();
        q(messageSnapshot);
    }

    @Override // e.h.a.t
    public void f(MessageSnapshot messageSnapshot) {
        a aVarV = this.a.v();
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "notify progress %s %d %d", aVarV, Long.valueOf(aVarV.o()), Long.valueOf(aVarV.E()));
        }
        if (aVarV.K() > 0) {
            this.f21357b.o();
            q(messageSnapshot);
        } else if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "notify progress but client not request notify %s", this.a);
        }
    }

    @Override // e.h.a.t
    public void g(MessageSnapshot messageSnapshot) {
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "notify warn %s", this.a);
        }
        this.f21357b.g();
        q(messageSnapshot);
    }

    @Override // e.h.a.t
    public void h(MessageSnapshot messageSnapshot) {
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "notify connected %s", this.a);
        }
        this.f21357b.o();
        q(messageSnapshot);
    }

    @Override // e.h.a.t
    public boolean i() {
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "notify begin %s", this.a);
        }
        if (this.a == null) {
            e.h.a.k0.d.i(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.f21358c.size()));
            return false;
        }
        this.f21357b.q();
        return true;
    }

    @Override // e.h.a.t
    public boolean j() {
        return this.f21358c.peek().k() == 4;
    }

    @Override // e.h.a.t
    public void k(MessageSnapshot messageSnapshot) {
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "notify block completed %s %s", this.a, Thread.currentThread().getName());
        }
        this.f21357b.o();
        q(messageSnapshot);
    }

    @Override // e.h.a.t
    public void l(MessageSnapshot messageSnapshot) {
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "notify started %s", this.a);
        }
        this.f21357b.o();
        q(messageSnapshot);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.h.a.t
    public void m() {
        if (this.f21359d) {
            return;
        }
        MessageSnapshot messageSnapshotPoll = this.f21358c.poll();
        byte bK = messageSnapshotPoll.k();
        a.b bVar = this.a;
        if (bVar == null) {
            throw new IllegalArgumentException(e.h.a.k0.f.o("can't handover the message, no master to receive this message(status[%d]) size[%d]", Integer.valueOf(bK), Integer.valueOf(this.f21358c.size())));
        }
        a aVarV = bVar.v();
        i iVarG = aVarV.G();
        x.a aVarY = bVar.y();
        o(bK);
        if (iVarG == null || iVarG.isInvalid()) {
            return;
        }
        if (bK == 4) {
            try {
                iVarG.blockComplete(aVarV);
                p(((BlockCompleteMessage) messageSnapshotPoll).b());
                return;
            } catch (Throwable th) {
                d(aVarY.l(th));
                return;
            }
        }
        g gVar = iVarG instanceof g ? (g) iVarG : null;
        if (bK == -4) {
            iVarG.warn(aVarV);
            return;
        }
        if (bK == -3) {
            iVarG.completed(aVarV);
            return;
        }
        if (bK == -2) {
            if (gVar != null) {
                gVar.paused(aVarV, messageSnapshotPoll.f(), messageSnapshotPoll.g());
                return;
            } else {
                iVarG.paused(aVarV, messageSnapshotPoll.i(), messageSnapshotPoll.j());
                return;
            }
        }
        if (bK == -1) {
            iVarG.error(aVarV, messageSnapshotPoll.l());
            return;
        }
        if (bK == 1) {
            if (gVar != null) {
                gVar.pending(aVarV, messageSnapshotPoll.f(), messageSnapshotPoll.g());
                return;
            } else {
                iVarG.pending(aVarV, messageSnapshotPoll.i(), messageSnapshotPoll.j());
                return;
            }
        }
        if (bK == 2) {
            if (gVar != null) {
                gVar.connected(aVarV, messageSnapshotPoll.c(), messageSnapshotPoll.n(), aVarV.o(), messageSnapshotPoll.g());
                return;
            } else {
                iVarG.connected(aVarV, messageSnapshotPoll.c(), messageSnapshotPoll.n(), aVarV.B(), messageSnapshotPoll.j());
                return;
            }
        }
        if (bK == 3) {
            if (gVar != null) {
                gVar.progress(aVarV, messageSnapshotPoll.f(), aVarV.E());
                return;
            } else {
                iVarG.progress(aVarV, messageSnapshotPoll.i(), aVarV.i());
                return;
            }
        }
        if (bK != 5) {
            if (bK != 6) {
                return;
            }
            iVarG.started(aVarV);
        } else if (gVar != null) {
            gVar.retry(aVarV, messageSnapshotPoll.l(), messageSnapshotPoll.h(), messageSnapshotPoll.f());
        } else {
            iVarG.retry(aVarV, messageSnapshotPoll.l(), messageSnapshotPoll.h(), messageSnapshotPoll.i());
        }
    }

    public void p(MessageSnapshot messageSnapshot) {
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "notify completed %s", this.a);
        }
        this.f21357b.g();
        q(messageSnapshot);
    }

    public String toString() {
        Object[] objArr = new Object[2];
        a.b bVar = this.a;
        objArr[0] = Integer.valueOf(bVar == null ? -1 : bVar.v().getId());
        objArr[1] = super.toString();
        return e.h.a.k0.f.o("%d:%s", objArr);
    }
}
