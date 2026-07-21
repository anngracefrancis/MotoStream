package io.sentry.cache;

import io.sentry.c2;
import io.sentry.d5;
import io.sentry.h4;
import io.sentry.j4;
import io.sentry.r4;
import io.sentry.s4;
import io.sentry.x4;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: CacheStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final Charset f22350f = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final x4 f22351g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final c2 f22352h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final File f22353i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f22354j;

    o(x4 x4Var, String str, int i2) {
        io.sentry.util.q.c(str, "Directory is required.");
        this.f22351g = (x4) io.sentry.util.q.c(x4Var, "SentryOptions is required.");
        this.f22352h = x4Var.getSerializer();
        this.f22353i = new File(str);
        this.f22354j = i2;
    }

    private h4 c(h4 h4Var, j4 j4Var) {
        ArrayList arrayList = new ArrayList();
        Iterator<j4> it = h4Var.c().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        arrayList.add(j4Var);
        return new h4(h4Var.b(), arrayList);
    }

    private d5 f(h4 h4Var) {
        for (j4 j4Var : h4Var.c()) {
            if (h(j4Var)) {
                return s(j4Var);
            }
        }
        return null;
    }

    private boolean h(j4 j4Var) {
        if (j4Var == null) {
            return false;
        }
        return j4Var.i().b().equals(r4.Session);
    }

    private boolean i(h4 h4Var) {
        return h4Var.c().iterator().hasNext();
    }

    private boolean n(d5 d5Var) {
        return d5Var.l().equals(d5.b.Ok) && d5Var.j() != null;
    }

    static /* synthetic */ int o(File file, File file2) {
        return (file.lastModified() > file2.lastModified() ? 1 : (file.lastModified() == file2.lastModified() ? 0 : -1));
    }

    private void q(File file, File[] fileArr) {
        Boolean boolG;
        d5 d5VarS;
        h4 h4VarR = r(file);
        if (h4VarR == null || !i(h4VarR)) {
            return;
        }
        this.f22351g.getClientReportRecorder().b(io.sentry.clientreport.e.CACHE_OVERFLOW, h4VarR);
        d5 d5VarF = f(h4VarR);
        if (d5VarF == null || !n(d5VarF) || (boolG = d5VarF.g()) == null || !boolG.booleanValue()) {
            return;
        }
        for (File file2 : fileArr) {
            h4 h4VarR2 = r(file2);
            if (h4VarR2 != null && i(h4VarR2)) {
                j4 j4VarF = null;
                Iterator<j4> it = h4VarR2.c().iterator();
                while (it.hasNext()) {
                    j4 next = it.next();
                    if (h(next) && (d5VarS = s(next)) != null && n(d5VarS)) {
                        Boolean boolG2 = d5VarS.g();
                        if (boolG2 != null && boolG2.booleanValue()) {
                            this.f22351g.getLogger().c(s4.ERROR, "Session %s has 2 times the init flag.", d5VarF.j());
                            return;
                        }
                        if (d5VarF.j() != null && d5VarF.j().equals(d5VarS.j())) {
                            d5VarS.n();
                            try {
                                j4VarF = j4.f(this.f22352h, d5VarS);
                                it.remove();
                                break;
                            } catch (IOException e2) {
                                this.f22351g.getLogger().a(s4.ERROR, e2, "Failed to create new envelope item for the session %s", d5VarF.j());
                                break;
                            }
                        }
                    }
                }
                if (j4VarF != null) {
                    h4 h4VarC = c(h4VarR2, j4VarF);
                    long jLastModified = file2.lastModified();
                    if (!file2.delete()) {
                        this.f22351g.getLogger().c(s4.WARNING, "File can't be deleted: %s", file2.getAbsolutePath());
                    }
                    u(h4VarC, file2, jLastModified);
                    return;
                }
            }
        }
    }

    private h4 r(File file) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                h4 h4VarD = this.f22352h.d(bufferedInputStream);
                bufferedInputStream.close();
                return h4VarD;
            } catch (Throwable th) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (IOException e2) {
            this.f22351g.getLogger().b(s4.ERROR, "Failed to deserialize the envelope.", e2);
            return null;
        }
    }

    private d5 s(j4 j4Var) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(j4Var.h()), f22350f));
            try {
                d5 d5Var = (d5) this.f22352h.c(bufferedReader, d5.class);
                bufferedReader.close();
                return d5Var;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            this.f22351g.getLogger().b(s4.ERROR, "Failed to deserialize the session.", th2);
            return null;
        }
    }

    private void u(h4 h4Var, File file, long j2) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                this.f22352h.b(h4Var, fileOutputStream);
                file.setLastModified(j2);
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            this.f22351g.getLogger().b(s4.ERROR, "Failed to serialize the new envelope to the disk.", th2);
        }
    }

    private void v(File[] fileArr) {
        if (fileArr.length > 1) {
            Arrays.sort(fileArr, new Comparator() { // from class: io.sentry.cache.a
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return o.o((File) obj, (File) obj2);
                }
            });
        }
    }

    protected boolean g() {
        if (this.f22353i.isDirectory() && this.f22353i.canWrite() && this.f22353i.canRead()) {
            return true;
        }
        this.f22351g.getLogger().c(s4.ERROR, "The directory for caching files is inaccessible.: %s", this.f22353i.getAbsolutePath());
        return false;
    }

    protected void t(File[] fileArr) {
        int length = fileArr.length;
        if (length >= this.f22354j) {
            this.f22351g.getLogger().c(s4.WARNING, "Cache folder if full (respecting maxSize). Rotating files", new Object[0]);
            int i2 = (length - this.f22354j) + 1;
            v(fileArr);
            File[] fileArr2 = (File[]) Arrays.copyOfRange(fileArr, i2, length);
            for (int i3 = 0; i3 < i2; i3++) {
                File file = fileArr[i3];
                q(file, fileArr2);
                if (!file.delete()) {
                    this.f22351g.getLogger().c(s4.WARNING, "File can't be deleted: %s", file.getAbsolutePath());
                }
            }
        }
    }
}
