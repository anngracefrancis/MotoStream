package kotlin.reflect.y.internal.j0.d.a;

import java.util.Collection;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.o0.h;
import kotlin.reflect.y.internal.j0.d.a.o0.i;

/* JADX INFO: compiled from: AnnotationQualifiersFqNames.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class q {
    private final i a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Collection<b> f23683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f23684c;

    /* JADX WARN: Multi-variable type inference failed */
    public q(i iVar, Collection<? extends b> collection, boolean z) {
        m.f(iVar, "nullabilityQualifier");
        m.f(collection, "qualifierApplicabilityTypes");
        this.a = iVar;
        this.f23683b = collection;
        this.f23684c = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ q b(q qVar, i iVar, Collection collection, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iVar = qVar.a;
        }
        if ((i2 & 2) != 0) {
            collection = qVar.f23683b;
        }
        if ((i2 & 4) != 0) {
            z = qVar.f23684c;
        }
        return qVar.a(iVar, collection, z);
    }

    public final q a(i iVar, Collection<? extends b> collection, boolean z) {
        m.f(iVar, "nullabilityQualifier");
        m.f(collection, "qualifierApplicabilityTypes");
        return new q(iVar, collection, z);
    }

    public final boolean c() {
        return this.f23684c;
    }

    public final i d() {
        return this.a;
    }

    public final Collection<b> e() {
        return this.f23683b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return m.a(this.a, qVar.a) && m.a(this.f23683b, qVar.f23683b) && this.f23684c == qVar.f23684c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.f23683b.hashCode()) * 31;
        boolean z = this.f23684c;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.a + ", qualifierApplicabilityTypes=" + this.f23683b + ", definitelyNotNull=" + this.f23684c + ')';
    }

    public /* synthetic */ q(i iVar, Collection collection, boolean z, int i2, g gVar) {
        this(iVar, collection, (i2 & 4) != 0 ? iVar.c() == h.NOT_NULL : z);
    }
}
