package com.google.firebase.crashlytics.internal.p;

import com.google.auto.value.AutoValue;
import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: compiled from: CrashlyticsReport.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class f0 {
    private static final Charset a = Charset.forName("UTF-8");

    /* JADX INFO: compiled from: CrashlyticsReport.java */
    @AutoValue
    public static abstract class a {

        /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CrashlyticsReport.java */
        @AutoValue
        public static abstract class AbstractC0210a {

            /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: CrashlyticsReport.java */
            @AutoValue.Builder
            public static abstract class AbstractC0211a {
                public abstract AbstractC0210a a();

                public abstract AbstractC0211a b(String str);

                public abstract AbstractC0211a c(String str);

                public abstract AbstractC0211a d(String str);
            }

            public static AbstractC0211a a() {
                return new com.google.firebase.crashlytics.h.p.d.b();
            }

            public abstract String b();

            public abstract String c();

            public abstract String d();
        }

        /* JADX INFO: compiled from: CrashlyticsReport.java */
        @AutoValue.Builder
        public static abstract class b {
            public abstract a a();

            public abstract b b(List<AbstractC0210a> list);

            public abstract b c(int i2);

            public abstract b d(int i2);

            public abstract b e(String str);

            public abstract b f(long j2);

            public abstract b g(int i2);

            public abstract b h(long j2);

            public abstract b i(long j2);

            public abstract b j(String str);
        }

        public static b a() {
            return new com.google.firebase.crashlytics.h.p.c.b();
        }

        public abstract List<AbstractC0210a> b();

        public abstract int c();

        public abstract int d();

        public abstract String e();

        public abstract long f();

        public abstract int g();

        public abstract long h();

        public abstract long i();

        public abstract String j();
    }

    /* JADX INFO: compiled from: CrashlyticsReport.java */
    @AutoValue.Builder
    public static abstract class b {
        public abstract f0 a();

        public abstract b b(a aVar);

        public abstract b c(String str);

        public abstract b d(String str);

        public abstract b e(String str);

        public abstract b f(String str);

        public abstract b g(String str);

        public abstract b h(String str);

        public abstract b i(d dVar);

        public abstract b j(int i2);

        public abstract b k(String str);

        public abstract b l(e eVar);
    }

    /* JADX INFO: compiled from: CrashlyticsReport.java */
    @AutoValue
    public static abstract class c {

        /* JADX INFO: compiled from: CrashlyticsReport.java */
        @AutoValue.Builder
        public static abstract class a {
            public abstract c a();

            public abstract a b(String str);

            public abstract a c(String str);
        }

        public static a a() {
            return new com.google.firebase.crashlytics.h.p.e.b();
        }

        public abstract String b();

        public abstract String c();
    }

    /* JADX INFO: compiled from: CrashlyticsReport.java */
    @AutoValue
    public static abstract class d {

        /* JADX INFO: compiled from: CrashlyticsReport.java */
        @AutoValue.Builder
        public static abstract class a {
            public abstract d a();

            public abstract a b(List<b> list);

            public abstract a c(String str);
        }

        /* JADX INFO: compiled from: CrashlyticsReport.java */
        @AutoValue
        public static abstract class b {

            /* JADX INFO: compiled from: CrashlyticsReport.java */
            @AutoValue.Builder
            public static abstract class a {
                public abstract b a();

                public abstract a b(byte[] bArr);

                public abstract a c(String str);
            }

            public static a a() {
                return new g.b();
            }

            public abstract byte[] b();

            public abstract String c();
        }

        public static a a() {
            return new f.b();
        }

        public abstract List<b> b();

        public abstract String c();
    }

    /* JADX INFO: compiled from: CrashlyticsReport.java */
    @AutoValue
    public static abstract class e {

        /* JADX INFO: compiled from: CrashlyticsReport.java */
        @AutoValue
        public static abstract class a {

            /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$e$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: CrashlyticsReport.java */
            @AutoValue.Builder
            public static abstract class AbstractC0212a {
                public abstract a a();

                public abstract AbstractC0212a b(String str);

                public abstract AbstractC0212a c(String str);

                public abstract AbstractC0212a d(String str);

                public abstract AbstractC0212a e(String str);

                public abstract AbstractC0212a f(String str);

                public abstract AbstractC0212a g(String str);
            }

            /* JADX INFO: compiled from: CrashlyticsReport.java */
            @AutoValue
            public static abstract class b {
                public abstract String a();
            }

            public static AbstractC0212a a() {
                return new i.b();
            }

            public abstract String b();

            public abstract String c();

            public abstract String d();

            public abstract String e();

            public abstract String f();

            public abstract b g();

            public abstract String h();
        }

        /* JADX INFO: compiled from: CrashlyticsReport.java */
        @AutoValue.Builder
        public static abstract class b {
            public abstract e a();

            public abstract b b(a aVar);

            public abstract b c(String str);

            public abstract b d(boolean z);

            public abstract b e(c cVar);

            public abstract b f(Long l);

            public abstract b g(List<d> list);

            public abstract b h(String str);

            public abstract b i(int i2);

            public abstract b j(String str);

            public b k(byte[] bArr) {
                return j(new String(bArr, f0.a));
            }

            public abstract b l(AbstractC0227e abstractC0227e);

            public abstract b m(long j2);

            public abstract b n(f fVar);
        }

        /* JADX INFO: compiled from: CrashlyticsReport.java */
        @AutoValue
        public static abstract class c {

            /* JADX INFO: compiled from: CrashlyticsReport.java */
            @AutoValue.Builder
            public static abstract class a {
                public abstract c a();

                public abstract a b(int i2);

                public abstract a c(int i2);

                public abstract a d(long j2);

                public abstract a e(String str);

                public abstract a f(String str);

                public abstract a g(String str);

                public abstract a h(long j2);

                public abstract a i(boolean z);

                public abstract a j(int i2);
            }

            public static a a() {
                return new k.b();
            }

            public abstract int b();

            public abstract int c();

            public abstract long d();

            public abstract String e();

            public abstract String f();

            public abstract String g();

            public abstract long h();

            public abstract int i();

            public abstract boolean j();
        }

        /* JADX INFO: compiled from: CrashlyticsReport.java */
        @AutoValue
        public static abstract class d {

            /* JADX INFO: compiled from: CrashlyticsReport.java */
            @AutoValue
            public static abstract class a {

                /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$e$d$a$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: CrashlyticsReport.java */
                @AutoValue.Builder
                public static abstract class AbstractC0213a {
                    public abstract a a();

                    public abstract AbstractC0213a b(List<c> list);

                    public abstract AbstractC0213a c(Boolean bool);

                    public abstract AbstractC0213a d(c cVar);

                    public abstract AbstractC0213a e(List<c> list);

                    public abstract AbstractC0213a f(b bVar);

                    public abstract AbstractC0213a g(List<c> list);

                    public abstract AbstractC0213a h(int i2);
                }

                /* JADX INFO: compiled from: CrashlyticsReport.java */
                @AutoValue
                public static abstract class b {

                    /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$e$d$a$b$a, reason: collision with other inner class name */
                    /* JADX INFO: compiled from: CrashlyticsReport.java */
                    @AutoValue
                    public static abstract class AbstractC0214a {

                        /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$e$d$a$b$a$a, reason: collision with other inner class name */
                        /* JADX INFO: compiled from: CrashlyticsReport.java */
                        @AutoValue.Builder
                        public static abstract class AbstractC0215a {
                            public abstract AbstractC0214a a();

                            public abstract AbstractC0215a b(long j2);

                            public abstract AbstractC0215a c(String str);

                            public abstract AbstractC0215a d(long j2);

                            public abstract AbstractC0215a e(String str);

                            public AbstractC0215a f(byte[] bArr) {
                                return e(new String(bArr, f0.a));
                            }
                        }

                        public static AbstractC0215a a() {
                            return new o.b();
                        }

                        public abstract long b();

                        public abstract String c();

                        public abstract long d();

                        public abstract String e();

                        public byte[] f() {
                            String strE = e();
                            if (strE != null) {
                                return strE.getBytes(f0.a);
                            }
                            return null;
                        }
                    }

                    /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$e$d$a$b$b, reason: collision with other inner class name */
                    /* JADX INFO: compiled from: CrashlyticsReport.java */
                    @AutoValue.Builder
                    public static abstract class AbstractC0216b {
                        public abstract b a();

                        public abstract AbstractC0216b b(a aVar);

                        public abstract AbstractC0216b c(List<AbstractC0214a> list);

                        public abstract AbstractC0216b d(c cVar);

                        public abstract AbstractC0216b e(AbstractC0218d abstractC0218d);

                        public abstract AbstractC0216b f(List<AbstractC0220e> list);
                    }

                    /* JADX INFO: compiled from: CrashlyticsReport.java */
                    @AutoValue
                    public static abstract class c {

                        /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$e$d$a$b$c$a, reason: collision with other inner class name */
                        /* JADX INFO: compiled from: CrashlyticsReport.java */
                        @AutoValue.Builder
                        public static abstract class AbstractC0217a {
                            public abstract c a();

                            public abstract AbstractC0217a b(c cVar);

                            public abstract AbstractC0217a c(List<AbstractC0220e.AbstractC0222b> list);

                            public abstract AbstractC0217a d(int i2);

                            public abstract AbstractC0217a e(String str);

                            public abstract AbstractC0217a f(String str);
                        }

                        public static AbstractC0217a a() {
                            return new p.b();
                        }

                        public abstract c b();

                        public abstract List<AbstractC0220e.AbstractC0222b> c();

                        public abstract int d();

                        public abstract String e();

                        public abstract String f();
                    }

                    /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$e$d$a$b$d, reason: collision with other inner class name */
                    /* JADX INFO: compiled from: CrashlyticsReport.java */
                    @AutoValue
                    public static abstract class AbstractC0218d {

                        /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$e$d$a$b$d$a, reason: collision with other inner class name */
                        /* JADX INFO: compiled from: CrashlyticsReport.java */
                        @AutoValue.Builder
                        public static abstract class AbstractC0219a {
                            public abstract AbstractC0218d a();

                            public abstract AbstractC0219a b(long j2);

                            public abstract AbstractC0219a c(String str);

                            public abstract AbstractC0219a d(String str);
                        }

                        public static AbstractC0219a a() {
                            return new q.b();
                        }

                        public abstract long b();

                        public abstract String c();

                        public abstract String d();
                    }

                    /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$e$d$a$b$e, reason: collision with other inner class name */
                    /* JADX INFO: compiled from: CrashlyticsReport.java */
                    @AutoValue
                    public static abstract class AbstractC0220e {

                        /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$e$d$a$b$e$a, reason: collision with other inner class name */
                        /* JADX INFO: compiled from: CrashlyticsReport.java */
                        @AutoValue.Builder
                        public static abstract class AbstractC0221a {
                            public abstract AbstractC0220e a();

                            public abstract AbstractC0221a b(List<AbstractC0222b> list);

                            public abstract AbstractC0221a c(int i2);

                            public abstract AbstractC0221a d(String str);
                        }

                        /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$e$d$a$b$e$b, reason: collision with other inner class name */
                        /* JADX INFO: compiled from: CrashlyticsReport.java */
                        @AutoValue
                        public static abstract class AbstractC0222b {

                            /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$e$d$a$b$e$b$a, reason: collision with other inner class name */
                            /* JADX INFO: compiled from: CrashlyticsReport.java */
                            @AutoValue.Builder
                            public static abstract class AbstractC0223a {
                                public abstract AbstractC0222b a();

                                public abstract AbstractC0223a b(String str);

                                public abstract AbstractC0223a c(int i2);

                                public abstract AbstractC0223a d(long j2);

                                public abstract AbstractC0223a e(long j2);

                                public abstract AbstractC0223a f(String str);
                            }

                            public static AbstractC0223a a() {
                                return new s.b();
                            }

                            public abstract String b();

                            public abstract int c();

                            public abstract long d();

                            public abstract long e();

                            public abstract String f();
                        }

                        public static AbstractC0221a a() {
                            return new r.b();
                        }

                        public abstract List<AbstractC0222b> b();

                        public abstract int c();

                        public abstract String d();
                    }

                    public static AbstractC0216b a() {
                        return new n.b();
                    }

                    public abstract a b();

                    public abstract List<AbstractC0214a> c();

                    public abstract c d();

                    public abstract AbstractC0218d e();

                    public abstract List<AbstractC0220e> f();
                }

                /* JADX INFO: compiled from: CrashlyticsReport.java */
                @AutoValue
                public static abstract class c {

                    /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$e$d$a$c$a, reason: collision with other inner class name */
                    /* JADX INFO: compiled from: CrashlyticsReport.java */
                    @AutoValue.Builder
                    public static abstract class AbstractC0224a {
                        public abstract c a();

                        public abstract AbstractC0224a b(boolean z);

                        public abstract AbstractC0224a c(int i2);

                        public abstract AbstractC0224a d(int i2);

                        public abstract AbstractC0224a e(String str);
                    }

                    public static AbstractC0224a a() {
                        return new t.b();
                    }

                    public abstract int b();

                    public abstract int c();

                    public abstract String d();

                    public abstract boolean e();
                }

                public static AbstractC0213a a() {
                    return new m.b();
                }

                public abstract List<c> b();

                public abstract Boolean c();

                public abstract c d();

                public abstract List<c> e();

                public abstract b f();

                public abstract List<c> g();

                public abstract int h();

                public abstract AbstractC0213a i();
            }

            /* JADX INFO: compiled from: CrashlyticsReport.java */
            @AutoValue.Builder
            public static abstract class b {
                public abstract d a();

                public abstract b b(a aVar);

                public abstract b c(c cVar);

                public abstract b d(AbstractC0225d abstractC0225d);

                public abstract b e(f fVar);

                public abstract b f(long j2);

                public abstract b g(String str);
            }

            /* JADX INFO: compiled from: CrashlyticsReport.java */
            @AutoValue
            public static abstract class c {

                /* JADX INFO: compiled from: CrashlyticsReport.java */
                @AutoValue.Builder
                public static abstract class a {
                    public abstract c a();

                    public abstract a b(Double d2);

                    public abstract a c(int i2);

                    public abstract a d(long j2);

                    public abstract a e(int i2);

                    public abstract a f(boolean z);

                    public abstract a g(long j2);
                }

                public static a a() {
                    return new u.b();
                }

                public abstract Double b();

                public abstract int c();

                public abstract long d();

                public abstract int e();

                public abstract long f();

                public abstract boolean g();
            }

            /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$e$d$d, reason: collision with other inner class name */
            /* JADX INFO: compiled from: CrashlyticsReport.java */
            @AutoValue
            public static abstract class AbstractC0225d {

                /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$e$d$d$a */
                /* JADX INFO: compiled from: CrashlyticsReport.java */
                @AutoValue.Builder
                public static abstract class a {
                    public abstract AbstractC0225d a();

                    public abstract a b(String str);
                }

                public static a a() {
                    return new v.b();
                }

                public abstract String b();
            }

            /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$e$d$e, reason: collision with other inner class name */
            /* JADX INFO: compiled from: CrashlyticsReport.java */
            @AutoValue
            public static abstract class AbstractC0226e {

                /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$e$d$e$a */
                /* JADX INFO: compiled from: CrashlyticsReport.java */
                @AutoValue.Builder
                public static abstract class a {
                    public abstract AbstractC0226e a();

                    public abstract a b(String str);

                    public abstract a c(String str);

                    public abstract a d(b bVar);

                    public abstract a e(long j2);
                }

                /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$e$d$e$b */
                /* JADX INFO: compiled from: CrashlyticsReport.java */
                @AutoValue
                public static abstract class b {

                    /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$e$d$e$b$a */
                    /* JADX INFO: compiled from: CrashlyticsReport.java */
                    @AutoValue.Builder
                    public static abstract class a {
                        public abstract b a();

                        public abstract a b(String str);

                        public abstract a c(String str);
                    }

                    public static a a() {
                        return new x.b();
                    }

                    public abstract String b();

                    public abstract String c();
                }

                public static a a() {
                    return new w.b();
                }

                public abstract String b();

                public abstract String c();

                public abstract b d();

                public abstract long e();
            }

            /* JADX INFO: compiled from: CrashlyticsReport.java */
            @AutoValue
            public static abstract class f {

                /* JADX INFO: compiled from: CrashlyticsReport.java */
                @AutoValue.Builder
                public static abstract class a {
                    public abstract f a();

                    public abstract a b(List<AbstractC0226e> list);
                }

                public static a a() {
                    return new y.b();
                }

                public abstract List<AbstractC0226e> b();
            }

            public static b a() {
                return new l.b();
            }

            public abstract a b();

            public abstract c c();

            public abstract AbstractC0225d d();

            public abstract f e();

            public abstract long f();

            public abstract String g();

            public abstract b h();
        }

        /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$e$e, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CrashlyticsReport.java */
        @AutoValue
        public static abstract class AbstractC0227e {

            /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.p.f0$e$e$a */
            /* JADX INFO: compiled from: CrashlyticsReport.java */
            @AutoValue.Builder
            public static abstract class a {
                public abstract AbstractC0227e a();

                public abstract a b(String str);

                public abstract a c(boolean z);

                public abstract a d(int i2);

                public abstract a e(String str);
            }

            public static a a() {
                return new z.b();
            }

            public abstract String b();

            public abstract int c();

            public abstract String d();

            public abstract boolean e();
        }

        /* JADX INFO: compiled from: CrashlyticsReport.java */
        @AutoValue
        public static abstract class f {

            /* JADX INFO: compiled from: CrashlyticsReport.java */
            @AutoValue.Builder
            public static abstract class a {
                public abstract f a();

                public abstract a b(String str);
            }

            public static a a() {
                return new a0.b();
            }

            public abstract String b();
        }

        public static b a() {
            return new h.b().d(false);
        }

        public abstract a b();

        public abstract String c();

        public abstract c d();

        public abstract Long e();

        public abstract List<d> f();

        public abstract String g();

        public abstract int h();

        public abstract String i();

        public byte[] j() {
            return i().getBytes(f0.a);
        }

        public abstract AbstractC0227e k();

        public abstract long l();

        public abstract f m();

        public abstract boolean n();

        public abstract b o();

        e p(String str) {
            return o().c(str).a();
        }

        e q(List<d> list) {
            return o().g(list).a();
        }

        e r(long j2, boolean z, String str) {
            b bVarO = o();
            bVarO.f(Long.valueOf(j2));
            bVarO.d(z);
            if (str != null) {
                bVarO.n(f.a().b(str).a());
            }
            return bVarO.a();
        }
    }

    public static b b() {
        return new com.google.firebase.crashlytics.internal.p.b.C0209b();
    }

    public abstract a c();

    public abstract String d();

    public abstract String e();

    public abstract String f();

    public abstract String g();

    public abstract String h();

    public abstract String i();

    public abstract d j();

    public abstract int k();

    public abstract String l();

    public abstract e m();

    protected abstract b n();

    public f0 o(String str) {
        b bVarC = n().c(str);
        if (m() != null) {
            bVarC.l(m().p(str));
        }
        return bVarC.a();
    }

    public f0 p(a aVar) {
        return aVar == null ? this : n().b(aVar).a();
    }

    public f0 q(List<e.d> list) {
        if (m() != null) {
            return n().l(m().q(list)).a();
        }
        throw new IllegalStateException("Reports without sessions cannot have events added to them.");
    }

    public f0 r(String str) {
        return n().f(str).a();
    }

    public f0 s(d dVar) {
        return n().l(null).i(dVar).a();
    }

    public f0 t(long j2, boolean z, String str) {
        b bVarN = n();
        if (m() != null) {
            bVarN.l(m().r(j2, z, str));
        }
        return bVarN.a();
    }
}
