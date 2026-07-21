package kotlin.p002reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: SourceElement.java */
/* JADX INFO: loaded from: classes2.dex */
public interface z0 {
    public static final z0 a = new a();

    /* JADX INFO: compiled from: SourceElement.java */
    static class a implements z0 {
        a() {
        }

        private static /* synthetic */ void d(int i2) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/SourceElement$1", "getContainingFile"));
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.z0
        public a1 a() {
            a1 a1Var = a1.a;
            if (a1Var == null) {
                d(0);
            }
            return a1Var;
        }

        public String toString() {
            return "NO_SOURCE";
        }
    }

    a1 a();
}
