package okhttp3.internal.cache2;

import j.d0;
import j.e0;
import j.f;
import j.i;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.u;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: Relay.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 E2\u00020\u0001:\u0002EFB5\b\u0002\u0012\b\u0010=\u001a\u0004\u0018\u00010<\u0012\b\u0010%\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010/\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\bC\u0010DJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0019\u0010\u0013\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010)R\u0019\u0010+\u001a\u00020*8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\"\u0010/\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0014\u001a\u0004\b0\u0010\u0016\"\u0004\b1\u0010\u000bR\"\u00103\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0013\u00109\u001a\u0002028F@\u0006¢\u0006\u0006\u001a\u0004\b9\u00106R\u0019\u0010:\u001a\u00020*8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010,\u001a\u0004\b;\u0010.R$\u0010=\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006G"}, d2 = {"Lokhttp3/internal/cache2/Relay;", HttpUrl.FRAGMENT_ENCODE_SET, "Lj/i;", "prefix", HttpUrl.FRAGMENT_ENCODE_SET, "upstreamSize", "metadataSize", "Lkotlin/u;", "writeHeader", "(Lj/i;JJ)V", "writeMetadata", "(J)V", "commit", "metadata", "()Lj/i;", "Lj/d0;", "newSource", "()Lj/d0;", "Lj/i;", "bufferMaxSize", "J", "getBufferMaxSize", "()J", "Ljava/lang/Thread;", "upstreamReader", "Ljava/lang/Thread;", "getUpstreamReader", "()Ljava/lang/Thread;", "setUpstreamReader", "(Ljava/lang/Thread;)V", HttpUrl.FRAGMENT_ENCODE_SET, "sourceCount", "I", "getSourceCount", "()I", "setSourceCount", "(I)V", "upstream", "Lj/d0;", "getUpstream", "setUpstream", "(Lj/d0;)V", "Lj/f;", "buffer", "Lj/f;", "getBuffer", "()Lj/f;", "upstreamPos", "getUpstreamPos", "setUpstreamPos", HttpUrl.FRAGMENT_ENCODE_SET, "complete", "Z", "getComplete", "()Z", "setComplete", "(Z)V", "isClosed", "upstreamBuffer", "getUpstreamBuffer", "Ljava/io/RandomAccessFile;", "file", "Ljava/io/RandomAccessFile;", "getFile", "()Ljava/io/RandomAccessFile;", "setFile", "(Ljava/io/RandomAccessFile;)V", "<init>", "(Ljava/io/RandomAccessFile;Lj/d0;JLj/i;J)V", "Companion", "RelaySource", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Relay {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long FILE_HEADER_SIZE = 32;
    public static final i PREFIX_CLEAN;
    public static final i PREFIX_DIRTY;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    private final f buffer;
    private final long bufferMaxSize;
    private boolean complete;
    private RandomAccessFile file;
    private final i metadata;
    private int sourceCount;
    private d0 upstream;
    private final f upstreamBuffer;
    private long upstreamPos;
    private Thread upstreamReader;

    /* JADX INFO: compiled from: Relay.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/cache2/Relay$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/io/File;", "file", "Lj/d0;", "upstream", "Lj/i;", "metadata", HttpUrl.FRAGMENT_ENCODE_SET, "bufferMaxSize", "Lokhttp3/internal/cache2/Relay;", "edit", "(Ljava/io/File;Lj/d0;Lj/i;J)Lokhttp3/internal/cache2/Relay;", "read", "(Ljava/io/File;)Lokhttp3/internal/cache2/Relay;", "FILE_HEADER_SIZE", "J", "PREFIX_CLEAN", "Lj/i;", "PREFIX_DIRTY", HttpUrl.FRAGMENT_ENCODE_SET, "SOURCE_FILE", "I", "SOURCE_UPSTREAM", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final Relay edit(File file, d0 upstream, i metadata, long bufferMaxSize) throws IOException {
            m.f(file, "file");
            m.f(upstream, "upstream");
            m.f(metadata, "metadata");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, upstream, 0L, metadata, bufferMaxSize, null);
            randomAccessFile.setLength(0L);
            relay.writeHeader(Relay.PREFIX_DIRTY, -1L, -1L);
            return relay;
        }

        public final Relay read(File file) throws IOException {
            m.f(file, "file");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            m.e(channel, "randomAccessFile.channel");
            FileOperator fileOperator = new FileOperator(channel);
            f fVar = new f();
            fileOperator.read(0L, fVar, Relay.FILE_HEADER_SIZE);
            i iVar = Relay.PREFIX_CLEAN;
            if (!m.a(fVar.u(iVar.P()), iVar)) {
                throw new IOException("unreadable cache file");
            }
            long j2 = fVar.readLong();
            long j3 = fVar.readLong();
            f fVar2 = new f();
            fileOperator.read(j2 + Relay.FILE_HEADER_SIZE, fVar2, j3);
            return new Relay(randomAccessFile, null, j2, fVar2.D0(), 0L, null);
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: Relay.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0013¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/cache2/Relay$RelaySource;", "Lj/d0;", "Lj/f;", "sink", HttpUrl.FRAGMENT_ENCODE_SET, "byteCount", "read", "(Lj/f;J)J", "Lj/e0;", "timeout", "()Lj/e0;", "Lkotlin/u;", "close", "()V", "Lokhttp3/internal/cache2/FileOperator;", "fileOperator", "Lokhttp3/internal/cache2/FileOperator;", "sourcePos", "J", "Lj/e0;", "<init>", "(Lokhttp3/internal/cache2/Relay;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class RelaySource implements d0 {
        private FileOperator fileOperator;
        private long sourcePos;
        private final e0 timeout = new e0();

        public RelaySource() {
            RandomAccessFile file = Relay.this.getFile();
            m.c(file);
            FileChannel channel = file.getChannel();
            m.e(channel, "file!!.channel");
            this.fileOperator = new FileOperator(channel);
        }

        @Override // j.d0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            synchronized (Relay.this) {
                Relay relay = Relay.this;
                relay.setSourceCount(relay.getSourceCount() - 1);
                if (Relay.this.getSourceCount() == 0) {
                    RandomAccessFile file = Relay.this.getFile();
                    Relay.this.setFile(null);
                    randomAccessFile = file;
                }
                u uVar = u.a;
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }

        @Override // j.d0
        public long read(f sink, long byteCount) throws IOException {
            m.f(sink, "sink");
            char c2 = 1;
            if (!(this.fileOperator != null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            synchronized (Relay.this) {
                while (true) {
                    if (this.sourcePos == Relay.this.getUpstreamPos()) {
                        if (!Relay.this.getComplete()) {
                            if (Relay.this.getUpstreamReader() == null) {
                                Relay.this.setUpstreamReader(Thread.currentThread());
                                break;
                            }
                            this.timeout.waitUntilNotified(Relay.this);
                        } else {
                            return -1L;
                        }
                    } else {
                        long upstreamPos = Relay.this.getUpstreamPos() - Relay.this.getBuffer().size();
                        if (this.sourcePos < upstreamPos) {
                            c2 = 2;
                            break;
                        }
                        long jMin = Math.min(byteCount, Relay.this.getUpstreamPos() - this.sourcePos);
                        Relay.this.getBuffer().j(sink, this.sourcePos - upstreamPos, jMin);
                        this.sourcePos += jMin;
                        return jMin;
                    }
                }
                if (c2 == 2) {
                    long jMin2 = Math.min(byteCount, Relay.this.getUpstreamPos() - this.sourcePos);
                    FileOperator fileOperator = this.fileOperator;
                    m.c(fileOperator);
                    fileOperator.read(this.sourcePos + Relay.FILE_HEADER_SIZE, sink, jMin2);
                    this.sourcePos += jMin2;
                    return jMin2;
                }
                try {
                    d0 upstream = Relay.this.getUpstream();
                    m.c(upstream);
                    long j2 = upstream.read(Relay.this.getUpstreamBuffer(), Relay.this.getBufferMaxSize());
                    if (j2 == -1) {
                        Relay relay = Relay.this;
                        relay.commit(relay.getUpstreamPos());
                        synchronized (Relay.this) {
                            Relay.this.setUpstreamReader(null);
                            Relay relay2 = Relay.this;
                            if (relay2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                            }
                            relay2.notifyAll();
                            u uVar = u.a;
                        }
                        return -1L;
                    }
                    long jMin3 = Math.min(j2, byteCount);
                    Relay.this.getUpstreamBuffer().j(sink, 0L, jMin3);
                    this.sourcePos += jMin3;
                    FileOperator fileOperator2 = this.fileOperator;
                    m.c(fileOperator2);
                    fileOperator2.write(Relay.this.getUpstreamPos() + Relay.FILE_HEADER_SIZE, Relay.this.getUpstreamBuffer().clone(), j2);
                    synchronized (Relay.this) {
                        Relay.this.getBuffer().write(Relay.this.getUpstreamBuffer(), j2);
                        if (Relay.this.getBuffer().size() > Relay.this.getBufferMaxSize()) {
                            Relay.this.getBuffer().skip(Relay.this.getBuffer().size() - Relay.this.getBufferMaxSize());
                        }
                        Relay relay3 = Relay.this;
                        relay3.setUpstreamPos(relay3.getUpstreamPos() + j2);
                        u uVar2 = u.a;
                    }
                    synchronized (Relay.this) {
                        Relay.this.setUpstreamReader(null);
                        Relay relay4 = Relay.this;
                        if (relay4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                        }
                        relay4.notifyAll();
                    }
                    return jMin3;
                } catch (Throwable th) {
                    synchronized (Relay.this) {
                        Relay.this.setUpstreamReader(null);
                        Relay relay5 = Relay.this;
                        if (relay5 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                        }
                        relay5.notifyAll();
                        u uVar3 = u.a;
                        throw th;
                    }
                }
            }
        }

        @Override // j.d0
        /* JADX INFO: renamed from: timeout, reason: from getter */
        public e0 getTimeout() {
            return this.timeout;
        }
    }

    static {
        i.a aVar = i.f22842g;
        PREFIX_CLEAN = aVar.d("OkHttp cache v1\n");
        PREFIX_DIRTY = aVar.d("OkHttp DIRTY :(\n");
    }

    private Relay(RandomAccessFile randomAccessFile, d0 d0Var, long j2, i iVar, long j3) {
        this.file = randomAccessFile;
        this.upstream = d0Var;
        this.upstreamPos = j2;
        this.metadata = iVar;
        this.bufferMaxSize = j3;
        this.upstreamBuffer = new f();
        this.complete = this.upstream == null;
        this.buffer = new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeHeader(i prefix, long upstreamSize, long metadataSize) throws IOException {
        f fVar = new f();
        fVar.U0(prefix);
        fVar.Q0(upstreamSize);
        fVar.Q0(metadataSize);
        if (!(fVar.size() == FILE_HEADER_SIZE)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        RandomAccessFile randomAccessFile = this.file;
        m.c(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        m.e(channel, "file!!.channel");
        new FileOperator(channel).write(0L, fVar, FILE_HEADER_SIZE);
    }

    private final void writeMetadata(long upstreamSize) throws IOException {
        f fVar = new f();
        fVar.U0(this.metadata);
        RandomAccessFile randomAccessFile = this.file;
        m.c(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        m.e(channel, "file!!.channel");
        new FileOperator(channel).write(FILE_HEADER_SIZE + upstreamSize, fVar, this.metadata.P());
    }

    public final void commit(long upstreamSize) throws IOException {
        writeMetadata(upstreamSize);
        RandomAccessFile randomAccessFile = this.file;
        m.c(randomAccessFile);
        randomAccessFile.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, upstreamSize, this.metadata.P());
        RandomAccessFile randomAccessFile2 = this.file;
        m.c(randomAccessFile2);
        randomAccessFile2.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
            u uVar = u.a;
        }
        d0 d0Var = this.upstream;
        if (d0Var != null) {
            Util.closeQuietly(d0Var);
        }
        this.upstream = null;
    }

    public final f getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    public final d0 getUpstream() {
        return this.upstream;
    }

    public final f getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        return this.file == null;
    }

    /* JADX INFO: renamed from: metadata, reason: from getter */
    public final i getMetadata() {
        return this.metadata;
    }

    public final d0 newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    public final void setComplete(boolean z) {
        this.complete = z;
    }

    public final void setFile(RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int i2) {
        this.sourceCount = i2;
    }

    public final void setUpstream(d0 d0Var) {
        this.upstream = d0Var;
    }

    public final void setUpstreamPos(long j2) {
        this.upstreamPos = j2;
    }

    public final void setUpstreamReader(Thread thread) {
        this.upstreamReader = thread;
    }

    public /* synthetic */ Relay(RandomAccessFile randomAccessFile, d0 d0Var, long j2, i iVar, long j3, g gVar) {
        this(randomAccessFile, d0Var, j2, iVar, j3);
    }
}
