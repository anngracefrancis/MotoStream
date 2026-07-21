package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.r.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: RequestBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class h<TranscodeType> extends com.bumptech.glide.p.a<h<TranscodeType>> implements Cloneable {
    protected static final com.bumptech.glide.p.h F = new com.bumptech.glide.p.h().i(com.bumptech.glide.load.engine.j.f9141c).b0(g.LOW).k0(true);
    private final Context G;
    private final i H;
    private final Class<TranscodeType> I;
    private final c J;
    private final e K;
    private j<?, ? super TranscodeType> L;
    private Object M;
    private List<com.bumptech.glide.p.g<TranscodeType>> N;
    private h<TranscodeType> O;
    private h<TranscodeType> P;
    private Float Q;
    private boolean R = true;
    private boolean S;
    private boolean T;

    /* JADX INFO: compiled from: RequestBuilder.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f8950b;

        static {
            int[] iArr = new int[g.values().length];
            f8950b = iArr;
            try {
                iArr[g.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8950b[g.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8950b[g.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8950b[g.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    @SuppressLint({"CheckResult"})
    protected h(c cVar, i iVar, Class<TranscodeType> cls, Context context) {
        this.J = cVar;
        this.H = iVar;
        this.I = cls;
        this.G = context;
        this.L = iVar.h(cls);
        this.K = cVar.i();
        z0(iVar.f());
        b(iVar.g());
    }

    private <Y extends com.bumptech.glide.p.l.i<TranscodeType>> Y B0(Y y, com.bumptech.glide.p.g<TranscodeType> gVar, com.bumptech.glide.p.a<?> aVar, Executor executor) {
        com.bumptech.glide.r.j.d(y);
        if (!this.S) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        com.bumptech.glide.p.d dVarU0 = u0(y, gVar, aVar, executor);
        com.bumptech.glide.p.d request = y.getRequest();
        if (!dVarU0.e(request) || E0(aVar, request)) {
            this.H.e(y);
            y.setRequest(dVarU0);
            this.H.o(y, dVarU0);
            return y;
        }
        dVarU0.c();
        if (!((com.bumptech.glide.p.d) com.bumptech.glide.r.j.d(request)).isRunning()) {
            request.d();
        }
        return y;
    }

    private boolean E0(com.bumptech.glide.p.a<?> aVar, com.bumptech.glide.p.d dVar) {
        return !aVar.H() && dVar.l();
    }

    private h<TranscodeType> L0(Object obj) {
        this.M = obj;
        this.S = true;
        return this;
    }

    private com.bumptech.glide.p.d N0(com.bumptech.glide.p.l.i<TranscodeType> iVar, com.bumptech.glide.p.g<TranscodeType> gVar, com.bumptech.glide.p.a<?> aVar, com.bumptech.glide.p.e eVar, j<?, ? super TranscodeType> jVar, g gVar2, int i2, int i3, Executor executor) {
        Context context = this.G;
        e eVar2 = this.K;
        return com.bumptech.glide.p.j.B(context, eVar2, this.M, this.I, aVar, i2, i3, gVar2, iVar, gVar, this.N, eVar, eVar2.f(), jVar.d(), executor);
    }

    private com.bumptech.glide.p.d u0(com.bumptech.glide.p.l.i<TranscodeType> iVar, com.bumptech.glide.p.g<TranscodeType> gVar, com.bumptech.glide.p.a<?> aVar, Executor executor) {
        return v0(iVar, gVar, null, this.L, aVar.w(), aVar.t(), aVar.s(), aVar, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.bumptech.glide.p.d v0(com.bumptech.glide.p.l.i<TranscodeType> iVar, com.bumptech.glide.p.g<TranscodeType> gVar, com.bumptech.glide.p.e eVar, j<?, ? super TranscodeType> jVar, g gVar2, int i2, int i3, com.bumptech.glide.p.a<?> aVar, Executor executor) {
        com.bumptech.glide.p.e eVar2;
        com.bumptech.glide.p.e bVar;
        if (this.P != null) {
            bVar = new com.bumptech.glide.p.b(eVar);
            eVar2 = bVar;
        } else {
            eVar2 = null;
            bVar = eVar;
        }
        com.bumptech.glide.p.d dVarW0 = w0(iVar, gVar, bVar, jVar, gVar2, i2, i3, aVar, executor);
        if (eVar2 == null) {
            return dVarW0;
        }
        int iT = this.P.t();
        int iS = this.P.s();
        if (k.t(i2, i3) && !this.P.P()) {
            iT = aVar.t();
            iS = aVar.s();
        }
        h<TranscodeType> hVar = this.P;
        com.bumptech.glide.p.b bVar2 = eVar2;
        bVar2.s(dVarW0, hVar.v0(iVar, gVar, eVar2, hVar.L, hVar.w(), iT, iS, this.P, executor));
        return bVar2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private com.bumptech.glide.p.d w0(com.bumptech.glide.p.l.i<TranscodeType> iVar, com.bumptech.glide.p.g<TranscodeType> gVar, com.bumptech.glide.p.e eVar, j<?, ? super TranscodeType> jVar, g gVar2, int i2, int i3, com.bumptech.glide.p.a<?> aVar, Executor executor) {
        h<TranscodeType> hVar = this.O;
        if (hVar == null) {
            if (this.Q == null) {
                return N0(iVar, gVar, aVar, eVar, jVar, gVar2, i2, i3, executor);
            }
            com.bumptech.glide.p.k kVar = new com.bumptech.glide.p.k(eVar);
            kVar.r(N0(iVar, gVar, aVar, kVar, jVar, gVar2, i2, i3, executor), N0(iVar, gVar, aVar.clone().j0(this.Q.floatValue()), kVar, jVar, y0(gVar2), i2, i3, executor));
            return kVar;
        }
        if (this.T) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        j<?, ? super TranscodeType> jVar2 = hVar.R ? jVar : hVar.L;
        g gVarW = hVar.I() ? this.O.w() : y0(gVar2);
        int iT = this.O.t();
        int iS = this.O.s();
        if (k.t(i2, i3) && !this.O.P()) {
            iT = aVar.t();
            iS = aVar.s();
        }
        int i4 = iT;
        int i5 = iS;
        com.bumptech.glide.p.k kVar2 = new com.bumptech.glide.p.k(eVar);
        com.bumptech.glide.p.d dVarN0 = N0(iVar, gVar, aVar, kVar2, jVar, gVar2, i2, i3, executor);
        this.T = true;
        h hVar2 = (h<TranscodeType>) this.O;
        com.bumptech.glide.p.d dVarV0 = hVar2.v0(iVar, gVar, kVar2, jVar2, gVarW, i4, i5, hVar2, executor);
        this.T = false;
        kVar2.r(dVarN0, dVarV0);
        return kVar2;
    }

    private g y0(g gVar) {
        int i2 = a.f8950b[gVar.ordinal()];
        if (i2 == 1) {
            return g.NORMAL;
        }
        if (i2 == 2) {
            return g.HIGH;
        }
        if (i2 == 3 || i2 == 4) {
            return g.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + w());
    }

    @SuppressLint({"CheckResult"})
    private void z0(List<com.bumptech.glide.p.g<Object>> list) {
        Iterator<com.bumptech.glide.p.g<Object>> it = list.iterator();
        while (it.hasNext()) {
            s0((com.bumptech.glide.p.g) it.next());
        }
    }

    public <Y extends com.bumptech.glide.p.l.i<TranscodeType>> Y A0(Y y) {
        return (Y) C0(y, null, com.bumptech.glide.r.e.b());
    }

    <Y extends com.bumptech.glide.p.l.i<TranscodeType>> Y C0(Y y, com.bumptech.glide.p.g<TranscodeType> gVar, Executor executor) {
        return (Y) B0(y, gVar, this, executor);
    }

    public com.bumptech.glide.p.l.j<ImageView, TranscodeType> D0(ImageView imageView) {
        com.bumptech.glide.p.a aVarR;
        k.b();
        com.bumptech.glide.r.j.d(imageView);
        if (!O() && M() && imageView.getScaleType() != null) {
            switch (a.a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVarR = clone().R();
                    break;
                case 2:
                    aVarR = clone().S();
                    break;
                case 3:
                case 4:
                case 5:
                    aVarR = clone().T();
                    break;
                case 6:
                    aVarR = clone().S();
                    break;
                default:
                    aVarR = this;
                    break;
            }
        } else {
            aVarR = this;
        }
        return (com.bumptech.glide.p.l.j) B0(this.K.a(imageView, this.I), null, aVarR, com.bumptech.glide.r.e.b());
    }

    public h<TranscodeType> F0(com.bumptech.glide.p.g<TranscodeType> gVar) {
        this.N = null;
        return s0(gVar);
    }

    public h<TranscodeType> G0(Uri uri) {
        return L0(uri);
    }

    public h<TranscodeType> H0(Integer num) {
        return L0(num).b(com.bumptech.glide.p.h.v0(com.bumptech.glide.q.a.c(this.G)));
    }

    public h<TranscodeType> I0(Object obj) {
        return L0(obj);
    }

    public h<TranscodeType> K0(String str) {
        return L0(str);
    }

    public com.bumptech.glide.p.c<TranscodeType> O0() {
        return P0(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public com.bumptech.glide.p.c<TranscodeType> P0(int i2, int i3) {
        com.bumptech.glide.p.f fVar = new com.bumptech.glide.p.f(i2, i3);
        return (com.bumptech.glide.p.c) C0(fVar, fVar, com.bumptech.glide.r.e.a());
    }

    public h<TranscodeType> Q0(j<?, ? super TranscodeType> jVar) {
        this.L = (j) com.bumptech.glide.r.j.d(jVar);
        this.R = false;
        return this;
    }

    public h<TranscodeType> s0(com.bumptech.glide.p.g<TranscodeType> gVar) {
        if (gVar != null) {
            if (this.N == null) {
                this.N = new ArrayList();
            }
            this.N.add(gVar);
        }
        return this;
    }

    @Override // com.bumptech.glide.p.a
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> b(com.bumptech.glide.p.a<?> aVar) {
        com.bumptech.glide.r.j.d(aVar);
        return (h) super.b(aVar);
    }

    @Override // com.bumptech.glide.p.a
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> clone() {
        h<TranscodeType> hVar = (h) super.clone();
        hVar.L = hVar.L.clone();
        return hVar;
    }
}
