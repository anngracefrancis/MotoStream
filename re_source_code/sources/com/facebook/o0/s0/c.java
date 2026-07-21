package com.facebook.o0.s0;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.a0;
import com.facebook.internal.p0;
import com.facebook.o0.v;
import java.util.Set;
import kotlin.collections.t;
import kotlin.collections.w0;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: OnDeviceProcessingManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final c a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f10478b = w0.i("fb_mobile_purchase", "StartTrial", "Subscribe");

    private c() {
    }

    private final boolean a(v vVar) {
        return (vVar.h() ^ true) || (vVar.h() && f10478b.contains(vVar.f()));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public static final boolean b() {
        boolean z;
        a0 a0Var = a0.a;
        if (a0.q(a0.c())) {
            z = false;
        } else {
            p0 p0Var = p0.a;
            if (p0.X()) {
                z = false;
            } else {
                z = true;
            }
        }
        if (z) {
            e eVar = e.a;
            if (e.b()) {
                return true;
            }
        }
        return false;
    }

    public static final void e(final String str, final v vVar) {
        m.f(str, "applicationId");
        m.f(vVar, "event");
        if (a.a(vVar)) {
            a0 a0Var = a0.a;
            a0.k().execute(new Runnable() { // from class: com.facebook.o0.s0.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.f(str, vVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String str, v vVar) {
        m.f(str, "$applicationId");
        m.f(vVar, "$event");
        e eVar = e.a;
        e.c(str, t.e(vVar));
    }

    public static final void g(final String str, final String str2) {
        a0 a0Var = a0.a;
        final Context contextC = a0.c();
        if (contextC == null || str == null || str2 == null) {
            return;
        }
        a0.k().execute(new Runnable() { // from class: com.facebook.o0.s0.a
            @Override // java.lang.Runnable
            public final void run() {
                c.h(contextC, str2, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Context context, String str, String str2) {
        m.f(context, "$context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        String strN = m.n(str2, "pingForOnDevice");
        if (sharedPreferences.getLong(strN, 0L) == 0) {
            e eVar = e.a;
            e.e(str2);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putLong(strN, System.currentTimeMillis());
            editorEdit.apply();
        }
    }
}
