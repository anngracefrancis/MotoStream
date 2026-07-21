package com.android.installreferrer.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: compiled from: InstallReferrerClientImpl.java */
/* JADX INFO: loaded from: classes.dex */
class a extends InstallReferrerClient {
    private int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f8880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private e.e.b.b.a.a f8881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ServiceConnection f8882d;

    /* JADX INFO: compiled from: InstallReferrerClientImpl.java */
    private final class b implements ServiceConnection {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final InstallReferrerStateListener f8883f;

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            e.b.a.a.a.a("InstallReferrerClient", "Install Referrer service connected.");
            a.this.f8881c = e.e.b.b.a.a.AbstractBinderC0258a.H(iBinder);
            a.this.a = 2;
            this.f8883f.a(0);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            e.b.a.a.a.b("InstallReferrerClient", "Install Referrer service disconnected.");
            a.this.f8881c = null;
            a.this.a = 0;
            this.f8883f.b();
        }

        private b(InstallReferrerStateListener installReferrerStateListener) {
            if (installReferrerStateListener == null) {
                throw new RuntimeException("Please specify a listener to know when setup is done.");
            }
            this.f8883f = installReferrerStateListener;
        }
    }

    public a(Context context) {
        this.f8880b = context.getApplicationContext();
    }

    private boolean g() {
        try {
            return this.f8880b.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public void a() {
        this.a = 3;
        if (this.f8882d != null) {
            e.b.a.a.a.a("InstallReferrerClient", "Unbinding from service.");
            this.f8880b.unbindService(this.f8882d);
            this.f8882d = null;
        }
        this.f8881c = null;
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public ReferrerDetails b() throws RemoteException {
        if (!h()) {
            throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", this.f8880b.getPackageName());
        try {
            return new ReferrerDetails(this.f8881c.e3(bundle));
        } catch (RemoteException e2) {
            e.b.a.a.a.b("InstallReferrerClient", "RemoteException getting install referrer information");
            this.a = 0;
            throw e2;
        }
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public void d(InstallReferrerStateListener installReferrerStateListener) {
        ServiceInfo serviceInfo;
        if (h()) {
            e.b.a.a.a.a("InstallReferrerClient", "Service connection is valid. No need to re-initialize.");
            installReferrerStateListener.a(0);
            return;
        }
        int i2 = this.a;
        if (i2 == 1) {
            e.b.a.a.a.b("InstallReferrerClient", "Client is already in the process of connecting to the service.");
            installReferrerStateListener.a(3);
            return;
        }
        if (i2 == 3) {
            e.b.a.a.a.b("InstallReferrerClient", "Client was already closed and can't be reused. Please create another instance.");
            installReferrerStateListener.a(3);
            return;
        }
        e.b.a.a.a.a("InstallReferrerClient", "Starting install referrer service setup.");
        this.f8882d = new b(installReferrerStateListener);
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        List<ResolveInfo> listQueryIntentServices = this.f8880b.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty() || (serviceInfo = listQueryIntentServices.get(0).serviceInfo) == null) {
            this.a = 0;
            e.b.a.a.a.a("InstallReferrerClient", "Install Referrer service unavailable on device.");
            installReferrerStateListener.a(2);
            return;
        }
        String str = serviceInfo.packageName;
        String str2 = serviceInfo.name;
        if (!"com.android.vending".equals(str) || str2 == null || !g()) {
            e.b.a.a.a.b("InstallReferrerClient", "Play Store missing or incompatible. Version 8.3.73 or later required.");
            this.a = 0;
            installReferrerStateListener.a(2);
        } else {
            if (this.f8880b.bindService(new Intent(intent), this.f8882d, 1)) {
                e.b.a.a.a.a("InstallReferrerClient", "Service was bonded successfully.");
                return;
            }
            e.b.a.a.a.b("InstallReferrerClient", "Connection to service is blocked.");
            this.a = 0;
            installReferrerStateListener.a(1);
        }
    }

    public boolean h() {
        return (this.a != 2 || this.f8881c == null || this.f8882d == null) ? false : true;
    }
}
