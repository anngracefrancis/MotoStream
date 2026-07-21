package io.sentry.android.core;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.UUID;

/* JADX INFO: compiled from: Installation.java */
/* JADX INFO: loaded from: classes2.dex */
final class a1 {
    static String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Charset f22091b = Charset.forName("UTF-8");

    public static synchronized String a(Context context) throws RuntimeException {
        if (a == null) {
            File file = new File(context.getFilesDir(), "INSTALLATION");
            try {
                if (!file.exists()) {
                    String strC = c(file);
                    a = strC;
                    return strC;
                }
                a = b(file);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
        return a;
    }

    static String b(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            byte[] bArr = new byte[(int) randomAccessFile.length()];
            randomAccessFile.readFully(bArr);
            String str = new String(bArr, f22091b);
            randomAccessFile.close();
            return str;
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    static String c(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            String string = UUID.randomUUID().toString();
            fileOutputStream.write(string.getBytes(f22091b));
            fileOutputStream.flush();
            fileOutputStream.close();
            return string;
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }
}
