package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.facebook.FacebookException;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: AttributionIdentifiers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class q {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9826b = q.class.getCanonicalName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static q f9827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f9828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f9829e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f9830f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f9831g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f9832h;

    /* JADX INFO: compiled from: AttributionIdentifiers.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final q a(q qVar) {
            qVar.f9829e = System.currentTimeMillis();
            q.f9827c = qVar;
            return qVar;
        }

        private final q b(Context context) {
            q qVarC = c(context);
            if (qVarC != null) {
                return qVarC;
            }
            q qVarD = d(context);
            return qVarD == null ? new q() : qVarD;
        }

        private final q c(Context context) {
            Object objR;
            try {
                if (!g(context)) {
                    return null;
                }
                p0 p0Var = p0.a;
                boolean zBooleanValue = false;
                Method methodJ = p0.J("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class);
                if (methodJ == null || (objR = p0.R(null, methodJ, context)) == null) {
                    return null;
                }
                Method methodI = p0.I(objR.getClass(), "getId", new Class[0]);
                Method methodI2 = p0.I(objR.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
                if (methodI != null && methodI2 != null) {
                    q qVar = new q();
                    qVar.f9828d = (String) p0.R(objR, methodI, new Object[0]);
                    Boolean bool = (Boolean) p0.R(objR, methodI2, new Object[0]);
                    if (bool != null) {
                        zBooleanValue = bool.booleanValue();
                    }
                    qVar.f9832h = zBooleanValue;
                    return qVar;
                }
                return null;
            } catch (Exception e2) {
                p0 p0Var2 = p0.a;
                p0.i0("android_id", e2);
                return null;
            }
        }

        private final q d(Context context) {
            if (!g(context)) {
                return null;
            }
            c cVar = new c();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                try {
                    if (context.bindService(intent, cVar, 1)) {
                        b bVar = new b(cVar.a());
                        q qVar = new q();
                        qVar.f9828d = bVar.H();
                        qVar.f9832h = bVar.P();
                        return qVar;
                    }
                } catch (Exception e2) {
                    p0 p0Var = p0.a;
                    p0.i0("android_id", e2);
                } finally {
                    context.unbindService(cVar);
                }
            } catch (SecurityException unused) {
            }
            return null;
        }

        private final String f(Context context) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return packageManager.getInstallerPackageName(context.getPackageName());
        }

        private final boolean g(Context context) {
            p0 p0Var = p0.a;
            Method methodJ = p0.J("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
            if (methodJ == null) {
                return false;
            }
            Object objR = p0.R(null, methodJ, context);
            return (objR instanceof Integer) && kotlin.jvm.internal.m.a(objR, 0);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x006c A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:17:0x006e A[Catch: all -> 0x00fc, Exception -> 0x00fe, TryCatch #4 {Exception -> 0x00fe, all -> 0x00fc, blocks: (B:3:0x0010, B:5:0x001e, B:7:0x0022, B:10:0x0033, B:12:0x0055, B:14:0x0064, B:21:0x0085, B:23:0x008b, B:25:0x0090, B:27:0x0095, B:17:0x006e, B:19:0x007d, B:49:0x00f4, B:50:0x00fb), top: B:71:0x0010 }] */
        /* JADX WARN: Code duplicated, block: B:19:0x007d A[Catch: all -> 0x00fc, Exception -> 0x00fe, TryCatch #4 {Exception -> 0x00fe, all -> 0x00fc, blocks: (B:3:0x0010, B:5:0x001e, B:7:0x0022, B:10:0x0033, B:12:0x0055, B:14:0x0064, B:21:0x0085, B:23:0x008b, B:25:0x0090, B:27:0x0095, B:17:0x006e, B:19:0x007d, B:49:0x00f4, B:50:0x00fb), top: B:71:0x0010 }] */
        /* JADX WARN: Code duplicated, block: B:64:0x011b  */
        public final q e(Context context) {
            Cursor cursor;
            Uri uri;
            String str;
            Uri uri2;
            kotlin.jvm.internal.m.f(context, "context");
            q qVarB = b(context);
            Cursor cursor2 = null;
            try {
                if (kotlin.jvm.internal.m.a(Looper.myLooper(), Looper.getMainLooper())) {
                    throw new FacebookException("getAttributionIdentifiers cannot be called on the main thread.");
                }
                q qVar = q.f9827c;
                if (qVar != null && System.currentTimeMillis() - qVar.f9829e < 3600000) {
                    return qVar;
                }
                String[] strArr = {"aid", "androidid", "limit_tracking"};
                ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.facebook.katana.provider.AttributionIdProvider", 0);
                ProviderInfo providerInfoResolveContentProvider2 = context.getPackageManager().resolveContentProvider("com.facebook.wakizashi.provider.AttributionIdProvider", 0);
                if (providerInfoResolveContentProvider != null) {
                    y yVar = y.a;
                    String str2 = providerInfoResolveContentProvider.packageName;
                    kotlin.jvm.internal.m.e(str2, "contentProviderInfo.packageName");
                    if (y.a(context, str2)) {
                        uri2 = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
                    } else {
                        if (providerInfoResolveContentProvider2 != null) {
                            y yVar2 = y.a;
                            str = providerInfoResolveContentProvider2.packageName;
                            kotlin.jvm.internal.m.e(str, "wakizashiProviderInfo.packageName");
                            if (y.a(context, str)) {
                                uri2 = Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider");
                            }
                        }
                        uri = null;
                    }
                    uri = uri2;
                } else {
                    if (providerInfoResolveContentProvider2 != null) {
                        y yVar3 = y.a;
                        str = providerInfoResolveContentProvider2.packageName;
                        kotlin.jvm.internal.m.e(str, "wakizashiProviderInfo.packageName");
                        if (y.a(context, str)) {
                            uri2 = Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider");
                            uri = uri2;
                        }
                    }
                    uri = null;
                }
                String strF = f(context);
                if (strF != null) {
                    qVarB.f9831g = strF;
                }
                if (uri == null) {
                    return a(qVarB);
                }
                Cursor cursorQuery = context.getContentResolver().query(uri, strArr, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            int columnIndex = cursorQuery.getColumnIndex("aid");
                            int columnIndex2 = cursorQuery.getColumnIndex("androidid");
                            int columnIndex3 = cursorQuery.getColumnIndex("limit_tracking");
                            qVarB.f9830f = cursorQuery.getString(columnIndex);
                            if (columnIndex2 > 0 && columnIndex3 > 0 && qVarB.h() == null) {
                                qVarB.f9828d = cursorQuery.getString(columnIndex2);
                                qVarB.f9832h = Boolean.parseBoolean(cursorQuery.getString(columnIndex3));
                            }
                            cursorQuery.close();
                            return a(qVarB);
                        }
                    } catch (Exception e2) {
                        cursor = cursorQuery;
                        e = e2;
                        try {
                            p0 p0Var = p0.a;
                            p0.j0(q.f9826b, kotlin.jvm.internal.m.n("Caught unexpected exception in getAttributionId(): ", e));
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        cursor2 = cursorQuery;
                        th = th2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
                q qVarA = a(qVarB);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return qVarA;
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
            }
        }

        public final boolean h(Context context) {
            kotlin.jvm.internal.m.f(context, "context");
            q qVarE = e(context);
            return qVarE != null && qVarE.k();
        }
    }

    /* JADX INFO: compiled from: AttributionIdentifiers.kt */
    private static final class b implements IInterface {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f9833f = new a(null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final IBinder f9834g;

        /* JADX INFO: compiled from: AttributionIdentifiers.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
                this();
            }
        }

        public b(IBinder iBinder) {
            kotlin.jvm.internal.m.f(iBinder, "binder");
            this.f9834g = iBinder;
        }

        public final String H() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            kotlin.jvm.internal.m.e(parcelObtain, "obtain()");
            Parcel parcelObtain2 = Parcel.obtain();
            kotlin.jvm.internal.m.e(parcelObtain2, "obtain()");
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f9834g.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        public final boolean P() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            kotlin.jvm.internal.m.e(parcelObtain, "obtain()");
            Parcel parcelObtain2 = Parcel.obtain();
            kotlin.jvm.internal.m.e(parcelObtain2, "obtain()");
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(1);
                this.f9834g.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f9834g;
        }
    }

    /* JADX INFO: compiled from: AttributionIdentifiers.kt */
    private static final class c implements ServiceConnection {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final AtomicBoolean f9835f = new AtomicBoolean(false);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final BlockingQueue<IBinder> f9836g = new LinkedBlockingDeque();

        public final IBinder a() throws InterruptedException {
            if (!(!this.f9835f.compareAndSet(true, true))) {
                throw new IllegalStateException("Binder already consumed".toString());
            }
            IBinder iBinderTake = this.f9836g.take();
            kotlin.jvm.internal.m.e(iBinderTake, "queue.take()");
            return iBinderTake;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                try {
                    this.f9836g.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public final String h() {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        if (com.facebook.a0.w() && com.facebook.a0.b()) {
            return this.f9828d;
        }
        return null;
    }

    public final String i() {
        return this.f9831g;
    }

    public final String j() {
        return this.f9830f;
    }

    public final boolean k() {
        return this.f9832h;
    }
}
