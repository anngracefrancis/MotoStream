package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class m implements ServiceConnection, zzs {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f12035f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f12036g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f12037h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private IBinder f12038i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzn f12039j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ComponentName f12040k;
    final /* synthetic */ o l;

    public m(o oVar, zzn zznVar) {
        this.l = oVar;
        this.f12039j = zznVar;
    }

    public final int a() {
        return this.f12036g;
    }

    public final ComponentName b() {
        return this.f12040k;
    }

    public final IBinder c() {
        return this.f12038i;
    }

    public final void d(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f12035f.put(serviceConnection, serviceConnection2);
    }

    public final void e(String str, Executor executor) {
        this.f12036g = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (PlatformVersion.o()) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            o oVar = this.l;
            boolean zD = oVar.f12046j.d(oVar.f12043g, str, this.f12039j.c(oVar.f12043g), this, this.f12039j.a(), executor);
            this.f12037h = zD;
            if (zD) {
                this.l.f12044h.sendMessageDelayed(this.l.f12044h.obtainMessage(1, this.f12039j), this.l.l);
            } else {
                this.f12036g = 2;
                try {
                    o oVar2 = this.l;
                    oVar2.f12046j.c(oVar2.f12043g, this);
                } catch (IllegalArgumentException unused) {
                }
            }
        } finally {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.f12035f.remove(serviceConnection);
    }

    public final void g(String str) {
        this.l.f12044h.removeMessages(1, this.f12039j);
        o oVar = this.l;
        oVar.f12046j.c(oVar.f12043g, this);
        this.f12037h = false;
        this.f12036g = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.f12035f.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.f12035f.isEmpty();
    }

    public final boolean j() {
        return this.f12037h;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.l.f12042f) {
            this.l.f12044h.removeMessages(1, this.f12039j);
            this.f12038i = iBinder;
            this.f12040k = componentName;
            Iterator it = this.f12035f.values().iterator();
            while (it.hasNext()) {
                ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
            }
            this.f12036g = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.l.f12042f) {
            this.l.f12044h.removeMessages(1, this.f12039j);
            this.f12038i = null;
            this.f12040k = componentName;
            Iterator it = this.f12035f.values().iterator();
            while (it.hasNext()) {
                ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
            }
            this.f12036g = 2;
        }
    }
}
