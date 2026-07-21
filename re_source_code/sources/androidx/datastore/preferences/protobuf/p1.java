package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: UnsafeUtil.java */
/* JADX INFO: loaded from: classes.dex */
final class p1 {
    private static final Logger a = Logger.getLogger(p1.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Unsafe f1384b = B();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Class<?> f1385c = androidx.datastore.preferences.protobuf.d.b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f1386d = m(Long.TYPE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final boolean f1387e = m(Integer.TYPE);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final e f1388f = z();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final boolean f1389g = Q();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final boolean f1390h = P();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final long f1391i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f1392j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f1393k;
    private static final long l;
    private static final long m;
    private static final long n;
    private static final long o;
    private static final long p;
    private static final long q;
    private static final long r;
    private static final long s;
    private static final long t;
    private static final long u;
    private static final long v;
    private static final int w;
    static final boolean x;

    /* JADX INFO: compiled from: UnsafeUtil.java */
    static class a implements PrivilegedExceptionAction<Unsafe> {
        a() {
        }

        @Override // java.security.PrivilegedExceptionAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unsafe run() throws Exception {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: UnsafeUtil.java */
    private static final class b extends e {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public boolean c(Object obj, long j2) {
            return p1.x ? p1.q(obj, j2) : p1.r(obj, j2);
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public byte d(Object obj, long j2) {
            return p1.x ? p1.t(obj, j2) : p1.u(obj, j2);
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public double e(Object obj, long j2) {
            return Double.longBitsToDouble(h(obj, j2));
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public float f(Object obj, long j2) {
            return Float.intBitsToFloat(g(obj, j2));
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public void k(Object obj, long j2, boolean z) {
            if (p1.x) {
                p1.F(obj, j2, z);
            } else {
                p1.G(obj, j2, z);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public void l(Object obj, long j2, byte b2) {
            if (p1.x) {
                p1.I(obj, j2, b2);
            } else {
                p1.J(obj, j2, b2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public void m(Object obj, long j2, double d2) {
            p(obj, j2, Double.doubleToLongBits(d2));
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public void n(Object obj, long j2, float f2) {
            o(obj, j2, Float.floatToIntBits(f2));
        }
    }

    /* JADX INFO: compiled from: UnsafeUtil.java */
    private static final class c extends e {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public boolean c(Object obj, long j2) {
            return p1.x ? p1.q(obj, j2) : p1.r(obj, j2);
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public byte d(Object obj, long j2) {
            return p1.x ? p1.t(obj, j2) : p1.u(obj, j2);
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public double e(Object obj, long j2) {
            return Double.longBitsToDouble(h(obj, j2));
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public float f(Object obj, long j2) {
            return Float.intBitsToFloat(g(obj, j2));
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public void k(Object obj, long j2, boolean z) {
            if (p1.x) {
                p1.F(obj, j2, z);
            } else {
                p1.G(obj, j2, z);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public void l(Object obj, long j2, byte b2) {
            if (p1.x) {
                p1.I(obj, j2, b2);
            } else {
                p1.J(obj, j2, b2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public void m(Object obj, long j2, double d2) {
            p(obj, j2, Double.doubleToLongBits(d2));
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public void n(Object obj, long j2, float f2) {
            o(obj, j2, Float.floatToIntBits(f2));
        }
    }

    /* JADX INFO: compiled from: UnsafeUtil.java */
    private static final class d extends e {
        d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public boolean c(Object obj, long j2) {
            return this.a.getBoolean(obj, j2);
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public byte d(Object obj, long j2) {
            return this.a.getByte(obj, j2);
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public double e(Object obj, long j2) {
            return this.a.getDouble(obj, j2);
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public float f(Object obj, long j2) {
            return this.a.getFloat(obj, j2);
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public void k(Object obj, long j2, boolean z) {
            this.a.putBoolean(obj, j2, z);
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public void l(Object obj, long j2, byte b2) {
            this.a.putByte(obj, j2, b2);
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public void m(Object obj, long j2, double d2) {
            this.a.putDouble(obj, j2, d2);
        }

        @Override // androidx.datastore.preferences.protobuf.p1.e
        public void n(Object obj, long j2, float f2) {
            this.a.putFloat(obj, j2, f2);
        }
    }

    /* JADX INFO: compiled from: UnsafeUtil.java */
    private static abstract class e {
        Unsafe a;

        e(Unsafe unsafe) {
            this.a = unsafe;
        }

        public final int a(Class<?> cls) {
            return this.a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.a.arrayIndexScale(cls);
        }

        public abstract boolean c(Object obj, long j2);

        public abstract byte d(Object obj, long j2);

        public abstract double e(Object obj, long j2);

        public abstract float f(Object obj, long j2);

        public final int g(Object obj, long j2) {
            return this.a.getInt(obj, j2);
        }

        public final long h(Object obj, long j2) {
            return this.a.getLong(obj, j2);
        }

        public final Object i(Object obj, long j2) {
            return this.a.getObject(obj, j2);
        }

        public final long j(Field field) {
            return this.a.objectFieldOffset(field);
        }

        public abstract void k(Object obj, long j2, boolean z);

        public abstract void l(Object obj, long j2, byte b2);

        public abstract void m(Object obj, long j2, double d2);

        public abstract void n(Object obj, long j2, float f2);

        public final void o(Object obj, long j2, int i2) {
            this.a.putInt(obj, j2, i2);
        }

        public final void p(Object obj, long j2, long j3) {
            this.a.putLong(obj, j2, j3);
        }

        public final void q(Object obj, long j2, Object obj2) {
            this.a.putObject(obj, j2, obj2);
        }
    }

    static {
        long j2 = j(byte[].class);
        f1391i = j2;
        f1392j = j(boolean[].class);
        f1393k = k(boolean[].class);
        l = j(int[].class);
        m = k(int[].class);
        n = j(long[].class);
        o = k(long[].class);
        p = j(float[].class);
        q = k(float[].class);
        r = j(double[].class);
        s = k(double[].class);
        t = j(Object[].class);
        u = k(Object[].class);
        v = o(l());
        w = (int) (7 & j2);
        x = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private p1() {
    }

    static Object A(Object obj, long j2) {
        return f1388f.i(obj, j2);
    }

    static Unsafe B() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean C() {
        return f1390h;
    }

    static boolean D() {
        return f1389g;
    }

    static void E(Object obj, long j2, boolean z) {
        f1388f.k(obj, j2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F(Object obj, long j2, boolean z) {
        I(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(Object obj, long j2, boolean z) {
        J(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    static void H(byte[] bArr, long j2, byte b2) {
        f1388f.l(bArr, f1391i + j2, b2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void I(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = ((((int) j2) ^ (-1)) & 3) << 3;
        M(obj, j3, ((255 & b2) << i2) | (x(obj, j3) & ((255 << i2) ^ (-1))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void J(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        M(obj, j3, ((255 & b2) << i2) | (x(obj, j3) & ((255 << i2) ^ (-1))));
    }

    static void K(Object obj, long j2, double d2) {
        f1388f.m(obj, j2, d2);
    }

    static void L(Object obj, long j2, float f2) {
        f1388f.n(obj, j2, f2);
    }

    static void M(Object obj, long j2, int i2) {
        f1388f.o(obj, j2, i2);
    }

    static void N(Object obj, long j2, long j3) {
        f1388f.p(obj, j2, j3);
    }

    static void O(Object obj, long j2, Object obj2) {
        f1388f.q(obj, j2, obj2);
    }

    private static boolean P() {
        Unsafe unsafe = f1384b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            if (androidx.datastore.preferences.protobuf.d.c()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    private static boolean Q() {
        Unsafe unsafe = f1384b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (l() == null) {
                return false;
            }
            if (androidx.datastore.preferences.protobuf.d.c()) {
                return true;
            }
            cls.getMethod("getByte", cls2);
            cls.getMethod("putByte", cls2, Byte.TYPE);
            cls.getMethod("getInt", cls2);
            cls.getMethod("putInt", cls2, Integer.TYPE);
            cls.getMethod("getLong", cls2);
            cls.getMethod("putLong", cls2, cls2);
            cls.getMethod("copyMemory", cls2, cls2, cls2);
            cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
            return true;
        } catch (Throwable th) {
            a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    static <T> T i(Class<T> cls) {
        try {
            return (T) f1384b.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int j(Class<?> cls) {
        if (f1390h) {
            return f1388f.a(cls);
        }
        return -1;
    }

    private static int k(Class<?> cls) {
        if (f1390h) {
            return f1388f.b(cls);
        }
        return -1;
    }

    private static Field l() {
        Field fieldN;
        if (androidx.datastore.preferences.protobuf.d.c() && (fieldN = n(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldN;
        }
        Field fieldN2 = n(Buffer.class, "address");
        if (fieldN2 == null || fieldN2.getType() != Long.TYPE) {
            return null;
        }
        return fieldN2;
    }

    private static boolean m(Class<?> cls) {
        if (!androidx.datastore.preferences.protobuf.d.c()) {
            return false;
        }
        try {
            Class<?> cls2 = f1385c;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field n(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long o(Field field) {
        e eVar;
        if (field == null || (eVar = f1388f) == null) {
            return -1L;
        }
        return eVar.j(field);
    }

    static boolean p(Object obj, long j2) {
        return f1388f.c(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean q(Object obj, long j2) {
        return t(obj, j2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean r(Object obj, long j2) {
        return u(obj, j2) != 0;
    }

    static byte s(byte[] bArr, long j2) {
        return f1388f.d(bArr, f1391i + j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte t(Object obj, long j2) {
        return (byte) ((x(obj, (-4) & j2) >>> ((int) (((j2 ^ (-1)) & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte u(Object obj, long j2) {
        return (byte) ((x(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3))) & 255);
    }

    static double v(Object obj, long j2) {
        return f1388f.e(obj, j2);
    }

    static float w(Object obj, long j2) {
        return f1388f.f(obj, j2);
    }

    static int x(Object obj, long j2) {
        return f1388f.g(obj, j2);
    }

    static long y(Object obj, long j2) {
        return f1388f.h(obj, j2);
    }

    private static e z() {
        Unsafe unsafe = f1384b;
        if (unsafe == null) {
            return null;
        }
        if (!androidx.datastore.preferences.protobuf.d.c()) {
            return new d(unsafe);
        }
        if (f1386d) {
            return new c(unsafe);
        }
        if (f1387e) {
            return new b(unsafe);
        }
        return null;
    }
}
