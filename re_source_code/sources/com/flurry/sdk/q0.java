package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 {
    String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    byte[] f11010b;

    static class a implements y1<q0> {
        a() {
        }

        @Override // com.flurry.sdk.y1
        public final v1<q0> a(int i2) {
            return new b(i2);
        }
    }

    public static class b implements v1<q0> {
        private int a;

        final class a extends DataOutputStream {
            a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
            }
        }

        /* JADX INFO: renamed from: com.flurry.sdk.q0$b$b, reason: collision with other inner class name */
        final class C0165b extends DataInputStream {
            C0165b(InputStream inputStream) {
                super(inputStream);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
            }
        }

        public b(int i2) {
            this.a = 1;
            this.a = i2;
        }

        @Override // com.flurry.sdk.v1
        public final /* synthetic */ void a(OutputStream outputStream, q0 q0Var) throws IOException {
            q0 q0Var2 = q0Var;
            if (outputStream == null || q0Var2 == null) {
                return;
            }
            a aVar = new a(outputStream);
            int length = q0Var2.f11010b.length;
            if (this.a == 1) {
                aVar.writeShort(length);
            } else {
                aVar.writeInt(length);
            }
            aVar.write(q0Var2.f11010b);
            aVar.writeShort(0);
            aVar.flush();
        }

        @Override // com.flurry.sdk.v1
        public final /* synthetic */ q0 b(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            C0165b c0165b = new C0165b(inputStream);
            q0 q0Var = new q0((byte) 0);
            int i2 = this.a == 1 ? c0165b.readShort() : c0165b.readInt();
            if (i2 == 0) {
                return null;
            }
            byte[] bArr = new byte[i2];
            q0Var.f11010b = bArr;
            c0165b.readFully(bArr);
            c0165b.readUnsignedShort();
            return q0Var;
        }
    }

    /* synthetic */ q0(byte b2) {
        this();
    }

    public static String a(String str) {
        return ".yflurrydatasenderblock.".concat(String.valueOf(str));
    }

    public static c7<q0> b(String str) {
        return new c7<>(b0.a().getFileStreamPath(a(str)), ".yflurrydatasenderblock.", 2, new a());
    }

    private q0() {
        this.a = null;
        this.f11010b = null;
    }

    public q0(byte[] bArr) {
        this.a = null;
        this.f11010b = null;
        this.a = UUID.randomUUID().toString();
        this.f11010b = bArr;
    }
}
