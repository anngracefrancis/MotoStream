package i.a.g;

import com.google.android.gms.ads.AdRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DNSIncoming.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static k.b.b f21758h = k.b.c.i(c.class.getName());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f21759i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final char[] f21760j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final DatagramPacket f21761k;
    private final long l;
    private final b m;
    private int n;

    /* JADX INFO: compiled from: DNSIncoming.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f21762b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f21763c;

        static {
            int[] iArr = new int[i.a.g.s.e.values().length];
            f21763c = iArr;
            try {
                iArr[i.a.g.s.e.TYPE_A.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21763c[i.a.g.s.e.TYPE_AAAA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21763c[i.a.g.s.e.TYPE_CNAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21763c[i.a.g.s.e.TYPE_PTR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f21763c[i.a.g.s.e.TYPE_TXT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f21763c[i.a.g.s.e.TYPE_SRV.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f21763c[i.a.g.s.e.TYPE_HINFO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f21763c[i.a.g.s.e.TYPE_OPT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[i.a.g.s.c.values().length];
            f21762b = iArr2;
            try {
                iArr2[i.a.g.s.c.Owner.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f21762b[i.a.g.s.c.LLQ.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f21762b[i.a.g.s.c.NSID.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f21762b[i.a.g.s.c.UL.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f21762b[i.a.g.s.c.Unknown.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            int[] iArr3 = new int[i.a.g.s.b.values().length];
            a = iArr3;
            try {
                iArr3[i.a.g.s.b.Standard.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[i.a.g.s.b.Compressed.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[i.a.g.s.b.Extended.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[i.a.g.s.b.Unknown.ordinal()] = 4;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* JADX INFO: compiled from: DNSIncoming.java */
    public static class b extends ByteArrayInputStream {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static k.b.b f21764f = k.b.c.i(b.class.getName());

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Map<Integer, String> f21765g;

        public b(byte[] bArr, int i2) {
            this(bArr, 0, i2);
        }

        public byte[] a(int i2) {
            byte[] bArr = new byte[i2];
            read(bArr, 0, i2);
            return bArr;
        }

        public String b() {
            HashMap map = new HashMap();
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            while (!z) {
                int iE = e();
                if (iE == 0) {
                    break;
                }
                int i2 = a.a[i.a.g.s.b.k(iE).ordinal()];
                if (i2 == 1) {
                    int i3 = ((ByteArrayInputStream) this).pos - 1;
                    String str = d(iE) + ".";
                    sb.append(str);
                    Iterator it = map.values().iterator();
                    while (it.hasNext()) {
                        ((StringBuilder) it.next()).append(str);
                    }
                    map.put(Integer.valueOf(i3), new StringBuilder(str));
                } else if (i2 == 2) {
                    int iQ = (i.a.g.s.b.q(iE) << 8) | e();
                    String str2 = this.f21765g.get(Integer.valueOf(iQ));
                    if (str2 == null) {
                        f21764f.h("bad domain name: possible circular name detected. Bad offset: 0x" + Integer.toHexString(iQ) + " at 0x" + Integer.toHexString(((ByteArrayInputStream) this).pos - 2));
                        str2 = HttpUrl.FRAGMENT_ENCODE_SET;
                    }
                    sb.append(str2);
                    Iterator it2 = map.values().iterator();
                    while (it2.hasNext()) {
                        ((StringBuilder) it2.next()).append(str2);
                    }
                    z = true;
                } else if (i2 != 3) {
                    f21764f.h("unsupported dns label type: '" + Integer.toHexString(iE & 192) + "'");
                } else {
                    f21764f.c("Extended label are not currently supported.");
                }
            }
            for (Integer num : map.keySet()) {
                this.f21765g.put(num, ((StringBuilder) map.get(num)).toString());
            }
            return sb.toString();
        }

        public String c() {
            return d(e());
        }

        public String d(int i2) {
            int i3;
            int iE;
            StringBuilder sb = new StringBuilder(i2);
            int i4 = 0;
            while (i4 < i2) {
                int iE2 = e();
                switch (iE2 >> 4) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        break;
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    default:
                        i3 = (iE2 & 63) << 4;
                        iE = e() & 15;
                        iE2 = i3 | iE;
                        i4++;
                        break;
                    case 12:
                    case 13:
                        i3 = (iE2 & 31) << 6;
                        iE = e() & 63;
                        iE2 = i3 | iE;
                        i4++;
                        break;
                    case 14:
                        iE2 = ((iE2 & 15) << 12) | ((e() & 63) << 6) | (e() & 63);
                        i4++;
                        i4++;
                        break;
                }
                sb.append((char) iE2);
                i4++;
            }
            return sb.toString();
        }

        public int e() {
            return read() & 255;
        }

        public int f() {
            return (e() << 8) | e();
        }

        public int readInt() {
            return (f() << 16) | f();
        }

        public b(byte[] bArr, int i2, int i3) {
            super(bArr, i2, i3);
            this.f21765g = new HashMap();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(DatagramPacket datagramPacket) throws IOException {
        super(0, 0, datagramPacket.getPort() == i.a.g.s.a.a);
        this.f21761k = datagramPacket;
        InetAddress address = datagramPacket.getAddress();
        b bVar = new b(datagramPacket.getData(), datagramPacket.getLength());
        this.m = bVar;
        this.l = System.currentTimeMillis();
        this.n = 1460;
        try {
            w(bVar.f());
            v(bVar.f());
            if (k() > 0) {
                throw new IOException("Received a message with a non standard operation code. Currently unsupported in the specification.");
            }
            int iF = bVar.f();
            int iF2 = bVar.f();
            int iF3 = bVar.f();
            int iF4 = bVar.f();
            if (f21758h.b()) {
                f21758h.c("DNSIncoming() questions:" + iF + " answers:" + iF2 + " authorities:" + iF3 + " additionals:" + iF4);
            }
            if ((iF * 5) + ((iF2 + iF3 + iF4) * 11) > datagramPacket.getLength()) {
                throw new IOException("questions:" + iF + " answers:" + iF2 + " authorities:" + iF3 + " additionals:" + iF4);
            }
            if (iF > 0) {
                for (int i2 = 0; i2 < iF; i2++) {
                    this.f21768d.add(E());
                }
            }
            if (iF2 > 0) {
                for (int i3 = 0; i3 < iF2; i3++) {
                    h hVarD = D(address);
                    if (hVarD != null) {
                        this.f21769e.add(hVarD);
                    }
                }
            }
            if (iF3 > 0) {
                for (int i4 = 0; i4 < iF3; i4++) {
                    h hVarD2 = D(address);
                    if (hVarD2 != null) {
                        this.f21770f.add(hVarD2);
                    }
                }
            }
            if (iF4 > 0) {
                for (int i5 = 0; i5 < iF4; i5++) {
                    h hVarD3 = D(address);
                    if (hVarD3 != null) {
                        this.f21771g.add(hVarD3);
                    }
                }
            }
            if (this.m.available() > 0) {
                throw new IOException("Received a message with the wrong length.");
            }
        } catch (Exception e2) {
            f21758h.f("DNSIncoming() dump " + C(true) + "\n exception ", e2);
            IOException iOException = new IOException("DNSIncoming corrupted message");
            iOException.initCause(e2);
            throw iOException;
        }
    }

    /* JADX WARN: Code duplicated, block: B:142:0x0264 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:144:0x00c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x0289  */
    /* JADX WARN: Code duplicated, block: B:78:0x029f  */
    /* JADX WARN: Code duplicated, block: B:81:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:82:0x02bb  */
    /* JADX WARN: Instruction removed from duplicated block: B:77:0x0289, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:81:0x02a5, please report this as an issue */
    private h D(InetAddress inetAddress) {
        h cVar;
        byte b2;
        byte b3;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        String str;
        String str2;
        String strB = this.m.b();
        i.a.g.s.e eVarK = i.a.g.s.e.k(this.m.f());
        if (eVarK == i.a.g.s.e.TYPE_IGNORE) {
            f21758h.h("Could not find record type. domain: " + strB + "\n" + C(true));
        }
        int iF = this.m.f();
        i.a.g.s.e eVar = i.a.g.s.e.TYPE_OPT;
        i.a.g.s.d dVarG = eVarK == eVar ? i.a.g.s.d.CLASS_UNKNOWN : i.a.g.s.d.g(iF);
        if (dVarG == i.a.g.s.d.CLASS_UNKNOWN && eVarK != eVar) {
            f21758h.h("Could not find record class. domain: " + strB + " type: " + eVarK + "\n" + C(true));
        }
        boolean zQ = dVarG.q(iF);
        int i2 = this.m.readInt();
        int iF2 = this.m.f();
        int i3 = a.f21763c[eVarK.ordinal()];
        String strSubstring = HttpUrl.FRAGMENT_ENCODE_SET;
        switch (i3) {
            case 1:
                cVar = new h.c(strB, dVarG, zQ, i2, this.m.a(iF2));
                break;
            case 2:
                cVar = new h.d(strB, dVarG, zQ, i2, this.m.a(iF2));
                break;
            case 3:
            case 4:
                String strB2 = this.m.b();
                if (strB2.length() <= 0) {
                    f21758h.h("PTR record of class: " + dVarG + ", there was a problem reading the service name of the answer for domain:" + strB);
                    cVar = null;
                } else {
                    cVar = new h.e(strB, dVarG, zQ, i2, strB2);
                }
                break;
            case 5:
                cVar = new h.g(strB, dVarG, zQ, i2, this.m.a(iF2));
                break;
            case 6:
                cVar = new h.f(strB, dVarG, zQ, i2, this.m.f(), this.m.f(), this.m.f(), f21759i ? this.m.b() : this.m.c());
                break;
            case 7:
                StringBuilder sb = new StringBuilder();
                sb.append(this.m.d(iF2));
                int iIndexOf = sb.indexOf(" ");
                String strTrim = (iIndexOf > 0 ? sb.substring(0, iIndexOf) : sb.toString()).trim();
                if (iIndexOf > 0) {
                    strSubstring = sb.substring(iIndexOf + 1);
                }
                cVar = new h.b(strB, dVarG, zQ, i2, strTrim, strSubstring.trim());
                break;
            case 8:
                i.a.g.s.f fVarK = i.a.g.s.f.k(e(), i2);
                int i4 = (16711680 & i2) >> 16;
                if (i4 == 0) {
                    this.n = iF;
                    while (this.m.available() > 0) {
                        if (this.m.available() >= 2) {
                            int iF3 = this.m.f();
                            i.a.g.s.c cVarK = i.a.g.s.c.k(iF3);
                            if (this.m.available() >= 2) {
                                int iF4 = this.m.f();
                                byte[] bArrA = new byte[0];
                                if (this.m.available() >= iF4) {
                                    bArrA = this.m.a(iF4);
                                }
                                int i5 = a.f21762b[cVarK.ordinal()];
                                if (i5 == 1) {
                                    try {
                                        b2 = bArrA[0];
                                        try {
                                            b3 = bArrA[1];
                                            try {
                                                bArr3 = new byte[]{bArrA[2], bArrA[3], bArrA[4], bArrA[5], bArrA[6], bArrA[7]};
                                                try {
                                                    bArr2 = bArrA.length > 8 ? new byte[]{bArrA[8], bArrA[9], bArrA[10], bArrA[11], bArrA[12], bArrA[13]} : bArr3;
                                                    try {
                                                        bArr = bArrA.length == 18 ? new byte[]{bArrA[14], bArrA[15], bArrA[16], bArrA[17]} : null;
                                                        try {
                                                            if (bArrA.length == 22) {
                                                                bArr = new byte[]{bArrA[14], bArrA[15], bArrA[16], bArrA[17], bArrA[18], bArrA[19], bArrA[20], bArrA[21]};
                                                            }
                                                        } catch (Exception unused) {
                                                            f21758h.h("Malformed OPT answer. Option code: Owner data: " + x(bArrA));
                                                        }
                                                        break;
                                                    } catch (Exception unused2) {
                                                        bArr = null;
                                                        f21758h.h("Malformed OPT answer. Option code: Owner data: " + x(bArrA));
                                                        if (f21758h.b()) {
                                                            k.b.b bVar = f21758h;
                                                            StringBuilder sb2 = new StringBuilder();
                                                            sb2.append("Unhandled Owner OPT version: ");
                                                            sb2.append((int) b2);
                                                            sb2.append(" sequence: ");
                                                            sb2.append((int) b3);
                                                            sb2.append(" MAC address: ");
                                                            sb2.append(x(bArr3));
                                                            if (bArr2 != bArr3) {
                                                                str = " wakeup MAC address: " + x(bArr2);
                                                            } else {
                                                                str = HttpUrl.FRAGMENT_ENCODE_SET;
                                                            }
                                                            sb2.append(str);
                                                            if (bArr != null) {
                                                                str2 = " password: " + x(bArr);
                                                            } else {
                                                                str2 = HttpUrl.FRAGMENT_ENCODE_SET;
                                                            }
                                                            sb2.append(str2);
                                                            bVar.c(sb2.toString());
                                                        }
                                                    }
                                                } catch (Exception unused3) {
                                                    bArr2 = bArr3;
                                                }
                                                break;
                                            } catch (Exception unused4) {
                                                bArr = null;
                                                bArr2 = null;
                                                bArr3 = null;
                                                f21758h.h("Malformed OPT answer. Option code: Owner data: " + x(bArrA));
                                                if (f21758h.b()) {
                                                    k.b.b bVar2 = f21758h;
                                                    StringBuilder sb3 = new StringBuilder();
                                                    sb3.append("Unhandled Owner OPT version: ");
                                                    sb3.append((int) b2);
                                                    sb3.append(" sequence: ");
                                                    sb3.append((int) b3);
                                                    sb3.append(" MAC address: ");
                                                    sb3.append(x(bArr3));
                                                    if (bArr2 != bArr3) {
                                                        str = " wakeup MAC address: " + x(bArr2);
                                                    } else {
                                                        str = HttpUrl.FRAGMENT_ENCODE_SET;
                                                    }
                                                    sb3.append(str);
                                                    if (bArr != null) {
                                                        str2 = " password: " + x(bArr);
                                                    } else {
                                                        str2 = HttpUrl.FRAGMENT_ENCODE_SET;
                                                    }
                                                    sb3.append(str2);
                                                    bVar2.c(sb3.toString());
                                                }
                                            }
                                        } catch (Exception unused5) {
                                            b3 = 0;
                                            bArr = null;
                                            bArr2 = null;
                                            bArr3 = null;
                                            f21758h.h("Malformed OPT answer. Option code: Owner data: " + x(bArrA));
                                            if (f21758h.b()) {
                                                k.b.b bVar3 = f21758h;
                                                StringBuilder sb4 = new StringBuilder();
                                                sb4.append("Unhandled Owner OPT version: ");
                                                sb4.append((int) b2);
                                                sb4.append(" sequence: ");
                                                sb4.append((int) b3);
                                                sb4.append(" MAC address: ");
                                                sb4.append(x(bArr3));
                                                if (bArr2 != bArr3) {
                                                    str = " wakeup MAC address: " + x(bArr2);
                                                } else {
                                                    str = HttpUrl.FRAGMENT_ENCODE_SET;
                                                }
                                                sb4.append(str);
                                                if (bArr != null) {
                                                    str2 = " password: " + x(bArr);
                                                } else {
                                                    str2 = HttpUrl.FRAGMENT_ENCODE_SET;
                                                }
                                                sb4.append(str2);
                                                bVar3.c(sb4.toString());
                                            }
                                        }
                                    } catch (Exception unused6) {
                                        b2 = 0;
                                    }
                                    if (f21758h.b()) {
                                        k.b.b bVar4 = f21758h;
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append("Unhandled Owner OPT version: ");
                                        sb5.append((int) b2);
                                        sb5.append(" sequence: ");
                                        sb5.append((int) b3);
                                        sb5.append(" MAC address: ");
                                        sb5.append(x(bArr3));
                                        if (bArr2 != bArr3) {
                                            str = " wakeup MAC address: " + x(bArr2);
                                        } else {
                                            str = HttpUrl.FRAGMENT_ENCODE_SET;
                                        }
                                        sb5.append(str);
                                        if (bArr != null) {
                                            str2 = " password: " + x(bArr);
                                        } else {
                                            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
                                        }
                                        sb5.append(str2);
                                        bVar4.c(sb5.toString());
                                    }
                                } else if (i5 == 2 || i5 == 3 || i5 == 4) {
                                    if (f21758h.b()) {
                                        f21758h.c("There was an OPT answer. Option code: " + cVarK + " data: " + x(bArrA));
                                    }
                                } else if (i5 == 5) {
                                    if (iF3 < 65001 || iF3 > 65534) {
                                        f21758h.h("There was an OPT answer. Not currently handled. Option code: " + iF3 + " data: " + x(bArrA));
                                    } else if (f21758h.b()) {
                                        f21758h.c("There was an OPT answer using an experimental/local option code: " + iF3 + " data: " + x(bArrA));
                                    }
                                }
                            } else {
                                f21758h.h("There was a problem reading the OPT record. Ignoring.");
                            }
                        } else {
                            f21758h.h("There was a problem reading the OPT record. Ignoring.");
                        }
                    }
                } else {
                    f21758h.h("There was an OPT answer. Wrong version number: " + i4 + " result code: " + fVarK);
                }
                cVar = null;
                break;
            default:
                if (f21758h.b()) {
                    f21758h.c("DNSIncoming() unknown type:" + eVarK);
                }
                this.m.skip(iF2);
                cVar = null;
                break;
        }
        if (cVar != null) {
            cVar.O(inetAddress);
        }
        return cVar;
    }

    private g E() {
        String strB = this.m.b();
        i.a.g.s.e eVarK = i.a.g.s.e.k(this.m.f());
        if (eVarK == i.a.g.s.e.TYPE_IGNORE) {
            f21758h.h("Could not find record type: " + C(true));
        }
        int iF = this.m.f();
        i.a.g.s.d dVarG = i.a.g.s.d.g(iF);
        return g.C(strB, eVarK, dVarG, dVarG.q(iF));
    }

    private String x(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            int i2 = b2 & 255;
            char[] cArr = f21760j;
            sb.append(cArr[i2 / 16]);
            sb.append(cArr[i2 % 16]);
        }
        return sb.toString();
    }

    public int A() {
        return (int) (System.currentTimeMillis() - this.l);
    }

    public int B() {
        return this.n;
    }

    String C(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(t());
        if (z) {
            int length = this.f21761k.getLength();
            byte[] bArr = new byte[length];
            System.arraycopy(this.f21761k.getData(), 0, bArr, 0, length);
            sb.append(u(bArr));
        }
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(p() ? "dns[query," : "dns[response,");
        if (this.f21761k.getAddress() != null) {
            sb.append(this.f21761k.getAddress().getHostAddress());
        }
        sb.append(':');
        sb.append(this.f21761k.getPort());
        sb.append(", length=");
        sb.append(this.f21761k.getLength());
        sb.append(", id=0x");
        sb.append(Integer.toHexString(f()));
        if (e() != 0) {
            sb.append(", flags=0x");
            sb.append(Integer.toHexString(e()));
            if ((e() & 32768) != 0) {
                sb.append(":r");
            }
            if ((e() & 1024) != 0) {
                sb.append(":aa");
            }
            if ((e() & AdRequest.MAX_CONTENT_URL_LENGTH) != 0) {
                sb.append(":tc");
            }
        }
        if (j() > 0) {
            sb.append(", questions=");
            sb.append(j());
        }
        if (h() > 0) {
            sb.append(", answers=");
            sb.append(h());
        }
        if (i() > 0) {
            sb.append(", authorities=");
            sb.append(i());
        }
        if (g() > 0) {
            sb.append(", additionals=");
            sb.append(g());
        }
        if (j() > 0) {
            sb.append("\nquestions:");
            for (g gVar : this.f21768d) {
                sb.append("\n\t");
                sb.append(gVar);
            }
        }
        if (h() > 0) {
            sb.append("\nanswers:");
            for (h hVar : this.f21769e) {
                sb.append("\n\t");
                sb.append(hVar);
            }
        }
        if (i() > 0) {
            sb.append("\nauthorities:");
            for (h hVar2 : this.f21770f) {
                sb.append("\n\t");
                sb.append(hVar2);
            }
        }
        if (g() > 0) {
            sb.append("\nadditionals:");
            for (h hVar3 : this.f21771g) {
                sb.append("\n\t");
                sb.append(hVar3);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    void y(c cVar) {
        if (!p() || !r() || !cVar.p()) {
            throw new IllegalArgumentException();
        }
        this.f21768d.addAll(cVar.l());
        this.f21769e.addAll(cVar.c());
        this.f21770f.addAll(cVar.d());
        this.f21771g.addAll(cVar.a());
    }

    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public c clone() {
        c cVar = new c(e(), f(), o(), this.f21761k, this.l);
        cVar.n = this.n;
        cVar.f21768d.addAll(this.f21768d);
        cVar.f21769e.addAll(this.f21769e);
        cVar.f21770f.addAll(this.f21770f);
        cVar.f21771g.addAll(this.f21771g);
        return cVar;
    }

    private c(int i2, int i3, boolean z, DatagramPacket datagramPacket, long j2) {
        super(i2, i3, z);
        this.f21761k = datagramPacket;
        this.m = new b(datagramPacket.getData(), datagramPacket.getLength());
        this.l = j2;
    }
}
