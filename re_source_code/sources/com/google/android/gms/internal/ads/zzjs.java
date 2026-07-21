package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.dataprovider.BuildConfig;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class zzjs implements zzkf {
    private static final Pattern a = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicReference<byte[]> f16366b = new AtomicReference<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f16367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f16368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f16369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f16370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzkn<String> f16371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final HashMap<String, String> f16372h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzke f16373i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzjq f16374j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private HttpURLConnection f16375k;
    private InputStream l;
    private boolean m;
    private long n;
    private long o;
    private long p;
    private long q;

    public zzjs(String str, zzkn<String> zzknVar, zzke zzkeVar, int i2, int i3, boolean z) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        this.f16370f = str;
        this.f16371g = null;
        this.f16373i = null;
        this.f16372h = new HashMap<>();
        this.f16368d = i2;
        this.f16369e = i3;
        this.f16367c = z;
    }

    private final void b() {
        HttpURLConnection httpURLConnection = this.f16375k;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.f16375k = null;
        }
    }

    private final HttpURLConnection c(URL url, long j2, long j3, boolean z) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f16368d);
        httpURLConnection.setReadTimeout(this.f16369e);
        httpURLConnection.setDoOutput(false);
        synchronized (this.f16372h) {
            for (Map.Entry<String, String> entry : this.f16372h.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        if (j2 != 0 || j3 != -1) {
            StringBuilder sb = new StringBuilder(27);
            sb.append("bytes=");
            sb.append(j2);
            sb.append("-");
            String string = sb.toString();
            if (j3 != -1) {
                String strValueOf = String.valueOf(string);
                long j4 = (j2 + j3) - 1;
                StringBuilder sb2 = new StringBuilder(strValueOf.length() + 20);
                sb2.append(strValueOf);
                sb2.append(j4);
                string = sb2.toString();
            }
            httpURLConnection.setRequestProperty("Range", string);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.f16370f);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
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
                Log.e("HttpDataSource", sb.toString());
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
            Log.w("HttpDataSource", sb2.toString());
            return Math.max(j2, j3);
        } catch (NumberFormatException unused2) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(headerField2).length() + 27);
            sb3.append("Unexpected Content-Range [");
            sb3.append(headerField2);
            sb3.append("]");
            Log.e("HttpDataSource", sb3.toString());
            return j2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final long a(zzjq zzjqVar) throws zzjx {
        HttpURLConnection httpURLConnectionC;
        this.f16374j = zzjqVar;
        long j2 = 0;
        this.q = 0L;
        this.p = 0L;
        try {
            URL url = new URL(zzjqVar.a.toString());
            long j3 = zzjqVar.f16359c;
            long j4 = zzjqVar.f16360d;
            boolean z = (zzjqVar.f16362f & 1) != 0;
            if (this.f16367c) {
                URL url2 = url;
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
                    HttpURLConnection httpURLConnectionC2 = c(url2, j3, j4, z);
                    httpURLConnectionC2.setInstanceFollowRedirects(false);
                    httpURLConnectionC2.connect();
                    int responseCode = httpURLConnectionC2.getResponseCode();
                    if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307 && responseCode != 308) {
                        httpURLConnectionC = httpURLConnectionC2;
                        break;
                    }
                    String headerField = httpURLConnectionC2.getHeaderField("Location");
                    httpURLConnectionC2.disconnect();
                    if (headerField == null) {
                        throw new ProtocolException("Null location redirect");
                    }
                    URL url4 = new URL(url3, headerField);
                    String protocol = url4.getProtocol();
                    if (!BuildConfig.APTOIDE_WEB_SERVICES_SCHEME.equals(protocol) && !"http".equals(protocol)) {
                        String strValueOf = String.valueOf(protocol);
                        throw new ProtocolException(strValueOf.length() != 0 ? "Unsupported protocol redirect: ".concat(strValueOf) : new String("Unsupported protocol redirect: "));
                    }
                    url2 = url4;
                    i2 = i3;
                    j4 = j5;
                }
            } else {
                httpURLConnectionC = c(url, j3, j4, z);
                httpURLConnectionC.connect();
            }
            this.f16375k = httpURLConnectionC;
            try {
                int responseCode2 = httpURLConnectionC.getResponseCode();
                if (responseCode2 < 200 || responseCode2 > 299) {
                    Map<String, List<String>> headerFields = this.f16375k.getHeaderFields();
                    b();
                    throw new zzjy(responseCode2, headerFields, zzjqVar);
                }
                this.f16375k.getContentType();
                if (responseCode2 == 200) {
                    long j6 = zzjqVar.f16359c;
                    if (j6 != 0) {
                        j2 = j6;
                    }
                }
                this.n = j2;
                if ((zzjqVar.f16362f & 1) == 0) {
                    long jD = d(this.f16375k);
                    long j7 = zzjqVar.f16360d;
                    if (j7 == -1) {
                        j7 = jD != -1 ? jD - this.n : -1L;
                    }
                    this.o = j7;
                } else {
                    this.o = zzjqVar.f16360d;
                }
                try {
                    this.l = this.f16375k.getInputStream();
                    this.m = true;
                    zzke zzkeVar = this.f16373i;
                    if (zzkeVar != null) {
                        zzkeVar.b();
                    }
                    return this.o;
                } catch (IOException e2) {
                    b();
                    throw new zzjx(e2, zzjqVar);
                }
            } catch (IOException e3) {
                b();
                String strValueOf2 = String.valueOf(zzjqVar.a.toString());
                throw new zzjx(strValueOf2.length() != 0 ? "Unable to connect to ".concat(strValueOf2) : new String("Unable to connect to "), e3, zzjqVar);
            }
        } catch (IOException e4) {
            String strValueOf3 = String.valueOf(zzjqVar.a.toString());
            throw new zzjx(strValueOf3.length() != 0 ? "Unable to connect to ".concat(strValueOf3) : new String("Unable to connect to "), e4, zzjqVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0033 A[Catch: IOException | Exception -> 0x0064, all -> 0x0087, TryCatch #0 {all -> 0x0087, blocks: (B:3:0x0001, B:5:0x0005, B:9:0x0013, B:26:0x0064, B:28:0x006a, B:30:0x006e, B:31:0x0075, B:14:0x001d, B:16:0x0025, B:21:0x0033, B:23:0x0043, B:25:0x004b, B:8:0x0010), top: B:48:0x0001, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x004b A[Catch: IOException | Exception -> 0x0064, all -> 0x0087, TRY_LEAVE, TryCatch #0 {all -> 0x0087, blocks: (B:3:0x0001, B:5:0x0005, B:9:0x0013, B:26:0x0064, B:28:0x006a, B:30:0x006e, B:31:0x0075, B:14:0x001d, B:16:0x0025, B:21:0x0033, B:23:0x0043, B:25:0x004b, B:8:0x0010), top: B:48:0x0001, inners: #2 }] */
    @Override // com.google.android.gms.internal.ads.zzjp
    public final void close() throws zzjx {
        String name;
        try {
            if (this.l != null) {
                HttpURLConnection httpURLConnection = this.f16375k;
                long j2 = this.o;
                if (j2 != -1) {
                    j2 -= this.q;
                }
                int i2 = zzkq.a;
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
                    } catch (IOException | Exception unused) {
                    }
                }
                try {
                    this.l.close();
                    this.l = null;
                } catch (IOException e2) {
                    throw new zzjx(e2, this.f16374j);
                }
            }
            if (this.m) {
                this.m = false;
                zzke zzkeVar = this.f16373i;
                if (zzkeVar != null) {
                    zzkeVar.c();
                }
                b();
            }
        } catch (Throwable th) {
            if (this.m) {
                this.m = false;
                zzke zzkeVar2 = this.f16373i;
                if (zzkeVar2 != null) {
                    zzkeVar2.c();
                }
                b();
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final int read(byte[] bArr, int i2, int i3) throws zzjx {
        try {
            if (this.p != this.n) {
                byte[] andSet = f16366b.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT];
                }
                while (true) {
                    long j2 = this.p;
                    long j3 = this.n;
                    if (j2 == j3) {
                        f16366b.set(andSet);
                        break;
                    }
                    int i4 = this.l.read(andSet, 0, (int) Math.min(j3 - j2, andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    }
                    if (i4 == -1) {
                        throw new EOFException();
                    }
                    this.p += (long) i4;
                    zzke zzkeVar = this.f16373i;
                    if (zzkeVar != null) {
                        zzkeVar.a(i4);
                    }
                }
            }
            long j4 = this.o;
            if (j4 != -1) {
                i3 = (int) Math.min(i3, j4 - this.q);
            }
            if (i3 == 0) {
                return -1;
            }
            int i5 = this.l.read(bArr, i2, i3);
            if (i5 == -1) {
                long j5 = this.o;
                if (j5 != -1 && j5 != this.q) {
                    throw new EOFException();
                }
                return -1;
            }
            this.q += (long) i5;
            zzke zzkeVar2 = this.f16373i;
            if (zzkeVar2 != null) {
                zzkeVar2.a(i5);
            }
            return i5;
        } catch (IOException e2) {
            throw new zzjx(e2, this.f16374j);
        }
    }
}
