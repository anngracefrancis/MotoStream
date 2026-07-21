package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class zzan implements zzb {
    private final Map<String, v2> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f13990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f13991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f13992d;

    public zzan(File file, int i2) {
        this.a = new LinkedHashMap(16, 0.75f, true);
        this.f13990b = 0L;
        this.f13991c = file;
        this.f13992d = i2;
    }

    private final synchronized void b(String str) {
        boolean zDelete = p(str).delete();
        c(str);
        if (!zDelete) {
            zzag.a("Could not delete cache entry for key=%s, filename=%s", str, o(str));
        }
    }

    private final void c(String str) {
        v2 v2VarRemove = this.a.remove(str);
        if (v2VarRemove != null) {
            this.f13990b -= v2VarRemove.a;
        }
    }

    private static int d(InputStream inputStream) throws IOException {
        int i2 = inputStream.read();
        if (i2 != -1) {
            return i2;
        }
        throw new EOFException();
    }

    private static InputStream e(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    static String f(y2 y2Var) throws IOException {
        return new String(k(y2Var, n(y2Var)), "UTF-8");
    }

    static void g(OutputStream outputStream, int i2) throws IOException {
        outputStream.write(i2 & 255);
        outputStream.write((i2 >> 8) & 255);
        outputStream.write((i2 >> 16) & 255);
        outputStream.write(i2 >>> 24);
    }

    static void h(OutputStream outputStream, long j2) throws IOException {
        outputStream.write((byte) j2);
        outputStream.write((byte) (j2 >>> 8));
        outputStream.write((byte) (j2 >>> 16));
        outputStream.write((byte) (j2 >>> 24));
        outputStream.write((byte) (j2 >>> 32));
        outputStream.write((byte) (j2 >>> 40));
        outputStream.write((byte) (j2 >>> 48));
        outputStream.write((byte) (j2 >>> 56));
    }

    static void i(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        h(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private final void j(String str, v2 v2Var) {
        if (this.a.containsKey(str)) {
            this.f13990b += v2Var.a - this.a.get(str).a;
        } else {
            this.f13990b += v2Var.a;
        }
        this.a.put(str, v2Var);
    }

    private static byte[] k(y2 y2Var, long j2) throws IOException {
        long jA = y2Var.a();
        if (j2 >= 0 && j2 <= jA) {
            int i2 = (int) j2;
            if (i2 == j2) {
                byte[] bArr = new byte[i2];
                new DataInputStream(y2Var).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder sb = new StringBuilder(73);
        sb.append("streamToBytes length=");
        sb.append(j2);
        sb.append(", maxLength=");
        sb.append(jA);
        throw new IOException(sb.toString());
    }

    static int l(InputStream inputStream) throws IOException {
        return (d(inputStream) << 24) | d(inputStream) | 0 | (d(inputStream) << 8) | (d(inputStream) << 16);
    }

    static List<zzl> m(y2 y2Var) throws IOException {
        int iL = l(y2Var);
        if (iL < 0) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("readHeaderList size=");
            sb.append(iL);
            throw new IOException(sb.toString());
        }
        List<zzl> listEmptyList = iL == 0 ? Collections.emptyList() : new ArrayList<>();
        for (int i2 = 0; i2 < iL; i2++) {
            listEmptyList.add(new zzl(f(y2Var).intern(), f(y2Var).intern()));
        }
        return listEmptyList;
    }

    static long n(InputStream inputStream) throws IOException {
        return (((long) d(inputStream)) & 255) | 0 | ((((long) d(inputStream)) & 255) << 8) | ((((long) d(inputStream)) & 255) << 16) | ((((long) d(inputStream)) & 255) << 24) | ((((long) d(inputStream)) & 255) << 32) | ((((long) d(inputStream)) & 255) << 40) | ((((long) d(inputStream)) & 255) << 48) | ((255 & ((long) d(inputStream))) << 56);
    }

    private static String o(String str) {
        int length = str.length() / 2;
        String strValueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String strValueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    private final File p(String str) {
        return new File(this.f13991c, o(str));
    }

    @Override // com.google.android.gms.internal.ads.zzb
    public final synchronized void a() {
        try {
            if (!this.f13991c.exists()) {
                if (!this.f13991c.mkdirs()) {
                    zzag.b("Unable to create cache dir %s", this.f13991c.getAbsolutePath());
                }
                return;
            }
            File[] fileArrListFiles = this.f13991c.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            for (File file : fileArrListFiles) {
                try {
                    long length = file.length();
                    y2 y2Var = new y2(new BufferedInputStream(e(file)), length);
                    try {
                        v2 v2VarB = v2.b(y2Var);
                        v2VarB.a = length;
                        j(v2VarB.f13429b, v2VarB);
                        y2Var.close();
                    } catch (Throwable th) {
                        y2Var.close();
                        throw th;
                    }
                } catch (IOException unused) {
                    file.delete();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzb
    public final synchronized zzc u(String str) {
        v2 v2Var = this.a.get(str);
        if (v2Var == null) {
            return null;
        }
        File fileP = p(str);
        try {
            y2 y2Var = new y2(new BufferedInputStream(e(fileP)), fileP.length());
            try {
                v2 v2VarB = v2.b(y2Var);
                if (!TextUtils.equals(str, v2VarB.f13429b)) {
                    zzag.a("%s: key=%s, found=%s", fileP.getAbsolutePath(), str, v2VarB.f13429b);
                    c(str);
                    y2Var.close();
                    return null;
                }
                byte[] bArrK = k(y2Var, y2Var.a());
                zzc zzcVar = new zzc();
                zzcVar.a = bArrK;
                zzcVar.f14946b = v2Var.f13430c;
                zzcVar.f14947c = v2Var.f13431d;
                zzcVar.f14948d = v2Var.f13432e;
                zzcVar.f14949e = v2Var.f13433f;
                zzcVar.f14950f = v2Var.f13434g;
                List<zzl> list = v2Var.f13435h;
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (zzl zzlVar : list) {
                    treeMap.put(zzlVar.a(), zzlVar.b());
                }
                zzcVar.f14951g = treeMap;
                zzcVar.f14952h = Collections.unmodifiableList(v2Var.f13435h);
                y2Var.close();
                return zzcVar;
            } catch (Throwable th) {
                y2Var.close();
                throw th;
            }
        } catch (IOException e2) {
            zzag.a("%s: %s", fileP.getAbsolutePath(), e2.toString());
            b(str);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzb
    public final synchronized void v(String str, zzc zzcVar) {
        long j2 = this.f13990b;
        byte[] bArr = zzcVar.a;
        long length = j2 + ((long) bArr.length);
        int i2 = this.f13992d;
        if (length <= i2 || bArr.length <= i2 * 0.9f) {
            File fileP = p(str);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileP));
                v2 v2Var = new v2(str, zzcVar);
                if (!v2Var.a(bufferedOutputStream)) {
                    bufferedOutputStream.close();
                    zzag.a("Failed to write header for %s", fileP.getAbsolutePath());
                    throw new IOException();
                }
                bufferedOutputStream.write(zzcVar.a);
                bufferedOutputStream.close();
                v2Var.a = fileP.length();
                j(str, v2Var);
                if (this.f13990b >= this.f13992d) {
                    if (zzag.f13871b) {
                        zzag.c("Pruning old cache entries.", new Object[0]);
                    }
                    long j3 = this.f13990b;
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    Iterator<Map.Entry<String, v2>> it = this.a.entrySet().iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            jElapsedRealtime = jElapsedRealtime;
                            break;
                        }
                        v2 value = it.next().getValue();
                        if (p(value.f13429b).delete()) {
                            this.f13990b -= value.a;
                        } else {
                            String str2 = value.f13429b;
                            zzag.a("Could not delete cache entry for key=%s, filename=%s", str2, o(str2));
                        }
                        it.remove();
                        i3++;
                        if (this.f13990b < this.f13992d * 0.9f) {
                            break;
                        } else {
                            jElapsedRealtime = jElapsedRealtime;
                        }
                    }
                    if (zzag.f13871b) {
                        zzag.c("pruned %d files, %d bytes, %d ms", Integer.valueOf(i3), Long.valueOf(this.f13990b - j3), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
                    }
                }
            } catch (IOException unused) {
                if (fileP.delete()) {
                    return;
                }
                zzag.a("Could not clean up file %s", fileP.getAbsolutePath());
            }
        }
    }

    public zzan(File file) {
        this(file, 5242880);
    }
}
