package com.flurry.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class o1 {
    private static o1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Application.ActivityLifecycleCallbacks f10962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final List<b> f10963c = new ArrayList();

    final class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            d1.c(3, "PerformanceMonitor", "onActivityPaused for activity: " + activity.toString());
            Iterator<b> it = o1.this.f10963c.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            d1.c(3, "PerformanceMonitor", "onActivityResumed for activity: " + activity.toString());
            Iterator<b> it = o1.this.f10963c.iterator();
            while (it.hasNext()) {
                it.next().d(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            d1.c(3, "PerformanceMonitor", "onActivityStarted for activity: " + activity.toString());
            Iterator<b> it = o1.this.f10963c.iterator();
            while (it.hasNext()) {
                it.next().b(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            d1.c(3, "PerformanceMonitor", "onActivityStopped for activity: " + activity.toString());
            Iterator<b> it = o1.this.f10963c.iterator();
            while (it.hasNext()) {
                it.next().c(activity);
            }
        }
    }

    public interface b {
        void a();

        void b(Activity activity);

        void c(Activity activity);

        void d(Activity activity);
    }

    private o1() {
    }

    public static synchronized o1 a() {
        if (a == null) {
            a = new o1();
        }
        return a;
    }

    public final void b(Context context, Cursor cursor) {
        if (this.f10962b == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Application) {
                if (context instanceof Application) {
                    n1.a().b(applicationContext, cursor);
                }
                q1.a().c();
                a aVar = new a();
                this.f10962b = aVar;
                ((Application) applicationContext).registerActivityLifecycleCallbacks(aVar);
            }
        }
    }

    public final void c(b bVar) {
        synchronized (this.f10963c) {
            this.f10963c.add(bVar);
        }
    }
}
