package cm.aptoide.pt.dataprovider.ws.v7.promotions;

import cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessDataListResponse;

/* JADX INFO: loaded from: classes.dex */
public class GetPromotionsResponse extends BaseV7EndlessDataListResponse<PromotionModel> {

    public static class PromotionModel {
        private String background;
        private String description;
        private String dialogDescription;
        private String promotionId;
        private String title;
        private String type;

        public String getBackground() {
            return this.background;
        }

        public String getDescription() {
            return this.description;
        }

        public String getDialogDescription() {
            return this.dialogDescription;
        }

        public String getPromotionId() {
            return this.promotionId;
        }

        public String getTitle() {
            return this.title;
        }

        public String getType() {
            return this.type;
        }

        public void setBackground(String str) {
            this.background = str;
        }

        public void setDescription(String str) {
            this.description = str;
        }

        public void setDialogDescription(String str) {
            this.dialogDescription = str;
        }

        public void setPromotionId(String str) {
            this.promotionId = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setType(String str) {
            this.type = str;
        }
    }
}
