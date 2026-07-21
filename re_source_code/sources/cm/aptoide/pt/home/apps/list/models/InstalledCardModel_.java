package cm.aptoide.pt.home.apps.list.models;

import cm.aptoide.pt.R;
import cm.aptoide.pt.home.apps.model.InstalledApp;
import com.airbnb.epoxy.f0;
import com.airbnb.epoxy.h0;
import com.airbnb.epoxy.i0;
import com.airbnb.epoxy.j0;
import com.airbnb.epoxy.n;
import com.airbnb.epoxy.s;
import com.airbnb.epoxy.u;
import com.airbnb.epoxy.v;

/* JADX INFO: loaded from: classes.dex */
public class InstalledCardModel_ extends InstalledCardModel implements v<InstalledCardModel.CardHolder>, InstalledCardModelBuilder {
    private f0<InstalledCardModel_, InstalledCardModel.CardHolder> onModelBoundListener_epoxyGeneratedModel;
    private h0<InstalledCardModel_, InstalledCardModel.CardHolder> onModelUnboundListener_epoxyGeneratedModel;
    private i0<InstalledCardModel_, InstalledCardModel.CardHolder> onModelVisibilityChangedListener_epoxyGeneratedModel;
    private j0<InstalledCardModel_, InstalledCardModel.CardHolder> onModelVisibilityStateChangedListener_epoxyGeneratedModel;

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
        if (!(obj instanceof InstalledCardModel_) || !super.equals(obj)) {
            return false;
        }
        InstalledCardModel_ installedCardModel_ = (InstalledCardModel_) obj;
        if ((this.onModelBoundListener_epoxyGeneratedModel == null) != (installedCardModel_.onModelBoundListener_epoxyGeneratedModel == null)) {
            return false;
        }
        if ((this.onModelUnboundListener_epoxyGeneratedModel == null) != (installedCardModel_.onModelUnboundListener_epoxyGeneratedModel == null)) {
            return false;
        }
        if ((this.onModelVisibilityStateChangedListener_epoxyGeneratedModel == null) != (installedCardModel_.onModelVisibilityStateChangedListener_epoxyGeneratedModel == null)) {
            return false;
        }
        if ((this.onModelVisibilityChangedListener_epoxyGeneratedModel == null) != (installedCardModel_.onModelVisibilityChangedListener_epoxyGeneratedModel == null)) {
            return false;
        }
        return getApplication() == null ? installedCardModel_.getApplication() == null : getApplication().equals(installedCardModel_.getApplication());
    }

    @Override // com.airbnb.epoxy.s
    protected int getDefaultLayout() {
        return R.layout.apps_installed_app_item;
    }

    @Override // com.airbnb.epoxy.s
    public int hashCode() {
        return (((((((((super.hashCode() * 31) + (this.onModelBoundListener_epoxyGeneratedModel != null ? 1 : 0)) * 31) + (this.onModelUnboundListener_epoxyGeneratedModel != null ? 1 : 0)) * 31) + (this.onModelVisibilityStateChangedListener_epoxyGeneratedModel != null ? 1 : 0)) * 31) + (this.onModelVisibilityChangedListener_epoxyGeneratedModel == null ? 0 : 1)) * 31) + (getApplication() != null ? getApplication().hashCode() : 0);
    }

    @Override // cm.aptoide.pt.home.apps.list.models.InstalledCardModelBuilder
    public /* bridge */ /* synthetic */ InstalledCardModelBuilder onBind(f0 f0Var) {
        return onBind((f0<InstalledCardModel_, InstalledCardModel.CardHolder>) f0Var);
    }

    @Override // cm.aptoide.pt.home.apps.list.models.InstalledCardModelBuilder
    public /* bridge */ /* synthetic */ InstalledCardModelBuilder onUnbind(h0 h0Var) {
        return onUnbind((h0<InstalledCardModel_, InstalledCardModel.CardHolder>) h0Var);
    }

    @Override // cm.aptoide.pt.home.apps.list.models.InstalledCardModelBuilder
    public /* bridge */ /* synthetic */ InstalledCardModelBuilder onVisibilityChanged(i0 i0Var) {
        return onVisibilityChanged((i0<InstalledCardModel_, InstalledCardModel.CardHolder>) i0Var);
    }

    @Override // cm.aptoide.pt.home.apps.list.models.InstalledCardModelBuilder
    public /* bridge */ /* synthetic */ InstalledCardModelBuilder onVisibilityStateChanged(j0 j0Var) {
        return onVisibilityStateChanged((j0<InstalledCardModel_, InstalledCardModel.CardHolder>) j0Var);
    }

    @Override // com.airbnb.epoxy.s
    public String toString() {
        return "InstalledCardModel_{application=" + getApplication() + "}" + super.toString();
    }

    @Override // cm.aptoide.pt.home.apps.list.models.InstalledCardModelBuilder
    public InstalledCardModel_ application(InstalledApp installedApp) {
        onMutation();
        super.setApplication(installedApp);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.epoxy.t
    public InstalledCardModel.CardHolder createNewHolder() {
        return new InstalledCardModel.CardHolder();
    }

    @Override // com.airbnb.epoxy.v
    public void handlePostBind(InstalledCardModel.CardHolder cardHolder, int i2) {
        f0<InstalledCardModel_, InstalledCardModel.CardHolder> f0Var = this.onModelBoundListener_epoxyGeneratedModel;
        if (f0Var != null) {
            f0Var.a(this, cardHolder, i2);
        }
        validateStateHasNotChangedSinceAdded("The model was changed during the bind call.", i2);
    }

    @Override // com.airbnb.epoxy.v
    public void handlePreBind(u uVar, InstalledCardModel.CardHolder cardHolder, int i2) {
        validateStateHasNotChangedSinceAdded("The model was changed between being added to the controller and being bound.", i2);
    }

    @Override // com.airbnb.epoxy.s
    public InstalledCardModel_ hide() {
        super.hide();
        return this;
    }

    @Override // cm.aptoide.pt.home.apps.list.models.InstalledCardModelBuilder
    public InstalledCardModel_ onBind(f0<InstalledCardModel_, InstalledCardModel.CardHolder> f0Var) {
        onMutation();
        this.onModelBoundListener_epoxyGeneratedModel = f0Var;
        return this;
    }

    @Override // cm.aptoide.pt.home.apps.list.models.InstalledCardModelBuilder
    public InstalledCardModel_ onUnbind(h0<InstalledCardModel_, InstalledCardModel.CardHolder> h0Var) {
        onMutation();
        this.onModelUnboundListener_epoxyGeneratedModel = h0Var;
        return this;
    }

    @Override // com.airbnb.epoxy.s
    public InstalledCardModel_ reset() {
        this.onModelBoundListener_epoxyGeneratedModel = null;
        this.onModelUnboundListener_epoxyGeneratedModel = null;
        this.onModelVisibilityStateChangedListener_epoxyGeneratedModel = null;
        this.onModelVisibilityChangedListener_epoxyGeneratedModel = null;
        super.setApplication(null);
        super.reset();
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public InstalledCardModel_ layout(int i2) {
        super.layout(i2);
        return this;
    }

    @Override // com.airbnb.epoxy.s
    public InstalledCardModel_ show() {
        super.show();
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public InstalledCardModel_ spanSizeOverride(s.c cVar) {
        super.spanSizeOverride(cVar);
        return this;
    }

    @Override // com.airbnb.epoxy.t, com.airbnb.epoxy.s
    public void unbind(InstalledCardModel.CardHolder cardHolder) {
        super.unbind(cardHolder);
        h0<InstalledCardModel_, InstalledCardModel.CardHolder> h0Var = this.onModelUnboundListener_epoxyGeneratedModel;
        if (h0Var != null) {
            h0Var.a(this, cardHolder);
        }
    }

    public InstalledApp application() {
        return super.getApplication();
    }

    @Override // com.airbnb.epoxy.t, com.airbnb.epoxy.s
    public void onVisibilityChanged(float f2, float f3, int i2, int i3, InstalledCardModel.CardHolder cardHolder) {
        i0<InstalledCardModel_, InstalledCardModel.CardHolder> i0Var = this.onModelVisibilityChangedListener_epoxyGeneratedModel;
        if (i0Var != null) {
            i0Var.a(this, cardHolder, f2, f3, i2, i3);
        }
        super.onVisibilityChanged(f2, f3, i2, i3, cardHolder);
    }

    @Override // com.airbnb.epoxy.t, com.airbnb.epoxy.s
    public void onVisibilityStateChanged(int i2, InstalledCardModel.CardHolder cardHolder) {
        j0<InstalledCardModel_, InstalledCardModel.CardHolder> j0Var = this.onModelVisibilityStateChangedListener_epoxyGeneratedModel;
        if (j0Var != null) {
            j0Var.a(this, cardHolder, i2);
        }
        super.onVisibilityStateChanged(i2, cardHolder);
    }

    @Override // com.airbnb.epoxy.s
    public InstalledCardModel_ show(boolean z) {
        super.show(z);
        return this;
    }

    @Override // cm.aptoide.pt.home.apps.list.models.InstalledCardModelBuilder
    public InstalledCardModel_ onVisibilityChanged(i0<InstalledCardModel_, InstalledCardModel.CardHolder> i0Var) {
        onMutation();
        this.onModelVisibilityChangedListener_epoxyGeneratedModel = i0Var;
        return this;
    }

    @Override // cm.aptoide.pt.home.apps.list.models.InstalledCardModelBuilder
    public InstalledCardModel_ onVisibilityStateChanged(j0<InstalledCardModel_, InstalledCardModel.CardHolder> j0Var) {
        onMutation();
        this.onModelVisibilityStateChangedListener_epoxyGeneratedModel = j0Var;
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public InstalledCardModel_ id(long j2) {
        super.id(j2);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public InstalledCardModel_ id(Number... numberArr) {
        super.id(numberArr);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public InstalledCardModel_ id(long j2, long j3) {
        super.id(j2, j3);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public InstalledCardModel_ id(CharSequence charSequence) {
        super.id(charSequence);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public InstalledCardModel_ id(CharSequence charSequence, CharSequence... charSequenceArr) {
        super.id(charSequence, charSequenceArr);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public InstalledCardModel_ id(CharSequence charSequence, long j2) {
        super.id(charSequence, j2);
        return this;
    }
}
