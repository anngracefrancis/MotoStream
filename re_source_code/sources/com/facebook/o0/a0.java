package com.facebook.o0;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import java.util.Arrays;

/* JADX INFO: compiled from: AppEventsLogger.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10091b = a0.class.getCanonicalName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b0 f10092c;

    /* JADX INFO: compiled from: AppEventsLogger.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final void a(Application application) {
            kotlin.jvm.internal.m.f(application, "application");
            b0.a.d(application, null);
        }

        public final void b(Application application, String str) {
            kotlin.jvm.internal.m.f(application, "application");
            b0.a.d(application, str);
        }

        public final String c(Context context) {
            kotlin.jvm.internal.m.f(context, "context");
            return b0.a.g(context);
        }

        public final b d() {
            return b0.a.h();
        }

        public final String e() {
            u uVar = u.a;
            return u.a();
        }

        public final void f(Context context, String str) {
            kotlin.jvm.internal.m.f(context, "context");
            b0.a.k(context, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final a0 g(Context context) {
            kotlin.jvm.internal.m.f(context, "context");
            return new a0(context, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0);
        }

        public final void h() {
            b0.a.s();
        }

        public final void i(String str) {
            u uVar = u.a;
            u.g(str);
        }
    }

    /* JADX INFO: compiled from: AppEventsLogger.kt */
    public enum b {
        AUTO,
        EXPLICIT_ONLY;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static b[] valuesCustom() {
            b[] bVarArrValuesCustom = values();
            return (b[]) Arrays.copyOf(bVarArrValuesCustom, bVarArrValuesCustom.length);
        }
    }

    private a0(Context context, String str, AccessToken accessToken) {
        this.f10092c = new b0(context, str, accessToken);
    }

    public /* synthetic */ a0(Context context, String str, AccessToken accessToken, kotlin.jvm.internal.g gVar) {
        this(context, str, accessToken);
    }

    public static final void a(Application application) {
        a.a(application);
    }

    public static final a0 e(Context context) {
        return a.g(context);
    }

    public static final void f(String str) {
        a.i(str);
    }

    public final void b() {
        this.f10092c.j();
    }

    public final void c(String str) {
        this.f10092c.k(str);
    }

    public final void d(String str, Bundle bundle) {
        this.f10092c.m(str, bundle);
    }
}
