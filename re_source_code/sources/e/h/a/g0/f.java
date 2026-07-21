package e.h.a.g0;

import android.database.sqlite.SQLiteFullException;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.liulishuo.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: DownloadStatusCallback.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final FileDownloadModel f21311f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a f21313h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f21314i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f21315j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f21316k;
    private long l;
    private Handler m;
    private HandlerThread n;
    private volatile Thread p;
    private volatile boolean o = false;
    private volatile long q = 0;
    private final AtomicLong r = new AtomicLong();
    private final AtomicBoolean s = new AtomicBoolean(false);
    private final AtomicBoolean t = new AtomicBoolean(false);
    private final AtomicBoolean u = new AtomicBoolean(true);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e.h.a.f0.a f21312g = c.j().f();

    /* JADX INFO: compiled from: DownloadStatusCallback.java */
    public static class a {
        private boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Exception f21317b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f21318c;

        public Exception a() {
            return this.f21317b;
        }

        public int b() {
            return this.f21318c;
        }

        public boolean c() {
            return this.a;
        }

        void d(Exception exc) {
            this.f21317b = exc;
        }

        void e(boolean z) {
            this.a = z;
        }

        void f(int i2) {
            this.f21318c = i2;
        }
    }

    f(FileDownloadModel fileDownloadModel, int i2, int i3, int i4) {
        this.f21311f = fileDownloadModel;
        this.f21315j = i3 < 5 ? 5 : i3;
        this.f21316k = i4;
        this.f21313h = new a();
        this.f21314i = i2;
    }

    private static long a(long j2, long j3) {
        if (j3 <= 0) {
            return -1L;
        }
        if (j2 == -1) {
            return 1L;
        }
        long j4 = j2 / j3;
        if (j4 <= 0) {
            return 1L;
        }
        return j4;
    }

    private Exception c(Exception exc) {
        long length;
        String strJ = this.f21311f.j();
        if ((!this.f21311f.n() && !e.h.a.k0.e.a().f21368f) || !(exc instanceof IOException) || !new File(strJ).exists()) {
            return exc;
        }
        long jX = e.h.a.k0.f.x(strJ);
        if (jX > 4096) {
            return exc;
        }
        File file = new File(strJ);
        if (file.exists()) {
            length = file.length();
        } else {
            e.h.a.k0.d.c(this, exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
            length = 0;
        }
        return Build.VERSION.SDK_INT >= 9 ? new FileDownloadOutOfSpaceException(jX, 4096L, length, exc) : new FileDownloadOutOfSpaceException(jX, 4096L, length);
    }

    private void d() throws Throwable {
        w();
        this.f21311f.y((byte) -3);
        this.f21312g.d(this.f21311f.e(), this.f21311f.k());
        this.f21312g.h(this.f21311f.e());
        v((byte) -3);
        if (e.h.a.k0.e.a().f21369g) {
            com.liulishuo.filedownloader.services.f.a(this.f21311f);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void e(Exception exc) {
        SQLiteFullException sQLiteFullException;
        Exception excC = c(exc);
        if (excC instanceof SQLiteFullException) {
            i((SQLiteFullException) excC);
            sQLiteFullException = excC;
        } else {
            try {
                this.f21311f.y((byte) -1);
                this.f21311f.t(exc.toString());
                this.f21312g.k(this.f21311f.e(), excC, this.f21311f.g());
                sQLiteFullException = excC;
            } catch (SQLiteFullException e2) {
                SQLiteFullException sQLiteFullException2 = e2;
                i(sQLiteFullException2);
                sQLiteFullException = sQLiteFullException2;
            }
        }
        this.f21313h.d(sQLiteFullException);
        v((byte) -1);
    }

    private void f() {
        this.f21311f.y((byte) -2);
        this.f21312g.q(this.f21311f.e(), this.f21311f.g());
        v((byte) -2);
    }

    private void g() {
        if (this.f21311f.g() == this.f21311f.k()) {
            this.f21312g.l(this.f21311f.e(), this.f21311f.g());
            return;
        }
        if (this.t.compareAndSet(true, false)) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.e(this, "handleProgress update model's status with progress", new Object[0]);
            }
            this.f21311f.y((byte) 3);
        }
        if (this.s.compareAndSet(true, false)) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.e(this, "handleProgress notify user progress status", new Object[0]);
            }
            v((byte) 3);
        }
    }

    private void h(Exception exc, int i2) {
        Exception excC = c(exc);
        this.f21313h.d(excC);
        this.f21313h.f(this.f21314i - i2);
        this.f21311f.y((byte) 5);
        this.f21311f.t(excC.toString());
        this.f21312g.c(this.f21311f.e(), excC);
        v((byte) 5);
    }

    private void i(SQLiteFullException sQLiteFullException) {
        int iE = this.f21311f.e();
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(iE), sQLiteFullException.toString());
        }
        this.f21311f.t(sQLiteFullException.toString());
        this.f21311f.y((byte) -1);
        this.f21312g.remove(iE);
        this.f21312g.h(iE);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x000a  */
    private void j(long j2) {
        boolean z;
        if (this.u.compareAndSet(true, false)) {
            z = true;
        } else {
            long j3 = j2 - this.q;
            if (this.l == -1 || this.r.get() < this.l || j3 < this.f21315j) {
                z = false;
            } else {
                z = true;
            }
        }
        if (z && this.s.compareAndSet(false, true)) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.e(this, "inspectNeedCallbackToUser need callback to user", new Object[0]);
            }
            this.q = j2;
            this.r.set(0L);
        }
    }

    private boolean k() {
        if (this.f21311f.n()) {
            FileDownloadModel fileDownloadModel = this.f21311f;
            fileDownloadModel.z(fileDownloadModel.g());
        } else if (this.f21311f.g() != this.f21311f.k()) {
            o(new FileDownloadGiveUpRetryException(e.h.a.k0.f.o("sofar[%d] not equal total[%d]", Long.valueOf(this.f21311f.g()), Long.valueOf(this.f21311f.k()))));
            return true;
        }
        return false;
    }

    private void v(byte b2) {
        if (b2 != -2) {
            com.liulishuo.filedownloader.message.b.a().b(com.liulishuo.filedownloader.message.c.e(b2, this.f21311f, this.f21313h));
        } else if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.f21311f.e()));
        }
    }

    private void w() throws Throwable {
        boolean z;
        String strJ = this.f21311f.j();
        String strI = this.f21311f.i();
        File file = new File(strJ);
        try {
            File file2 = new File(strI);
            if (file2.exists()) {
                long length = file2.length();
                if (!file2.delete()) {
                    throw new IOException(e.h.a.k0.f.o("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", strI, Long.valueOf(length)));
                }
                e.h.a.k0.d.i(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", strI, Long.valueOf(length), Long.valueOf(file.length()));
            }
            z = !file.renameTo(file2);
            if (!z) {
                if (z && file.exists() && !file.delete()) {
                    e.h.a.k0.d.i(this, "delete the temp file(%s) failed, on completed downloading.", strJ);
                    return;
                }
                return;
            }
            try {
                throw new IOException(e.h.a.k0.f.o("Can't rename the  temp downloaded file(%s) to the target file(%s)", strJ, strI));
            } catch (Throwable th) {
                th = th;
                if (z && file.exists() && !file.delete()) {
                    e.h.a.k0.d.i(this, "delete the temp file(%s) failed, on completed downloading.", strJ);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z = true;
        }
    }

    private synchronized void x(Message message) {
        if (!this.n.isAlive()) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
            }
            return;
        }
        try {
            this.m.sendMessage(message);
        } catch (IllegalStateException e2) {
            if (this.n.isAlive()) {
                throw e2;
            }
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
            }
        }
    }

    void b() {
        Handler handler = this.m;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.n.quit();
            this.p = Thread.currentThread();
            while (this.o) {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
            }
            this.p = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0020  */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        this.o = true;
        int i2 = message.what;
        try {
            if (i2 != 3) {
                if (i2 == 5) {
                    h((Exception) message.obj, message.arg1);
                }
                this.o = false;
                if (this.p != null) {
                    LockSupport.unpark(this.p);
                }
                return true;
            }
            g();
            this.o = false;
            if (this.p != null) {
                LockSupport.unpark(this.p);
            }
            return true;
        } catch (Throwable th) {
            this.o = false;
            if (this.p != null) {
                LockSupport.unpark(this.p);
            }
            throw th;
        }
    }

    public boolean l() {
        HandlerThread handlerThread = this.n;
        return handlerThread != null && handlerThread.isAlive();
    }

    void m() throws Throwable {
        if (k()) {
            return;
        }
        d();
    }

    void n(boolean z, long j2, String str, String str2) throws IllegalArgumentException {
        String strB = this.f21311f.b();
        if (strB != null && !strB.equals(str)) {
            throw new IllegalArgumentException(e.h.a.k0.f.o("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, strB));
        }
        this.f21313h.e(z);
        this.f21311f.y((byte) 2);
        this.f21311f.z(j2);
        this.f21311f.s(str);
        this.f21311f.u(str2);
        this.f21312g.m(this.f21311f.e(), j2, str, str2);
        v((byte) 2);
        this.l = a(j2, this.f21316k);
        this.t.compareAndSet(false, true);
    }

    void o(Exception exc) {
        e(exc);
    }

    void p() {
        HandlerThread handlerThread = new HandlerThread("source-status-callback");
        this.n = handlerThread;
        handlerThread.start();
        this.m = new Handler(this.n.getLooper(), this);
    }

    void q() {
        f();
    }

    public void r() {
        this.f21311f.y((byte) 1);
        this.f21312g.a(this.f21311f.e());
        v((byte) 1);
    }

    void s(long j2) {
        this.r.addAndGet(j2);
        this.f21311f.m(j2);
        j(SystemClock.elapsedRealtime());
        if (this.m == null) {
            g();
        } else if (this.s.get()) {
            x(this.m.obtainMessage(3));
        }
    }

    void t(Exception exc, int i2) {
        this.r.set(0L);
        Handler handler = this.m;
        if (handler == null) {
            h(exc, i2);
        } else {
            x(handler.obtainMessage(5, i2, 0, exc));
        }
    }

    void u() {
        this.f21311f.y((byte) 6);
        v((byte) 6);
        this.f21312g.i(this.f21311f.e());
    }
}
