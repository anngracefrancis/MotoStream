package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: ProgressNoopOutputStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j0 extends OutputStream implements l0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f9919f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<GraphRequest, m0> f9920g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private GraphRequest f9921h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private m0 f9922i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f9923j;

    public j0(Handler handler) {
        this.f9919f = handler;
    }

    @Override // com.facebook.l0
    public void a(GraphRequest graphRequest) {
        this.f9921h = graphRequest;
        this.f9922i = graphRequest != null ? this.f9920g.get(graphRequest) : null;
    }

    public final void b(long j2) {
        GraphRequest graphRequest = this.f9921h;
        if (graphRequest == null) {
            return;
        }
        if (this.f9922i == null) {
            m0 m0Var = new m0(this.f9919f, graphRequest);
            this.f9922i = m0Var;
            this.f9920g.put(graphRequest, m0Var);
        }
        m0 m0Var2 = this.f9922i;
        if (m0Var2 != null) {
            m0Var2.b(j2);
        }
        this.f9923j += (int) j2;
    }

    public final int c() {
        return this.f9923j;
    }

    public final Map<GraphRequest, m0> d() {
        return this.f9920g;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        kotlin.jvm.internal.m.f(bArr, "buffer");
        b(bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) {
        kotlin.jvm.internal.m.f(bArr, "buffer");
        b(i3);
    }

    @Override // java.io.OutputStream
    public void write(int i2) {
        b(1L);
    }
}
