package cm.aptoide.pt.promotions;

import java.util.List;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Promotion.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0001&B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JA\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010!\u001a\u00020\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0006\u0010$\u001a\u00020\u0003J\t\u0010%\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u0006'"}, d2 = {"Lcm/aptoide/pt/promotions/Promotion;", HttpUrl.FRAGMENT_ENCODE_SET, "isClaimed", HttpUrl.FRAGMENT_ENCODE_SET, "appc", HttpUrl.FRAGMENT_ENCODE_SET, "packageName", HttpUrl.FRAGMENT_ENCODE_SET, "promotionId", "claimActions", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/pt/promotions/Promotion$ClaimAction;", "(ZFLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAppc", "()F", "getClaimActions", "()Ljava/util/List;", "setClaimActions", "(Ljava/util/List;)V", "()Z", "setClaimed", "(Z)V", "getPackageName", "()Ljava/lang/String;", "getPromotionId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "exists", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "isClaimable", "toString", "ClaimAction", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class Promotion {
    private final float appc;
    private List<? extends ClaimAction> claimActions;
    private boolean isClaimed;
    private final String packageName;
    private final String promotionId;

    /* JADX INFO: compiled from: Promotion.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcm/aptoide/pt/promotions/Promotion$ClaimAction;", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;I)V", "INSTALL", "MIGRATE", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum ClaimAction {
        INSTALL,
        MIGRATE
    }

    public Promotion() {
        this(false, 0.0f, null, null, null, 31, null);
    }

    public Promotion(boolean z, float f2, String str, String str2, List<? extends ClaimAction> list) {
        kotlin.jvm.internal.m.f(str, "packageName");
        kotlin.jvm.internal.m.f(str2, "promotionId");
        kotlin.jvm.internal.m.f(list, "claimActions");
        this.isClaimed = z;
        this.appc = f2;
        this.packageName = str;
        this.promotionId = str2;
        this.claimActions = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Promotion copy$default(Promotion promotion, boolean z, float f2, String str, String str2, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = promotion.isClaimed;
        }
        if ((i2 & 2) != 0) {
            f2 = promotion.appc;
        }
        float f3 = f2;
        if ((i2 & 4) != 0) {
            str = promotion.packageName;
        }
        String str3 = str;
        if ((i2 & 8) != 0) {
            str2 = promotion.promotionId;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            list = promotion.claimActions;
        }
        return promotion.copy(z, f3, str3, str4, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsClaimed() {
        return this.isClaimed;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getAppc() {
        return this.appc;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPromotionId() {
        return this.promotionId;
    }

    public final List<ClaimAction> component5() {
        return this.claimActions;
    }

    public final Promotion copy(boolean isClaimed, float appc, String packageName, String promotionId, List<? extends ClaimAction> claimActions) {
        kotlin.jvm.internal.m.f(packageName, "packageName");
        kotlin.jvm.internal.m.f(promotionId, "promotionId");
        kotlin.jvm.internal.m.f(claimActions, "claimActions");
        return new Promotion(isClaimed, appc, packageName, promotionId, claimActions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Promotion)) {
            return false;
        }
        Promotion promotion = (Promotion) other;
        return this.isClaimed == promotion.isClaimed && kotlin.jvm.internal.m.a(Float.valueOf(this.appc), Float.valueOf(promotion.appc)) && kotlin.jvm.internal.m.a(this.packageName, promotion.packageName) && kotlin.jvm.internal.m.a(this.promotionId, promotion.promotionId) && kotlin.jvm.internal.m.a(this.claimActions, promotion.claimActions);
    }

    public final boolean exists() {
        return !(this.promotionId.length() == 0);
    }

    public final float getAppc() {
        return this.appc;
    }

    public final List<ClaimAction> getClaimActions() {
        return this.claimActions;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean z = this.isClaimed;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((r0 * 31) + Float.floatToIntBits(this.appc)) * 31) + this.packageName.hashCode()) * 31) + this.promotionId.hashCode()) * 31) + this.claimActions.hashCode();
    }

    public final boolean isClaimable() {
        return exists() && !this.isClaimed;
    }

    public final boolean isClaimed() {
        return this.isClaimed;
    }

    public final void setClaimActions(List<? extends ClaimAction> list) {
        kotlin.jvm.internal.m.f(list, "<set-?>");
        this.claimActions = list;
    }

    public final void setClaimed(boolean z) {
        this.isClaimed = z;
    }

    public String toString() {
        return "Promotion(isClaimed=" + this.isClaimed + ", appc=" + this.appc + ", packageName=" + this.packageName + ", promotionId=" + this.promotionId + ", claimActions=" + this.claimActions + ')';
    }

    public /* synthetic */ Promotion(boolean z, float f2, String str, String str2, List list, int i2, kotlin.jvm.internal.g gVar) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? -1.0f : f2, (i2 & 4) != 0 ? HttpUrl.FRAGMENT_ENCODE_SET : str, (i2 & 8) == 0 ? str2 : HttpUrl.FRAGMENT_ENCODE_SET, (i2 & 16) != 0 ? kotlin.collections.u.j() : list);
    }
}
