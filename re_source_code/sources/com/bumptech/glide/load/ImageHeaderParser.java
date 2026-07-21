package com.bumptech.glide.load;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface ImageHeaderParser {

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);


        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f9022f;

        ImageType(boolean z) {
            this.f9022f = z;
        }

        public boolean hasAlpha() {
            return this.f9022f;
        }
    }

    ImageType a(ByteBuffer byteBuffer) throws IOException;

    ImageType b(InputStream inputStream) throws IOException;

    int c(InputStream inputStream, com.bumptech.glide.load.engine.z.b bVar) throws IOException;
}
