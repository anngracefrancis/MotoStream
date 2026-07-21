package kotlin.p002reflect.jvm.internal.impl.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: AbstractMessageLite.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f25392f = 0;

    UninitializedMessageException a() {
        return new UninitializedMessageException(this);
    }

    public void i(OutputStream outputStream) throws IOException {
        int iE = e();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(outputStream, CodedOutputStream.u(CodedOutputStream.v(iE) + iE));
        codedOutputStreamJ.o0(iE);
        h(codedOutputStreamJ);
        codedOutputStreamJ.I();
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractMessageLite.java */
    public static abstract class AbstractC0413a<BuilderType extends AbstractC0413a> implements o.a {
        protected static UninitializedMessageException j(o oVar) {
            return new UninitializedMessageException(oVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        public abstract BuilderType i(e eVar, f fVar) throws IOException;

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AbstractMessageLite.java */
        static final class C0414a extends FilterInputStream {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private int f25393f;

            C0414a(InputStream inputStream, int i2) {
                super(inputStream);
                this.f25393f = i2;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.f25393f);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.f25393f <= 0) {
                    return -1;
                }
                int i2 = super.read();
                if (i2 >= 0) {
                    this.f25393f--;
                }
                return i2;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j2) throws IOException {
                long jSkip = super.skip(Math.min(j2, this.f25393f));
                if (jSkip >= 0) {
                    this.f25393f = (int) (((long) this.f25393f) - jSkip);
                }
                return jSkip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i2, int i3) throws IOException {
                int i4 = this.f25393f;
                if (i4 <= 0) {
                    return -1;
                }
                int i5 = super.read(bArr, i2, Math.min(i3, i4));
                if (i5 >= 0) {
                    this.f25393f -= i5;
                }
                return i5;
            }
        }
    }
}
