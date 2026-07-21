package cm.aptoide.pt.view;

import cm.aptoide.pt.editorial.EditorialLoadSource;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: EditorialConfiguration.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcm/aptoide/pt/view/EditorialConfiguration;", HttpUrl.FRAGMENT_ENCODE_SET, "loadSource", "Lcm/aptoide/pt/editorial/EditorialLoadSource;", "(Lcm/aptoide/pt/editorial/EditorialLoadSource;)V", "getLoadSource", "()Lcm/aptoide/pt/editorial/EditorialLoadSource;", "setLoadSource", "component1", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class EditorialConfiguration {
    private EditorialLoadSource loadSource;

    public EditorialConfiguration(EditorialLoadSource editorialLoadSource) {
        this.loadSource = editorialLoadSource;
    }

    public static /* synthetic */ EditorialConfiguration copy$default(EditorialConfiguration editorialConfiguration, EditorialLoadSource editorialLoadSource, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            editorialLoadSource = editorialConfiguration.loadSource;
        }
        return editorialConfiguration.copy(editorialLoadSource);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EditorialLoadSource getLoadSource() {
        return this.loadSource;
    }

    public final EditorialConfiguration copy(EditorialLoadSource loadSource) {
        return new EditorialConfiguration(loadSource);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof EditorialConfiguration) && kotlin.jvm.internal.m.a(this.loadSource, ((EditorialConfiguration) other).loadSource);
    }

    public final EditorialLoadSource getLoadSource() {
        return this.loadSource;
    }

    public int hashCode() {
        EditorialLoadSource editorialLoadSource = this.loadSource;
        if (editorialLoadSource == null) {
            return 0;
        }
        return editorialLoadSource.hashCode();
    }

    public final void setLoadSource(EditorialLoadSource editorialLoadSource) {
        this.loadSource = editorialLoadSource;
    }

    public String toString() {
        return "EditorialConfiguration(loadSource=" + this.loadSource + ')';
    }
}
