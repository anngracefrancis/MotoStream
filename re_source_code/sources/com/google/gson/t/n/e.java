package com.google.gson.t.n;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: JsonTreeReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends com.google.gson.stream.a {
    private static final Reader v = new a();
    private static final Object w = new Object();
    private int[] A;
    private Object[] x;
    private int y;
    private String[] z;

    /* JADX INFO: compiled from: JsonTreeReader.java */
    static class a extends Reader {
        a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i2, int i3) throws IOException {
            throw new AssertionError();
        }
    }

    private void E0(Object obj) {
        int i2 = this.y;
        Object[] objArr = this.x;
        if (i2 == objArr.length) {
            Object[] objArr2 = new Object[i2 * 2];
            int[] iArr = new int[i2 * 2];
            String[] strArr = new String[i2 * 2];
            System.arraycopy(objArr, 0, objArr2, 0, i2);
            System.arraycopy(this.A, 0, iArr, 0, this.y);
            System.arraycopy(this.z, 0, strArr, 0, this.y);
            this.x = objArr2;
            this.A = iArr;
            this.z = strArr;
        }
        Object[] objArr3 = this.x;
        int i3 = this.y;
        this.y = i3 + 1;
        objArr3[i3] = obj;
    }

    private void q0(com.google.gson.stream.b bVar) throws IOException {
        if (Q() == bVar) {
            return;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + Q() + x());
    }

    private Object t0() {
        return this.x[this.y - 1];
    }

    private String x() {
        return " at path " + g();
    }

    private Object x0() {
        Object[] objArr = this.x;
        int i2 = this.y - 1;
        this.y = i2;
        Object obj = objArr[i2];
        objArr[i2] = null;
        return obj;
    }

    @Override // com.google.gson.stream.a
    public int A() throws IOException {
        com.google.gson.stream.b bVarQ = Q();
        com.google.gson.stream.b bVar = com.google.gson.stream.b.NUMBER;
        if (bVarQ != bVar && bVarQ != com.google.gson.stream.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarQ + x());
        }
        int iT = ((com.google.gson.m) t0()).t();
        x0();
        int i2 = this.y;
        if (i2 > 0) {
            int[] iArr = this.A;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return iT;
    }

    @Override // com.google.gson.stream.a
    public long B() throws IOException {
        com.google.gson.stream.b bVarQ = Q();
        com.google.gson.stream.b bVar = com.google.gson.stream.b.NUMBER;
        if (bVarQ != bVar && bVarQ != com.google.gson.stream.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarQ + x());
        }
        long jU = ((com.google.gson.m) t0()).u();
        x0();
        int i2 = this.y;
        if (i2 > 0) {
            int[] iArr = this.A;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return jU;
    }

    @Override // com.google.gson.stream.a
    public String D() throws IOException {
        q0(com.google.gson.stream.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) t0()).next();
        String str = (String) entry.getKey();
        this.z[this.y - 1] = str;
        E0(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public void I() throws IOException {
        q0(com.google.gson.stream.b.NULL);
        x0();
        int i2 = this.y;
        if (i2 > 0) {
            int[] iArr = this.A;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String K() throws IOException {
        com.google.gson.stream.b bVarQ = Q();
        com.google.gson.stream.b bVar = com.google.gson.stream.b.STRING;
        if (bVarQ == bVar || bVarQ == com.google.gson.stream.b.NUMBER) {
            String strW = ((com.google.gson.m) x0()).w();
            int i2 = this.y;
            if (i2 > 0) {
                int[] iArr = this.A;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return strW;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + bVarQ + x());
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.b Q() throws IOException {
        if (this.y == 0) {
            return com.google.gson.stream.b.END_DOCUMENT;
        }
        Object objT0 = t0();
        if (objT0 instanceof Iterator) {
            boolean z = this.x[this.y - 2] instanceof com.google.gson.l;
            Iterator it = (Iterator) objT0;
            if (!it.hasNext()) {
                return z ? com.google.gson.stream.b.END_OBJECT : com.google.gson.stream.b.END_ARRAY;
            }
            if (z) {
                return com.google.gson.stream.b.NAME;
            }
            E0(it.next());
            return Q();
        }
        if (objT0 instanceof com.google.gson.l) {
            return com.google.gson.stream.b.BEGIN_OBJECT;
        }
        if (objT0 instanceof com.google.gson.g) {
            return com.google.gson.stream.b.BEGIN_ARRAY;
        }
        if (!(objT0 instanceof com.google.gson.m)) {
            if (objT0 instanceof com.google.gson.k) {
                return com.google.gson.stream.b.NULL;
            }
            if (objT0 == w) {
                throw new IllegalStateException("JsonReader is closed");
            }
            throw new AssertionError();
        }
        com.google.gson.m mVar = (com.google.gson.m) objT0;
        if (mVar.C()) {
            return com.google.gson.stream.b.STRING;
        }
        if (mVar.x()) {
            return com.google.gson.stream.b.BOOLEAN;
        }
        if (mVar.z()) {
            return com.google.gson.stream.b.NUMBER;
        }
        throw new AssertionError();
    }

    @Override // com.google.gson.stream.a
    public void a() throws IOException {
        q0(com.google.gson.stream.b.BEGIN_ARRAY);
        E0(((com.google.gson.g) t0()).iterator());
        this.A[this.y - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void b() throws IOException {
        q0(com.google.gson.stream.b.BEGIN_OBJECT);
        E0(((com.google.gson.l) t0()).r().iterator());
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.x = new Object[]{w};
        this.y = 1;
    }

    @Override // com.google.gson.stream.a
    public void f() throws IOException {
        q0(com.google.gson.stream.b.END_ARRAY);
        x0();
        x0();
        int i2 = this.y;
        if (i2 > 0) {
            int[] iArr = this.A;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String g() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = 0;
        while (i2 < this.y) {
            Object[] objArr = this.x;
            if (objArr[i2] instanceof com.google.gson.g) {
                i2++;
                if (objArr[i2] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.A[i2]);
                    sb.append(']');
                }
            } else if (objArr[i2] instanceof com.google.gson.l) {
                i2++;
                if (objArr[i2] instanceof Iterator) {
                    sb.append('.');
                    String[] strArr = this.z;
                    if (strArr[i2] != null) {
                        sb.append(strArr[i2]);
                    }
                }
            }
            i2++;
        }
        return sb.toString();
    }

    @Override // com.google.gson.stream.a
    public void j() throws IOException {
        q0(com.google.gson.stream.b.END_OBJECT);
        x0();
        x0();
        int i2 = this.y;
        if (i2 > 0) {
            int[] iArr = this.A;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean l() throws IOException {
        com.google.gson.stream.b bVarQ = Q();
        return (bVarQ == com.google.gson.stream.b.END_OBJECT || bVarQ == com.google.gson.stream.b.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public void n0() throws IOException {
        if (Q() == com.google.gson.stream.b.NAME) {
            D();
            this.z[this.y - 2] = "null";
        } else {
            x0();
            int i2 = this.y;
            if (i2 > 0) {
                this.z[i2 - 1] = "null";
            }
        }
        int i3 = this.y;
        if (i3 > 0) {
            int[] iArr = this.A;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return e.class.getSimpleName();
    }

    @Override // com.google.gson.stream.a
    public boolean y() throws IOException {
        q0(com.google.gson.stream.b.BOOLEAN);
        boolean zQ = ((com.google.gson.m) x0()).q();
        int i2 = this.y;
        if (i2 > 0) {
            int[] iArr = this.A;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return zQ;
    }

    public void y0() throws IOException {
        q0(com.google.gson.stream.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) t0()).next();
        E0(entry.getValue());
        E0(new com.google.gson.m((String) entry.getKey()));
    }

    @Override // com.google.gson.stream.a
    public double z() throws IOException {
        com.google.gson.stream.b bVarQ = Q();
        com.google.gson.stream.b bVar = com.google.gson.stream.b.NUMBER;
        if (bVarQ != bVar && bVarQ != com.google.gson.stream.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarQ + x());
        }
        double dS = ((com.google.gson.m) t0()).s();
        if (!m() && (Double.isNaN(dS) || Double.isInfinite(dS))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + dS);
        }
        x0();
        int i2 = this.y;
        if (i2 > 0) {
            int[] iArr = this.A;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return dS;
    }
}
