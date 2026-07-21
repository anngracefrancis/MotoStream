package com.google.firebase.components;

/* JADX INFO: compiled from: Dependency.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v {
    private final b0<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f18913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f18914c;

    private v(Class<?> cls, int i2, int i3) {
        this((b0<?>) b0.b(cls), i2, i3);
    }

    public static v a(Class<?> cls) {
        return new v(cls, 0, 2);
    }

    private static String b(int i2) {
        if (i2 == 0) {
            return "direct";
        }
        if (i2 == 1) {
            return "provider";
        }
        if (i2 == 2) {
            return "deferred";
        }
        throw new AssertionError("Unsupported injection: " + i2);
    }

    @Deprecated
    public static v h(Class<?> cls) {
        return new v(cls, 0, 0);
    }

    public static v i(Class<?> cls) {
        return new v(cls, 0, 1);
    }

    public static v j(b0<?> b0Var) {
        return new v(b0Var, 1, 0);
    }

    public static v k(Class<?> cls) {
        return new v(cls, 1, 0);
    }

    public static v l(b0<?> b0Var) {
        return new v(b0Var, 1, 1);
    }

    public static v m(Class<?> cls) {
        return new v(cls, 1, 1);
    }

    public static v n(Class<?> cls) {
        return new v(cls, 2, 0);
    }

    public b0<?> c() {
        return this.a;
    }

    public boolean d() {
        return this.f18914c == 2;
    }

    public boolean e() {
        return this.f18914c == 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.a.equals(vVar.a) && this.f18913b == vVar.f18913b && this.f18914c == vVar.f18914c;
    }

    public boolean f() {
        return this.f18913b == 1;
    }

    public boolean g() {
        return this.f18913b == 2;
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f18913b) * 1000003) ^ this.f18914c;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.a);
        sb.append(", type=");
        int i2 = this.f18913b;
        if (i2 == 1) {
            str = "required";
        } else {
            str = i2 == 0 ? "optional" : "set";
        }
        sb.append(str);
        sb.append(", injection=");
        sb.append(b(this.f18914c));
        sb.append("}");
        return sb.toString();
    }

    private v(b0<?> b0Var, int i2, int i3) {
        this.a = (b0) a0.c(b0Var, "Null dependency anInterface.");
        this.f18913b = i2;
        this.f18914c = i3;
    }
}
