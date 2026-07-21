package cm.aptoide.pt.download.view.outofspace;

import cm.aptoide.pt.R;
import com.airbnb.epoxy.i0;
import com.airbnb.epoxy.j0;

/* JADX INFO: loaded from: classes.dex */
public class InstalledAppCardModel_ extends InstalledAppCardModel implements com.airbnb.epoxy.v<InstalledAppCardModel.CardHolder>, InstalledAppCardModelBuilder {
    private com.airbnb.epoxy.f0<InstalledAppCardModel_, InstalledAppCardModel.CardHolder> onModelBoundListener_epoxyGeneratedModel;
    private com.airbnb.epoxy.h0<InstalledAppCardModel_, InstalledAppCardModel.CardHolder> onModelUnboundListener_epoxyGeneratedModel;
    private i0<InstalledAppCardModel_, InstalledAppCardModel.CardHolder> onModelVisibilityChangedListener_epoxyGeneratedModel;
    private j0<InstalledAppCardModel_, InstalledAppCardModel.CardHolder> onModelVisibilityStateChangedListener_epoxyGeneratedModel;

    @Override // com.airbnb.epoxy.s
    public void addTo(com.airbnb.epoxy.n nVar) {
        super.addTo(nVar);
        addWithDebugValidation(nVar);
    }

