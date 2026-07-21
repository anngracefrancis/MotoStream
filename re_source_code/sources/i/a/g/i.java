package i.a.g;

import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: DNSStatefulObject.java */
/* JADX INFO: loaded from: classes2.dex */
public interface i {

    /* JADX INFO: compiled from: DNSStatefulObject.java */
    public static final class a {
        private static k.b.b a = k.b.c.i(a.class.getName());

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f21783b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ConcurrentMap<Thread, Semaphore> f21784c = new ConcurrentHashMap(50);

        public a(String str) {
            this.f21783b = str;
        }

        public void a() {
            Collection<Semaphore> collectionValues = this.f21784c.values();
            for (Semaphore semaphore : collectionValues) {
                semaphore.release();
                collectionValues.remove(semaphore);
            }
        }

        public void b(long j2) {
            Thread threadCurrentThread = Thread.currentThread();
            if (this.f21784c.get(threadCurrentThread) == null) {
                Semaphore semaphore = new Semaphore(1, true);
                semaphore.drainPermits();
                this.f21784c.putIfAbsent(threadCurrentThread, semaphore);
            }
            try {
                this.f21784c.get(threadCurrentThread).tryAcquire(j2, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                a.g("Exception ", e2);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(1000);
            sb.append("Semaphore: ");
            sb.append(this.f21783b);
            if (this.f21784c.size() == 0) {
                sb.append(" no semaphores.");
            } else {
                sb.append(" semaphores:\n");
                for (Thread thread : this.f21784c.keySet()) {
                    sb.append("\tThread: ");
                    sb.append(thread.getName());
                    sb.append(' ');
                    sb.append(this.f21784c.get(thread));
                    sb.append('\n');
                }
            }
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: DNSStatefulObject.java */
    public static class b extends ReentrantLock implements i {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static k.b.b f21785f = k.b.c.i(b.class.getName());

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private volatile l f21786g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        protected volatile i.a.g.t.a f21787h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        protected volatile i.a.g.s.g f21788i = i.a.g.s.g.f21884f;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final a f21789j = new a("Announce");

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final a f21790k = new a("Cancel");

        private boolean v() {
            return this.f21788i.u() || this.f21788i.v();
        }

        private boolean w() {
            return this.f21788i.x() || this.f21788i.y();
        }

        public void a(i.a.g.t.a aVar, i.a.g.s.g gVar) {
            if (this.f21787h == null && this.f21788i == gVar) {
                lock();
                try {
                    if (this.f21787h == null && this.f21788i == gVar) {
                        s(aVar);
                    }
                } finally {
                    unlock();
                }
            }
        }

        public boolean b() {
            boolean z = false;
            if (!v()) {
                lock();
                try {
                    if (!v()) {
                        r(i.a.g.s.g.l);
                        s(null);
                        z = true;
                    }
                } finally {
                    unlock();
                }
            }
            return z;
        }

        public boolean c() {
            boolean z = false;
            if (!w()) {
                lock();
                try {
                    if (!w()) {
                        r(i.a.g.s.g.p);
                        s(null);
                        z = true;
                    }
                } finally {
                    unlock();
                }
            }
            return z;
        }

        @Override // i.a.g.i
        public boolean d(i.a.g.t.a aVar) {
            if (this.f21787h != aVar) {
                return true;
            }
            lock();
            try {
                if (this.f21787h == aVar) {
                    r(this.f21788i.g());
                } else {
                    f21785f.h("Trying to advance state whhen not the owner. owner: " + this.f21787h + " perpetrator: " + aVar);
                }
                return true;
            } finally {
                unlock();
            }
        }

        public l e() {
            return this.f21786g;
        }

        public boolean f() {
            return this.f21788i.k();
        }

        public boolean g() {
            return this.f21788i.q();
        }

        public boolean h(i.a.g.t.a aVar, i.a.g.s.g gVar) {
            lock();
            try {
                return this.f21787h == aVar && this.f21788i == gVar;
            } finally {
                unlock();
            }
        }

        public boolean i() {
            return this.f21788i.u();
        }

        public boolean j() {
            return this.f21788i.v();
        }

        public boolean k() {
            return this.f21788i.x();
        }

        public boolean l() {
            return this.f21788i.y();
        }

        public boolean m() {
            return this.f21788i.A();
        }

        public boolean n() {
            lock();
            try {
                r(i.a.g.s.g.f21884f);
                s(null);
                return false;
            } finally {
                unlock();
            }
        }

        public void o(i.a.g.t.a aVar) {
            if (this.f21787h == aVar) {
                lock();
                try {
                    if (this.f21787h == aVar) {
                        s(null);
                    }
                } finally {
                    unlock();
                }
            }
        }

        public boolean p() {
            if (v()) {
                return true;
            }
            lock();
            try {
                if (!v()) {
                    r(this.f21788i.D());
                    s(null);
                }
                return true;
            } finally {
                unlock();
            }
        }

        protected void q(l lVar) {
            this.f21786g = lVar;
        }

        protected void r(i.a.g.s.g gVar) {
            lock();
            try {
                this.f21788i = gVar;
                if (f()) {
                    this.f21789j.a();
                }
                if (i()) {
                    this.f21790k.a();
                    this.f21789j.a();
                }
            } finally {
                unlock();
            }
        }

        protected void s(i.a.g.t.a aVar) {
            this.f21787h = aVar;
        }

        public boolean t(long j2) {
            if (!f() && !v()) {
                this.f21789j.b(j2 + 10);
            }
            if (!f()) {
                this.f21789j.b(10L);
                if (!f()) {
                    if (v() || w()) {
                        f21785f.c("Wait for announced cancelled: " + this);
                    } else {
                        f21785f.h("Wait for announced timed out: " + this);
                    }
                }
            }
            return f();
        }

        @Override // java.util.concurrent.locks.ReentrantLock
        public String toString() {
            String str;
            String str2 = "NO DNS";
            try {
                StringBuilder sb = new StringBuilder();
                if (this.f21786g != null) {
                    str = "DNS: " + this.f21786g.p0() + " [" + this.f21786g.i0() + "]";
                } else {
                    str = "NO DNS";
                }
                sb.append(str);
                sb.append(" state: ");
                sb.append(this.f21788i);
                sb.append(" task: ");
                sb.append(this.f21787h);
                return sb.toString();
            } catch (IOException unused) {
                StringBuilder sb2 = new StringBuilder();
                if (this.f21786g != null) {
                    str2 = "DNS: " + this.f21786g.p0();
                }
                sb2.append(str2);
                sb2.append(" state: ");
                sb2.append(this.f21788i);
                sb2.append(" task: ");
                sb2.append(this.f21787h);
                return sb2.toString();
            }
        }

        public boolean u(long j2) {
            if (!i()) {
                this.f21790k.b(j2);
            }
            if (!i()) {
                this.f21790k.b(10L);
                if (!i() && !w()) {
                    f21785f.h("Wait for canceled timed out: " + this);
                }
            }
            return i();
        }
    }

    boolean d(i.a.g.t.a aVar);
}
