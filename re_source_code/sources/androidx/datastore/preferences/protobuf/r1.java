package androidx.datastore.preferences.protobuf;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: WireFormat.java */
/* JADX INFO: loaded from: classes.dex */
public final class r1 {
    static final int a = c(1, 3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int f1394b = c(1, 4);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int f1395c = c(2, 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f1396d = c(3, 2);

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'h' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: WireFormat.java */
    public static class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f1397f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f1398g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f1399h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f1400i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final b f1401j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final b f1402k;
        public static final b l;
        public static final b m;
        public static final b n;
        public static final b o;
        public static final b p;
        public static final b q;
        public static final b r;
        public static final b s;
        public static final b t;
        public static final b u;
        public static final b v;
        public static final b w;
        private static final /* synthetic */ b[] x;
        private final c y;
        private final int z;

        /* JADX INFO: compiled from: WireFormat.java */
        static enum a extends b {
            a(String str, int i2, c cVar, int i3) {
                super(str, i2, cVar, i3);
            }
        }

        /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.r1$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: WireFormat.java */
        static enum C0034b extends b {
            C0034b(String str, int i2, c cVar, int i3) {
                super(str, i2, cVar, i3);
            }
        }

        /* JADX INFO: compiled from: WireFormat.java */
        static enum c extends b {
            c(String str, int i2, c cVar, int i3) {
                super(str, i2, cVar, i3);
            }
        }

        /* JADX INFO: compiled from: WireFormat.java */
        static enum d extends b {
            d(String str, int i2, c cVar, int i3) {
                super(str, i2, cVar, i3);
            }
        }

        static {
            b bVar = new b("DOUBLE", 0, c.DOUBLE, 1);
            f1397f = bVar;
            b bVar2 = new b("FLOAT", 1, c.FLOAT, 5);
            f1398g = bVar2;
            c cVar = c.LONG;
            b bVar3 = new b("INT64", 2, cVar, 0);
            f1399h = bVar3;
            b bVar4 = new b("UINT64", 3, cVar, 0);
            f1400i = bVar4;
            c cVar2 = c.INT;
            b bVar5 = new b("INT32", 4, cVar2, 0);
            f1401j = bVar5;
            b bVar6 = new b("FIXED64", 5, cVar, 1);
            f1402k = bVar6;
            b bVar7 = new b("FIXED32", 6, cVar2, 5);
            l = bVar7;
            b bVar8 = new b("BOOL", 7, c.BOOLEAN, 0);
            m = bVar8;
            a aVar = new a("STRING", 8, c.STRING, 2);
            n = aVar;
            c cVar3 = c.MESSAGE;
            C0034b c0034b = new C0034b("GROUP", 9, cVar3, 3);
            o = c0034b;
            c cVar4 = new c("MESSAGE", 10, cVar3, 2);
            p = cVar4;
            d dVar = new d("BYTES", 11, c.BYTE_STRING, 2);
            q = dVar;
            b bVar9 = new b("UINT32", 12, cVar2, 0);
            r = bVar9;
            b bVar10 = new b("ENUM", 13, c.ENUM, 0);
            s = bVar10;
            b bVar11 = new b("SFIXED32", 14, cVar2, 5);
            t = bVar11;
            b bVar12 = new b("SFIXED64", 15, cVar, 1);
            u = bVar12;
            b bVar13 = new b("SINT32", 16, cVar2, 0);
            v = bVar13;
            b bVar14 = new b("SINT64", 17, cVar, 0);
            w = bVar14;
            x = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, aVar, c0034b, cVar4, dVar, bVar9, bVar10, bVar11, bVar12, bVar13, bVar14};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) x.clone();
        }

        public c g() {
            return this.y;
        }

        public int k() {
            return this.z;
        }

        private b(String str, int i2, c cVar, int i3) {
            super(str, i2);
            this.y = cVar;
            this.z = i3;
        }
    }

    /* JADX INFO: compiled from: WireFormat.java */
    public enum c {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(HttpUrl.FRAGMENT_ENCODE_SET),
        BYTE_STRING(h.f1298f),
        ENUM(null),
        MESSAGE(null);

        private final Object p;

        c(Object obj) {
            this.p = obj;
        }
    }

    public static int a(int i2) {
        return i2 >>> 3;
    }

    public static int b(int i2) {
        return i2 & 7;
    }

    static int c(int i2, int i3) {
        return (i2 << 3) | i3;
    }
}
