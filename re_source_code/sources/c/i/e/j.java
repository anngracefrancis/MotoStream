package c.i.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: TypefaceCompatBaseImpl.java */
/* JADX INFO: loaded from: classes.dex */
class j {

    @SuppressLint({"BanConcurrentHashMap"})
    private ConcurrentHashMap<Long, androidx.core.content.d.c.b> a = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: TypefaceCompatBaseImpl.java */
    class a implements c<c.i.h.f.b> {
        a() {
        }

        @Override // c.i.e.j.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(c.i.h.f.b bVar) {
            return bVar.e();
        }

        @Override // c.i.e.j.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(c.i.h.f.b bVar) {
            return bVar.f();
        }
    }

    /* JADX INFO: compiled from: TypefaceCompatBaseImpl.java */
    class b implements c<androidx.core.content.d.c.C0022c> {
        b() {
        }

        @Override // c.i.e.j.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(androidx.core.content.d.c.C0022c c0022c) {
            return c0022c.e();
        }

        @Override // c.i.e.j.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(androidx.core.content.d.c.C0022c c0022c) {
            return c0022c.f();
        }
    }

    /* JADX INFO: compiled from: TypefaceCompatBaseImpl.java */
    private interface c<T> {
        int a(T t);

        boolean b(T t);
    }

    j() {
    }

    private void a(Typeface typeface, androidx.core.content.d.c.b bVar) {
        long j2 = j(typeface);
        if (j2 != 0) {
            this.a.put(Long.valueOf(j2), bVar);
        }
    }

    private androidx.core.content.d.c.C0022c f(androidx.core.content.d.c.b bVar, int i2) {
        return (androidx.core.content.d.c.C0022c) g(bVar.a(), i2, new b());
    }

    private static <T> T g(T[] tArr, int i2, c<T> cVar) {
        int i3 = (i2 & 1) == 0 ? 400 : 700;
        boolean z = (i2 & 2) != 0;
        T t = null;
        int i4 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int iAbs = (Math.abs(cVar.a(t2) - i3) * 2) + (cVar.b(t2) == z ? 0 : 1);
            if (t == null || i4 > iAbs) {
                t = t2;
                i4 = iAbs;
            }
        }
        return t;
    }

    private static long j(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0L;
        } catch (NoSuchFieldException e3) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e3);
            return 0L;
        }
    }

    public Typeface b(Context context, androidx.core.content.d.c.b bVar, Resources resources, int i2) {
        androidx.core.content.d.c.C0022c c0022cF = f(bVar, i2);
        if (c0022cF == null) {
            return null;
        }
        Typeface typefaceD = d.d(context, resources, c0022cF.b(), c0022cF.a(), i2);
        a(typefaceD, bVar);
        return typefaceD;
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, c.i.h.f.b[] bVarArr, int i2) throws Throwable {
        InputStream inputStreamOpenInputStream;
        InputStream inputStream = null;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(h(bVarArr, i2).d());
            try {
                Typeface typefaceD = d(context, inputStreamOpenInputStream);
                k.a(inputStreamOpenInputStream);
                return typefaceD;
            } catch (IOException unused) {
                k.a(inputStreamOpenInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream = inputStreamOpenInputStream;
                k.a(inputStream);
                throw th;
            }
        } catch (IOException unused2) {
            inputStreamOpenInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    protected Typeface d(Context context, InputStream inputStream) {
        File fileE = k.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (k.d(fileE, inputStream)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i2, String str, int i3) {
        File fileE = k.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (k.c(fileE, resources, i2)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    protected c.i.h.f.b h(c.i.h.f.b[] bVarArr, int i2) {
        return (c.i.h.f.b) g(bVarArr, i2, new a());
    }

    androidx.core.content.d.c.b i(Typeface typeface) {
        long j2 = j(typeface);
        if (j2 == 0) {
            return null;
        }
        return this.a.get(Long.valueOf(j2));
    }
}
