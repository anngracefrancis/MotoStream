package c.g.b.k;

import c.g.b.k.m.n;
import c.g.b.k.m.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ConstraintWidget.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public static float a = 0.5f;
    e A0;
    public int B0;
    public int C0;
    private boolean E;
    public d P;
    public d[] Q;
    protected ArrayList<d> R;
    private boolean[] S;
    public b[] T;
    public e U;
    int V;
    int W;
    public float X;
    protected int Y;
    protected int Z;
    protected int a0;
    int b0;
    int c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c.g.b.k.m.c f3069d;
    protected int d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c.g.b.k.m.c f3070e;
    protected int e0;
    int f0;
    protected int g0;
    protected int h0;
    float i0;
    float j0;
    private Object k0;
    private int l0;
    private int m0;
    private String n0;
    private String o0;
    boolean p0;
    boolean q0;
    boolean r0;
    int s0;
    int t0;
    boolean u0;
    boolean v0;
    public float[] w0;
    protected e[] x0;
    protected e[] y0;
    e z0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3067b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p[] f3068c = new p[2];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c.g.b.k.m.l f3071f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public n f3072g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean[] f3073h = {true, true};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f3074i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f3075j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f3076k = false;
    private boolean l = true;
    private boolean m = false;
    private boolean n = false;
    public int o = -1;
    public int p = -1;
    public int q = 0;
    public int r = 0;
    public int[] s = new int[2];
    public int t = 0;
    public int u = 0;
    public float v = 1.0f;
    public int w = 0;
    public int x = 0;
    public float y = 1.0f;
    int z = -1;
    float A = 1.0f;
    private int[] B = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    private float C = 0.0f;
    private boolean D = false;
    private boolean F = false;
    private int G = 0;
    private int H = 0;
    public d I = new d(this, d.b.LEFT);
    public d J = new d(this, d.b.TOP);
    public d K = new d(this, d.b.RIGHT);
    public d L = new d(this, d.b.BOTTOM);
    public d M = new d(this, d.b.BASELINE);
    d N = new d(this, d.b.CENTER_X);
    d O = new d(this, d.b.CENTER_Y);

    /* JADX INFO: compiled from: ConstraintWidget.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f3077b;

        static {
            int[] iArr = new int[b.values().length];
            f3077b = iArr;
            try {
                iArr[b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3077b[b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3077b[b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3077b[b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[d.b.values().length];
            a = iArr2;
            try {
                iArr2[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[d.b.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[d.b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* JADX INFO: compiled from: ConstraintWidget.java */
    public enum b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public e() {
        d dVar = new d(this, d.b.CENTER);
        this.P = dVar;
        this.Q = new d[]{this.I, this.K, this.J, this.L, this.M, dVar};
        this.R = new ArrayList<>();
        this.S = new boolean[2];
        b bVar = b.FIXED;
        this.T = new b[]{bVar, bVar};
        this.U = null;
        this.V = 0;
        this.W = 0;
        this.X = 0.0f;
        this.Y = -1;
        this.Z = 0;
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = 0;
        float f2 = a;
        this.i0 = f2;
        this.j0 = f2;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = null;
        this.o0 = null;
        this.r0 = false;
        this.s0 = 0;
        this.t0 = 0;
        this.w0 = new float[]{-1.0f, -1.0f};
        this.x0 = new e[]{null, null};
        this.y0 = new e[]{null, null};
        this.z0 = null;
        this.A0 = null;
        this.B0 = -1;
        this.C0 = -1;
        d();
    }

    private boolean Y(int i2) {
        int i3 = i2 * 2;
        d[] dVarArr = this.Q;
        if (dVarArr[i3].f3057f != null && dVarArr[i3].f3057f.f3057f != dVarArr[i3]) {
            int i4 = i3 + 1;
            if (dVarArr[i4].f3057f != null && dVarArr[i4].f3057f.f3057f == dVarArr[i4]) {
                return true;
            }
        }
        return false;
    }

    private void d() {
        this.R.add(this.I);
        this.R.add(this.J);
        this.R.add(this.K);
        this.R.add(this.L);
        this.R.add(this.N);
        this.R.add(this.O);
        this.R.add(this.P);
        this.R.add(this.M);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0175  */
    /* JADX WARN: Code duplicated, block: B:103:0x01af  */
    /* JADX WARN: Code duplicated, block: B:105:0x01bf A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:215:0x0384 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:218:0x038d  */
    /* JADX WARN: Code duplicated, block: B:220:0x0391  */
    /* JADX WARN: Code duplicated, block: B:221:0x0393 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:226:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:228:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:231:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:235:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:236:0x03f1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:243:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:245:0x0415  */
    /* JADX WARN: Code duplicated, block: B:247:0x0419 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:253:0x0427  */
    /* JADX WARN: Code duplicated, block: B:255:0x042d  */
    /* JADX WARN: Code duplicated, block: B:256:0x042f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:277:0x045b  */
    /* JADX WARN: Code duplicated, block: B:279:0x045f  */
    /* JADX WARN: Code duplicated, block: B:281:0x0465 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:285:0x046d A[PHI: r1
      0x046d: PHI (r1v40 int) = (r1v39 int), (r1v44 int), (r1v44 int), (r1v44 int) binds: [B:278:0x045d, B:280:0x0463, B:281:0x0465, B:283:0x0469] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:288:0x047f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0079  */
    /* JADX WARN: Code duplicated, block: B:290:0x0483  */
    /* JADX WARN: Code duplicated, block: B:291:0x0488  */
    /* JADX WARN: Code duplicated, block: B:293:0x048b  */
    /* JADX WARN: Code duplicated, block: B:295:0x0491 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:29:0x007d  */
    /* JADX WARN: Code duplicated, block: B:303:0x04ab  */
    /* JADX WARN: Code duplicated, block: B:31:0x0081  */
    /* JADX WARN: Code duplicated, block: B:325:0x04e0 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:327:0x04ed A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:346:0x0520  */
    /* JADX WARN: Code duplicated, block: B:35:0x008d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:361:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x008f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:38:0x009d  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:51:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:73:0x0104  */
    /* JADX WARN: Code duplicated, block: B:75:0x010f  */
    /* JADX WARN: Code duplicated, block: B:79:0x0116  */
    /* JADX WARN: Code duplicated, block: B:81:0x0119  */
    /* JADX WARN: Code duplicated, block: B:82:0x011f  */
    /* JADX WARN: Code duplicated, block: B:84:0x0126  */
    /* JADX WARN: Code duplicated, block: B:87:0x012b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:88:0x012d  */
    /* JADX WARN: Code duplicated, block: B:89:0x0131 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x0133  */
    /* JADX WARN: Code duplicated, block: B:91:0x013b  */
    /* JADX WARN: Code duplicated, block: B:93:0x0148  */
    /* JADX WARN: Code duplicated, block: B:95:0x014b  */
    private void i(c.g.b.d dVar, boolean z, boolean z2, boolean z3, boolean z4, c.g.b.i iVar, c.g.b.i iVar2, b bVar, boolean z5, d dVar2, d dVar3, int i2, int i3, int i4, int i5, float f2, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i6, int i7, int i8, int i9, float f3, boolean z11) {
        int i10;
        boolean z12;
        int iMin;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z13;
        d.b bVarJ;
        d.b bVar2;
        c.g.b.i iVarQ;
        c.g.b.i iVarQ2;
        boolean z14;
        int i17;
        char c2;
        char c3;
        d dVar4;
        boolean z15;
        boolean z16;
        boolean z17;
        int i18;
        int i19;
        int i20;
        boolean z18;
        c.g.b.i iVar3;
        e eVar;
        boolean z19;
        boolean z20;
        c.g.b.i iVar4;
        int iMin2;
        int i21;
        int iE;
        int i22;
        int iE2;
        e eVar2;
        int i23;
        int i24;
        int i25;
        int i26;
        boolean z21;
        boolean z22;
        int i27;
        e eVar3;
        e eVar4;
        c.g.b.i iVarQ3 = dVar.q(dVar2);
        c.g.b.i iVarQ4 = dVar.q(dVar3);
        c.g.b.i iVarQ5 = dVar.q(dVar2.i());
        c.g.b.i iVarQ6 = dVar.q(dVar3.i());
        if (c.g.b.d.w() != null) {
            c.g.b.d.w();
            throw null;
        }
        boolean zN = dVar2.n();
        boolean zN2 = dVar3.n();
        boolean zN3 = this.P.n();
        int i28 = zN2 ? (zN ? 1 : 0) + 1 : zN ? 1 : 0;
        if (zN3) {
            i28++;
        }
        int i29 = z6 ? 3 : i6;
        int i30 = a.f3077b[bVar.ordinal()];
        if (i30 != 1 && i30 != 2 && i30 != 3 && i30 == 4) {
            i10 = i29;
            z12 = i10 != 4;
            if (this.m0 == 8) {
                iMin = 0;
                z12 = false;
            } else {
                iMin = i3;
            }
            if (z11) {
                if (zN && !zN2 && !zN3) {
                    dVar.f(iVarQ3, i2);
                } else if (zN && !zN2) {
                    i11 = 8;
                    dVar.e(iVarQ3, iVarQ5, dVar2.e(), 8);
                }
                i11 = 8;
            } else {
                i11 = 8;
            }
            if (!z12) {
                if (i28 == 2 && !z6 && (i10 == 1 || i10 == 0)) {
                    int iMax = Math.max(i8, iMin);
                    if (i9 > 0) {
                        iMax = Math.min(i9, iMax);
                    }
                    dVar.e(iVarQ4, iVarQ3, iMax, 8);
                    i16 = i8;
                    i13 = i9;
                    iVarQ5 = iVarQ5;
                    iVarQ4 = iVarQ4;
                    z13 = false;
                    i15 = i28;
                } else {
                    if (i8 == -2) {
                        i12 = iMin;
                    } else {
                        i12 = i8;
                    }
                    if (i9 == -2) {
                        i13 = iMin;
                    } else {
                        i13 = i9;
                    }
                    if (iMin > 0 && i10 != 1) {
                        iMin = 0;
                    }
                    if (i12 > 0) {
                        dVar.h(iVarQ4, iVarQ3, i12, 8);
                        iMin = Math.max(iMin, i12);
                    }
                    if (i13 > 0) {
                        if (z2 || i10 != 1) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (z14) {
                            i14 = 8;
                            dVar.j(iVarQ4, iVarQ3, i13, 8);
                        } else {
                            i14 = 8;
                        }
                        iMin = Math.min(iMin, i13);
                    } else {
                        i14 = 8;
                    }
                    if (i10 == 1) {
                        if (z2) {
                            dVar.e(iVarQ4, iVarQ3, iMin, i14);
                        } else if (z8) {
                            dVar.e(iVarQ4, iVarQ3, iMin, 5);
                            dVar.j(iVarQ4, iVarQ3, iMin, i14);
                        } else {
                            dVar.e(iVarQ4, iVarQ3, iMin, 5);
                            dVar.j(iVarQ4, iVarQ3, iMin, i14);
                        }
                        i16 = i12;
                    } else if (i10 == 2) {
                        bVarJ = dVar2.j();
                        bVar2 = d.b.TOP;
                        if (bVarJ != bVar2 || dVar2.j() == d.b.BOTTOM) {
                            iVarQ = dVar.q(this.U.m(bVar2));
                            iVarQ2 = dVar.q(this.U.m(d.b.BOTTOM));
                        } else {
                            iVarQ = dVar.q(this.U.m(d.b.LEFT));
                            iVarQ2 = dVar.q(this.U.m(d.b.RIGHT));
                        }
                        c.g.b.i iVar5 = iVarQ;
                        c.g.b.b bVarR = dVar.r();
                        int i31 = i12;
                        iVarQ6 = iVarQ6;
                        iVarQ5 = iVarQ5;
                        i15 = i28 == true ? 1 : 0;
                        iVarQ4 = iVarQ4;
                        dVar.d(bVarR.k(iVarQ4, iVarQ3, iVarQ2, iVar5, f3));
                        z4 = z4;
                        i16 = i31;
                        z13 = false;
                    } else {
                        iVarQ5 = iVarQ5;
                        iVarQ4 = iVarQ4;
                        int i32 = i12;
                        iVarQ6 = iVarQ6;
                        i15 = i28;
                        i16 = i32;
                        z13 = z12;
                        z4 = true;
                    }
                }
                if (z11 || z8) {
                    i17 = 0;
                    c2 = 2;
                    c3 = 1;
                    if (i15 >= c2 && z2 && z4) {
                        dVar.h(iVarQ3, iVar, i17, 8);
                        char c4 = (z || this.M.f3057f == null) ? (char) 1 : (char) 0;
                        if (z || (dVar4 = this.M.f3057f) == null) {
                            c3 = c4;
                        } else {
                            e eVar5 = dVar4.f3055d;
                            if (eVar5.X != 0.0f) {
                                b[] bVarArr = eVar5.T;
                                b bVar3 = bVarArr[i17];
                                b bVar4 = b.MATCH_CONSTRAINT;
                                if (bVar3 != bVar4 || bVarArr[c3] != bVar4) {
                                    c3 = 0;
                                }
                            } else {
                                c3 = 0;
                            }
                        }
                        if (c3 != 0) {
                            dVar.h(iVar2, iVarQ4, i17, 8);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if ((zN || zN2 || zN3) && (!zN || zN2)) {
                    if (!zN && zN2) {
                        dVar.e(iVarQ4, iVarQ6, -dVar3.e(), 8);
                        if (z2) {
                            if (this.f3076k && iVarQ3.f3023h && (eVar3 = this.U) != null) {
                                f fVar = (f) eVar3;
                                if (z) {
                                    fVar.i1(dVar2);
                                } else {
                                    fVar.n1(dVar2);
                                }
                            } else {
                                dVar.h(iVarQ3, iVar, 0, 5);
                            }
                        }
                    } else if (zN && zN2) {
                        e eVar6 = dVar2.f3057f.f3055d;
                        e eVar7 = dVar3.f3057f.f3055d;
                        e eVarI = I();
                        int i33 = 6;
                        if (z13) {
                            if (i10 == 0) {
                                if (i13 != 0 || i16 != 0) {
                                    z21 = true;
                                    z22 = false;
                                    z17 = true;
                                    i20 = 5;
                                    i27 = 5;
                                } else if (iVarQ5.f3023h && iVarQ6.f3023h) {
                                    dVar.e(iVarQ3, iVarQ5, dVar2.e(), 8);
                                    dVar.e(iVarQ4, iVarQ6, -dVar3.e(), 8);
                                    return;
                                } else {
                                    z21 = false;
                                    z22 = true;
                                    z17 = false;
                                    i20 = 8;
                                    i27 = 8;
                                }
                                if ((eVar6 instanceof c.g.b.k.a) || (eVar7 instanceof c.g.b.k.a)) {
                                    i18 = 6;
                                    i19 = 4;
                                } else {
                                    i19 = i27;
                                    i18 = 6;
                                }
                                z15 = z21;
                                z16 = z22;
                            } else {
                                if (i10 == 1) {
                                    iVar2 = iVar2;
                                    z15 = true;
                                    z16 = false;
                                    z17 = true;
                                    i18 = 6;
                                    i19 = 4;
                                } else {
                                    if (i10 != 3) {
                                        iVar2 = iVar2;
                                        z15 = false;
                                        z16 = false;
                                        z17 = false;
                                        i18 = 6;
                                        i19 = 4;
                                        i20 = 5;
                                    } else if (this.z == -1) {
                                        if (z9) {
                                            iVar2 = iVar2;
                                            z15 = true;
                                            z16 = true;
                                            z17 = true;
                                            i18 = z2 ? 5 : 4;
                                        } else {
                                            iVar2 = iVar2;
                                            z15 = true;
                                            z16 = true;
                                            z17 = true;
                                            i18 = 8;
                                        }
                                        i19 = 5;
                                    } else if (z6) {
                                        if (i7 == 2 || i7 == 1) {
                                            i25 = 5;
                                            i26 = 4;
                                        } else {
                                            i25 = 8;
                                            i26 = 5;
                                        }
                                        i20 = i25;
                                        i19 = i26;
                                        z15 = true;
                                        z16 = true;
                                        z17 = true;
                                        i18 = 6;
                                    } else {
                                        if (i13 > 0) {
                                            iVar2 = iVar2;
                                            z15 = true;
                                            z16 = true;
                                            z17 = true;
                                            i18 = 6;
                                            i19 = 5;
                                        } else if (i13 != 0 || i16 != 0) {
                                            z15 = true;
                                            z16 = true;
                                        } else if (z9) {
                                            iVar2 = iVar2;
                                            i20 = (eVar6 == eVarI || eVar7 == eVarI) ? 5 : 4;
                                            z15 = true;
                                            z16 = true;
                                            z17 = true;
                                            i18 = 6;
                                            i19 = 4;
                                        } else {
                                            iVar2 = iVar2;
                                            z15 = true;
                                            z16 = true;
                                            z17 = true;
                                            i18 = 6;
                                            i19 = 8;
                                        }
                                        i20 = 5;
                                    }
                                    if (z17 || iVarQ5 != iVarQ6 || eVar6 == eVarI) {
                                        z18 = true;
                                    } else {
                                        z17 = false;
                                        z18 = false;
                                    }
                                    if (z15) {
                                        if (z13 && !z7 && !z9 && iVarQ5 == iVar && iVarQ6 == iVar2) {
                                            z19 = false;
                                            i18 = 8;
                                            i20 = 8;
                                            z18 = false;
                                        } else {
                                            z19 = z2;
                                        }
                                        c.g.b.i iVar6 = iVarQ4;
                                        iVar3 = iVar6;
                                        eVar = eVarI;
                                        dVar.c(iVarQ3, iVarQ5, dVar2.e(), f2, iVarQ6, iVar6, dVar3.e(), i18);
                                    } else {
                                        iVar3 = iVarQ4;
                                        eVar = eVarI;
                                        z19 = z2;
                                    }
                                    z20 = z18;
                                    if (this.m0 != 8 && !dVar3.l()) {
                                        return;
                                    }
                                    if (z17) {
                                        if (z19 || iVarQ5 == iVarQ6 || z13 || !((eVar6 instanceof c.g.b.k.a) || (eVar7 instanceof c.g.b.k.a))) {
                                            i24 = i20;
                                        } else {
                                            i24 = 6;
                                        }
                                        dVar.h(iVarQ3, iVarQ5, dVar2.e(), i24);
                                        iVar4 = iVar3;
                                        dVar.j(iVar4, iVarQ6, -dVar3.e(), i24);
                                        i20 = i24;
                                    } else {
                                        iVar4 = iVar3;
                                    }
                                    if (z19 || !z10 || (eVar6 instanceof c.g.b.k.a) || (eVar7 instanceof c.g.b.k.a)) {
                                        iMin2 = i19;
                                        i21 = i20;
                                    } else {
                                        iMin2 = 6;
                                        z20 = true;
                                        i21 = 6;
                                    }
                                    if (z20) {
                                        if (z16 || (z9 && !z3)) {
                                            eVar2 = eVar;
                                        } else {
                                            eVar2 = eVar;
                                            if (eVar6 != eVar2 && eVar7 != eVar2) {
                                                i33 = iMin2;
                                            }
                                            if ((eVar6 instanceof g) || (eVar7 instanceof g)) {
                                                i33 = 5;
                                            }
                                            if ((eVar6 instanceof c.g.b.k.a) || (eVar7 instanceof c.g.b.k.a)) {
                                                i33 = 5;
                                            }
                                            iMin2 = Math.max(z9 ? 5 : i33, iMin2);
                                        }
                                        if (z19) {
                                            iMin2 = Math.min(i21, iMin2);
                                            if (z6 || z9 || !(eVar6 == eVar2 || eVar7 == eVar2)) {
                                                i23 = iMin2;
                                            } else {
                                                i23 = 4;
                                            }
                                        } else {
                                            i23 = iMin2;
                                        }
                                        dVar.e(iVarQ3, iVarQ5, dVar2.e(), i23);
                                        dVar.e(iVar4, iVarQ6, -dVar3.e(), i23);
                                    }
                                    if (z19) {
                                        if (iVar == iVarQ5) {
                                            iE2 = dVar2.e();
                                        } else {
                                            iE2 = 0;
                                        }
                                        if (iVarQ5 != iVar) {
                                            dVar.h(iVarQ3, iVar, iE2, 5);
                                        }
                                    }
                                    if (z19 || !z13 || i4 != 0 || i16 != 0) {
                                        iE = 0;
                                    } else if (z13 && i22 == 3) {
                                        iE = 0;
                                        dVar.h(iVar4, iVarQ3, 0, 8);
                                    } else {
                                        i22 = i10;
                                        iE = 0;
                                        dVar.h(iVar4, iVarQ3, 0, 5);
                                    }
                                }
                                i20 = 8;
                                if (z17) {
                                    z18 = true;
                                } else {
                                    z18 = true;
                                }
                                if (z15) {
                                    if (z13) {
                                        z19 = z2;
                                    } else {
                                        z19 = z2;
                                    }
                                    c.g.b.i iVar7 = iVarQ4;
                                    iVar3 = iVar7;
                                    eVar = eVarI;
                                    dVar.c(iVarQ3, iVarQ5, dVar2.e(), f2, iVarQ6, iVar7, dVar3.e(), i18);
                                } else {
                                    iVar3 = iVarQ4;
                                    eVar = eVarI;
                                    z19 = z2;
                                }
                                z20 = z18;
                                if (this.m0 != 8) {
                                }
                                if (z17) {
                                    if (z19) {
                                        i24 = i20;
                                    } else {
                                        i24 = i20;
                                    }
                                    dVar.h(iVarQ3, iVarQ5, dVar2.e(), i24);
                                    iVar4 = iVar3;
                                    dVar.j(iVar4, iVarQ6, -dVar3.e(), i24);
                                    i20 = i24;
                                } else {
                                    iVar4 = iVar3;
                                }
                                if (z19) {
                                    iMin2 = i19;
                                    i21 = i20;
                                } else {
                                    iMin2 = i19;
                                    i21 = i20;
                                }
                                if (z20) {
                                    if (z16) {
                                        eVar2 = eVar;
                                    } else {
                                        eVar2 = eVar;
                                    }
                                    if (z19) {
                                        iMin2 = Math.min(i21, iMin2);
                                        if (z6) {
                                            i23 = iMin2;
                                        } else {
                                            i23 = iMin2;
                                        }
                                    } else {
                                        i23 = iMin2;
                                    }
                                    dVar.e(iVarQ3, iVarQ5, dVar2.e(), i23);
                                    dVar.e(iVar4, iVarQ6, -dVar3.e(), i23);
                                }
                                if (z19) {
                                    if (iVar == iVarQ5) {
                                        iE2 = dVar2.e();
                                    } else {
                                        iE2 = 0;
                                    }
                                    if (iVarQ5 != iVar) {
                                        dVar.h(iVarQ3, iVar, iE2, 5);
                                    }
                                }
                                if (z19) {
                                    iE = 0;
                                } else {
                                    iE = 0;
                                }
                            }
                            iVar2 = iVar2;
                            if (z17) {
                                z18 = true;
                            } else {
                                z18 = true;
                            }
                            if (z15) {
                                if (z13) {
                                    z19 = z2;
                                } else {
                                    z19 = z2;
                                }
                                c.g.b.i iVar8 = iVarQ4;
                                iVar3 = iVar8;
                                eVar = eVarI;
                                dVar.c(iVarQ3, iVarQ5, dVar2.e(), f2, iVarQ6, iVar8, dVar3.e(), i18);
                            } else {
                                iVar3 = iVarQ4;
                                eVar = eVarI;
                                z19 = z2;
                            }
                            z20 = z18;
                            if (this.m0 != 8) {
                            }
                            if (z17) {
                                if (z19) {
                                    i24 = i20;
                                } else {
                                    i24 = i20;
                                }
                                dVar.h(iVarQ3, iVarQ5, dVar2.e(), i24);
                                iVar4 = iVar3;
                                dVar.j(iVar4, iVarQ6, -dVar3.e(), i24);
                                i20 = i24;
                            } else {
                                iVar4 = iVar3;
                            }
                            if (z19) {
                                iMin2 = i19;
                                i21 = i20;
                            } else {
                                iMin2 = i19;
                                i21 = i20;
                            }
                            if (z20) {
                                if (z16) {
                                    eVar2 = eVar;
                                } else {
                                    eVar2 = eVar;
                                }
                                if (z19) {
                                    iMin2 = Math.min(i21, iMin2);
                                    if (z6) {
                                        i23 = iMin2;
                                    } else {
                                        i23 = iMin2;
                                    }
                                } else {
                                    i23 = iMin2;
                                }
                                dVar.e(iVarQ3, iVarQ5, dVar2.e(), i23);
                                dVar.e(iVar4, iVarQ6, -dVar3.e(), i23);
                            }
                            if (z19) {
                                if (iVar == iVarQ5) {
                                    iE2 = dVar2.e();
                                } else {
                                    iE2 = 0;
                                }
                                if (iVarQ5 != iVar) {
                                    dVar.h(iVarQ3, iVar, iE2, 5);
                                }
                            }
                            if (z19) {
                                iE = 0;
                            } else {
                                iE = 0;
                            }
                        } else {
                            if (iVarQ5.f3023h && iVarQ6.f3023h) {
                                dVar.c(iVarQ3, iVarQ5, dVar2.e(), f2, iVarQ6, iVarQ4, dVar3.e(), 8);
                                if (z2 && z4) {
                                    int iE3 = dVar3.f3057f != null ? dVar3.e() : 0;
                                    if (iVarQ6 != iVar2) {
                                        dVar.h(iVar2, iVarQ4, iE3, 5);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            z15 = true;
                            z16 = false;
                        }
                        z17 = true;
                        i18 = 6;
                        i19 = 4;
                        i20 = 5;
                        if (z17) {
                            z18 = true;
                        } else {
                            z18 = true;
                        }
                        if (z15) {
                            if (z13) {
                                z19 = z2;
                            } else {
                                z19 = z2;
                            }
                            c.g.b.i iVar9 = iVarQ4;
                            iVar3 = iVar9;
                            eVar = eVarI;
                            dVar.c(iVarQ3, iVarQ5, dVar2.e(), f2, iVarQ6, iVar9, dVar3.e(), i18);
                        } else {
                            iVar3 = iVarQ4;
                            eVar = eVarI;
                            z19 = z2;
                        }
                        z20 = z18;
                        if (this.m0 != 8) {
                        }
                        if (z17) {
                            if (z19) {
                                i24 = i20;
                            } else {
                                i24 = i20;
                            }
                            dVar.h(iVarQ3, iVarQ5, dVar2.e(), i24);
                            iVar4 = iVar3;
                            dVar.j(iVar4, iVarQ6, -dVar3.e(), i24);
                            i20 = i24;
                        } else {
                            iVar4 = iVar3;
                        }
                        if (z19) {
                            iMin2 = i19;
                            i21 = i20;
                        } else {
                            iMin2 = i19;
                            i21 = i20;
                        }
                        if (z20) {
                            if (z16) {
                                eVar2 = eVar;
                            } else {
                                eVar2 = eVar;
                            }
                            if (z19) {
                                iMin2 = Math.min(i21, iMin2);
                                if (z6) {
                                    i23 = iMin2;
                                } else {
                                    i23 = iMin2;
                                }
                            } else {
                                i23 = iMin2;
                            }
                            dVar.e(iVarQ3, iVarQ5, dVar2.e(), i23);
                            dVar.e(iVar4, iVarQ6, -dVar3.e(), i23);
                        }
                        if (z19) {
                            if (iVar == iVarQ5) {
                                iE2 = dVar2.e();
                            } else {
                                iE2 = 0;
                            }
                            if (iVarQ5 != iVar) {
                                dVar.h(iVarQ3, iVar, iE2, 5);
                            }
                        }
                        if (z19) {
                            iE = 0;
                        } else {
                            iE = 0;
                        }
                    }
                    iVar4 = iVarQ4;
                    iE = 0;
                    z19 = z2;
                } else {
                    iVar4 = iVarQ4;
                    iE = 0;
                    z19 = z2;
                }
                if (!z19) {
                    i22 = i10;
                    return;
                }
                if (z4) {
                    if (dVar3.f3057f != null) {
                        iE = dVar3.e();
                    }
                    if (iVarQ6 != iVar2) {
                        if (!this.f3076k || !iVar4.f3023h || (eVar4 = this.U) == null) {
                            dVar.h(iVar2, iVar4, iE, 5);
                            return;
                        }
                        f fVar2 = (f) eVar4;
                        if (z) {
                            fVar2.h1(dVar3);
                            return;
                        } else {
                            fVar2.m1(dVar3);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (z5) {
                dVar.e(iVarQ4, iVarQ3, 0, 3);
                if (i4 > 0) {
                    dVar.h(iVarQ4, iVarQ3, i4, 8);
                }
                if (i5 < Integer.MAX_VALUE) {
                    dVar.j(iVarQ4, iVarQ3, i5, 8);
                }
            } else {
                dVar.e(iVarQ4, iVarQ3, iMin, i11);
            }
            i16 = i8;
            i13 = i9;
            z13 = z12;
            i15 = i28;
            if (z11) {
                i17 = 0;
                c2 = 2;
                c3 = 1;
            } else {
                i17 = 0;
                c2 = 2;
                c3 = 1;
            }
            if (i15 >= c2) {
            }
        }
        i10 = i29;
        if (this.m0 == 8) {
            iMin = 0;
            z12 = false;
        } else {
            iMin = i3;
        }
        if (z11) {
            i11 = 8;
        } else if (zN) {
            if (zN) {
                i11 = 8;
            } else {
                i11 = 8;
            }
        } else if (zN) {
            i11 = 8;
        } else {
            i11 = 8;
        }
        if (!z12) {
            if (i28 == 2) {
            }
            if (i8 == -2) {
                i12 = iMin;
            } else {
                i12 = i8;
            }
            if (i9 == -2) {
                i13 = iMin;
            } else {
                i13 = i9;
            }
            if (iMin > 0) {
                iMin = 0;
            }
            if (i12 > 0) {
                dVar.h(iVarQ4, iVarQ3, i12, 8);
                iMin = Math.max(iMin, i12);
            }
            if (i13 > 0) {
                if (z2) {
                    z14 = true;
                } else {
                    z14 = true;
                }
                if (z14) {
                    i14 = 8;
                    dVar.j(iVarQ4, iVarQ3, i13, 8);
                } else {
                    i14 = 8;
                }
                iMin = Math.min(iMin, i13);
            } else {
                i14 = 8;
            }
            if (i10 == 1) {
                if (z2) {
                    dVar.e(iVarQ4, iVarQ3, iMin, i14);
                } else if (z8) {
                    dVar.e(iVarQ4, iVarQ3, iMin, 5);
                    dVar.j(iVarQ4, iVarQ3, iMin, i14);
                } else {
                    dVar.e(iVarQ4, iVarQ3, iMin, 5);
                    dVar.j(iVarQ4, iVarQ3, iMin, i14);
                }
                i16 = i12;
            } else if (i10 == 2) {
                bVarJ = dVar2.j();
                bVar2 = d.b.TOP;
                if (bVarJ != bVar2) {
                    iVarQ = dVar.q(this.U.m(bVar2));
                    iVarQ2 = dVar.q(this.U.m(d.b.BOTTOM));
                } else {
                    iVarQ = dVar.q(this.U.m(bVar2));
                    iVarQ2 = dVar.q(this.U.m(d.b.BOTTOM));
                }
                c.g.b.i iVar10 = iVarQ;
                c.g.b.b bVarR2 = dVar.r();
                int i34 = i12;
                iVarQ6 = iVarQ6;
                iVarQ5 = iVarQ5;
                i15 = i28 == true ? 1 : 0;
                iVarQ4 = iVarQ4;
                dVar.d(bVarR2.k(iVarQ4, iVarQ3, iVarQ2, iVar10, f3));
                z4 = z4;
                i16 = i34;
                z13 = false;
            } else {
                iVarQ5 = iVarQ5;
                iVarQ4 = iVarQ4;
                int i35 = i12;
                iVarQ6 = iVarQ6;
                i15 = i28;
                i16 = i35;
                z13 = z12;
                z4 = true;
            }
            if (z11) {
                i17 = 0;
                c2 = 2;
                c3 = 1;
            } else {
                i17 = 0;
                c2 = 2;
                c3 = 1;
            }
            if (i15 >= c2) {
            }
        }
        if (z5) {
            dVar.e(iVarQ4, iVarQ3, 0, 3);
            if (i4 > 0) {
                dVar.h(iVarQ4, iVarQ3, i4, 8);
            }
            if (i5 < Integer.MAX_VALUE) {
                dVar.j(iVarQ4, iVarQ3, i5, 8);
            }
        } else {
            dVar.e(iVarQ4, iVarQ3, iMin, i11);
        }
        i16 = i8;
        i13 = i9;
        z13 = z12;
        i15 = i28;
        if (z11) {
            i17 = 0;
            c2 = 2;
            c3 = 1;
        } else {
            i17 = 0;
            c2 = 2;
            c3 = 1;
        }
        if (i15 >= c2) {
        }
    }

    public int A() {
        return this.G;
    }

    public void A0(int i2, int i3, int i4, float f2) {
        this.q = i2;
        this.t = i3;
        if (i4 == Integer.MAX_VALUE) {
            i4 = 0;
        }
        this.u = i4;
        this.v = f2;
        if (f2 <= 0.0f || f2 >= 1.0f || i2 != 0) {
            return;
        }
        this.q = 2;
    }

    public int B() {
        return this.H;
    }

    public void B0(float f2) {
        this.w0[0] = f2;
    }

    public int C(int i2) {
        if (i2 == 0) {
            return R();
        }
        if (i2 == 1) {
            return v();
        }
        return 0;
    }

    protected void C0(int i2, boolean z) {
        this.S[i2] = z;
    }

    public int D() {
        return this.B[1];
    }

    public void D0(boolean z) {
        this.E = z;
    }

    public int E() {
        return this.B[0];
    }

    public void E0(boolean z) {
        this.F = z;
    }

    public int F() {
        return this.h0;
    }

    public void F0(int i2, int i3) {
        this.G = i2;
        this.H = i3;
        I0(false);
    }

    public int G() {
        return this.g0;
    }

    public void G0(int i2) {
        this.B[1] = i2;
    }

    public e H(int i2) {
        d dVar;
        d dVar2;
        if (i2 != 0) {
            if (i2 == 1 && (dVar2 = (dVar = this.L).f3057f) != null && dVar2.f3057f == dVar) {
                return dVar2.f3055d;
            }
            return null;
        }
        d dVar3 = this.K;
        d dVar4 = dVar3.f3057f;
        if (dVar4 == null || dVar4.f3057f != dVar3) {
            return null;
        }
        return dVar4.f3055d;
    }

    public void H0(int i2) {
        this.B[0] = i2;
    }

    public e I() {
        return this.U;
    }

    public void I0(boolean z) {
        this.f3075j = z;
    }

    public e J(int i2) {
        d dVar;
        d dVar2;
        if (i2 != 0) {
            if (i2 == 1 && (dVar2 = (dVar = this.J).f3057f) != null && dVar2.f3057f == dVar) {
                return dVar2.f3055d;
            }
            return null;
        }
        d dVar3 = this.I;
        d dVar4 = dVar3.f3057f;
        if (dVar4 == null || dVar4.f3057f != dVar3) {
            return null;
        }
        return dVar4.f3055d;
    }

    public void J0(int i2) {
        if (i2 < 0) {
            this.h0 = 0;
        } else {
            this.h0 = i2;
        }
    }

    public int K() {
        return S() + this.V;
    }

    public void K0(int i2) {
        if (i2 < 0) {
            this.g0 = 0;
        } else {
            this.g0 = i2;
        }
    }

    public p L(int i2) {
        if (i2 == 0) {
            return this.f3071f;
        }
        if (i2 == 1) {
            return this.f3072g;
        }
        return null;
    }

    public void L0(int i2, int i3) {
        this.Z = i2;
        this.a0 = i3;
    }

    public float M() {
        return this.j0;
    }

    public void M0(e eVar) {
        this.U = eVar;
    }

    public int N() {
        return this.t0;
    }

    public void N0(float f2) {
        this.j0 = f2;
    }

    public b O() {
        return this.T[1];
    }

    public void O0(int i2) {
        this.t0 = i2;
    }

    public int P() {
        int i2 = this.I != null ? 0 + this.J.f3058g : 0;
        return this.K != null ? i2 + this.L.f3058g : i2;
    }

    public void P0(int i2, int i3) {
        this.a0 = i2;
        int i4 = i3 - i2;
        this.W = i4;
        int i5 = this.h0;
        if (i4 < i5) {
            this.W = i5;
        }
    }

    public int Q() {
        return this.m0;
    }

    public void Q0(b bVar) {
        this.T[1] = bVar;
    }

    public int R() {
        if (this.m0 == 8) {
            return 0;
        }
        return this.V;
    }

    public void R0(int i2, int i3, int i4, float f2) {
        this.r = i2;
        this.w = i3;
        if (i4 == Integer.MAX_VALUE) {
            i4 = 0;
        }
        this.x = i4;
        this.y = f2;
        if (f2 <= 0.0f || f2 >= 1.0f || i2 != 0) {
            return;
        }
        this.r = 2;
    }

    public int S() {
        e eVar = this.U;
        return (eVar == null || !(eVar instanceof f)) ? this.Z : ((f) eVar).K0 + this.Z;
    }

    public void S0(float f2) {
        this.w0[1] = f2;
    }

    public int T() {
        e eVar = this.U;
        return (eVar == null || !(eVar instanceof f)) ? this.a0 : ((f) eVar).L0 + this.a0;
    }

    public void T0(int i2) {
        this.m0 = i2;
    }

    public boolean U() {
        return this.D;
    }

    public void U0(int i2) {
        this.V = i2;
        int i3 = this.g0;
        if (i2 < i3) {
            this.V = i3;
        }
    }

    public boolean V(int i2) {
        if (i2 == 0) {
            return (this.I.f3057f != null ? 1 : 0) + (this.K.f3057f != null ? 1 : 0) < 2;
        }
        return ((this.J.f3057f != null ? 1 : 0) + (this.L.f3057f != null ? 1 : 0)) + (this.M.f3057f != null ? 1 : 0) < 2;
    }

    public void V0(int i2) {
        this.Z = i2;
    }

    public boolean W() {
        int size = this.R.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.R.get(i2).l()) {
                return true;
            }
        }
        return false;
    }

    public void W0(int i2) {
        this.a0 = i2;
    }

    public void X(d.b bVar, e eVar, d.b bVar2, int i2, int i3) {
        m(bVar).a(eVar.m(bVar2), i2, i3, true);
    }

    public void X0(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.z == -1) {
            if (z3 && !z4) {
                this.z = 0;
            } else if (!z3 && z4) {
                this.z = 1;
                if (this.Y == -1) {
                    this.A = 1.0f / this.A;
                }
            }
        }
        if (this.z == 0 && (!this.J.n() || !this.L.n())) {
            this.z = 1;
        } else if (this.z == 1 && (!this.I.n() || !this.K.n())) {
            this.z = 0;
        }
        if (this.z == -1 && (!this.J.n() || !this.L.n() || !this.I.n() || !this.K.n())) {
            if (this.J.n() && this.L.n()) {
                this.z = 0;
            } else if (this.I.n() && this.K.n()) {
                this.A = 1.0f / this.A;
                this.z = 1;
            }
        }
        if (this.z == -1) {
            int i2 = this.t;
            if (i2 > 0 && this.w == 0) {
                this.z = 0;
            } else {
                if (i2 != 0 || this.w <= 0) {
                    return;
                }
                this.A = 1.0f / this.A;
                this.z = 1;
            }
        }
    }

    public void Y0(boolean z, boolean z2) {
        int i2;
        int i3;
        boolean zK = z & this.f3071f.k();
        boolean zK2 = z2 & this.f3072g.k();
        c.g.b.k.m.l lVar = this.f3071f;
        int i4 = lVar.f3148h.f3109g;
        n nVar = this.f3072g;
        int i5 = nVar.f3148h.f3109g;
        int i6 = lVar.f3149i.f3109g;
        int i7 = nVar.f3149i.f3109g;
        int i8 = i7 - i5;
        if (i6 - i4 < 0 || i8 < 0 || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE) {
            i6 = 0;
            i4 = 0;
            i7 = 0;
            i5 = 0;
        }
        int i9 = i6 - i4;
        int i10 = i7 - i5;
        if (zK) {
            this.Z = i4;
        }
        if (zK2) {
            this.a0 = i5;
        }
        if (this.m0 == 8) {
            this.V = 0;
            this.W = 0;
            return;
        }
        if (zK) {
            if (this.T[0] == b.FIXED && i9 < (i3 = this.V)) {
                i9 = i3;
            }
            this.V = i9;
            int i11 = this.g0;
            if (i9 < i11) {
                this.V = i11;
            }
        }
        if (zK2) {
            if (this.T[1] == b.FIXED && i10 < (i2 = this.W)) {
                i10 = i2;
            }
            this.W = i10;
            int i12 = this.h0;
            if (i10 < i12) {
                this.W = i12;
            }
        }
    }

    public boolean Z() {
        d dVar = this.I;
        d dVar2 = dVar.f3057f;
        if (dVar2 != null && dVar2.f3057f == dVar) {
            return true;
        }
        d dVar3 = this.K;
        d dVar4 = dVar3.f3057f;
        return dVar4 != null && dVar4.f3057f == dVar3;
    }

    public void Z0(c.g.b.d dVar, boolean z) {
        n nVar;
        c.g.b.k.m.l lVar;
        int iX = dVar.x(this.I);
        int iX2 = dVar.x(this.J);
        int iX3 = dVar.x(this.K);
        int iX4 = dVar.x(this.L);
        if (z && (lVar = this.f3071f) != null) {
            c.g.b.k.m.f fVar = lVar.f3148h;
            if (fVar.f3112j) {
                c.g.b.k.m.f fVar2 = lVar.f3149i;
                if (fVar2.f3112j) {
                    iX = fVar.f3109g;
                    iX3 = fVar2.f3109g;
                }
            }
        }
        if (z && (nVar = this.f3072g) != null) {
            c.g.b.k.m.f fVar3 = nVar.f3148h;
            if (fVar3.f3112j) {
                c.g.b.k.m.f fVar4 = nVar.f3149i;
                if (fVar4.f3112j) {
                    iX2 = fVar3.f3109g;
                    iX4 = fVar4.f3109g;
                }
            }
        }
        int i2 = iX4 - iX2;
        if (iX3 - iX < 0 || i2 < 0 || iX == Integer.MIN_VALUE || iX == Integer.MAX_VALUE || iX2 == Integer.MIN_VALUE || iX2 == Integer.MAX_VALUE || iX3 == Integer.MIN_VALUE || iX3 == Integer.MAX_VALUE || iX4 == Integer.MIN_VALUE || iX4 == Integer.MAX_VALUE) {
            iX4 = 0;
            iX = 0;
            iX2 = 0;
            iX3 = 0;
        }
        t0(iX, iX2, iX3, iX4);
    }

    public boolean a0() {
        return this.E;
    }

    public boolean b0() {
        d dVar = this.J;
        d dVar2 = dVar.f3057f;
        if (dVar2 != null && dVar2.f3057f == dVar) {
            return true;
        }
        d dVar3 = this.L;
        d dVar4 = dVar3.f3057f;
        return dVar4 != null && dVar4.f3057f == dVar3;
    }

    public boolean c0() {
        return this.F;
    }

    public boolean d0() {
        return this.f3075j && this.m0 != 8;
    }

    public void e(f fVar, c.g.b.d dVar, HashSet<e> hashSet, int i2, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            j.a(fVar, dVar, this);
            hashSet.remove(this);
            g(dVar, fVar.B1(64));
        }
        if (i2 == 0) {
            HashSet<d> hashSetC = this.I.c();
            if (hashSetC != null) {
                Iterator<d> it = hashSetC.iterator();
                while (it.hasNext()) {
                    it.next().f3055d.e(fVar, dVar, hashSet, i2, true);
                }
            }
            HashSet<d> hashSetC2 = this.K.c();
            if (hashSetC2 != null) {
                Iterator<d> it2 = hashSetC2.iterator();
                while (it2.hasNext()) {
                    it2.next().f3055d.e(fVar, dVar, hashSet, i2, true);
                }
                return;
            }
            return;
        }
        HashSet<d> hashSetC3 = this.J.c();
        if (hashSetC3 != null) {
            Iterator<d> it3 = hashSetC3.iterator();
            while (it3.hasNext()) {
                it3.next().f3055d.e(fVar, dVar, hashSet, i2, true);
            }
        }
        HashSet<d> hashSetC4 = this.L.c();
        if (hashSetC4 != null) {
            Iterator<d> it4 = hashSetC4.iterator();
            while (it4.hasNext()) {
                it4.next().f3055d.e(fVar, dVar, hashSet, i2, true);
            }
        }
        HashSet<d> hashSetC5 = this.M.c();
        if (hashSetC5 != null) {
            Iterator<d> it5 = hashSetC5.iterator();
            while (it5.hasNext()) {
                it5.next().f3055d.e(fVar, dVar, hashSet, i2, true);
            }
        }
    }

    public boolean e0() {
        return this.m || (this.I.m() && this.K.m());
    }

    boolean f() {
        return (this instanceof k) || (this instanceof g);
    }

    public boolean f0() {
        return this.n || (this.J.m() && this.L.m());
    }

    /* JADX WARN: Code duplicated, block: B:183:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:187:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:190:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:194:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:197:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:200:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:202:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:203:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:206:0x0315  */
    /* JADX WARN: Code duplicated, block: B:227:0x037c  */
    /* JADX WARN: Code duplicated, block: B:229:0x0388  */
    /* JADX WARN: Code duplicated, block: B:230:0x0391  */
    /* JADX WARN: Code duplicated, block: B:233:0x0397  */
    /* JADX WARN: Code duplicated, block: B:234:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:237:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:238:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:240:0x0420  */
    /* JADX WARN: Code duplicated, block: B:242:0x0434  */
    /* JADX WARN: Code duplicated, block: B:244:0x043a  */
    /* JADX WARN: Code duplicated, block: B:246:0x0440  */
    /* JADX WARN: Code duplicated, block: B:259:0x0498  */
    /* JADX WARN: Code duplicated, block: B:263:0x04ac  */
    /* JADX WARN: Code duplicated, block: B:264:0x04ae  */
    /* JADX WARN: Code duplicated, block: B:266:0x04b1  */
    /* JADX WARN: Code duplicated, block: B:304:0x0585  */
    /* JADX WARN: Code duplicated, block: B:306:0x058b  */
    /* JADX WARN: Code duplicated, block: B:308:0x0594  */
    /* JADX WARN: Code duplicated, block: B:309:0x05a4  */
    /* JADX WARN: Code duplicated, block: B:310:0x05b6  */
    /* JADX WARN: Code duplicated, block: B:313:0x05c0  */
    public void g(c.g.b.d dVar, boolean z) {
        boolean z2;
        boolean z3;
        e eVar;
        e eVar2;
        boolean z4;
        boolean z5;
        c.g.b.i iVar;
        char c2;
        int i2;
        int i3;
        int i4;
        boolean z6;
        int i5;
        boolean z7;
        b bVar;
        b bVar2;
        boolean z8;
        int i6;
        c.g.b.i iVar2;
        int i7;
        int i8;
        char c3;
        e eVar3;
        boolean z9;
        boolean z10;
        e eVar4;
        boolean z11;
        n nVar;
        c.g.b.k.m.f fVar;
        e eVar5;
        c.g.b.i iVarQ;
        e eVar6;
        c.g.b.i iVarQ2;
        b[] bVarArr;
        boolean z12;
        c.g.b.k.m.l lVar;
        int i9;
        int i10;
        boolean Z;
        boolean zB0;
        c.g.b.k.m.l lVar2;
        n nVar2;
        c.g.b.i iVarQ3 = dVar.q(this.I);
        c.g.b.i iVarQ4 = dVar.q(this.K);
        c.g.b.i iVarQ5 = dVar.q(this.J);
        c.g.b.i iVarQ6 = dVar.q(this.L);
        c.g.b.i iVarQ7 = dVar.q(this.M);
        e eVar7 = this.U;
        if (eVar7 != null) {
            boolean z13 = eVar7 != null && eVar7.T[0] == b.WRAP_CONTENT;
            z3 = eVar7 != null && eVar7.T[1] == b.WRAP_CONTENT;
            z2 = z13;
        } else {
            z2 = false;
            z3 = false;
        }
        if (this.m0 == 8 && !W()) {
            boolean[] zArr = this.S;
            if (!zArr[0] && !zArr[1]) {
                return;
            }
        }
        boolean z14 = this.m;
        if (z14 || this.n) {
            if (z14) {
                dVar.f(iVarQ3, this.Z);
                dVar.f(iVarQ4, this.Z + this.V);
                if (z2 && (eVar2 = this.U) != null) {
                    if (this.l) {
                        f fVar2 = (f) eVar2;
                        fVar2.n1(this.I);
                        fVar2.h1(this.K);
                    } else {
                        dVar.h(dVar.q(eVar2.K), iVarQ4, 0, 5);
                    }
                }
            }
            if (this.n) {
                dVar.f(iVarQ5, this.a0);
                dVar.f(iVarQ6, this.a0 + this.W);
                if (this.M.l()) {
                    dVar.f(iVarQ7, this.a0 + this.f0);
                }
                if (z3 && (eVar = this.U) != null) {
                    if (this.l) {
                        f fVar3 = (f) eVar;
                        fVar3.n1(this.J);
                        fVar3.m1(this.L);
                    } else {
                        dVar.h(dVar.q(eVar.L), iVarQ6, 0, 5);
                    }
                }
            }
            if (this.m && this.n) {
                this.m = false;
                this.n = false;
                return;
            }
        }
        c.g.b.e eVar8 = c.g.b.d.f3001g;
        if (eVar8 != null) {
            throw null;
        }
        if (z && (lVar2 = this.f3071f) != null && (nVar2 = this.f3072g) != null) {
            c.g.b.k.m.f fVar4 = lVar2.f3148h;
            if (fVar4.f3112j && lVar2.f3149i.f3112j && nVar2.f3148h.f3112j && nVar2.f3149i.f3112j) {
                if (eVar8 != null) {
                    throw null;
                }
                dVar.f(iVarQ3, fVar4.f3109g);
                dVar.f(iVarQ4, this.f3071f.f3149i.f3109g);
                dVar.f(iVarQ5, this.f3072g.f3148h.f3109g);
                dVar.f(iVarQ6, this.f3072g.f3149i.f3109g);
                dVar.f(iVarQ7, this.f3072g.f3128k.f3109g);
                if (this.U != null) {
                    if (z2 && this.f3073h[0] && !Z()) {
                        dVar.h(dVar.q(this.U.K), iVarQ4, 0, 8);
                    }
                    if (z3 && this.f3073h[1] && !b0()) {
                        dVar.h(dVar.q(this.U.L), iVarQ6, 0, 8);
                    }
                }
                this.m = false;
                this.n = false;
                return;
            }
        }
        if (eVar8 != null) {
            throw null;
        }
        if (this.U != null) {
            if (Y(0)) {
                ((f) this.U).e1(this, 0);
                Z = true;
            } else {
                Z = Z();
            }
            if (Y(1)) {
                ((f) this.U).e1(this, 1);
                zB0 = true;
            } else {
                zB0 = b0();
            }
            if (!Z && z2 && this.m0 != 8 && this.I.f3057f == null && this.K.f3057f == null) {
                dVar.h(dVar.q(this.U.K), iVarQ4, 0, 1);
            }
            if (!zB0 && z3 && this.m0 != 8 && this.J.f3057f == null && this.L.f3057f == null && this.M == null) {
                dVar.h(dVar.q(this.U.L), iVarQ6, 0, 1);
            }
            z5 = Z;
            z4 = zB0;
        } else {
            z4 = false;
            z5 = false;
        }
        int i11 = this.V;
        int i12 = this.g0;
        if (i11 >= i12) {
            i12 = i11;
        }
        int i13 = this.W;
        int i14 = this.h0;
        if (i13 >= i14) {
            i14 = i13;
        }
        b[] bVarArr2 = this.T;
        b bVar3 = bVarArr2[0];
        b bVar4 = b.MATCH_CONSTRAINT;
        int i15 = i12;
        boolean z15 = bVar3 != bVar4;
        int i16 = i14;
        boolean z16 = bVarArr2[1] != bVar4;
        int i17 = this.Y;
        this.z = i17;
        c.g.b.i iVar3 = iVarQ7;
        float f2 = this.X;
        this.A = f2;
        c.g.b.i iVar4 = iVarQ6;
        int i18 = this.q;
        c.g.b.i iVar5 = iVarQ5;
        int i19 = this.r;
        c.g.b.i iVar6 = iVarQ4;
        if (f2 > 0.0f) {
            iVar = iVarQ3;
            if (this.m0 != 8) {
                if (bVarArr2[0] == bVar4 && i18 == 0) {
                    i18 = 3;
                }
                if (bVarArr2[1] == bVar4 && i19 == 0) {
                    i19 = 3;
                }
                if (bVarArr2[0] == bVar4 && bVarArr2[1] == bVar4) {
                    i10 = 3;
                    if (i18 == 3 && i19 == 3) {
                        X0(z2, z3, z15, z16);
                    }
                    c2 = 0;
                    i2 = i18;
                    i3 = i15;
                    i4 = i16;
                    z6 = true;
                } else {
                    i10 = 3;
                }
                if (bVarArr2[0] == bVar4 && i18 == i10) {
                    this.z = 0;
                    i3 = (int) (f2 * i13);
                    if (bVarArr2[1] != bVar4) {
                        i19 = i19;
                        i4 = i16;
                        c2 = 0;
                        z6 = false;
                        i2 = 4;
                    } else {
                        i2 = i18;
                        i4 = i16;
                        c2 = 0;
                        z6 = true;
                    }
                } else {
                    if (bVarArr2[1] == bVar4 && i19 == 3) {
                        this.z = 1;
                        if (i17 == -1) {
                            this.A = 1.0f / f2;
                        }
                        int i20 = (int) (this.A * i11);
                        c2 = 0;
                        i4 = i20;
                        i2 = i18;
                        if (bVarArr2[0] != bVar4) {
                            i3 = i15;
                            z6 = false;
                            i19 = 4;
                        } else {
                            i3 = i15;
                        }
                    } else {
                        c2 = 0;
                        i2 = i18;
                        i3 = i15;
                        i4 = i16;
                    }
                    z6 = true;
                }
            }
            int[] iArr = this.s;
            iArr[c2] = i2;
            iArr[1] = i19;
            this.f3074i = z6;
            if (z6) {
                int i21 = this.z;
                i5 = -1;
                boolean z17 = i21 != 0 || i21 == -1;
                if (z6 || !((i9 = this.z) == 1 || i9 == i5)) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                bVar = this.T[0];
                bVar2 = b.WRAP_CONTENT;
                if (bVar == bVar2 || !(this instanceof f)) {
                    z8 = false;
                } else {
                    z8 = true;
                }
                if (z8) {
                    i6 = 0;
                } else {
                    i6 = i3;
                }
                boolean z18 = !this.P.n();
                boolean[] zArr2 = this.S;
                boolean z19 = zArr2[0];
                boolean z20 = zArr2[1];
                if (this.o != 2 || this.m) {
                    iVar2 = iVar;
                } else if (!z || (lVar = this.f3071f) == null) {
                    c.g.b.i iVar7 = iVar;
                    eVar5 = this.U;
                    if (eVar5 != null) {
                        iVarQ = dVar.q(eVar5.K);
                    } else {
                        iVarQ = null;
                    }
                    eVar6 = this.U;
                    if (eVar6 != null) {
                        iVarQ2 = dVar.q(eVar6.I);
                    } else {
                        iVarQ2 = null;
                    }
                    boolean z21 = this.f3073h[0];
                    bVarArr = this.T;
                    b bVar5 = bVarArr[0];
                    d dVar2 = this.I;
                    d dVar3 = this.K;
                    int i22 = this.Z;
                    int i23 = this.g0;
                    int i24 = this.B[0];
                    float f3 = this.i0;
                    if (bVarArr[1] == bVar4) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    iVar6 = iVar6;
                    iVar2 = iVar7;
                    i(dVar, true, z2, z3, z21, iVarQ2, iVarQ, bVar5, z8, dVar2, dVar3, i22, i6, i23, i24, f3, z17, z12, z5, z4, z19, i2, i19, this.t, this.u, this.v, z18);
                } else {
                    c.g.b.k.m.f fVar5 = lVar.f3148h;
                    if (!fVar5.f3112j || !lVar.f3149i.f3112j) {
                        c.g.b.i iVar8 = iVar;
                        eVar5 = this.U;
                        if (eVar5 != null) {
                            iVarQ = dVar.q(eVar5.K);
                        } else {
                            iVarQ = null;
                        }
                        eVar6 = this.U;
                        if (eVar6 != null) {
                            iVarQ2 = dVar.q(eVar6.I);
                        } else {
                            iVarQ2 = null;
                        }
                        boolean z22 = this.f3073h[0];
                        bVarArr = this.T;
                        b bVar6 = bVarArr[0];
                        d dVar4 = this.I;
                        d dVar5 = this.K;
                        int i25 = this.Z;
                        int i26 = this.g0;
                        int i27 = this.B[0];
                        float f4 = this.i0;
                        if (bVarArr[1] == bVar4) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        iVar6 = iVar6;
                        iVar2 = iVar8;
                        i(dVar, true, z2, z3, z22, iVarQ2, iVarQ, bVar6, z8, dVar4, dVar5, i25, i6, i26, i27, f4, z17, z12, z5, z4, z19, i2, i19, this.t, this.u, this.v, z18);
                    } else if (z) {
                        c.g.b.i iVar9 = iVar;
                        dVar.f(iVar9, fVar5.f3109g);
                        dVar.f(iVar6, this.f3071f.f3149i.f3109g);
                        if (this.U != null && z2 && this.f3073h[0] && !Z()) {
                            dVar.h(dVar.q(this.U.K), iVar6, 0, 8);
                        }
                        iVar6 = iVar6;
                        iVar2 = iVar9;
                    } else {
                        iVar2 = iVar;
                    }
                }
                if (z) {
                    eVar3 = this;
                    nVar = eVar3.f3072g;
                    if (nVar != null) {
                        fVar = nVar.f3148h;
                        if (!fVar.f3112j && nVar.f3149i.f3112j) {
                            dVar = dVar;
                            iVar5 = iVar5;
                            dVar.f(iVar5, fVar.f3109g);
                            iVar4 = iVar4;
                            dVar.f(iVar4, eVar3.f3072g.f3149i.f3109g);
                            iVar3 = iVar3;
                            dVar.f(iVar3, eVar3.f3072g.f3128k.f3109g);
                            e eVar9 = eVar3.U;
                            if (eVar9 == null || z4 || !z3) {
                                i7 = 8;
                                i8 = 0;
                                c3 = 1;
                            } else {
                                c3 = 1;
                                if (eVar3.f3073h[1]) {
                                    i7 = 8;
                                    i8 = 0;
                                    dVar.h(dVar.q(eVar9.L), iVar4, 0, 8);
                                } else {
                                    i7 = 8;
                                    i8 = 0;
                                }
                            }
                            z9 = false;
                        }
                        if (eVar3.p == 2) {
                            z10 = false;
                        } else {
                            z10 = z9;
                        }
                        if (!z10 && !eVar3.n) {
                            boolean z23 = eVar3.T[c3] == bVar2 && (eVar3 instanceof f);
                            if (z23) {
                                i4 = 0;
                            }
                            e eVar10 = eVar3.U;
                            c.g.b.i iVarQ8 = eVar10 != null ? dVar.q(eVar10.L) : null;
                            e eVar11 = eVar3.U;
                            c.g.b.i iVarQ9 = eVar11 != null ? dVar.q(eVar11.J) : null;
                            if (eVar3.f0 <= 0 && eVar3.m0 != i7) {
                                z11 = z18;
                            } else if (eVar3.M.f3057f != null) {
                                dVar.e(iVar3, iVar5, n(), i7);
                                dVar.e(iVar3, dVar.q(eVar3.M.f3057f), i8, i7);
                                if (z3 != 0) {
                                    dVar.h(iVarQ8, dVar.q(eVar3.L), i8, 5);
                                }
                                z11 = false;
                            } else {
                                if (eVar3.m0 == i7) {
                                    dVar.e(iVar3, iVar5, i8, i7);
                                } else {
                                    dVar.e(iVar3, iVar5, n(), i7);
                                }
                                z11 = z18;
                            }
                            boolean z24 = eVar3.f3073h[c3];
                            b[] bVarArr3 = eVar3.T;
                            i(dVar, false, z3, z2, z24, iVarQ9, iVarQ8, bVarArr3[c3], z23, eVar3.J, eVar3.L, eVar3.a0, i4, eVar3.h0, eVar3.B[c3], eVar3.j0, z7, bVarArr3[0] == bVar4, z4, z5, z20, i19, i2, eVar3.w, eVar3.x, eVar3.y, z11);
                        }
                        if (z6) {
                            eVar4 = this;
                            if (eVar4.z == 1) {
                                dVar.k(iVar4, iVar5, iVar6, iVar2, eVar4.A, 8);
                            } else {
                                dVar.k(iVar6, iVar2, iVar4, iVar5, eVar4.A, 8);
                            }
                        } else {
                            eVar4 = this;
                        }
                        if (eVar4.P.n()) {
                            dVar.b(eVar4, eVar4.P.i().g(), (float) Math.toRadians(eVar4.C + 90.0f), eVar4.P.e());
                        }
                        eVar4.m = false;
                        eVar4.n = false;
                    }
                    i7 = 8;
                    i8 = 0;
                    c3 = 1;
                } else {
                    i7 = 8;
                    i8 = 0;
                    c3 = 1;
                    eVar3 = this;
                }
                z9 = true;
                if (eVar3.p == 2) {
                    z10 = false;
                } else {
                    z10 = z9;
                }
                if (!z10) {
                }
                if (z6) {
                    eVar4 = this;
                    if (eVar4.z == 1) {
                        dVar.k(iVar4, iVar5, iVar6, iVar2, eVar4.A, 8);
                    } else {
                        dVar.k(iVar6, iVar2, iVar4, iVar5, eVar4.A, 8);
                    }
                } else {
                    eVar4 = this;
                }
                if (eVar4.P.n()) {
                    dVar.b(eVar4, eVar4.P.i().g(), (float) Math.toRadians(eVar4.C + 90.0f), eVar4.P.e());
                }
                eVar4.m = false;
                eVar4.n = false;
            }
            i5 = -1;
            if (z6) {
                z7 = false;
            } else {
                z7 = false;
            }
            bVar = this.T[0];
            bVar2 = b.WRAP_CONTENT;
            if (bVar == bVar2) {
                z8 = false;
            } else {
                z8 = false;
            }
            if (z8) {
                i6 = 0;
            } else {
                i6 = i3;
            }
            boolean z110 = !this.P.n();
            boolean[] zArr3 = this.S;
            boolean z111 = zArr3[0];
            boolean z25 = zArr3[1];
            if (this.o != 2) {
                iVar2 = iVar;
            } else {
                iVar2 = iVar;
            }
            if (z) {
                eVar3 = this;
                nVar = eVar3.f3072g;
                if (nVar != null) {
                    fVar = nVar.f3148h;
                    if (!fVar.f3112j) {
                    }
                }
                i7 = 8;
                i8 = 0;
                c3 = 1;
            } else {
                i7 = 8;
                i8 = 0;
                c3 = 1;
                eVar3 = this;
            }
            z9 = true;
            if (eVar3.p == 2) {
                z10 = false;
            } else {
                z10 = z9;
            }
            if (!z10) {
            }
            if (z6) {
                eVar4 = this;
                if (eVar4.z == 1) {
                    dVar.k(iVar4, iVar5, iVar6, iVar2, eVar4.A, 8);
                } else {
                    dVar.k(iVar6, iVar2, iVar4, iVar5, eVar4.A, 8);
                }
            } else {
                eVar4 = this;
            }
            if (eVar4.P.n()) {
                dVar.b(eVar4, eVar4.P.i().g(), (float) Math.toRadians(eVar4.C + 90.0f), eVar4.P.e());
            }
            eVar4.m = false;
            eVar4.n = false;
        }
        iVar = iVarQ3;
        c2 = 0;
        i2 = i18;
        i19 = i19;
        i3 = i15;
        i4 = i16;
        z6 = false;
        int[] iArr2 = this.s;
        iArr2[c2] = i2;
        iArr2[1] = i19;
        this.f3074i = z6;
        if (z6) {
            int i28 = this.z;
            i5 = -1;
            if (i28 != 0) {
            }
            if (z6) {
                z7 = false;
            } else {
                z7 = false;
            }
            bVar = this.T[0];
            bVar2 = b.WRAP_CONTENT;
            if (bVar == bVar2) {
                z8 = false;
            } else {
                z8 = false;
            }
            if (z8) {
                i6 = 0;
            } else {
                i6 = i3;
            }
            boolean z112 = !this.P.n();
            boolean[] zArr4 = this.S;
            boolean z113 = zArr4[0];
            boolean z26 = zArr4[1];
            if (this.o != 2) {
                iVar2 = iVar;
            } else {
                iVar2 = iVar;
            }
            if (z) {
                eVar3 = this;
                nVar = eVar3.f3072g;
                if (nVar != null) {
                    fVar = nVar.f3148h;
                    if (!fVar.f3112j) {
                    }
                }
                i7 = 8;
                i8 = 0;
                c3 = 1;
            } else {
                i7 = 8;
                i8 = 0;
                c3 = 1;
                eVar3 = this;
            }
            z9 = true;
            if (eVar3.p == 2) {
                z10 = false;
            } else {
                z10 = z9;
            }
            if (!z10) {
            }
            if (z6) {
                eVar4 = this;
                if (eVar4.z == 1) {
                    dVar.k(iVar4, iVar5, iVar6, iVar2, eVar4.A, 8);
                } else {
                    dVar.k(iVar6, iVar2, iVar4, iVar5, eVar4.A, 8);
                }
            } else {
                eVar4 = this;
            }
            if (eVar4.P.n()) {
                dVar.b(eVar4, eVar4.P.i().g(), (float) Math.toRadians(eVar4.C + 90.0f), eVar4.P.e());
            }
            eVar4.m = false;
            eVar4.n = false;
        }
        i5 = -1;
        if (z6) {
            z7 = false;
        } else {
            z7 = false;
        }
        bVar = this.T[0];
        bVar2 = b.WRAP_CONTENT;
        if (bVar == bVar2) {
            z8 = false;
        } else {
            z8 = false;
        }
        if (z8) {
            i6 = 0;
        } else {
            i6 = i3;
        }
        boolean z114 = !this.P.n();
        boolean[] zArr5 = this.S;
        boolean z115 = zArr5[0];
        boolean z27 = zArr5[1];
        if (this.o != 2) {
            iVar2 = iVar;
        } else {
            iVar2 = iVar;
        }
        if (z) {
            eVar3 = this;
            nVar = eVar3.f3072g;
            if (nVar != null) {
                fVar = nVar.f3148h;
                if (!fVar.f3112j) {
                }
            }
            i7 = 8;
            i8 = 0;
            c3 = 1;
        } else {
            i7 = 8;
            i8 = 0;
            c3 = 1;
            eVar3 = this;
        }
        z9 = true;
        if (eVar3.p == 2) {
            z10 = false;
        } else {
            z10 = z9;
        }
        if (!z10) {
        }
        if (z6) {
            eVar4 = this;
            if (eVar4.z == 1) {
                dVar.k(iVar4, iVar5, iVar6, iVar2, eVar4.A, 8);
            } else {
                dVar.k(iVar6, iVar2, iVar4, iVar5, eVar4.A, 8);
            }
        } else {
            eVar4 = this;
        }
        if (eVar4.P.n()) {
            dVar.b(eVar4, eVar4.P.i().g(), (float) Math.toRadians(eVar4.C + 90.0f), eVar4.P.e());
        }
        eVar4.m = false;
        eVar4.n = false;
    }

    public boolean g0() {
        b[] bVarArr = this.T;
        b bVar = bVarArr[0];
        b bVar2 = b.MATCH_CONSTRAINT;
        return bVar == bVar2 && bVarArr[1] == bVar2;
    }

    public boolean h() {
        return this.m0 != 8;
    }

    public void h0() {
        this.I.p();
        this.J.p();
        this.K.p();
        this.L.p();
        this.M.p();
        this.N.p();
        this.O.p();
        this.P.p();
        this.U = null;
        this.C = 0.0f;
        this.V = 0;
        this.W = 0;
        this.X = 0.0f;
        this.Y = -1;
        this.Z = 0;
        this.a0 = 0;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = 0;
        this.g0 = 0;
        this.h0 = 0;
        float f2 = a;
        this.i0 = f2;
        this.j0 = f2;
        b[] bVarArr = this.T;
        b bVar = b.FIXED;
        bVarArr[0] = bVar;
        bVarArr[1] = bVar;
        this.k0 = null;
        this.l0 = 0;
        this.m0 = 0;
        this.o0 = null;
        this.p0 = false;
        this.q0 = false;
        this.s0 = 0;
        this.t0 = 0;
        this.u0 = false;
        this.v0 = false;
        float[] fArr = this.w0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.o = -1;
        this.p = -1;
        int[] iArr = this.B;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.q = 0;
        this.r = 0;
        this.v = 1.0f;
        this.y = 1.0f;
        this.u = Integer.MAX_VALUE;
        this.x = Integer.MAX_VALUE;
        this.t = 0;
        this.w = 0;
        this.f3074i = false;
        this.z = -1;
        this.A = 1.0f;
        this.r0 = false;
        boolean[] zArr = this.f3073h;
        zArr[0] = true;
        zArr[1] = true;
        this.F = false;
        boolean[] zArr2 = this.S;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f3075j = true;
    }

    public void i0() {
        this.m = false;
        this.n = false;
        int size = this.R.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.R.get(i2).q();
        }
    }

    public void j(e eVar, float f2, int i2) {
        d.b bVar = d.b.CENTER;
        X(bVar, eVar, bVar, i2, 0);
        this.C = f2;
    }

    public void j0(c.g.b.c cVar) {
        this.I.r(cVar);
        this.J.r(cVar);
        this.K.r(cVar);
        this.L.r(cVar);
        this.M.r(cVar);
        this.P.r(cVar);
        this.N.r(cVar);
        this.O.r(cVar);
    }

    public void k(c.g.b.d dVar) {
        dVar.q(this.I);
        dVar.q(this.J);
        dVar.q(this.K);
        dVar.q(this.L);
        if (this.f0 > 0) {
            dVar.q(this.M);
        }
    }

    public void k0(int i2) {
        this.f0 = i2;
        this.D = i2 > 0;
    }

    public void l() {
        if (this.f3071f == null) {
            this.f3071f = new c.g.b.k.m.l(this);
        }
        if (this.f3072g == null) {
            this.f3072g = new n(this);
        }
    }

    public void l0(Object obj) {
        this.k0 = obj;
    }

    public d m(d.b bVar) {
        switch (a.a[bVar.ordinal()]) {
            case 1:
                return this.I;
            case 2:
                return this.J;
            case 3:
                return this.K;
            case 4:
                return this.L;
            case 5:
                return this.M;
            case 6:
                return this.P;
            case 7:
                return this.N;
            case 8:
                return this.O;
            case 9:
                return null;
            default:
                throw new AssertionError(bVar.name());
        }
    }

    public void m0(String str) {
        this.n0 = str;
    }

    public int n() {
        return this.f0;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0084 A[PHI: r0
      0x0084: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:45:0x0084, B:35:0x007d, B:23:0x004f, B:25:0x0055, B:27:0x0061, B:29:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:39:0x0085). Please report as a decompilation issue!!! */
    public void n0(String str) {
        float fAbs;
        int i2 = 0;
        if (str == null || str.length() == 0) {
            this.X = 0.0f;
            return;
        }
        int i3 = -1;
        int length = str.length();
        int iIndexOf = str.indexOf(44);
        int i4 = 0;
        if (iIndexOf > 0 && iIndexOf < length - 1) {
            String strSubstring = str.substring(0, iIndexOf);
            if (strSubstring.equalsIgnoreCase("W")) {
                i3 = 0;
            } else if (strSubstring.equalsIgnoreCase("H")) {
                i3 = 1;
            }
            i4 = iIndexOf + 1;
        }
        int iIndexOf2 = str.indexOf(58);
        try {
            if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                String strSubstring2 = str.substring(i4);
                if (strSubstring2.length() > 0) {
                    fAbs = Float.parseFloat(strSubstring2);
                } else {
                    fAbs = 0.0f;
                }
            } else {
                String strSubstring3 = str.substring(i4, iIndexOf2);
                String strSubstring4 = str.substring(iIndexOf2 + 1);
                if (strSubstring3.length() <= 0 || strSubstring4.length() <= 0) {
                    fAbs = 0.0f;
                } else {
                    float f2 = Float.parseFloat(strSubstring3);
                    float f3 = Float.parseFloat(strSubstring4);
                    if (f2 <= 0.0f || f3 <= 0.0f) {
                        fAbs = 0.0f;
                    } else {
                        fAbs = i3 == 1 ? Math.abs(f3 / f2) : Math.abs(f2 / f3);
                    }
                }
            }
        } catch (NumberFormatException unused) {
        }
        i2 = (fAbs > i2 ? 1 : (fAbs == i2 ? 0 : -1));
        if (i2 > 0) {
            this.X = fAbs;
            this.Y = i3;
        }
    }

    public float o(int i2) {
        if (i2 == 0) {
            return this.i0;
        }
        if (i2 == 1) {
            return this.j0;
        }
        return -1.0f;
    }

    public void o0(int i2) {
        if (this.D) {
            int i3 = i2 - this.f0;
            int i4 = this.W + i3;
            this.a0 = i3;
            this.J.s(i3);
            this.L.s(i4);
            this.M.s(i2);
            this.n = true;
        }
    }

    public int p() {
        return T() + this.W;
    }

    public void p0(int i2, int i3) {
        this.I.s(i2);
        this.K.s(i3);
        this.Z = i2;
        this.V = i3 - i2;
        this.m = true;
    }

    public Object q() {
        return this.k0;
    }

    public void q0(int i2) {
        this.I.s(i2);
        this.Z = i2;
    }

    public String r() {
        return this.n0;
    }

    public void r0(int i2) {
        this.J.s(i2);
        this.a0 = i2;
    }

    public b s(int i2) {
        if (i2 == 0) {
            return y();
        }
        if (i2 == 1) {
            return O();
        }
        return null;
    }

    public void s0(int i2, int i3) {
        this.J.s(i2);
        this.L.s(i3);
        this.a0 = i2;
        this.W = i3 - i2;
        if (this.D) {
            this.M.s(i2 + this.f0);
        }
        this.n = true;
    }

    public float t() {
        return this.X;
    }

    public void t0(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8 = i4 - i2;
        int i9 = i5 - i3;
        this.Z = i2;
        this.a0 = i3;
        if (this.m0 == 8) {
            this.V = 0;
            this.W = 0;
            return;
        }
        b[] bVarArr = this.T;
        b bVar = bVarArr[0];
        b bVar2 = b.FIXED;
        if (bVar == bVar2 && i8 < (i7 = this.V)) {
            i8 = i7;
        }
        if (bVarArr[1] == bVar2 && i9 < (i6 = this.W)) {
            i9 = i6;
        }
        this.V = i8;
        this.W = i9;
        int i10 = this.h0;
        if (i9 < i10) {
            this.W = i10;
        }
        int i11 = this.g0;
        if (i8 < i11) {
            this.V = i11;
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = this.o0;
        String str3 = HttpUrl.FRAGMENT_ENCODE_SET;
        if (str2 != null) {
            str = "type: " + this.o0 + " ";
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(str);
        if (this.n0 != null) {
            str3 = "id: " + this.n0 + " ";
        }
        sb.append(str3);
        sb.append("(");
        sb.append(this.Z);
        sb.append(", ");
        sb.append(this.a0);
        sb.append(") - (");
        sb.append(this.V);
        sb.append(" x ");
        sb.append(this.W);
        sb.append(")");
        return sb.toString();
    }

    public int u() {
        return this.Y;
    }

    public void u0(boolean z) {
        this.D = z;
    }

    public int v() {
        if (this.m0 == 8) {
            return 0;
        }
        return this.W;
    }

    public void v0(int i2) {
        this.W = i2;
        int i3 = this.h0;
        if (i2 < i3) {
            this.W = i3;
        }
    }

    public float w() {
        return this.i0;
    }

    public void w0(float f2) {
        this.i0 = f2;
    }

    public int x() {
        return this.s0;
    }

    public void x0(int i2) {
        this.s0 = i2;
    }

    public b y() {
        return this.T[0];
    }

    public void y0(int i2, int i3) {
        this.Z = i2;
        int i4 = i3 - i2;
        this.V = i4;
        int i5 = this.g0;
        if (i4 < i5) {
            this.V = i5;
        }
    }

    public int z() {
        d dVar = this.I;
        int i2 = dVar != null ? 0 + dVar.f3058g : 0;
        d dVar2 = this.K;
        return dVar2 != null ? i2 + dVar2.f3058g : i2;
    }

    public void z0(b bVar) {
        this.T[0] = bVar;
    }
}
