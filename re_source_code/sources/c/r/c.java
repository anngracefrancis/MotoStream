package c.r;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Stream;

/* JADX INFO: compiled from: ZipUtil.java */
/* JADX INFO: loaded from: classes.dex */
final class c {

    /* JADX INFO: compiled from: ZipUtil.java */
    static class a {
        long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f3410b;

        a() {
        }
    }

    static long a(RandomAccessFile randomAccessFile, a aVar) throws IOException {
        CRC32 crc32 = new CRC32();
        long j2 = aVar.f3410b;
        randomAccessFile.seek(aVar.a);
        int iMin = (int) Math.min(Http2Stream.EMIT_BUFFER_SIZE, j2);
        byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
        int i2 = randomAccessFile.read(bArr, 0, iMin);
        while (i2 != -1) {
            crc32.update(bArr, 0, i2);
            j2 -= (long) i2;
            if (j2 == 0) {
                break;
            }
            i2 = randomAccessFile.read(bArr, 0, (int) Math.min(Http2Stream.EMIT_BUFFER_SIZE, j2));
        }
        return crc32.getValue();
    }

    static a b(RandomAccessFile randomAccessFile) throws IOException {
        long length = randomAccessFile.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j2 = length - 65536;
        long j3 = j2 >= 0 ? j2 : 0L;
        int iReverseBytes = Integer.reverseBytes(101010256);
        do {
            randomAccessFile.seek(length);
            if (randomAccessFile.readInt() == iReverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                a aVar = new a();
                aVar.f3410b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                aVar.a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                return aVar;
            }
            length--;
        } while (length >= j3);
        throw new ZipException("End Of Central Directory signature not found");
    }

    static long c(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            return a(randomAccessFile, b(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }
}
