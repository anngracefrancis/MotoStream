package com.bumptech.glide.load.o.c;

import android.media.ExifInterface;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ExifInterfaceImageHeaderParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class o implements ImageHeaderParser {
    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) throws IOException {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType b(InputStream inputStream) throws IOException {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int c(InputStream inputStream, com.bumptech.glide.load.engine.z.b bVar) throws IOException {
        int attributeInt = new ExifInterface(inputStream).getAttributeInt("Orientation", 1);
        if (attributeInt == 0) {
            return -1;
        }
        return attributeInt;
    }
}
