package rx.q;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: RxJavaPlugins.java */
/* JADX INFO: loaded from: classes3.dex */
public class f {
    private static final f a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final rx.q.b f26853b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicReference<rx.q.b> f26854c = new AtomicReference<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicReference<d> f26855d = new AtomicReference<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicReference<h> f26856e = new AtomicReference<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicReference<rx.q.a> f26857f = new AtomicReference<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicReference<g> f26858g = new AtomicReference<>();

    /* JADX INFO: compiled from: RxJavaPlugins.java */
    static class a extends rx.q.b {
        a() {
        }
    }

    /* JADX INFO: compiled from: RxJavaPlugins.java */
    class b extends rx.q.a {
        b() {
        }
    }

    f() {
    }

    @Deprecated
    public static f c() {
        return a;
    }

    static Object e(Class<?> cls, Properties properties) {
        Properties properties2 = (Properties) properties.clone();
        String simpleName = cls.getSimpleName();
        String property = properties2.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            try {
                for (Map.Entry entry : properties2.entrySet()) {
                    String string = entry.getKey().toString();
                    if (string.startsWith("rxjava.plugin.") && string.endsWith(".class") && simpleName.equals(entry.getValue().toString())) {
                        String str = "rxjava.plugin." + string.substring(0, string.length() - 6).substring(14) + ".impl";
                        property = properties2.getProperty(str);
                        if (property != null) {
                            break;
                        }
                        throw new IllegalStateException("Implementing class declaration for " + simpleName + " missing: " + str);
                    }
                }
            } catch (SecurityException e2) {
                e2.printStackTrace();
            }
        }
        if (property == null) {
            return null;
        }
        try {
            return Class.forName(property).asSubclass(cls).newInstance();
        } catch (ClassCastException e3) {
            throw new IllegalStateException(simpleName + " implementation is not an instance of " + simpleName + ": " + property, e3);
        } catch (ClassNotFoundException e4) {
            throw new IllegalStateException(simpleName + " implementation class not found: " + property, e4);
        } catch (IllegalAccessException e5) {
            throw new IllegalStateException(simpleName + " implementation not able to be accessed: " + property, e5);
        } catch (InstantiationException e6) {
            throw new IllegalStateException(simpleName + " implementation not able to be instantiated: " + property, e6);
        }
    }

    static Properties h() {
        try {
            return System.getProperties();
        } catch (SecurityException unused) {
            return new Properties();
        }
    }

    public rx.q.a a() {
        if (this.f26857f.get() == null) {
            Object objE = e(rx.q.a.class, h());
            if (objE == null) {
                this.f26857f.compareAndSet(null, new b());
            } else {
                this.f26857f.compareAndSet(null, (rx.q.a) objE);
            }
        }
        return this.f26857f.get();
    }

    public rx.q.b b() {
        if (this.f26854c.get() == null) {
            Object objE = e(rx.q.b.class, h());
            if (objE == null) {
                this.f26854c.compareAndSet(null, f26853b);
            } else {
                this.f26854c.compareAndSet(null, (rx.q.b) objE);
            }
        }
        return this.f26854c.get();
    }

    public d d() {
        if (this.f26855d.get() == null) {
            Object objE = e(d.class, h());
            if (objE == null) {
                this.f26855d.compareAndSet(null, e.a());
            } else {
                this.f26855d.compareAndSet(null, (d) objE);
            }
        }
        return this.f26855d.get();
    }

    public g f() {
        if (this.f26858g.get() == null) {
            Object objE = e(g.class, h());
            if (objE == null) {
                this.f26858g.compareAndSet(null, g.h());
            } else {
                this.f26858g.compareAndSet(null, (g) objE);
            }
        }
        return this.f26858g.get();
    }

    public h g() {
        if (this.f26856e.get() == null) {
            Object objE = e(h.class, h());
            if (objE == null) {
                this.f26856e.compareAndSet(null, i.f());
            } else {
                this.f26856e.compareAndSet(null, (h) objE);
            }
        }
        return this.f26856e.get();
    }
}
