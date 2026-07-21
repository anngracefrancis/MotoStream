package com.google.firebase.installations;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.components.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: FirebaseInstallations.java */
/* JADX INFO: loaded from: classes2.dex */
public class h implements i {
    private static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadFactory f19681b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.firebase.j f19682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.firebase.installations.r.c f19683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.google.firebase.installations.q.c f19684e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final o f19685f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final x<com.google.firebase.installations.q.b> f19686g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final m f19687h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f19688i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ExecutorService f19689j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Executor f19690k;
    private String l;
    private Set<com.google.firebase.installations.p.a> m;
    private final List<n> n;

    /* JADX INFO: compiled from: FirebaseInstallations.java */
    class a implements ThreadFactory {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final AtomicInteger f19691f = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        @SuppressLint({"ThreadPoolCreation"})
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.f19691f.getAndIncrement())));
        }
    }

    /* JADX INFO: compiled from: FirebaseInstallations.java */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f19692b;

        static {
            int[] iArr = new int[com.google.firebase.installations.r.f.b.values().length];
            f19692b = iArr;
            try {
                iArr[com.google.firebase.installations.r.f.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19692b[com.google.firebase.installations.r.f.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19692b[com.google.firebase.installations.r.f.b.AUTH_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[com.google.firebase.installations.r.d.b.values().length];
            a = iArr2;
            try {
                iArr2[com.google.firebase.installations.r.d.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.google.firebase.installations.r.d.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @SuppressLint({"ThreadPoolCreation"})
    h(final com.google.firebase.j jVar, com.google.firebase.s.b<com.google.firebase.r.i> bVar, ExecutorService executorService, Executor executor) {
        this(executorService, executor, jVar, new com.google.firebase.installations.r.c(jVar.i(), bVar), new com.google.firebase.installations.q.c(jVar), o.c(), new x(new com.google.firebase.s.b() { // from class: com.google.firebase.installations.a
            @Override // com.google.firebase.s.b
            public final Object get() {
                return h.w(jVar);
            }
        }), new m());
    }

    private void A(Exception exc) {
        synchronized (this.f19688i) {
            Iterator<n> it = this.n.iterator();
            while (it.hasNext()) {
                if (it.next().a(exc)) {
                    it.remove();
                }
            }
        }
    }

    private void B(com.google.firebase.installations.q.d dVar) {
        synchronized (this.f19688i) {
            Iterator<n> it = this.n.iterator();
            while (it.hasNext()) {
                if (it.next().b(dVar)) {
                    it.remove();
                }
            }
        }
    }

    private synchronized void C(String str) {
        this.l = str;
    }

    private synchronized void D(com.google.firebase.installations.q.d dVar, com.google.firebase.installations.q.d dVar2) {
        if (this.m.size() != 0 && !TextUtils.equals(dVar.d(), dVar2.d())) {
            Iterator<com.google.firebase.installations.p.a> it = this.m.iterator();
            while (it.hasNext()) {
                it.next().a(dVar2.d());
            }
        }
    }

    private Task<l> b() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        d(new j(this.f19685f, taskCompletionSource));
        return taskCompletionSource.a();
    }

    private Task<String> c() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        d(new k(taskCompletionSource));
        return taskCompletionSource.a();
    }

    private void d(n nVar) {
        synchronized (this.f19688i) {
            this.n.add(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void r(boolean z) {
        com.google.firebase.installations.q.d dVarZ;
        com.google.firebase.installations.q.d dVarM = m();
        try {
            if (dVarM.i() || dVarM.l()) {
                dVarZ = z(dVarM);
            } else {
                if (!z && !this.f19685f.f(dVarM)) {
                    return;
                }
                dVarZ = g(dVarM);
            }
            p(dVarZ);
            D(dVarM, dVarZ);
            if (dVarZ.k()) {
                C(dVarZ.d());
            }
            if (dVarZ.i()) {
                A(new FirebaseInstallationsException(FirebaseInstallationsException.a.BAD_CONFIG));
            } else if (dVarZ.j()) {
                A(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
            } else {
                B(dVarZ);
            }
        } catch (FirebaseInstallationsException e2) {
            A(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final void v(final boolean z) {
        com.google.firebase.installations.q.d dVarN = n();
        if (z) {
            dVarN = dVarN.p();
        }
        B(dVarN);
        this.f19690k.execute(new Runnable() { // from class: com.google.firebase.installations.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f19672f.r(z);
            }
        });
    }

    private com.google.firebase.installations.q.d g(com.google.firebase.installations.q.d dVar) throws FirebaseInstallationsException {
        com.google.firebase.installations.r.f fVarE = this.f19683d.e(h(), dVar.d(), o(), dVar.f());
        int i2 = b.f19692b[fVarE.b().ordinal()];
        if (i2 == 1) {
            return dVar.o(fVarE.c(), fVarE.d(), this.f19685f.b());
        }
        if (i2 == 2) {
            return dVar.q("BAD CONFIG");
        }
        if (i2 != 3) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.a.UNAVAILABLE);
        }
        C(null);
        return dVar.r();
    }

    private synchronized String j() {
        return this.l;
    }

    private com.google.firebase.installations.q.b k() {
        return this.f19686g.get();
    }

    public static h l(com.google.firebase.j jVar) {
        Preconditions.b(jVar != null, "Null is not a valid value of FirebaseApp.");
        return (h) jVar.h(i.class);
    }

    private com.google.firebase.installations.q.d m() {
        com.google.firebase.installations.q.d dVarD;
        synchronized (a) {
            g gVarA = g.a(this.f19682c.i(), "generatefid.lock");
            try {
                dVarD = this.f19684e.d();
                if (gVarA != null) {
                    gVarA.b();
                }
            } catch (Throwable th) {
                if (gVarA != null) {
                    gVarA.b();
                }
                throw th;
            }
        }
        return dVarD;
    }

    private com.google.firebase.installations.q.d n() {
        com.google.firebase.installations.q.d dVarD;
        synchronized (a) {
            g gVarA = g.a(this.f19682c.i(), "generatefid.lock");
            try {
                dVarD = this.f19684e.d();
                if (dVarD.j()) {
                    dVarD = this.f19684e.b(dVarD.t(y(dVarD)));
                }
                if (gVarA != null) {
                    gVarA.b();
                }
            } catch (Throwable th) {
                if (gVarA != null) {
                    gVarA.b();
                }
                throw th;
            }
        }
        return dVarD;
    }

    private void p(com.google.firebase.installations.q.d dVar) {
        synchronized (a) {
            g gVarA = g.a(this.f19682c.i(), "generatefid.lock");
            try {
                this.f19684e.b(dVar);
                if (gVarA != null) {
                    gVarA.b();
                }
            } catch (Throwable th) {
                if (gVarA != null) {
                    gVarA.b();
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t() {
        u(false);
    }

    static /* synthetic */ com.google.firebase.installations.q.b w(com.google.firebase.j jVar) {
        return new com.google.firebase.installations.q.b(jVar);
    }

    private void x() {
        Preconditions.h(i(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.h(o(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.h(h(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.b(o.h(i()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.b(o.g(h()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    private String y(com.google.firebase.installations.q.d dVar) {
        if ((!this.f19682c.k().equals("CHIME_ANDROID_SDK") && !this.f19682c.s()) || !dVar.m()) {
            return this.f19687h.a();
        }
        String strF = k().f();
        return TextUtils.isEmpty(strF) ? this.f19687h.a() : strF;
    }

    private com.google.firebase.installations.q.d z(com.google.firebase.installations.q.d dVar) throws FirebaseInstallationsException {
        com.google.firebase.installations.r.d dVarD = this.f19683d.d(h(), dVar.d(), o(), i(), (dVar.d() == null || dVar.d().length() != 11) ? null : k().i());
        int i2 = b.a[dVarD.e().ordinal()];
        if (i2 == 1) {
            return dVar.s(dVarD.c(), dVarD.d(), this.f19685f.b(), dVarD.b().c(), dVarD.b().d());
        }
        if (i2 == 2) {
            return dVar.q("BAD CONFIG");
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.a.UNAVAILABLE);
    }

    @Override // com.google.firebase.installations.i
    public Task<l> a(final boolean z) {
        x();
        Task<l> taskB = b();
        this.f19689j.execute(new Runnable() { // from class: com.google.firebase.installations.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f19674f.v(z);
            }
        });
        return taskB;
    }

    @Override // com.google.firebase.installations.i
    public Task<String> getId() {
        x();
        String strJ = j();
        if (strJ != null) {
            return Tasks.e(strJ);
        }
        Task<String> taskC = c();
        this.f19689j.execute(new Runnable() { // from class: com.google.firebase.installations.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f19671f.t();
            }
        });
        return taskC;
    }

    String h() {
        return this.f19682c.l().b();
    }

    String i() {
        return this.f19682c.l().c();
    }

    String o() {
        return this.f19682c.l().e();
    }

    @SuppressLint({"ThreadPoolCreation"})
    h(ExecutorService executorService, Executor executor, com.google.firebase.j jVar, com.google.firebase.installations.r.c cVar, com.google.firebase.installations.q.c cVar2, o oVar, x<com.google.firebase.installations.q.b> xVar, m mVar) {
        this.f19688i = new Object();
        this.m = new HashSet();
        this.n = new ArrayList();
        this.f19682c = jVar;
        this.f19683d = cVar;
        this.f19684e = cVar2;
        this.f19685f = oVar;
        this.f19686g = xVar;
        this.f19687h = mVar;
        this.f19689j = executorService;
        this.f19690k = executor;
    }
}
