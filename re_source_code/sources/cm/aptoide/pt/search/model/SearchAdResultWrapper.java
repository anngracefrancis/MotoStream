package cm.aptoide.pt.search.model;

/* JADX INFO: loaded from: classes.dex */
public class SearchAdResultWrapper {
    private int position;
    private SearchAdResult searchAdResult;

    public SearchAdResultWrapper(SearchAdResult searchAdResult, int i2) {
        this.searchAdResult = searchAdResult;
        this.position = i2;
    }

    public int getPosition() {
        return this.position;
    }

    public SearchAdResult getSearchAdResult() {
        return this.searchAdResult;
    }
}
