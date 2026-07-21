package cm.aptoide.pt.store.view.my;

import android.content.Context;
import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import cm.aptoide.pt.dataprovider.ws.v7.store.StoreContext;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class StoreDisplayable extends Displayable {
    private int firstStatsLabel;
    private long firstStatsNumber;
    private boolean isLongTime;
    private String message;
    private int secondStatsLabel;
    private long secondStatsNumber;
    private boolean statsClickable;
    private Store store;
    private StoreContext storeContext;
    private int textColor;

    public StoreDisplayable() {
    }

    private String getStoreDescription() {
        return this.message;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        return new Displayable.Configs(1, true);
    }

    public int getExploreButtonText() {
        return this.isLongTime ? R.string.create_store_displayable_explore_long_term_button : R.string.create_store_displayable_explore_button;
    }

    int getFirstStatsLabel() {
        return this.firstStatsLabel;
    }

    long getFirstStatsNumber() {
        return this.firstStatsNumber;
    }

    int getSecondStatsLabel() {
        return this.secondStatsLabel;
    }

    long getSecondStatsNumber() {
        return this.secondStatsNumber;
    }

    public Store getStore() {
        return this.store;
    }

    public StoreContext getStoreContext() {
        return this.storeContext;
    }

    public String getSuggestionMessage(Context context) {
        return this.isLongTime ? getStoreDescription() : context.getString(R.string.create_store_displayable_explore_message);
    }

    public int getTextColor() {
        return this.textColor;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        return R.layout.store_displayable_layout;
    }

    public boolean isStatsClickable() {
        return this.statsClickable;
    }

    public StoreDisplayable(Store store, StoreContext storeContext, long j2, long j3, int i2, int i3, boolean z, String str, int i4) {
        this.store = store;
        this.storeContext = storeContext;
        this.firstStatsNumber = j2;
        this.secondStatsNumber = j3;
        this.firstStatsLabel = i2;
        this.secondStatsLabel = i3;
        this.statsClickable = z;
        this.message = str;
        this.textColor = i4;
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.add(5, -7);
        this.isLongTime = store.getAdded().before(calendar.getTime());
    }
}
