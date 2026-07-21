package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public final class DynamiteModule {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Boolean f12198g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f12199h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f12200i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f12201j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Boolean f12202k;
    private static zzq p;
    private static zzr q;
    private final Context r;
    private static final ThreadLocal l = new ThreadLocal();
    private static final ThreadLocal m = new c();
    private static final VersionPolicy.IVersions n = new d();

    @KeepForSdk
    public static final VersionPolicy a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @KeepForSdk
    public static final VersionPolicy f12193b = new f();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @KeepForSdk
    public static final VersionPolicy f12194c = new g();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @KeepForSdk
    public static final VersionPolicy f12195d = new h();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @KeepForSdk
    public static final VersionPolicy f12196e = new i();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @KeepForSdk
    public static final VersionPolicy f12197f = new j();
    public static final VersionPolicy o = new k();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    @KeepForSdk
    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, zzp zzpVar) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zzp zzpVar) {
            super(str, th);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public interface VersionPolicy {

        /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
        @KeepForSdk
        public interface IVersions {
            int a(Context context, String str, boolean z) throws LoadingException;

            int b(Context context, String str);
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
        @KeepForSdk
        public static class SelectionResult {

            @KeepForSdk
            public int a = 0;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @KeepForSdk
            public int f12203b = 0;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @KeepForSdk
            public int f12204c = 0;
        }

        @KeepForSdk
        SelectionResult a(Context context, String str, IVersions iVersions) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        Preconditions.k(context);
        this.r = context;
    }

    @KeepForSdk
    public static int a(Context context, String str) {
        try {
            Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.a(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e2) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e2.getMessage())));
            return 0;
        }
    }

    @KeepForSdk
    public static int c(Context context, String str) {
        return f(context, str, false);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0209 A[Catch: all -> 0x0212, TRY_ENTER, TryCatch #2 {, blocks: (B:28:0x00a2, B:30:0x00a8, B:31:0x00aa, B:101:0x0209, B:102:0x0211), top: B:148:0x00a2 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x028d A[Catch: all -> 0x02d6, TryCatch #6 {all -> 0x02d6, blocks: (B:3:0x0025, B:7:0x006f, B:12:0x0077, B:15:0x007d, B:26:0x009f, B:107:0x0216, B:108:0x0221, B:110:0x0223, B:112:0x0225, B:113:0x022d, B:131:0x028d, B:132:0x02a4, B:115:0x022f, B:117:0x024d, B:119:0x025e, B:129:0x0284, B:130:0x028c, B:133:0x02a5, B:134:0x02d5), top: B:151:0x0025, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:148:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:149:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:15:0x007d A[Catch: all -> 0x02d6, TRY_LEAVE, TryCatch #6 {all -> 0x02d6, blocks: (B:3:0x0025, B:7:0x006f, B:12:0x0077, B:15:0x007d, B:26:0x009f, B:107:0x0216, B:108:0x0221, B:110:0x0223, B:112:0x0225, B:113:0x022d, B:131:0x028d, B:132:0x02a4, B:115:0x022f, B:117:0x024d, B:119:0x025e, B:129:0x0284, B:130:0x028c, B:133:0x02a5, B:134:0x02d5), top: B:151:0x0025, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0087  */
    /* JADX WARN: Code duplicated, block: B:19:0x008b  */
    /* JADX WARN: Code duplicated, block: B:22:0x0096  */
    /* JADX WARN: Code duplicated, block: B:25:0x009d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x00a8 A[Catch: all -> 0x0212, TryCatch #2 {, blocks: (B:28:0x00a2, B:30:0x00a8, B:31:0x00aa, B:101:0x0209, B:102:0x0211), top: B:148:0x00a2 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00ad A[Catch: all -> 0x0215, LoadingException -> 0x0222, RemoteException -> 0x0224, TRY_ENTER, TryCatch #7 {RemoteException -> 0x0224, LoadingException -> 0x0222, all -> 0x0215, blocks: (B:27:0x00a1, B:33:0x00ad, B:35:0x00b4, B:36:0x00d2, B:40:0x00d8, B:42:0x00e0, B:44:0x00e4, B:45:0x00ef, B:52:0x00fc, B:54:0x0102, B:56:0x0129, B:58:0x0131, B:59:0x0138, B:60:0x0140, B:55:0x0116, B:63:0x0143, B:64:0x0144, B:65:0x014c, B:66:0x014d, B:67:0x0155, B:70:0x0158, B:71:0x0159, B:73:0x017d, B:75:0x0184, B:77:0x018c, B:83:0x01c5, B:85:0x01cb, B:95:0x01ee, B:96:0x01f6, B:78:0x019b, B:79:0x01a3, B:81:0x01a6, B:82:0x01b6, B:97:0x01f7, B:98:0x01ff, B:99:0x0200, B:100:0x0208, B:105:0x0214), top: B:152:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00b4 A[Catch: all -> 0x0215, LoadingException -> 0x0222, RemoteException -> 0x0224, TryCatch #7 {RemoteException -> 0x0224, LoadingException -> 0x0222, all -> 0x0215, blocks: (B:27:0x00a1, B:33:0x00ad, B:35:0x00b4, B:36:0x00d2, B:40:0x00d8, B:42:0x00e0, B:44:0x00e4, B:45:0x00ef, B:52:0x00fc, B:54:0x0102, B:56:0x0129, B:58:0x0131, B:59:0x0138, B:60:0x0140, B:55:0x0116, B:63:0x0143, B:64:0x0144, B:65:0x014c, B:66:0x014d, B:67:0x0155, B:70:0x0158, B:71:0x0159, B:73:0x017d, B:75:0x0184, B:77:0x018c, B:83:0x01c5, B:85:0x01cb, B:95:0x01ee, B:96:0x01f6, B:78:0x019b, B:79:0x01a3, B:81:0x01a6, B:82:0x01b6, B:97:0x01f7, B:98:0x01ff, B:99:0x0200, B:100:0x0208, B:105:0x0214), top: B:152:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00d8 A[Catch: all -> 0x0215, LoadingException -> 0x0222, RemoteException -> 0x0224, TRY_ENTER, TryCatch #7 {RemoteException -> 0x0224, LoadingException -> 0x0222, all -> 0x0215, blocks: (B:27:0x00a1, B:33:0x00ad, B:35:0x00b4, B:36:0x00d2, B:40:0x00d8, B:42:0x00e0, B:44:0x00e4, B:45:0x00ef, B:52:0x00fc, B:54:0x0102, B:56:0x0129, B:58:0x0131, B:59:0x0138, B:60:0x0140, B:55:0x0116, B:63:0x0143, B:64:0x0144, B:65:0x014c, B:66:0x014d, B:67:0x0155, B:70:0x0158, B:71:0x0159, B:73:0x017d, B:75:0x0184, B:77:0x018c, B:83:0x01c5, B:85:0x01cb, B:95:0x01ee, B:96:0x01f6, B:78:0x019b, B:79:0x01a3, B:81:0x01a6, B:82:0x01b6, B:97:0x01f7, B:98:0x01ff, B:99:0x0200, B:100:0x0208, B:105:0x0214), top: B:152:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x014d A[Catch: all -> 0x0215, LoadingException -> 0x0222, RemoteException -> 0x0224, TryCatch #7 {RemoteException -> 0x0224, LoadingException -> 0x0222, all -> 0x0215, blocks: (B:27:0x00a1, B:33:0x00ad, B:35:0x00b4, B:36:0x00d2, B:40:0x00d8, B:42:0x00e0, B:44:0x00e4, B:45:0x00ef, B:52:0x00fc, B:54:0x0102, B:56:0x0129, B:58:0x0131, B:59:0x0138, B:60:0x0140, B:55:0x0116, B:63:0x0143, B:64:0x0144, B:65:0x014c, B:66:0x014d, B:67:0x0155, B:70:0x0158, B:71:0x0159, B:73:0x017d, B:75:0x0184, B:77:0x018c, B:83:0x01c5, B:85:0x01cb, B:95:0x01ee, B:96:0x01f6, B:78:0x019b, B:79:0x01a3, B:81:0x01a6, B:82:0x01b6, B:97:0x01f7, B:98:0x01ff, B:99:0x0200, B:100:0x0208, B:105:0x0214), top: B:152:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0159 A[Catch: all -> 0x0215, LoadingException -> 0x0222, RemoteException -> 0x0224, TryCatch #7 {RemoteException -> 0x0224, LoadingException -> 0x0222, all -> 0x0215, blocks: (B:27:0x00a1, B:33:0x00ad, B:35:0x00b4, B:36:0x00d2, B:40:0x00d8, B:42:0x00e0, B:44:0x00e4, B:45:0x00ef, B:52:0x00fc, B:54:0x0102, B:56:0x0129, B:58:0x0131, B:59:0x0138, B:60:0x0140, B:55:0x0116, B:63:0x0143, B:64:0x0144, B:65:0x014c, B:66:0x014d, B:67:0x0155, B:70:0x0158, B:71:0x0159, B:73:0x017d, B:75:0x0184, B:77:0x018c, B:83:0x01c5, B:85:0x01cb, B:95:0x01ee, B:96:0x01f6, B:78:0x019b, B:79:0x01a3, B:81:0x01a6, B:82:0x01b6, B:97:0x01f7, B:98:0x01ff, B:99:0x0200, B:100:0x0208, B:105:0x0214), top: B:152:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x017d A[Catch: all -> 0x0215, LoadingException -> 0x0222, RemoteException -> 0x0224, TryCatch #7 {RemoteException -> 0x0224, LoadingException -> 0x0222, all -> 0x0215, blocks: (B:27:0x00a1, B:33:0x00ad, B:35:0x00b4, B:36:0x00d2, B:40:0x00d8, B:42:0x00e0, B:44:0x00e4, B:45:0x00ef, B:52:0x00fc, B:54:0x0102, B:56:0x0129, B:58:0x0131, B:59:0x0138, B:60:0x0140, B:55:0x0116, B:63:0x0143, B:64:0x0144, B:65:0x014c, B:66:0x014d, B:67:0x0155, B:70:0x0158, B:71:0x0159, B:73:0x017d, B:75:0x0184, B:77:0x018c, B:83:0x01c5, B:85:0x01cb, B:95:0x01ee, B:96:0x01f6, B:78:0x019b, B:79:0x01a3, B:81:0x01a6, B:82:0x01b6, B:97:0x01f7, B:98:0x01ff, B:99:0x0200, B:100:0x0208, B:105:0x0214), top: B:152:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0184 A[Catch: all -> 0x0215, LoadingException -> 0x0222, RemoteException -> 0x0224, TryCatch #7 {RemoteException -> 0x0224, LoadingException -> 0x0222, all -> 0x0215, blocks: (B:27:0x00a1, B:33:0x00ad, B:35:0x00b4, B:36:0x00d2, B:40:0x00d8, B:42:0x00e0, B:44:0x00e4, B:45:0x00ef, B:52:0x00fc, B:54:0x0102, B:56:0x0129, B:58:0x0131, B:59:0x0138, B:60:0x0140, B:55:0x0116, B:63:0x0143, B:64:0x0144, B:65:0x014c, B:66:0x014d, B:67:0x0155, B:70:0x0158, B:71:0x0159, B:73:0x017d, B:75:0x0184, B:77:0x018c, B:83:0x01c5, B:85:0x01cb, B:95:0x01ee, B:96:0x01f6, B:78:0x019b, B:79:0x01a3, B:81:0x01a6, B:82:0x01b6, B:97:0x01f7, B:98:0x01ff, B:99:0x0200, B:100:0x0208, B:105:0x0214), top: B:152:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x018c A[Catch: all -> 0x0215, LoadingException -> 0x0222, RemoteException -> 0x0224, TryCatch #7 {RemoteException -> 0x0224, LoadingException -> 0x0222, all -> 0x0215, blocks: (B:27:0x00a1, B:33:0x00ad, B:35:0x00b4, B:36:0x00d2, B:40:0x00d8, B:42:0x00e0, B:44:0x00e4, B:45:0x00ef, B:52:0x00fc, B:54:0x0102, B:56:0x0129, B:58:0x0131, B:59:0x0138, B:60:0x0140, B:55:0x0116, B:63:0x0143, B:64:0x0144, B:65:0x014c, B:66:0x014d, B:67:0x0155, B:70:0x0158, B:71:0x0159, B:73:0x017d, B:75:0x0184, B:77:0x018c, B:83:0x01c5, B:85:0x01cb, B:95:0x01ee, B:96:0x01f6, B:78:0x019b, B:79:0x01a3, B:81:0x01a6, B:82:0x01b6, B:97:0x01f7, B:98:0x01ff, B:99:0x0200, B:100:0x0208, B:105:0x0214), top: B:152:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x019b A[Catch: all -> 0x0215, LoadingException -> 0x0222, RemoteException -> 0x0224, TryCatch #7 {RemoteException -> 0x0224, LoadingException -> 0x0222, all -> 0x0215, blocks: (B:27:0x00a1, B:33:0x00ad, B:35:0x00b4, B:36:0x00d2, B:40:0x00d8, B:42:0x00e0, B:44:0x00e4, B:45:0x00ef, B:52:0x00fc, B:54:0x0102, B:56:0x0129, B:58:0x0131, B:59:0x0138, B:60:0x0140, B:55:0x0116, B:63:0x0143, B:64:0x0144, B:65:0x014c, B:66:0x014d, B:67:0x0155, B:70:0x0158, B:71:0x0159, B:73:0x017d, B:75:0x0184, B:77:0x018c, B:83:0x01c5, B:85:0x01cb, B:95:0x01ee, B:96:0x01f6, B:78:0x019b, B:79:0x01a3, B:81:0x01a6, B:82:0x01b6, B:97:0x01f7, B:98:0x01ff, B:99:0x0200, B:100:0x0208, B:105:0x0214), top: B:152:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x01a4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x01a6 A[Catch: all -> 0x0215, LoadingException -> 0x0222, RemoteException -> 0x0224, TryCatch #7 {RemoteException -> 0x0224, LoadingException -> 0x0222, all -> 0x0215, blocks: (B:27:0x00a1, B:33:0x00ad, B:35:0x00b4, B:36:0x00d2, B:40:0x00d8, B:42:0x00e0, B:44:0x00e4, B:45:0x00ef, B:52:0x00fc, B:54:0x0102, B:56:0x0129, B:58:0x0131, B:59:0x0138, B:60:0x0140, B:55:0x0116, B:63:0x0143, B:64:0x0144, B:65:0x014c, B:66:0x014d, B:67:0x0155, B:70:0x0158, B:71:0x0159, B:73:0x017d, B:75:0x0184, B:77:0x018c, B:83:0x01c5, B:85:0x01cb, B:95:0x01ee, B:96:0x01f6, B:78:0x019b, B:79:0x01a3, B:81:0x01a6, B:82:0x01b6, B:97:0x01f7, B:98:0x01ff, B:99:0x0200, B:100:0x0208, B:105:0x0214), top: B:152:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x01b6 A[Catch: all -> 0x0215, LoadingException -> 0x0222, RemoteException -> 0x0224, TryCatch #7 {RemoteException -> 0x0224, LoadingException -> 0x0222, all -> 0x0215, blocks: (B:27:0x00a1, B:33:0x00ad, B:35:0x00b4, B:36:0x00d2, B:40:0x00d8, B:42:0x00e0, B:44:0x00e4, B:45:0x00ef, B:52:0x00fc, B:54:0x0102, B:56:0x0129, B:58:0x0131, B:59:0x0138, B:60:0x0140, B:55:0x0116, B:63:0x0143, B:64:0x0144, B:65:0x014c, B:66:0x014d, B:67:0x0155, B:70:0x0158, B:71:0x0159, B:73:0x017d, B:75:0x0184, B:77:0x018c, B:83:0x01c5, B:85:0x01cb, B:95:0x01ee, B:96:0x01f6, B:78:0x019b, B:79:0x01a3, B:81:0x01a6, B:82:0x01b6, B:97:0x01f7, B:98:0x01ff, B:99:0x0200, B:100:0x0208, B:105:0x0214), top: B:152:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x01cb A[Catch: all -> 0x0215, LoadingException -> 0x0222, RemoteException -> 0x0224, TRY_LEAVE, TryCatch #7 {RemoteException -> 0x0224, LoadingException -> 0x0222, all -> 0x0215, blocks: (B:27:0x00a1, B:33:0x00ad, B:35:0x00b4, B:36:0x00d2, B:40:0x00d8, B:42:0x00e0, B:44:0x00e4, B:45:0x00ef, B:52:0x00fc, B:54:0x0102, B:56:0x0129, B:58:0x0131, B:59:0x0138, B:60:0x0140, B:55:0x0116, B:63:0x0143, B:64:0x0144, B:65:0x014c, B:66:0x014d, B:67:0x0155, B:70:0x0158, B:71:0x0159, B:73:0x017d, B:75:0x0184, B:77:0x018c, B:83:0x01c5, B:85:0x01cb, B:95:0x01ee, B:96:0x01f6, B:78:0x019b, B:79:0x01a3, B:81:0x01a6, B:82:0x01b6, B:97:0x01f7, B:98:0x01ff, B:99:0x0200, B:100:0x0208, B:105:0x0214), top: B:152:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:89:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:92:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:95:0x01ee A[Catch: all -> 0x0215, LoadingException -> 0x0222, RemoteException -> 0x0224, TRY_ENTER, TryCatch #7 {RemoteException -> 0x0224, LoadingException -> 0x0222, all -> 0x0215, blocks: (B:27:0x00a1, B:33:0x00ad, B:35:0x00b4, B:36:0x00d2, B:40:0x00d8, B:42:0x00e0, B:44:0x00e4, B:45:0x00ef, B:52:0x00fc, B:54:0x0102, B:56:0x0129, B:58:0x0131, B:59:0x0138, B:60:0x0140, B:55:0x0116, B:63:0x0143, B:64:0x0144, B:65:0x014c, B:66:0x014d, B:67:0x0155, B:70:0x0158, B:71:0x0159, B:73:0x017d, B:75:0x0184, B:77:0x018c, B:83:0x01c5, B:85:0x01cb, B:95:0x01ee, B:96:0x01f6, B:78:0x019b, B:79:0x01a3, B:81:0x01a6, B:82:0x01b6, B:97:0x01f7, B:98:0x01ff, B:99:0x0200, B:100:0x0208, B:105:0x0214), top: B:152:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x01f7 A[Catch: all -> 0x0215, LoadingException -> 0x0222, RemoteException -> 0x0224, TryCatch #7 {RemoteException -> 0x0224, LoadingException -> 0x0222, all -> 0x0215, blocks: (B:27:0x00a1, B:33:0x00ad, B:35:0x00b4, B:36:0x00d2, B:40:0x00d8, B:42:0x00e0, B:44:0x00e4, B:45:0x00ef, B:52:0x00fc, B:54:0x0102, B:56:0x0129, B:58:0x0131, B:59:0x0138, B:60:0x0140, B:55:0x0116, B:63:0x0143, B:64:0x0144, B:65:0x014c, B:66:0x014d, B:67:0x0155, B:70:0x0158, B:71:0x0159, B:73:0x017d, B:75:0x0184, B:77:0x018c, B:83:0x01c5, B:85:0x01cb, B:95:0x01ee, B:96:0x01f6, B:78:0x019b, B:79:0x01a3, B:81:0x01a6, B:82:0x01b6, B:97:0x01f7, B:98:0x01ff, B:99:0x0200, B:100:0x0208, B:105:0x0214), top: B:152:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0200 A[Catch: all -> 0x0215, LoadingException -> 0x0222, RemoteException -> 0x0224, TryCatch #7 {RemoteException -> 0x0224, LoadingException -> 0x0222, all -> 0x0215, blocks: (B:27:0x00a1, B:33:0x00ad, B:35:0x00b4, B:36:0x00d2, B:40:0x00d8, B:42:0x00e0, B:44:0x00e4, B:45:0x00ef, B:52:0x00fc, B:54:0x0102, B:56:0x0129, B:58:0x0131, B:59:0x0138, B:60:0x0140, B:55:0x0116, B:63:0x0143, B:64:0x0144, B:65:0x014c, B:66:0x014d, B:67:0x0155, B:70:0x0158, B:71:0x0159, B:73:0x017d, B:75:0x0184, B:77:0x018c, B:83:0x01c5, B:85:0x01cb, B:95:0x01ee, B:96:0x01f6, B:78:0x019b, B:79:0x01a3, B:81:0x01a6, B:82:0x01b6, B:97:0x01f7, B:98:0x01ff, B:99:0x0200, B:100:0x0208, B:105:0x0214), top: B:152:0x00a1 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:131:0x028d, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:35:0x00b4, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:71:0x0159, please report this as an issue */
    @KeepForSdk
    public static DynamiteModule e(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        int i2;
        Boolean bool;
        zzq zzqVarL;
        int iE0;
        IObjectWrapper iObjectWrapperY4;
        Object objK0;
        DynamiteModule dynamiteModule;
        l lVar;
        Cursor cursor;
        zzr zzrVar;
        l lVar2;
        Boolean boolValueOf;
        IObjectWrapper iObjectWrapperE0;
        Cursor cursor2;
        ThreadLocal threadLocal = l;
        l lVar3 = (l) threadLocal.get();
        l lVar4 = new l(null);
        threadLocal.set(lVar4);
        ThreadLocal threadLocal2 = m;
        long jLongValue = ((Long) threadLocal2.get()).longValue();
        try {
            threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
            VersionPolicy.SelectionResult selectionResultA = versionPolicy.a(context, str, n);
            Log.i("DynamiteModule", "Considering local module " + str + ":" + selectionResultA.a + " and remote module " + str + ":" + selectionResultA.f12203b);
            int i3 = selectionResultA.f12204c;
            if (i3 != 0) {
                if (i3 != -1) {
                    if (i3 == 1 || selectionResultA.f12203b != 0) {
                        if (i3 == -1) {
                            DynamiteModule dynamiteModuleH = h(context, str);
                            if (jLongValue == 0) {
                                threadLocal2.remove();
                            } else {
                                threadLocal2.set(Long.valueOf(jLongValue));
                            }
                            cursor2 = lVar4.a;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            threadLocal.set(lVar3);
                            return dynamiteModuleH;
                        }
                        if (i3 == 1) {
                            throw new LoadingException("VersionPolicy returned invalid code:" + i3, null);
                        }
                        try {
                            i2 = selectionResultA.f12203b;
                            try {
                                synchronized (DynamiteModule.class) {
                                    if (k(context)) {
                                        throw new LoadingException("Remote loading disabled", null);
                                    }
                                    bool = f12198g;
                                }
                                if (bool != null) {
                                    throw new LoadingException("Failed to determine which loading route to use.", null);
                                }
                                if (bool.booleanValue()) {
                                    Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i2);
                                    synchronized (DynamiteModule.class) {
                                        zzrVar = q;
                                    }
                                    if (zzrVar != null) {
                                        throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
                                    }
                                    lVar2 = (l) threadLocal.get();
                                    if (lVar2 != null || lVar2.a == null) {
                                        throw new LoadingException("No result cursor", null);
                                    }
                                    Context applicationContext = context.getApplicationContext();
                                    Cursor cursor3 = lVar2.a;
                                    ObjectWrapper.E0(null);
                                    synchronized (DynamiteModule.class) {
                                        boolValueOf = Boolean.valueOf(f12201j >= 2);
                                    }
                                    if (boolValueOf.booleanValue()) {
                                        Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                        iObjectWrapperE0 = zzrVar.E3(ObjectWrapper.E0(applicationContext), str, i2, ObjectWrapper.E0(cursor3));
                                    } else {
                                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                        iObjectWrapperE0 = zzrVar.E0(ObjectWrapper.E0(applicationContext), str, i2, ObjectWrapper.E0(cursor3));
                                    }
                                    Context context2 = (Context) ObjectWrapper.k0(iObjectWrapperE0);
                                    if (context2 == null) {
                                        throw new LoadingException("Failed to get module context", null);
                                    }
                                    dynamiteModule = new DynamiteModule(context2);
                                } else {
                                    Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i2);
                                    zzqVarL = l(context);
                                    if (zzqVarL != null) {
                                        throw new LoadingException("Failed to create IDynamiteLoader.", null);
                                    }
                                    iE0 = zzqVarL.E0();
                                    if (iE0 >= 3) {
                                        lVar = (l) threadLocal.get();
                                        if (lVar != null) {
                                            throw new LoadingException("No cached result cursor holder", null);
                                        }
                                        iObjectWrapperY4 = zzqVarL.S4(ObjectWrapper.E0(context), str, i2, ObjectWrapper.E0(lVar.a));
                                    } else if (iE0 == 2) {
                                        Log.w("DynamiteModule", "IDynamite loader version = 2");
                                        iObjectWrapperY4 = zzqVarL.Y4(ObjectWrapper.E0(context), str, i2);
                                    } else {
                                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                        iObjectWrapperY4 = zzqVarL.y4(ObjectWrapper.E0(context), str, i2);
                                    }
                                    objK0 = ObjectWrapper.k0(iObjectWrapperY4);
                                    if (objK0 != null) {
                                        throw new LoadingException("Failed to load remote module.", null);
                                    }
                                    dynamiteModule = new DynamiteModule((Context) objK0);
                                }
                                if (jLongValue == 0) {
                                    threadLocal2.remove();
                                } else {
                                    threadLocal2.set(Long.valueOf(jLongValue));
                                }
                                cursor = lVar4.a;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                threadLocal.set(lVar3);
                                return dynamiteModule;
                            } catch (RemoteException e2) {
                                throw new LoadingException("Failed to load remote module.", e2, null);
                            } catch (LoadingException e3) {
                                throw e3;
                            } catch (Throwable th) {
                                CrashUtils.a(context, th);
                                throw new LoadingException("Failed to load remote module.", th, null);
                            }
                        } catch (LoadingException e4) {
                            Log.w("DynamiteModule", "Failed to load remote module: " + e4.getMessage());
                            int i4 = selectionResultA.a;
                            if (i4 == 0 || versionPolicy.a(context, str, new m(i4, 0)).f12204c != -1) {
                                throw new LoadingException("Remote load failed. No local fallback found.", e4, null);
                            }
                            DynamiteModule dynamiteModuleH2 = h(context, str);
                            if (jLongValue == 0) {
                                m.remove();
                            } else {
                                m.set(Long.valueOf(jLongValue));
                            }
                            Cursor cursor4 = lVar4.a;
                            if (cursor4 != null) {
                                cursor4.close();
                            }
                            l.set(lVar3);
                            return dynamiteModuleH2;
                        }
                    }
                } else if (selectionResultA.a != 0) {
                    i3 = -1;
                    if (i3 == 1) {
                    }
                    if (i3 == -1) {
                        DynamiteModule dynamiteModuleH3 = h(context, str);
                        if (jLongValue == 0) {
                            threadLocal2.remove();
                        } else {
                            threadLocal2.set(Long.valueOf(jLongValue));
                        }
                        cursor2 = lVar4.a;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        threadLocal.set(lVar3);
                        return dynamiteModuleH3;
                    }
                    if (i3 == 1) {
                        throw new LoadingException("VersionPolicy returned invalid code:" + i3, null);
                    }
                    i2 = selectionResultA.f12203b;
                    synchronized (DynamiteModule.class) {
                        if (k(context)) {
                            throw new LoadingException("Remote loading disabled", null);
                        }
                        bool = f12198g;
                        if (bool != null) {
                            throw new LoadingException("Failed to determine which loading route to use.", null);
                        }
                        if (bool.booleanValue()) {
                            Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i2);
                            synchronized (DynamiteModule.class) {
                                zzrVar = q;
                                if (zzrVar != null) {
                                    throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
                                }
                                lVar2 = (l) threadLocal.get();
                                if (lVar2 != null) {
                                }
                                throw new LoadingException("No result cursor", null);
                            }
                        }
                        Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i2);
                        zzqVarL = l(context);
                        if (zzqVarL != null) {
                            throw new LoadingException("Failed to create IDynamiteLoader.", null);
                        }
                        iE0 = zzqVarL.E0();
                        if (iE0 >= 3) {
                            lVar = (l) threadLocal.get();
                            if (lVar != null) {
                                throw new LoadingException("No cached result cursor holder", null);
                            }
                            iObjectWrapperY4 = zzqVarL.S4(ObjectWrapper.E0(context), str, i2, ObjectWrapper.E0(lVar.a));
                        } else if (iE0 == 2) {
                            Log.w("DynamiteModule", "IDynamite loader version = 2");
                            iObjectWrapperY4 = zzqVarL.Y4(ObjectWrapper.E0(context), str, i2);
                        } else {
                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                            iObjectWrapperY4 = zzqVarL.y4(ObjectWrapper.E0(context), str, i2);
                        }
                        objK0 = ObjectWrapper.k0(iObjectWrapperY4);
                        if (objK0 != null) {
                            throw new LoadingException("Failed to load remote module.", null);
                        }
                        dynamiteModule = new DynamiteModule((Context) objK0);
                        if (jLongValue == 0) {
                            threadLocal2.remove();
                        } else {
                            threadLocal2.set(Long.valueOf(jLongValue));
                        }
                        cursor = lVar4.a;
                        if (cursor != null) {
                            cursor.close();
                        }
                        threadLocal.set(lVar3);
                        return dynamiteModule;
                    }
                }
            }
            throw new LoadingException("No acceptable module " + str + " found. Local version is " + selectionResultA.a + " and remote version is " + selectionResultA.f12203b + ".", null);
        } catch (Throwable th2) {
            if (jLongValue == 0) {
                m.remove();
            } else {
                m.set(Long.valueOf(jLongValue));
            }
            Cursor cursor5 = lVar4.a;
            if (cursor5 != null) {
                cursor5.close();
            }
            l.set(lVar3);
            throw th2;
        }
    }

    /* JADX INFO: Removed unreachable split cross block B:136:0x01b6 */
    /* JADX WARN: Code duplicated, block: B:47:0x00a7 A[Catch: all -> 0x00b2, TryCatch #5 {, blocks: (B:9:0x0026, B:11:0x0032, B:48:0x00b0, B:14:0x0038, B:16:0x003f, B:18:0x0045, B:21:0x0048, B:23:0x004c, B:27:0x0056, B:29:0x005e, B:32:0x0065, B:39:0x008f, B:40:0x0097, B:35:0x006c, B:37:0x0072, B:38:0x0081, B:43:0x009a, B:46:0x009d, B:47:0x00a7, B:15:0x003b), top: B:130:0x0026, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0166 A[Catch: all -> 0x01c2, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x01c2, blocks: (B:3:0x0002, B:61:0x00d9, B:63:0x00df, B:68:0x0100, B:90:0x0158, B:94:0x0166, B:115:0x01bb, B:116:0x01be, B:110:0x01b3, B:66:0x00e5, B:119:0x01c1, B:4:0x0003, B:7:0x0009, B:8:0x0025, B:59:0x00d6, B:19:0x0046, B:41:0x0098, B:44:0x009b, B:52:0x00b4, B:60:0x00d8, B:58:0x00ba), top: B:129:0x0002, inners: #9, #12 }] */
    public static int f(Context context, String str, boolean z) {
        Throwable th;
        RemoteException e2;
        Cursor cursor;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = f12198g;
                Cursor cursor2 = null;
                int iE3 = 0;
                if (bool == null) {
                    try {
                        Field declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                        synchronized (declaredField.getDeclaringClass()) {
                            ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                            if (classLoader == ClassLoader.getSystemClassLoader()) {
                                bool = Boolean.FALSE;
                            } else if (classLoader != null) {
                                try {
                                    i(classLoader);
                                } catch (LoadingException unused) {
                                }
                                bool = Boolean.TRUE;
                            } else {
                                if (!k(context)) {
                                    return 0;
                                }
                                if (f12200i) {
                                    declaredField.set(null, ClassLoader.getSystemClassLoader());
                                    bool = Boolean.FALSE;
                                } else {
                                    Boolean bool2 = Boolean.TRUE;
                                    if (bool2.equals(null)) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                    } else {
                                        try {
                                            int iG = g(context, str, z, true);
                                            String str2 = f12199h;
                                            if (str2 != null && !str2.isEmpty()) {
                                                ClassLoader classLoaderA = zzb.a();
                                                if (classLoaderA == null) {
                                                    if (Build.VERSION.SDK_INT >= 29) {
                                                        String str3 = f12199h;
                                                        Preconditions.k(str3);
                                                        classLoaderA = new DelegateLastClassLoader(str3, ClassLoader.getSystemClassLoader());
                                                    } else {
                                                        String str4 = f12199h;
                                                        Preconditions.k(str4);
                                                        classLoaderA = new b(str4, ClassLoader.getSystemClassLoader());
                                                    }
                                                }
                                                i(classLoaderA);
                                                declaredField.set(null, classLoaderA);
                                                f12198g = bool2;
                                                return iG;
                                            }
                                            return iG;
                                        } catch (LoadingException unused2) {
                                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                                            bool = Boolean.FALSE;
                                        }
                                    }
                                }
                            }
                            f12198g = bool;
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e3) {
                        Log.w("DynamiteModule", "Failed to load module via V2: " + e3.toString());
                        bool = Boolean.FALSE;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return g(context, str, z, false);
                    } catch (LoadingException e4) {
                        Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e4.getMessage());
                        return 0;
                    }
                }
                zzq zzqVarL = l(context);
                try {
                    if (zzqVarL != null) {
                        try {
                            int iE0 = zzqVarL.E0();
                            if (iE0 >= 3) {
                                l lVar = (l) l.get();
                                if (lVar == null || (cursor = lVar.a) == null) {
                                    Cursor cursor3 = (Cursor) ObjectWrapper.k0(zzqVarL.p5(ObjectWrapper.E0(context), str, z, ((Long) m.get()).longValue()));
                                    if (cursor3 != null) {
                                        try {
                                            if (cursor3.moveToFirst()) {
                                                int i2 = cursor3.getInt(0);
                                                cursor2 = (i2 <= 0 || !j(cursor3)) ? cursor3 : null;
                                                if (cursor2 != null) {
                                                    cursor2.close();
                                                }
                                                iE3 = i2;
                                            } else {
                                                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                                if (cursor3 != null) {
                                                    cursor3.close();
                                                }
                                            }
                                        } catch (RemoteException e5) {
                                            e2 = e5;
                                            cursor2 = cursor3;
                                            Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e2.getMessage());
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            cursor2 = cursor3;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            throw th;
                                        }
                                    } else {
                                        Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                        if (cursor3 != null) {
                                            cursor3.close();
                                        }
                                    }
                                } else {
                                    iE3 = cursor.getInt(0);
                                }
                            } else if (iE0 == 2) {
                                Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                                iE3 = zzqVarL.V3(ObjectWrapper.E0(context), str, z);
                            } else {
                                Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                                iE3 = zzqVarL.E3(ObjectWrapper.E0(context), str, z);
                            }
                        } catch (RemoteException e6) {
                            e2 = e6;
                        }
                    }
                    return iE3;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Throwable th4) {
            CrashUtils.a(context, th4);
            throw th4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00c9  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    private static int g(Context context, String str, boolean z, boolean z2) throws Throwable {
        Throwable th;
        Exception e2;
        ?? r0 = 0;
        ?? r1 = 0;
        ?? r2 = 0;
        ?? r3 = 0;
        try {
            try {
                boolean z3 = true;
                Cursor cursorQuery = context.getContentResolver().query(new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(true != z ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartTime", String.valueOf(((Long) m.get()).longValue())).build(), null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            boolean z4 = false;
                            int i2 = cursorQuery.getInt(0);
                            if (i2 > 0) {
                                synchronized (DynamiteModule.class) {
                                    f12199h = cursorQuery.getString(2);
                                    int columnIndex = cursorQuery.getColumnIndex("loaderVersion");
                                    if (columnIndex >= 0) {
                                        f12201j = cursorQuery.getInt(columnIndex);
                                    }
                                    int columnIndex2 = cursorQuery.getColumnIndex("disableStandaloneDynamiteLoader2");
                                    if (columnIndex2 >= 0) {
                                        if (cursorQuery.getInt(columnIndex2) == 0) {
                                            z3 = false;
                                        }
                                        f12200i = z3;
                                        z4 = z3;
                                    }
                                }
                                if (j(cursorQuery)) {
                                    cursorQuery = null;
                                }
                            }
                            if (z2 && z4) {
                                throw new LoadingException("forcing fallback to container DynamiteLoader impl", r2 == true ? 1 : 0);
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return i2;
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        if (e2 instanceof LoadingException) {
                            throw e2;
                        }
                        throw new LoadingException("V2 version check failed", e2, r1 == true ? 1 : 0);
                    }
                }
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new LoadingException("Failed to connect to dynamite module ContentResolver.", r3 == true ? 1 : 0);
            } catch (Throwable th2) {
                th = th2;
                r0 = context;
                if (r0 != 0) {
                    r0.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            e2 = e4;
        } catch (Throwable th3) {
            th = th3;
            if (r0 != 0) {
                r0.close();
            }
            throw th;
        }
    }

    private static DynamiteModule h(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static void i(ClassLoader classLoader) throws LoadingException {
        zzr zzrVar;
        zzp zzpVar = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzrVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zzrVar = iInterfaceQueryLocalInterface instanceof zzr ? (zzr) iInterfaceQueryLocalInterface : new zzr(iBinder);
            }
            q = zzrVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to instantiate dynamite loader", e2, zzpVar);
        }
    }

    private static boolean j(Cursor cursor) {
        l lVar = (l) l.get();
        if (lVar == null || lVar.a != null) {
            return false;
        }
        lVar.a = cursor;
        return true;
    }

    private static boolean k(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(f12202k)) {
            return true;
        }
        boolean zBooleanValue = false;
        if (f12202k == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.h().j(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                zBooleanValue = true;
            }
            Boolean boolValueOf = Boolean.valueOf(zBooleanValue);
            f12202k = boolValueOf;
            zBooleanValue = boolValueOf.booleanValue();
            if (zBooleanValue && providerInfoResolveContentProvider != null && (applicationInfo = providerInfoResolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                f12200i = true;
            }
        }
        if (!zBooleanValue) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return zBooleanValue;
    }

    private static zzq l(Context context) {
        zzq zzqVar;
        synchronized (DynamiteModule.class) {
            zzq zzqVar2 = p;
            if (zzqVar2 != null) {
                return zzqVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzqVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzqVar = iInterfaceQueryLocalInterface instanceof zzq ? (zzq) iInterfaceQueryLocalInterface : new zzq(iBinder);
                }
                if (zzqVar != null) {
                    p = zzqVar;
                    return zzqVar;
                }
            } catch (Exception e2) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e2.getMessage());
            }
            return null;
        }
    }

    @KeepForSdk
    public Context b() {
        return this.r;
    }

    @KeepForSdk
    public IBinder d(String str) throws LoadingException {
        try {
            return (IBinder) this.r.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e2, null);
        }
    }
}
