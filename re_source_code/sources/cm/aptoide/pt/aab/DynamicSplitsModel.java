package cm.aptoide.pt.aab;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DynamicSplitsModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcm/aptoide/pt/aab/DynamicSplitsModel;", HttpUrl.FRAGMENT_ENCODE_SET, "dynamicSplitsList", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/pt/aab/DynamicSplit;", "(Ljava/util/List;)V", "getDynamicSplitsList", "()Ljava/util/List;", "component1", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class DynamicSplitsModel {
    private final List<DynamicSplit> dynamicSplitsList;

    public DynamicSplitsModel(List<DynamicSplit> list) {
        m.f(list, "dynamicSplitsList");
        this.dynamicSplitsList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DynamicSplitsModel copy$default(DynamicSplitsModel dynamicSplitsModel, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = dynamicSplitsModel.dynamicSplitsList;
        }
        return dynamicSplitsModel.copy(list);
    }

    public final List<DynamicSplit> component1() {
        return this.dynamicSplitsList;
    }

    public final DynamicSplitsModel copy(List<DynamicSplit> dynamicSplitsList) {
        m.f(dynamicSplitsList, "dynamicSplitsList");
        return new DynamicSplitsModel(dynamicSplitsList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DynamicSplitsModel) && m.a(this.dynamicSplitsList, ((DynamicSplitsModel) other).dynamicSplitsList);
    }

    public final List<DynamicSplit> getDynamicSplitsList() {
        return this.dynamicSplitsList;
    }

    public int hashCode() {
        return this.dynamicSplitsList.hashCode();
    }

    public String toString() {
        return "DynamicSplitsModel(dynamicSplitsList=" + this.dynamicSplitsList + ')';
    }
}
