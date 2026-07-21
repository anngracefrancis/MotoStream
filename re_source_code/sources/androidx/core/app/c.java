package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: ActivityRecreator.java */
/* JADX INFO: loaded from: classes.dex */
final class c {
    protected static final Class<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final Field f851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final Field f852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final Method f853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final Method f854e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final Method f855f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Handler f856g = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: ActivityRecreator.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f857f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Object f858g;

        a(d dVar, Object obj) {
            this.f857f = dVar;
            this.f858g = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f857f.f863f = this.f858g;
        }
    }

    /* JADX INFO: compiled from: ActivityRecreator.java */
    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Application f859f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d f860g;

        b(Application application, d dVar) {
            this.f859f = application;
            this.f860g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f859f.unregisterActivityLifecycleCallbacks(this.f860g);
        }
    }

    /* JADX INFO: renamed from: androidx.core.app.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActivityRecreator.java */
    class RunnableC0019c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f861f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Object f862g;

        RunnableC0019c(Object obj, Object obj2) {
            this.f861f = obj;
            this.f862g = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = c.f853d;
                if (method != null) {
                    method.invoke(this.f861f, this.f862g, Boolean.FALSE, "AppCompat recreation");
                } else {
                    c.f854e.invoke(this.f861f, this.f862g, Boolean.FALSE);
                }
            } catch (RuntimeException e2) {
                if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                    throw e2;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    /* JADX INFO: compiled from: ActivityRecreator.java */
    private static final class d implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f863f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Activity f864g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f865h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f866i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f867j = false;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f868k = false;

        d(Activity activity) {
            this.f864g = activity;
            this.f865h = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f864g == activity) {
                this.f864g = null;
                this.f867j = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f867j || this.f868k || this.f866i || !c.h(this.f863f, this.f865h, activity)) {
                return;
            }
            this.f868k = true;
            this.f863f = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f864g == activity) {
                this.f866i = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> clsA = a();
        a = clsA;
        f851b = b();
        f852c = f();
        f853d = d(clsA);
        f854e = c(clsA);
        f855f = e(clsA);
    }

    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 == 26 || i2 == 27;
    }

    protected static boolean h(Object obj, int i2, Activity activity) {
        try {
            Object obj2 = f852c.get(activity);
            if (obj2 == obj && activity.hashCode() == i2) {
                f856g.postAtFrontOfQueue(new RunnableC0019c(f851b.get(activity), obj2));
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && f855f == null) {
            return false;
        }
        if (f854e == null && f853d == null) {
            return false;
        }
        try {
            Object obj2 = f852c.get(activity);
            if (obj2 == null || (obj = f851b.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            d dVar = new d(activity);
            application.registerActivityLifecycleCallbacks(dVar);
            f856g.post(new a(dVar, obj2));
            try {
                if (g()) {
                    Method method = f855f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                return true;
            } finally {
                f856g.post(new b(application, dVar));
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
