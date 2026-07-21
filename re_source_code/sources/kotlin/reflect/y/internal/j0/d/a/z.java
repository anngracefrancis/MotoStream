package kotlin.reflect.y.internal.j0.d.a;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.m.u.a;
import kotlin.text.u;

/* JADX INFO: compiled from: JvmAbi.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class z {
    public static final z a = new z();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f23705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f23706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final b f23707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final b f23708e;

    static {
        c cVar = new c("kotlin.jvm.JvmField");
        f23705b = cVar;
        b bVarM = b.m(cVar);
        m.e(bVarM, "topLevel(JVM_FIELD_ANNOTATION_FQ_NAME)");
        f23706c = bVarM;
        b bVarM2 = b.m(new c("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
        m.e(bVarM2, "topLevel(FqName(\"kotlin.….ReflectionFactoryImpl\"))");
        f23707d = bVarM2;
        b bVarE = b.e("kotlin/jvm/internal/RepeatableContainer");
        m.e(bVarE, "fromString(\"kotlin/jvm/i…nal/RepeatableContainer\")");
        f23708e = bVarE;
    }

    private z() {
    }

    public static final String b(String str) {
        m.f(str, "propertyName");
        if (f(str)) {
            return str;
        }
        return "get" + a.a(str);
    }

    public static final boolean c(String str) {
        m.f(str, "name");
        return u.E(str, "get", false, 2, null) || u.E(str, "is", false, 2, null);
    }

    public static final boolean d(String str) {
        m.f(str, "name");
        return u.E(str, "set", false, 2, null);
    }

    public static final String e(String str) {
        String strA;
        m.f(str, "propertyName");
        StringBuilder sb = new StringBuilder();
        sb.append("set");
        if (f(str)) {
            strA = str.substring(2);
            m.e(strA, "this as java.lang.String).substring(startIndex)");
        } else {
            strA = a.a(str);
        }
        sb.append(strA);
        return sb.toString();
    }

    public static final boolean f(String str) {
        m.f(str, "name");
        if (!u.E(str, "is", false, 2, null) || str.length() == 2) {
            return false;
        }
        char cCharAt = str.charAt(2);
        return m.h(97, cCharAt) > 0 || m.h(cCharAt, 122) > 0;
    }

    public final b a() {
        return f23708e;
    }
}
