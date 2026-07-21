package kotlin.p002reflect.jvm.internal.impl.protobuf;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: BoundedByteString.java */
/* JADX INFO: loaded from: classes3.dex */
class c extends n {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f25394i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f25395j;

    /* JADX INFO: compiled from: BoundedByteString.java */
    private class b implements d.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f25396f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f25397g;

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(f());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d.a
        public byte f() {
            int i2 = this.f25396f;
            if (i2 >= this.f25397g) {
                throw new NoSuchElementException();
            }
            byte[] bArr = c.this.f25448g;
            this.f25396f = i2 + 1;
            return bArr[i2];
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25396f < this.f25397g;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private b() {
            int iM = c.this.M();
            this.f25396f = iM;
            this.f25397g = iM + c.this.size();
        }
    }

    c(byte[] bArr, int i2, int i3) {
        super(bArr);
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(29);
            sb.append("Offset too small: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i3 < 0) {
            StringBuilder sb2 = new StringBuilder(29);
            sb2.append("Length too small: ");
            sb2.append(i2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (((long) i2) + ((long) i3) <= bArr.length) {
            this.f25394i = i2;
            this.f25395j = i3;
            return;
        }
        StringBuilder sb3 = new StringBuilder(48);
        sb3.append("Offset+Length too large: ");
        sb3.append(i2);
        sb3.append("+");
        sb3.append(i3);
        throw new IllegalArgumentException(sb3.toString());
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.n
    public byte G(int i2) {
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(28);
            sb.append("Index too small: ");
            sb.append(i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        if (i2 < size()) {
            return this.f25448g[this.f25394i + i2];
        }
        int size = size();
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append("Index too large: ");
        sb2.append(i2);
        sb2.append(", ");
        sb2.append(size);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.n
    protected int M() {
        return this.f25394i;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.n, kotlin.p002reflect.jvm.internal.impl.protobuf.d
    protected void q(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.f25448g, M() + i2, bArr, i3, i4);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.n, kotlin.p002reflect.jvm.internal.impl.protobuf.d
    public int size() {
        return this.f25395j;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.n, kotlin.p002reflect.jvm.internal.impl.protobuf.d, java.lang.Iterable
    /* JADX INFO: renamed from: u */
    public d.a iterator() {
        return new b();
    }
}
