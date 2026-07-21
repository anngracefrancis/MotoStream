package okhttp3.logging;

import j.f;
import j.h;
import j.n;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.w0;
import kotlin.collections.z;
import kotlin.io.a;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.text.u;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;

/* JADX INFO: compiled from: HttpLoggingInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002'(B\u0013\b\u0007\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b%\u0010&J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR*\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00108\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010 \u001a\u0004\b\u0016\u0010\u0015\"\u0004\b\u0011\u0010!R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Headers;", "headers", HttpUrl.FRAGMENT_ENCODE_SET, "i", "Lkotlin/u;", "logHeader", "(Lokhttp3/Headers;I)V", HttpUrl.FRAGMENT_ENCODE_SET, "bodyHasUnknownEncoding", "(Lokhttp3/Headers;)Z", HttpUrl.FRAGMENT_ENCODE_SET, "name", "redactHeader", "(Ljava/lang/String;)V", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "level", "setLevel", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)Lokhttp3/logging/HttpLoggingInterceptor;", "-deprecated_level", "()Lokhttp3/logging/HttpLoggingInterceptor$Level;", "getLevel", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "<set-?>", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)V", HttpUrl.FRAGMENT_ENCODE_SET, "headersToRedact", "Ljava/util/Set;", "<init>", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "Level", "Logger", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
public final class HttpLoggingInterceptor implements Interceptor {
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;

    /* JADX INFO: compiled from: HttpLoggingInterceptor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Level;", HttpUrl.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;I)V", "NONE", "BASIC", "HEADERS", "BODY", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* JADX INFO: compiled from: HttpLoggingInterceptor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bæ\u0080\u0001\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "message", "Lkotlin/u;", "log", "(Ljava/lang/String;)V", "Companion", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
    public interface Logger {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Logger DEFAULT = new Companion.DefaultLogger();

        /* JADX INFO: compiled from: HttpLoggingInterceptor.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0001\u0082\u0002\u0007\n\u0005\b\u0091F0\u0001¨\u0006\b"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "DEFAULT", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "<init>", "()V", "DefaultLogger", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;

            /* JADX INFO: compiled from: HttpLoggingInterceptor.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion$DefaultLogger;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", HttpUrl.FRAGMENT_ENCODE_SET, "message", "Lkotlin/u;", "log", "(Ljava/lang/String;)V", "<init>", "()V", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
            private static final class DefaultLogger implements Logger {
                @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
                public void log(String message) {
                    m.f(message, "message");
                    Platform.log$default(Platform.INSTANCE.get(), message, 0, null, 6, null);
                }
            }

            private Companion() {
            }

            public /* synthetic */ Companion(g gVar) {
                this();
            }
        }

        void log(String message);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpLoggingInterceptor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public HttpLoggingInterceptor(Logger logger) {
        m.f(logger, "logger");
        this.logger = logger;
        this.headersToRedact = w0.d();
        this.level = Level.NONE;
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || u.q(str, "identity", true) || u.q(str, "gzip", true)) ? false : true;
    }

    private final void logHeader(Headers headers, int i2) {
        String strValue = this.headersToRedact.contains(headers.name(i2)) ? "██" : headers.value(i2);
        this.logger.log(headers.name(i2) + ": " + strValue);
    }

    /* JADX INFO: renamed from: -deprecated_level, reason: not valid java name and from getter */
    public final Level getLevel() {
        return this.level;
    }

    public final Level getLevel() {
        return this.level;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        Charset charset;
        Charset charset2;
        m.f(chain, "chain");
        Level level = this.level;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        boolean z = level == Level.BODY;
        boolean z2 = z || level == Level.HEADERS;
        RequestBody requestBodyBody = request.body();
        Connection connection = chain.connection();
        StringBuilder sb = new StringBuilder();
        sb.append("--> ");
        sb.append(request.method());
        sb.append(' ');
        sb.append(request.url());
        sb.append(connection != null ? " " + connection.protocol() : HttpUrl.FRAGMENT_ENCODE_SET);
        String string = sb.toString();
        if (!z2 && requestBodyBody != null) {
            string = string + " (" + requestBodyBody.contentLength() + "-byte body)";
        }
        this.logger.log(string);
        if (z2) {
            Headers headers = request.headers();
            if (requestBodyBody != null) {
                MediaType contentType = requestBodyBody.getContentType();
                if (contentType != null && headers.get("Content-Type") == null) {
                    this.logger.log("Content-Type: " + contentType);
                }
                if (requestBodyBody.contentLength() != -1 && headers.get("Content-Length") == null) {
                    this.logger.log("Content-Length: " + requestBodyBody.contentLength());
                }
            }
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                logHeader(headers, i2);
            }
            if (!z || requestBodyBody == null) {
                this.logger.log("--> END " + request.method());
            } else if (bodyHasUnknownEncoding(request.headers())) {
                this.logger.log("--> END " + request.method() + " (encoded body omitted)");
            } else if (requestBodyBody.isDuplex()) {
                this.logger.log("--> END " + request.method() + " (duplex request body omitted)");
            } else if (requestBodyBody.isOneShot()) {
                this.logger.log("--> END " + request.method() + " (one-shot body omitted)");
            } else {
                f fVar = new f();
                requestBodyBody.writeTo(fVar);
                MediaType contentType2 = requestBodyBody.getContentType();
                if (contentType2 == null || (charset2 = contentType2.charset(StandardCharsets.UTF_8)) == null) {
                    charset2 = StandardCharsets.UTF_8;
                    m.e(charset2, "UTF_8");
                }
                this.logger.log(HttpUrl.FRAGMENT_ENCODE_SET);
                if (Utf8Kt.isProbablyUtf8(fVar)) {
                    this.logger.log(fVar.w0(charset2));
                    this.logger.log("--> END " + request.method() + " (" + requestBodyBody.contentLength() + "-byte body)");
                } else {
                    this.logger.log("--> END " + request.method() + " (binary " + requestBodyBody.contentLength() + "-byte body omitted)");
                }
            }
        }
        long jNanoTime = System.nanoTime();
        try {
            Response responseProceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            ResponseBody responseBodyBody = responseProceed.body();
            m.c(responseBodyBody);
            long contentLength = responseBodyBody.getContentLength();
            String str = contentLength != -1 ? contentLength + "-byte" : "unknown-length";
            Logger logger = this.logger;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("<-- ");
            sb2.append(responseProceed.code());
            sb2.append(responseProceed.message().length() == 0 ? HttpUrl.FRAGMENT_ENCODE_SET : String.valueOf(' ') + responseProceed.message());
            sb2.append(' ');
            sb2.append(responseProceed.request().url());
            sb2.append(" (");
            sb2.append(millis);
            sb2.append("ms");
            sb2.append(z2 ? HttpUrl.FRAGMENT_ENCODE_SET : ", " + str + " body");
            sb2.append(')');
            logger.log(sb2.toString());
            if (z2) {
                Headers headers2 = responseProceed.headers();
                int size2 = headers2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    logHeader(headers2, i3);
                }
                if (!z || !HttpHeaders.promisesBody(responseProceed)) {
                    this.logger.log("<-- END HTTP");
                } else if (bodyHasUnknownEncoding(responseProceed.headers())) {
                    this.logger.log("<-- END HTTP (encoded body omitted)");
                } else {
                    h source = responseBodyBody.getSource();
                    source.request(Long.MAX_VALUE);
                    f fVarI = source.i();
                    Long l = null;
                    if (u.q("gzip", headers2.get("Content-Encoding"), true)) {
                        Long lValueOf = Long.valueOf(fVarI.size());
                        n nVar = new n(fVarI.clone());
                        try {
                            fVarI = new f();
                            fVarI.B0(nVar);
                            a.a(nVar, null);
                            l = lValueOf;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                a.a(nVar, th);
                                throw th2;
                            }
                        }
                    }
                    MediaType mediaType = responseBodyBody.get$contentType();
                    if (mediaType == null || (charset = mediaType.charset(StandardCharsets.UTF_8)) == null) {
                        charset = StandardCharsets.UTF_8;
                        m.e(charset, "UTF_8");
                    }
                    if (!Utf8Kt.isProbablyUtf8(fVarI)) {
                        this.logger.log(HttpUrl.FRAGMENT_ENCODE_SET);
                        this.logger.log("<-- END HTTP (binary " + fVarI.size() + "-byte body omitted)");
                        return responseProceed;
                    }
                    if (contentLength != 0) {
                        this.logger.log(HttpUrl.FRAGMENT_ENCODE_SET);
                        this.logger.log(fVarI.clone().w0(charset));
                    }
                    if (l != null) {
                        this.logger.log("<-- END HTTP (" + fVarI.size() + "-byte, " + l + "-gzipped-byte body)");
                    } else {
                        this.logger.log("<-- END HTTP (" + fVarI.size() + "-byte body)");
                    }
                }
            }
            return responseProceed;
        } catch (Exception e2) {
            this.logger.log("<-- HTTP FAILED: " + e2);
            throw e2;
        }
    }

    public final void level(Level level) {
        m.f(level, "<set-?>");
        this.level = level;
    }

    public final void redactHeader(String name) {
        m.f(name, "name");
        TreeSet treeSet = new TreeSet(u.s(StringCompanionObject.a));
        z.z(treeSet, this.headersToRedact);
        treeSet.add(name);
        this.headersToRedact = treeSet;
    }

    public final HttpLoggingInterceptor setLevel(Level level) {
        m.f(level, "level");
        this.level = level;
        return this;
    }

    public /* synthetic */ HttpLoggingInterceptor(Logger logger, int i2, g gVar) {
        this((i2 & 1) != 0 ? Logger.DEFAULT : logger);
    }
}
