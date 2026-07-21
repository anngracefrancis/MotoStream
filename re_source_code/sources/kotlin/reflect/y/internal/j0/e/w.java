package kotlin.reflect.y.internal.j0.e;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
public final class w extends h implements p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final w f24151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static q<w> f24152h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final d f24153i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<v> f24154j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private byte f24155k;
    private int l;

    /* JADX INFO: compiled from: ProtoBuf.java */
    static class a extends kotlin.p002reflect.jvm.internal.impl.protobuf.b<w> {
        a() {
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public w b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new w(eVar, fVar);
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends h.b<w, b> implements p {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f24156g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private List<v> f24157h = Collections.emptyList();

        private b() {
            u();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b s() {
            return new b();
        }

        private void t() {
            if ((this.f24156g & 1) != 1) {
                this.f24157h = new ArrayList(this.f24157h);
                this.f24156g |= 1;
            }
        }

        private void u() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public w c() {
            w wVarQ = q();
            if (wVarQ.isInitialized()) {
                return wVarQ;
            }
            throw kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a.j(wVarQ);
        }

        public w q() {
            w wVar = new w(this);
            if ((this.f24156g & 1) == 1) {
                this.f24157h = Collections.unmodifiableList(this.f24157h);
                this.f24156g &= -2;
            }
            wVar.f24154j = this.f24157h;
            return wVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public b k() {
            return s().m(q());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public b m(w wVar) {
            if (wVar == w.u()) {
                return this;
            }
            if (!wVar.f24154j.isEmpty()) {
                if (this.f24157h.isEmpty()) {
                    this.f24157h = wVar.f24154j;
                    this.f24156g &= -2;
                } else {
                    t();
                    this.f24157h.addAll(wVar.f24154j);
                }
            }
            n(l().f(wVar.f24153i));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        public b i(e eVar, f fVar) throws Throwable {
            w wVar = null;
            try {
                try {
                    w wVarB = w.f24152h.b(eVar, fVar);
                    if (wVarB != null) {
                        m(wVarB);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    w wVar2 = (w) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        wVar = wVar2;
                        if (wVar != null) {
                            m(wVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (wVar != null) {
                    m(wVar);
                }
                throw th;
            }
        }
    }

    static {
        w wVar = new w(true);
        f24151g = wVar;
        wVar.x();
    }

    public static w u() {
        return f24151g;
    }

    private void x() {
        this.f24154j = Collections.emptyList();
    }

    public static b y() {
        return b.s();
    }

    public static b z(w wVar) {
        return y().m(wVar);
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
        for (int i3 = 0; i3 < this.f24154j.size(); i3++) {
            iS += CodedOutputStream.s(1, this.f24154j.get(i3));
        }
        int size = iS + this.f24153i.size();
        this.l = size;
        return size;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.h, kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public q<w> g() {
        return f24152h;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        for (int i2 = 0; i2 < this.f24154j.size(); i2++) {
            codedOutputStream.d0(1, this.f24154j.get(i2));
        }
        codedOutputStream.i0(this.f24153i);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.p
    public final boolean isInitialized() {
        byte b2 = this.f24155k;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        this.f24155k = (byte) 1;
        return true;
    }

    public int v() {
        return this.f24154j.size();
    }

    public List<v> w() {
        return this.f24154j;
    }

    private w(h.b bVar) {
        super(bVar);
        this.f24155k = (byte) -1;
        this.l = -1;
        this.f24153i = bVar.l();
    }

    private w(boolean z) {
        this.f24155k = (byte) -1;
        this.l = -1;
        this.f24153i = d.f25399f;
    }

    private w(e eVar, f fVar) throws InvalidProtocolBufferException {
        this.f24155k = (byte) -1;
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
                                this.f24154j = new ArrayList();
                                z2 |= true;
                            }
                            this.f24154j.add((v) eVar.u(v.f24130h, fVar));
                        }
                    }
                    z = true;
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.f24154j = Collections.unmodifiableList(this.f24154j);
                    }
                    try {
                        codedOutputStreamJ.I();
                    } catch (IOException unused) {
                    } finally {
                        this.f24153i = bVarW.e();
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
            this.f24154j = Collections.unmodifiableList(this.f24154j);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } finally {
            this.f24153i = bVarW.e();
        }
        m();
    }
}
