package cm.aptoide.pt.promotions;

/* JADX INFO: loaded from: classes.dex */
public class ClaimPromotionsClickWrapper extends ClaimPromotionsWrapper {
    private String walletAddress;

    public ClaimPromotionsClickWrapper(String str, String str2) {
        super(str2);
        this.walletAddress = str;
    }

    public String getWalletAddress() {
        return this.walletAddress;
    }
}
