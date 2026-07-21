package kotlin.reflect.y.internal.j0.d.b;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.i.u.e;

/* JADX INFO: compiled from: methodSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l {
    public static final b a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d f23802b = new d(e.BOOLEAN);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d f23803c = new d(e.CHAR);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final d f23804d = new d(e.BYTE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final d f23805e = new d(e.SHORT);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final d f23806f = new d(e.INT);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final d f23807g = new d(e.FLOAT);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final d f23808h = new d(e.LONG);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final d f23809i = new d(e.DOUBLE);

    /* JADX INFO: compiled from: methodSignatureMapping.kt */
    public static final class a extends l {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final l f23810j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar) {
            super(null);
            m.f(lVar, "elementType");
            this.f23810j = lVar;
        }

        public final l i() {
            return this.f23810j;
        }
    }

    /* JADX INFO: compiled from: methodSignatureMapping.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        public final d a() {
            return l.f23802b;
        }

        public final d b() {
            return l.f23804d;
        }

        public final d c() {
            return l.f23803c;
        }

        public final d d() {
            return l.f23809i;
        }

        public final d e() {
            return l.f23807g;
        }

        public final d f() {
            return l.f23806f;
        }

        public final d g() {
            return l.f23808h;
        }

        public final d h() {
            return l.f23805e;
        }
    }

    /* JADX INFO: compiled from: methodSignatureMapping.kt */
    public static final class c extends l {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final String f23811j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(null);
            m.f(str, "internalName");
            this.f23811j = str;
        }

        public final String i() {
            return this.f23811j;
        }
    }

    /* JADX INFO: compiled from: methodSignatureMapping.kt */
    public static final class d extends l {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final e f23812j;

        public d(e eVar) {
            super(null);
            this.f23812j = eVar;
        }

        public final e i() {
            return this.f23812j;
        }
    }

    private l() {
    }

    public /* synthetic */ l(g gVar) {
        this();
    }

    public String toString() {
        return n.a.a(this);
    }
}
