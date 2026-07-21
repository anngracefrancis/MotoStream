package cm.aptoide.pt.store.view;

import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.model.v7.Comment;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StoreLatestCommentsDisplayable extends Displayable {
    private final List<Comment> comments;
    private final long storeId;
    private String storeName;
    private ThemeManager themeManager;

    public StoreLatestCommentsDisplayable() {
        this.storeId = -1L;
        this.comments = Collections.emptyList();
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        return new Displayable.Configs(1, true);
    }

    public long getStoreId() {
        return this.storeId;
    }

    public String getStoreName() {
        return this.storeName;
    }

    public ThemeManager getThemeManager() {
        return this.themeManager;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        return R.layout.displayable_grid_latest_store_comments;
    }

    public StoreLatestCommentsDisplayable(long j2, String str, List<Comment> list, ThemeManager themeManager) {
        this.storeId = j2;
        this.storeName = str;
        this.comments = list;
        this.themeManager = themeManager;
    }
}
