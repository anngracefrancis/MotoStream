package com.google.firebase.crashlytics.internal.n;

import com.google.firebase.crashlytics.internal.p.f0;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: BytesBackedNativeSessionFile.java */
/* JADX INFO: loaded from: classes2.dex */
class r implements l0 {
    private final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19076c;

    r(String str, String str2, byte[] bArr) {
        this.f19075b = str;
        this.f19076c = str2;
        this.a = bArr;
    }

    private byte[] d() {
        if (e()) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(this.a);
                    gZIPOutputStream.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (Throwable th) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable unused2) {
                }
                throw th2;
            }
        } catch (IOException unused3) {
            return null;
        }
    }

    private boolean e() {
        byte[] bArr = this.a;
        return bArr == null || bArr.length == 0;
    }

    @Override // com.google.firebase.crashlytics.internal.n.l0
    public String a() {
        return this.f19076c;
    }

    @Override // com.google.firebase.crashlytics.internal.n.l0
    public InputStream b() {
        if (e()) {
            return null;
        }
        return new ByteArrayInputStream(this.a);
    }

    @Override // com.google.firebase.crashlytics.internal.n.l0
    public f0.d.b c() {
        byte[] bArrD = d();
        if (bArrD == null) {
            return null;
        }
        return f0.d.b.a().b(bArrD).c(this.f19075b).a();
    }
}
