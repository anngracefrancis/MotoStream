package io.sentry.transport;

/* JADX INFO: compiled from: TransportResult.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a0 {

    /* JADX INFO: compiled from: TransportResult.java */
    private static final class b extends a0 {
        private final int a;

        b(int i2) {
            super();
            this.a = i2;
        }

        @Override // io.sentry.transport.a0
        public int c() {
            return this.a;
        }

        @Override // io.sentry.transport.a0
        public boolean d() {
            return false;
        }
    }

    /* JADX INFO: compiled from: TransportResult.java */
    private static final class c extends a0 {
        static final c a = new c();

        private c() {
            super();
        }

        @Override // io.sentry.transport.a0
        public int c() {
            return -1;
        }

        @Override // io.sentry.transport.a0
        public boolean d() {
            return true;
        }
    }

    public static a0 a() {
        return b(-1);
    }

    public static a0 b(int i2) {
        return new b(i2);
    }

    public static a0 e() {
        return c.a;
    }

    public abstract int c();

    public abstract boolean d();

    private a0() {
    }
}
