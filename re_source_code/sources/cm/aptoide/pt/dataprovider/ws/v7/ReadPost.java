package cm.aptoide.pt.dataprovider.ws.v7;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes.dex */
public class ReadPost {

    @JsonProperty("uid")
    private final String postId;

    @JsonProperty("type")
    private final String postType;

    public ReadPost(String str, String str2) {
        this.postId = str;
        this.postType = str2;
    }
}
