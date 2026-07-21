package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.c0;
import kotlin.collections.z;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: compiled from: OkHttpClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 \u0090\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u0091\u0001\u0090\u0001B\u0014\b\u0000\u0012\u0007\u0010\u008d\u0001\u001a\u00020\u0011¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001B\n\b\u0016¢\u0006\u0005\b\u008e\u0001\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u001b\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007¢\u0006\u0004\b!\u0010\u001fJ\u000f\u0010&\u001a\u00020#H\u0007¢\u0006\u0004\b$\u0010%J\u000f\u0010*\u001a\u00020'H\u0007¢\u0006\u0004\b(\u0010)J\u000f\u0010.\u001a\u00020+H\u0007¢\u0006\u0004\b,\u0010-J\u000f\u00100\u001a\u00020'H\u0007¢\u0006\u0004\b/\u0010)J\u000f\u00102\u001a\u00020'H\u0007¢\u0006\u0004\b1\u0010)J\u000f\u00106\u001a\u000203H\u0007¢\u0006\u0004\b4\u00105J\u0011\u0010:\u001a\u0004\u0018\u000107H\u0007¢\u0006\u0004\b8\u00109J\u000f\u0010>\u001a\u00020;H\u0007¢\u0006\u0004\b<\u0010=J\u0011\u0010B\u001a\u0004\u0018\u00010?H\u0007¢\u0006\u0004\b@\u0010AJ\u000f\u0010F\u001a\u00020CH\u0007¢\u0006\u0004\bD\u0010EJ\u000f\u0010H\u001a\u00020+H\u0007¢\u0006\u0004\bG\u0010-J\u000f\u0010L\u001a\u00020IH\u0007¢\u0006\u0004\bJ\u0010KJ\u000f\u0010P\u001a\u00020MH\u0007¢\u0006\u0004\bN\u0010OJ\u0015\u0010S\u001a\b\u0012\u0004\u0012\u00020Q0\u001cH\u0007¢\u0006\u0004\bR\u0010\u001fJ\u0015\u0010V\u001a\b\u0012\u0004\u0012\u00020T0\u001cH\u0007¢\u0006\u0004\bU\u0010\u001fJ\u000f\u0010Z\u001a\u00020WH\u0007¢\u0006\u0004\bX\u0010YJ\u000f\u0010^\u001a\u00020[H\u0007¢\u0006\u0004\b\\\u0010]J\u000f\u0010b\u001a\u00020_H\u0007¢\u0006\u0004\b`\u0010aJ\u000f\u0010d\u001a\u00020_H\u0007¢\u0006\u0004\bc\u0010aJ\u000f\u0010f\u001a\u00020_H\u0007¢\u0006\u0004\be\u0010aJ\u000f\u0010h\u001a\u00020_H\u0007¢\u0006\u0004\bg\u0010aJ\u000f\u0010j\u001a\u00020_H\u0007¢\u0006\u0004\bi\u0010aR\u0019\u00100\u001a\u00020'8G@\u0006¢\u0006\f\n\u0004\b0\u0010k\u001a\u0004\b0\u0010)R\u0019\u0010m\u001a\u00020l8G@\u0006¢\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bm\u0010oR\u0019\u0010f\u001a\u00020_8G@\u0006¢\u0006\f\n\u0004\bf\u0010p\u001a\u0004\bf\u0010aR\u001f\u0010V\u001a\b\u0012\u0004\u0012\u00020T0\u001c8G@\u0006¢\u0006\f\n\u0004\bV\u0010q\u001a\u0004\bV\u0010\u001fR\u0019\u0010s\u001a\u00020r8\u0006@\u0006¢\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010vR\u0019\u0010.\u001a\u00020+8G@\u0006¢\u0006\f\n\u0004\b.\u0010w\u001a\u0004\b.\u0010-R\u0019\u0010^\u001a\u00020[8G@\u0006¢\u0006\f\n\u0004\b^\u0010x\u001a\u0004\b^\u0010]R\u0018\u0010y\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0019\u0010H\u001a\u00020+8G@\u0006¢\u0006\f\n\u0004\bH\u0010w\u001a\u0004\bH\u0010-R\u0013\u0010P\u001a\u00020M8G@\u0006¢\u0006\u0006\u001a\u0004\bP\u0010OR\u0019\u0010L\u001a\u00020I8G@\u0006¢\u0006\f\n\u0004\bL\u0010{\u001a\u0004\bL\u0010KR\u0019\u0010>\u001a\u00020;8G@\u0006¢\u0006\f\n\u0004\b>\u0010|\u001a\u0004\b>\u0010=R\u001b\u0010B\u001a\u0004\u0018\u00010?8G@\u0006¢\u0006\f\n\u0004\bB\u0010}\u001a\u0004\bB\u0010AR\u0019\u0010Z\u001a\u00020W8G@\u0006¢\u0006\f\n\u0004\bZ\u0010~\u001a\u0004\bZ\u0010YR\u0019\u0010j\u001a\u00020_8G@\u0006¢\u0006\f\n\u0004\bj\u0010p\u001a\u0004\bj\u0010aR\u0019\u0010\u001b\u001a\u00020\u00188G@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u007f\u001a\u0004\b\u001b\u0010\u001aR\u001a\u0010&\u001a\u00020#8G@\u0006¢\u0006\r\n\u0005\b&\u0010\u0080\u0001\u001a\u0004\b&\u0010%R\u001a\u00106\u001a\u0002038G@\u0006¢\u0006\r\n\u0005\b6\u0010\u0081\u0001\u001a\u0004\b6\u00105R\u001c\u0010:\u001a\u0004\u0018\u0001078G@\u0006¢\u0006\r\n\u0005\b:\u0010\u0082\u0001\u001a\u0004\b:\u00109R!\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u00018G@\u0006¢\u0006\u0010\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0084\u0001\u0010\u0086\u0001R\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8G@\u0006¢\u0006\f\n\u0004\b\"\u0010q\u001a\u0004\b\"\u0010\u001fR!\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00018G@\u0006¢\u0006\u0010\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u0088\u0001\u0010\u008a\u0001R\u001a\u0010\u0017\u001a\u00020\u00148G@\u0006¢\u0006\r\n\u0005\b\u0017\u0010\u008b\u0001\u001a\u0004\b\u0017\u0010\u0016R\u0019\u00102\u001a\u00020'8G@\u0006¢\u0006\f\n\u0004\b2\u0010k\u001a\u0004\b2\u0010)R\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8G@\u0006¢\u0006\f\n\u0004\b \u0010q\u001a\u0004\b \u0010\u001fR\u0019\u0010*\u001a\u00020'8G@\u0006¢\u0006\f\n\u0004\b*\u0010k\u001a\u0004\b*\u0010)R\u001a\u0010F\u001a\u00020C8G@\u0006¢\u0006\r\n\u0005\bF\u0010\u008c\u0001\u001a\u0004\bF\u0010ER\u001f\u0010S\u001a\b\u0012\u0004\u0012\u00020Q0\u001c8G@\u0006¢\u0006\f\n\u0004\bS\u0010q\u001a\u0004\bS\u0010\u001fR\u0019\u0010h\u001a\u00020_8G@\u0006¢\u0006\f\n\u0004\bh\u0010p\u001a\u0004\bh\u0010aR\u0019\u0010b\u001a\u00020_8G@\u0006¢\u0006\f\n\u0004\bb\u0010p\u001a\u0004\bb\u0010aR\u0019\u0010d\u001a\u00020_8G@\u0006¢\u0006\f\n\u0004\bd\u0010p\u001a\u0004\bd\u0010a¨\u0006\u0092\u0001"}, d2 = {"Lokhttp3/OkHttpClient;", HttpUrl.FRAGMENT_ENCODE_SET, "Lokhttp3/Call$Factory;", "Lokhttp3/WebSocket$Factory;", "Lkotlin/u;", "verifyClientState", "()V", "Lokhttp3/Request;", "request", "Lokhttp3/Call;", "newCall", "(Lokhttp3/Request;)Lokhttp3/Call;", "Lokhttp3/WebSocketListener;", "listener", "Lokhttp3/WebSocket;", "newWebSocket", "(Lokhttp3/Request;Lokhttp3/WebSocketListener;)Lokhttp3/WebSocket;", "Lokhttp3/OkHttpClient$Builder;", "newBuilder", "()Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Dispatcher;", "-deprecated_dispatcher", "()Lokhttp3/Dispatcher;", "dispatcher", "Lokhttp3/ConnectionPool;", "-deprecated_connectionPool", "()Lokhttp3/ConnectionPool;", "connectionPool", HttpUrl.FRAGMENT_ENCODE_SET, "Lokhttp3/Interceptor;", "-deprecated_interceptors", "()Ljava/util/List;", "interceptors", "-deprecated_networkInterceptors", "networkInterceptors", "Lokhttp3/EventListener$Factory;", "-deprecated_eventListenerFactory", "()Lokhttp3/EventListener$Factory;", "eventListenerFactory", HttpUrl.FRAGMENT_ENCODE_SET, "-deprecated_retryOnConnectionFailure", "()Z", "retryOnConnectionFailure", "Lokhttp3/Authenticator;", "-deprecated_authenticator", "()Lokhttp3/Authenticator;", "authenticator", "-deprecated_followRedirects", "followRedirects", "-deprecated_followSslRedirects", "followSslRedirects", "Lokhttp3/CookieJar;", "-deprecated_cookieJar", "()Lokhttp3/CookieJar;", "cookieJar", "Lokhttp3/Cache;", "-deprecated_cache", "()Lokhttp3/Cache;", "cache", "Lokhttp3/Dns;", "-deprecated_dns", "()Lokhttp3/Dns;", "dns", "Ljava/net/Proxy;", "-deprecated_proxy", "()Ljava/net/Proxy;", "proxy", "Ljava/net/ProxySelector;", "-deprecated_proxySelector", "()Ljava/net/ProxySelector;", "proxySelector", "-deprecated_proxyAuthenticator", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "-deprecated_socketFactory", "()Ljavax/net/SocketFactory;", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "-deprecated_sslSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Lokhttp3/ConnectionSpec;", "-deprecated_connectionSpecs", "connectionSpecs", "Lokhttp3/Protocol;", "-deprecated_protocols", "protocols", "Ljavax/net/ssl/HostnameVerifier;", "-deprecated_hostnameVerifier", "()Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Lokhttp3/CertificatePinner;", "-deprecated_certificatePinner", "()Lokhttp3/CertificatePinner;", "certificatePinner", HttpUrl.FRAGMENT_ENCODE_SET, "-deprecated_callTimeoutMillis", "()I", "callTimeoutMillis", "-deprecated_connectTimeoutMillis", "connectTimeoutMillis", "-deprecated_readTimeoutMillis", "readTimeoutMillis", "-deprecated_writeTimeoutMillis", "writeTimeoutMillis", "-deprecated_pingIntervalMillis", "pingIntervalMillis", "Z", HttpUrl.FRAGMENT_ENCODE_SET, "minWebSocketMessageToCompress", "J", "()J", "I", "Ljava/util/List;", "Lokhttp3/internal/connection/RouteDatabase;", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", "getRouteDatabase", "()Lokhttp3/internal/connection/RouteDatabase;", "Lokhttp3/Authenticator;", "Lokhttp3/CertificatePinner;", "sslSocketFactoryOrNull", "Ljavax/net/ssl/SSLSocketFactory;", "Ljavax/net/SocketFactory;", "Lokhttp3/Dns;", "Ljava/net/Proxy;", "Ljavax/net/ssl/HostnameVerifier;", "Lokhttp3/ConnectionPool;", "Lokhttp3/EventListener$Factory;", "Lokhttp3/CookieJar;", "Lokhttp3/Cache;", "Ljavax/net/ssl/X509TrustManager;", "x509TrustManager", "Ljavax/net/ssl/X509TrustManager;", "()Ljavax/net/ssl/X509TrustManager;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "Lokhttp3/Dispatcher;", "Ljava/net/ProxySelector;", "builder", "<init>", "(Lokhttp3/OkHttpClient$Builder;)V", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {
    private final Authenticator authenticator;
    private final Cache cache;
    private final int callTimeoutMillis;
    private final CertificateChainCleaner certificateChainCleaner;
    private final CertificatePinner certificatePinner;
    private final int connectTimeoutMillis;
    private final ConnectionPool connectionPool;
    private final List<ConnectionSpec> connectionSpecs;
    private final CookieJar cookieJar;
    private final Dispatcher dispatcher;
    private final Dns dns;
    private final EventListener.Factory eventListenerFactory;
    private final boolean followRedirects;
    private final boolean followSslRedirects;
    private final HostnameVerifier hostnameVerifier;
    private final List<Interceptor> interceptors;
    private final long minWebSocketMessageToCompress;
    private final List<Interceptor> networkInterceptors;
    private final int pingIntervalMillis;
    private final List<Protocol> protocols;
    private final Proxy proxy;
    private final Authenticator proxyAuthenticator;
    private final ProxySelector proxySelector;
    private final int readTimeoutMillis;
    private final boolean retryOnConnectionFailure;
    private final RouteDatabase routeDatabase;
    private final SocketFactory socketFactory;
    private final SSLSocketFactory sslSocketFactoryOrNull;
    private final int writeTimeoutMillis;
    private final X509TrustManager x509TrustManager;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableListOf(Protocol.HTTP_2, Protocol.HTTP_1_1);
    private static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS = Util.immutableListOf(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT);

    /* JADX INFO: compiled from: OkHttpClient.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b8\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\bÜ\u0001\u0010Ý\u0001B\u0014\b\u0010\u0012\u0007\u0010Þ\u0001\u001a\u00020]¢\u0006\u0006\bÜ\u0001\u0010ß\u0001J\u0015\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\r\u001a\u00020\u00002\u0014\b\u0004\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u0015\u0010\u000bJ\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u000eJ)\u0010\u0016\u001a\u00020\u00002\u0014\b\u0004\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0014J\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u001e¢\u0006\u0004\b$\u0010 J\u0015\u0010&\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u001e¢\u0006\u0004\b&\u0010 J\u0015\u0010(\u001a\u00020\u00002\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\u00020\u00002\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u000100¢\u0006\u0004\b1\u00102J\u0015\u00104\u001a\u00020\u00002\u0006\u00104\u001a\u000203¢\u0006\u0004\b4\u00105J\u0015\u00106\u001a\u00020\u00002\u0006\u00106\u001a\u00020!¢\u0006\u0004\b6\u0010#J\u0015\u00108\u001a\u00020\u00002\u0006\u00108\u001a\u000207¢\u0006\u0004\b8\u00109J\u0017\u0010;\u001a\u00020\u00002\u0006\u0010;\u001a\u00020:H\u0007¢\u0006\u0004\b;\u0010<J\u001d\u0010;\u001a\u00020\u00002\u0006\u0010;\u001a\u00020:2\u0006\u0010>\u001a\u00020=¢\u0006\u0004\b;\u0010?J\u001b\u0010B\u001a\u00020\u00002\f\u0010B\u001a\b\u0012\u0004\u0012\u00020A0@¢\u0006\u0004\bB\u0010CJ\u001b\u0010E\u001a\u00020\u00002\f\u0010E\u001a\b\u0012\u0004\u0012\u00020D0@¢\u0006\u0004\bE\u0010CJ\u0015\u0010G\u001a\u00020\u00002\u0006\u0010G\u001a\u00020F¢\u0006\u0004\bG\u0010HJ\u0015\u0010J\u001a\u00020\u00002\u0006\u0010J\u001a\u00020I¢\u0006\u0004\bJ\u0010KJ\u001d\u0010P\u001a\u00020\u00002\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020N¢\u0006\u0004\bP\u0010QJ\u0017\u0010P\u001a\u00020\u00002\u0006\u0010S\u001a\u00020RH\u0007¢\u0006\u0004\bP\u0010TJ\u001d\u0010U\u001a\u00020\u00002\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020N¢\u0006\u0004\bU\u0010QJ\u0017\u0010U\u001a\u00020\u00002\u0006\u0010S\u001a\u00020RH\u0007¢\u0006\u0004\bU\u0010TJ\u001d\u0010V\u001a\u00020\u00002\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020N¢\u0006\u0004\bV\u0010QJ\u0017\u0010V\u001a\u00020\u00002\u0006\u0010S\u001a\u00020RH\u0007¢\u0006\u0004\bV\u0010TJ\u001d\u0010W\u001a\u00020\u00002\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020N¢\u0006\u0004\bW\u0010QJ\u0017\u0010W\u001a\u00020\u00002\u0006\u0010S\u001a\u00020RH\u0007¢\u0006\u0004\bW\u0010TJ\u001d\u0010Y\u001a\u00020\u00002\u0006\u0010X\u001a\u00020L2\u0006\u0010O\u001a\u00020N¢\u0006\u0004\bY\u0010QJ\u0017\u0010Y\u001a\u00020\u00002\u0006\u0010S\u001a\u00020RH\u0007¢\u0006\u0004\bY\u0010TJ\u0015\u0010[\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020L¢\u0006\u0004\b[\u0010\\J\r\u0010^\u001a\u00020]¢\u0006\u0004\b^\u0010_R\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010`\u001a\u0004\ba\u0010\u000bR\"\u0010[\u001a\u00020L8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b[\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u0010V\u001a\u00020g8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bV\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR$\u00101\u001a\u0004\u0018\u0001008\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b1\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\"\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR(\u0010E\u001a\b\u0012\u0004\u0012\u00020D0@8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bE\u0010`\u001a\u0004\bw\u0010\u000b\"\u0004\bx\u0010yR\"\u0010P\u001a\u00020g8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bP\u0010h\u001a\u0004\bz\u0010j\"\u0004\b{\u0010lR\"\u0010W\u001a\u00020g8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bW\u0010h\u001a\u0004\b|\u0010j\"\u0004\b}\u0010lR(\u0010B\u001a\b\u0012\u0004\u0012\u00020A0@8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bB\u0010`\u001a\u0004\b~\u0010\u000b\"\u0004\b\u007f\u0010yR'\u0010J\u001a\u00020I8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bJ\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R'\u0010$\u001a\u00020\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b$\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R'\u00106\u001a\u00020!8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b6\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R+\u0010\u008f\u0001\u001a\u0004\u0018\u00010=8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R$\u0010Y\u001a\u00020g8\u0000@\u0000X\u0080\u000e¢\u0006\u0014\n\u0004\bY\u0010h\u001a\u0005\b\u0095\u0001\u0010j\"\u0005\b\u0096\u0001\u0010lR,\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R'\u0010\"\u001a\u00020!8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b\"\u0010\u008a\u0001\u001a\u0006\b\u009e\u0001\u0010\u008c\u0001\"\u0006\b\u009f\u0001\u0010\u008e\u0001R#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0000@\u0000X\u0080\u0004¢\u0006\r\n\u0004\b\u0015\u0010`\u001a\u0005\b \u0001\u0010\u000bR'\u0010\u001f\u001a\u00020\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b\u001f\u0010\u0085\u0001\u001a\u0006\b¡\u0001\u0010\u0087\u0001\"\u0006\b¢\u0001\u0010\u0089\u0001R)\u00104\u001a\u0004\u0018\u0001038\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b4\u0010£\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R,\u0010©\u0001\u001a\u0005\u0018\u00010¨\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R$\u0010U\u001a\u00020g8\u0000@\u0000X\u0080\u000e¢\u0006\u0014\n\u0004\bU\u0010h\u001a\u0005\b¯\u0001\u0010j\"\u0005\b°\u0001\u0010lR'\u0010.\u001a\u00020-8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b.\u0010±\u0001\u001a\u0006\b²\u0001\u0010³\u0001\"\u0006\b´\u0001\u0010µ\u0001R'\u0010\u001c\u001a\u00020\u001b8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b\u001c\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R'\u0010&\u001a\u00020\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b&\u0010\u0085\u0001\u001a\u0006\b»\u0001\u0010\u0087\u0001\"\u0006\b¼\u0001\u0010\u0089\u0001R'\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b\u0003\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R'\u00108\u001a\u0002078\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b8\u0010Â\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R'\u0010(\u001a\u00020'8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b(\u0010Ç\u0001\u001a\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R+\u0010Ì\u0001\u001a\u0004\u0018\u00010:8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÌ\u0001\u0010Í\u0001\u001a\u0006\bÎ\u0001\u0010Ï\u0001\"\u0006\bÐ\u0001\u0010Ñ\u0001R'\u0010G\u001a\u00020F8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bG\u0010Ò\u0001\u001a\u0006\bÓ\u0001\u0010Ô\u0001\"\u0006\bÕ\u0001\u0010Ö\u0001R)\u0010+\u001a\u0004\u0018\u00010*8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b+\u0010×\u0001\u001a\u0006\bØ\u0001\u0010Ù\u0001\"\u0006\bÚ\u0001\u0010Û\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006à\u0001"}, d2 = {"Lokhttp3/OkHttpClient$Builder;", HttpUrl.FRAGMENT_ENCODE_SET, "Lokhttp3/Dispatcher;", "dispatcher", "(Lokhttp3/Dispatcher;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/ConnectionPool;", "connectionPool", "(Lokhttp3/ConnectionPool;)Lokhttp3/OkHttpClient$Builder;", HttpUrl.FRAGMENT_ENCODE_SET, "Lokhttp3/Interceptor;", "interceptors", "()Ljava/util/List;", "interceptor", "addInterceptor", "(Lokhttp3/Interceptor;)Lokhttp3/OkHttpClient$Builder;", "Lkotlin/Function1;", "Lokhttp3/Interceptor$Chain;", "Lokhttp3/Response;", "block", "-addInterceptor", "(Lkotlin/a0/c/l;)Lokhttp3/OkHttpClient$Builder;", "networkInterceptors", "addNetworkInterceptor", "-addNetworkInterceptor", "Lokhttp3/EventListener;", "eventListener", "(Lokhttp3/EventListener;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/EventListener$Factory;", "eventListenerFactory", "(Lokhttp3/EventListener$Factory;)Lokhttp3/OkHttpClient$Builder;", HttpUrl.FRAGMENT_ENCODE_SET, "retryOnConnectionFailure", "(Z)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Authenticator;", "authenticator", "(Lokhttp3/Authenticator;)Lokhttp3/OkHttpClient$Builder;", "followRedirects", "followProtocolRedirects", "followSslRedirects", "Lokhttp3/CookieJar;", "cookieJar", "(Lokhttp3/CookieJar;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Cache;", "cache", "(Lokhttp3/Cache;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Dns;", "dns", "(Lokhttp3/Dns;)Lokhttp3/OkHttpClient$Builder;", "Ljava/net/Proxy;", "proxy", "(Ljava/net/Proxy;)Lokhttp3/OkHttpClient$Builder;", "Ljava/net/ProxySelector;", "proxySelector", "(Ljava/net/ProxySelector;)Lokhttp3/OkHttpClient$Builder;", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "socketFactory", "(Ljavax/net/SocketFactory;)Lokhttp3/OkHttpClient$Builder;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "(Ljavax/net/ssl/SSLSocketFactory;)Lokhttp3/OkHttpClient$Builder;", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/X509TrustManager;)Lokhttp3/OkHttpClient$Builder;", HttpUrl.FRAGMENT_ENCODE_SET, "Lokhttp3/ConnectionSpec;", "connectionSpecs", "(Ljava/util/List;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Protocol;", "protocols", "Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "(Ljavax/net/ssl/HostnameVerifier;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/CertificatePinner;", "certificatePinner", "(Lokhttp3/CertificatePinner;)Lokhttp3/OkHttpClient$Builder;", HttpUrl.FRAGMENT_ENCODE_SET, "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "callTimeout", "(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;", "Ljava/time/Duration;", "duration", "(Ljava/time/Duration;)Lokhttp3/OkHttpClient$Builder;", "connectTimeout", "readTimeout", "writeTimeout", "interval", "pingInterval", "bytes", "minWebSocketMessageToCompress", "(J)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/OkHttpClient;", "build", "()Lokhttp3/OkHttpClient;", "Ljava/util/List;", "getInterceptors$okhttp", "J", "getMinWebSocketMessageToCompress$okhttp", "()J", "setMinWebSocketMessageToCompress$okhttp", "(J)V", HttpUrl.FRAGMENT_ENCODE_SET, "I", "getReadTimeout$okhttp", "()I", "setReadTimeout$okhttp", "(I)V", "Ljava/net/Proxy;", "getProxy$okhttp", "()Ljava/net/Proxy;", "setProxy$okhttp", "(Ljava/net/Proxy;)V", "Lokhttp3/ConnectionPool;", "getConnectionPool$okhttp", "()Lokhttp3/ConnectionPool;", "setConnectionPool$okhttp", "(Lokhttp3/ConnectionPool;)V", "getProtocols$okhttp", "setProtocols$okhttp", "(Ljava/util/List;)V", "getCallTimeout$okhttp", "setCallTimeout$okhttp", "getWriteTimeout$okhttp", "setWriteTimeout$okhttp", "getConnectionSpecs$okhttp", "setConnectionSpecs$okhttp", "Lokhttp3/CertificatePinner;", "getCertificatePinner$okhttp", "()Lokhttp3/CertificatePinner;", "setCertificatePinner$okhttp", "(Lokhttp3/CertificatePinner;)V", "Z", "getFollowRedirects$okhttp", "()Z", "setFollowRedirects$okhttp", "(Z)V", "Lokhttp3/Authenticator;", "getProxyAuthenticator$okhttp", "()Lokhttp3/Authenticator;", "setProxyAuthenticator$okhttp", "(Lokhttp3/Authenticator;)V", "x509TrustManagerOrNull", "Ljavax/net/ssl/X509TrustManager;", "getX509TrustManagerOrNull$okhttp", "()Ljavax/net/ssl/X509TrustManager;", "setX509TrustManagerOrNull$okhttp", "(Ljavax/net/ssl/X509TrustManager;)V", "getPingInterval$okhttp", "setPingInterval$okhttp", "Lokhttp3/internal/connection/RouteDatabase;", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", "getRouteDatabase$okhttp", "()Lokhttp3/internal/connection/RouteDatabase;", "setRouteDatabase$okhttp", "(Lokhttp3/internal/connection/RouteDatabase;)V", "getAuthenticator$okhttp", "setAuthenticator$okhttp", "getNetworkInterceptors$okhttp", "getRetryOnConnectionFailure$okhttp", "setRetryOnConnectionFailure$okhttp", "Ljava/net/ProxySelector;", "getProxySelector$okhttp", "()Ljava/net/ProxySelector;", "setProxySelector$okhttp", "(Ljava/net/ProxySelector;)V", "Lokhttp3/internal/tls/CertificateChainCleaner;", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "setCertificateChainCleaner$okhttp", "(Lokhttp3/internal/tls/CertificateChainCleaner;)V", "getConnectTimeout$okhttp", "setConnectTimeout$okhttp", "Lokhttp3/Dns;", "getDns$okhttp", "()Lokhttp3/Dns;", "setDns$okhttp", "(Lokhttp3/Dns;)V", "Lokhttp3/EventListener$Factory;", "getEventListenerFactory$okhttp", "()Lokhttp3/EventListener$Factory;", "setEventListenerFactory$okhttp", "(Lokhttp3/EventListener$Factory;)V", "getFollowSslRedirects$okhttp", "setFollowSslRedirects$okhttp", "Lokhttp3/Dispatcher;", "getDispatcher$okhttp", "()Lokhttp3/Dispatcher;", "setDispatcher$okhttp", "(Lokhttp3/Dispatcher;)V", "Ljavax/net/SocketFactory;", "getSocketFactory$okhttp", "()Ljavax/net/SocketFactory;", "setSocketFactory$okhttp", "(Ljavax/net/SocketFactory;)V", "Lokhttp3/CookieJar;", "getCookieJar$okhttp", "()Lokhttp3/CookieJar;", "setCookieJar$okhttp", "(Lokhttp3/CookieJar;)V", "sslSocketFactoryOrNull", "Ljavax/net/ssl/SSLSocketFactory;", "getSslSocketFactoryOrNull$okhttp", "()Ljavax/net/ssl/SSLSocketFactory;", "setSslSocketFactoryOrNull$okhttp", "(Ljavax/net/ssl/SSLSocketFactory;)V", "Ljavax/net/ssl/HostnameVerifier;", "getHostnameVerifier$okhttp", "()Ljavax/net/ssl/HostnameVerifier;", "setHostnameVerifier$okhttp", "(Ljavax/net/ssl/HostnameVerifier;)V", "Lokhttp3/Cache;", "getCache$okhttp", "()Lokhttp3/Cache;", "setCache$okhttp", "(Lokhttp3/Cache;)V", "<init>", "()V", "okHttpClient", "(Lokhttp3/OkHttpClient;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {
        private Authenticator authenticator;
        private Cache cache;
        private int callTimeout;
        private CertificateChainCleaner certificateChainCleaner;
        private CertificatePinner certificatePinner;
        private int connectTimeout;
        private ConnectionPool connectionPool;
        private List<ConnectionSpec> connectionSpecs;
        private CookieJar cookieJar;
        private Dispatcher dispatcher;
        private Dns dns;
        private EventListener.Factory eventListenerFactory;
        private boolean followRedirects;
        private boolean followSslRedirects;
        private HostnameVerifier hostnameVerifier;
        private final List<Interceptor> interceptors;
        private long minWebSocketMessageToCompress;
        private final List<Interceptor> networkInterceptors;
        private int pingInterval;
        private List<? extends Protocol> protocols;
        private Proxy proxy;
        private Authenticator proxyAuthenticator;
        private ProxySelector proxySelector;
        private int readTimeout;
        private boolean retryOnConnectionFailure;
        private RouteDatabase routeDatabase;
        private SocketFactory socketFactory;
        private SSLSocketFactory sslSocketFactoryOrNull;
        private int writeTimeout;
        private X509TrustManager x509TrustManagerOrNull;

        public Builder() {
            this.dispatcher = new Dispatcher();
            this.connectionPool = new ConnectionPool();
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.eventListenerFactory = Util.asFactory(EventListener.NONE);
            this.retryOnConnectionFailure = true;
            Authenticator authenticator = Authenticator.NONE;
            this.authenticator = authenticator;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = CookieJar.NO_COOKIES;
            this.dns = Dns.SYSTEM;
            this.proxyAuthenticator = authenticator;
            SocketFactory socketFactory = SocketFactory.getDefault();
            m.e(socketFactory, "SocketFactory.getDefault()");
            this.socketFactory = socketFactory;
            Companion companion = OkHttpClient.INSTANCE;
            this.connectionSpecs = companion.getDEFAULT_CONNECTION_SPECS$okhttp();
            this.protocols = companion.getDEFAULT_PROTOCOLS$okhttp();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.minWebSocketMessageToCompress = RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        }

        /* JADX INFO: renamed from: -addInterceptor, reason: not valid java name */
        public final Builder m486addInterceptor(final Function1<? super Interceptor.Chain, Response> block) {
            m.f(block, "block");
            return addInterceptor(new Interceptor() { // from class: okhttp3.OkHttpClient$Builder$addInterceptor$2
                @Override // okhttp3.Interceptor
                public final Response intercept(Interceptor.Chain chain) {
                    m.f(chain, "chain");
                    return (Response) block.invoke(chain);
                }
            });
        }

        /* JADX INFO: renamed from: -addNetworkInterceptor, reason: not valid java name */
        public final Builder m487addNetworkInterceptor(final Function1<? super Interceptor.Chain, Response> block) {
            m.f(block, "block");
            return addNetworkInterceptor(new Interceptor() { // from class: okhttp3.OkHttpClient$Builder$addNetworkInterceptor$2
                @Override // okhttp3.Interceptor
                public final Response intercept(Interceptor.Chain chain) {
                    m.f(chain, "chain");
                    return (Response) block.invoke(chain);
                }
            });
        }

        public final Builder addInterceptor(Interceptor interceptor) {
            m.f(interceptor, "interceptor");
            this.interceptors.add(interceptor);
            return this;
        }

        public final Builder addNetworkInterceptor(Interceptor interceptor) {
            m.f(interceptor, "interceptor");
            this.networkInterceptors.add(interceptor);
            return this;
        }

        public final Builder authenticator(Authenticator authenticator) {
            m.f(authenticator, "authenticator");
            this.authenticator = authenticator;
            return this;
        }

        public final OkHttpClient build() {
            return new OkHttpClient(this);
        }

        public final Builder cache(Cache cache) {
            this.cache = cache;
            return this;
        }

        public final Builder callTimeout(long timeout, TimeUnit unit) {
            m.f(unit, "unit");
            this.callTimeout = Util.checkDuration("timeout", timeout, unit);
            return this;
        }

        public final Builder certificatePinner(CertificatePinner certificatePinner) {
            m.f(certificatePinner, "certificatePinner");
            if (!m.a(certificatePinner, this.certificatePinner)) {
                this.routeDatabase = null;
            }
            this.certificatePinner = certificatePinner;
            return this;
        }

        public final Builder connectTimeout(long timeout, TimeUnit unit) {
            m.f(unit, "unit");
            this.connectTimeout = Util.checkDuration("timeout", timeout, unit);
            return this;
        }

        public final Builder connectionPool(ConnectionPool connectionPool) {
            m.f(connectionPool, "connectionPool");
            this.connectionPool = connectionPool;
            return this;
        }

        public final Builder connectionSpecs(List<ConnectionSpec> connectionSpecs) {
            m.f(connectionSpecs, "connectionSpecs");
            if (!m.a(connectionSpecs, this.connectionSpecs)) {
                this.routeDatabase = null;
            }
            this.connectionSpecs = Util.toImmutableList(connectionSpecs);
            return this;
        }

        public final Builder cookieJar(CookieJar cookieJar) {
            m.f(cookieJar, "cookieJar");
            this.cookieJar = cookieJar;
            return this;
        }

        public final Builder dispatcher(Dispatcher dispatcher) {
            m.f(dispatcher, "dispatcher");
            this.dispatcher = dispatcher;
            return this;
        }

        public final Builder dns(Dns dns) {
            m.f(dns, "dns");
            if (!m.a(dns, this.dns)) {
                this.routeDatabase = null;
            }
            this.dns = dns;
            return this;
        }

        public final Builder eventListener(EventListener eventListener) {
            m.f(eventListener, "eventListener");
            this.eventListenerFactory = Util.asFactory(eventListener);
            return this;
        }

        public final Builder eventListenerFactory(EventListener.Factory eventListenerFactory) {
            m.f(eventListenerFactory, "eventListenerFactory");
            this.eventListenerFactory = eventListenerFactory;
            return this;
        }

        public final Builder followRedirects(boolean followRedirects) {
            this.followRedirects = followRedirects;
            return this;
        }

        public final Builder followSslRedirects(boolean followProtocolRedirects) {
            this.followSslRedirects = followProtocolRedirects;
            return this;
        }

        /* JADX INFO: renamed from: getAuthenticator$okhttp, reason: from getter */
        public final Authenticator getAuthenticator() {
            return this.authenticator;
        }

        /* JADX INFO: renamed from: getCache$okhttp, reason: from getter */
        public final Cache getCache() {
            return this.cache;
        }

        /* JADX INFO: renamed from: getCallTimeout$okhttp, reason: from getter */
        public final int getCallTimeout() {
            return this.callTimeout;
        }

        /* JADX INFO: renamed from: getCertificateChainCleaner$okhttp, reason: from getter */
        public final CertificateChainCleaner getCertificateChainCleaner() {
            return this.certificateChainCleaner;
        }

        /* JADX INFO: renamed from: getCertificatePinner$okhttp, reason: from getter */
        public final CertificatePinner getCertificatePinner() {
            return this.certificatePinner;
        }

        /* JADX INFO: renamed from: getConnectTimeout$okhttp, reason: from getter */
        public final int getConnectTimeout() {
            return this.connectTimeout;
        }

        /* JADX INFO: renamed from: getConnectionPool$okhttp, reason: from getter */
        public final ConnectionPool getConnectionPool() {
            return this.connectionPool;
        }

        public final List<ConnectionSpec> getConnectionSpecs$okhttp() {
            return this.connectionSpecs;
        }

        /* JADX INFO: renamed from: getCookieJar$okhttp, reason: from getter */
        public final CookieJar getCookieJar() {
            return this.cookieJar;
        }

        /* JADX INFO: renamed from: getDispatcher$okhttp, reason: from getter */
        public final Dispatcher getDispatcher() {
            return this.dispatcher;
        }

        /* JADX INFO: renamed from: getDns$okhttp, reason: from getter */
        public final Dns getDns() {
            return this.dns;
        }

        /* JADX INFO: renamed from: getEventListenerFactory$okhttp, reason: from getter */
        public final EventListener.Factory getEventListenerFactory() {
            return this.eventListenerFactory;
        }

        /* JADX INFO: renamed from: getFollowRedirects$okhttp, reason: from getter */
        public final boolean getFollowRedirects() {
            return this.followRedirects;
        }

        /* JADX INFO: renamed from: getFollowSslRedirects$okhttp, reason: from getter */
        public final boolean getFollowSslRedirects() {
            return this.followSslRedirects;
        }

        /* JADX INFO: renamed from: getHostnameVerifier$okhttp, reason: from getter */
        public final HostnameVerifier getHostnameVerifier() {
            return this.hostnameVerifier;
        }

        public final List<Interceptor> getInterceptors$okhttp() {
            return this.interceptors;
        }

        /* JADX INFO: renamed from: getMinWebSocketMessageToCompress$okhttp, reason: from getter */
        public final long getMinWebSocketMessageToCompress() {
            return this.minWebSocketMessageToCompress;
        }

        public final List<Interceptor> getNetworkInterceptors$okhttp() {
            return this.networkInterceptors;
        }

        /* JADX INFO: renamed from: getPingInterval$okhttp, reason: from getter */
        public final int getPingInterval() {
            return this.pingInterval;
        }

        public final List<Protocol> getProtocols$okhttp() {
            return this.protocols;
        }

        /* JADX INFO: renamed from: getProxy$okhttp, reason: from getter */
        public final Proxy getProxy() {
            return this.proxy;
        }

        /* JADX INFO: renamed from: getProxyAuthenticator$okhttp, reason: from getter */
        public final Authenticator getProxyAuthenticator() {
            return this.proxyAuthenticator;
        }

        /* JADX INFO: renamed from: getProxySelector$okhttp, reason: from getter */
        public final ProxySelector getProxySelector() {
            return this.proxySelector;
        }

        /* JADX INFO: renamed from: getReadTimeout$okhttp, reason: from getter */
        public final int getReadTimeout() {
            return this.readTimeout;
        }

        /* JADX INFO: renamed from: getRetryOnConnectionFailure$okhttp, reason: from getter */
        public final boolean getRetryOnConnectionFailure() {
            return this.retryOnConnectionFailure;
        }

        /* JADX INFO: renamed from: getRouteDatabase$okhttp, reason: from getter */
        public final RouteDatabase getRouteDatabase() {
            return this.routeDatabase;
        }

        /* JADX INFO: renamed from: getSocketFactory$okhttp, reason: from getter */
        public final SocketFactory getSocketFactory() {
            return this.socketFactory;
        }

        /* JADX INFO: renamed from: getSslSocketFactoryOrNull$okhttp, reason: from getter */
        public final SSLSocketFactory getSslSocketFactoryOrNull() {
            return this.sslSocketFactoryOrNull;
        }

        /* JADX INFO: renamed from: getWriteTimeout$okhttp, reason: from getter */
        public final int getWriteTimeout() {
            return this.writeTimeout;
        }

        /* JADX INFO: renamed from: getX509TrustManagerOrNull$okhttp, reason: from getter */
        public final X509TrustManager getX509TrustManagerOrNull() {
            return this.x509TrustManagerOrNull;
        }

        public final Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            m.f(hostnameVerifier, "hostnameVerifier");
            if (!m.a(hostnameVerifier, this.hostnameVerifier)) {
                this.routeDatabase = null;
            }
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        public final List<Interceptor> interceptors() {
            return this.interceptors;
        }

        public final Builder minWebSocketMessageToCompress(long bytes) {
            if (bytes >= 0) {
                this.minWebSocketMessageToCompress = bytes;
                return this;
            }
            throw new IllegalArgumentException(("minWebSocketMessageToCompress must be positive: " + bytes).toString());
        }

        public final List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        public final Builder pingInterval(long interval, TimeUnit unit) {
            m.f(unit, "unit");
            this.pingInterval = Util.checkDuration("interval", interval, unit);
            return this;
        }

        public final Builder protocols(List<? extends Protocol> protocols) {
            m.f(protocols, "protocols");
            List listG0 = c0.G0(protocols);
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!(listG0.contains(protocol) || listG0.contains(Protocol.HTTP_1_1))) {
                throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + listG0).toString());
            }
            if (!(!listG0.contains(protocol) || listG0.size() <= 1)) {
                throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + listG0).toString());
            }
            if (!(!listG0.contains(Protocol.HTTP_1_0))) {
                throw new IllegalArgumentException(("protocols must not contain http/1.0: " + listG0).toString());
            }
            if (!(!listG0.contains(null))) {
                throw new IllegalArgumentException("protocols must not contain null".toString());
            }
            listG0.remove(Protocol.SPDY_3);
            if (!m.a(listG0, this.protocols)) {
                this.routeDatabase = null;
            }
            List<? extends Protocol> listUnmodifiableList = Collections.unmodifiableList(listG0);
            m.e(listUnmodifiableList, "Collections.unmodifiableList(protocolsCopy)");
            this.protocols = listUnmodifiableList;
            return this;
        }

        public final Builder proxy(Proxy proxy) {
            if (!m.a(proxy, this.proxy)) {
                this.routeDatabase = null;
            }
            this.proxy = proxy;
            return this;
        }

        public final Builder proxyAuthenticator(Authenticator proxyAuthenticator) {
            m.f(proxyAuthenticator, "proxyAuthenticator");
            if (!m.a(proxyAuthenticator, this.proxyAuthenticator)) {
                this.routeDatabase = null;
            }
            this.proxyAuthenticator = proxyAuthenticator;
            return this;
        }

        public final Builder proxySelector(ProxySelector proxySelector) {
            m.f(proxySelector, "proxySelector");
            if (!m.a(proxySelector, this.proxySelector)) {
                this.routeDatabase = null;
            }
            this.proxySelector = proxySelector;
            return this;
        }

        public final Builder readTimeout(long timeout, TimeUnit unit) {
            m.f(unit, "unit");
            this.readTimeout = Util.checkDuration("timeout", timeout, unit);
            return this;
        }

        public final Builder retryOnConnectionFailure(boolean retryOnConnectionFailure) {
            this.retryOnConnectionFailure = retryOnConnectionFailure;
            return this;
        }

        public final void setAuthenticator$okhttp(Authenticator authenticator) {
            m.f(authenticator, "<set-?>");
            this.authenticator = authenticator;
        }

        public final void setCache$okhttp(Cache cache) {
            this.cache = cache;
        }

        public final void setCallTimeout$okhttp(int i2) {
            this.callTimeout = i2;
        }

        public final void setCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner) {
            this.certificateChainCleaner = certificateChainCleaner;
        }

        public final void setCertificatePinner$okhttp(CertificatePinner certificatePinner) {
            m.f(certificatePinner, "<set-?>");
            this.certificatePinner = certificatePinner;
        }

        public final void setConnectTimeout$okhttp(int i2) {
            this.connectTimeout = i2;
        }

        public final void setConnectionPool$okhttp(ConnectionPool connectionPool) {
            m.f(connectionPool, "<set-?>");
            this.connectionPool = connectionPool;
        }

        public final void setConnectionSpecs$okhttp(List<ConnectionSpec> list) {
            m.f(list, "<set-?>");
            this.connectionSpecs = list;
        }

        public final void setCookieJar$okhttp(CookieJar cookieJar) {
            m.f(cookieJar, "<set-?>");
            this.cookieJar = cookieJar;
        }

        public final void setDispatcher$okhttp(Dispatcher dispatcher) {
            m.f(dispatcher, "<set-?>");
            this.dispatcher = dispatcher;
        }

        public final void setDns$okhttp(Dns dns) {
            m.f(dns, "<set-?>");
            this.dns = dns;
        }

        public final void setEventListenerFactory$okhttp(EventListener.Factory factory) {
            m.f(factory, "<set-?>");
            this.eventListenerFactory = factory;
        }

        public final void setFollowRedirects$okhttp(boolean z) {
            this.followRedirects = z;
        }

        public final void setFollowSslRedirects$okhttp(boolean z) {
            this.followSslRedirects = z;
        }

        public final void setHostnameVerifier$okhttp(HostnameVerifier hostnameVerifier) {
            m.f(hostnameVerifier, "<set-?>");
            this.hostnameVerifier = hostnameVerifier;
        }

        public final void setMinWebSocketMessageToCompress$okhttp(long j2) {
            this.minWebSocketMessageToCompress = j2;
        }

        public final void setPingInterval$okhttp(int i2) {
            this.pingInterval = i2;
        }

        public final void setProtocols$okhttp(List<? extends Protocol> list) {
            m.f(list, "<set-?>");
            this.protocols = list;
        }

        public final void setProxy$okhttp(Proxy proxy) {
            this.proxy = proxy;
        }

        public final void setProxyAuthenticator$okhttp(Authenticator authenticator) {
            m.f(authenticator, "<set-?>");
            this.proxyAuthenticator = authenticator;
        }

        public final void setProxySelector$okhttp(ProxySelector proxySelector) {
            this.proxySelector = proxySelector;
        }

        public final void setReadTimeout$okhttp(int i2) {
            this.readTimeout = i2;
        }

        public final void setRetryOnConnectionFailure$okhttp(boolean z) {
            this.retryOnConnectionFailure = z;
        }

        public final void setRouteDatabase$okhttp(RouteDatabase routeDatabase) {
            this.routeDatabase = routeDatabase;
        }

        public final void setSocketFactory$okhttp(SocketFactory socketFactory) {
            m.f(socketFactory, "<set-?>");
            this.socketFactory = socketFactory;
        }

        public final void setSslSocketFactoryOrNull$okhttp(SSLSocketFactory sSLSocketFactory) {
            this.sslSocketFactoryOrNull = sSLSocketFactory;
        }

        public final void setWriteTimeout$okhttp(int i2) {
            this.writeTimeout = i2;
        }

        public final void setX509TrustManagerOrNull$okhttp(X509TrustManager x509TrustManager) {
            this.x509TrustManagerOrNull = x509TrustManager;
        }

        public final Builder socketFactory(SocketFactory socketFactory) {
            m.f(socketFactory, "socketFactory");
            if (!(!(socketFactory instanceof SSLSocketFactory))) {
                throw new IllegalArgumentException("socketFactory instanceof SSLSocketFactory".toString());
            }
            if (!m.a(socketFactory, this.socketFactory)) {
                this.routeDatabase = null;
            }
            this.socketFactory = socketFactory;
            return this;
        }

        public final Builder sslSocketFactory(SSLSocketFactory sslSocketFactory) {
            m.f(sslSocketFactory, "sslSocketFactory");
            if (!m.a(sslSocketFactory, this.sslSocketFactoryOrNull)) {
                this.routeDatabase = null;
            }
            this.sslSocketFactoryOrNull = sslSocketFactory;
            Platform.Companion companion = Platform.INSTANCE;
            X509TrustManager x509TrustManagerTrustManager = companion.get().trustManager(sslSocketFactory);
            if (x509TrustManagerTrustManager != null) {
                this.x509TrustManagerOrNull = x509TrustManagerTrustManager;
                Platform platform = companion.get();
                X509TrustManager x509TrustManager = this.x509TrustManagerOrNull;
                m.c(x509TrustManager);
                this.certificateChainCleaner = platform.buildCertificateChainCleaner(x509TrustManager);
                return this;
            }
            throw new IllegalStateException("Unable to extract the trust manager on " + companion.get() + ", sslSocketFactory is " + sslSocketFactory.getClass());
        }

        public final Builder writeTimeout(long timeout, TimeUnit unit) {
            m.f(unit, "unit");
            this.writeTimeout = Util.checkDuration("timeout", timeout, unit);
            return this;
        }

        @IgnoreJRERequirement
        public final Builder callTimeout(Duration duration) {
            m.f(duration, "duration");
            callTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        public final Builder connectTimeout(Duration duration) {
            m.f(duration, "duration");
            connectTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        public final Builder pingInterval(Duration duration) {
            m.f(duration, "duration");
            pingInterval(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        public final Builder readTimeout(Duration duration) {
            m.f(duration, "duration");
            readTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        public final Builder writeTimeout(Duration duration) {
            m.f(duration, "duration");
            writeTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public final Builder sslSocketFactory(SSLSocketFactory sslSocketFactory, X509TrustManager trustManager) {
            m.f(sslSocketFactory, "sslSocketFactory");
            m.f(trustManager, "trustManager");
            if ((!m.a(sslSocketFactory, this.sslSocketFactoryOrNull)) || (!m.a(trustManager, this.x509TrustManagerOrNull))) {
                this.routeDatabase = null;
            }
            this.sslSocketFactoryOrNull = sslSocketFactory;
            this.certificateChainCleaner = CertificateChainCleaner.INSTANCE.get(trustManager);
            this.x509TrustManagerOrNull = trustManager;
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(OkHttpClient okHttpClient) {
            this();
            m.f(okHttpClient, "okHttpClient");
            this.dispatcher = okHttpClient.dispatcher();
            this.connectionPool = okHttpClient.connectionPool();
            z.z(this.interceptors, okHttpClient.interceptors());
            z.z(this.networkInterceptors, okHttpClient.networkInterceptors());
            this.eventListenerFactory = okHttpClient.eventListenerFactory();
            this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure();
            this.authenticator = okHttpClient.authenticator();
            this.followRedirects = okHttpClient.followRedirects();
            this.followSslRedirects = okHttpClient.followSslRedirects();
            this.cookieJar = okHttpClient.cookieJar();
            this.cache = okHttpClient.cache();
            this.dns = okHttpClient.dns();
            this.proxy = okHttpClient.proxy();
            this.proxySelector = okHttpClient.proxySelector();
            this.proxyAuthenticator = okHttpClient.proxyAuthenticator();
            this.socketFactory = okHttpClient.socketFactory();
            this.sslSocketFactoryOrNull = okHttpClient.sslSocketFactoryOrNull;
            this.x509TrustManagerOrNull = okHttpClient.getX509TrustManager();
            this.connectionSpecs = okHttpClient.connectionSpecs();
            this.protocols = okHttpClient.protocols();
            this.hostnameVerifier = okHttpClient.hostnameVerifier();
            this.certificatePinner = okHttpClient.certificatePinner();
            this.certificateChainCleaner = okHttpClient.getCertificateChainCleaner();
            this.callTimeout = okHttpClient.callTimeoutMillis();
            this.connectTimeout = okHttpClient.connectTimeoutMillis();
            this.readTimeout = okHttpClient.readTimeoutMillis();
            this.writeTimeout = okHttpClient.writeTimeoutMillis();
            this.pingInterval = okHttpClient.pingIntervalMillis();
            this.minWebSocketMessageToCompress = okHttpClient.getMinWebSocketMessageToCompress();
            this.routeDatabase = okHttpClient.getRouteDatabase();
        }
    }

    /* JADX INFO: compiled from: OkHttpClient.kt */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\r"}, d2 = {"Lokhttp3/OkHttpClient$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "Lokhttp3/Protocol;", "DEFAULT_PROTOCOLS", "Ljava/util/List;", "getDEFAULT_PROTOCOLS$okhttp", "()Ljava/util/List;", "Lokhttp3/ConnectionSpec;", "DEFAULT_CONNECTION_SPECS", "getDEFAULT_CONNECTION_SPECS$okhttp", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final List<ConnectionSpec> getDEFAULT_CONNECTION_SPECS$okhttp() {
            return OkHttpClient.DEFAULT_CONNECTION_SPECS;
        }

        public final List<Protocol> getDEFAULT_PROTOCOLS$okhttp() {
            return OkHttpClient.DEFAULT_PROTOCOLS;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public OkHttpClient(Builder builder) {
        ProxySelector proxySelector;
        m.f(builder, "builder");
        this.dispatcher = builder.getDispatcher();
        this.connectionPool = builder.getConnectionPool();
        this.interceptors = Util.toImmutableList(builder.getInterceptors$okhttp());
        this.networkInterceptors = Util.toImmutableList(builder.getNetworkInterceptors$okhttp());
        this.eventListenerFactory = builder.getEventListenerFactory();
        this.retryOnConnectionFailure = builder.getRetryOnConnectionFailure();
        this.authenticator = builder.getAuthenticator();
        this.followRedirects = builder.getFollowRedirects();
        this.followSslRedirects = builder.getFollowSslRedirects();
        this.cookieJar = builder.getCookieJar();
        this.cache = builder.getCache();
        this.dns = builder.getDns();
        this.proxy = builder.getProxy();
        if (builder.getProxy() != null) {
            proxySelector = NullProxySelector.INSTANCE;
        } else {
            proxySelector = builder.getProxySelector();
            proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
            if (proxySelector == null) {
                proxySelector = NullProxySelector.INSTANCE;
            }
        }
        this.proxySelector = proxySelector;
        this.proxyAuthenticator = builder.getProxyAuthenticator();
        this.socketFactory = builder.getSocketFactory();
        List<ConnectionSpec> connectionSpecs$okhttp = builder.getConnectionSpecs$okhttp();
        this.connectionSpecs = connectionSpecs$okhttp;
        this.protocols = builder.getProtocols$okhttp();
        this.hostnameVerifier = builder.getHostnameVerifier();
        this.callTimeoutMillis = builder.getCallTimeout();
        this.connectTimeoutMillis = builder.getConnectTimeout();
        this.readTimeoutMillis = builder.getReadTimeout();
        this.writeTimeoutMillis = builder.getWriteTimeout();
        this.pingIntervalMillis = builder.getPingInterval();
        this.minWebSocketMessageToCompress = builder.getMinWebSocketMessageToCompress();
        RouteDatabase routeDatabase = builder.getRouteDatabase();
        this.routeDatabase = routeDatabase == null ? new RouteDatabase() : routeDatabase;
        boolean z = true;
        if (!(connectionSpecs$okhttp instanceof Collection) || !connectionSpecs$okhttp.isEmpty()) {
            Iterator<T> it = connectionSpecs$okhttp.iterator();
            while (it.hasNext()) {
                if (((ConnectionSpec) it.next()).getIsTls()) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            this.sslSocketFactoryOrNull = null;
            this.certificateChainCleaner = null;
            this.x509TrustManager = null;
            this.certificatePinner = CertificatePinner.DEFAULT;
        } else if (builder.getSslSocketFactoryOrNull() != null) {
            this.sslSocketFactoryOrNull = builder.getSslSocketFactoryOrNull();
            CertificateChainCleaner certificateChainCleaner = builder.getCertificateChainCleaner();
            m.c(certificateChainCleaner);
            this.certificateChainCleaner = certificateChainCleaner;
            X509TrustManager x509TrustManagerOrNull = builder.getX509TrustManagerOrNull();
            m.c(x509TrustManagerOrNull);
            this.x509TrustManager = x509TrustManagerOrNull;
            CertificatePinner certificatePinner = builder.getCertificatePinner();
            m.c(certificateChainCleaner);
            this.certificatePinner = certificatePinner.withCertificateChainCleaner$okhttp(certificateChainCleaner);
        } else {
            Platform.Companion companion = Platform.INSTANCE;
            X509TrustManager x509TrustManagerPlatformTrustManager = companion.get().platformTrustManager();
            this.x509TrustManager = x509TrustManagerPlatformTrustManager;
            Platform platform = companion.get();
            m.c(x509TrustManagerPlatformTrustManager);
            this.sslSocketFactoryOrNull = platform.newSslSocketFactory(x509TrustManagerPlatformTrustManager);
            CertificateChainCleaner.Companion companion2 = CertificateChainCleaner.INSTANCE;
            m.c(x509TrustManagerPlatformTrustManager);
            CertificateChainCleaner certificateChainCleaner2 = companion2.get(x509TrustManagerPlatformTrustManager);
            this.certificateChainCleaner = certificateChainCleaner2;
            CertificatePinner certificatePinner2 = builder.getCertificatePinner();
            m.c(certificateChainCleaner2);
            this.certificatePinner = certificatePinner2.withCertificateChainCleaner$okhttp(certificateChainCleaner2);
        }
        verifyClientState();
    }

    private final void verifyClientState() {
        boolean z;
        List<Interceptor> list = this.interceptors;
        if (list == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
        if (!(!list.contains(null))) {
            throw new IllegalStateException(("Null interceptor: " + this.interceptors).toString());
        }
        List<Interceptor> list2 = this.networkInterceptors;
        if (list2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
        if (!(!list2.contains(null))) {
            throw new IllegalStateException(("Null network interceptor: " + this.networkInterceptors).toString());
        }
        List<ConnectionSpec> list3 = this.connectionSpecs;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator<T> it = list3.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (((ConnectionSpec) it.next()).getIsTls()) {
                    z = false;
                    break;
                }
            }
        } else {
            z = true;
            break;
        }
        if (!z) {
            if (this.sslSocketFactoryOrNull == null) {
                throw new IllegalStateException("sslSocketFactory == null".toString());
            }
            if (this.certificateChainCleaner == null) {
                throw new IllegalStateException("certificateChainCleaner == null".toString());
            }
            if (this.x509TrustManager == null) {
                throw new IllegalStateException("x509TrustManager == null".toString());
            }
            return;
        }
        if (!(this.sslSocketFactoryOrNull == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.certificateChainCleaner == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.x509TrustManager == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!m.a(this.certificatePinner, CertificatePinner.DEFAULT)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX INFO: renamed from: -deprecated_authenticator, reason: not valid java name and from getter */
    public final Authenticator getAuthenticator() {
        return this.authenticator;
    }

    /* JADX INFO: renamed from: -deprecated_cache, reason: not valid java name and from getter */
    public final Cache getCache() {
        return this.cache;
    }

    /* JADX INFO: renamed from: -deprecated_callTimeoutMillis, reason: not valid java name and from getter */
    public final int getCallTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    /* JADX INFO: renamed from: -deprecated_certificatePinner, reason: not valid java name and from getter */
    public final CertificatePinner getCertificatePinner() {
        return this.certificatePinner;
    }

    /* JADX INFO: renamed from: -deprecated_connectTimeoutMillis, reason: not valid java name and from getter */
    public final int getConnectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    /* JADX INFO: renamed from: -deprecated_connectionPool, reason: not valid java name and from getter */
    public final ConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    /* JADX INFO: renamed from: -deprecated_connectionSpecs, reason: not valid java name */
    public final List<ConnectionSpec> m466deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    /* JADX INFO: renamed from: -deprecated_cookieJar, reason: not valid java name and from getter */
    public final CookieJar getCookieJar() {
        return this.cookieJar;
    }

    /* JADX INFO: renamed from: -deprecated_dispatcher, reason: not valid java name and from getter */
    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    /* JADX INFO: renamed from: -deprecated_dns, reason: not valid java name and from getter */
    public final Dns getDns() {
        return this.dns;
    }

    /* JADX INFO: renamed from: -deprecated_eventListenerFactory, reason: not valid java name and from getter */
    public final EventListener.Factory getEventListenerFactory() {
        return this.eventListenerFactory;
    }

    /* JADX INFO: renamed from: -deprecated_followRedirects, reason: not valid java name and from getter */
    public final boolean getFollowRedirects() {
        return this.followRedirects;
    }

    /* JADX INFO: renamed from: -deprecated_followSslRedirects, reason: not valid java name and from getter */
    public final boolean getFollowSslRedirects() {
        return this.followSslRedirects;
    }

    /* JADX INFO: renamed from: -deprecated_hostnameVerifier, reason: not valid java name and from getter */
    public final HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    /* JADX INFO: renamed from: -deprecated_interceptors, reason: not valid java name */
    public final List<Interceptor> m474deprecated_interceptors() {
        return this.interceptors;
    }

    /* JADX INFO: renamed from: -deprecated_networkInterceptors, reason: not valid java name */
    public final List<Interceptor> m475deprecated_networkInterceptors() {
        return this.networkInterceptors;
    }

    /* JADX INFO: renamed from: -deprecated_pingIntervalMillis, reason: not valid java name and from getter */
    public final int getPingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    /* JADX INFO: renamed from: -deprecated_protocols, reason: not valid java name */
    public final List<Protocol> m477deprecated_protocols() {
        return this.protocols;
    }

    /* JADX INFO: renamed from: -deprecated_proxy, reason: not valid java name and from getter */
    public final Proxy getProxy() {
        return this.proxy;
    }

    /* JADX INFO: renamed from: -deprecated_proxyAuthenticator, reason: not valid java name and from getter */
    public final Authenticator getProxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    /* JADX INFO: renamed from: -deprecated_proxySelector, reason: not valid java name and from getter */
    public final ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    /* JADX INFO: renamed from: -deprecated_readTimeoutMillis, reason: not valid java name and from getter */
    public final int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    /* JADX INFO: renamed from: -deprecated_retryOnConnectionFailure, reason: not valid java name and from getter */
    public final boolean getRetryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    /* JADX INFO: renamed from: -deprecated_socketFactory, reason: not valid java name and from getter */
    public final SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    /* JADX INFO: renamed from: -deprecated_sslSocketFactory, reason: not valid java name */
    public final SSLSocketFactory m484deprecated_sslSocketFactory() {
        return sslSocketFactory();
    }

    /* JADX INFO: renamed from: -deprecated_writeTimeoutMillis, reason: not valid java name and from getter */
    public final int getWriteTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    public final Authenticator authenticator() {
        return this.authenticator;
    }

    public final Cache cache() {
        return this.cache;
    }

    public final int callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    /* JADX INFO: renamed from: certificateChainCleaner, reason: from getter */
    public final CertificateChainCleaner getCertificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public Object clone() {
        return super.clone();
    }

    public final int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    public final ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public final CookieJar cookieJar() {
        return this.cookieJar;
    }

    public final Dispatcher dispatcher() {
        return this.dispatcher;
    }

    public final Dns dns() {
        return this.dns;
    }

    public final EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    public final boolean followRedirects() {
        return this.followRedirects;
    }

    public final boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    public final RouteDatabase getRouteDatabase() {
        return this.routeDatabase;
    }

    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<Interceptor> interceptors() {
        return this.interceptors;
    }

    /* JADX INFO: renamed from: minWebSocketMessageToCompress, reason: from getter */
    public final long getMinWebSocketMessageToCompress() {
        return this.minWebSocketMessageToCompress;
    }

    public final List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    @Override // okhttp3.Call.Factory
    public Call newCall(Request request) {
        m.f(request, "request");
        return new RealCall(this, request, false);
    }

    @Override // okhttp3.WebSocket.Factory
    public WebSocket newWebSocket(Request request, WebSocketListener listener) {
        m.f(request, "request");
        m.f(listener, "listener");
        RealWebSocket realWebSocket = new RealWebSocket(TaskRunner.INSTANCE, request, listener, new Random(), this.pingIntervalMillis, null, this.minWebSocketMessageToCompress);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    public final int pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    public final List<Protocol> protocols() {
        return this.protocols;
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public final int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public final boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory sslSocketFactory() {
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactoryOrNull;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    public final int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    /* JADX INFO: renamed from: x509TrustManager, reason: from getter */
    public final X509TrustManager getX509TrustManager() {
        return this.x509TrustManager;
    }

    public OkHttpClient() {
        this(new Builder());
    }
}
