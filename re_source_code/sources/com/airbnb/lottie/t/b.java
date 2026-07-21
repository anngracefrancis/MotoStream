package com.airbnb.lottie.t;

import android.content.Context;
import c.i.j.e;
import cm.aptoide.pt.utils.MultiDexHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: NetworkCache.java */
/* JADX INFO: loaded from: classes.dex */
class b {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8845b;

    b(Context context, String str) {
        this.a = context.getApplicationContext();
        this.f8845b = str;
    }

    private static String b(String str, a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", HttpUrl.FRAGMENT_ENCODE_SET));
        sb.append(z ? aVar.f8844i : aVar.g());
        return sb.toString();
    }

    private File c(String str) throws FileNotFoundException {
        File file = new File(this.a.getCacheDir(), b(str, a.Json, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(this.a.getCacheDir(), b(str, a.Zip, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    e<a, InputStream> a() {
        try {
            File fileC = c(this.f8845b);
            if (fileC == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileC);
            a aVar = fileC.getAbsolutePath().endsWith(MultiDexHelper.EXTRACTED_SUFFIX) ? a.Zip : a.Json;
            com.airbnb.lottie.c.b("Cache hit for " + this.f8845b + " at " + fileC.getAbsolutePath());
            return new e<>(aVar, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    void d(a aVar) {
        File file = new File(this.a.getCacheDir(), b(this.f8845b, aVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", HttpUrl.FRAGMENT_ENCODE_SET));
        boolean zRenameTo = file.renameTo(file2);
        com.airbnb.lottie.c.b("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        com.airbnb.lottie.c.d("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    File e(InputStream inputStream, a aVar) throws IOException {
        File file = new File(this.a.getCacheDir(), b(this.f8845b, aVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i2 = inputStream.read(bArr);
                    if (i2 == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        inputStream.close();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, i2);
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            inputStream.close();
            throw th2;
        }
    }
}
