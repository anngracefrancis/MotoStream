package i.a.g.s;

/* JADX INFO: compiled from: DNSRecordClass.java */
/* JADX INFO: loaded from: classes2.dex */
public enum d {
    CLASS_UNKNOWN("?", 0),
    CLASS_IN("in", 1),
    CLASS_CS("cs", 2),
    CLASS_CH("ch", 3),
    CLASS_HS("hs", 4),
    CLASS_NONE("none", 254),
    CLASS_ANY("any", 255);

    private static k.b.b m = k.b.c.i(d.class.getName());
    private final String o;
    private final int p;

    d(String str, int i2) {
        this.o = str;
        this.p = i2;
    }

    public static d g(int i2) {
        int i3 = i2 & 32767;
        for (d dVar : values()) {
            if (dVar.p == i3) {
                return dVar;
            }
        }
        m.h("Could not find record class for index: " + i2);
        return CLASS_UNKNOWN;
    }

    public int k() {
        return this.p;
    }

    public boolean q(int i2) {
        return (this == CLASS_UNKNOWN || (i2 & 32768) == 0) ? false : true;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name() + " index " + k();
    }
}
