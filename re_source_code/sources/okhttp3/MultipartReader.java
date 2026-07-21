package okhttp3;

import j.d0;
import j.e0;
import j.f;
import j.h;
import j.i;
import j.q;
import j.t;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import okhttp3.internal.http1.HeadersReader;

/* JADX INFO: compiled from: MultipartReader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0003&'(B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b!\u0010\"B\u0011\b\u0016\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b!\u0010%J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\b\u0018\u00010\fR\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001a\u001a\u00020\u00198\u0007@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001f¨\u0006)"}, d2 = {"Lokhttp3/MultipartReader;", "Ljava/io/Closeable;", HttpUrl.FRAGMENT_ENCODE_SET, "maxResult", "currentPartBytesRemaining", "(J)J", "Lokhttp3/MultipartReader$Part;", "nextPart", "()Lokhttp3/MultipartReader$Part;", "Lkotlin/u;", "close", "()V", "Lokhttp3/MultipartReader$PartSource;", "currentPart", "Lokhttp3/MultipartReader$PartSource;", "Lj/h;", "source", "Lj/h;", HttpUrl.FRAGMENT_ENCODE_SET, "noMoreParts", "Z", "closed", HttpUrl.FRAGMENT_ENCODE_SET, "partCount", "I", HttpUrl.FRAGMENT_ENCODE_SET, "boundary", "Ljava/lang/String;", "()Ljava/lang/String;", "Lj/i;", "dashDashBoundary", "Lj/i;", "crlfDashDashBoundary", "<init>", "(Lj/h;Ljava/lang/String;)V", "Lokhttp3/ResponseBody;", "response", "(Lokhttp3/ResponseBody;)V", "Companion", "Part", "PartSource", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class MultipartReader implements Closeable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final t afterBoundaryOptions;
    private final String boundary;
    private boolean closed;
    private final i crlfDashDashBoundary;
    private PartSource currentPart;
    private final i dashDashBoundary;
    private boolean noMoreParts;
    private int partCount;
    private final h source;

    /* JADX INFO: compiled from: MultipartReader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lokhttp3/MultipartReader$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "Lj/t;", "afterBoundaryOptions", "Lj/t;", "getAfterBoundaryOptions", "()Lj/t;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final t getAfterBoundaryOptions() {
            return MultipartReader.afterBoundaryOptions;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: MultipartReader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00058\u0007@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u0019\u0010\n\u001a\u00020\t8\u0007@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f¨\u0006\u000f"}, d2 = {"Lokhttp3/MultipartReader$Part;", "Ljava/io/Closeable;", "Lkotlin/u;", "close", "()V", "Lokhttp3/Headers;", "headers", "Lokhttp3/Headers;", "()Lokhttp3/Headers;", "Lj/h;", "body", "Lj/h;", "()Lj/h;", "<init>", "(Lokhttp3/Headers;Lj/h;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Part implements Closeable {
        private final h body;
        private final Headers headers;

        public Part(Headers headers, h hVar) {
            m.f(headers, "headers");
            m.f(hVar, "body");
            this.headers = headers;
            this.body = hVar;
        }

        /* JADX INFO: renamed from: body, reason: from getter */
        public final h getBody() {
            return this.body;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.body.close();
        }

        /* JADX INFO: renamed from: headers, reason: from getter */
        public final Headers getHeaders() {
            return this.headers;
        }
    }

    /* JADX INFO: compiled from: MultipartReader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000e¨\u0006\u0011"}, d2 = {"Lokhttp3/MultipartReader$PartSource;", "Lj/d0;", "Lkotlin/u;", "close", "()V", "Lj/f;", "sink", HttpUrl.FRAGMENT_ENCODE_SET, "byteCount", "read", "(Lj/f;J)J", "Lj/e0;", "timeout", "()Lj/e0;", "Lj/e0;", "<init>", "(Lokhttp3/MultipartReader;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    private final class PartSource implements d0 {
        private final e0 timeout = new e0();

        public PartSource() {
        }

        @Override // j.d0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (m.a(MultipartReader.this.currentPart, this)) {
                MultipartReader.this.currentPart = null;
            }
        }

        @Override // j.d0
        public long read(f sink, long byteCount) {
            m.f(sink, "sink");
            if (!(byteCount >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            if (!m.a(MultipartReader.this.currentPart, this)) {
                throw new IllegalStateException("closed".toString());
            }
            e0 timeout = MultipartReader.this.source.getTimeout();
            e0 e0Var = this.timeout;
            long jTimeoutNanos = timeout.timeoutNanos();
            timeout.timeout(e0.Companion.a(e0Var.timeoutNanos(), timeout.timeoutNanos()), TimeUnit.NANOSECONDS);
            if (!timeout.hasDeadline()) {
                if (e0Var.hasDeadline()) {
                    timeout.deadlineNanoTime(e0Var.deadlineNanoTime());
                }
                try {
                    long jCurrentPartBytesRemaining = MultipartReader.this.currentPartBytesRemaining(byteCount);
                    return jCurrentPartBytesRemaining == 0 ? -1L : MultipartReader.this.source.read(sink, jCurrentPartBytesRemaining);
                } finally {
                    timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                    if (e0Var.hasDeadline()) {
                        timeout.clearDeadline();
                    }
                }
            }
            long jDeadlineNanoTime = timeout.deadlineNanoTime();
            if (e0Var.hasDeadline()) {
                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), e0Var.deadlineNanoTime()));
            }
            try {
                long jCurrentPartBytesRemaining2 = MultipartReader.this.currentPartBytesRemaining(byteCount);
                return jCurrentPartBytesRemaining2 == 0 ? -1L : MultipartReader.this.source.read(sink, jCurrentPartBytesRemaining2);
            } finally {
                timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                if (e0Var.hasDeadline()) {
                    timeout.deadlineNanoTime(jDeadlineNanoTime);
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
        t.a aVar = t.f22860g;
        i.a aVar2 = i.f22842g;
        afterBoundaryOptions = aVar.d(aVar2.d("\r\n"), aVar2.d("--"), aVar2.d(" "), aVar2.d("\t"));
    }

    public MultipartReader(h hVar, String str) throws IOException {
        m.f(hVar, "source");
        m.f(str, "boundary");
        this.source = hVar;
        this.boundary = str;
        this.dashDashBoundary = new f().r0("--").r0(str).D0();
        this.crlfDashDashBoundary = new f().r0("\r\n--").r0(str).D0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long currentPartBytesRemaining(long maxResult) throws IOException {
        this.source.g1(this.crlfDashDashBoundary.P());
        long jP = this.source.i().P(this.crlfDashDashBoundary);
        return jP == -1 ? Math.min(maxResult, (this.source.i().size() - ((long) this.crlfDashDashBoundary.P())) + 1) : Math.min(maxResult, jP);
    }

    /* JADX INFO: renamed from: boundary, reason: from getter */
    public final String getBoundary() {
        return this.boundary;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.currentPart = null;
        this.source.close();
    }

    public final Part nextPart() throws IOException {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.noMoreParts) {
            return null;
        }
        if (this.partCount == 0 && this.source.v0(0L, this.dashDashBoundary)) {
            this.source.skip(this.dashDashBoundary.P());
        } else {
            while (true) {
                long jCurrentPartBytesRemaining = currentPartBytesRemaining(8192L);
                if (jCurrentPartBytesRemaining == 0) {
                    break;
                }
                this.source.skip(jCurrentPartBytesRemaining);
            }
            this.source.skip(this.crlfDashDashBoundary.P());
        }
        boolean z = false;
        while (true) {
            int iP1 = this.source.p1(afterBoundaryOptions);
            if (iP1 == -1) {
                throw new ProtocolException("unexpected characters after boundary");
            }
            if (iP1 == 0) {
                this.partCount++;
                Headers headers = new HeadersReader(this.source).readHeaders();
                PartSource partSource = new PartSource();
                this.currentPart = partSource;
                return new Part(headers, q.d(partSource));
            }
            if (iP1 == 1) {
                if (z) {
                    throw new ProtocolException("unexpected characters after boundary");
                }
                if (this.partCount == 0) {
                    throw new ProtocolException("expected at least 1 part");
                }
                this.noMoreParts = true;
                return null;
            }
            if (iP1 == 2 || iP1 == 3) {
                z = true;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MultipartReader(ResponseBody responseBody) throws IOException {
        String strParameter;
        m.f(responseBody, "response");
        h bodySource = responseBody.getBodySource();
        MediaType mediaType = responseBody.get$contentType();
        if (mediaType != null && (strParameter = mediaType.parameter("boundary")) != null) {
            this(bodySource, strParameter);
            return;
        }
        throw new ProtocolException("expected the Content-Type to have a boundary parameter");
    }
}
