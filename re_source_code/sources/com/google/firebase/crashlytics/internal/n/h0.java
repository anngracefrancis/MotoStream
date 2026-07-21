package com.google.firebase.crashlytics.internal.n;

import com.google.firebase.crashlytics.internal.p.f0;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: FileBackedNativeSessionFile.java */
/* JADX INFO: loaded from: classes2.dex */
class h0 implements l0 {
    private final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19045c;

    h0(String str, String str2, File file) {
        this.f19044b = str;
        this.f19045c = str2;
        this.a = file;
    }

    private byte[] d() {
        byte[] bArr = new byte[8192];
        try {
            InputStream inputStreamB = b();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    if (inputStreamB == null) {
                        gZIPOutputStream.close();
                        byteArrayOutputStream.close();
                        if (inputStreamB != null) {
                            inputStreamB.close();
                        }
                        return null;
                    }
                    while (true) {
                        try {
                            int i2 = inputStreamB.read(bArr);
                            if (i2 <= 0) {
                                gZIPOutputStream.finish();
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                gZIPOutputStream.close();
                                byteArrayOutputStream.close();
                                inputStreamB.close();
                                return byteArray;
                            }
                            gZIPOutputStream.write(bArr, 0, i2);
                        } catch (Throwable th) {
                            try {
                                gZIPOutputStream.close();
                            } catch (Throwable unused) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused2) {
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                if (inputStreamB != null) {
                    try {
                        inputStreamB.close();
                    } catch (Throwable unused3) {
                    }
                }
                throw th3;
            }
        } catch (IOException unused4) {
            return null;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.n.l0
    public String a() {
        return this.f19045c;
    }

    @Override // com.google.firebase.crashlytics.internal.n.l0
    public InputStream b() {
        if (this.a.exists() && this.a.isFile()) {
            try {
                return new FileInputStream(this.a);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.n.l0
    public f0.d.b c() {
        byte[] bArrD = d();
        if (bArrD != null) {
            return f0.d.b.a().b(bArrD).c(this.f19044b).a();
        }
        return null;
    }
}
