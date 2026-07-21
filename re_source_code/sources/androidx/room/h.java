package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: MultiInstanceInvalidationClient.java */
/* JADX INFO: loaded from: classes.dex */
class h {
    final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f2148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final g f2150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final g.c f2151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    androidx.room.e f2152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Executor f2153g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final androidx.room.d f2154h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final AtomicBoolean f2155i = new AtomicBoolean(false);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final ServiceConnection f2156j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final Runnable f2157k;
    final Runnable l;
    private final Runnable m;

    /* JADX INFO: compiled from: MultiInstanceInvalidationClient.java */
    class a extends androidx.room.d.a {

        /* JADX INFO: renamed from: androidx.room.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MultiInstanceInvalidationClient.java */
        class RunnableC0045a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String[] f2159f;

            RunnableC0045a(String[] strArr) {
                this.f2159f = strArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.f2150d.e(this.f2159f);
            }
        }

        a() {
        }

        @Override // androidx.room.d
        public void L1(String[] strArr) {
            h.this.f2153g.execute(new RunnableC0045a(strArr));
        }
    }

    /* JADX INFO: compiled from: MultiInstanceInvalidationClient.java */
    class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            h.this.f2152f = androidx.room.e.a.H(iBinder);
            h hVar = h.this;
            hVar.f2153g.execute(hVar.f2157k);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            h hVar = h.this;
            hVar.f2153g.execute(hVar.l);
            h.this.f2152f = null;
        }
    }

    /* JADX INFO: compiled from: MultiInstanceInvalidationClient.java */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                h hVar = h.this;
                androidx.room.e eVar = hVar.f2152f;
                if (eVar != null) {
                    hVar.f2149c = eVar.k2(hVar.f2154h, hVar.f2148b);
                    h hVar2 = h.this;
                    hVar2.f2150d.a(hVar2.f2151e);
                }
            } catch (RemoteException e2) {
                Log.w("ROOM", "Cannot register multi-instance invalidation callback", e2);
            }
        }
    }

    /* JADX INFO: compiled from: MultiInstanceInvalidationClient.java */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.f2150d.g(hVar.f2151e);
        }
    }

    /* JADX INFO: compiled from: MultiInstanceInvalidationClient.java */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.f2150d.g(hVar.f2151e);
            try {
                h hVar2 = h.this;
                androidx.room.e eVar = hVar2.f2152f;
                if (eVar != null) {
                    eVar.S6(hVar2.f2154h, hVar2.f2149c);
                }
            } catch (RemoteException e2) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e2);
            }
            h hVar3 = h.this;
            hVar3.a.unbindService(hVar3.f2156j);
        }
    }

    /* JADX INFO: compiled from: MultiInstanceInvalidationClient.java */
    class f extends g.c {
        f(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.g.c
        boolean a() {
            return true;
        }

        @Override // androidx.room.g.c
        public void b(Set<String> set) {
            if (h.this.f2155i.get()) {
                return;
            }
            try {
                h hVar = h.this;
                androidx.room.e eVar = hVar.f2152f;
                if (eVar != null) {
                    eVar.z6(hVar.f2149c, (String[]) set.toArray(new String[0]));
                }
            } catch (RemoteException e2) {
                Log.w("ROOM", "Cannot broadcast invalidation", e2);
            }
        }
    }

    h(Context context, String str, g gVar, Executor executor) {
        b bVar = new b();
        this.f2156j = bVar;
        this.f2157k = new c();
        this.l = new d();
        this.m = new e();
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.f2148b = str;
        this.f2150d = gVar;
        this.f2153g = executor;
        this.f2151e = new f((String[]) gVar.f2130b.keySet().toArray(new String[0]));
        applicationContext.bindService(new Intent(applicationContext, (Class<?>) MultiInstanceInvalidationService.class), bVar, 1);
    }

    void a() {
        if (this.f2155i.compareAndSet(false, true)) {
            this.f2153g.execute(this.m);
        }
    }
}
