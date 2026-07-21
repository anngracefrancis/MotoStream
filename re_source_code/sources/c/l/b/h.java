package c.l.b;

import androidx.datastore.preferences.protobuf.r0;
import androidx.datastore.preferences.protobuf.y;
import androidx.datastore.preferences.protobuf.y0;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: PreferencesProto.java */
/* JADX INFO: loaded from: classes.dex */
public final class h extends y<h, a> implements r0 {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    private static final h DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile y0<h> PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int bitField0_;
    private int valueCase_ = 0;
    private Object value_;

    /* JADX INFO: compiled from: PreferencesProto.java */
    public static final class a extends y.a<h, a> implements r0 {
        /* synthetic */ a(e eVar) {
            this();
        }

        public a A(double d2) {
            r();
            ((h) this.f1448g).c0(d2);
            return this;
        }

        public a B(float f2) {
            r();
            ((h) this.f1448g).d0(f2);
            return this;
        }

        public a C(int i2) {
            r();
            ((h) this.f1448g).e0(i2);
            return this;
        }

        public a D(long j2) {
            r();
            ((h) this.f1448g).f0(j2);
            return this;
        }

        public a E(String str) {
            r();
            ((h) this.f1448g).g0(str);
            return this;
        }

        public a F(g.a aVar) {
            r();
            ((h) this.f1448g).h0(aVar);
            return this;
        }

        public a w(boolean z) {
            r();
            ((h) this.f1448g).b0(z);
            return this;
        }

        private a() {
            super(h.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: compiled from: PreferencesProto.java */
    public enum b {
        BOOLEAN(1),
        FLOAT(2),
        INTEGER(3),
        LONG(4),
        STRING(5),
        STRING_SET(6),
        DOUBLE(7),
        VALUE_NOT_SET(0);

        private final int o;

        b(int i2) {
            this.o = i2;
        }

        public static b g(int i2) {
            switch (i2) {
                case 0:
                    return VALUE_NOT_SET;
                case 1:
                    return BOOLEAN;
                case 2:
                    return FLOAT;
                case 3:
                    return INTEGER;
                case 4:
                    return LONG;
                case 5:
                    return STRING;
                case 6:
                    return STRING_SET;
                case 7:
                    return DOUBLE;
                default:
                    return null;
            }
        }
    }

    static {
        h hVar = new h();
        DEFAULT_INSTANCE = hVar;
        y.H(h.class, hVar);
    }

    private h() {
    }

    public static h S() {
        return DEFAULT_INSTANCE;
    }

    public static a a0() {
        return DEFAULT_INSTANCE.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(boolean z) {
        this.valueCase_ = 1;
        this.value_ = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(double d2) {
        this.valueCase_ = 7;
        this.value_ = Double.valueOf(d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(float f2) {
        this.valueCase_ = 2;
        this.value_ = Float.valueOf(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(int i2) {
        this.valueCase_ = 3;
        this.value_ = Integer.valueOf(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(long j2) {
        this.valueCase_ = 4;
        this.value_ = Long.valueOf(j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(String str) {
        str.getClass();
        this.valueCase_ = 5;
        this.value_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(g.a aVar) {
        this.value_ = aVar.c();
        this.valueCase_ = 6;
    }

    public boolean R() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public double T() {
        if (this.valueCase_ == 7) {
            return ((Double) this.value_).doubleValue();
        }
        return 0.0d;
    }

    public float U() {
        if (this.valueCase_ == 2) {
            return ((Float) this.value_).floatValue();
        }
        return 0.0f;
    }

    public int V() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }

    public long W() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0L;
    }

    public String X() {
        return this.valueCase_ == 5 ? (String) this.value_ : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public g Y() {
        return this.valueCase_ == 6 ? (g) this.value_ : g.N();
    }

    public b Z() {
        return b.g(this.valueCase_);
    }

    @Override // androidx.datastore.preferences.protobuf.y
    protected final Object u(y.f fVar, Object obj, Object obj2) {
        e eVar = null;
        switch (e.a[fVar.ordinal()]) {
            case 1:
                return new h();
            case 2:
                return new a(eVar);
            case 3:
                return y.E(DEFAULT_INSTANCE, "\u0001\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000", new Object[]{"value_", "valueCase_", "bitField0_", g.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                y0<h> bVar = PARSER;
                if (bVar == null) {
                    synchronized (h.class) {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new y.b<>(DEFAULT_INSTANCE);
                            PARSER = bVar;
                        }
                        break;
                    }
                }
                return bVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
