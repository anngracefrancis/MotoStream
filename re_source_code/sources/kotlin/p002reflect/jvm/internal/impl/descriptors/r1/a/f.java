package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a;

import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.d;
import kotlin.reflect.y.internal.j0.d.b.c0.b;
import kotlin.reflect.y.internal.j0.d.b.q;
import kotlin.text.u;

/* JADX INFO: compiled from: ReflectKotlinClass.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements q {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<?> f25316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.d.b.c0.a f25317c;

    /* JADX INFO: compiled from: ReflectKotlinClass.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final f a(Class<?> cls) throws InvocationTargetException {
            m.f(cls, "klass");
            b bVar = new b();
            c.a.b(cls, bVar);
            kotlin.reflect.y.internal.j0.d.b.c0.a aVarM = bVar.m();
            g gVar = null;
            if (aVarM == null) {
                return null;
            }
            return new f(cls, aVarM, gVar);
        }
    }

    private f(Class<?> cls, kotlin.reflect.y.internal.j0.d.b.c0.a aVar) {
        this.f25316b = cls;
        this.f25317c = aVar;
    }

    public /* synthetic */ f(Class cls, kotlin.reflect.y.internal.j0.d.b.c0.a aVar, g gVar) {
        this(cls, aVar);
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.q
    public kotlin.reflect.y.internal.j0.d.b.c0.a a() {
        return this.f25317c;
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.q
    public void b(q.c cVar, byte[] bArr) throws InvocationTargetException {
        m.f(cVar, "visitor");
        c.a.b(this.f25316b, cVar);
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.q
    public void c(q.d dVar, byte[] bArr) throws InvocationTargetException {
        m.f(dVar, "visitor");
        c.a.i(this.f25316b, dVar);
    }

    public final Class<?> d() {
        return this.f25316b;
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.q
    public kotlin.reflect.y.internal.j0.f.b e() {
        return d.a(this.f25316b);
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && m.a(this.f25316b, ((f) obj).f25316b);
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.q
    public String getLocation() {
        StringBuilder sb = new StringBuilder();
        String name = this.f25316b.getName();
        m.e(name, "klass.name");
        sb.append(u.z(name, '.', '/', false, 4, null));
        sb.append(".class");
        return sb.toString();
    }

    public int hashCode() {
        return this.f25316b.hashCode();
    }

    public String toString() {
        return f.class.getName() + ": " + this.f25316b;
    }
}
