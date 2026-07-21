package io.sentry.android.core.internal.util;

import io.sentry.s4;
import io.sentry.v0;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: BreadcrumbFactory.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public class i {
    public static v0 a(String str) {
        v0 v0Var = new v0();
        v0Var.p("session");
        v0Var.m("state", str);
        v0Var.l("app.lifecycle");
        v0Var.n(s4.INFO);
        return v0Var;
    }
}
