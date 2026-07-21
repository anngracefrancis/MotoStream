package com.airbnb.lottie.s.j;

/* JADX INFO: compiled from: MergePaths.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements b {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f8750b;

    /* JADX INFO: compiled from: MergePaths.java */
    public enum a {
        Merge,
        Add,
        Subtract,
        Intersect,
        ExcludeIntersections;

        public static a g(int i2) {
            if (i2 == 1) {
                return Merge;
            }
            if (i2 == 2) {
                return Add;
            }
            if (i2 == 3) {
                return Subtract;
            }
            if (i2 != 4) {
                return i2 != 5 ? Merge : ExcludeIntersections;
            }
            return Intersect;
        }
    }

    public h(String str, a aVar) {
        this.a = str;
        this.f8750b = aVar;
    }

    @Override // com.airbnb.lottie.s.j.b
    public com.airbnb.lottie.q.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar) {
        if (fVar.h()) {
            return new com.airbnb.lottie.q.a.k(this);
        }
        com.airbnb.lottie.c.d("Animation contains merge paths but they are disabled.");
        return null;
    }

    public a b() {
        return this.f8750b;
    }

    public String c() {
        return this.a;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f8750b + '}';
    }
}
