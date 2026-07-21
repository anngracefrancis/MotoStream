package kotlin.reflect.y.internal.j0.e;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.p002reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.p002reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.p002reflect.jvm.internal.impl.protobuf.e;
import kotlin.p002reflect.jvm.internal.impl.protobuf.f;
import kotlin.p002reflect.jvm.internal.impl.protobuf.h;
import kotlin.p002reflect.jvm.internal.impl.protobuf.p;
import kotlin.p002reflect.jvm.internal.impl.protobuf.q;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends h.d<d> implements p {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final d f23945h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static q<d> f23946i = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final kotlin.p002reflect.jvm.internal.impl.protobuf.d f23947j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f23948k;
    private int l;
    private List<u> m;
    private List<Integer> n;
    private byte o;
    private int p;

    /* JADX INFO: compiled from: ProtoBuf.java */
    static class a extends kotlin.p002reflect.jvm.internal.impl.protobuf.b<d> {
        a() {
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public d b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new d(eVar, fVar);
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends h.c<d, b> implements p {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f23949i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f23950j = 6;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private List<u> f23951k = Collections.emptyList();
        private List<Integer> l = Collections.emptyList();

        private b() {
            C();
        }

        private void A() {
            if ((this.f23949i & 2) != 2) {
                this.f23951k = new ArrayList(this.f23951k);
                this.f23949i |= 2;
            }
        }

        private void B() {
            if ((this.f23949i & 4) != 4) {
                this.l = new ArrayList(this.l);
                this.f23949i |= 4;
            }
        }

        private void C() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b w() {
            return new b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public b m(d dVar) {
            if (dVar == d.H()) {
                return this;
            }
            if (dVar.O()) {
                F(dVar.J());
            }
            if (!dVar.m.isEmpty()) {
                if (this.f23951k.isEmpty()) {
                    this.f23951k = dVar.m;
                    this.f23949i &= -3;
                } else {
                    A();
                    this.f23951k.addAll(dVar.m);
                }
            }
            if (!dVar.n.isEmpty()) {
                if (this.l.isEmpty()) {
                    this.l = dVar.n;
                    this.f23949i &= -5;
                } else {
                    B();
                    this.l.addAll(dVar.n);
                }
            }
            r(dVar);
            n(l().f(dVar.f23947j));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public b i(e eVar, f fVar) throws Throwable {
            d dVar = null;
            try {
                try {
                    d dVarB = d.f23946i.b(eVar, fVar);
                    if (dVarB != null) {
                        m(dVarB);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    d dVar2 = (d) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        dVar = dVar2;
                        if (dVar != null) {
                            m(dVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (dVar != null) {
                    m(dVar);
                }
                throw th;
            }
        }

        public b F(int i2) {
            this.f23949i |= 1;
            this.f23950j = i2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public d c() {
            d dVarU = u();
            if (dVarU.isInitialized()) {
                return dVarU;
            }
            throw kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a.j(dVarU);
        }

        public d u() {
            d dVar = new d(this);
            int i2 = (this.f23949i & 1) != 1 ? 0 : 1;
            dVar.l = this.f23950j;
            if ((this.f23949i & 2) == 2) {
                this.f23951k = Collections.unmodifiableList(this.f23951k);
                this.f23949i &= -3;
            }
            dVar.m = this.f23951k;
            if ((this.f23949i & 4) == 4) {
                this.l = Collections.unmodifiableList(this.l);
                this.f23949i &= -5;
            }
            dVar.n = this.l;
            dVar.f23948k = i2;
            return dVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public b k() {
            return w().m(u());
        }
    }

    static {
        d dVar = new d(true);
        f23945h = dVar;
        dVar.P();
    }

    public static d H() {
        return f23945h;
    }

    private void P() {
        this.l = 6;
        this.m = Collections.emptyList();
        this.n = Collections.emptyList();
    }

    public static b Q() {
        return b.w();
    }

    public static b R(d dVar) {
        return Q().m(dVar);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.p
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public d b() {
        return f23945h;
    }

    public int J() {
        return this.l;
    }

    public u K(int i2) {
        return this.m.get(i2);
    }

    public int L() {
        return this.m.size();
    }

    public List<u> M() {
        return this.m;
    }

    public List<Integer> N() {
        return this.n;
    }

    public boolean O() {
        return (this.f23948k & 1) == 1;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public b f() {
        return Q();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public b d() {
        return R(this);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public int e() {
        int i2 = this.p;
        if (i2 != -1) {
            return i2;
        }
        int iO = (this.f23948k & 1) == 1 ? CodedOutputStream.o(1, this.l) + 0 : 0;
        for (int i3 = 0; i3 < this.m.size(); i3++) {
            iO += CodedOutputStream.s(2, this.m.get(i3));
        }
        int iP = 0;
        for (int i4 = 0; i4 < this.n.size(); i4++) {
            iP += CodedOutputStream.p(this.n.get(i4).intValue());
        }
        int size = iO + iP + (N().size() * 2) + t() + this.f23947j.size();
        this.p = size;
        return size;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.h, kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public q<d> g() {
        return f23946i;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        h.d<MessageType>.a aVarY = y();
        if ((this.f23948k & 1) == 1) {
            codedOutputStream.a0(1, this.l);
        }
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            codedOutputStream.d0(2, this.m.get(i2));
        }
        for (int i3 = 0; i3 < this.n.size(); i3++) {
            codedOutputStream.a0(31, this.n.get(i3).intValue());
        }
        aVarY.a(19000, codedOutputStream);
        codedOutputStream.i0(this.f23947j);
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
        for (int i2 = 0; i2 < L(); i2++) {
            if (!K(i2).isInitialized()) {
                this.o = (byte) 0;
                return false;
            }
        }
        if (s()) {
            this.o = (byte) 1;
            return true;
        }
        this.o = (byte) 0;
        return false;
    }

    private d(h.c<d, ?> cVar) {
        super(cVar);
        this.o = (byte) -1;
        this.p = -1;
        this.f23947j = cVar.l();
    }

    private d(boolean z) {
        this.o = (byte) -1;
        this.p = -1;
        this.f23947j = kotlin.p002reflect.jvm.internal.impl.protobuf.d.f25399f;
    }

    private d(e eVar, f fVar) throws InvalidProtocolBufferException {
        this.o = (byte) -1;
        this.p = -1;
        P();
        kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarW = kotlin.p002reflect.jvm.internal.impl.protobuf.d.w();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(bVarW, 1);
        boolean z = false;
        int i2 = 0;
        while (!z) {
            try {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK == 8) {
                                this.f23948k |= 1;
                                this.l = eVar.s();
                            } else if (iK == 18) {
                                if ((i2 & 2) != 2) {
                                    this.m = new ArrayList();
                                    i2 |= 2;
                                }
                                this.m.add((u) eVar.u(u.f24123i, fVar));
                            } else if (iK == 248) {
                                if ((i2 & 4) != 4) {
                                    this.n = new ArrayList();
                                    i2 |= 4;
                                }
                                this.n.add(Integer.valueOf(eVar.s()));
                            } else if (iK != 250) {
                                if (!p(eVar, codedOutputStreamJ, fVar, iK)) {
                                }
                            } else {
                                int iJ = eVar.j(eVar.A());
                                if ((i2 & 4) != 4 && eVar.e() > 0) {
                                    this.n = new ArrayList();
                                    i2 |= 4;
                                }
                                while (eVar.e() > 0) {
                                    this.n.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(iJ);
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.i(this);
                    }
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).i(this);
                }
            } catch (Throwable th) {
                if ((i2 & 2) == 2) {
                    this.m = Collections.unmodifiableList(this.m);
                }
                if ((i2 & 4) == 4) {
                    this.n = Collections.unmodifiableList(this.n);
                }
                try {
                    codedOutputStreamJ.I();
                } catch (IOException unused) {
                } finally {
                    this.f23947j = bVarW.e();
                }
                m();
                throw th;
            }
        }
        if ((i2 & 2) == 2) {
            this.m = Collections.unmodifiableList(this.m);
        }
        if ((i2 & 4) == 4) {
            this.n = Collections.unmodifiableList(this.n);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } finally {
            this.f23947j = bVarW.e();
        }
        m();
    }
}
