package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.security.DigestOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class o3 {
    public final synchronized byte[] a(u6 u6Var) {
        byte[] byteArray;
        DataOutputStream dataOutputStream;
        byteArray = null;
        try {
            d6 d6Var = new d6();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(640);
            DigestOutputStream digestOutputStream = new DigestOutputStream(byteArrayOutputStream, d6Var);
            dataOutputStream = new DataOutputStream(digestOutputStream);
            try {
                d1.c(3, "FrameSerializer", "Adding frame " + u6Var.a() + " payload " + u6Var.d());
                dataOutputStream.writeByte(u6Var.e());
                int i2 = u6Var.a().T;
                byte[] bArr = {(byte) (i2 >> 16), (byte) (i2 >> 8), (byte) (i2 >> 0), 0};
                for (int i3 = 0; i3 < 3; i3++) {
                    dataOutputStream.write(bArr[i3]);
                }
                dataOutputStream.writeLong(u6Var.c());
                dataOutputStream.writeLong(u6Var.b());
                byte[] bytes = u6Var.d().getBytes("UTF-8");
                dataOutputStream.writeInt(bytes.length);
                dataOutputStream.write(bytes);
                if (u6Var.g()) {
                    digestOutputStream.on(false);
                    dataOutputStream.writeInt(d6Var.a());
                }
                dataOutputStream.close();
                byteArray = byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                th = th;
                try {
                    d1.d(3, "FrameSerializer", "Error when generating report", th);
                } catch (Throwable th2) {
                    c2.f(dataOutputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
        }
        c2.f(dataOutputStream);
        return byteArray;
    }
}
