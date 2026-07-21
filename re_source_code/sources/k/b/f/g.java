package k.b.f;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;

/* JADX INFO: compiled from: SubstituteLogger.java */
/* JADX INFO: loaded from: classes3.dex */
public class g implements k.b.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f22915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile k.b.b f22916g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Boolean f22917h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Method f22918i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private k.b.e.a f22919j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Queue<k.b.e.d> f22920k;
    private final boolean l;

    public g(String str, Queue<k.b.e.d> queue, boolean z) {
        this.f22915f = str;
        this.f22920k = queue;
        this.l = z;
    }

    private k.b.b k() {
        if (this.f22919j == null) {
            this.f22919j = new k.b.e.a(this, this.f22920k);
        }
        return this.f22919j;
    }

    @Override // k.b.b
    public void a(String str, Object obj, Object obj2) {
        j().a(str, obj, obj2);
    }

    @Override // k.b.b
    public boolean b() {
        return j().b();
    }

    @Override // k.b.b
    public void c(String str) {
        j().c(str);
    }

    @Override // k.b.b
    public boolean d() {
        return j().d();
    }

    @Override // k.b.b
    public void e(String str, Throwable th) {
        j().e(str, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && g.class == obj.getClass() && this.f22915f.equals(((g) obj).f22915f);
    }

    @Override // k.b.b
    public void f(String str, Throwable th) {
        j().f(str, th);
    }

    @Override // k.b.b
    public void g(String str, Throwable th) {
        j().g(str, th);
    }

    @Override // k.b.b
    public void h(String str) {
        j().h(str);
    }

    public int hashCode() {
        return this.f22915f.hashCode();
    }

    @Override // k.b.b
    public void i(String str) {
        j().i(str);
    }

    k.b.b j() {
        if (this.f22916g != null) {
            return this.f22916g;
        }
        return this.l ? d.f22913g : k();
    }

    public String l() {
        return this.f22915f;
    }

    public boolean m() {
        Boolean bool = this.f22917h;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f22918i = this.f22916g.getClass().getMethod("log", k.b.e.c.class);
            this.f22917h = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.f22917h = Boolean.FALSE;
        }
        return this.f22917h.booleanValue();
    }

    public boolean n() {
        return this.f22916g instanceof d;
    }

    public boolean o() {
        return this.f22916g == null;
    }

    public void p(k.b.e.c cVar) {
        if (m()) {
            try {
                this.f22918i.invoke(this.f22916g, cVar);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    public void q(k.b.b bVar) {
        this.f22916g = bVar;
    }
}
