package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: compiled from: LifecycleService.java */
/* JADX INFO: loaded from: classes.dex */
public class n extends Service implements k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final w f1765f = new w(this);

    @Override // androidx.lifecycle.k
    public g getLifecycle() {
        return this.f1765f.a();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.f1765f.b();
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.f1765f.c();
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f1765f.d();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        this.f1765f.e();
        super.onStart(intent, i2);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        return super.onStartCommand(intent, i2, i3);
    }
}
