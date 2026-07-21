package kotlin.reflect.y.internal.j0.j.b;

import java.util.List;
import kotlin.p002reflect.jvm.internal.impl.descriptors.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;

/* JADX INFO: compiled from: ErrorReporter.java */
/* JADX INFO: loaded from: classes3.dex */
public interface r {
    public static final r a = new a();

    /* JADX INFO: compiled from: ErrorReporter.java */
    static class a implements r {
        a() {
        }

        private static /* synthetic */ void c(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "unresolvedSuperClasses";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1";
            if (i2 != 2) {
                objArr[2] = "reportIncompleteHierarchy";
            } else {
                objArr[2] = "reportCannotInferVisibility";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.y.internal.j0.j.b.r
        public void a(b bVar) {
            if (bVar == null) {
                c(2);
            }
        }

        @Override // kotlin.reflect.y.internal.j0.j.b.r
        public void b(e eVar, List<String> list) {
            if (eVar == null) {
                c(0);
            }
            if (list == null) {
                c(1);
            }
        }
    }

    void a(b bVar);

    void b(e eVar, List<String> list);
}
