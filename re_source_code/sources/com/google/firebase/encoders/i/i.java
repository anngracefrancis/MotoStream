package com.google.firebase.encoders.i;

import com.google.firebase.encoders.EncodingException;
import java.io.IOException;

/* JADX INFO: compiled from: ProtobufValueEncoderContext.java */
/* JADX INFO: loaded from: classes2.dex */
class i implements com.google.firebase.encoders.f {
    private boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f19615b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.google.firebase.encoders.b f19616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g f19617d;

    i(g gVar) {
        this.f19617d = gVar;
    }

    private void a() {
        if (this.a) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
        this.a = true;
    }

    void b(com.google.firebase.encoders.b bVar, boolean z) {
        this.a = false;
        this.f19616c = bVar;
        this.f19615b = z;
    }

    @Override // com.google.firebase.encoders.f
    public com.google.firebase.encoders.f f(String str) throws IOException {
        a();
        this.f19617d.j(this.f19616c, str, this.f19615b);
        return this;
    }

    @Override // com.google.firebase.encoders.f
    public com.google.firebase.encoders.f g(boolean z) throws IOException {
        a();
        this.f19617d.p(this.f19616c, z, this.f19615b);
        return this;
    }
}
