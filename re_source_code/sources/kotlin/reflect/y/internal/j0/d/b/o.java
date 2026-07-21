package kotlin.reflect.y.internal.j0.d.b;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.j.b.u;

/* JADX INFO: compiled from: KotlinClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface o extends u {

    /* JADX INFO: compiled from: KotlinClassFinder.kt */
    public static abstract class a {

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.d.b.o$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: KotlinClassFinder.kt */
        public static final class C0351a extends a {
            private final byte[] a;

            public final byte[] b() {
                return this.a;
            }
        }

        /* JADX INFO: compiled from: KotlinClassFinder.kt */
        public static final class b extends a {
            private final q a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final byte[] f23813b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(q qVar, byte[] bArr) {
                super(null);
                m.f(qVar, "kotlinJvmBinaryClass");
                this.a = qVar;
                this.f23813b = bArr;
            }

            public final q b() {
                return this.a;
            }

            public /* synthetic */ b(q qVar, byte[] bArr, int i2, g gVar) {
                this(qVar, (i2 & 2) != 0 ? null : bArr);
            }
        }

        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final q a() {
            b bVar = this instanceof b ? (b) this : null;
            if (bVar != null) {
                return bVar.b();
            }
            return null;
        }
    }

    a a(kotlin.reflect.y.internal.j0.d.a.n0.g gVar);

    a c(b bVar);
}
