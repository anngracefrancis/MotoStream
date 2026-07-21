package cm.aptoide.pt.home.apps.list.models;

import cm.aptoide.pt.R;
import com.airbnb.epoxy.f0;
import com.airbnb.epoxy.h0;
import com.airbnb.epoxy.i0;
import com.airbnb.epoxy.j0;
import com.airbnb.epoxy.n;
import com.airbnb.epoxy.s;
import com.airbnb.epoxy.u;
import com.airbnb.epoxy.v;

/* JADX INFO: loaded from: classes.dex */
public class TitleModel_ extends TitleModel implements v<TitleModel.Holder>, TitleModelBuilder {
    private f0<TitleModel_, TitleModel.Holder> onModelBoundListener_epoxyGeneratedModel;
    private h0<TitleModel_, TitleModel.Holder> onModelUnboundListener_epoxyGeneratedModel;
    private i0<TitleModel_, TitleModel.Holder> onModelVisibilityChangedListener_epoxyGeneratedModel;
    private j0<TitleModel_, TitleModel.Holder> onModelVisibilityStateChangedListener_epoxyGeneratedModel;

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
        if (!(obj instanceof TitleModel_) || !super.equals(obj)) {
            return false;
        }
        TitleModel_ titleModel_ = (TitleModel_) obj;
        if ((this.onModelBoundListener_epoxyGeneratedModel == null) != (titleModel_.onModelBoundListener_epoxyGeneratedModel == null)) {
            return false;
        }
        if ((this.onModelUnboundListener_epoxyGeneratedModel == null) != (titleModel_.onModelUnboundListener_epoxyGeneratedModel == null)) {
            return false;
        }
        if ((this.onModelVisibilityStateChangedListener_epoxyGeneratedModel == null) != (titleModel_.onModelVisibilityStateChangedListener_epoxyGeneratedModel == null)) {
            return false;
        }
        if ((this.onModelVisibilityChangedListener_epoxyGeneratedModel == null) != (titleModel_.onModelVisibilityChangedListener_epoxyGeneratedModel == null)) {
            return false;
        }
        if (getTitle() == null ? titleModel_.getTitle() != null : !getTitle().equals(titleModel_.getTitle())) {
            return false;
        }
        if (getShouldShowButton() != titleModel_.getShouldShowButton()) {
            return false;
        }
        return (getEventSubject() == null) == (titleModel_.getEventSubject() == null);
    }

    @Override // cm.aptoide.pt.home.apps.list.models.TitleModelBuilder
    public /* bridge */ /* synthetic */ TitleModelBuilder eventSubject(rx.s.b bVar) {
        return eventSubject((rx.s.b<Void>) bVar);
    }

    @Override // com.airbnb.epoxy.s
    protected int getDefaultLayout() {
        return R.layout.apps_header_item;
    }

    @Override // com.airbnb.epoxy.s
    public int hashCode() {
        return (((((((((((((super.hashCode() * 31) + (this.onModelBoundListener_epoxyGeneratedModel != null ? 1 : 0)) * 31) + (this.onModelUnboundListener_epoxyGeneratedModel != null ? 1 : 0)) * 31) + (this.onModelVisibilityStateChangedListener_epoxyGeneratedModel != null ? 1 : 0)) * 31) + (this.onModelVisibilityChangedListener_epoxyGeneratedModel != null ? 1 : 0)) * 31) + (getTitle() != null ? getTitle().hashCode() : 0)) * 31) + (getShouldShowButton() ? 1 : 0)) * 31) + (getEventSubject() == null ? 0 : 1);
    }

    @Override // cm.aptoide.pt.home.apps.list.models.TitleModelBuilder
    public /* bridge */ /* synthetic */ TitleModelBuilder onBind(f0 f0Var) {
        return onBind((f0<TitleModel_, TitleModel.Holder>) f0Var);
    }

    @Override // cm.aptoide.pt.home.apps.list.models.TitleModelBuilder
    public /* bridge */ /* synthetic */ TitleModelBuilder onUnbind(h0 h0Var) {
        return onUnbind((h0<TitleModel_, TitleModel.Holder>) h0Var);
    }

    @Override // cm.aptoide.pt.home.apps.list.models.TitleModelBuilder
    public /* bridge */ /* synthetic */ TitleModelBuilder onVisibilityChanged(i0 i0Var) {
        return onVisibilityChanged((i0<TitleModel_, TitleModel.Holder>) i0Var);
    }

    @Override // cm.aptoide.pt.home.apps.list.models.TitleModelBuilder
    public /* bridge */ /* synthetic */ TitleModelBuilder onVisibilityStateChanged(j0 j0Var) {
        return onVisibilityStateChanged((j0<TitleModel_, TitleModel.Holder>) j0Var);
    }

    @Override // com.airbnb.epoxy.s
    public String toString() {
        return "TitleModel_{title=" + getTitle() + ", shouldShowButton=" + getShouldShowButton() + ", eventSubject=" + getEventSubject() + "}" + super.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.epoxy.t
    public TitleModel.Holder createNewHolder() {
        return new TitleModel.Holder();
    }

    @Override // cm.aptoide.pt.home.apps.list.models.TitleModelBuilder
    public TitleModel_ eventSubject(rx.s.b<Void> bVar) {
        onMutation();
        super.setEventSubject(bVar);
        return this;
    }

    @Override // com.airbnb.epoxy.v
    public void handlePostBind(TitleModel.Holder holder, int i2) {
        f0<TitleModel_, TitleModel.Holder> f0Var = this.onModelBoundListener_epoxyGeneratedModel;
        if (f0Var != null) {
            f0Var.a(this, holder, i2);
        }
        validateStateHasNotChangedSinceAdded("The model was changed during the bind call.", i2);
    }

    @Override // com.airbnb.epoxy.v
    public void handlePreBind(u uVar, TitleModel.Holder holder, int i2) {
        validateStateHasNotChangedSinceAdded("The model was changed between being added to the controller and being bound.", i2);
    }

    @Override // com.airbnb.epoxy.s
    public TitleModel_ hide() {
        super.hide();
        return this;
    }

    @Override // cm.aptoide.pt.home.apps.list.models.TitleModelBuilder
    public TitleModel_ onBind(f0<TitleModel_, TitleModel.Holder> f0Var) {
        onMutation();
        this.onModelBoundListener_epoxyGeneratedModel = f0Var;
        return this;
    }

    @Override // cm.aptoide.pt.home.apps.list.models.TitleModelBuilder
    public TitleModel_ onUnbind(h0<TitleModel_, TitleModel.Holder> h0Var) {
        onMutation();
        this.onModelUnboundListener_epoxyGeneratedModel = h0Var;
        return this;
    }

    @Override // com.airbnb.epoxy.s
    public TitleModel_ reset() {
        this.onModelBoundListener_epoxyGeneratedModel = null;
        this.onModelUnboundListener_epoxyGeneratedModel = null;
        this.onModelVisibilityStateChangedListener_epoxyGeneratedModel = null;
        this.onModelVisibilityChangedListener_epoxyGeneratedModel = null;
        super.setTitle(null);
        super.setShouldShowButton(false);
        super.setEventSubject(null);
        super.reset();
        return this;
    }

    @Override // cm.aptoide.pt.home.apps.list.models.TitleModelBuilder
    public TitleModel_ shouldShowButton(boolean z) {
        onMutation();
        super.setShouldShowButton(z);
        return this;
    }

    @Override // cm.aptoide.pt.home.apps.list.models.TitleModelBuilder
    public TitleModel_ title(Integer num) {
        onMutation();
        super.setTitle(num);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public TitleModel_ layout(int i2) {
        super.layout(i2);
        return this;
    }

    @Override // com.airbnb.epoxy.s
    public TitleModel_ show() {
        super.show();
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public TitleModel_ spanSizeOverride(s.c cVar) {
        super.spanSizeOverride(cVar);
        return this;
    }

    @Override // com.airbnb.epoxy.t, com.airbnb.epoxy.s
    public void unbind(TitleModel.Holder holder) {
        super.unbind(holder);
        h0<TitleModel_, TitleModel.Holder> h0Var = this.onModelUnboundListener_epoxyGeneratedModel;
        if (h0Var != null) {
            h0Var.a(this, holder);
        }
    }

    public rx.s.b<Void> eventSubject() {
        return super.getEventSubject();
    }

    @Override // com.airbnb.epoxy.t, com.airbnb.epoxy.s
    public void onVisibilityChanged(float f2, float f3, int i2, int i3, TitleModel.Holder holder) {
        i0<TitleModel_, TitleModel.Holder> i0Var = this.onModelVisibilityChangedListener_epoxyGeneratedModel;
        if (i0Var != null) {
            i0Var.a(this, holder, f2, f3, i2, i3);
        }
        super.onVisibilityChanged(f2, f3, i2, i3, holder);
    }

    @Override // com.airbnb.epoxy.t, com.airbnb.epoxy.s
    public void onVisibilityStateChanged(int i2, TitleModel.Holder holder) {
        j0<TitleModel_, TitleModel.Holder> j0Var = this.onModelVisibilityStateChangedListener_epoxyGeneratedModel;
        if (j0Var != null) {
            j0Var.a(this, holder, i2);
        }
        super.onVisibilityStateChanged(i2, holder);
    }

    public boolean shouldShowButton() {
        return super.getShouldShowButton();
    }

    @Override // com.airbnb.epoxy.s
    public TitleModel_ show(boolean z) {
        super.show(z);
        return this;
    }

    public Integer title() {
        return super.getTitle();
    }

    @Override // cm.aptoide.pt.home.apps.list.models.TitleModelBuilder
    public TitleModel_ onVisibilityChanged(i0<TitleModel_, TitleModel.Holder> i0Var) {
        onMutation();
        this.onModelVisibilityChangedListener_epoxyGeneratedModel = i0Var;
        return this;
    }

    @Override // cm.aptoide.pt.home.apps.list.models.TitleModelBuilder
    public TitleModel_ onVisibilityStateChanged(j0<TitleModel_, TitleModel.Holder> j0Var) {
        onMutation();
        this.onModelVisibilityStateChangedListener_epoxyGeneratedModel = j0Var;
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public TitleModel_ id(long j2) {
        super.id(j2);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public TitleModel_ id(Number... numberArr) {
        super.id(numberArr);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public TitleModel_ id(long j2, long j3) {
        super.id(j2, j3);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public TitleModel_ id(CharSequence charSequence) {
        super.id(charSequence);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public TitleModel_ id(CharSequence charSequence, CharSequence... charSequenceArr) {
        super.id(charSequence, charSequenceArr);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public TitleModel_ id(CharSequence charSequence, long j2) {
        super.id(charSequence, j2);
        return this;
    }
}
