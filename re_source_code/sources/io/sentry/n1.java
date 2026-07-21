package io.sentry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: Hint.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n1 {
    private static final Map<String, Class<?>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Object> f22501b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<s0> f22502c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private s0 f22503d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private s0 f22504e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private s0 f22505f = null;

    static {
        HashMap map = new HashMap();
        a = map;
        map.put("boolean", Boolean.class);
        map.put("char", Character.class);
        map.put("byte", Byte.class);
        map.put("short", Short.class);
        map.put("int", Integer.class);
        map.put("long", Long.class);
        map.put("float", Float.class);
        map.put("double", Double.class);
    }

    private boolean i(Object obj, Class<?> cls) {
        Class<?> cls2 = a.get(cls.getCanonicalName());
        return obj != null && cls.isPrimitive() && cls2 != null && cls2.isInstance(obj);
    }

    public void a(List<s0> list) {
        if (list != null) {
            this.f22502c.addAll(list);
        }
    }

    @ApiStatus.Internal
    public synchronized void b() {
        Iterator<Map.Entry<String, Object>> it = this.f22501b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> next = it.next();
            if (next.getKey() == null || !next.getKey().startsWith("sentry:")) {
                it.remove();
            }
        }
    }

    public synchronized Object c(String str) {
        return this.f22501b.get(str);
    }

    public synchronized <T> T d(String str, Class<T> cls) {
        T t = (T) this.f22501b.get(str);
        if (cls.isInstance(t)) {
            return t;
        }
        if (i(t, cls)) {
            return t;
        }
        return null;
    }

    public List<s0> e() {
        return new ArrayList(this.f22502c);
    }

    public s0 f() {
        return this.f22503d;
    }

    public s0 g() {
        return this.f22505f;
    }

    public s0 h() {
        return this.f22504e;
    }

    public synchronized void j(String str, Object obj) {
        this.f22501b.put(str, obj);
    }

    public void k(s0 s0Var) {
        this.f22503d = s0Var;
    }

    public void l(s0 s0Var) {
        this.f22505f = s0Var;
    }

    public void m(s0 s0Var) {
        this.f22504e = s0Var;
    }
}
