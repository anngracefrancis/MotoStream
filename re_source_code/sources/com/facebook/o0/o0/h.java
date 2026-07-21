package com.facebook.o0.o0;

import android.content.Context;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.text.u;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: InAppPurchaseBillingClientWrapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static h f10360c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f10364g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f10365h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Class<?> f10366i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Class<?> f10367j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Class<?> f10368k;
    private final Class<?> l;
    private final Class<?> m;
    private final Class<?> n;
    private final Class<?> o;
    private final Method p;
    private final Method q;
    private final Method r;
    private final Method s;
    private final Method t;
    private final Method u;
    private final Method v;
    private final l w;
    private final Set<String> x;
    public static final b a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f10359b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicBoolean f10361d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, JSONObject> f10362e = new ConcurrentHashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Map<String, JSONObject> f10363f = new ConcurrentHashMap();

    /* JADX INFO: compiled from: InAppPurchaseBillingClientWrapper.kt */
    public static final class a implements InvocationHandler {
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            kotlin.jvm.internal.m.f(obj, "proxy");
            kotlin.jvm.internal.m.f(method, "m");
            if (kotlin.jvm.internal.m.a(method.getName(), "onBillingSetupFinished")) {
                h.a.f().set(true);
            } else {
                String name = method.getName();
                kotlin.jvm.internal.m.e(name, "m.name");
                if (u.p(name, "onBillingServiceDisconnected", false, 2, null)) {
                    h.a.f().set(false);
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: InAppPurchaseBillingClientWrapper.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final Object a(Context context, Class<?> cls) {
            Object objE;
            Object objE2;
            Object objE3;
            m mVar = m.a;
            Class<?> clsA = m.a("com.android.billingclient.api.BillingClient$Builder");
            Class<?> clsA2 = m.a("com.android.billingclient.api.PurchasesUpdatedListener");
            if (clsA == null || clsA2 == null) {
                return null;
            }
            Method methodD = m.d(cls, "newBuilder", Context.class);
            Method methodD2 = m.d(clsA, "enablePendingPurchases", new Class[0]);
            Method methodD3 = m.d(clsA, "setListener", clsA2);
            Method methodD4 = m.d(clsA, "build", new Class[0]);
            if (methodD == null || methodD2 == null || methodD3 == null || methodD4 == null || (objE = m.e(cls, methodD, null, context)) == null || (objE2 = m.e(clsA, methodD3, objE, Proxy.newProxyInstance(clsA2.getClassLoader(), new Class[]{clsA2}, new d()))) == null || (objE3 = m.e(clsA, methodD2, objE2, new Object[0])) == null) {
                return null;
            }
            return m.e(clsA, methodD4, objE3, new Object[0]);
        }

        private final void b(Context context) {
            l lVarB = l.a.b();
            if (lVarB == null) {
                return;
            }
            m mVar = m.a;
            Class<?> clsA = m.a("com.android.billingclient.api.BillingClient");
            Class<?> clsA2 = m.a("com.android.billingclient.api.Purchase");
            Class<?> clsA3 = m.a("com.android.billingclient.api.Purchase$PurchasesResult");
            Class<?> clsA4 = m.a("com.android.billingclient.api.SkuDetails");
            Class<?> clsA5 = m.a("com.android.billingclient.api.PurchaseHistoryRecord");
            Class<?> clsA6 = m.a("com.android.billingclient.api.SkuDetailsResponseListener");
            Class<?> clsA7 = m.a("com.android.billingclient.api.PurchaseHistoryResponseListener");
            if (clsA == null || clsA3 == null || clsA2 == null || clsA4 == null || clsA6 == null || clsA5 == null || clsA7 == null) {
                return;
            }
            Method methodD = m.d(clsA, "queryPurchases", String.class);
            Method methodD2 = m.d(clsA3, "getPurchasesList", new Class[0]);
            Method methodD3 = m.d(clsA2, "getOriginalJson", new Class[0]);
            Method methodD4 = m.d(clsA4, "getOriginalJson", new Class[0]);
            Method methodD5 = m.d(clsA5, "getOriginalJson", new Class[0]);
            Method methodD6 = m.d(clsA, "querySkuDetailsAsync", lVarB.e(), clsA6);
            Method methodD7 = m.d(clsA, "queryPurchaseHistoryAsync", String.class, clsA7);
            if (methodD == null || methodD2 == null || methodD3 == null || methodD4 == null || methodD5 == null || methodD6 == null || methodD7 == null) {
                return;
            }
            Object objA = a(context, clsA);
            if (objA == null) {
                return;
            }
            h.f10360c = new h(context, objA, clsA, clsA3, clsA2, clsA4, clsA5, clsA6, clsA7, methodD, methodD2, methodD3, methodD4, methodD5, methodD6, methodD7, lVarB, null);
            h hVar = h.f10360c;
            if (hVar == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper");
            }
            hVar.t();
        }

        public final synchronized h c(Context context) {
            kotlin.jvm.internal.m.f(context, "context");
            if (h.f10359b.get()) {
                return h.f10360c;
            }
            b(context);
            h.f10359b.set(true);
            return h.f10360c;
        }

        public final Map<String, JSONObject> d() {
            return h.f10362e;
        }

        public final Map<String, JSONObject> e() {
            return h.f10363f;
        }

        public final AtomicBoolean f() {
            return h.f10361d;
        }
    }

    /* JADX INFO: compiled from: InAppPurchaseBillingClientWrapper.kt */
    public final class c implements InvocationHandler {
        private Runnable a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f10369b;

        public c(h hVar, Runnable runnable) {
            kotlin.jvm.internal.m.f(hVar, "this$0");
            kotlin.jvm.internal.m.f(runnable, "runnable");
            this.f10369b = hVar;
            this.a = runnable;
        }

        private final void a(List<?> list) {
            for (Object obj : list) {
                try {
                    m mVar = m.a;
                    Object objE = m.e(this.f10369b.m, this.f10369b.t, obj, new Object[0]);
                    String str = objE instanceof String ? (String) objE : null;
                    if (str != null) {
                        JSONObject jSONObject = new JSONObject(str);
                        jSONObject.put("packageName", this.f10369b.f10364g.getPackageName());
                        if (jSONObject.has("productId")) {
                            String string = jSONObject.getString("productId");
                            this.f10369b.x.add(string);
                            Map<String, JSONObject> mapD = h.a.d();
                            kotlin.jvm.internal.m.e(string, "skuID");
                            mapD.put(string, jSONObject);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            this.a.run();
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            kotlin.jvm.internal.m.f(obj, "proxy");
            kotlin.jvm.internal.m.f(method, "method");
            if (kotlin.jvm.internal.m.a(method.getName(), "onPurchaseHistoryResponse")) {
                Object obj2 = objArr == null ? null : objArr[1];
                if (obj2 != null && (obj2 instanceof List)) {
                    a((List) obj2);
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: InAppPurchaseBillingClientWrapper.kt */
    public static final class d implements InvocationHandler {
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            kotlin.jvm.internal.m.f(obj, "proxy");
            kotlin.jvm.internal.m.f(method, "m");
            return null;
        }
    }

    /* JADX INFO: compiled from: InAppPurchaseBillingClientWrapper.kt */
    public final class e implements InvocationHandler {
        private Runnable a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f10370b;

        public e(h hVar, Runnable runnable) {
            kotlin.jvm.internal.m.f(hVar, "this$0");
            kotlin.jvm.internal.m.f(runnable, "runnable");
            this.f10370b = hVar;
            this.a = runnable;
        }

        public final void a(List<?> list) {
            kotlin.jvm.internal.m.f(list, "skuDetailsObjectList");
            for (Object obj : list) {
                try {
                    m mVar = m.a;
                    Object objE = m.e(this.f10370b.l, this.f10370b.s, obj, new Object[0]);
                    String str = objE instanceof String ? (String) objE : null;
                    if (str != null) {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has("productId")) {
                            String string = jSONObject.getString("productId");
                            Map<String, JSONObject> mapE = h.a.e();
                            kotlin.jvm.internal.m.e(string, "skuID");
                            mapE.put(string, jSONObject);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            this.a.run();
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            kotlin.jvm.internal.m.f(obj, "proxy");
            kotlin.jvm.internal.m.f(method, "m");
            if (kotlin.jvm.internal.m.a(method.getName(), "onSkuDetailsResponse")) {
                Object obj2 = objArr == null ? null : objArr[1];
                if (obj2 != null && (obj2 instanceof List)) {
                    a((List) obj2);
                }
            }
            return null;
        }
    }

    private h(Context context, Object obj, Class<?> cls, Class<?> cls2, Class<?> cls3, Class<?> cls4, Class<?> cls5, Class<?> cls6, Class<?> cls7, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, l lVar) {
        this.f10364g = context;
        this.f10365h = obj;
        this.f10366i = cls;
        this.f10367j = cls2;
        this.f10368k = cls3;
        this.l = cls4;
        this.m = cls5;
        this.n = cls6;
        this.o = cls7;
        this.p = method;
        this.q = method2;
        this.r = method3;
        this.s = method4;
        this.t = method5;
        this.u = method6;
        this.v = method7;
        this.w = lVar;
        this.x = new CopyOnWriteArraySet();
    }

    public /* synthetic */ h(Context context, Object obj, Class cls, Class cls2, Class cls3, Class cls4, Class cls5, Class cls6, Class cls7, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, l lVar, kotlin.jvm.internal.g gVar) {
        this(context, obj, cls, cls2, cls3, cls4, cls5, cls6, cls7, method, method2, method3, method4, method5, method6, method7, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(h hVar, Runnable runnable) {
        kotlin.jvm.internal.m.f(hVar, "this$0");
        kotlin.jvm.internal.m.f(runnable, "$queryPurchaseHistoryRunnable");
        hVar.s("inapp", new ArrayList(hVar.x), runnable);
    }

    private final void r(String str, Runnable runnable) {
        Object objNewProxyInstance = Proxy.newProxyInstance(this.o.getClassLoader(), new Class[]{this.o}, new c(this, runnable));
        m mVar = m.a;
        m.e(this.f10366i, this.v, this.f10365h, str, objNewProxyInstance);
    }

    private final void s(String str, List<String> list, Runnable runnable) {
        Object objNewProxyInstance = Proxy.newProxyInstance(this.n.getClassLoader(), new Class[]{this.n}, new e(this, runnable));
        Object objD = this.w.d(str, list);
        m mVar = m.a;
        m.e(this.f10366i, this.u, this.f10365h, objD, objNewProxyInstance);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        Method methodD;
        m mVar = m.a;
        Class<?> clsA = m.a("com.android.billingclient.api.BillingClientStateListener");
        if (clsA == null || (methodD = m.d(this.f10366i, "startConnection", clsA)) == null) {
            return;
        }
        m.e(this.f10366i, methodD, this.f10365h, Proxy.newProxyInstance(clsA.getClassLoader(), new Class[]{clsA}, new a()));
    }

    public final void o(String str, Runnable runnable) {
        kotlin.jvm.internal.m.f(str, "skuType");
        kotlin.jvm.internal.m.f(runnable, "querySkuRunnable");
        m mVar = m.a;
        Object objE = m.e(this.f10367j, this.q, m.e(this.f10366i, this.p, this.f10365h, "inapp"), new Object[0]);
        List list = objE instanceof List ? (List) objE : null;
        if (list == null) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                m mVar2 = m.a;
                Object objE2 = m.e(this.f10368k, this.r, obj, new Object[0]);
                String str2 = objE2 instanceof String ? (String) objE2 : null;
                if (str2 != null) {
                    JSONObject jSONObject = new JSONObject(str2);
                    if (jSONObject.has("productId")) {
                        String string = jSONObject.getString("productId");
                        arrayList.add(string);
                        Map<String, JSONObject> map = f10362e;
                        kotlin.jvm.internal.m.e(string, "skuID");
                        map.put(string, jSONObject);
                    }
                }
            }
            s(str, arrayList, runnable);
        } catch (JSONException unused) {
        }
    }

    public final void p(String str, final Runnable runnable) {
        kotlin.jvm.internal.m.f(str, "skuType");
        kotlin.jvm.internal.m.f(runnable, "queryPurchaseHistoryRunnable");
        r(str, new Runnable() { // from class: com.facebook.o0.o0.e
            @Override // java.lang.Runnable
            public final void run() {
                h.q(this.f10349f, runnable);
            }
        });
    }
}
