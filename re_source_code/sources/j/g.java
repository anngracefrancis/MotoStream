package j;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: BufferedSink.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface g extends b0, WritableByteChannel {
    g A0(String str, int i2, int i3) throws IOException;

    long B0(d0 d0Var) throws IOException;

    g C() throws IOException;

    g C0(long j2) throws IOException;

    g U0(i iVar) throws IOException;

    g c0() throws IOException;

    @Override // j.b0, java.io.Flushable
    void flush() throws IOException;

    f i();

    g i1(long j2) throws IOException;

    g r0(String str) throws IOException;

    g write(byte[] bArr) throws IOException;

    g write(byte[] bArr, int i2, int i3) throws IOException;

    g writeByte(int i2) throws IOException;

    g writeInt(int i2) throws IOException;

    g writeShort(int i2) throws IOException;
}
