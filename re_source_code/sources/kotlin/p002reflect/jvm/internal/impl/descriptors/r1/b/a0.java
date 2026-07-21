package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.s;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.n0.y;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: ReflectJavaTypeParameter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a0 extends p implements h, y {
    private final TypeVariable<?> a;

    public a0(TypeVariable<?> typeVariable) {
        m.f(typeVariable, "typeVariable");
        this.a = typeVariable;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public e l(c cVar) {
        return h.a.a(this, cVar);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public List<e> getAnnotations() {
        return h.a.b(this);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.y
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public List<n> getUpperBounds() {
        Type[] bounds = this.a.getBounds();
        m.e(bounds, "typeVariable.bounds");
        ArrayList arrayList = new ArrayList(bounds.length);
        for (Type type : bounds) {
            arrayList.add(new n(type));
        }
        n nVar = (n) s.u0(arrayList);
        return m.a(nVar != null ? nVar.R() : null, Object.class) ? u.j() : arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a0) && m.a(this.a, ((a0) obj).a);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.t
    public f getName() {
        f fVarX = f.x(this.a.getName());
        m.e(fVarX, "identifier(typeVariable.name)");
        return fVarX;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public boolean m() {
        return h.a.c(this);
    }

    public String toString() {
        return a0.class.getName() + ": " + this.a;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.h
    public AnnotatedElement w() {
        TypeVariable<?> typeVariable = this.a;
        if (typeVariable instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable;
        }
        return null;
    }
}
