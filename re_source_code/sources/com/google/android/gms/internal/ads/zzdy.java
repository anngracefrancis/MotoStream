package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class zzdy {
    private static final String a = "zzdy";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Context f16182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ExecutorService f16183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private DexClassLoader f16184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzdj f16185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f16186f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f16190j;
    private zzda m;
    private Map<Pair<String, String>, zzfi> p;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile AdvertisingIdClient f16187g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f16188h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Future f16189i = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile zzbp.zza f16191k = null;
    private Future l = null;
    protected boolean n = false;
    private boolean o = false;
    private boolean q = false;
    private boolean r = true;
    private boolean s = false;

    final class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                zzdy.this.r = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                zzdy.this.r = false;
            }
        }

        /* synthetic */ a(zzdy zzdyVar, ly lyVar) {
            this();
        }
    }

    private zzdy(Context context) {
        Context applicationContext = context.getApplicationContext();
        boolean z = applicationContext != null;
        this.f16190j = z;
        this.f16182b = z ? applicationContext : context;
        this.p = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        try {
            if (this.f16187g == null && this.f16190j) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.f16182b);
                advertisingIdClient.start();
                this.f16187g = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.f16187g = null;
        }
    }

    private final zzbp.zza C() {
        try {
            PackageInfo packageInfo = this.f16182b.getPackageManager().getPackageInfo(this.f16182b.getPackageName(), 0);
            Context context = this.f16182b;
            return zzdal.a(context, context.getPackageName(), Integer.toString(packageInfo.versionCode));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static zzdy d(Context context, String str, String str2, boolean z) throws Throwable {
        zzdy zzdyVar = new zzdy(context);
        try {
            zzdyVar.f16183c = Executors.newCachedThreadPool(new ly());
            zzdyVar.f16188h = z;
            if (z) {
                zzdyVar.f16189i = zzdyVar.f16183c.submit(new ny(zzdyVar));
            }
            zzdyVar.f16183c.execute(new py(zzdyVar));
            try {
                GoogleApiAvailabilityLight googleApiAvailabilityLightH = GoogleApiAvailabilityLight.h();
                zzdyVar.n = googleApiAvailabilityLightH.b(zzdyVar.f16182b) > 0;
                zzdyVar.o = googleApiAvailabilityLightH.i(zzdyVar.f16182b) == 0;
            } catch (Throwable unused) {
            }
            zzdyVar.e(0, true);
            if (zzef.a() && ((Boolean) zzyt.e().c(zzacu.u2)).booleanValue()) {
                throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
            }
            ly lyVar = null;
            zzdj zzdjVar = new zzdj(null);
            zzdyVar.f16185e = zzdjVar;
            try {
                zzdyVar.f16186f = zzdjVar.c(str);
                try {
                    try {
                        try {
                            File cacheDir = zzdyVar.f16182b.getCacheDir();
                            if (cacheDir == null && (cacheDir = zzdyVar.f16182b.getDir("dex", 0)) == null) {
                                throw new zzdv();
                            }
                            File file = new File(String.format("%s/%s.jar", cacheDir, "1542658731108"));
                            if (!file.exists()) {
                                byte[] bArrB = zzdyVar.f16185e.b(zzdyVar.f16186f, str2);
                                file.createNewFile();
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                fileOutputStream.write(bArrB, 0, bArrB.length);
                                fileOutputStream.close();
                            }
                            zzdyVar.o(cacheDir, "1542658731108");
                            try {
                                zzdyVar.f16184d = new DexClassLoader(file.getAbsolutePath(), cacheDir.getAbsolutePath(), null, zzdyVar.f16182b.getClassLoader());
                                m(file);
                                zzdyVar.g(cacheDir, "1542658731108");
                                k(String.format("%s/%s.dex", cacheDir, "1542658731108"));
                                if (!zzdyVar.s) {
                                    IntentFilter intentFilter = new IntentFilter();
                                    intentFilter.addAction("android.intent.action.USER_PRESENT");
                                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                                    zzdyVar.f16182b.registerReceiver(new a(zzdyVar, lyVar), intentFilter);
                                    zzdyVar.s = true;
                                }
                                zzdyVar.m = new zzda(zzdyVar);
                                zzdyVar.q = true;
                                return zzdyVar;
                            } catch (Throwable th) {
                                m(file);
                                zzdyVar.g(cacheDir, "1542658731108");
                                k(String.format("%s/%s.dex", cacheDir, "1542658731108"));
                                throw th;
                            }
                        } catch (FileNotFoundException e2) {
                            throw new zzdv(e2);
                        }
                    } catch (IOException e3) {
                        throw new zzdv(e3);
                    }
                } catch (zzdk e4) {
                    throw new zzdv(e4);
                } catch (NullPointerException e5) {
                    throw new zzdv(e5);
                }
            } catch (zzdk e6) {
                throw new zzdv(e6);
            }
        } catch (zzdv unused2) {
        }
    }

    private final void g(File file, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, str));
        if (file2.exists()) {
            return;
        }
        File file3 = new File(String.format("%s/%s.dex", file, str));
        if (file3.exists()) {
            long length = file3.length();
            if (length <= 0) {
                return;
            }
            byte[] bArr = new byte[(int) length];
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file3);
                try {
                    try {
                        if (fileInputStream2.read(bArr) <= 0) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused) {
                            }
                            m(file3);
                            return;
                        }
                        System.out.print("test");
                        System.out.print("test");
                        System.out.print("test");
                        zzbp.zzd.zza zzaVarW = zzbp.zzd.D().A(zzdmr.D(Build.VERSION.SDK.getBytes())).w(zzdmr.D(str.getBytes()));
                        byte[] bytes = this.f16185e.d(this.f16186f, bArr).getBytes();
                        zzaVarW.u(zzdmr.D(bytes)).v(zzdmr.D(ij.e(bytes)));
                        file2.createNewFile();
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            byte[] bArrG = ((zzbp.zzd) ((zzdob) zzaVarW.p0())).g();
                            fileOutputStream.write(bArrG, 0, bArrG.length);
                            fileOutputStream.close();
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused2) {
                            }
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused3) {
                            }
                            m(file3);
                            return;
                        } catch (zzdk | IOException | NoSuchAlgorithmException unused4) {
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused5) {
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused6) {
                                }
                            }
                            m(file3);
                            return;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                    }
                } catch (zzdk | IOException | NoSuchAlgorithmException unused7) {
                    fileOutputStream = null;
                }
                fileInputStream = fileInputStream2;
            } catch (zzdk | IOException | NoSuchAlgorithmException unused8) {
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused9) {
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused10) {
                }
            }
            m(file3);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean h(int i2, zzbp.zza zzaVar) {
        if (i2 < 4) {
            return zzaVar == null || !zzaVar.d0() || zzaVar.U().equals("0000000000000000000000000000000000000000000000000000000000000000") || !zzaVar.i0() || !zzaVar.j0().x() || zzaVar.j0().y() == -2;
        }
        return false;
    }

    private static void k(String str) {
        m(new File(str));
    }

    private static void m(File file) {
        if (file.exists()) {
            file.delete();
        } else {
            Log.d(a, String.format("File %s not found. No need for deletion", file.getAbsolutePath()));
        }
    }

    private final boolean o(File file, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, str));
        if (!file2.exists()) {
            return false;
        }
        File file3 = new File(String.format("%s/%s.dex", file, str));
        if (file3.exists()) {
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            long length = file2.length();
            if (length <= 0) {
                m(file2);
                return false;
            }
            byte[] bArr = new byte[(int) length];
            FileInputStream fileInputStream2 = new FileInputStream(file2);
            try {
                try {
                    if (fileInputStream2.read(bArr) <= 0) {
                        Log.d(a, "Cannot read the cache data.");
                        m(file2);
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused) {
                        }
                        return false;
                    }
                    zzbp.zzd zzdVarF = zzbp.zzd.F(bArr, zzdno.e());
                    if (str.equals(new String(zzdVarF.B().c())) && Arrays.equals(zzdVarF.z().c(), ij.e(zzdVarF.y().c())) && Arrays.equals(zzdVarF.C().c(), Build.VERSION.SDK.getBytes())) {
                        byte[] bArrB = this.f16185e.b(this.f16186f, new String(zzdVarF.y().c()));
                        file3.createNewFile();
                        fileOutputStream = new FileOutputStream(file3);
                        try {
                            fileOutputStream.write(bArrB, 0, bArrB.length);
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused2) {
                            }
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused3) {
                            }
                            return true;
                        } catch (zzdk | IOException | NoSuchAlgorithmException unused4) {
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused5) {
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused6) {
                                }
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused7) {
                                }
                            }
                            if (fileOutputStream == null) {
                                throw th;
                            }
                            try {
                                fileOutputStream.close();
                                throw th;
                            } catch (IOException unused8) {
                                throw th;
                            }
                        }
                    }
                    m(file2);
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused9) {
                    }
                    return false;
                } catch (zzdk | IOException | NoSuchAlgorithmException unused10) {
                    fileOutputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (zzdk | IOException | NoSuchAlgorithmException unused11) {
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public final Future A() {
        return this.l;
    }

    public final AdvertisingIdClient D() {
        if (!this.f16188h) {
            return null;
        }
        if (this.f16187g != null) {
            return this.f16187g;
        }
        Future future = this.f16189i;
        if (future != null) {
            try {
                future.get(2000L, TimeUnit.MILLISECONDS);
                this.f16189i = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.f16189i.cancel(true);
            }
        }
        return this.f16187g;
    }

    public final Context a() {
        return this.f16182b;
    }

    public final boolean b() {
        return this.q;
    }

    final void e(int i2, boolean z) {
        if (this.o) {
            Future<?> futureSubmit = this.f16183c.submit(new oy(this, i2, z));
            if (i2 == 0) {
                this.l = futureSubmit;
            }
        }
    }

    public final boolean j(String str, String str2, Class<?>... clsArr) {
        if (this.p.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.p.put(new Pair<>(str, str2), new zzfi(this, str, str2, clsArr));
        return true;
    }

    final zzbp.zza l(int i2, boolean z) {
        if (i2 > 0 && z) {
            try {
                Thread.sleep(i2 * 1000);
            } catch (InterruptedException unused) {
            }
        }
        return C();
    }

    public final Method p(String str, String str2) {
        zzfi zzfiVar = this.p.get(new Pair(str, str2));
        if (zzfiVar == null) {
            return null;
        }
        return zzfiVar.d();
    }

    public final int q() {
        if (this.m != null) {
            return zzda.d();
        }
        return Integer.MIN_VALUE;
    }

    public final ExecutorService r() {
        return this.f16183c;
    }

    public final DexClassLoader s() {
        return this.f16184d;
    }

    public final zzdj t() {
        return this.f16185e;
    }

    public final byte[] u() {
        return this.f16186f;
    }

    public final boolean v() {
        return this.n;
    }

    public final zzda w() {
        return this.m;
    }

    public final boolean x() {
        return this.o;
    }

    public final boolean y() {
        return this.r;
    }

    public final zzbp.zza z() {
        return this.f16191k;
    }
}
