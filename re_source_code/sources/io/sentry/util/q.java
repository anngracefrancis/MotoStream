package io.sentry.util;

import java.util.Arrays;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: Objects.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class q {
    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static <T> T c(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(str);
    }
}
