package com.bumptech.glide.r;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import com.bumptech.glide.load.n.l;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes.dex */
public final class k {
    private static final char[] a = "0123456789abcdef".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f9556b = new char[64];

    /* JADX INFO: compiled from: Util.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static void a() {
        if (!q()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    public static void b() {
        if (!r()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean c(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj instanceof l ? ((l) obj).a(obj2) : obj.equals(obj2);
    }

    public static boolean d(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static String e(byte[] bArr, char[] cArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            char[] cArr2 = a;
            cArr[i4] = cArr2[i3 >>> 4];
            cArr[i4 + 1] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }

    public static <T> Queue<T> f(int i2) {
        return new ArrayDeque(i2);
    }

    public static int g(int i2, int i3, Bitmap.Config config) {
        return i2 * i3 * i(config);
    }

    @TargetApi(19)
    public static int h(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    return bitmap.getAllocationByteCount();
                } catch (NullPointerException unused) {
                }
            }
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    private static int i(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i2 = a.a[config.ordinal()];
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2 || i2 == 3) {
            return 2;
        }
        return i2 != 4 ? 4 : 8;
    }

    public static <T> List<T> j(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static int k(float f2) {
        return l(f2, 17);
    }

    public static int l(float f2, int i2) {
        return n(Float.floatToIntBits(f2), i2);
    }

    public static int m(int i2) {
        return n(i2, 17);
    }

    public static int n(int i2, int i3) {
        return (i3 * 31) + i2;
    }

    public static int o(Object obj, int i2) {
        return n(obj == null ? 0 : obj.hashCode(), i2);
    }

    public static int p(boolean z, int i2) {
        return n(z ? 1 : 0, i2);
    }

    public static boolean q() {
        return !r();
    }

    public static boolean r() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static boolean s(int i2) {
        return i2 > 0 || i2 == Integer.MIN_VALUE;
    }

    public static boolean t(int i2, int i3) {
        return s(i2) && s(i3);
    }

    public static String u(byte[] bArr) {
        String strE;
        char[] cArr = f9556b;
        synchronized (cArr) {
            strE = e(bArr, cArr);
        }
        return strE;
    }
}
