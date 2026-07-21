package rx.q;

/* JADX INFO: compiled from: RxJavaErrorHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    @Deprecated
    public void a(Throwable th) {
    }

    public final String b(Object obj) {
        try {
            return c(obj);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            return obj.getClass().getName() + ".errorRendering";
        }
    }

    protected String c(Object obj) throws InterruptedException {
        return null;
    }
}
