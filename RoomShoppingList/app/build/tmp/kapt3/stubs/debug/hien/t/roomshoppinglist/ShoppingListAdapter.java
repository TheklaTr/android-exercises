package hien.t.roomshoppinglist;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0014\u0010\u0014\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006\u00a8\u0006\u0017"}, d2 = {"Lhien/t/roomshoppinglist/ShoppingListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lhien/t/roomshoppinglist/ShoppingListAdapter$ViewHolder;", "shoppingList", "", "Lhien/t/roomshoppinglist/ShoppingListItem;", "(Ljava/util/List;)V", "getShoppingList", "()Ljava/util/List;", "setShoppingList", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "newList", "ViewHolder", "app_debug"})
public final class ShoppingListAdapter extends android.support.v7.widget.RecyclerView.Adapter<hien.t.roomshoppinglist.ShoppingListAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<hien.t.roomshoppinglist.ShoppingListItem> shoppingList;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public hien.t.roomshoppinglist.ShoppingListAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    hien.t.roomshoppinglist.ShoppingListAdapter.ViewHolder holder, int position) {
    }
    
    public final void update(@org.jetbrains.annotations.NotNull()
    java.util.List<hien.t.roomshoppinglist.ShoppingListItem> newList) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<hien.t.roomshoppinglist.ShoppingListItem> getShoppingList() {
        return null;
    }
    
    public final void setShoppingList(@org.jetbrains.annotations.NotNull()
    java.util.List<hien.t.roomshoppinglist.ShoppingListItem> p0) {
    }
    
    public ShoppingListAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<hien.t.roomshoppinglist.ShoppingListItem> shoppingList) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b\u00a8\u0006\r"}, d2 = {"Lhien/t/roomshoppinglist/ShoppingListAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lhien/t/roomshoppinglist/ShoppingListAdapter;Landroid/view/View;)V", "countTextView", "Landroid/widget/TextView;", "getCountTextView", "()Landroid/widget/TextView;", "nameTextView", "getNameTextView", "priceTextView", "getPriceTextView", "app_debug"})
    public final class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView nameTextView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView countTextView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView priceTextView = null;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getNameTextView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getCountTextView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getPriceTextView() {
            return null;
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}