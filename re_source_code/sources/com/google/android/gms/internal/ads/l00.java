package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"HandlerLeak"})
final class l00 extends Handler implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzkc f12899f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzka f12900g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f12901h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile Thread f12902i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzjz f12903j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l00(zzjz zzjzVar, Looper looper, zzkc zzkcVar, zzka zzkaVar, int i2) {
        super(looper);
        this.f12903j = zzjzVar;
        this.f12899f = zzkcVar;
        this.f12900g = zzkaVar;
        this.f12901h = 0;
    }

    public final void a() {
        this.f12899f.b();
        if (this.f12902i != null) {
            this.f12902i.interrupt();
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what == 2) {
            throw ((Error) message.obj);
        }
        zzjz.e(this.f12903j, false);
        zzjz.c(this.f12903j, null);
        if (this.f12899f.a()) {
            this.f12900g.h(this.f12899f);
            return;
        }
        int i2 = message.what;
        if (i2 == 0) {
            this.f12900g.a(this.f12899f);
        } else {
            if (i2 != 1) {
                return;
            }
            this.f12900g.b(this.f12899f, (IOException) message.obj);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f12902i = Thread.currentThread();
            int i2 = this.f12901h;
            if (i2 > 0) {
                Thread.sleep(i2);
            }
            if (!this.f12899f.a()) {
                this.f12899f.c();
            }
            sendEmptyMessage(0);
        } catch (IOException e2) {
            obtainMessage(1, e2).sendToTarget();
        } catch (Error e3) {
            Log.e("LoadTask", "Unexpected error loading stream", e3);
            obtainMessage(2, e3).sendToTarget();
            throw e3;
        } catch (InterruptedException unused) {
            zzkh.d(this.f12899f.a());
            sendEmptyMessage(0);
        } catch (Exception e4) {
            Log.e("LoadTask", "Unexpected exception loading stream", e4);
            obtainMessage(1, new zzkd(e4)).sendToTarget();
        }
    }
}
