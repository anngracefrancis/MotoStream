package cm.aptoide.pt.dataprovider.ws.v7.promotions;

import cm.aptoide.pt.dataprovider.model.v7.AppCoinsCampaign;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessDataListResponse;
import cm.aptoide.pt.dataprovider.model.v7.GetAppMeta;

/* JADX INFO: loaded from: classes.dex */
public class GetPromotionAppsResponse extends BaseV7EndlessDataListResponse<PromotionAppModel> {

    public static class PromotionAppModel {
        private GetAppMeta.App app;
        private float appc;
        private boolean claimed;
        private AppCoinsCampaign.Fiat fiat;
        private String promotionDescription;

        public GetAppMeta.App getApp() {
            return this.app;
        }

        public float getAppc() {
            return this.appc;
        }

        public AppCoinsCampaign.Fiat getFiat() {
            return this.fiat;
        }

        public String getPromotionDescription() {
            return this.promotionDescription;
        }

        public boolean isClaimed() {
            return this.claimed;
        }

        public void setApp(GetAppMeta.App app) {
            this.app = app;
        }

        public void setAppc(float f2) {
            this.appc = f2;
        }

        public void setClaimed(boolean z) {
            this.claimed = z;
        }

        public void setFiat(AppCoinsCampaign.Fiat fiat) {
            this.fiat = fiat;
        }

        public void setPromotionDescription(String str) {
            this.promotionDescription = str;
        }
    }
}
