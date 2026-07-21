package com.google.firebase.crashlytics.internal.n;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.crashlytics.internal.o.l;
import com.google.firebase.crashlytics.internal.p.f0;
import com.google.firebase.crashlytics.internal.p.g0;
import com.google.firebase.crashlytics.internal.t.i;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes2.dex */
class x {
    static final FilenameFilter a = new FilenameFilter() { // from class: com.google.firebase.crashlytics.h.n.c
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return str.startsWith(".ae");
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f19094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e0 f19095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final z f19096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final l f19097e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final w f19098f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final i0 f19099g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.google.firebase.crashlytics.internal.r.f f19100h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final l f19101i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.google.firebase.crashlytics.internal.o.f f19102j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.google.firebase.crashlytics.internal.d f19103k;
    private final com.google.firebase.crashlytics.internal.l.a l;
    private final v m;
    private final o0 n;
    private c0 o;
    private i p = null;
    final TaskCompletionSource<Boolean> q = new TaskCompletionSource<>();
    final TaskCompletionSource<Boolean> r = new TaskCompletionSource<>();
    final TaskCompletionSource<Void> s = new TaskCompletionSource<>();
    final AtomicBoolean t = new AtomicBoolean(false);

    /* JADX INFO: compiled from: CrashlyticsController.java */
    class a implements c0.a {
        a() {
        }

        @Override // com.google.firebase.crashlytics.h.n.c0.a
        public void a(i iVar, Thread thread, Throwable th) {
            x.this.G(iVar, thread, th);
        }
    }

    /* JADX INFO: compiled from: CrashlyticsController.java */
    class b implements Callable<Task<Void>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f19104f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Throwable f19105g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Thread f19106h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ i f19107i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ boolean f19108j;

        /* JADX INFO: compiled from: CrashlyticsController.java */
        class a implements SuccessContinuation<com.google.firebase.crashlytics.internal.t.d, Void> {
            final /* synthetic */ Executor a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f19110b;

            a(Executor executor, String str) {
                this.a = executor;
                this.f19110b = str;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Task<Void> a(com.google.firebase.crashlytics.internal.t.d dVar) throws Exception {
                if (dVar == null) {
                    h.f().k("Received null app settings, cannot send reports at crash time.");
                    return Tasks.e(null);
                }
                Task[] taskArr = new Task[2];
                taskArr[0] = x.this.M();
                taskArr[1] = x.this.n.w(this.a, b.this.f19108j ? this.f19110b : null);
                return Tasks.g(taskArr);
            }
        }

        b(long j2, Throwable th, Thread thread, i iVar, boolean z) {
            this.f19104f = j2;
            this.f19105g = th;
            this.f19106h = thread;
            this.f19107i = iVar;
            this.f19108j = z;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task<Void> call() throws Exception {
            long jE = x.E(this.f19104f);
            String strA = x.this.A();
            if (strA == null) {
                h.f().d("Tried to write a fatal exception while no session was open.");
                return Tasks.e(null);
            }
            x.this.f19096d.a();
            x.this.n.s(this.f19105g, this.f19106h, strA, jE);
            x.this.v(this.f19104f);
            x.this.s(this.f19107i);
            x.this.u(new s(x.this.f19099g).toString(), Boolean.valueOf(this.f19108j));
            if (!x.this.f19095c.d()) {
                return Tasks.e(null);
            }
            Executor executorC = x.this.f19098f.c();
            return this.f19107i.a().p(executorC, new a(executorC, strA));
        }
    }

    /* JADX INFO: compiled from: CrashlyticsController.java */
    class c implements SuccessContinuation<Void, Boolean> {
        c() {
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Task<Boolean> a(Void r1) throws Exception {
            return Tasks.e(Boolean.TRUE);
        }
    }

    /* JADX INFO: compiled from: CrashlyticsController.java */
    class d implements SuccessContinuation<Boolean, Void> {
        final /* synthetic */ Task a;

        /* JADX INFO: compiled from: CrashlyticsController.java */
        class a implements Callable<Task<Void>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Boolean f19113f;

            /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.n.x$d$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: CrashlyticsController.java */
            class C0207a implements SuccessContinuation<com.google.firebase.crashlytics.internal.t.d, Void> {
                final /* synthetic */ Executor a;

                C0207a(Executor executor) {
                    this.a = executor;
                }

                @Override // com.google.android.gms.tasks.SuccessContinuation
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public Task<Void> a(com.google.firebase.crashlytics.internal.t.d dVar) throws Exception {
                    if (dVar == null) {
                        h.f().k("Received null app settings at app startup. Cannot send cached reports");
                        return Tasks.e(null);
                    }
                    x.this.M();
                    x.this.n.v(this.a);
                    x.this.s.e(null);
                    return Tasks.e(null);
                }
            }

            a(Boolean bool) {
                this.f19113f = bool;
            }

            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Task<Void> call() throws Exception {
                if (this.f19113f.booleanValue()) {
                    h.f().b("Sending cached crash reports...");
                    x.this.f19095c.c(this.f19113f.booleanValue());
                    Executor executorC = x.this.f19098f.c();
                    return d.this.a.p(executorC, new C0207a(executorC));
                }
                h.f().i("Deleting cached crash reports...");
                x.q(x.this.K());
                x.this.n.u();
                x.this.s.e(null);
                return Tasks.e(null);
            }
        }

        d(Task task) {
            this.a = task;
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Task<Void> a(Boolean bool) throws Exception {
            return x.this.f19098f.h(new a(bool));
        }
    }

    /* JADX INFO: compiled from: CrashlyticsController.java */
    class e implements Callable<Void> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f19116f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f19117g;

        e(long j2, String str) {
            this.f19116f = j2;
            this.f19117g = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            if (x.this.I()) {
                return null;
            }
            x.this.f19102j.g(this.f19116f, this.f19117g);
            return null;
        }
    }

    /* JADX INFO: compiled from: CrashlyticsController.java */
    class f implements Callable<Void> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f19119f;

        f(String str) {
            this.f19119f = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            x.this.u(this.f19119f, Boolean.FALSE);
            return null;
        }
    }

    /* JADX INFO: compiled from: CrashlyticsController.java */
    class g implements Callable<Void> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f19121f;

        g(long j2) {
            this.f19121f = j2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            Bundle bundle = new Bundle();
            bundle.putInt("fatal", 1);
            bundle.putLong("timestamp", this.f19121f);
            x.this.l.a("_ae", bundle);
            return null;
        }
    }

