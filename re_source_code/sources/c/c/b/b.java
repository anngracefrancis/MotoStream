package c.c.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: compiled from: CustomTabsClient.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private final b.b.a.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ComponentName f2865b;

    /* JADX INFO: compiled from: CustomTabsClient.java */
    static class a extends d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f2866f;

        a(Context context) {
            this.f2866f = context;
        }

        @Override // c.c.b.d
        public final void a(ComponentName componentName, b bVar) {
            bVar.d(0L);
            this.f2866f.unbindService(this);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: renamed from: c.c.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CustomTabsClient.java */
    class BinderC0065b extends b.b.a.a.AbstractBinderC0058a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Handler f2867f = new Handler(Looper.getMainLooper());

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c.c.b.a f2868g;

        /* JADX INFO: renamed from: c.c.b.b$b$a */
        /* JADX INFO: compiled from: CustomTabsClient.java */
        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f2870f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ Bundle f2871g;

            a(int i2, Bundle bundle) {
                this.f2870f = i2;
                this.f2871g = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.c.b.a aVar = BinderC0065b.this.f2868g;
                throw null;
            }
        }

        /* JADX INFO: renamed from: c.c.b.b$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CustomTabsClient.java */
        class RunnableC0066b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f2873f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ Bundle f2874g;

            RunnableC0066b(String str, Bundle bundle) {
                this.f2873f = str;
                this.f2874g = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.c.b.a aVar = BinderC0065b.this.f2868g;
                throw null;
            }
        }

        /* JADX INFO: renamed from: c.c.b.b$b$c */
        /* JADX INFO: compiled from: CustomTabsClient.java */
        class c implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Bundle f2876f;

            c(Bundle bundle) {
                this.f2876f = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.c.b.a aVar = BinderC0065b.this.f2868g;
                throw null;
            }
        }

        /* JADX INFO: renamed from: c.c.b.b$b$d */
        /* JADX INFO: compiled from: CustomTabsClient.java */
        class d implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f2878f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ Bundle f2879g;

            d(String str, Bundle bundle) {
                this.f2878f = str;
                this.f2879g = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.c.b.a aVar = BinderC0065b.this.f2868g;
                throw null;
            }
        }

        /* JADX INFO: renamed from: c.c.b.b$b$e */
        /* JADX INFO: compiled from: CustomTabsClient.java */
        class e implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f2881f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ Uri f2882g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ boolean f2883h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ Bundle f2884i;

            e(int i2, Uri uri, boolean z, Bundle bundle) {
                this.f2881f = i2;
                this.f2882g = uri;
                this.f2883h = z;
                this.f2884i = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.c.b.a aVar = BinderC0065b.this.f2868g;
                throw null;
            }
        }

        BinderC0065b(c.c.b.a aVar) {
        }

        @Override // b.b.a.a
        public void B6(Bundle bundle) throws RemoteException {
            if (this.f2868g == null) {
                return;
            }
            this.f2867f.post(new c(bundle));
        }

        @Override // b.b.a.a
        public void J6(int i2, Uri uri, boolean z, Bundle bundle) throws RemoteException {
            if (this.f2868g == null) {
                return;
            }
            this.f2867f.post(new e(i2, uri, z, bundle));
        }

        @Override // b.b.a.a
        public void N4(String str, Bundle bundle) throws RemoteException {
            if (this.f2868g == null) {
                return;
            }
            this.f2867f.post(new RunnableC0066b(str, bundle));
        }

        @Override // b.b.a.a
        public void q6(String str, Bundle bundle) throws RemoteException {
            if (this.f2868g == null) {
                return;
            }
            this.f2867f.post(new d(str, bundle));
        }

        @Override // b.b.a.a
        public void r5(int i2, Bundle bundle) {
            if (this.f2868g == null) {
                return;
            }
            this.f2867f.post(new a(i2, bundle));
        }
    }

    b(b.b.a.b bVar, ComponentName componentName) {
        this.a = bVar;
        this.f2865b = componentName;
    }

    public static boolean a(Context context, String str, d dVar) {
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, dVar, 33);
    }

    public static boolean b(Context context, String str) {
        if (str == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            return a(applicationContext, str, new a(applicationContext));
        } catch (SecurityException unused) {
            return false;
        }
    }

    public e c(c.c.b.a aVar) {
        BinderC0065b binderC0065b = new BinderC0065b(aVar);
        try {
            if (this.a.x4(binderC0065b)) {
                return new e(this.a, binderC0065b, this.f2865b);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    public boolean d(long j2) {
        try {
            return this.a.p3(j2);
        } catch (RemoteException unused) {
            return false;
        }
    }
}
