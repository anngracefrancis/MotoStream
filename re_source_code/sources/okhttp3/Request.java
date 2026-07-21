package okhttp3;

import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.q0;
import kotlin.jvm.internal.m;
import kotlin.text.u;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

/* JADX INFO: compiled from: Request.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00015BC\b\u0000\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0019\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c\u0012\u0016\u0010+\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\u00010*¢\u0006\u0004\b3\u00104J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\t\u0010\nJ%\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000b2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\f¢\u0006\u0004\b\t\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0007\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u001cH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010#\u001a\u00020 H\u0007¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b$\u0010\u0017R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0007@\u0006¢\u0006\f\n\u0004\b\u001f\u0010%\u001a\u0004\b\u001f\u0010\u001eR\u0019\u0010\u0018\u001a\u00020\u00028\u0007@\u0006¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010#\u001a\u00020 8G@\u0006¢\u0006\u0006\u001a\u0004\b#\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0019\u0010\u0015\u001a\u00020\u00128\u0007@\u0006¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b\u0015\u0010\u0014R,\u0010+\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\u00010*8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0013\u00100\u001a\u00020/8F@\u0006¢\u0006\u0006\u001a\u0004\b0\u00101R\u0019\u0010\u0007\u001a\u00020\u00198\u0007@\u0006¢\u0006\f\n\u0004\b\u0007\u00102\u001a\u0004\b\u0007\u0010\u001b¨\u00066"}, d2 = {"Lokhttp3/Request;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "name", "header", "(Ljava/lang/String;)Ljava/lang/String;", HttpUrl.FRAGMENT_ENCODE_SET, "headers", "(Ljava/lang/String;)Ljava/util/List;", StoreTabGridRecyclerFragment.BundleCons.TAG, "()Ljava/lang/Object;", "T", "Ljava/lang/Class;", "type", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lokhttp3/Request$Builder;", "newBuilder", "()Lokhttp3/Request$Builder;", "Lokhttp3/HttpUrl;", "-deprecated_url", "()Lokhttp3/HttpUrl;", "url", "-deprecated_method", "()Ljava/lang/String;", "method", "Lokhttp3/Headers;", "-deprecated_headers", "()Lokhttp3/Headers;", "Lokhttp3/RequestBody;", "-deprecated_body", "()Lokhttp3/RequestBody;", "body", "Lokhttp3/CacheControl;", "-deprecated_cacheControl", "()Lokhttp3/CacheControl;", "cacheControl", "toString", "Lokhttp3/RequestBody;", "Ljava/lang/String;", "lazyCacheControl", "Lokhttp3/CacheControl;", "Lokhttp3/HttpUrl;", HttpUrl.FRAGMENT_ENCODE_SET, "tags", "Ljava/util/Map;", "getTags$okhttp", "()Ljava/util/Map;", HttpUrl.FRAGMENT_ENCODE_SET, "isHttps", "()Z", "Lokhttp3/Headers;", "<init>", "(Lokhttp3/HttpUrl;Ljava/lang/String;Lokhttp3/Headers;Lokhttp3/RequestBody;Ljava/util/Map;)V", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Request {
    private final RequestBody body;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String method;
    private final Map<Class<?>, Object> tags;
    private final HttpUrl url;

    /* JADX INFO: compiled from: Request.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\bF\u0010GB\u0011\b\u0010\u0012\u0006\u0010H\u001a\u00020'¢\u0006\u0004\bF\u0010IJ\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0003\u0010\u0006J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0003\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0017¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001d\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001e\u0010\u001bJ!\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010!\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b!\u0010\"J/\u0010!\u001a\u00020\u0000\"\u0004\b\u0000\u0010#2\u000e\u0010%\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000$2\b\u0010!\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b!\u0010&J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R2\u00100\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030$\u0012\u0004\u0012\u00020\u00010/8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0019\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010\u0010\u001a\u00020;8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010\u001f\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006J"}, d2 = {"Lokhttp3/Request$Builder;", HttpUrl.FRAGMENT_ENCODE_SET, "Lokhttp3/HttpUrl;", "url", "(Lokhttp3/HttpUrl;)Lokhttp3/Request$Builder;", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;)Lokhttp3/Request$Builder;", "Ljava/net/URL;", "(Ljava/net/URL;)Lokhttp3/Request$Builder;", "name", "value", "header", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;", "addHeader", "removeHeader", "Lokhttp3/Headers;", "headers", "(Lokhttp3/Headers;)Lokhttp3/Request$Builder;", "Lokhttp3/CacheControl;", "cacheControl", "(Lokhttp3/CacheControl;)Lokhttp3/Request$Builder;", "get", "()Lokhttp3/Request$Builder;", "head", "Lokhttp3/RequestBody;", "body", "post", "(Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;", "delete", "put", "patch", "method", "(Ljava/lang/String;Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;", StoreTabGridRecyclerFragment.BundleCons.TAG, "(Ljava/lang/Object;)Lokhttp3/Request$Builder;", "T", "Ljava/lang/Class;", "type", "(Ljava/lang/Class;Ljava/lang/Object;)Lokhttp3/Request$Builder;", "Lokhttp3/Request;", "build", "()Lokhttp3/Request;", "Lokhttp3/HttpUrl;", "getUrl$okhttp", "()Lokhttp3/HttpUrl;", "setUrl$okhttp", "(Lokhttp3/HttpUrl;)V", HttpUrl.FRAGMENT_ENCODE_SET, "tags", "Ljava/util/Map;", "getTags$okhttp", "()Ljava/util/Map;", "setTags$okhttp", "(Ljava/util/Map;)V", "Lokhttp3/RequestBody;", "getBody$okhttp", "()Lokhttp3/RequestBody;", "setBody$okhttp", "(Lokhttp3/RequestBody;)V", "Lokhttp3/Headers$Builder;", "Lokhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "Ljava/lang/String;", "getMethod$okhttp", "()Ljava/lang/String;", "setMethod$okhttp", "(Ljava/lang/String;)V", "<init>", "()V", "request", "(Lokhttp3/Request;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static class Builder {
        private RequestBody body;
        private Headers.Builder headers;
        private String method;
        private Map<Class<?>, Object> tags;
        private HttpUrl url;

        public Builder() {
            this.tags = new LinkedHashMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public static /* synthetic */ Builder delete$default(Builder builder, RequestBody requestBody, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
            }
            if ((i2 & 1) != 0) {
                requestBody = Util.EMPTY_REQUEST;
            }
            return builder.delete(requestBody);
        }

        public Builder addHeader(String name, String value) {
            m.f(name, "name");
            m.f(value, "value");
            this.headers.add(name, value);
            return this;
        }

        public Request build() {
            HttpUrl httpUrl = this.url;
            if (httpUrl != null) {
                return new Request(httpUrl, this.method, this.headers.build(), this.body, Util.toImmutableMap(this.tags));
            }
            throw new IllegalStateException("url == null".toString());
        }

        public Builder cacheControl(CacheControl cacheControl) {
            m.f(cacheControl, "cacheControl");
            String string = cacheControl.toString();
            return string.length() == 0 ? removeHeader("Cache-Control") : header("Cache-Control", string);
        }

        public final Builder delete() {
            return delete$default(this, null, 1, null);
        }

        public Builder delete(RequestBody body) {
            return method("DELETE", body);
        }

        public Builder get() {
            return method("GET", null);
        }

        /* JADX INFO: renamed from: getBody$okhttp, reason: from getter */
        public final RequestBody getBody() {
            return this.body;
        }

        /* JADX INFO: renamed from: getHeaders$okhttp, reason: from getter */
        public final Headers.Builder getHeaders() {
            return this.headers;
        }

        /* JADX INFO: renamed from: getMethod$okhttp, reason: from getter */
        public final String getMethod() {
            return this.method;
        }

        public final Map<Class<?>, Object> getTags$okhttp() {
            return this.tags;
        }

        /* JADX INFO: renamed from: getUrl$okhttp, reason: from getter */
        public final HttpUrl getUrl() {
            return this.url;
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder header(String name, String value) {
            m.f(name, "name");
            m.f(value, "value");
            this.headers.set(name, value);
            return this;
        }

        public Builder headers(Headers headers) {
            m.f(headers, "headers");
            this.headers = headers.newBuilder();
            return this;
        }

        public Builder method(String method, RequestBody body) {
            m.f(method, "method");
            if (!(method.length() > 0)) {
                throw new IllegalArgumentException("method.isEmpty() == true".toString());
            }
            if (body == null) {
                if (!(true ^ HttpMethod.requiresRequestBody(method))) {
                    throw new IllegalArgumentException(("method " + method + " must have a request body.").toString());
                }
            } else if (!HttpMethod.permitsRequestBody(method)) {
                throw new IllegalArgumentException(("method " + method + " must not have a request body.").toString());
            }
            this.method = method;
            this.body = body;
            return this;
        }

        public Builder patch(RequestBody body) {
            m.f(body, "body");
            return method("PATCH", body);
        }

        public Builder post(RequestBody body) {
            m.f(body, "body");
            return method("POST", body);
        }

        public Builder put(RequestBody body) {
            m.f(body, "body");
            return method("PUT", body);
        }

        public Builder removeHeader(String name) {
            m.f(name, "name");
            this.headers.removeAll(name);
            return this;
        }

        public final void setBody$okhttp(RequestBody requestBody) {
            this.body = requestBody;
        }

        public final void setHeaders$okhttp(Headers.Builder builder) {
            m.f(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMethod$okhttp(String str) {
            m.f(str, "<set-?>");
            this.method = str;
        }

        public final void setTags$okhttp(Map<Class<?>, Object> map) {
            m.f(map, "<set-?>");
            this.tags = map;
        }

        public final void setUrl$okhttp(HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        public Builder tag(Object tag) {
            return tag(Object.class, tag);
        }

        public Builder url(HttpUrl url) {
            m.f(url, "url");
            this.url = url;
            return this;
        }

        public <T> Builder tag(Class<? super T> type, T tag) {
            m.f(type, "type");
            if (tag == null) {
                this.tags.remove(type);
            } else {
                if (this.tags.isEmpty()) {
                    this.tags = new LinkedHashMap();
                }
                Map<Class<?>, Object> map = this.tags;
                T tCast = type.cast(tag);
                m.c(tCast);
                map.put(type, tCast);
            }
            return this;
        }

        public Builder url(String url) {
            m.f(url, "url");
            if (u.C(url, "ws:", true)) {
                StringBuilder sb = new StringBuilder();
                sb.append("http:");
                String strSubstring = url.substring(3);
                m.e(strSubstring, "(this as java.lang.String).substring(startIndex)");
                sb.append(strSubstring);
                url = sb.toString();
            } else if (u.C(url, "wss:", true)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("https:");
                String strSubstring2 = url.substring(4);
                m.e(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                sb2.append(strSubstring2);
                url = sb2.toString();
            }
            return url(HttpUrl.INSTANCE.get(url));
        }

        public Builder(Request request) {
            Map<Class<?>, Object> mapU;
            m.f(request, "request");
            this.tags = new LinkedHashMap();
            this.url = request.url();
            this.method = request.method();
            this.body = request.body();
            if (request.getTags$okhttp().isEmpty()) {
                mapU = new LinkedHashMap<>();
            } else {
                mapU = q0.u(request.getTags$okhttp());
            }
            this.tags = mapU;
            this.headers = request.headers().newBuilder();
        }

        public Builder url(URL url) {
            m.f(url, "url");
            HttpUrl.Companion companion = HttpUrl.INSTANCE;
            String string = url.toString();
            m.e(string, "url.toString()");
            return url(companion.get(string));
        }
    }

    public Request(HttpUrl httpUrl, String str, Headers headers, RequestBody requestBody, Map<Class<?>, ? extends Object> map) {
        m.f(httpUrl, "url");
        m.f(str, "method");
        m.f(headers, "headers");
        m.f(map, "tags");
        this.url = httpUrl;
        this.method = str;
        this.headers = headers;
        this.body = requestBody;
        this.tags = map;
    }

    /* JADX INFO: renamed from: -deprecated_body, reason: not valid java name and from getter */
    public final RequestBody getBody() {
        return this.body;
    }

    /* JADX INFO: renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final CacheControl m489deprecated_cacheControl() {
        return cacheControl();
    }

    /* JADX INFO: renamed from: -deprecated_headers, reason: not valid java name and from getter */
    public final Headers getHeaders() {
        return this.headers;
    }

    /* JADX INFO: renamed from: -deprecated_method, reason: not valid java name and from getter */
    public final String getMethod() {
        return this.method;
    }

    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name and from getter */
    public final HttpUrl getUrl() {
        return this.url;
    }

    public final RequestBody body() {
        return this.body;
    }

    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControl2 = CacheControl.INSTANCE.parse(this.headers);
        this.lazyCacheControl = cacheControl2;
        return cacheControl2;
    }

    public final Map<Class<?>, Object> getTags$okhttp() {
        return this.tags;
    }

    public final String header(String name) {
        m.f(name, "name");
        return this.headers.get(name);
    }

    public final Headers headers() {
        return this.headers;
    }

    public final boolean isHttps() {
        return this.url.getIsHttps();
    }

    public final String method() {
        return this.method;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final Object tag() {
        return tag(Object.class);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.url);
        if (this.headers.size() != 0) {
            sb.append(", headers=[");
            int i2 = 0;
            for (Pair<? extends String, ? extends String> pair : this.headers) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.collections.u.t();
                }
                Pair<? extends String, ? extends String> pair2 = pair;
                String strA = pair2.a();
                String strB = pair2.b();
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(strA);
                sb.append(':');
                sb.append(strB);
                i2 = i3;
            }
            sb.append(']');
        }
        if (!this.tags.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.tags);
        }
        sb.append('}');
        String string = sb.toString();
        m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final HttpUrl url() {
        return this.url;
    }

    public final List<String> headers(String name) {
        m.f(name, "name");
        return this.headers.values(name);
    }

    public final <T> T tag(Class<? extends T> type) {
        m.f(type, "type");
        return type.cast(this.tags.get(type));
    }
}
