package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.n0.x;
import kotlin.reflect.y.internal.j0.f.c;

/* JADX INFO: compiled from: ReflectJavaType.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements x {
    public static final a a = new a(null);

    /* JADX INFO: compiled from: ReflectJavaType.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final z a(Type type) {
            z kVar;
            m.f(type, "type");
            boolean z = type instanceof Class;
            if (z) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new x(cls);
                }
            }
            if ((type instanceof GenericArrayType) || (z && ((Class) type).isArray())) {
                kVar = new k(type);
            } else {
                kVar = type instanceof WildcardType ? new c0((WildcardType) type) : new n(type);
            }
            return kVar;
        }
    }

    protected abstract Type R();

    public boolean equals(Object obj) {
        return (obj instanceof z) && m.a(R(), ((z) obj).R());
    }

    public int hashCode() {
        return R().hashCode();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public kotlin.reflect.y.internal.j0.d.a.n0.a l(c cVar) {
        return x.a.a(this, cVar);
    }

    public String toString() {
        return getClass().getName() + ": " + R();
    }
}
