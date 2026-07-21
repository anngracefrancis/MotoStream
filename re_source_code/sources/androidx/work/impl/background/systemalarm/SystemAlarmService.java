package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.lifecycle.n;
import androidx.work.impl.utils.j;

/* JADX INFO: loaded from: classes.dex */
public class SystemAlarmService extends n implements e.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f2350g = androidx.work.n.f("SystemAlarmService");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private e f2351h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f2352i;

    private void e() {
        e eVar = new e(this);
        this.f2351h = eVar;
        eVar.m(this);
    }

    @Override // androidx.work.impl.background.systemalarm.e.c
    public void a() {
        this.f2352i = true;
        androidx.work.n.c().a(f2350g, "All commands completed in dispatcher", new Throwable[0]);
        j.a();
        stopSelf();
    }

    @Override // androidx.lifecycle.n, android.app.Service
    public void onCreate() {
        super.onCreate();
        e();
        this.f2352i = false;
    }

    @Override // androidx.lifecycle.n, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f2352i = true;
        this.f2351h.j();
    }

    @Override // androidx.lifecycle.n, android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (this.f2352i) {
            androidx.work.n.c().d(f2350g, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.f2351h.j();
            e();
            this.f2352i = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f2351h.a(intent, i3);
        return 3;
    }
}
