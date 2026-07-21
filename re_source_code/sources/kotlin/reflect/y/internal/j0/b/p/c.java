package kotlin.reflect.y.internal.j0.b.p;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.text.u;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'i' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: FunctionClassKind.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f23232f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f23233g = new c("Function", 0, k.r, "Function", false, false);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f23234h = new c("SuspendFunction", 1, k.f23199j, "SuspendFunction", true, false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f23235i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f23236j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ c[] f23237k;
    private final kotlin.reflect.y.internal.j0.f.c l;
    private final String m;
    private final boolean n;
    private final boolean o;

    /* JADX INFO: compiled from: FunctionClassKind.kt */
    public static final class a {

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.b.p.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FunctionClassKind.kt */
        public static final class C0323a {
            private final c a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f23238b;

            public C0323a(c cVar, int i2) {
                m.f(cVar, "kind");
                this.a = cVar;
                this.f23238b = i2;
            }

            public final c a() {
                return this.a;
            }

            public final int b() {
                return this.f23238b;
            }

            public final c c() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0323a)) {
                    return false;
                }
                C0323a c0323a = (C0323a) obj;
                return this.a == c0323a.a && this.f23238b == c0323a.f23238b;
            }

            public int hashCode() {
                return (this.a.hashCode() * 31) + this.f23238b;
            }

            public String toString() {
                return "KindWithArity(kind=" + this.a + ", arity=" + this.f23238b + ')';
            }
        }

        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        private final Integer d(String str) {
            if (str.length() == 0) {
                return null;
            }
            int length = str.length();
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                int iCharAt = str.charAt(i3) - '0';
                if (!(iCharAt >= 0 && iCharAt < 10)) {
                    return null;
                }
                i2 = (i2 * 10) + iCharAt;
            }
            return Integer.valueOf(i2);
        }

        public final c a(kotlin.reflect.y.internal.j0.f.c cVar, String str) {
            m.f(cVar, "packageFqName");
            m.f(str, "className");
            for (c cVar2 : c.values()) {
                if (m.a(cVar2.q(), cVar) && u.E(str, cVar2.k(), false, 2, null)) {
                    return cVar2;
                }
            }
            return null;
        }

        public final c b(String str, kotlin.reflect.y.internal.j0.f.c cVar) {
            m.f(str, "className");
            m.f(cVar, "packageFqName");
            C0323a c0323aC = c(str, cVar);
            if (c0323aC != null) {
                return c0323aC.c();
            }
            return null;
        }

        public final C0323a c(String str, kotlin.reflect.y.internal.j0.f.c cVar) {
            m.f(str, "className");
            m.f(cVar, "packageFqName");
            c cVarA = a(cVar, str);
            if (cVarA == null) {
                return null;
            }
            String strSubstring = str.substring(cVarA.k().length());
            m.e(strSubstring, "this as java.lang.String).substring(startIndex)");
            Integer numD = d(strSubstring);
            if (numD != null) {
                return new C0323a(cVarA, numD.intValue());
            }
            return null;
        }
    }

    static {
        kotlin.reflect.y.internal.j0.f.c cVar = k.o;
        f23235i = new c("KFunction", 2, cVar, "KFunction", false, true);
        f23236j = new c("KSuspendFunction", 3, cVar, "KSuspendFunction", true, true);
        f23237k = g();
        f23232f = new a(null);
    }

    private c(String str, int i2, kotlin.reflect.y.internal.j0.f.c cVar, String str2, boolean z, boolean z2) {
        super(str, i2);
        this.l = cVar;
        this.m = str2;
        this.n = z;
        this.o = z2;
    }

    private static final /* synthetic */ c[] g() {
        return new c[]{f23233g, f23234h, f23235i, f23236j};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f23237k.clone();
    }

    public final String k() {
        return this.m;
    }

    public final kotlin.reflect.y.internal.j0.f.c q() {
        return this.l;
    }

    public final f u(int i2) {
        f fVarX = f.x(this.m + i2);
        m.e(fVarX, "identifier(\"$classNamePrefix$arity\")");
        return fVarX;
    }
}
