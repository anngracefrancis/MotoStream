package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.util.Collection;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.b.i;
import kotlin.reflect.y.internal.j0.d.a.n0.a;
import kotlin.reflect.y.internal.j0.d.a.n0.v;
import kotlin.reflect.y.internal.j0.i.u.e;

/* JADX INFO: compiled from: ReflectJavaPrimitiveType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class x extends z implements v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<?> f25362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Collection<a> f25363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f25364d;

    public x(Class<?> cls) {
        m.f(cls, "reflectType");
        this.f25362b = cls;
        this.f25363c = u.j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.z
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public Class<?> R() {
        return this.f25362b;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public Collection<a> getAnnotations() {
        return this.f25363c;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.v
    public i getType() {
        if (m.a(R(), Void.TYPE)) {
            return null;
        }
        return e.k(R().getName()).x();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public boolean m() {
        return this.f25364d;
    }
}
