package com.flurry.sdk;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.view.ViewTreeObserver;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class n1 {
    private static n1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f10929b = System.nanoTime();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f10930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f10931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f10932e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private o1.b f10934g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10935h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10936i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f10937j = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, String> f10933f = new HashMap();

    final class a implements o1.b {

        /* JADX INFO: renamed from: com.flurry.sdk.n1$a$a, reason: collision with other inner class name */
        final class ViewTreeObserverOnGlobalLayoutListenerC0163a implements ViewTreeObserver.OnGlobalLayoutListener {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Activity f10938f;

            ViewTreeObserverOnGlobalLayoutListenerC0163a(Activity activity) {
                this.f10938f = activity;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f10938f.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                n1 n1Var = n1.this;
                this.f10938f.getApplication();
                n1.d(n1Var);
                n1.this.c(this.f10938f, "onGlobalLayout", "fl.layout.time", "fl.layout.runtime.memory", "fl.layout.system.memory");
                n1.g(n1.this);
                if (n1.this.f10935h) {
                    n1.this.f();
                }
            }
        }

        a() {
        }

        @Override // com.flurry.sdk.o1.b
        public final void a() {
        }

        @Override // com.flurry.sdk.o1.b
        public final void b(Activity activity) {
            activity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0163a(activity));
        }

        @Override // com.flurry.sdk.o1.b
        public final void c(Activity activity) {
        }

        @Override // com.flurry.sdk.o1.b
        public final void d(Activity activity) {
            n1.this.c(activity, "onActivityResumed", "fl.resume.time", "fl.resume.runtime.memory", "fl.resume.system.memory");
        }
    }

    private n1() {
    }

    public static synchronized n1 a() {
        if (a == null) {
            a = new n1();
        }
        return a;
    }

    static /* synthetic */ void d(n1 n1Var) {
        if (n1Var.f10934g != null) {
            o1 o1VarA = o1.a();
            o1.b bVar = n1Var.f10934g;
            synchronized (o1VarA.f10963c) {
                o1VarA.f10963c.remove(bVar);
            }
            n1Var.f10934g = null;
        }
    }

    static /* synthetic */ boolean g(n1 n1Var) {
        n1Var.f10936i = true;
        return true;
    }

    public final void b(Context context, Cursor cursor) {
        if (this.f10934g != null) {
            return;
        }
        if (cursor != null) {
            cursor.moveToFirst();
            this.f10930c = cursor.getLong(0);
            this.f10931d = cursor.getLong(1);
            this.f10932e = cursor.getLong(2);
            cursor.close();
        } else {
            Runtime runtime = Runtime.getRuntime();
            ActivityManager.MemoryInfo memoryInfoA = p1.a(context);
            this.f10930c = f10929b;
            this.f10931d = runtime.totalMemory() - runtime.freeMemory();
            this.f10932e = memoryInfoA.totalMem - memoryInfoA.availMem;
        }
        StringBuilder sb = new StringBuilder("Registered with Content Provider: ");
        sb.append(cursor != null);
        sb.append(", start time: ");
        sb.append(this.f10930c);
        sb.append(", runtime memory: ");
        sb.append(this.f10931d);
        sb.append(", system memory: ");
        sb.append(this.f10932e);
        d1.c(3, "ColdStartMonitor", sb.toString());
        this.f10934g = new a();
        o1.a().c(this.f10934g);
    }

    public final void c(Context context, String str, String str2, String str3, String str4) {
        double dNanoTime = System.nanoTime() - this.f10930c;
        Double.isNaN(dNanoTime);
        long j2 = (long) (dNanoTime / 1000000.0d);
        Runtime runtime = Runtime.getRuntime();
        long jFreeMemory = runtime.totalMemory() - runtime.freeMemory();
        long j3 = jFreeMemory - this.f10931d;
        if (j3 < 0) {
            j3 = 0;
        }
        ActivityManager.MemoryInfo memoryInfoA = p1.a(context);
        long j4 = memoryInfoA.totalMem - memoryInfoA.availMem;
        long j5 = j4 - this.f10932e;
        long j6 = j5 >= 0 ? j5 : 0L;
        d1.c(3, "ColdStartMonitor", str + " time: " + j2 + ", runtime memory usage: " + jFreeMemory + ", system memory usage: " + j4);
        this.f10933f.put(str2, Long.toString(j2));
        this.f10933f.put(str3, Long.toString(j3));
        this.f10933f.put(str4, Long.toString(j6));
    }

    public final synchronized void f() {
        if (this.f10933f.isEmpty()) {
            return;
        }
        d1.c(4, "ColdStartMonitor", "Log Cold Start time event: " + this.f10933f);
        com.flurry.sdk.a.v().s("Flurry.ColdStartTime", v3.a.PERFORMANCE, this.f10933f);
        this.f10933f.clear();
    }
}
