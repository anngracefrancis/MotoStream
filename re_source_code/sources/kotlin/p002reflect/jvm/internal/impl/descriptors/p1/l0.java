package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.v;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.j1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.o;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.l1;

/* JADX INFO: compiled from: ValueParameterDescriptorImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public class l0 extends m0 implements i1 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f25249k = new a(null);
    private final int l;
    private final boolean m;
    private final boolean n;
    private final boolean o;
    private final e0 p;
    private final i1 q;

    /* JADX INFO: compiled from: ValueParameterDescriptorImpl.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final l0 a(kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar, i1 i1Var, int i2, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar, f fVar, e0 e0Var, boolean z, boolean z2, boolean z3, e0 e0Var2, z0 z0Var, Function0<? extends List<? extends j1>> function0) {
            m.f(aVar, "containingDeclaration");
            m.f(gVar, "annotations");
            m.f(fVar, "name");
            m.f(e0Var, "outType");
            m.f(z0Var, "source");
            return function0 == null ? new l0(aVar, i1Var, i2, gVar, fVar, e0Var, z, z2, z3, e0Var2, z0Var) : new b(aVar, i1Var, i2, gVar, fVar, e0Var, z, z2, z3, e0Var2, z0Var, function0);
        }
    }

    /* JADX INFO: compiled from: ValueParameterDescriptorImpl.kt */
    public static final class b extends l0 {
        private final Lazy r;

        /* JADX INFO: compiled from: ValueParameterDescriptorImpl.kt */
        static final class a extends Lambda implements Function0<List<? extends j1>> {
            a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends j1> invoke() {
                return b.this.O0();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar, i1 i1Var, int i2, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar, f fVar, e0 e0Var, boolean z, boolean z2, boolean z3, e0 e0Var2, z0 z0Var, Function0<? extends List<? extends j1>> function0) {
            super(aVar, i1Var, i2, gVar, fVar, e0Var, z, z2, z3, e0Var2, z0Var);
            m.f(aVar, "containingDeclaration");
            m.f(gVar, "annotations");
            m.f(fVar, "name");
            m.f(e0Var, "outType");
            m.f(z0Var, "source");
            m.f(function0, "destructuringVariables");
            this.r = i.b(function0);
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.l0, kotlin.p002reflect.jvm.internal.impl.descriptors.i1
        public i1 G0(kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar, f fVar, int i2) {
            m.f(aVar, "newOwner");
            m.f(fVar, "newName");
            kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g annotations = getAnnotations();
            m.e(annotations, "annotations");
            e0 type = getType();
            m.e(type, "type");
            boolean zU0 = u0();
            boolean zB0 = b0();
            boolean zY = Y();
            e0 e0VarL0 = l0();
            z0 z0Var = z0.a;
            m.e(z0Var, "NO_SOURCE");
            return new b(aVar, null, i2, annotations, fVar, type, zU0, zB0, zY, e0VarL0, z0Var, new a());
        }

        public final List<j1> O0() {
            return (List) this.r.getValue();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar, i1 i1Var, int i2, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar, f fVar, e0 e0Var, boolean z, boolean z2, boolean z3, e0 e0Var2, z0 z0Var) {
        super(aVar, gVar, fVar, e0Var, z0Var);
        m.f(aVar, "containingDeclaration");
        m.f(gVar, "annotations");
        m.f(fVar, "name");
        m.f(e0Var, "outType");
        m.f(z0Var, "source");
        this.l = i2;
        this.m = z;
        this.n = z2;
        this.o = z3;
        this.p = e0Var2;
        this.q = i1Var == null ? this : i1Var;
    }

    public static final l0 L0(kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar, i1 i1Var, int i2, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar, f fVar, e0 e0Var, boolean z, boolean z2, boolean z3, e0 e0Var2, z0 z0Var, Function0<? extends List<? extends j1>> function0) {
        return f25249k.a(aVar, i1Var, i2, gVar, fVar, e0Var, z, z2, z3, e0Var2, z0Var, function0);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.i1
    public i1 G0(kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar, f fVar, int i2) {
        m.f(aVar, "newOwner");
        m.f(fVar, "newName");
        kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g annotations = getAnnotations();
        m.e(annotations, "annotations");
        e0 type = getType();
        m.e(type, "type");
        boolean zU0 = u0();
        boolean zB0 = b0();
        boolean zY = Y();
        e0 e0VarL0 = l0();
        z0 z0Var = z0.a;
        m.e(z0Var, "NO_SOURCE");
        return new l0(aVar, null, i2, annotations, fVar, type, zU0, zB0, zY, e0VarL0, z0Var);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(o<R, D> oVar, D d2) {
        m.f(oVar, "visitor");
        return oVar.k(this, d2);
    }

    public Void M0() {
        return null;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.b1
    /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
    public i1 c(l1 l1Var) {
        m.f(l1Var, "substitutor");
        if (l1Var.k()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.j1
    public /* bridge */ /* synthetic */ kotlin.reflect.y.internal.j0.i.r.g X() {
        return (kotlin.reflect.y.internal.j0.i.r.g) M0();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.i1
    public boolean Y() {
        return this.o;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.i1
    public boolean b0() {
        return this.n;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public Collection<i1> e() {
        Collection<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.a> collectionE = b().e();
        m.e(collectionE, "containingDeclaration.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(v.u(collectionE, 10));
        Iterator<T> it = collectionE.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.p002reflect.jvm.internal.impl.descriptors.a) it.next()).f().get(g()));
        }
        return arrayList;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.i1
    public int g() {
        return this.l;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.q, kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public u getVisibility() {
        u uVar = t.f25369f;
        m.e(uVar, "LOCAL");
        return uVar;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.j1
    public boolean j0() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.i1
    public e0 l0() {
        return this.p;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.i1
    public boolean u0() {
        if (this.m) {
            kotlin.p002reflect.jvm.internal.impl.descriptors.a aVarB = b();
            m.d(aVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
            if (((kotlin.p002reflect.jvm.internal.impl.descriptors.b) aVarB).i().g()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.k, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public kotlin.p002reflect.jvm.internal.impl.descriptors.a b() {
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = super.b();
        m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        return (kotlin.p002reflect.jvm.internal.impl.descriptors.a) mVarB;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.k, kotlin.p002reflect.jvm.internal.impl.descriptors.p1.j, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public i1 a() {
        i1 i1Var = this.q;
        return i1Var == this ? this : i1Var.a();
    }
}
