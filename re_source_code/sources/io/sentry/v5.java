package io.sentry;

/* JADX INFO: compiled from: UncaughtExceptionHandler.java */
/* JADX INFO: loaded from: classes2.dex */
interface v5 {

    /* JADX INFO: compiled from: UncaughtExceptionHandler.java */
    public static final class a implements v5 {
        private static final a a = new a();

        private a() {
        }

        static v5 c() {
            return a;
        }

        @Override // io.sentry.v5
        public void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }

        @Override // io.sentry.v5
        public Thread.UncaughtExceptionHandler b() {
            return Thread.getDefaultUncaughtExceptionHandler();
        }
    }

    void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler);

    Thread.UncaughtExceptionHandler b();
}
