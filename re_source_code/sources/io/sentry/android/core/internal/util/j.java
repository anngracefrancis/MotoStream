package io.sentry.android.core.internal.util;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: ClassUtil.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public class j {
    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        String canonicalName = obj.getClass().getCanonicalName();
        return canonicalName != null ? canonicalName : obj.getClass().getSimpleName();
    }
}
