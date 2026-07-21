package cm.aptoide.pt.editorialList;

import cm.aptoide.pt.reactions.data.TopReaction;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class CurationCard {
    private final String captionColor;
    private final String date;
    private final String flair;
    private final String icon;
    private final String id;
    private int numberOfReactions;
    private List<TopReaction> reactions;
    private final String subTitle;
    private final String title;
    private final String type;
    private String userReaction;

    public CurationCard(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.id = str;
        this.subTitle = str2;
        this.icon = str3;
        this.title = str4;
        this.type = str5;
        this.date = str6;
        this.captionColor = str7;
        this.flair = str8;
        this.reactions = Collections.emptyList();
        this.userReaction = HttpUrl.FRAGMENT_ENCODE_SET;
        this.numberOfReactions = -1;
    }

    public String getCaptionColor() {
        return this.captionColor;
    }

    public String getDate() {
        return this.date;
    }

    public String getFlair() {
        return this.flair;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getId() {
        return this.id;
    }

    public int getNumberOfReactions() {
        return this.numberOfReactions;
    }

    public List<TopReaction> getReactions() {
        return this.reactions;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public String getUserReaction() {
        return this.userReaction;
    }

    public void setNumberOfReactions(int i2) {
        this.numberOfReactions = i2;
    }

    public void setReactions(List<TopReaction> list) {
        this.reactions = list;
    }

    public void setUserReaction(String str) {
        this.userReaction = str;
    }

    public CurationCard() {
        this.id = HttpUrl.FRAGMENT_ENCODE_SET;
        this.subTitle = HttpUrl.FRAGMENT_ENCODE_SET;
        this.icon = HttpUrl.FRAGMENT_ENCODE_SET;
        this.title = HttpUrl.FRAGMENT_ENCODE_SET;
        this.type = HttpUrl.FRAGMENT_ENCODE_SET;
        this.date = HttpUrl.FRAGMENT_ENCODE_SET;
        this.captionColor = HttpUrl.FRAGMENT_ENCODE_SET;
        this.flair = HttpUrl.FRAGMENT_ENCODE_SET;
    }
}
