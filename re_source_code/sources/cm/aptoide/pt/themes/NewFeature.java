package cm.aptoide.pt.themes;

import cm.aptoide.pt.DeepLinkIntentReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: NewFeature.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcm/aptoide/pt/themes/NewFeature;", HttpUrl.FRAGMENT_ENCODE_SET, DeepLinkIntentReceiver.DeepLinksKeys.ID, HttpUrl.FRAGMENT_ENCODE_SET, "title", "description", "actionId", "actionStringRes", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getActionId", "()Ljava/lang/String;", "getActionStringRes", "()I", "getDescription", "getId", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", "toString", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class NewFeature {
    private final String actionId;
    private final int actionStringRes;
    private final String description;
    private final String id;
    private final String title;

    public NewFeature(String str, String str2, String str3, String str4, int i2) {
        m.f(str, DeepLinkIntentReceiver.DeepLinksKeys.ID);
        m.f(str2, "title");
        m.f(str3, "description");
        m.f(str4, "actionId");
        this.id = str;
        this.title = str2;
        this.description = str3;
        this.actionId = str4;
        this.actionStringRes = i2;
    }

    public static /* synthetic */ NewFeature copy$default(NewFeature newFeature, String str, String str2, String str3, String str4, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = newFeature.id;
        }
        if ((i3 & 2) != 0) {
            str2 = newFeature.title;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            str3 = newFeature.description;
        }
        String str6 = str3;
        if ((i3 & 8) != 0) {
            str4 = newFeature.actionId;
        }
        String str7 = str4;
        if ((i3 & 16) != 0) {
            i2 = newFeature.actionStringRes;
        }
        return newFeature.copy(str, str5, str6, str7, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getActionId() {
        return this.actionId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getActionStringRes() {
        return this.actionStringRes;
    }

    public final NewFeature copy(String id, String title, String description, String actionId, int actionStringRes) {
        m.f(id, DeepLinkIntentReceiver.DeepLinksKeys.ID);
        m.f(title, "title");
        m.f(description, "description");
        m.f(actionId, "actionId");
        return new NewFeature(id, title, description, actionId, actionStringRes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewFeature)) {
            return false;
        }
        NewFeature newFeature = (NewFeature) other;
        return m.a(this.id, newFeature.id) && m.a(this.title, newFeature.title) && m.a(this.description, newFeature.description) && m.a(this.actionId, newFeature.actionId) && this.actionStringRes == newFeature.actionStringRes;
    }

    public final String getActionId() {
        return this.actionId;
    }

    public final int getActionStringRes() {
        return this.actionStringRes;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.actionId.hashCode()) * 31) + this.actionStringRes;
    }

    public String toString() {
        return "NewFeature(id=" + this.id + ", title=" + this.title + ", description=" + this.description + ", actionId=" + this.actionId + ", actionStringRes=" + this.actionStringRes + ')';
    }
}
