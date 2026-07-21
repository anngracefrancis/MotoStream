package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.q;
import com.google.firebase.components.t;
import com.google.firebase.components.x;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.concurrent.a0;
import com.google.firebase.provider.FirebaseInitProvider;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FirebaseApp.java */
/* JADX INFO: loaded from: classes.dex */
public class j {
    private static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Map<String, j> f19747b = new c.e.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f19748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final m f19750e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final t f19751f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final x<com.google.firebase.t.a> f19754i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.google.firebase.s.b<com.google.firebase.r.f> f19755j;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f19752g = new AtomicBoolean(false);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f19753h = new AtomicBoolean();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List<a> f19756k = new CopyOnWriteArrayList();
    private final List<k> l = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: FirebaseApp.java */
    /* JADX INFO: loaded from: classes2.dex */
    @KeepForSdk
    public interface a {
        @KeepForSdk
        void a(boolean z);
    }

    /* JADX INFO: compiled from: FirebaseApp.java */
    /* JADX INFO: loaded from: classes2.dex */
    @TargetApi(14)
    private static class b implements BackgroundDetector.BackgroundStateChangeListener {
        private static AtomicReference<b> a = new AtomicReference<>();

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void c(Context context) {
            if (PlatformVersion.a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (a.get() == null) {
                    b bVar = new b();
                    if (a.compareAndSet(null, bVar)) {
                        BackgroundDetector.c(application);
                        BackgroundDetector.b().a(bVar);
                    }
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
        public void a(boolean z) {
            synchronized (j.a) {
                for (j jVar : new ArrayList(j.f19747b.values())) {
                    if (jVar.f19752g.get()) {
                        jVar.y(z);
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: FirebaseApp.java */
    /* JADX INFO: loaded from: classes2.dex */
    @TargetApi(24)
    private static class c extends BroadcastReceiver {
        private static AtomicReference<c> a = new AtomicReference<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f19757b;

        public c(Context context) {
            this.f19757b = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (a.get() == null) {
                c cVar = new c(context);
                if (a.compareAndSet(null, cVar)) {
                    context.registerReceiver(cVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.f19757b.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (j.a) {
                Iterator<j> it = j.f19747b.values().iterator();
                while (it.hasNext()) {
                    it.next().n();
                }
            }
            c();
        }
    }

    protected j(final Context context, String str, m mVar) {
        this.f19748c = (Context) Preconditions.k(context);
        this.f19749d = Preconditions.g(str);
        this.f19750e = (m) Preconditions.k(mVar);
        n nVarB = FirebaseInitProvider.b();
        com.google.firebase.w.c.b("Firebase");
        com.google.firebase.w.c.b("ComponentDiscovery");
        List<com.google.firebase.s.b<ComponentRegistrar>> listA = q.b(context, ComponentDiscoveryService.class).a();
        com.google.firebase.w.c.a();
        com.google.firebase.w.c.b("Runtime");
        t.b bVarF = t.j(a0.INSTANCE).c(listA).b(new FirebaseCommonRegistrar()).b(new ExecutorsRegistrar()).a(com.google.firebase.components.n.q(context, Context.class, new Class[0])).a(com.google.firebase.components.n.q(this, j.class, new Class[0])).a(com.google.firebase.components.n.q(mVar, m.class, new Class[0])).f(new com.google.firebase.w.b());
        if (androidx.core.os.e.a(context) && FirebaseInitProvider.c()) {
            bVarF.a(com.google.firebase.components.n.q(nVarB, n.class, new Class[0]));
        }
        t tVarD = bVarF.d();
        this.f19751f = tVarD;
        com.google.firebase.w.c.a();
        this.f19754i = new x<>(new com.google.firebase.s.b() { // from class: com.google.firebase.b
            @Override // com.google.firebase.s.b
            public final Object get() {
                return this.a.u(context);
            }
        });
        this.f19755j = tVarD.c(com.google.firebase.r.f.class);
        e(new a() { // from class: com.google.firebase.a
            @Override // com.google.firebase.j.a
            public final void a(boolean z) {
                this.a.w(z);
            }
        });
        com.google.firebase.w.c.a();
    }

    private void g() {
        Preconditions.o(!this.f19753h.get(), "FirebaseApp was deleted");
    }

    public static j j() {
        j jVar;
        synchronized (a) {
            jVar = f19747b.get("[DEFAULT]");
            if (jVar == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
            jVar.f19755j.get().j();
        }
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (!androidx.core.os.e.a(this.f19748c)) {
            Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + k());
            c.b(this.f19748c);
            return;
        }
        Log.i("FirebaseApp", "Device unlocked: initializing all Firebase APIs for app " + k());
        this.f19751f.m(s());
        this.f19755j.get().j();
    }

    public static j o(Context context) {
        synchronized (a) {
            if (f19747b.containsKey("[DEFAULT]")) {
                return j();
            }
            m mVarA = m.a(context);
            if (mVarA == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            return p(context, mVarA);
        }
    }

    public static j p(Context context, m mVar) {
        return q(context, mVar, "[DEFAULT]");
    }

    public static j q(Context context, m mVar, String str) {
        j jVar;
        b.c(context);
        String strX = x(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (a) {
            Map<String, j> map = f19747b;
            Preconditions.o(!map.containsKey(strX), "FirebaseApp name " + strX + " already exists!");
            Preconditions.l(context, "Application context cannot be null.");
            jVar = new j(context, strX, mVar);
            map.put(strX, jVar);
        }
        jVar.n();
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ com.google.firebase.t.a u(Context context) {
        return new com.google.firebase.t.a(context, m(), (com.google.firebase.q.c) this.f19751f.a(com.google.firebase.q.c.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(boolean z) {
        if (z) {
            return;
        }
        this.f19755j.get().j();
    }

    private static String x(String str) {
        return str.trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator<a> it = this.f19756k.iterator();
        while (it.hasNext()) {
            it.next().a(z);
        }
    }

    @KeepForSdk
    public void e(a aVar) {
        g();
        if (this.f19752g.get() && BackgroundDetector.b().d()) {
            aVar.a(true);
        }
        this.f19756k.add(aVar);
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f19749d.equals(((j) obj).k());
        }
        return false;
    }

    @KeepForSdk
    public void f(k kVar) {
        g();
        Preconditions.k(kVar);
        this.l.add(kVar);
    }

    @KeepForSdk
    public <T> T h(Class<T> cls) {
        g();
        return (T) this.f19751f.a(cls);
    }

    public int hashCode() {
        return this.f19749d.hashCode();
    }

    public Context i() {
        g();
        return this.f19748c;
    }

    public String k() {
        g();
        return this.f19749d;
    }

    public m l() {
        g();
        return this.f19750e;
    }

    @KeepForSdk
    public String m() {
        return Base64Utils.c(k().getBytes(Charset.defaultCharset())) + "+" + Base64Utils.c(l().c().getBytes(Charset.defaultCharset()));
    }

    @KeepForSdk
    public boolean r() {
        g();
        return this.f19754i.get().b();
    }

    @KeepForSdk
    public boolean s() {
        return "[DEFAULT]".equals(k());
    }

    public String toString() {
        return Objects.c(this).a("name", this.f19749d).a("options", this.f19750e).toString();
    }
}
