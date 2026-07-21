package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import kotlin.collections.j;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.n0.a;

/* JADX INFO: compiled from: ReflectJavaWildcardType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c0 extends z implements kotlin.reflect.y.internal.j0.d.a.n0.c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WildcardType f25334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Collection<a> f25335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f25336d;

    public c0(WildcardType wildcardType) {
        m.f(wildcardType, "reflectType");
        this.f25334b = wildcardType;
        this.f25335c = u.j();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.c0
    public boolean J() {
        Type[] upperBounds = R().getUpperBounds();
        m.e(upperBounds, "reflectType.upperBounds");
        return !m.a(j.x(upperBounds), Object.class);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.c0
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public z C() {
        Type[] upperBounds = R().getUpperBounds();
        Type[] lowerBounds = R().getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + R());
        }
        if (lowerBounds.length == 1) {
            z.a aVar = z.a;
            m.e(lowerBounds, "lowerBounds");
            Object objN = j.N(lowerBounds);
            m.e(objN, "lowerBounds.single()");
            return aVar.a((Type) objN);
        }
        if (upperBounds.length != 1) {
            return null;
        }
        m.e(upperBounds, "upperBounds");
        Type type = (Type) j.N(upperBounds);
        if (m.a(type, Object.class)) {
            return null;
        }
        z.a aVar2 = z.a;
        m.e(type, "ub");
        return aVar2.a(type);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.z
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public WildcardType R() {
        return this.f25334b;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public Collection<a> getAnnotations() {
        return this.f25335c;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public boolean m() {
        return this.f25336d;
    }
}
