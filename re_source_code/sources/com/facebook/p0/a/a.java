package com.facebook.p0.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import com.facebook.a0;
import com.facebook.internal.c0;
import com.facebook.internal.d0;
import com.facebook.internal.o0;
import com.facebook.internal.p0;
import com.google.zxing.WriterException;
import com.google.zxing.c;
import com.google.zxing.d;
import com.google.zxing.g.b;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.m;
import kotlin.text.u;
import org.json.JSONObject;

/* JADX INFO: compiled from: DeviceRequestsHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final a a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10558b = a.class.getCanonicalName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final HashMap<String, NsdManager.RegistrationListener> f10559c = new HashMap<>();

    /* JADX INFO: renamed from: com.facebook.p0.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DeviceRequestsHelper.kt */
    public static final class C0153a implements NsdManager.RegistrationListener {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f10560b;

        C0153a(String str, String str2) {
            this.a = str;
            this.f10560b = str2;
        }

        @Override // android.net.nsd.NsdManager.RegistrationListener
        public void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i2) {
            m.f(nsdServiceInfo, "serviceInfo");
            a aVar = a.a;
            a.a(this.f10560b);
        }

        @Override // android.net.nsd.NsdManager.RegistrationListener
        public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
            m.f(nsdServiceInfo, "NsdServiceInfo");
            if (m.a(this.a, nsdServiceInfo.getServiceName())) {
                return;
            }
            a aVar = a.a;
            a.a(this.f10560b);
        }

        @Override // android.net.nsd.NsdManager.RegistrationListener
        public void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
            m.f(nsdServiceInfo, "serviceInfo");
        }

        @Override // android.net.nsd.NsdManager.RegistrationListener
        public void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i2) {
            m.f(nsdServiceInfo, "serviceInfo");
        }
    }

    private a() {
    }

    public static final void a(String str) {
        a.b(str);
    }

    @TargetApi(16)
    private final void b(String str) {
        NsdManager.RegistrationListener registrationListener = f10559c.get(str);
        if (registrationListener != null) {
            a0 a0Var = a0.a;
            Object systemService = a0.c().getSystemService("servicediscovery");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.net.nsd.NsdManager");
            }
            try {
                ((NsdManager) systemService).unregisterService(registrationListener);
            } catch (IllegalArgumentException e2) {
                p0 p0Var = p0.a;
                p0.i0(f10558b, e2);
            }
            f10559c.remove(str);
        }
    }

    public static final Bitmap c(String str) {
        EnumMap enumMap = new EnumMap(c.class);
        enumMap.put(c.MARGIN, 2);
        Bitmap bitmapCreateBitmap = null;
        try {
            b bVarA = new d().a(str, com.google.zxing.a.QR_CODE, 200, 200, enumMap);
            int iG = bVarA.g();
            int iH = bVarA.h();
            int[] iArr = new int[iG * iH];
            if (iG > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    int i4 = i2 * iH;
                    if (iH > 0) {
                        int i5 = 0;
                        while (true) {
                            int i6 = i5 + 1;
                            iArr[i4 + i5] = bVarA.f(i5, i2) ? -16777216 : -1;
                            if (i6 >= iH) {
                                break;
                            }
                            i5 = i6;
                        }
                    }
                    if (i3 >= iG) {
                        break;
                    }
                    i2 = i3;
                }
            }
            bitmapCreateBitmap = Bitmap.createBitmap(iH, iG, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, 0, iH, 0, 0, iH, iG);
            return bitmapCreateBitmap;
        } catch (WriterException unused) {
            return bitmapCreateBitmap;
        }
    }

    public static final String d(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        String str = Build.DEVICE;
        m.e(str, "DEVICE");
        map.put("device", str);
        String str2 = Build.MODEL;
        m.e(str2, "MODEL");
        map.put("model", str2);
        String string = new JSONObject(map).toString();
        m.e(string, "JSONObject(deviceInfo as Map<*, *>).toString()");
        return string;
    }

    public static final boolean e() {
        d0 d0Var = d0.a;
        a0 a0Var = a0.a;
        c0 c0VarC = d0.c(a0.d());
        return Build.VERSION.SDK_INT >= 16 && c0VarC != null && c0VarC.l().contains(o0.Enabled);
    }

    public static final boolean f(String str) {
        a aVar = a;
        if (e()) {
            return aVar.g(str);
        }
        return false;
    }

    @TargetApi(16)
    private final boolean g(String str) {
        HashMap<String, NsdManager.RegistrationListener> map = f10559c;
        if (map.containsKey(str)) {
            return true;
        }
        a0 a0Var = a0.a;
        String str2 = "fbsdk_" + m.n("android-", u.z(a0.s(), '.', '|', false, 4, null)) + '_' + ((Object) str);
        NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
        nsdServiceInfo.setServiceType("_fb._tcp.");
        nsdServiceInfo.setServiceName(str2);
        nsdServiceInfo.setPort(80);
        Object systemService = a0.c().getSystemService("servicediscovery");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.net.nsd.NsdManager");
        }
        C0153a c0153a = new C0153a(str2, str);
        map.put(str, c0153a);
        ((NsdManager) systemService).registerService(nsdServiceInfo, 1, c0153a);
        return true;
    }
}
