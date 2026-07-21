package io.sentry.cache;

import io.sentry.l2;
import io.sentry.s4;
import io.sentry.x4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: CacheUtils.java */
/* JADX INFO: loaded from: classes2.dex */
final class p {
    private static final Charset a = Charset.forName("UTF-8");

    static void a(x4 x4Var, String str, String str2) {
        File fileB = b(x4Var, str);
        if (fileB == null) {
            x4Var.getLogger().c(s4.INFO, "Cache dir is not set, cannot delete from scope cache", new Object[0]);
            return;
        }
        File file = new File(fileB, str2);
        if (file.exists()) {
            x4Var.getLogger().c(s4.DEBUG, "Deleting %s from scope cache", str2);
            if (file.delete()) {
                return;
            }
            x4Var.getLogger().c(s4.ERROR, "Failed to delete: %s", file.getAbsolutePath());
        }
    }

    private static File b(x4 x4Var, String str) {
        String cacheDirPath = x4Var.getCacheDirPath();
        if (cacheDirPath == null) {
            return null;
        }
        File file = new File(cacheDirPath, str);
        file.mkdirs();
        return file;
    }

    static <T, R> T c(x4 x4Var, String str, String str2, Class<T> cls, l2<R> l2Var) {
        File fileB = b(x4Var, str);
        if (fileB == null) {
            x4Var.getLogger().c(s4.INFO, "Cache dir is not set, cannot read from scope cache", new Object[0]);
            return null;
        }
        File file = new File(fileB, str2);
        if (file.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), a));
                try {
                    if (l2Var == null) {
                        T t = (T) x4Var.getSerializer().c(bufferedReader, cls);
                        bufferedReader.close();
                        return t;
                    }
                    T t2 = (T) x4Var.getSerializer().e(bufferedReader, cls, l2Var);
                    bufferedReader.close();
                    return t2;
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                x4Var.getLogger().a(s4.ERROR, th2, "Error reading entity from scope cache: %s", str2);
            }
        } else {
            x4Var.getLogger().c(s4.DEBUG, "No entry stored for %s", str2);
        }
        return null;
    }

    static <T> void d(x4 x4Var, T t, String str, String str2) {
        File fileB = b(x4Var, str);
        if (fileB == null) {
            x4Var.getLogger().c(s4.INFO, "Cache dir is not set, cannot store in scope cache", new Object[0]);
            return;
        }
        File file = new File(fileB, str2);
        if (file.exists()) {
            x4Var.getLogger().c(s4.DEBUG, "Overwriting %s in scope cache", str2);
            if (!file.delete()) {
                x4Var.getLogger().c(s4.ERROR, "Failed to delete: %s", file.getAbsolutePath());
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, a));
                try {
                    x4Var.getSerializer().a(t, bufferedWriter);
                    bufferedWriter.close();
                    fileOutputStream.close();
                } catch (Throwable th) {
                    try {
                        bufferedWriter.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    fileOutputStream.close();
                } catch (Throwable unused2) {
                }
                throw th2;
            }
        } catch (Throwable th3) {
            x4Var.getLogger().a(s4.ERROR, th3, "Error persisting entity: %s", str2);
        }
    }
}
