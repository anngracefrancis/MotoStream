package kotlin.reflect.y.internal.j0.d.a;

import java.util.Arrays;
import java.util.Set;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.n0.g;
import kotlin.reflect.y.internal.j0.d.a.n0.u;
import kotlin.reflect.y.internal.j0.f.c;

/* JADX INFO: compiled from: JavaClassFinder.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface o {

    /* JADX INFO: compiled from: JavaClassFinder.kt */
    public static final class a {
        public static /* synthetic */ u a(o oVar, c cVar, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findPackage");
            }
            if ((i2 & 2) != 0) {
                z = true;
            }
            return oVar.c(cVar, z);
        }
    }

    g a(b bVar);

    Set<String> b(c cVar);

    u c(c cVar, boolean z);

    /* JADX INFO: compiled from: JavaClassFinder.kt */
    public static final class b {
        private final kotlin.reflect.y.internal.j0.f.b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f23600b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final g f23601c;

        public b(kotlin.reflect.y.internal.j0.f.b bVar, byte[] bArr, g gVar) {
            m.f(bVar, "classId");
            this.a = bVar;
            this.f23600b = bArr;
            this.f23601c = gVar;
        }

        public final kotlin.reflect.y.internal.j0.f.b a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return m.a(this.a, bVar.a) && m.a(this.f23600b, bVar.f23600b) && m.a(this.f23601c, bVar.f23601c);
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            byte[] bArr = this.f23600b;
            int iHashCode2 = (iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
            g gVar = this.f23601c;
            return iHashCode2 + (gVar != null ? gVar.hashCode() : 0);
        }

        public String toString() {
            return "Request(classId=" + this.a + ", previouslyFoundClassFileContent=" + Arrays.toString(this.f23600b) + ", outerClass=" + this.f23601c + ')';
        }

        public /* synthetic */ b(kotlin.reflect.y.internal.j0.f.b bVar, byte[] bArr, g gVar, int i2, kotlin.jvm.internal.g gVar2) {
            this(bVar, (i2 & 2) != 0 ? null : bArr, (i2 & 4) != 0 ? null : gVar);
        }
    }
}
