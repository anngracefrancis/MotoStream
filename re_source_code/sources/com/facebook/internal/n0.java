package com.facebook.internal;

import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: ServerProtocol.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class n0 {
    public static final n0 a = new n0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9806b = n0.class.getName();

    private n0() {
    }

    public static final String a() {
        return "v16.0";
    }

    public static final String b() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        com.facebook.a0 a0Var = com.facebook.a0.a;
        String str = String.format("m.%s", Arrays.copyOf(new Object[]{com.facebook.a0.l()}, 1));
        kotlin.jvm.internal.m.e(str, "java.lang.String.format(format, *args)");
        return str;
    }

    public static final String c() {
        return "CONNECTION_FAILURE";
    }

    public static final Collection<String> d() {
        return kotlin.collections.u.m("service_disabled", "AndroidAuthKillSwitchException");
    }

    public static final Collection<String> e() {
        return kotlin.collections.u.m("access_denied", "OAuthAccessDeniedException");
    }

    public static final String f() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        com.facebook.a0 a0Var = com.facebook.a0.a;
        String str = String.format("https://graph.%s", Arrays.copyOf(new Object[]{com.facebook.a0.l()}, 1));
        kotlin.jvm.internal.m.e(str, "java.lang.String.format(format, *args)");
        return str;
    }

    public static final String g() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        com.facebook.a0 a0Var = com.facebook.a0.a;
        String str = String.format("%s", Arrays.copyOf(new Object[]{com.facebook.a0.m()}, 1));
        kotlin.jvm.internal.m.e(str, "java.lang.String.format(format, *args)");
        return str;
    }

    public static final String h() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        com.facebook.a0 a0Var = com.facebook.a0.a;
        String str = String.format("https://graph.%s", Arrays.copyOf(new Object[]{com.facebook.a0.o()}, 1));
        kotlin.jvm.internal.m.e(str, "java.lang.String.format(format, *args)");
        return str;
    }

    public static final String i(String str) {
        kotlin.jvm.internal.m.f(str, "subdomain");
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String str2 = String.format("https://graph.%s", Arrays.copyOf(new Object[]{str}, 1));
        kotlin.jvm.internal.m.e(str2, "java.lang.String.format(format, *args)");
        return str2;
    }

    public static final String j() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        com.facebook.a0 a0Var = com.facebook.a0.a;
        String str = String.format("https://graph-video.%s", Arrays.copyOf(new Object[]{com.facebook.a0.o()}, 1));
        kotlin.jvm.internal.m.e(str, "java.lang.String.format(format, *args)");
        return str;
    }

    public static final String k() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        com.facebook.a0 a0Var = com.facebook.a0.a;
        String str = String.format("m.%s", Arrays.copyOf(new Object[]{com.facebook.a0.p()}, 1));
        kotlin.jvm.internal.m.e(str, "java.lang.String.format(format, *args)");
        return str;
    }
}
