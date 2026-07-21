package kotlin.reflect.y.internal.j0.d.a;

import kotlin.KotlinVersion;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: JavaNullabilityAnnotationsStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class v {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final v f23691b = new v(f0.STRICT, null, null, 6, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f0 f23692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final KotlinVersion f23693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f0 f23694e;

    /* JADX INFO: compiled from: JavaNullabilityAnnotationsStatus.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final v a() {
            return v.f23691b;
        }
    }

    public v(f0 f0Var, KotlinVersion kotlinVersion, f0 f0Var2) {
        m.f(f0Var, "reportLevelBefore");
        m.f(f0Var2, "reportLevelAfter");
        this.f23692c = f0Var;
        this.f23693d = kotlinVersion;
        this.f23694e = f0Var2;
    }

    public final f0 b() {
        return this.f23694e;
    }

    public final f0 c() {
        return this.f23692c;
    }

    public final KotlinVersion d() {
        return this.f23693d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f23692c == vVar.f23692c && m.a(this.f23693d, vVar.f23693d) && this.f23694e == vVar.f23694e;
    }

    public int hashCode() {
        int iHashCode = this.f23692c.hashCode() * 31;
        KotlinVersion kotlinVersion = this.f23693d;
        return ((iHashCode + (kotlinVersion == null ? 0 : kotlinVersion.getF22960k())) * 31) + this.f23694e.hashCode();
    }

    public String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.f23692c + ", sinceVersion=" + this.f23693d + ", reportLevelAfter=" + this.f23694e + ')';
    }

    public /* synthetic */ v(f0 f0Var, KotlinVersion kotlinVersion, f0 f0Var2, int i2, g gVar) {
        this(f0Var, (i2 & 2) != 0 ? new KotlinVersion(1, 0) : kotlinVersion, (i2 & 4) != 0 ? f0Var : f0Var2);
    }
}
