package i.a.g;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DNSEntry.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f21753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final i.a.g.s.e f21754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final i.a.g.s.d f21755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f21756f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Map<i.a.d.a, String> f21757g;

    b(String str, i.a.g.s.e eVar, i.a.g.s.d dVar, boolean z) {
        String str2;
        String str3;
        this.f21752b = str;
        this.f21754d = eVar;
        this.f21755e = dVar;
        this.f21756f = z;
        Map<i.a.d.a, String> mapJ = q.J(c());
        this.f21757g = mapJ;
        String str4 = mapJ.get(i.a.d.a.Domain);
        String str5 = mapJ.get(i.a.d.a.Protocol);
        String str6 = mapJ.get(i.a.d.a.Application);
        String lowerCase = mapJ.get(i.a.d.a.Instance).toLowerCase();
        StringBuilder sb = new StringBuilder();
        int length = str6.length();
        String str7 = HttpUrl.FRAGMENT_ENCODE_SET;
        if (length > 0) {
            str2 = "_" + str6 + ".";
        } else {
            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(str2);
        if (str5.length() > 0) {
            str3 = "_" + str5 + ".";
        } else {
            str3 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(str3);
        sb.append(str4);
        sb.append(".");
        String string = sb.toString();
        this.f21753c = string;
        StringBuilder sb2 = new StringBuilder();
        if (lowerCase.length() > 0) {
            str7 = lowerCase + ".";
        }
        sb2.append(str7);
        sb2.append(string);
        this.a = sb2.toString().toLowerCase();
    }

    public int a(b bVar) {
        byte[] bArrW = w();
        byte[] bArrW2 = bVar.w();
        int iMin = Math.min(bArrW.length, bArrW2.length);
        for (int i2 = 0; i2 < iMin; i2++) {
            if (bArrW[i2] > bArrW2[i2]) {
                return 1;
            }
            if (bArrW[i2] < bArrW2[i2]) {
                return -1;
            }
        }
        return bArrW.length - bArrW2.length;
    }

    public String b() {
        String str = this.a;
        return str != null ? str : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public String c() {
        String str = this.f21752b;
        return str != null ? str : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public Map<i.a.d.a, String> d() {
        return Collections.unmodifiableMap(this.f21757g);
    }

    public i.a.g.s.d e() {
        i.a.g.s.d dVar = this.f21755e;
        return dVar != null ? dVar : i.a.g.s.d.CLASS_UNKNOWN;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return b().equals(bVar.b()) && f().equals(bVar.f()) && e() == bVar.e();
    }

    public i.a.g.s.e f() {
        i.a.g.s.e eVar = this.f21754d;
        return eVar != null ? eVar : i.a.g.s.e.TYPE_IGNORE;
    }

    public String g() {
        String str = d().get(i.a.d.a.Subtype);
        return str != null ? str : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public String h() {
        String str = this.f21753c;
        return str != null ? str : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public int hashCode() {
        return b().hashCode() + f().g() + e().k();
    }

    public boolean i() {
        if (!this.f21757g.get(i.a.d.a.Application).equals("dns-sd")) {
            return false;
        }
        String str = this.f21757g.get(i.a.d.a.Instance);
        return "b".equals(str) || "db".equals(str) || "r".equals(str) || "dr".equals(str) || "lb".equals(str);
    }

    public abstract boolean j(long j2);

    public boolean k() {
        return q() || r();
    }

    public boolean l(b bVar) {
        return b().equals(bVar.b()) && t(bVar.f()) && s(bVar.e());
    }

    public boolean m(b bVar) {
        return bVar != null && bVar.e() == e();
    }

    public boolean n(b bVar) {
        return bVar != null && bVar.f() == f();
    }

    public boolean o() {
        return this.f21757g.get(i.a.d.a.Application).equals("dns-sd") && this.f21757g.get(i.a.d.a.Instance).equals("_services");
    }

    public boolean p() {
        return this.f21756f;
    }

    public boolean q() {
        return this.f21757g.get(i.a.d.a.Domain).endsWith("in-addr.arpa");
    }

    public boolean r() {
        return this.f21757g.get(i.a.d.a.Domain).endsWith("ip6.arpa");
    }

    public boolean s(i.a.g.s.d dVar) {
        i.a.g.s.d dVar2 = i.a.g.s.d.CLASS_ANY;
        return dVar2 == dVar || dVar2 == e() || e().equals(dVar);
    }

    public boolean t(i.a.g.s.e eVar) {
        return f().equals(eVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("[" + getClass().getSimpleName() + "@" + System.identityHashCode(this));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" type: ");
        sb2.append(f());
        sb.append(sb2.toString());
        sb.append(", class: " + e());
        sb.append(this.f21756f ? "-unique," : ",");
        sb.append(" name: " + this.f21752b);
        x(sb);
        sb.append("]");
        return sb.toString();
    }

    public boolean u(b bVar) {
        return g().equals(bVar.g());
    }

    protected void v(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(c().getBytes("UTF8"));
        dataOutputStream.writeShort(f().g());
        dataOutputStream.writeShort(e().k());
    }

    protected byte[] w() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            v(dataOutputStream);
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new InternalError();
        }
    }

    protected void x(StringBuilder sb) {
    }
}