    x(Context context, w wVar, i0 i0Var, e0 e0Var, com.google.firebase.crashlytics.internal.r.f fVar, z zVar, l lVar, l lVar2, com.google.firebase.crashlytics.internal.o.f fVar2, o0 o0Var, com.google.firebase.crashlytics.internal.d dVar, com.google.firebase.crashlytics.internal.l.a aVar, v vVar) {
        this.f19094b = context;
        this.f19098f = wVar;
        this.f19099g = i0Var;
        this.f19095c = e0Var;
        this.f19100h = fVar;
        this.f19096d = zVar;
        this.f19101i = lVar;
        this.f19097e = lVar2;
        this.f19102j = fVar2;
        this.f19103k = dVar;
        this.l = aVar;
        this.m = vVar;
        this.n = o0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String A() {
        SortedSet<String> sortedSetO = this.n.o();
        if (sortedSetO.isEmpty()) {
            return null;
        }
        return sortedSetO.first();
    }

    private static long B() {
        return E(System.currentTimeMillis());
    }

    static List<l0> C(com.google.firebase.crashlytics.internal.i iVar, String str, com.google.firebase.crashlytics.internal.r.f fVar, byte[] bArr) {
        File fileO = fVar.o(str, "user-data");
        File fileO2 = fVar.o(str, "keys");
        File fileO3 = fVar.o(str, "rollouts-state");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new r("logs_file", "logs", bArr));
        arrayList.add(new h0("crash_meta_file", "metadata", iVar.g()));
        arrayList.add(new h0("session_meta_file", "session", iVar.f()));
        arrayList.add(new h0("app_meta_file", "app", iVar.a()));
        arrayList.add(new h0("device_meta_file", "device", iVar.c()));
        arrayList.add(new h0("os_meta_file", "os", iVar.b()));
        arrayList.add(O(iVar));
        arrayList.add(new h0("user_meta_file", "user", fileO));
        arrayList.add(new h0("keys_file", "keys", fileO2));
        arrayList.add(new h0("rollouts_file", "rollouts", fileO3));
        return arrayList;
    }

