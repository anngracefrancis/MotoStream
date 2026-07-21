package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
final class rq implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    private zzdba f13283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f13284g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f13285h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final LinkedBlockingQueue<zzbp.zza> f13286i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final HandlerThread f13287j;

    public rq(Context context, String str, String str2) {
        this.f13284g = str;
        this.f13285h = str2;
        HandlerThread handlerThread = new HandlerThread("GassClient");
        this.f13287j = handlerThread;
        handlerThread.start();
        this.f13283f = new zzdba(context, handlerThread.getLooper(), this, this);
        this.f13286i = new LinkedBlockingQueue<>();
        this.f13283f.checkAvailabilityAndConnect();
    }

    private final void a() {
        zzdba zzdbaVar = this.f13283f;
        if (zzdbaVar != null) {
            if (zzdbaVar.isConnected() || this.f13283f.isConnecting()) {
                this.f13283f.disconnect();
            }
        }
    }

    private final zzdbf b() {
        try {
            return this.f13283f.e();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }

    @VisibleForTesting
    private static zzbp.zza c() {
        return (zzbp.zza) ((zzdob) zzbp.zza.k0().N(32768L).p0());
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void E0(ConnectionResult connectionResult) {
        try {
            this.f13286i.put(c());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void H(int i2) {
        try {
            this.f13286i.put(c());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void P(Bundle bundle) {
        zzdbf zzdbfVarB = b();
        if (zzdbfVarB != null) {
            try {
                try {
                    this.f13286i.put(zzdbfVarB.B4(new zzdbb(this.f13284g, this.f13285h)).y());
                    a();
                    this.f13287j.quit();
                } catch (Throwable unused) {
                    this.f13286i.put(c());
                }
            } catch (InterruptedException unused2) {
            } finally {
                a();
                this.f13287j.quit();
            }
        }
    }

    public final zzbp.zza d(int i2) {
        zzbp.zza zzaVarPoll;
        try {
            zzaVarPoll = this.f13286i.poll(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zzaVarPoll = null;
        }
        return zzaVarPoll == null ? c() : zzaVarPoll;
    }
}
