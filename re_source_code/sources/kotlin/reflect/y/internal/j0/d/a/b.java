package kotlin.reflect.y.internal.j0.d.a;

/* JADX INFO: compiled from: AnnotationQualifierApplicabilityType.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum b {
    METHOD_RETURN_TYPE("METHOD"),
    VALUE_PARAMETER("PARAMETER"),
    FIELD("FIELD"),
    TYPE_USE("TYPE_USE"),
    TYPE_PARAMETER_BOUNDS("TYPE_USE"),
    TYPE_PARAMETER("TYPE_PARAMETER");

    private final String m;

    b(String str) {
        this.m = str;
    }

    public final String k() {
        return this.m;
    }
}
