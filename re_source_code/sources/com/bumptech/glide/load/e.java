package com.bumptech.glide.load;

import com.bumptech.glide.load.o.c.s;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: ImageHeaderParserUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static int a(List<ImageHeaderParser> list, InputStream inputStream, com.bumptech.glide.load.engine.z.b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new s(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                int iC = list.get(i2).c(inputStream, bVar);
                if (iC != -1) {
                    return iC;
                }
                inputStream.reset();
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }

    public static ImageHeaderParser.ImageType b(List<ImageHeaderParser> list, InputStream inputStream, com.bumptech.glide.load.engine.z.b bVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new s(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ImageHeaderParser.ImageType imageTypeB = list.get(i2).b(inputStream);
                if (imageTypeB != ImageHeaderParser.ImageType.UNKNOWN) {
                    return imageTypeB;
                }
                inputStream.reset();
            } finally {
                inputStream.reset();
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static ImageHeaderParser.ImageType c(List<ImageHeaderParser> list, ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageHeaderParser.ImageType imageTypeA = list.get(i2).a(byteBuffer);
            if (imageTypeA != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageTypeA;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
