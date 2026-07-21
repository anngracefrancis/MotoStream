package com.flurry.sdk;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class i1<RequestObjectType, ResponseObjectType> extends k1 {
    public b<RequestObjectType, ResponseObjectType> G;
    public RequestObjectType H;
    private ResponseObjectType I;
    public v1<RequestObjectType> J;
    public v1<ResponseObjectType> K;

    final class a implements k1.d {
        a() {
        }

        @Override // com.flurry.sdk.k1.d
        public final void a() {
            i1.k(i1.this);
        }

        @Override // com.flurry.sdk.k1.d
        public final void b(InputStream inputStream) throws Exception {
            if (i1.this.K != null) {
                i1 i1Var = i1.this;
                i1Var.I = i1Var.K.b(inputStream);
            }
        }

        @Override // com.flurry.sdk.k1.d
        public final void c(OutputStream outputStream) throws Exception {
            if (i1.this.H == null || i1.this.J == null) {
                return;
            }
            i1.this.J.a(outputStream, i1.this.H);
        }
    }

    public interface b<RequestObjectType, ResponseObjectType> {
        void a(i1<RequestObjectType, ResponseObjectType> i1Var, ResponseObjectType responseobjecttype);
    }

    static /* synthetic */ void k(i1 i1Var) {
        if (i1Var.G == null || i1Var.d()) {
            return;
        }
        i1Var.G.a(i1Var, i1Var.I);
    }

    @Override // com.flurry.sdk.k1, com.flurry.sdk.f2
    public final void a() {
        this.s = new a();
        super.a();
    }
}
