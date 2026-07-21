package okhttp3.internal.connection;

import j.d;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.b;
import kotlin.collections.z;
import kotlin.jvm.internal.m;
import kotlin.u;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CertificatePinner;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;

/* JADX INFO: compiled from: RealCall.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t*\u0001m\u0018\u00002\u00020\u0001:\u0002z{B\u001f\u0012\u0006\u0010t\u001a\u00020s\u0012\u0006\u0010N\u001a\u00020\u0019\u0012\u0006\u0010a\u001a\u00020\u001d¢\u0006\u0004\bx\u0010yJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\b\u001a\u00028\u0000\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000b\u001a\u00028\u0000\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u001dH\u0016¢\u0006\u0004\b'\u0010\u001fJ\u000f\u0010)\u001a\u00020 H\u0000¢\u0006\u0004\b(\u0010\"J\u001d\u0010+\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u001d¢\u0006\u0004\b+\u0010,J\u0017\u00102\u001a\u00020/2\u0006\u0010.\u001a\u00020-H\u0000¢\u0006\u0004\b0\u00101J\u0015\u00105\u001a\u00020\u00022\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J;\u0010<\u001a\u00028\u0000\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\u00052\u0006\u00107\u001a\u00020/2\u0006\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00028\u0000H\u0000¢\u0006\u0004\b:\u0010;J\u001b\u0010>\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b=\u0010\tJ\u0011\u0010B\u001a\u0004\u0018\u00010?H\u0000¢\u0006\u0004\b@\u0010AJ\r\u0010C\u001a\u00020\u0002¢\u0006\u0004\bC\u0010\u0004J\u0017\u0010G\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u001dH\u0000¢\u0006\u0004\bE\u0010FJ\r\u0010H\u001a\u00020\u001d¢\u0006\u0004\bH\u0010\u001fJ\u000f\u0010J\u001a\u00020\u0011H\u0000¢\u0006\u0004\bI\u0010\u0013R\u0016\u0010L\u001a\u00020K8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0019\u0010N\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010\u001bR\u0016\u0010Q\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020S8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010RR$\u0010W\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u00106R\u0016\u0010C\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010RR(\u00104\u001a\u0004\u0018\u0001032\b\u0010\\\u001a\u0004\u0018\u0001038\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b4\u0010X\u001a\u0004\b]\u0010ZR\u0018\u0010_\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0019\u0010a\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\ba\u0010R\u001a\u0004\bb\u0010\u001fR\u001c\u0010d\u001a\u00020c8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR\u0016\u0010h\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010RR\u0018\u0010j\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010l\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010RR\u0016\u0010\u0015\u001a\u00020m8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010nR\u0018\u00107\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010oR(\u0010p\u001a\u0004\u0018\u00010/2\b\u0010\\\u001a\u0004\u0018\u00010/8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bp\u0010o\u001a\u0004\bq\u0010rR\u0019\u0010t\u001a\u00020s8\u0006@\u0006¢\u0006\f\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w¨\u0006|"}, d2 = {"Lokhttp3/internal/connection/RealCall;", "Lokhttp3/Call;", "Lkotlin/u;", "callStart", "()V", "Ljava/io/IOException;", "E", "e", "callDone", "(Ljava/io/IOException;)Ljava/io/IOException;", "cause", "timeoutExit", "Lokhttp3/HttpUrl;", "url", "Lokhttp3/Address;", "createAddress", "(Lokhttp3/HttpUrl;)Lokhttp3/Address;", HttpUrl.FRAGMENT_ENCODE_SET, "toLoggableString", "()Ljava/lang/String;", "Lj/d;", "timeout", "()Lj/d;", "clone", "()Lokhttp3/internal/connection/RealCall;", "Lokhttp3/Request;", "request", "()Lokhttp3/Request;", "cancel", HttpUrl.FRAGMENT_ENCODE_SET, "isCanceled", "()Z", "Lokhttp3/Response;", "execute", "()Lokhttp3/Response;", "Lokhttp3/Callback;", "responseCallback", "enqueue", "(Lokhttp3/Callback;)V", "isExecuted", "getResponseWithInterceptorChain$okhttp", "getResponseWithInterceptorChain", "newExchangeFinder", "enterNetworkInterceptorExchange", "(Lokhttp3/Request;Z)V", "Lokhttp3/internal/http/RealInterceptorChain;", "chain", "Lokhttp3/internal/connection/Exchange;", "initExchange$okhttp", "(Lokhttp3/internal/http/RealInterceptorChain;)Lokhttp3/internal/connection/Exchange;", "initExchange", "Lokhttp3/internal/connection/RealConnection;", "connection", "acquireConnectionNoEvents", "(Lokhttp3/internal/connection/RealConnection;)V", "exchange", "requestDone", "responseDone", "messageDone$okhttp", "(Lokhttp3/internal/connection/Exchange;ZZLjava/io/IOException;)Ljava/io/IOException;", "messageDone", "noMoreExchanges$okhttp", "noMoreExchanges", "Ljava/net/Socket;", "releaseConnectionNoEvents$okhttp", "()Ljava/net/Socket;", "releaseConnectionNoEvents", "timeoutEarlyExit", "closeExchange", "exitNetworkInterceptorExchange$okhttp", "(Z)V", "exitNetworkInterceptorExchange", "retryAfterFailure", "redactedUrl$okhttp", "redactedUrl", "Ljava/util/concurrent/atomic/AtomicBoolean;", "executed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "originalRequest", "Lokhttp3/Request;", "getOriginalRequest", "responseBodyOpen", "Z", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "canceled", "connectionToCancel", "Lokhttp3/internal/connection/RealConnection;", "getConnectionToCancel", "()Lokhttp3/internal/connection/RealConnection;", "setConnectionToCancel", "<set-?>", "getConnection", HttpUrl.FRAGMENT_ENCODE_SET, "callStackTrace", "Ljava/lang/Object;", "forWebSocket", "getForWebSocket", "Lokhttp3/EventListener;", "eventListener", "Lokhttp3/EventListener;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "requestBodyOpen", "Lokhttp3/internal/connection/ExchangeFinder;", "exchangeFinder", "Lokhttp3/internal/connection/ExchangeFinder;", "expectMoreExchanges", "okhttp3/internal/connection/RealCall$timeout$1", "Lokhttp3/internal/connection/RealCall$timeout$1;", "Lokhttp3/internal/connection/Exchange;", "interceptorScopedExchange", "getInterceptorScopedExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Z)V", "AsyncCall", "CallReference", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RealCall implements Call {
    private Object callStackTrace;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private RealConnection connection;
    private final RealConnectionPool connectionPool;
    private volatile RealConnection connectionToCancel;
    private final EventListener eventListener;
    private volatile Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private final AtomicBoolean executed;
    private boolean expectMoreExchanges;
    private final boolean forWebSocket;
    private Exchange interceptorScopedExchange;
    private final Request originalRequest;
    private boolean requestBodyOpen;
    private boolean responseBodyOpen;
    private final AnonymousClass1 timeout;
    private boolean timeoutEarlyExit;

    /* JADX INFO: compiled from: RealCall.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b!\u0010\"J\u0019\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u00060\u0000R\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0013\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00148\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001d\u001a\u00020\u001a8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010 \u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lokhttp3/internal/connection/RealCall$AsyncCall;", "Ljava/lang/Runnable;", "Lokhttp3/internal/connection/RealCall;", "other", "Lkotlin/u;", "reuseCallsPerHostFrom", "(Lokhttp3/internal/connection/RealCall$AsyncCall;)V", "Ljava/util/concurrent/ExecutorService;", "executorService", "executeOn", "(Ljava/util/concurrent/ExecutorService;)V", "run", "()V", "Lokhttp3/Callback;", "responseCallback", "Lokhttp3/Callback;", "Lokhttp3/Request;", "getRequest", "()Lokhttp3/Request;", "request", "Ljava/util/concurrent/atomic/AtomicInteger;", "<set-?>", "callsPerHost", "Ljava/util/concurrent/atomic/AtomicInteger;", "getCallsPerHost", "()Ljava/util/concurrent/atomic/AtomicInteger;", HttpUrl.FRAGMENT_ENCODE_SET, "getHost", "()Ljava/lang/String;", "host", "getCall", "()Lokhttp3/internal/connection/RealCall;", "call", "<init>", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/Callback;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class AsyncCall implements Runnable {
        private volatile AtomicInteger callsPerHost;
        private final Callback responseCallback;
        final /* synthetic */ RealCall this$0;

        public AsyncCall(RealCall realCall, Callback callback) {
            m.f(callback, "responseCallback");
            this.this$0 = realCall;
            this.responseCallback = callback;
            this.callsPerHost = new AtomicInteger(0);
        }

        public final void executeOn(ExecutorService executorService) {
            m.f(executorService, "executorService");
            Dispatcher dispatcher = this.this$0.getClient().dispatcher();
            if (Util.assertionsEnabled && Thread.holdsLock(dispatcher)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread threadCurrentThread = Thread.currentThread();
                m.e(threadCurrentThread, "Thread.currentThread()");
                sb.append(threadCurrentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(dispatcher);
                throw new AssertionError(sb.toString());
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e2) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e2);
                    this.this$0.noMoreExchanges$okhttp(interruptedIOException);
                    this.responseCallback.onFailure(this.this$0, interruptedIOException);
                    this.this$0.getClient().dispatcher().finished$okhttp(this);
                }
            } catch (Throwable th) {
                this.this$0.getClient().dispatcher().finished$okhttp(this);
                throw th;
            }
        }

        /* JADX INFO: renamed from: getCall, reason: from getter */
        public final RealCall getThis$0() {
            return this.this$0;
        }

        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        public final String getHost() {
            return this.this$0.getOriginalRequest().url().host();
        }

        public final Request getRequest() {
            return this.this$0.getOriginalRequest();
        }

        public final void reuseCallsPerHostFrom(AsyncCall other) {
            m.f(other, "other");
            this.callsPerHost = other.callsPerHost;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            boolean z;
            IOException e2;
            Dispatcher dispatcher;
            String str = "OkHttp " + this.this$0.redactedUrl$okhttp();
            Thread threadCurrentThread = Thread.currentThread();
            m.e(threadCurrentThread, "currentThread");
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(str);
            try {
                try {
                    enter();
                    try {
                        z = true;
                        try {
                            this.responseCallback.onResponse(this.this$0, this.this$0.getResponseWithInterceptorChain$okhttp());
                            dispatcher = this.this$0.getClient().dispatcher();
                        } catch (IOException e3) {
                            e2 = e3;
                            if (z) {
                                Platform.INSTANCE.get().log("Callback failure for " + this.this$0.toLoggableString(), 4, e2);
                            } else {
                                this.responseCallback.onFailure(this.this$0, e2);
                            }
                            dispatcher = this.this$0.getClient().dispatcher();
                        } catch (Throwable th2) {
                            th = th2;
                            this.this$0.cancel();
                            if (!z) {
                                IOException iOException = new IOException("canceled due to " + th);
                                b.a(iOException, th);
                                this.responseCallback.onFailure(this.this$0, iOException);
                            }
                            throw th;
                        }
                    } catch (IOException e4) {
                        e2 = e4;
                        z = false;
                    } catch (Throwable th3) {
                        th = th3;
                        z = false;
                    }
                    dispatcher.finished$okhttp(this);
                    threadCurrentThread.setName(name);
                } catch (Throwable th4) {
                    this.this$0.getClient().dispatcher().finished$okhttp(this);
                    throw th4;
                }
            } catch (Throwable th5) {
                threadCurrentThread.setName(name);
                throw th5;
            }
        }
    }

    /* JADX INFO: compiled from: RealCall.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/connection/RealCall$CallReference;", "Ljava/lang/ref/WeakReference;", "Lokhttp3/internal/connection/RealCall;", HttpUrl.FRAGMENT_ENCODE_SET, "callStackTrace", "Ljava/lang/Object;", "getCallStackTrace", "()Ljava/lang/Object;", "referent", "<init>", "(Lokhttp3/internal/connection/RealCall;Ljava/lang/Object;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class CallReference extends WeakReference<RealCall> {
        private final Object callStackTrace;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CallReference(RealCall realCall, Object obj) {
            super(realCall);
            m.f(realCall, "referent");
            this.callStackTrace = obj;
        }

        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [j.e0, okhttp3.internal.connection.RealCall$timeout$1] */
    public RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        m.f(okHttpClient, "client");
        m.f(request, "originalRequest");
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
        this.connectionPool = okHttpClient.connectionPool().getDelegate();
        this.eventListener = okHttpClient.eventListenerFactory().create(this);
        ?? r4 = new d() { // from class: okhttp3.internal.connection.RealCall.timeout.1
            @Override // j.d
            protected void timedOut() {
                RealCall.this.cancel();
            }
        };
        r4.timeout(okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
        u uVar = u.a;
        this.timeout = r4;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final <E extends IOException> E callDone(E e2) {
        Socket socketReleaseConnectionNoEvents$okhttp;
        boolean z = Util.assertionsEnabled;
        if (z && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            m.e(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        RealConnection realConnection = this.connection;
        if (realConnection != null) {
            if (z && Thread.holdsLock(realConnection)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Thread ");
                Thread threadCurrentThread2 = Thread.currentThread();
                m.e(threadCurrentThread2, "Thread.currentThread()");
                sb2.append(threadCurrentThread2.getName());
                sb2.append(" MUST NOT hold lock on ");
                sb2.append(realConnection);
                throw new AssertionError(sb2.toString());
            }
            synchronized (realConnection) {
                socketReleaseConnectionNoEvents$okhttp = releaseConnectionNoEvents$okhttp();
            }
            if (this.connection == null) {
                if (socketReleaseConnectionNoEvents$okhttp != null) {
                    Util.closeQuietly(socketReleaseConnectionNoEvents$okhttp);
                }
                this.eventListener.connectionReleased(this, realConnection);
            } else {
                if (!(socketReleaseConnectionNoEvents$okhttp == null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        E e3 = (E) timeoutExit(e2);
        if (e2 != null) {
            EventListener eventListener = this.eventListener;
            m.c(e3);
            eventListener.callFailed(this, e3);
        } else {
            this.eventListener.callEnd(this);
        }
        return e3;
    }

    private final void callStart() {
        this.callStackTrace = Platform.INSTANCE.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this);
    }

    private final Address createAddress(HttpUrl url) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        if (url.getIsHttps()) {
            SSLSocketFactory sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(url.host(), url.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    private final <E extends IOException> E timeoutExit(E cause) {
        if (this.timeoutEarlyExit || !exit()) {
            return cause;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (cause != null) {
            interruptedIOException.initCause(cause);
        }
        return interruptedIOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toLoggableString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getCanceled() ? "canceled " : HttpUrl.FRAGMENT_ENCODE_SET);
        sb.append(this.forWebSocket ? "web socket" : "call");
        sb.append(" to ");
        sb.append(redactedUrl$okhttp());
        return sb.toString();
    }

    public final void acquireConnectionNoEvents(RealConnection connection) {
        m.f(connection, "connection");
        if (!Util.assertionsEnabled || Thread.holdsLock(connection)) {
            if (!(this.connection == null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            this.connection = connection;
            connection.getCalls().add(new CallReference(this, this.callStackTrace));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        m.e(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(connection);
        throw new AssertionError(sb.toString());
    }

    @Override // okhttp3.Call
    public void cancel() {
        if (this.canceled) {
            return;
        }
        this.canceled = true;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            exchange.cancel();
        }
        RealConnection realConnection = this.connectionToCancel;
        if (realConnection != null) {
            realConnection.cancel();
        }
        this.eventListener.canceled(this);
    }

    @Override // okhttp3.Call
    public void enqueue(Callback responseCallback) {
        m.f(responseCallback, "responseCallback");
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        callStart();
        this.client.dispatcher().enqueue$okhttp(new AsyncCall(this, responseCallback));
    }

    public final void enterNetworkInterceptorExchange(Request request, boolean newExchangeFinder) {
        m.f(request, "request");
        if (!(this.interceptorScopedExchange == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        synchronized (this) {
            if (!(!this.responseBodyOpen)) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
            }
            if (!(!this.requestBodyOpen)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            u uVar = u.a;
        }
        if (newExchangeFinder) {
            this.exchangeFinder = new ExchangeFinder(this.connectionPool, createAddress(request.url()), this, this.eventListener);
        }
    }

    @Override // okhttp3.Call
    public Response execute() {
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        enter();
        callStart();
        try {
            this.client.dispatcher().executed$okhttp(this);
            return getResponseWithInterceptorChain$okhttp();
        } finally {
            this.client.dispatcher().finished$okhttp(this);
        }
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean closeExchange) {
        Exchange exchange;
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released".toString());
            }
            u uVar = u.a;
        }
        if (closeExchange && (exchange = this.exchange) != null) {
            exchange.detachWithViolence();
        }
        this.interceptorScopedExchange = null;
    }

    public final OkHttpClient getClient() {
        return this.client;
    }

    public final RealConnection getConnection() {
        return this.connection;
    }

    public final RealConnection getConnectionToCancel() {
        return this.connectionToCancel;
    }

    /* JADX INFO: renamed from: getEventListener$okhttp, reason: from getter */
    public final EventListener getEventListener() {
        return this.eventListener;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    /* JADX INFO: renamed from: getInterceptorScopedExchange$okhttp, reason: from getter */
    public final Exchange getInterceptorScopedExchange() {
        return this.interceptorScopedExchange;
    }

    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00a2  */
    public final Response getResponseWithInterceptorChain$okhttp() throws Throwable {
        ArrayList arrayList = new ArrayList();
        z.z(arrayList, this.client.interceptors());
        arrayList.add(new RetryAndFollowUpInterceptor(this.client));
        arrayList.add(new BridgeInterceptor(this.client.cookieJar()));
        arrayList.add(new CacheInterceptor(this.client.cache()));
        arrayList.add(ConnectInterceptor.INSTANCE);
        if (!this.forWebSocket) {
            z.z(arrayList, this.client.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.forWebSocket));
        boolean z = false;
        try {
            Response responseProceed = new RealInterceptorChain(this, arrayList, 0, null, this.originalRequest, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
            if (getCanceled()) {
                Util.closeQuietly(responseProceed);
                throw new IOException("Canceled");
            }
            noMoreExchanges$okhttp(null);
            return responseProceed;
        } catch (IOException e2) {
            try {
                IOException iOExceptionNoMoreExchanges$okhttp = noMoreExchanges$okhttp(e2);
                if (iOExceptionNoMoreExchanges$okhttp == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
                throw iOExceptionNoMoreExchanges$okhttp;
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    noMoreExchanges$okhttp(null);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (!z) {
                noMoreExchanges$okhttp(null);
            }
            throw th;
        }
    }

    public final Exchange initExchange$okhttp(RealInterceptorChain chain) throws IOException {
        m.f(chain, "chain");
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released".toString());
            }
            if (!(!this.responseBodyOpen)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (!(!this.requestBodyOpen)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            u uVar = u.a;
        }
        ExchangeFinder exchangeFinder = this.exchangeFinder;
        m.c(exchangeFinder);
        Exchange exchange = new Exchange(this, this.eventListener, exchangeFinder, exchangeFinder.find(this.client, chain));
        this.interceptorScopedExchange = exchange;
        this.exchange = exchange;
        synchronized (this) {
            this.requestBodyOpen = true;
            this.responseBodyOpen = true;
        }
        if (this.canceled) {
            throw new IOException("Canceled");
        }
        return exchange;
    }

    @Override // okhttp3.Call
    /* JADX INFO: renamed from: isCanceled, reason: from getter */
    public boolean getCanceled() {
        return this.canceled;
    }

    @Override // okhttp3.Call
    public boolean isExecuted() {
        return this.executed.get();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0021 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0023 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:8:0x0014, B:17:0x0023, B:19:0x0027, B:20:0x0029, B:22:0x002d, B:27:0x0036, B:29:0x003a, B:35:0x0043, B:14:0x001d), top: B:47:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0027 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:8:0x0014, B:17:0x0023, B:19:0x0027, B:20:0x0029, B:22:0x002d, B:27:0x0036, B:29:0x003a, B:35:0x0043, B:14:0x001d), top: B:47:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0033  */
    /* JADX WARN: Code duplicated, block: B:32:0x003f  */
    public final <E extends IOException> E messageDone$okhttp(Exchange exchange, boolean requestDone, boolean responseDone, E e2) {
        boolean z;
        boolean z2;
        boolean z3;
        m.f(exchange, "exchange");
        boolean z4 = true;
        if (!m.a(exchange, this.exchange)) {
            return e2;
        }
        synchronized (this) {
            z = false;
            if (requestDone) {
                try {
                    if (this.requestBodyOpen) {
                        if (requestDone) {
                            this.requestBodyOpen = false;
                        }
                        if (responseDone) {
                            this.responseBodyOpen = false;
                        }
                        z2 = this.requestBodyOpen;
                        if (z2) {
                            z3 = false;
                        } else {
                            z3 = false;
                        }
                        if (z2) {
                            z4 = false;
                        } else {
                            z4 = false;
                        }
                        z = z3;
                    } else if (responseDone || !this.responseBodyOpen) {
                        z4 = false;
                    } else {
                        if (requestDone) {
                            this.requestBodyOpen = false;
                        }
                        if (responseDone) {
                            this.responseBodyOpen = false;
                        }
                        z2 = this.requestBodyOpen;
                        if (z2 || this.responseBodyOpen) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (z2 || this.responseBodyOpen || this.expectMoreExchanges) {
                            z4 = false;
                        }
                        z = z3;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                if (responseDone) {
                }
                z4 = false;
            }
            u uVar = u.a;
        }
        if (z) {
            this.exchange = null;
            RealConnection realConnection = this.connection;
            if (realConnection != null) {
                realConnection.incrementSuccessCount$okhttp();
            }
        }
        return z4 ? (E) callDone(e2) : e2;
    }

    public final IOException noMoreExchanges$okhttp(IOException e2) {
        boolean z;
        synchronized (this) {
            z = false;
            if (this.expectMoreExchanges) {
                this.expectMoreExchanges = false;
                if (!this.requestBodyOpen && !this.responseBodyOpen) {
                    z = true;
                }
            }
            u uVar = u.a;
        }
        return z ? callDone(e2) : e2;
    }

    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().redact();
    }

    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnection realConnection = this.connection;
        m.c(realConnection);
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            m.e(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(realConnection);
            throw new AssertionError(sb.toString());
        }
        List<Reference<RealCall>> calls = realConnection.getCalls();
        Iterator<Reference<RealCall>> it = calls.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            if (m.a(it.next().get(), this)) {
                break;
            }
            i2++;
        }
        if (!(i2 != -1)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        calls.remove(i2);
        this.connection = null;
        if (calls.isEmpty()) {
            realConnection.setIdleAtNs$okhttp(System.nanoTime());
            if (this.connectionPool.connectionBecameIdle(realConnection)) {
                return realConnection.socket();
            }
        }
        return null;
    }

    @Override // okhttp3.Call
    public Request request() {
        return this.originalRequest;
    }

    public final boolean retryAfterFailure() {
        ExchangeFinder exchangeFinder = this.exchangeFinder;
        m.c(exchangeFinder);
        return exchangeFinder.retryAfterFailure();
    }

    public final void setConnectionToCancel(RealConnection realConnection) {
        this.connectionToCancel = realConnection;
    }

    public final void timeoutEarlyExit() {
        if (!(!this.timeoutEarlyExit)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.timeoutEarlyExit = true;
        exit();
    }

    @Override // okhttp3.Call
    public d timeout() {
        return this.timeout;
    }

    @Override // okhttp3.Call
    public RealCall clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }
}
