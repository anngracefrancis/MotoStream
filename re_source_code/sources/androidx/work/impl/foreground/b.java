package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.h;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.j;
import androidx.work.impl.m.c;
import androidx.work.impl.m.d;
import androidx.work.impl.n.p;
import androidx.work.n;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: SystemForegroundDispatcher.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements c, androidx.work.impl.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final String f2414f = n.f("SystemFgDispatcher");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f2415g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private j f2416h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final androidx.work.impl.utils.p.a f2417i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final Object f2418j = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    String f2419k;
    final Map<String, h> l;
    final Map<String, p> m;
    final Set<p> n;
    final d o;
    private InterfaceC0050b p;

    /* JADX INFO: compiled from: SystemForegroundDispatcher.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ WorkDatabase f2420f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f2421g;

        a(WorkDatabase workDatabase, String str) {
            this.f2420f = workDatabase;
            this.f2421g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            p pVarM = this.f2420f.j().m(this.f2421g);
            if (pVarM == null || !pVarM.b()) {
                return;
            }
            synchronized (b.this.f2418j) {
                b.this.m.put(this.f2421g, pVarM);
                b.this.n.add(pVarM);
                b bVar = b.this;
                bVar.o.d(bVar.n);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.work.impl.foreground.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SystemForegroundDispatcher.java */
    interface InterfaceC0050b {
        void b(int i2, int i3, Notification notification);

        void c(int i2, Notification notification);

        void d(int i2);

        void stop();
    }

    b(Context context) {
        this.f2415g = context;
        j jVarP = j.p(this.f2415g);
        this.f2416h = jVarP;
        androidx.work.impl.utils.p.a aVarU = jVarP.u();
        this.f2417i = aVarU;
        this.f2419k = null;
        this.l = new LinkedHashMap();
        this.n = new HashSet();
        this.m = new HashMap();
        this.o = new d(this.f2415g, aVarU, this);
        this.f2416h.r().c(this);
    }

    public static Intent a(Context context, String str, h hVar) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", hVar.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", hVar.a());
        intent.putExtra("KEY_NOTIFICATION", hVar.b());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent c(Context context, String str, h hVar) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", hVar.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", hVar.a());
        intent.putExtra("KEY_NOTIFICATION", hVar.b());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent f(Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }

    private void g(Intent intent) {
        n.c().d(f2414f, String.format("Stopping foreground work for %s", intent), new Throwable[0]);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.f2416h.j(UUID.fromString(stringExtra));
    }

    private void h(Intent intent) {
        int iA = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        n.c().a(f2414f, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)), new Throwable[0]);
        if (notification == null || this.p == null) {
            return;
        }
        this.l.put(stringExtra, new h(intExtra, notification, intExtra2));
        if (TextUtils.isEmpty(this.f2419k)) {
            this.f2419k = stringExtra;
            this.p.b(intExtra, intExtra2, notification);
            return;
        }
        this.p.c(intExtra, notification);
        if (intExtra2 == 0 || Build.VERSION.SDK_INT < 29) {
            return;
        }
        Iterator<Map.Entry<String, h>> it = this.l.entrySet().iterator();
        while (it.hasNext()) {
            iA |= it.next().getValue().a();
        }
        h hVar = this.l.get(this.f2419k);
        if (hVar != null) {
            this.p.b(hVar.c(), iA, hVar.b());
        }
    }

    private void i(Intent intent) {
        n.c().d(f2414f, String.format("Started foreground service %s", intent), new Throwable[0]);
        this.f2417i.b(new a(this.f2416h.t(), intent.getStringExtra("KEY_WORKSPEC_ID")));
    }

    @Override // androidx.work.impl.m.c
    public void b(List<String> list) {
        if (list.isEmpty()) {
            return;
        }
        for (String str : list) {
            n.c().a(f2414f, String.format("Constraints unmet for WorkSpec %s", str), new Throwable[0]);
            this.f2416h.B(str);
        }
    }

    @Override // androidx.work.impl.b
    public void d(String str, boolean z) {
        Map.Entry<String, h> entry;
        synchronized (this.f2418j) {
            p pVarRemove = this.m.remove(str);
            if (pVarRemove != null ? this.n.remove(pVarRemove) : false) {
                this.o.d(this.n);
            }
        }
        h hVarRemove = this.l.remove(str);
        if (str.equals(this.f2419k) && this.l.size() > 0) {
            Iterator<Map.Entry<String, h>> it = this.l.entrySet().iterator();
            Map.Entry<String, h> next = it.next();
            while (true) {
                entry = next;
                if (!it.hasNext()) {
                    break;
                } else {
                    next = it.next();
                }
            }
            this.f2419k = entry.getKey();
            if (this.p != null) {
                h value = entry.getValue();
                this.p.b(value.c(), value.a(), value.b());
                this.p.d(value.c());
            }
        }
        InterfaceC0050b interfaceC0050b = this.p;
        if (hVarRemove == null || interfaceC0050b == null) {
            return;
        }
        n.c().a(f2414f, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", Integer.valueOf(hVarRemove.c()), str, Integer.valueOf(hVarRemove.a())), new Throwable[0]);
        interfaceC0050b.d(hVarRemove.c());
    }

    @Override // androidx.work.impl.m.c
    public void e(List<String> list) {
    }

    void j(Intent intent) {
        n.c().d(f2414f, "Stopping foreground service", new Throwable[0]);
        InterfaceC0050b interfaceC0050b = this.p;
        if (interfaceC0050b != null) {
            interfaceC0050b.stop();
        }
    }

    void k() {
        this.p = null;
        synchronized (this.f2418j) {
            this.o.e();
        }
        this.f2416h.r().i(this);
    }

    void l(Intent intent) {
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            i(intent);
            h(intent);
        } else if ("ACTION_NOTIFY".equals(action)) {
            h(intent);
        } else if ("ACTION_CANCEL_WORK".equals(action)) {
            g(intent);
        } else if ("ACTION_STOP_FOREGROUND".equals(action)) {
            j(intent);
        }
    }

    void m(InterfaceC0050b interfaceC0050b) {
        if (this.p != null) {
            n.c().b(f2414f, "A callback already exists.", new Throwable[0]);
        } else {
            this.p = interfaceC0050b;
        }
    }
}
