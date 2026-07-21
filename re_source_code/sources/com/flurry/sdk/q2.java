package com.flurry.sdk;

import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class q2 {

    public static class a implements FilenameFilter {
        final /* synthetic */ Pattern a;

        public a(Pattern pattern) {
            this.a = pattern;
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return this.a.matcher(str).matches();
        }
    }

    public static boolean a() {
        File file = new File(f());
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    public static boolean b(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }

    public static String c() {
        return f() + File.separator + "fCompleted";
    }

    public static boolean d(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static String e() {
        return f() + File.separator + "fInProgress";
    }

    private static String f() {
        return b2.a().toString() + File.separator + ".fstreaming";
    }
}
