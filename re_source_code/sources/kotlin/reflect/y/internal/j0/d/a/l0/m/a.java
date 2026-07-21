package kotlin.reflect.y.internal.j0.d.a.l0.m;

import java.util.Set;
import kotlin.collections.v0;
import kotlin.collections.x0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.y.internal.j0.d.a.j0.k;
import kotlin.reflect.y.internal.j0.l.m0;

/* JADX INFO: compiled from: JavaTypeResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private final k a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f23563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f23564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set<e1> f23565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final m0 f23566e;

    /* JADX WARN: Multi-variable type inference failed */
    public a(k kVar, b bVar, boolean z, Set<? extends e1> set, m0 m0Var) {
        m.f(kVar, "howThisTypeIsUsed");
        m.f(bVar, "flexibility");
        this.a = kVar;
        this.f23563b = bVar;
        this.f23564c = z;
        this.f23565d = set;
        this.f23566e = m0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ a b(a aVar, k kVar, b bVar, boolean z, Set set, m0 m0Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kVar = aVar.a;
        }
        if ((i2 & 2) != 0) {
            bVar = aVar.f23563b;
        }
        b bVar2 = bVar;
        if ((i2 & 4) != 0) {
            z = aVar.f23564c;
        }
        boolean z2 = z;
        if ((i2 & 8) != 0) {
            set = aVar.f23565d;
        }
        Set set2 = set;
        if ((i2 & 16) != 0) {
            m0Var = aVar.f23566e;
        }
        return aVar.a(kVar, bVar2, z2, set2, m0Var);
    }

    public final a a(k kVar, b bVar, boolean z, Set<? extends e1> set, m0 m0Var) {
        m.f(kVar, "howThisTypeIsUsed");
        m.f(bVar, "flexibility");
        return new a(kVar, bVar, z, set, m0Var);
    }

    public final m0 c() {
        return this.f23566e;
    }

    public final b d() {
        return this.f23563b;
    }

    public final k e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && this.f23563b == aVar.f23563b && this.f23564c == aVar.f23564c && m.a(this.f23565d, aVar.f23565d) && m.a(this.f23566e, aVar.f23566e);
    }

    public final Set<e1> f() {
        return this.f23565d;
    }

    public final boolean g() {
        return this.f23564c;
    }

    public final a h(m0 m0Var) {
        return b(this, null, null, false, null, m0Var, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.f23563b.hashCode()) * 31;
        boolean z = this.f23564c;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i2 = (iHashCode + r1) * 31;
        Set<e1> set = this.f23565d;
        int iHashCode2 = (i2 + (set == null ? 0 : set.hashCode())) * 31;
        m0 m0Var = this.f23566e;
        return iHashCode2 + (m0Var != null ? m0Var.hashCode() : 0);
    }

    public final a i(b bVar) {
        m.f(bVar, "flexibility");
        return b(this, null, bVar, false, null, null, 29, null);
    }

    public final a j(e1 e1Var) {
        m.f(e1Var, "typeParameter");
        Set<e1> set = this.f23565d;
        return b(this, null, null, false, set != null ? x0.m(set, e1Var) : v0.c(e1Var), null, 23, null);
    }

    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.a + ", flexibility=" + this.f23563b + ", isForAnnotationParameter=" + this.f23564c + ", visitedTypeParameters=" + this.f23565d + ", defaultType=" + this.f23566e + ')';
    }

    public /* synthetic */ a(k kVar, b bVar, boolean z, Set set, m0 m0Var, int i2, g gVar) {
        this(kVar, (i2 & 2) != 0 ? b.INFLEXIBLE : bVar, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? null : set, (i2 & 16) != 0 ? null : m0Var);
    }
}
