package io.sentry.android.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import io.sentry.Integration;
import io.sentry.i2;
import io.sentry.n1;
import io.sentry.s4;
import io.sentry.v1;
import io.sentry.w1;
import io.sentry.x4;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class SystemEventsBreadcrumbsIntegration implements Integration, Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f22074f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    a f22075g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SentryAndroidOptions f22076h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<String> f22077i;

    static final class a extends BroadcastReceiver {
        private final v1 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final w1 f22078b;

        a(v1 v1Var, w1 w1Var) {
            this.a = v1Var;
            this.f22078b = w1Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            io.sentry.v0 v0Var = new io.sentry.v0();
            v0Var.p("system");
            v0Var.l("device.event");
            String action = intent.getAction();
            String strC = io.sentry.util.u.c(action);
            if (strC != null) {
                v0Var.m("action", strC);
            }
            Bundle extras = intent.getExtras();
            HashMap map = new HashMap();
            if (extras != null && !extras.isEmpty()) {
                for (String str : extras.keySet()) {
                    try {
                        Object obj = extras.get(str);
                        if (obj != null) {
                            map.put(str, obj.toString());
                        }
                    } catch (Throwable th) {
                        this.f22078b.a(s4.ERROR, th, "%s key of the %s action threw an error.", str, action);
                    }
                }
                v0Var.m("extras", map);
            }
            v0Var.n(s4.INFO);
            n1 n1Var = new n1();
            n1Var.j("android:intent", intent);
            this.a.n(v0Var, n1Var);
        }
    }

    public SystemEventsBreadcrumbsIntegration(Context context) {
        this(context, b());
    }

    private static List<String> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.appwidget.action.APPWIDGET_DELETED");
        arrayList.add("android.appwidget.action.APPWIDGET_DISABLED");
        arrayList.add("android.appwidget.action.APPWIDGET_ENABLED");
        arrayList.add("android.appwidget.action.APPWIDGET_HOST_RESTORED");
        arrayList.add("android.appwidget.action.APPWIDGET_RESTORED");
        arrayList.add("android.appwidget.action.APPWIDGET_UPDATE");
        arrayList.add("android.appwidget.action.APPWIDGET_UPDATE_OPTIONS");
        arrayList.add("android.intent.action.ACTION_POWER_CONNECTED");
        arrayList.add("android.intent.action.ACTION_POWER_DISCONNECTED");
        arrayList.add("android.intent.action.ACTION_SHUTDOWN");
        arrayList.add("android.intent.action.AIRPLANE_MODE");
        arrayList.add("android.intent.action.BATTERY_LOW");
        arrayList.add("android.intent.action.BATTERY_OKAY");
        arrayList.add("android.intent.action.BOOT_COMPLETED");
        arrayList.add("android.intent.action.CAMERA_BUTTON");
        arrayList.add("android.intent.action.CONFIGURATION_CHANGED");
        arrayList.add("android.intent.action.CONTENT_CHANGED");
        arrayList.add("android.intent.action.DATE_CHANGED");
        arrayList.add("android.intent.action.DEVICE_STORAGE_LOW");
        arrayList.add("android.intent.action.DEVICE_STORAGE_OK");
        arrayList.add("android.intent.action.DOCK_EVENT");
        arrayList.add("android.intent.action.DREAMING_STARTED");
        arrayList.add("android.intent.action.DREAMING_STOPPED");
        arrayList.add("android.intent.action.INPUT_METHOD_CHANGED");
        arrayList.add("android.intent.action.LOCALE_CHANGED");
        arrayList.add("android.intent.action.REBOOT");
        arrayList.add("android.intent.action.SCREEN_OFF");
        arrayList.add("android.intent.action.SCREEN_ON");
        arrayList.add("android.intent.action.TIMEZONE_CHANGED");
        arrayList.add("android.intent.action.TIME_SET");
        arrayList.add("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        arrayList.add("android.os.action.POWER_SAVE_MODE_CHANGED");
        arrayList.add("android.intent.action.APP_ERROR");
        arrayList.add("android.intent.action.BUG_REPORT");
        arrayList.add("android.intent.action.MEDIA_BAD_REMOVAL");
        arrayList.add("android.intent.action.MEDIA_MOUNTED");
        arrayList.add("android.intent.action.MEDIA_UNMOUNTABLE");
        arrayList.add("android.intent.action.MEDIA_UNMOUNTED");
        return arrayList;
    }

    @Override // io.sentry.j2
    public /* synthetic */ void a() {
        i2.a(this);
    }

    @Override // io.sentry.Integration
    public void c(v1 v1Var, x4 x4Var) {
        io.sentry.util.q.c(v1Var, "Hub is required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) io.sentry.util.q.c(x4Var instanceof SentryAndroidOptions ? (SentryAndroidOptions) x4Var : null, "SentryAndroidOptions is required");
        this.f22076h = sentryAndroidOptions;
        sentryAndroidOptions.getLogger().c(s4.DEBUG, "SystemEventsBreadcrumbsIntegration enabled: %s", Boolean.valueOf(this.f22076h.isEnableSystemEventBreadcrumbs()));
        if (this.f22076h.isEnableSystemEventBreadcrumbs()) {
            this.f22075g = new a(v1Var, this.f22076h.getLogger());
            IntentFilter intentFilter = new IntentFilter();
            Iterator<String> it = this.f22077i.iterator();
            while (it.hasNext()) {
                intentFilter.addAction(it.next());
            }
            try {
                t0.n(this.f22074f, x4Var, this.f22075g, intentFilter);
                this.f22076h.getLogger().c(s4.DEBUG, "SystemEventsBreadcrumbsIntegration installed.", new Object[0]);
                a();
            } catch (Throwable th) {
                this.f22076h.setEnableSystemEventBreadcrumbs(false);
                this.f22076h.getLogger().b(s4.ERROR, "Failed to initialize SystemEventsBreadcrumbsIntegration.", th);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a aVar = this.f22075g;
        if (aVar != null) {
            this.f22074f.unregisterReceiver(aVar);
            this.f22075g = null;
            SentryAndroidOptions sentryAndroidOptions = this.f22076h;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().c(s4.DEBUG, "SystemEventsBreadcrumbsIntegration remove.", new Object[0]);
            }
        }
    }

    @Override // io.sentry.j2
    public /* synthetic */ String d() {
        return i2.b(this);
    }

    public SystemEventsBreadcrumbsIntegration(Context context, List<String> list) {
        this.f22074f = (Context) io.sentry.util.q.c(context, "Context is required");
        this.f22077i = (List) io.sentry.util.q.c(list, "Actions list is required");
    }
}
