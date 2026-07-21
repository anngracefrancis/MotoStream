package cm.aptoide.pt.dataprovider.ws.v7.home;

import cm.aptoide.pt.bonus.BonusAppcModel;

/* JADX INFO: loaded from: classes.dex */
public class EditorialActionItem {
    private ActionItemResponse actionItemResponse;
    private BonusAppcModel bonusAppcModel;

    public EditorialActionItem(ActionItemResponse actionItemResponse, BonusAppcModel bonusAppcModel) {
        this.actionItemResponse = actionItemResponse;
        this.bonusAppcModel = bonusAppcModel;
    }

    public ActionItemResponse getActionItemResponse() {
        return this.actionItemResponse;
    }

    public BonusAppcModel getBonusAppcModel() {
        return this.bonusAppcModel;
    }
}
