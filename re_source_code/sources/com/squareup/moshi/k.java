package com.squareup.moshi;

import cm.aptoide.pt.account.AdultContentAnalytics;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;

/* JADX INFO: compiled from: JsonUtf8Reader.java */
/* JADX INFO: loaded from: classes2.dex */
final class k extends i {
    private static final j.i l = j.i.v("'\\");
    private static final j.i m = j.i.v("\"\\");
    private static final j.i n = j.i.v("{}[]:, \n\t\r\f/\\;#=");
    private static final j.i o = j.i.v("\n\r");
    private static final j.i p = j.i.v("*/");
    private final j.h q;
    private final j.f r;
    private int s = 0;
    private long t;
    private int u;
    private String v;

    k(j.h hVar) {
        if (hVar == null) {
            throw new NullPointerException("source == null");
        }
        this.q = hVar;
        this.r = hVar.i();
        D(6);
    }

    private boolean E0() throws IOException {
        j.h hVar = this.q;
        j.i iVar = p;
        long jP = hVar.P(iVar);
        boolean z = jP != -1;
        j.f fVar = this.r;
        fVar.skip(z ? jP + ((long) iVar.P()) : fVar.size());
        return z;
    }

    private void F0() throws IOException {
        long jB0 = this.q.b0(o);
        j.f fVar = this.r;
        fVar.skip(jB0 != -1 ? jB0 + 1 : fVar.size());
    }

    private void G0() throws IOException {
        long jB0 = this.q.b0(n);
        j.f fVar = this.r;
        if (jB0 == -1) {
            jB0 = fVar.size();
        }
        fVar.skip(jB0);
    }

    private void Y() throws IOException {
        if (!this.f20560j) {
            throw T("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int Z() throws IOException {
        int[] iArr = this.f20557g;
        int i2 = this.f20556f;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int iM0 = m0(true);
            this.r.readByte();
            if (iM0 != 44) {
                if (iM0 != 59) {
                    if (iM0 != 93) {
                        throw T("Unterminated array");
                    }
                    this.s = 4;
                    return 4;
                }
                Y();
            }
        } else {
            if (i3 == 3 || i3 == 5) {
                iArr[i2 - 1] = 4;
                if (i3 == 5) {
                    int iM1 = m0(true);
                    this.r.readByte();
                    if (iM1 != 44) {
                        if (iM1 != 59) {
                            if (iM1 != 125) {
                                throw T("Unterminated object");
                            }
                            this.s = 2;
                            return 2;
                        }
                        Y();
                    }
                }
                int iM2 = m0(true);
                if (iM2 == 34) {
                    this.r.readByte();
                    this.s = 13;
                    return 13;
                }
                if (iM2 == 39) {
                    this.r.readByte();
                    Y();
                    this.s = 12;
                    return 12;
                }
                if (iM2 != 125) {
                    Y();
                    if (!f0((char) iM2)) {
                        throw T("Expected name");
                    }
                    this.s = 14;
                    return 14;
                }
                if (i3 == 5) {
                    throw T("Expected name");
                }
                this.r.readByte();
                this.s = 2;
                return 2;
            }
            if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int iM3 = m0(true);
                this.r.readByte();
                if (iM3 != 58) {
                    if (iM3 != 61) {
                        throw T("Expected ':'");
                    }
                    Y();
                    if (this.q.request(1L) && this.r.m(0L) == 62) {
                        this.r.readByte();
                    }
                }
            } else if (i3 == 6) {
                iArr[i2 - 1] = 7;
            } else if (i3 == 7) {
                if (m0(false) == -1) {
                    this.s = 18;
                    return 18;
                }
                Y();
            } else {
                if (i3 == 9) {
                    throw null;
                }
                if (i3 == 8) {
                    throw new IllegalStateException("JsonReader is closed");
                }
            }
        }
        int iM4 = m0(true);
        if (iM4 == 34) {
            this.r.readByte();
            this.s = 9;
            return 9;
        }
        if (iM4 == 39) {
            Y();
            this.r.readByte();
            this.s = 8;
            return 8;
        }
        if (iM4 != 44 && iM4 != 59) {
            if (iM4 == 91) {
                this.r.readByte();
                this.s = 3;
                return 3;
            }
            if (iM4 != 93) {
                if (iM4 == 123) {
                    this.r.readByte();
                    this.s = 1;
                    return 1;
                }
                int iQ0 = q0();
                if (iQ0 != 0) {
                    return iQ0;
                }
                int iT0 = t0();
                if (iT0 != 0) {
                    return iT0;
                }
                if (!f0(this.r.m(0L))) {
                    throw T("Expected value");
                }
                Y();
                this.s = 10;
                return 10;
            }
            if (i3 == 1) {
                this.r.readByte();
                this.s = 4;
                return 4;
            }
        }
        if (i3 != 1 && i3 != 2) {
            throw T("Unexpected value");
        }
        Y();
        this.s = 7;
        return 7;
    }

