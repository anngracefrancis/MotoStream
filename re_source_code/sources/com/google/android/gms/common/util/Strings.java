package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
@KeepForSdk
public class Strings {
    private static final Pattern a = Pattern.compile("\\$\\{(.*?)\\}");

    private Strings() {
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = false)
    @KeepForSdk
    public static boolean a(String str) {
        return str == null || str.trim().isEmpty();
    }
}
