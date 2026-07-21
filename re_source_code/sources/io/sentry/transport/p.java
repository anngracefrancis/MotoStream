package io.sentry.transport;

import io.sentry.h4;
import io.sentry.p3;
import io.sentry.s4;
import io.sentry.w1;
import io.sentry.x4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: HttpConnection.java */
/* JADX INFO: loaded from: classes2.dex */
final class p {
    private static final Charset a = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Proxy f22742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p3 f22743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final x4 f22744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final y f22745e;

    public p(x4 x4Var, p3 p3Var, y yVar) {
        this(x4Var, p3Var, n.a(), yVar);
    }

    private void a(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.getInputStream().close();
        } catch (IOException unused) {
        } finally {
            httpURLConnection.disconnect();
        }
    }

    private HttpURLConnection b() throws IOException {
        HttpURLConnection httpURLConnectionE = e();
        for (Map.Entry<String, String> entry : this.f22743c.a().entrySet()) {
            httpURLConnectionE.setRequestProperty(entry.getKey(), entry.getValue());
        }
        httpURLConnectionE.setRequestMethod("POST");
        httpURLConnectionE.setDoOutput(true);
        httpURLConnectionE.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnectionE.setRequestProperty("Content-Type", "application/x-sentry-envelope");
        httpURLConnectionE.setRequestProperty("Accept", "application/json");
        httpURLConnectionE.setRequestProperty("Connection", "close");
        httpURLConnectionE.setConnectTimeout(this.f22744d.getConnectionTimeoutMillis());
        httpURLConnectionE.setReadTimeout(this.f22744d.getReadTimeoutMillis());
        HostnameVerifier hostnameVerifier = this.f22744d.getHostnameVerifier();
        boolean z = httpURLConnectionE instanceof HttpsURLConnection;
        if (z && hostnameVerifier != null) {
            ((HttpsURLConnection) httpURLConnectionE).setHostnameVerifier(hostnameVerifier);
        }
        SSLSocketFactory sslSocketFactory = this.f22744d.getSslSocketFactory();
        if (z && sslSocketFactory != null) {
            ((HttpsURLConnection) httpURLConnectionE).setSSLSocketFactory(sslSocketFactory);
        }
        httpURLConnectionE.connect();
        return httpURLConnectionE;
    }

    private String c(HttpURLConnection httpURLConnection) {
        try {
            InputStream errorStream = httpURLConnection.getErrorStream();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, a));
                try {
                    StringBuilder sb = new StringBuilder();
                    boolean z = true;
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (!z) {
                            sb.append("\n");
                        }
                        sb.append(line);
                        z = false;
                    }
                    String string = sb.toString();
                    bufferedReader.close();
                    if (errorStream != null) {
                        errorStream.close();
                    }
                    return string;
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                if (errorStream != null) {
                    try {
                        errorStream.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th2;
            }
        } catch (IOException unused3) {
            return "Failed to obtain error message while analyzing send failure.";
        }
    }

    private boolean d(int i2) {
        return i2 == 200;
    }

    private a0 f(HttpURLConnection httpURLConnection) {
        try {
            int responseCode = httpURLConnection.getResponseCode();
            i(httpURLConnection, responseCode);
            if (d(responseCode)) {
                this.f22744d.getLogger().c(s4.DEBUG, "Envelope sent successfully.", new Object[0]);
                return a0.e();
            }
            w1 logger = this.f22744d.getLogger();
            s4 s4Var = s4.ERROR;
            logger.c(s4Var, "Request failed, API returned %s", Integer.valueOf(responseCode));
            if (this.f22744d.isDebug()) {
                this.f22744d.getLogger().c(s4Var, "%s", c(httpURLConnection));
            }
            return a0.b(responseCode);
        } catch (IOException e2) {
            this.f22744d.getLogger().a(s4.ERROR, e2, "Error reading and logging the response stream", new Object[0]);
            return a0.a();
        } finally {
            a(httpURLConnection);
        }
    }

    private Proxy g(x4.e eVar) {
        if (eVar != null) {
            String strC = eVar.c();
            String strA = eVar.a();
            if (strC != null && strA != null) {
                try {
                    return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(strA, Integer.parseInt(strC)));
                } catch (NumberFormatException e2) {
                    this.f22744d.getLogger().a(s4.ERROR, e2, "Failed to parse Sentry Proxy port: " + eVar.c() + ". Proxy is ignored", new Object[0]);
                }
            }
        }
        return null;
    }

    HttpURLConnection e() throws IOException {
        return (HttpURLConnection) (this.f22742b == null ? this.f22743c.b().openConnection() : this.f22743c.b().openConnection(this.f22742b));
    }

    public a0 h(h4 h4Var) throws IOException {
        HttpURLConnection httpURLConnectionB = b();
        try {
            OutputStream outputStream = httpURLConnectionB.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.f22744d.getSerializer().b(h4Var, gZIPOutputStream);
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    return f(httpURLConnectionB);
                } catch (Throwable th) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                this.f22744d.getLogger().a(s4.ERROR, th3, "An exception occurred while submitting the envelope to the Sentry server.", new Object[0]);
            } catch (Throwable th4) {
                f(httpURLConnectionB);
                throw th4;
            }
        }
    }

    public void i(HttpURLConnection httpURLConnection, int i2) {
        String headerField = httpURLConnection.getHeaderField("Retry-After");
        this.f22745e.i(httpURLConnection.getHeaderField("X-Sentry-Rate-Limits"), headerField, i2);
    }

    p(x4 x4Var, p3 p3Var, n nVar, y yVar) {
        this.f22743c = p3Var;
        this.f22744d = x4Var;
        this.f22745e = yVar;
        Proxy proxyG = g(x4Var.getProxy());
        this.f22742b = proxyG;
        if (proxyG == null || x4Var.getProxy() == null) {
            return;
        }
        String strD = x4Var.getProxy().d();
        String strB = x4Var.getProxy().b();
        if (strD == null || strB == null) {
            return;
        }
        nVar.b(new w(strD, strB));
    }
}
