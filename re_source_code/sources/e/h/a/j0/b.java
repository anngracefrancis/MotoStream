package e.h.a.j0;

import e.h.a.k0.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: FileDownloadRandomAccessFile.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements e.h.a.j0.a {
    private final BufferedOutputStream a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FileDescriptor f21355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RandomAccessFile f21356c;

    /* JADX INFO: compiled from: FileDownloadRandomAccessFile.java */
    public static class a implements c.e {
        @Override // e.h.a.k0.c.e
        public e.h.a.j0.a a(File file) throws IOException {
            return new b(file);
        }

        @Override // e.h.a.k0.c.e
        public boolean b() {
            return true;
        }
    }

    b(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.f21356c = randomAccessFile;
        this.f21355b = randomAccessFile.getFD();
        this.a = new BufferedOutputStream(new FileOutputStream(randomAccessFile.getFD()));
    }

    @Override // e.h.a.j0.a
    public void a(long j2) throws IOException {
        this.f21356c.setLength(j2);
    }

    @Override // e.h.a.j0.a
    public void b() throws IOException {
        this.a.flush();
        this.f21355b.sync();
    }

    @Override // e.h.a.j0.a
    public void c(long j2) throws IOException {
        this.f21356c.seek(j2);
    }

    @Override // e.h.a.j0.a
    public void close() throws IOException {
        this.a.close();
        this.f21356c.close();
    }

    @Override // e.h.a.j0.a
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.a.write(bArr, i2, i3);
    }
}
