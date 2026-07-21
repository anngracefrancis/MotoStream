package kotlin.reflect.y.internal.j0.e;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.p002reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.p002reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.p002reflect.jvm.internal.impl.protobuf.d;
import kotlin.p002reflect.jvm.internal.impl.protobuf.f;
import kotlin.p002reflect.jvm.internal.impl.protobuf.h;
import kotlin.p002reflect.jvm.internal.impl.protobuf.p;
import kotlin.p002reflect.jvm.internal.impl.protobuf.q;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends h implements p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final e f23952g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static q<e> f23953h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final d f23954i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<f> f23955j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private byte f23956k;
    private int l;

    /* JADX INFO: compiled from: ProtoBuf.java */
    static class a extends kotlin.p002reflect.jvm.internal.impl.protobuf.b<e> {
        a() {
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public e b(kotlin.p002reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
            return new e(eVar, fVar);
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends h.b<e, b> implements p {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f23957g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private List<f> f23958h = Collections.emptyList();

        private b() {
            u();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b s() {
            return new b();
        }

        private void t() {
            if ((this.f23957g & 1) != 1) {
                this.f23958h = new ArrayList(this.f23958h);
                this.f23957g |= 1;
            }
        }

        private void u() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public e c() {
            e eVarQ = q();
            if (eVarQ.isInitialized()) {
                return eVarQ;
            }
            throw kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a.j(eVarQ);
        }

        public e q() {
            e eVar = new e(this);
            if ((this.f23957g & 1) == 1) {
                this.f23958h = Collections.unmodifiableList(this.f23958h);
                this.f23957g &= -2;
            }
            eVar.f23955j = this.f23958h;
            return eVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public b k() {
            return s().m(q());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public b m(e eVar) {
            if (eVar == e.u()) {
                return this;
            }
            if (!eVar.f23955j.isEmpty()) {
                if (this.f23958h.isEmpty()) {
                    this.f23958h = eVar.f23955j;
                    this.f23957g &= -2;
                } else {
                    t();
                    this.f23958h.addAll(eVar.f23955j);
                }
            }
            n(l().f(eVar.f23954i));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        public b i(kotlin.p002reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws Throwable {
            e eVar2 = null;
            try {
                try {
                    e eVarB = e.f23953h.b(eVar, fVar);
                    if (eVarB != null) {
                        m(eVarB);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    e eVar3 = (e) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        eVar2 = eVar3;
                        if (eVar2 != null) {
                            m(eVar2);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (eVar2 != null) {
                    m(eVar2);
                }
                throw th;
            }
        }
    }

    static {
        e eVar = new e(true);
        f23952g = eVar;
        eVar.x();
    }

    public static e u() {
        return f23952g;
    }

    private void x() {
        this.f23955j = Collections.emptyList();
    }

    public static b y() {
        return b.s();
    }

    public static b z(e eVar) {
        return y().m(eVar);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public b f() {
        return y();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public b d() {
        return z(this);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public int e() {
        int i2 = this.l;
        if (i2 != -1) {
            return i2;
        }
        int iS = 0;
        for (int i3 = 0; i3 < this.f23955j.size(); i3++) {
            iS += CodedOutputStream.s(1, this.f23955j.get(i3));
        }
        int size = iS + this.f23954i.size();
        this.l = size;
        return size;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.h, kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public q<e> g() {
        return f23953h;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        for (int i2 = 0; i2 < this.f23955j.size(); i2++) {
            codedOutputStream.d0(1, this.f23955j.get(i2));
        }
        codedOutputStream.i0(this.f23954i);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.p
    public final boolean isInitialized() {
        byte b2 = this.f23956k;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        for (int i2 = 0; i2 < w(); i2++) {
            if (!v(i2).isInitialized()) {
                this.f23956k = (byte) 0;
                return false;
            }
        }
        this.f23956k = (byte) 1;
        return true;
    }

    public f v(int i2) {
        return this.f23955j.get(i2);
    }

    public int w() {
        return this.f23955j.size();
    }

    private e(h.b bVar) {
        super(bVar);
        this.f23956k = (byte) -1;
        this.l = -1;
        this.f23954i = bVar.l();
    }

    private e(boolean z) {
        this.f23956k = (byte) -1;
        this.l = -1;
        this.f23954i = d.f25399f;
    }

    private e(kotlin.p002reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
        this.f23956k = (byte) -1;
        this.l = -1;
        x();
        d.b bVarW = d.w();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(bVarW, 1);
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                try {
                    int iK = eVar.K();
                    if (iK != 0) {
                        if (iK != 10) {
                            if (!p(eVar, codedOutputStreamJ, fVar, iK)) {
                            }
                        } else {
                            if (!(z2 & true)) {
                                this.f23955j = new ArrayList();
                                z2 |= true;
                            }
                            this.f23955j.add((f) eVar.u(f.f23960h, fVar));
                        }
                    }
                    z = true;
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.f23955j = Collections.unmodifiableList(this.f23955j);
                    }
                    try {
                        codedOutputStreamJ.I();
                    } catch (IOException unused) {
                    } finally {
                        this.f23954i = bVarW.e();
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
        if (z2 & true) {
            this.f23955j = Collections.unmodifiableList(this.f23955j);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } finally {
            this.f23954i = bVarW.e();
        }
        m();
    }
}
