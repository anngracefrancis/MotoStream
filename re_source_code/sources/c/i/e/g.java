package c.i.e;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: compiled from: TypefaceCompatApi26Impl.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final Class<?> f3204g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final Constructor<?> f3205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final Method f3206i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected final Method f3207j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected final Method f3208k;
    protected final Method l;
    protected final Method m;

    public g() throws NoSuchMethodException {
        Method methodX;
        Constructor<?> constructorZ;
        Method methodV;
        Method methodW;
        Method methodA;
        Method methodU;
        Class<?> cls = null;
        try {
            Class<?> clsY = y();
            constructorZ = z(clsY);
            methodV = v(clsY);
            methodW = w(clsY);
            methodA = A(clsY);
            methodU = u(clsY);
            methodX = x(clsY);
            cls = clsY;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e2.getClass().getName(), e2);
            methodX = null;
            constructorZ = null;
            methodV = null;
            methodW = null;
            methodA = null;
            methodU = null;
        }
        this.f3204g = cls;
        this.f3205h = constructorZ;
        this.f3206i = methodV;
        this.f3207j = methodW;
        this.f3208k = methodA;
        this.l = methodU;
        this.m = methodX;
    }

    private Object o() {
        try {
            return this.f3205h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private void p(Object obj) {
        try {
            this.l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean q(Context context, Object obj, String str, int i2, int i3, int i4, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f3206i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean r(Object obj, ByteBuffer byteBuffer, int i2, int i3, int i4) {
        try {
            return ((Boolean) this.f3207j.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Integer.valueOf(i4))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean s(Object obj) {
        try {
            return ((Boolean) this.f3208k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean t() {
        if (this.f3206i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f3206i != null;
    }

    protected Method A(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    @Override // c.i.e.e, c.i.e.j
    public Typeface b(Context context, androidx.core.content.d.c.b bVar, Resources resources, int i2) {
        if (!t()) {
            return super.b(context, bVar, resources, i2);
        }
        Object objO = o();
        if (objO == null) {
            return null;
        }
        for (androidx.core.content.d.c.C0022c c0022c : bVar.a()) {
            if (!q(context, objO, c0022c.a(), c0022c.c(), c0022c.e(), c0022c.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c0022c.d()))) {
                p(objO);
                return null;
            }
        }
        if (s(objO)) {
            return l(objO);
        }
        return null;
    }

    @Override // c.i.e.e, c.i.e.j
    public Typeface c(Context context, CancellationSignal cancellationSignal, c.i.h.f.b[] bVarArr, int i2) {
        Typeface typefaceL;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!t()) {
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
                    Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(bVarH.e()).setItalic(bVarH.f()).build();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceBuild;
                } catch (Throwable th) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } catch (IOException unused2) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> mapH = k.h(context, bVarArr, cancellationSignal);
        Object objO = o();
        if (objO == null) {
            return null;
        }
        boolean z = false;
        for (c.i.h.f.b bVar : bVarArr) {
            ByteBuffer byteBuffer = mapH.get(bVar.d());
            if (byteBuffer != null) {
                if (!r(objO, byteBuffer, bVar.c(), bVar.e(), bVar.f() ? 1 : 0)) {
                    p(objO);
                    return null;
                }
                z = true;
            }
        }
        if (!z) {
            p(objO);
            return null;
        }
        if (s(objO) && (typefaceL = l(objO)) != null) {
            return Typeface.create(typefaceL, i2);
        }
        return null;
    }

    @Override // c.i.e.j
    public Typeface e(Context context, Resources resources, int i2, String str, int i3) {
        if (!t()) {
            return super.e(context, resources, i2, str, i3);
        }
        Object objO = o();
        if (objO == null) {
            return null;
        }
        if (!q(context, objO, str, 0, -1, -1, null)) {
            p(objO);
            return null;
        }
        if (s(objO)) {
            return l(objO);
        }
        return null;
    }

    protected Typeface l(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(this.f3204g, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.m.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    protected Method u(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    protected Method v(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    protected Method w(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    protected Method x(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    protected Class<?> y() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Constructor<?> z(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }
}
