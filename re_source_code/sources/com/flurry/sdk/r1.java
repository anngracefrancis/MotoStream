package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class r1 implements v1<byte[]> {
    @Override // com.flurry.sdk.v1
    public final /* synthetic */ void a(OutputStream outputStream, byte[] bArr) throws IOException {
        byte[] bArr2 = bArr;
        if (outputStream == null || bArr2 == null) {
            return;
        }
        outputStream.write(bArr2, 0, bArr2.length);
    }

    @Override // com.flurry.sdk.v1
    public final /* synthetic */ byte[] b(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        c2.a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
