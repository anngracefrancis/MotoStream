package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
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
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class zzsa implements zzrv {
    private static final Pattern a = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicReference<byte[]> f16697b = new AtomicReference<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f16699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f16700e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f16701f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzsj<? super zzsa> f16705j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private zzry f16706k;
    private HttpURLConnection l;
    private InputStream m;
    private boolean n;
    private long o;
    private long p;
    private long q;
    private long r;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzsv<String> f16702g = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzsd f16704i = new zzsd();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f16698c = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzsd f16703h = null;

    public zzsa(String str, zzsv<String> zzsvVar, zzsj<? super zzsa> zzsjVar, int i2, int i3, boolean z, zzsd zzsdVar) {
        this.f16701f = zzsk.c(str);
        this.f16705j = zzsjVar;
        this.f16699d = i2;
        this.f16700e = i3;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00bb  */
    private final HttpURLConnection c(URL url, byte[] bArr, long j2, long j3, boolean z, boolean z2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f16699d);
        httpURLConnection.setReadTimeout(this.f16700e);
        for (Map.Entry<String, String> entry : this.f16704i.a().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        if (j2 != 0 || j3 != -1) {
            StringBuilder sb = new StringBuilder(27);
            sb.append("bytes=");
            sb.append(j2);
            sb.append("-");
            String string = sb.toString();
            if (j3 != -1) {
                String strValueOf = String.valueOf(string);
                StringBuilder sb2 = new StringBuilder(strValueOf.length() + 20);
                sb2.append(strValueOf);
                sb2.append((j2 + j3) - 1);
                string = sb2.toString();
            }
            httpURLConnection.setRequestProperty("Range", string);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.f16701f);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
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
        return httpURLConnection;
    }

    private static long d(HttpURLConnection httpURLConnection) {
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
                Log.e("DefaultHttpDataSource", sb.toString());
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
            Log.w("DefaultHttpDataSource", sb2.toString());
            return Math.max(j2, j3);
        } catch (NumberFormatException unused2) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(headerField2).length() + 27);
            sb3.append("Unexpected Content-Range [");
            sb3.append(headerField2);
            sb3.append("]");
            Log.e("DefaultHttpDataSource", sb3.toString());
            return j2;
        }
    }

    private final void e() {
        HttpURLConnection httpURLConnection = this.l;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e2);
            }
            this.l = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final Uri I0() {
        HttpURLConnection httpURLConnection = this.l;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final long a(zzry zzryVar) throws zzsb {
        HttpURLConnection httpURLConnectionC;
        HttpURLConnection httpURLConnectionC2;
        this.f16706k = zzryVar;
        long j2 = 0;
        this.r = 0L;
        this.q = 0L;
        try {
            URL url = new URL(zzryVar.a.toString());
            byte[] bArr = zzryVar.f16684b;
            long j3 = zzryVar.f16686d;
            long j4 = zzryVar.f16687e;
            boolean zA = zzryVar.a(1);
            if (this.f16698c) {
                URL url2 = url;
                byte[] bArr2 = bArr;
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    if (i2 > 20) {
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("Too many redirects: ");
                        sb.append(i3);
                        throw new NoRouteToHostException(sb.toString());
                    }
                    URL url3 = url2;
                    long j5 = j4;
                    long j6 = j3;
                    httpURLConnectionC = c(url2, bArr2, j3, j4, zA, false);
                    int responseCode = httpURLConnectionC.getResponseCode();
                    if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && (bArr2 != null || (responseCode != 307 && responseCode != 308))) {
                        break;
                    }
                    bArr2 = null;
                    String headerField = httpURLConnectionC.getHeaderField("Location");
                    httpURLConnectionC.disconnect();
                    if (headerField == null) {
                        throw new ProtocolException("Null location redirect");
                    }
                    url2 = new URL(url3, headerField);
                    String protocol = url2.getProtocol();
                    if (!BuildConfig.APTOIDE_WEB_SERVICES_SCHEME.equals(protocol) && !"http".equals(protocol)) {
                        String strValueOf = String.valueOf(protocol);
                        throw new ProtocolException(strValueOf.length() != 0 ? "Unsupported protocol redirect: ".concat(strValueOf) : new String("Unsupported protocol redirect: "));
                    }
                    i2 = i3;
                    j4 = j5;
                    j3 = j6;
                }
                httpURLConnectionC2 = httpURLConnectionC;
            } else {
                httpURLConnectionC2 = c(url, bArr, j3, j4, zA, true);
            }
            this.l = httpURLConnectionC2;
            try {
                int responseCode2 = httpURLConnectionC2.getResponseCode();
                if (responseCode2 < 200 || responseCode2 > 299) {
                    Map<String, List<String>> headerFields = this.l.getHeaderFields();
                    e();
                    zzsc zzscVar = new zzsc(responseCode2, headerFields, zzryVar);
                    if (responseCode2 != 416) {
                        throw zzscVar;
                    }
                    zzscVar.initCause(new zzrx(0));
                    throw zzscVar;
                }
                this.l.getContentType();
                if (responseCode2 == 200) {
                    long j7 = zzryVar.f16686d;
                    if (j7 != 0) {
                        j2 = j7;
                    }
                }
                this.o = j2;
                if (zzryVar.a(1)) {
                    this.p = zzryVar.f16687e;
                } else {
                    long j8 = zzryVar.f16687e;
                    if (j8 != -1) {
                        this.p = j8;
                    } else {
                        long jD = d(this.l);
                        this.p = jD != -1 ? jD - this.o : -1L;
                    }
                }
                try {
                    this.m = this.l.getInputStream();
                    this.n = true;
                    zzsj<? super zzsa> zzsjVar = this.f16705j;
                    if (zzsjVar != null) {
                        zzsjVar.n(this, zzryVar);
                    }
                    return this.p;
                } catch (IOException e2) {
                    e();
                    throw new zzsb(e2, zzryVar, 1);
                }
            } catch (IOException e3) {
                e();
                String strValueOf2 = String.valueOf(zzryVar.a.toString());
                throw new zzsb(strValueOf2.length() != 0 ? "Unable to connect to ".concat(strValueOf2) : new String("Unable to connect to "), e3, zzryVar, 1);
            }
        } catch (IOException e4) {
            String strValueOf3 = String.valueOf(zzryVar.a.toString());
            throw new zzsb(strValueOf3.length() != 0 ? "Unable to connect to ".concat(strValueOf3) : new String("Unable to connect to "), e4, zzryVar, 1);
        }
    }

    public final Map<String, List<String>> b() {
        HttpURLConnection httpURLConnection = this.l;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0034 A[Catch: Exception -> 0x0065, all -> 0x0088, TryCatch #0 {all -> 0x0088, blocks: (B:3:0x0002, B:5:0x0006, B:9:0x0014, B:26:0x0065, B:29:0x006c, B:30:0x0074, B:14:0x001e, B:16:0x0026, B:21:0x0034, B:23:0x0044, B:25:0x004c, B:8:0x0011), top: B:45:0x0002, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x004c A[Catch: Exception -> 0x0065, all -> 0x0088, TRY_LEAVE, TryCatch #0 {all -> 0x0088, blocks: (B:3:0x0002, B:5:0x0006, B:9:0x0014, B:26:0x0065, B:29:0x006c, B:30:0x0074, B:14:0x001e, B:16:0x0026, B:21:0x0034, B:23:0x0044, B:25:0x004c, B:8:0x0011), top: B:45:0x0002, inners: #2 }] */
    @Override // com.google.android.gms.internal.ads.zzrv
    public final void close() throws zzsb {
        String name;
        try {
            if (this.m != null) {
                HttpURLConnection httpURLConnection = this.l;
                long j2 = this.p;
                if (j2 != -1) {
                    j2 -= this.r;
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
                    this.m.close();
                } catch (IOException e2) {
                    throw new zzsb(e2, this.f16706k, 3);
                }
            }
            this.m = null;
            e();
            if (this.n) {
                this.n = false;
                zzsj<? super zzsa> zzsjVar = this.f16705j;
                if (zzsjVar != null) {
                    zzsjVar.d(this);
                }
            }
        } catch (Throwable th) {
            this.m = null;
            e();
            if (this.n) {
                this.n = false;
                zzsj<? super zzsa> zzsjVar2 = this.f16705j;
                if (zzsjVar2 != null) {
                    zzsjVar2.d(this);
                }
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final int read(byte[] bArr, int i2, int i3) throws zzsb {
        try {
            if (this.q != this.o) {
                byte[] andSet = f16697b.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT];
                }
                while (true) {
                    long j2 = this.q;
                    long j3 = this.o;
                    if (j2 == j3) {
                        f16697b.set(andSet);
                        break;
                    }
                    int i4 = this.m.read(andSet, 0, (int) Math.min(j3 - j2, andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    }
                    if (i4 == -1) {
                        throw new EOFException();
                    }
                    this.q += (long) i4;
                    zzsj<? super zzsa> zzsjVar = this.f16705j;
                    if (zzsjVar != null) {
                        zzsjVar.o(this, i4);
                    }
                }
            }
            if (i3 == 0) {
                return 0;
            }
            long j4 = this.p;
            if (j4 != -1) {
                long j5 = j4 - this.r;
                if (j5 == 0) {
                    return -1;
                }
                i3 = (int) Math.min(i3, j5);
            }
            int i5 = this.m.read(bArr, i2, i3);
            if (i5 == -1) {
                if (this.p == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.r += (long) i5;
            zzsj<? super zzsa> zzsjVar2 = this.f16705j;
            if (zzsjVar2 != null) {
                zzsjVar2.o(this, i5);
            }
            return i5;
        } catch (IOException e2) {
            throw new zzsb(e2, this.f16706k, 2);
        }
    }
}
