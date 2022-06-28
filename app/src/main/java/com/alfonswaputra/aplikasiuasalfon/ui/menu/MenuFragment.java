package com.alfonswaputra.aplikasiuasalfon.ui.menu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alfonswaputra.aplikasiuasalfon.databinding.FragmentMenuBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuFragment extends Fragment {

    private FragmentMenuBinding binding;
    String[] c = new String[] {
            "Tipografi",
            "Info Warga",
            "Sarana Prasarana",
            "Pendidikan",
            "Kesehatan",
            "Keagamaan",
            "Disabilitas",
            "Olahraga",
            "Transportasi dan Komunikasi",
            "Lahan",
            "UMKM",
            "Kriminalitas",
            "Program Pemerintah",
            "Aset dan Bantuan",
            "SDM Desa",
            "Pariwisata",
            "Pasar dan Angkutan Umum",
            "Organisasi Kemasyarakatan",
            "Informasi Umum"
    };
    ArrayList<String> categories = new ArrayList<>(Arrays.asList(c));



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerView.setAdapter(new MenuRecyclerViewAdapter(this.requireActivity(), categories));
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}