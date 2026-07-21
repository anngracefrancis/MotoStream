package cm.aptoide.pt.dataprovider.ws.v7.analyticsbody;

/* JADX INFO: loaded from: classes.dex */
public class Obb {
    private String mirror;
    private ObbType type;
    private String url;

    public enum ObbType {
        MAIN,
        PATCH
    }

    public String getMirror() {
        return this.mirror;
    }

    public ObbType getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setMirror(String str) {
        this.mirror = str;
    }

    public void setType(ObbType obbType) {
        this.type = obbType;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
