package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class BlockingServiceConnection implements ServiceConnection {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f11617f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BlockingQueue f11618g = new LinkedBlockingQueue();

    @KeepForSdk
    public IBinder a(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        Preconditions.j("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f11617f) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f11617f = true;
        IBinder iBinder = (IBinder) this.f11618g.poll(j2, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f11618g.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
