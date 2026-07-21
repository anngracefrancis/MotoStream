package com.facebook;

import android.os.Handler;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: ProgressOutputStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k0 extends FilterOutputStream implements l0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c0 f9926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<GraphRequest, m0> f9927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f9928h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f9929i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f9930j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f9931k;
    private m0 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(OutputStream outputStream, c0 c0Var, Map<GraphRequest, m0> map, long j2) {
        super(outputStream);
        kotlin.jvm.internal.m.f(outputStream, "out");
        kotlin.jvm.internal.m.f(c0Var, "requests");
        kotlin.jvm.internal.m.f(map, "progressMap");
        this.f9926f = c0Var;
        this.f9927g = map;
        this.f9928h = j2;
        a0 a0Var = a0.a;
        this.f9929i = a0.r();
    }

    private final void b(long j2) {
        m0 m0Var = this.l;
        if (m0Var != null) {
            m0Var.a(j2);
        }
        long j3 = this.f9930j + j2;
        this.f9930j = j3;
        if (j3 >= this.f9931k + this.f9929i || j3 >= this.f9928h) {
            f();
        }
    }

    private final void f() {
        if (this.f9930j > this.f9931k) {
            for (final c0.a aVar : this.f9926f.u()) {
                if (aVar instanceof c0.c) {
                    Handler handlerT = this.f9926f.t();
                    if ((handlerT == null ? null : Boolean.valueOf(handlerT.post(new Runnable() { // from class: com.facebook.r
                        @Override // java.lang.Runnable
                        public final void run() {
                            k0.j(aVar, this);
                        }
                    }))) == null) {
                        ((c0.c) aVar).b(this.f9926f, this.f9930j, this.f9928h);
                    }
                }
            }
            this.f9931k = this.f9930j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(c0.a aVar, k0 k0Var) {
        kotlin.jvm.internal.m.f(aVar, "$callback");
        kotlin.jvm.internal.m.f(k0Var, "this$0");
        ((c0.c) aVar).b(k0Var.f9926f, k0Var.c(), k0Var.d());
    }

    @Override // com.facebook.l0
    public void a(GraphRequest graphRequest) {
        this.l = graphRequest != null ? this.f9927g.get(graphRequest) : null;
    }

    public final long c() {
        return this.f9930j;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        Iterator<m0> it = this.f9927g.values().iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        f();
    }

    public final long d() {
        return this.f9928h;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        kotlin.jvm.internal.m.f(bArr, "buffer");
        ((FilterOutputStream) this).out.write(bArr);
        b(bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        kotlin.jvm.internal.m.f(bArr, "buffer");
        ((FilterOutputStream) this).out.write(bArr, i2, i3);
        b(i3);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        ((FilterOutputStream) this).out.write(i2);
        b(1L);
    }
}
