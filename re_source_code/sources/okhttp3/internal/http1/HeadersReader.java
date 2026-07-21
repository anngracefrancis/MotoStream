package okhttp3.internal.http1;

import j.h;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.Headers;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: HeadersReader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lokhttp3/internal/http1/HeadersReader;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "readLine", "()Ljava/lang/String;", "Lokhttp3/Headers;", "readHeaders", "()Lokhttp3/Headers;", "Lj/h;", "source", "Lj/h;", "getSource", "()Lj/h;", HttpUrl.FRAGMENT_ENCODE_SET, "headerLimit", "J", "<init>", "(Lj/h;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class HeadersReader {
    private static final int HEADER_LIMIT = 262144;
    private long headerLimit;
    private final h source;

    public HeadersReader(h hVar) {
        m.f(hVar, "source");
        this.source = hVar;
        this.headerLimit = HEADER_LIMIT;
    }

    public final h getSource() {
        return this.source;
    }

    public final Headers readHeaders() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String line = readLine();
            if (line.length() == 0) {
                return builder.build();
            }
            builder.addLenient$okhttp(line);
        }
    }

    public final String readLine() throws IOException {
        String strG0 = this.source.g0(this.headerLimit);
        this.headerLimit -= (long) strG0.length();
        return strG0;
    }
}
