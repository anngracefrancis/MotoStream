package com.google.firebase.encoders.i;

import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: AtProtobuf.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f.a f19595b = f.a.DEFAULT;

    /* JADX INFO: compiled from: AtProtobuf.java */
    /* JADX INFO: loaded from: classes.dex */
    private static final class a implements f {
        private final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f.a f19596b;

        a(int i2, f.a aVar) {
            this.a = i2;
            this.f19596b = aVar;
        }

        @Override // java.lang.annotation.Annotation
        public Class<? extends Annotation> annotationType() {
            return f.class;
        }

        @Override // java.lang.annotation.Annotation
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.a == fVar.tag() && this.f19596b.equals(fVar.intEncoding());
        }

        @Override // java.lang.annotation.Annotation
        public int hashCode() {
            return (this.a ^ 14552422) + (this.f19596b.hashCode() ^ 2041407134);
        }

        @Override // com.google.firebase.encoders.i.f
        public f.a intEncoding() {
            return this.f19596b;
        }

        @Override // com.google.firebase.encoders.i.f
        public int tag() {
            return this.a;
        }

        @Override // java.lang.annotation.Annotation
        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.a + "intEncoding=" + this.f19596b + ')';
        }
    }

    public static c b() {
        return new c();
    }

    public f a() {
        return new a(this.a, this.f19595b);
    }

    public c c(int i2) {
        this.a = i2;
        return this;
    }
}