    private InputStream D(String str) {
        ClassLoader classLoader = x.class.getClassLoader();
        if (classLoader == null) {
            h.f().k("Couldn't get Class Loader");
            return null;
        }
        InputStream resourceAsStream = classLoader.getResourceAsStream(str);
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        h.f().g("No version control information found");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long E(long j2) {
        return j2 / 1000;
    }

    private Task<Void> L(long j2) {
        if (z()) {
            h.f().k("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return Tasks.e(null);
        }
        h.f().b("Logging app exception event to Firebase Analytics");
        return Tasks.c(new ScheduledThreadPoolExecutor(1), new g(j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task<Void> M() {
        ArrayList arrayList = new ArrayList();
        for (File file : K()) {
            try {
                arrayList.add(L(Long.parseLong(file.getName().substring(3))));
            } catch (NumberFormatException unused) {
                h.f().k("Could not parse app exception timestamp from file " + file.getName());
            }
            file.delete();
        }
        return Tasks.f(arrayList);
    }

    private static boolean N(String str, File file, f0.a aVar) {
        if (file == null || !file.exists()) {
            h.f().k("No minidump data found for session " + str);
        }
        if (aVar == null) {
            h.f().g("No Tombstones data found for session " + str);
        }
        return (file == null || !file.exists()) && aVar == null;
    }

    private static l0 O(com.google.firebase.crashlytics.internal.i iVar) {
        File fileE = iVar.e();
        return (fileE == null || !fileE.exists()) ? new r("minidump_file", "minidump", new byte[]{0}) : new h0("minidump_file", "minidump", fileE);
    }

    private static byte[] Q(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    private Task<Boolean> U() {
        if (this.f19095c.d()) {
            h.f().b("Automatic data collection is enabled. Allowing upload.");
            this.q.e(Boolean.FALSE);
            return Tasks.e(Boolean.TRUE);
        }
        h.f().b("Automatic data collection is disabled.");
        h.f().i("Notifying that unsent reports are available.");
        this.q.e(Boolean.TRUE);
        Task<TContinuationResult> taskO = this.f19095c.h().o(new c());
        h.f().b("Waiting for send/deleteUnsentReports to be called.");
        return q0.i(taskO, this.r.a());
    }

    private void V(String str) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 30) {
            h.f().i("ANR feature enabled, but device is API " + i2);
            return;
        }
        List<ApplicationExitInfo> historicalProcessExitReasons = ((ActivityManager) this.f19094b.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
        if (historicalProcessExitReasons.size() != 0) {
            this.n.t(str, historicalProcessExitReasons, new com.google.firebase.crashlytics.internal.o.f(this.f19100h, str), l.h(str, this.f19100h, this.f19098f));
        } else {
            h.f().i("No ApplicationExitInfo available. Session: " + str);
        }
    }

    private static g0.a n(i0 i0Var, l lVar) {
        return g0.a.b(i0Var.f(), lVar.f19060f, lVar.f19061g, i0Var.a().c(), f0.g(lVar.f19058d).k(), lVar.f19062h);
    }

    private static g0.b o(Context context) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return g0.b.c(t.k(), Build.MODEL, Runtime.getRuntime().availableProcessors(), t.b(context), ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()), t.w(), t.l(), Build.MANUFACTURER, Build.PRODUCT);
    }

    private static g0.c p() {
        return g0.c.a(Build.VERSION.RELEASE, Build.VERSION.CODENAME, t.x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(List<File> list) {
        Iterator<File> it = list.iterator();
        while (it.hasNext()) {
            it.next().delete();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void t(boolean z, i iVar) {
        ArrayList arrayList = new ArrayList(this.n.o());
        if (arrayList.size() <= z) {
            h.f().i("No open sessions to be closed.");
            return;
        }
        String str = (String) arrayList.get(z ? 1 : 0);
        if (iVar.b().f19545b.f19552b) {
            V(str);
        } else {
            h.f().i("ANR feature disabled.");
        }
        if (this.f19103k.d(str)) {
            x(str);
        }
        String str2 = null;
        if (z != 0) {
            str2 = (String) arrayList.get(0);
        } else {
            this.m.e(null);
        }
        this.n.i(B(), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, Boolean bool) {
        long jB = B();
        h.f().b("Opening a new session with ID " + str);
        this.f19103k.c(str, String.format(Locale.US, "Crashlytics Android SDK/%s", y.i()), jB, g0.b(n(this.f19099g, this.f19101i), p(), o(this.f19094b)));
        if (bool.booleanValue() && str != null) {
            this.f19097e.k(str);
        }
        this.f19102j.e(str);
        this.m.e(str);
        this.n.p(str, jB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(long j2) {
        try {
            if (this.f19100h.e(".ae" + j2).createNewFile()) {
            } else {
                throw new IOException("Create new file failed.");
            }
        } catch (IOException e2) {
            h.f().l("Could not create app exception marker file.", e2);
        }
    }

    private void x(String str) {
        h.f().i("Finalizing native report for session " + str);
        com.google.firebase.crashlytics.internal.i iVarA = this.f19103k.a(str);
        File fileE = iVarA.e();
        f0.a aVarD = iVarA.d();
        if (N(str, fileE, aVarD)) {
            h.f().k("No native core present");
            return;
        }
        long jLastModified = fileE.lastModified();
        com.google.firebase.crashlytics.internal.o.f fVar = new com.google.firebase.crashlytics.internal.o.f(this.f19100h, str);
        File fileI = this.f19100h.i(str);
        if (!fileI.isDirectory()) {
            h.f().k("Couldn't create directory to store native session files, aborting.");
            return;
        }
        v(jLastModified);
        List<l0> listC = C(iVarA, str, this.f19100h, fVar.b());
        m0.b(fileI, listC);
        h.f().b("CrashlyticsController#finalizePreviousNativeSession");
        this.n.h(str, listC, aVarD);
        fVar.a();
    }

    private static boolean z() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    String F() throws IOException {
        InputStream inputStreamD = D("META-INF/version-control-info.textproto");
        if (inputStreamD == null) {
            return null;
        }
        h.f().b("Read version control info");
        return Base64.encodeToString(Q(inputStreamD), 0);
    }

    void G(i iVar, Thread thread, Throwable th) {
        H(iVar, thread, th, false);
    }

    synchronized void H(i iVar, Thread thread, Throwable th, boolean z) {
        h.f().b("Handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        try {
            q0.a(this.f19098f.h(new b(System.currentTimeMillis(), th, thread, iVar, z)));
        } catch (TimeoutException unused) {
            h.f().d("Cannot send reports. Timed out while fetching settings.");
        } catch (Exception e2) {
            h.f().e("Error handling uncaught exception", e2);
        }
    }

    boolean I() {
        c0 c0Var = this.o;
        return c0Var != null && c0Var.a();
    }

    List<File> K() {
        return this.f19100h.f(a);
    }

    void P(String str) {
        this.f19098f.g(new f(str));
    }

    void R() {
        try {
            String strF = F();
            if (strF != null) {
                S("com.crashlytics.version-control-info", strF);
                h.f().g("Saved version control info");
            }
        } catch (IOException e2) {
            h.f().l("Unable to save version control info", e2);
        }
    }

    void S(String str, String str2) {
        try {
            this.f19097e.j(str, str2);
        } catch (IllegalArgumentException e2) {
            Context context = this.f19094b;
            if (context != null && t.u(context)) {
                throw e2;
            }
            h.f().d("Attempting to set custom attribute with null key, ignoring.");
        }
    }

    @SuppressLint({"TaskMainThread"})
    Task<Void> T(Task<com.google.firebase.crashlytics.internal.t.d> task) {
        if (this.n.l()) {
            h.f().i("Crash reports are available to be sent.");
            return U().o(new d(task));
        }
        h.f().i("No crash reports are available to be sent.");
        this.q.e(Boolean.FALSE);
        return Tasks.e(null);
    }

    void W(long j2, String str) {
        this.f19098f.g(new e(j2, str));
    }

    boolean r() {
        if (!this.f19096d.c()) {
            String strA = A();
            return strA != null && this.f19103k.d(strA);
        }
        h.f().i("Found previous crash marker.");
        this.f19096d.d();
        return true;
    }

    void s(i iVar) {
        t(false, iVar);
    }

    void w(String str, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, i iVar) {
        this.p = iVar;
        P(str);
        c0 c0Var = new c0(new a(), iVar, uncaughtExceptionHandler, this.f19103k);
        this.o = c0Var;
        Thread.setDefaultUncaughtExceptionHandler(c0Var);
    }

    boolean y(i iVar) {
        this.f19098f.b();
        if (I()) {
            h.f().k("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        h.f().i("Finalizing previously open sessions.");
        try {
            t(true, iVar);
            h.f().i("Closed all previously open sessions.");
            return true;
        } catch (Exception e2) {
            h.f().e("Unable to finalize previously open sessions.", e2);
            return false;
        }
    }
}
