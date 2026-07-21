package com.airbnb.epoxy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: compiled from: EpoxyModel.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class s<T> {
    private static long idCounter = -1;
    boolean addedToAdapter;
    n controllerToStageTo;
    private boolean currentlyInInterceptors;
    private n firstControllerAddedTo;
    private boolean hasDefaultId;
    private int hashCodeWhenAdded;
    private long id;
    private int layout;
    private boolean shown;
    private c spanSizeOverride;

    /* JADX INFO: compiled from: EpoxyModel.java */
    class a implements n.f {
        a() {
        }

        @Override // com.airbnb.epoxy.n.f
        public void a(n nVar) {
            s.this.currentlyInInterceptors = true;
        }

        @Override // com.airbnb.epoxy.n.f
        public void b(n nVar) {
            s sVar = s.this;
            sVar.hashCodeWhenAdded = sVar.hashCode();
            s.this.currentlyInInterceptors = false;
        }
    }

    /* JADX INFO: compiled from: EpoxyModel.java */
    public interface b {
        boolean a();
    }

    /* JADX INFO: compiled from: EpoxyModel.java */
    public interface c {
        int a(int i2, int i3, int i4);
    }

    protected s(long j2) {
        this.shown = true;
        id(j2);
    }

    private static int getPosition(n nVar, s<?> sVar) {
        return nVar.isBuildingModels() ? nVar.getFirstIndexOfModelInBuildingList(sVar) : nVar.getAdapter().E(sVar);
    }

    public void addIf(boolean z, n nVar) {
        if (z) {
            addTo(nVar);
            return;
        }
        n nVar2 = this.controllerToStageTo;
        if (nVar2 != null) {
            nVar2.clearModelFromStaging(this);
            this.controllerToStageTo = null;
        }
    }

    public void addTo(n nVar) {
        nVar.addInternal(this);
    }

    protected final void addWithDebugValidation(n nVar) {
        if (nVar == null) {
            throw new IllegalArgumentException("Controller cannot be null");
        }
        if (nVar.isModelAddedMultipleTimes(this)) {
            throw new IllegalEpoxyUsage("This model was already added to the controller at position " + nVar.getFirstIndexOfModelInBuildingList(this));
        }
        if (this.firstControllerAddedTo == null) {
            this.firstControllerAddedTo = nVar;
            this.hashCodeWhenAdded = hashCode();
            nVar.addAfterInterceptorCallback(new a());
        }
    }

    public void bind(T t) {
    }

    public void bind(T t, List<Object> list) {
        bind(t);
    }

    protected View buildView(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(getLayout(), viewGroup, false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.id == sVar.id && getViewType() == sVar.getViewType() && this.shown == sVar.shown;
    }

    protected abstract int getDefaultLayout();

    public final int getLayout() {
        int i2 = this.layout;
        return i2 == 0 ? getDefaultLayout() : i2;
    }

    public int getSpanSize(int i2, int i3, int i4) {
        return 1;
    }

    protected int getViewType() {
        return getLayout();
    }

    boolean hasDefaultId() {
        return this.hasDefaultId;
    }

    public int hashCode() {
        long j2 = this.id;
        return (((((int) (j2 ^ (j2 >>> 32))) * 31) + getViewType()) * 31) + (this.shown ? 1 : 0);
    }

    public s<T> hide() {
        return show(false);
    }

    public long id() {
        return this.id;
    }

    boolean isDebugValidationEnabled() {
        return this.firstControllerAddedTo != null;
    }

    public boolean isShown() {
        return this.shown;
    }

    public s<T> layout(int i2) {
        onMutation();
        this.layout = i2;
        return this;
    }

    public boolean onFailedToRecycleView(T t) {
        return false;
    }

    protected final void onMutation() {
        if (isDebugValidationEnabled() && !this.currentlyInInterceptors) {
            throw new z(this, getPosition(this.firstControllerAddedTo, this));
        }
        n nVar = this.controllerToStageTo;
        if (nVar != null) {
            nVar.setStagedModel(this);
        }
    }

    public void onViewAttachedToWindow(T t) {
    }

    public void onViewDetachedFromWindow(T t) {
    }

    public void onVisibilityChanged(float f2, float f3, int i2, int i3, T t) {
    }

    public void onVisibilityStateChanged(int i2, T t) {
    }

    public s<T> reset() {
        onMutation();
        this.layout = 0;
        this.shown = true;
        return this;
    }

    public boolean shouldSaveViewState() {
        return false;
    }

    public s<T> show() {
        return show(true);
    }

    public final int spanSize(int i2, int i3, int i4) {
        c cVar = this.spanSizeOverride;
        return cVar != null ? cVar.a(i2, i3, i4) : getSpanSize(i2, i3, i4);
    }

    public s<T> spanSizeOverride(c cVar) {
        this.spanSizeOverride = cVar;
        return this;
    }

    public String toString() {
        return getClass().getSimpleName() + "{id=" + this.id + ", viewType=" + getViewType() + ", shown=" + this.shown + ", addedToAdapter=" + this.addedToAdapter + '}';
    }

    public void unbind(T t) {
    }

    protected final void validateStateHasNotChangedSinceAdded(String str, int i2) {
        if (isDebugValidationEnabled() && !this.currentlyInInterceptors && this.hashCodeWhenAdded != hashCode()) {
            throw new z(this, str, i2);
        }
    }

    public void bind(T t, s<?> sVar) {
        bind(t);
    }

    public s<T> id(long j2) {
        if ((this.addedToAdapter || this.firstControllerAddedTo != null) && j2 != this.id) {
            throw new IllegalEpoxyUsage("Cannot change a model's id after it has been added to the adapter.");
        }
        this.hasDefaultId = false;
        this.id = j2;
        return this;
    }

    public s<T> show(boolean z) {
        onMutation();
        this.shown = z;
        return this;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public s() {
        long j2 = idCounter;
        idCounter = j2 - 1;
        this(j2);
        this.hasDefaultId = true;
    }

    public void addIf(b bVar, n nVar) {
        addIf(bVar.a(), nVar);
    }

    public s<T> id(Number... numberArr) {
        long j2 = 0;
        if (numberArr != null) {
            int length = numberArr.length;
            long jA = 0;
            for (int i2 = 0; i2 < length; i2++) {
                Number number = numberArr[i2];
                jA = (jA * 31) + y.a(number == null ? 0L : number.hashCode());
            }
            j2 = jA;
        }
        return id(j2);
    }

    public s<T> id(long j2, long j3) {
        return id((y.a(j2) * 31) + y.a(j3));
    }

    public s<T> id(CharSequence charSequence) {
        id(y.b(charSequence));
        return this;
    }

    public s<T> id(CharSequence charSequence, CharSequence... charSequenceArr) {
        long jB = y.b(charSequence);
        if (charSequenceArr != null) {
            for (CharSequence charSequence2 : charSequenceArr) {
                jB = (jB * 31) + y.b(charSequence2);
            }
        }
        return id(jB);
    }

    public s<T> id(CharSequence charSequence, long j2) {
        id((y.b(charSequence) * 31) + y.a(j2));
        return this;
    }
}
