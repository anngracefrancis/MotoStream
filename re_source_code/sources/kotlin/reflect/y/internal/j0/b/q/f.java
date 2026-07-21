package kotlin.reflect.y.internal.j0.b.q;

import java.util.List;
import kotlin.collections.c0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.x;
import kotlin.reflect.KProperty;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.reflect.y.internal.j0.k.n;

/* JADX INFO: compiled from: JvmBuiltIns.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends h {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f23265h = {g0.h(new y(g0.b(f.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final a f23266i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Function0<b> f23267j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final i f23268k;

    /* JADX INFO: compiled from: JvmBuiltIns.kt */
    public enum a {
        FROM_DEPENDENCIES,
        FROM_CLASS_LOADER,
        FALLBACK
    }

    /* JADX INFO: compiled from: JvmBuiltIns.kt */
    public static final class b {
        private final kotlin.p002reflect.jvm.internal.impl.descriptors.g0 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f23273b;

        public b(kotlin.p002reflect.jvm.internal.impl.descriptors.g0 g0Var, boolean z) {
            m.f(g0Var, "ownerModuleDescriptor");
            this.a = g0Var;
            this.f23273b = z;
        }

        public final kotlin.p002reflect.jvm.internal.impl.descriptors.g0 a() {
            return this.a;
        }

        public final boolean b() {
            return this.f23273b;
        }
    }

    /* JADX INFO: compiled from: JvmBuiltIns.kt */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            iArr[a.FROM_DEPENDENCIES.ordinal()] = 1;
            iArr[a.FROM_CLASS_LOADER.ordinal()] = 2;
            iArr[a.FALLBACK.ordinal()] = 3;
            a = iArr;
        }
    }

    /* JADX INFO: compiled from: JvmBuiltIns.kt */
    static final class d extends Lambda implements Function0<g> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ n f23275g;

        /* JADX INFO: compiled from: JvmBuiltIns.kt */
        static final class a extends Lambda implements Function0<b> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ f f23276f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(f fVar) {
                super(0);
                this.f23276f = fVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final b invoke() {
                Function0 function0 = this.f23276f.f23267j;
                if (function0 == null) {
                    throw new AssertionError("JvmBuiltins instance has not been initialized properly");
                }
                b bVar = (b) function0.invoke();
                this.f23276f.f23267j = null;
                return bVar;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(n nVar) {
            super(0);
            this.f23275g = nVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g invoke() {
            x xVarR = f.this.r();
            m.e(xVarR, "builtInsModule");
            return new g(xVarR, this.f23275g, new a(f.this));
        }
    }

    /* JADX INFO: compiled from: JvmBuiltIns.kt */
    static final class e extends Lambda implements Function0<b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.p002reflect.jvm.internal.impl.descriptors.g0 f23277f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f23278g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(kotlin.p002reflect.jvm.internal.impl.descriptors.g0 g0Var, boolean z) {
            super(0);
            this.f23277f = g0Var;
            this.f23278g = z;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final b invoke() {
            return new b(this.f23277f, this.f23278g);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(n nVar, a aVar) {
        super(nVar);
        m.f(nVar, "storageManager");
        m.f(aVar, "kind");
        this.f23266i = aVar;
        this.f23268k = nVar.d(new d(nVar));
        int i2 = c.a[aVar.ordinal()];
        if (i2 == 2) {
            f(false);
        } else {
            if (i2 != 3) {
                return;
            }
            f(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.b.h
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public List<kotlin.p002reflect.jvm.internal.impl.descriptors.o1.b> v() {
        Iterable<kotlin.p002reflect.jvm.internal.impl.descriptors.o1.b> iterableV = super.v();
        m.e(iterableV, "super.getClassDescriptorFactories()");
        n nVarU = U();
        m.e(nVarU, "storageManager");
        x xVarR = r();
        m.e(xVarR, "builtInsModule");
        return c0.n0(iterableV, new kotlin.reflect.y.internal.j0.b.q.e(nVarU, xVarR, null, 4, null));
    }

    public final g H0() {
        return (g) kotlin.reflect.y.internal.j0.k.m.a(this.f23268k, this, f23265h[0]);
    }

    public final void I0(kotlin.p002reflect.jvm.internal.impl.descriptors.g0 g0Var, boolean z) {
        m.f(g0Var, "moduleDescriptor");
        J0(new e(g0Var, z));
    }

    public final void J0(Function0<b> function0) {
        m.f(function0, "computation");
        Function0<b> function1 = this.f23267j;
        this.f23267j = function0;
    }

    @Override // kotlin.reflect.y.internal.j0.b.h
    protected kotlin.p002reflect.jvm.internal.impl.descriptors.o1.c M() {
        return H0();
    }

    @Override // kotlin.reflect.y.internal.j0.b.h
    protected kotlin.p002reflect.jvm.internal.impl.descriptors.o1.a g() {
        return H0();
    }
}
