package cm.aptoide.pt.dataprovider.model.v7.listapp;

import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ListAppsUpdates extends BaseV7Response {
    private List<App> list;

    @Override // cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    protected boolean canEqual(Object obj) {
        return obj instanceof ListAppsUpdates;
    }

    @Override // cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListAppsUpdates)) {
            return false;
        }
        ListAppsUpdates listAppsUpdates = (ListAppsUpdates) obj;
        if (!listAppsUpdates.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        List<App> list = getList();
        List<App> list2 = listAppsUpdates.getList();
        return list != null ? list.equals(list2) : list2 == null;
    }

    public List<App> getList() {
        return this.list;
    }

    @Override // cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    public int hashCode() {
        int iHashCode = super.hashCode() + 59;
        List<App> list = getList();
        return (iHashCode * 59) + (list == null ? 43 : list.hashCode());
    }

    @Override // cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    public boolean isOk() {
        return super.isOk() || this.list != null;
    }

    public void setList(List<App> list) {
        this.list = list;
    }

    @Override // cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    public String toString() {
        return "ListAppsUpdates(list=" + getList() + ")";
    }
}
