package kotlin.reflect.y.internal.j0.e;

import kotlin.p002reflect.jvm.internal.impl.protobuf.i;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public enum k implements i.a {
    FINAL(0, 0),
    OPEN(1, 1),
    ABSTRACT(2, 2),
    SEALED(3, 3);


    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static i.b<k> f24020j = new i.b<k>() { // from class: kotlin.f0.y.e.j0.e.k.a
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public k a(int i2) {
            return k.g(i2);
        }
    };
    private final int l;

    k(int i2, int i3) {
        this.l = i3;
    }

    public static k g(int i2) {
        if (i2 == 0) {
            return FINAL;
        }
        if (i2 == 1) {
            return OPEN;
        }
        if (i2 == 2) {
            return ABSTRACT;
        }
        if (i2 != 3) {
            return null;
        }
        return SEALED;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
    public final int f() {
        return this.l;
    }
}
