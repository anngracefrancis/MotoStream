package cm.aptoide.pt.dataprovider.model.v7;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes.dex */
public class BundlesEndlessDataListResponse<T> extends BaseV7EndlessResponse {

    @JsonProperty("datalist")
    private BundlesDataList dataList;

    public BundlesDataList getDataList() {
        return this.dataList;
    }

    @Override // cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessResponse
    public int getNextSize() {
        if (hasData()) {
            return this.dataList.getNext();
        }
        return 0;
    }

    @Override // cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessResponse
    public int getTotal() {
        if (hasData()) {
            return this.dataList.getTotal();
        }
        return 0;
    }

    @Override // cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessResponse
    public boolean hasData() {
        BundlesDataList bundlesDataList = this.dataList;
        return (bundlesDataList == null || bundlesDataList.getList() == null) ? false : true;
    }

    public void setDataList(BundlesDataList bundlesDataList) {
        this.dataList = bundlesDataList;
    }
}
