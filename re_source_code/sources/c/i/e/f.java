package c.i.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: TypefaceCompatApi24Impl.java */
/* JADX INFO: loaded from: classes.dex */
class f extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class<?> f3200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Constructor<?> f3201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Method f3202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Method f3203e;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            cls = null;
            method = null;
            method2 = null;
        }
        f3201c = constructor;
        f3200b = cls;
        f3202d = method2;
        f3203e = method;
    }

    f() {
    }

    private static boolean k(Object obj, ByteBuffer byteBuffer, int i2, int i3, boolean z) {
        try {
            return ((Boolean) f3202d.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface l(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(f3200b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f3203e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean m() {
        Method method = f3202d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object n() {
        try {
            return f3201c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // c.i.e.j
    public Typeface b(Context context, androidx.core.content.d.c.b bVar, Resources resources, int i2) {
        Object objN = n();
        if (objN == null) {
            return null;
        }
        for (androidx.core.content.d.c.C0022c c0022c : bVar.a()) {
            ByteBuffer byteBufferB = k.b(context, resources, c0022c.b());
            if (byteBufferB == null || !k(objN, byteBufferB, c0022c.c(), c0022c.e(), c0022c.f())) {
                return null;
            }
        }
        return l(objN);
    }

    @Override // c.i.e.j
    public Typeface c(Context context, CancellationSignal cancellationSignal, c.i.h.f.b[] bVarArr, int i2) {
        Object objN = n();
        if (objN == null) {
            return null;
        }
        c.e.g gVar = new c.e.g();
        for (c.i.h.f.b bVar : bVarArr) {
            Uri uriD = bVar.d();
            ByteBuffer byteBufferF = (ByteBuffer) gVar.get(uriD);
            if (byteBufferF == null) {
                byteBufferF = k.f(context, cancellationSignal, uriD);
                gVar.put(uriD, byteBufferF);
            }
            if (byteBufferF == null || !k(objN, byteBufferF, bVar.c(), bVar.e(), bVar.f())) {
                return null;
            }
        }
        Typeface typefaceL = l(objN);
        if (typefaceL == null) {
            return null;
        }
        return Typeface.create(typefaceL, i2);
    }
}
