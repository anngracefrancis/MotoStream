package kotlin.reflect.y.internal.j0.d.a.j0;

import java.util.Collections;
import java.util.List;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.y.internal.j0.d.a.n0.r;
import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: SignaturePropagator.java */
/* JADX INFO: loaded from: classes2.dex */
public interface j {
    public static final j a = new a();

    /* JADX INFO: compiled from: SignaturePropagator.java */
    static class a implements j {
        a() {
        }

        private static /* synthetic */ void c(int i2) {
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = "owner";
                    break;
                case 2:
                    objArr[0] = "returnType";
                    break;
                case 3:
                    objArr[0] = "valueParameters";
                    break;
                case 4:
                    objArr[0] = "typeParameters";
                    break;
                case 5:
                    objArr[0] = "descriptor";
                    break;
                case 6:
                    objArr[0] = "signatureErrors";
                    break;
                default:
                    objArr[0] = "method";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1";
            if (i2 == 5 || i2 == 6) {
                objArr[2] = "reportSignatureErrors";
            } else {
                objArr[2] = "resolvePropagatedSignature";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.y.internal.j0.d.a.j0.j
        public b a(r rVar, e eVar, e0 e0Var, e0 e0Var2, List<i1> list, List<e1> list2) {
            if (rVar == null) {
                c(0);
            }
            if (eVar == null) {
                c(1);
            }
            if (e0Var == null) {
                c(2);
            }
            if (list == null) {
                c(3);
            }
            if (list2 == null) {
                c(4);
            }
            return new b(e0Var, e0Var2, list, list2, Collections.emptyList(), false);
        }

        @Override // kotlin.reflect.y.internal.j0.d.a.j0.j
        public void b(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar, List<String> list) {
            if (bVar == null) {
                c(5);
            }
            if (list == null) {
                c(6);
            }
            throw new UnsupportedOperationException("Should not be called");
        }
    }

    /* JADX INFO: compiled from: SignaturePropagator.java */
    public static class b {
        private final e0 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e0 f23429b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<i1> f23430c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<e1> f23431d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<String> f23432e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f23433f;

        public b(e0 e0Var, e0 e0Var2, List<i1> list, List<e1> list2, List<String> list3, boolean z) {
            if (e0Var == null) {
                a(0);
            }
            if (list == null) {
                a(1);
            }
            if (list2 == null) {
                a(2);
            }
            if (list3 == null) {
                a(3);
            }
            this.a = e0Var;
            this.f23429b = e0Var2;
            this.f23430c = list;
            this.f23431d = list2;
            this.f23432e = list3;
            this.f23433f = z;
        }

        private static /* synthetic */ void a(int i2) {
            String str = (i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7) ? 2 : 3];
            switch (i2) {
                case 1:
                    objArr[0] = "valueParameters";
                    break;
                case 2:
                    objArr[0] = "typeParameters";
                    break;
                case 3:
                    objArr[0] = "signatureErrors";
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
                    break;
                default:
                    objArr[0] = "returnType";
                    break;
            }
            if (i2 == 4) {
                objArr[1] = "getReturnType";
            } else if (i2 == 5) {
                objArr[1] = "getValueParameters";
            } else if (i2 == 6) {
                objArr[1] = "getTypeParameters";
            } else if (i2 != 7) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
            } else {
                objArr[1] = "getErrors";
            }
            if (i2 != 4 && i2 != 5 && i2 != 6 && i2 != 7) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i2 != 4 && i2 != 5 && i2 != 6 && i2 != 7) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        public List<String> b() {
            List<String> list = this.f23432e;
            if (list == null) {
                a(7);
            }
            return list;
        }

        public e0 c() {
            return this.f23429b;
        }

        public e0 d() {
            e0 e0Var = this.a;
            if (e0Var == null) {
                a(4);
            }
            return e0Var;
        }

        public List<e1> e() {
            List<e1> list = this.f23431d;
            if (list == null) {
                a(6);
            }
            return list;
        }

        public List<i1> f() {
            List<i1> list = this.f23430c;
            if (list == null) {
                a(5);
            }
            return list;
        }

        public boolean g() {
            return this.f23433f;
        }
    }

    b a(r rVar, e eVar, e0 e0Var, e0 e0Var2, List<i1> list, List<e1> list2);

    void b(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar, List<String> list);
}
