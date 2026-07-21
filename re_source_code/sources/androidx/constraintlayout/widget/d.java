package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ConstraintSet.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final int[] a = {0, 4, 8};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SparseIntArray f758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashMap<String, androidx.constraintlayout.widget.a> f759c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f760d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap<Integer, a> f761e = new HashMap<>();

    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class a {
        int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0015d f762b = new C0015d();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f763c = new c();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f764d = new b();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final e f765e = new e();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public HashMap<String, androidx.constraintlayout.widget.a> f766f = new HashMap<>();

        /* JADX INFO: Access modifiers changed from: private */
        public void f(int i2, ConstraintLayout.b bVar) {
            this.a = i2;
            b bVar2 = this.f764d;
            bVar2.f774i = bVar.f713d;
            bVar2.f775j = bVar.f714e;
            bVar2.f776k = bVar.f715f;
            bVar2.l = bVar.f716g;
            bVar2.m = bVar.f717h;
            bVar2.n = bVar.f718i;
            bVar2.o = bVar.f719j;
            bVar2.p = bVar.f720k;
            bVar2.q = bVar.l;
            bVar2.r = bVar.p;
            bVar2.s = bVar.q;
            bVar2.t = bVar.r;
            bVar2.u = bVar.s;
            bVar2.v = bVar.z;
            bVar2.w = bVar.A;
            bVar2.x = bVar.B;
            bVar2.y = bVar.m;
            bVar2.z = bVar.n;
            bVar2.A = bVar.o;
            bVar2.B = bVar.Q;
            bVar2.C = bVar.R;
            bVar2.D = bVar.S;
            bVar2.f773h = bVar.f712c;
            bVar2.f771f = bVar.a;
            bVar2.f772g = bVar.f711b;
            b bVar3 = this.f764d;
            bVar3.f769d = ((ViewGroup.MarginLayoutParams) bVar).width;
            bVar3.f770e = ((ViewGroup.MarginLayoutParams) bVar).height;
            bVar3.E = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            bVar3.F = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            bVar3.G = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            bVar3.H = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            bVar3.Q = bVar.F;
            bVar3.R = bVar.E;
            bVar3.T = bVar.H;
            bVar3.S = bVar.G;
            bVar3.i0 = bVar.T;
            bVar3.j0 = bVar.U;
            bVar3.U = bVar.I;
            bVar3.V = bVar.J;
            bVar3.W = bVar.M;
            bVar3.X = bVar.N;
            bVar3.Y = bVar.K;
            bVar3.Z = bVar.L;
            bVar3.a0 = bVar.O;
            bVar3.b0 = bVar.P;
            bVar3.h0 = bVar.V;
            bVar3.L = bVar.u;
            bVar3.N = bVar.w;
            bVar3.K = bVar.t;
            bVar3.M = bVar.v;
            b bVar4 = this.f764d;
            bVar4.P = bVar.x;
            bVar4.O = bVar.y;
            if (Build.VERSION.SDK_INT >= 17) {
                bVar4.I = bVar.getMarginEnd();
                this.f764d.J = bVar.getMarginStart();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(int i2, androidx.constraintlayout.widget.e.a aVar) {
            f(i2, aVar);
            this.f762b.f786d = aVar.p0;
            e eVar = this.f765e;
            eVar.f789c = aVar.s0;
            eVar.f790d = aVar.t0;
            eVar.f791e = aVar.u0;
            eVar.f792f = aVar.v0;
            eVar.f793g = aVar.w0;
            eVar.f794h = aVar.x0;
            eVar.f795i = aVar.y0;
            eVar.f796j = aVar.z0;
            eVar.f797k = aVar.A0;
            eVar.l = aVar.B0;
            eVar.n = aVar.r0;
            eVar.m = aVar.q0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(androidx.constraintlayout.widget.b bVar, int i2, androidx.constraintlayout.widget.e.a aVar) {
            g(i2, aVar);
            if (bVar instanceof Barrier) {
                b bVar2 = this.f764d;
                bVar2.e0 = 1;
                Barrier barrier = (Barrier) bVar;
                bVar2.c0 = barrier.getType();
                this.f764d.f0 = barrier.getReferencedIds();
                this.f764d.d0 = barrier.getMargin();
            }
        }

        public void d(ConstraintLayout.b bVar) {
            b bVar2 = this.f764d;
            bVar.f713d = bVar2.f774i;
            bVar.f714e = bVar2.f775j;
            bVar.f715f = bVar2.f776k;
            bVar.f716g = bVar2.l;
            bVar.f717h = bVar2.m;
            bVar.f718i = bVar2.n;
            bVar.f719j = bVar2.o;
            bVar.f720k = bVar2.p;
            bVar.l = bVar2.q;
            bVar.p = bVar2.r;
            bVar.q = bVar2.s;
            bVar.r = bVar2.t;
            bVar.s = bVar2.u;
            ((ViewGroup.MarginLayoutParams) bVar).leftMargin = bVar2.E;
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = bVar2.F;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = bVar2.G;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = bVar2.H;
            bVar.x = bVar2.P;
            bVar.y = bVar2.O;
            bVar.u = bVar2.L;
            bVar.w = bVar2.N;
            bVar.z = bVar2.v;
            bVar.A = bVar2.w;
            bVar.m = bVar2.y;
            bVar.n = bVar2.z;
            b bVar3 = this.f764d;
            bVar.o = bVar3.A;
            bVar.B = bVar3.x;
            bVar.Q = bVar3.B;
            bVar.R = bVar3.C;
            bVar.F = bVar3.Q;
            bVar.E = bVar3.R;
            bVar.H = bVar3.T;
            bVar.G = bVar3.S;
            bVar.T = bVar3.i0;
            bVar.U = bVar3.j0;
            bVar.I = bVar3.U;
            bVar.J = bVar3.V;
            bVar.M = bVar3.W;
            bVar.N = bVar3.X;
            bVar.K = bVar3.Y;
            bVar.L = bVar3.Z;
            bVar.O = bVar3.a0;
            bVar.P = bVar3.b0;
            bVar.S = bVar3.D;
            bVar.f712c = bVar3.f773h;
            bVar.a = bVar3.f771f;
            bVar.f711b = bVar3.f772g;
            ((ViewGroup.MarginLayoutParams) bVar).width = bVar3.f769d;
            ((ViewGroup.MarginLayoutParams) bVar).height = bVar3.f770e;
            String str = bVar3.h0;
            if (str != null) {
                bVar.V = str;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                bVar.setMarginStart(this.f764d.J);
                bVar.setMarginEnd(this.f764d.I);
            }
            bVar.a();
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.f764d.a(this.f764d);
            aVar.f763c.a(this.f763c);
            aVar.f762b.a(this.f762b);
            aVar.f765e.a(this.f765e);
            aVar.a = this.a;
            return aVar;
        }
    }

    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class b {
        private static SparseIntArray a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f769d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f770e;
        public int[] f0;
        public String g0;
        public String h0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f767b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f768c = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f771f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f772g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f773h = -1.0f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f774i = -1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f775j = -1;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f776k = -1;
        public int l = -1;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = -1;
        public float v = 0.5f;
        public float w = 0.5f;
        public String x = null;
        public int y = -1;
        public int z = 0;
        public float A = 0.0f;
        public int B = -1;
        public int C = -1;
        public int D = -1;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = -1;
        public int I = -1;
        public int J = -1;
        public int K = -1;
        public int L = -1;
        public int M = -1;
        public int N = -1;
        public int O = -1;
        public int P = -1;
        public float Q = -1.0f;
        public float R = -1.0f;
        public int S = 0;
        public int T = 0;
        public int U = 0;
        public int V = 0;
        public int W = -1;
        public int X = -1;
        public int Y = -1;
        public int Z = -1;
        public float a0 = 1.0f;
        public float b0 = 1.0f;
        public int c0 = -1;
        public int d0 = 0;
        public int e0 = -1;
        public boolean i0 = false;
        public boolean j0 = false;
        public boolean k0 = true;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(i.F3, 24);
            a.append(i.G3, 25);
            a.append(i.I3, 28);
            a.append(i.J3, 29);
            a.append(i.O3, 35);
            a.append(i.N3, 34);
            a.append(i.q3, 4);
            a.append(i.p3, 3);
            a.append(i.n3, 1);
            a.append(i.T3, 6);
            a.append(i.U3, 7);
            a.append(i.x3, 17);
            a.append(i.y3, 18);
            a.append(i.z3, 19);
            a.append(i.Y2, 26);
            a.append(i.K3, 31);
            a.append(i.L3, 32);
            a.append(i.w3, 10);
            a.append(i.v3, 9);
            a.append(i.X3, 13);
            a.append(i.a4, 16);
            a.append(i.Y3, 14);
            a.append(i.V3, 11);
            a.append(i.Z3, 15);
            a.append(i.W3, 12);
            a.append(i.R3, 38);
            a.append(i.D3, 37);
            a.append(i.C3, 39);
            a.append(i.Q3, 40);
            a.append(i.B3, 20);
            a.append(i.P3, 36);
            a.append(i.u3, 5);
            a.append(i.E3, 76);
            a.append(i.M3, 76);
            a.append(i.H3, 76);
            a.append(i.o3, 76);
            a.append(i.m3, 76);
            a.append(i.b3, 23);
            a.append(i.d3, 27);
            a.append(i.f3, 30);
            a.append(i.g3, 8);
            a.append(i.c3, 33);
            a.append(i.e3, 2);
            a.append(i.Z2, 22);
            a.append(i.a3, 21);
            a.append(i.r3, 61);
            a.append(i.t3, 62);
            a.append(i.s3, 63);
            a.append(i.S3, 69);
            a.append(i.A3, 70);
            a.append(i.k3, 71);
            a.append(i.i3, 72);
            a.append(i.j3, 73);
            a.append(i.l3, 74);
            a.append(i.h3, 75);
        }

        public void a(b bVar) {
            this.f767b = bVar.f767b;
            this.f769d = bVar.f769d;
            this.f768c = bVar.f768c;
            this.f770e = bVar.f770e;
            this.f771f = bVar.f771f;
            this.f772g = bVar.f772g;
            this.f773h = bVar.f773h;
            this.f774i = bVar.f774i;
            this.f775j = bVar.f775j;
            this.f776k = bVar.f776k;
            this.l = bVar.l;
            this.m = bVar.m;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
            this.q = bVar.q;
            this.r = bVar.r;
            this.s = bVar.s;
            this.t = bVar.t;
            this.u = bVar.u;
            this.v = bVar.v;
            this.w = bVar.w;
            this.x = bVar.x;
            this.y = bVar.y;
            this.z = bVar.z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
            this.G = bVar.G;
            this.H = bVar.H;
            this.I = bVar.I;
            this.J = bVar.J;
            this.K = bVar.K;
            this.L = bVar.L;
            this.M = bVar.M;
            this.N = bVar.N;
            this.O = bVar.O;
            this.P = bVar.P;
            this.Q = bVar.Q;
            this.R = bVar.R;
            this.S = bVar.S;
            this.T = bVar.T;
            this.U = bVar.U;
            this.V = bVar.V;
            this.W = bVar.W;
            this.X = bVar.X;
            this.Y = bVar.Y;
            this.Z = bVar.Z;
            this.a0 = bVar.a0;
            this.b0 = bVar.b0;
            this.c0 = bVar.c0;
            this.d0 = bVar.d0;
            this.e0 = bVar.e0;
            this.h0 = bVar.h0;
            int[] iArr = bVar.f0;
            if (iArr != null) {
                this.f0 = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.f0 = null;
            }
            this.g0 = bVar.g0;
            this.i0 = bVar.i0;
            this.j0 = bVar.j0;
            this.k0 = bVar.k0;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.X2);
            this.f768c = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                int i3 = a.get(index);
                if (i3 == 80) {
                    this.i0 = typedArrayObtainStyledAttributes.getBoolean(index, this.i0);
                } else if (i3 != 81) {
                    switch (i3) {
                        case 1:
                            this.q = d.n(typedArrayObtainStyledAttributes, index, this.q);
                            break;
                        case 2:
                            this.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.H);
                            break;
                        case 3:
                            this.p = d.n(typedArrayObtainStyledAttributes, index, this.p);
                            break;
                        case 4:
                            this.o = d.n(typedArrayObtainStyledAttributes, index, this.o);
                            break;
                        case 5:
                            this.x = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 6:
                            this.B = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.B);
                            break;
                        case 7:
                            this.C = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.C);
                            break;
                        case 8:
                            if (Build.VERSION.SDK_INT >= 17) {
                                this.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.I);
                            }
                            break;
                        case 9:
                            this.u = d.n(typedArrayObtainStyledAttributes, index, this.u);
                            break;
                        case 10:
                            this.t = d.n(typedArrayObtainStyledAttributes, index, this.t);
                            break;
                        case 11:
                            this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        case 12:
                            this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            break;
                        case 13:
                            this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        case 14:
                            this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        case 15:
                            this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.P);
                            break;
                        case 16:
                            this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        case 17:
                            this.f771f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f771f);
                            break;
                        case 18:
                            this.f772g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f772g);
                            break;
                        case 19:
                            this.f773h = typedArrayObtainStyledAttributes.getFloat(index, this.f773h);
                            break;
                        case 20:
                            this.v = typedArrayObtainStyledAttributes.getFloat(index, this.v);
                            break;
                        case 21:
                            this.f770e = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f770e);
                            break;
                        case 22:
                            this.f769d = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f769d);
                            break;
                        case 23:
                            this.E = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.E);
                            break;
                        case 24:
                            this.f774i = d.n(typedArrayObtainStyledAttributes, index, this.f774i);
                            break;
                        case 25:
                            this.f775j = d.n(typedArrayObtainStyledAttributes, index, this.f775j);
                            break;
                        case 26:
                            this.D = typedArrayObtainStyledAttributes.getInt(index, this.D);
                            break;
                        case 27:
                            this.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.F);
                            break;
                        case 28:
                            this.f776k = d.n(typedArrayObtainStyledAttributes, index, this.f776k);
                            break;
                        case 29:
                            this.l = d.n(typedArrayObtainStyledAttributes, index, this.l);
                            break;
                        case 30:
                            if (Build.VERSION.SDK_INT >= 17) {
                                this.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            }
                            break;
                        case 31:
                            this.r = d.n(typedArrayObtainStyledAttributes, index, this.r);
                            break;
                        case 32:
                            this.s = d.n(typedArrayObtainStyledAttributes, index, this.s);
                            break;
                        case 33:
                            this.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.G);
                            break;
                        case 34:
                            this.n = d.n(typedArrayObtainStyledAttributes, index, this.n);
                            break;
                        case 35:
                            this.m = d.n(typedArrayObtainStyledAttributes, index, this.m);
                            break;
                        case 36:
                            this.w = typedArrayObtainStyledAttributes.getFloat(index, this.w);
                            break;
                        case 37:
                            this.R = typedArrayObtainStyledAttributes.getFloat(index, this.R);
                            break;
                        case 38:
                            this.Q = typedArrayObtainStyledAttributes.getFloat(index, this.Q);
                            break;
                        case 39:
                            this.S = typedArrayObtainStyledAttributes.getInt(index, this.S);
                            break;
                        case 40:
                            this.T = typedArrayObtainStyledAttributes.getInt(index, this.T);
                            break;
                        default:
                            switch (i3) {
                                case 54:
                                    this.U = typedArrayObtainStyledAttributes.getInt(index, this.U);
                                    break;
                                case 55:
                                    this.V = typedArrayObtainStyledAttributes.getInt(index, this.V);
                                    break;
                                case 56:
                                    this.W = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.W);
                                    break;
                                case 57:
                                    this.X = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.X);
                                    break;
                                case 58:
                                    this.Y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Y);
                                    break;
                                case 59:
                                    this.Z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Z);
                                    break;
                                default:
                                    switch (i3) {
                                        case 61:
                                            this.y = d.n(typedArrayObtainStyledAttributes, index, this.y);
                                            break;
                                        case 62:
                                            this.z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.z);
                                            break;
                                        case 63:
                                            this.A = typedArrayObtainStyledAttributes.getFloat(index, this.A);
                                            break;
                                        default:
                                            switch (i3) {
                                                case 69:
                                                    this.a0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 70:
                                                    this.b0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 71:
                                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                    break;
                                                case 72:
                                                    this.c0 = typedArrayObtainStyledAttributes.getInt(index, this.c0);
                                                    break;
                                                case 73:
                                                    this.d0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.d0);
                                                    break;
                                                case 74:
                                                    this.g0 = typedArrayObtainStyledAttributes.getString(index);
                                                    break;
                                                case 75:
                                                    this.k0 = typedArrayObtainStyledAttributes.getBoolean(index, this.k0);
                                                    break;
                                                case 76:
                                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + a.get(index));
                                                    break;
                                                case 77:
                                                    this.h0 = typedArrayObtainStyledAttributes.getString(index);
                                                    break;
                                                default:
                                                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + a.get(index));
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                } else {
                    this.j0 = typedArrayObtainStyledAttributes.getBoolean(index, this.j0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class c {
        private static SparseIntArray a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f777b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f778c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f779d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f780e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f781f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f782g = Float.NaN;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f783h = Float.NaN;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(i.l4, 1);
            a.append(i.n4, 2);
            a.append(i.o4, 3);
            a.append(i.k4, 4);
            a.append(i.j4, 5);
            a.append(i.m4, 6);
        }

        public void a(c cVar) {
            this.f777b = cVar.f777b;
            this.f778c = cVar.f778c;
            this.f779d = cVar.f779d;
            this.f780e = cVar.f780e;
            this.f781f = cVar.f781f;
            this.f783h = cVar.f783h;
            this.f782g = cVar.f782g;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.i4);
            this.f777b = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                switch (a.get(index)) {
                    case 1:
                        this.f783h = typedArrayObtainStyledAttributes.getFloat(index, this.f783h);
                        break;
                    case 2:
                        this.f780e = typedArrayObtainStyledAttributes.getInt(index, this.f780e);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            this.f779d = typedArrayObtainStyledAttributes.getString(index);
                        } else {
                            this.f779d = c.g.a.a.a.f2976b[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        }
                        break;
                    case 4:
                        this.f781f = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f778c = d.n(typedArrayObtainStyledAttributes, index, this.f778c);
                        break;
                    case 6:
                        this.f782g = typedArrayObtainStyledAttributes.getFloat(index, this.f782g);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class C0015d {
        public boolean a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f784b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f785c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f786d = 1.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f787e = Float.NaN;

        public void a(C0015d c0015d) {
            this.a = c0015d.a;
            this.f784b = c0015d.f784b;
            this.f786d = c0015d.f786d;
            this.f787e = c0015d.f787e;
            this.f785c = c0015d.f785c;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.x4);
            this.a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == i.z4) {
                    this.f786d = typedArrayObtainStyledAttributes.getFloat(index, this.f786d);
                } else if (index == i.y4) {
                    this.f784b = typedArrayObtainStyledAttributes.getInt(index, this.f784b);
                    this.f784b = d.a[this.f784b];
                } else if (index == i.B4) {
                    this.f785c = typedArrayObtainStyledAttributes.getInt(index, this.f785c);
                } else if (index == i.A4) {
                    this.f787e = typedArrayObtainStyledAttributes.getFloat(index, this.f787e);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class e {
        private static SparseIntArray a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f788b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f789c = 0.0f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f790d = 0.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f791e = 0.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f792f = 1.0f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f793g = 1.0f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f794h = Float.NaN;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f795i = Float.NaN;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f796j = 0.0f;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f797k = 0.0f;
        public float l = 0.0f;
        public boolean m = false;
        public float n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(i.V4, 1);
            a.append(i.W4, 2);
            a.append(i.X4, 3);
            a.append(i.T4, 4);
            a.append(i.U4, 5);
            a.append(i.P4, 6);
            a.append(i.Q4, 7);
            a.append(i.R4, 8);
            a.append(i.S4, 9);
            a.append(i.Y4, 10);
            a.append(i.Z4, 11);
        }

        public void a(e eVar) {
            this.f788b = eVar.f788b;
            this.f789c = eVar.f789c;
            this.f790d = eVar.f790d;
            this.f791e = eVar.f791e;
            this.f792f = eVar.f792f;
            this.f793g = eVar.f793g;
            this.f794h = eVar.f794h;
            this.f795i = eVar.f795i;
            this.f796j = eVar.f796j;
            this.f797k = eVar.f797k;
            this.l = eVar.l;
            this.m = eVar.m;
            this.n = eVar.n;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.O4);
            this.f788b = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                switch (a.get(index)) {
                    case 1:
                        this.f789c = typedArrayObtainStyledAttributes.getFloat(index, this.f789c);
                        break;
                    case 2:
                        this.f790d = typedArrayObtainStyledAttributes.getFloat(index, this.f790d);
                        break;
                    case 3:
                        this.f791e = typedArrayObtainStyledAttributes.getFloat(index, this.f791e);
                        break;
                    case 4:
                        this.f792f = typedArrayObtainStyledAttributes.getFloat(index, this.f792f);
                        break;
                    case 5:
                        this.f793g = typedArrayObtainStyledAttributes.getFloat(index, this.f793g);
                        break;
                    case 6:
                        this.f794h = typedArrayObtainStyledAttributes.getDimension(index, this.f794h);
                        break;
                    case 7:
                        this.f795i = typedArrayObtainStyledAttributes.getDimension(index, this.f795i);
                        break;
                    case 8:
                        this.f796j = typedArrayObtainStyledAttributes.getDimension(index, this.f796j);
                        break;
                    case 9:
                        this.f797k = typedArrayObtainStyledAttributes.getDimension(index, this.f797k);
                        break;
                    case 10:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.l = typedArrayObtainStyledAttributes.getDimension(index, this.l);
                        }
                        break;
                    case 11:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.m = true;
                            this.n = typedArrayObtainStyledAttributes.getDimension(index, this.n);
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f758b = sparseIntArray;
        sparseIntArray.append(i.u0, 25);
        f758b.append(i.v0, 26);
        f758b.append(i.x0, 29);
        f758b.append(i.y0, 30);
        f758b.append(i.E0, 36);
        f758b.append(i.D0, 35);
        f758b.append(i.c0, 4);
        f758b.append(i.b0, 3);
        f758b.append(i.Z, 1);
        f758b.append(i.M0, 6);
        f758b.append(i.N0, 7);
        f758b.append(i.j0, 17);
        f758b.append(i.k0, 18);
        f758b.append(i.l0, 19);
        f758b.append(i.s, 27);
        f758b.append(i.z0, 32);
        f758b.append(i.A0, 33);
        f758b.append(i.i0, 10);
        f758b.append(i.h0, 9);
        f758b.append(i.Q0, 13);
        f758b.append(i.T0, 16);
        f758b.append(i.R0, 14);
        f758b.append(i.O0, 11);
        f758b.append(i.S0, 15);
        f758b.append(i.P0, 12);
        f758b.append(i.H0, 40);
        f758b.append(i.s0, 39);
        f758b.append(i.r0, 41);
        f758b.append(i.G0, 42);
        f758b.append(i.q0, 20);
        f758b.append(i.F0, 37);
        f758b.append(i.g0, 5);
        f758b.append(i.t0, 82);
        f758b.append(i.C0, 82);
        f758b.append(i.w0, 82);
        f758b.append(i.a0, 82);
        f758b.append(i.Y, 82);
        f758b.append(i.x, 24);
        f758b.append(i.z, 28);
        f758b.append(i.L, 31);
        f758b.append(i.M, 8);
        f758b.append(i.y, 34);
        f758b.append(i.A, 2);
        f758b.append(i.v, 23);
        f758b.append(i.w, 21);
        f758b.append(i.u, 22);
        f758b.append(i.B, 43);
        f758b.append(i.O, 44);
        f758b.append(i.J, 45);
        f758b.append(i.K, 46);
        f758b.append(i.I, 60);
        f758b.append(i.G, 47);
        f758b.append(i.H, 48);
        f758b.append(i.C, 49);
        f758b.append(i.D, 50);
        f758b.append(i.E, 51);
        f758b.append(i.F, 52);
        f758b.append(i.N, 53);
        f758b.append(i.I0, 54);
        f758b.append(i.m0, 55);
        f758b.append(i.J0, 56);
        f758b.append(i.n0, 57);
        f758b.append(i.K0, 58);
        f758b.append(i.o0, 59);
        f758b.append(i.d0, 61);
        f758b.append(i.f0, 62);
        f758b.append(i.e0, 63);
        f758b.append(i.P, 64);
        f758b.append(i.X0, 65);
        f758b.append(i.V, 66);
        f758b.append(i.Y0, 67);
        f758b.append(i.V0, 79);
        f758b.append(i.t, 38);
        f758b.append(i.U0, 68);
        f758b.append(i.L0, 69);
        f758b.append(i.p0, 70);
        f758b.append(i.T, 71);
        f758b.append(i.R, 72);
        f758b.append(i.S, 73);
        f758b.append(i.U, 74);
        f758b.append(i.Q, 75);
        f758b.append(i.W0, 76);
        f758b.append(i.B0, 77);
        f758b.append(i.Z0, 78);
        f758b.append(i.X, 80);
        f758b.append(i.W, 81);
    }

    private int[] i(View view, String str) {
        int iIntValue;
        Object objF;
        String[] strArrSplit = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < strArrSplit.length) {
            String strTrim = strArrSplit[i2].trim();
            try {
                iIntValue = h.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, DeepLinkIntentReceiver.DeepLinksKeys.ID, context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (objF = ((ConstraintLayout) view.getParent()).f(0, strTrim)) != null && (objF instanceof Integer)) {
                iIntValue = ((Integer) objF).intValue();
            }
            iArr[i3] = iIntValue;
            i2++;
            i3++;
        }
        return i3 != strArrSplit.length ? Arrays.copyOf(iArr, i3) : iArr;
    }

    private a j(Context context, AttributeSet attributeSet) {
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.r);
        o(context, aVar, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    private a k(int i2) {
        if (!this.f761e.containsKey(Integer.valueOf(i2))) {
            this.f761e.put(Integer.valueOf(i2), new a());
        }
        return this.f761e.get(Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int n(TypedArray typedArray, int i2, int i3) {
        int resourceId = typedArray.getResourceId(i2, i3);
        return resourceId == -1 ? typedArray.getInt(i2, -1) : resourceId;
    }

    private void o(Context context, a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            if (index != i.t && i.L != index && i.M != index) {
                aVar.f763c.f777b = true;
                aVar.f764d.f768c = true;
                aVar.f762b.a = true;
                aVar.f765e.f788b = true;
            }
            switch (f758b.get(index)) {
                case 1:
                    b bVar = aVar.f764d;
                    bVar.q = n(typedArray, index, bVar.q);
                    break;
                case 2:
                    b bVar2 = aVar.f764d;
                    bVar2.H = typedArray.getDimensionPixelSize(index, bVar2.H);
                    break;
                case 3:
                    b bVar3 = aVar.f764d;
                    bVar3.p = n(typedArray, index, bVar3.p);
                    break;
                case 4:
                    b bVar4 = aVar.f764d;
                    bVar4.o = n(typedArray, index, bVar4.o);
                    break;
                case 5:
                    aVar.f764d.x = typedArray.getString(index);
                    break;
                case 6:
                    b bVar5 = aVar.f764d;
                    bVar5.B = typedArray.getDimensionPixelOffset(index, bVar5.B);
                    break;
                case 7:
                    b bVar6 = aVar.f764d;
                    bVar6.C = typedArray.getDimensionPixelOffset(index, bVar6.C);
                    break;
                case 8:
                    if (Build.VERSION.SDK_INT >= 17) {
                        b bVar7 = aVar.f764d;
                        bVar7.I = typedArray.getDimensionPixelSize(index, bVar7.I);
                    }
                    break;
                case 9:
                    b bVar8 = aVar.f764d;
                    bVar8.u = n(typedArray, index, bVar8.u);
                    break;
                case 10:
                    b bVar9 = aVar.f764d;
                    bVar9.t = n(typedArray, index, bVar9.t);
                    break;
                case 11:
                    b bVar10 = aVar.f764d;
                    bVar10.N = typedArray.getDimensionPixelSize(index, bVar10.N);
                    break;
                case 12:
                    b bVar11 = aVar.f764d;
                    bVar11.O = typedArray.getDimensionPixelSize(index, bVar11.O);
                    break;
                case 13:
                    b bVar12 = aVar.f764d;
                    bVar12.K = typedArray.getDimensionPixelSize(index, bVar12.K);
                    break;
                case 14:
                    b bVar13 = aVar.f764d;
                    bVar13.M = typedArray.getDimensionPixelSize(index, bVar13.M);
                    break;
                case 15:
                    b bVar14 = aVar.f764d;
                    bVar14.P = typedArray.getDimensionPixelSize(index, bVar14.P);
                    break;
                case 16:
                    b bVar15 = aVar.f764d;
                    bVar15.L = typedArray.getDimensionPixelSize(index, bVar15.L);
                    break;
                case 17:
                    b bVar16 = aVar.f764d;
                    bVar16.f771f = typedArray.getDimensionPixelOffset(index, bVar16.f771f);
                    break;
                case 18:
                    b bVar17 = aVar.f764d;
                    bVar17.f772g = typedArray.getDimensionPixelOffset(index, bVar17.f772g);
                    break;
                case 19:
                    b bVar18 = aVar.f764d;
                    bVar18.f773h = typedArray.getFloat(index, bVar18.f773h);
                    break;
                case 20:
                    b bVar19 = aVar.f764d;
                    bVar19.v = typedArray.getFloat(index, bVar19.v);
                    break;
                case 21:
                    b bVar20 = aVar.f764d;
                    bVar20.f770e = typedArray.getLayoutDimension(index, bVar20.f770e);
                    break;
                case 22:
                    C0015d c0015d = aVar.f762b;
                    c0015d.f784b = typedArray.getInt(index, c0015d.f784b);
                    C0015d c0015d2 = aVar.f762b;
                    c0015d2.f784b = a[c0015d2.f784b];
                    break;
                case 23:
                    b bVar21 = aVar.f764d;
                    bVar21.f769d = typedArray.getLayoutDimension(index, bVar21.f769d);
                    break;
                case 24:
                    b bVar22 = aVar.f764d;
                    bVar22.E = typedArray.getDimensionPixelSize(index, bVar22.E);
                    break;
                case 25:
                    b bVar23 = aVar.f764d;
                    bVar23.f774i = n(typedArray, index, bVar23.f774i);
                    break;
                case 26:
                    b bVar24 = aVar.f764d;
                    bVar24.f775j = n(typedArray, index, bVar24.f775j);
                    break;
                case 27:
                    b bVar25 = aVar.f764d;
                    bVar25.D = typedArray.getInt(index, bVar25.D);
                    break;
                case 28:
                    b bVar26 = aVar.f764d;
                    bVar26.F = typedArray.getDimensionPixelSize(index, bVar26.F);
                    break;
                case 29:
                    b bVar27 = aVar.f764d;
                    bVar27.f776k = n(typedArray, index, bVar27.f776k);
                    break;
                case 30:
                    b bVar28 = aVar.f764d;
                    bVar28.l = n(typedArray, index, bVar28.l);
                    break;
                case 31:
                    if (Build.VERSION.SDK_INT >= 17) {
                        b bVar29 = aVar.f764d;
                        bVar29.J = typedArray.getDimensionPixelSize(index, bVar29.J);
                    }
                    break;
                case 32:
                    b bVar30 = aVar.f764d;
                    bVar30.r = n(typedArray, index, bVar30.r);
                    break;
                case 33:
                    b bVar31 = aVar.f764d;
                    bVar31.s = n(typedArray, index, bVar31.s);
                    break;
                case 34:
                    b bVar32 = aVar.f764d;
                    bVar32.G = typedArray.getDimensionPixelSize(index, bVar32.G);
                    break;
                case 35:
                    b bVar33 = aVar.f764d;
                    bVar33.n = n(typedArray, index, bVar33.n);
                    break;
                case 36:
                    b bVar34 = aVar.f764d;
                    bVar34.m = n(typedArray, index, bVar34.m);
                    break;
                case 37:
                    b bVar35 = aVar.f764d;
                    bVar35.w = typedArray.getFloat(index, bVar35.w);
                    break;
                case 38:
                    aVar.a = typedArray.getResourceId(index, aVar.a);
                    break;
                case 39:
                    b bVar36 = aVar.f764d;
                    bVar36.R = typedArray.getFloat(index, bVar36.R);
                    break;
                case 40:
                    b bVar37 = aVar.f764d;
                    bVar37.Q = typedArray.getFloat(index, bVar37.Q);
                    break;
                case 41:
                    b bVar38 = aVar.f764d;
                    bVar38.S = typedArray.getInt(index, bVar38.S);
                    break;
                case 42:
                    b bVar39 = aVar.f764d;
                    bVar39.T = typedArray.getInt(index, bVar39.T);
                    break;
                case 43:
                    C0015d c0015d3 = aVar.f762b;
                    c0015d3.f786d = typedArray.getFloat(index, c0015d3.f786d);
                    break;
                case 44:
                    if (Build.VERSION.SDK_INT >= 21) {
                        e eVar = aVar.f765e;
                        eVar.m = true;
                        eVar.n = typedArray.getDimension(index, eVar.n);
                    }
                    break;
                case 45:
                    e eVar2 = aVar.f765e;
                    eVar2.f790d = typedArray.getFloat(index, eVar2.f790d);
                    break;
                case 46:
                    e eVar3 = aVar.f765e;
                    eVar3.f791e = typedArray.getFloat(index, eVar3.f791e);
                    break;
                case 47:
                    e eVar4 = aVar.f765e;
                    eVar4.f792f = typedArray.getFloat(index, eVar4.f792f);
                    break;
                case 48:
                    e eVar5 = aVar.f765e;
                    eVar5.f793g = typedArray.getFloat(index, eVar5.f793g);
                    break;
                case 49:
                    e eVar6 = aVar.f765e;
                    eVar6.f794h = typedArray.getDimension(index, eVar6.f794h);
                    break;
                case 50:
                    e eVar7 = aVar.f765e;
                    eVar7.f795i = typedArray.getDimension(index, eVar7.f795i);
                    break;
                case 51:
                    e eVar8 = aVar.f765e;
                    eVar8.f796j = typedArray.getDimension(index, eVar8.f796j);
                    break;
                case 52:
                    e eVar9 = aVar.f765e;
                    eVar9.f797k = typedArray.getDimension(index, eVar9.f797k);
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT >= 21) {
                        e eVar10 = aVar.f765e;
                        eVar10.l = typedArray.getDimension(index, eVar10.l);
                    }
                    break;
                case 54:
                    b bVar40 = aVar.f764d;
                    bVar40.U = typedArray.getInt(index, bVar40.U);
                    break;
                case 55:
                    b bVar41 = aVar.f764d;
                    bVar41.V = typedArray.getInt(index, bVar41.V);
                    break;
                case 56:
                    b bVar42 = aVar.f764d;
                    bVar42.W = typedArray.getDimensionPixelSize(index, bVar42.W);
                    break;
                case 57:
                    b bVar43 = aVar.f764d;
                    bVar43.X = typedArray.getDimensionPixelSize(index, bVar43.X);
                    break;
                case 58:
                    b bVar44 = aVar.f764d;
                    bVar44.Y = typedArray.getDimensionPixelSize(index, bVar44.Y);
                    break;
                case 59:
                    b bVar45 = aVar.f764d;
                    bVar45.Z = typedArray.getDimensionPixelSize(index, bVar45.Z);
                    break;
                case 60:
                    e eVar11 = aVar.f765e;
                    eVar11.f789c = typedArray.getFloat(index, eVar11.f789c);
                    break;
                case 61:
                    b bVar46 = aVar.f764d;
                    bVar46.y = n(typedArray, index, bVar46.y);
                    break;
                case 62:
                    b bVar47 = aVar.f764d;
                    bVar47.z = typedArray.getDimensionPixelSize(index, bVar47.z);
                    break;
                case 63:
                    b bVar48 = aVar.f764d;
                    bVar48.A = typedArray.getFloat(index, bVar48.A);
                    break;
                case 64:
                    c cVar = aVar.f763c;
                    cVar.f778c = n(typedArray, index, cVar.f778c);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        aVar.f763c.f779d = typedArray.getString(index);
                    } else {
                        aVar.f763c.f779d = c.g.a.a.a.f2976b[typedArray.getInteger(index, 0)];
                    }
                    break;
                case 66:
                    aVar.f763c.f781f = typedArray.getInt(index, 0);
                    break;
                case 67:
                    c cVar2 = aVar.f763c;
                    cVar2.f783h = typedArray.getFloat(index, cVar2.f783h);
                    break;
                case 68:
                    C0015d c0015d4 = aVar.f762b;
                    c0015d4.f787e = typedArray.getFloat(index, c0015d4.f787e);
                    break;
                case 69:
                    aVar.f764d.a0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.f764d.b0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    b bVar49 = aVar.f764d;
                    bVar49.c0 = typedArray.getInt(index, bVar49.c0);
                    break;
                case 73:
                    b bVar50 = aVar.f764d;
                    bVar50.d0 = typedArray.getDimensionPixelSize(index, bVar50.d0);
                    break;
                case 74:
                    aVar.f764d.g0 = typedArray.getString(index);
                    break;
                case 75:
                    b bVar51 = aVar.f764d;
                    bVar51.k0 = typedArray.getBoolean(index, bVar51.k0);
                    break;
                case 76:
                    c cVar3 = aVar.f763c;
                    cVar3.f780e = typedArray.getInt(index, cVar3.f780e);
                    break;
                case 77:
                    aVar.f764d.h0 = typedArray.getString(index);
                    break;
                case 78:
                    C0015d c0015d5 = aVar.f762b;
                    c0015d5.f785c = typedArray.getInt(index, c0015d5.f785c);
                    break;
                case 79:
                    c cVar4 = aVar.f763c;
                    cVar4.f782g = typedArray.getFloat(index, cVar4.f782g);
                    break;
                case 80:
                    b bVar52 = aVar.f764d;
                    bVar52.i0 = typedArray.getBoolean(index, bVar52.i0);
                    break;
                case 81:
                    b bVar53 = aVar.f764d;
                    bVar53.j0 = typedArray.getBoolean(index, bVar53.j0);
                    break;
                case 82:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f758b.get(index));
                    break;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f758b.get(index));
                    break;
            }
        }
    }

    private String q(int i2) {
        switch (i2) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public void c(ConstraintLayout constraintLayout) {
        d(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    void d(ConstraintLayout constraintLayout, boolean z) {
        int childCount = constraintLayout.getChildCount();
        HashSet<Integer> hashSet = new HashSet(this.f761e.keySet());
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (!this.f761e.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + c.g.a.b.a.a(childAt));
            } else {
                if (this.f760d && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (this.f761e.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        a aVar = this.f761e.get(Integer.valueOf(id));
                        if (childAt instanceof Barrier) {
                            aVar.f764d.e0 = 1;
                        }
                        int i3 = aVar.f764d.e0;
                        if (i3 != -1 && i3 == 1) {
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            barrier.setType(aVar.f764d.c0);
                            barrier.setMargin(aVar.f764d.d0);
                            barrier.setAllowsGoneWidget(aVar.f764d.k0);
                            b bVar = aVar.f764d;
                            int[] iArr = bVar.f0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = bVar.g0;
                                if (str != null) {
                                    bVar.f0 = i(barrier, str);
                                    barrier.setReferencedIds(aVar.f764d.f0);
                                }
                            }
                        }
                        ConstraintLayout.b bVar2 = (ConstraintLayout.b) childAt.getLayoutParams();
                        bVar2.a();
                        aVar.d(bVar2);
                        if (z) {
                            androidx.constraintlayout.widget.a.c(childAt, aVar.f766f);
                        }
                        childAt.setLayoutParams(bVar2);
                        C0015d c0015d = aVar.f762b;
                        if (c0015d.f785c == 0) {
                            childAt.setVisibility(c0015d.f784b);
                        }
                        int i4 = Build.VERSION.SDK_INT;
                        if (i4 >= 17) {
                            childAt.setAlpha(aVar.f762b.f786d);
                            childAt.setRotation(aVar.f765e.f789c);
                            childAt.setRotationX(aVar.f765e.f790d);
                            childAt.setRotationY(aVar.f765e.f791e);
                            childAt.setScaleX(aVar.f765e.f792f);
                            childAt.setScaleY(aVar.f765e.f793g);
                            if (!Float.isNaN(aVar.f765e.f794h)) {
                                childAt.setPivotX(aVar.f765e.f794h);
                            }
                            if (!Float.isNaN(aVar.f765e.f795i)) {
                                childAt.setPivotY(aVar.f765e.f795i);
                            }
                            childAt.setTranslationX(aVar.f765e.f796j);
                            childAt.setTranslationY(aVar.f765e.f797k);
                            if (i4 >= 21) {
                                childAt.setTranslationZ(aVar.f765e.l);
                                e eVar = aVar.f765e;
                                if (eVar.m) {
                                    childAt.setElevation(eVar.n);
                                }
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        for (Integer num : hashSet) {
            a aVar2 = this.f761e.get(num);
            int i5 = aVar2.f764d.e0;
            if (i5 != -1 && i5 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                b bVar3 = aVar2.f764d;
                int[] iArr2 = bVar3.f0;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = bVar3.g0;
                    if (str2 != null) {
                        bVar3.f0 = i(barrier2, str2);
                        barrier2.setReferencedIds(aVar2.f764d.f0);
                    }
                }
                barrier2.setType(aVar2.f764d.c0);
                barrier2.setMargin(aVar2.f764d.d0);
                ConstraintLayout.b bVarD = constraintLayout.generateDefaultLayoutParams();
                barrier2.n();
                aVar2.d(bVarD);
                constraintLayout.addView(barrier2, bVarD);
            }
            if (aVar2.f764d.f767b) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.b bVarD2 = constraintLayout.generateDefaultLayoutParams();
                aVar2.d(bVarD2);
                constraintLayout.addView(guideline, bVarD2);
            }
        }
    }

    public void e(Context context, int i2) {
        f((ConstraintLayout) LayoutInflater.from(context).inflate(i2, (ViewGroup) null));
    }

    public void f(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f761e.clear();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f760d && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f761e.containsKey(Integer.valueOf(id))) {
                this.f761e.put(Integer.valueOf(id), new a());
            }
            a aVar = this.f761e.get(Integer.valueOf(id));
            aVar.f766f = androidx.constraintlayout.widget.a.a(this.f759c, childAt);
            aVar.f(id, bVar);
            aVar.f762b.f784b = childAt.getVisibility();
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 17) {
                aVar.f762b.f786d = childAt.getAlpha();
                aVar.f765e.f789c = childAt.getRotation();
                aVar.f765e.f790d = childAt.getRotationX();
                aVar.f765e.f791e = childAt.getRotationY();
                aVar.f765e.f792f = childAt.getScaleX();
                aVar.f765e.f793g = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    e eVar = aVar.f765e;
                    eVar.f794h = pivotX;
                    eVar.f795i = pivotY;
                }
                aVar.f765e.f796j = childAt.getTranslationX();
                aVar.f765e.f797k = childAt.getTranslationY();
                if (i3 >= 21) {
                    aVar.f765e.l = childAt.getTranslationZ();
                    e eVar2 = aVar.f765e;
                    if (eVar2.m) {
                        eVar2.n = childAt.getElevation();
                    }
                }
            }
            if (childAt instanceof Barrier) {
                Barrier barrier = (Barrier) childAt;
                aVar.f764d.k0 = barrier.o();
                aVar.f764d.f0 = barrier.getReferencedIds();
                aVar.f764d.c0 = barrier.getType();
                aVar.f764d.d0 = barrier.getMargin();
            }
        }
    }

    public void g(androidx.constraintlayout.widget.e eVar) {
        int childCount = eVar.getChildCount();
        this.f761e.clear();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = eVar.getChildAt(i2);
            androidx.constraintlayout.widget.e.a aVar = (androidx.constraintlayout.widget.e.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f760d && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f761e.containsKey(Integer.valueOf(id))) {
                this.f761e.put(Integer.valueOf(id), new a());
            }
            a aVar2 = this.f761e.get(Integer.valueOf(id));
            if (childAt instanceof androidx.constraintlayout.widget.b) {
                aVar2.h((androidx.constraintlayout.widget.b) childAt, id, aVar);
            }
            aVar2.g(id, aVar);
        }
    }

    public void h(int i2, int i3, int i4, int i5) {
        if (!this.f761e.containsKey(Integer.valueOf(i2))) {
            this.f761e.put(Integer.valueOf(i2), new a());
        }
        a aVar = this.f761e.get(Integer.valueOf(i2));
        switch (i3) {
            case 1:
                if (i5 == 1) {
                    b bVar = aVar.f764d;
                    bVar.f774i = i4;
                    bVar.f775j = -1;
                    return;
                } else if (i5 == 2) {
                    b bVar2 = aVar.f764d;
                    bVar2.f775j = i4;
                    bVar2.f774i = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + q(i5) + " undefined");
                }
            case 2:
                if (i5 == 1) {
                    b bVar3 = aVar.f764d;
                    bVar3.f776k = i4;
                    bVar3.l = -1;
                    return;
                } else if (i5 == 2) {
                    b bVar4 = aVar.f764d;
                    bVar4.l = i4;
                    bVar4.f776k = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + q(i5) + " undefined");
                }
            case 3:
                if (i5 == 3) {
                    b bVar5 = aVar.f764d;
                    bVar5.m = i4;
                    bVar5.n = -1;
                    bVar5.q = -1;
                    return;
                }
                if (i5 == 4) {
                    b bVar6 = aVar.f764d;
                    bVar6.n = i4;
                    bVar6.m = -1;
                    bVar6.q = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + q(i5) + " undefined");
            case 4:
                if (i5 == 4) {
                    b bVar7 = aVar.f764d;
                    bVar7.p = i4;
                    bVar7.o = -1;
                    bVar7.q = -1;
                    return;
                }
                if (i5 == 3) {
                    b bVar8 = aVar.f764d;
                    bVar8.o = i4;
                    bVar8.p = -1;
                    bVar8.q = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + q(i5) + " undefined");
            case 5:
                if (i5 != 5) {
                    throw new IllegalArgumentException("right to " + q(i5) + " undefined");
                }
                b bVar9 = aVar.f764d;
                bVar9.q = i4;
                bVar9.p = -1;
                bVar9.o = -1;
                bVar9.m = -1;
                bVar9.n = -1;
                return;
            case 6:
                if (i5 == 6) {
                    b bVar10 = aVar.f764d;
                    bVar10.s = i4;
                    bVar10.r = -1;
                    return;
                } else if (i5 == 7) {
                    b bVar11 = aVar.f764d;
                    bVar11.r = i4;
                    bVar11.s = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + q(i5) + " undefined");
                }
            case 7:
                if (i5 == 7) {
                    b bVar12 = aVar.f764d;
                    bVar12.u = i4;
                    bVar12.t = -1;
                    return;
                } else if (i5 == 6) {
                    b bVar13 = aVar.f764d;
                    bVar13.t = i4;
                    bVar13.u = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + q(i5) + " undefined");
                }
            default:
                throw new IllegalArgumentException(q(i3) + " to " + q(i5) + " unknown");
        }
    }

    public void l(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a aVarJ = j(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        aVarJ.f764d.f767b = true;
                    }
                    this.f761e.put(Integer.valueOf(aVarJ.a), aVarJ);
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0090  */
    public void m(Context context, XmlPullParser xmlPullParser) {
        a aVarJ;
        try {
            int eventType = xmlPullParser.getEventType();
            a aVar = null;
            while (eventType != 1) {
                if (eventType != 0) {
                    if (eventType == 2) {
                        switch (xmlPullParser.getName()) {
                            case "Constraint":
                                aVarJ = j(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            case "Guideline":
                                aVarJ = j(context, Xml.asAttributeSet(xmlPullParser));
                                b bVar = aVarJ.f764d;
                                bVar.f767b = true;
                                bVar.f768c = true;
                                break;
                            case "Barrier":
                                aVarJ = j(context, Xml.asAttributeSet(xmlPullParser));
                                aVarJ.f764d.e0 = 1;
                                break;
                            case "PropertySet":
                                if (aVar == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                                aVar.f762b.b(context, Xml.asAttributeSet(xmlPullParser));
                                continue;
                                break;
                                break;
                            case "Transform":
                                if (aVar == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                                aVar.f765e.b(context, Xml.asAttributeSet(xmlPullParser));
                                continue;
                                break;
                                break;
                            case "Layout":
                                if (aVar == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                                aVar.f764d.b(context, Xml.asAttributeSet(xmlPullParser));
                                continue;
                                break;
                                break;
                            case "Motion":
                                if (aVar == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                                aVar.f763c.b(context, Xml.asAttributeSet(xmlPullParser));
                                continue;
                                break;
                                break;
                            case "CustomAttribute":
                                if (aVar == null) {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                                androidx.constraintlayout.widget.a.b(context, xmlPullParser, aVar.f766f);
                                continue;
                                break;
                                break;
                            default:
                                continue;
                                break;
                        }
                        aVar = aVarJ;
                    } else if (eventType != 3) {
                        continue;
                    } else {
                        String name = xmlPullParser.getName();
                        if ("ConstraintSet".equals(name)) {
                            return;
                        }
                        if (name.equalsIgnoreCase("Constraint")) {
                            this.f761e.put(Integer.valueOf(aVar.a), aVar);
                            aVar = null;
                        }
                    }
                } else {
                    xmlPullParser.getName();
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    public void p(int i2, float f2) {
        k(i2).f764d.w = f2;
    }
}
