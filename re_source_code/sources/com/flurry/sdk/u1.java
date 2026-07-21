package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class u1<T> implements v1<List<T>> {
    v1<T> a;

    final class a extends DataOutputStream {
        a(OutputStream outputStream) {
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

    public u1(v1<T> v1Var) {
        this.a = v1Var;
    }

    @Override // com.flurry.sdk.v1
    public final /* synthetic */ void a(OutputStream outputStream, Object obj) throws IOException {
        List list = (List) obj;
        if (outputStream != null) {
            a aVar = new a(outputStream);
            int size = list != null ? list.size() : 0;
            aVar.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.a.a(outputStream, (T) list.get(i2));
            }
            aVar.flush();
        }
    }

    @Override // com.flurry.sdk.v1
    public final /* synthetic */ Object b(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        int i2 = new b(inputStream).readInt();
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            T tB = this.a.b(inputStream);
            if (tB == null) {
                throw new IOException("Missing record.");
            }
            arrayList.add(tB);
        }
        return arrayList;
    }
}
