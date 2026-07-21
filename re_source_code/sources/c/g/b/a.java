package c.g.b;

import java.util.Arrays;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ArrayLinkedVariables.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b.a {
    private static float a = 0.001f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f2979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final c f2980d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2978b = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2981e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private i f2982f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int[] f2983g = new int[8];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int[] f2984h = new int[8];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float[] f2985i = new float[8];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2986j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f2987k = -1;
    private boolean l = false;

    a(b bVar, c cVar) {
        this.f2979c = bVar;
        this.f2980d = cVar;
    }

    @Override // c.g.b.b.a
    public int a() {
        return this.f2978b;
    }

    @Override // c.g.b.b.a
    public i b(int i2) {
        int i3 = this.f2986j;
        for (int i4 = 0; i3 != -1 && i4 < this.f2978b; i4++) {
            if (i4 == i2) {
                return this.f2980d.f2995d[this.f2983g[i3]];
            }
            i3 = this.f2984h[i3];
        }
        return null;
    }

    @Override // c.g.b.b.a
    public void c() {
        int i2 = this.f2986j;
        for (int i3 = 0; i2 != -1 && i3 < this.f2978b; i3++) {
            float[] fArr = this.f2985i;
            fArr[i2] = fArr[i2] * (-1.0f);
            i2 = this.f2984h[i2];
        }
    }

    @Override // c.g.b.b.a
    public final void clear() {
        int i2 = this.f2986j;
        for (int i3 = 0; i2 != -1 && i3 < this.f2978b; i3++) {
            i iVar = this.f2980d.f2995d[this.f2983g[i2]];
            if (iVar != null) {
                iVar.c(this.f2979c);
            }
            i2 = this.f2984h[i2];
        }
        this.f2986j = -1;
        this.f2987k = -1;
        this.l = false;
        this.f2978b = 0;
    }

    @Override // c.g.b.b.a
    public float d(int i2) {
        int i3 = this.f2986j;
        for (int i4 = 0; i3 != -1 && i4 < this.f2978b; i4++) {
            if (i4 == i2) {
                return this.f2985i[i3];
            }
            i3 = this.f2984h[i3];
        }
        return 0.0f;
    }

    @Override // c.g.b.b.a
    public void e(i iVar, float f2, boolean z) {
        float f3 = a;
        if (f2 <= (-f3) || f2 >= f3) {
            int i2 = this.f2986j;
            if (i2 == -1) {
                this.f2986j = 0;
                this.f2985i[0] = f2;
                this.f2983g[0] = iVar.f3019d;
                this.f2984h[0] = -1;
                iVar.n++;
                iVar.a(this.f2979c);
                this.f2978b++;
                if (this.l) {
                    return;
                }
                int i3 = this.f2987k + 1;
                this.f2987k = i3;
                int[] iArr = this.f2983g;
                if (i3 >= iArr.length) {
                    this.l = true;
                    this.f2987k = iArr.length - 1;
                    return;
                }
                return;
            }
            int i4 = -1;
            for (int i5 = 0; i2 != -1 && i5 < this.f2978b; i5++) {
                int[] iArr2 = this.f2983g;
                int i6 = iArr2[i2];
                int i7 = iVar.f3019d;
                if (i6 == i7) {
                    float[] fArr = this.f2985i;
                    float f4 = fArr[i2] + f2;
                    float f5 = a;
                    if (f4 > (-f5) && f4 < f5) {
                        f4 = 0.0f;
                    }
                    fArr[i2] = f4;
                    if (f4 == 0.0f) {
                        if (i2 == this.f2986j) {
                            this.f2986j = this.f2984h[i2];
                        } else {
                            int[] iArr3 = this.f2984h;
                            iArr3[i4] = iArr3[i2];
                        }
                        if (z) {
                            iVar.c(this.f2979c);
                        }
                        if (this.l) {
                            this.f2987k = i2;
                        }
                        iVar.n--;
                        this.f2978b--;
                        return;
                    }
                    return;
                }
                if (iArr2[i2] < i7) {
                    i4 = i2;
                }
                i2 = this.f2984h[i2];
            }
            int length = this.f2987k;
            int i8 = length + 1;
            if (this.l) {
                int[] iArr4 = this.f2983g;
                if (iArr4[length] != -1) {
                    length = iArr4.length;
                }
            } else {
                length = i8;
            }
            int[] iArr5 = this.f2983g;
            if (length >= iArr5.length && this.f2978b < iArr5.length) {
                int i9 = 0;
                while (true) {
                    int[] iArr6 = this.f2983g;
                    if (i9 >= iArr6.length) {
                        break;
                    }
                    if (iArr6[i9] == -1) {
                        length = i9;
                        break;
                    }
                    i9++;
                }
            }
            int[] iArr7 = this.f2983g;
            if (length >= iArr7.length) {
                length = iArr7.length;
                int i10 = this.f2981e * 2;
                this.f2981e = i10;
                this.l = false;
                this.f2987k = length - 1;
                this.f2985i = Arrays.copyOf(this.f2985i, i10);
                this.f2983g = Arrays.copyOf(this.f2983g, this.f2981e);
                this.f2984h = Arrays.copyOf(this.f2984h, this.f2981e);
            }
            this.f2983g[length] = iVar.f3019d;
            this.f2985i[length] = f2;
            if (i4 != -1) {
                int[] iArr8 = this.f2984h;
                iArr8[length] = iArr8[i4];
                iArr8[i4] = length;
            } else {
                this.f2984h[length] = this.f2986j;
                this.f2986j = length;
            }
            iVar.n++;
            iVar.a(this.f2979c);
            this.f2978b++;
            if (!this.l) {
                this.f2987k++;
            }
            int i11 = this.f2987k;
            int[] iArr9 = this.f2983g;
            if (i11 >= iArr9.length) {
                this.l = true;
                this.f2987k = iArr9.length - 1;
            }
        }
    }

    @Override // c.g.b.b.a
    public final float f(i iVar) {
        int i2 = this.f2986j;
        for (int i3 = 0; i2 != -1 && i3 < this.f2978b; i3++) {
            if (this.f2983g[i2] == iVar.f3019d) {
                return this.f2985i[i2];
            }
            i2 = this.f2984h[i2];
        }
        return 0.0f;
    }

    @Override // c.g.b.b.a
    public boolean g(i iVar) {
        int i2 = this.f2986j;
        if (i2 == -1) {
            return false;
        }
        for (int i3 = 0; i2 != -1 && i3 < this.f2978b; i3++) {
            if (this.f2983g[i2] == iVar.f3019d) {
                return true;
            }
            i2 = this.f2984h[i2];
        }
        return false;
    }

    @Override // c.g.b.b.a
    public float h(b bVar, boolean z) {
        float f2 = f(bVar.a);
        j(bVar.a, z);
        b.a aVar = bVar.f2991e;
        int iA = aVar.a();
        for (int i2 = 0; i2 < iA; i2++) {
            i iVarB = aVar.b(i2);
            e(iVarB, aVar.f(iVarB) * f2, z);
        }
        return f2;
    }

    @Override // c.g.b.b.a
    public final void i(i iVar, float f2) {
        if (f2 == 0.0f) {
            j(iVar, true);
            return;
        }
        int i2 = this.f2986j;
        if (i2 == -1) {
            this.f2986j = 0;
            this.f2985i[0] = f2;
            this.f2983g[0] = iVar.f3019d;
            this.f2984h[0] = -1;
            iVar.n++;
            iVar.a(this.f2979c);
            this.f2978b++;
            if (this.l) {
                return;
            }
            int i3 = this.f2987k + 1;
            this.f2987k = i3;
            int[] iArr = this.f2983g;
            if (i3 >= iArr.length) {
                this.l = true;
                this.f2987k = iArr.length - 1;
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; i2 != -1 && i5 < this.f2978b; i5++) {
            int[] iArr2 = this.f2983g;
            int i6 = iArr2[i2];
            int i7 = iVar.f3019d;
            if (i6 == i7) {
                this.f2985i[i2] = f2;
                return;
            }
            if (iArr2[i2] < i7) {
                i4 = i2;
            }
            i2 = this.f2984h[i2];
        }
        int length = this.f2987k;
        int i8 = length + 1;
        if (this.l) {
            int[] iArr3 = this.f2983g;
            if (iArr3[length] != -1) {
                length = iArr3.length;
            }
        } else {
            length = i8;
        }
        int[] iArr4 = this.f2983g;
        if (length >= iArr4.length && this.f2978b < iArr4.length) {
            int i9 = 0;
            while (true) {
                int[] iArr5 = this.f2983g;
                if (i9 >= iArr5.length) {
                    break;
                }
                if (iArr5[i9] == -1) {
                    length = i9;
                    break;
                }
                i9++;
            }
        }
        int[] iArr6 = this.f2983g;
        if (length >= iArr6.length) {
            length = iArr6.length;
            int i10 = this.f2981e * 2;
            this.f2981e = i10;
            this.l = false;
            this.f2987k = length - 1;
            this.f2985i = Arrays.copyOf(this.f2985i, i10);
            this.f2983g = Arrays.copyOf(this.f2983g, this.f2981e);
            this.f2984h = Arrays.copyOf(this.f2984h, this.f2981e);
        }
        this.f2983g[length] = iVar.f3019d;
        this.f2985i[length] = f2;
        if (i4 != -1) {
            int[] iArr7 = this.f2984h;
            iArr7[length] = iArr7[i4];
            iArr7[i4] = length;
        } else {
            this.f2984h[length] = this.f2986j;
            this.f2986j = length;
        }
        iVar.n++;
        iVar.a(this.f2979c);
        int i11 = this.f2978b + 1;
        this.f2978b = i11;
        if (!this.l) {
            this.f2987k++;
        }
        int[] iArr8 = this.f2983g;
        if (i11 >= iArr8.length) {
            this.l = true;
        }
        if (this.f2987k >= iArr8.length) {
            this.l = true;
            this.f2987k = iArr8.length - 1;
        }
    }

    @Override // c.g.b.b.a
    public final float j(i iVar, boolean z) {
        if (this.f2982f == iVar) {
            this.f2982f = null;
        }
        int i2 = this.f2986j;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.f2978b) {
            if (this.f2983g[i2] == iVar.f3019d) {
                if (i2 == this.f2986j) {
                    this.f2986j = this.f2984h[i2];
                } else {
                    int[] iArr = this.f2984h;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    iVar.c(this.f2979c);
                }
                iVar.n--;
                this.f2978b--;
                this.f2983g[i2] = -1;
                if (this.l) {
                    this.f2987k = i2;
                }
                return this.f2985i[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.f2984h[i2];
        }
        return 0.0f;
    }

    @Override // c.g.b.b.a
    public void k(float f2) {
        int i2 = this.f2986j;
        for (int i3 = 0; i2 != -1 && i3 < this.f2978b; i3++) {
            float[] fArr = this.f2985i;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.f2984h[i2];
        }
    }

    public String toString() {
        int i2 = this.f2986j;
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        for (int i3 = 0; i2 != -1 && i3 < this.f2978b; i3++) {
            str = ((str + " -> ") + this.f2985i[i2] + " : ") + this.f2980d.f2995d[this.f2983g[i2]];
            i2 = this.f2984h[i2];
        }
        return str;
    }
}
