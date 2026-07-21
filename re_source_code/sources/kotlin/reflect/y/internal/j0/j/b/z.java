package kotlin.reflect.y.internal.j0.j.b;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.e.z.c;
import kotlin.reflect.y.internal.j0.e.z.g;

/* JADX INFO: compiled from: ProtoContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z {
    private final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f24638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final z0 f24639c;

    /* JADX INFO: compiled from: ProtoContainer.kt */
    public static final class a extends z {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final kotlin.reflect.y.internal.j0.e.c f24640d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final a f24641e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final kotlin.reflect.y.internal.j0.f.b f24642f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final kotlin.reflect.y.internal.j0.e.c.EnumC0365c f24643g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f24644h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kotlin.reflect.y.internal.j0.e.c cVar, c cVar2, g gVar, z0 z0Var, a aVar) {
            super(cVar2, gVar, z0Var, null);
            m.f(cVar, "classProto");
            m.f(cVar2, "nameResolver");
            m.f(gVar, "typeTable");
            this.f24640d = cVar;
            this.f24641e = aVar;
            this.f24642f = x.a(cVar2, cVar.F0());
            kotlin.reflect.y.internal.j0.e.c.EnumC0365c enumC0365cD = kotlin.reflect.y.internal.j0.e.z.b.f24186f.d(cVar.E0());
            this.f24643g = enumC0365cD == null ? kotlin.reflect.y.internal.j0.e.c.EnumC0365c.CLASS : enumC0365cD;
            Boolean boolD = kotlin.reflect.y.internal.j0.e.z.b.f24187g.d(cVar.E0());
            m.e(boolD, "IS_INNER.get(classProto.flags)");
            this.f24644h = boolD.booleanValue();
        }

        @Override // kotlin.reflect.y.internal.j0.j.b.z
        public kotlin.reflect.y.internal.j0.f.c a() {
            kotlin.reflect.y.internal.j0.f.c cVarB = this.f24642f.b();
            m.e(cVarB, "classId.asSingleFqName()");
            return cVarB;
        }

        public final kotlin.reflect.y.internal.j0.f.b e() {
            return this.f24642f;
        }

        public final kotlin.reflect.y.internal.j0.e.c f() {
            return this.f24640d;
        }

        public final kotlin.reflect.y.internal.j0.e.c.EnumC0365c g() {
            return this.f24643g;
        }

        public final a h() {
            return this.f24641e;
        }

        public final boolean i() {
            return this.f24644h;
        }
    }

    /* JADX INFO: compiled from: ProtoContainer.kt */
    public static final class b extends z {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final kotlin.reflect.y.internal.j0.f.c f24645d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(kotlin.reflect.y.internal.j0.f.c cVar, c cVar2, g gVar, z0 z0Var) {
            super(cVar2, gVar, z0Var, null);
            m.f(cVar, "fqName");
            m.f(cVar2, "nameResolver");
            m.f(gVar, "typeTable");
            this.f24645d = cVar;
        }

        @Override // kotlin.reflect.y.internal.j0.j.b.z
        public kotlin.reflect.y.internal.j0.f.c a() {
            return this.f24645d;
        }
    }

    private z(c cVar, g gVar, z0 z0Var) {
        this.a = cVar;
        this.f24638b = gVar;
        this.f24639c = z0Var;
    }

    public /* synthetic */ z(c cVar, g gVar, z0 z0Var, kotlin.jvm.internal.g gVar2) {
        this(cVar, gVar, z0Var);
    }

    public abstract kotlin.reflect.y.internal.j0.f.c a();

    public final c b() {
        return this.a;
    }

    public final z0 c() {
        return this.f24639c;
    }

    public final g d() {
        return this.f24638b;
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + a();
    }
}
