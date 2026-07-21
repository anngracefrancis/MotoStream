package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class c implements ServiceConnection {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f11585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Messenger f11586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    l f11587h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Queue<m<?>> f11588i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final SparseArray<m<?>> f11589j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ zze f11590k;

    private c(zze zzeVar) {
        this.f11590k = zzeVar;
        this.f11585f = 0;
        this.f11586g = new Messenger(new com.google.android.gms.internal.cloudmessaging.zze(Looper.getMainLooper(), new Handler.Callback(this) { // from class: com.google.android.gms.cloudmessaging.f

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final c f11592f;

            {
                this.f11592f = this;
            }

            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f11592f.d(message);
            }
        }));
        this.f11588i = new ArrayDeque();
        this.f11589j = new SparseArray<>();
    }

    final void a() {
        this.f11590k.f11611c.execute(new Runnable(this) { // from class: com.google.android.gms.cloudmessaging.g

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final c f11593f;

            {
                this.f11593f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                final m<?> mVarPoll;
                final c cVar = this.f11593f;
                while (true) {
                    synchronized (cVar) {
                        if (cVar.f11585f != 2) {
                            return;
                        }
                        if (cVar.f11588i.isEmpty()) {
                            cVar.f();
                            return;
                        } else {
                            mVarPoll = cVar.f11588i.poll();
                            cVar.f11589j.put(mVarPoll.a, mVarPoll);
                            cVar.f11590k.f11611c.schedule(new Runnable(cVar, mVarPoll) { // from class: com.google.android.gms.cloudmessaging.i

                                /* JADX INFO: renamed from: f, reason: collision with root package name */
                                private final c f11596f;

                                /* JADX INFO: renamed from: g, reason: collision with root package name */
                                private final m f11597g;

                                {
                                    this.f11596f = cVar;
                                    this.f11597g = mVarPoll;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f11596f.b(this.f11597g.a);
                                }
                            }, 30L, TimeUnit.SECONDS);
                        }
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        String strValueOf = String.valueOf(mVarPoll);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 8);
                        sb.append("Sending ");
                        sb.append(strValueOf);
                        Log.d("MessengerIpcClient", sb.toString());
                    }
                    Context context = cVar.f11590k.f11610b;
                    Messenger messenger = cVar.f11586g;
                    Message messageObtain = Message.obtain();
                    messageObtain.what = mVarPoll.f11601c;
                    messageObtain.arg1 = mVarPoll.a;
                    messageObtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", mVarPoll.d());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", mVarPoll.f11602d);
                    messageObtain.setData(bundle);
                    try {
                        cVar.f11587h.a(messageObtain);
                    } catch (RemoteException e2) {
                        cVar.c(2, e2.getMessage());
                    }
                }
            }
        });
    }

    final synchronized void b(int i2) {
        m<?> mVar = this.f11589j.get(i2);
        if (mVar != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i2);
            Log.w("MessengerIpcClient", sb.toString());
            this.f11589j.remove(i2);
            mVar.b(new zzp(3, "Timed out waiting for response"));
            f();
        }
    }

    final synchronized void c(int i2, String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", strValueOf.length() != 0 ? "Disconnected: ".concat(strValueOf) : new String("Disconnected: "));
        }
        int i3 = this.f11585f;
        if (i3 == 0) {
            throw new IllegalStateException();
        }
        if (i3 != 1 && i3 != 2) {
            if (i3 == 3) {
                this.f11585f = 4;
                return;
            } else {
                if (i3 == 4) {
                    return;
                }
                int i4 = this.f11585f;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i4);
                throw new IllegalStateException(sb.toString());
            }
        }
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Unbinding service");
        }
        this.f11585f = 4;
        ConnectionTracker.b().c(this.f11590k.f11610b, this);
        zzp zzpVar = new zzp(i2, str);
        Iterator<m<?>> it = this.f11588i.iterator();
        while (it.hasNext()) {
            it.next().b(zzpVar);
        }
        this.f11588i.clear();
        for (int i5 = 0; i5 < this.f11589j.size(); i5++) {
            this.f11589j.valueAt(i5).b(zzpVar);
        }
        this.f11589j.clear();
    }

    final boolean d(Message message) {
        int i2 = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Received response to request: ");
            sb.append(i2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        synchronized (this) {
            m<?> mVar = this.f11589j.get(i2);
            if (mVar == null) {
                StringBuilder sb2 = new StringBuilder(50);
                sb2.append("Received response for unknown request: ");
                sb2.append(i2);
                Log.w("MessengerIpcClient", sb2.toString());
                return true;
            }
            this.f11589j.remove(i2);
            f();
            Bundle data = message.getData();
            if (data.getBoolean("unsupported", false)) {
                mVar.b(new zzp(4, "Not supported by GmsCore"));
            } else {
                mVar.a(data);
            }
            return true;
        }
    }

    final synchronized boolean e(m<?> mVar) {
        int i2 = this.f11585f;
        if (i2 == 0) {
            this.f11588i.add(mVar);
            Preconditions.n(this.f11585f == 0);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.f11585f = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            if (ConnectionTracker.b().a(this.f11590k.f11610b, intent, this, 1)) {
                this.f11590k.f11611c.schedule(new Runnable(this) { // from class: com.google.android.gms.cloudmessaging.e

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    private final c f11591f;

                    {
                        this.f11591f = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11591f.g();
                    }
                }, 30L, TimeUnit.SECONDS);
            } else {
                c(0, "Unable to bind to service");
            }
            return true;
        }
        if (i2 == 1) {
            this.f11588i.add(mVar);
            return true;
        }
        if (i2 == 2) {
            this.f11588i.add(mVar);
            a();
            return true;
        }
        if (i2 != 3 && i2 != 4) {
            int i3 = this.f11585f;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Unknown state: ");
            sb.append(i3);
            throw new IllegalStateException(sb.toString());
        }
        return false;
    }

    final synchronized void f() {
        if (this.f11585f == 2 && this.f11588i.isEmpty() && this.f11589j.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.f11585f = 3;
            ConnectionTracker.b().c(this.f11590k.f11610b, this);
        }
    }

    final synchronized void g() {
        if (this.f11585f == 1) {
            c(1, "Timed out while binding");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.f11590k.f11611c.execute(new Runnable(this, iBinder) { // from class: com.google.android.gms.cloudmessaging.h

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final c f11594f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final IBinder f11595g;

            {
                this.f11594f = this;
                this.f11595g = iBinder;
            }

            @Override // java.lang.Runnable
            public final void run() {
                c cVar = this.f11594f;
                IBinder iBinder2 = this.f11595g;
                synchronized (cVar) {
                    try {
                        if (iBinder2 == null) {
                            cVar.c(0, "Null service connection");
                            return;
                        }
                        try {
                            cVar.f11587h = new l(iBinder2);
                            cVar.f11585f = 2;
                            cVar.a();
                        } catch (RemoteException e2) {
                            cVar.c(0, e2.getMessage());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        this.f11590k.f11611c.execute(new Runnable(this) { // from class: com.google.android.gms.cloudmessaging.j

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final c f11598f;

            {
                this.f11598f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f11598f.c(2, "Service disconnected");
            }
        });
    }
}
