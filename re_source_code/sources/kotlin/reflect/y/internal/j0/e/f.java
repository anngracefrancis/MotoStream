package kotlin.reflect.y.internal.j0.e;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.p002reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.p002reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.p002reflect.jvm.internal.impl.protobuf.e;
import kotlin.p002reflect.jvm.internal.impl.protobuf.h;
import kotlin.p002reflect.jvm.internal.impl.protobuf.i;
import kotlin.p002reflect.jvm.internal.impl.protobuf.p;
import kotlin.p002reflect.jvm.internal.impl.protobuf.q;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends h implements p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final f f23959g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static q<f> f23960h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final kotlin.p002reflect.jvm.internal.impl.protobuf.d f23961i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f23962j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private c f23963k;
    private List<h> l;
    private h m;
    private d n;
    private byte o;
    private int p;

    /* JADX INFO: compiled from: ProtoBuf.java */
    static class a extends kotlin.p002reflect.jvm.internal.impl.protobuf.b<f> {
        a() {
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public f b(e eVar, kotlin.p002reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            return new f(eVar, fVar);
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends h.b<f, b> implements p {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f23964g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private c f23965h = c.RETURNS_CONSTANT;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private List<h> f23966i = Collections.emptyList();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private h f23967j = h.F();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private d f23968k = d.AT_MOST_ONCE;

        private b() {
            u();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b s() {
            return new b();
        }

        private void t() {
            if ((this.f23964g & 2) != 2) {
                this.f23966i = new ArrayList(this.f23966i);
                this.f23964g |= 2;
            }
        }

        private void u() {
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
        public b i(e eVar, kotlin.p002reflect.jvm.internal.impl.protobuf.f fVar) throws Throwable {
            f fVar2 = null;
            try {
                try {
                    f fVarB = f.f23960h.b(eVar, fVar);
                    if (fVarB != null) {
                        m(fVarB);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    f fVar3 = (f) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        fVar2 = fVar3;
                        if (fVar2 != null) {
                            m(fVar2);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (fVar2 != null) {
                    m(fVar2);
                }
                throw th;
            }
        }

        public b B(c cVar) {
            cVar.getClass();
            this.f23964g |= 1;
            this.f23965h = cVar;
            return this;
        }

        public b C(d dVar) {
            dVar.getClass();
            this.f23964g |= 8;
            this.f23968k = dVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public f c() {
            f fVarQ = q();
            if (fVarQ.isInitialized()) {
                return fVarQ;
            }
            throw kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a.j(fVarQ);
        }

        public f q() {
            f fVar = new f(this);
            int i2 = this.f23964g;
            int i3 = (i2 & 1) != 1 ? 0 : 1;
            fVar.f23963k = this.f23965h;
            if ((this.f23964g & 2) == 2) {
                this.f23966i = Collections.unmodifiableList(this.f23966i);
                this.f23964g &= -3;
            }
            fVar.l = this.f23966i;
            if ((i2 & 4) == 4) {
                i3 |= 2;
            }
            fVar.m = this.f23967j;
            if ((i2 & 8) == 8) {
                i3 |= 4;
            }
            fVar.n = this.f23968k;
            fVar.f23962j = i3;
            return fVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public b k() {
            return s().m(q());
        }

        public b v(h hVar) {
            if ((this.f23964g & 4) != 4 || this.f23967j == h.F()) {
                this.f23967j = hVar;
            } else {
                this.f23967j = h.T(this.f23967j).m(hVar).q();
            }
            this.f23964g |= 4;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        public b m(f fVar) {
            if (fVar == f.z()) {
                return this;
            }
            if (fVar.F()) {
                B(fVar.C());
            }
            if (!fVar.l.isEmpty()) {
                if (this.f23966i.isEmpty()) {
                    this.f23966i = fVar.l;
                    this.f23964g &= -3;
                } else {
                    t();
                    this.f23966i.addAll(fVar.l);
                }
            }
            if (fVar.E()) {
                v(fVar.y());
            }
            if (fVar.G()) {
                C(fVar.D());
            }
            n(l().f(fVar.f23961i));
            return this;
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public enum c implements i.a {
        RETURNS_CONSTANT(0, 0),
        CALLS(1, 1),
        RETURNS_NOT_NULL(2, 2);


        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static i.b<c> f23972i = new a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f23974k;

        /* JADX INFO: compiled from: ProtoBuf.java */
        static class a implements i.b<c> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public c a(int i2) {
                return c.g(i2);
            }
        }

        c(int i2, int i3) {
            this.f23974k = i3;
        }

        public static c g(int i2) {
            if (i2 == 0) {
                return RETURNS_CONSTANT;
            }
            if (i2 == 1) {
                return CALLS;
            }
            if (i2 != 2) {
                return null;
            }
            return RETURNS_NOT_NULL;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
        public final int f() {
            return this.f23974k;
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public enum d implements i.a {
        AT_MOST_ONCE(0, 0),
        EXACTLY_ONCE(1, 1),
        AT_LEAST_ONCE(2, 2);


        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static i.b<d> f23978i = new a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f23980k;

        /* JADX INFO: compiled from: ProtoBuf.java */
        static class a implements i.b<d> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d a(int i2) {
                return d.g(i2);
            }
        }

        d(int i2, int i3) {
            this.f23980k = i3;
        }

        public static d g(int i2) {
            if (i2 == 0) {
                return AT_MOST_ONCE;
            }
            if (i2 == 1) {
                return EXACTLY_ONCE;
            }
            if (i2 != 2) {
                return null;
            }
            return AT_LEAST_ONCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
        public final int f() {
            return this.f23980k;
        }
    }

    static {
        f fVar = new f(true);
        f23959g = fVar;
        fVar.H();
    }

    private void H() {
        this.f23963k = c.RETURNS_CONSTANT;
        this.l = Collections.emptyList();
        this.m = h.F();
        this.n = d.AT_MOST_ONCE;
    }

    public static b I() {
        return b.s();
    }

    public static b J(f fVar) {
        return I().m(fVar);
    }

    public static f z() {
        return f23959g;
    }

    public h A(int i2) {
        return this.l.get(i2);
    }

    public int B() {
        return this.l.size();
    }

    public c C() {
        return this.f23963k;
    }

    public d D() {
        return this.n;
    }

    public boolean E() {
        return (this.f23962j & 2) == 2;
    }

    public boolean F() {
        return (this.f23962j & 1) == 1;
    }

    public boolean G() {
        return (this.f23962j & 4) == 4;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public b f() {
        return I();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public b d() {
        return J(this);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public int e() {
        int i2 = this.p;
        if (i2 != -1) {
            return i2;
        }
        int iH = (this.f23962j & 1) == 1 ? CodedOutputStream.h(1, this.f23963k.f()) + 0 : 0;
        for (int i3 = 0; i3 < this.l.size(); i3++) {
            iH += CodedOutputStream.s(2, this.l.get(i3));
        }
        if ((this.f23962j & 2) == 2) {
            iH += CodedOutputStream.s(3, this.m);
        }
        if ((this.f23962j & 4) == 4) {
            iH += CodedOutputStream.h(4, this.n.f());
        }
        int size = iH + this.f23961i.size();
        this.p = size;
        return size;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.h, kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public q<f> g() {
        return f23960h;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        if ((this.f23962j & 1) == 1) {
            codedOutputStream.S(1, this.f23963k.f());
        }
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            codedOutputStream.d0(2, this.l.get(i2));
        }
        if ((this.f23962j & 2) == 2) {
            codedOutputStream.d0(3, this.m);
        }
        if ((this.f23962j & 4) == 4) {
            codedOutputStream.S(4, this.n.f());
        }
        codedOutputStream.i0(this.f23961i);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.p
    public final boolean isInitialized() {
        byte b2 = this.o;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        for (int i2 = 0; i2 < B(); i2++) {
            if (!A(i2).isInitialized()) {
                this.o = (byte) 0;
                return false;
            }
        }
        if (!E() || y().isInitialized()) {
            this.o = (byte) 1;
            return true;
        }
        this.o = (byte) 0;
        return false;
    }

    public h y() {
        return this.m;
    }

    private f(h.b bVar) {
        super(bVar);
        this.o = (byte) -1;
        this.p = -1;
        this.f23961i = bVar.l();
    }

    private f(boolean z) {
        this.o = (byte) -1;
        this.p = -1;
        this.f23961i = kotlin.p002reflect.jvm.internal.impl.protobuf.d.f25399f;
    }

    private f(e eVar, kotlin.p002reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
        this.o = (byte) -1;
        this.p = -1;
        H();
        kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarW = kotlin.p002reflect.jvm.internal.impl.protobuf.d.w();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(bVarW, 1);
        boolean z = false;
        int i2 = 0;
        while (!z) {
            try {
                try {
                    int iK = eVar.K();
                    if (iK != 0) {
                        if (iK == 8) {
                            int iN = eVar.n();
                            c cVarG = c.g(iN);
                            if (cVarG == null) {
                                codedOutputStreamJ.o0(iK);
                                codedOutputStreamJ.o0(iN);
                            } else {
                                this.f23962j |= 1;
                                this.f23963k = cVarG;
                            }
                        } else if (iK == 18) {
                            if ((i2 & 2) != 2) {
                                this.l = new ArrayList();
                                i2 |= 2;
                            }
                            this.l.add((h) eVar.u(h.f23988h, fVar));
                        } else if (iK == 26) {
                            h.b bVarD = (this.f23962j & 2) == 2 ? this.m.d() : null;
                            h hVar = (h) eVar.u(h.f23988h, fVar);
                            this.m = hVar;
                            if (bVarD != null) {
                                bVarD.m(hVar);
                                this.m = bVarD.q();
                            }
                            this.f23962j |= 2;
                        } else if (iK != 32) {
                            if (!p(eVar, codedOutputStreamJ, fVar, iK)) {
                            }
                        } else {
                            int iN2 = eVar.n();
                            d dVarG = d.g(iN2);
                            if (dVarG == null) {
                                codedOutputStreamJ.o0(iK);
                                codedOutputStreamJ.o0(iN2);
                            } else {
                                this.f23962j |= 4;
                                this.n = dVarG;
                            }
                        }
                    }
                    z = true;
                } catch (Throwable th) {
                    if ((i2 & 2) == 2) {
                        this.l = Collections.unmodifiableList(this.l);
                    }
                    try {
                        codedOutputStreamJ.I();
                    } catch (IOException unused) {
                    } finally {
                        this.f23961i = bVarW.e();
                    }
                    m();
                    throw th;
                }
            } catch (InvalidProtocolBufferException e2) {
                throw e2.i(this);
            } catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).i(this);
            }
        }
        if ((i2 & 2) == 2) {
            this.l = Collections.unmodifiableList(this.l);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } finally {
            this.f23961i = bVarW.e();
        }
        m();
    }
}
