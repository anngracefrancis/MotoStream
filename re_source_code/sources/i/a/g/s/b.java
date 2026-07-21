package i.a.g.s;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DNSLabel.java */
/* JADX INFO: loaded from: classes2.dex */
public enum b {
    Unknown(HttpUrl.FRAGMENT_ENCODE_SET, 128),
    Standard("standard label", 0),
    Compressed("compressed label", 192),
    Extended("extended label", 64);


    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f21859k;
    private final int l;

    b(String str, int i2) {
        this.f21859k = str;
        this.l = i2;
    }

    public static b k(int i2) {
        int i3 = i2 & 192;
        for (b bVar : values()) {
            if (bVar.l == i3) {
                return bVar;
            }
        }
        return Unknown;
    }

    public static int q(int i2) {
        return i2 & 63;
    }

    public int g() {
        return this.l;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name() + " index " + g();
    }
}
