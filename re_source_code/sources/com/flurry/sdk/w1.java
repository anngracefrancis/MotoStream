package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class w1 implements v1<String> {
    @Override // com.flurry.sdk.v1
    public final /* synthetic */ void a(OutputStream outputStream, String str) throws IOException {
        String str2 = str;
        if (outputStream == null || str2 == null) {
            return;
        }
        byte[] bytes = str2.getBytes("utf-8");
        outputStream.write(bytes, 0, bytes.length);
    }

    @Override // com.flurry.sdk.v1
    public final /* synthetic */ String b(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        c2.a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toString();
    }
}
