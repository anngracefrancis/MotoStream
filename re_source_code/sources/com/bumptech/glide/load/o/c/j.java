package com.bumptech.glide.load.o.c;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: DefaultImageHeaderParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class j implements ImageHeaderParser {
    static final byte[] a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f9359b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
    private static final class a implements c {
        private final ByteBuffer a;

        a(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.o.c.j.c
        public int a() {
            return ((d() << 8) & 65280) | (d() & 255);
        }

        @Override // com.bumptech.glide.load.o.c.j.c
        public int b(byte[] bArr, int i2) {
            int iMin = Math.min(i2, this.a.remaining());
            if (iMin == 0) {
                return -1;
            }
            this.a.get(bArr, 0, iMin);
            return iMin;
        }

        @Override // com.bumptech.glide.load.o.c.j.c
        public short c() {
            return (short) (d() & 255);
        }

        @Override // com.bumptech.glide.load.o.c.j.c
        public int d() {
            if (this.a.remaining() < 1) {
                return -1;
            }
            return this.a.get();
        }

        @Override // com.bumptech.glide.load.o.c.j.c
        public long skip(long j2) {
            int iMin = (int) Math.min(this.a.remaining(), j2);
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(byteBuffer.position() + iMin);
            return iMin;
        }
    }

    /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
    private static final class b {
        private final ByteBuffer a;

        b(byte[] bArr, int i2) {
            this.a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i2);
        }

        private boolean c(int i2, int i3) {
            return this.a.remaining() - i2 >= i3;
        }

        short a(int i2) {
            if (c(i2, 2)) {
                return this.a.getShort(i2);
            }
            return (short) -1;
        }

        int b(int i2) {
            if (c(i2, 4)) {
                return this.a.getInt(i2);
            }
            return -1;
        }

        int d() {
            return this.a.remaining();
        }

        void e(ByteOrder byteOrder) {
            this.a.order(byteOrder);
        }
    }

    /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
    private interface c {
        int a() throws IOException;

        int b(byte[] bArr, int i2) throws IOException;

        short c() throws IOException;

        int d() throws IOException;

        long skip(long j2) throws IOException;
    }

    /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
    private static final class d implements c {
        private final InputStream a;

        d(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // com.bumptech.glide.load.o.c.j.c
        public int a() throws IOException {
            return ((this.a.read() << 8) & 65280) | (this.a.read() & 255);
        }

        @Override // com.bumptech.glide.load.o.c.j.c
        public int b(byte[] bArr, int i2) throws IOException {
            int i3 = i2;
            while (i3 > 0) {
                int i4 = this.a.read(bArr, i2 - i3, i3);
                if (i4 == -1) {
                    break;
                }
                i3 -= i4;
            }
            return i2 - i3;
        }

        @Override // com.bumptech.glide.load.o.c.j.c
        public short c() throws IOException {
            return (short) (this.a.read() & 255);
        }

        @Override // com.bumptech.glide.load.o.c.j.c
        public int d() throws IOException {
            return this.a.read();
        }

        @Override // com.bumptech.glide.load.o.c.j.c
        public long skip(long j2) throws IOException {
            if (j2 < 0) {
                return 0L;
            }
            long j3 = j2;
            while (j3 > 0) {
                long jSkip = this.a.skip(j3);
                if (jSkip <= 0) {
                    if (this.a.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j3 -= jSkip;
            }
            return j2 - j3;
        }
    }

    private static int d(int i2, int i3) {
        return i2 + 2 + (i3 * 12);
    }

    private int e(c cVar, com.bumptech.glide.load.engine.z.b bVar) throws IOException {
        int iA = cVar.a();
        if (!g(iA)) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + iA);
            }
            return -1;
        }
        int i2 = i(cVar);
        if (i2 == -1) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        byte[] bArr = (byte[]) bVar.e(i2, byte[].class);
        try {
            return k(cVar, bArr, i2);
        } finally {
            bVar.d(bArr);
        }
    }

    private ImageHeaderParser.ImageType f(c cVar) throws IOException {
        int iA = cVar.a();
        if (iA == 65496) {
            return ImageHeaderParser.ImageType.JPEG;
        }
        int iA2 = ((iA << 16) & (-65536)) | (cVar.a() & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        if (iA2 == -1991225785) {
            cVar.skip(21L);
            return cVar.d() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
        }
        if ((iA2 >> 8) == 4671814) {
            return ImageHeaderParser.ImageType.GIF;
        }
        if (iA2 != 1380533830) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        cVar.skip(4L);
        if ((((cVar.a() << 16) & (-65536)) | (cVar.a() & Settings.DEFAULT_INITIAL_WINDOW_SIZE)) != 1464156752) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int iA3 = ((cVar.a() << 16) & (-65536)) | (cVar.a() & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        if ((iA3 & (-256)) != 1448097792) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int i2 = iA3 & 255;
        if (i2 == 88) {
            cVar.skip(4L);
            return (cVar.d() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
        }
        if (i2 != 76) {
            return ImageHeaderParser.ImageType.WEBP;
        }
        cVar.skip(4L);
        return (cVar.d() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
    }

    private static boolean g(int i2) {
        return (i2 & 65496) == 65496 || i2 == 19789 || i2 == 18761;
    }

    private boolean h(byte[] bArr, int i2) {
        boolean z = bArr != null && i2 > a.length;
        if (z) {
            int i3 = 0;
            while (true) {
                byte[] bArr2 = a;
                if (i3 >= bArr2.length) {
                    break;
                }
                if (bArr[i3] != bArr2[i3]) {
                    return false;
                }
                i3++;
            }
        }
        return z;
    }

    private int i(c cVar) throws IOException {
        short sC;
        int iA;
        long j2;
        long jSkip;
        do {
            short sC2 = cVar.c();
            if (sC2 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) sC2));
                }
                return -1;
            }
            sC = cVar.c();
            if (sC == 218) {
                return -1;
            }
            if (sC == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            iA = cVar.a() - 2;
            if (sC == 225) {
                return iA;
            }
            j2 = iA;
            jSkip = cVar.skip(j2);
        } while (jSkip == j2);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) sC) + ", wanted to skip: " + iA + ", but actually skipped: " + jSkip);
        }
        return -1;
    }

    private static int j(b bVar) {
        ByteOrder byteOrder;
        short sA = bVar.a(6);
        if (sA != 18761) {
            if (sA != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) sA));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        bVar.e(byteOrder);
        int iB = bVar.b(10) + 6;
        short sA2 = bVar.a(iB);
        for (int i2 = 0; i2 < sA2; i2++) {
            int iD = d(iB, i2);
            short sA3 = bVar.a(iD);
            if (sA3 == 274) {
                short sA4 = bVar.a(iD + 2);
                if (sA4 >= 1 && sA4 <= 12) {
                    int iB2 = bVar.b(iD + 4);
                    if (iB2 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i2 + " tagType=" + ((int) sA3) + " formatCode=" + ((int) sA4) + " componentCount=" + iB2);
                        }
                        int i3 = iB2 + f9359b[sA4];
                        if (i3 <= 4) {
                            int i4 = iD + 8;
                            if (i4 >= 0 && i4 <= bVar.d()) {
                                if (i3 >= 0 && i3 + i4 <= bVar.d()) {
                                    return bVar.a(i4);
                                }
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) sA3));
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i4 + " tagType=" + ((int) sA3));
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) sA4));
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) sA4));
                }
            }
        }
        return -1;
    }

    private int k(c cVar, byte[] bArr, int i2) throws IOException {
        int iB = cVar.b(bArr, i2);
        if (iB == i2) {
            if (h(bArr, i2)) {
                return j(new b(bArr, i2));
            }
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i2 + ", actually read: " + iB);
        }
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) throws IOException {
        return f(new a((ByteBuffer) com.bumptech.glide.r.j.d(byteBuffer)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType b(InputStream inputStream) throws IOException {
        return f(new d((InputStream) com.bumptech.glide.r.j.d(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int c(InputStream inputStream, com.bumptech.glide.load.engine.z.b bVar) throws IOException {
        return e(new d((InputStream) com.bumptech.glide.r.j.d(inputStream)), (com.bumptech.glide.load.engine.z.b) com.bumptech.glide.r.j.d(bVar));
    }
}
