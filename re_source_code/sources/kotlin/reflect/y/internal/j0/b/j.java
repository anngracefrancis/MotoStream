package kotlin.reflect.y.internal.j0.b;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.j0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.KProperty;
import kotlin.reflect.y.internal.j0.c.b.d;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.s0;

/* JADX INFO: compiled from: ReflectionTypes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j0 f23181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f23182d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f23183e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a f23184f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a f23185g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a f23186h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final a f23187i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final a f23188j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final a f23189k;
    private final a l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f23180b = {g0.h(new y(g0.b(j.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), g0.h(new y(g0.b(j.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), g0.h(new y(g0.b(j.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), g0.h(new y(g0.b(j.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), g0.h(new y(g0.b(j.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), g0.h(new y(g0.b(j.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), g0.h(new y(g0.b(j.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), g0.h(new y(g0.b(j.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"))};
    public static final b a = new b(null);

    /* JADX INFO: compiled from: ReflectionTypes.kt */
    private static final class a {
        private final int a;

        public a(int i2) {
            this.a = i2;
        }

        public final e a(j jVar, KProperty<?> kProperty) {
            m.f(jVar, "types");
            m.f(kProperty, "property");
            return jVar.b(kotlin.reflect.y.internal.j0.m.u.a.a(kProperty.getM()), this.a);
        }
    }

    /* JADX INFO: compiled from: ReflectionTypes.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        public final e0 a(kotlin.p002reflect.jvm.internal.impl.descriptors.g0 g0Var) {
            m.f(g0Var, "module");
            e eVarA = x.a(g0Var, k.a.s0);
            if (eVarA == null) {
                return null;
            }
            a1 a1VarH = a1.f24676g.h();
            List<e1> parameters = eVarA.h().getParameters();
            m.e(parameters, "kPropertyClass.typeConstructor.parameters");
            Object objS0 = s.s0(parameters);
            m.e(objS0, "kPropertyClass.typeConstructor.parameters.single()");
            return f0.g(a1VarH, eVarA, t.e(new s0((e1) objS0)));
        }
    }

    /* JADX INFO: compiled from: ReflectionTypes.kt */
    static final class c extends Lambda implements Function0<h> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.p002reflect.jvm.internal.impl.descriptors.g0 f23190f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(kotlin.p002reflect.jvm.internal.impl.descriptors.g0 g0Var) {
            super(0);
            this.f23190f = g0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final h invoke() {
            return this.f23190f.N(k.o).q();
        }
    }

    public j(kotlin.p002reflect.jvm.internal.impl.descriptors.g0 g0Var, j0 j0Var) {
        m.f(g0Var, "module");
        m.f(j0Var, "notFoundClasses");
        this.f23181c = j0Var;
        this.f23182d = i.a(LazyThreadSafetyMode.PUBLICATION, new c(g0Var));
        this.f23183e = new a(1);
        this.f23184f = new a(1);
        this.f23185g = new a(1);
        this.f23186h = new a(2);
        this.f23187i = new a(3);
        this.f23188j = new a(1);
        this.f23189k = new a(2);
        this.l = new a(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e b(String str, int i2) {
        f fVarX = f.x(str);
        m.e(fVarX, "identifier(className)");
        kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarF = d().f(fVarX, d.FROM_REFLECTION);
        e eVar = hVarF instanceof e ? (e) hVarF : null;
        return eVar == null ? this.f23181c.d(new kotlin.reflect.y.internal.j0.f.b(k.o, fVarX), t.e(Integer.valueOf(i2))) : eVar;
    }

    private final h d() {
        return (h) this.f23182d.getValue();
    }

    public final e c() {
        return this.f23183e.a(this, f23180b[0]);
    }
}
