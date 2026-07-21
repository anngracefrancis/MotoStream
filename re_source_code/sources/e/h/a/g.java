package e.h.a;

/* JADX INFO: compiled from: FileDownloadLargeFileListener.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends i {
    public g() {
    }

    @Override // e.h.a.i
    protected void connected(a aVar, String str, boolean z, int i2, int i3) {
    }

    protected void connected(a aVar, String str, boolean z, long j2, long j3) {
    }

    @Override // e.h.a.i
    protected void paused(a aVar, int i2, int i3) {
    }

    protected abstract void paused(a aVar, long j2, long j3);

    @Override // e.h.a.i
    protected void pending(a aVar, int i2, int i3) {
    }

    protected abstract void pending(a aVar, long j2, long j3);

    @Override // e.h.a.i
    protected void progress(a aVar, int i2, int i3) {
    }

    protected abstract void progress(a aVar, long j2, long j3);

    @Override // e.h.a.i
    protected void retry(a aVar, Throwable th, int i2, int i3) {
    }

    protected void retry(a aVar, Throwable th, int i2, long j2) {
    }

    public g(int i2) {
        super(i2);
    }
}
