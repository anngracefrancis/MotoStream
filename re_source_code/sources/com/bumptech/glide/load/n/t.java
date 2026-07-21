package com.bumptech.glide.load.n;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: StreamEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public class t implements com.bumptech.glide.load.d<InputStream> {
    private final com.bumptech.glide.load.engine.z.b a;

    public t(com.bumptech.glide.load.engine.z.b bVar) {
        this.a = bVar;
    }

    @Override // com.bumptech.glide.load.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(InputStream inputStream, File file, com.bumptech.glide.load.i iVar) throws Throwable {
        byte[] bArr = (byte[]) this.a.e(65536, byte[].class);
        boolean z = false;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    while (true) {
                        try {
                            int i2 = inputStream.read(bArr);
                            if (i2 == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, i2);
                        } catch (IOException e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            if (Log.isLoggable("StreamEncoder", 3)) {
                                Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            this.a.d(bArr);
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            this.a.d(bArr);
                            throw th;
                        }
                    }
                    fileOutputStream2.close();
                    z = true;
                    fileOutputStream2.close();
                } catch (IOException unused2) {
                }
            } catch (IOException e3) {
                e = e3;
            }
            this.a.d(bArr);
            return z;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
