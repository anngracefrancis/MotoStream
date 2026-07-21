package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.n;

/* JADX INFO: loaded from: classes.dex */
public class SystemForegroundService extends n implements androidx.work.impl.foreground.b.InterfaceC0050b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f2400g = androidx.work.n.f("SystemFgService");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static SystemForegroundService f2401h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Handler f2402i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f2403j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    androidx.work.impl.foreground.b f2404k;
    NotificationManager l;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f2405f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Notification f2406g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f2407h;

        a(int i2, Notification notification, int i3) {
            this.f2405f = i2;
            this.f2406g = notification;
            this.f2407h = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT >= 29) {
                SystemForegroundService.this.startForeground(this.f2405f, this.f2406g, this.f2407h);
            } else {
                SystemForegroundService.this.startForeground(this.f2405f, this.f2406g);
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f2409f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Notification f2410g;

        b(int i2, Notification notification) {
            this.f2409f = i2;
            this.f2410g = notification;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemForegroundService.this.l.notify(this.f2409f, this.f2410g);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f2412f;

        c(int i2) {
            this.f2412f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemForegroundService.this.l.cancel(this.f2412f);
        }
    }

    private void e() {
        this.f2402i = new Handler(Looper.getMainLooper());
        this.l = (NotificationManager) getApplicationContext().getSystemService("notification");
        androidx.work.impl.foreground.b bVar = new androidx.work.impl.foreground.b(getApplicationContext());
        this.f2404k = bVar;
        bVar.m(this);
    }

    @Override // androidx.work.impl.foreground.b.InterfaceC0050b
    public void b(int i2, int i3, Notification notification) {
        this.f2402i.post(new a(i2, notification, i3));
    }

    @Override // androidx.work.impl.foreground.b.InterfaceC0050b
    public void c(int i2, Notification notification) {
        this.f2402i.post(new b(i2, notification));
    }

    @Override // androidx.work.impl.foreground.b.InterfaceC0050b
    public void d(int i2) {
        this.f2402i.post(new c(i2));
    }

    @Override // androidx.lifecycle.n, android.app.Service
    public void onCreate() {
        super.onCreate();
        f2401h = this;
        e();
    }

    @Override // androidx.lifecycle.n, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f2404k.k();
    }

    @Override // androidx.lifecycle.n, android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (this.f2403j) {
            androidx.work.n.c().d(f2400g, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.f2404k.k();
            e();
            this.f2403j = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f2404k.l(intent);
        return 3;
    }

    @Override // androidx.work.impl.foreground.b.InterfaceC0050b
    public void stop() {
        this.f2403j = true;
        androidx.work.n.c().a(f2400g, "All commands completed.", new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        f2401h = null;
        stopSelf();
    }
}
