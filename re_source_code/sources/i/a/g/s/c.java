package i.a.g.s;

import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: DNSOptionCode.java */
/* JADX INFO: loaded from: classes2.dex */
public enum c {
    Unknown("Unknown", Settings.DEFAULT_INITIAL_WINDOW_SIZE),
    LLQ("LLQ", 1),
    UL("UL", 2),
    NSID("NSID", 3),
    Owner("Owner", 4);

    private final String l;
    private final int m;

    c(String str, int i2) {
        this.l = str;
        this.m = i2;
    }

    public static c k(int i2) {
        for (c cVar : values()) {
            if (cVar.m == i2) {
                return cVar;
            }
        }
        return Unknown;
    }

    public int g() {
        return this.m;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name() + " index " + g();
    }
}
