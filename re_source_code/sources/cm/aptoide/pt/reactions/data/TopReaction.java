package cm.aptoide.pt.reactions.data;

/* JADX INFO: loaded from: classes.dex */
public class TopReaction {
    private final int total;
    private final String type;

    public TopReaction(String str, int i2) {
        this.type = str;
        this.total = i2;
    }

    public int getTotal() {
        return this.total;
    }

    public String getType() {
        return this.type;
    }
}
