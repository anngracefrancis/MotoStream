package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class s0 {
    String a;

    public static class a implements v1<s0> {

        /* JADX INFO: renamed from: com.flurry.sdk.s0$a$a, reason: collision with other inner class name */
        final class C0167a extends DataOutputStream {
            C0167a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
            }
        }

        final class b extends DataInputStream {
            b(InputStream inputStream) {
                super(inputStream);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
            }
        }

        @Override // com.flurry.sdk.v1
        public final /* synthetic */ void a(OutputStream outputStream, s0 s0Var) throws IOException {
            s0 s0Var2 = s0Var;
            if (outputStream == null || s0Var2 == null) {
                return;
            }
            C0167a c0167a = new C0167a(outputStream);
            c0167a.writeUTF(s0Var2.a);
            c0167a.flush();
        }

        @Override // com.flurry.sdk.v1
        public final /* synthetic */ s0 b(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            b bVar = new b(inputStream);
            s0 s0Var = new s0((byte) 0);
            s0Var.a = bVar.readUTF();
            return s0Var;
        }
    }

    /* synthetic */ s0(byte b2) {
        this();
    }

    private s0() {
    }

    public s0(String str) {
        this.a = str;
    }
}
