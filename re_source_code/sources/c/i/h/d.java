package c.i.h;

import android.util.Base64;
import c.i.j.i;
import java.util.List;

/* JADX INFO: compiled from: FontRequest.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f3216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f3217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<List<byte[]>> f3218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f3219e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f3220f;

    public d(String str, String str2, String str3, List<List<byte[]>> list) {
        this.a = (String) i.c(str);
        this.f3216b = (String) i.c(str2);
        this.f3217c = (String) i.c(str3);
        this.f3218d = (List) i.c(list);
        this.f3220f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List<List<byte[]>> b() {
        return this.f3218d;
    }

    public int c() {
        return this.f3219e;
    }

    String d() {
        return this.f3220f;
    }

    public String e() {
        return this.a;
    }

    public String f() {
        return this.f3216b;
    }

    public String g() {
        return this.f3217c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.a + ", mProviderPackage: " + this.f3216b + ", mQuery: " + this.f3217c + ", mCertificates:");
        for (int i2 = 0; i2 < this.f3218d.size(); i2++) {
            sb.append(" [");
            List<byte[]> list = this.f3218d.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i3), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f3219e);
        return sb.toString();
    }
}
