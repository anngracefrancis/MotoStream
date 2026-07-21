package com.bumptech.glide.r;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ByteBufferUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final AtomicReference<byte[]> a = new AtomicReference<>();

    /* JADX INFO: compiled from: ByteBufferUtil.java */
    static final class b {
        final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f9541b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final byte[] f9542c;

        b(byte[] bArr, int i2, int i3) {
            this.f9542c = bArr;
            this.a = i2;
            this.f9541b = i3;
        }
    }

    public static ByteBuffer a(File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        FileChannel channel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            }
            if (length == 0) {
                throw new IOException("File unsuitable for memory mapping");
            }
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                channel = randomAccessFile.getChannel();
                MappedByteBuffer mappedByteBufferLoad = channel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                try {
                    channel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
                return mappedByteBufferLoad;
            } catch (Throwable th) {
                th = th;
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    private static b b(ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    public static byte[] c(ByteBuffer byteBuffer) {
        b bVarB = b(byteBuffer);
        if (bVarB != null && bVarB.a == 0 && bVarB.f9541b == bVarB.f9542c.length) {
            return byteBuffer.array();
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[byteBufferAsReadOnlyBuffer.limit()];
        byteBufferAsReadOnlyBuffer.position(0);
        byteBufferAsReadOnlyBuffer.get(bArr);
        return bArr;
    }

    public static void d(ByteBuffer byteBuffer, File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        FileChannel channel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                channel = randomAccessFile.getChannel();
                channel.write(byteBuffer);
                channel.force(false);
                channel.close();
                randomAccessFile.close();
                try {
                    channel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th) {
                th = th;
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    public static InputStream e(ByteBuffer byteBuffer) {
        return new C0142a(byteBuffer);
    }

    /* JADX INFO: renamed from: com.bumptech.glide.r.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteBufferUtil.java */
    private static class C0142a extends InputStream {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ByteBuffer f9539f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f9540g = -1;

        C0142a(ByteBuffer byteBuffer) {
            this.f9539f = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f9539f.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i2) {
            this.f9540g = this.f9539f.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f9539f.hasRemaining()) {
                return this.f9539f.get();
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            int i2 = this.f9540g;
            if (i2 == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f9539f.position(i2);
        }

        @Override // java.io.InputStream
        public long skip(long j2) throws IOException {
            if (!this.f9539f.hasRemaining()) {
                return -1L;
            }
            long jMin = Math.min(j2, available());
            ByteBuffer byteBuffer = this.f9539f;
            byteBuffer.position((int) (((long) byteBuffer.position()) + jMin));
            return jMin;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            if (!this.f9539f.hasRemaining()) {
                return -1;
            }
            int iMin = Math.min(i3, available());
            this.f9539f.get(bArr, i2, iMin);
            return iMin;
        }
    }
}
