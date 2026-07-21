package com.facebook.o0.o0;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: InAppPurchaseSkuDetailsWrapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static l f10380b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Class<?> f10382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Class<?> f10383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Method f10384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Method f10385g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Method f10386h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Method f10387i;
    public static final a a = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f10381c = new AtomicBoolean(false);

    /* JADX INFO: compiled from: InAppPurchaseSkuDetailsWrapper.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final void a() {
            m mVar = m.a;
            Class<?> clsA = m.a("com.android.billingclient.api.SkuDetailsParams");
            Class<?> clsA2 = m.a("com.android.billingclient.api.SkuDetailsParams$Builder");
            if (clsA == null || clsA2 == null) {
                return;
            }
            Method methodD = m.d(clsA, "newBuilder", new Class[0]);
            Method methodD2 = m.d(clsA2, "setType", String.class);
            Method methodD3 = m.d(clsA2, "setSkusList", List.class);
            Method methodD4 = m.d(clsA2, "build", new Class[0]);
            if (methodD == null || methodD2 == null || methodD3 == null || methodD4 == null) {
                return;
            }
            l.f10380b = new l(clsA, clsA2, methodD, methodD2, methodD3, methodD4);
        }

        public final l b() {
            if (l.f10381c.get()) {
                return l.f10380b;
            }
            a();
            l.f10381c.set(true);
            return l.f10380b;
        }
    }

    public l(Class<?> cls, Class<?> cls2, Method method, Method method2, Method method3, Method method4) {
        kotlin.jvm.internal.m.f(cls, "skuDetailsParamsClazz");
        kotlin.jvm.internal.m.f(cls2, "builderClazz");
        kotlin.jvm.internal.m.f(method, "newBuilderMethod");
        kotlin.jvm.internal.m.f(method2, "setTypeMethod");
        kotlin.jvm.internal.m.f(method3, "setSkusListMethod");
        kotlin.jvm.internal.m.f(method4, "buildMethod");
        this.f10382d = cls;
        this.f10383e = cls2;
        this.f10384f = method;
        this.f10385g = method2;
        this.f10386h = method3;
        this.f10387i = method4;
    }

    public final Object d(String str, List<String> list) {
        Object objE;
        Object objE2;
        m mVar = m.a;
        Object objE3 = m.e(this.f10382d, this.f10384f, null, new Object[0]);
        if (objE3 == null || (objE = m.e(this.f10383e, this.f10385g, objE3, str)) == null || (objE2 = m.e(this.f10383e, this.f10386h, objE, list)) == null) {
            return null;
        }
        return m.e(this.f10383e, this.f10387i, objE2, new Object[0]);
    }

    public final Class<?> e() {
        return this.f10382d;
    }
}
