package kotlin.p002reflect.jvm.internal.impl.descriptors.n1;

/* JADX INFO: compiled from: AnnotatedImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final g f25165f;

    public b(g gVar) {
        if (gVar == null) {
            v(0);
        }
        this.f25165f = gVar;
    }

    private static /* synthetic */ void v(int i2) {
        String str = i2 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 1 ? 3 : 2];
        if (i2 != 1) {
            objArr[0] = "annotations";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        }
        if (i2 != 1) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        } else {
            objArr[1] = "getAnnotations";
        }
        if (i2 != 1) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i2 == 1) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.a
    public g getAnnotations() {
        g gVar = this.f25165f;
        if (gVar == null) {
            v(1);
        }
        return gVar;
    }
}
