package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.n0.a;
import kotlin.reflect.y.internal.j0.d.a.n0.f;

/* JADX INFO: compiled from: ReflectJavaArrayType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k extends z implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Type f25345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final z f25346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Collection<a> f25347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f25348e;

    public k(Type type) {
        z zVarA;
        m.f(type, "reflectType");
        this.f25345b = type;
        Type typeR = R();
        if (!(typeR instanceof GenericArrayType)) {
            if (typeR instanceof Class) {
                Class cls = (Class) typeR;
                if (cls.isArray()) {
                    z.a aVar = z.a;
                    Class<?> componentType = cls.getComponentType();
                    m.e(componentType, "getComponentType()");
                    zVarA = aVar.a(componentType);
                }
            }
            throw new IllegalArgumentException("Not an array type (" + R().getClass() + "): " + R());
        }
        z.a aVar2 = z.a;
        Type genericComponentType = ((GenericArrayType) typeR).getGenericComponentType();
        m.e(genericComponentType, "genericComponentType");
        zVarA = aVar2.a(genericComponentType);
        this.f25346c = zVarA;
        this.f25347d = u.j();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.z
    protected Type R() {
        return this.f25345b;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.f
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public z n() {
        return this.f25346c;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public Collection<a> getAnnotations() {
        return this.f25347d;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public boolean m() {
        return this.f25348e;
    }
}
