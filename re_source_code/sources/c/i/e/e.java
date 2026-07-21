package c.i.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: TypefaceCompatApi21Impl.java */
/* JADX INFO: loaded from: classes.dex */
class e extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class<?> f3195b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Constructor<?> f3196c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f3197d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f3198e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f3199f = false;

    e() {
    }

    private static boolean k(Object obj, String str, int i2, boolean z) throws NoSuchMethodException {
        n();
        try {
            return ((Boolean) f3197d.invoke(obj, str, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Typeface l(Object obj) throws NoSuchMethodException {
        n();
        try {
            Object objNewInstance = Array.newInstance(f3195b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f3198e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private File m(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String str = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(str).st_mode)) {
                return new File(str);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static void n() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (f3199f) {
            return;
        }
        f3199f = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi21Impl", e2.getClass().getName(), e2);
            method = null;
            cls = null;
            method2 = null;
        }
        f3196c = constructor;
        f3195b = cls;
        f3197d = method2;
        f3198e = method;
    }

    private static Object o() throws NoSuchMethodException {
        n();
        try {
            return f3196c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // c.i.e.j
    public Typeface b(Context context, androidx.core.content.d.c.b bVar, Resources resources, int i2) throws NoSuchMethodException {
        Object objO = o();
        for (androidx.core.content.d.c.C0022c c0022c : bVar.a()) {
            File fileE = k.e(context);
            if (fileE == null) {
                return null;
            }
            try {
                if (!k.c(fileE, resources, c0022c.b())) {
                    return null;
                }
                if (!k(objO, fileE.getPath(), c0022c.e(), c0022c.f())) {
                    return null;
                }
                fileE.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                fileE.delete();
            }
        }
        return l(objO);
    }

    @Override // c.i.e.j
    public Typeface c(Context context, CancellationSignal cancellationSignal, c.i.h.f.b[] bVarArr, int i2) {
        if (bVarArr.length < 1) {
            return null;
        }
        c.i.h.f.b bVarH = h(bVarArr, i2);
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(bVarH.d(), "r", cancellationSignal);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                }
                return null;
            }
            try {
                File fileM = m(parcelFileDescriptorOpenFileDescriptor);
                if (fileM != null && fileM.canRead()) {
                    Typeface typefaceCreateFromFile = Typeface.createFromFile(fileM);
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceCreateFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    Typeface typefaceD = super.d(context, fileInputStream);
                    fileInputStream.close();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceD;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (Throwable unused2) {
                }
                throw th2;
            }
        } catch (IOException unused3) {
            return null;
        }
    }
}
