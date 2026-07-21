package i.a.g;

import com.google.android.gms.ads.AdRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: DNSMessage.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f21766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f21767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final List<g> f21768d = Collections.synchronizedList(new LinkedList());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final List<h> f21769e = Collections.synchronizedList(new LinkedList());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final List<h> f21770f = Collections.synchronizedList(new LinkedList());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final List<h> f21771g = Collections.synchronizedList(new LinkedList());

    protected e(int i2, int i3, boolean z) {
        this.f21767c = i2;
        this.a = i3;
        this.f21766b = z;
    }

    public Collection<? extends h> a() {
        return this.f21771g;
    }

    public List<h> b() {
        ArrayList arrayList = new ArrayList(this.f21769e.size() + this.f21770f.size() + this.f21771g.size());
        arrayList.addAll(this.f21769e);
        arrayList.addAll(this.f21770f);
        arrayList.addAll(this.f21771g);
        return arrayList;
    }

    public Collection<? extends h> c() {
        return this.f21769e;
    }

    public Collection<? extends h> d() {
        return this.f21770f;
    }

    public int e() {
        return this.f21767c;
    }

    public int f() {
        if (this.f21766b) {
            return 0;
        }
        return this.a;
    }

    public int g() {
        return a().size();
    }

    public int h() {
        return c().size();
    }

    public int i() {
        return d().size();
    }

    public int j() {
        return l().size();
    }

    public int k() {
        return (this.f21767c & 30720) >> 11;
    }

    public Collection<? extends g> l() {
        return this.f21768d;
    }

    public boolean m() {
        return (this.f21767c & 1024) != 0;
    }

    public boolean n() {
        return ((j() + h()) + i()) + g() == 0;
    }

    public boolean o() {
        return this.f21766b;
    }

    public boolean p() {
        return (this.f21767c & 32768) == 0;
    }

    public boolean q() {
        return (this.f21767c & 32768) == 32768;
    }

    public boolean r() {
        return (this.f21767c & AdRequest.MAX_CONTENT_URL_LENGTH) != 0;
    }

    public boolean s() {
        return (this.f21767c & 15) == 0;
    }

    String t() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append(toString());
        stringBuffer.append("\n");
        for (g gVar : this.f21768d) {
            stringBuffer.append("\tquestion:      ");
            stringBuffer.append(gVar);
            stringBuffer.append("\n");
        }
        for (h hVar : this.f21769e) {
            stringBuffer.append("\tanswer:        ");
            stringBuffer.append(hVar);
            stringBuffer.append("\n");
        }
        for (h hVar2 : this.f21770f) {
            stringBuffer.append("\tauthoritative: ");
            stringBuffer.append(hVar2);
            stringBuffer.append("\n");
        }
        for (h hVar3 : this.f21771g) {
            stringBuffer.append("\tadditional:    ");
            stringBuffer.append(hVar3);
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    protected String u(byte[] bArr) {
        StringBuilder sb = new StringBuilder(4000);
        int length = bArr.length;
        int i2 = 0;
        while (i2 < length) {
            int iMin = Math.min(32, length - i2);
            if (i2 < 16) {
                sb.append(' ');
            }
            if (i2 < 256) {
                sb.append(' ');
            }
            if (i2 < 4096) {
                sb.append(' ');
            }
            sb.append(Integer.toHexString(i2));
            sb.append(':');
            int i3 = 0;
            while (i3 < iMin) {
                if (i3 % 8 == 0) {
                    sb.append(' ');
                }
                int i4 = i2 + i3;
                sb.append(Integer.toHexString((bArr[i4] & 240) >> 4));
                sb.append(Integer.toHexString((bArr[i4] & 15) >> 0));
                i3++;
            }
            if (i3 < 32) {
                while (i3 < 32) {
                    if (i3 % 8 == 0) {
                        sb.append(' ');
                    }
                    sb.append("  ");
                    i3++;
                }
            }
            sb.append("    ");
            for (int i5 = 0; i5 < iMin; i5++) {
                if (i5 % 8 == 0) {
                    sb.append(' ');
                }
                int i6 = bArr[i2 + i5] & 255;
                sb.append((i6 <= 32 || i6 >= 127) ? '.' : (char) i6);
            }
            sb.append("\n");
            i2 += 32;
            if (i2 >= 2048) {
                sb.append("....\n");
                break;
            }
        }
        return sb.toString();
    }

    public void v(int i2) {
        this.f21767c = i2;
    }

    public void w(int i2) {
        this.a = i2;
    }
}
