package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.dataprovider.BuildConfig;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
@zzard
final class m9 implements zzrv {
    private static final Pattern a = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicReference<byte[]> f12965b = new AtomicReference<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f12967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f12968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f12969f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzsj<? super m9> f12971h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzry f12972i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private HttpURLConnection f12973j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private InputStream f12974k;
    private boolean l;
    private long m;
    private long n;
    private long o;
    private long p;
    private int q;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SSLSocketFactory f12966c = new n9(this);
    private Set<Socket> r = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzsd f12970g = new zzsd();

    m9(String str, zzsj<? super m9> zzsjVar, int i2, int i3, int i4) {
        this.f12969f = zzsk.c(str);
        this.f12971h = zzsjVar;
        this.f12967d = i2;
        this.f12968e = i3;
        this.q = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(Socket socket) {
        this.r.add(socket);
    }

    private static long f(HttpURLConnection httpURLConnection) {
        long j2;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (TextUtils.isEmpty(headerField)) {
            j2 = -1;
        } else {
            try {
                j2 = Long.parseLong(headerField);
            } catch (NumberFormatException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(headerField).length() + 28);
                sb.append("Unexpected Content-Length [");
                sb.append(headerField);
                sb.append("]");
                zzbad.g(sb.toString());
                j2 = -1;
            }
        }
        String headerField2 = httpURLConnection.getHeaderField("Content-Range");
        if (TextUtils.isEmpty(headerField2)) {
            return j2;
        }
        Matcher matcher = a.matcher(headerField2);
        if (!matcher.find()) {
            return j2;
        }
        try {
            long j3 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            if (j2 < 0) {
                return j3;
            }
            if (j2 == j3) {
                return j2;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(headerField).length() + 26 + String.valueOf(headerField2).length());
            sb2.append("Inconsistent headers [");
            sb2.append(headerField);
            sb2.append("] [");
            sb2.append(headerField2);
            sb2.append("]");
            zzbad.i(sb2.toString());
            return Math.max(j2, j3);
        } catch (NumberFormatException unused2) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(headerField2).length() + 27);
            sb3.append("Unexpected Content-Range [");
            sb3.append(headerField2);
            sb3.append("]");
            zzbad.g(sb3.toString());
            return j2;
        }
    }

    private final void g() {
        HttpURLConnection httpURLConnection = this.f12973j;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                zzbad.c("Unexpected error while disconnecting", e2);
            }
            this.f12973j = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final Uri I0() {
        HttpURLConnection httpURLConnection = this.f12973j;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0104 A[Catch: IOException -> 0x0241, TryCatch #1 {IOException -> 0x0241, blocks: (B:3:0x000f, B:4:0x0025, B:6:0x002b, B:8:0x0035, B:9:0x003d, B:10:0x0055, B:12:0x005b, B:24:0x00cc, B:26:0x00d5, B:27:0x00dc, B:31:0x00e5, B:33:0x00ea, B:35:0x00f2, B:37:0x0107, B:51:0x0127, B:96:0x01d7, B:98:0x01e2, B:100:0x01f3, B:102:0x01fb, B:104:0x0209, B:106:0x0213, B:107:0x0216, B:105:0x020e, B:109:0x0220, B:110:0x0227, B:36:0x0104, B:19:0x0085, B:21:0x00a1, B:23:0x00c7, B:111:0x0228, B:112:0x0240), top: B:123:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:66:0x014e  */
    /* JADX WARN: Code duplicated, block: B:68:0x0156  */
    /* JADX WARN: Code duplicated, block: B:69:0x0159  */
    /* JADX WARN: Code duplicated, block: B:71:0x0163  */
    /* JADX WARN: Code duplicated, block: B:72:0x0168  */
    /* JADX WARN: Code duplicated, block: B:74:0x016c  */
    /* JADX WARN: Code duplicated, block: B:78:0x017f  */
    @Override // com.google.android.gms.internal.ads.zzrv
    public final long a(zzry zzryVar) throws zzsb {
        long j2;
        long j3;
        zzsj<? super m9> zzsjVar;
        long j4;
        long jF;
        long j5;
        this.f12972i = zzryVar;
        this.p = 0L;
        this.o = 0L;
        try {
            URL url = new URL(zzryVar.a.toString());
            byte[] bArr = zzryVar.f16684b;
            long j6 = zzryVar.f16686d;
            long j7 = zzryVar.f16687e;
            boolean zA = zzryVar.a(1);
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 > 20) {
                    StringBuilder sb = new StringBuilder(31);
                    sb.append("Too many redirects: ");
                    sb.append(i3);
                    throw new NoRouteToHostException(sb.toString());
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                if (httpURLConnection instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.f12966c);
                }
                httpURLConnection.setConnectTimeout(this.f12967d);
                httpURLConnection.setReadTimeout(this.f12968e);
                for (Map.Entry<String, String> entry : this.f12970g.a().entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
                if (j6 == 0 && j7 == -1) {
                    j6 = j6;
                } else {
                    StringBuilder sb2 = new StringBuilder(27);
                    sb2.append("bytes=");
                    sb2.append(j6);
                    sb2.append("-");
                    String string = sb2.toString();
                    if (j7 != -1) {
                        String strValueOf = String.valueOf(string);
                        long j8 = (j6 + j7) - 1;
                        StringBuilder sb3 = new StringBuilder(strValueOf.length() + 20);
                        sb3.append(strValueOf);
                        sb3.append(j8);
                        string = sb3.toString();
                    }
                    httpURLConnection.setRequestProperty("Range", string);
                }
                httpURLConnection.setRequestProperty("User-Agent", this.f12969f);
                if (!zA) {
                    httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
                }
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setDoOutput(bArr != null);
                if (bArr != null) {
                    httpURLConnection.setRequestMethod("POST");
                    if (bArr.length != 0) {
                        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                        httpURLConnection.connect();
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(bArr);
                        outputStream.close();
                    } else {
                        httpURLConnection.connect();
                    }
                } else {
                    httpURLConnection.connect();
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && (bArr != null || (responseCode != 307 && responseCode != 308))) {
                    this.f12973j = httpURLConnection;
                    try {
                        int responseCode2 = httpURLConnection.getResponseCode();
                        if (responseCode2 < 200 || responseCode2 > 299) {
                            Map<String, List<String>> headerFields = this.f12973j.getHeaderFields();
                            g();
                            zzsc zzscVar = new zzsc(responseCode2, headerFields, zzryVar);
                            if (responseCode2 != 416) {
                                throw zzscVar;
                            }
                            zzscVar.initCause(new zzrx(0));
                            throw zzscVar;
                        }
                        try {
                            if (responseCode2 == 200) {
                                long j9 = zzryVar.f16686d;
                                j2 = 0;
                                if (j9 != 0) {
                                    j3 = j9;
                                }
                                this.m = j3;
                                if (zzryVar.a(1)) {
                                    this.n = zzryVar.f16687e;
                                } else {
                                    j4 = zzryVar.f16687e;
                                    if (j4 != -1) {
                                        this.n = j4;
                                    } else {
                                        jF = f(this.f12973j);
                                        if (jF != -1) {
                                            j5 = jF - this.m;
                                        } else {
                                            j5 = -1;
                                        }
                                        this.n = j5;
                                    }
                                }
                                this.f12974k = this.f12973j.getInputStream();
                                this.l = true;
                                zzsjVar = this.f12971h;
                                if (zzsjVar != null) {
                                    zzsjVar.n(this, zzryVar);
                                }
                                return this.n;
                            }
                            j2 = 0;
                            this.f12974k = this.f12973j.getInputStream();
                            this.l = true;
                            zzsjVar = this.f12971h;
                            if (zzsjVar != null) {
                                zzsjVar.n(this, zzryVar);
                            }
                            return this.n;
                        } catch (IOException e2) {
                            g();
                            throw new zzsb(e2, zzryVar, 1);
                        }
                        j3 = j2;
                        this.m = j3;
                        if (zzryVar.a(1)) {
                            j4 = zzryVar.f16687e;
                            if (j4 != -1) {
                                this.n = j4;
                            } else {
                                jF = f(this.f12973j);
                                if (jF != -1) {
                                    j5 = jF - this.m;
                                } else {
                                    j5 = -1;
                                }
                                this.n = j5;
                            }
                        } else {
                            this.n = zzryVar.f16687e;
                        }
                    } catch (IOException e3) {
                        g();
                        String strValueOf2 = String.valueOf(zzryVar.a.toString());
                        throw new zzsb(strValueOf2.length() != 0 ? "Unable to connect to ".concat(strValueOf2) : new String("Unable to connect to "), e3, zzryVar, 1);
                    }
                }
                String headerField = httpURLConnection.getHeaderField("Location");
                httpURLConnection.disconnect();
                if (headerField == null) {
                    throw new ProtocolException("Null location redirect");
                }
                URL url2 = new URL(url, headerField);
                String protocol = url2.getProtocol();
                if (!BuildConfig.APTOIDE_WEB_SERVICES_SCHEME.equals(protocol) && !"http".equals(protocol)) {
                    String strValueOf3 = String.valueOf(protocol);
                    throw new ProtocolException(strValueOf3.length() != 0 ? "Unsupported protocol redirect: ".concat(strValueOf3) : new String("Unsupported protocol redirect: "));
                }
                bArr = null;
                url = url2;
                i2 = i3;
                j6 = j6;
            }
        } catch (IOException e4) {
            String strValueOf4 = String.valueOf(zzryVar.a.toString());
            throw new zzsb(strValueOf4.length() != 0 ? "Unable to connect to ".concat(strValueOf4) : new String("Unable to connect to "), e4, zzryVar, 1);
        }
    }

    final void b(int i2) {
        this.q = i2;
        for (Socket socket : this.r) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.q);
                } catch (SocketException e2) {
                    zzbad.d("Failed to update receive buffer size.", e2);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0034 A[Catch: Exception -> 0x0065, all -> 0x008d, TryCatch #0 {Exception -> 0x0065, blocks: (B:14:0x001e, B:16:0x0026, B:21:0x0034, B:23:0x0044, B:25:0x004c), top: B:47:0x001e }] */
    /* JADX WARN: Code duplicated, block: B:25:0x004c A[Catch: Exception -> 0x0065, all -> 0x008d, TRY_LEAVE, TryCatch #0 {Exception -> 0x0065, blocks: (B:14:0x001e, B:16:0x0026, B:21:0x0034, B:23:0x0044, B:25:0x004c), top: B:47:0x001e }] */
    @Override // com.google.android.gms.internal.ads.zzrv
    public final void close() throws zzsb {
        String name;
        try {
            if (this.f12974k != null) {
                HttpURLConnection httpURLConnection = this.f12973j;
                long j2 = this.n;
                if (j2 != -1) {
                    j2 -= this.p;
                }
                int i2 = zzsy.a;
                if (i2 == 19 || i2 == 20) {
                    try {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        if (j2 == -1) {
                            if (inputStream.read() != -1) {
                                name = inputStream.getClass().getName();
                                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                                    declaredMethod.setAccessible(true);
                                    declaredMethod.invoke(inputStream, new Object[0]);
                                }
                            }
                        } else if (j2 > 2048) {
                            name = inputStream.getClass().getName();
                            if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream")) {
                                Method declaredMethod2 = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                                declaredMethod2.setAccessible(true);
                                declaredMethod2.invoke(inputStream, new Object[0]);
                            } else {
                                Method declaredMethod3 = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                                declaredMethod3.setAccessible(true);
                                declaredMethod3.invoke(inputStream, new Object[0]);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                try {
                    this.f12974k.close();
                } catch (IOException e2) {
                    throw new zzsb(e2, this.f12972i, 3);
                }
            }
            this.f12974k = null;
            g();
            if (this.l) {
                this.l = false;
                zzsj<? super m9> zzsjVar = this.f12971h;
                if (zzsjVar != null) {
                    zzsjVar.d(this);
                }
            }
            this.r.clear();
        } catch (Throwable th) {
            this.f12974k = null;
            g();
            if (this.l) {
                this.l = false;
                zzsj<? super m9> zzsjVar2 = this.f12971h;
                if (zzsjVar2 != null) {
                    zzsjVar2.d(this);
                }
            }
            this.r.clear();
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final int read(byte[] bArr, int i2, int i3) throws zzsb {
        try {
            if (this.o != this.m) {
                byte[] andSet = f12965b.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT];
                }
                while (true) {
                    long j2 = this.o;
                    long j3 = this.m;
                    if (j2 == j3) {
                        f12965b.set(andSet);
                        break;
                    }
                    int i4 = this.f12974k.read(andSet, 0, (int) Math.min(j3 - j2, andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    }
                    if (i4 == -1) {
                        throw new EOFException();
                    }
                    this.o += (long) i4;
                    zzsj<? super m9> zzsjVar = this.f12971h;
                    if (zzsjVar != null) {
                        zzsjVar.o(this, i4);
                    }
                }
            }
            if (i3 == 0) {
                return 0;
            }
            long j4 = this.n;
            if (j4 != -1) {
                long j5 = j4 - this.p;
                if (j5 == 0) {
                    return -1;
                }
                i3 = (int) Math.min(i3, j5);
            }
            int i5 = this.f12974k.read(bArr, i2, i3);
            if (i5 == -1) {
                if (this.n == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.p += (long) i5;
            zzsj<? super m9> zzsjVar2 = this.f12971h;
            if (zzsjVar2 != null) {
                zzsjVar2.o(this, i5);
            }
            return i5;
        } catch (IOException e2) {
            throw new zzsb(e2, this.f12972i, 2);
        }
    }
}
