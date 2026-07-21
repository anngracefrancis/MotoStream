package c.i.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;

/* JADX INFO: compiled from: TypefaceCompat.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public class d {
    private static final j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c.e.e<String, Typeface> f3194b;

    /* JADX INFO: compiled from: TypefaceCompat.java */
    public static class a extends c.i.h.f.c {
        private androidx.core.content.d.f.c a;

        public a(androidx.core.content.d.f.c cVar) {
            this.a = cVar;
        }

        @Override // c.i.h.f.c
        public void a(int i2) {
            androidx.core.content.d.f.c cVar = this.a;
            if (cVar != null) {
                cVar.d(i2);
            }
        }

        @Override // c.i.h.f.c
        public void b(Typeface typeface) {
            androidx.core.content.d.f.c cVar = this.a;
            if (cVar != null) {
                cVar.e(typeface);
            }
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            a = new i();
        } else if (i2 >= 28) {
            a = new h();
        } else if (i2 >= 26) {
            a = new g();
        } else if (i2 >= 24 && f.m()) {
            a = new f();
        } else if (i2 >= 21) {
            a = new e();
        } else {
            a = new j();
        }
        f3194b = new c.e.e<>(16);
    }

    public static Typeface a(Context context, Typeface typeface, int i2) {
        Typeface typefaceG;
        if (context != null) {
            return (Build.VERSION.SDK_INT >= 21 || (typefaceG = g(context, typeface, i2)) == null) ? Typeface.create(typeface, i2) : typefaceG;
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, c.i.h.f.b[] bVarArr, int i2) {
        return a.c(context, cancellationSignal, bVarArr, i2);
    }

    public static Typeface c(Context context, androidx.core.content.d.c.a aVar, Resources resources, int i2, int i3, androidx.core.content.d.f.c cVar, Handler handler, boolean z) {
        Typeface typefaceB;
        if (aVar instanceof androidx.core.content.d.c.d) {
            androidx.core.content.d.c.d dVar = (androidx.core.content.d.c.d) aVar;
            Typeface typefaceH = h(dVar.c());
            if (typefaceH != null) {
                if (cVar != null) {
                    cVar.b(typefaceH, handler);
                }
                return typefaceH;
            }
            typefaceB = c.i.h.f.a(context, dVar.b(), i3, !z ? cVar != null : dVar.a() != 0, z ? dVar.d() : -1, androidx.core.content.d.f.c.c(handler), new a(cVar));
        } else {
            typefaceB = a.b(context, (androidx.core.content.d.c.b) aVar, resources, i3);
            if (cVar != null) {
                if (typefaceB != null) {
                    cVar.b(typefaceB, handler);
                } else {
                    cVar.a(-3, handler);
                }
            }
        }
        if (typefaceB != null) {
            f3194b.d(e(resources, i2, i3), typefaceB);
        }
        return typefaceB;
    }

    public static Typeface d(Context context, Resources resources, int i2, String str, int i3) {
        Typeface typefaceE = a.e(context, resources, i2, str, i3);
        if (typefaceE != null) {
            f3194b.d(e(resources, i2, i3), typefaceE);
        }
        return typefaceE;
    }

    private static String e(Resources resources, int i2, int i3) {
        return resources.getResourcePackageName(i2) + "-" + i2 + "-" + i3;
    }

    public static Typeface f(Resources resources, int i2, int i3) {
        return f3194b.c(e(resources, i2, i3));
    }

    private static Typeface g(Context context, Typeface typeface, int i2) {
        j jVar = a;
        androidx.core.content.d.c.b bVarI = jVar.i(typeface);
        if (bVarI == null) {
            return null;
        }
        return jVar.b(context, bVarI, context.getResources(), i2);
    }

    private static Typeface h(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface typefaceCreate = Typeface.create(str, 0);
        Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
        if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
            return null;
        }
        return typefaceCreate;
    }
}
