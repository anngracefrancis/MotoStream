package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.impl.j;
import androidx.work.impl.utils.g;
import androidx.work.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SystemAlarmDispatcher.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements androidx.work.impl.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final String f2367f = n.f("SystemAlarmDispatcher");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Context f2368g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final androidx.work.impl.utils.p.a f2369h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final androidx.work.impl.utils.n f2370i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final androidx.work.impl.d f2371j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final j f2372k;
    final androidx.work.impl.background.systemalarm.b l;
    private final Handler m;
    final List<Intent> n;
    Intent o;
    private c p;

    /* JADX INFO: compiled from: SystemAlarmDispatcher.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar;
            d dVar;
            synchronized (e.this.n) {
                e eVar2 = e.this;
                eVar2.o = eVar2.n.get(0);
            }
            Intent intent = e.this.o;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = e.this.o.getIntExtra("KEY_START_ID", 0);
                n nVarC = n.c();
                String str = e.f2367f;
                nVarC.a(str, String.format("Processing command %s, %s", e.this.o, Integer.valueOf(intExtra)), new Throwable[0]);
                PowerManager.WakeLock wakeLockB = androidx.work.impl.utils.j.b(e.this.f2368g, String.format("%s (%s)", action, Integer.valueOf(intExtra)));
                try {
                    n.c().a(str, String.format("Acquiring operation wake lock (%s) %s", action, wakeLockB), new Throwable[0]);
                    wakeLockB.acquire();
                    e eVar3 = e.this;
                    eVar3.l.p(eVar3.o, intExtra, eVar3);
                    n.c().a(str, String.format("Releasing operation wake lock (%s) %s", action, wakeLockB), new Throwable[0]);
                    wakeLockB.release();
                    eVar = e.this;
                    dVar = new d(eVar);
                } catch (Throwable th) {
                    try {
                        n nVarC2 = n.c();
                        String str2 = e.f2367f;
                        nVarC2.b(str2, "Unexpected error in onHandleIntent", th);
                        n.c().a(str2, String.format("Releasing operation wake lock (%s) %s", action, wakeLockB), new Throwable[0]);
                        wakeLockB.release();
                        eVar = e.this;
                        dVar = new d(eVar);
                    } catch (Throwable th2) {
                        n.c().a(e.f2367f, String.format("Releasing operation wake lock (%s) %s", action, wakeLockB), new Throwable[0]);
                        wakeLockB.release();
                        e eVar4 = e.this;
                        eVar4.k(new d(eVar4));
                        throw th2;
                    }
                }
                eVar.k(dVar);
            }
        }
    }

    /* JADX INFO: compiled from: SystemAlarmDispatcher.java */
    static class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final e f2374f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Intent f2375g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f2376h;

        b(e eVar, Intent intent, int i2) {
            this.f2374f = eVar;
            this.f2375g = intent;
            this.f2376h = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2374f.a(this.f2375g, this.f2376h);
        }
    }

    /* JADX INFO: compiled from: SystemAlarmDispatcher.java */
    interface c {
        void a();
    }

    /* JADX INFO: compiled from: SystemAlarmDispatcher.java */
    static class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final e f2377f;

        d(e eVar) {
            this.f2377f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2377f.c();
        }
    }

    e(Context context) {
        this(context, null, null);
    }

    private void b() {
        if (this.m.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    private boolean i(String str) {
        b();
        synchronized (this.n) {
            Iterator<Intent> it = this.n.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().getAction())) {
                    return true;
                }
            }
            return false;
        }
    }

    private void l() {
        b();
        PowerManager.WakeLock wakeLockB = androidx.work.impl.utils.j.b(this.f2368g, "ProcessCommand");
        try {
            wakeLockB.acquire();
            this.f2372k.u().b(new a());
        } finally {
            wakeLockB.release();
        }
    }

    public boolean a(Intent intent, int i2) {
        n nVarC = n.c();
        String str = f2367f;
        nVarC.a(str, String.format("Adding command %s (%s)", intent, Integer.valueOf(i2)), new Throwable[0]);
        b();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            n.c().h(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && i("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        }
        intent.putExtra("KEY_START_ID", i2);
        synchronized (this.n) {
            boolean z = this.n.isEmpty() ? false : true;
            this.n.add(intent);
            if (!z) {
                l();
            }
        }
        return true;
    }

    void c() {
        n nVarC = n.c();
        String str = f2367f;
        nVarC.a(str, "Checking if commands are complete.", new Throwable[0]);
        b();
        synchronized (this.n) {
            if (this.o != null) {
                n.c().a(str, String.format("Removing command %s", this.o), new Throwable[0]);
                if (!this.n.remove(0).equals(this.o)) {
                    throw new IllegalStateException("Dequeue-d command is not the first.");
                }
                this.o = null;
            }
            g gVarC = this.f2369h.c();
            if (!this.l.o() && this.n.isEmpty() && !gVarC.a()) {
                n.c().a(str, "No more commands & intents.", new Throwable[0]);
                c cVar = this.p;
                if (cVar != null) {
                    cVar.a();
                }
            } else if (!this.n.isEmpty()) {
                l();
            }
        }
    }

    @Override // androidx.work.impl.b
    public void d(String str, boolean z) {
        k(new b(this, androidx.work.impl.background.systemalarm.b.c(this.f2368g, str, z), 0));
    }

    androidx.work.impl.d e() {
        return this.f2371j;
    }

    androidx.work.impl.utils.p.a f() {
        return this.f2369h;
    }

    j g() {
        return this.f2372k;
    }

    androidx.work.impl.utils.n h() {
        return this.f2370i;
    }

    void j() {
        n.c().a(f2367f, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.f2371j.i(this);
        this.f2370i.a();
        this.p = null;
    }

    void k(Runnable runnable) {
        this.m.post(runnable);
    }

    void m(c cVar) {
        if (this.p != null) {
            n.c().b(f2367f, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            this.p = cVar;
        }
    }

    e(Context context, androidx.work.impl.d dVar, j jVar) {
        Context applicationContext = context.getApplicationContext();
        this.f2368g = applicationContext;
        this.l = new androidx.work.impl.background.systemalarm.b(applicationContext);
        this.f2370i = new androidx.work.impl.utils.n();
        jVar = jVar == null ? j.p(context) : jVar;
        this.f2372k = jVar;
        dVar = dVar == null ? jVar.r() : dVar;
        this.f2371j = dVar;
        this.f2369h = jVar.u();
        dVar.c(this);
        this.n = new ArrayList();
        this.o = null;
        this.m = new Handler(Looper.getMainLooper());
    }
}
