package cm.aptoide.pt.home.apps;

/* JADX INFO: loaded from: classes.dex */
public interface App {

    public enum Type {
        UPDATE,
        DOWNLOAD,
        INSTALLED
    }

    String getIdentifier();

    Type getType();
}
