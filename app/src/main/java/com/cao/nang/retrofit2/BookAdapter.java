package com.cao.nang.retrofit2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BookAdapter extends  RecyclerView.Adapter<BookAdapter.BookViewHolder>{

    public Context context;
    public List<Post> bookList;

    public BookAdapter(Context context, List<Post> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_sach,viewGroup,false);

        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int i) {
        final int position = i;
        final Post book = bookList.get(i);
        holder.txtMasach.setText("id :"+book.getId());
        holder.txtTenSach.setText("tên sách:"+book.getName());
        holder.txtSoLuongSach.setText("the loai :"+book.getCategory());
        holder.txtGiaban.setText("url :"+book.getDescription());
        Picasso.get().load(book.getUrl()).into(holder.imgView);

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        TextView txtTenSach,txtSoLuongSach,txtGiaban,txtMasach;
        ImageView imgView ;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMasach=itemView.findViewById(R.id.txtMasach);
            txtTenSach = itemView.findViewById(R.id.txtTenSach);
            txtSoLuongSach = itemView.findViewById(R.id.txtSoLuongSach);
            imgView=itemView.findViewById(R.id.imgView);
            txtGiaban=itemView.findViewById(R.id.txtGiaban);


        }
    }
}