    private int a0(String str, i.a aVar) {
        int length = aVar.a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(aVar.a[i2])) {
                this.s = 0;
                this.f20558h[this.f20556f - 1] = str;
                return i2;
            }
        }
        return -1;
    }

    private int e0(String str, i.a aVar) {
        int length = aVar.a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(aVar.a[i2])) {
                this.s = 0;
                int[] iArr = this.f20559i;
                int i3 = this.f20556f - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
        }
        return -1;
    }

    private boolean f0(int i2) throws IOException {
        if (i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13 || i2 == 32) {
            return false;
        }
        if (i2 != 35) {
            if (i2 == 44) {
                return false;
            }
            if (i2 != 47 && i2 != 61) {
                if (i2 == 123 || i2 == 125 || i2 == 58) {
                    return false;
                }
                if (i2 != 59) {
                    switch (i2) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        Y();
        return false;
    }

    private int m0(boolean z) throws IOException {
        int i2;
        int i3;
        byte bM;
        while (true) {
            while (true) {
                i3 = i2 + 1;
                if (!this.q.request(i3)) {
                    if (z) {
                        throw new EOFException("End of input");
                    }
                    return -1;
                }
                bM = this.r.m(i2);
                i2 = (bM == 10 || bM == 32 || bM == 13 || bM == 9) ? i3 : 0;
            }
            this.r.skip(i3 - 1);
            if (bM == 47) {
                if (!this.q.request(2L)) {
                    return bM;
                }
                Y();
                byte bM2 = this.r.m(1L);
                if (bM2 == 42) {
                    this.r.readByte();
                    this.r.readByte();
                    if (!E0()) {
                        throw T("Unterminated comment");
                    }
                } else {
                    if (bM2 != 47) {
                        return bM;
                    }
                    this.r.readByte();
                    this.r.readByte();
                    F0();
                }
            } else {
                if (bM != 35) {
                    return bM;
                }
                Y();
                F0();
            }
        }
    }

    private String n0(j.i iVar) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long jB0 = this.q.b0(iVar);
            if (jB0 == -1) {
                throw T("Unterminated string");
            }
            if (this.r.m(jB0) != 92) {
                if (sb == null) {
                    String strZ = this.r.Z(jB0);
                    this.r.readByte();
                    return strZ;
                }
                sb.append(this.r.Z(jB0));
                this.r.readByte();
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(this.r.Z(jB0));
            this.r.readByte();
            sb.append(x0());
        }
    }

    private String p0() throws IOException {
        long jB0 = this.q.b0(n);
        return jB0 != -1 ? this.r.Z(jB0) : this.r.T();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private int q0() throws IOException {
        int i2;
        String str;
        String str2;
        byte bM = this.r.m(0L);
        if (bM == 116 || bM == 84) {
            i2 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (bM == 102 || bM == 70) {
            i2 = 6;
            str = AdultContentAnalytics.UNLOCK;
            str2 = "FALSE";
        } else {
            if (bM != 110 && bM != 78) {
                return 0;
            }
            i2 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        int i3 = 1;
        while (i3 < length) {
            int i4 = i3 + 1;
            if (!this.q.request(i4)) {
                return 0;
            }
            byte bM2 = this.r.m(i3);
            if (bM2 != str.charAt(i3) && bM2 != str2.charAt(i3)) {
                return 0;
            }
            i3 = i4;
        }
        if (this.q.request(length + 1) && f0(this.r.m(length))) {
            return 0;
        }
        this.r.skip(length);
        this.s = i2;
        return i2;
    }

    private int t0() throws IOException {
        boolean z = true;
        int i2 = 0;
        long j2 = 0;
        int i3 = 0;
        char c2 = 0;
        boolean z2 = true;
        boolean z3 = false;
        while (true) {
            int i4 = i3 + 1;
            if (!this.q.request(i4)) {
                break;
            }
            byte bM = this.r.m(i3);
            if (bM != 43) {
                if (bM == 69 || bM == 101) {
                    if (c2 != 2 && c2 != 4) {
                        return i2;
                    }
                    c2 = 5;
                } else if (bM != 45) {
                    if (bM != 46) {
                        if (bM < 48 || bM > 57) {
                            if (!f0(bM)) {
                                break;
                            }
                            return 0;
                        }
                        if (c2 == z || c2 == 0) {
                            j2 = -(bM - 48);
                            i2 = 0;
                            c2 = 2;
                        } else {
                            if (c2 == 2) {
                                if (j2 == 0) {
                                    return i2;
                                }
                                long j3 = (10 * j2) - ((long) (bM - 48));
                                z2 &= j2 > -922337203685477580L || (j2 == -922337203685477580L && j3 < j2);
                                j2 = j3;
                            } else if (c2 == 3) {
                                i2 = 0;
                                c2 = 4;
                            } else if (c2 == 5 || c2 == 6) {
                                i2 = 0;
                                c2 = 7;
                            }
                            i2 = 0;
                        }
                    } else {
                        if (c2 != 2) {
                            return i2;
                        }
                        c2 = 3;
                    }
                } else if (c2 == 0) {
                    c2 = 1;
                    z3 = true;
                } else if (c2 != 5) {
                    return i2;
                }
                i3 = i4;
                z = true;
            } else if (c2 != 5) {
                return i2;
            }
            c2 = 6;
            i3 = i4;
            z = true;
        }
        if (c2 == 2 && z2 && ((j2 != Long.MIN_VALUE || z3) && (j2 != 0 || !z3))) {
            if (!z3) {
                j2 = -j2;
            }
            this.t = j2;
            this.r.skip(i3);
            this.s = 16;
            return 16;
        }
        if (c2 != 2 && c2 != 4 && c2 != 7) {
            return 0;
        }
        this.u = i3;
        this.s = 17;
        return 17;
    }

    private char x0() throws IOException {
        int i2;
        int i3;
        if (!this.q.request(1L)) {
            throw T("Unterminated escape sequence");
        }
        byte b2 = this.r.readByte();
        if (b2 == 10 || b2 == 34 || b2 == 39 || b2 == 47 || b2 == 92) {
            return (char) b2;
        }
        if (b2 == 98) {
            return '\b';
        }
        if (b2 == 102) {
            return '\f';
        }
        if (b2 == 110) {
            return '\n';
        }
        if (b2 == 114) {
            return '\r';
        }
        if (b2 == 116) {
            return '\t';
        }
        if (b2 != 117) {
            if (this.f20560j) {
                return (char) b2;
            }
            throw T("Invalid escape sequence: \\" + ((char) b2));
        }
        if (!this.q.request(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + g());
        }
        char c2 = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            byte bM = this.r.m(i4);
            char c3 = (char) (c2 << 4);
            if (bM < 48 || bM > 57) {
                if (bM >= 97 && bM <= 102) {
                    i2 = bM - 97;
                } else {
                    if (bM < 65 || bM > 70) {
                        throw T("\\u" + this.r.Z(4L));
                    }
                    i2 = bM - 65;
                }
                i3 = i2 + 10;
            } else {
                i3 = bM - 48;
            }
            c2 = (char) (c3 + i3);
        }
        this.r.skip(4L);
        return c2;
    }

    private void y0(j.i iVar) throws IOException {
        while (true) {
            long jB0 = this.q.b0(iVar);
            if (jB0 == -1) {
                throw T("Unterminated string");
            }
            if (this.r.m(jB0) != 92) {
                this.r.skip(jB0 + 1);
                return;
            } else {
                this.r.skip(jB0 + 1);
                x0();
            }
        }
    }

    @Override // com.squareup.moshi.i
    public i.b A() throws IOException {
        int iZ = this.s;
        if (iZ == 0) {
            iZ = Z();
        }
        switch (iZ) {
            case 1:
                return i.b.BEGIN_OBJECT;
            case 2:
                return i.b.END_OBJECT;
            case 3:
                return i.b.BEGIN_ARRAY;
            case 4:
                return i.b.END_ARRAY;
            case 5:
            case 6:
                return i.b.BOOLEAN;
            case 7:
                return i.b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return i.b.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return i.b.NAME;
            case 16:
            case 17:
                return i.b.NUMBER;
            case 18:
                return i.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.squareup.moshi.i
    public void B() throws IOException {
        if (f()) {
            this.v = i0();
            this.s = 11;
        }
    }

    @Override // com.squareup.moshi.i
    public int H(i.a aVar) throws IOException {
        int iZ = this.s;
        if (iZ == 0) {
            iZ = Z();
        }
        if (iZ < 12 || iZ > 15) {
            return -1;
        }
        if (iZ == 15) {
            return a0(this.v, aVar);
        }
        int iP1 = this.q.p1(aVar.f20562b);
        if (iP1 != -1) {
            this.s = 0;
            this.f20558h[this.f20556f - 1] = aVar.a[iP1];
            return iP1;
        }
        String str = this.f20558h[this.f20556f - 1];
        String strI0 = i0();
        int iA0 = a0(strI0, aVar);
        if (iA0 == -1) {
            this.s = 15;
            this.v = strI0;
            this.f20558h[this.f20556f - 1] = str;
        }
        return iA0;
    }

    @Override // com.squareup.moshi.i
    public int I(i.a aVar) throws IOException {
        int iZ = this.s;
        if (iZ == 0) {
            iZ = Z();
        }
        if (iZ < 8 || iZ > 11) {
            return -1;
        }
        if (iZ == 11) {
            return e0(this.v, aVar);
        }
        int iP1 = this.q.p1(aVar.f20562b);
        if (iP1 != -1) {
            this.s = 0;
            int[] iArr = this.f20559i;
            int i2 = this.f20556f - 1;
            iArr[i2] = iArr[i2] + 1;
            return iP1;
        }
        String strY = y();
        int iE0 = e0(strY, aVar);
        if (iE0 == -1) {
            this.s = 11;
            this.v = strY;
            int[] iArr2 = this.f20559i;
            int i3 = this.f20556f - 1;
            iArr2[i3] = iArr2[i3] - 1;
        }
        return iE0;
    }

    @Override // com.squareup.moshi.i
    public void N() throws IOException {
        if (this.f20561k) {
            i.b bVarA = A();
            i0();
            throw new JsonDataException("Cannot skip unexpected " + bVarA + " at " + g());
        }
        int iZ = this.s;
        if (iZ == 0) {
            iZ = Z();
        }
        if (iZ == 14) {
            G0();
        } else if (iZ == 13) {
            y0(m);
        } else if (iZ == 12) {
            y0(l);
        } else if (iZ != 15) {
            throw new JsonDataException("Expected a name but was " + A() + " at path " + g());
        }
        this.s = 0;
        this.f20558h[this.f20556f - 1] = "null";
    }

    @Override // com.squareup.moshi.i
    public void Q() throws IOException {
        if (this.f20561k) {
            throw new JsonDataException("Cannot skip unexpected " + A() + " at " + g());
        }
        int i2 = 0;
        do {
            int iZ = this.s;
            if (iZ == 0) {
                iZ = Z();
            }
            if (iZ == 3) {
                D(1);
            } else {
                if (iZ == 1) {
                    D(3);
                } else if (iZ == 4) {
                    i2--;
                    if (i2 < 0) {
                        throw new JsonDataException("Expected a value but was " + A() + " at path " + g());
                    }
                    this.f20556f--;
                } else if (iZ == 2) {
                    i2--;
                    if (i2 < 0) {
                        throw new JsonDataException("Expected a value but was " + A() + " at path " + g());
                    }
                    this.f20556f--;
                } else if (iZ == 14 || iZ == 10) {
                    G0();
                } else if (iZ == 9 || iZ == 13) {
                    y0(m);
                } else if (iZ == 8 || iZ == 12) {
                    y0(l);
                } else if (iZ == 17) {
                    this.r.skip(this.u);
                } else if (iZ == 18) {
                    throw new JsonDataException("Expected a value but was " + A() + " at path " + g());
                }
                this.s = 0;
            }
            i2++;
            this.s = 0;
        } while (i2 != 0);
        int[] iArr = this.f20559i;
        int i3 = this.f20556f;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.f20558h[i3 - 1] = "null";
    }

    @Override // com.squareup.moshi.i
    public void a() throws IOException {
        int iZ = this.s;
        if (iZ == 0) {
            iZ = Z();
        }
        if (iZ == 3) {
            D(1);
            this.f20559i[this.f20556f - 1] = 0;
            this.s = 0;
        } else {
            throw new JsonDataException("Expected BEGIN_ARRAY but was " + A() + " at path " + g());
        }
    }

    @Override // com.squareup.moshi.i
    public void b() throws IOException {
        int iZ = this.s;
        if (iZ == 0) {
            iZ = Z();
        }
        if (iZ == 1) {
            D(3);
            this.s = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + A() + " at path " + g());
    }

    @Override // com.squareup.moshi.i
    public void c() throws IOException {
        int iZ = this.s;
        if (iZ == 0) {
            iZ = Z();
        }
        if (iZ != 4) {
            throw new JsonDataException("Expected END_ARRAY but was " + A() + " at path " + g());
        }
        int i2 = this.f20556f - 1;
        this.f20556f = i2;
        int[] iArr = this.f20559i;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.s = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.s = 0;
        this.f20557g[0] = 8;
        this.f20556f = 1;
        this.r.b();
        this.q.close();
    }

    @Override // com.squareup.moshi.i
    public void d() throws IOException {
        int iZ = this.s;
        if (iZ == 0) {
            iZ = Z();
        }
        if (iZ != 2) {
            throw new JsonDataException("Expected END_OBJECT but was " + A() + " at path " + g());
        }
        int i2 = this.f20556f - 1;
        this.f20556f = i2;
        this.f20558h[i2] = null;
        int[] iArr = this.f20559i;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.s = 0;
    }

    @Override // com.squareup.moshi.i
    public boolean f() throws IOException {
        int iZ = this.s;
        if (iZ == 0) {
            iZ = Z();
        }
        return (iZ == 2 || iZ == 4 || iZ == 18) ? false : true;
    }

    public String i0() throws IOException {
        String strN0;
        int iZ = this.s;
        if (iZ == 0) {
            iZ = Z();
        }
        if (iZ == 14) {
            strN0 = p0();
        } else if (iZ == 13) {
            strN0 = n0(m);
        } else if (iZ == 12) {
            strN0 = n0(l);
        } else {
            if (iZ != 15) {
                throw new JsonDataException("Expected a name but was " + A() + " at path " + g());
            }
            strN0 = this.v;
            this.v = null;
        }
        this.s = 0;
        this.f20558h[this.f20556f - 1] = strN0;
        return strN0;
    }

    @Override // com.squareup.moshi.i
    public boolean k() throws IOException {
        int iZ = this.s;
        if (iZ == 0) {
            iZ = Z();
        }
        if (iZ == 5) {
            this.s = 0;
            int[] iArr = this.f20559i;
            int i2 = this.f20556f - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (iZ == 6) {
            this.s = 0;
            int[] iArr2 = this.f20559i;
            int i3 = this.f20556f - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        }
        throw new JsonDataException("Expected a boolean but was " + A() + " at path " + g());
    }

    @Override // com.squareup.moshi.i
    public double l() throws IOException {
        int iZ = this.s;
        if (iZ == 0) {
            iZ = Z();
        }
        if (iZ == 16) {
            this.s = 0;
            int[] iArr = this.f20559i;
            int i2 = this.f20556f - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.t;
        }
        if (iZ == 17) {
            this.v = this.r.Z(this.u);
        } else if (iZ == 9) {
            this.v = n0(m);
        } else if (iZ == 8) {
            this.v = n0(l);
        } else if (iZ == 10) {
            this.v = p0();
        } else if (iZ != 11) {
            throw new JsonDataException("Expected a double but was " + A() + " at path " + g());
        }
        this.s = 11;
        try {
            double d2 = Double.parseDouble(this.v);
            if (this.f20560j || !(Double.isNaN(d2) || Double.isInfinite(d2))) {
                this.v = null;
                this.s = 0;
                int[] iArr2 = this.f20559i;
                int i3 = this.f20556f - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return d2;
            }
            throw new JsonEncodingException("JSON forbids NaN and infinities: " + d2 + " at path " + g());
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.v + " at path " + g());
        }
    }

    @Override // com.squareup.moshi.i
    public int m() throws IOException {
        int iZ = this.s;
        if (iZ == 0) {
            iZ = Z();
        }
        if (iZ == 16) {
            long j2 = this.t;
            int i2 = (int) j2;
            if (j2 == i2) {
                this.s = 0;
                int[] iArr = this.f20559i;
                int i3 = this.f20556f - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new JsonDataException("Expected an int but was " + this.t + " at path " + g());
        }
        if (iZ == 17) {
            this.v = this.r.Z(this.u);
        } else if (iZ == 9 || iZ == 8) {
            String strN0 = iZ == 9 ? n0(m) : n0(l);
            this.v = strN0;
            try {
                int i4 = Integer.parseInt(strN0);
                this.s = 0;
                int[] iArr2 = this.f20559i;
                int i5 = this.f20556f - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return i4;
            } catch (NumberFormatException unused) {
            }
        } else if (iZ != 11) {
            throw new JsonDataException("Expected an int but was " + A() + " at path " + g());
        }
        this.s = 11;
        try {
            double d2 = Double.parseDouble(this.v);
            int i6 = (int) d2;
            if (i6 == d2) {
                this.v = null;
                this.s = 0;
                int[] iArr3 = this.f20559i;
                int i7 = this.f20556f - 1;
                iArr3[i7] = iArr3[i7] + 1;
                return i6;
            }
            throw new JsonDataException("Expected an int but was " + this.v + " at path " + g());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.v + " at path " + g());
        }
    }

    @Override // com.squareup.moshi.i
    public long p() throws IOException {
        int iZ = this.s;
        if (iZ == 0) {
            iZ = Z();
        }
        if (iZ == 16) {
            this.s = 0;
            int[] iArr = this.f20559i;
            int i2 = this.f20556f - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.t;
        }
        if (iZ == 17) {
            this.v = this.r.Z(this.u);
        } else if (iZ == 9 || iZ == 8) {
            String strN0 = iZ == 9 ? n0(m) : n0(l);
            this.v = strN0;
            try {
                long j2 = Long.parseLong(strN0);
                this.s = 0;
                int[] iArr2 = this.f20559i;
                int i3 = this.f20556f - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return j2;
            } catch (NumberFormatException unused) {
            }
        } else if (iZ != 11) {
            throw new JsonDataException("Expected a long but was " + A() + " at path " + g());
        }
        this.s = 11;
        try {
            long jLongValueExact = new BigDecimal(this.v).longValueExact();
            this.v = null;
            this.s = 0;
            int[] iArr3 = this.f20559i;
            int i4 = this.f20556f - 1;
            iArr3[i4] = iArr3[i4] + 1;
            return jLongValueExact;
        } catch (ArithmeticException | NumberFormatException unused2) {
            throw new JsonDataException("Expected a long but was " + this.v + " at path " + g());
        }
    }

    public String toString() {
        return "JsonReader(" + this.q + ")";
    }

    @Override // com.squareup.moshi.i
    public <T> T x() throws IOException {
        int iZ = this.s;
        if (iZ == 0) {
            iZ = Z();
        }
        if (iZ == 7) {
            this.s = 0;
            int[] iArr = this.f20559i;
            int i2 = this.f20556f - 1;
            iArr[i2] = iArr[i2] + 1;
            return null;
        }
        throw new JsonDataException("Expected null but was " + A() + " at path " + g());
    }

    @Override // com.squareup.moshi.i
    public String y() throws IOException {
        String strZ;
        int iZ = this.s;
        if (iZ == 0) {
            iZ = Z();
        }
        if (iZ == 10) {
            strZ = p0();
        } else if (iZ == 9) {
            strZ = n0(m);
        } else if (iZ == 8) {
            strZ = n0(l);
        } else if (iZ == 11) {
            strZ = this.v;
            this.v = null;
        } else if (iZ == 16) {
            strZ = Long.toString(this.t);
        } else {
            if (iZ != 17) {
                throw new JsonDataException("Expected a string but was " + A() + " at path " + g());
            }
            strZ = this.r.Z(this.u);
        }
        this.s = 0;
        int[] iArr = this.f20559i;
        int i2 = this.f20556f - 1;
        iArr[i2] = iArr[i2] + 1;
        return strZ;
    }
}
