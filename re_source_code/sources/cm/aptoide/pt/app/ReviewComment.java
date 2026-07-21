package cm.aptoide.pt.app;

/* JADX INFO: loaded from: classes.dex */
public class ReviewComment {
    private final long total;
    private final String view;

    public ReviewComment(String str, long j2) {
        this.view = str;
        this.total = j2;
    }

    public long getTotal() {
        return this.total;
    }

    public String getView() {
        return this.view;
    }
}
