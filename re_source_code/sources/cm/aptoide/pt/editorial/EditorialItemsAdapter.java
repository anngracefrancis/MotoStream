package cm.aptoide.pt.editorial;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import java.text.DecimalFormat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class EditorialItemsAdapter extends RecyclerView.g<EditorialItemsViewHolder> {
    private final rx.s.b<EditorialDownloadEvent> downloadEventListener;
    private List<EditorialContent> editorialItemList;
    private final DecimalFormat oneDecimalFormat;
    private boolean shouldHaveAnimation = true;
    private rx.s.b<EditorialEvent> uiEventListener;

    public EditorialItemsAdapter(List<EditorialContent> list, DecimalFormat decimalFormat, rx.s.b<EditorialEvent> bVar, rx.s.b<EditorialDownloadEvent> bVar2) {
        this.editorialItemList = list;
        this.oneDecimalFormat = decimalFormat;
        this.uiEventListener = bVar;
        this.downloadEventListener = bVar2;
    }

    public void add(List<EditorialContent> list, boolean z) {
        this.editorialItemList.addAll(list);
        this.shouldHaveAnimation = z;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.editorialItemList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(EditorialItemsViewHolder editorialItemsViewHolder, int i2) {
        editorialItemsViewHolder.setVisibility(this.editorialItemList.get(i2), i2, Boolean.valueOf(this.shouldHaveAnimation));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public EditorialItemsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new EditorialItemsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.editorial_item_layout, viewGroup, false), this.oneDecimalFormat, this.uiEventListener, this.downloadEventListener);
    }
}
