package cm.aptoide.pt.store.view;

import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStoreDisplays;
import cm.aptoide.pt.dataprovider.ws.v7.store.StoreContext;
import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import cm.aptoide.pt.view.recycler.displayable.DisplayablePojo;

/* JADX INFO: loaded from: classes.dex */
public class GridDisplayDisplayable extends DisplayablePojo<GetStoreDisplays.EventImage> {
    private AptoideInstalledAppsRepository aptoideInstalledAppsRepository;
    private StoreContext storeContext;
    private String storeName;
    private String storeTheme;
    private String tag;

    public GridDisplayDisplayable() {
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        return new Displayable.Configs(2, true);
    }

    public AptoideInstalledAppsRepository getInstalledRepository() {
        return this.aptoideInstalledAppsRepository;
    }

    public StoreContext getStoreContext() {
        return this.storeContext;
    }

    public String getStoreName() {
        return this.storeName;
    }

    public String getStoreTheme() {
        return this.storeTheme;
    }

    public String getTag() {
        return this.tag;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        return R.layout.displayable_grid_display;
    }

    public GridDisplayDisplayable(GetStoreDisplays.EventImage eventImage, String str, String str2, StoreContext storeContext, AptoideInstalledAppsRepository aptoideInstalledAppsRepository) {
        super(eventImage);
        this.storeTheme = str;
        this.tag = str2;
        this.storeContext = storeContext;
        this.aptoideInstalledAppsRepository = aptoideInstalledAppsRepository;
    }
}
