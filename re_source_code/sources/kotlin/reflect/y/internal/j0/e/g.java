package kotlin.reflect.y.internal.j0.e;

import java.io.IOException;
import kotlin.p002reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.p002reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.p002reflect.jvm.internal.impl.protobuf.d;
import kotlin.p002reflect.jvm.internal.impl.protobuf.e;
import kotlin.p002reflect.jvm.internal.impl.protobuf.f;
import kotlin.p002reflect.jvm.internal.impl.protobuf.h;
import kotlin.p002reflect.jvm.internal.impl.protobuf.p;
import kotlin.p002reflect.jvm.internal.impl.protobuf.q;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends h.d<g> implements p {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final g f23981h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static q<g> f23982i = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d f23983j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f23984k;
    private int l;
    private byte m;
    private int n;

    /* JADX INFO: compiled from: ProtoBuf.java */
    static class a extends kotlin.p002reflect.jvm.internal.impl.protobuf.b<g> {
        a() {
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public g b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new g(eVar, fVar);
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends h.c<g, b> implements p {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f23985i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f23986j;

        private b() {
            A();
        }

        private void A() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b w() {
            return new b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public b m(g gVar) {
            if (gVar == g.D()) {
                return this;
            }
            if (gVar.G()) {
                D(gVar.F());
            }
            r(gVar);
            n(l().f(gVar.f23983j));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public b i(e eVar, f fVar) throws Throwable {
            g gVar = null;
            try {
                try {
                    g gVarB = g.f23982i.b(eVar, fVar);
                    if (gVarB != null) {
                        m(gVarB);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    g gVar2 = (g) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        gVar = gVar2;
                        if (gVar != null) {
                            m(gVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (gVar != null) {
                    m(gVar);
                }
                throw th;
            }
        }

        public b D(int i2) {
            this.f23985i |= 1;
            this.f23986j = i2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public g c() {
            g gVarU = u();
            if (gVarU.isInitialized()) {
                return gVarU;
            }
            throw kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a.j(gVarU);
        }

        public g u() {
            g gVar = new g(this);
            int i2 = (this.f23985i & 1) != 1 ? 0 : 1;
            gVar.l = this.f23986j;
            gVar.f23984k = i2;
            return gVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public b k() {
            return w().m(u());
        }
    }

    static {
        g gVar = new g(true);
        f23981h = gVar;
        gVar.H();
    }

    public static g D() {
        return f23981h;
    }

    private void H() {
        this.l = 0;
    }

    public static b I() {
        return b.w();
    }

    public static b J(g gVar) {
        return I().m(gVar);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.p
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public g b() {
        return f23981h;
    }

    public int F() {
        return this.l;
    }

    public boolean G() {
        return (this.f23984k & 1) == 1;
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
        int i2 = this.n;
        if (i2 != -1) {
            return i2;
        }
        int iO = ((this.f23984k & 1) == 1 ? 0 + CodedOutputStream.o(1, this.l) : 0) + t() + this.f23983j.size();
        this.n = iO;
        return iO;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.h, kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public q<g> g() {
        return f23982i;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        h.d<MessageType>.a aVarY = y();
        if ((this.f23984k & 1) == 1) {
            codedOutputStream.a0(1, this.l);
        }
        aVarY.a(200, codedOutputStream);
        codedOutputStream.i0(this.f23983j);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.p
    public final boolean isInitialized() {
        byte b2 = this.m;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if (s()) {
            this.m = (byte) 1;
            return true;
        }
        this.m = (byte) 0;
        return false;
    }

    private g(h.c<g, ?> cVar) {
        super(cVar);
        this.m = (byte) -1;
        this.n = -1;
        this.f23983j = cVar.l();
    }

    private g(boolean z) {
        this.m = (byte) -1;
        this.n = -1;
        this.f23983j = d.f25399f;
    }

    private g(e eVar, f fVar) throws InvalidProtocolBufferException {
        this.m = (byte) -1;
        this.n = -1;
        H();
        d.b bVarW = d.w();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(bVarW, 1);
        boolean z = false;
        while (!z) {
            try {
                try {
                    int iK = eVar.K();
                    if (iK != 0) {
                        if (iK != 8) {
                            if (!p(eVar, codedOutputStreamJ, fVar, iK)) {
                            }
                        } else {
                            this.f23984k |= 1;
                            this.l = eVar.s();
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.i(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).i(this);
                }
            } catch (Throwable th) {
                try {
                    codedOutputStreamJ.I();
                } catch (IOException unused) {
                } finally {
                    this.f23983j = bVarW.e();
                }
                m();
                throw th;
            }
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } finally {
            this.f23983j = bVarW.e();
        }
        m();
    }
}
