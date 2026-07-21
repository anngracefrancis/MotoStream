package i.a.g.s;

import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: DNSResultCode.java */
/* JADX INFO: loaded from: classes2.dex */
public enum f {
    Unknown("Unknown", Settings.DEFAULT_INITIAL_WINDOW_SIZE),
    NoError("No Error", 0),
    FormErr("Format Error", 1),
    ServFail("Server Failure", 2),
    NXDomain("Non-Existent Domain", 3),
    NotImp("Not Implemented", 4),
    Refused("Query Refused", 5),
    YXDomain("Name Exists when it should not", 6),
    YXRRSet("RR Set Exists when it should not", 7),
    NXRRSet("RR Set that should exist does not", 8),
    NotAuth("Server Not Authoritative for zone", 9),
    NotZone("NotZone Name not contained in zone", 10);

    private final String s;
    private final int t;

    f(String str, int i2) {
        this.s = str;
        this.t = i2;
    }

    public static f k(int i2, int i3) {
        int i4 = (i2 & 15) | ((i3 >> 28) & 255);
        for (f fVar : values()) {
            if (fVar.t == i4) {
                return fVar;
            }
        }
        return Unknown;
    }

    public int g() {
        return this.t;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name() + " index " + g();
    }
}
