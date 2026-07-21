package cm.aptoide.pt.app;

/* JADX INFO: loaded from: classes.dex */
public class ReviewUser {
    private final String avatar;
    private final long id;
    private final String name;

    public ReviewUser(long j2, String str, String str2) {
        this.id = j2;
        this.avatar = str;
        this.name = str2;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
