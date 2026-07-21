package cm.aptoide.pt.home.apps.list.models;

import cm.aptoide.pt.R;
import cm.aptoide.pt.home.apps.AppClick;
import cm.aptoide.pt.home.apps.model.UpdateApp;
import cm.aptoide.pt.themes.ThemeManager;
import com.airbnb.epoxy.f0;
import com.airbnb.epoxy.h0;
import com.airbnb.epoxy.i0;
import com.airbnb.epoxy.j0;
import com.airbnb.epoxy.n;
import com.airbnb.epoxy.s;
import com.airbnb.epoxy.u;
import com.airbnb.epoxy.v;

/* JADX INFO: loaded from: classes.dex */
public class UpdateCardModel_ extends UpdateCardModel implements v<UpdateCardModel.CardHolder>, UpdateCardModelBuilder {
    private f0<UpdateCardModel_, UpdateCardModel.CardHolder> onModelBoundListener_epoxyGeneratedModel;
    private h0<UpdateCardModel_, UpdateCardModel.CardHolder> onModelUnboundListener_epoxyGeneratedModel;
    private i0<UpdateCardModel_, UpdateCardModel.CardHolder> onModelVisibilityChangedListener_epoxyGeneratedModel;
    private j0<UpdateCardModel_, UpdateCardModel.CardHolder> onModelVisibilityStateChangedListener_epoxyGeneratedModel;

    @Override // com.airbnb.epoxy.s
    public void addTo(n nVar) {
        super.addTo(nVar);
        addWithDebugValidation(nVar);
    }

