package kotlin.reflect.y.internal.j0.d.a.j0;

import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.y.internal.j0.d.a.n0.l;
import kotlin.reflect.y.internal.j0.d.a.n0.n;
import kotlin.reflect.y.internal.j0.d.a.n0.q;
import kotlin.reflect.y.internal.j0.f.c;

/* JADX INFO: compiled from: JavaResolverCache.java */
/* JADX INFO: loaded from: classes2.dex */
public interface g {
    public static final g a = new a();

    /* JADX INFO: compiled from: JavaResolverCache.java */
    static class a implements g {
        a() {
        }

        private static /* synthetic */ void f(int i2) {
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = "member";
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                    objArr[0] = "descriptor";
                    break;
                case 3:
                    objArr[0] = "element";
                    break;
                case 5:
                    objArr[0] = "field";
                    break;
                case 7:
                    objArr[0] = "javaClass";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1";
            switch (i2) {
                case 1:
                case 2:
                    objArr[2] = "recordMethod";
                    break;
                case 3:
                case 4:
                    objArr[2] = "recordConstructor";
                    break;
                case 5:
                case 6:
                    objArr[2] = "recordField";
                    break;
                case 7:
                case 8:
                    objArr[2] = "recordClass";
                    break;
                default:
                    objArr[2] = "getClassResolvedFromSource";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.y.internal.j0.d.a.j0.g
        public e a(c cVar) {
            if (cVar != null) {
                return null;
            }
            f(0);
            return null;
        }

        @Override // kotlin.reflect.y.internal.j0.d.a.j0.g
        public void b(l lVar, kotlin.p002reflect.jvm.internal.impl.descriptors.l lVar2) {
            if (lVar == null) {
                f(3);
            }
            if (lVar2 == null) {
                f(4);
            }
        }

        @Override // kotlin.reflect.y.internal.j0.d.a.j0.g
        public void c(kotlin.reflect.y.internal.j0.d.a.n0.g gVar, e eVar) {
            if (gVar == null) {
                f(7);
            }
            if (eVar == null) {
                f(8);
            }
        }

        @Override // kotlin.reflect.y.internal.j0.d.a.j0.g
        public void d(n nVar, t0 t0Var) {
            if (nVar == null) {
                f(5);
            }
            if (t0Var == null) {
                f(6);
            }
        }

        @Override // kotlin.reflect.y.internal.j0.d.a.j0.g
        public void e(q qVar, y0 y0Var) {
            if (qVar == null) {
                f(1);
            }
            if (y0Var == null) {
                f(2);
            }
        }
    }

    e a(c cVar);

    void b(l lVar, kotlin.p002reflect.jvm.internal.impl.descriptors.l lVar2);

    void c(kotlin.reflect.y.internal.j0.d.a.n0.g gVar, e eVar);

    void d(n nVar, t0 t0Var);

    void e(q qVar, y0 y0Var);
}
