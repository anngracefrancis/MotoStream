package cm.aptoide.pt.dataprovider.model.v7;

/* JADX INFO: loaded from: classes.dex */
public class GroupDatalist extends BaseV7EndlessDataListResponse<Group> {
    @Override // cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessDataListResponse, cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessResponse, cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    protected boolean canEqual(Object obj) {
        return obj instanceof GroupDatalist;
    }

    @Override // cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessDataListResponse, cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessResponse, cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof GroupDatalist) && ((GroupDatalist) obj).canEqual(this) && super.equals(obj);
    }

    @Override // cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessDataListResponse, cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessResponse, cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    public int hashCode() {
        return 59 + super.hashCode();
    }
}