    @Override // com.airbnb.epoxy.s
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateCardModel_) || !super.equals(obj)) {
            return false;
        }
        UpdateCardModel_ updateCardModel_ = (UpdateCardModel_) obj;
        if ((this.onModelBoundListener_epoxyGeneratedModel == null) != (updateCardModel_.onModelBoundListener_epoxyGeneratedModel == null)) {
            return false;
        }
        if ((this.onModelUnboundListener_epoxyGeneratedModel == null) != (updateCardModel_.onModelUnboundListener_epoxyGeneratedModel == null)) {
            return false;
        }
        if ((this.onModelVisibilityStateChangedListener_epoxyGeneratedModel == null) != (updateCardModel_.onModelVisibilityStateChangedListener_epoxyGeneratedModel == null)) {
            return false;
        }
        if ((this.onModelVisibilityChangedListener_epoxyGeneratedModel == null) != (updateCardModel_.onModelVisibilityChangedListener_epoxyGeneratedModel == null)) {
            return false;
        }
        if (getApplication() == null ? updateCardModel_.getApplication() != null : !getApplication().equals(updateCardModel_.getApplication())) {
            return false;
        }
        if ((getEventSubject() == null) != (updateCardModel_.getEventSubject() == null)) {
            return false;
        }
        return (getThemeManager() == null) == (updateCardModel_.getThemeManager() == null);
    }

    @Override // cm.aptoide.pt.home.apps.list.models.UpdateCardModelBuilder
    public /* bridge */ /* synthetic */ UpdateCardModelBuilder eventSubject(rx.s.b bVar) {
        return eventSubject((rx.s.b<AppClick>) bVar);
    }

    @Override // com.airbnb.epoxy.s
    protected int getDefaultLayout() {
        return R.layout.apps_update_app_item;
    }

    @Override // com.airbnb.epoxy.s
    public int hashCode() {
        return (((((((((((((super.hashCode() * 31) + (this.onModelBoundListener_epoxyGeneratedModel != null ? 1 : 0)) * 31) + (this.onModelUnboundListener_epoxyGeneratedModel != null ? 1 : 0)) * 31) + (this.onModelVisibilityStateChangedListener_epoxyGeneratedModel != null ? 1 : 0)) * 31) + (this.onModelVisibilityChangedListener_epoxyGeneratedModel != null ? 1 : 0)) * 31) + (getApplication() != null ? getApplication().hashCode() : 0)) * 31) + (getEventSubject() != null ? 1 : 0)) * 31) + (getThemeManager() == null ? 0 : 1);
    }

    @Override // cm.aptoide.pt.home.apps.list.models.UpdateCardModelBuilder
    public /* bridge */ /* synthetic */ UpdateCardModelBuilder onBind(f0 f0Var) {
        return onBind((f0<UpdateCardModel_, UpdateCardModel.CardHolder>) f0Var);
    }

    @Override // cm.aptoide.pt.home.apps.list.models.UpdateCardModelBuilder
    public /* bridge */ /* synthetic */ UpdateCardModelBuilder onUnbind(h0 h0Var) {
        return onUnbind((h0<UpdateCardModel_, UpdateCardModel.CardHolder>) h0Var);
    }

    @Override // cm.aptoide.pt.home.apps.list.models.UpdateCardModelBuilder
    public /* bridge */ /* synthetic */ UpdateCardModelBuilder onVisibilityChanged(i0 i0Var) {
        return onVisibilityChanged((i0<UpdateCardModel_, UpdateCardModel.CardHolder>) i0Var);
    }

    @Override // cm.aptoide.pt.home.apps.list.models.UpdateCardModelBuilder
    public /* bridge */ /* synthetic */ UpdateCardModelBuilder onVisibilityStateChanged(j0 j0Var) {
        return onVisibilityStateChanged((j0<UpdateCardModel_, UpdateCardModel.CardHolder>) j0Var);
    }

    @Override // com.airbnb.epoxy.s
    public String toString() {
        return "UpdateCardModel_{application=" + getApplication() + ", eventSubject=" + getEventSubject() + ", themeManager=" + getThemeManager() + "}" + super.toString();
    }

    @Override // cm.aptoide.pt.home.apps.list.models.UpdateCardModelBuilder
    public UpdateCardModel_ application(UpdateApp updateApp) {
        onMutation();
        super.setApplication(updateApp);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.epoxy.t
    public UpdateCardModel.CardHolder createNewHolder() {
        return new UpdateCardModel.CardHolder();
    }

    @Override // cm.aptoide.pt.home.apps.list.models.UpdateCardModelBuilder
    public UpdateCardModel_ eventSubject(rx.s.b<AppClick> bVar) {
        onMutation();
        super.setEventSubject(bVar);
        return this;
    }

    @Override // com.airbnb.epoxy.v
    public void handlePostBind(UpdateCardModel.CardHolder cardHolder, int i2) {
        f0<UpdateCardModel_, UpdateCardModel.CardHolder> f0Var = this.onModelBoundListener_epoxyGeneratedModel;
        if (f0Var != null) {
            f0Var.a(this, cardHolder, i2);
        }
        validateStateHasNotChangedSinceAdded("The model was changed during the bind call.", i2);
    }

    @Override // com.airbnb.epoxy.v
    public void handlePreBind(u uVar, UpdateCardModel.CardHolder cardHolder, int i2) {
        validateStateHasNotChangedSinceAdded("The model was changed between being added to the controller and being bound.", i2);
    }

    @Override // com.airbnb.epoxy.s
    public UpdateCardModel_ hide() {
        super.hide();
        return this;
    }

    @Override // cm.aptoide.pt.home.apps.list.models.UpdateCardModelBuilder
    public UpdateCardModel_ onBind(f0<UpdateCardModel_, UpdateCardModel.CardHolder> f0Var) {
        onMutation();
        this.onModelBoundListener_epoxyGeneratedModel = f0Var;
        return this;
    }

    @Override // cm.aptoide.pt.home.apps.list.models.UpdateCardModelBuilder
    public UpdateCardModel_ onUnbind(h0<UpdateCardModel_, UpdateCardModel.CardHolder> h0Var) {
        onMutation();
        this.onModelUnboundListener_epoxyGeneratedModel = h0Var;
        return this;
    }

    @Override // com.airbnb.epoxy.s
    public UpdateCardModel_ reset() {
        this.onModelBoundListener_epoxyGeneratedModel = null;
        this.onModelUnboundListener_epoxyGeneratedModel = null;
        this.onModelVisibilityStateChangedListener_epoxyGeneratedModel = null;
        this.onModelVisibilityChangedListener_epoxyGeneratedModel = null;
        super.setApplication(null);
        super.setEventSubject(null);
        super.setThemeManager(null);
        super.reset();
        return this;
    }

    @Override // cm.aptoide.pt.home.apps.list.models.UpdateCardModelBuilder
    public UpdateCardModel_ themeManager(ThemeManager themeManager) {
        onMutation();
        super.setThemeManager(themeManager);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public UpdateCardModel_ layout(int i2) {
        super.layout(i2);
        return this;
    }

    @Override // com.airbnb.epoxy.s
    public UpdateCardModel_ show() {
        super.show();
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public UpdateCardModel_ spanSizeOverride(s.c cVar) {
        super.spanSizeOverride(cVar);
        return this;
    }

    @Override // com.airbnb.epoxy.t, com.airbnb.epoxy.s
    public void unbind(UpdateCardModel.CardHolder cardHolder) {
        super.unbind(cardHolder);
        h0<UpdateCardModel_, UpdateCardModel.CardHolder> h0Var = this.onModelUnboundListener_epoxyGeneratedModel;
        if (h0Var != null) {
            h0Var.a(this, cardHolder);
        }
    }

    public UpdateApp application() {
        return super.getApplication();
    }

    public rx.s.b<AppClick> eventSubject() {
        return super.getEventSubject();
    }

    @Override // com.airbnb.epoxy.t, com.airbnb.epoxy.s
    public void onVisibilityChanged(float f2, float f3, int i2, int i3, UpdateCardModel.CardHolder cardHolder) {
        i0<UpdateCardModel_, UpdateCardModel.CardHolder> i0Var = this.onModelVisibilityChangedListener_epoxyGeneratedModel;
        if (i0Var != null) {
            i0Var.a(this, cardHolder, f2, f3, i2, i3);
        }
        super.onVisibilityChanged(f2, f3, i2, i3, cardHolder);
    }

    @Override // com.airbnb.epoxy.t, com.airbnb.epoxy.s
    public void onVisibilityStateChanged(int i2, UpdateCardModel.CardHolder cardHolder) {
        j0<UpdateCardModel_, UpdateCardModel.CardHolder> j0Var = this.onModelVisibilityStateChangedListener_epoxyGeneratedModel;
        if (j0Var != null) {
            j0Var.a(this, cardHolder, i2);
        }
        super.onVisibilityStateChanged(i2, cardHolder);
    }

    @Override // com.airbnb.epoxy.s
    public UpdateCardModel_ show(boolean z) {
        super.show(z);
        return this;
    }

    public ThemeManager themeManager() {
        return super.getThemeManager();
    }

    @Override // cm.aptoide.pt.home.apps.list.models.UpdateCardModelBuilder
    public UpdateCardModel_ onVisibilityChanged(i0<UpdateCardModel_, UpdateCardModel.CardHolder> i0Var) {
        onMutation();
        this.onModelVisibilityChangedListener_epoxyGeneratedModel = i0Var;
        return this;
    }

    @Override // cm.aptoide.pt.home.apps.list.models.UpdateCardModelBuilder
    public UpdateCardModel_ onVisibilityStateChanged(j0<UpdateCardModel_, UpdateCardModel.CardHolder> j0Var) {
        onMutation();
        this.onModelVisibilityStateChangedListener_epoxyGeneratedModel = j0Var;
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public UpdateCardModel_ id(long j2) {
        super.id(j2);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public UpdateCardModel_ id(Number... numberArr) {
        super.id(numberArr);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public UpdateCardModel_ id(long j2, long j3) {
        super.id(j2, j3);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public UpdateCardModel_ id(CharSequence charSequence) {
        super.id(charSequence);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public UpdateCardModel_ id(CharSequence charSequence, CharSequence... charSequenceArr) {
        super.id(charSequence, charSequenceArr);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public UpdateCardModel_ id(CharSequence charSequence, long j2) {
        super.id(charSequence, j2);
        return this;
    }
}
