package kotlin.reflect.y.internal.j0.d.b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SignatureBuildingComponents.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x {
    public static final x a = new x();

    /* JADX INFO: compiled from: SignatureBuildingComponents.kt */
    static final class a extends Lambda implements Function1<String, CharSequence> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f23820f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(String str) {
            m.f(str, "it");
            return x.a.c(str);
        }
    }

    private x() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return 'L' + str + ';';
    }

    public final String[] b(String... strArr) {
        m.f(strArr, "signatures");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("<init>(" + str + ")V");
        }
        Object[] array = arrayList.toArray(new String[0]);
        m.d(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    public final Set<String> d(String str, String... strArr) {
        m.f(str, "internalName");
        m.f(strArr, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str2 : strArr) {
            linkedHashSet.add(str + '.' + str2);
        }
        return linkedHashSet;
    }

    public final Set<String> e(String str, String... strArr) {
        m.f(str, "name");
        m.f(strArr, "signatures");
        return d(h(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final Set<String> f(String str, String... strArr) {
        m.f(str, "name");
        m.f(strArr, "signatures");
        return d(i(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final String g(String str) {
        m.f(str, "name");
        return "java/util/function/" + str;
    }

    public final String h(String str) {
        m.f(str, "name");
        return "java/lang/" + str;
    }

    public final String i(String str) {
        m.f(str, "name");
        return "java/util/" + str;
    }

    public final String j(String str, List<String> list, String str2) {
        m.f(str, "name");
        m.f(list, "parameters");
        m.f(str2, "ret");
        return str + '(' + c0.e0(list, HttpUrl.FRAGMENT_ENCODE_SET, null, null, 0, null, a.f23820f, 30, null) + ')' + c(str2);
    }

    public final String k(String str, String str2) {
        m.f(str, "internalName");
        m.f(str2, "jvmDescriptor");
        return str + '.' + str2;
    }
}
