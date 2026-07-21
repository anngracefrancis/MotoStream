package com.facebook.o0.k0;

import android.app.Activity;
import com.facebook.a0;
import com.facebook.internal.c0;
import com.facebook.internal.d0;
import com.facebook.internal.p0;
import com.facebook.internal.q;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: MetadataIndexer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final c a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10151b = c.class.getCanonicalName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f10152c;

    private c() {
    }

    public static final void a() {
        try {
            a0 a0Var = a0.a;
            a0.k().execute(new Runnable() { // from class: com.facebook.o0.k0.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.b();
                }
            });
        } catch (Exception e2) {
            p0 p0Var = p0.a;
            p0.i0(f10151b, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b() {
        a0 a0Var = a0.a;
        if (q.a.h(a0.c())) {
            return;
        }
        a.e();
        f10152c = true;
    }

    public static final void d(Activity activity) {
        m.f(activity, "activity");
        try {
            if (f10152c && !e.a.c().isEmpty()) {
                f.f10157f.e(activity);
            }
        } catch (Exception unused) {
        }
    }

    private final void e() {
        String strH;
        d0 d0Var = d0.a;
        a0 a0Var = a0.a;
        c0 c0VarO = d0.o(a0.d(), false);
        if (c0VarO == null || (strH = c0VarO.h()) == null) {
            return;
        }
        e.a.d(strH);
    }
}
