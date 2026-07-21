package c.g.b;

import java.util.Arrays;
import java.util.HashSet;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SolverVariable.java */
/* JADX INFO: loaded from: classes.dex */
public class i {
    private static int a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f3018c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f3022g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    a f3026k;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3019d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f3020e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3021f = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3023h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float[] f3024i = new float[9];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float[] f3025j = new float[9];
    b[] l = new b[16];
    int m = 0;
    public int n = 0;
    boolean o = false;
    int p = -1;
    float q = 0.0f;
    HashSet<b> r = null;

    /* JADX INFO: compiled from: SolverVariable.java */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.f3026k = aVar;
    }

    static void b() {
        a++;
    }

    public final void a(b bVar) {
        int i2 = 0;
        while (true) {
            int i3 = this.m;
            if (i2 >= i3) {
                b[] bVarArr = this.l;
                if (i3 >= bVarArr.length) {
                    this.l = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.l;
                int i4 = this.m;
                bVarArr2[i4] = bVar;
                this.m = i4 + 1;
                return;
            }
            if (this.l[i2] == bVar) {
                return;
            } else {
                i2++;
            }
        }
    }

    public final void c(b bVar) {
        int i2 = this.m;
        int i3 = 0;
        while (i3 < i2) {
            if (this.l[i3] == bVar) {
                while (i3 < i2 - 1) {
                    b[] bVarArr = this.l;
                    int i4 = i3 + 1;
                    bVarArr[i3] = bVarArr[i4];
                    i3 = i4;
                }
                this.m--;
                return;
            }
            i3++;
        }
    }

    public void d() {
        this.f3018c = null;
        this.f3026k = a.UNKNOWN;
        this.f3021f = 0;
        this.f3019d = -1;
        this.f3020e = -1;
        this.f3022g = 0.0f;
        this.f3023h = false;
        this.o = false;
        this.p = -1;
        this.q = 0.0f;
        int i2 = this.m;
        for (int i3 = 0; i3 < i2; i3++) {
            this.l[i3] = null;
        }
        this.m = 0;
        this.n = 0;
        this.f3017b = false;
        Arrays.fill(this.f3025j, 0.0f);
    }

    public void e(d dVar, float f2) {
        this.f3022g = f2;
        this.f3023h = true;
        this.o = false;
        this.p = -1;
        this.q = 0.0f;
        int i2 = this.m;
        this.f3020e = -1;
        for (int i3 = 0; i3 < i2; i3++) {
            this.l[i3].A(dVar, this, false);
        }
        this.m = 0;
    }

    public void f(a aVar, String str) {
        this.f3026k = aVar;
    }

    public final void g(d dVar, b bVar) {
        int i2 = this.m;
        for (int i3 = 0; i3 < i2; i3++) {
            this.l[i3].B(dVar, bVar, false);
        }
        this.m = 0;
    }

    public String toString() {
        if (this.f3018c != null) {
            return HttpUrl.FRAGMENT_ENCODE_SET + this.f3018c;
        }
        return HttpUrl.FRAGMENT_ENCODE_SET + this.f3019d;
    }
}
