package com.google.android.datatransport.cct.f;

import com.google.auto.value.AutoValue;
import java.util.List;

/* JADX INFO: compiled from: LogRequest.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class m {

    /* JADX INFO: compiled from: LogRequest.java */
    @AutoValue.Builder
    public static abstract class a {
        public abstract m a();

        public abstract a b(k kVar);

        public abstract a c(List<l> list);

        abstract a d(Integer num);

        abstract a e(String str);

        public abstract a f(p pVar);

        public abstract a g(long j2);

        public abstract a h(long j2);

        public a i(int i2) {
            return d(Integer.valueOf(i2));
        }

        public a j(String str) {
            return e(str);
        }
    }

    public static a a() {
        return new g.b();
    }

    public abstract k b();

    public abstract List<l> c();

    public abstract Integer d();

    public abstract String e();

    public abstract p f();

    public abstract long g();

    public abstract long h();
}
