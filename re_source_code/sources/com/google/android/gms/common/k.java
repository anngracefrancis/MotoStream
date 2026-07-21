package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile zzaf f12081e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Context f12083g;
    static final i a = new c(g.k0("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final i f12078b = new d(g.k0("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final i f12079c = new e(g.k0("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final i f12080d = new f(g.k0("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f12082f = new Object();

    static m a(String str, g gVar, boolean z, boolean z2) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return f(str, gVar, z, z2);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    static m b(String str, boolean z, boolean z2, boolean z3) {
        return g(str, z, false, false, true);
    }

    static /* synthetic */ String c(boolean z, String str, g gVar) throws Exception {
        String str2 = true != (!z && f(str, gVar, true, false).f12088b) ? "not allowed" : "debug cert rejected";
        MessageDigest messageDigestB = AndroidUtilsLight.b("SHA-256");
        Preconditions.k(messageDigestB);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str2, str, Hex.a(messageDigestB.digest(gVar.E0())), Boolean.valueOf(z), "12451000.false");
    }

    static synchronized void d(Context context) {
        if (f12083g != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            f12083g = context.getApplicationContext();
        }
    }

    static boolean e() {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                h();
                return f12081e.l();
            } finally {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return false;
        }
    }

    private static m f(final String str, final g gVar, final boolean z, boolean z2) {
        try {
            h();
            Preconditions.k(f12083g);
            try {
                return f12081e.C1(new zzs(str, gVar, z, z2), ObjectWrapper.E0(f12083g.getPackageManager())) ? m.b() : new l(new Callable() { // from class: com.google.android.gms.common.zze
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return k.c(z, str, gVar);
                    }
                }, null);
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                return m.d("module call", e2);
            }
        } catch (DynamiteModule.LoadingException e3) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            return m.d("module init: ".concat(String.valueOf(e3.getMessage())), e3);
        }
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [android.os.IBinder, com.google.android.gms.dynamic.IObjectWrapper] */
    private static m g(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        m mVarD;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Preconditions.k(f12083g);
            try {
                h();
                zzo zzoVar = new zzo(str, z, false, ObjectWrapper.E0(f12083g), false);
                try {
                    zzq zzqVarQ3 = z4 ? f12081e.q3(zzoVar) : f12081e.c4(zzoVar);
                    if (zzqVarQ3.z()) {
                        mVarD = m.f(zzqVarQ3.W());
                    } else {
                        String strY = zzqVarQ3.y();
                        PackageManager.NameNotFoundException nameNotFoundException = zzqVarQ3.Y() == 4 ? new PackageManager.NameNotFoundException() : null;
                        if (strY == null) {
                            strY = "error checking package certificate";
                        }
                        mVarD = m.g(zzqVarQ3.W(), zzqVarQ3.Y(), strY, nameNotFoundException);
                    }
                } catch (RemoteException e2) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                    mVarD = m.d("module call", e2);
                }
            } catch (DynamiteModule.LoadingException e3) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
                mVarD = m.d("module init: ".concat(String.valueOf(e3.getMessage())), e3);
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return mVarD;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    private static void h() throws DynamiteModule.LoadingException {
        if (f12081e != null) {
            return;
        }
        Preconditions.k(f12083g);
        synchronized (f12082f) {
            if (f12081e == null) {
                f12081e = com.google.android.gms.common.internal.zzae.P(DynamiteModule.e(f12083g, DynamiteModule.f12196e, "com.google.android.gms.googlecertificates").d("com.google.android.gms.common.GoogleCertificatesImpl"));
            }
        }
    }
}