    @Override // com.airbnb.epoxy.s
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstalledAppCardModel_) || !super.equals(obj)) {
            return false;
        }
        InstalledAppCardModel_ installedAppCardModel_ = (InstalledAppCardModel_) obj;
        if ((this.onModelBoundListener_epoxyGeneratedModel == null) != (installedAppCardModel_.onModelBoundListener_epoxyGeneratedModel == null)) {
            return false;
        }
        if ((this.onModelUnboundListener_epoxyGeneratedModel == null) != (installedAppCardModel_.onModelUnboundListener_epoxyGeneratedModel == null)) {
            return false;
        }
        if ((this.onModelVisibilityStateChangedListener_epoxyGeneratedModel == null) != (installedAppCardModel_.onModelVisibilityStateChangedListener_epoxyGeneratedModel == null)) {
            return false;
        }
        if ((this.onModelVisibilityChangedListener_epoxyGeneratedModel == null) != (installedAppCardModel_.onModelVisibilityChangedListener_epoxyGeneratedModel == null)) {
            return false;
        }
        if (getApplication() == null ? installedAppCardModel_.getApplication() == null : getApplication().equals(installedAppCardModel_.getApplication())) {
            return (getEventSubject() == null) == (installedAppCardModel_.getEventSubject() == null);
        }
        return false;
    }

    @Override // cm.aptoide.pt.download.view.outofspace.InstalledAppCardModelBuilder
    public /* bridge */ /* synthetic */ InstalledAppCardModelBuilder eventSubject(rx.s.b bVar) {
        return eventSubject((rx.s.b<String>) bVar);
    }

    @Override // com.airbnb.epoxy.s
    protected int getDefaultLayout() {
        return R.layout.out_of_space_installed_app_card;
    }

    @Override // com.airbnb.epoxy.s
    public int hashCode() {
        return (((((((((((super.hashCode() * 31) + (this.onModelBoundListener_epoxyGeneratedModel != null ? 1 : 0)) * 31) + (this.onModelUnboundListener_epoxyGeneratedModel != null ? 1 : 0)) * 31) + (this.onModelVisibilityStateChangedListener_epoxyGeneratedModel != null ? 1 : 0)) * 31) + (this.onModelVisibilityChangedListener_epoxyGeneratedModel != null ? 1 : 0)) * 31) + (getApplication() != null ? getApplication().hashCode() : 0)) * 31) + (getEventSubject() == null ? 0 : 1);
    }

    @Override // cm.aptoide.pt.download.view.outofspace.InstalledAppCardModelBuilder
    public /* bridge */ /* synthetic */ InstalledAppCardModelBuilder onBind(com.airbnb.epoxy.f0 f0Var) {
        return onBind((com.airbnb.epoxy.f0<InstalledAppCardModel_, InstalledAppCardModel.CardHolder>) f0Var);
    }

    @Override // cm.aptoide.pt.download.view.outofspace.InstalledAppCardModelBuilder
    public /* bridge */ /* synthetic */ InstalledAppCardModelBuilder onUnbind(com.airbnb.epoxy.h0 h0Var) {
        return onUnbind((com.airbnb.epoxy.h0<InstalledAppCardModel_, InstalledAppCardModel.CardHolder>) h0Var);
    }

    @Override // cm.aptoide.pt.download.view.outofspace.InstalledAppCardModelBuilder
    public /* bridge */ /* synthetic */ InstalledAppCardModelBuilder onVisibilityChanged(i0 i0Var) {
        return onVisibilityChanged((i0<InstalledAppCardModel_, InstalledAppCardModel.CardHolder>) i0Var);
    }

    @Override // cm.aptoide.pt.download.view.outofspace.InstalledAppCardModelBuilder
    public /* bridge */ /* synthetic */ InstalledAppCardModelBuilder onVisibilityStateChanged(j0 j0Var) {
        return onVisibilityStateChanged((j0<InstalledAppCardModel_, InstalledAppCardModel.CardHolder>) j0Var);
    }

    @Override // com.airbnb.epoxy.s
    public String toString() {
        return "InstalledAppCardModel_{application=" + getApplication() + ", eventSubject=" + getEventSubject() + "}" + super.toString();
    }

    @Override // cm.aptoide.pt.download.view.outofspace.InstalledAppCardModelBuilder
    public InstalledAppCardModel_ application(InstalledApp installedApp) {
        onMutation();
        super.setApplication(installedApp);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.epoxy.t
    public InstalledAppCardModel.CardHolder createNewHolder() {
        return new InstalledAppCardModel.CardHolder();
    }

    @Override // cm.aptoide.pt.download.view.outofspace.InstalledAppCardModelBuilder
    public InstalledAppCardModel_ eventSubject(rx.s.b<String> bVar) {
        onMutation();
        super.setEventSubject(bVar);
        return this;
    }

    @Override // com.airbnb.epoxy.v
    public void handlePostBind(InstalledAppCardModel.CardHolder cardHolder, int i2) {
        com.airbnb.epoxy.f0<InstalledAppCardModel_, InstalledAppCardModel.CardHolder> f0Var = this.onModelBoundListener_epoxyGeneratedModel;
        if (f0Var != null) {
            f0Var.a(this, cardHolder, i2);
        }
        validateStateHasNotChangedSinceAdded("The model was changed during the bind call.", i2);
    }

    @Override // com.airbnb.epoxy.v
    public void handlePreBind(com.airbnb.epoxy.u uVar, InstalledAppCardModel.CardHolder cardHolder, int i2) {
        validateStateHasNotChangedSinceAdded("The model was changed between being added to the controller and being bound.", i2);
    }

    @Override // com.airbnb.epoxy.s
    public InstalledAppCardModel_ hide() {
        super.hide();
        return this;
    }

    @Override // cm.aptoide.pt.download.view.outofspace.InstalledAppCardModelBuilder
    public InstalledAppCardModel_ onBind(com.airbnb.epoxy.f0<InstalledAppCardModel_, InstalledAppCardModel.CardHolder> f0Var) {
        onMutation();
        this.onModelBoundListener_epoxyGeneratedModel = f0Var;
        return this;
    }

    @Override // cm.aptoide.pt.download.view.outofspace.InstalledAppCardModelBuilder
    public InstalledAppCardModel_ onUnbind(com.airbnb.epoxy.h0<InstalledAppCardModel_, InstalledAppCardModel.CardHolder> h0Var) {
        onMutation();
        this.onModelUnboundListener_epoxyGeneratedModel = h0Var;
        return this;
    }

    @Override // com.airbnb.epoxy.s
    public InstalledAppCardModel_ reset() {
        this.onModelBoundListener_epoxyGeneratedModel = null;
        this.onModelUnboundListener_epoxyGeneratedModel = null;
        this.onModelVisibilityStateChangedListener_epoxyGeneratedModel = null;
        this.onModelVisibilityChangedListener_epoxyGeneratedModel = null;
        super.setApplication(null);
        super.setEventSubject(null);
        super.reset();
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public InstalledAppCardModel_ layout(int i2) {
        super.layout(i2);
        return this;
    }

    @Override // com.airbnb.epoxy.s
    public InstalledAppCardModel_ show() {
        super.show();
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public InstalledAppCardModel_ spanSizeOverride(com.airbnb.epoxy.s.c cVar) {
        super.spanSizeOverride(cVar);
        return this;
    }

    @Override // com.airbnb.epoxy.t, com.airbnb.epoxy.s
    public void unbind(InstalledAppCardModel.CardHolder cardHolder) {
        super.unbind(cardHolder);
        com.airbnb.epoxy.h0<InstalledAppCardModel_, InstalledAppCardModel.CardHolder> h0Var = this.onModelUnboundListener_epoxyGeneratedModel;
        if (h0Var != null) {
            h0Var.a(this, cardHolder);
        }
    }

    public InstalledApp application() {
        return super.getApplication();
    }

    public rx.s.b<String> eventSubject() {
        return super.getEventSubject();
    }

    @Override // com.airbnb.epoxy.t, com.airbnb.epoxy.s
    public void onVisibilityChanged(float f2, float f3, int i2, int i3, InstalledAppCardModel.CardHolder cardHolder) {
        i0<InstalledAppCardModel_, InstalledAppCardModel.CardHolder> i0Var = this.onModelVisibilityChangedListener_epoxyGeneratedModel;
        if (i0Var != null) {
            i0Var.a(this, cardHolder, f2, f3, i2, i3);
        }
        super.onVisibilityChanged(f2, f3, i2, i3, cardHolder);
    }

    @Override // com.airbnb.epoxy.t, com.airbnb.epoxy.s
    public void onVisibilityStateChanged(int i2, InstalledAppCardModel.CardHolder cardHolder) {
        j0<InstalledAppCardModel_, InstalledAppCardModel.CardHolder> j0Var = this.onModelVisibilityStateChangedListener_epoxyGeneratedModel;
        if (j0Var != null) {
            j0Var.a(this, cardHolder, i2);
        }
        super.onVisibilityStateChanged(i2, cardHolder);
    }

    @Override // com.airbnb.epoxy.s
    public InstalledAppCardModel_ show(boolean z) {
        super.show(z);
        return this;
    }

    @Override // cm.aptoide.pt.download.view.outofspace.InstalledAppCardModelBuilder
    public InstalledAppCardModel_ onVisibilityChanged(i0<InstalledAppCardModel_, InstalledAppCardModel.CardHolder> i0Var) {
        onMutation();
        this.onModelVisibilityChangedListener_epoxyGeneratedModel = i0Var;
        return this;
    }

    @Override // cm.aptoide.pt.download.view.outofspace.InstalledAppCardModelBuilder
    public InstalledAppCardModel_ onVisibilityStateChanged(j0<InstalledAppCardModel_, InstalledAppCardModel.CardHolder> j0Var) {
        onMutation();
        this.onModelVisibilityStateChangedListener_epoxyGeneratedModel = j0Var;
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public InstalledAppCardModel_ id(long j2) {
        super.id(j2);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public InstalledAppCardModel_ id(Number... numberArr) {
        super.id(numberArr);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public InstalledAppCardModel_ id(long j2, long j3) {
        super.id(j2, j3);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public InstalledAppCardModel_ id(CharSequence charSequence) {
        super.id(charSequence);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public InstalledAppCardModel_ id(CharSequence charSequence, CharSequence... charSequenceArr) {
        super.id(charSequence, charSequenceArr);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public InstalledAppCardModel_ id(CharSequence charSequence, long j2) {
        super.id(charSequence, j2);
        return this;
    }
}
