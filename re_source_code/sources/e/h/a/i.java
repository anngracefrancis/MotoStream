package e.h.a;

/* JADX INFO: compiled from: FileDownloadListener.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class i {
    public i() {
    }

    protected void blockComplete(a aVar) throws Throwable {
    }

    protected abstract void completed(a aVar);

    protected abstract void connected(a aVar, String str, boolean z, int i2, int i3);

    protected abstract void error(a aVar, Throwable th);

    protected boolean isInvalid() {
        return false;
    }

    protected abstract void paused(a aVar, int i2, int i3);

    protected abstract void pending(a aVar, int i2, int i3);

    protected abstract void progress(a aVar, int i2, int i3);

    protected abstract void retry(a aVar, Throwable th, int i2, int i3);

    protected void started(a aVar) {
    }

    protected abstract void warn(a aVar);

    public i(int i2) {
        e.h.a.k0.d.i(this, "not handle priority any more", new Object[0]);
    }
}
