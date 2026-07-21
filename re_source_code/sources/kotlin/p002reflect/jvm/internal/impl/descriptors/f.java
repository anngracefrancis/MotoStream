package kotlin.p002reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: ClassKind.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum f {
    CLASS("class"),
    INTERFACE("interface"),
    ENUM_CLASS("enum class"),
    ENUM_ENTRY(null),
    ANNOTATION_CLASS("annotation class"),
    OBJECT("object");

    private final String m;

    f(String str) {
        this.m = str;
    }

    public final boolean k() {
        return this == OBJECT || this == ENUM_ENTRY;
    }
}
