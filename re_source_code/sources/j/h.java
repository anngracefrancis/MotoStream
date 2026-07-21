package j;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: BufferedSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface h extends d0, ReadableByteChannel {
    i D0() throws IOException;

    String L0() throws IOException;

    byte[] M() throws IOException;

    byte[] O0(long j2) throws IOException;

    long P(i iVar) throws IOException;

    boolean R() throws IOException;

    void X(f fVar, long j2) throws IOException;

    long Y0(b0 b0Var) throws IOException;

    long b0(i iVar) throws IOException;

    long d0() throws IOException;

    String g0(long j2) throws IOException;

    void g1(long j2) throws IOException;

    f i();

    long m1() throws IOException;

    InputStream o1();

    int p1(t tVar) throws IOException;

    h peek();

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    long readLong() throws IOException;

    short readShort() throws IOException;

    boolean request(long j2) throws IOException;

    void skip(long j2) throws IOException;

    f t();

    i u(long j2) throws IOException;

    boolean v0(long j2, i iVar) throws IOException;

    String w0(Charset charset) throws IOException;
}
