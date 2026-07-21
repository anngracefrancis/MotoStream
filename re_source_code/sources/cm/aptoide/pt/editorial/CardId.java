package cm.aptoide.pt.editorial;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: EditorialLoadSource.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcm/aptoide/pt/editorial/CardId;", "Lcm/aptoide/pt/editorial/EditorialLoadSource;", "cardId", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;)V", "getCardId", "()Ljava/lang/String;", "component1", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class CardId extends EditorialLoadSource {
    private final String cardId;

    public CardId(String str) {
        super(null);
        this.cardId = str;
    }

    public static /* synthetic */ CardId copy$default(CardId cardId, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cardId.cardId;
        }
        return cardId.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCardId() {
        return this.cardId;
    }

    public final CardId copy(String cardId) {
        return new CardId(cardId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CardId) && kotlin.jvm.internal.m.a(this.cardId, ((CardId) other).cardId);
    }

    public final String getCardId() {
        return this.cardId;
    }

    public int hashCode() {
        String str = this.cardId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "CardId(cardId=" + this.cardId + ')';
    }
}
