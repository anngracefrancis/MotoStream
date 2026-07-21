package cm.aptoide.aptoideviews.filters;

import com.airbnb.epoxy.f0;
import com.airbnb.epoxy.h0;
import com.airbnb.epoxy.i0;
import com.airbnb.epoxy.j0;
import com.airbnb.epoxy.n;
import com.airbnb.epoxy.s;
import com.airbnb.epoxy.u;
import com.airbnb.epoxy.v;

/* JADX INFO: loaded from: classes.dex */
public class ClearFiltersModel_ extends ClearFiltersModel implements v<ClearFiltersModel.CardHolder>, ClearFiltersModelBuilder {
    private f0<ClearFiltersModel_, ClearFiltersModel.CardHolder> onModelBoundListener_epoxyGeneratedModel;
    private h0<ClearFiltersModel_, ClearFiltersModel.CardHolder> onModelUnboundListener_epoxyGeneratedModel;
    private i0<ClearFiltersModel_, ClearFiltersModel.CardHolder> onModelVisibilityChangedListener_epoxyGeneratedModel;
    private j0<ClearFiltersModel_, ClearFiltersModel.CardHolder> onModelVisibilityStateChangedListener_epoxyGeneratedModel;

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
        if (!(obj instanceof ClearFiltersModel_) || !super.equals(obj)) {
            return false;
        }
        ClearFiltersModel_ clearFiltersModel_ = (ClearFiltersModel_) obj;
        if ((this.onModelBoundListener_epoxyGeneratedModel == null) != (clearFiltersModel_.onModelBoundListener_epoxyGeneratedModel == null)) {
            return false;
        }
        if ((this.onModelUnboundListener_epoxyGeneratedModel == null) != (clearFiltersModel_.onModelUnboundListener_epoxyGeneratedModel == null)) {
            return false;
        }
        if ((this.onModelVisibilityStateChangedListener_epoxyGeneratedModel == null) != (clearFiltersModel_.onModelVisibilityStateChangedListener_epoxyGeneratedModel == null)) {
            return false;
        }
        if ((this.onModelVisibilityChangedListener_epoxyGeneratedModel == null) != (clearFiltersModel_.onModelVisibilityChangedListener_epoxyGeneratedModel == null)) {
            return false;
        }
        if ((getEventListener() == null) != (clearFiltersModel_.getEventListener() == null)) {
            return false;
        }
        return (getTextColorStateList() == null) == (clearFiltersModel_.getTextColorStateList() == null);
    }

    @Override // com.airbnb.epoxy.s
    public int hashCode() {
        return (((((((((((super.hashCode() * 31) + (this.onModelBoundListener_epoxyGeneratedModel != null ? 1 : 0)) * 31) + (this.onModelUnboundListener_epoxyGeneratedModel != null ? 1 : 0)) * 31) + (this.onModelVisibilityStateChangedListener_epoxyGeneratedModel != null ? 1 : 0)) * 31) + (this.onModelVisibilityChangedListener_epoxyGeneratedModel != null ? 1 : 0)) * 31) + (getEventListener() != null ? 1 : 0)) * 31) + (getTextColorStateList() == null ? 0 : 1);
    }

    @Override // cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public /* bridge */ /* synthetic */ ClearFiltersModelBuilder onBind(f0 f0Var) {
        return onBind((f0<ClearFiltersModel_, ClearFiltersModel.CardHolder>) f0Var);
    }

    @Override // cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public /* bridge */ /* synthetic */ ClearFiltersModelBuilder onUnbind(h0 h0Var) {
        return onUnbind((h0<ClearFiltersModel_, ClearFiltersModel.CardHolder>) h0Var);
    }

    @Override // cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public /* bridge */ /* synthetic */ ClearFiltersModelBuilder onVisibilityChanged(i0 i0Var) {
        return onVisibilityChanged((i0<ClearFiltersModel_, ClearFiltersModel.CardHolder>) i0Var);
    }

    @Override // cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public /* bridge */ /* synthetic */ ClearFiltersModelBuilder onVisibilityStateChanged(j0 j0Var) {
        return onVisibilityStateChanged((j0<ClearFiltersModel_, ClearFiltersModel.CardHolder>) j0Var);
    }

    @Override // com.airbnb.epoxy.s
    public String toString() {
        return "ClearFiltersModel_{eventListener=" + getEventListener() + ", textColorStateList=" + getTextColorStateList() + "}" + super.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.epoxy.t
    public ClearFiltersModel.CardHolder createNewHolder() {
        return new ClearFiltersModel.CardHolder();
    }

    @Override // cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public ClearFiltersModel_ eventListener(FilterEventListener filterEventListener) {
        onMutation();
        super.setEventListener(filterEventListener);
        return this;
    }

    @Override // com.airbnb.epoxy.v
    public void handlePostBind(ClearFiltersModel.CardHolder cardHolder, int i2) {
        f0<ClearFiltersModel_, ClearFiltersModel.CardHolder> f0Var = this.onModelBoundListener_epoxyGeneratedModel;
        if (f0Var != null) {
            f0Var.a(this, cardHolder, i2);
        }
        validateStateHasNotChangedSinceAdded("The model was changed during the bind call.", i2);
    }

    @Override // com.airbnb.epoxy.v
    public void handlePreBind(u uVar, ClearFiltersModel.CardHolder cardHolder, int i2) {
        validateStateHasNotChangedSinceAdded("The model was changed between being added to the controller and being bound.", i2);
    }

    @Override // com.airbnb.epoxy.s
    public ClearFiltersModel_ hide() {
        super.hide();
        return this;
    }

    @Override // cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public ClearFiltersModel_ onBind(f0<ClearFiltersModel_, ClearFiltersModel.CardHolder> f0Var) {
        onMutation();
        this.onModelBoundListener_epoxyGeneratedModel = f0Var;
        return this;
    }

    @Override // cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public ClearFiltersModel_ onUnbind(h0<ClearFiltersModel_, ClearFiltersModel.CardHolder> h0Var) {
        onMutation();
        this.onModelUnboundListener_epoxyGeneratedModel = h0Var;
        return this;
    }

    @Override // com.airbnb.epoxy.s
    public ClearFiltersModel_ reset() {
        this.onModelBoundListener_epoxyGeneratedModel = null;
        this.onModelUnboundListener_epoxyGeneratedModel = null;
        this.onModelVisibilityStateChangedListener_epoxyGeneratedModel = null;
        this.onModelVisibilityChangedListener_epoxyGeneratedModel = null;
        super.setEventListener(null);
        super.setTextColorStateList(null);
        super.reset();
        return this;
    }

    @Override // cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public ClearFiltersModel_ textColorStateList(Integer num) {
        onMutation();
        super.setTextColorStateList(num);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public ClearFiltersModel_ layout(int i2) {
        super.layout(i2);
        return this;
    }

    @Override // com.airbnb.epoxy.s
    public ClearFiltersModel_ show() {
        super.show();
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public ClearFiltersModel_ spanSizeOverride(s.c cVar) {
        super.spanSizeOverride(cVar);
        return this;
    }

    @Override // com.airbnb.epoxy.t, com.airbnb.epoxy.s
    public void unbind(ClearFiltersModel.CardHolder cardHolder) {
        super.unbind(cardHolder);
        h0<ClearFiltersModel_, ClearFiltersModel.CardHolder> h0Var = this.onModelUnboundListener_epoxyGeneratedModel;
        if (h0Var != null) {
            h0Var.a(this, cardHolder);
        }
    }

    public FilterEventListener eventListener() {
        return super.getEventListener();
    }

    @Override // com.airbnb.epoxy.t, com.airbnb.epoxy.s
    public void onVisibilityChanged(float f2, float f3, int i2, int i3, ClearFiltersModel.CardHolder cardHolder) {
        i0<ClearFiltersModel_, ClearFiltersModel.CardHolder> i0Var = this.onModelVisibilityChangedListener_epoxyGeneratedModel;
        if (i0Var != null) {
            i0Var.a(this, cardHolder, f2, f3, i2, i3);
        }
        super.onVisibilityChanged(f2, f3, i2, i3, cardHolder);
    }

    @Override // com.airbnb.epoxy.t, com.airbnb.epoxy.s
    public void onVisibilityStateChanged(int i2, ClearFiltersModel.CardHolder cardHolder) {
        j0<ClearFiltersModel_, ClearFiltersModel.CardHolder> j0Var = this.onModelVisibilityStateChangedListener_epoxyGeneratedModel;
        if (j0Var != null) {
            j0Var.a(this, cardHolder, i2);
        }
        super.onVisibilityStateChanged(i2, cardHolder);
    }

    @Override // com.airbnb.epoxy.s
    public ClearFiltersModel_ show(boolean z) {
        super.show(z);
        return this;
    }

    public Integer textColorStateList() {
        return super.getTextColorStateList();
    }

    @Override // cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public ClearFiltersModel_ onVisibilityChanged(i0<ClearFiltersModel_, ClearFiltersModel.CardHolder> i0Var) {
        onMutation();
        this.onModelVisibilityChangedListener_epoxyGeneratedModel = i0Var;
        return this;
    }

    @Override // cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public ClearFiltersModel_ onVisibilityStateChanged(j0<ClearFiltersModel_, ClearFiltersModel.CardHolder> j0Var) {
        onMutation();
        this.onModelVisibilityStateChangedListener_epoxyGeneratedModel = j0Var;
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public ClearFiltersModel_ id(long j2) {
        super.id(j2);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public ClearFiltersModel_ id(Number... numberArr) {
        super.id(numberArr);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public ClearFiltersModel_ id(long j2, long j3) {
        super.id(j2, j3);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public ClearFiltersModel_ id(CharSequence charSequence) {
        super.id(charSequence);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public ClearFiltersModel_ id(CharSequence charSequence, CharSequence... charSequenceArr) {
        super.id(charSequence, charSequenceArr);
        return this;
    }

    @Override // com.airbnb.epoxy.s, cm.aptoide.aptoideviews.filters.ClearFiltersModelBuilder
    public ClearFiltersModel_ id(CharSequence charSequence, long j2) {
        super.id(charSequence, j2);
        return this;
    }
}
