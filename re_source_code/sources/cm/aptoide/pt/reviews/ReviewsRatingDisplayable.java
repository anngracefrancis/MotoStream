package cm.aptoide.pt.reviews;

import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.model.v7.GetAppMeta;
import cm.aptoide.pt.view.recycler.displayable.Displayable;

/* JADX INFO: loaded from: classes.dex */
public class ReviewsRatingDisplayable extends Displayable {
    private GetAppMeta.App appMeta;

    public ReviewsRatingDisplayable() {
    }

    public GetAppMeta.App getAppMeta() {
        return this.appMeta;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        return new Displayable.Configs(1, true);
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        return R.layout.reviews_rating_displayable;
    }

    public ReviewsRatingDisplayable(GetAppMeta.App app) {
        this.appMeta = app;
    }
}
