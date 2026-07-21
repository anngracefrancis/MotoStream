package com.google.android.gms.internal.ads;

import cm.aptoide.pt.dataprovider.BuildConfig;
import cm.aptoide.pt.file.CacheHelper;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbge extends zzbft {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Set<String> f14433i = Collections.synchronizedSet(new HashSet());

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final DecimalFormat f14434j = new DecimalFormat("#,###");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private File f14435k;
    private boolean l;

    public zzbge(zzbdf zzbdfVar) {
        super(zzbdfVar);
        File cacheDir = this.f14430f.getCacheDir();
        if (cacheDir == null) {
            zzbad.i("Context.getCacheDir() returned null");
            return;
        }
        File file = new File(cacheDir, "admobVideoStreams");
        this.f14435k = file;
        if (!file.isDirectory() && !this.f14435k.mkdirs()) {
            String strValueOf = String.valueOf(this.f14435k.getAbsolutePath());
            zzbad.i(strValueOf.length() != 0 ? "Could not create preload cache directory at ".concat(strValueOf) : new String("Could not create preload cache directory at "));
            this.f14435k = null;
        } else {
            if (this.f14435k.setReadable(true, false) && this.f14435k.setExecutable(true, false)) {
                return;
            }
            String strValueOf2 = String.valueOf(this.f14435k.getAbsolutePath());
            zzbad.i(strValueOf2.length() != 0 ? "Could not set cache file permissions at ".concat(strValueOf2) : new String("Could not set cache file permissions at "));
            this.f14435k = null;
        }
    }

    private final File B(File file) {
        return new File(this.f14435k, String.valueOf(file.getName()).concat(".done"));
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void b() {
        this.l = true;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0048  */
    /* JADX WARN: Code duplicated, block: B:247:0x051b  */
    /* JADX WARN: Code duplicated, block: B:253:0x052d  */
    /* JADX WARN: Code duplicated, block: B:254:0x0551  */
    /* JADX WARN: Code duplicated, block: B:257:0x057a  */
    /* JADX WARN: Code duplicated, block: B:261:0x0590  */
    /* JADX WARN: Code duplicated, block: B:262:0x0595  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 22, insn: 0x050c: MOVE (r15 I:??[OBJECT, ARRAY]) = (r22 I:??[OBJECT, ARRAY]), block:B:239:0x050c */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v35, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v55 */
    /* JADX WARN: Type inference failed for: r1v73 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v89 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r1v90 */
    /* JADX WARN: Type inference failed for: r1v91 */
    /* JADX WARN: Type inference failed for: r1v92 */
    /* JADX WARN: Type inference failed for: r1v93 */
    /* JADX WARN: Type inference failed for: r24v0 */
    /* JADX WARN: Type inference failed for: r24v1 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r24v4, types: [int] */
    /* JADX WARN: Type inference failed for: r24v5 */
    /* JADX WARN: Type inference failed for: r24v6 */
    /* JADX WARN: Type inference failed for: r24v7 */
    /* JADX WARN: Type inference failed for: r24v8 */
    /* JADX WARN: Type inference failed for: r24v9 */
    @Override // com.google.android.gms.internal.ads.zzbft
    public final boolean y(String str) {
        int i2;
        ?? r1;
        String strConcat;
        ?? r2;
        String strValueOf;
        String str2;
        String str3;
        FileOutputStream fileOutputStream;
        ?? r3;
        ?? r4;
        ?? r24;
        String str4;
        ?? r5;
        boolean zDelete;
        FileOutputStream fileOutputStream2 = null;
        int i3 = 0;
        if (this.f14435k == null) {
            q(str, null, "noCacheDir", null);
            return false;
        }
        do {
            File file = this.f14435k;
            if (file == null) {
                i2 = 0;
            } else {
                i2 = 0;
                for (File file2 : file.listFiles()) {
                    if (!file2.getName().endsWith(".done")) {
                        i2++;
                    }
                }
            }
            if (i2 > ((Integer) zzyt.e().c(zzacu.B)).intValue()) {
                File file3 = this.f14435k;
                if (file3 == null) {
                    zDelete = false;
                } else {
                    long j2 = Long.MAX_VALUE;
                    File file4 = null;
                    for (File file5 : file3.listFiles()) {
                        if (!file5.getName().endsWith(".done")) {
                            long jLastModified = file5.lastModified();
                            if (jLastModified < j2) {
                                file4 = file5;
                                j2 = jLastModified;
                            }
                        }
                    }
                    if (file4 != null) {
                        zDelete = file4.delete();
                        File fileB = B(file4);
                        if (fileB.isFile()) {
                            zDelete &= fileB.delete();
                        }
                    } else {
                        zDelete = false;
                    }
                }
            } else {
                File file6 = new File(this.f14435k, z(str));
                File fileB2 = B(file6);
                if (file6.isFile() && fileB2.isFile()) {
                    int length = (int) file6.length();
                    String strValueOf2 = String.valueOf(str);
                    zzbad.e(strValueOf2.length() != 0 ? "Stream cache hit at ".concat(strValueOf2) : new String("Stream cache hit at "));
                    j(str, file6.getAbsolutePath(), length);
                    return true;
                }
                String strValueOf3 = String.valueOf(this.f14435k.getAbsolutePath());
                String strValueOf4 = String.valueOf(str);
                String strConcat2 = strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3);
                Set<String> set = f14433i;
                synchronized (set) {
                    if (set.contains(strConcat2)) {
                        String strValueOf5 = String.valueOf(str);
                        zzbad.i(strValueOf5.length() != 0 ? "Stream cache already in progress at ".concat(strValueOf5) : new String("Stream cache already in progress at "));
                        q(str, file6.getAbsolutePath(), "inProgress", null);
                        return false;
                    }
                    set.add(strConcat2);
                    String str5 = "error";
                    try {
                        zzk.zzls();
                        int iIntValue = ((Integer) zzyt.e().c(zzacu.G)).intValue();
                        URL url = new URL(str);
                        int i4 = 0;
                        while (true) {
                            i4++;
                            try {
                                try {
                                    if (i4 > 20) {
                                        throw new IOException("Too many redirects (20)");
                                    }
                                    URLConnection uRLConnectionOpenConnection = url.openConnection();
                                    uRLConnectionOpenConnection.setConnectTimeout(iIntValue);
                                    uRLConnectionOpenConnection.setReadTimeout(iIntValue);
                                    if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                                        throw new IOException("Invalid protocol.");
                                    }
                                    HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                                    zzazx zzazxVar = new zzazx();
                                    zzazxVar.i(httpURLConnection, null);
                                    httpURLConnection.setInstanceFollowRedirects(false);
                                    int responseCode = httpURLConnection.getResponseCode();
                                    zzazxVar.h(httpURLConnection, responseCode);
                                    if (responseCode / 100 == 3) {
                                        try {
                                            String headerField = httpURLConnection.getHeaderField("Location");
                                            if (headerField == null) {
                                                throw new IOException("Missing Location header in redirect");
                                            }
                                            URL url2 = new URL(url, headerField);
                                            String protocol = url2.getProtocol();
                                            if (protocol == null) {
                                                throw new IOException("Protocol is null");
                                            }
                                            if (!protocol.equals("http") && !protocol.equals(BuildConfig.APTOIDE_WEB_SERVICES_SCHEME)) {
                                                throw new IOException(protocol.length() != 0 ? "Unsupported scheme: ".concat(protocol) : new String("Unsupported scheme: "));
                                            }
                                            zzbad.e(headerField.length() != 0 ? "Redirecting to ".concat(headerField) : new String("Redirecting to "));
                                            httpURLConnection.disconnect();
                                            url = url2;
                                        } catch (IOException | RuntimeException e2) {
                                            e = e2;
                                            strConcat = null;
                                        }
                                    } else {
                                        int responseCode2 = httpURLConnection.getResponseCode();
                                        if (responseCode2 >= 400) {
                                            str5 = "badUrl";
                                            String strValueOf6 = String.valueOf(Integer.toString(responseCode2));
                                            strConcat = strValueOf6.length() != 0 ? "HTTP request failed. Code: ".concat(strValueOf6) : new String("HTTP request failed. Code: ");
                                            try {
                                                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 32);
                                                sb.append("HTTP status code ");
                                                sb.append(responseCode2);
                                                sb.append(" at ");
                                                sb.append(str);
                                                throw new IOException(sb.toString());
                                            } catch (IOException e3) {
                                                e = e3;
                                            } catch (RuntimeException e4) {
                                                e = e4;
                                            }
                                        } else {
                                            int contentLength = httpURLConnection.getContentLength();
                                            if (contentLength < 0) {
                                                String strValueOf7 = String.valueOf(str);
                                                zzbad.i(strValueOf7.length() != 0 ? "Stream cache aborted, missing content-length header at ".concat(strValueOf7) : new String("Stream cache aborted, missing content-length header at "));
                                                q(str, file6.getAbsolutePath(), "contentLengthMissing", null);
                                                f14433i.remove(strConcat2);
                                                return false;
                                            }
                                            String str6 = f14434j.format(contentLength);
                                            int iIntValue2 = ((Integer) zzyt.e().c(zzacu.C)).intValue();
                                            if (contentLength > iIntValue2) {
                                                StringBuilder sb2 = new StringBuilder(String.valueOf(str6).length() + 33 + String.valueOf(str).length());
                                                sb2.append("Content length ");
                                                sb2.append(str6);
                                                sb2.append(" exceeds limit at ");
                                                sb2.append(str);
                                                zzbad.i(sb2.toString());
                                                String strValueOf8 = String.valueOf(str6);
                                                q(str, file6.getAbsolutePath(), "sizeExceeded", strValueOf8.length() != 0 ? "File too big for full file cache. Size: ".concat(strValueOf8) : new String("File too big for full file cache. Size: "));
                                                f14433i.remove(strConcat2);
                                                return false;
                                            }
                                            StringBuilder sb3 = new StringBuilder(String.valueOf(str6).length() + 20 + String.valueOf(str).length());
                                            sb3.append("Caching ");
                                            sb3.append(str6);
                                            sb3.append(" bytes from ");
                                            sb3.append(str);
                                            zzbad.e(sb3.toString());
                                            ReadableByteChannel readableByteChannelNewChannel = Channels.newChannel(httpURLConnection.getInputStream());
                                            FileOutputStream fileOutputStream3 = new FileOutputStream(file6);
                                            try {
                                                FileChannel channel = fileOutputStream3.getChannel();
                                                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(CacheHelper.VALUE_TO_CONVERT_MB_TO_BYTES);
                                                Clock clockZzln = zzk.zzln();
                                                long jA = clockZzln.a();
                                                ?? r10 = strConcat2;
                                                try {
                                                    zzazj zzazjVar = new zzazj(((Long) zzyt.e().c(zzacu.F)).longValue());
                                                    long jLongValue = ((Long) zzyt.e().c(zzacu.E)).longValue();
                                                    r10 = r10;
                                                    while (true) {
                                                        int i5 = readableByteChannelNewChannel.read(byteBufferAllocate);
                                                        if (i5 >= 0) {
                                                            i3 += i5;
                                                            if (i3 > iIntValue2) {
                                                                try {
                                                                    str5 = "sizeExceeded";
                                                                    String strValueOf9 = String.valueOf(Integer.toString(i3));
                                                                    String strConcat3 = strValueOf9.length() != 0 ? "File too big for full file cache. Size: ".concat(strValueOf9) : new String("File too big for full file cache. Size: ");
                                                                    try {
                                                                        throw new IOException("stream cache file size limit exceeded");
                                                                    } catch (IOException | RuntimeException e5) {
                                                                        e = e5;
                                                                        strConcat = strConcat3;
                                                                        fileOutputStream2 = fileOutputStream3;
                                                                        r2 = r10;
                                                                        if (e instanceof RuntimeException) {
                                                                            zzk.zzlk().e(e, "VideoStreamFullFileCache.preload");
                                                                        }
                                                                        fileOutputStream2.close();
                                                                        if (this.l) {
                                                                            StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 26);
                                                                            sb4.append("Preload aborted for URL \"");
                                                                            sb4.append(str);
                                                                            sb4.append("\"");
                                                                            zzbad.h(sb4.toString());
                                                                        } else {
                                                                            StringBuilder sb5 = new StringBuilder(String.valueOf(str).length() + 25);
                                                                            sb5.append("Preload failed for URL \"");
                                                                            sb5.append(str);
                                                                            sb5.append("\"");
                                                                            zzbad.d(sb5.toString(), e);
                                                                        }
                                                                        if (file6.exists()) {
                                                                            strValueOf = String.valueOf(file6.getAbsolutePath());
                                                                            if (strValueOf.length() != 0) {
                                                                                str2 = "Could not delete partial cache file at ".concat(strValueOf);
                                                                            } else {
                                                                                str2 = new String("Could not delete partial cache file at ");
                                                                            }
                                                                            zzbad.i(str2);
                                                                        }
                                                                        q(str, file6.getAbsolutePath(), str5, strConcat);
                                                                        f14433i.remove(r2);
                                                                        return false;
                                                                    }
                                                                } catch (IOException | RuntimeException e6) {
                                                                    e = e6;
                                                                    strConcat = null;
                                                                }
                                                            } else {
                                                                try {
                                                                    byteBufferAllocate.flip();
                                                                    while (channel.write(byteBufferAllocate) > 0) {
                                                                    }
                                                                    byteBufferAllocate.clear();
                                                                    r24 = ((clockZzln.a() - jA) > (1000 * jLongValue) ? 1 : ((clockZzln.a() - jA) == (1000 * jLongValue) ? 0 : -1));
                                                                    try {
                                                                        if (r24 <= 0) {
                                                                            ByteBuffer byteBuffer = byteBufferAllocate;
                                                                            if (this.l) {
                                                                                throw new IOException("abort requested");
                                                                            }
                                                                            if (zzazjVar.a()) {
                                                                                str4 = str5;
                                                                                try {
                                                                                    r24 = r10;
                                                                                    fileOutputStream = fileOutputStream3;
                                                                                    try {
                                                                                        try {
                                                                                            zzazt.a.post(new z9(this, str, file6.getAbsolutePath(), i3, contentLength, false));
                                                                                        } catch (RuntimeException e7) {
                                                                                            e = e7;
                                                                                            str5 = str4;
                                                                                            r4 = r24;
                                                                                            fileOutputStream2 = fileOutputStream;
                                                                                            strConcat = null;
                                                                                            r2 = r4;
                                                                                            if (e instanceof RuntimeException) {
                                                                                                zzk.zzlk().e(e, "VideoStreamFullFileCache.preload");
                                                                                            }
                                                                                            fileOutputStream2.close();
                                                                                            if (this.l) {
                                                                                                StringBuilder sb6 = new StringBuilder(String.valueOf(str).length() + 26);
                                                                                                sb6.append("Preload aborted for URL \"");
                                                                                                sb6.append(str);
                                                                                                sb6.append("\"");
                                                                                                zzbad.h(sb6.toString());
                                                                                            } else {
                                                                                                StringBuilder sb7 = new StringBuilder(String.valueOf(str).length() + 25);
                                                                                                sb7.append("Preload failed for URL \"");
                                                                                                sb7.append(str);
                                                                                                sb7.append("\"");
                                                                                                zzbad.d(sb7.toString(), e);
                                                                                            }
                                                                                            if (file6.exists()) {
                                                                                                strValueOf = String.valueOf(file6.getAbsolutePath());
                                                                                                if (strValueOf.length() != 0) {
                                                                                                    str2 = "Could not delete partial cache file at ".concat(strValueOf);
                                                                                                } else {
                                                                                                    str2 = new String("Could not delete partial cache file at ");
                                                                                                }
                                                                                                zzbad.i(str2);
                                                                                            }
                                                                                            q(str, file6.getAbsolutePath(), str5, strConcat);
                                                                                            f14433i.remove(r2);
                                                                                            return false;
                                                                                        }
                                                                                    } catch (IOException e8) {
                                                                                        e = e8;
                                                                                        str5 = str4;
                                                                                        r4 = r24;
                                                                                        fileOutputStream2 = fileOutputStream;
                                                                                        strConcat = null;
                                                                                        r2 = r4;
                                                                                        if (e instanceof RuntimeException) {
                                                                                            zzk.zzlk().e(e, "VideoStreamFullFileCache.preload");
                                                                                        }
                                                                                        fileOutputStream2.close();
                                                                                        if (this.l) {
                                                                                            StringBuilder sb8 = new StringBuilder(String.valueOf(str).length() + 26);
                                                                                            sb8.append("Preload aborted for URL \"");
                                                                                            sb8.append(str);
                                                                                            sb8.append("\"");
                                                                                            zzbad.h(sb8.toString());
                                                                                        } else {
                                                                                            StringBuilder sb9 = new StringBuilder(String.valueOf(str).length() + 25);
                                                                                            sb9.append("Preload failed for URL \"");
                                                                                            sb9.append(str);
                                                                                            sb9.append("\"");
                                                                                            zzbad.d(sb9.toString(), e);
                                                                                        }
                                                                                        if (file6.exists()) {
                                                                                            strValueOf = String.valueOf(file6.getAbsolutePath());
                                                                                            if (strValueOf.length() != 0) {
                                                                                                str2 = "Could not delete partial cache file at ".concat(strValueOf);
                                                                                            } else {
                                                                                                str2 = new String("Could not delete partial cache file at ");
                                                                                            }
                                                                                            zzbad.i(str2);
                                                                                        }
                                                                                        q(str, file6.getAbsolutePath(), str5, strConcat);
                                                                                        f14433i.remove(r2);
                                                                                        return false;
                                                                                    }
                                                                                } catch (IOException e9) {
                                                                                    e = e9;
                                                                                    fileOutputStream = fileOutputStream3;
                                                                                    r5 = r10;
                                                                                    str5 = str4;
                                                                                    r4 = r5;
                                                                                    fileOutputStream2 = fileOutputStream;
                                                                                    strConcat = null;
                                                                                    r2 = r4;
                                                                                    if (e instanceof RuntimeException) {
                                                                                        zzk.zzlk().e(e, "VideoStreamFullFileCache.preload");
                                                                                    }
                                                                                    fileOutputStream2.close();
                                                                                    if (this.l) {
                                                                                        StringBuilder sb10 = new StringBuilder(String.valueOf(str).length() + 26);
                                                                                        sb10.append("Preload aborted for URL \"");
                                                                                        sb10.append(str);
                                                                                        sb10.append("\"");
                                                                                        zzbad.h(sb10.toString());
                                                                                    } else {
                                                                                        StringBuilder sb11 = new StringBuilder(String.valueOf(str).length() + 25);
                                                                                        sb11.append("Preload failed for URL \"");
                                                                                        sb11.append(str);
                                                                                        sb11.append("\"");
                                                                                        zzbad.d(sb11.toString(), e);
                                                                                    }
                                                                                    if (file6.exists()) {
                                                                                        strValueOf = String.valueOf(file6.getAbsolutePath());
                                                                                        if (strValueOf.length() != 0) {
                                                                                            str2 = "Could not delete partial cache file at ".concat(strValueOf);
                                                                                        } else {
                                                                                            str2 = new String("Could not delete partial cache file at ");
                                                                                        }
                                                                                        zzbad.i(str2);
                                                                                    }
                                                                                    q(str, file6.getAbsolutePath(), str5, strConcat);
                                                                                    f14433i.remove(r2);
                                                                                    return false;
                                                                                } catch (RuntimeException e10) {
                                                                                    e = e10;
                                                                                    fileOutputStream = fileOutputStream3;
                                                                                    r5 = r10;
                                                                                    str5 = str4;
                                                                                    r4 = r5;
                                                                                    fileOutputStream2 = fileOutputStream;
                                                                                    strConcat = null;
                                                                                    r2 = r4;
                                                                                    if (e instanceof RuntimeException) {
                                                                                        zzk.zzlk().e(e, "VideoStreamFullFileCache.preload");
                                                                                    }
                                                                                    fileOutputStream2.close();
                                                                                    if (this.l) {
                                                                                        StringBuilder sb12 = new StringBuilder(String.valueOf(str).length() + 26);
                                                                                        sb12.append("Preload aborted for URL \"");
                                                                                        sb12.append(str);
                                                                                        sb12.append("\"");
                                                                                        zzbad.h(sb12.toString());
                                                                                    } else {
                                                                                        StringBuilder sb13 = new StringBuilder(String.valueOf(str).length() + 25);
                                                                                        sb13.append("Preload failed for URL \"");
                                                                                        sb13.append(str);
                                                                                        sb13.append("\"");
                                                                                        zzbad.d(sb13.toString(), e);
                                                                                    }
                                                                                    if (file6.exists()) {
                                                                                        strValueOf = String.valueOf(file6.getAbsolutePath());
                                                                                        if (strValueOf.length() != 0) {
                                                                                            str2 = "Could not delete partial cache file at ".concat(strValueOf);
                                                                                        } else {
                                                                                            str2 = new String("Could not delete partial cache file at ");
                                                                                        }
                                                                                        zzbad.i(str2);
                                                                                    }
                                                                                    q(str, file6.getAbsolutePath(), str5, strConcat);
                                                                                    f14433i.remove(r2);
                                                                                    return false;
                                                                                }
                                                                            } else {
                                                                                fileOutputStream = fileOutputStream3;
                                                                                r24 = r10;
                                                                                str4 = str5;
                                                                            }
                                                                            zzazjVar = zzazjVar;
                                                                            byteBufferAllocate = byteBuffer;
                                                                            readableByteChannelNewChannel = readableByteChannelNewChannel;
                                                                            str5 = str4;
                                                                            r10 = r24;
                                                                            channel = channel;
                                                                            iIntValue2 = iIntValue2;
                                                                            fileOutputStream3 = fileOutputStream;
                                                                            contentLength = contentLength;
                                                                        } else {
                                                                            FileOutputStream fileOutputStream4 = fileOutputStream3;
                                                                            ?? r25 = r10;
                                                                            str5 = "downloadTimeout";
                                                                            String string = Long.toString(jLongValue);
                                                                            StringBuilder sb14 = new StringBuilder(String.valueOf(string).length() + 29);
                                                                            sb14.append("Timeout exceeded. Limit: ");
                                                                            sb14.append(string);
                                                                            sb14.append(" sec");
                                                                            String string2 = sb14.toString();
                                                                            try {
                                                                                throw new IOException("stream cache time limit exceeded");
                                                                            } catch (IOException | RuntimeException e11) {
                                                                                e = e11;
                                                                                strConcat = string2;
                                                                                r2 = r25;
                                                                                fileOutputStream2 = fileOutputStream4;
                                                                            }
                                                                        }
                                                                    } catch (IOException e12) {
                                                                        e = e12;
                                                                        r4 = r24;
                                                                        fileOutputStream2 = fileOutputStream;
                                                                        strConcat = null;
                                                                        r2 = r4;
                                                                    } catch (RuntimeException e13) {
                                                                        e = e13;
                                                                        r4 = r24;
                                                                        fileOutputStream2 = fileOutputStream;
                                                                        strConcat = null;
                                                                        r2 = r4;
                                                                    }
                                                                } catch (IOException | RuntimeException e14) {
                                                                    e = e14;
                                                                    fileOutputStream = fileOutputStream3;
                                                                    r4 = r10;
                                                                    fileOutputStream2 = fileOutputStream;
                                                                    strConcat = null;
                                                                    r2 = r4;
                                                                }
                                                            }
                                                            if (e instanceof RuntimeException) {
                                                                zzk.zzlk().e(e, "VideoStreamFullFileCache.preload");
                                                            }
                                                            fileOutputStream2.close();
                                                            if (this.l) {
                                                                StringBuilder sb15 = new StringBuilder(String.valueOf(str).length() + 26);
                                                                sb15.append("Preload aborted for URL \"");
                                                                sb15.append(str);
                                                                sb15.append("\"");
                                                                zzbad.h(sb15.toString());
                                                            } else {
                                                                StringBuilder sb16 = new StringBuilder(String.valueOf(str).length() + 25);
                                                                sb16.append("Preload failed for URL \"");
                                                                sb16.append(str);
                                                                sb16.append("\"");
                                                                zzbad.d(sb16.toString(), e);
                                                            }
                                                            if (file6.exists() && !file6.delete()) {
                                                                strValueOf = String.valueOf(file6.getAbsolutePath());
                                                                if (strValueOf.length() != 0) {
                                                                    str2 = "Could not delete partial cache file at ".concat(strValueOf);
                                                                } else {
                                                                    str2 = new String("Could not delete partial cache file at ");
                                                                }
                                                                zzbad.i(str2);
                                                            }
                                                            q(str, file6.getAbsolutePath(), str5, strConcat);
                                                            f14433i.remove(r2);
                                                            return false;
                                                        }
                                                        fileOutputStream = fileOutputStream3;
                                                        r24 = r10;
                                                        str4 = str5;
                                                        try {
                                                            fileOutputStream.close();
                                                            if (zzbad.a(3)) {
                                                                String str7 = f14434j.format(i3);
                                                                StringBuilder sb17 = new StringBuilder(String.valueOf(str7).length() + 22 + String.valueOf(str).length());
                                                                sb17.append("Preloaded ");
                                                                sb17.append(str7);
                                                                sb17.append(" bytes from ");
                                                                sb17.append(str);
                                                                zzbad.e(sb17.toString());
                                                            }
                                                            file6.setReadable(true, false);
                                                            if (fileB2.isFile()) {
                                                                fileB2.setLastModified(System.currentTimeMillis());
                                                            } else {
                                                                try {
                                                                    fileB2.createNewFile();
                                                                } catch (IOException unused) {
                                                                }
                                                            }
                                                            j(str, file6.getAbsolutePath(), i3);
                                                            r5 = r24;
                                                            try {
                                                                f14433i.remove(r5);
                                                                return true;
                                                            } catch (IOException e15) {
                                                                e = e15;
                                                            } catch (RuntimeException e16) {
                                                                e = e16;
                                                            }
                                                        } catch (IOException | RuntimeException e17) {
                                                            e = e17;
                                                            r5 = r24;
                                                        }
                                                        str5 = str4;
                                                        r4 = r5;
                                                        fileOutputStream2 = fileOutputStream;
                                                        strConcat = null;
                                                        r2 = r4;
                                                        if (e instanceof RuntimeException) {
                                                            zzk.zzlk().e(e, "VideoStreamFullFileCache.preload");
                                                        }
                                                        fileOutputStream2.close();
                                                        if (this.l) {
                                                            StringBuilder sb18 = new StringBuilder(String.valueOf(str).length() + 26);
                                                            sb18.append("Preload aborted for URL \"");
                                                            sb18.append(str);
                                                            sb18.append("\"");
                                                            zzbad.h(sb18.toString());
                                                        } else {
                                                            StringBuilder sb19 = new StringBuilder(String.valueOf(str).length() + 25);
                                                            sb19.append("Preload failed for URL \"");
                                                            sb19.append(str);
                                                            sb19.append("\"");
                                                            zzbad.d(sb19.toString(), e);
                                                        }
                                                        if (file6.exists()) {
                                                            strValueOf = String.valueOf(file6.getAbsolutePath());
                                                            if (strValueOf.length() != 0) {
                                                                str2 = "Could not delete partial cache file at ".concat(strValueOf);
                                                            } else {
                                                                str2 = new String("Could not delete partial cache file at ");
                                                            }
                                                            zzbad.i(str2);
                                                        }
                                                        q(str, file6.getAbsolutePath(), str5, strConcat);
                                                        f14433i.remove(r2);
                                                        return false;
                                                    }
                                                } catch (IOException | RuntimeException e18) {
                                                    e = e18;
                                                    fileOutputStream = fileOutputStream3;
                                                    r3 = r10;
                                                    r4 = r3;
                                                }
                                            } catch (IOException | RuntimeException e19) {
                                                e = e19;
                                                fileOutputStream = fileOutputStream3;
                                                r3 = strConcat2;
                                            }
                                        }
                                    }
                                    r2 = strConcat2;
                                    if (e instanceof RuntimeException) {
                                        zzk.zzlk().e(e, "VideoStreamFullFileCache.preload");
                                    }
                                    fileOutputStream2.close();
                                    if (this.l) {
                                        StringBuilder sb110 = new StringBuilder(String.valueOf(str).length() + 26);
                                        sb110.append("Preload aborted for URL \"");
                                        sb110.append(str);
                                        sb110.append("\"");
                                        zzbad.h(sb110.toString());
                                    } else {
                                        StringBuilder sb111 = new StringBuilder(String.valueOf(str).length() + 25);
                                        sb111.append("Preload failed for URL \"");
                                        sb111.append(str);
                                        sb111.append("\"");
                                        zzbad.d(sb111.toString(), e);
                                    }
                                    if (file6.exists()) {
                                        strValueOf = String.valueOf(file6.getAbsolutePath());
                                        if (strValueOf.length() != 0) {
                                            str2 = "Could not delete partial cache file at ".concat(strValueOf);
                                        } else {
                                            str2 = new String("Could not delete partial cache file at ");
                                        }
                                        zzbad.i(str2);
                                    }
                                    q(str, file6.getAbsolutePath(), str5, strConcat);
                                    f14433i.remove(r2);
                                    return false;
                                } catch (IOException | RuntimeException e20) {
                                    e = e20;
                                    str5 = str3;
                                    r1 = iIntValue;
                                    strConcat = null;
                                    fileOutputStream2 = null;
                                    r2 = r1;
                                }
                                fileOutputStream2.close();
                            } catch (IOException | NullPointerException unused2) {
                            }
                            strConcat = null;
                            fileOutputStream2 = null;
                            r2 = r1;
                            if (e instanceof RuntimeException) {
                                zzk.zzlk().e(e, "VideoStreamFullFileCache.preload");
                            }
                            if (this.l) {
                                StringBuilder sb112 = new StringBuilder(String.valueOf(str).length() + 26);
                                sb112.append("Preload aborted for URL \"");
                                sb112.append(str);
                                sb112.append("\"");
                                zzbad.h(sb112.toString());
                            } else {
                                StringBuilder sb113 = new StringBuilder(String.valueOf(str).length() + 25);
                                sb113.append("Preload failed for URL \"");
                                sb113.append(str);
                                sb113.append("\"");
                                zzbad.d(sb113.toString(), e);
                            }
                            if (file6.exists()) {
                                strValueOf = String.valueOf(file6.getAbsolutePath());
                                if (strValueOf.length() != 0) {
                                    str2 = "Could not delete partial cache file at ".concat(strValueOf);
                                } else {
                                    str2 = new String("Could not delete partial cache file at ");
                                }
                                zzbad.i(str2);
                            }
                            q(str, file6.getAbsolutePath(), str5, strConcat);
                            f14433i.remove(r2);
                            return false;
                        }
                    } catch (IOException | RuntimeException e21) {
                        e = e21;
                        r1 = strConcat2;
                    }
                }
            }
        } while (zDelete);
        zzbad.i("Unable to expire stream cache");
        q(str, null, "expireFailed", null);
        return false;
    }
}
