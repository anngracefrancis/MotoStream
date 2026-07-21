package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: NotificationManagerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f910b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static c f913e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f914f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final NotificationManager f915g;
    private static final Object a = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Set<String> f911c = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f912d = new Object();

    /* JADX INFO: compiled from: NotificationManagerCompat.java */
    private static class a implements d {
        final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f917c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Notification f918d;

        a(String str, int i2, String str2, Notification notification) {
            this.a = str;
            this.f916b = i2;
            this.f917c = str2;
            this.f918d = notification;
        }

        @Override // androidx.core.app.l.d
        public void a(android.support.v4.app.a aVar) throws RemoteException {
            aVar.F6(this.a, this.f916b, this.f917c, this.f918d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.a + ", id:" + this.f916b + ", tag:" + this.f917c + "]";
        }
    }

    /* JADX INFO: compiled from: NotificationManagerCompat.java */
    private static class b {
        final ComponentName a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final IBinder f919b;

        b(ComponentName componentName, IBinder iBinder) {
            this.a = componentName;
            this.f919b = iBinder;
        }
    }

    /* JADX INFO: compiled from: NotificationManagerCompat.java */
    private static class c implements Handler.Callback, ServiceConnection {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Context f920f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final HandlerThread f921g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Handler f922h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Map<ComponentName, a> f923i = new HashMap();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Set<String> f924j = new HashSet();

        /* JADX INFO: compiled from: NotificationManagerCompat.java */
        private static class a {
            final ComponentName a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            android.support.v4.app.a f926c;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            boolean f925b = false;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            ArrayDeque<d> f927d = new ArrayDeque<>();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f928e = 0;

            a(ComponentName componentName) {
                this.a = componentName;
            }
        }

        c(Context context) {
            this.f920f = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f921g = handlerThread;
            handlerThread.start();
            this.f922h = new Handler(handlerThread.getLooper(), this);
        }

        private boolean a(a aVar) {
            if (aVar.f925b) {
                return true;
            }
            boolean zBindService = this.f920f.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.a), this, 33);
            aVar.f925b = zBindService;
            if (zBindService) {
                aVar.f928e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.a);
                this.f920f.unbindService(this);
            }
            return aVar.f925b;
        }

        private void b(a aVar) {
            if (aVar.f925b) {
                this.f920f.unbindService(this);
                aVar.f925b = false;
            }
            aVar.f926c = null;
        }

        private void c(d dVar) {
            j();
            for (a aVar : this.f923i.values()) {
                aVar.f927d.add(dVar);
                g(aVar);
            }
        }

        private void d(ComponentName componentName) {
            a aVar = this.f923i.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        private void e(ComponentName componentName, IBinder iBinder) {
            a aVar = this.f923i.get(componentName);
            if (aVar != null) {
                aVar.f926c = android.support.v4.app.a.AbstractBinderC0000a.H(iBinder);
                aVar.f928e = 0;
                g(aVar);
            }
        }

        private void f(ComponentName componentName) {
            a aVar = this.f923i.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        private void g(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.a + ", " + aVar.f927d.size() + " queued tasks");
            }
            if (aVar.f927d.isEmpty()) {
                return;
            }
            if (!a(aVar) || aVar.f926c == null) {
                i(aVar);
                return;
            }
            while (true) {
                d dVarPeek = aVar.f927d.peek();
                if (dVarPeek == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + dVarPeek);
                    }
                    dVarPeek.a(aVar.f926c);
                    aVar.f927d.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + aVar.a);
                    }
                } catch (RemoteException e2) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + aVar.a, e2);
                }
            }
            if (aVar.f927d.isEmpty()) {
                return;
            }
            i(aVar);
        }

        private void i(a aVar) {
            if (this.f922h.hasMessages(3, aVar.a)) {
                return;
            }
            int i2 = aVar.f928e + 1;
            aVar.f928e = i2;
            if (i2 <= 6) {
                int i3 = (1 << (i2 - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i3 + " ms");
                }
                this.f922h.sendMessageDelayed(this.f922h.obtainMessage(3, aVar.a), i3);
                return;
            }
            Log.w("NotifManCompat", "Giving up on delivering " + aVar.f927d.size() + " tasks to " + aVar.a + " after " + aVar.f928e + " retries");
            aVar.f927d.clear();
        }

        private void j() {
            Set<String> setC = l.c(this.f920f);
            if (setC.equals(this.f924j)) {
                return;
            }
            this.f924j = setC;
            List<ResolveInfo> listQueryIntentServices = this.f920f.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                if (setC.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f923i.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.f923i.put(componentName2, new a(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, a>> it = this.f923i.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ComponentName, a> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + next.getKey());
                    }
                    b(next.getValue());
                    it.remove();
                }
            }
        }

        public void h(d dVar) {
            this.f922h.obtainMessage(0, dVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                c((d) message.obj);
                return true;
            }
            if (i2 == 1) {
                b bVar = (b) message.obj;
                e(bVar.a, bVar.f919b);
                return true;
            }
            if (i2 == 2) {
                f((ComponentName) message.obj);
                return true;
            }
            if (i2 != 3) {
                return false;
            }
            d((ComponentName) message.obj);
            return true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f922h.obtainMessage(1, new b(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f922h.obtainMessage(2, componentName).sendToTarget();
        }
    }

    /* JADX INFO: compiled from: NotificationManagerCompat.java */
    private interface d {
        void a(android.support.v4.app.a aVar) throws RemoteException;
    }

    private l(Context context) {
        this.f914f = context;
        this.f915g = (NotificationManager) context.getSystemService("notification");
    }

    public static l b(Context context) {
        return new l(context);
    }

    public static Set<String> c(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (a) {
            if (string != null) {
                if (!string.equals(f910b)) {
                    String[] strArrSplit = string.split(":", -1);
                    HashSet hashSet = new HashSet(strArrSplit.length);
                    for (String str : strArrSplit) {
                        ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                        if (componentNameUnflattenFromString != null) {
                            hashSet.add(componentNameUnflattenFromString.getPackageName());
                        }
                    }
                    f911c = hashSet;
                    f910b = string;
                }
                set = f911c;
            } else {
                set = f911c;
            }
            throw th;
        }
        return set;
    }

    private void f(d dVar) {
        synchronized (f912d) {
            if (f913e == null) {
                f913e = new c(this.f914f.getApplicationContext());
            }
            f913e.h(dVar);
        }
    }

    private static boolean g(Notification notification) {
        Bundle bundleA = i.a(notification);
        return bundleA != null && bundleA.getBoolean("android.support.useSideChannel");
    }

    public boolean a() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            return this.f915g.areNotificationsEnabled();
        }
        if (i2 < 19) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f914f.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f914f.getApplicationInfo();
        String packageName = this.f914f.getApplicationContext().getPackageName();
        int i3 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i3), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public void d(int i2, Notification notification) {
        e(null, i2, notification);
    }

    public void e(String str, int i2, Notification notification) {
        if (!g(notification)) {
            this.f915g.notify(str, i2, notification);
        } else {
            f(new a(this.f914f.getPackageName(), i2, str, notification));
            this.f915g.cancel(str, i2);
        }
    }
}
