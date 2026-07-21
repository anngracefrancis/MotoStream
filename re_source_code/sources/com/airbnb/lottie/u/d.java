package com.airbnb.lottie.u;

import android.util.JsonReader;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: AnimatableValueParser.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static <T> List<com.airbnb.lottie.w.a<T>> a(JsonReader jsonReader, float f2, com.airbnb.lottie.d dVar, j0<T> j0Var) throws IOException {
        return r.a(jsonReader, dVar, f2, j0Var);
    }

    private static <T> List<com.airbnb.lottie.w.a<T>> b(JsonReader jsonReader, com.airbnb.lottie.d dVar, j0<T> j0Var) throws IOException {
        return r.a(jsonReader, dVar, 1.0f, j0Var);
    }

    static com.airbnb.lottie.s.i.a c(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.s.i.a(b(jsonReader, dVar, f.a));
    }

    static com.airbnb.lottie.s.i.j d(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.s.i.j(b(jsonReader, dVar, h.a));
    }

    public static com.airbnb.lottie.s.i.b e(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return f(jsonReader, dVar, true);
    }

    public static com.airbnb.lottie.s.i.b f(JsonReader jsonReader, com.airbnb.lottie.d dVar, boolean z) throws IOException {
        return new com.airbnb.lottie.s.i.b(a(jsonReader, z ? com.airbnb.lottie.v.f.e() : 1.0f, dVar, i.a));
    }

    static com.airbnb.lottie.s.i.c g(JsonReader jsonReader, com.airbnb.lottie.d dVar, int i2) throws IOException {
        return new com.airbnb.lottie.s.i.c(b(jsonReader, dVar, new l(i2)));
    }

    static com.airbnb.lottie.s.i.d h(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.s.i.d(b(jsonReader, dVar, o.a));
    }

    static com.airbnb.lottie.s.i.f i(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.s.i.f(a(jsonReader, com.airbnb.lottie.v.f.e(), dVar, y.a));
    }

    static com.airbnb.lottie.s.i.g j(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.s.i.g((List<com.airbnb.lottie.w.a<com.airbnb.lottie.w.d>>) b(jsonReader, dVar, c0.a));
    }

    static com.airbnb.lottie.s.i.h k(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.s.i.h(a(jsonReader, com.airbnb.lottie.v.f.e(), dVar, d0.a));
    }
}
