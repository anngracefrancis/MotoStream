package androidx.work.impl.m.f;

import android.content.Context;

/* JADX INFO: compiled from: Trackers.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private static g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f2507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f2508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e f2509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private f f2510e;

    private g(Context context, androidx.work.impl.utils.p.a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.f2507b = new a(applicationContext, aVar);
        this.f2508c = new b(applicationContext, aVar);
        this.f2509d = new e(applicationContext, aVar);
        this.f2510e = new f(applicationContext, aVar);
    }

    public static synchronized g c(Context context, androidx.work.impl.utils.p.a aVar) {
        if (a == null) {
            a = new g(context, aVar);
        }
        return a;
    }

    public a a() {
        return this.f2507b;
    }

    public b b() {
        return this.f2508c;
    }

    public e d() {
        return this.f2509d;
    }

    public f e() {
        return this.f2510e;
    }
}
