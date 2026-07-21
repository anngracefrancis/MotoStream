package c.s.a;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.Log;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Palette.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    static final c a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<e> f3426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<c.s.a.c> f3427c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SparseBooleanArray f3429e = new SparseBooleanArray();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<c.s.a.c, e> f3428d = new c.e.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e f3430f = a();

    /* JADX INFO: compiled from: Palette.java */
    static class a implements c {
        a() {
        }

        private boolean b(float[] fArr) {
            return fArr[2] <= 0.05f;
        }

        private boolean c(float[] fArr) {
            return fArr[0] >= 10.0f && fArr[0] <= 37.0f && fArr[1] <= 0.82f;
        }

        private boolean d(float[] fArr) {
            return fArr[2] >= 0.95f;
        }

        @Override // c.s.a.b.c
        public boolean a(int i2, float[] fArr) {
            return (d(fArr) || b(fArr) || c(fArr)) ? false : true;
        }
    }

    /* JADX INFO: renamed from: c.s.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Palette.java */
    public static final class C0093b {
        private final List<e> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Bitmap f3431b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<c.s.a.c> f3432c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f3433d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f3434e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f3435f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final List<c> f3436g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Rect f3437h;

        /* JADX INFO: renamed from: c.s.a.b$b$a */
        /* JADX INFO: compiled from: Palette.java */
        class a extends AsyncTask<Bitmap, Void, b> {
            final /* synthetic */ d a;

            a(d dVar) {
                this.a = dVar;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b doInBackground(Bitmap... bitmapArr) {
                try {
                    return C0093b.this.b();
                } catch (Exception e2) {
                    Log.e("Palette", "Exception thrown during async generate", e2);
                    return null;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(b bVar) {
                this.a.a(bVar);
            }
        }

        public C0093b(Bitmap bitmap) {
            ArrayList arrayList = new ArrayList();
            this.f3432c = arrayList;
            this.f3433d = 16;
            this.f3434e = 12544;
            this.f3435f = -1;
            ArrayList arrayList2 = new ArrayList();
            this.f3436g = arrayList2;
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            arrayList2.add(b.a);
            this.f3431b = bitmap;
            this.a = null;
            arrayList.add(c.s.a.c.a);
            arrayList.add(c.s.a.c.f3447b);
            arrayList.add(c.s.a.c.f3448c);
            arrayList.add(c.s.a.c.f3449d);
            arrayList.add(c.s.a.c.f3450e);
            arrayList.add(c.s.a.c.f3451f);
        }

        private int[] c(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            Rect rect = this.f3437h;
            if (rect == null) {
                return iArr;
            }
            int iWidth = rect.width();
            int iHeight = this.f3437h.height();
            int[] iArr2 = new int[iWidth * iHeight];
            for (int i2 = 0; i2 < iHeight; i2++) {
                Rect rect2 = this.f3437h;
                System.arraycopy(iArr, ((rect2.top + i2) * width) + rect2.left, iArr2, i2 * iWidth, iWidth);
            }
            return iArr2;
        }

        private Bitmap e(Bitmap bitmap) {
            int iMax;
            int i2;
            double dSqrt = -1.0d;
            if (this.f3434e > 0) {
                int width = bitmap.getWidth() * bitmap.getHeight();
                int i3 = this.f3434e;
                if (width > i3) {
                    double d2 = i3;
                    double d3 = width;
                    Double.isNaN(d2);
                    Double.isNaN(d3);
                    dSqrt = Math.sqrt(d2 / d3);
                }
            } else if (this.f3435f > 0 && (iMax = Math.max(bitmap.getWidth(), bitmap.getHeight())) > (i2 = this.f3435f)) {
                double d4 = i2;
                double d5 = iMax;
                Double.isNaN(d4);
                Double.isNaN(d5);
                dSqrt = d4 / d5;
            }
            if (dSqrt <= 0.0d) {
                return bitmap;
            }
            double width2 = bitmap.getWidth();
            Double.isNaN(width2);
            int iCeil = (int) Math.ceil(width2 * dSqrt);
            double height = bitmap.getHeight();
            Double.isNaN(height);
            return Bitmap.createScaledBitmap(bitmap, iCeil, (int) Math.ceil(height * dSqrt), false);
        }

        public AsyncTask<Bitmap, Void, b> a(d dVar) {
            if (dVar != null) {
                return new a(dVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f3431b);
            }
            throw new IllegalArgumentException("listener can not be null");
        }

        public b b() {
            List<e> listD;
            c[] cVarArr;
            Bitmap bitmap = this.f3431b;
            if (bitmap != null) {
                Bitmap bitmapE = e(bitmap);
                Rect rect = this.f3437h;
                if (bitmapE != this.f3431b && rect != null) {
                    double width = bitmapE.getWidth();
                    double width2 = this.f3431b.getWidth();
                    Double.isNaN(width);
                    Double.isNaN(width2);
                    double d2 = width / width2;
                    double d3 = rect.left;
                    Double.isNaN(d3);
                    rect.left = (int) Math.floor(d3 * d2);
                    double d4 = rect.top;
                    Double.isNaN(d4);
                    rect.top = (int) Math.floor(d4 * d2);
                    double d5 = rect.right;
                    Double.isNaN(d5);
                    rect.right = Math.min((int) Math.ceil(d5 * d2), bitmapE.getWidth());
                    double d6 = rect.bottom;
                    Double.isNaN(d6);
                    rect.bottom = Math.min((int) Math.ceil(d6 * d2), bitmapE.getHeight());
                }
                int[] iArrC = c(bitmapE);
                int i2 = this.f3433d;
                if (this.f3436g.isEmpty()) {
                    cVarArr = null;
                } else {
                    List<c> list = this.f3436g;
                    cVarArr = (c[]) list.toArray(new c[list.size()]);
                }
                c.s.a.a aVar = new c.s.a.a(iArrC, i2, cVarArr);
                if (bitmapE != this.f3431b) {
                    bitmapE.recycle();
                }
                listD = aVar.d();
            } else {
                listD = this.a;
                if (listD == null) {
                    throw new AssertionError();
                }
            }
            b bVar = new b(listD, this.f3432c);
            bVar.c();
            return bVar;
        }

        public C0093b d(int i2) {
            this.f3433d = i2;
            return this;
        }
    }

    /* JADX INFO: compiled from: Palette.java */
    public interface c {
        boolean a(int i2, float[] fArr);
    }

    /* JADX INFO: compiled from: Palette.java */
    public interface d {
        void a(b bVar);
    }

    /* JADX INFO: compiled from: Palette.java */
    public static final class e {
        private final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f3439b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f3440c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f3441d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f3442e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f3443f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f3444g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f3445h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private float[] f3446i;

        public e(int i2, int i3) {
            this.a = Color.red(i2);
            this.f3439b = Color.green(i2);
            this.f3440c = Color.blue(i2);
            this.f3441d = i2;
            this.f3442e = i3;
        }

        private void a() {
            if (this.f3443f) {
                return;
            }
            int iF = c.i.e.a.f(-1, this.f3441d, 4.5f);
            int iF2 = c.i.e.a.f(-1, this.f3441d, 3.0f);
            if (iF != -1 && iF2 != -1) {
                this.f3445h = c.i.e.a.o(-1, iF);
                this.f3444g = c.i.e.a.o(-1, iF2);
                this.f3443f = true;
                return;
            }
            int iF3 = c.i.e.a.f(-16777216, this.f3441d, 4.5f);
            int iF4 = c.i.e.a.f(-16777216, this.f3441d, 3.0f);
            if (iF3 == -1 || iF4 == -1) {
                this.f3445h = iF != -1 ? c.i.e.a.o(-1, iF) : c.i.e.a.o(-16777216, iF3);
                this.f3444g = iF2 != -1 ? c.i.e.a.o(-1, iF2) : c.i.e.a.o(-16777216, iF4);
                this.f3443f = true;
            } else {
                this.f3445h = c.i.e.a.o(-16777216, iF3);
                this.f3444g = c.i.e.a.o(-16777216, iF4);
                this.f3443f = true;
            }
        }

        public int b() {
            a();
            return this.f3445h;
        }

        public float[] c() {
            if (this.f3446i == null) {
                this.f3446i = new float[3];
            }
            c.i.e.a.b(this.a, this.f3439b, this.f3440c, this.f3446i);
            return this.f3446i;
        }

        public int d() {
            return this.f3442e;
        }

        public int e() {
            return this.f3441d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.f3442e == eVar.f3442e && this.f3441d == eVar.f3441d;
        }

        public int f() {
            a();
            return this.f3444g;
        }

        public int hashCode() {
            return (this.f3441d * 31) + this.f3442e;
        }

        public String toString() {
            return e.class.getSimpleName() + " [RGB: #" + Integer.toHexString(e()) + "] [HSL: " + Arrays.toString(c()) + "] [Population: " + this.f3442e + "] [Title Text: #" + Integer.toHexString(f()) + "] [Body Text: #" + Integer.toHexString(b()) + ']';
        }
    }

    b(List<e> list, List<c.s.a.c> list2) {
        this.f3426b = list;
        this.f3427c = list2;
    }

    private e a() {
        int size = this.f3426b.size();
        int iD = Integer.MIN_VALUE;
        e eVar = null;
        for (int i2 = 0; i2 < size; i2++) {
            e eVar2 = this.f3426b.get(i2);
            if (eVar2.d() > iD) {
                iD = eVar2.d();
                eVar = eVar2;
            }
        }
        return eVar;
    }

    public static C0093b b(Bitmap bitmap) {
        return new C0093b(bitmap);
    }

    private float d(e eVar, c.s.a.c cVar) {
        float[] fArrC = eVar.c();
        e eVar2 = this.f3430f;
        return (cVar.g() > 0.0f ? cVar.g() * (1.0f - Math.abs(fArrC[1] - cVar.i())) : 0.0f) + (cVar.a() > 0.0f ? cVar.a() * (1.0f - Math.abs(fArrC[2] - cVar.h())) : 0.0f) + (cVar.f() > 0.0f ? cVar.f() * (eVar.d() / (eVar2 != null ? eVar2.d() : 1)) : 0.0f);
    }

    private e e(c.s.a.c cVar) {
        e eVarG = g(cVar);
        if (eVarG != null && cVar.j()) {
            this.f3429e.append(eVarG.e(), true);
        }
        return eVarG;
    }

    private e g(c.s.a.c cVar) {
        int size = this.f3426b.size();
        float f2 = 0.0f;
        e eVar = null;
        for (int i2 = 0; i2 < size; i2++) {
            e eVar2 = this.f3426b.get(i2);
            if (h(eVar2, cVar)) {
                float fD = d(eVar2, cVar);
                if (eVar == null || fD > f2) {
                    eVar = eVar2;
                    f2 = fD;
                }
            }
        }
        return eVar;
    }

    private boolean h(e eVar, c.s.a.c cVar) {
        float[] fArrC = eVar.c();
        return fArrC[1] >= cVar.e() && fArrC[1] <= cVar.c() && fArrC[2] >= cVar.d() && fArrC[2] <= cVar.b() && !this.f3429e.get(eVar.e());
    }

    void c() {
        int size = this.f3427c.size();
        for (int i2 = 0; i2 < size; i2++) {
            c.s.a.c cVar = this.f3427c.get(i2);
            cVar.k();
            this.f3428d.put(cVar, e(cVar));
        }
        this.f3429e.clear();
    }

    public int f(int i2) {
        e eVar = this.f3430f;
        return eVar != null ? eVar.e() : i2;
    }
}
