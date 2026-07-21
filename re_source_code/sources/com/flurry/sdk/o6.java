package com.flurry.sdk;

import android.os.SystemClock;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class o6 extends r6 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f10966e = "UserPropertiesFrame";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicInteger f10967f = new AtomicInteger(0);

    private o6(t6 t6Var) {
        super(t6Var);
    }

    private static void h(String str, String str2, p6.a aVar) {
        i(str, str2 == null ? Collections.emptyList() : Collections.singletonList(str2), aVar);
    }

    private static void i(String str, List<String> list, p6.a aVar) {
        m2.a().b(new o6(new p6(f10967f.incrementAndGet(), SystemClock.elapsedRealtime(), str, list, aVar)));
    }

    public static void j(String str, String str2) {
        if (str2 == null) {
            d1.c(2, f10966e, "User Property is null, do not send the frame.");
        } else {
            h(str, str2, p6.a.Add);
        }
    }

    @Override // com.flurry.sdk.u6
    public final s6 a() {
        return s6.USER_PROPERTY;
    }
}
