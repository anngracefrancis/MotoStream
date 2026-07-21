package kotlin.reflect.y.internal.j0.b.q;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.u;
import kotlin.collections.x0;
import kotlin.collections.z;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.d.b.x;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.d;
import kotlin.reflect.y.internal.j0.i.u.e;

/* JADX INFO: compiled from: JvmBuiltInsSignatures.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public static final i a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f23301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<String> f23302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<String> f23303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Set<String> f23304e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Set<String> f23305f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Set<String> f23306g;

    static {
        i iVar = new i();
        a = iVar;
        x xVar = x.a;
        f23301b = x0.m(xVar.f("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        f23302c = x0.l(x0.l(x0.l(x0.l(x0.l(x0.l(iVar.b(), xVar.f("List", "sort(Ljava/util/Comparator;)V")), xVar.e("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;")), xVar.e("Double", "isInfinite()Z", "isNaN()Z")), xVar.e("Float", "isInfinite()Z", "isNaN()Z")), xVar.e("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V")), xVar.e("CharSequence", "isEmpty()Z"));
        f23303d = x0.l(x0.l(x0.l(x0.l(x0.l(x0.l(xVar.e("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), xVar.f("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), xVar.e("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;")), xVar.e("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V")), xVar.f("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), xVar.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V")), xVar.f("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        f23304e = x0.l(x0.l(xVar.f("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), xVar.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V")), xVar.f("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        Set<String> setA = iVar.a();
        String[] strArrB = xVar.b("D");
        Set setL = x0.l(setA, xVar.e("Float", (String[]) Arrays.copyOf(strArrB, strArrB.length)));
        String[] strArrB2 = xVar.b("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        f23305f = x0.l(setL, xVar.e("String", (String[]) Arrays.copyOf(strArrB2, strArrB2.length)));
        String[] strArrB3 = xVar.b("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        f23306g = xVar.e("Throwable", (String[]) Arrays.copyOf(strArrB3, strArrB3.length));
    }

    private i() {
    }

    private final Set<String> a() {
        x xVar = x.a;
        e eVar = e.BYTE;
        List listM = u.m(e.BOOLEAN, eVar, e.DOUBLE, e.FLOAT, eVar, e.INT, e.LONG, e.SHORT);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listM.iterator();
        while (it.hasNext()) {
            String strK = ((e) it.next()).y().g().k();
            m.e(strK, "it.wrapperFqName.shortName().asString()");
            String[] strArrB = xVar.b("Ljava/lang/String;");
            z.z(linkedHashSet, xVar.e(strK, (String[]) Arrays.copyOf(strArrB, strArrB.length)));
        }
        return linkedHashSet;
    }

    private final Set<String> b() {
        x xVar = x.a;
        List<e> listM = u.m(e.BOOLEAN, e.CHAR);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (e eVar : listM) {
            String strK = eVar.y().g().k();
            m.e(strK, "it.wrapperFqName.shortName().asString()");
            z.z(linkedHashSet, xVar.e(strK, eVar.v() + "Value()" + eVar.u()));
        }
        return linkedHashSet;
    }

    public final Set<String> c() {
        return f23301b;
    }

    public final Set<String> d() {
        return f23305f;
    }

    public final Set<String> e() {
        return f23302c;
    }

    public final Set<String> f() {
        return f23304e;
    }

    public final Set<String> g() {
        return f23306g;
    }

    public final Set<String> h() {
        return f23303d;
    }

    public final boolean i(d dVar) {
        m.f(dVar, "fqName");
        return m.a(dVar, k.a.f23208i) || k.e(dVar);
    }

    public final boolean j(d dVar) {
        m.f(dVar, "fqName");
        if (i(dVar)) {
            return true;
        }
        b bVarN = c.a.n(dVar);
        if (bVarN == null) {
            return false;
        }
        try {
            return Serializable.class.isAssignableFrom(Class.forName(bVarN.b().b()));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
