package com.google.firebase.crashlytics.internal.n;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: NativeSessionFileGzipper.java */
/* JADX INFO: loaded from: classes2.dex */
class m0 {
    private static void a(InputStream inputStream, File file) throws Throwable {
        if (inputStream == null) {
            return;
        }
        byte[] bArr = new byte[8192];
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file));
            while (true) {
                try {
                    int i2 = inputStream.read(bArr);
                    if (i2 <= 0) {
                        gZIPOutputStream2.finish();
                        t.g(gZIPOutputStream2);
                        return;
                    }
                    gZIPOutputStream2.write(bArr, 0, i2);
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    t.g(gZIPOutputStream);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    static void b(File file, List<l0> list) {
        for (l0 l0Var : list) {
            InputStream inputStreamB = null;
            try {
                inputStreamB = l0Var.b();
                if (inputStreamB != null) {
                    a(inputStreamB, new File(file, l0Var.a()));
                }
            } catch (IOException unused) {
            } finally {
                t.g(null);
            }
        }
    }
}
