package e.e.b.a.i;

import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: SendRequest.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
abstract class p {

    /* JADX INFO: compiled from: SendRequest.java */
    @AutoValue.Builder
    public static abstract class a {
        public abstract p a();

        abstract a b(e.e.b.a.b bVar);

        abstract a c(e.e.b.a.c<?> cVar);

        abstract a d(e.e.b.a.e<?, byte[]> eVar);

        public abstract a e(q qVar);

        public abstract a f(String str);
    }

    p() {
    }

    public static a a() {
        return new d.b();
    }

    public abstract e.e.b.a.b b();

    abstract e.e.b.a.c<?> c();

    public byte[] d() {
        return e().a(c().b());
    }

    abstract e.e.b.a.e<?, byte[]> e();

    public abstract q f();

    public abstract String g();
}
