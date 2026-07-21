package com.google.firebase.crashlytics.internal.l;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.h;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: BlockingAnalyticsEventLogger.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements b, a {
    private final e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f19004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TimeUnit f19005c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CountDownLatch f19007e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f19006d = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f19008f = false;

    public c(e eVar, int i2, TimeUnit timeUnit) {
        this.a = eVar;
        this.f19004b = i2;
        this.f19005c = timeUnit;
    }

    @Override // com.google.firebase.crashlytics.internal.l.b
    public void J0(String str, Bundle bundle) {
        CountDownLatch countDownLatch = this.f19007e;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }

    @Override // com.google.firebase.crashlytics.internal.l.a
    public void a(String str, Bundle bundle) {
        synchronized (this.f19006d) {
            h.f().i("Logging event " + str + " to Firebase Analytics with params " + bundle);
            this.f19007e = new CountDownLatch(1);
            this.f19008f = false;
            this.a.a(str, bundle);
            h.f().i("Awaiting app exception callback from Analytics...");
            try {
                if (this.f19007e.await(this.f19004b, this.f19005c)) {
                    this.f19008f = true;
                    h.f().i("App exception callback received from Analytics listener.");
                } else {
                    h.f().k("Timeout exceeded while awaiting app exception callback from Analytics listener.");
                }
            } catch (InterruptedException unused) {
                h.f().d("Interrupted while awaiting app exception callback from Analytics listener.");
            }
            this.f19007e = null;
        }
    }
}
