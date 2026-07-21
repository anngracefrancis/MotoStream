package kotlin.reflect.y.internal.j0.l.u1;

/* JADX INFO: compiled from: ErrorEntity.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum b {
    ERROR_CLASS("<Error class: %s>"),
    ERROR_FUNCTION("<Error function>"),
    ERROR_SCOPE("<Error scope>"),
    ERROR_MODULE("<Error module>"),
    ERROR_PROPERTY("<Error property>"),
    ERROR_TYPE("[Error type: %s]"),
    PARENT_OF_ERROR_SCOPE("<Fake parent for error lexical scope>");

    private final String n;

    b(String str) {
        this.n = str;
    }

    public final String k() {
        return this.n;
    }
}
