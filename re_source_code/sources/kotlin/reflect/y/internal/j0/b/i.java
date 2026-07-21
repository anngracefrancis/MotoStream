package kotlin.reflect.y.internal.j0.b;

import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.w0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 kotlin.f0.y.e.j0.b.i, still in use, count: 1, list:
  (r0v1 kotlin.f0.y.e.j0.b.i) from 0x006e: FILLED_NEW_ARRAY 
  (r0v1 kotlin.f0.y.e.j0.b.i)
  (r1v2 kotlin.f0.y.e.j0.b.i)
  (r4v2 kotlin.f0.y.e.j0.b.i)
  (r6v2 kotlin.f0.y.e.j0.b.i)
  (r8v2 kotlin.f0.y.e.j0.b.i)
  (r10v2 kotlin.f0.y.e.j0.b.i)
  (r12v2 kotlin.f0.y.e.j0.b.i)
 A[WRAPPED] elemType: kotlin.f0.y.e.j0.b.i
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: PrimitiveType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");


    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set<i> f23173g = w0.i(new i("Char"), new i("Byte"), new i("Short"), new i("Int"), new i("Float"), new i("Long"), new i("Double"));
    private final f q;
    private final f r;
    private final Lazy s;
    private final Lazy t;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f23172f = new a(null);

    /* JADX INFO: compiled from: PrimitiveType.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: PrimitiveType.kt */
    static final class b extends Lambda implements Function0<kotlin.reflect.y.internal.j0.f.c> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.y.internal.j0.f.c invoke() {
            kotlin.reflect.y.internal.j0.f.c cVarC = k.r.c(i.this.q());
            m.e(cVarC, "BUILT_INS_PACKAGE_FQ_NAME.child(arrayTypeName)");
            return cVarC;
        }
    }

    /* JADX INFO: compiled from: PrimitiveType.kt */
    static final class c extends Lambda implements Function0<kotlin.reflect.y.internal.j0.f.c> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.y.internal.j0.f.c invoke() {
            kotlin.reflect.y.internal.j0.f.c cVarC = k.r.c(i.this.v());
            m.e(cVarC, "BUILT_INS_PACKAGE_FQ_NAME.child(this.typeName)");
            return cVarC;
        }
    }

    static {
    }

    private i(String str) {
        super(str, i);
        f fVarX = f.x(str);
        m.e(fVarX, "identifier(typeName)");
        this.q = fVarX;
        f fVarX2 = f.x(str + "Array");
        m.e(fVarX2, "identifier(\"${typeName}Array\")");
        this.r = fVarX2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.s = kotlin.i.a(lazyThreadSafetyMode, new c());
        this.t = kotlin.i.a(lazyThreadSafetyMode, new b());
    }

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) p.clone();
    }

    public final kotlin.reflect.y.internal.j0.f.c k() {
        return (kotlin.reflect.y.internal.j0.f.c) this.t.getValue();
    }

    public final f q() {
        return this.r;
    }

    public final kotlin.reflect.y.internal.j0.f.c u() {
        return (kotlin.reflect.y.internal.j0.f.c) this.s.getValue();
    }

    public final f v() {
        return this.q;
    }
}
