package e.h.a.g0;

import android.os.SystemClock;
import androidx.recyclerview.widget.RecyclerView;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.liulishuo.filedownloader.exception.FileDownloadNetworkPolicyException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: FetchDataTask.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    private final h a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f21320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f21321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final e.h.a.e0.b f21322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f21323f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f21324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f21325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f21326i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f21327j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    long f21328k;
    private e.h.a.j0.a l;
    private volatile boolean m;
    private final e.h.a.f0.a n;
    private volatile long o;
    private volatile long p;

    /* JADX INFO: compiled from: FetchDataTask.java */
    public static class b {
        e a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        e.h.a.e0.b f21329b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        e.h.a.g0.b f21330c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h f21331d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f21332e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Boolean f21333f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Integer f21334g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Integer f21335h;

        public g a() throws IllegalArgumentException {
            e.h.a.e0.b bVar;
            e.h.a.g0.b bVar2;
            Integer num;
            if (this.f21333f == null || (bVar = this.f21329b) == null || (bVar2 = this.f21330c) == null || this.f21331d == null || this.f21332e == null || (num = this.f21335h) == null || this.f21334g == null) {
                throw new IllegalArgumentException();
            }
            return new g(bVar, bVar2, this.a, num.intValue(), this.f21334g.intValue(), this.f21333f.booleanValue(), this.f21331d, this.f21332e);
        }

        public b b(h hVar) {
            this.f21331d = hVar;
            return this;
        }

        public b c(e.h.a.e0.b bVar) {
            this.f21329b = bVar;
            return this;
        }

        public b d(int i2) {
            this.f21334g = Integer.valueOf(i2);
            return this;
        }

        public b e(e.h.a.g0.b bVar) {
            this.f21330c = bVar;
            return this;
        }

        public b f(int i2) {
            this.f21335h = Integer.valueOf(i2);
            return this;
        }

        public b g(e eVar) {
            this.a = eVar;
            return this;
        }

        public b h(String str) {
            this.f21332e = str;
            return this;
        }

        public b i(boolean z) {
            this.f21333f = Boolean.valueOf(z);
            return this;
        }
    }

    private void a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (e.h.a.k0.f.L(this.f21328k - this.o, jElapsedRealtime - this.p)) {
            d();
            this.o = this.f21328k;
            this.p = jElapsedRealtime;
        }
    }

    private void d() {
        boolean z;
        long jUptimeMillis = SystemClock.uptimeMillis();
        try {
            this.l.b();
            z = true;
        } catch (IOException e2) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e2);
            }
            z = false;
        }
        if (z) {
            int i2 = this.f21320c;
            if (i2 >= 0) {
                this.n.f(this.f21319b, i2, this.f21328k);
            } else {
                this.a.f();
            }
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.f21319b), Integer.valueOf(this.f21320c), Long.valueOf(this.f21328k), Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
            }
        }
    }

    public void b() {
        this.m = true;
    }

    public void c() throws Throwable {
        Throwable th;
        e.h.a.j0.a aVarC;
        if (this.m) {
            return;
        }
        long jH = e.h.a.k0.f.h(this.f21320c, this.f21322e);
        if (jH == -1) {
            jH = e.h.a.k0.f.i(this.f21322e);
        }
        if (jH == 0) {
            throw new FileDownloadGiveUpRetryException(e.h.a.k0.f.o("there isn't any content need to download on %d-%d with the content-length is 0", Integer.valueOf(this.f21319b), Integer.valueOf(this.f21320c)));
        }
        long j2 = this.f21326i;
        if (j2 > 0 && jH != j2) {
            throw new FileDownloadGiveUpRetryException(e.h.a.k0.f.o("require %s with contentLength(%d), but the backend response contentLength is %d on downloadId[%d]-connectionIndex[%d], please ask your backend dev to fix such problem.", this.f21325h == -1 ? e.h.a.k0.f.o("range[%d-)", Long.valueOf(this.f21328k)) : e.h.a.k0.f.o("range[%d-%d)", Long.valueOf(this.f21328k), Long.valueOf(this.f21325h)), Long.valueOf(this.f21326i), Long.valueOf(jH), Integer.valueOf(this.f21319b), Integer.valueOf(this.f21320c)));
        }
        long j3 = this.f21328k;
        InputStream inputStreamA = null;
        try {
            boolean zM = c.j().m();
            if (this.f21321d != null && !zM) {
                throw new IllegalAccessException("can't using multi-download when the output stream can't support seek");
            }
            aVarC = e.h.a.k0.f.c(this.f21327j);
            try {
                this.l = aVarC;
                if (zM) {
                    aVarC.c(this.f21328k);
                }
                if (e.h.a.k0.d.a) {
                    e.h.a.k0.d.a(this, "start fetch(%d): range [%d, %d), seek to[%d]", Integer.valueOf(this.f21320c), Long.valueOf(this.f21324g), Long.valueOf(this.f21325h), Long.valueOf(this.f21328k));
                }
                inputStreamA = this.f21322e.a();
                byte[] bArr = new byte[RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT];
                if (this.m) {
                    if (inputStreamA != null) {
                        try {
                            inputStreamA.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (aVarC != null) {
                        try {
                            d();
                        } catch (Throwable th2) {
                            try {
                                aVarC.close();
                                throw th2;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                throw th2;
                            }
                        }
                    }
                    if (aVarC != null) {
                        try {
                            aVarC.close();
                            return;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                while (true) {
                    int i2 = inputStreamA.read(bArr);
                    if (i2 == -1) {
                        try {
                            inputStreamA.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                        if (aVarC != null) {
                            try {
                                d();
                            } catch (Throwable th3) {
                                try {
                                    aVarC.close();
                                    throw th3;
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                    throw th3;
                                }
                            }
                        }
                        if (aVarC != null) {
                            try {
                                aVarC.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        long j4 = this.f21328k - j3;
                        if (jH != -1 && jH != j4) {
                            throw new FileDownloadGiveUpRetryException(e.h.a.k0.f.o("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset[%d]", Long.valueOf(j4), Long.valueOf(jH), Long.valueOf(this.f21324g), Long.valueOf(this.f21325h), Long.valueOf(this.f21328k), Long.valueOf(j3)));
                        }
                        this.a.a(this.f21321d, this.f21324g, this.f21325h);
                        return;
                    }
                    aVarC.write(bArr, 0, i2);
                    long j5 = j3;
                    long j6 = i2;
                    this.f21328k += j6;
                    this.a.d(j6);
                    a();
                    if (this.m) {
                        try {
                            inputStreamA.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                        try {
                            d();
                            try {
                                return;
                            } catch (IOException e9) {
                                return;
                            }
                        } finally {
                            try {
                                aVarC.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                    }
                    if (this.f21323f && e.h.a.k0.f.M()) {
                        throw new FileDownloadNetworkPolicyException();
                    }
                    j3 = j5;
                }
            } catch (Throwable th4) {
                th = th4;
                if (inputStreamA != null) {
                    try {
                        inputStreamA.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
                if (aVarC != null) {
                    try {
                        d();
                    } catch (Throwable th5) {
                        try {
                            aVarC.close();
                            throw th5;
                        } catch (IOException e12) {
                            e12.printStackTrace();
                            throw th5;
                        }
                    }
                }
                if (aVarC == null) {
                    throw th;
                }
                try {
                    aVarC.close();
                    throw th;
                } catch (IOException e13) {
                    e13.printStackTrace();
                    throw th;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            aVarC = null;
        }
    }

    private g(e.h.a.e0.b bVar, e.h.a.g0.b bVar2, e eVar, int i2, int i3, boolean z, h hVar, String str) {
        this.o = 0L;
        this.p = 0L;
        this.a = hVar;
        this.f21327j = str;
        this.f21322e = bVar;
        this.f21323f = z;
        this.f21321d = eVar;
        this.f21320c = i3;
        this.f21319b = i2;
        this.n = c.j().f();
        this.f21324g = bVar2.a;
        this.f21325h = bVar2.f21276c;
        this.f21328k = bVar2.f21275b;
        this.f21326i = bVar2.f21277d;
    }
}
