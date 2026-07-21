package okhttp3.internal.http;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: HttpMethod.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lokhttp3/internal/http/HttpMethod;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "method", HttpUrl.FRAGMENT_ENCODE_SET, "requiresRequestBody", "(Ljava/lang/String;)Z", "permitsRequestBody", "invalidatesCache", "redirectsWithBody", "redirectsToGet", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    public static final boolean permitsRequestBody(String method) {
        m.f(method, "method");
        return (m.a(method, "GET") || m.a(method, "HEAD")) ? false : true;
    }

    public static final boolean requiresRequestBody(String method) {
        m.f(method, "method");
        return m.a(method, "POST") || m.a(method, "PUT") || m.a(method, "PATCH") || m.a(method, "PROPPATCH") || m.a(method, "REPORT");
    }

    public final boolean invalidatesCache(String method) {
        m.f(method, "method");
        return m.a(method, "POST") || m.a(method, "PATCH") || m.a(method, "PUT") || m.a(method, "DELETE") || m.a(method, "MOVE");
    }

    public final boolean redirectsToGet(String method) {
        m.f(method, "method");
        return !m.a(method, "PROPFIND");
    }

    public final boolean redirectsWithBody(String method) {
        m.f(method, "method");
        return m.a(method, "PROPFIND");
    }
}
