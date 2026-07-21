package i.a.g;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ServiceInfoImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class q extends i.a.d implements d, i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static k.b.b f21847g = k.b.c.i(q.class.getName());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f21848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f21849i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f21850j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f21851k;
    private String l;
    private String m;
    private int n;
    private int o;
    private int p;
    private byte[] q;
    private Map<String, byte[]> r;
    private final Set<Inet4Address> s;
    private final Set<Inet6Address> t;
    private transient String u;
    private boolean v;
    private boolean w;
    private final b x;

    /* JADX INFO: compiled from: ServiceInfoImpl.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.a.g.s.e.values().length];
            a = iArr;
            try {
                iArr[i.a.g.s.e.TYPE_A.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[i.a.g.s.e.TYPE_AAAA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[i.a.g.s.e.TYPE_SRV.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[i.a.g.s.e.TYPE_TXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[i.a.g.s.e.TYPE_PTR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: ServiceInfoImpl.java */
    private static final class b extends i.b {
        private final q l;

        public b(q qVar) {
            this.l = qVar;
        }

        @Override // i.a.g.i.b
        public void q(l lVar) {
            super.q(lVar);
        }

        @Override // i.a.g.i.b
        protected void s(i.a.g.t.a aVar) {
            super.s(aVar);
            if (this.f21787h == null && this.l.U()) {
                lock();
                try {
                    if (this.f21787h == null && this.l.U()) {
                        if (this.f21788i.k()) {
                            r(i.a.g.s.g.f21887i);
                            if (e() != null) {
                                e().l();
                            }
                        }
                        this.l.f0(false);
                    }
                } finally {
                    unlock();
                }
            }
        }
    }

    public q(String str, String str2, String str3, int i2, int i3, int i4, boolean z, byte[] bArr) {
        this(I(str, str2, str3), i2, i3, i4, z, bArr);
    }

    protected static Map<i.a.d.a, String> G(Map<i.a.d.a, String> map) {
        HashMap map2 = new HashMap(5);
        i.a.d.a aVar = i.a.d.a.Domain;
        String str = "local";
        String str2 = map.containsKey(aVar) ? map.get(aVar) : "local";
        if (str2 != null && str2.length() != 0) {
            str = str2;
        }
        map2.put(aVar, a0(str));
        i.a.d.a aVar2 = i.a.d.a.Protocol;
        String str3 = "tcp";
        String str4 = map.containsKey(aVar2) ? map.get(aVar2) : "tcp";
        if (str4 != null && str4.length() != 0) {
            str3 = str4;
        }
        map2.put(aVar2, a0(str3));
        i.a.d.a aVar3 = i.a.d.a.Application;
        boolean zContainsKey = map.containsKey(aVar3);
        String str5 = HttpUrl.FRAGMENT_ENCODE_SET;
        String str6 = zContainsKey ? map.get(aVar3) : HttpUrl.FRAGMENT_ENCODE_SET;
        if (str6 == null || str6.length() == 0) {
            str6 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        map2.put(aVar3, a0(str6));
        i.a.d.a aVar4 = i.a.d.a.Instance;
        String str7 = map.containsKey(aVar4) ? map.get(aVar4) : HttpUrl.FRAGMENT_ENCODE_SET;
        if (str7 == null || str7.length() == 0) {
            str7 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        map2.put(aVar4, a0(str7));
        i.a.d.a aVar5 = i.a.d.a.Subtype;
        String str8 = map.containsKey(aVar5) ? map.get(aVar5) : HttpUrl.FRAGMENT_ENCODE_SET;
        if (str8 != null && str8.length() != 0) {
            str5 = str8;
        }
        map2.put(aVar5, a0(str5));
        return map2;
    }

    public static Map<i.a.d.a, String> I(String str, String str2, String str3) {
        Map<i.a.d.a, String> mapJ = J(str);
        mapJ.put(i.a.d.a.Instance, str2);
        mapJ.put(i.a.d.a.Subtype, str3);
        return G(mapJ);
    }

    public static Map<i.a.d.a, String> J(String str) {
        String strA0;
        String strSubstring;
        String str2;
        int iIndexOf;
        String strSubstring2;
        String strSubstring3;
        String strSubstring4;
        String lowerCase = str.toLowerCase();
        boolean zContains = lowerCase.contains("in-addr.arpa");
        String strA1 = HttpUrl.FRAGMENT_ENCODE_SET;
        if (!zContains && !lowerCase.contains("ip6.arpa")) {
            if (lowerCase.contains("_") || !lowerCase.contains(".")) {
                if ((!lowerCase.startsWith("_") || lowerCase.startsWith("_services")) && (iIndexOf = lowerCase.indexOf("._")) > 0) {
                    strSubstring2 = str.substring(0, iIndexOf);
                    int i2 = iIndexOf + 1;
                    if (i2 < lowerCase.length()) {
                        strSubstring3 = lowerCase.substring(i2);
                        str = str.substring(i2);
                    } else {
                        strSubstring3 = lowerCase;
                    }
                } else {
                    strSubstring3 = lowerCase;
                    strSubstring2 = HttpUrl.FRAGMENT_ENCODE_SET;
                }
                int iLastIndexOf = strSubstring3.lastIndexOf("._");
                if (iLastIndexOf > 0) {
                    int i3 = iLastIndexOf + 2;
                    strSubstring4 = str.substring(i3, strSubstring3.indexOf(46, i3));
                } else {
                    strSubstring4 = HttpUrl.FRAGMENT_ENCODE_SET;
                }
                if (strSubstring4.length() > 0) {
                    int iIndexOf2 = strSubstring3.indexOf("_" + strSubstring4.toLowerCase() + ".");
                    int length = strSubstring4.length() + iIndexOf2 + 2;
                    int length2 = strSubstring3.length() - (strSubstring3.endsWith(".") ? 1 : 0);
                    String strSubstring5 = length2 > length ? str.substring(length, length2) : HttpUrl.FRAGMENT_ENCODE_SET;
                    if (iIndexOf2 > 0) {
                        lowerCase = str.substring(0, iIndexOf2 - 1);
                        strSubstring = strSubstring5;
                    } else {
                        strSubstring = strSubstring5;
                        lowerCase = HttpUrl.FRAGMENT_ENCODE_SET;
                    }
                } else {
                    strSubstring = HttpUrl.FRAGMENT_ENCODE_SET;
                }
                int iIndexOf3 = lowerCase.toLowerCase().indexOf("._sub");
                if (iIndexOf3 > 0) {
                    strA1 = a0(lowerCase.substring(0, iIndexOf3));
                    lowerCase = lowerCase.substring(iIndexOf3 + 5);
                }
                strA0 = strSubstring2;
                String str3 = strA1;
                strA1 = strSubstring4;
                str2 = str3;
            } else {
                int iIndexOf4 = lowerCase.indexOf(46);
                strA0 = a0(str.substring(0, iIndexOf4));
                strSubstring = a0(str.substring(iIndexOf4));
            }
            HashMap map = new HashMap(5);
            map.put(i.a.d.a.Domain, a0(strSubstring));
            map.put(i.a.d.a.Protocol, strA1);
            map.put(i.a.d.a.Application, a0(lowerCase));
            map.put(i.a.d.a.Instance, strA0);
            map.put(i.a.d.a.Subtype, str2);
            return map;
        }
        int iIndexOf5 = lowerCase.contains("in-addr.arpa") ? lowerCase.indexOf("in-addr.arpa") : lowerCase.indexOf("ip6.arpa");
        strA0 = a0(str.substring(0, iIndexOf5));
        strSubstring = str.substring(iIndexOf5);
        lowerCase = HttpUrl.FRAGMENT_ENCODE_SET;
        str2 = lowerCase;
        HashMap map2 = new HashMap(5);
        map2.put(i.a.d.a.Domain, a0(strSubstring));
        map2.put(i.a.d.a.Protocol, strA1);
        map2.put(i.a.d.a.Application, a0(lowerCase));
        map2.put(i.a.d.a.Instance, strA0);
        map2.put(i.a.d.a.Subtype, str2);
        return map2;
    }

    private final boolean P() {
        return this.s.size() > 0 || this.t.size() > 0;
    }

    private static String a0(String str) {
        if (str == null) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        String strTrim = str.trim();
        if (strTrim.startsWith(".")) {
            strTrim = strTrim.substring(1);
        }
        if (strTrim.startsWith("_")) {
            strTrim = strTrim.substring(1);
        }
        return strTrim.endsWith(".") ? strTrim.substring(0, strTrim.length() - 1) : strTrim;
    }

    private static byte[] h0(Map<String, ?> map) {
        byte[] byteArray = null;
        if (map != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);
                for (String str : map.keySet()) {
                    Object obj = map.get(str);
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(100);
                    l0(byteArrayOutputStream2, str);
                    if (obj != null) {
                        if (obj instanceof String) {
                            byteArrayOutputStream2.write(61);
                            l0(byteArrayOutputStream2, (String) obj);
                        } else {
                            if (!(obj instanceof byte[])) {
                                throw new IllegalArgumentException("invalid property value: " + obj);
                            }
                            byte[] bArr = (byte[]) obj;
                            if (bArr.length > 0) {
                                byteArrayOutputStream2.write(61);
                                byteArrayOutputStream2.write(bArr, 0, bArr.length);
                            } else {
                                obj = null;
                            }
                        }
                    }
                    byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                    if (byteArray2.length > 255) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Cannot have individual values larger that 255 chars. Offending value: ");
                        sb.append(str);
                        sb.append(obj != null ? HttpUrl.FRAGMENT_ENCODE_SET : "=" + obj);
                        throw new IOException(sb.toString());
                    }
                    byteArrayOutputStream.write((byte) byteArray2.length);
                    byteArrayOutputStream.write(byteArray2, 0, byteArray2.length);
                }
                byteArray = byteArrayOutputStream.toByteArray();
            } catch (IOException e2) {
                throw new RuntimeException("unexpected exception: " + e2);
            }
        }
        return (byteArray == null || byteArray.length <= 0) ? h.f21780i : byteArray;
    }

    static void l0(OutputStream outputStream, String str) throws IOException {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt >= 1 && cCharAt <= 127) {
                outputStream.write(cCharAt);
            } else if (cCharAt > 2047) {
                outputStream.write(((cCharAt >> '\f') & 15) | 224);
                outputStream.write(((cCharAt >> 6) & 63) | 128);
                outputStream.write(((cCharAt >> 0) & 63) | 128);
            } else {
                outputStream.write(((cCharAt >> 6) & 31) | 192);
                outputStream.write(((cCharAt >> 0) & 63) | 128);
            }
        }
    }

    void A(byte[] bArr) {
        this.q = bArr;
        this.r = null;
    }

    void B(Inet4Address inet4Address) {
        this.s.add(inet4Address);
    }

    void C(Inet6Address inet6Address) {
        this.t.add(inet6Address);
    }

    public Collection<h> D(i.a.g.s.d dVar, boolean z, int i2, k kVar) {
        ArrayList arrayList = new ArrayList();
        if (dVar == i.a.g.s.d.CLASS_ANY || dVar == i.a.g.s.d.CLASS_IN) {
            if (q().length() > 0) {
                arrayList.add(new h.e(O(), i.a.g.s.d.CLASS_IN, false, i2, o()));
            }
            String strS = s();
            i.a.g.s.d dVar2 = i.a.g.s.d.CLASS_IN;
            arrayList.add(new h.e(strS, dVar2, false, i2, o()));
            arrayList.add(new h.f(o(), dVar2, z, i2, this.p, this.o, this.n, kVar.q()));
            arrayList.add(new h.g(o(), dVar2, z, i2, r()));
        }
        return arrayList;
    }

    public void E(i.a.g.t.a aVar, i.a.g.s.g gVar) {
        this.x.a(aVar, gVar);
    }

    public boolean F() {
        return this.x.b();
    }

    @Override // i.a.d
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public q clone() {
        q qVar = new q(N(), this.n, this.o, this.p, this.v, this.q);
        for (Inet6Address inet6Address : i()) {
            qVar.t.add(inet6Address);
        }
        for (Inet4Address inet4Address : h()) {
            qVar.s.add(inet4Address);
        }
        return qVar;
    }

    public l K() {
        return this.x.e();
    }

    public String L() {
        if (this.u == null) {
            this.u = o().toLowerCase();
        }
        return this.u;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x007b  */
    /* JADX WARN: Code duplicated, block: B:36:0x007c A[Catch: all -> 0x0082, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000b, B:9:0x0012, B:11:0x0019, B:13:0x0025, B:18:0x0032, B:20:0x003e, B:21:0x0041, B:23:0x004b, B:25:0x0051, B:26:0x0057, B:28:0x0069, B:32:0x0075, B:31:0x006e, B:33:0x0077, B:36:0x007c), top: B:44:0x0001, inners: #1 }] */
    synchronized Map<String, byte[]> M() {
        Map<String, byte[]> mapEmptyMap;
        int i2;
        if (this.r != null || r() == null) {
            mapEmptyMap = this.r;
            if (mapEmptyMap != null) {
                mapEmptyMap = Collections.emptyMap();
            }
        } else {
            Hashtable hashtable = new Hashtable();
            int i3 = 0;
            while (i3 < r().length) {
                try {
                    int i4 = i3 + 1;
                    int i5 = r()[i3] & 255;
                    if (i5 == 0 || (i2 = i4 + i5) > r().length) {
                        hashtable.clear();
                        break;
                    }
                    int i6 = 0;
                    while (i6 < i5 && r()[i4 + i6] != 61) {
                        i6++;
                    }
                    String strV = V(r(), i4, i6);
                    if (strV == null) {
                        hashtable.clear();
                        break;
                    }
                    if (i6 == i5) {
                        hashtable.put(strV, i.a.d.f21745f);
                    } else {
                        int i7 = i6 + 1;
                        int i8 = i5 - i7;
                        byte[] bArr = new byte[i8];
                        System.arraycopy(r(), i4 + i7, bArr, 0, i8);
                        hashtable.put(strV, bArr);
                    }
                    i3 = i2;
                } catch (Exception e2) {
                    f21847g.f("Malformed TXT Field ", e2);
                }
            }
            this.r = hashtable;
            mapEmptyMap = this.r;
            if (mapEmptyMap != null) {
                mapEmptyMap = Collections.emptyMap();
            }
        }
        throw th;
        return mapEmptyMap;
    }

    public Map<i.a.d.a, String> N() {
        HashMap map = new HashMap(5);
        map.put(i.a.d.a.Domain, g());
        map.put(i.a.d.a.Protocol, n());
        map.put(i.a.d.a.Application, f());
        map.put(i.a.d.a.Instance, k());
        map.put(i.a.d.a.Subtype, q());
        return map;
    }

    public String O() {
        String str;
        String strQ = q();
        StringBuilder sb = new StringBuilder();
        if (strQ.length() > 0) {
            str = "_" + strQ.toLowerCase() + "._sub.";
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(str);
        sb.append(s());
        return sb.toString();
    }

    public boolean Q() {
        return this.x.f();
    }

    public boolean R() {
        return this.x.g();
    }

    public boolean S(i.a.g.t.a aVar, i.a.g.s.g gVar) {
        return this.x.h(aVar, gVar);
    }

    public boolean T() {
        return this.x.m();
    }

    public boolean U() {
        return this.w;
    }

    String V(byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        StringBuffer stringBuffer = new StringBuffer();
        int i7 = i2 + i3;
        while (i2 < i7) {
            int i8 = i2 + 1;
            int i9 = bArr[i2] & 255;
            switch (i9 >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    continue;
                    stringBuffer.append((char) i9);
                    i2 = i8;
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    i5 = i8 + 1;
                    if (i5 >= i3) {
                        return null;
                    }
                    i4 = (i9 & 63) << 4;
                    i6 = bArr[i8] & 15;
                    break;
                case 12:
                case 13:
                    if (i8 >= i3) {
                        return null;
                    }
                    i4 = (i9 & 31) << 6;
                    i5 = i8 + 1;
                    i6 = bArr[i8] & 63;
                    break;
                case 14:
                    if (i8 + 2 >= i3) {
                        return null;
                    }
                    int i10 = i8 + 1;
                    int i11 = ((i9 & 15) << 12) | ((bArr[i8] & 63) << 6);
                    i8 = i10 + 1;
                    i9 = i11 | (bArr[i10] & 63);
                    continue;
                    stringBuffer.append((char) i9);
                    i2 = i8;
                    break;
            }
            i9 = i4 | i6;
            i8 = i5;
            stringBuffer.append((char) i9);
            i2 = i8;
        }
        return stringBuffer.toString();
    }

    public boolean X() {
        return this.x.n();
    }

    public void Z(i.a.g.t.a aVar) {
        this.x.o(aVar);
    }

    @Override // i.a.g.d
    public void b(i.a.g.a aVar, long j2, i.a.g.b bVar) {
        l lVarK;
        if (!(bVar instanceof h) || bVar.j(j2)) {
            return;
        }
        int i2 = a.a[bVar.f().ordinal()];
        boolean z = false;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5 && q().length() == 0 && bVar.g().length() != 0) {
                            this.l = bVar.g();
                            z = true;
                        }
                    } else if (bVar.c().equalsIgnoreCase(o())) {
                        this.q = ((h.g) bVar).T();
                        this.r = null;
                        z = true;
                    }
                } else if (bVar.c().equalsIgnoreCase(o())) {
                    h.f fVar = (h.f) bVar;
                    String str = this.m;
                    boolean z2 = str == null || !str.equalsIgnoreCase(fVar.V());
                    this.m = fVar.V();
                    this.n = fVar.T();
                    this.o = fVar.W();
                    this.p = fVar.U();
                    if (z2) {
                        this.s.clear();
                        this.t.clear();
                        Iterator<? extends i.a.g.b> it = aVar.h(this.m, i.a.g.s.e.TYPE_A, i.a.g.s.d.CLASS_IN).iterator();
                        while (it.hasNext()) {
                            b(aVar, j2, it.next());
                        }
                        Iterator<? extends i.a.g.b> it2 = aVar.h(this.m, i.a.g.s.e.TYPE_AAAA, i.a.g.s.d.CLASS_IN).iterator();
                        while (it2.hasNext()) {
                            b(aVar, j2, it2.next());
                        }
                    } else {
                        z = true;
                    }
                }
            } else if (bVar.c().equalsIgnoreCase(p())) {
                this.t.add((Inet6Address) ((h.a) bVar).T());
                z = true;
            }
        } else if (bVar.c().equalsIgnoreCase(p())) {
            this.s.add((Inet4Address) ((h.a) bVar).T());
            z = true;
        }
        if (z && u() && (lVarK = K()) != null) {
            lVarK.M0(new p(lVarK, s(), k(), this));
        }
        synchronized (this) {
            notifyAll();
        }
    }

    public boolean b0() {
        return this.x.p();
    }

    public void c0(l lVar) {
        this.x.q(lVar);
    }

    @Override // i.a.g.i
    public boolean d(i.a.g.t.a aVar) {
        return this.x.d(aVar);
    }

    void d0(String str) {
        this.f21851k = str;
        this.u = null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof q) && o().equals(((q) obj).o());
    }

    @Override // i.a.d
    public String f() {
        String str = this.f21850j;
        return str != null ? str : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public void f0(boolean z) {
        this.w = z;
        if (z) {
            this.x.s(null);
        }
    }

    @Override // i.a.d
    public String g() {
        String str = this.f21848h;
        return str != null ? str : "local";
    }

    void g0(String str) {
        this.m = str;
    }

    @Override // i.a.d
    public Inet4Address[] h() {
        Set<Inet4Address> set = this.s;
        return (Inet4Address[]) set.toArray(new Inet4Address[set.size()]);
    }

    public int hashCode() {
        return o().hashCode();
    }

    @Override // i.a.d
    public Inet6Address[] i() {
        Set<Inet6Address> set = this.t;
        return (Inet6Address[]) set.toArray(new Inet6Address[set.size()]);
    }

    @Override // i.a.d
    public InetAddress[] j() {
        ArrayList arrayList = new ArrayList(this.s.size() + this.t.size());
        arrayList.addAll(this.s);
        arrayList.addAll(this.t);
        return (InetAddress[]) arrayList.toArray(new InetAddress[arrayList.size()]);
    }

    public boolean j0(long j2) {
        return this.x.t(j2);
    }

    @Override // i.a.d
    public String k() {
        String str = this.f21851k;
        return str != null ? str : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public boolean k0(long j2) {
        return this.x.u(j2);
    }

    @Override // i.a.d
    public int l() {
        return this.n;
    }

    @Override // i.a.d
    public int m() {
        return this.p;
    }

    @Override // i.a.d
    public String n() {
        String str = this.f21849i;
        return str != null ? str : "tcp";
    }

    @Override // i.a.d
    public String o() {
        String str;
        String str2;
        String strG = g();
        String strN = n();
        String strF = f();
        String strK = k();
        StringBuilder sb = new StringBuilder();
        int length = strK.length();
        String str3 = HttpUrl.FRAGMENT_ENCODE_SET;
        if (length > 0) {
            str = strK + ".";
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(str);
        if (strF.length() > 0) {
            str2 = "_" + strF + ".";
        } else {
            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(str2);
        if (strN.length() > 0) {
            str3 = "_" + strN + ".";
        }
        sb.append(str3);
        sb.append(strG);
        sb.append(".");
        return sb.toString();
    }

    @Override // i.a.d
    public String p() {
        String str = this.m;
        return str != null ? str : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    @Override // i.a.d
    public String q() {
        String str = this.l;
        return str != null ? str : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    @Override // i.a.d
    public byte[] r() {
        byte[] bArr = this.q;
        return (bArr == null || bArr.length <= 0) ? h.f21780i : bArr;
    }

    @Override // i.a.d
    public String s() {
        String str;
        String strG = g();
        String strN = n();
        String strF = f();
        StringBuilder sb = new StringBuilder();
        int length = strF.length();
        String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        if (length > 0) {
            str = "_" + strF + ".";
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(str);
        if (strN.length() > 0) {
            str2 = "_" + strN + ".";
        }
        sb.append(str2);
        sb.append(strG);
        sb.append(".");
        return sb.toString();
    }

    @Override // i.a.d
    public int t() {
        return this.o;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[" + q.class.getSimpleName() + "@" + System.identityHashCode(this) + " ");
        sb.append("name: '");
        StringBuilder sb2 = new StringBuilder();
        int length = k().length();
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        sb2.append(length > 0 ? k() + "." : HttpUrl.FRAGMENT_ENCODE_SET);
        sb2.append(O());
        sb.append(sb2.toString());
        sb.append("' address: '");
        InetAddress[] inetAddressArrJ = j();
        if (inetAddressArrJ.length > 0) {
            for (InetAddress inetAddress : inetAddressArrJ) {
                sb.append(inetAddress);
                sb.append(':');
                sb.append(l());
                sb.append(' ');
            }
        } else {
            sb.append("(null):");
            sb.append(l());
        }
        sb.append("' status: '");
        sb.append(this.x.toString());
        sb.append(w() ? "' is persistent," : "',");
        sb.append(" has ");
        if (!u()) {
            str = "NO ";
        }
        sb.append(str);
        sb.append("data");
        if (r().length > 0) {
            Map<String, byte[]> mapM = M();
            if (mapM.isEmpty()) {
                sb.append(" empty");
            } else {
                sb.append("\n");
                for (String str2 : mapM.keySet()) {
                    sb.append("\t" + str2 + ": " + new String(mapM.get(str2)) + "\n");
                }
            }
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // i.a.d
    public synchronized boolean u() {
        return p() != null && P() && r() != null && r().length > 0;
    }

    @Override // i.a.d
    public boolean v(i.a.d dVar) {
        if (dVar == null) {
            return false;
        }
        if (dVar instanceof q) {
            q qVar = (q) dVar;
            return this.s.size() == qVar.s.size() && this.t.size() == qVar.t.size() && this.s.equals(qVar.s) && this.t.equals(qVar.t);
        }
        InetAddress[] inetAddressArrJ = j();
        InetAddress[] inetAddressArrJ2 = dVar.j();
        return inetAddressArrJ.length == inetAddressArrJ2.length && new HashSet(Arrays.asList(inetAddressArrJ)).equals(new HashSet(Arrays.asList(inetAddressArrJ2)));
    }

    @Override // i.a.d
    public boolean w() {
        return this.v;
    }

    public q(Map<i.a.d.a, String> map, int i2, int i3, int i4, boolean z, Map<String, ?> map2) {
        this(map, i2, i3, i4, z, h0(map2));
    }

    q(Map<i.a.d.a, String> map, int i2, int i3, int i4, boolean z, String str) {
        this(map, i2, i3, i4, z, (byte[]) null);
        this.m = str;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
            l0(byteArrayOutputStream, str);
            this.q = byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new RuntimeException("unexpected exception: " + e2);
        }
    }

    q(Map<i.a.d.a, String> map, int i2, int i3, int i4, boolean z, byte[] bArr) {
        Map<i.a.d.a, String> mapG = G(map);
        this.f21848h = mapG.get(i.a.d.a.Domain);
        this.f21849i = mapG.get(i.a.d.a.Protocol);
        this.f21850j = mapG.get(i.a.d.a.Application);
        this.f21851k = mapG.get(i.a.d.a.Instance);
        this.l = mapG.get(i.a.d.a.Subtype);
        this.n = i2;
        this.o = i3;
        this.p = i4;
        this.q = bArr;
        f0(false);
        this.x = new b(this);
        this.v = z;
        this.s = Collections.synchronizedSet(new LinkedHashSet());
        this.t = Collections.synchronizedSet(new LinkedHashSet());
    }

    q(i.a.d dVar) {
        this.s = Collections.synchronizedSet(new LinkedHashSet());
        this.t = Collections.synchronizedSet(new LinkedHashSet());
        if (dVar != null) {
            this.f21848h = dVar.g();
            this.f21849i = dVar.n();
            this.f21850j = dVar.f();
            this.f21851k = dVar.k();
            this.l = dVar.q();
            this.n = dVar.l();
            this.o = dVar.t();
            this.p = dVar.m();
            this.q = dVar.r();
            this.v = dVar.w();
            for (Inet6Address inet6Address : dVar.i()) {
                this.t.add(inet6Address);
            }
            for (Inet4Address inet4Address : dVar.h()) {
                this.s.add(inet4Address);
            }
        }
        this.x = new b(this);
    }
}
