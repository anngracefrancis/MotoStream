package io.sentry.android.core;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import io.sentry.Integration;
import io.sentry.i2;
import io.sentry.s4;
import io.sentry.v1;
import io.sentry.w1;
import io.sentry.x4;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class PhoneStateBreadcrumbsIntegration implements Integration, Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f22060f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SentryAndroidOptions f22061g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    a f22062h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TelephonyManager f22063i;

    static final class a extends PhoneStateListener {
        private final v1 a;

        a(v1 v1Var) {
            this.a = v1Var;
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i2, String str) {
            if (i2 == 1) {
                io.sentry.v0 v0Var = new io.sentry.v0();
                v0Var.p("system");
                v0Var.l("device.event");
                v0Var.m("action", "CALL_STATE_RINGING");
                v0Var.o("Device ringing");
                v0Var.n(s4.INFO);
                this.a.i(v0Var);
            }
        }
    }

    public PhoneStateBreadcrumbsIntegration(Context context) {
        this.f22060f = (Context) io.sentry.util.q.c(context, "Context is required");
    }

    @Override // io.sentry.j2
    public /* synthetic */ void a() {
        i2.a(this);
    }

    @Override // io.sentry.Integration
    public void c(v1 v1Var, x4 x4Var) {
        io.sentry.util.q.c(v1Var, "Hub is required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) io.sentry.util.q.c(x4Var instanceof SentryAndroidOptions ? (SentryAndroidOptions) x4Var : null, "SentryAndroidOptions is required");
        this.f22061g = sentryAndroidOptions;
        w1 logger = sentryAndroidOptions.getLogger();
        s4 s4Var = s4.DEBUG;
        logger.c(s4Var, "enableSystemEventBreadcrumbs enabled: %s", Boolean.valueOf(this.f22061g.isEnableSystemEventBreadcrumbs()));
        if (this.f22061g.isEnableSystemEventBreadcrumbs() && io.sentry.android.core.internal.util.q.a(this.f22060f, "android.permission.READ_PHONE_STATE")) {
            TelephonyManager telephonyManager = (TelephonyManager) this.f22060f.getSystemService("phone");
            this.f22063i = telephonyManager;
            if (telephonyManager == null) {
                this.f22061g.getLogger().c(s4.INFO, "TelephonyManager is not available", new Object[0]);
                return;
            }
            try {
                a aVar = new a(v1Var);
                this.f22062h = aVar;
                this.f22063i.listen(aVar, 32);
                x4Var.getLogger().c(s4Var, "PhoneStateBreadcrumbsIntegration installed.", new Object[0]);
                a();
            } catch (Throwable th) {
                this.f22061g.getLogger().a(s4.INFO, th, "TelephonyManager is not available or ready to use.", new Object[0]);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a aVar;
        TelephonyManager telephonyManager = this.f22063i;
        if (telephonyManager == null || (aVar = this.f22062h) == null) {
            return;
        }
        telephonyManager.listen(aVar, 0);
        this.f22062h = null;
        SentryAndroidOptions sentryAndroidOptions = this.f22061g;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().c(s4.DEBUG, "PhoneStateBreadcrumbsIntegration removed.", new Object[0]);
        }
    }

    @Override // io.sentry.j2
    public /* synthetic */ String d() {
        return i2.b(this);
    }
}
