package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.n0.a;
import kotlin.reflect.y.internal.j0.d.a.n0.i;
import kotlin.reflect.y.internal.j0.d.a.n0.j;
import kotlin.reflect.y.internal.j0.d.a.n0.x;
import kotlin.reflect.y.internal.j0.f.c;

/* JADX INFO: compiled from: ReflectJavaClassifierType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class n extends z implements j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Type f25358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i f25359c;

    public n(Type type) {
        i lVar;
        m.f(type, "reflectType");
        this.f25358b = type;
        Type typeR = R();
        if (typeR instanceof Class) {
            lVar = new l((Class) typeR);
        } else if (typeR instanceof TypeVariable) {
            lVar = new a0((TypeVariable) typeR);
        } else {
            if (!(typeR instanceof ParameterizedType)) {
                throw new IllegalStateException("Not a classifier type (" + typeR.getClass() + "): " + typeR);
            }
            Type rawType = ((ParameterizedType) typeR).getRawType();
            m.d(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            lVar = new l((Class) rawType);
        }
        this.f25359c = lVar;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.j
    public List<x> F() {
        List<Type> listC = d.c(R());
        z.a aVar = z.a;
        ArrayList arrayList = new ArrayList(v.u(listC, 10));
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            arrayList.add(aVar.a((Type) it.next()));
        }
        return arrayList;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.z
    public Type R() {
        return this.f25358b;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.j
    public i c() {
        return this.f25359c;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public Collection<a> getAnnotations() {
        return u.j();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.z, kotlin.reflect.y.internal.j0.d.a.n0.d
    public a l(c cVar) {
        m.f(cVar, "fqName");
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public boolean m() {
        return false;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.j
    public String p() {
        return R().toString();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.j
    public boolean x() {
        Type typeR = R();
        if (!(typeR instanceof Class)) {
            return false;
        }
        TypeVariable[] typeParameters = ((Class) typeR).getTypeParameters();
        m.e(typeParameters, "getTypeParameters()");
        return (typeParameters.length == 0) ^ true;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.j
    public String y() {
        throw new UnsupportedOperationException("Type not found: " + R());
    }
}
