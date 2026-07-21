package kotlin.reflect.y.internal.j0.i.r;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.b;

/* JADX INFO: compiled from: ClassLiteralValue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    private final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f24359b;

    public f(b bVar, int i2) {
        m.f(bVar, "classId");
        this.a = bVar;
        this.f24359b = i2;
    }

    public final b a() {
        return this.a;
    }

    public final int b() {
        return this.f24359b;
    }

    public final int c() {
        return this.f24359b;
    }

    public final b d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return m.a(this.a, fVar.a) && this.f24359b == fVar.f24359b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.f24359b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i2 = this.f24359b;
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("kotlin/Array<");
        }
        sb.append(this.a);
        int i4 = this.f24359b;
        for (int i5 = 0; i5 < i4; i5++) {
            sb.append(">");
        }
        String string = sb.toString();
        m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
