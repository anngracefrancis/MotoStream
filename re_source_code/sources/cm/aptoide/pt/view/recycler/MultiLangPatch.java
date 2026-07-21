package cm.aptoide.pt.view.recycler;

import cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessResponse;

/* JADX INFO: loaded from: classes.dex */
public class MultiLangPatch {
    private int total;
    private int totalWaiting;

    public int getTotal() {
        return this.total;
    }

    void updateOffset() {
        this.total = this.totalWaiting;
    }

    void updateTotal(BaseV7EndlessResponse baseV7EndlessResponse) {
        this.totalWaiting += baseV7EndlessResponse.getTotal();
    }
}
