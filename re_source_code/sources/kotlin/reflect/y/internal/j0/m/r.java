package kotlin.reflect.y.internal.j0.m;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.m0;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r implements f {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<h, e0> f24927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f24928c;

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class a extends r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f24929d = new a();

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.m.r$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: modifierChecks.kt */
        static final class C0402a extends Lambda implements Function1<h, e0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final C0402a f24930f = new C0402a();

            C0402a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final e0 invoke(h hVar) {
                m.f(hVar, "$this$null");
                m0 m0VarN = hVar.n();
                m.e(m0VarN, "booleanType");
                return m0VarN;
            }
        }

        private a() {
            super("Boolean", C0402a.f24930f, null);
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class b extends r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f24931d = new b();

        /* JADX INFO: compiled from: modifierChecks.kt */
        static final class a extends Lambda implements Function1<h, e0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final a f24932f = new a();

            a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final e0 invoke(h hVar) {
                m.f(hVar, "$this$null");
                m0 m0VarD = hVar.D();
                m.e(m0VarD, "intType");
                return m0VarD;
            }
        }

        private b() {
            super("Int", a.f24932f, null);
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class c extends r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f24933d = new c();

        /* JADX INFO: compiled from: modifierChecks.kt */
        static final class a extends Lambda implements Function1<h, e0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final a f24934f = new a();

            a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final e0 invoke(h hVar) {
                m.f(hVar, "$this$null");
                m0 m0VarZ = hVar.Z();
                m.e(m0VarZ, "unitType");
                return m0VarZ;
            }
        }

        private c() {
            super("Unit", a.f24934f, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private r(String str, Function1<? super h, ? extends e0> function1) {
        this.a = str;
        this.f24927b = function1;
        this.f24928c = "must return " + str;
    }

    public /* synthetic */ r(String str, Function1 function1, g gVar) {
        this(str, function1);
    }

    @Override // kotlin.reflect.y.internal.j0.m.f
    public String a(y yVar) {
        return f.a.a(this, yVar);
    }

    @Override // kotlin.reflect.y.internal.j0.m.f
    public boolean b(y yVar) {
        m.f(yVar, "functionDescriptor");
        return m.a(yVar.getReturnType(), this.f24927b.invoke(kotlin.reflect.y.internal.j0.i.t.a.f(yVar)));
    }

    @Override // kotlin.reflect.y.internal.j0.m.f
    public String getDescription() {
        return this.f24928c;
    }
}
