package com.example.recyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.databinding.AnotharRowItemBinding;
import com.example.recyclerview.databinding.RowItemBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclarAdaptar extends RecyclerView.Adapter {


    private static final String TAG = "RecyclarAdaptar";
    List<String> movieList;

    public RecyclarAdaptar(List<String> movieList) {
        this.movieList = movieList;
    }

    @Override
    public int getItemViewType(int position) {
        if (movieList.get(position).toLowerCase().contains("movie 2")) {
            return 0;
        }
        return 1;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Log.i(TAG, "onCreateViewHolder: ";
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view;
        if (viewType == 0) {
            view = layoutInflater.inflate(R.layout.row_item, parent, false);
            return new ViewHoldar(RowItemBinding.bind(view));
        }
        view = layoutInflater.inflate(R.layout.anothar_row_item, parent, false);
        return new ViewHoldarTwo(AnotharRowItemBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (movieList.get(position).toLowerCase().contains("movie 2")) {
            //bind ViewHoldarTwo
            ViewHoldar viewHoldar = (ViewHoldar) holder;
            ((ViewHoldar) holder).binding.tvMainTitel.setText(movieList.get(position));
            ((ViewHoldar) holder).binding.tvNormalTitle.setText(movieList.get(position));

        } else {
            //bind ViewHoldar
            ViewHoldarTwo viewHoldarTwo = (ViewHoldarTwo) holder;
            ((ViewHoldarTwo) holder).anotharRowItemBinding.tvOne.setText(movieList.get(position));
            ((ViewHoldarTwo) holder).anotharRowItemBinding.tvTwo.setText(movieList.get(position));

        }

//        //holder.binding.tvMainTitel.setText("sadsad");
//        holder.binding.tvMainTitel.setText(movieList.get(position));
//        holder.binding.tvNormalTitle.setText(String.valueOf(position));

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHoldar extends RecyclerView.ViewHolder implements View.OnClickListener {
        RowItemBinding binding;

        public ViewHoldar(@NonNull RowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.getRoot().setOnClickListener(this);

            binding.getRoot().setOnLongClickListener(v -> {
                movieList.remove(getAdapterPosition());
                notifyItemRemoved(getAdapterPosition());
                return true;
            });

        }

        public class a{

            int a ;
            String qq;
            Boolean aq = true;

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(binding.getRoot().getContext(), movieList.get(getAbsoluteAdapterPosition()), Toast.LENGTH_LONG).show();
        }
    }

    public class ViewHoldarTwo extends RecyclerView.ViewHolder implements View.OnClickListener {
        AnotharRowItemBinding anotharRowItemBinding;

        public ViewHoldarTwo(AnotharRowItemBinding anotharRowItemBinding) {
            super(anotharRowItemBinding.getRoot());
            this.anotharRowItemBinding = anotharRowItemBinding;
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(anotharRowItemBinding.getRoot().getContext(), movieList.get(getAbsoluteAdapterPosition()), Toast.LENGTH_LONG).show();
        }
    }

}
