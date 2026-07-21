package com.google.gson.t.n;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: JsonTreeWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends com.google.gson.stream.c {
    private static final Writer q = new a();
    private static final com.google.gson.m r = new com.google.gson.m("closed");
    private final List<com.google.gson.j> s;
    private String t;
    private com.google.gson.j u;

    /* JADX INFO: compiled from: JsonTreeWriter.java */
    static class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) {
            throw new AssertionError();
        }
    }

    public f() {
        super(q);
        this.s = new ArrayList();
        this.u = com.google.gson.k.a;
    }

    private com.google.gson.j f0() {
        List<com.google.gson.j> list = this.s;
        return list.get(list.size() - 1);
    }

    private void i0(com.google.gson.j jVar) {
        if (this.t != null) {
            if (!jVar.i() || k()) {
                ((com.google.gson.l) f0()).q(this.t, jVar);
            }
            this.t = null;
            return;
        }
        if (this.s.isEmpty()) {
            this.u = jVar;
            return;
        }
        com.google.gson.j jVarF0 = f0();
        if (!(jVarF0 instanceof com.google.gson.g)) {
            throw new IllegalStateException();
        }
        ((com.google.gson.g) jVarF0).q(jVar);
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c Q(long j2) throws IOException {
        i0(new com.google.gson.m(Long.valueOf(j2)));
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c T(Boolean bool) throws IOException {
        if (bool == null) {
            return y();
        }
        i0(new com.google.gson.m(bool));
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c W(Number number) throws IOException {
        if (number == null) {
            return y();
        }
        if (!m()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        i0(new com.google.gson.m(number));
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c Y(String str) throws IOException {
        if (str == null) {
            return y();
        }
        i0(new com.google.gson.m(str));
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c Z(boolean z) throws IOException {
        i0(new com.google.gson.m(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c c() throws IOException {
        com.google.gson.g gVar = new com.google.gson.g();
        i0(gVar);
        this.s.add(gVar);
        return this;
    }

    @Override // com.google.gson.stream.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.s.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.s.add(r);
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c d() throws IOException {
        com.google.gson.l lVar = new com.google.gson.l();
        i0(lVar);
        this.s.add(lVar);
        return this;
    }

    public com.google.gson.j e0() {
        if (this.s.isEmpty()) {
            return this.u;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.s);
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c f() throws IOException {
        if (this.s.isEmpty() || this.t != null) {
            throw new IllegalStateException();
        }
        if (!(f0() instanceof com.google.gson.g)) {
            throw new IllegalStateException();
        }
        List<com.google.gson.j> list = this.s;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // com.google.gson.stream.c, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c j() throws IOException {
        if (this.s.isEmpty() || this.t != null) {
            throw new IllegalStateException();
        }
        if (!(f0() instanceof com.google.gson.l)) {
            throw new IllegalStateException();
        }
        List<com.google.gson.j> list = this.s;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c p(String str) throws IOException {
        if (this.s.isEmpty() || this.t != null) {
            throw new IllegalStateException();
        }
        if (!(f0() instanceof com.google.gson.l)) {
            throw new IllegalStateException();
        }
        this.t = str;
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c y() throws IOException {
        i0(com.google.gson.k.a);
        return this;
    }
}
