package com.bumptech.glide.load.o.g;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.u;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: StreamGifDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements com.bumptech.glide.load.j<InputStream, c> {
    private final List<ImageHeaderParser> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.j<ByteBuffer, c> f9441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.b f9442c;

    public j(List<ImageHeaderParser> list, com.bumptech.glide.load.j<ByteBuffer, c> jVar, com.bumptech.glide.load.engine.z.b bVar) {
        this.a = list;
        this.f9441b = jVar;
        this.f9442c = bVar;
    }

    private static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Http2.INITIAL_MAX_FRAME_SIZE);
        try {
            byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
        } catch (IOException e2) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e2);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public u<c> b(InputStream inputStream, int i2, int i3, com.bumptech.glide.load.i iVar) throws IOException {
        byte[] bArrE = e(inputStream);
        if (bArrE == null) {
            return null;
        }
        return this.f9441b.b(ByteBuffer.wrap(bArrE), i2, i3, iVar);
    }

    @Override // com.bumptech.glide.load.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(InputStream inputStream, com.bumptech.glide.load.i iVar) throws IOException {
        return !((Boolean) iVar.a(i.f9440b)).booleanValue() && com.bumptech.glide.load.e.b(this.a, inputStream, this.f9442c) == ImageHeaderParser.ImageType.GIF;
    }
}
